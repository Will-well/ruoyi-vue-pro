package cn.iocoder.yudao.module.system.service.information;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.information.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.information.InformationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 资讯 Service 接口
 *
 * @author 芋道源码
 */
public interface InformationService {

    /**
     * 创建资讯
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInformation(@Valid InformationCreateReqVO createReqVO);

    /**
     * 更新资讯
     *
     * @param updateReqVO 更新信息
     */
    void updateInformation(@Valid InformationUpdateReqVO updateReqVO);

    /**
     * 删除资讯
     *
     * @param id 编号
     */
    void deleteInformation(Long id);

    /**
     * 获得资讯
     *
     * @param id 编号
     * @return 资讯
     */
    InformationDO getInformation(Long id);

    /**
     * 获得资讯列表
     *
     * @param ids 编号
     * @return 资讯列表
     */
    List<InformationDO> getInformationList(Collection<Long> ids);

    /**
     * 获得资讯分页
     *
     * @param pageReqVO 分页查询
     * @return 资讯分页
     */
    PageResult<InformationDO> getInformationPage(InformationPageReqVO pageReqVO);

    /**
     * 获得资讯列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 资讯列表
     */
    List<InformationDO> getInformationList(InformationExportReqVO exportReqVO);

}
