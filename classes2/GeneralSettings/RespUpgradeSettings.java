package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespUpgradeSettings
  extends JceStruct
{
  public int Result;
  
  public RespUpgradeSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespUpgradeSettings(int paramInt)
  {
    this.Result = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Result = paramJceInputStream.read(this.Result, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Result, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GeneralSettings\RespUpgradeSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */