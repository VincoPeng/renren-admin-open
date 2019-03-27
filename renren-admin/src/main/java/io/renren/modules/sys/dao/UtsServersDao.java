package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.Project;
import io.renren.modules.sys.entity.UtsServersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author will
 * @email goaskwill@163.com
 * @date 2019-03-26 08:41:37
 */
@Mapper
public interface UtsServersDao extends BaseMapper<UtsServersEntity> {
    @Select("select project_id,project_name from tb_goods")
    List<Project> getprojects();
}
