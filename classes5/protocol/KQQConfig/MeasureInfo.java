package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MeasureInfo
  extends JceStruct
{
  public byte bDefault;
  public byte bLinkType;
  public byte bProxy;
  public int iPort;
  public String sIP;
  public String sImsi;
  
  public MeasureInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sIP = "";
    this.sImsi = "";
    this.bProxy = 1;
    this.bDefault = 1;
  }
  
  public MeasureInfo(String paramString1, int paramInt, byte paramByte1, String paramString2, byte paramByte2, byte paramByte3)
  {
    this.sIP = "";
    this.sImsi = "";
    this.bProxy = 1;
    this.bDefault = 1;
    this.sIP = paramString1;
    this.iPort = paramInt;
    this.bLinkType = paramByte1;
    this.sImsi = paramString2;
    this.bProxy = paramByte2;
    this.bDefault = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIP = paramJceInputStream.readString(1, true);
    this.iPort = paramJceInputStream.read(this.iPort, 2, true);
    this.bLinkType = paramJceInputStream.read(this.bLinkType, 3, true);
    this.sImsi = paramJceInputStream.readString(4, false);
    this.bProxy = paramJceInputStream.read(this.bProxy, 5, false);
    this.bDefault = paramJceInputStream.read(this.bDefault, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sIP, 1);
    paramJceOutputStream.write(this.iPort, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    if (this.sImsi != null) {
      paramJceOutputStream.write(this.sImsi, 4);
    }
    paramJceOutputStream.write(this.bProxy, 5);
    paramJceOutputStream.write(this.bDefault, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\MeasureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */