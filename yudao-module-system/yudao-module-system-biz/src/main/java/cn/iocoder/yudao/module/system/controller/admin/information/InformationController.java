package cn.iocoder.yudao.module.system.controller.admin.information;

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

import cn.iocoder.yudao.module.system.controller.admin.information.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.information.InformationDO;
import cn.iocoder.yudao.module.system.convert.information.InformationConvert;
import cn.iocoder.yudao.module.system.service.information.InformationService;

@Tag(name = "管理后台 - 资讯")
@RestController
@RequestMapping("/system/information")
@Validated
public class InformationController {

    @Resource
    private InformationService informationService;

    @PostMapping("/create")
    @Operation(summary = "创建资讯")
    @PreAuthorize("@ss.hasPermission('system:information:create')")
    public CommonResult<Long> createInformation(@Valid @RequestBody InformationCreateReqVO createReqVO) {
        return success(informationService.createInformation(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新资讯")
    @PreAuthorize("@ss.hasPermission('system:information:update')")
    public CommonResult<Boolean> updateInformation(@Valid @RequestBody InformationUpdateReqVO updateReqVO) {
        informationService.updateInformation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除资讯")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:information:delete')")
    public CommonResult<Boolean> deleteInformation(@RequestParam("id") Long id) {
        informationService.deleteInformation(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得资讯")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:information:query')")
    public CommonResult<InformationRespVO> getInformation(@RequestParam("id") Long id) {
        InformationDO information = informationService.getInformation(id);
        return success(InformationConvert.INSTANCE.convert(information));
    }

    @GetMapping("/list")
    @Operation(summary = "获得资讯列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:information:query')")
    public CommonResult<List<InformationRespVO>> getInformationList(@RequestParam("ids") Collection<Long> ids) {
        List<InformationDO> list = informationService.getInformationList(ids);
        return success(InformationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得资讯分页")
    @PreAuthorize("@ss.hasPermission('system:information:query')")
    public CommonResult<PageResult<InformationRespVO>> getInformationPage(@Valid InformationPageReqVO pageVO) {
        PageResult<InformationDO> pageResult = informationService.getInformationPage(pageVO);
        return success(InformationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出资讯 Excel")
    @PreAuthorize("@ss.hasPermission('system:information:export')")
    @OperateLog(type = EXPORT)
    public void exportInformationExcel(@Valid InformationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<InformationDO> list = informationService.getInformationList(exportReqVO);
        // 导出 Excel
        List<InformationExcelVO> datas = InformationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "资讯.xls", "数据", InformationExcelVO.class, datas);
    }

}
