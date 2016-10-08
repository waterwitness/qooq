package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Attr
  extends JceStruct
{
  public String strImei;
  public String strImsi;
  public String strPhonenum;
  
  public Attr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strImei = "";
    this.strImsi = "";
    this.strPhonenum = "";
  }
  
  public Attr(String paramString1, String paramString2, String paramString3)
  {
    this.strImei = "";
    this.strImsi = "";
    this.strPhonenum = "";
    this.strImei = paramString1;
    this.strImsi = paramString2;
    this.strPhonenum = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strImei = paramJceInputStream.readString(0, false);
    this.strImsi = paramJceInputStream.readString(1, false);
    this.strPhonenum = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strImei != null) {
      paramJceOutputStream.write(this.strImei, 0);
    }
    if (this.strImsi != null) {
      paramJceOutputStream.write(this.strImsi, 1);
    }
    if (this.strPhonenum != null) {
      paramJceOutputStream.write(this.strPhonenum, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyPubAcct\Attr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */