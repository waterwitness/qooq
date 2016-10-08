package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Wifi
  extends JceStruct
{
  public long lMac;
  public short shRssi;
  
  public Wifi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.lMac = -1L;
  }
  
  public Wifi(long paramLong, short paramShort)
  {
    this.lMac = -1L;
    this.lMac = paramLong;
    this.shRssi = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lMac = paramJceInputStream.read(this.lMac, 0, true);
    this.shRssi = paramJceInputStream.read(this.shRssi, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lMac, 0);
    paramJceOutputStream.write(this.shRssi, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\Wifi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */