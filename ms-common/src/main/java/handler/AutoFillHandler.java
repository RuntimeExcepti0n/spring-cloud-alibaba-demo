package handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @ClassName: AutoFillHandler
 * @Description: 自动填充处理器
 * @date: 2020/5/18
 */
public class AutoFillHandler implements MetaObjectHandler
{

    private Logger logger = LoggerFactory.getLogger(AutoFillHandler.class);

    /**
     * 新增时自动填充
     *
     * @param metaObject m
     */
    @Override
    public void insertFill(MetaObject metaObject)
    {
        // 填充的字段
        Object date = getFieldValByName("createTime", metaObject);
        Object operator = getFieldValByName("createBy", metaObject);
        Object delFlag = getFieldValByName("delFlag", metaObject);
        // 操作时间自动填充默认值
        if (date == null)
        {
            this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        }
        // 操作人自动填充默认值
        if (operator == null)
        {
            throw new BussinessException("操作人不能为空");
        }
        // 逻辑删除自动填充默认值
        if (delFlag == null)
        {
            this.strictInsertFill(metaObject, "delFlag", Integer.class, 0);
        }
    }

    /**
     * 更新时自动填充
     *
     * @param metaObject m
     */
    @Override
    public void updateFill(MetaObject metaObject)
    {
        logger.info("start update autoFill ....");
        // 填充的字段
        Object updateDate = getFieldValByName("updateTime", metaObject);
        Object operator = getFieldValByName("updateBy", metaObject);

        // 操作时间自动填充默认值
        if (updateDate == null)
        {
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        }
        // 操作人自动填充默认值
        if (operator == null)
        {
            throw new BussinessException("操作人不能为空");
        }
    }
}