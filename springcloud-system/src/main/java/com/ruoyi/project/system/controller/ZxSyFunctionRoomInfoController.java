package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.ZxSyFunctionRoomInfo;
import com.ruoyi.project.system.service.IZxSyFunctionRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能室管理Controller
 * 
 * @author suenle
 * @date 2020-03-01
 */
@RestController
@RequestMapping("/system/syFunctionRoomInfo")
public class ZxSyFunctionRoomInfoController extends BaseController
{
    @Autowired
    private IZxSyFunctionRoomInfoService zxSyFunctionRoomInfoService;

    /**
     * 查询功能室管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:syFunctionRoomInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZxSyFunctionRoomInfo zxSyFunctionRoomInfo)
    {
        startPage();
        List<ZxSyFunctionRoomInfo> list = zxSyFunctionRoomInfoService.selectZxSyFunctionRoomInfoList(zxSyFunctionRoomInfo);
        return getDataTable(list);
    }

    /**
     * 导出功能室管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:syFunctionRoomInfo:export')")
    @Log(title = "功能室管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZxSyFunctionRoomInfo zxSyFunctionRoomInfo)
    {
        List<ZxSyFunctionRoomInfo> list = zxSyFunctionRoomInfoService.selectZxSyFunctionRoomInfoList(zxSyFunctionRoomInfo);
        ExcelUtil<ZxSyFunctionRoomInfo> util = new ExcelUtil<ZxSyFunctionRoomInfo>(ZxSyFunctionRoomInfo.class);
        return util.exportExcel(list, "syFunctionRoomInfo");
    }

    /**
     * 获取功能室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:syFunctionRoomInfo:query')")
    @GetMapping(value = "/{roomId}")
    public AjaxResult getInfo(@PathVariable("roomId") Long roomId)
    {
        return AjaxResult.success(zxSyFunctionRoomInfoService.selectZxSyFunctionRoomInfoById(roomId));
    }

    /**
     * 新增功能室管理
     */
    @PreAuthorize("@ss.hasPermi('system:syFunctionRoomInfo:add')")
    @Log(title = "功能室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZxSyFunctionRoomInfo zxSyFunctionRoomInfo)
    {
        return toAjax(zxSyFunctionRoomInfoService.insertZxSyFunctionRoomInfo(zxSyFunctionRoomInfo));
    }

    /**
     * 修改功能室管理
     */
    @PreAuthorize("@ss.hasPermi('system:syFunctionRoomInfo:edit')")
    @Log(title = "功能室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZxSyFunctionRoomInfo zxSyFunctionRoomInfo)
    {
        return toAjax(zxSyFunctionRoomInfoService.updateZxSyFunctionRoomInfo(zxSyFunctionRoomInfo));
    }

    /**
     * 删除功能室管理
     */
    @PreAuthorize("@ss.hasPermi('system:syFunctionRoomInfo:remove')")
    @Log(title = "功能室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roomIds}")
    public AjaxResult remove(@PathVariable Long[] roomIds)
    {
        return toAjax(zxSyFunctionRoomInfoService.deleteZxSyFunctionRoomInfoByIds(roomIds));
    }
}
