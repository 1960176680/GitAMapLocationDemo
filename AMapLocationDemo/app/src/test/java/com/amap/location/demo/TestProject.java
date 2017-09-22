package com.amap.location.demo;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;

import org.junit.Test;

/**
 * Created by Administrator on 2017-01-02.
 */

public class TestProject {
    @Test
    public void get(){
        float s=AMapUtils.calculateLineDistance(new LatLng(30.183393,120.158563),new LatLng(30.211876,120.211952));
//        double s=getDistance(30.183393,120.158563,30.211876,120.211952);
        System.out.print("距离是："+s+"km");
    }

        public double getDistance(double lat1, double lng1, double lat2, double lng2){


// 计算距离，结果的单位为千米（km）

            if( ( Math.abs( lat1 ) > 90  ) ||(  Math.abs( lat2 ) > 90 ) )
                return 0;

            if( ( Math.abs( lng1 ) > 180  ) ||(  Math.abs( lng2 ) > 180 ) )
                return 0;

            double radLat1 = rad(lat1);
            double radLat2 = rad(lat2);
            double a = radLat1 - radLat2;
            double b = rad(lng1) - rad(lng2);
            double s = 2 * Math.asin(
                    Math.sqrt(
                            Math.pow( Math.sin( a/2 ), 2 ) + Math.cos( radLat1 ) * Math.cos( radLat2 ) *
                                    Math.pow( Math.sin( b/2 ), 2 )
                    )
            );
            s = s * 6378.137 ; // 地球半径 6378.137
            s = Math.round(s * 10000) / 10000;
            return s;
        }



    // 弧度转换
    public  double rad(double d){
        return d * Math.PI / 180.0;
    }
}
