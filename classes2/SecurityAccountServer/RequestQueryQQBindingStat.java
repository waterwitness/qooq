package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestQueryQQBindingStat
  extends JceStruct
{
  public String MobileUniqueNo;
  
  public RequestQueryQQBindingStat()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.MobileUniqueNo = "";
  }
  
  public RequestQueryQQBindingStat(String paramString)
  {
    this.MobileUniqueNo = "";
    this.MobileUniqueNo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MobileUniqueNo = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestQueryQQBindingStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */