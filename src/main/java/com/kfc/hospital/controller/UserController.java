package com.kfc.hospital.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kfc.hospital.entity.User;
import com.kfc.hospital.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   ckf on 2019/5/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;


    @PostMapping("/insertUser")
    public Map insertUser(User user){
        String time = String.valueOf(System.currentTimeMillis());
        String id = time.substring(time.length()-6,time.length());
        user.setId(Integer.valueOf(id));
        userMapper.insert(user);
        Map map = new HashMap();
        map.put("state","0");
        return map;
    }

    @PostMapping("/insertPoint")
    public Map insertPoint(Integer id,Integer point){
        User user = new User();
        user.setId(id);
        user.setPoint(point);
        userMapper.updateById(user);
        Map map = new HashMap();
        map.put("state","0");
        return map;
    }

    @GetMapping("/getPoint")
    public IPage<User> queryPoint(@RequestParam(defaultValue = "0") Integer index, @RequestParam(defaultValue = "10")Integer size){
        Page<User> page = new Page<>(index,size);
        QueryWrapper qw = new QueryWrapper();
        qw.orderByDesc("point");
        IPage<User> iPage = userMapper.selectPage(page,qw);
        List<User> list = iPage.getRecords();
        for (int i=0;i<list.size();i++){
            list.get(i).setMingci(i+1);
        }
        return iPage;
    }
}
