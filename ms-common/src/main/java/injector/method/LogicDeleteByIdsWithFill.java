package injector.method;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @ClassName: LogicDeleteByIdsWithFill
 * @Description: 逻辑批量删除并自动填充
 * @date:
 */
public class LogicDeleteByIdsWithFill extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql;
        SqlMethod sqlMethod;
        if (tableInfo.isLogicDelete()) {
            sqlMethod = SqlMethod.LOGIC_DELETE_BATCH_BY_IDS;
            List<TableFieldInfo> fieldInfos = tableInfo.getFieldList().stream()
                    .filter(TableFieldInfo::isWithUpdateFill)
                    .collect(toList());
            if (CollectionUtils.isNotEmpty(fieldInfos)) {
                String sqlSet = "SET " + fieldInfos.stream()
                        .filter(fieldInfo->!fieldInfo.getColumn().equals("del_flag"))
                        .map(i -> i.getSqlSet(ENTITY_DOT)).collect(joining(EMPTY))
                        + tableInfo.getLogicDeleteSql(false, false);
                sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), sqlSet,
                        tableInfo.getKeyColumn(),
                        SqlScriptUtils.convertForeach("#{item}", COLLECTION, null, "item", COMMA),
                        tableInfo.getLogicDeleteSql(true, true));
            } else {
                sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), sqlLogicSet(tableInfo),
                        tableInfo.getKeyColumn(),
                        SqlScriptUtils.convertForeach("#{item}", COLLECTION, null, "item", COMMA),
                        tableInfo.getLogicDeleteSql(true, true));
            }
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
            return this.addUpdateMappedStatement(mapperClass, modelClass, getMethod(sqlMethod), sqlSource);
        } else {
            sqlMethod = SqlMethod.DELETE_BATCH_BY_IDS;
            sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), tableInfo.getKeyColumn(),
                    SqlScriptUtils.convertForeach("#{item}", COLLECTION, null, "item", COMMA));
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, Object.class);
            return this.addDeleteMappedStatement(mapperClass, getMethod(sqlMethod), sqlSource);
        }

    }

    @Override
    public String getMethod(SqlMethod sqlMethod) {
        // 自定义 mapper 方法名
        return "deleteByIdsWithFill";
    }
}
