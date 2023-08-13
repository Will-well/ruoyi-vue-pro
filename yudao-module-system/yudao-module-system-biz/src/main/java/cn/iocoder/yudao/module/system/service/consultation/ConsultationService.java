package cn.iocoder.yudao.module.system.service.consultation;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.consultation.ConsultationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 用户咨询 Service 接口
 *
 * @author 芋道源码
 */
public interface ConsultationService {

    /**
     * 创建用户咨询
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createConsultation(@Valid ConsultationCreateReqVO createReqVO);

    /**
     * 更新用户咨询
     *
     * @param updateReqVO 更新信息
     */
    void updateConsultation(@Valid ConsultationUpdateReqVO updateReqVO);

    /**
     * 删除用户咨询
     *
     * @param id 编号
     */
    void deleteConsultation(Long id);

    /**
     * 获得用户咨询
     *
     * @param id 编号
     * @return 用户咨询
     */
    ConsultationDO getConsultation(Long id);

    /**
     * 获得用户咨询列表
     *
     * @param ids 编号
     * @return 用户咨询列表
     */
    List<ConsultationDO> getConsultationList(Collection<Long> ids);

    /**
     * 获得用户咨询分页
     *
     * @param pageReqVO 分页查询
     * @return 用户咨询分页
     */
    PageResult<ConsultationDO> getConsultationPage(ConsultationPageReqVO pageReqVO);

    /**
     * 获得用户咨询列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 用户咨询列表
     */
    List<ConsultationDO> getConsultationList(ConsultationExportReqVO exportReqVO);

}
