package cn.iocoder.yudao.module.system.controller.admin.wxuser;

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

import cn.iocoder.yudao.module.system.controller.admin.wxuser.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.wxuser.WxUserDO;
import cn.iocoder.yudao.module.system.convert.wxuser.WxUserConvert;
import cn.iocoder.yudao.module.system.service.wxuser.WxUserService;

@Tag(name = "管理后台 - wx用户")
@RestController
@RequestMapping("/system/wx-user")
@Validated
public class WxUserController {

    @Resource
    private WxUserService wxUserService;

    @PostMapping("/create")
    @Operation(summary = "创建wx用户")
    @PreAuthorize("@ss.hasPermission('system:wx-user:create')")
    public CommonResult<Long> createWxUser(@Valid @RequestBody WxUserCreateReqVO createReqVO) {
        return success(wxUserService.createWxUser(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新wx用户")
    @PreAuthorize("@ss.hasPermission('system:wx-user:update')")
    public CommonResult<Boolean> updateWxUser(@Valid @RequestBody WxUserUpdateReqVO updateReqVO) {
        wxUserService.updateWxUser(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除wx用户")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:wx-user:delete')")
    public CommonResult<Boolean> deleteWxUser(@RequestParam("id") Long id) {
        wxUserService.deleteWxUser(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得wx用户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:wx-user:query')")
    public CommonResult<WxUserRespVO> getWxUser(@RequestParam("id") Long id) {
        WxUserDO wxUser = wxUserService.getWxUser(id);
        return success(WxUserConvert.INSTANCE.convert(wxUser));
    }

    @GetMapping("/list")
    @Operation(summary = "获得wx用户列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('system:wx-user:query')")
    public CommonResult<List<WxUserRespVO>> getWxUserList(@RequestParam("ids") Collection<Long> ids) {
        List<WxUserDO> list = wxUserService.getWxUserList(ids);
        return success(WxUserConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得wx用户分页")
    @PreAuthorize("@ss.hasPermission('system:wx-user:query')")
    public CommonResult<PageResult<WxUserRespVO>> getWxUserPage(@Valid WxUserPageReqVO pageVO) {
        PageResult<WxUserDO> pageResult = wxUserService.getWxUserPage(pageVO);
        return success(WxUserConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出wx用户 Excel")
    @PreAuthorize("@ss.hasPermission('system:wx-user:export')")
    @OperateLog(type = EXPORT)
    public void exportWxUserExcel(@Valid WxUserExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<WxUserDO> list = wxUserService.getWxUserList(exportReqVO);
        // 导出 Excel
        List<WxUserExcelVO> datas = WxUserConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "wx用户.xls", "数据", WxUserExcelVO.class, datas);
    }

}
