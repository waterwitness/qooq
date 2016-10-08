package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespOffFilePack
  extends JceStruct
{
  static byte[] cache_vBody;
  public int iReplyCode;
  public long lUIN;
  public byte[] vBody;
  
  public RespOffFilePack()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespOffFilePack(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.lUIN = paramLong;
    this.iReplyCode = paramInt;
    this.vBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 1, true);
    if (cache_vBody == null)
    {
      cache_vBody = (byte[])new byte[1];
      ((byte[])cache_vBody)[0] = 0;
    }
    this.vBody = ((byte[])paramJceInputStream.read(cache_vBody, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.iReplyCode, 1);
    paramJceOutputStream.write(this.vBody, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespOffFilePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */