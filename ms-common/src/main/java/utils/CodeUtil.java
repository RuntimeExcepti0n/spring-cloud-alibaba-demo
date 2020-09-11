package utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import entity.BasePo;
import entity.GeneratorDo;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @ClassName: CodeUtil
 * @Description: 代码自动生成工具
 * @author: zhoulong1
 * @date: 2020/5/18
 * @Copyright: 2020 www.baoneng.com Inc. All rights reserved. 注意：本内容仅限于宝能汽车公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class CodeUtil {

    public  static void autoGenerator(GeneratorDo generatorDo)
    {

        Objects.requireNonNull(generatorDo.getDatabaseName(),"数据库名不能为空");
        Objects.requireNonNull(generatorDo.getModulePath(),"模块名不能为空");
        Objects.requireNonNull(generatorDo.getTableName(),"表名不能为空");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取当前项目目录
        String projectPath = System.getProperty("user.dir");
        String modulePath = generatorDo.getModulePath();
        gc.setOutputDir(projectPath +"/"+ modulePath+"/src/main/java");
        gc.setAuthor(System.getProperty("user.name"));
        gc.setFileOverride(true);

        // 设置生成的service接口的名字的首字母是否为I
        gc.setServiceName("I%sService");
        gc.setEntityName("%sPo");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        String ip = StringUtils.isBlank(generatorDo.getDatabaseIp()) ? "10.210.100.17" : generatorDo.getDatabaseIp();
        String port = StringUtils.isBlank(generatorDo.getDatabasePort()) ? "3306" : generatorDo.getDatabasePort();
        String userName = StringUtils.isBlank(generatorDo.getUserName()) ? "root" : generatorDo.getUserName();
        String passWord = StringUtils.isBlank(generatorDo.getPassWord()) ? "Bnqc@2020" : generatorDo.getPassWord();
        dsc.setUrl("jdbc:mysql://"+ip+":"+port+"/"+generatorDo.getDatabaseName()+"?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(userName);
        dsc.setPassword(passWord);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        String mapperPackageName = StringUtils.isBlank(generatorDo.getMapperPackageName()) ? "mapper" : generatorDo.getMapperPackageName();
        String servicePackageName = StringUtils.isBlank(generatorDo.getServicePackageName()) ? "service" : generatorDo.getServicePackageName();
        String entity = StringUtils.isBlank(generatorDo.getEntityPackageName()) ? "model/entity" : generatorDo.getEntityPackageName();
        pc.setParent(generatorDo.getParentPackge())
                .setMapper(mapperPackageName)
                .setService(servicePackageName)
                .setController("controller")
                .setEntity(entity)
                .setXml("mapper");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setEntitySerialVersionUID(true);
        strategy.setEntityLombokModel(true);
        strategy.setSuperEntityClass(BasePo.class);
        //如何去掉父类属性，下面有说明。
        strategy.setSuperEntityColumns("createTime","createBy","updateTime","updateBy","delFlag");
        //配置表名
        strategy.setInclude(generatorDo.getTableName());
        strategy.setControllerMappingHyphenStyle(true);
        String tablePrefix = StringUtils.isBlank(generatorDo.getTablePrefix()) ? "tb_" : generatorDo.getTablePrefix();
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                //自定义配置，在模版中cfg.superColums 获取
                map.put("superColums", Arrays.asList(this.getConfig().getStrategyConfig().getSuperEntityColumns()));
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.btl")
        {
            @Override
            public String outputFile(TableInfo tableInfo)
            {
                // 自定义输入文件名称
                return projectPath + modulePath+"/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        TemplateConfig templateConfig = new TemplateConfig();
        //自定义模版
        templateConfig.setEntity("/templates/entity.java");
        templateConfig.setMapper("/templates/mapper.java");
        templateConfig.setController("/templates/controller.java");
        templateConfig.setService("/templates/service.java");
        templateConfig.setServiceImpl("/templates/serviceImpl.java");
        //关闭默认的mapper xml生成
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new BeetlTemplateEngine());
        mpg.execute();
    }

}
