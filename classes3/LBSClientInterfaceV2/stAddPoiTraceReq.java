package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAddPoiTraceReq
  extends JceStruct
{
  static stGPS cache_stGps;
  public stGPS stGps = null;
  public String strPoiId = "";
  
  public stAddPoiTraceReq() {}
  
  public stAddPoiTraceReq(String paramString, stGPS paramstGPS)
  {
    this.strPoiId = paramString;
    this.stGps = paramstGPS;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPoiId = paramJceInputStream.readString(0, true);
    if (cache_stGps == null) {
      cache_stGps = new stGPS();
    }
    this.stGps = ((stGPS)paramJceInputStream.read(cache_stGps, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPoiId, 0);
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\LBSClientInterfaceV2\stAddPoiTraceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */