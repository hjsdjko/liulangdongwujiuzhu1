package com.entity.view;

import com.entity.XinxifabuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 信息发布
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xinxifabu")
public class XinxifabuView extends XinxifabuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String xinxifabuValue;
		/**
		* 宠物类型的值
		*/
		private String chongwuValue;
		/**
		* 信息状态的值
		*/
		private String xinxiValue;



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

	public XinxifabuView() {

	}

	public XinxifabuView(XinxifabuEntity xinxifabuEntity) {
		try {
			BeanUtils.copyProperties(this, xinxifabuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
