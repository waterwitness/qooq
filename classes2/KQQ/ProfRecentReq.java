package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ProfRecentReq
  extends JceStruct
{
  public long uTimeStamp;
  
  public ProfRecentReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfRecentReq(long paramLong)
  {
    this.uTimeStamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uTimeStamp = paramJceInputStream.read(this.uTimeStamp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uTimeStamp, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfRecentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */