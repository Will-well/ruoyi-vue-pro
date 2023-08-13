package cn.iocoder.yudao.module.system.service.wxuser;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.wxuser.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.wxuser.WxUserDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.wxuser.WxUserConvert;
import cn.iocoder.yudao.module.system.dal.mysql.wxuser.WxUserMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * wx用户 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class WxUserServiceImpl implements WxUserService {

    @Resource
    private WxUserMapper wxUserMapper;

    @Override
    public Long createWxUser(WxUserCreateReqVO createReqVO) {
        // 插入
        WxUserDO wxUser = WxUserConvert.INSTANCE.convert(createReqVO);
        wxUserMapper.insert(wxUser);
        // 返回
        return wxUser.getId();
    }

    @Override
    public void updateWxUser(WxUserUpdateReqVO updateReqVO) {
        // 校验存在
        validateWxUserExists(updateReqVO.getId());
        // 更新
        WxUserDO updateObj = WxUserConvert.INSTANCE.convert(updateReqVO);
        wxUserMapper.updateById(updateObj);
    }

    @Override
    public void deleteWxUser(Long id) {
        // 校验存在
        validateWxUserExists(id);
        // 删除
        wxUserMapper.deleteById(id);
    }

    private void validateWxUserExists(Long id) {
        if (wxUserMapper.selectById(id) == null) {
            throw exception(WX_USER_NOT_EXISTS);
        }
    }

    @Override
    public WxUserDO getWxUser(Long id) {
        return wxUserMapper.selectById(id);
    }

    @Override
    public List<WxUserDO> getWxUserList(Collection<Long> ids) {
        return wxUserMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<WxUserDO> getWxUserPage(WxUserPageReqVO pageReqVO) {
        return wxUserMapper.selectPage(pageReqVO);
    }

    @Override
    public List<WxUserDO> getWxUserList(WxUserExportReqVO exportReqVO) {
        return wxUserMapper.selectList(exportReqVO);
    }

}
