package com.tencent.mobileqq.openapi.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public class ApiUtilsExt
{
  private static final String a = "MobileQQApi.Util";
  
  public ApiUtilsExt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static final String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.tencent.mobileqq", 128).metaData.getString("TencentOpenAbility");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static final Map a(Context paramContext)
  {
    HashMap localHashMap = null;
    Object localObject = a(paramContext);
    paramContext = localHashMap;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      localHashMap = new HashMap(localObject.length);
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        paramContext = localHashMap;
        if (i >= j) {
          break;
        }
        paramContext = localObject[i].split("_");
        if (paramContext.length == 2) {
          localHashMap.put(paramContext[0], Integer.valueOf(Integer.parseInt(paramContext[1])));
        }
        i += 1;
      }
    }
    return paramContext;
  }
  
  public static final boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  public static final boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 4) || (paramInt == 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\openapi\sdk\ApiUtilsExt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */