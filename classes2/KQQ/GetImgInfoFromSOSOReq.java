package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetImgInfoFromSOSOReq
  extends JceStruct
{
  static byte[] cache_vecReqBody;
  public byte[] vecReqBody;
  
  public GetImgInfoFromSOSOReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetImgInfoFromSOSOReq(byte[] paramArrayOfByte)
  {
    this.vecReqBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecReqBody == null)
    {
      cache_vecReqBody = (byte[])new byte[1];
      ((byte[])cache_vecReqBody)[0] = 0;
    }
    this.vecReqBody = ((byte[])paramJceInputStream.read(cache_vecReqBody, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReqBody, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\GetImgInfoFromSOSOReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */