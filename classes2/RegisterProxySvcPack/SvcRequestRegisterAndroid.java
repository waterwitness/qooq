package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcRequestRegisterAndroid
  extends JceStruct
{
  public long ulRequestOptional;
  
  public SvcRequestRegisterAndroid()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRequestRegisterAndroid(long paramLong)
  {
    this.ulRequestOptional = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ulRequestOptional = paramJceInputStream.read(this.ulRequestOptional, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ulRequestOptional, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\SvcRequestRegisterAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */