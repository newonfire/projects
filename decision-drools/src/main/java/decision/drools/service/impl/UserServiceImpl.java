package decision.drools.service.impl;

import decision.drools.dao.UserMapper;
import decision.drools.model.User;
import decision.drools.service.UserService;
import decision.drools.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/03/20.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
