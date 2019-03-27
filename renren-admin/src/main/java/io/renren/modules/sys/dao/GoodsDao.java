package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.GoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品管理
 * 
 * @author will
 * @email goaskwill@163.com
 * @date 2019-03-26 10:30:15
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
	
}
