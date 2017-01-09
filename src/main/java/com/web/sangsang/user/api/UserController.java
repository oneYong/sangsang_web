package com.web.sangsang.user.api;

import com.web.sangsang.cmm.entity.SsUser;
import com.web.sangsang.mapper.UserMapper;
import com.web.sangsang.user.service.UserService;
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
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "Get User Info")
    @RequestMapping(value="/find", method = RequestMethod.GET)
    public SsUser findUser(@RequestParam("source") String source, @RequestParam("sourceId") String sourceId) throws Exception{
       return userMapper.selectUser(source,sourceId);
    }

    @ApiOperation(value = "Get User Info")
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public SsUser updateUser(@RequestBody SsUser ssUser) throws Exception{
        return userService.registerUser(ssUser);
    }
}
