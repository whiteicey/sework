package pers.se.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pers.se.entity.User;
import pers.se.mapper.UserMapper;
import pers.se.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
    // @Autowired
    // private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAll() { 
        return userService.list();
    } 

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeByIds(ids);
    }

    // @GetMapping("/page")
    // public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String username) {
    //     pageNum = (pageNum - 1) * pageSize;
    //     username = "%" + username + "%";
    //     List<User> data = userMapper.selectPage(pageNum, pageSize, username);
    //     Integer total = userMapper.selectTotal(username);
    //     Map<String, Object> res = new HashMap<>();
    //     res.put("data",data);
    //     res.put("total",total);
    //     return res;
    // }

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum, 
                                @RequestParam Integer pageSize, 
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String nickname,
                                @RequestParam(defaultValue = "") String address) {
        IPage<User> page = new Page<User>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)) {
            queryWrapper.like("username", username);
        }
        else if(!"".equals(nickname)){
            queryWrapper.like("nickname",nickname);
        }
        else if(!"".equals(address)){
            queryWrapper.like("address",address);
        }
        // queryWrapper.or().like("username", username);
        queryWrapper.orderByDesc("id");
        return userService.page(page, queryWrapper);
    }

}
