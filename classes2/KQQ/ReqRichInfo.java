package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqRichInfo
  extends JceStruct
{
  public long dwTime;
  public long lUin;
  
  public ReqRichInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqRichInfo(long paramLong1, long paramLong2)
  {
    this.lUin = paramLong1;
    this.dwTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 1, true);
    this.dwTime = paramJceInputStream.read(this.dwTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 1);
    paramJceOutputStream.write(this.dwTime, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ReqRichInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */