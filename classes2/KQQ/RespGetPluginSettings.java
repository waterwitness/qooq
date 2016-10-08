package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetPluginSettings
  extends JceStruct
{
  static ArrayList cache_PluginInfoList;
  public ArrayList PluginInfoList;
  
  public RespGetPluginSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespGetPluginSettings(ArrayList paramArrayList)
  {
    this.PluginInfoList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_PluginInfoList == null)
    {
      cache_PluginInfoList = new ArrayList();
      PluginInfo localPluginInfo = new PluginInfo();
      cache_PluginInfoList.add(localPluginInfo);
    }
    this.PluginInfoList = ((ArrayList)paramJceInputStream.read(cache_PluginInfoList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.PluginInfoList, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\RespGetPluginSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */