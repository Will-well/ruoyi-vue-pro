package cn.iocoder.yudao.module.system.dal.mysql.wxuser;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.wxuser.WxUserDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.wxuser.vo.*;

/**
 * wx用户 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface WxUserMapper extends BaseMapperX<WxUserDO> {

    default PageResult<WxUserDO> selectPage(WxUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<WxUserDO>()
                .eqIfPresent(WxUserDO::getWxId, reqVO.getWxId())
                .eqIfPresent(WxUserDO::getLoginToken, reqVO.getLoginToken())
                .likeIfPresent(WxUserDO::getRealName, reqVO.getRealName())
                .eqIfPresent(WxUserDO::getSex, reqVO.getSex())
                .eqIfPresent(WxUserDO::getAge, reqVO.getAge())
                .likeIfPresent(WxUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(WxUserDO::getPhone, reqVO.getPhone())
                .eqIfPresent(WxUserDO::getEncryptPhone, reqVO.getEncryptPhone())
                .betweenIfPresent(WxUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(WxUserDO::getId));
    }

    default List<WxUserDO> selectList(WxUserExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<WxUserDO>()
                .eqIfPresent(WxUserDO::getWxId, reqVO.getWxId())
                .eqIfPresent(WxUserDO::getLoginToken, reqVO.getLoginToken())
                .likeIfPresent(WxUserDO::getRealName, reqVO.getRealName())
                .eqIfPresent(WxUserDO::getSex, reqVO.getSex())
                .eqIfPresent(WxUserDO::getAge, reqVO.getAge())
                .likeIfPresent(WxUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(WxUserDO::getPhone, reqVO.getPhone())
                .eqIfPresent(WxUserDO::getEncryptPhone, reqVO.getEncryptPhone())
                .betweenIfPresent(WxUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(WxUserDO::getId));
    }

}
