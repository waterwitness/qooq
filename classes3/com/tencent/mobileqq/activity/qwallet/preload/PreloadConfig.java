package com.tencent.mobileqq.activity.qwallet.preload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public List preloadModules;
  
  public PreloadConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.preloadModules = new ArrayList();
  }
  
  public void addOrMerge(JSONObject paramJSONObject)
  {
    paramJSONObject = PreloadModule.parsePreloadModule(paramJSONObject);
    int i = this.preloadModules.indexOf(paramJSONObject);
    if (i != -1)
    {
      ((PreloadModule)this.preloadModules.get(i)).updatePreloadModule(paramJSONObject);
      return;
    }
    this.preloadModules.add(paramJSONObject);
  }
  
  public PreloadModule getModuleByName(String paramString)
  {
    PreloadModule localPreloadModule = new PreloadModule();
    localPreloadModule.name = paramString;
    int i = this.preloadModules.indexOf(localPreloadModule);
    paramString = localPreloadModule;
    if (i != -1) {
      paramString = (PreloadModule)this.preloadModules.get(i);
    }
    return paramString;
  }
  
  public void parsePreloadConfig(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("module_config");
      int i = 0;
      while (i < paramString.length())
      {
        addOrMerge(paramString.getJSONObject(i));
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\preload\PreloadConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */