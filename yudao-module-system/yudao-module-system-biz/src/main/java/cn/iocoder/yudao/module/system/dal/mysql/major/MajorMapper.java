package cn.iocoder.yudao.module.system.dal.mysql.major;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.major.MajorDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.major.vo.*;

/**
 * 专业 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MajorMapper extends BaseMapperX<MajorDO> {

    default PageResult<MajorDO> selectPage(MajorPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MajorDO>()
                .eqIfPresent(MajorDO::getUniversityId, reqVO.getUniversityId())
                .likeIfPresent(MajorDO::getUniversityName, reqVO.getUniversityName())
                .eqIfPresent(MajorDO::getTopCategory, reqVO.getTopCategory())
                .eqIfPresent(MajorDO::getCategory, reqVO.getCategory())
                .likeIfPresent(MajorDO::getMajorName, reqVO.getMajorName())
                .eqIfPresent(MajorDO::getMajorIntro, reqVO.getMajorIntro())
                .eqIfPresent(MajorDO::getEmploymentOrientation, reqVO.getEmploymentOrientation())
                .eqIfPresent(MajorDO::getSpecialRequirements, reqVO.getSpecialRequirements())
                .eqIfPresent(MajorDO::getSort, reqVO.getSort())
                .betweenIfPresent(MajorDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MajorDO::getId));
    }

    default List<MajorDO> selectList(MajorExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MajorDO>()
                .eqIfPresent(MajorDO::getUniversityId, reqVO.getUniversityId())
                .likeIfPresent(MajorDO::getUniversityName, reqVO.getUniversityName())
                .eqIfPresent(MajorDO::getTopCategory, reqVO.getTopCategory())
                .eqIfPresent(MajorDO::getCategory, reqVO.getCategory())
                .likeIfPresent(MajorDO::getMajorName, reqVO.getMajorName())
                .eqIfPresent(MajorDO::getMajorIntro, reqVO.getMajorIntro())
                .eqIfPresent(MajorDO::getEmploymentOrientation, reqVO.getEmploymentOrientation())
                .eqIfPresent(MajorDO::getSpecialRequirements, reqVO.getSpecialRequirements())
                .eqIfPresent(MajorDO::getSort, reqVO.getSort())
                .betweenIfPresent(MajorDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MajorDO::getId));
    }

}
