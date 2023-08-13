package cn.iocoder.yudao.module.system.controller.admin.major.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 专业 Excel 导出 Request VO，参数和 MajorPageReqVO 是一致的")
@Data
public class MajorExportReqVO {

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
