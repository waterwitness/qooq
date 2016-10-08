package com.tencent.biz.common.offline;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import hgp;
import hhd;
import hhe;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineExpire
{
  public static int a;
  public static String a;
  public static boolean a;
  private static int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "OfflineExpire";
    jdField_a_of_type_Int = 3;
  }
  
  protected static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire:" + paramString);
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        int j = paramString.length();
        if (i >= j) {
          break;
        }
        localObject = paramString.optJSONObject(i);
        if (localObject != null) {
          break label119;
        }
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      label119:
      int k = ((JSONObject)localObject).optInt("bid");
      if (k > 0)
      {
        localObject = HtmlOffline.a(k + "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (String)localObject + k;
          if (new File((String)localObject).exists()) {
            Util.a((String)localObject);
          }
        }
      }
    }
  }
  
  protected static void a(String paramString, AppRuntime paramAppRuntime, Context paramContext, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire:" + paramString);
    }
    if (paramInt == 1) {}
    for (paramInt = 300000;; paramInt = 0)
    {
      ArrayList localArrayList;
      JSONObject localJSONObject;
      Object localObject;
      hgp localhgp;
      do
      {
        do
        {
          try
          {
            paramString = new JSONObject(paramString).optJSONArray("data");
            b = 0;
            paramContext = new ArrayList();
            localArrayList = new ArrayList();
            int j = paramString.length();
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label398;
              }
              localJSONObject = paramString.optJSONObject(i);
              if (localJSONObject != null) {
                break;
              }
              i += 1;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
          }
          QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire: " + QLog.getStackTraceString(paramString));
          return;
          k = localJSONObject.optInt("code");
        } while ((k <= 0) || (k >= 10));
        localObject = localJSONObject.optInt("bid") + "";
        paramContext.add(localObject);
        localhgp = new hgp((String)localObject, paramAppRuntime, new hhd(), true, k);
        localhgp.jdField_c_of_type_Int = localJSONObject.optInt("id");
        localObject = HtmlOffline.a((String)localObject + "");
      } while ((localObject != null) && (((JSONObject)localObject).optInt("version", 0) >= localhgp.jdField_c_of_type_Int));
      int k = localJSONObject.optInt("filesize", 0);
      boolean bool;
      if (localJSONObject.optInt("network", 0) == 1)
      {
        bool = true;
        label322:
        localhgp.f = bool;
        if (!localhgp.f) {
          break label387;
        }
        localArrayList.add(localhgp);
      }
      for (;;)
      {
        b += 1;
        localhgp.jdField_c_of_type_JavaLangString = localJSONObject.optString("url");
        localhgp.b = k;
        localhgp.a = true;
        break;
        bool = false;
        break label322;
        label387:
        localArrayList.add(0, localhgp);
      }
      label398:
      ThreadManager.b().postDelayed(new hhe(localArrayList), paramInt);
      return;
    }
  }
  
  private static String b(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.tmdownloader.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\OfflineExpire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */