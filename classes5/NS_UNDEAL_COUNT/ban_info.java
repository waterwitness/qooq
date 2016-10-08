package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ban_info
  extends JceStruct
{
  public byte iBanLevel;
  public String strMessage;
  
  public ban_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strMessage = "";
  }
  
  public ban_info(byte paramByte, String paramString)
  {
    this.strMessage = "";
    this.iBanLevel = paramByte;
    this.strMessage = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iBanLevel = paramJceInputStream.read(this.iBanLevel, 0, false);
    this.strMessage = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iBanLevel, 0);
    if (this.strMessage != null) {
      paramJceOutputStream.write(this.strMessage, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\ban_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */