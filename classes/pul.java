import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class pul
  extends BroadcastReceiver
{
  public pul(BrowserAppInterface paramBrowserAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (localObject == null) {}
    for (;;)
    {
      return;
      if (((String)localObject).equals("com.tencent.process.exit"))
      {
        localObject = paramIntent.getExtras();
        if (localObject == null) {
          continue;
        }
        ArrayList localArrayList = ((Bundle)localObject).getStringArrayList("procNameList");
        if ((!CommonUtil.a(((Bundle)localObject).getString("verify"), localArrayList)) || (!BrowserAppInterface.a(localArrayList, MobileQQ.getContext()))) {
          continue;
        }
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        try
        {
          paramContext = paramContext.getRunningTasks(1);
          if ((paramContext != null) && (paramContext.size() >= 1))
          {
            paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
            if (QLog.isColorLevel()) {
              QLog.d(BrowserAppInterface.jdField_a_of_type_JavaLangString, 2, "runningActivity=" + paramContext);
            }
            if ((paramContext != null) && (paramContext.length() > 0) && ((paramContext.contains("com.pay")) || (paramContext.contains("com.tenpay")))) {}
          }
          else if (BrowserAppInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            this.a.jdField_a_of_type_Boolean = true;
            this.a.jdField_a_of_type_AndroidContentIntent = paramIntent;
            return;
          }
        }
        catch (SecurityException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
          BrowserAppInterface.a(this.a, paramIntent);
          return;
        }
      }
    }
    if ((((String)localObject).equals("mqq.intent.action.ACCOUNT_CHANGED")) || (((String)localObject).equals("mqq.intent.action.ACCOUNT_KICKED")))
    {
      BrowserAppInterface.a(1);
      BrowserAppInterface.a(this.a, paramIntent);
      return;
    }
    if ((!this.a.isLogin()) && (((String)localObject).equals("mqq.intent.action.ACCOUNT_EXPIRED")))
    {
      BrowserAppInterface.a(1);
      return;
    }
    this.a.getApplication().otherProcessExit(true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */