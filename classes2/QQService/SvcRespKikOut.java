package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcRespKikOut
  extends JceStruct
{
  public long appid;
  public long lUin;
  public byte result;
  
  public SvcRespKikOut()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRespKikOut(long paramLong1, long paramLong2, byte paramByte)
  {
    this.lUin = paramLong1;
    this.appid = paramLong2;
    this.result = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.result = paramJceInputStream.read(this.result, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.result, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\SvcRespKikOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */