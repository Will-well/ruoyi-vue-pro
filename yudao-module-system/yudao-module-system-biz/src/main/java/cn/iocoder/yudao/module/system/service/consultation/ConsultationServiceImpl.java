package cn.iocoder.yudao.module.system.service.consultation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.consultation.ConsultationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.consultation.ConsultationConvert;
import cn.iocoder.yudao.module.system.dal.mysql.consultation.ConsultationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 用户咨询 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ConsultationServiceImpl implements ConsultationService {

    @Resource
    private ConsultationMapper consultationMapper;

    @Override
    public Long createConsultation(ConsultationCreateReqVO createReqVO) {
        // 插入
        ConsultationDO consultation = ConsultationConvert.INSTANCE.convert(createReqVO);
        consultationMapper.insert(consultation);
        // 返回
        return consultation.getId();
    }

    @Override
    public void updateConsultation(ConsultationUpdateReqVO updateReqVO) {
        // 校验存在
        validateConsultationExists(updateReqVO.getId());
        // 更新
        ConsultationDO updateObj = ConsultationConvert.INSTANCE.convert(updateReqVO);
        consultationMapper.updateById(updateObj);
    }

    @Override
    public void deleteConsultation(Long id) {
        // 校验存在
        validateConsultationExists(id);
        // 删除
        consultationMapper.deleteById(id);
    }

    private void validateConsultationExists(Long id) {
        if (consultationMapper.selectById(id) == null) {
            throw exception(CONSULTATION_NOT_EXISTS);
        }
    }

    @Override
    public ConsultationDO getConsultation(Long id) {
        return consultationMapper.selectById(id);
    }

    @Override
    public List<ConsultationDO> getConsultationList(Collection<Long> ids) {
        return consultationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ConsultationDO> getConsultationPage(ConsultationPageReqVO pageReqVO) {
        return consultationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ConsultationDO> getConsultationList(ConsultationExportReqVO exportReqVO) {
        return consultationMapper.selectList(exportReqVO);
    }

}
