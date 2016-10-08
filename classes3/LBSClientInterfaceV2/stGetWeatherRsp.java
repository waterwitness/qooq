package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetWeatherRsp
  extends JceStruct
{
  static stWeatherInfo cache_stWeather;
  public stWeatherInfo stWeather = null;
  
  public stGetWeatherRsp() {}
  
  public stGetWeatherRsp(stWeatherInfo paramstWeatherInfo)
  {
    this.stWeather = paramstWeatherInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stWeather == null) {
      cache_stWeather = new stWeatherInfo();
    }
    this.stWeather = ((stWeatherInfo)paramJceInputStream.read(cache_stWeather, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stWeather, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\LBSClientInterfaceV2\stGetWeatherRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */