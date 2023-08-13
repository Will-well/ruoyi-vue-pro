package cn.iocoder.yudao.module.system.dal.dataobject.major;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 专业 DO
 *
 * @author 芋道源码
 */
@TableName("system_major")
@KeySequence("system_major_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MajorDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 大学id
     */
    private String universityId;
    /**
     * 大学名称
     */
    private String universityName;
    /**
     * 一级分类
     */
    private String topCategory;
    /**
     * 二级分类
     */
    private String category;
    /**
     * 专业名称
     */
    private String majorName;
    /**
     * 专业介绍
     */
    private String majorIntro;
    /**
     * 就业方向
     */
    private String employmentOrientation;
    /**
     * 特殊要求
     */
    private String specialRequirements;
    /**
     * 排序
     */
    private Integer sort;

}
