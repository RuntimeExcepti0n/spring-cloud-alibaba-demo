package mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName: DemoBaseMapper
 * @Description: 添加自定义mapper方法
 * @date: 2020/7/10
 */
public interface DemoBaseMapper<T> extends BaseMapper<T> {
    /**
     * 批量插入数据
     *
     * 如果要自动填充，需要在mapper方法的参数上定义@{@code Param}(xx) xx参数名必须是 list/collection/array 3个的其中之一，不然无法自动填充
     *
     * @param batchList
     * @return
     */
    @SqlParser(filter = true)
    int saveAllInBatch(@Param("list") List<T> batchList);

    /**
     * 逻辑删除并填充字段
     * @param entity
     * @return
     */
    @SqlParser(filter = true)
    int deleteByIdWithFill(T entity);

    /**
     * 逻辑批量删除补兵填充字段
     * @param entity
     * @param idList
     * @return
     */
    @SqlParser(filter = true)
    int deleteByIdsWithFill(@Param(Constants.ENTITY) T entity, @Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
}
