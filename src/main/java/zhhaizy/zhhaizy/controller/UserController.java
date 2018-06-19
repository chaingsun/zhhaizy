package zhhaizy.zhhaizy.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zhhaizy.zhhaizy.domain.Result;
import zhhaizy.zhhaizy.domain.User;
import zhhaizy.zhhaizy.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
@Api(value = "用户")
public class UserController {

    private static final Logger LOG=LoggerFactory.getLogger("UserController");

    @Autowired
    private UserService userService;

    @ApiOperation(value = "分页查询")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页面大小",name = "size",paramType = "query"),
            @ApiImplicitParam(value = "当前页面",name = "page",paramType = "query")
    })
    private Page<User> findByPage(final User user, Pageable pageable){
        return userService.findByPage(user,pageable);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(method = RequestMethod.POST)
    private Result add(@Valid @RequestBody User user, final BindingResult result){
      try {
          if (!result.hasErrors()){
              userService.save(user);
              return  new Result("添加用户成功",1);
          }else {
              return new Result("添加用户失败",0);
          }
      }catch (Exception e){
            LOG.error("添加用户失败",e);
            return  new Result("添加用户失败",0);
      }

    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    private Result delete(@PathVariable Integer id){
        if (null!=id){
            userService.deleteById(id);
            return  new Result("success",1);
        }else{
            return new Result("fail",0);
        }
    }


    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "findALl",method = RequestMethod.GET)
    private Result findAll(){
        List<User> list=userService.findAll();
        return new Result("success",1,list);
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "updatePwd",method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户ID",name = "id",paramType = "form",required = true),
            @ApiImplicitParam(value = "旧密码",name = "oldPwd",paramType = "form",required = true),
            @ApiImplicitParam(value = "新密码",name = "newPwd",paramType = "form",required = true),
    })
    public Result updatePwd(Integer  id,String newPwd,String oldPwd){
        Optional<User> user=userService.findById(id);
        User one=user.get();
        if(oldPwd.equals(one.getPassword())){
            int  resutl=userService.updatePwd(newPwd,id);
            if (resutl==1){
                return new Result("success",1);
            }else {
                return new Result("fail",0);
            }
        }else {
            return new Result("密码错误",0);
        }
    }

    @ApiOperation(value = "注册")
    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public Result regist(String name,String password){

        return null;
    }
}
