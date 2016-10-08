package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetImgInfoFromSOSOResp
  extends JceStruct
{
  static byte[] cache_vecRespBody;
  public byte[] vecRespBody;
  
  public GetImgInfoFromSOSOResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetImgInfoFromSOSOResp(byte[] paramArrayOfByte)
  {
    this.vecRespBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecRespBody == null)
    {
      cache_vecRespBody = (byte[])new byte[1];
      ((byte[])cache_vecRespBody)[0] = 0;
    }
    this.vecRespBody = ((byte[])paramJceInputStream.read(cache_vecRespBody, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecRespBody, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\GetImgInfoFromSOSOResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */