package com.sixgod.pluginsdk;

import android.text.TextUtils;
import com.sixgod.pluginsdk.log.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginLoadParams
{
  public String apkPath = "";
  public Map componentMap = null;
  public String defaultActivityContainer = "";
  public String defaultLoadApkActivity = "";
  public String defaultServiceContainer = "";
  public int defaultTheme = 0;
  public boolean defaultUseActionBar = false;
  public ArrayList libList = null;
  public int loadTransTheme = 0;
  public boolean mLoadInMainProcess = true;
  public String pkgName = "";
  public PluginCallback pluginLoadCallBack;
  public String pluginName = "";
  public int pluginResourceFlag = 0;
  public boolean preload = false;
  public String processName;
  public Map serviceActionMap = null;
  public List singleTaskContainers = new ArrayList();
  public List singleTopContainers = new ArrayList();
  public boolean useBootClassLoader = false;
  public boolean useJni = true;
  public String versionName = "";
  
  protected PluginLoadParams()
  {
    this.componentMap = new HashMap();
    this.libList = new ArrayList();
  }
  
  public PluginLoadParams(String paramString1, String paramString2, String paramString3)
  {
    this.apkPath = paramString1;
    this.pluginName = paramString3;
    this.pkgName = paramString2;
    this.componentMap = new HashMap();
    this.serviceActionMap = new HashMap();
    this.libList = new ArrayList();
  }
  
  public static PluginLoadParams parseFromJson(String paramString)
  {
    int j = 0;
    PluginLoadParams localPluginLoadParams = new PluginLoadParams();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localPluginLoadParams.apkPath = paramString.optString("apkPath");
        localPluginLoadParams.pluginName = paramString.optString("pluginName");
        localPluginLoadParams.pkgName = paramString.optString("pkgName");
        localPluginLoadParams.useJni = paramString.optBoolean("useJni");
        localPluginLoadParams.pluginResourceFlag = paramString.optInt("pluginResourceFlag");
        localPluginLoadParams.defaultUseActionBar = paramString.optBoolean("defaultUseActionBar");
        localPluginLoadParams.useBootClassLoader = paramString.optBoolean("useBootClassLoader");
        localPluginLoadParams.defaultActivityContainer = paramString.optString("defaultActivityContainer");
        localPluginLoadParams.defaultServiceContainer = paramString.optString("defaultServiceContainer");
        localPluginLoadParams.versionName = paramString.optString("versionName");
        JSONArray localJSONArray = paramString.optJSONArray("componentMap");
        int k;
        Object localObject;
        String str;
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k = localJSONArray.length();
          i = 0;
          if (i < k)
          {
            localObject = localJSONArray.getJSONObject(i);
            str = ((JSONObject)localObject).optString("key");
            localObject = ((JSONObject)localObject).optString("value");
            if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label541;
            }
            localPluginLoadParams.componentMap.put(str, localObject);
            break label541;
          }
        }
        localJSONArray = paramString.optJSONArray("actionMap");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k = localJSONArray.length();
          i = 0;
          if (i < k)
          {
            localObject = localJSONArray.getJSONObject(i);
            str = ((JSONObject)localObject).optString("key");
            localObject = ((JSONObject)localObject).optString("value");
            if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label550;
            }
            localPluginLoadParams.serviceActionMap.put(str, localObject);
            break label550;
          }
        }
        localJSONArray = paramString.optJSONArray("libList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          k = localJSONArray.length();
          i = 0;
          if (i < k)
          {
            localPluginLoadParams.libList.add(localJSONArray.getString(i));
            i += 1;
            continue;
          }
        }
        localJSONArray = paramString.optJSONArray("singleTasks");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i = 0;
          k = localJSONArray.length();
          if (i < k) {
            try
            {
              localPluginLoadParams.singleTaskContainers.add(Class.forName(localJSONArray.optString(i)));
              i += 1;
            }
            catch (Exception localException2)
            {
              a.b("parseSingleTask failed, msg = " + localException2.getMessage());
              continue;
            }
          }
        }
        paramString = paramString.optJSONArray("singleTops");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localPluginLoadParams;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        i = j;
        for (;;)
        {
          j = paramString.length();
          if (i >= j) {
            break;
          }
          try
          {
            localPluginLoadParams.singleTopContainers.add(Class.forName(paramString.optString(i)));
            i += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              a.b("parseSingTop failed, msg = " + localException1.getMessage());
            }
          }
        }
        label541:
        i += 1;
        continue;
        label550:
        i += 1;
      }
    }
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject1 = new JSONObject();
    Iterator localIterator;
    Map.Entry localEntry;
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("apkPath", this.apkPath);
      localJSONObject1.put("pluginName", this.pluginName);
      localJSONObject1.put("pkgName", this.pkgName);
      localJSONObject1.put("useJni", this.useJni);
      localJSONObject1.put("pluginResourceFlag", this.pluginResourceFlag);
      localJSONObject1.put("defaultUseActionBar", this.defaultUseActionBar);
      localJSONObject1.put("useBootClassLoader", this.useBootClassLoader);
      localJSONObject1.put("defaultActivityContainer", this.defaultActivityContainer);
      localJSONObject1.put("defaultServiceContainer", this.defaultServiceContainer);
      localJSONObject1.put("versionName", this.versionName);
      JSONArray localJSONArray1 = new JSONArray();
      if (this.componentMap != null)
      {
        localIterator = this.componentMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("key", (String)localEntry.getKey());
          localJSONObject2.put("value", (String)localEntry.getValue());
          localJSONArray1.put(localJSONObject2);
          continue;
          return localJSONObject1.toString();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      localJSONObject1.put("componentMap", localException);
      JSONArray localJSONArray2 = new JSONArray();
      if (this.serviceActionMap != null)
      {
        localIterator = this.serviceActionMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("key", (String)localEntry.getKey());
          localJSONObject2.put("value", (String)localEntry.getValue());
          localJSONArray2.put(localJSONObject2);
        }
      }
      localJSONObject1.put("actionMap", localJSONArray2);
      localJSONArray2 = new JSONArray();
      if (this.libList != null)
      {
        int j = this.libList.size();
        int i = 0;
        while (i < j)
        {
          localJSONArray2.put(this.libList.get(i));
          i += 1;
        }
      }
      localJSONObject1.put("libList", localJSONArray2);
      localJSONArray2 = new JSONArray();
      if (this.singleTaskContainers != null)
      {
        localIterator = this.singleTaskContainers.iterator();
        while (localIterator.hasNext()) {
          localJSONArray2.put(((Class)localIterator.next()).getName());
        }
      }
      localJSONObject1.put("singleTasks", localJSONArray2);
      localJSONArray2 = new JSONArray();
      if (this.singleTopContainers != null)
      {
        localIterator = this.singleTopContainers.iterator();
        while (localIterator.hasNext()) {
          localJSONArray2.put(((Class)localIterator.next()).getName());
        }
      }
      localJSONObject1.put("singleTops", localJSONArray2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\PluginLoadParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */