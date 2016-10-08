package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqPicSafetyCheck
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public int iScene;
  public long lToUIN;
  public ReqHead stHeader;
  
  public ReqPicSafetyCheck()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqPicSafetyCheck(ReqHead paramReqHead, long paramLong, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.lToUIN = paramLong;
    this.iScene = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.iScene = paramJceInputStream.read(this.iScene, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.iScene, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqPicSafetyCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */