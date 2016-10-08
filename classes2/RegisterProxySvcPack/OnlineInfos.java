package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OnlineInfos
  extends JceStruct
{
  public int clienType;
  public int instanceId;
  public int onlineStatus;
  
  public OnlineInfos()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OnlineInfos(int paramInt1, int paramInt2, int paramInt3)
  {
    this.instanceId = paramInt1;
    this.clienType = paramInt2;
    this.onlineStatus = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.instanceId = paramJceInputStream.read(this.instanceId, 0, false);
    this.clienType = paramJceInputStream.read(this.clienType, 1, false);
    this.onlineStatus = paramJceInputStream.read(this.onlineStatus, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.instanceId, 0);
    paramJceOutputStream.write(this.clienType, 1);
    paramJceOutputStream.write(this.onlineStatus, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\OnlineInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */