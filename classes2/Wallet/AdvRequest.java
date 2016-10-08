package Wallet;

import NearbyGroup.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class AdvRequest
  extends JceStruct
{
  static LBSInfo cache_lbsInfo = new LBSInfo();
  public long id;
  public String ip = "";
  public LBSInfo lbsInfo;
  public long platform;
  public String spid = "";
  public String uin = "";
  public String version = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 1, false));
    this.version = paramJceInputStream.readString(2, false);
    this.platform = paramJceInputStream.read(this.platform, 3, false);
    this.uin = paramJceInputStream.readString(4, false);
    this.ip = paramJceInputStream.readString(5, false);
    this.spid = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.lbsInfo != null) {
      paramJceOutputStream.write(this.lbsInfo, 1);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 2);
    }
    paramJceOutputStream.write(this.platform, 3);
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 4);
    }
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 5);
    }
    if (this.spid != null) {
      paramJceOutputStream.write(this.spid, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\AdvRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */