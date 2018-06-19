package zhhaizy.zhhaizy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zhhaizy.zhhaizy.domain.DrugCategory;
import zhhaizy.zhhaizy.domain.Result;
import zhhaizy.zhhaizy.service.DrugCategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author LL
 * 2018/5/17
 */
@Api(value = "药品分类")
@RestController
@RequestMapping(value = "/drugCategory")
public class DrugCategoryController {

    private static final org.slf4j.Logger LOG=LoggerFactory.getLogger("DrugCategoryController");

    @Autowired
    private DrugCategoryService drugCategoryService;

    @ApiOperation(value = "分页查询")
    @RequestMapping(method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页面大小",name = "size",paramType = "query"),
            @ApiImplicitParam(value = "当前页面",name = "page",paramType = "query")
    })
    private Page<DrugCategory> findByPage(final DrugCategory drugCategory, Pageable pageable){
        return drugCategoryService.findByPage(drugCategory,pageable);
    }

    @ApiOperation(value = "添加药品类型")
    @RequestMapping(method = RequestMethod.POST)
    private Result add(@Valid @RequestBody DrugCategory drugCategory, final BindingResult result){
        try {
            if (!result.hasErrors()){
                drugCategoryService.save(drugCategory);
                return  new Result("添加药品类型成功",1);
            }else {
                return new Result("添加药品类型失败",0);
            }
        }catch (Exception e){
            LOG.error("添加药品类型失败");
            return new Result("添加药品类型失败",0);
        }

    }

    @ApiOperation(value = "删除药品类型")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    private Result delete(@PathVariable Integer id,final BindingResult result){
        try {
            if (!result.hasErrors()){
                drugCategoryService.deleteById(id);
                return  new Result("删除药品分类成功",1);
            }else{
                return new Result("删除药品分类失败",0);
            }
        }catch (Exception e){
            LOG.error("删除药品分类失败",e);
            return new Result("删除药品分类失败",0);
        }

    }


    @ApiOperation(value = "查询所有药品类型")
    @RequestMapping(value = "findALl",method = RequestMethod.GET)
    private Result findAll(){
        List<DrugCategory> list=drugCategoryService.findAll();
        return new Result("查询成功",1,list);
    }
}
