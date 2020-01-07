package com.max.controller;

import com.max.pojo.Hero;
import com.max.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value="Hero MainController",tags={"英雄操作接口"})
@Controller
public class MainController {

    @Autowired
    private HeroService heroService;

    @ApiIgnore()
    @GetMapping("/main")
    public String main(Model model){
        List<Hero> allHero = heroService.getAllHero();
        model.addAttribute("allHero",allHero);
        return "main";
    }

    @ApiIgnore()
    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @ApiIgnore()
    @PostMapping("/addHero")
    public String addHero(Hero hero){
        heroService.insertHero(hero);
        return "redirect:/main";
    }

    /**
     * 请求路径相同 但请求方式不同
     * @param hero
     * @return
     */
    @ApiIgnore()
    @PutMapping("/addHero")
    public String editHero(Hero hero){
        heroService.updateHero(hero);
        return "redirect:/main";
    }


    /**
     * 参数绑定日期类型转换
     * @param dataBinder
     */
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder){

        dataBinder.registerCustomEditor(Date.class,new PropertyEditorSupport(){

            @Override
            public void setAsText(String value){
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch (ParseException e) {
                    setValue(null);

                }
            }
            @Override
            public String getAsText() {
                return new SimpleDateFormat("yyyy-MM-dd").format((Date)getValue());
            }

        });

    }


    @ApiIgnore()
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")Integer id,Model model){
//        //根据id获取记录
        Hero hero = heroService.getOneHero(id);
        model.addAttribute("hero",hero);

        return "add";
    }
    @ApiIgnore()
    @DeleteMapping("/edit/{id}")
    public String delete(@PathVariable("id")Integer id){

        heroService.deleteHero(id);

        return "redirect:/main";

    }


    /**
     * 测试Swagger2
     * @param id
     * @return
     */
    @ApiOperation(value="通过id获取用户信息",notes="注意问题点",httpMethod="GET")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "path")})
    @GetMapping("/test/{id}")
    @ResponseBody
    public Hero test(@PathVariable("id")Integer id){
//        //根据id获取记录
        return heroService.getOneHero(id);
    }


}
