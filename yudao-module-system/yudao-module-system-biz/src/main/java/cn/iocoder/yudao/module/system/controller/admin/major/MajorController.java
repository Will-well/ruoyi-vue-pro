package cn.iocoder.yudao.module.system.controller.admin.major;

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

import cn.iocoder.yudao.module.system.controller.admin.major.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.major.MajorDO;
import cn.iocoder.yudao.module.system.convert.major.MajorConvert;
import cn.iocoder.yudao.module.system.service.major.MajorService;

@Tag(name = "管理后台 - 专业")
@RestController
@RequestMapping("/system/major")
@Validated
public class MajorController {

    @Resource
    private MajorService majorService;

    @PostMapping("/create")
    @Operation(summary = "创建专业")
    @PreAuthorize("@ss.hasPermission('system:major:create')")
    public CommonResult<Long> createMajor(@Valid @RequestBody MajorCreateReqVO createReqVO) {
        return success(majorService.createMajor(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新专业")
    @PreAuthorize("@ss.hasPermission('system:major:update')")
    public CommonResult<Boolean> updateMajor(@Valid @RequestBody MajorUpdateReqVO updateReqVO) {
        majorService.updateMajor(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除专业")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:major:delete')")
    public CommonResult<Boolean> deleteMajor(@RequestParam("id") Long id) {
        majorService.deleteMajor(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得专业")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:major:query')")
    public CommonResult<MajorRespVO> getMajor(@RequestParam("id") Long id) {
        MajorDO major = majorService.getMajor(id);
        return success(MajorConvert.INSTANCE.convert(major));
    }

    @GetMapping("/list")
    @Operation(summary = "获得专业列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:major:query')")
    public CommonResult<List<MajorRespVO>> getMajorList(@RequestParam("ids") Collection<Long> ids) {
        List<MajorDO> list = majorService.getMajorList(ids);
        return success(MajorConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得专业分页")
    @PreAuthorize("@ss.hasPermission('system:major:query')")
    public CommonResult<PageResult<MajorRespVO>> getMajorPage(@Valid MajorPageReqVO pageVO) {
        PageResult<MajorDO> pageResult = majorService.getMajorPage(pageVO);
        return success(MajorConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出专业 Excel")
    @PreAuthorize("@ss.hasPermission('system:major:export')")
    @OperateLog(type = EXPORT)
    public void exportMajorExcel(@Valid MajorExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MajorDO> list = majorService.getMajorList(exportReqVO);
        // 导出 Excel
        List<MajorExcelVO> datas = MajorConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "专业.xls", "数据", MajorExcelVO.class, datas);
    }

}
