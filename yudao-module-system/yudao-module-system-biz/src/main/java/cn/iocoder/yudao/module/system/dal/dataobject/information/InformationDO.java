package cn.iocoder.yudao.module.system.dal.dataobject.information;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资讯 DO
 *
 * @author 芋道源码
 */
@TableName("system_information")
@KeySequence("system_information_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformationDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 资讯图片
     */
    private String pic;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 资讯内容
     */
    private String content;
    /**
     * 排序
     */
    private Integer sort;

}
