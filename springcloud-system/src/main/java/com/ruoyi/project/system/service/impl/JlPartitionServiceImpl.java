package com.ruoyi.project.system.service.impl;

import com.ruoyi.project.system.domain.JlPartition;
import com.ruoyi.project.system.mapper.JlPartitionMapper;
import com.ruoyi.project.system.service.IJlPartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试Service业务层处理
 * 
 * @author suenle
 * @date 2020-03-12
 */
@Service
public class JlPartitionServiceImpl implements IJlPartitionService 
{
    @Autowired
    private JlPartitionMapper jlPartitionMapper;

    /**
     * 查询测试
     * 
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public JlPartition selectJlPartitionById(Long id)
    {
        return jlPartitionMapper.selectJlPartitionById(id);
    }

    /**
     * 查询测试列表
     * 
     * @param jlPartition 测试
     * @return 测试
     */
    @Override
    public List<JlPartition> selectJlPartitionList(JlPartition jlPartition)
    {
        return jlPartitionMapper.selectJlPartitionList(jlPartition);
    }

    /**
     * 新增测试
     * 
     * @param jlPartition 测试
     * @return 结果
     */
    @Override
    public int insertJlPartition(JlPartition jlPartition)
    {
        return jlPartitionMapper.insertJlPartition(jlPartition);
    }

    /**
     * 修改测试
     * 
     * @param jlPartition 测试
     * @return 结果
     */
    @Override
    public int updateJlPartition(JlPartition jlPartition)
    {
        return jlPartitionMapper.updateJlPartition(jlPartition);
    }

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的测试ID
     * @return 结果
     */
    @Override
    public int deleteJlPartitionByIds(Long[] ids)
    {
        return jlPartitionMapper.deleteJlPartitionByIds(ids);
    }

    /**
     * 删除测试信息
     * 
     * @param id 测试ID
     * @return 结果
     */
    @Override
    public int deleteJlPartitionById(Long id)
    {
        return jlPartitionMapper.deleteJlPartitionById(id);
    }
}
