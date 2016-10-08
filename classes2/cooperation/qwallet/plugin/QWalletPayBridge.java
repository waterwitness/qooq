package cooperation.qwallet.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import yjp;

public abstract class QWalletPayBridge
{
  public QWalletPayBridge()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle)
  {
    return a(paramActivity, paramAppInterface, paramBundle, null);
  }
  
  public static boolean a(Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle, Dialog paramDialog)
  {
    if ((paramActivity == null) || (paramBundle == null)) {}
    do
    {
      return false;
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.e("Q.qwallet.pay", 2, "launchService appInterface == null :" + TimeFormatterUtils.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss SSS"));
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " Launch PayPlugin");
    }
    QWalletHelper.a(paramActivity, paramAppInterface, paramBundle, paramDialog, 0L);
    ThreadManager.b().post(new yjp(paramAppInterface, paramActivity));
    return true;
  }
  
  public static boolean a(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null)) {}
    do
    {
      return false;
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.e("Q.qwallet.pay", 2, "getWalletData appInterface == null :" + TimeFormatterUtils.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss SSS"));
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " getWalletData PayPlugin");
    }
    QWalletHelper.a(paramContext, paramAppInterface, paramBundle);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\QWalletPayBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */