package cn.iocoder.yudao.module.system.controller.admin.wxuser.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - wx用户分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WxUserPageReqVO extends PageParam {

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
