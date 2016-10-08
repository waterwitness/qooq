package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class OnlineInfo
  extends JceStruct
{
  static byte[] cache_subPlatform;
  public int clientType;
  public int instanceId;
  public int onlineStatus;
  public int platformId;
  public byte[] subPlatform;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_subPlatform = (byte[])new byte[1];
    ((byte[])cache_subPlatform)[0] = 0;
  }
  
  public OnlineInfo() {}
  
  public OnlineInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.instanceId = paramInt1;
    this.clientType = paramInt2;
    this.onlineStatus = paramInt3;
    this.platformId = paramInt4;
    this.subPlatform = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.instanceId = paramJceInputStream.read(this.instanceId, 0, false);
    this.clientType = paramJceInputStream.read(this.clientType, 1, false);
    this.onlineStatus = paramJceInputStream.read(this.onlineStatus, 2, false);
    this.platformId = paramJceInputStream.read(this.platformId, 3, false);
    this.subPlatform = ((byte[])paramJceInputStream.read(cache_subPlatform, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.instanceId, 0);
    paramJceOutputStream.write(this.clientType, 1);
    paramJceOutputStream.write(this.onlineStatus, 2);
    paramJceOutputStream.write(this.platformId, 3);
    if (this.subPlatform != null) {
      paramJceOutputStream.write(this.subPlatform, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\OnlineInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */