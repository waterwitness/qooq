package com.tencent.bitapp.module;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.utils.FileUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public enum ModuleDependency
{
  INSTANCE;
  
  private static final String TAG = ModuleDependency.class.getSimpleName();
  private Map<String, Denpendency> mDependencyMap = null;
  
  public Denpendency addDependencies(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    Object localObject;
    if (!paramBoolean)
    {
      localObject = (Denpendency)this.mDependencyMap.get(paramString);
      if (localObject != null) {
        return (Denpendency)localObject;
      }
      bool = true;
    }
    if (bool)
    {
      localObject = Module.getListFile(paramString);
      if (FileUtils.isFileExist((String)localObject))
      {
        localObject = new Denpendency((String)localObject);
        this.mDependencyMap.put(paramString, localObject);
        return (Denpendency)localObject;
      }
      return null;
    }
    return null;
  }
  
  public void addDependencies(String paramString)
  {
    addDependencies(paramString, false);
  }
  
  public void clear()
  {
    this.mDependencyMap.clear();
  }
  
  public Set<String> getDependencies(String paramString)
  {
    Denpendency localDenpendency2 = (Denpendency)this.mDependencyMap.get(paramString);
    Denpendency localDenpendency1 = localDenpendency2;
    if (localDenpendency2 == null) {
      localDenpendency1 = addDependencies(paramString, false);
    }
    if ((localDenpendency1 == null) || (localDenpendency1.getModuleId() == null) || (localDenpendency1.getModuleId().size() == 0)) {
      return new HashSet();
    }
    return localDenpendency1.getModuleId();
  }
  
  public Set<BundleStruct> getDependenciesStruct(String paramString)
  {
    Denpendency localDenpendency2 = (Denpendency)this.mDependencyMap.get(paramString);
    Denpendency localDenpendency1 = localDenpendency2;
    if (localDenpendency2 == null) {
      localDenpendency1 = addDependencies(paramString, false);
    }
    if ((localDenpendency1 == null) || (localDenpendency1.getBundleStruct() == null) || (localDenpendency1.getBundleStruct().size() == 0)) {
      return new HashSet();
    }
    return localDenpendency1.getBundleStruct();
  }
  
  class Denpendency
  {
    private Set<BundleStruct> mBundleStruct = null;
    private Set<String> mModuleIds = null;
    private String mPath = null;
    
    public Denpendency(String paramString)
    {
      this.mPath = paramString;
    }
    
    private void parseDenpendencies()
    {
      this.mModuleIds = new HashSet();
      this.mBundleStruct = new HashSet();
      String str = FileUtils.readFileByBytesToString(this.mPath, "utf-8");
      if (!TextUtils.isEmpty(str))
      {
        int j;
        int i;
        do
        {
          try
          {
            localJSONArray = new JSONArray(str);
            if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
              break;
            }
            j = localJSONArray.length();
            i = 0;
          }
          catch (Exception localException)
          {
            JSONArray localJSONArray;
            Object localObject;
            int k;
            int m;
            boolean bool;
            if (!FLog.isLoggable(3)) {
              break;
            }
          }
          localObject = localJSONArray.getJSONObject(i);
          k = ((JSONObject)localObject).getInt("module_id");
          m = ((JSONObject)localObject).getInt("module_version");
          bool = ((JSONObject)localObject).getBoolean("decrypt");
          if ((k > 0) && (m > 0))
          {
            this.mModuleIds.add(String.valueOf(k));
            localObject = new BundleStruct(k);
            ((BundleStruct)localObject).module_version = m;
            ((BundleStruct)localObject).decrypt = bool;
            this.mBundleStruct.add(localObject);
          }
          i += 1;
          continue;
          FLog.i(ModuleDependency.TAG, "parseDenpendencies Could not parse data: " + str);
          return;
        } while (i < j);
      }
    }
    
    public Set<BundleStruct> getBundleStruct()
    {
      if ((this.mBundleStruct == null) && (!TextUtils.isEmpty(this.mPath))) {
        parseDenpendencies();
      }
      return this.mBundleStruct;
    }
    
    public Set<String> getModuleId()
    {
      if ((this.mModuleIds == null) && (!TextUtils.isEmpty(this.mPath))) {
        parseDenpendencies();
      }
      return this.mModuleIds;
    }
    
    public String getPath()
    {
      return this.mPath;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\ModuleDependency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */