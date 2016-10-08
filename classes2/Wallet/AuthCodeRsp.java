package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class AuthCodeRsp
  extends JceStruct
{
  static ArrayList cache_items;
  public long iNextReqTime;
  public ArrayList items;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_items = new ArrayList();
    AuthCodeItem localAuthCodeItem = new AuthCodeItem();
    cache_items.add(localAuthCodeItem);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.items = ((ArrayList)paramJceInputStream.read(cache_items, 0, false));
    this.iNextReqTime = paramJceInputStream.read(this.iNextReqTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.items != null) {
      paramJceOutputStream.write(this.items, 0);
    }
    paramJceOutputStream.write(this.iNextReqTime, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\AuthCodeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */