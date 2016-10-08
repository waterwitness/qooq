package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QQRobertInfo
  extends JceStruct
{
  public String actionUrl;
  public String nickname;
  
  public QQRobertInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nickname = "";
    this.actionUrl = "";
  }
  
  public QQRobertInfo(String paramString1, String paramString2)
  {
    this.nickname = "";
    this.actionUrl = "";
    this.nickname = paramString1;
    this.actionUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, true);
    this.actionUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nickname, 0);
    if (this.actionUrl != null) {
      paramJceOutputStream.write(this.actionUrl, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\QQRobertInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */