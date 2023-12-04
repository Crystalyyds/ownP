package com.example.own.entity.pojo;

import java.util.List;
import lombok.Data;

@Data
public class AmapPoi{
	private Suggestion suggestion;
	private String count;
	private String infocode;
	private List<PoisItem> pois;
	private String status;
	private String info;

	@Data
	public class PoisItem{
		private String parent;
		private String address;
		private String distance;
		private String pname;
		private List<Object> importance;
		private List<Object> bizExt;
		private List<Object> bizType;
		private String cityname;
		private String type;
		private List<Object> photos;
		private String typecode;
		private String shopinfo;
		private List<Object> poiweight;
		private String childtype;
		private String adname;
		private String name;
		private String location;
		private String tel;
		private List<Object> shopid;
		private String id;
	}

	@Data
	public class Suggestion{
		private List<Object> keywords;
		private List<Object> cities;
	}
}