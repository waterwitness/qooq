package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetSettings
  extends JceStruct
{
  static ArrayList cache_Settings;
  public int Revision;
  public ArrayList Settings;
  public long Total;
  
  public RespGetSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespGetSettings(int paramInt, ArrayList paramArrayList, long paramLong)
  {
    this.Revision = paramInt;
    this.Settings = paramArrayList;
    this.Total = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Revision = paramJceInputStream.read(this.Revision, 0, true);
    if (cache_Settings == null)
    {
      cache_Settings = new ArrayList();
      Setting localSetting = new Setting();
      cache_Settings.add(localSetting);
    }
    this.Settings = ((ArrayList)paramJceInputStream.read(cache_Settings, 1, false));
    this.Total = paramJceInputStream.read(this.Total, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Revision, 0);
    if (this.Settings != null) {
      paramJceOutputStream.write(this.Settings, 1);
    }
    paramJceOutputStream.write(this.Total, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GeneralSettings\RespGetSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */