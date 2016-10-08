package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqChannel
  extends JceStruct
  implements Cloneable
{
  static LBSInfo cache_lbsInfo;
  public String MQVersion;
  public LBSInfo lbsInfo;
  public int nfcSupported;
  public String phoneModel;
  public int pid;
  public int subCmd;
  
  public ReqChannel()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.phoneModel = "";
    this.MQVersion = "";
  }
  
  public ReqChannel(int paramInt1, int paramInt2, LBSInfo paramLBSInfo, String paramString1, int paramInt3, String paramString2)
  {
    this.phoneModel = "";
    this.MQVersion = "";
    this.subCmd = paramInt1;
    this.pid = paramInt2;
    this.lbsInfo = paramLBSInfo;
    this.phoneModel = paramString1;
    this.nfcSupported = paramInt3;
    this.MQVersion = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subCmd = paramJceInputStream.read(this.subCmd, 0, true);
    this.pid = paramJceInputStream.read(this.pid, 1, true);
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 2, true));
    this.phoneModel = paramJceInputStream.readString(3, true);
    this.nfcSupported = paramJceInputStream.read(this.nfcSupported, 4, false);
    this.MQVersion = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subCmd, 0);
    paramJceOutputStream.write(this.pid, 1);
    paramJceOutputStream.write(this.lbsInfo, 2);
    paramJceOutputStream.write(this.phoneModel, 3);
    paramJceOutputStream.write(this.nfcSupported, 4);
    if (this.MQVersion != null) {
      paramJceOutputStream.write(this.MQVersion, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\CardPay\ReqChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */