package zhhaizy.zhhaizy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import zhhaizy.zhhaizy.domain.Drug;
import zhhaizy.zhhaizy.domain.Result;
import zhhaizy.zhhaizy.domain.User;
import zhhaizy.zhhaizy.service.DrugService;


import java.util.List;

/**
 * @author LL
 * 2018/5/17
 */
@Api(value = "药品")
@RestController
@RequestMapping(value = "/drug")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @ApiOperation(value = "分页查询")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页面大小",name = "size",paramType = "query"),
            @ApiImplicitParam(value = "当前页面",name = "page",paramType = "query")
    })
    private Page<Drug> findByPage(final Drug drug, Pageable pageable){
        return drugService.findByPage(drug,pageable);
    }

    @ApiOperation(value = "添加药品")
    @RequestMapping(method = RequestMethod.POST)
    private Result add(@RequestBody Drug drug){
        if (null!=drug){
            drugService.save(drug);
            return  new Result("success",1);
        }else {
            return new Result("fail",0);
        }
    }

    @ApiOperation(value = "删除药品")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    private Result delete(@PathVariable Integer id){
        if (null!=id){
            drugService.deleteById(id);
            return  new Result("success",1);
        }else{
            return new Result("fail",0);
        }
    }


    @ApiOperation(value = "查询所有药品")
    @RequestMapping(value = "findALl",method = RequestMethod.GET)
    private Result findAll(){
        List<Drug> list=drugService.findAll();
        return new Result("success",1,list);
    }
}
