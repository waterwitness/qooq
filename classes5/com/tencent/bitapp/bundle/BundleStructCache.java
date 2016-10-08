package com.tencent.bitapp.bundle;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.utils.SharedPreferencesUtils;
import java.util.Map;
import org.json.JSONObject;

public enum BundleStructCache
{
  INSTANCE;
  
  private Map<Integer, BundleStruct> mBundleStructMap = null;
  
  public void add(BundleStruct paramBundleStruct)
  {
    int i = paramBundleStruct.module_id;
    if (!paramBundleStruct.equals((BundleStruct)this.mBundleStructMap.get(Integer.valueOf(i))))
    {
      this.mBundleStructMap.put(Integer.valueOf(paramBundleStruct.module_id), paramBundleStruct);
      SharedPreferencesUtils.setBundleStruct(ContextUtils.INSTANCE.getApplicationContext(), paramBundleStruct);
    }
    while (!FLog.isLoggable(3)) {
      return;
    }
    FLog.d("React", "Same BundleStruct no need add");
  }
  
  public void clear()
  {
    this.mBundleStructMap.clear();
  }
  
  public BundleStruct get(int paramInt)
  {
    localObject3 = (BundleStruct)this.mBundleStructMap.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject3;
    String str2;
    if (localObject3 == null)
    {
      str2 = SharedPreferencesUtils.getBundleStruct(ContextUtils.INSTANCE.getApplicationContext(), paramInt);
      localObject1 = localObject3;
      if (TextUtils.isEmpty(str2)) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(str2);
        int i = ((JSONObject)localObject1).getInt("module_version");
        int j = ((JSONObject)localObject1).getInt("module_state");
        String str1 = ((JSONObject)localObject1).getString("download_url");
        String str3 = ((JSONObject)localObject1).getString("md5");
        boolean bool1 = true;
        try
        {
          boolean bool2 = ((JSONObject)localObject1).getBoolean("decrypt");
          bool1 = bool2;
        }
        catch (Exception localException1)
        {
          try
          {
            ((BundleStruct)localObject1).module_version = i;
            ((BundleStruct)localObject1).module_state = j;
            ((BundleStruct)localObject1).download_url = str1;
            ((BundleStruct)localObject1).md5 = str3;
            ((BundleStruct)localObject1).decrypt = bool1;
            this.mBundleStructMap.put(Integer.valueOf(paramInt), localObject1);
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = new BundleStruct(paramInt);
            }
            return (BundleStruct)localObject3;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              Object localObject2;
              localObject3 = localObject2;
            }
          }
          localException1 = localException1;
          localException1.printStackTrace();
          continue;
        }
        localObject1 = new BundleStruct(paramInt);
        localObject2 = localObject3;
      }
      catch (Exception localException2) {}
      if (FLog.isLoggable(5))
      {
        FLog.w("React", "Could not parse BundleStruct from: " + str2, localException2);
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\BundleStructCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */