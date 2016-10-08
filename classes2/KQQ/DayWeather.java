package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DayWeather
  extends JceStruct
{
  public int WeatherId;
  public String bWeather;
  public String bWind;
  public String eWeather;
  public String eWind;
  public int highTemp;
  public int lowTemp;
  
  public DayWeather()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bWeather = "";
    this.eWeather = "";
    this.bWind = "";
    this.eWind = "";
  }
  
  public DayWeather(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    this.bWeather = "";
    this.eWeather = "";
    this.bWind = "";
    this.eWind = "";
    this.highTemp = paramInt1;
    this.lowTemp = paramInt2;
    this.bWeather = paramString1;
    this.eWeather = paramString2;
    this.bWind = paramString3;
    this.eWind = paramString4;
    this.WeatherId = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.highTemp = paramJceInputStream.read(this.highTemp, 1, true);
    this.lowTemp = paramJceInputStream.read(this.lowTemp, 2, true);
    this.bWeather = paramJceInputStream.readString(3, true);
    this.eWeather = paramJceInputStream.readString(4, true);
    this.bWind = paramJceInputStream.readString(5, true);
    this.eWind = paramJceInputStream.readString(6, true);
    this.WeatherId = paramJceInputStream.read(this.WeatherId, 7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.highTemp, 1);
    paramJceOutputStream.write(this.lowTemp, 2);
    paramJceOutputStream.write(this.bWeather, 3);
    paramJceOutputStream.write(this.eWeather, 4);
    paramJceOutputStream.write(this.bWind, 5);
    paramJceOutputStream.write(this.eWind, 6);
    paramJceOutputStream.write(this.WeatherId, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\DayWeather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */