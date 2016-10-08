package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ToolProcReceiver
  extends BroadcastReceiver
{
  AppRuntime mRt;
  boolean registered;
  
  public String[] getModularReceiveActions()
  {
    return new String[] { "mqq.intent.action.ACCOUNT_KICKED", "mqq.intent.action.EXIT_" + MobileQQ.getContext().getPackageName(), "mqq.intent.action.ACCOUNT_CHANGED", "mqq.intent.action.ACCOUNT_EXPIRED", "mqq.intent.action.LOGOUT", "com.tencent.process.exit" };
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    int i;
    if (paramIntent != null)
    {
      localObject = paramIntent.getAction();
      i = 0;
      j = 0;
      if (!"com.tencent.process.exit".equals(localObject)) {
        break label188;
      }
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {}
    }
    else
    {
      return;
    }
    while (i != 0)
    {
      localObject = paramIntent.getStringArrayList("procNameList");
      if ((AppProcHelper.isLegalBroadcast(paramIntent.getString("verify"), (ArrayList)localObject)) && (AppProcHelper.isContainsProc(paramContext, (ArrayList)localObject)))
      {
        paramContext = this.mRt.subRuntimeMap.values().iterator();
        for (;;)
        {
          i = j;
          if (!paramContext.hasNext()) {
            break;
          }
          paramIntent = (AppRuntime)paramContext.next();
          if (((paramIntent instanceof IToolProcEventListener)) && (((IToolProcEventListener)paramIntent).onReceiveLegalExitProcAction())) {
            j = 1;
          }
        }
      }
      i = 1;
    }
    paramContext = this.mRt.subRuntimeMap.values().iterator();
    while (paramContext.hasNext())
    {
      paramIntent = (AppRuntime)paramContext.next();
      if ((paramIntent instanceof IToolProcEventListener)) {
        ((IToolProcEventListener)paramIntent).onBeforeExitProc();
      }
    }
    label188:
    paramContext = this.mRt.subRuntimeMap.values().iterator();
    for (int j = i;; j = 1)
    {
      AppRuntime localAppRuntime;
      do
      {
        i = j;
        if (!paramContext.hasNext()) {
          break;
        }
        localAppRuntime = (AppRuntime)paramContext.next();
      } while ((!(localAppRuntime instanceof IToolProcEventListener)) || (!((IToolProcEventListener)localAppRuntime).onReceiveAccountAction((String)localObject, paramIntent)));
    }
    this.mRt.exitToolProc();
  }
  
  void register()
  {
    if (this.registered) {}
    do
    {
      return;
      try
      {
        IntentFilter localIntentFilter = new IntentFilter();
        String[] arrayOfString = getModularReceiveActions();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localIntentFilter.addAction(arrayOfString[i]);
          i += 1;
        }
        MobileQQ.getContext().registerReceiver(this, localIntentFilter);
        this.registered = true;
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    localThrowable.printStackTrace();
  }
  
  void unRegister()
  {
    try
    {
      if (this.registered) {
        MobileQQ.getContext().unregisterReceiver(this);
      }
      this.registered = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\ToolProcReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */