package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import wxs;
import wxt;
import wxu;

public class PackageInstallReceiver
  extends BroadcastReceiver
{
  public final String a;
  
  public PackageInstallReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = PackageInstallReceiver.class.getName();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtility.c(this.a, "onReceive >> " + paramIntent.getAction());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext)) {
      LogUtility.e(this.a, "onReceive intentPkgNameString == null ");
    }
    Object localObject;
    do
    {
      return;
      localObject = paramContext.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
          ThreadManager.a(new wxs(this, paramContext, (String)localObject), 5, null, true);
        }
      }
      else
      {
        LogUtility.e(this.a, "onReceive packageName == null " + paramIntent.getDataString());
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED"))
      {
        ThreadManager.a(new wxt(this, paramContext, (String)localObject), 5, null, true);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"));
    ThreadManager.a(new wxu(this, paramContext, (String)localObject), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\common\PackageInstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */