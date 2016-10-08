package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RspHeader
  extends JceStruct
{
  static int cache_eResult;
  static int cache_eUinType;
  public int eResult;
  public int eUinType;
  public short shVersion;
  public String strCookie;
  public String strErrMsg;
  public String strUin;
  
  public RspHeader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.shVersion = 2;
    this.strUin = "";
    this.strCookie = "";
    this.strErrMsg = "";
  }
  
  public RspHeader(short paramShort, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    this.shVersion = 2;
    this.strUin = "";
    this.strCookie = "";
    this.strErrMsg = "";
    this.shVersion = paramShort;
    this.eUinType = paramInt1;
    this.strUin = paramString1;
    this.strCookie = paramString2;
    this.eResult = paramInt2;
    this.strErrMsg = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.eUinType = paramJceInputStream.read(this.eUinType, 1, true);
    this.strUin = paramJceInputStream.readString(2, true);
    this.strCookie = paramJceInputStream.readString(3, true);
    this.eResult = paramJceInputStream.read(this.eResult, 4, true);
    this.strErrMsg = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.eUinType, 1);
    paramJceOutputStream.write(this.strUin, 2);
    paramJceOutputStream.write(this.strCookie, 3);
    paramJceOutputStream.write(this.eResult, 4);
    paramJceOutputStream.write(this.strErrMsg, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBSAddrProtocol\RspHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */