package cn.iocoder.yudao.module.system.controller.admin.university.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 学校 Excel 导出 Request VO，参数和 UniversityPageReqVO 是一致的")
@Data
public class UniversityExportReqVO {

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
