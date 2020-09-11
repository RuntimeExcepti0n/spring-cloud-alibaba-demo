package com.dragon.model.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName: SystemConfigPo
 * @Description:  实体类
 * @since 2020-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_system_config")
public class SystemConfigPo extends BasePo{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 业务维度，PO不同或数据表名不同
     */
    private String businessDimension;

    /**
     * 配置名称
     */
    private String configName;

    /**
     * 配置值
     */
    private Integer configValue;

    /**
     * 配置值描述
     */
    private String configValueDesc;

    /**
     * 配置描述
     */
    private String configDesc;

    /**
     * 项目代码
     */
    private String projectId;

    /**
     * 版本号
     */
    private Integer version;

}
