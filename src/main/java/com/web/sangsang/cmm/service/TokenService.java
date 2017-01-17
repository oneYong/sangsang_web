package com.web.sangsang.cmm.service;

import com.web.sangsang.cmm.entity.SsUser;
import com.web.sangsang.cmm.util.CmmAES256Util;
import com.web.sangsang.cmm.util.CmmUtil;
import com.web.sangsang.framework.exceptions.NotValidTokenException;
import com.web.sangsang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WYKIM on 2017-01-09.
 */
@Service
public class TokenService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CmmAES256Util cmmAES256Util;

    @Autowired
    private NotValidTokenException notValidTokenException;

    // token create
    public String createToken(MakeTokenInfo makeTokenInfo) throws Exception {
        String encodeStr = makeTokenInfo.toString();
        return cmmAES256Util.aesEncode(encodeStr);
    }

        // token decode to object
        private MakeTokenInfo parsingToken(String encodeStr) throws Exception {
            String decodeStr = cmmAES256Util.aesDecode(encodeStr);
            MakeTokenInfo makeTokenInfo = CmmUtil.jsonStringToObject(decodeStr,MakeTokenInfo.class);
            return makeTokenInfo;
        }

    // confirm user info
    public boolean isExistUser(String encodeStr) throws Exception {
        MakeTokenInfo makeTokenInfo = getMakeTokenInfo(encodeStr);

        String source = makeTokenInfo.getSource();
        String sourceId = makeTokenInfo.getSourceId();
        SsUser ssUser = userMapper.selectUser(source,sourceId);

        if(ssUser != null)
            return true;

        return false;
    }

        private MakeTokenInfo getMakeTokenInfo(String encodeStr) {
            MakeTokenInfo makeTokenInfo = null;
            try{
                makeTokenInfo = parsingToken(encodeStr);
            }catch (Exception e){
                throw notValidTokenException;
            }
            return makeTokenInfo;
        }
}
