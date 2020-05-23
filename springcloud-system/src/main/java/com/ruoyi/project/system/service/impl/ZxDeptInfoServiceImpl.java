package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.domain.ZxDeptInfo;
import com.ruoyi.project.system.mapper.ZxDeptInfoMapper;
import com.ruoyi.project.system.service.IZxDeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门Service业务层处理
 * 
 * @author suenle
 * @date 2020-02-25
 */
@Service
public class ZxDeptInfoServiceImpl implements IZxDeptInfoService 
{
    @Autowired
    private ZxDeptInfoMapper zxDeptInfoMapper;

    /**
     * 查询部门
     * 
     * @param deptId 部门ID
     * @return 部门
     */
    @Override
    public ZxDeptInfo selectZxDeptInfoById(Long deptId)
    {
        return zxDeptInfoMapper.selectZxDeptInfoById(deptId);
    }

    /**
     * 查询部门列表
     * 
     * @param zxDeptInfo 部门
     * @return 部门
     */
    @Override
    public List<ZxDeptInfo> selectZxDeptInfoList(ZxDeptInfo zxDeptInfo)
    {
        return zxDeptInfoMapper.selectZxDeptInfoList(zxDeptInfo);
    }

    /**
     * 新增部门
     * 
     * @param zxDeptInfo 部门
     * @return 结果
     */
    @Override
    public int insertZxDeptInfo(ZxDeptInfo zxDeptInfo)
    {
        zxDeptInfo.setCreateTime(DateUtils.getNowDate());
        return zxDeptInfoMapper.insertZxDeptInfo(zxDeptInfo);
    }

    /**
     * 修改部门
     * 
     * @param zxDeptInfo 部门
     * @return 结果
     */
    @Override
    public int updateZxDeptInfo(ZxDeptInfo zxDeptInfo)
    {
        zxDeptInfo.setUpdateTime(DateUtils.getNowDate());
        return zxDeptInfoMapper.updateZxDeptInfo(zxDeptInfo);
    }

    /**
     * 批量删除部门
     * 
     * @param deptIds 需要删除的部门ID
     * @return 结果
     */
    @Override
    public int deleteZxDeptInfoByIds(Long[] deptIds)
    {
        return zxDeptInfoMapper.deleteZxDeptInfoByIds(deptIds);
    }

    /**
     * 删除部门信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    @Override
    public int deleteZxDeptInfoById(Long deptId)
    {
        return zxDeptInfoMapper.deleteZxDeptInfoById(deptId);
    }
}
