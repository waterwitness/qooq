package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CheckSinglePkgSigReq
  extends JceStruct
{
  public String pkgName;
  public String pkgSig;
  public int versionCode;
  
  public CheckSinglePkgSigReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.pkgName = "";
    this.pkgSig = "";
  }
  
  public CheckSinglePkgSigReq(String paramString1, String paramString2, int paramInt)
  {
    this.pkgName = "";
    this.pkgSig = "";
    this.pkgName = paramString1;
    this.pkgSig = paramString2;
    this.versionCode = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgName = paramJceInputStream.readString(0, true);
    this.pkgSig = paramJceInputStream.readString(1, true);
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgName, 0);
    paramJceOutputStream.write(this.pkgSig, 1);
    paramJceOutputStream.write(this.versionCode, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MAAccessClient\CheckSinglePkgSigReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */