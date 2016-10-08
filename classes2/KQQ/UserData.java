package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserData
  extends JceStruct
{
  public byte cIfPushPic;
  
  public UserData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UserData(byte paramByte)
  {
    this.cIfPushPic = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cIfPushPic = paramJceInputStream.read(this.cIfPushPic, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cIfPushPic, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\UserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */