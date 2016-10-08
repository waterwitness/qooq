package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqSetDiscussFlag
  extends JceStruct
{
  public long DiscussUin;
  public byte Flag;
  
  public ReqSetDiscussFlag()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqSetDiscussFlag(long paramLong, byte paramByte)
  {
    this.DiscussUin = paramLong;
    this.Flag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.Flag = paramJceInputStream.read(this.Flag, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.Flag, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqSetDiscussFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */