package com.entity.model;

import com.entity.XinxifabuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 信息发布
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinxifabuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String xinxifabuName;


    /**
     * 类型
     */
    private Integer xinxifabuTypes;


    /**
     * 发布用户
     */
    private Integer yonghuId;


    /**
     * 图片
     */
    private String xinxifabuPhoto;


    /**
     * 地点
     */
    private String xinxifabuAddress;


    /**
     * 宠物类型
     */
    private Integer chongwuTypes;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xinxifabuTime;


    /**
     * 信息状态
     */
    private Integer xinxiTypes;


    /**
     * 详情
     */
    private String xinxifabuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：标题
	 */
    public String getXinxifabuName() {
        return xinxifabuName;
    }


    /**
	 * 设置：标题
	 */
    public void setXinxifabuName(String xinxifabuName) {
        this.xinxifabuName = xinxifabuName;
    }
    /**
	 * 获取：类型
	 */
    public Integer getXinxifabuTypes() {
        return xinxifabuTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setXinxifabuTypes(Integer xinxifabuTypes) {
        this.xinxifabuTypes = xinxifabuTypes;
    }
    /**
	 * 获取：发布用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：发布用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：图片
	 */
    public String getXinxifabuPhoto() {
        return xinxifabuPhoto;
    }


    /**
	 * 设置：图片
	 */
    public void setXinxifabuPhoto(String xinxifabuPhoto) {
        this.xinxifabuPhoto = xinxifabuPhoto;
    }
    /**
	 * 获取：地点
	 */
    public String getXinxifabuAddress() {
        return xinxifabuAddress;
    }


    /**
	 * 设置：地点
	 */
    public void setXinxifabuAddress(String xinxifabuAddress) {
        this.xinxifabuAddress = xinxifabuAddress;
    }
    /**
	 * 获取：宠物类型
	 */
    public Integer getChongwuTypes() {
        return chongwuTypes;
    }


    /**
	 * 设置：宠物类型
	 */
    public void setChongwuTypes(Integer chongwuTypes) {
        this.chongwuTypes = chongwuTypes;
    }
    /**
	 * 获取：时间
	 */
    public Date getXinxifabuTime() {
        return xinxifabuTime;
    }


    /**
	 * 设置：时间
	 */
    public void setXinxifabuTime(Date xinxifabuTime) {
        this.xinxifabuTime = xinxifabuTime;
    }
    /**
	 * 获取：信息状态
	 */
    public Integer getXinxiTypes() {
        return xinxiTypes;
    }


    /**
	 * 设置：信息状态
	 */
    public void setXinxiTypes(Integer xinxiTypes) {
        this.xinxiTypes = xinxiTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getXinxifabuContent() {
        return xinxifabuContent;
    }


    /**
	 * 设置：详情
	 */
    public void setXinxifabuContent(String xinxifabuContent) {
        this.xinxifabuContent = xinxifabuContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
