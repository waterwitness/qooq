package com.tencent.kingkong;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainConfig
{
  private static MainConfig jdField_a_of_type_ComTencentKingkongMainConfig;
  public static final String b = "enabled";
  public static final String c = "disabled";
  public static final String d = "update";
  public static final String e = "install";
  private static final String f = "KingKongMainConfig";
  private static final String g = "app";
  private static final String h = "patches";
  private static final String i = "PATCH_LIST";
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private MainConfig()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private MainConfig(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramContext = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("PATCH_LIST", "").split(";");
    int k = paramContext.length;
    while (j < k)
    {
      Object localObject = paramContext[j];
      if (!((String)localObject).equals(""))
      {
        localObject = new PatchInfo(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        Common.Log.a("KingKongMainConfig", "--> " + localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      j += 1;
    }
  }
  
  public static MainConfig a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentKingkongMainConfig != null) {
      return jdField_a_of_type_ComTencentKingkongMainConfig;
    }
    try
    {
      if (jdField_a_of_type_ComTencentKingkongMainConfig != null)
      {
        paramContext = jdField_a_of_type_ComTencentKingkongMainConfig;
        return paramContext;
      }
    }
    finally {}
    jdField_a_of_type_ComTencentKingkongMainConfig = new MainConfig(paramContext);
    paramContext = jdField_a_of_type_ComTencentKingkongMainConfig;
    return paramContext;
  }
  
  public static MainConfig a(String paramString)
  {
    Common.Log.a("KingKongMainConfig", "Analysing Config File " + paramString);
    Object localObject = DataReport.b();
    if (localObject == null) {
      Common.Log.a("KingKongMainConfig", "Unable to get application name");
    }
    MainConfig localMainConfig;
    for (;;)
    {
      return null;
      localMainConfig = new MainConfig();
      try
      {
        paramString = Utils.a(paramString);
        Common.Log.a("KingKongMainConfig", "Main config : " + paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          paramString = localJSONObject.getJSONArray("patches");
          localMainConfig.jdField_a_of_type_JavaLangString = localJSONObject.getString("app");
          if (!localMainConfig.jdField_a_of_type_JavaLangString.equals(localObject))
          {
            Common.Log.a("KingKongMainConfig", "Application mismatch : " + (String)localObject + ", " + localMainConfig.jdField_a_of_type_JavaLangString);
            return null;
          }
        }
      }
      catch (Exception paramString)
      {
        Common.Log.a("KingKongMainConfig", "Parse main config exception " + paramString);
        return null;
      }
    }
    int j = 0;
    for (;;)
    {
      if (j >= paramString.length()) {
        return localMainConfig;
      }
      localObject = PatchInfo.a(paramString.getJSONObject(j));
      if (localObject == null) {
        break;
      }
      Common.Log.a("KingKongMainConfig", "-->" + localObject);
      localMainConfig.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      j += 1;
    }
    return localMainConfig;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    PatchInfo localPatchInfo;
    for (String str = ""; localIterator.hasNext(); str = str + localPatchInfo.jdField_a_of_type_JavaLangString + ";") {
      localPatchInfo = (PatchInfo)localIterator.next();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public PatchInfo a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (localPatchInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localPatchInfo;
      }
    }
    return null;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.jdField_a_of_type_JavaLangString;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (localPatchInfo.jdField_a_of_type_JavaLangString.equals(str)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localPatchInfo);
      }
    }
    paramPatchInfo.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
    a();
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (localPatchInfo.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localPatchInfo.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localPatchInfo);
      }
    }
    a();
  }
  
  public void b(PatchInfo paramPatchInfo)
  {
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((PatchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_JavaLangString.equals(paramPatchInfo.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (j != -1) {
        this.jdField_a_of_type_JavaUtilArrayList.set(j, paramPatchInfo);
      }
      for (;;)
      {
        paramPatchInfo.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        return;
        j += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramPatchInfo);
        a();
      }
      j = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\MainConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */