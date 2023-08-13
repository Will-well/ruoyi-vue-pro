package cn.iocoder.yudao.module.system.service.university;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.university.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.university.UniversityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.university.UniversityConvert;
import cn.iocoder.yudao.module.system.dal.mysql.university.UniversityMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 学校 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class UniversityServiceImpl implements UniversityService {

    @Resource
    private UniversityMapper universityMapper;

    @Override
    public Long createUniversity(UniversityCreateReqVO createReqVO) {
        // 插入
        UniversityDO university = UniversityConvert.INSTANCE.convert(createReqVO);
        universityMapper.insert(university);
        // 返回
        return university.getId();
    }

    @Override
    public void updateUniversity(UniversityUpdateReqVO updateReqVO) {
        // 校验存在
        validateUniversityExists(updateReqVO.getId());
        // 更新
        UniversityDO updateObj = UniversityConvert.INSTANCE.convert(updateReqVO);
        universityMapper.updateById(updateObj);
    }

    @Override
    public void deleteUniversity(Long id) {
        // 校验存在
        validateUniversityExists(id);
        // 删除
        universityMapper.deleteById(id);
    }

    private void validateUniversityExists(Long id) {
        if (universityMapper.selectById(id) == null) {
            throw exception(UNIVERSITY_NOT_EXISTS);
        }
    }

    @Override
    public UniversityDO getUniversity(Long id) {
        return universityMapper.selectById(id);
    }

    @Override
    public List<UniversityDO> getUniversityList(Collection<Long> ids) {
        return universityMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<UniversityDO> getUniversityPage(UniversityPageReqVO pageReqVO) {
        return universityMapper.selectPage(pageReqVO);
    }

    @Override
    public List<UniversityDO> getUniversityList(UniversityExportReqVO exportReqVO) {
        return universityMapper.selectList(exportReqVO);
    }

}
