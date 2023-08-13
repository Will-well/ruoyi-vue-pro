package cn.iocoder.yudao.module.system.service.university;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.university.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.university.UniversityDO;
import cn.iocoder.yudao.module.system.dal.mysql.university.UniversityMapper;
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
 * {@link UniversityServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(UniversityServiceImpl.class)
public class UniversityServiceImplTest extends BaseDbUnitTest {

    @Resource
    private UniversityServiceImpl universityService;

    @Resource
    private UniversityMapper universityMapper;

    @Test
    public void testCreateUniversity_success() {
        // 准备参数
        UniversityCreateReqVO reqVO = randomPojo(UniversityCreateReqVO.class);

        // 调用
        Long universityId = universityService.createUniversity(reqVO);
        // 断言
        assertNotNull(universityId);
        // 校验记录的属性是否正确
        UniversityDO university = universityMapper.selectById(universityId);
        assertPojoEquals(reqVO, university);
    }

    @Test
    public void testUpdateUniversity_success() {
        // mock 数据
        UniversityDO dbUniversity = randomPojo(UniversityDO.class);
        universityMapper.insert(dbUniversity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        UniversityUpdateReqVO reqVO = randomPojo(UniversityUpdateReqVO.class, o -> {
            o.setId(dbUniversity.getId()); // 设置更新的 ID
        });

        // 调用
        universityService.updateUniversity(reqVO);
        // 校验是否更新正确
        UniversityDO university = universityMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, university);
    }

    @Test
    public void testUpdateUniversity_notExists() {
        // 准备参数
        UniversityUpdateReqVO reqVO = randomPojo(UniversityUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> universityService.updateUniversity(reqVO), UNIVERSITY_NOT_EXISTS);
    }

    @Test
    public void testDeleteUniversity_success() {
        // mock 数据
        UniversityDO dbUniversity = randomPojo(UniversityDO.class);
        universityMapper.insert(dbUniversity);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbUniversity.getId();

        // 调用
        universityService.deleteUniversity(id);
       // 校验数据不存在了
       assertNull(universityMapper.selectById(id));
    }

    @Test
    public void testDeleteUniversity_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> universityService.deleteUniversity(id), UNIVERSITY_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetUniversityPage() {
       // mock 数据
       UniversityDO dbUniversity = randomPojo(UniversityDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setName(null);
           o.setEnName(null);
           o.setLogo(null);
           o.setHomePic(null);
           o.setIntro(null);
           o.setApplyRequirements(null);
           o.setCountry(null);
           o.setTuitionFee(null);
           o.setEnrollmentMethod(null);
           o.setEmployment(null);
           o.setShengShuo(null);
           o.setQs(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       universityMapper.insert(dbUniversity);
       // 测试 code 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setCode(null)));
       // 测试 name 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setName(null)));
       // 测试 enName 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setEnName(null)));
       // 测试 logo 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setLogo(null)));
       // 测试 homePic 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setHomePic(null)));
       // 测试 intro 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setIntro(null)));
       // 测试 applyRequirements 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setApplyRequirements(null)));
       // 测试 country 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setCountry(null)));
       // 测试 tuitionFee 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setTuitionFee(null)));
       // 测试 enrollmentMethod 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setEnrollmentMethod(null)));
       // 测试 employment 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setEmployment(null)));
       // 测试 shengShuo 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setShengShuo(null)));
       // 测试 qs 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setQs(null)));
       // 测试 sort 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setCreateTime(null)));
       // 准备参数
       UniversityPageReqVO reqVO = new UniversityPageReqVO();
       reqVO.setCode(null);
       reqVO.setName(null);
       reqVO.setEnName(null);
       reqVO.setLogo(null);
       reqVO.setHomePic(null);
       reqVO.setIntro(null);
       reqVO.setApplyRequirements(null);
       reqVO.setCountry(null);
       reqVO.setTuitionFee(null);
       reqVO.setEnrollmentMethod(null);
       reqVO.setEmployment(null);
       reqVO.setShengShuo(null);
       reqVO.setQs(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<UniversityDO> pageResult = universityService.getUniversityPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbUniversity, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetUniversityList() {
       // mock 数据
       UniversityDO dbUniversity = randomPojo(UniversityDO.class, o -> { // 等会查询到
           o.setCode(null);
           o.setName(null);
           o.setEnName(null);
           o.setLogo(null);
           o.setHomePic(null);
           o.setIntro(null);
           o.setApplyRequirements(null);
           o.setCountry(null);
           o.setTuitionFee(null);
           o.setEnrollmentMethod(null);
           o.setEmployment(null);
           o.setShengShuo(null);
           o.setQs(null);
           o.setSort(null);
           o.setCreateTime(null);
       });
       universityMapper.insert(dbUniversity);
       // 测试 code 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setCode(null)));
       // 测试 name 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setName(null)));
       // 测试 enName 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setEnName(null)));
       // 测试 logo 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setLogo(null)));
       // 测试 homePic 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setHomePic(null)));
       // 测试 intro 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setIntro(null)));
       // 测试 applyRequirements 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setApplyRequirements(null)));
       // 测试 country 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setCountry(null)));
       // 测试 tuitionFee 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setTuitionFee(null)));
       // 测试 enrollmentMethod 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setEnrollmentMethod(null)));
       // 测试 employment 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setEmployment(null)));
       // 测试 shengShuo 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setShengShuo(null)));
       // 测试 qs 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setQs(null)));
       // 测试 sort 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setSort(null)));
       // 测试 createTime 不匹配
       universityMapper.insert(cloneIgnoreId(dbUniversity, o -> o.setCreateTime(null)));
       // 准备参数
       UniversityExportReqVO reqVO = new UniversityExportReqVO();
       reqVO.setCode(null);
       reqVO.setName(null);
       reqVO.setEnName(null);
       reqVO.setLogo(null);
       reqVO.setHomePic(null);
       reqVO.setIntro(null);
       reqVO.setApplyRequirements(null);
       reqVO.setCountry(null);
       reqVO.setTuitionFee(null);
       reqVO.setEnrollmentMethod(null);
       reqVO.setEmployment(null);
       reqVO.setShengShuo(null);
       reqVO.setQs(null);
       reqVO.setSort(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<UniversityDO> list = universityService.getUniversityList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbUniversity, list.get(0));
    }

}
