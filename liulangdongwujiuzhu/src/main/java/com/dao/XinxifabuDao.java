package com.dao;

import com.entity.XinxifabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinxifabuView;

/**
 * 信息发布 Dao 接口
 *
 * @author 
 */
public interface XinxifabuDao extends BaseMapper<XinxifabuEntity> {

   List<XinxifabuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
