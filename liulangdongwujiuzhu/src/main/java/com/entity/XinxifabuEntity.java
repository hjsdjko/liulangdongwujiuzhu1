package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 信息发布
 *
 * @author 
 * @email
 */
@TableName("xinxifabu")
public class XinxifabuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinxifabuEntity() {

	}

	public XinxifabuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Xinxifabu{" +
            "id=" + id +
            ", xinxifabuName=" + xinxifabuName +
            ", xinxifabuTypes=" + xinxifabuTypes +
            ", yonghuId=" + yonghuId +
            ", xinxifabuPhoto=" + xinxifabuPhoto +
            ", xinxifabuAddress=" + xinxifabuAddress +
            ", chongwuTypes=" + chongwuTypes +
            ", xinxifabuTime=" + xinxifabuTime +
            ", xinxiTypes=" + xinxiTypes +
            ", xinxifabuContent=" + xinxifabuContent +
            ", createTime=" + createTime +
        "}";
    }
}
