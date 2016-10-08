package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_gps
  extends JceStruct
{
  public int altitude;
  public int latitude;
  public int longitude;
  
  public s_gps()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_gps(int paramInt1, int paramInt2, int paramInt3)
  {
    this.latitude = paramInt1;
    this.longitude = paramInt2;
    this.altitude = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.latitude = paramJceInputStream.read(this.latitude, 0, false);
    this.longitude = paramJceInputStream.read(this.longitude, 1, false);
    this.altitude = paramJceInputStream.read(this.altitude, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.latitude, 0);
    paramJceOutputStream.write(this.longitude, 1);
    paramJceOutputStream.write(this.altitude, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_gps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */