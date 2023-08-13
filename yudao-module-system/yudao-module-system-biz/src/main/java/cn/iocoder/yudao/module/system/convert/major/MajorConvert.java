package cn.iocoder.yudao.module.system.convert.major;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.major.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.major.MajorDO;

/**
 * 专业 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MajorConvert {

    MajorConvert INSTANCE = Mappers.getMapper(MajorConvert.class);

    MajorDO convert(MajorCreateReqVO bean);

    MajorDO convert(MajorUpdateReqVO bean);

    MajorRespVO convert(MajorDO bean);

    List<MajorRespVO> convertList(List<MajorDO> list);

    PageResult<MajorRespVO> convertPage(PageResult<MajorDO> page);

    List<MajorExcelVO> convertList02(List<MajorDO> list);

}
