package com.desheng.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OtherController {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${weather.url}")
	private String url;
	@Value("${weather.appkey}")
	private String appkey;

	// 查询天气接口
	@RequestMapping("Other/SimpleWeather")
	public Object querySimpleWeather(@RequestParam("name") String name) {
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("cityname", name);// 要查询的城市，如：温州、上海、北京
		params.put("key", appkey);// 应用APPKEY(应用详细页查询)
		params.put("dtype", "json");// 返回数据的格式,xml或json，默认json
		@SuppressWarnings("rawtypes")
		HashMap map = restTemplate.postForObject(url, params, HashMap.class);
		return map;

	}

}
