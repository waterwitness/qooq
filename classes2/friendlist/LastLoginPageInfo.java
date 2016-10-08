package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class LastLoginPageInfo
  extends JceStruct
{
  public long dwCurrentReqIndex;
  public long dwCurrentReqUin;
  public long dwTotalReqTimes;
  
  public LastLoginPageInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LastLoginPageInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.dwTotalReqTimes = paramLong1;
    this.dwCurrentReqIndex = paramLong2;
    this.dwCurrentReqUin = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwTotalReqTimes = paramJceInputStream.read(this.dwTotalReqTimes, 0, true);
    this.dwCurrentReqIndex = paramJceInputStream.read(this.dwCurrentReqIndex, 1, true);
    this.dwCurrentReqUin = paramJceInputStream.read(this.dwCurrentReqUin, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwTotalReqTimes, 0);
    paramJceOutputStream.write(this.dwCurrentReqIndex, 1);
    paramJceOutputStream.write(this.dwCurrentReqUin, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\LastLoginPageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */