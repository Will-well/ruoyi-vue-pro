package cn.iocoder.yudao.module.system.controller.admin.wxuser.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * wx用户 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class WxUserExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("open_id")
    private String wxId;

    @ExcelProperty("登录token")
    private String loginToken;

    @ExcelProperty("真实姓名")
    private String realName;

    @ExcelProperty("性别")
    private Byte sex;

    @ExcelProperty("年龄")
    private Byte age;

    @ExcelProperty("用户昵称")
    private String nickname;

    @ExcelProperty("脱敏手机号")
    private String phone;

    @ExcelProperty("加密手机号")
    private String encryptPhone;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
