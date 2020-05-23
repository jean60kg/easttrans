package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.ZxSyLaboratoryInfo;
import com.ruoyi.project.system.service.IZxSyLaboratoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 试验室管理Controller
 * 
 * @author suenle
 * @date 2020-03-01
 */
@RestController
@RequestMapping("/system/syLaboratoryInfo")
public class ZxSyLaboratoryInfoController extends BaseController
{
    @Autowired
    private IZxSyLaboratoryInfoService zxSyLaboratoryInfoService;

    /**
     * 查询试验室管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:syLaboratoryInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZxSyLaboratoryInfo zxSyLaboratoryInfo)
    {
        startPage();
        List<ZxSyLaboratoryInfo> list = zxSyLaboratoryInfoService.selectZxSyLaboratoryInfoList(zxSyLaboratoryInfo);
        return getDataTable(list);
    }

    /**
     * 导出试验室管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:syLaboratoryInfo:export')")
    @Log(title = "试验室管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZxSyLaboratoryInfo zxSyLaboratoryInfo)
    {
        List<ZxSyLaboratoryInfo> list = zxSyLaboratoryInfoService.selectZxSyLaboratoryInfoList(zxSyLaboratoryInfo);
        ExcelUtil<ZxSyLaboratoryInfo> util = new ExcelUtil<ZxSyLaboratoryInfo>(ZxSyLaboratoryInfo.class);
        return util.exportExcel(list, "syLaboratoryInfo");
    }

    /**
     * 获取试验室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:syLaboratoryInfo:query')")
    @GetMapping(value = "/{laboratoryId}")
    public AjaxResult getInfo(@PathVariable("laboratoryId") Long laboratoryId)
    {
        return AjaxResult.success(zxSyLaboratoryInfoService.selectZxSyLaboratoryInfoById(laboratoryId));
    }

    /**
     * 新增试验室管理
     */
    @PreAuthorize("@ss.hasPermi('system:syLaboratoryInfo:add')")
    @Log(title = "试验室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZxSyLaboratoryInfo zxSyLaboratoryInfo)
    {
        return toAjax(zxSyLaboratoryInfoService.insertZxSyLaboratoryInfo(zxSyLaboratoryInfo));
    }

    /**
     * 修改试验室管理
     */
    @PreAuthorize("@ss.hasPermi('system:syLaboratoryInfo:edit')")
    @Log(title = "试验室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZxSyLaboratoryInfo zxSyLaboratoryInfo)
    {
        return toAjax(zxSyLaboratoryInfoService.updateZxSyLaboratoryInfo(zxSyLaboratoryInfo));
    }

    /**
     * 删除试验室管理
     */
    @PreAuthorize("@ss.hasPermi('system:syLaboratoryInfo:remove')")
    @Log(title = "试验室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{laboratoryIds}")
    public AjaxResult remove(@PathVariable Long[] laboratoryIds)
    {
        return toAjax(zxSyLaboratoryInfoService.deleteZxSyLaboratoryInfoByIds(laboratoryIds));
    }
}
