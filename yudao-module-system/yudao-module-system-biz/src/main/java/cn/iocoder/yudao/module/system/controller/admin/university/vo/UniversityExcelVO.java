package cn.iocoder.yudao.module.system.controller.admin.university.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 学校 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class UniversityExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("大学编码")
    private String code;

    @ExcelProperty("大学名称")
    private String name;

    @ExcelProperty("大学英文名称")
    private String enName;

    @ExcelProperty("学校logo")
    private String logo;

    @ExcelProperty("主页图片")
    private String homePic;

    @ExcelProperty("简介")
    private String intro;

    @ExcelProperty("申请要求")
    private String applyRequirements;

    @ExcelProperty("所属国家")
    private String country;

    @ExcelProperty("学费")
    private BigDecimal tuitionFee;

    @ExcelProperty("招生方式")
    private String enrollmentMethod;

    @ExcelProperty("就业")
    private String employment;

    @ExcelProperty("申硕情况")
    private String shengShuo;

    @ExcelProperty("排名")
    private Integer qs;

    @ExcelProperty("排序")
    private Integer sort;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
