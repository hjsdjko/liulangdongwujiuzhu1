package com.entity.view;

import com.entity.LingyangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 领养记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("lingyang")
public class LingyangView extends LingyangEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 xinxifabu
			/**
			* 标题
			*/
			private String xinxifabuName;
			/**
			* 类型
			*/
			private Integer xinxifabuTypes;
				/**
				* 类型的值
				*/
				private String xinxifabuValue;
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
				* 宠物类型的值
				*/
				private String chongwuValue;
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
				* 信息状态的值
				*/
				private String xinxiValue;
			/**
			* 详情
			*/
			private String xinxifabuContent;


//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public LingyangView() {

	}

	public LingyangView(LingyangEntity lingyangEntity) {
		try {
			BeanUtils.copyProperties(this, lingyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















				//级联表的get和set xinxifabu
					/**
					* 获取： 标题
					*/
					public String getXinxifabuName() {
						return xinxifabuName;
					}
					/**
					* 设置： 标题
					*/
					public void setXinxifabuName(String xinxifabuName) {
						this.xinxifabuName = xinxifabuName;
					}
					/**
					* 获取： 类型
					*/
					public Integer getXinxifabuTypes() {
						return xinxifabuTypes;
					}
					/**
					* 设置： 类型
					*/
					public void setXinxifabuTypes(Integer xinxifabuTypes) {
						this.xinxifabuTypes = xinxifabuTypes;
					}


						/**
						* 获取： 类型的值
						*/
						public String getXinxifabuValue() {
							return xinxifabuValue;
						}
						/**
						* 设置： 类型的值
						*/
						public void setXinxifabuValue(String xinxifabuValue) {
							this.xinxifabuValue = xinxifabuValue;
						}
					/**
					* 获取： 图片
					*/
					public String getXinxifabuPhoto() {
						return xinxifabuPhoto;
					}
					/**
					* 设置： 图片
					*/
					public void setXinxifabuPhoto(String xinxifabuPhoto) {
						this.xinxifabuPhoto = xinxifabuPhoto;
					}
					/**
					* 获取： 地点
					*/
					public String getXinxifabuAddress() {
						return xinxifabuAddress;
					}
					/**
					* 设置： 地点
					*/
					public void setXinxifabuAddress(String xinxifabuAddress) {
						this.xinxifabuAddress = xinxifabuAddress;
					}
					/**
					* 获取： 宠物类型
					*/
					public Integer getChongwuTypes() {
						return chongwuTypes;
					}
					/**
					* 设置： 宠物类型
					*/
					public void setChongwuTypes(Integer chongwuTypes) {
						this.chongwuTypes = chongwuTypes;
					}


						/**
						* 获取： 宠物类型的值
						*/
						public String getChongwuValue() {
							return chongwuValue;
						}
						/**
						* 设置： 宠物类型的值
						*/
						public void setChongwuValue(String chongwuValue) {
							this.chongwuValue = chongwuValue;
						}
					/**
					* 获取： 时间
					*/
					public Date getXinxifabuTime() {
						return xinxifabuTime;
					}
					/**
					* 设置： 时间
					*/
					public void setXinxifabuTime(Date xinxifabuTime) {
						this.xinxifabuTime = xinxifabuTime;
					}
					/**
					* 获取： 信息状态
					*/
					public Integer getXinxiTypes() {
						return xinxiTypes;
					}
					/**
					* 设置： 信息状态
					*/
					public void setXinxiTypes(Integer xinxiTypes) {
						this.xinxiTypes = xinxiTypes;
					}


						/**
						* 获取： 信息状态的值
						*/
						public String getXinxiValue() {
							return xinxiValue;
						}
						/**
						* 设置： 信息状态的值
						*/
						public void setXinxiValue(String xinxiValue) {
							this.xinxiValue = xinxiValue;
						}
					/**
					* 获取： 详情
					*/
					public String getXinxifabuContent() {
						return xinxifabuContent;
					}
					/**
					* 设置： 详情
					*/
					public void setXinxifabuContent(String xinxifabuContent) {
						this.xinxifabuContent = xinxifabuContent;
					}







				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}



}
