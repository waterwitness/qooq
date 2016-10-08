package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GPicInfo
  extends JceStruct
{
  static byte[] cache_vHost;
  static byte[] cache_vPath;
  public byte[] vHost;
  public byte[] vPath;
  
  public GPicInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GPicInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.vPath = paramArrayOfByte1;
    this.vHost = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPath == null)
    {
      cache_vPath = (byte[])new byte[1];
      ((byte[])cache_vPath)[0] = 0;
    }
    this.vPath = ((byte[])paramJceInputStream.read(cache_vPath, 0, true));
    if (cache_vHost == null)
    {
      cache_vHost = (byte[])new byte[1];
      ((byte[])cache_vHost)[0] = 0;
    }
    this.vHost = ((byte[])paramJceInputStream.read(cache_vHost, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vPath, 0);
    if (this.vHost != null) {
      paramJceOutputStream.write(this.vHost, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PushNotifyPack\GPicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */