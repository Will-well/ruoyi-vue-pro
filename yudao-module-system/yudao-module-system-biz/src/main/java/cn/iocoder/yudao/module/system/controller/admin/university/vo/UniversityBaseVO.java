package cn.iocoder.yudao.module.system.controller.admin.university.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 学校 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class UniversityBaseVO {

    @Schema(description = "大学编码")
    private String code;

    @Schema(description = "大学名称", example = "赵六")
    private String name;

    @Schema(description = "大学英文名称", example = "赵六")
    private String enName;

    @Schema(description = "学校logo")
    private String logo;

    @Schema(description = "主页图片")
    private String homePic;

    @Schema(description = "简介")
    private String intro;

    @Schema(description = "申请要求")
    private String applyRequirements;

    @Schema(description = "所属国家")
    private String country;

    @Schema(description = "学费")
    private BigDecimal tuitionFee;

    @Schema(description = "招生方式")
    private String enrollmentMethod;

    @Schema(description = "就业")
    private String employment;

    @Schema(description = "申硕情况")
    private String shengShuo;

    @Schema(description = "排名")
    private Integer qs;

    @Schema(description = "排序")
    private Integer sort;

}
