package com.dragon;

import entity.GeneratorDo;
import utils.CodeUtil;

/**
 * @ClassName: UtilGenerator
 * @Description: 代码生成工具类
 * @since: 2020/7/14
 */
public class UtilGenerator {

    public static void main(String[] args) {
        GeneratorDo generatorDo = new GeneratorDo();
        // 指定数据库名称
        generatorDo.setDatabaseName("db_tsp_maintenance");
        // 指定模块名称，若只有一级模块sync-video,可以直接填写sync-video
        generatorDo.setModulePath("/ms-alibaba-consumer");
        // 指定数据库表名 表字段最好有注释，这样可以生成对应实体字段注释
        generatorDo.setTableName("tb_system_config");
        //这里设置父包名称，所以该类建在和XXXApplication平级，无需提交git
        generatorDo.setParentPackge(new UtilGenerator().getClass().getPackageName());
        generatorDo.setEntityPackageName("model.entity");
        CodeUtil.autoGenerator(generatorDo);
    }
}
