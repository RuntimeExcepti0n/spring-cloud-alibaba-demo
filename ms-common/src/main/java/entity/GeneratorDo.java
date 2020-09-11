package entity;

import lombok.Data;

/**
 * @ClassName: GeneratorDo
 * @Description: 自动生成工具可选参数类
 * @author: zhoulong1
 * @date: 2020/5/18
 * @Copyright: 2020 www.baoneng.com Inc. All rights reserved. 注意：本内容仅限于宝能汽车公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Data
public class GeneratorDo {
    /**
     * 模块地址
     */
    private String modulePath;
    /**
     * 数据库名称
     */
    private String databaseName;
    /**
     * 数据库IP
     */
    private String databaseIp;
    /**
     * 数据库端口
     */
    private String databasePort;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 父包名
     */
    private String parentPackge;
    /**
     * 表名前缀，默认tb_
     */
    private String tablePrefix;
    /**
     * 用户名默认root
     */
    private String userName;
    /**
     * 密码默认Bnqc@2020
     */
    private String passWord;
    /**
     * mapper包名，默认mapper
     */
    private String mapperPackageName;
    /**
     * entity包名，默认entity
     */
    private String entityPackageName;
    /**
     * service包名，默认servcie
     */
    private String servicePackageName;
    /**
     * 实现类名，默认service下impl
     */
    private String implPackageName;

}
