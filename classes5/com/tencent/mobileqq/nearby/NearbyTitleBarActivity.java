package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import mqq.app.AppRuntime;
import tik;
import til;

public class NearbyTitleBarActivity
  extends IphoneTitleBarActivity
{
  public NearbyAppInterface b;
  public long h;
  public long i;
  public boolean i;
  public boolean j;
  
  public NearbyTitleBarActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = System.currentTimeMillis();
  }
  
  public static AppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().waitAppRuntime(null).getAppRuntime("module_nearby");
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  static void a(NearbyAppInterface paramNearbyAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    til localtil = null;
    if (paramLong1 != 0L) {}
    try
    {
      localtil = new til();
      localtil.jdField_a_of_type_JavaLangString = paramNearbyAppInterface.a();
      localtil.jdField_a_of_type_Int = paramNearbyAppInterface.c;
      localtil.b = paramNearbyAppInterface.d;
      localtil.c = paramLong2;
      localtil.e = paramLong1;
      localtil.d = paramLong3;
      paramNearbyAppInterface.a(2, 0);
      if (localtil != null)
      {
        paramNearbyAppInterface = Class.forName("android.view.ViewRootImpl");
        paramNearbyAppInterface.getMethod("addFirstDrawHandler", new Class[] { Runnable.class }).invoke(paramNearbyAppInterface, new Object[] { localtil });
      }
      return;
    }
    catch (Throwable paramNearbyAppInterface)
    {
      paramNearbyAppInterface.printStackTrace();
    }
  }
  
  public static void b(AppInterface paramAppInterface, String paramString)
  {
    b(paramAppInterface, paramString, "", "", "", "");
  }
  
  public static void b(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.a(new tik(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    int k;
    if (!this.jdField_i_of_type_Boolean)
    {
      if (a()) {
        getWindow().addFlags(16777216);
      }
      k = a();
      if (k != 0)
      {
        setContentView(k);
        this.jdField_i_of_type_Boolean = true;
      }
    }
    if ((this.jdField_i_of_type_Boolean) && (!this.j)) {}
    try
    {
      a();
      this.j = true;
      k = b();
      if (k == 0)
      {
        getWindow().setBackgroundDrawable(null);
        this.mUseOptimizMode = true;
        return bool;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        getWindow().setBackgroundDrawableResource(k);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_i_of_type_Long == 0L)
    {
      this.jdField_i_of_type_Long = System.currentTimeMillis();
      if (this.b.c == 2) {}
    }
    try
    {
      long l = getIntent().getLongExtra("ENTER_TIME", 0L);
      a(this.b, l, this.h, this.jdField_i_of_type_Long);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected String getModuleId()
  {
    return "module_nearby";
  }
  
  public boolean showPreview()
  {
    int k = a();
    if (k != 0)
    {
      if (a()) {
        getWindow().addFlags(16777216);
      }
      setContentView(k);
      this.jdField_i_of_type_Boolean = true;
    }
    try
    {
      a();
      this.j = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof NearbyAppInterface)) {
      this.b = ((NearbyAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 4, "NearbyActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyTitleBarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */