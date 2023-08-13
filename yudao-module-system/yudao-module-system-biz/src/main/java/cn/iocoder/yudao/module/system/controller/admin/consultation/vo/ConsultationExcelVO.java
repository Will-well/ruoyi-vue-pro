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

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 用户咨询 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ConsultationExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("孩子姓名")
    private String childName;

    @ExcelProperty("专业名称")
    private String major;

    @ExcelProperty("省市")
    private String provinceCity;

    @ExcelProperty("年级")
    private String grade;

    @ExcelProperty("分数或预估")
    private BigDecimal estimatedScore;

    @ExcelProperty("英语分数")
    private BigDecimal englishScore;

    @ExcelProperty("数学分数")
    private BigDecimal mathScore;

    @ExcelProperty("意向专业")
    private String intendedMajor;

    @ExcelProperty("意向地区")
    private String intendedArea;

    @ExcelProperty("意向学校")
    private String intendedUniversity;

    @ExcelProperty("意向国家")
    private String intendedCountry;

    @ExcelProperty("预算")
    private BigDecimal budget;

    @ExcelProperty("联系方式")
    private String contactPhone;

    @ExcelProperty("用户姓名")
    private String userName;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
