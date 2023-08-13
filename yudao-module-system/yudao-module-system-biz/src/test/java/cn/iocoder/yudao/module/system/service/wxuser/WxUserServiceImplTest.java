package cn.iocoder.yudao.module.system.service.wxuser;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.wxuser.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.wxuser.WxUserDO;
import cn.iocoder.yudao.module.system.dal.mysql.wxuser.WxUserMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link WxUserServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(WxUserServiceImpl.class)
public class WxUserServiceImplTest extends BaseDbUnitTest {

    @Resource
    private WxUserServiceImpl wxUserService;

    @Resource
    private WxUserMapper wxUserMapper;

    @Test
    public void testCreateWxUser_success() {
        // 准备参数
        WxUserCreateReqVO reqVO = randomPojo(WxUserCreateReqVO.class);

        // 调用
        Long wxUserId = wxUserService.createWxUser(reqVO);
        // 断言
        assertNotNull(wxUserId);
        // 校验记录的属性是否正确
        WxUserDO wxUser = wxUserMapper.selectById(wxUserId);
        assertPojoEquals(reqVO, wxUser);
    }

    @Test
    public void testUpdateWxUser_success() {
        // mock 数据
        WxUserDO dbWxUser = randomPojo(WxUserDO.class);
        wxUserMapper.insert(dbWxUser);// @Sql: 先插入出一条存在的数据
        // 准备参数
        WxUserUpdateReqVO reqVO = randomPojo(WxUserUpdateReqVO.class, o -> {
            o.setId(dbWxUser.getId()); // 设置更新的 ID
        });

        // 调用
        wxUserService.updateWxUser(reqVO);
        // 校验是否更新正确
        WxUserDO wxUser = wxUserMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, wxUser);
    }

    @Test
    public void testUpdateWxUser_notExists() {
        // 准备参数
        WxUserUpdateReqVO reqVO = randomPojo(WxUserUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> wxUserService.updateWxUser(reqVO), WX_USER_NOT_EXISTS);
    }

    @Test
    public void testDeleteWxUser_success() {
        // mock 数据
        WxUserDO dbWxUser = randomPojo(WxUserDO.class);
        wxUserMapper.insert(dbWxUser);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbWxUser.getId();

        // 调用
        wxUserService.deleteWxUser(id);
       // 校验数据不存在了
       assertNull(wxUserMapper.selectById(id));
    }

    @Test
    public void testDeleteWxUser_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> wxUserService.deleteWxUser(id), WX_USER_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetWxUserPage() {
       // mock 数据
       WxUserDO dbWxUser = randomPojo(WxUserDO.class, o -> { // 等会查询到
           o.setWxId(null);
           o.setLoginToken(null);
           o.setRealName(null);
           o.setSex(null);
           o.setAge(null);
           o.setNickname(null);
           o.setPhone(null);
           o.setEncryptPhone(null);
           o.setCreateTime(null);
       });
       wxUserMapper.insert(dbWxUser);
       // 测试 wxId 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setWxId(null)));
       // 测试 loginToken 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setLoginToken(null)));
       // 测试 realName 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setRealName(null)));
       // 测试 sex 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setSex(null)));
       // 测试 age 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setAge(null)));
       // 测试 nickname 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setNickname(null)));
       // 测试 phone 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setPhone(null)));
       // 测试 encryptPhone 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setEncryptPhone(null)));
       // 测试 createTime 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setCreateTime(null)));
       // 准备参数
       WxUserPageReqVO reqVO = new WxUserPageReqVO();
       reqVO.setWxId(null);
       reqVO.setLoginToken(null);
       reqVO.setRealName(null);
       reqVO.setSex(null);
       reqVO.setAge(null);
       reqVO.setNickname(null);
       reqVO.setPhone(null);
       reqVO.setEncryptPhone(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<WxUserDO> pageResult = wxUserService.getWxUserPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbWxUser, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetWxUserList() {
       // mock 数据
       WxUserDO dbWxUser = randomPojo(WxUserDO.class, o -> { // 等会查询到
           o.setWxId(null);
           o.setLoginToken(null);
           o.setRealName(null);
           o.setSex(null);
           o.setAge(null);
           o.setNickname(null);
           o.setPhone(null);
           o.setEncryptPhone(null);
           o.setCreateTime(null);
       });
       wxUserMapper.insert(dbWxUser);
       // 测试 wxId 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setWxId(null)));
       // 测试 loginToken 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setLoginToken(null)));
       // 测试 realName 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setRealName(null)));
       // 测试 sex 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setSex(null)));
       // 测试 age 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setAge(null)));
       // 测试 nickname 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setNickname(null)));
       // 测试 phone 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setPhone(null)));
       // 测试 encryptPhone 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setEncryptPhone(null)));
       // 测试 createTime 不匹配
       wxUserMapper.insert(cloneIgnoreId(dbWxUser, o -> o.setCreateTime(null)));
       // 准备参数
       WxUserExportReqVO reqVO = new WxUserExportReqVO();
       reqVO.setWxId(null);
       reqVO.setLoginToken(null);
       reqVO.setRealName(null);
       reqVO.setSex(null);
       reqVO.setAge(null);
       reqVO.setNickname(null);
       reqVO.setPhone(null);
       reqVO.setEncryptPhone(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<WxUserDO> list = wxUserService.getWxUserList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbWxUser, list.get(0));
    }

}
