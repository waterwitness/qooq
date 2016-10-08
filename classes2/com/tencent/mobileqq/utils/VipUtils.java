package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import wds;

public class VipUtils
{
  public static final int a = 1;
  public static final String a = "vip";
  public static final int b = 2;
  public static final String b = "svip";
  public static final int c = 4;
  public static final String c = "chat_history";
  private static final String d = "VipUtils";
  
  public VipUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = -1;
    int i = j;
    boolean bool;
    if (paramQQAppInterface != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQQAppInterface.a();
      }
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
      if (paramQQAppInterface == null) {
        break label105;
      }
      paramQQAppInterface = paramQQAppInterface.c(str);
      if (paramQQAppInterface == null) {
        break label86;
      }
      bool = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label71;
      }
      i = 3;
    }
    label71:
    label86:
    label105:
    do
    {
      for (;;)
      {
        return i;
        if (bool)
        {
          i = 2;
        }
        else
        {
          i = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("VipUtils", 2, "getUserStatus Friends is null");
          }
          i = -1;
        }
      }
      i = j;
    } while (!QLog.isColorLevel());
    QLog.e("VipUtils", 2, "getUserStatus FriendsManagerImp is null");
    return -1;
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString)
  {
    int j = 0;
    int k = 0;
    int i = j;
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(50);
      if (paramAppRuntime == null) {
        break label131;
      }
      paramAppRuntime = paramAppRuntime.c(str);
      if (paramAppRuntime == null) {
        break label112;
      }
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label101;
      }
      i = 1;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label106;
      }
      j = 2;
      label76:
      if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        k = 4;
      }
      i = k | j | 0x0 | i;
    }
    label101:
    label106:
    label112:
    label131:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label76;
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
      return 0;
      i = j;
    } while (!QLog.isColorLevel());
    QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
    return 0;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    int i = a(paramAppInterface, paramString);
    if ((i & 0x4) != 0) {
      return "2";
    }
    if ((i & 0x2) != 0) {
      return "1";
    }
    return "0";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.replace("-", "_");
      paramString = str;
    } while (str.contains("_"));
    return "jhan_" + str;
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString2)) && (paramInt > 0))
    {
      wds localwds = new wds();
      localwds.jdField_a_of_type_JavaLangString = paramString1;
      localwds.d = paramString2;
      localwds.e = "1450000516";
      localwds.b = "CJCLUBT";
      localwds.c = paramActivity.getString(2131371097);
      localwds.jdField_a_of_type_Int = paramInt;
      localwds.f = "svip";
      a(paramActivity, localwds);
    }
  }
  
  public static void a(Activity paramActivity, wds paramwds)
  {
    if ((paramwds == null) || (paramActivity == null) || (TextUtils.isEmpty(paramwds.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramwds.d)) || (TextUtils.isEmpty(paramwds.e)) || (TextUtils.isEmpty(paramwds.b)) || (TextUtils.isEmpty(paramwds.c)) || (paramwds.jdField_a_of_type_Int < 1)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", paramwds.b);
        ((JSONObject)localObject).put("aid", paramwds.d);
        ((JSONObject)localObject).put("openMonth", String.valueOf(paramwds.jdField_a_of_type_Int));
        ((JSONObject)localObject).put("offerId", paramwds.e);
        ((JSONObject)localObject).put("serviceName", paramwds.c);
        ((JSONObject)localObject).put("userId", paramwds.jdField_a_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
        if (paramwds.f == null) {
          break label210;
        }
        paramwds = paramwds.f;
        PayBridgeActivity.tenpay(paramActivity, (String)localObject, 4, paramwds);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VipUtils", 2, "openRechargeDialog exception : " + paramActivity.getMessage());
      return;
      label210:
      paramwds = "";
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramVarArgs = (QQAppInterface)paramAppInterface;
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramAppInterface = "UNKNOWN";; paramAppInterface = paramString1)
      {
        ReportController.b(paramVarArgs, "P_CliOper", paramAppInterface, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = "UNKNOWN";
      }
      for (;;)
      {
        paramAppInterface.a("P_CliOper", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramAppInterface = "UNKNOWN";; paramAppInterface = paramString1)
    {
      ReportController.b(null, "P_CliOper", paramAppInterface, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      return;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      wds localwds = new wds();
      localwds.jdField_a_of_type_JavaLangString = paramBaseActivity.app.a();
      localwds.d = paramString;
      localwds.e = "1450000515";
      localwds.b = "LTMCLUB";
      localwds.c = paramBaseActivity.getString(2131370893);
      localwds.jdField_a_of_type_Int = paramInt;
      localwds.f = "vip";
      a(paramBaseActivity, localwds);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x4) != 0;
  }
  
  public static void b(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      wds localwds = new wds();
      localwds.jdField_a_of_type_JavaLangString = paramBaseActivity.app.a();
      localwds.d = paramString;
      localwds.e = "1450000516";
      localwds.b = "CJCLUBT";
      localwds.c = paramBaseActivity.getString(2131371097);
      localwds.jdField_a_of_type_Int = paramInt;
      localwds.f = "svip";
      a(paramBaseActivity, localwds);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x2) != 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x1) != 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\VipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */