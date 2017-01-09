package com.web.sangsang.user.api;

import com.web.sangsang.cmm.entity.SsUser;
import com.web.sangsang.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RestController
@RequestMapping(value="/api/user")
@Api(value = "UserController", description = "User API")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "Get User Info")
    @RequestMapping(value="/find", method = RequestMethod.GET)
    public SsUser findUser(@RequestParam("source") String source, @RequestParam("sourceId") String sourceId) throws Exception{
       return userMapper.selectUser(source,sourceId);
    }
}
