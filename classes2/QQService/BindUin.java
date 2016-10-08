package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BindUin
  extends JceStruct
{
  static byte[] cache_sKey;
  public int iStatus;
  public long lUin;
  public byte[] sKey;
  
  public BindUin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iStatus = 11;
  }
  
  public BindUin(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.iStatus = 11;
    this.lUin = paramLong;
    this.sKey = paramArrayOfByte;
    this.iStatus = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_sKey == null)
    {
      cache_sKey = (byte[])new byte[1];
      ((byte[])cache_sKey)[0] = 0;
    }
    this.sKey = ((byte[])paramJceInputStream.read(cache_sKey, 1, true));
    this.iStatus = paramJceInputStream.read(this.iStatus, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.sKey, 1);
    paramJceOutputStream.write(this.iStatus, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\BindUin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */