package cn.iocoder.yudao.module.system.service.wxuser;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.wxuser.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.wxuser.WxUserDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * wx用户 Service 接口
 *
 * @author 芋道源码
 */
public interface WxUserService {

    /**
     * 创建wx用户
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createWxUser(@Valid WxUserCreateReqVO createReqVO);

    /**
     * 更新wx用户
     *
     * @param updateReqVO 更新信息
     */
    void updateWxUser(@Valid WxUserUpdateReqVO updateReqVO);

    /**
     * 删除wx用户
     *
     * @param id 编号
     */
    void deleteWxUser(Long id);

    /**
     * 获得wx用户
     *
     * @param id 编号
     * @return wx用户
     */
    WxUserDO getWxUser(Long id);

    /**
     * 获得wx用户列表
     *
     * @param ids 编号
     * @return wx用户列表
     */
    List<WxUserDO> getWxUserList(Collection<Long> ids);

    /**
     * 获得wx用户分页
     *
     * @param pageReqVO 分页查询
     * @return wx用户分页
     */
    PageResult<WxUserDO> getWxUserPage(WxUserPageReqVO pageReqVO);

    /**
     * 获得wx用户列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return wx用户列表
     */
    List<WxUserDO> getWxUserList(WxUserExportReqVO exportReqVO);

}
