package cn.iocoder.yudao.module.system.dal.dataobject.university;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 学校 DO
 *
 * @author 芋道源码
 */
@TableName("system_university")
@KeySequence("system_university_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 大学编码
     */
    private String code;
    /**
     * 大学名称
     */
    private String name;
    /**
     * 大学英文名称
     */
    private String enName;
    /**
     * 学校logo
     */
    private String logo;
    /**
     * 主页图片
     */
    private String homePic;
    /**
     * 简介
     */
    private String intro;
    /**
     * 申请要求
     */
    private String applyRequirements;
    /**
     * 所属国家
     */
    private String country;
    /**
     * 学费
     */
    private BigDecimal tuitionFee;
    /**
     * 招生方式
     */
    private String enrollmentMethod;
    /**
     * 就业
     */
    private String employment;
    /**
     * 申硕情况
     */
    private String shengShuo;
    /**
     * 排名
     */
    private Integer qs;
    /**
     * 排序
     */
    private Integer sort;

}
