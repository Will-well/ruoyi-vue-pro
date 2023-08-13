package cn.iocoder.yudao.module.system.controller.admin.information.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 资讯 Excel 导出 Request VO，参数和 InformationPageReqVO 是一致的")
@Data
public class InformationExportReqVO {

    @Schema(description = "资讯图片")
    private String pic;

    @Schema(description = "资讯标题")
    private String title;

    @Schema(description = "资讯内容")
    private String content;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
