package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.domain.ZxSecInfo;
import com.ruoyi.project.system.mapper.ZxSecInfoMapper;
import com.ruoyi.project.system.service.IZxSecInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标段信息Service业务层处理
 * 
 * @author suenle
 * @date 2020-02-25
 */
@Service
public class ZxSecInfoServiceImpl implements IZxSecInfoService 
{
    @Autowired
    private ZxSecInfoMapper zxSecInfoMapper;

    /**
     * 查询标段信息
     * 
     * @param deptId 标段信息ID
     * @return 标段信息
     */
    @Override
    public ZxSecInfo selectZxSecInfoById(Long deptId)
    {
        return zxSecInfoMapper.selectZxSecInfoById(deptId);
    }

    /**
     * 查询标段信息列表
     * 
     * @param zxSecInfo 标段信息
     * @return 标段信息
     */
    @Override
    public List<ZxSecInfo> selectZxSecInfoList(ZxSecInfo zxSecInfo)
    {
        return zxSecInfoMapper.selectZxSecInfoList(zxSecInfo);
    }

    /**
     * 新增标段信息
     * 
     * @param zxSecInfo 标段信息
     * @return 结果
     */
    @Override
    public int insertZxSecInfo(ZxSecInfo zxSecInfo)
    {
        zxSecInfo.setCreateTime(DateUtils.getNowDate());
        return zxSecInfoMapper.insertZxSecInfo(zxSecInfo);
    }

    /**
     * 修改标段信息
     * 
     * @param zxSecInfo 标段信息
     * @return 结果
     */
    @Override
    public int updateZxSecInfo(ZxSecInfo zxSecInfo)
    {
        zxSecInfo.setUpdateTime(DateUtils.getNowDate());
        return zxSecInfoMapper.updateZxSecInfo(zxSecInfo);
    }

    /**
     * 批量删除标段信息
     * 
     * @param deptIds 需要删除的标段信息ID
     * @return 结果
     */
    @Override
    public int deleteZxSecInfoByIds(Long[] deptIds)
    {
        return zxSecInfoMapper.deleteZxSecInfoByIds(deptIds);
    }

    /**
     * 删除标段信息信息
     * 
     * @param deptId 标段信息ID
     * @return 结果
     */
    @Override
    public int deleteZxSecInfoById(Long deptId)
    {
        return zxSecInfoMapper.deleteZxSecInfoById(deptId);
    }
}
