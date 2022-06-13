/*
 * create by mybatis-plus-generator
 */
package io.github.gogozs.generator.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.github.gogozs.generator.entity.User;
import io.github.gogozs.generator.service.UserDaoService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author zs
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/api/v1/User")
public class UserController {

    @Resource
    private UserDaoService UserDaoService;

    /**
    * 分页查询
    *
    * @param pageQuery  分页对象
    * @return 查询结果
    */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(@RequestParam Page<User> pageQuery) {
        return ResponseEntity.ok(this.UserDaoService.page(pageQuery));
    }

    /**
    * 通过主键查询单条数据
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.UserDaoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param t_user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Boolean> add(@RequestBody User t_user) {
        return ResponseEntity.ok(this.UserDaoService.save(t_user));
    }

    /**
     * 编辑数据
     *
     * @param t_user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Boolean> edit(@RequestBody User t_user) {
        return ResponseEntity.ok(this.UserDaoService.updateById(t_user));
    }

    /**
    * 删除数据
    *
    * @param id 主键
    * @return 删除是否成功
    */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id){
        return ResponseEntity.ok(this.UserDaoService.removeById(id));
    }

}

