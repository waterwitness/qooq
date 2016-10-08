package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class WeatherInfoReq
  extends JceStruct
{
  public String city;
  public int iAppId;
  public String strSessionKey;
  
  public WeatherInfoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strSessionKey = "";
    this.city = "";
  }
  
  public WeatherInfoReq(int paramInt, String paramString1, String paramString2)
  {
    this.strSessionKey = "";
    this.city = "";
    this.iAppId = paramInt;
    this.strSessionKey = paramString1;
    this.city = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 1, true);
    this.strSessionKey = paramJceInputStream.readString(2, true);
    this.city = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 1);
    paramJceOutputStream.write(this.strSessionKey, 2);
    paramJceOutputStream.write(this.city, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\WeatherInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */