package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import qgh;

public class SqliteExcuteMonitor
{
  public static final int a = 1001;
  private static final String jdField_a_of_type_JavaLangString = SqliteExcuteMonitor.class.getSimpleName();
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int = 0;
  private static final String jdField_b_of_type_JavaLangString = "endOperation";
  private static Field jdField_b_of_type_JavaLangReflectField;
  private static int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "SELECT";
  private static Field jdField_c_of_type_JavaLangReflectField;
  private static int jdField_d_of_type_Int = 0;
  private static final String jdField_d_of_type_JavaLangString = "UPDATE";
  private static int jdField_e_of_type_Int = 0;
  private static final String jdField_e_of_type_JavaLangString = "TRANSACTION";
  private static int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString = "(([=|>|<|>=|<=|!=|]|LIKE)\\s*)[\\w\\.']+";
  private static int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.length() < 3) {}
    do
    {
      return 99;
      paramString = paramString.substring(0, 3).toUpperCase(Locale.US);
      if (paramString.equals("SEL")) {
        return 1;
      }
      if ((paramString.equals("INS")) || (paramString.equals("UPD")) || (paramString.equals("REP")) || (paramString.equals("DEL"))) {
        return 2;
      }
      if (paramString.equals("ATT")) {
        return 3;
      }
      if (paramString.equals("COM")) {
        return 5;
      }
      if (paramString.equals("END")) {
        return 5;
      }
      if (paramString.equals("ROL")) {
        return 6;
      }
      if (paramString.equals("BEG")) {
        return 4;
      }
      if (paramString.equals("PRA")) {
        return 7;
      }
      if ((paramString.equals("CRE")) || (paramString.equals("DRO")) || (paramString.equals("ALT"))) {
        return 8;
      }
    } while ((!paramString.equals("ANA")) && (!paramString.equals("DET")));
    return 9;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    if (b()) {
      b(paramAppInterface, paramInt);
    }
  }
  
  private static boolean a()
  {
    return (jdField_b_of_type_Int > 0) && (jdField_c_of_type_Int > 0) && (d > 0) && (e > 0) && (f > 0) && (g > 0);
  }
  
  private static void b(AppInterface paramAppInterface, int paramInt)
  {
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        Class localClass = Class.forName("android.database.sqlite.SQLiteConnection$OperationLog");
        Method localMethod = localClass.getDeclaredMethod("getOperationLocked", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        if (localClass != null) {
          JavaHookBridge.findAndHookMethod(localClass, "endOperation", new Object[] { Integer.TYPE, new qgh(localMethod, paramAppInterface, paramInt) });
        }
      }
      return;
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  private static void b(AppInterface paramAppInterface, String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    String str2 = paramString.replaceAll("(([=|>|<|>=|<=|!=|]|LIKE)\\s*)[\\w\\.']+", "$1?");
    int i = a(str2);
    paramString = "";
    if (i == 1)
    {
      paramString = "SELECT";
      if (!paramBoolean) {
        break label169;
      }
    }
    label169:
    for (String str1 = "1";; str1 = "0")
    {
      String str3 = String.valueOf(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sql=").append(str2).append(",bizId=").append(str3).append(",operType=").append(paramString).append(",costTime=").append(paramLong).append("isMainThread").append(paramBoolean);
        QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      VipComicReportUtils.a(paramAppInterface, str3, "", paramString, str2, String.valueOf(paramLong), str1, new String[0]);
      return;
      if (i == 2)
      {
        paramString = "UPDATE";
        break;
      }
      if (i != 5) {
        break;
      }
      paramString = "TRANSACTION";
      break;
    }
  }
  
  private static boolean b()
  {
    Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.sqlite_monitor_threshold.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseDpc sql monitor thresholds = " + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        String[] arrayOfString2 = ((String)localObject).split("\\|");
        if ((arrayOfString2.length == 4) && (arrayOfString2[0].charAt(0) == '1'))
        {
          localObject = arrayOfString2[1].split(";");
          String[] arrayOfString1 = arrayOfString2[2].split(";");
          arrayOfString2 = arrayOfString2[3].split(";");
          if (localObject.length == 2)
          {
            jdField_b_of_type_Int = Integer.parseInt(localObject[0]);
            jdField_c_of_type_Int = Integer.parseInt(localObject[1]);
          }
          if (arrayOfString1.length == 2)
          {
            d = Integer.parseInt(arrayOfString1[0]);
            e = Integer.parseInt(arrayOfString1[1]);
          }
          if (arrayOfString2.length == 2)
          {
            f = Integer.parseInt(arrayOfString2[0]);
            g = Integer.parseInt(arrayOfString2[1]);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("parseDpc sql monitor ");
            ((StringBuilder)localObject).append("queryMainThread = ").append(jdField_b_of_type_Int).append("ms, ");
            ((StringBuilder)localObject).append("querySubThread = ").append(jdField_c_of_type_Int).append("ms, ");
            ((StringBuilder)localObject).append("writeMainThread = ").append(d).append("ms, ");
            ((StringBuilder)localObject).append("writeSubThread = ").append(e).append("ms, ");
            ((StringBuilder)localObject).append("transactionMainThread = ").append(f).append("ms, ");
            ((StringBuilder)localObject).append("transactionSubThread = ").append(g).append("ms");
            QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
          }
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean b(String paramString, long paramLong, boolean paramBoolean)
  {
    int i;
    int j;
    label37:
    int k;
    if ((!TextUtils.isEmpty(paramString)) && (a()))
    {
      int m = a(paramString);
      if (!paramBoolean) {
        break label86;
      }
      i = jdField_b_of_type_Int;
      if (!paramBoolean) {
        break label94;
      }
      j = d;
      if (!paramBoolean) {
        break label102;
      }
      k = f;
      label46:
      switch (m)
      {
      }
    }
    label86:
    label94:
    label102:
    do
    {
      do
      {
        do
        {
          return false;
          i = jdField_c_of_type_Int;
          break;
          j = e;
          break label37;
          k = g;
          break label46;
        } while (paramLong <= i);
        return true;
      } while (paramLong <= j);
      return true;
    } while (paramLong <= k);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SqliteExcuteMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */