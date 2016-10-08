package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqSetSettings
  extends JceStruct
{
  static ArrayList cache_Settings;
  public ArrayList Settings;
  
  public ReqSetSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqSetSettings(ArrayList paramArrayList)
  {
    this.Settings = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_Settings == null)
    {
      cache_Settings = new ArrayList();
      Setting localSetting = new Setting();
      cache_Settings.add(localSetting);
    }
    this.Settings = ((ArrayList)paramJceInputStream.read(cache_Settings, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Settings, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GeneralSettings\ReqSetSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */