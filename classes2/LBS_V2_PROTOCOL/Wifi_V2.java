package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Wifi_V2
  extends JceStruct
{
  public int iRssi;
  public String strMac;
  
  public Wifi_V2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strMac = "";
  }
  
  public Wifi_V2(String paramString, int paramInt)
  {
    this.strMac = "";
    this.strMac = paramString;
    this.iRssi = paramInt;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.strMac, "strMac");
    paramStringBuilder.display(this.iRssi, "iRssi");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strMac = paramJceInputStream.readString(0, true);
    this.iRssi = paramJceInputStream.read(this.iRssi, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strMac, 0);
    paramJceOutputStream.write(this.iRssi, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBS_V2_PROTOCOL\Wifi_V2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */