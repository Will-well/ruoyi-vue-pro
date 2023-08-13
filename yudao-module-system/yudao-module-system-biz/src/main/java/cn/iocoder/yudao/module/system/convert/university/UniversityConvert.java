package cn.iocoder.yudao.module.system.convert.university;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.university.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.university.UniversityDO;

/**
 * 学校 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface UniversityConvert {

    UniversityConvert INSTANCE = Mappers.getMapper(UniversityConvert.class);

    UniversityDO convert(UniversityCreateReqVO bean);

    UniversityDO convert(UniversityUpdateReqVO bean);

    UniversityRespVO convert(UniversityDO bean);

    List<UniversityRespVO> convertList(List<UniversityDO> list);

    PageResult<UniversityRespVO> convertPage(PageResult<UniversityDO> page);

    List<UniversityExcelVO> convertList02(List<UniversityDO> list);

}
