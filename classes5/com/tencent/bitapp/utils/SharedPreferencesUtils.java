package com.tencent.bitapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.bitapp.bundle.BundleStruct;

public class SharedPreferencesUtils
{
  public static final String BITAPP_CONFIG = "bitapp_config";
  public static final String FILE_BUNDLE_STRUCT_PREX = "file_bundle_struct_prex";
  public static final String FILE_MD5_PREX = "file_md5_prex";
  
  public static String get(Context paramContext, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString)) {
        str1 = paramContext.getSharedPreferences("bitapp_config", 0).getString(paramString, "");
      }
    }
    return str1;
  }
  
  public static String getBundleStruct(Context paramContext, int paramInt)
  {
    return get(paramContext, "file_bundle_struct_prex_" + paramInt);
  }
  
  public static String getMd5(Context paramContext, String paramString)
  {
    paramString = Md5Utils.getMD5(paramString);
    return get(paramContext, "file_md5_prex_" + paramString);
  }
  
  public static boolean set(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = paramContext.getSharedPreferences("bitapp_config", 0).edit();
        paramContext.putString(paramString1, paramString2);
        bool1 = paramContext.commit();
      }
    }
    return bool1;
  }
  
  public static boolean setBundleStruct(Context paramContext, BundleStruct paramBundleStruct)
  {
    String str = paramBundleStruct.toString();
    return set(paramContext, "file_bundle_struct_prex_" + paramBundleStruct.module_id, str);
  }
  
  public static boolean setMd5(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = Md5Utils.getMD5(paramString1);
    return set(paramContext, "file_md5_prex_" + paramString1, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */