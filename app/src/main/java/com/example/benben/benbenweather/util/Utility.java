package com.example.benben.benbenweather.util;

import android.text.TextUtils;

import com.example.benben.benbenweather.db.CoolWeatherDB;
import com.example.benben.benbenweather.model.CityModel;
import com.example.benben.benbenweather.model.CountyModel;
import com.example.benben.benbenweather.model.ProvinceModel;

/**
 * Created by benebn on 2016/5/31.
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB
            , String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array=p.split("\\|");
                    ProvinceModel province = new ProvinceModel();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    /**将解析出来的数据存储到Province表*/
                coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB
            , String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    CityModel city = new CityModel();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    /**将解析出来的数据存储到city表中*/
                coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB
            , String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    CountyModel county = new CountyModel();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    /**将解析出来的数据存储到County*/
                coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

}
