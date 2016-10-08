package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DeviceItemDes
  extends JceStruct
{
  static byte[] cache_vecItemDes;
  public byte[] vecItemDes;
  
  public DeviceItemDes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DeviceItemDes(byte[] paramArrayOfByte)
  {
    this.vecItemDes = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecItemDes == null)
    {
      cache_vecItemDes = (byte[])new byte[1];
      ((byte[])cache_vecItemDes)[0] = 0;
    }
    this.vecItemDes = ((byte[])paramJceInputStream.read(cache_vecItemDes, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecItemDes, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\DeviceItemDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */