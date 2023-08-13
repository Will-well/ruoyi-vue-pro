package cn.iocoder.yudao.module.system.controller.admin.consultation;

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

import cn.iocoder.yudao.module.system.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.consultation.ConsultationDO;
import cn.iocoder.yudao.module.system.convert.consultation.ConsultationConvert;
import cn.iocoder.yudao.module.system.service.consultation.ConsultationService;

@Tag(name = "管理后台 - 用户咨询")
@RestController
@RequestMapping("/system/consultation")
@Validated
public class ConsultationController {

    @Resource
    private ConsultationService consultationService;

    @PostMapping("/create")
    @Operation(summary = "创建用户咨询")
    @PreAuthorize("@ss.hasPermission('system:consultation:create')")
    public CommonResult<Long> createConsultation(@Valid @RequestBody ConsultationCreateReqVO createReqVO) {
        return success(consultationService.createConsultation(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户咨询")
    @PreAuthorize("@ss.hasPermission('system:consultation:update')")
    public CommonResult<Boolean> updateConsultation(@Valid @RequestBody ConsultationUpdateReqVO updateReqVO) {
        consultationService.updateConsultation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户咨询")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:consultation:delete')")
    public CommonResult<Boolean> deleteConsultation(@RequestParam("id") Long id) {
        consultationService.deleteConsultation(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得用户咨询")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:consultation:query')")
    public CommonResult<ConsultationRespVO> getConsultation(@RequestParam("id") Long id) {
        ConsultationDO consultation = consultationService.getConsultation(id);
        return success(ConsultationConvert.INSTANCE.convert(consultation));
    }

    @GetMapping("/list")
    @Operation(summary = "获得用户咨询列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:consultation:query')")
    public CommonResult<List<ConsultationRespVO>> getConsultationList(@RequestParam("ids") Collection<Long> ids) {
        List<ConsultationDO> list = consultationService.getConsultationList(ids);
        return success(ConsultationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得用户咨询分页")
    @PreAuthorize("@ss.hasPermission('system:consultation:query')")
    public CommonResult<PageResult<ConsultationRespVO>> getConsultationPage(@Valid ConsultationPageReqVO pageVO) {
        PageResult<ConsultationDO> pageResult = consultationService.getConsultationPage(pageVO);
        return success(ConsultationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出用户咨询 Excel")
    @PreAuthorize("@ss.hasPermission('system:consultation:export')")
    @OperateLog(type = EXPORT)
    public void exportConsultationExcel(@Valid ConsultationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ConsultationDO> list = consultationService.getConsultationList(exportReqVO);
        // 导出 Excel
        List<ConsultationExcelVO> datas = ConsultationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户咨询.xls", "数据", ConsultationExcelVO.class, datas);
    }

}
