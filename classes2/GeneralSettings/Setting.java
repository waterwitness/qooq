package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Setting
  extends JceStruct
{
  public String Path;
  public String Value;
  
  public Setting()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.Path = "";
    this.Value = "";
  }
  
  public Setting(String paramString1, String paramString2)
  {
    this.Path = "";
    this.Value = "";
    this.Path = paramString1;
    this.Value = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Path = paramJceInputStream.readString(0, true);
    this.Value = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Path, 0);
    if (this.Value != null) {
      paramJceOutputStream.write(this.Value, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GeneralSettings\Setting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */