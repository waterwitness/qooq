package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGPS
  extends JceStruct
{
  public int eType = 2;
  public double fLat = 900.0D;
  public double fLon = 900.0D;
  public int iAlt = -10000000;
  
  public stGPS() {}
  
  public stGPS(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    this.fLat = paramDouble1;
    this.fLon = paramDouble2;
    this.iAlt = paramInt1;
    this.eType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fLat = paramJceInputStream.read(this.fLat, 0, true);
    this.fLon = paramJceInputStream.read(this.fLon, 1, true);
    this.iAlt = paramJceInputStream.read(this.iAlt, 2, true);
    this.eType = paramJceInputStream.read(this.eType, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fLat, 0);
    paramJceOutputStream.write(this.fLon, 1);
    paramJceOutputStream.write(this.iAlt, 2);
    paramJceOutputStream.write(this.eType, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\LBSClientInterfaceV2\stGPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */