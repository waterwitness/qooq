package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GPS
  extends JceStruct
{
  static int cache_eType;
  public int eType;
  public int iAlt;
  public int iLat;
  public int iLon;
  
  public GPS()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iLat = 900000000;
    this.iLon = 900000000;
    this.iAlt = -10000000;
    this.eType = 0;
  }
  
  public GPS(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iLat = 900000000;
    this.iLon = 900000000;
    this.iAlt = -10000000;
    this.eType = 0;
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.iAlt = paramInt3;
    this.eType = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
    this.iAlt = paramJceInputStream.read(this.iAlt, 2, true);
    this.eType = paramJceInputStream.read(this.eType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.iAlt, 2);
    paramJceOutputStream.write(this.eType, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\GPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */