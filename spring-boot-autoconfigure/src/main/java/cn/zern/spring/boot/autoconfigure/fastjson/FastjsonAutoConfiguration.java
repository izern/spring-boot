package cn.zern.spring.boot.autoconfigure.fastjson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 启用Fastjson做为HttpMessageConverters默认json转换器
 * @author zern
 * 2017年5月2日 下午9:03:59
 */
@Configuration
@ConditionalOnClass(FastJsonHttpMessageConverter.class)
@EnableConfigurationProperties(FastjsonProperties.class)
public class FastjsonAutoConfiguration{
	
	@Autowired
	private FastjsonProperties properties;

	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(properties.getSerializerFeatures());
		fastJsonConfig.setDateFormat(properties.getDateFormat());
		fastJsonConfig.setFeatures(properties.getFeature());
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
}
