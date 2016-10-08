package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetResourceReqInfo
  extends JceStruct
{
  public short sLanType;
  public short sReqType;
  public short sResType;
  public String strPkgName;
  public long uiCurVer;
  public long uiResID;
  
  public GetResourceReqInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strPkgName = "";
  }
  
  public GetResourceReqInfo(long paramLong1, String paramString, long paramLong2, short paramShort1, short paramShort2, short paramShort3)
  {
    this.strPkgName = "";
    this.uiResID = paramLong1;
    this.strPkgName = paramString;
    this.uiCurVer = paramLong2;
    this.sResType = paramShort1;
    this.sLanType = paramShort2;
    this.sReqType = paramShort3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiResID = paramJceInputStream.read(this.uiResID, 1, true);
    this.strPkgName = paramJceInputStream.readString(2, true);
    this.uiCurVer = paramJceInputStream.read(this.uiCurVer, 3, true);
    this.sResType = paramJceInputStream.read(this.sResType, 4, true);
    this.sLanType = paramJceInputStream.read(this.sLanType, 5, true);
    this.sReqType = paramJceInputStream.read(this.sReqType, 6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiResID, 1);
    paramJceOutputStream.write(this.strPkgName, 2);
    paramJceOutputStream.write(this.uiCurVer, 3);
    paramJceOutputStream.write(this.sResType, 4);
    paramJceOutputStream.write(this.sLanType, 5);
    paramJceOutputStream.write(this.sReqType, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\GetResourceReqInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */