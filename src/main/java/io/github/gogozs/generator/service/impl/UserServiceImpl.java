/*
 * create by mybatis-plus-generator
 */
package io.github.gogozs.generator.service.impl;

import io.github.gogozs.generator.entity.User;
import io.github.gogozs.generator.mapper.UserMapper;
import io.github.gogozs.generator.service.UserDaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author zs
 * @since 2022-06-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserDaoService {

}
