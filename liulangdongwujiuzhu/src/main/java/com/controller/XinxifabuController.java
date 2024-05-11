








package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 信息发布
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinxifabu")
public class XinxifabuController {
    private static final Logger logger = LoggerFactory.getLogger(XinxifabuController.class);

    @Autowired
    private XinxifabuService xinxifabuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xinxifabuService.queryPage(params);

        //字典表数据转换
        List<XinxifabuView> list =(List<XinxifabuView>)page.getList();
        for(XinxifabuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinxifabuEntity xinxifabu = xinxifabuService.selectById(id);
        if(xinxifabu !=null){
            //entity转view
            XinxifabuView view = new XinxifabuView();
            BeanUtils.copyProperties( xinxifabu , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xinxifabu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XinxifabuEntity xinxifabu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinxifabu:{}",this.getClass().getName(),xinxifabu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            xinxifabu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<XinxifabuEntity> queryWrapper = new EntityWrapper<XinxifabuEntity>()
            .eq("xinxifabu_name", xinxifabu.getXinxifabuName())
            .eq("xinxifabu_types", xinxifabu.getXinxifabuTypes())
            .eq("yonghu_id", xinxifabu.getYonghuId())
            .eq("xinxifabu_address", xinxifabu.getXinxifabuAddress())
            .eq("chongwu_types", xinxifabu.getChongwuTypes())
            .eq("xinxi_types", xinxifabu.getXinxiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinxifabuEntity xinxifabuEntity = xinxifabuService.selectOne(queryWrapper);
        if(xinxifabuEntity==null){
            xinxifabu.setCreateTime(new Date());
            xinxifabuService.insert(xinxifabu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinxifabuEntity xinxifabu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xinxifabu:{}",this.getClass().getName(),xinxifabu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            xinxifabu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XinxifabuEntity> queryWrapper = new EntityWrapper<XinxifabuEntity>()
            .notIn("id",xinxifabu.getId())
            .andNew()
            .eq("xinxifabu_name", xinxifabu.getXinxifabuName())
            .eq("xinxifabu_types", xinxifabu.getXinxifabuTypes())
            .eq("yonghu_id", xinxifabu.getYonghuId())
            .eq("xinxifabu_address", xinxifabu.getXinxifabuAddress())
            .eq("chongwu_types", xinxifabu.getChongwuTypes())
            .eq("xinxi_types", xinxifabu.getXinxiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinxifabuEntity xinxifabuEntity = xinxifabuService.selectOne(queryWrapper);
        if("".equals(xinxifabu.getXinxifabuPhoto()) || "null".equals(xinxifabu.getXinxifabuPhoto())){
                xinxifabu.setXinxifabuPhoto(null);
        }
        if(xinxifabuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xinxifabu.set
            //  }
            xinxifabuService.updateById(xinxifabu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xinxifabuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XinxifabuEntity> xinxifabuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XinxifabuEntity xinxifabuEntity = new XinxifabuEntity();
//                            xinxifabuEntity.setXinxifabuName(data.get(0));                    //标题 要改的
//                            xinxifabuEntity.setXinxifabuTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            xinxifabuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //发布用户 要改的
//                            xinxifabuEntity.setXinxifabuPhoto("");//照片
//                            xinxifabuEntity.setXinxifabuAddress(data.get(0));                    //地点 要改的
//                            xinxifabuEntity.setChongwuTypes(Integer.valueOf(data.get(0)));   //宠物类型 要改的
//                            xinxifabuEntity.setXinxifabuTime(new Date(data.get(0)));          //时间 要改的
//                            xinxifabuEntity.setXinxiTypes(Integer.valueOf(data.get(0)));   //信息状态 要改的
//                            xinxifabuEntity.setXinxifabuContent("");//照片
//                            xinxifabuEntity.setCreateTime(date);//时间
                            xinxifabuList.add(xinxifabuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xinxifabuService.insertBatch(xinxifabuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = xinxifabuService.queryPage(params);

        //字典表数据转换
        List<XinxifabuView> list =(List<XinxifabuView>)page.getList();
        for(XinxifabuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinxifabuEntity xinxifabu = xinxifabuService.selectById(id);
            if(xinxifabu !=null){


                //entity转view
                XinxifabuView view = new XinxifabuView();
                BeanUtils.copyProperties( xinxifabu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinxifabu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XinxifabuEntity xinxifabu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinxifabu:{}",this.getClass().getName(),xinxifabu.toString());
        Wrapper<XinxifabuEntity> queryWrapper = new EntityWrapper<XinxifabuEntity>()
            .eq("xinxifabu_name", xinxifabu.getXinxifabuName())
            .eq("xinxifabu_types", xinxifabu.getXinxifabuTypes())
            .eq("yonghu_id", xinxifabu.getYonghuId())
            .eq("xinxifabu_address", xinxifabu.getXinxifabuAddress())
            .eq("chongwu_types", xinxifabu.getChongwuTypes())
            .eq("xinxi_types", xinxifabu.getXinxiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinxifabuEntity xinxifabuEntity = xinxifabuService.selectOne(queryWrapper);
        if(xinxifabuEntity==null){
            xinxifabu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      xinxifabu.set
        //  }
        xinxifabuService.insert(xinxifabu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



}
