package cn.iocoder.yudao.module.system.controller.admin.information.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 资讯 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class InformationBaseVO {

    @Schema(description = "资讯图片")
    private String pic;

    @Schema(description = "资讯标题")
    private String title;

    @Schema(description = "资讯内容")
    private String content;

    @Schema(description = "排序")
    private Integer sort;

}
