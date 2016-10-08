package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetPoint
  extends JceStruct
{
  static ReqUserInfo cache_stUserInfo;
  public byte bGetCityId;
  public byte bJiejingSOSO;
  public ReqUserInfo stUserInfo;
  
  public ReqGetPoint()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqGetPoint(ReqUserInfo paramReqUserInfo, byte paramByte1, byte paramByte2)
  {
    this.stUserInfo = paramReqUserInfo;
    this.bJiejingSOSO = paramByte1;
    this.bGetCityId = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.bJiejingSOSO = paramJceInputStream.read(this.bJiejingSOSO, 1, false);
    this.bGetCityId = paramJceInputStream.read(this.bGetCityId, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.bJiejingSOSO, 1);
    paramJceOutputStream.write(this.bGetCityId, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NeighborSvc\ReqGetPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */