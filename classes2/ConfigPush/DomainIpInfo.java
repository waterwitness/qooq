package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DomainIpInfo
  extends JceStruct
{
  public int uIp;
  public int uPort;
  
  public DomainIpInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DomainIpInfo(int paramInt1, int paramInt2)
  {
    this.uIp = paramInt1;
    this.uPort = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uIp = paramJceInputStream.read(this.uIp, 1, true);
    this.uPort = paramJceInputStream.read(this.uPort, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uIp, 1);
    paramJceOutputStream.write(this.uPort, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\DomainIpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */