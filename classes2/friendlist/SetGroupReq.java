package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SetGroupReq
  extends JceStruct
{
  static int cache_reqtype;
  static byte[] cache_vecBody;
  public int reqtype;
  public long uin;
  public byte[] vecBody;
  
  public SetGroupReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SetGroupReq(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    this.reqtype = paramInt;
    this.uin = paramLong;
    this.vecBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    if (cache_vecBody == null)
    {
      cache_vecBody = (byte[])new byte[1];
      ((byte[])cache_vecBody)[0] = 0;
    }
    this.vecBody = ((byte[])paramJceInputStream.read(cache_vecBody, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.vecBody, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\SetGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */