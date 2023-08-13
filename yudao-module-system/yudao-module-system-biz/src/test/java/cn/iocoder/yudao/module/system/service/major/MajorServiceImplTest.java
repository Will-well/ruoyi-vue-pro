package cn.iocoder.yudao.module.system.service.major;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.major.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.major.MajorDO;
import cn.iocoder.yudao.module.system.dal.mysql.major.MajorMapper;
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
 * {@link MajorServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(MajorServiceImpl.class)
public class MajorServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MajorServiceImpl majorService;

    @Resource
    private MajorMapper majorMapper;

    @Test
    public void testCreateMajor_success() {
        // 准备参数
        MajorCreateReqVO reqVO = randomPojo(MajorCreateReqVO.class);

        // 调用
        Long majorId = majorService.createMajor(reqVO);
        // 断言
        assertNotNull(majorId);
        // 校验记录的属性是否正确
        MajorDO major = majorMapper.selectById(majorId);
        assertPojoEquals(reqVO, major);
    }

    @Test
    public void testUpdateMajor_success() {
        // mock 数据
        MajorDO dbMajor = randomPojo(MajorDO.class);
        majorMapper.insert(dbMajor);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MajorUpdateReqVO reqVO = randomPojo(MajorUpdateReqVO.class, o -> {
            o.setId(dbMajor.getId()); // 设置更新的 ID
        });

        // 调用
        majorService.updateMajor(reqVO);
        // 校验是否更新正确
        MajorDO major = majorMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, major);
    }

    @Test
    public void testUpdateMajor_notExists() {
        // 准备参数
        MajorUpdateReqVO reqVO = randomPojo(MajorUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> majorService.updateMajor(reqVO), MAJOR_NOT_EXISTS);
    }

    @Test
    public void testDeleteMajor_success() {
        // mock 数据
        MajorDO dbMajor = randomPojo(MajorDO.class);
        majorMapper.insert(dbMajor);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMajor.getId();

        // 调用
        majorService.deleteMajor(id);
       // 校验数据不存在了
       assertNull(majorMapper.selectById(id));
    }

    @Test
    public void testDeleteMajor_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> majorService.deleteMajor(id), MAJOR_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMajorPage() {
       // mock 数据
       MajorDO dbMajor = randomPojo(MajorDO.class, o -> { // 等会查询到
           o.setUniversityId(null);
           o.setUniversityName(null);
           o.setTopCategory(null);
           o.setCategory(null);
           o.setMajorName(null);
           o.setMajorIntro(null);
           o.setEmploymentOrientation(null);
           o.setSpecialRequirements(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       majorMapper.insert(dbMajor);
       // 测试 universityId 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setUniversityId(null)));
       // 测试 universityName 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setUniversityName(null)));
       // 测试 topCategory 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setTopCategory(null)));
       // 测试 category 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setCategory(null)));
       // 测试 majorName 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setMajorName(null)));
       // 测试 majorIntro 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setMajorIntro(null)));
       // 测试 employmentOrientation 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setEmploymentOrientation(null)));
       // 测试 specialRequirements 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setSpecialRequirements(null)));
       // 测试 sort 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setCreateTime(null)));
       // 准备参数
       MajorPageReqVO reqVO = new MajorPageReqVO();
       reqVO.setUniversityId(null);
       reqVO.setUniversityName(null);
       reqVO.setTopCategory(null);
       reqVO.setCategory(null);
       reqVO.setMajorName(null);
       reqVO.setMajorIntro(null);
       reqVO.setEmploymentOrientation(null);
       reqVO.setSpecialRequirements(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<MajorDO> pageResult = majorService.getMajorPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMajor, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMajorList() {
       // mock 数据
       MajorDO dbMajor = randomPojo(MajorDO.class, o -> { // 等会查询到
           o.setUniversityId(null);
           o.setUniversityName(null);
           o.setTopCategory(null);
           o.setCategory(null);
           o.setMajorName(null);
           o.setMajorIntro(null);
           o.setEmploymentOrientation(null);
           o.setSpecialRequirements(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       majorMapper.insert(dbMajor);
       // 测试 universityId 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setUniversityId(null)));
       // 测试 universityName 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setUniversityName(null)));
       // 测试 topCategory 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setTopCategory(null)));
       // 测试 category 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setCategory(null)));
       // 测试 majorName 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setMajorName(null)));
       // 测试 majorIntro 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setMajorIntro(null)));
       // 测试 employmentOrientation 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setEmploymentOrientation(null)));
       // 测试 specialRequirements 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setSpecialRequirements(null)));
       // 测试 sort 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       majorMapper.insert(cloneIgnoreId(dbMajor, o -> o.setCreateTime(null)));
       // 准备参数
       MajorExportReqVO reqVO = new MajorExportReqVO();
       reqVO.setUniversityId(null);
       reqVO.setUniversityName(null);
       reqVO.setTopCategory(null);
       reqVO.setCategory(null);
       reqVO.setMajorName(null);
       reqVO.setMajorIntro(null);
       reqVO.setEmploymentOrientation(null);
       reqVO.setSpecialRequirements(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<MajorDO> list = majorService.getMajorList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMajor, list.get(0));
    }

}
