//package com.kfc.hospital.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.kfc.hospital.entity.User;
//import com.kfc.hospital.mapper.UserMapper;
//import com.kfc.hospital.util.HttpRequestUtils;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// *   ckf on 2019/5/19.
// */
//@RestController
//@RequestMapping("/wechat")
//public class WeChatController {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    private UserMapper userMapper;
//
//    private String appid = "wx07305d3bbd9bf3f8";
//    private String callBack = "";
//    private String scope = "snsapi_base";
//    private String appsecret;
//
//    @RequestMapping("/login")
//    public CodeMessage index1() throws UnsupportedEncodingException {
//        //https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wx_appid+"&redirect_uri="+api.wx_reg+"&response_type=code&scope=snsapi_login,snsapi_userinfo&state=1,0#wechat_redirect
//        Map<String,Object> map = new HashMap();
//        String redirect_uri = URLEncoder.encode(callBack, "utf-8");
//        map.put("appid",appid);
//        map.put("scope",scope);
//        map.put("redirect_uri",redirect_uri);
//        return CodeMessage.SUCCESS(map);
//    }
//
//
//    @RequestMapping("/loginByCodeAndState"
//    public CodeMessage callBack(String code, String state,HttpServletResponse response) throws Exception{
//        //1.通过code获取access_token
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//        logger.info("进入授权回调,code:{},state:{}",code,state);
//        url = url.replace("APPID",appid).replace("SECRET",appsecret).replace("CODE",code);
//        String tokenInfoStr =  HttpRequestUtils.httpGet(url,null,null);
//        JSONObject tokenInfoObject = new JSONObject(tokenInfoStr);
//        logger.info("tokenInfoObject:{}",tokenInfoObject);
//        //2.通过access_token和openid获取用户信息
//        String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
//        userInfoUrl = userInfoUrl.replace("ACCESS_TOKEN",tokenInfoObject.getString("access_token")).replace("OPENID",tokenInfoObject.getString("openid"));
//        String userInfoStr =  HttpRequestUtils.httpGet(userInfoUrl,null,null);
//        logger.info("userInfoObject:{}",userInfoStr);
//        JSONObject userJson = new JSONObject(userInfoStr);
//        String nickname = userJson.getString("nickname");
//        String openid = userJson.getString("openid");
//        String headImgurl = userJson.getString("headimgurl");
//
//        // serach user
//        QueryWrapper qw = new QueryWrapper();
//        qw.eq("open_id",openid);
//        User user = userMapper.selectOne(qw);
//        if (user==null){
//            //insert
//            user = new User();
//            user.setHeadImage(headImgurl);
//            user.setWxName(nickname);
//            user.setPoint(0);
//            user.setOpenId(openid);
//            userMapper.insert(user);
//        }
//        Map map = new HashMap();
//        map.put("openid",openid);
//        map.put("nickname",nickname);
//        map.put("headImgurl",headImgurl);
//        return CodeMessage.SUCCESS(map);
//    }
//
//
//
//
//
//}
