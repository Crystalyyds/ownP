package com.example.own.utils.amap.pojo;

import java.util.List;

import lombok.Data;

@Data
public class PoiEntity {
    private Suggestion suggestion;
    private String count;
    private String infocode;
    private List<PoisItem> pois;
    private String status;
    private String info;

    @Data
    public static class Suggestion {
        private List<Object> keywords;
        private List<Object> cities;
    }

    @Data
    public static class PoisItem {
        private List<Object> parent;
        private List<Object> distance;
        private String pcode;
        private List<Object> importance;
        private BizExt bizExt;
        private String recommend;
        private String type;
        private List<PhotosItem> photos;
        private String discountNum;
        private String gridcode;
        private String typecode;
        private String shopinfo;
        private List<Object> poiweight;
        private String citycode;
        private String adname;
        private List<Object> children;
        private String alias;
        private List<Object> tel;
        private String id;
        private List<Object> tag;
        private List<Object> event;
        private String entrLocation;
        private String indoorMap;
        private List<Object> email;
        private String timestamp;
        private List<Object> website;
        private String address;
        private String adcode;
        private String pname;
        private List<Object> bizType;
        private String cityname;
        private List<Object> postcode;
        private String match;
        private List<Object> businessArea;
        private IndoorData indoorData;
        private List<Object> childtype;
        private List<Object> exitLocation;
        private String name;
        private String location;
        private List<Object> shopid;
        private String naviPoiid;
        private String groupbuyNum;

        @Data
        public static class BizExt {
            private List<Object> cost;
            private List<Object> rating;
            private String mealOrdering;
        }

        @Data
        public static class IndoorData {
            private List<Object> cmsid;
            private List<Object> truefloor;
            private List<Object> cpid;
            private List<Object> floor;
        }

        @Data
        public static class PhotosItem {
            private List<Object> title;
            private String url;
        }
    }
}