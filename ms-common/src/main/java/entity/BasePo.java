package entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName: BasePo
 * @Description: 基本Po类
 * @date: 2020/5/18
 */
@Data
public class BasePo {

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;

    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    private String updateBy;

    @TableLogic(value = "0",delval = "1")
    @TableField(value = "del_flag",fill = FieldFill.INSERT_UPDATE)
    private Integer delFlag;
}
