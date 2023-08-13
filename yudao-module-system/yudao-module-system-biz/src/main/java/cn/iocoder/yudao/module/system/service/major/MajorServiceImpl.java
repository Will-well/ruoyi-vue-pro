package cn.iocoder.yudao.module.system.service.major;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.major.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.major.MajorDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.major.MajorConvert;
import cn.iocoder.yudao.module.system.dal.mysql.major.MajorMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 专业 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MajorServiceImpl implements MajorService {

    @Resource
    private MajorMapper majorMapper;

    @Override
    public Long createMajor(MajorCreateReqVO createReqVO) {
        // 插入
        MajorDO major = MajorConvert.INSTANCE.convert(createReqVO);
        majorMapper.insert(major);
        // 返回
        return major.getId();
    }

    @Override
    public void updateMajor(MajorUpdateReqVO updateReqVO) {
        // 校验存在
        validateMajorExists(updateReqVO.getId());
        // 更新
        MajorDO updateObj = MajorConvert.INSTANCE.convert(updateReqVO);
        majorMapper.updateById(updateObj);
    }

    @Override
    public void deleteMajor(Long id) {
        // 校验存在
        validateMajorExists(id);
        // 删除
        majorMapper.deleteById(id);
    }

    private void validateMajorExists(Long id) {
        if (majorMapper.selectById(id) == null) {
            throw exception(MAJOR_NOT_EXISTS);
        }
    }

    @Override
    public MajorDO getMajor(Long id) {
        return majorMapper.selectById(id);
    }

    @Override
    public List<MajorDO> getMajorList(Collection<Long> ids) {
        return majorMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MajorDO> getMajorPage(MajorPageReqVO pageReqVO) {
        return majorMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MajorDO> getMajorList(MajorExportReqVO exportReqVO) {
        return majorMapper.selectList(exportReqVO);
    }

}
