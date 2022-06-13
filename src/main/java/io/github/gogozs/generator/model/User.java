/*
 * create by mybatis-plus-generator
 */
package io.github.gogozs.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author zs
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "`id`", type = IdType.AUTO)
    private Long id;

    @TableField("`telephone`")
    private String telephone;

    @TableField("`email`")
    private String email;

    @TableField("`password`")
    private String password;

    @TableField("`username`")
    private String username;


    public static final String ID = "id";

    public static final String TELEPHONE = "telephone";

    public static final String EMAIL = "email";

    public static final String PASSWORD = "password";

    public static final String USERNAME = "username";

}
