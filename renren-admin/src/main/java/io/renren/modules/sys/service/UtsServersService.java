package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.UtsServersEntity;

import java.util.Map;

/**
 * 
 *
 * @author will
 * @email goaskwill@163.com
 * @date 2019-03-26 08:41:37
 */
public interface UtsServersService extends IService<UtsServersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

