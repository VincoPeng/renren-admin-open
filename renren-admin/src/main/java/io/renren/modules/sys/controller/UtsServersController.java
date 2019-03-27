package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.Project;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.UtsServersEntity;
import io.renren.modules.sys.service.UtsServersService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author will
 * @email goaskwill@163.com
 * @date 2019-03-26 08:41:37
 */
@RestController
@RequestMapping("sys/utsservers")
public class UtsServersController {
    @Autowired
    private UtsServersService utsServersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:utsservers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = utsServersService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:utsservers:info")
    public R info(@PathVariable("id") Long id){
        UtsServersEntity utsServers = utsServersService.getById(id);

        return R.ok().put("utsServers", utsServers);
    }

    /**
     * 获取项目信息
     */
    @RequestMapping("/getprojects")
    public R getProjects(){
        List<Project> projects = utsServersService.getprojects();
        return R.ok().put("projects", projects);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:utsservers:save")
    public R save(@RequestBody UtsServersEntity utsServers){
        utsServersService.save(utsServers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:utsservers:update")
    public R update(@RequestBody UtsServersEntity utsServers){
        ValidatorUtils.validateEntity(utsServers);
        utsServersService.updateById(utsServers);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:utsservers:delete")
    public R delete(@RequestBody Long[] ids){
        utsServersService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
