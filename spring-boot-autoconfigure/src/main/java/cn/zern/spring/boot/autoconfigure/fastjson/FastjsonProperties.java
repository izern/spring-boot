package cn.zern.spring.boot.autoconfigure.fastjson;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 读取fastjson配置
 * @author zern
 * 2017年2月22日
 */
@ConfigurationProperties(prefix = "spring.fastjson")
public class FastjsonProperties{
	
	private SerializerFeature[] serializerFeatures;
	
	private Feature[] feature;
	
	private String dateFormat;
	
	/**
	 * 设置默认属性
	 */
	public FastjsonProperties() {
		this.dateFormat  = "yyyy-MM-dd hh:mm:ss";
		this.feature = new Feature[0];
		this.serializerFeatures = new SerializerFeature[0];
	}
	public SerializerFeature[] getSerializerFeatures() {
		return serializerFeatures;
	}
	public void setSerializerFeatures(SerializerFeature[] serializerFeatures) {
		this.serializerFeatures = serializerFeatures;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public Feature[] getFeature() {
		return feature;
	}
	public void setFeature(Feature[] feature) {
		this.feature = feature;
	}
}