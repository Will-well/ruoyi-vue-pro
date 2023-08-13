package cn.iocoder.yudao.module.system.controller.admin.wxuser.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * wx用户 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class WxUserBaseVO {

    @Schema(description = "open_id", example = "15964")
    private String wxId;

    @Schema(description = "登录token")
    private String loginToken;

    @Schema(description = "真实姓名", example = "李四")
    private String realName;

    @Schema(description = "性别")
    private Byte sex;

    @Schema(description = "年龄")
    private Byte age;

    @Schema(description = "用户昵称", example = "李四")
    private String nickname;

    @Schema(description = "脱敏手机号")
    private String phone;

    @Schema(description = "加密手机号")
    private String encryptPhone;

}
