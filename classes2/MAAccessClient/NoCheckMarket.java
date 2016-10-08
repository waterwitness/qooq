package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class NoCheckMarket
  extends JceStruct
{
  public String pkgName;
  public String signatureMd5;
  public int versionCode;
  
  public NoCheckMarket()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.pkgName = "";
    this.signatureMd5 = "";
  }
  
  public NoCheckMarket(String paramString1, String paramString2, int paramInt)
  {
    this.pkgName = "";
    this.signatureMd5 = "";
    this.pkgName = paramString1;
    this.signatureMd5 = paramString2;
    this.versionCode = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgName = paramJceInputStream.readString(0, false);
    this.signatureMd5 = paramJceInputStream.readString(1, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.pkgName != null) {
      paramJceOutputStream.write(this.pkgName, 0);
    }
    if (this.signatureMd5 != null) {
      paramJceOutputStream.write(this.signatureMd5, 1);
    }
    paramJceOutputStream.write(this.versionCode, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MAAccessClient\NoCheckMarket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */