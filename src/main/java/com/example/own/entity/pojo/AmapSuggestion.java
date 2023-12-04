package com.example.own.entity.pojo;

import java.util.List;
import lombok.Data;

@Data
public class AmapSuggestion{
	private String count;
	private String infocode;
	private List<TipsItem> tips;
	private String status;
	private String info;

	@Data
	public static class TipsItem{
		private String typecode;
		private String address;
		private String adcode;
		private List<Object> city;
		private String district;
		private String name;
		private String location;
		private String id;
	}
}