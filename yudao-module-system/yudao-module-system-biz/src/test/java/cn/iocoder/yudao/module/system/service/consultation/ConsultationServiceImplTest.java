package cn.iocoder.yudao.module.system.service.consultation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.consultation.ConsultationDO;
import cn.iocoder.yudao.module.system.dal.mysql.consultation.ConsultationMapper;
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
 * {@link ConsultationServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(ConsultationServiceImpl.class)
public class ConsultationServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ConsultationServiceImpl consultationService;

    @Resource
    private ConsultationMapper consultationMapper;

    @Test
    public void testCreateConsultation_success() {
        // 准备参数
        ConsultationCreateReqVO reqVO = randomPojo(ConsultationCreateReqVO.class);

        // 调用
        Long consultationId = consultationService.createConsultation(reqVO);
        // 断言
        assertNotNull(consultationId);
        // 校验记录的属性是否正确
        ConsultationDO consultation = consultationMapper.selectById(consultationId);
        assertPojoEquals(reqVO, consultation);
    }

    @Test
    public void testUpdateConsultation_success() {
        // mock 数据
        ConsultationDO dbConsultation = randomPojo(ConsultationDO.class);
        consultationMapper.insert(dbConsultation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ConsultationUpdateReqVO reqVO = randomPojo(ConsultationUpdateReqVO.class, o -> {
            o.setId(dbConsultation.getId()); // 设置更新的 ID
        });

        // 调用
        consultationService.updateConsultation(reqVO);
        // 校验是否更新正确
        ConsultationDO consultation = consultationMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, consultation);
    }

    @Test
    public void testUpdateConsultation_notExists() {
        // 准备参数
        ConsultationUpdateReqVO reqVO = randomPojo(ConsultationUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> consultationService.updateConsultation(reqVO), CONSULTATION_NOT_EXISTS);
    }

    @Test
    public void testDeleteConsultation_success() {
        // mock 数据
        ConsultationDO dbConsultation = randomPojo(ConsultationDO.class);
        consultationMapper.insert(dbConsultation);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbConsultation.getId();

        // 调用
        consultationService.deleteConsultation(id);
       // 校验数据不存在了
       assertNull(consultationMapper.selectById(id));
    }

    @Test
    public void testDeleteConsultation_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> consultationService.deleteConsultation(id), CONSULTATION_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetConsultationPage() {
       // mock 数据
       ConsultationDO dbConsultation = randomPojo(ConsultationDO.class, o -> { // 等会查询到
           o.setChildName(null);
           o.setMajor(null);
           o.setProvinceCity(null);
           o.setGrade(null);
           o.setEstimatedScore(null);
           o.setEnglishScore(null);
           o.setMathScore(null);
           o.setIntendedMajor(null);
           o.setIntendedArea(null);
           o.setIntendedUniversity(null);
           o.setIntendedCountry(null);
           o.setBudget(null);
           o.setContactPhone(null);
           o.setUserName(null);
           o.setCreateTime(null);
       });
       consultationMapper.insert(dbConsultation);
       // 测试 childName 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setChildName(null)));
       // 测试 major 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setMajor(null)));
       // 测试 provinceCity 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setProvinceCity(null)));
       // 测试 grade 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setGrade(null)));
       // 测试 estimatedScore 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setEstimatedScore(null)));
       // 测试 englishScore 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setEnglishScore(null)));
       // 测试 mathScore 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setMathScore(null)));
       // 测试 intendedMajor 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedMajor(null)));
       // 测试 intendedArea 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedArea(null)));
       // 测试 intendedUniversity 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedUniversity(null)));
       // 测试 intendedCountry 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedCountry(null)));
       // 测试 budget 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setBudget(null)));
       // 测试 contactPhone 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setContactPhone(null)));
       // 测试 userName 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setUserName(null)));
       // 测试 createTime 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setCreateTime(null)));
       // 准备参数
       ConsultationPageReqVO reqVO = new ConsultationPageReqVO();
       reqVO.setChildName(null);
       reqVO.setMajor(null);
       reqVO.setProvinceCity(null);
       reqVO.setGrade(null);
       reqVO.setEstimatedScore(null);
       reqVO.setEnglishScore(null);
       reqVO.setMathScore(null);
       reqVO.setIntendedMajor(null);
       reqVO.setIntendedArea(null);
       reqVO.setIntendedUniversity(null);
       reqVO.setIntendedCountry(null);
       reqVO.setBudget(null);
       reqVO.setContactPhone(null);
       reqVO.setUserName(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<ConsultationDO> pageResult = consultationService.getConsultationPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbConsultation, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetConsultationList() {
       // mock 数据
       ConsultationDO dbConsultation = randomPojo(ConsultationDO.class, o -> { // 等会查询到
           o.setChildName(null);
           o.setMajor(null);
           o.setProvinceCity(null);
           o.setGrade(null);
           o.setEstimatedScore(null);
           o.setEnglishScore(null);
           o.setMathScore(null);
           o.setIntendedMajor(null);
           o.setIntendedArea(null);
           o.setIntendedUniversity(null);
           o.setIntendedCountry(null);
           o.setBudget(null);
           o.setContactPhone(null);
           o.setUserName(null);
           o.setCreateTime(null);
       });
       consultationMapper.insert(dbConsultation);
       // 测试 childName 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setChildName(null)));
       // 测试 major 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setMajor(null)));
       // 测试 provinceCity 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setProvinceCity(null)));
       // 测试 grade 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setGrade(null)));
       // 测试 estimatedScore 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setEstimatedScore(null)));
       // 测试 englishScore 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setEnglishScore(null)));
       // 测试 mathScore 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setMathScore(null)));
       // 测试 intendedMajor 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedMajor(null)));
       // 测试 intendedArea 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedArea(null)));
       // 测试 intendedUniversity 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedUniversity(null)));
       // 测试 intendedCountry 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setIntendedCountry(null)));
       // 测试 budget 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setBudget(null)));
       // 测试 contactPhone 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setContactPhone(null)));
       // 测试 userName 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setUserName(null)));
       // 测试 createTime 不匹配
       consultationMapper.insert(cloneIgnoreId(dbConsultation, o -> o.setCreateTime(null)));
       // 准备参数
       ConsultationExportReqVO reqVO = new ConsultationExportReqVO();
       reqVO.setChildName(null);
       reqVO.setMajor(null);
       reqVO.setProvinceCity(null);
       reqVO.setGrade(null);
       reqVO.setEstimatedScore(null);
       reqVO.setEnglishScore(null);
       reqVO.setMathScore(null);
       reqVO.setIntendedMajor(null);
       reqVO.setIntendedArea(null);
       reqVO.setIntendedUniversity(null);
       reqVO.setIntendedCountry(null);
       reqVO.setBudget(null);
       reqVO.setContactPhone(null);
       reqVO.setUserName(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<ConsultationDO> list = consultationService.getConsultationList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbConsultation, list.get(0));
    }

}
