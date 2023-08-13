package cn.iocoder.yudao.module.system.service.major;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.major.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.major.MajorDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 专业 Service 接口
 *
 * @author 芋道源码
 */
public interface MajorService {

    /**
     * 创建专业
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMajor(@Valid MajorCreateReqVO createReqVO);

    /**
     * 更新专业
     *
     * @param updateReqVO 更新信息
     */
    void updateMajor(@Valid MajorUpdateReqVO updateReqVO);

    /**
     * 删除专业
     *
     * @param id 编号
     */
    void deleteMajor(Long id);

    /**
     * 获得专业
     *
     * @param id 编号
     * @return 专业
     */
    MajorDO getMajor(Long id);

    /**
     * 获得专业列表
     *
     * @param ids 编号
     * @return 专业列表
     */
    List<MajorDO> getMajorList(Collection<Long> ids);

    /**
     * 获得专业分页
     *
     * @param pageReqVO 分页查询
     * @return 专业分页
     */
    PageResult<MajorDO> getMajorPage(MajorPageReqVO pageReqVO);

    /**
     * 获得专业列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 专业列表
     */
    List<MajorDO> getMajorList(MajorExportReqVO exportReqVO);

}
