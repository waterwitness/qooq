package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PrePayRqt
  extends JceStruct
  implements Cloneable
{
  public String MQOS;
  public String MQVersion;
  public String appId;
  public String appVersion;
  public String bundleID;
  public String nonceStr;
  public String packageName;
  public String payPackage;
  public String paySign;
  public String phoneModel;
  public String sha;
  public String signType;
  public int sourceType;
  public String sourceUrl;
  public String timeStamp;
  
  public PrePayRqt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.appId = "";
    this.timeStamp = "";
    this.nonceStr = "";
    this.payPackage = "";
    this.signType = "";
    this.paySign = "";
    this.MQVersion = "";
    this.MQOS = "";
    this.phoneModel = "";
    this.sourceUrl = "";
    this.appVersion = "";
    this.packageName = "";
    this.sha = "";
    this.bundleID = "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appId = paramJceInputStream.readString(0, true);
    this.timeStamp = paramJceInputStream.readString(1, true);
    this.nonceStr = paramJceInputStream.readString(2, true);
    this.payPackage = paramJceInputStream.readString(3, true);
    this.signType = paramJceInputStream.readString(4, true);
    this.paySign = paramJceInputStream.readString(5, true);
    this.MQVersion = paramJceInputStream.readString(6, false);
    this.MQOS = paramJceInputStream.readString(7, false);
    this.phoneModel = paramJceInputStream.readString(8, false);
    this.sourceType = paramJceInputStream.read(this.sourceType, 9, true);
    this.sourceUrl = paramJceInputStream.readString(10, false);
    this.appVersion = paramJceInputStream.readString(11, false);
    this.packageName = paramJceInputStream.readString(12, false);
    this.sha = paramJceInputStream.readString(13, false);
    this.bundleID = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.nonceStr, 2);
    paramJceOutputStream.write(this.payPackage, 3);
    paramJceOutputStream.write(this.signType, 4);
    paramJceOutputStream.write(this.paySign, 5);
    if (this.MQVersion != null) {
      paramJceOutputStream.write(this.MQVersion, 6);
    }
    if (this.MQOS != null) {
      paramJceOutputStream.write(this.MQOS, 7);
    }
    if (this.phoneModel != null) {
      paramJceOutputStream.write(this.phoneModel, 8);
    }
    paramJceOutputStream.write(this.sourceType, 9);
    if (this.sourceUrl != null) {
      paramJceOutputStream.write(this.sourceUrl, 10);
    }
    if (this.appVersion != null) {
      paramJceOutputStream.write(this.appVersion, 11);
    }
    if (this.packageName != null) {
      paramJceOutputStream.write(this.packageName, 12);
    }
    if (this.sha != null) {
      paramJceOutputStream.write(this.sha, 13);
    }
    if (this.bundleID != null) {
      paramJceOutputStream.write(this.bundleID, 14);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\PrePayRqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */