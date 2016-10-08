package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserInfo
  extends JceStruct
{
  public String aid;
  public String clientIp;
  public int isIOSJailbreak;
  public String platform;
  public String type;
  public String uin;
  public String version;
  
  public UserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uin = "";
    this.platform = "";
    this.clientIp = "";
    this.aid = "";
    this.version = "";
    this.type = "";
  }
  
  public UserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this.uin = "";
    this.platform = "";
    this.clientIp = "";
    this.aid = "";
    this.version = "";
    this.type = "";
    this.uin = paramString1;
    this.platform = paramString2;
    this.clientIp = paramString3;
    this.aid = paramString4;
    this.version = paramString5;
    this.isIOSJailbreak = paramInt;
    this.type = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, true);
    this.platform = paramJceInputStream.readString(1, true);
    this.clientIp = paramJceInputStream.readString(2, true);
    this.aid = paramJceInputStream.readString(3, true);
    this.version = paramJceInputStream.readString(4, true);
    this.isIOSJailbreak = paramJceInputStream.read(this.isIOSJailbreak, 5, false);
    this.type = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.platform, 1);
    paramJceOutputStream.write(this.clientIp, 2);
    paramJceOutputStream.write(this.aid, 3);
    paramJceOutputStream.write(this.version, 4);
    paramJceOutputStream.write(this.isIOSJailbreak, 5);
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\VipRecommend\MQQ\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */