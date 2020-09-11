package entity;

import lombok.Data;

/**
 * @ClassName: GeneratorDo
 * @Description: 自动生成工具可选参数类
 * @date: 2020/5/18
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
