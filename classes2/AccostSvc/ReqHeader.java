package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqHeader
  extends JceStruct
{
  static int cache_eBusiType;
  static int cache_eMqqSysType;
  public byte bNeedAck;
  public int eBusiType;
  public int eMqqSysType;
  public long iAppID;
  public long lMID;
  public short shVersion;
  
  public ReqHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.eBusiType = BusinessType.BusinessType_MQQ.value();
    this.eMqqSysType = MqqSysType.MqqSysType_default.value();
  }
  
  public ReqHeader(short paramShort, long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte paramByte)
  {
    this.eBusiType = BusinessType.BusinessType_MQQ.value();
    this.eMqqSysType = MqqSysType.MqqSysType_default.value();
    this.shVersion = paramShort;
    this.lMID = paramLong1;
    this.iAppID = paramLong2;
    this.eBusiType = paramInt1;
    this.eMqqSysType = paramInt2;
    this.bNeedAck = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
    this.iAppID = paramJceInputStream.read(this.iAppID, 2, true);
    this.eBusiType = paramJceInputStream.read(this.eBusiType, 3, false);
    this.eMqqSysType = paramJceInputStream.read(this.eMqqSysType, 4, false);
    this.bNeedAck = paramJceInputStream.read(this.bNeedAck, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.lMID, 1);
    paramJceOutputStream.write(this.iAppID, 2);
    paramJceOutputStream.write(this.eBusiType, 3);
    paramJceOutputStream.write(this.eMqqSysType, 4);
    paramJceOutputStream.write(this.bNeedAck, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\ReqHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */