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
import zhhaizy.zhhaizy.domain.DrugSeries;
import zhhaizy.zhhaizy.domain.Result;
import zhhaizy.zhhaizy.service.DrugSeriesService;
import zhhaizy.zhhaizy.service.DrugService;

import java.util.List;

/**
 * @author LL
 * 2018/5/17
 */
@Api(value = "药品系列")
@RestController
@RequestMapping(value = "/drugSeries")
public class DrugSeriesController {

    @Autowired
    private DrugSeriesService drugSeriesService;

    @ApiOperation(value = "分页查询")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页面大小",name = "size",paramType = "query"),
            @ApiImplicitParam(value = "当前页面",name = "page",paramType = "query")
    })
    private Page<DrugSeries> findByPage(final DrugSeries drugSeries, Pageable pageable){
        return drugSeriesService.findByPage(drugSeries,pageable);
    }

    @ApiOperation(value = "添加药品系列")
    @RequestMapping(method = RequestMethod.POST)
    private Result add(@RequestBody DrugSeries drugSeries){
        if (null!=drugSeries){
            drugSeriesService.save(drugSeries);
            return  new Result("success",1);
        }else {
            return new Result("fail",0);
        }
    }

    @ApiOperation(value = "删除药品系列")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    private Result delete(@PathVariable Integer id){
        if (null!=id){
            drugSeriesService.deleteById(id);
            return  new Result("success",1);
        }else{
            return new Result("fail",0);
        }
    }


    @ApiOperation(value = "查询所有药品系列")
    @RequestMapping(value = "findALl",method = RequestMethod.GET)
    private Result findAll(){
        List<DrugSeries> list=drugSeriesService.findAll();
        return new Result("success",1,list);
    }
}
