package com.tencent.av.smallscreen;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import god;
import goe;
import gof;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
{
  static final String a = "SmallScreenDialogActivity";
  private static final String b = "miui.intent.action.APP_PERM_EDITOR";
  private static final String c = "com.meizu.safe.security.SHOW_APPSEC";
  private static final String d = "huawei.intent.action.NOTIFICATIONMANAGER";
  private static final String e = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
  private static final String f = "com.miui.securitycenter";
  private static final String g = "com.meizu.safe";
  private static final String h = "com.miui.permcenter.permissions.AppPermissionsEditorActivity";
  private static final String i = "com.meizu.safe.security.AppSecActivity";
  private static final String j = "extra_pkgname";
  private static final String k = "packageName";
  public VideoAppInterface a;
  
  public SmallScreenDialogActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean b()
  {
    return (SmallScreenUtils.a(this, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(this, "com.meizu.safe.security.SHOW_APPSEC")) || ((SmallScreenUtils.a(this, "huawei.intent.action.NOTIFICATIONMANAGER")) && (!a())) || (SmallScreenUtils.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  public void a()
  {
    int i1 = 1;
    Object localObject = getPackageName();
    Intent localIntent;
    if (SmallScreenUtils.a(this, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    for (;;)
    {
      try
      {
        startActivity(localIntent);
        m = 1;
      }
      catch (Exception localException5)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenDialogActivity", 2, "WL_DEBUG openPermissionActivity e = " + localException5);
        m = 0;
        continue;
      }
      int n = m;
      if (m == 0)
      {
        n = m;
        if (SmallScreenUtils.a(this, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        startActivity(localIntent);
        n = 1;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          break label339;
        }
        QLog.e("SmallScreenDialogActivity", 2, "WL_DEBUG openPermissionActivity e = " + localException1);
        n = 0;
        continue;
      }
      int m = n;
      if (n == 0)
      {
        m = n;
        if (SmallScreenUtils.a(this, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          m = n;
          if (!a())
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
          }
        }
      }
      try
      {
        startActivity((Intent)localObject);
        n = 1;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label377;
        }
        QLog.e("SmallScreenDialogActivity", 2, "WL_DEBUG openPermissionActivity e = " + localException2);
        n = 0;
        continue;
      }
      m = n;
      if (n == 0) {
        localObject = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
      }
      try
      {
        startActivity((Intent)localObject);
        m = 1;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          break label415;
        }
        QLog.e("SmallScreenDialogActivity", 2, "WL_DEBUG openPermissionActivity e = " + localException3);
        m = 0;
        continue;
        continue;
      }
      if ((m == 0) && (SmallScreenUtils.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
      {
        localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          startActivity((Intent)localObject);
          m = i1;
        }
        catch (Exception localException4)
        {
          if (!QLog.isColorLevel()) {
            break label452;
          }
          QLog.e("SmallScreenDialogActivity", 2, "WL_DEBUG openPermissionActivity e = " + localException4);
          m = 0;
          continue;
        }
        if (m == 0)
        {
          localObject = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("hide_left_button", false);
          ((Intent)localObject).putExtra("show_right_close_button", false);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.openQQBrowserWithoutAD(this, "http://kf.qq.com/touch/apifaq/1506297fqqea150629iuAjqU.html?platform=14", 524288L, (Intent)localObject, false, -1);
        }
        return;
      }
      label339:
      label377:
      label415:
      label452:
      m = 0;
    }
  }
  
  public void a(QQCustomDialog paramQQCustomDialog)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenDialogActivity", 2, "WL_DEBUG showDialog");
      }
      paramQQCustomDialog.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenDialogActivity", 2, "WL_DEBUG showDialog ", localBadTokenException);
      }
      getWindow().getDecorView().post(new gof(this, paramQQCustomDialog));
    }
  }
  
  boolean a()
  {
    return Build.MODEL.equals("H60-L01");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    this.a = ((VideoAppInterface)super.getAppRuntime());
  }
  
  protected void onResume()
  {
    super.onResume();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage(2131363858).setNegativeButton(2131367262, new goe(this));
    if (b()) {}
    for (int m = 2131363870;; m = 2131363869)
    {
      localQQCustomDialog = localQQCustomDialog.setPositiveButton(m, new god(this));
      localQQCustomDialog.setTitle(2131363859);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      a(localQQCustomDialog);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */