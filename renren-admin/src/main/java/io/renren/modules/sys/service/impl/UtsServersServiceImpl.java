package io.renren.modules.sys.service.impl;

import io.renren.common.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.UtsServersDao;
import io.renren.modules.sys.entity.UtsServersEntity;
import io.renren.modules.sys.service.UtsServersService;


@Service("utsServersService")
public class UtsServersServiceImpl extends ServiceImpl<UtsServersDao, UtsServersEntity> implements UtsServersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //新建对象查询字段
        String projectId=(String)params.get("projectId");
        String serverName=(String)params.get("serverName");
        String serverCode=(String)params.get("serverCode");
        IPage<UtsServersEntity> page = this.page(
                new Query<UtsServersEntity>().getPage(params),
                new QueryWrapper<UtsServersEntity>()
                        //模糊查询对应字段
                .like(StringUtils.isNotBlank(projectId),"project_id",projectId)
                .like(StringUtils.isNotBlank(serverName),"server_name",serverName)
                .like(StringUtils.isNotBlank(serverCode),"server_code",serverCode)
                .apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);
    }

}
