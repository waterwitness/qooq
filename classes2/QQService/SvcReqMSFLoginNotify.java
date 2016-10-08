package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcReqMSFLoginNotify
  extends JceStruct
{
  public byte cStatus;
  public byte cTablet;
  public long iAppId;
  public long iPlatform;
  public long iProductType;
  public String strInfo;
  public String strTitle;
  
  public SvcReqMSFLoginNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strTitle = "";
    this.strInfo = "";
  }
  
  public SvcReqMSFLoginNotify(long paramLong1, byte paramByte1, byte paramByte2, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.strTitle = "";
    this.strInfo = "";
    this.iAppId = paramLong1;
    this.cStatus = paramByte1;
    this.cTablet = paramByte2;
    this.iPlatform = paramLong2;
    this.strTitle = paramString1;
    this.strInfo = paramString2;
    this.iProductType = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 0, true);
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.cTablet = paramJceInputStream.read(this.cTablet, 2, false);
    this.iPlatform = paramJceInputStream.read(this.iPlatform, 3, false);
    this.strTitle = paramJceInputStream.readString(4, false);
    this.strInfo = paramJceInputStream.readString(5, false);
    this.iProductType = paramJceInputStream.read(this.iProductType, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 0);
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.cTablet, 2);
    paramJceOutputStream.write(this.iPlatform, 3);
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 4);
    }
    if (this.strInfo != null) {
      paramJceOutputStream.write(this.strInfo, 5);
    }
    paramJceOutputStream.write(this.iProductType, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\SvcReqMSFLoginNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */