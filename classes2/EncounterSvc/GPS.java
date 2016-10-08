package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GPS
  extends JceStruct
{
  static int cache_eType = 0;
  public int eType = 0;
  public int iAlt = -10000000;
  public int iLat = 900000000;
  public int iLon = 900000000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GPS() {}
  
  public GPS(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\GPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */