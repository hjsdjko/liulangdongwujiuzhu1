package com.dao;

import com.entity.XinxifabuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinxifabuLiuyanView;

/**
 * 评价 Dao 接口
 *
 * @author 
 */
public interface XinxifabuLiuyanDao extends BaseMapper<XinxifabuLiuyanEntity> {

   List<XinxifabuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
