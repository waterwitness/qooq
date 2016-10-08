package com.tencent.open.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.OpenConst;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SharedPrefs
  implements OpenConst
{
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private static boolean jdField_a_of_type_Boolean;
  
  public SharedPrefs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static SharedPreferences a()
  {
    try
    {
      if (jdField_a_of_type_AndroidContentSharedPreferences == null) {
        jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("shared_prefs_open", 0);
      }
      SharedPreferences localSharedPreferences = jdField_a_of_type_AndroidContentSharedPreferences;
      return localSharedPreferences;
    }
    finally {}
  }
  
  public static ArrayList a()
  {
    b();
    return a("login_history");
  }
  
  private static ArrayList a(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Object localObject3 = a().getString(paramString, "");
      if (((String)localObject3).length() > 0)
      {
        String[] arrayOfString = ((String)localObject3).split(",");
        localObject3 = new ArrayList();
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          localObject1 = localObject3;
          if (i >= j) {
            break;
          }
          ((ArrayList)localObject3).add(arrayOfString[i]);
          i += 1;
        }
      }
      return (ArrayList)localObject1;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_AndroidContentSharedPreferences = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(String paramString)
  {
    b();
    a(paramString, "login_history");
    a(paramString, "login_history", true);
    if (!a()) {
      a().edit().putBoolean("have_ever_login", true).commit();
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      for (;;)
      {
        try
        {
          String str = a().getString(paramString2, "");
          if (str.length() > 0)
          {
            Matcher localMatcher = Pattern.compile("(^|,)" + paramString1 + "($|,)").matcher(str);
            if (localMatcher.find())
            {
              paramString1 = ",";
              if ((localMatcher.start() == 0) || (localMatcher.end() == str.length())) {
                break label126;
              }
              paramString1 = localMatcher.replaceFirst(paramString1);
              a().edit().putString(paramString2, paramString1).commit();
            }
          }
          return;
        }
        finally {}
        label126:
        paramString1 = "";
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    if (!TextUtils.isEmpty(paramString1)) {}
    label166:
    for (;;)
    {
      String str;
      try
      {
        str = a().getString(paramString2, "");
        if (str.length() <= 0) {
          break label166;
        }
        if (!Pattern.compile("(^|,)" + paramString1 + "($|,)").matcher(str).find())
        {
          if (paramBoolean)
          {
            paramString1 = paramString1 + "," + str;
            if (i != 0) {
              a().edit().putString(paramString2, paramString1).commit();
            }
            return;
          }
          paramString1 = str + "," + paramString1;
          continue;
        }
        i = 0;
      }
      finally {}
      paramString1 = str;
      continue;
      return;
    }
  }
  
  public static boolean a()
  {
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = a().getBoolean("have_ever_login", false);
    }
    return jdField_a_of_type_Boolean;
  }
  
  private static void b()
  {
    Object localObject1;
    String str1;
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    if (!a())
    {
      localObject1 = BaseApplicationImpl.a().getSharedPreferences("accountList", 0);
      str1 = ((SharedPreferences)localObject1).getString("last_account", null);
      localObject1 = ((SharedPreferences)localObject1).getString("accList", null);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label342;
      }
      localObject2 = ((String)localObject1).split(",");
      if (localObject2 == null) {
        break label342;
      }
      localObject1 = new ArrayList(localObject2.length);
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(str1))) {
          ((ArrayList)localObject1).add(localObject3);
        }
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = MsfSdkUtils.getLoginedAccountList();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SimpleAccount)((Iterator)localObject2).next();
          if (((SimpleAccount)localObject3).isLogined())
          {
            a(((SimpleAccount)localObject3).getUin(), "login_history", true);
            i = 1;
          }
          for (;;)
          {
            break;
            if (!((SimpleAccount)localObject3).getUin().equals(str1)) {
              break label333;
            }
            str1 = null;
            label184:
            if (localObject1 == null) {
              break label330;
            }
            Iterator localIterator = ((ArrayList)localObject1).iterator();
            String str2;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              str2 = (String)localIterator.next();
            } while (!((SimpleAccount)localObject3).getUin().equals(str2));
            ((ArrayList)localObject1).remove(str2);
          }
        }
      }
      for (;;)
      {
        j = i;
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            a((String)((Iterator)localObject1).next(), "login_history", true);
            i = 1;
          }
        }
        if (!TextUtils.isEmpty(str1))
        {
          a(str1, "login_history", true);
          j = 1;
        }
        if (j != 0) {
          a().edit().putBoolean("have_ever_login", true).commit();
        }
        return;
        label330:
        break;
        label333:
        break label184;
        i = 0;
      }
      label342:
      localObject1 = null;
    }
  }
  
  public static void b(String paramString)
  {
    a(paramString, "login_history");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\data\SharedPrefs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */