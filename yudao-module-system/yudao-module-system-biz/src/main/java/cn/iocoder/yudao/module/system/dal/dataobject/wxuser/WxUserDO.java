package cn.iocoder.yudao.module.system.dal.dataobject.wxuser;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * wx用户 DO
 *
 * @author 芋道源码
 */
@TableName("system_wx_user")
@KeySequence("system_wx_user_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxUserDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * open_id
     */
    private String wxId;
    /**
     * 登录token
     */
    private String loginToken;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别
     */
    private Byte sex;
    /**
     * 年龄
     */
    private Byte age;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 脱敏手机号
     */
    private String phone;
    /**
     * 加密手机号
     */
    private String encryptPhone;

}
