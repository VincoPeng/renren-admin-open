package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.GoodsEntity;

import java.util.Map;

/**
 * 商品管理
 *
 * @author will
 * @email goaskwill@163.com
 * @date 2019-03-26 10:30:15
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

