package com.tencent.mobileqq.activity.qwallet.preload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadModule
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String baseUrl;
  public boolean isForbidAutoDownload;
  public String name;
  public int option;
  public List preloadResources;
  
  public PreloadModule()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.preloadResources = new ArrayList();
  }
  
  public static PreloadModule parsePreloadModule(JSONObject paramJSONObject)
  {
    boolean bool = true;
    int i = 0;
    localPreloadModule = new PreloadModule();
    try
    {
      localPreloadModule.name = paramJSONObject.optString("module_name");
      localPreloadModule.option = paramJSONObject.optInt("option");
      if (paramJSONObject.optInt("forbid_download") == 1) {}
      for (;;)
      {
        localPreloadModule.isForbidAutoDownload = bool;
        localPreloadModule.baseUrl = paramJSONObject.optString("url_base");
        paramJSONObject = paramJSONObject.optJSONArray("resources");
        while (i < paramJSONObject.length())
        {
          PreloadResource localPreloadResource = PreloadResource.parsePreloadResource(paramJSONObject.getJSONObject(i));
          localPreloadModule.preloadResources.add(localPreloadResource);
          i += 1;
        }
        bool = false;
      }
      return localPreloadModule;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadModule)))
    {
      paramObject = (PreloadModule)paramObject;
      if ((this.name != null) && (this.name.equals(((PreloadModule)paramObject).name))) {
        return true;
      }
    }
    return false;
  }
  
  public void updatePreloadModule(PreloadModule paramPreloadModule)
  {
    this.name = paramPreloadModule.name;
    this.option = paramPreloadModule.option;
    this.isForbidAutoDownload = paramPreloadModule.isForbidAutoDownload;
    this.baseUrl = paramPreloadModule.baseUrl;
    paramPreloadModule = paramPreloadModule.preloadResources.iterator();
    while (paramPreloadModule.hasNext())
    {
      PreloadResource localPreloadResource1 = (PreloadResource)paramPreloadModule.next();
      int i = this.preloadResources.indexOf(localPreloadResource1);
      if (i == -1)
      {
        this.preloadResources.add(localPreloadResource1);
      }
      else
      {
        PreloadResource localPreloadResource2 = (PreloadResource)this.preloadResources.get(i);
        if (!localPreloadResource2.md5.equals(localPreloadResource1.md5)) {}
        for (boolean bool = true;; bool = false)
        {
          localPreloadResource2.needReplace = bool;
          localPreloadResource2.downloadTime = localPreloadResource1.downloadTime;
          localPreloadResource2.invalidTime = localPreloadResource1.invalidTime;
          localPreloadResource2.md5 = localPreloadResource1.md5;
          localPreloadResource2.type = localPreloadResource1.type;
          break;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\preload\PreloadModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */