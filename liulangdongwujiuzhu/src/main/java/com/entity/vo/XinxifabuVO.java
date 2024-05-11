package com.entity.vo;

import com.entity.XinxifabuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 信息发布
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinxifabu")
public class XinxifabuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "xinxifabu_name")
    private String xinxifabuName;


    /**
     * 类型
     */

    @TableField(value = "xinxifabu_types")
    private Integer xinxifabuTypes;


    /**
     * 发布用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 图片
     */

    @TableField(value = "xinxifabu_photo")
    private String xinxifabuPhoto;


    /**
     * 地点
     */

    @TableField(value = "xinxifabu_address")
    private String xinxifabuAddress;


    /**
     * 宠物类型
     */

    @TableField(value = "chongwu_types")
    private Integer chongwuTypes;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xinxifabu_time")
    private Date xinxifabuTime;


    /**
     * 信息状态
     */

    @TableField(value = "xinxi_types")
    private Integer xinxiTypes;


    /**
     * 详情
     */

    @TableField(value = "xinxifabu_content")
    private String xinxifabuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：标题
	 */
    public String getXinxifabuName() {
        return xinxifabuName;
    }


    /**
	 * 获取：标题
	 */

    public void setXinxifabuName(String xinxifabuName) {
        this.xinxifabuName = xinxifabuName;
    }
    /**
	 * 设置：类型
	 */
    public Integer getXinxifabuTypes() {
        return xinxifabuTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setXinxifabuTypes(Integer xinxifabuTypes) {
        this.xinxifabuTypes = xinxifabuTypes;
    }
    /**
	 * 设置：发布用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：发布用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：图片
	 */
    public String getXinxifabuPhoto() {
        return xinxifabuPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setXinxifabuPhoto(String xinxifabuPhoto) {
        this.xinxifabuPhoto = xinxifabuPhoto;
    }
    /**
	 * 设置：地点
	 */
    public String getXinxifabuAddress() {
        return xinxifabuAddress;
    }


    /**
	 * 获取：地点
	 */

    public void setXinxifabuAddress(String xinxifabuAddress) {
        this.xinxifabuAddress = xinxifabuAddress;
    }
    /**
	 * 设置：宠物类型
	 */
    public Integer getChongwuTypes() {
        return chongwuTypes;
    }


    /**
	 * 获取：宠物类型
	 */

    public void setChongwuTypes(Integer chongwuTypes) {
        this.chongwuTypes = chongwuTypes;
    }
    /**
	 * 设置：时间
	 */
    public Date getXinxifabuTime() {
        return xinxifabuTime;
    }


    /**
	 * 获取：时间
	 */

    public void setXinxifabuTime(Date xinxifabuTime) {
        this.xinxifabuTime = xinxifabuTime;
    }
    /**
	 * 设置：信息状态
	 */
    public Integer getXinxiTypes() {
        return xinxiTypes;
    }


    /**
	 * 获取：信息状态
	 */

    public void setXinxiTypes(Integer xinxiTypes) {
        this.xinxiTypes = xinxiTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getXinxifabuContent() {
        return xinxifabuContent;
    }


    /**
	 * 获取：详情
	 */

    public void setXinxifabuContent(String xinxifabuContent) {
        this.xinxifabuContent = xinxifabuContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
