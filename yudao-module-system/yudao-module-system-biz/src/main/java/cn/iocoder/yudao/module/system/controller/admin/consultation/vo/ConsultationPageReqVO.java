package cn.iocoder.yudao.module.system.controller.admin.consultation.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户咨询分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConsultationPageReqVO extends PageParam {

    @Schema(description = "孩子姓名", example = "王五")
    private String childName;

    @Schema(description = "专业名称")
    private String major;

    @Schema(description = "省市")
    private String provinceCity;

    @Schema(description = "年级")
    private String grade;

    @Schema(description = "分数或预估")
    private BigDecimal estimatedScore;

    @Schema(description = "英语分数")
    private BigDecimal englishScore;

    @Schema(description = "数学分数")
    private BigDecimal mathScore;

    @Schema(description = "意向专业")
    private String intendedMajor;

    @Schema(description = "意向地区")
    private String intendedArea;

    @Schema(description = "意向学校")
    private String intendedUniversity;

    @Schema(description = "意向国家")
    private String intendedCountry;

    @Schema(description = "预算")
    private BigDecimal budget;

    @Schema(description = "联系方式")
    private String contactPhone;

    @Schema(description = "用户姓名", example = "王五")
    private String userName;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
