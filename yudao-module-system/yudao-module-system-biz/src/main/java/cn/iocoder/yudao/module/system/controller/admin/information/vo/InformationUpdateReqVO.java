package cn.iocoder.yudao.module.system.controller.admin.information.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 资讯更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InformationUpdateReqVO extends InformationBaseVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19904")
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
