package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class LastLoginInfo
  extends JceStruct
{
  public String contactsInfoEncrypt;
  
  public LastLoginInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.contactsInfoEncrypt = "";
  }
  
  public LastLoginInfo(String paramString)
  {
    this.contactsInfoEncrypt = "";
    this.contactsInfoEncrypt = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.contactsInfoEncrypt = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.contactsInfoEncrypt, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\LastLoginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */