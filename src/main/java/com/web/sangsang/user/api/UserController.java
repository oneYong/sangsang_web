package com.web.sangsang.user.api;

import com.web.sangsang.cmm.entity.SsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WYKIM on 2017-01-04.
 */
@RestController
@RequestMapping(value="/api/user")
@Api(value = "UserController", description = "User API")
public class UserController {

    @ApiOperation(value = "Get User Info")
    @RequestMapping(value="/find", method = RequestMethod.GET)
    public SsUser findUser(@RequestParam("source") String source, @RequestParam("sourceId") String sourceId){
        SsUser ssUser = new SsUser();
        ssUser.setSourceId(sourceId);
        ssUser.setSource(source);
        return ssUser;
    }
}
