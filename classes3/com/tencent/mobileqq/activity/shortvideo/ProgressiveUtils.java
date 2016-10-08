package com.tencent.mobileqq.activity.shortvideo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProgressiveUtils
{
  private static final String jdField_a_of_type_JavaLangString = "ShortVideo.ProgressiveUtils";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static AtomicBoolean a;
  private static boolean jdField_a_of_type_Boolean = false;
  public static String[] a;
  private static final String b = "key_shortvideo_progressive_blacklist";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "MI 3", "Coolpad 8675", "OPPO R7", "Redmi Note 2", "MX4", "vivo X5L", "m3 note", "PRO 6" };
  }
  
  private static void a()
  {
    int i = 0;
    if (jdField_a_of_type_Boolean) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("key_shortvideo_progressive_blacklist", null);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        a((String)localObject1, false);
      }
    } while (jdField_a_of_type_Boolean);
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        i += 1;
      }
      break;
      jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        if (Integer.valueOf(paramString).intValue() == 0)
        {
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideo.ProgressiveUtils", 2, "parseConfig(): config = " + paramString + ", sProgressiveEnable = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
          }
          return;
        }
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        continue;
      }
      catch (Exception localException)
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        continue;
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideo.ProgressiveUtils", 2, "updateBlackList(), config = " + paramString + ",needUpdateSP = " + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject(paramString).getJSONArray("shortvideo_progressive_blacklist");
        if (jdField_a_of_type_JavaUtilArrayList == null) {
          break label242;
        }
        jdField_a_of_type_JavaUtilArrayList.clear();
      }
      catch (Exception localException)
      {
        Object localObject;
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ShortVideo.ProgressiveUtils", 2, "updateBlackList(), config = " + paramString, localException);
        jdField_a_of_type_Boolean = false;
        jdField_a_of_type_JavaUtilArrayList = null;
        return;
      }
      if (i < ((JSONArray)localObject).length())
      {
        str = ((JSONArray)localObject).getString(i);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.ProgressiveUtils", 2, "updateBlackList(): " + str);
        }
        if (jdField_a_of_type_JavaUtilArrayList == null) {
          jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        jdField_a_of_type_JavaUtilArrayList.add(str);
        i += 1;
      }
      else
      {
        if (paramBoolean)
        {
          localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
          ((SharedPreferences.Editor)localObject).putString("key_shortvideo_progressive_blacklist", paramString);
          ((SharedPreferences.Editor)localObject).commit();
        }
        jdField_a_of_type_Boolean = true;
        return;
        label242:
        while (localException == null)
        {
          jdField_a_of_type_Boolean = false;
          return;
        }
        i = 0;
      }
    }
  }
  
  public static boolean a()
  {
    String str = Build.MODEL;
    if (!jdField_a_of_type_Boolean) {
      a();
    }
    if ((jdField_a_of_type_JavaUtilArrayList == null) && (jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    int j = jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j) {
      if (!((String)jdField_a_of_type_JavaUtilArrayList.get(i)).equalsIgnoreCase(str)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.ProgressiveUtils", 2, "isInBlackList() ： phone = " + str + ", result = " + bool);
      }
      return bool;
      i += 1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\ProgressiveUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */