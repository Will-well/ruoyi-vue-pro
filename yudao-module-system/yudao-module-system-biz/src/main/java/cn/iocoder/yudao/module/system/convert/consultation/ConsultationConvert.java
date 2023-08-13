package cn.iocoder.yudao.module.system.convert.consultation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.consultation.ConsultationDO;

/**
 * 用户咨询 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ConsultationConvert {

    ConsultationConvert INSTANCE = Mappers.getMapper(ConsultationConvert.class);

    ConsultationDO convert(ConsultationCreateReqVO bean);

    ConsultationDO convert(ConsultationUpdateReqVO bean);

    ConsultationRespVO convert(ConsultationDO bean);

    List<ConsultationRespVO> convertList(List<ConsultationDO> list);

    PageResult<ConsultationRespVO> convertPage(PageResult<ConsultationDO> page);

    List<ConsultationExcelVO> convertList02(List<ConsultationDO> list);

}
