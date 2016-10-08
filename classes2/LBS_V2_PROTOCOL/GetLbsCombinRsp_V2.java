package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetLbsCombinRsp_V2
  extends JceStruct
{
  static GeoInfo_V2 cache_stGeoInfo;
  static GPS_V2 cache_stGps;
  static GetPoiInfoRsp_V2 cache_stPoiInfo;
  static WeatherInfo_V2 cache_stWeather;
  public int iMood;
  public GeoInfo_V2 stGeoInfo;
  public GPS_V2 stGps;
  public GetPoiInfoRsp_V2 stPoiInfo;
  public WeatherInfo_V2 stWeather;
  
  public GetLbsCombinRsp_V2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetLbsCombinRsp_V2(GPS_V2 paramGPS_V2, GeoInfo_V2 paramGeoInfo_V2, GetPoiInfoRsp_V2 paramGetPoiInfoRsp_V2, WeatherInfo_V2 paramWeatherInfo_V2, int paramInt)
  {
    this.stGps = paramGPS_V2;
    this.stGeoInfo = paramGeoInfo_V2;
    this.stPoiInfo = paramGetPoiInfoRsp_V2;
    this.stWeather = paramWeatherInfo_V2;
    this.iMood = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS_V2();
    }
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 0, true));
    if (cache_stGeoInfo == null) {
      cache_stGeoInfo = new GeoInfo_V2();
    }
    this.stGeoInfo = ((GeoInfo_V2)paramJceInputStream.read(cache_stGeoInfo, 1, true));
    if (cache_stPoiInfo == null) {
      cache_stPoiInfo = new GetPoiInfoRsp_V2();
    }
    this.stPoiInfo = ((GetPoiInfoRsp_V2)paramJceInputStream.read(cache_stPoiInfo, 2, true));
    if (cache_stWeather == null) {
      cache_stWeather = new WeatherInfo_V2();
    }
    this.stWeather = ((WeatherInfo_V2)paramJceInputStream.read(cache_stWeather, 3, true));
    this.iMood = paramJceInputStream.read(this.iMood, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.stGeoInfo, 1);
    paramJceOutputStream.write(this.stPoiInfo, 2);
    paramJceOutputStream.write(this.stWeather, 3);
    paramJceOutputStream.write(this.iMood, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBS_V2_PROTOCOL\GetLbsCombinRsp_V2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */