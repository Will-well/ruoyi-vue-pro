package cn.iocoder.yudao.module.system.dal.mysql.university;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.university.UniversityDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.university.vo.*;

/**
 * 学校 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface UniversityMapper extends BaseMapperX<UniversityDO> {

    default PageResult<UniversityDO> selectPage(UniversityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UniversityDO>()
                .eqIfPresent(UniversityDO::getCode, reqVO.getCode())
                .likeIfPresent(UniversityDO::getName, reqVO.getName())
                .likeIfPresent(UniversityDO::getEnName, reqVO.getEnName())
                .eqIfPresent(UniversityDO::getLogo, reqVO.getLogo())
                .eqIfPresent(UniversityDO::getHomePic, reqVO.getHomePic())
                .eqIfPresent(UniversityDO::getIntro, reqVO.getIntro())
                .eqIfPresent(UniversityDO::getApplyRequirements, reqVO.getApplyRequirements())
                .eqIfPresent(UniversityDO::getCountry, reqVO.getCountry())
                .eqIfPresent(UniversityDO::getTuitionFee, reqVO.getTuitionFee())
                .eqIfPresent(UniversityDO::getEnrollmentMethod, reqVO.getEnrollmentMethod())
                .eqIfPresent(UniversityDO::getEmployment, reqVO.getEmployment())
                .eqIfPresent(UniversityDO::getShengShuo, reqVO.getShengShuo())
                .eqIfPresent(UniversityDO::getQs, reqVO.getQs())
                .eqIfPresent(UniversityDO::getSort, reqVO.getSort())
                .betweenIfPresent(UniversityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UniversityDO::getId));
    }

    default List<UniversityDO> selectList(UniversityExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<UniversityDO>()
                .eqIfPresent(UniversityDO::getCode, reqVO.getCode())
                .likeIfPresent(UniversityDO::getName, reqVO.getName())
                .likeIfPresent(UniversityDO::getEnName, reqVO.getEnName())
                .eqIfPresent(UniversityDO::getLogo, reqVO.getLogo())
                .eqIfPresent(UniversityDO::getHomePic, reqVO.getHomePic())
                .eqIfPresent(UniversityDO::getIntro, reqVO.getIntro())
                .eqIfPresent(UniversityDO::getApplyRequirements, reqVO.getApplyRequirements())
                .eqIfPresent(UniversityDO::getCountry, reqVO.getCountry())
                .eqIfPresent(UniversityDO::getTuitionFee, reqVO.getTuitionFee())
                .eqIfPresent(UniversityDO::getEnrollmentMethod, reqVO.getEnrollmentMethod())
                .eqIfPresent(UniversityDO::getEmployment, reqVO.getEmployment())
                .eqIfPresent(UniversityDO::getShengShuo, reqVO.getShengShuo())
                .eqIfPresent(UniversityDO::getQs, reqVO.getQs())
                .eqIfPresent(UniversityDO::getSort, reqVO.getSort())
                .betweenIfPresent(UniversityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UniversityDO::getId));
    }

}
