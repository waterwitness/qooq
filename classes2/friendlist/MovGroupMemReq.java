package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MovGroupMemReq
  extends JceStruct
{
  static byte[] cache_vecBody;
  public byte reqtype;
  public long uin;
  public byte[] vecBody;
  
  public MovGroupMemReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MovGroupMemReq(long paramLong, byte paramByte, byte[] paramArrayOfByte)
  {
    this.uin = paramLong;
    this.reqtype = paramByte;
    this.vecBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.reqtype = paramJceInputStream.read(this.reqtype, 1, true);
    if (cache_vecBody == null)
    {
      cache_vecBody = (byte[])new byte[1];
      ((byte[])cache_vecBody)[0] = 0;
    }
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.reqtype, 1);
    paramJceOutputStream.write(this.vecBody, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\MovGroupMemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */