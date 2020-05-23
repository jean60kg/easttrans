package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.domain.JlPartition;
import com.ruoyi.project.system.service.IJlPartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试Controller
 * 
 * @author suenle
 * @date 2020-03-12
 */
@RestController
@RequestMapping("/system/partition")
public class JlPartitionController extends BaseController
{
    @Autowired
    private IJlPartitionService jlPartitionService;

    /**
     * 查询测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:partition:list')")
    @GetMapping("/list")
    public AjaxResult list(JlPartition jlPartition)
    {
        List<JlPartition> list = jlPartitionService.selectJlPartitionList(jlPartition);
        return AjaxResult.success(list);
    }

    /**
     * 导出测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:partition:export')")
    @Log(title = "测试", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JlPartition jlPartition)
    {
        List<JlPartition> list = jlPartitionService.selectJlPartitionList(jlPartition);
        ExcelUtil<JlPartition> util = new ExcelUtil<JlPartition>(JlPartition.class);
        return util.exportExcel(list, "partition");
    }

    /**
     * 获取测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:partition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(jlPartitionService.selectJlPartitionById(id));
    }

    /**
     * 新增测试
     */
    @PreAuthorize("@ss.hasPermi('system:partition:add')")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JlPartition jlPartition)
    {
        return toAjax(jlPartitionService.insertJlPartition(jlPartition));
    }

    /**
     * 修改测试
     */
    @PreAuthorize("@ss.hasPermi('system:partition:edit')")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JlPartition jlPartition)
    {
        return toAjax(jlPartitionService.updateJlPartition(jlPartition));
    }

    /**
     * 删除测试
     */
    @PreAuthorize("@ss.hasPermi('system:partition:remove')")
    @Log(title = "测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jlPartitionService.deleteJlPartitionByIds(ids));
    }
}
