package com.example.own.entity.pojo.direction;

import lombok.Data;

import java.util.List;

@Data
public class Walking{
	private Route route;
	private String count;
	private String infocode;
	private String status;
	private String info;

	@Data
	public static class StepsItem{
		private String duration;
		private List<Object> assistantAction;
		private List<Object> orientation;
		private String distance;
		private List<Object> road;
		private String instruction;
		private String action;
		private String walkType;
		private String polyline;
	}

	@Data
	public static class Route{
		private List<PathsItem> paths;
		private String origin;
		private String destination;
	}

	@Data
	public static class PathsItem{
		private String duration;
		private String distance;
		private List<StepsItem> steps;
	}

}