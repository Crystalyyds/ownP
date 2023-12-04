package com.example.own.entity.pojo;

import java.util.List;
import lombok.Data;
/**
 * 高德天气类
 */
@Data
public class AmapWeather{
	private List<LivesItem> lives;
	private String count;
	private String infocode;
	private String status;
	private String info;

	@Data
	public static class LivesItem{
		private String province;
		private String city;
		private String adcode;
		private String temperatureFloat;
		private String humidityFloat;
		private String windpower;
		private String weather;
		private String temperature;
		private String humidity;
		private String reporttime;
		private String winddirection;
	}

}