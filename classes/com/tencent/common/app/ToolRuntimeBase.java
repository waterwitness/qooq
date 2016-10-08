package com.tencent.common.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import jkp;
import mqq.app.MobileQQ;

public class ToolRuntimeBase
  extends PluginRuntime
{
  static final int jdField_a_of_type_Int = 0;
  static final int jdField_b_of_type_Int = 1;
  static final String jdField_b_of_type_JavaLangString;
  static final int c = 2;
  static final int d = 3;
  long jdField_a_of_type_Long;
  ComponentCallbacks jdField_a_of_type_AndroidContentComponentCallbacks;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = ToolRuntimeBase.class.getSimpleName();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "onTrimMemory, " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      b(0);
      return;
    case 10: 
      b(0);
      return;
    case 15: 
      b(0);
      return;
    case 20: 
      b(1);
      return;
    case 40: 
    case 60: 
      b(2);
      return;
    }
    b(3);
  }
  
  void b(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 2000L) {}
    MQLruCache localMQLruCache;
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "clearCache, " + paramInt);
      }
      localMQLruCache = BaseApplicationImpl.a;
    } while (localMQLruCache == null);
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 1: 
      localMQLruCache.releaseLargeCache();
      return;
    case 2: 
      localMQLruCache.evictAll();
      return;
    }
    localMQLruCache.evictAll();
  }
  
  protected void exitToolProc()
  {
    QIPCClientHelper.getInstance().disconnect();
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.jdField_a_of_type_AndroidContentComponentCallbacks != null) {
        getApplication().unregisterComponentCallbacks(this.jdField_a_of_type_AndroidContentComponentCallbacks);
      }
      super.exitToolProc();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "", localThrowable);
        }
      }
    }
  }
  
  public void setAsToolRuntime()
  {
    super.setAsToolRuntime();
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.jdField_a_of_type_AndroidContentComponentCallbacks == null)
      {
        this.jdField_a_of_type_AndroidContentComponentCallbacks = new jkp(this);
        BaseApplicationImpl.a().getApplicationContext().registerComponentCallbacks(this.jdField_a_of_type_AndroidContentComponentCallbacks);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(b, 2, "", localThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\common\app\ToolRuntimeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */