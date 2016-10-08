package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserData
  extends JceStruct
{
  public int iLat;
  public int iLon;
  public long lNextMid;
  public int lTime;
  public String strProvince;
  
  public UserData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iLat = 900000000;
    this.iLon = 900000000;
    this.strProvince = "";
  }
  
  public UserData(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    this.iLat = 900000000;
    this.iLon = 900000000;
    this.strProvince = "";
    this.lTime = paramInt1;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
    this.lNextMid = paramLong;
    this.strProvince = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lTime = paramJceInputStream.read(this.lTime, 0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 3, true);
    this.strProvince = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lTime, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.lNextMid, 3);
    if (this.strProvince != null) {
      paramJceOutputStream.write(this.strProvince, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NeighborSvc\UserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */