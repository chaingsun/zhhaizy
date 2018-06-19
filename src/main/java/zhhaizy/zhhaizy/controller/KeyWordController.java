package zhhaizy.zhhaizy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import zhhaizy.zhhaizy.domain.KeyWord;
import zhhaizy.zhhaizy.domain.Result;
import zhhaizy.zhhaizy.domain.User;
import zhhaizy.zhhaizy.service.KeyWordService;
import zhhaizy.zhhaizy.service.UserService;

import java.util.List;

/**
 * @author LL
 * 2018/5/17
 */
@Api(value = "关键字")
@RestController
@RequestMapping(value = "/keyWord")
public class KeyWordController {
    @Autowired
    private KeyWordService keyWordService;

    @ApiOperation(value = "分页查询")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页面大小",name = "size",paramType = "query"),
            @ApiImplicitParam(value = "当前页面",name = "page",paramType = "query")
    })
    private Page<KeyWord> findByPage(final KeyWord keyWord, Pageable pageable){
        return keyWordService.findByPage(keyWord,pageable);
    }

    @ApiOperation(value = "添加关键字")
    @RequestMapping(method = RequestMethod.POST)
    private Result add(@RequestBody KeyWord keyWord){
        if (null!=keyWord){
            keyWordService.save(keyWord);
            return  new Result("success",1);
        }else {
            return new Result("fail",0);
        }
    }

    @ApiOperation(value = "删除关键字")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    private Result delete(@PathVariable Integer id){
        if (null!=id){
            keyWordService.deleteById(id);
            return  new Result("success",1);
        }else{
            return new Result("fail",0);
        }
    }


    @ApiOperation(value = "查询所有关键字")
    @RequestMapping(value = "findALl",method = RequestMethod.GET)
    private Result findAll(){
        List<KeyWord> list=keyWordService.findAll();
        return new Result("success",1,list);
    }
}