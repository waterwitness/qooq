package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetNearbyPubAcctInfo
  extends JceStruct
{
  static LBSInfo cache_stLBSInfo;
  static byte[] cache_vContext;
  public int iCount;
  public short shVersion;
  public LBSInfo stLBSInfo;
  public byte[] vContext;
  
  public ReqGetNearbyPubAcctInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqGetNearbyPubAcctInfo(short paramShort, byte[] paramArrayOfByte, int paramInt, LBSInfo paramLBSInfo)
  {
    this.shVersion = paramShort;
    this.vContext = paramArrayOfByte;
    this.iCount = paramInt;
    this.stLBSInfo = paramLBSInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    if (cache_vContext == null)
    {
      cache_vContext = (byte[])new byte[1];
      ((byte[])cache_vContext)[0] = 0;
    }
    this.vContext = ((byte[])paramJceInputStream.read(cache_vContext, 1, true));
    this.iCount = paramJceInputStream.read(this.iCount, 2, true);
    if (cache_stLBSInfo == null) {
      cache_stLBSInfo = new LBSInfo();
    }
    this.stLBSInfo = ((LBSInfo)paramJceInputStream.read(cache_stLBSInfo, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.vContext, 1);
    paramJceOutputStream.write(this.iCount, 2);
    paramJceOutputStream.write(this.stLBSInfo, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyPubAcct\ReqGetNearbyPubAcctInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */