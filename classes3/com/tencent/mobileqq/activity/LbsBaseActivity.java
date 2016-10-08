package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import lqe;
import lqf;
import lqg;
import lqh;
import lqi;
import lqj;
import lqk;
import lql;

public class LbsBaseActivity
  extends IphoneTitleBarActivity
{
  protected static final int a = 10;
  private Dialog a;
  private Dialog b;
  private Dialog c;
  
  public LbsBaseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a()
  {
    LocationManager localLocationManager = (LocationManager)getAppInterface().a().getSystemService("location");
    try
    {
      bool = localLocationManager.isProviderEnabled("gps");
      if (QLog.isColorLevel()) {
        QLog.i("LBS", 2, "GPS Open " + bool);
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  private boolean b()
  {
    return NearbySPUtil.a(getAppInterface().getAccount());
  }
  
  private void e(Runnable paramRunnable)
  {
    if (!a())
    {
      g(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private void f(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  private void g(Runnable paramRunnable)
  {
    if (this.a == null)
    {
      this.a = CustomDialogFactory.a(this, 17039380, 2131368212, 2131366775, 2131368221, new lqg(this), new lqh(this));
      this.a.setOnDismissListener(new lqi(this, paramRunnable));
    }
    c();
    this.a.show();
  }
  
  private void h(Runnable paramRunnable)
  {
    paramRunnable = new lqj(this, paramRunnable);
    this.b = CustomDialogFactory.a(this, 2131368215, a(), 2131368222, 2131368221, new lqk(this), new lql(this));
    this.b.setOnDismissListener(paramRunnable);
    this.b.show();
  }
  
  protected int a()
  {
    return 2131368216;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(Dialog paramDialog)
  {
    try
    {
      paramDialog.dismiss();
      ActivityLeakSolution.a(paramDialog);
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      ActivityLeakSolution.a(paramDialog);
      return;
    }
    finally
    {
      localObject = finally;
      ActivityLeakSolution.a(paramDialog);
      throw ((Throwable)localObject);
    }
  }
  
  protected void a(Runnable paramRunnable)
  {
    f(paramRunnable);
  }
  
  protected int b()
  {
    try
    {
      int i = ((Integer)Class.forName("com.android.internal.R$id").getField("title_container").get(null)).intValue();
      i = ((ViewGroup)getWindow().findViewById(i)).getBottom();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void b() {}
  
  protected void b(Runnable paramRunnable)
  {
    if (b())
    {
      f(paramRunnable);
      return;
    }
    h(paramRunnable);
  }
  
  protected void c() {}
  
  protected void c(Runnable paramRunnable)
  {
    if (b()) {
      f(paramRunnable);
    }
  }
  
  public void d()
  {
    finish();
  }
  
  protected void d(Runnable paramRunnable)
  {
    this.c = CustomDialogFactory.a(this, 2131368213, 2131368214, 2131367262, 2131368223, new lqe(this), new lqf(this, paramRunnable));
    this.c.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      a(this.a);
    }
    if ((this.b != null) && (this.b.isShowing())) {
      a(this.b);
    }
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
    super.doOnDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\LbsBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */