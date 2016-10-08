package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class AuthCodeReq
  extends JceStruct
{
  static ArrayList cache_apps;
  public ArrayList apps;
  public String skey = "";
  public long uin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_apps = new ArrayList();
    cache_apps.add(Long.valueOf(0L));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.skey = paramJceInputStream.readString(1, false);
    this.apps = ((ArrayList)paramJceInputStream.read(cache_apps, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.skey != null) {
      paramJceOutputStream.write(this.skey, 1);
    }
    if (this.apps != null) {
      paramJceOutputStream.write(this.apps, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\AuthCodeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */