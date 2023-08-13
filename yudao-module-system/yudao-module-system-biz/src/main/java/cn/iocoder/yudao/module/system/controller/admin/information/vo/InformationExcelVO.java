package cn.iocoder.yudao.module.system.controller.admin.information.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 资讯 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class InformationExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("资讯图片")
    private String pic;

    @ExcelProperty("资讯标题")
    private String title;

    @ExcelProperty("资讯内容")
    private String content;

    @ExcelProperty("排序")
    private Integer sort;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
