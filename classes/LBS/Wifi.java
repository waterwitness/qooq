package LBS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Wifi
  extends JceStruct
{
  public long lMac = -1L;
  public short shRssi = 0;
  
  public Wifi() {}
  
  public Wifi(long paramLong, short paramShort)
  {
    this.lMac = paramLong;
    this.shRssi = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lMac = paramJceInputStream.read(this.lMac, 0, true);
    this.shRssi = paramJceInputStream.read(this.shRssi, 1, false);
  }
  
  public String toString()
  {
    return "Wifi[mac=" + this.lMac + ",rssi=" + this.shRssi + "]\n";
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lMac, 0);
    paramJceOutputStream.write(this.shRssi, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\LBS\Wifi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */