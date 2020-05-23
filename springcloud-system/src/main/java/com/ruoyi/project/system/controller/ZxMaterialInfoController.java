package com.ruoyi.project.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.ZxMaterialInfo;
import com.ruoyi.project.system.service.IZxMaterialInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 原材料评估Controller
 *
 * @author suenle
 * @date 2020-03-26
 */
@RestController
@RequestMapping("/system/materialInfo")
public class ZxMaterialInfoController extends BaseController {
    @Autowired
    private IZxMaterialInfoService zxMaterialInfoService;

    /**
     * 查询原材料评估列表
     */
    @PreAuthorize("@ss.hasPermi('system:materialInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZxMaterialInfo zxMaterialInfo) {
        startPage();
        QueryWrapper<ZxMaterialInfo> queryWrapper = new QueryWrapper<ZxMaterialInfo>();
        if (zxMaterialInfo.getDeptId() != null) {
            queryWrapper.eq("dept_id", zxMaterialInfo.getDeptId());
        }
        if (zxMaterialInfo.getParentId() != null) {
            queryWrapper.eq("parent_id", zxMaterialInfo.getParentId());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getMaterialType())) {
            queryWrapper.eq("material_type", zxMaterialInfo.getMaterialType());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getMaterialName())) {
            queryWrapper.like("material_name", zxMaterialInfo.getMaterialName());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getCompanyName())) {
            queryWrapper.like("company_name", zxMaterialInfo.getCompanyName());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getCompanyAddress())) {
            queryWrapper.eq("company_address", zxMaterialInfo.getCompanyAddress());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getBusinessScope())) {
            queryWrapper.eq("business_scope", zxMaterialInfo.getBusinessScope());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getProduction())) {
            queryWrapper.eq("production", zxMaterialInfo.getProduction());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getDistance())) {
            queryWrapper.eq("distance", zxMaterialInfo.getDistance());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getOtherDistance())) {
            queryWrapper.eq("other_distance", zxMaterialInfo.getOtherDistance());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getTransportation())) {
            queryWrapper.eq("transportation", zxMaterialInfo.getTransportation());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getStructure())) {
            queryWrapper.eq("structure", zxMaterialInfo.getStructure());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getDetailedType())) {
            queryWrapper.eq("detailed_type", zxMaterialInfo.getDetailedType());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getMaterialModel())) {
            queryWrapper.eq("material_model", zxMaterialInfo.getMaterialModel());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getIndicators())) {
            queryWrapper.eq("indicators", zxMaterialInfo.getIndicators());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getAttachment())) {
            queryWrapper.eq("attachment", zxMaterialInfo.getAttachment());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getRemark())) {
            queryWrapper.eq("remark", zxMaterialInfo.getRemark());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getStatus())) {
            queryWrapper.eq("status", zxMaterialInfo.getStatus());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getDelFlag())) {
            queryWrapper.eq("del_flag", zxMaterialInfo.getDelFlag());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getCreateBy())) {
            queryWrapper.like("create_by", zxMaterialInfo.getCreateBy());
        }
        if (StringUtils.isNotBlank(zxMaterialInfo.getUpdateBy())) {
            queryWrapper.eq("update_by", zxMaterialInfo.getUpdateBy());
        }
        if (zxMaterialInfo.getUpdateTime() != null) {
            queryWrapper.eq("update_time", zxMaterialInfo.getUpdateTime());
        }
        List<ZxMaterialInfo> list = zxMaterialInfoService.list(queryWrapper);
        return getDataTable(list);
    }

    /**
     * 导出原材料评估列表
     */
    @PreAuthorize("@ss.hasPermi('system:materialInfo:export')")
    @Log(title = "原材料评估", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZxMaterialInfo zxMaterialInfo) {
        QueryWrapper<ZxMaterialInfo> queryWrapper = new QueryWrapper<ZxMaterialInfo>(zxMaterialInfo);
        List<ZxMaterialInfo> list = zxMaterialInfoService.list(queryWrapper);
        ExcelUtil<ZxMaterialInfo> util = new ExcelUtil<ZxMaterialInfo>(ZxMaterialInfo.class);
        return util.exportExcel(list, "materialInfo");
    }

    /**
     * 获取原材料评估详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:materialInfo:query')")
    @GetMapping(value = "/{materialId}")
    public AjaxResult getInfo(@PathVariable("materialId") Long materialId) {
        return AjaxResult.success(zxMaterialInfoService.getById(materialId));
    }

    /**
     * 新增原材料评估
     */
    @PreAuthorize("@ss.hasPermi('system:materialInfo:add')")
    @Log(title = "原材料评估", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZxMaterialInfo zxMaterialInfo) {
        return toAjax(zxMaterialInfoService.save(zxMaterialInfo) ? 1 : 0);
    }

    /**
     * 修改原材料评估
     */
    @PreAuthorize("@ss.hasPermi('system:materialInfo:edit')")
    @Log(title = "原材料评估", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZxMaterialInfo zxMaterialInfo) {
        return toAjax(zxMaterialInfoService.updateById(zxMaterialInfo) ? 1 : 0);
    }

    /**
     * 删除原材料评估
     */
    @PreAuthorize("@ss.hasPermi('system:materialInfo:remove')")
    @Log(title = "原材料评估", businessType = BusinessType.DELETE)
    @DeleteMapping("/{materialIds}")
    public AjaxResult remove(@PathVariable Long[] materialIds) {
        return toAjax(zxMaterialInfoService.removeByIds(Arrays.asList(materialIds)) ? 1 : 0);
    }
}
