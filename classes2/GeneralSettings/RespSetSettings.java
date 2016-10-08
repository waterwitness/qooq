package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespSetSettings
  extends JceStruct
{
  public int Revision;
  
  public RespSetSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespSetSettings(int paramInt)
  {
    this.Revision = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Revision = paramJceInputStream.read(this.Revision, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Revision, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GeneralSettings\RespSetSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */