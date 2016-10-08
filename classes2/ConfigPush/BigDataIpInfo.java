package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class BigDataIpInfo
  extends JceStruct
{
  public String sIp;
  public long uPort;
  public long uType;
  
  public BigDataIpInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sIp = "";
  }
  
  public BigDataIpInfo(long paramLong1, String paramString, long paramLong2)
  {
    this.sIp = "";
    this.uType = paramLong1;
    this.sIp = paramString;
    this.uPort = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uType = paramJceInputStream.read(this.uType, 0, true);
    this.sIp = paramJceInputStream.readString(1, true);
    this.uPort = paramJceInputStream.read(this.uPort, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uType, 0);
    paramJceOutputStream.write(this.sIp, 1);
    paramJceOutputStream.write(this.uPort, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\BigDataIpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */