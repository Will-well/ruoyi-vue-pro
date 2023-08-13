package cn.iocoder.yudao.module.system.convert.information;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.information.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.information.InformationDO;

/**
 * 资讯 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface InformationConvert {

    InformationConvert INSTANCE = Mappers.getMapper(InformationConvert.class);

    InformationDO convert(InformationCreateReqVO bean);

    InformationDO convert(InformationUpdateReqVO bean);

    InformationRespVO convert(InformationDO bean);

    List<InformationRespVO> convertList(List<InformationDO> list);

    PageResult<InformationRespVO> convertPage(PageResult<InformationDO> page);

    List<InformationExcelVO> convertList02(List<InformationDO> list);

}
