package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DiscussInfo
  extends JceStruct
{
  public long DiscussUin;
  public long InfoSeq;
  
  public DiscussInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DiscussInfo(long paramLong1, long paramLong2)
  {
    this.DiscussUin = paramLong1;
    this.InfoSeq = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.InfoSeq = paramJceInputStream.read(this.InfoSeq, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.InfoSeq, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\DiscussInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */