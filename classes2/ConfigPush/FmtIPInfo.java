package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class FmtIPInfo
  extends JceStruct
{
  public long iGateIpOper;
  public String sGateIp;
  
  public FmtIPInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sGateIp = "";
  }
  
  public FmtIPInfo(String paramString, long paramLong)
  {
    this.sGateIp = "";
    this.sGateIp = paramString;
    this.iGateIpOper = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sGateIp = paramJceInputStream.readString(0, true);
    this.iGateIpOper = paramJceInputStream.read(this.iGateIpOper, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sGateIp, 0);
    paramJceOutputStream.write(this.iGateIpOper, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\FmtIPInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */