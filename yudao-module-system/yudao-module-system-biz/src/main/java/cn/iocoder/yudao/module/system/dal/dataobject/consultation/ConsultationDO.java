package cn.iocoder.yudao.module.system.dal.dataobject.consultation;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 用户咨询 DO
 *
 * @author 芋道源码
 */
@TableName("system_consultation")
@KeySequence("system_consultation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 孩子姓名
     */
    private String childName;
    /**
     * 专业名称
     */
    private String major;
    /**
     * 省市
     */
    private String provinceCity;
    /**
     * 年级
     */
    private String grade;
    /**
     * 分数或预估
     */
    private BigDecimal estimatedScore;
    /**
     * 英语分数
     */
    private BigDecimal englishScore;
    /**
     * 数学分数
     */
    private BigDecimal mathScore;
    /**
     * 意向专业
     */
    private String intendedMajor;
    /**
     * 意向地区
     */
    private String intendedArea;
    /**
     * 意向学校
     */
    private String intendedUniversity;
    /**
     * 意向国家
     */
    private String intendedCountry;
    /**
     * 预算
     */
    private BigDecimal budget;
    /**
     * 联系方式
     */
    private String contactPhone;
    /**
     * 用户姓名
     */
    private String userName;

}
