package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetSinglePkgSigRsp
  extends JceStruct
{
  public String pkgSig;
  public int ret;
  
  public GetSinglePkgSigRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.pkgSig = "";
  }
  
  public GetSinglePkgSigRsp(int paramInt, String paramString)
  {
    this.pkgSig = "";
    this.ret = paramInt;
    this.pkgSig = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.pkgSig = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.pkgSig, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MAAccessClient\GetSinglePkgSigRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */