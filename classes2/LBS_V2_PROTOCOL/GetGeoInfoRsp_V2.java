package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetGeoInfoRsp_V2
  extends JceStruct
{
  static GeoInfo_V2 cache_stGeoInfo;
  static GPS_V2 cache_stGps;
  public GeoInfo_V2 stGeoInfo;
  public GPS_V2 stGps;
  
  public GetGeoInfoRsp_V2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetGeoInfoRsp_V2(GPS_V2 paramGPS_V2, GeoInfo_V2 paramGeoInfo_V2)
  {
    this.stGps = paramGPS_V2;
    this.stGeoInfo = paramGeoInfo_V2;
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
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.stGeoInfo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBS_V2_PROTOCOL\GetGeoInfoRsp_V2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */