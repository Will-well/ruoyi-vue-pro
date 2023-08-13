package cn.iocoder.yudao.module.system.controller.admin.major.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 专业 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MajorExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("大学id")
    private String universityId;

    @ExcelProperty("大学名称")
    private String universityName;

    @ExcelProperty("一级分类")
    private String topCategory;

    @ExcelProperty("二级分类")
    private String category;

    @ExcelProperty("专业名称")
    private String majorName;

    @ExcelProperty("专业介绍")
    private String majorIntro;

    @ExcelProperty("就业方向")
    private String employmentOrientation;

    @ExcelProperty("特殊要求")
    private String specialRequirements;

    @ExcelProperty("排序")
    private Integer sort;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
