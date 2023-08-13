package cn.iocoder.yudao.module.system.convert.wxuser;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.system.controller.admin.wxuser.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.wxuser.WxUserDO;

/**
 * wx用户 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface WxUserConvert {

    WxUserConvert INSTANCE = Mappers.getMapper(WxUserConvert.class);

    WxUserDO convert(WxUserCreateReqVO bean);

    WxUserDO convert(WxUserUpdateReqVO bean);

    WxUserRespVO convert(WxUserDO bean);

    List<WxUserRespVO> convertList(List<WxUserDO> list);

    PageResult<WxUserRespVO> convertPage(PageResult<WxUserDO> page);

    List<WxUserExcelVO> convertList02(List<WxUserDO> list);

}
