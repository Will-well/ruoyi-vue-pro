package cn.iocoder.yudao.module.system.service.information;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.information.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.information.InformationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.system.convert.information.InformationConvert;
import cn.iocoder.yudao.module.system.dal.mysql.information.InformationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 资讯 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationMapper informationMapper;

    @Override
    public Long createInformation(InformationCreateReqVO createReqVO) {
        // 插入
        InformationDO information = InformationConvert.INSTANCE.convert(createReqVO);
        informationMapper.insert(information);
        // 返回
        return information.getId();
    }

    @Override
    public void updateInformation(InformationUpdateReqVO updateReqVO) {
        // 校验存在
        validateInformationExists(updateReqVO.getId());
        // 更新
        InformationDO updateObj = InformationConvert.INSTANCE.convert(updateReqVO);
        informationMapper.updateById(updateObj);
    }

    @Override
    public void deleteInformation(Long id) {
        // 校验存在
        validateInformationExists(id);
        // 删除
        informationMapper.deleteById(id);
    }

    private void validateInformationExists(Long id) {
        if (informationMapper.selectById(id) == null) {
            throw exception(INFORMATION_NOT_EXISTS);
        }
    }

    @Override
    public InformationDO getInformation(Long id) {
        return informationMapper.selectById(id);
    }

    @Override
    public List<InformationDO> getInformationList(Collection<Long> ids) {
        return informationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<InformationDO> getInformationPage(InformationPageReqVO pageReqVO) {
        return informationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<InformationDO> getInformationList(InformationExportReqVO exportReqVO) {
        return informationMapper.selectList(exportReqVO);
    }

}
