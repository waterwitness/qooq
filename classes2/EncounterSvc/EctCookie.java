package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class EctCookie
  extends JceStruct
{
  static int cache_eNextGridListType = 0;
  static byte[] cache_vCookie;
  public byte cNextGridSIndex;
  public byte cResetIdentity;
  public int eNextGridListType = 0;
  public long lCurrentGrid;
  public long lNextMid;
  public long lOriginGridS;
  public int last_max_distance;
  public byte[] vCookie;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vCookie = (byte[])new byte[1];
    ((byte[])cache_vCookie)[0] = 0;
  }
  
  public EctCookie() {}
  
  public EctCookie(byte[] paramArrayOfByte, long paramLong1, long paramLong2, byte paramByte1, int paramInt1, long paramLong3, int paramInt2, byte paramByte2)
  {
    this.vCookie = paramArrayOfByte;
    this.lCurrentGrid = paramLong1;
    this.lOriginGridS = paramLong2;
    this.cNextGridSIndex = paramByte1;
    this.eNextGridListType = paramInt1;
    this.lNextMid = paramLong3;
    this.last_max_distance = paramInt2;
    this.cResetIdentity = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vCookie = ((byte[])paramJceInputStream.read(cache_vCookie, 0, false));
    this.lCurrentGrid = paramJceInputStream.read(this.lCurrentGrid, 1, false);
    this.lOriginGridS = paramJceInputStream.read(this.lOriginGridS, 2, false);
    this.cNextGridSIndex = paramJceInputStream.read(this.cNextGridSIndex, 3, false);
    this.eNextGridListType = paramJceInputStream.read(this.eNextGridListType, 4, false);
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 5, false);
    this.last_max_distance = paramJceInputStream.read(this.last_max_distance, 6, false);
    this.cResetIdentity = paramJceInputStream.read(this.cResetIdentity, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vCookie != null) {
      paramJceOutputStream.write(this.vCookie, 0);
    }
    paramJceOutputStream.write(this.lCurrentGrid, 1);
    paramJceOutputStream.write(this.lOriginGridS, 2);
    paramJceOutputStream.write(this.cNextGridSIndex, 3);
    paramJceOutputStream.write(this.eNextGridListType, 4);
    paramJceOutputStream.write(this.lNextMid, 5);
    paramJceOutputStream.write(this.last_max_distance, 6);
    paramJceOutputStream.write(this.cResetIdentity, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\EctCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */