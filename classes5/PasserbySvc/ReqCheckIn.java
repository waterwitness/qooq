package PasserbySvc;

import NeighborComm.ReqHeader;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqCheckIn
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static ReqUserInfo cache_stUserInfo;
  public ReqHeader stHeader;
  public ReqUserInfo stUserInfo;
  
  public ReqCheckIn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqCheckIn(ReqHeader paramReqHeader, ReqUserInfo paramReqUserInfo)
  {
    this.stHeader = paramReqHeader;
    this.stUserInfo = paramReqUserInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stUserInfo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PasserbySvc\ReqCheckIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */