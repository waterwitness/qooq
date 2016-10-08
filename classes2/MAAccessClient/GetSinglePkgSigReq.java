package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetSinglePkgSigReq
  extends JceStruct
{
  public String pkgName;
  public int versionCode;
  
  public GetSinglePkgSigReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.pkgName = "";
  }
  
  public GetSinglePkgSigReq(String paramString, int paramInt)
  {
    this.pkgName = "";
    this.pkgName = paramString;
    this.versionCode = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgName = paramJceInputStream.readString(0, true);
    this.versionCode = paramJceInputStream.read(this.versionCode, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgName, 0);
    paramJceOutputStream.write(this.versionCode, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MAAccessClient\GetSinglePkgSigReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */