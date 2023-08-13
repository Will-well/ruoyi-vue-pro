package cn.iocoder.yudao.module.system.controller.admin.major.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 专业 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MajorBaseVO {

    @Schema(description = "大学id", example = "28031")
    private String universityId;

    @Schema(description = "大学名称", example = "赵六")
    private String universityName;

    @Schema(description = "一级分类")
    private String topCategory;

    @Schema(description = "二级分类")
    private String category;

    @Schema(description = "专业名称", example = "赵六")
    private String majorName;

    @Schema(description = "专业介绍")
    private String majorIntro;

    @Schema(description = "就业方向")
    private String employmentOrientation;

    @Schema(description = "特殊要求")
    private String specialRequirements;

    @Schema(description = "排序")
    private Integer sort;

}
