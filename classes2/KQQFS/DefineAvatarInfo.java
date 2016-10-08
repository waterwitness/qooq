package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DefineAvatarInfo
  extends JceStruct
{
  public byte cImgFmt;
  public byte cImgStyle;
  
  public DefineAvatarInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DefineAvatarInfo(byte paramByte1, byte paramByte2)
  {
    this.cImgStyle = paramByte1;
    this.cImgFmt = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cImgStyle = paramJceInputStream.read(this.cImgStyle, 0, true);
    this.cImgFmt = paramJceInputStream.read(this.cImgFmt, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cImgStyle, 0);
    paramJceOutputStream.write(this.cImgFmt, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQFS\DefineAvatarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */