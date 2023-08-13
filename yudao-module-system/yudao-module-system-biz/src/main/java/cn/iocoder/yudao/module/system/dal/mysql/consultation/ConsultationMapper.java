package cn.iocoder.yudao.module.system.dal.mysql.consultation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.consultation.ConsultationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.consultation.vo.*;

/**
 * 用户咨询 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ConsultationMapper extends BaseMapperX<ConsultationDO> {

    default PageResult<ConsultationDO> selectPage(ConsultationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ConsultationDO>()
                .likeIfPresent(ConsultationDO::getChildName, reqVO.getChildName())
                .eqIfPresent(ConsultationDO::getMajor, reqVO.getMajor())
                .eqIfPresent(ConsultationDO::getProvinceCity, reqVO.getProvinceCity())
                .eqIfPresent(ConsultationDO::getGrade, reqVO.getGrade())
                .eqIfPresent(ConsultationDO::getEstimatedScore, reqVO.getEstimatedScore())
                .eqIfPresent(ConsultationDO::getEnglishScore, reqVO.getEnglishScore())
                .eqIfPresent(ConsultationDO::getMathScore, reqVO.getMathScore())
                .eqIfPresent(ConsultationDO::getIntendedMajor, reqVO.getIntendedMajor())
                .eqIfPresent(ConsultationDO::getIntendedArea, reqVO.getIntendedArea())
                .eqIfPresent(ConsultationDO::getIntendedUniversity, reqVO.getIntendedUniversity())
                .eqIfPresent(ConsultationDO::getIntendedCountry, reqVO.getIntendedCountry())
                .eqIfPresent(ConsultationDO::getBudget, reqVO.getBudget())
                .eqIfPresent(ConsultationDO::getContactPhone, reqVO.getContactPhone())
                .likeIfPresent(ConsultationDO::getUserName, reqVO.getUserName())
                .betweenIfPresent(ConsultationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ConsultationDO::getId));
    }

    default List<ConsultationDO> selectList(ConsultationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ConsultationDO>()
                .likeIfPresent(ConsultationDO::getChildName, reqVO.getChildName())
                .eqIfPresent(ConsultationDO::getMajor, reqVO.getMajor())
                .eqIfPresent(ConsultationDO::getProvinceCity, reqVO.getProvinceCity())
                .eqIfPresent(ConsultationDO::getGrade, reqVO.getGrade())
                .eqIfPresent(ConsultationDO::getEstimatedScore, reqVO.getEstimatedScore())
                .eqIfPresent(ConsultationDO::getEnglishScore, reqVO.getEnglishScore())
                .eqIfPresent(ConsultationDO::getMathScore, reqVO.getMathScore())
                .eqIfPresent(ConsultationDO::getIntendedMajor, reqVO.getIntendedMajor())
                .eqIfPresent(ConsultationDO::getIntendedArea, reqVO.getIntendedArea())
                .eqIfPresent(ConsultationDO::getIntendedUniversity, reqVO.getIntendedUniversity())
                .eqIfPresent(ConsultationDO::getIntendedCountry, reqVO.getIntendedCountry())
                .eqIfPresent(ConsultationDO::getBudget, reqVO.getBudget())
                .eqIfPresent(ConsultationDO::getContactPhone, reqVO.getContactPhone())
                .likeIfPresent(ConsultationDO::getUserName, reqVO.getUserName())
                .betweenIfPresent(ConsultationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ConsultationDO::getId));
    }

}
