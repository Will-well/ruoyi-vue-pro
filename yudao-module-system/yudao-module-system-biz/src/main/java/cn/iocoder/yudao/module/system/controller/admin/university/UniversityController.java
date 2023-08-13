package cn.iocoder.yudao.module.system.controller.admin.university;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.system.controller.admin.university.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.university.UniversityDO;
import cn.iocoder.yudao.module.system.convert.university.UniversityConvert;
import cn.iocoder.yudao.module.system.service.university.UniversityService;

@Tag(name = "管理后台 - 学校")
@RestController
@RequestMapping("/system/university")
@Validated
public class UniversityController {

    @Resource
    private UniversityService universityService;

    @PostMapping("/create")
    @Operation(summary = "创建学校")
    @PreAuthorize("@ss.hasPermission('system:university:create')")
    public CommonResult<Long> createUniversity(@Valid @RequestBody UniversityCreateReqVO createReqVO) {
        return success(universityService.createUniversity(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新学校")
    @PreAuthorize("@ss.hasPermission('system:university:update')")
    public CommonResult<Boolean> updateUniversity(@Valid @RequestBody UniversityUpdateReqVO updateReqVO) {
        universityService.updateUniversity(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除学校")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:university:delete')")
    public CommonResult<Boolean> deleteUniversity(@RequestParam("id") Long id) {
        universityService.deleteUniversity(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得学校")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:university:query')")
    public CommonResult<UniversityRespVO> getUniversity(@RequestParam("id") Long id) {
        UniversityDO university = universityService.getUniversity(id);
        return success(UniversityConvert.INSTANCE.convert(university));
    }

    @GetMapping("/list")
    @Operation(summary = "获得学校列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:university:query')")
    public CommonResult<List<UniversityRespVO>> getUniversityList(@RequestParam("ids") Collection<Long> ids) {
        List<UniversityDO> list = universityService.getUniversityList(ids);
        return success(UniversityConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得学校分页")
    @PreAuthorize("@ss.hasPermission('system:university:query')")
    public CommonResult<PageResult<UniversityRespVO>> getUniversityPage(@Valid UniversityPageReqVO pageVO) {
        PageResult<UniversityDO> pageResult = universityService.getUniversityPage(pageVO);
        return success(UniversityConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出学校 Excel")
    @PreAuthorize("@ss.hasPermission('system:university:export')")
    @OperateLog(type = EXPORT)
    public void exportUniversityExcel(@Valid UniversityExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<UniversityDO> list = universityService.getUniversityList(exportReqVO);
        // 导出 Excel
        List<UniversityExcelVO> datas = UniversityConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "学校.xls", "数据", UniversityExcelVO.class, datas);
    }

}
