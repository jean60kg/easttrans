package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.ZxSecInfo;
import com.ruoyi.project.system.service.IZxSecInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标段信息Controller
 * 
 * @author suenle
 * @date 2020-02-25
 */
@RestController
@RequestMapping("/system/secInfo")
public class ZxSecInfoController extends BaseController
{
    @Autowired
    private IZxSecInfoService zxSecInfoService;

    /**
     * 查询标段信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:secInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZxSecInfo zxSecInfo)
    {
        startPage();
        List<ZxSecInfo> list = zxSecInfoService.selectZxSecInfoList(zxSecInfo);
        return getDataTable(list);
    }

    /**
     * 导出标段信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:secInfo:export')")
    @Log(title = "标段信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZxSecInfo zxSecInfo)
    {
        List<ZxSecInfo> list = zxSecInfoService.selectZxSecInfoList(zxSecInfo);
        ExcelUtil<ZxSecInfo> util = new ExcelUtil<ZxSecInfo>(ZxSecInfo.class);
        return util.exportExcel(list, "secInfo");
    }

    /**
     * 获取标段信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:secInfo:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(zxSecInfoService.selectZxSecInfoById(deptId));
    }

    /**
     * 新增标段信息
     */
    @PreAuthorize("@ss.hasPermi('system:secInfo:add')")
    @Log(title = "标段信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZxSecInfo zxSecInfo)
    {
        return toAjax(zxSecInfoService.insertZxSecInfo(zxSecInfo));
    }

    /**
     * 修改标段信息
     */
    @PreAuthorize("@ss.hasPermi('system:secInfo:edit')")
    @Log(title = "标段信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZxSecInfo zxSecInfo)
    {
        return toAjax(zxSecInfoService.updateZxSecInfo(zxSecInfo));
    }

    /**
     * 删除标段信息
     */
    @PreAuthorize("@ss.hasPermi('system:secInfo:remove')")
    @Log(title = "标段信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(zxSecInfoService.deleteZxSecInfoByIds(deptIds));
    }
}
