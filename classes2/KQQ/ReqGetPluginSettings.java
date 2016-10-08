package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqGetPluginSettings
  extends JceStruct
{
  static ArrayList cache_PluginList;
  public ArrayList PluginList;
  
  public ReqGetPluginSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqGetPluginSettings(ArrayList paramArrayList)
  {
    this.PluginList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_PluginList == null)
    {
      cache_PluginList = new ArrayList();
      cache_PluginList.add(Long.valueOf(0L));
    }
    this.PluginList = ((ArrayList)paramJceInputStream.read(cache_PluginList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.PluginList, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ReqGetPluginSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */