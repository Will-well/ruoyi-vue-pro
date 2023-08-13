package cn.iocoder.yudao.module.system.controller.admin.university.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 学校更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UniversityUpdateReqVO extends UniversityBaseVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "26465")
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
