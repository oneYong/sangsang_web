package com.web.sangsang.user.service;

import com.web.sangsang.cmm.entity.SsUser;
import com.web.sangsang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WYKIM on 2017-01-09.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public SsUser registerUser(SsUser ssUser) throws Exception {
        SsUser existUser = userMapper.selectUser(ssUser.getSource(),ssUser.getSourceId());
        if(existUser != null){
            userMapper.updateUser(ssUser);
            ssUser.setResult("U");
        }else {
            userMapper.insertUser(ssUser);
            ssUser.setResult("I");
        }
        return ssUser;
    }
}
