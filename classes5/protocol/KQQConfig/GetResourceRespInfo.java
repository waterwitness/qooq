package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetResourceRespInfo
  extends JceStruct
{
  public int iResult;
  public short sLanType;
  public short sPriority;
  public short sResType;
  public String strPkgName;
  public String strResConf;
  public String strResDesc;
  public String strResName;
  public String strResURL_big;
  public String strResURL_small;
  public long uiNewVer;
  public long uiResID;
  
  public GetResourceRespInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strPkgName = "";
    this.strResName = "";
    this.strResDesc = "";
    this.strResURL_big = "";
    this.strResURL_small = "";
    this.strResConf = "";
  }
  
  public GetResourceRespInfo(int paramInt, long paramLong1, String paramString1, long paramLong2, short paramShort1, short paramShort2, short paramShort3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.strPkgName = "";
    this.strResName = "";
    this.strResDesc = "";
    this.strResURL_big = "";
    this.strResURL_small = "";
    this.strResConf = "";
    this.iResult = paramInt;
    this.uiResID = paramLong1;
    this.strPkgName = paramString1;
    this.uiNewVer = paramLong2;
    this.sResType = paramShort1;
    this.sLanType = paramShort2;
    this.sPriority = paramShort3;
    this.strResName = paramString2;
    this.strResDesc = paramString3;
    this.strResURL_big = paramString4;
    this.strResURL_small = paramString5;
    this.strResConf = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    this.uiResID = paramJceInputStream.read(this.uiResID, 2, true);
    this.strPkgName = paramJceInputStream.readString(3, true);
    this.uiNewVer = paramJceInputStream.read(this.uiNewVer, 4, true);
    this.sResType = paramJceInputStream.read(this.sResType, 5, true);
    this.sLanType = paramJceInputStream.read(this.sLanType, 6, true);
    this.sPriority = paramJceInputStream.read(this.sPriority, 7, true);
    this.strResName = paramJceInputStream.readString(8, true);
    this.strResDesc = paramJceInputStream.readString(9, true);
    this.strResURL_big = paramJceInputStream.readString(10, true);
    this.strResURL_small = paramJceInputStream.readString(11, true);
    this.strResConf = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.uiResID, 2);
    paramJceOutputStream.write(this.strPkgName, 3);
    paramJceOutputStream.write(this.uiNewVer, 4);
    paramJceOutputStream.write(this.sResType, 5);
    paramJceOutputStream.write(this.sLanType, 6);
    paramJceOutputStream.write(this.sPriority, 7);
    paramJceOutputStream.write(this.strResName, 8);
    paramJceOutputStream.write(this.strResDesc, 9);
    paramJceOutputStream.write(this.strResURL_big, 10);
    paramJceOutputStream.write(this.strResURL_small, 11);
    if (this.strResConf != null) {
      paramJceOutputStream.write(this.strResConf, 12);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\GetResourceRespInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */