package cooperation.c2b;

import android.content.Context;
import android.content.Intent;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import xys;

public class C2BLBSHelper
{
  public static String a;
  public static xys a;
  public static String b = "isSucess";
  public static String c = "lbsinfo";
  public static String d = "skey";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "C2BLBSHelper";
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "C2BLBSHelper getLocation ACTION = " + paramIntent.getAction());
    }
    String str = paramQQAppInterface.a();
    TicketManager localTicketManager;
    if ((str != null) && (str.length() > 0))
    {
      localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
      if (localTicketManager == null) {}
    }
    for (str = localTicketManager.getSkey(str);; str = "")
    {
      paramIntent.putExtra(d, str);
      if ((paramQQAppInterface.a() != null) && (NetworkUtil.e(paramQQAppInterface.a().getApplicationContext())))
      {
        if (jdField_a_of_type_Xys == null) {
          jdField_a_of_type_Xys = new xys(paramContext, paramQQAppInterface);
        }
        jdField_a_of_type_Xys.a(paramIntent);
        paramQQAppInterface.a(jdField_a_of_type_Xys);
        ((LBSHandler)paramQQAppInterface.a(3)).b();
      }
      do
      {
        return;
        b(paramContext, paramIntent, false, null);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getLocation no network or app.getApp() == null");
      return;
    }
  }
  
  private static boolean b(Context paramContext, Intent paramIntent, boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    String str = paramIntent.getStringExtra("destaction");
    if ((str == null) || (str.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "response:resAction == null || resAction.length() == 0");
      }
    }
    do
    {
      return false;
      if (!str.equals(paramIntent.getAction())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "response desAction = Action return");
    return false;
    Intent localIntent = new Intent(str);
    localIntent.putExtras(paramIntent);
    localIntent.putExtra(b, paramBoolean);
    if (paramLBSInfo != null)
    {
      localIntent.putExtra("nation", paramLBSInfo.g());
      localIntent.putExtra("province", paramLBSInfo.e());
      localIntent.putExtra("city", paramLBSInfo.h());
      localIntent.putExtra("district", paramLBSInfo.f());
      localIntent.putExtra("town", paramLBSInfo.b());
      localIntent.putExtra("village", paramLBSInfo.a());
      localIntent.putExtra("street", paramLBSInfo.d());
      localIntent.putExtra("streetNo", paramLBSInfo.c());
      localIntent.putExtra("latitude", paramLBSInfo.b());
      localIntent.putExtra("longitude", paramLBSInfo.c());
      localIntent.putExtra("altitude", paramLBSInfo.a());
    }
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "response:isSuccess = " + paramBoolean + " , destination action:" + str);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BLBSHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */