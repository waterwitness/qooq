package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqGetPositionApi
  extends JceStruct
{
  static byte[] cache_vLBSKeyData;
  public int iClientIp;
  public byte[] vLBSKeyData;
  
  public ReqGetPositionApi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqGetPositionApi(byte[] paramArrayOfByte, int paramInt)
  {
    this.vLBSKeyData = paramArrayOfByte;
    this.iClientIp = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vLBSKeyData == null)
    {
      cache_vLBSKeyData = (byte[])new byte[1];
      ((byte[])cache_vLBSKeyData)[0] = 0;
    }
    this.vLBSKeyData = ((byte[])paramJceInputStream.read(cache_vLBSKeyData, 0, true));
    this.iClientIp = paramJceInputStream.read(this.iClientIp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vLBSKeyData, 0);
    paramJceOutputStream.write(this.iClientIp, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBSAddrProtocol\ReqGetPositionApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */