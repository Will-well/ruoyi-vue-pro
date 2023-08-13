package cn.iocoder.yudao.module.system.controller.admin.consultation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 用户咨询 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class ConsultationBaseVO {

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

}
