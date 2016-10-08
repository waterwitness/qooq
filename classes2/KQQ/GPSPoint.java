package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GPSPoint
  extends JceStruct
{
  public int alt;
  public int lat;
  public int lon;
  
  public GPSPoint()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.lat = 900000000;
    this.lon = 900000000;
  }
  
  public GPSPoint(int paramInt1, int paramInt2, int paramInt3)
  {
    this.lat = 900000000;
    this.lon = 900000000;
    this.lat = paramInt1;
    this.lon = paramInt2;
    this.alt = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lat = paramJceInputStream.read(this.lat, 0, true);
    this.lon = paramJceInputStream.read(this.lon, 1, true);
    this.alt = paramJceInputStream.read(this.alt, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lat, 0);
    paramJceOutputStream.write(this.lon, 1);
    paramJceOutputStream.write(this.alt, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\GPSPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */