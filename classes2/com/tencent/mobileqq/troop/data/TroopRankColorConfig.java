package com.tencent.mobileqq.troop.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopRankColorConfig
{
  private static TroopRankColorConfig a;
  public static final String a = "troop_rank_color_cfg";
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public int a;
  public SparseIntArray a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  private TroopRankColorConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    Resources localResources = BaseApplication.getContext().getResources();
    this.jdField_a_of_type_Int = localResources.getColor(2131427953);
    this.b = localResources.getColor(2131427954);
    this.c = localResources.getColor(2131427955);
    this.d = localResources.getColor(2131427956);
    this.e = localResources.getColor(2131427956);
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static Drawable a(Resources paramResources)
  {
    return TroopUtils.a(paramResources, a().d);
  }
  
  public static Drawable a(Resources paramResources, int paramInt1, int paramInt2)
  {
    TroopRankColorConfig localTroopRankColorConfig = a();
    if (paramInt1 == 0) {
      return TroopUtils.a(paramResources, localTroopRankColorConfig.jdField_a_of_type_Int);
    }
    if (paramInt1 == 1) {
      return TroopUtils.a(paramResources, localTroopRankColorConfig.b);
    }
    if (paramInt1 == 2) {
      return TroopUtils.a(paramResources, localTroopRankColorConfig.c);
    }
    if (localTroopRankColorConfig.jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(paramInt2) >= 0) {
      return TroopUtils.a(paramResources, localTroopRankColorConfig.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt2));
    }
    return TroopUtils.a(paramResources, localTroopRankColorConfig.d);
  }
  
  public static TroopRankColorConfig a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankColorConfig == null) {
        jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankColorConfig = b();
      }
      TroopRankColorConfig localTroopRankColorConfig = jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankColorConfig;
      return localTroopRankColorConfig;
    }
    finally {}
  }
  
  protected static TroopRankColorConfig a(String paramString)
  {
    try
    {
      TroopRankColorConfig localTroopRankColorConfig = new TroopRankColorConfig();
      paramString = new JSONObject(paramString);
      localTroopRankColorConfig.jdField_a_of_type_Int = Color.parseColor(paramString.getString("ownerRank"));
      localTroopRankColorConfig.b = Color.parseColor(paramString.getString("adminRank"));
      localTroopRankColorConfig.c = Color.parseColor(paramString.getString("uniqRank"));
      localTroopRankColorConfig.d = Color.parseColor(paramString.getString("defLevelRank"));
      JSONArray localJSONArray = paramString.optJSONArray("flower");
      paramString = localTroopRankColorConfig;
      if (localJSONArray != null)
      {
        paramString = localTroopRankColorConfig;
        if (localJSONArray.length() > 0)
        {
          int j = 0;
          for (;;)
          {
            paramString = localTroopRankColorConfig;
            if (j >= localJSONArray.length()) {
              break;
            }
            paramString = localJSONArray.getJSONObject(j);
            int k = paramString.getInt("rank");
            int m = Color.parseColor(paramString.getString("color"));
            localTroopRankColorConfig.jdField_a_of_type_AndroidUtilSparseIntArray.put(k, m);
            j += 1;
          }
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.getTroopMemberLevelInfo", 2, "parseConfig exp:", paramString);
      }
      paramString = null;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setBackgroundDrawable(a(BaseApplication.getContext().getResources(), paramInt1, paramInt2));
  }
  
  public static boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "refreshConfig:" + paramString);
        }
        TroopRankColorConfig localTroopRankColorConfig = a(paramString);
        if (localTroopRankColorConfig != null)
        {
          jdField_a_of_type_ComTencentMobileqqTroopDataTroopRankColorConfig = localTroopRankColorConfig;
          bool1 = true;
        }
        boolean bool2;
        boolean bool1 = false;
      }
      catch (Exception localException1)
      {
        try
        {
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putString("troop_rank_color_cfg", paramString).commit();
          bool2 = bool1;
          return bool2;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        bool1 = false;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.getTroopMemberLevelInfo", 2, "TroopRankColorConfig.refreshConfig exp, jsonStr=" + paramString, localException1);
          return bool1;
        }
      }
    }
  }
  
  protected static TroopRankColorConfig b()
  {
    try
    {
      TroopRankColorConfig localTroopRankColorConfig1 = a(BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getString("troop_rank_color_cfg", ""));
      TroopRankColorConfig localTroopRankColorConfig2 = localTroopRankColorConfig1;
      if (localTroopRankColorConfig1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "getConfigFromLocal exp, localConfig==null");
        }
        localTroopRankColorConfig2 = new TroopRankColorConfig();
      }
      return localTroopRankColorConfig2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.getTroopMemberLevelInfo", 2, "getConfigFromLocal exp:", localException);
        }
        Object localObject = null;
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray.indexOfKey(paramInt) >= 0) {
      return this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt);
    }
    return this.d;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopRankColorConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */