package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.domain.ZxFileInfo;
import com.ruoyi.project.system.mapper.ZxFileInfoMapper;
import com.ruoyi.project.system.service.IZxFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件管理Service业务层处理
 * 
 * @author suenle
 * @date 2020-03-21
 */
@Service
public class ZxFileInfoServiceImpl implements IZxFileInfoService
{
    @Autowired
    private ZxFileInfoMapper zxFileInfoMapper;

    /**
     * 查询文件管理
     * 
     * @param fileId 文件管理ID
     * @return 文件管理
     */
    @Override
    public ZxFileInfo selectZxFileInfoById(Long fileId)
    {
        return zxFileInfoMapper.selectZxFileInfoById(fileId);
    }

    /**
     * 查询文件管理列表
     * 
     * @param zxFileInfo 文件管理
     * @return 文件管理
     */
    @Override
    public List<ZxFileInfo> selectZxFileInfoList(ZxFileInfo zxFileInfo)
    {
        return zxFileInfoMapper.selectZxFileInfoList(zxFileInfo);
    }

    /**
     * 新增文件管理
     * 
     * @param zxFileInfo 文件管理
     * @return 结果
     */
    @Override
    public int insertZxFileInfo(ZxFileInfo zxFileInfo)
    {
        zxFileInfo.setCreateTime(DateUtils.getNowDate());
        return zxFileInfoMapper.insertZxFileInfo(zxFileInfo);
    }

    /**
     * 修改文件管理
     * 
     * @param zxFileInfo 文件管理
     * @return 结果
     */
    @Override
    public int updateZxFileInfo(ZxFileInfo zxFileInfo)
    {
        zxFileInfo.setUpdateTime(DateUtils.getNowDate());
        return zxFileInfoMapper.updateZxFileInfo(zxFileInfo);
    }

    /**
     * 批量删除文件管理
     * 
     * @param fileIds 需要删除的文件管理ID
     * @return 结果
     */
    @Override
    public int deleteZxFileInfoByIds(Long[] fileIds)
    {
        return zxFileInfoMapper.deleteZxFileInfoByIds(fileIds);
    }

    /**
     * 删除文件管理信息
     * 
     * @param fileId 文件管理ID
     * @return 结果
     */
    @Override
    public int deleteZxFileInfoById(Long fileId)
    {
        return zxFileInfoMapper.deleteZxFileInfoById(fileId);
    }
}
