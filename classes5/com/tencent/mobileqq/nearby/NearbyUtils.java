package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public final class NearbyUtils
{
  public static final boolean a = true;
  
  public NearbyUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = Pattern.compile("\n").matcher(paramString).replaceAll("");
    paramString = Pattern.compile("^ +").matcher(paramString).replaceAll("");
    return Pattern.compile(" +$").matcher(paramString).replaceAll("");
  }
  
  public static String a(StringBuilder paramStringBuilder, String paramString, Object... paramVarArgs)
  {
    int j;
    int i;
    label33:
    Object localObject;
    if (paramStringBuilder == null)
    {
      paramStringBuilder = new StringBuilder(20);
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break label85;
      }
      j = 1;
      int k = paramVarArgs.length;
      i = 0;
      if (i >= k) {
        break label85;
      }
      localObject = paramVarArgs[i];
      if (j != 0) {
        break label79;
      }
      paramStringBuilder.append(paramString);
    }
    for (;;)
    {
      paramStringBuilder.append(localObject);
      i += 1;
      break label33;
      paramStringBuilder.setLength(0);
      break;
      label79:
      j = 0;
    }
    label85:
    return paramStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    int i = 0;
    boolean bool;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool = false;
    }
    StringBuilder localStringBuilder;
    while (bool)
    {
      localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(paramString2);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int j = paramVarArgs.length;
        for (;;)
        {
          if (i < j)
          {
            paramString2 = paramVarArgs[i];
            localStringBuilder.append(",").append(paramString2);
            i += 1;
            continue;
            bool = QLog.isColorLevel();
            break;
            bool = QLog.isDevelopLevel();
            break;
          }
        }
      }
      if ((paramInt != 4) || (!QLog.isDevelopLevel())) {
        break label142;
      }
      QLog.i(paramString1, 4, localStringBuilder.toString());
    }
    label142:
    while ((paramInt != 2) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.i(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void a(EditText paramEditText, int paramInt)
  {
    String str = paramEditText.getText().toString();
    if (str.getBytes().length > paramInt)
    {
      while (str.getBytes().length > paramInt) {
        str = str.substring(0, str.length() - 1);
      }
      paramEditText.setText(str);
      paramEditText.setSelection(str.length());
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i(paramString1, 4, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]).append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i("Q.nearby", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    return QLog.isDevelopLevel();
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public static boolean c()
  {
    return BaseApplicationImpl.a().waitAppRuntime(null).getAppRuntime("module_nearby") instanceof NearbyAppInterface;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */