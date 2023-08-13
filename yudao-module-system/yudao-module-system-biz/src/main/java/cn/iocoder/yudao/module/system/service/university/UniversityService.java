package cn.iocoder.yudao.module.system.service.university;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.university.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.university.UniversityDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 学校 Service 接口
 *
 * @author 芋道源码
 */
public interface UniversityService {

    /**
     * 创建学校
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUniversity(@Valid UniversityCreateReqVO createReqVO);

    /**
     * 更新学校
     *
     * @param updateReqVO 更新信息
     */
    void updateUniversity(@Valid UniversityUpdateReqVO updateReqVO);

    /**
     * 删除学校
     *
     * @param id 编号
     */
    void deleteUniversity(Long id);

    /**
     * 获得学校
     *
     * @param id 编号
     * @return 学校
     */
    UniversityDO getUniversity(Long id);

    /**
     * 获得学校列表
     *
     * @param ids 编号
     * @return 学校列表
     */
    List<UniversityDO> getUniversityList(Collection<Long> ids);

    /**
     * 获得学校分页
     *
     * @param pageReqVO 分页查询
     * @return 学校分页
     */
    PageResult<UniversityDO> getUniversityPage(UniversityPageReqVO pageReqVO);

    /**
     * 获得学校列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 学校列表
     */
    List<UniversityDO> getUniversityList(UniversityExportReqVO exportReqVO);

}
