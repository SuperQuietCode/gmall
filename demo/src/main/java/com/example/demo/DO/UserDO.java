package com.example.demo.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author ZhaoXin
 * @date 2020/9/25 14:32
 */
@Data
@TableName("user_info")
public class UserDO implements Serializable {

    private static final long serialVersionUID = -9073609127274759264L;

    @Id
    private String id;

    @TableField("user_name")
    private String userName;

    @TableField("pass_word")
    private String passWord;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
