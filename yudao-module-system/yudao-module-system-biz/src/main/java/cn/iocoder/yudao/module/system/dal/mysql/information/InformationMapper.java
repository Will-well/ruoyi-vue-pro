package cn.iocoder.yudao.module.system.dal.mysql.information;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.information.InformationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.information.vo.*;

/**
 * 资讯 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface InformationMapper extends BaseMapperX<InformationDO> {

    default PageResult<InformationDO> selectPage(InformationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InformationDO>()
                .eqIfPresent(InformationDO::getPic, reqVO.getPic())
                .eqIfPresent(InformationDO::getTitle, reqVO.getTitle())
                .eqIfPresent(InformationDO::getContent, reqVO.getContent())
                .eqIfPresent(InformationDO::getSort, reqVO.getSort())
                .betweenIfPresent(InformationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InformationDO::getId));
    }

    default List<InformationDO> selectList(InformationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<InformationDO>()
                .eqIfPresent(InformationDO::getPic, reqVO.getPic())
                .eqIfPresent(InformationDO::getTitle, reqVO.getTitle())
                .eqIfPresent(InformationDO::getContent, reqVO.getContent())
                .eqIfPresent(InformationDO::getSort, reqVO.getSort())
                .betweenIfPresent(InformationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InformationDO::getId));
    }

}
