package cn.iocoder.yudao.module.system.service.information;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.information.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.information.InformationDO;
import cn.iocoder.yudao.module.system.dal.mysql.information.InformationMapper;
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
 * {@link InformationServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(InformationServiceImpl.class)
public class InformationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private InformationServiceImpl informationService;

    @Resource
    private InformationMapper informationMapper;

    @Test
    public void testCreateInformation_success() {
        // 准备参数
        InformationCreateReqVO reqVO = randomPojo(InformationCreateReqVO.class);

        // 调用
        Long informationId = informationService.createInformation(reqVO);
        // 断言
        assertNotNull(informationId);
        // 校验记录的属性是否正确
        InformationDO information = informationMapper.selectById(informationId);
        assertPojoEquals(reqVO, information);
    }

    @Test
    public void testUpdateInformation_success() {
        // mock 数据
        InformationDO dbInformation = randomPojo(InformationDO.class);
        informationMapper.insert(dbInformation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        InformationUpdateReqVO reqVO = randomPojo(InformationUpdateReqVO.class, o -> {
            o.setId(dbInformation.getId()); // 设置更新的 ID
        });

        // 调用
        informationService.updateInformation(reqVO);
        // 校验是否更新正确
        InformationDO information = informationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, information);
    }

    @Test
    public void testUpdateInformation_notExists() {
        // 准备参数
        InformationUpdateReqVO reqVO = randomPojo(InformationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> informationService.updateInformation(reqVO), INFORMATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteInformation_success() {
        // mock 数据
        InformationDO dbInformation = randomPojo(InformationDO.class);
        informationMapper.insert(dbInformation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbInformation.getId();

        // 调用
        informationService.deleteInformation(id);
       // 校验数据不存在了
       assertNull(informationMapper.selectById(id));
    }

    @Test
    public void testDeleteInformation_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> informationService.deleteInformation(id), INFORMATION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInformationPage() {
       // mock 数据
       InformationDO dbInformation = randomPojo(InformationDO.class, o -> { // 等会查询到
           o.setPic(null);
           o.setTitle(null);
           o.setContent(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       informationMapper.insert(dbInformation);
       // 测试 pic 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setPic(null)));
       // 测试 title 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setTitle(null)));
       // 测试 content 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setContent(null)));
       // 测试 sort 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setCreateTime(null)));
       // 准备参数
       InformationPageReqVO reqVO = new InformationPageReqVO();
       reqVO.setPic(null);
       reqVO.setTitle(null);
       reqVO.setContent(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<InformationDO> pageResult = informationService.getInformationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbInformation, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetInformationList() {
       // mock 数据
       InformationDO dbInformation = randomPojo(InformationDO.class, o -> { // 等会查询到
           o.setPic(null);
           o.setTitle(null);
           o.setContent(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       informationMapper.insert(dbInformation);
       // 测试 pic 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setPic(null)));
       // 测试 title 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setTitle(null)));
       // 测试 content 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setContent(null)));
       // 测试 sort 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       informationMapper.insert(cloneIgnoreId(dbInformation, o -> o.setCreateTime(null)));
       // 准备参数
       InformationExportReqVO reqVO = new InformationExportReqVO();
       reqVO.setPic(null);
       reqVO.setTitle(null);
       reqVO.setContent(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<InformationDO> list = informationService.getInformationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbInformation, list.get(0));
    }

}
