package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ThreadOptimizer
{
  private static ThreadOptimizer jdField_a_of_type_ComTencentMobileqqAppThreadOptimizer;
  private static final String jdField_a_of_type_JavaLangString = "ThreadManager.Optimizer";
  private static final String jdField_b_of_type_JavaLangString = "\\|";
  private static final boolean d = true;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public ThreadOptimizer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -2;
  }
  
  public static ThreadOptimizer a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppThreadOptimizer == null) {
        jdField_a_of_type_ComTencentMobileqqAppThreadOptimizer = new ThreadOptimizer();
      }
      ThreadOptimizer localThreadOptimizer = jdField_a_of_type_ComTencentMobileqqAppThreadOptimizer;
      return localThreadOptimizer;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    int i = 0;
    Object localObject2 = DeviceProfileManager.a();
    Object localObject1 = ((DeviceProfileManager)localObject2).a(DeviceProfileManager.DpcNames.qq_thread_config.name());
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager.Optimizer", 2, "config = " + (String)localObject1);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return;
      try
      {
        localObject1 = ((String)localObject1).split("\\|");
        if (localObject1.length >= 5)
        {
          float f = Float.parseFloat(localObject1[1]);
          if (((DeviceProfileManager)localObject2).jdField_a_of_type_Int * 1.0F / 10000.0F < f)
          {
            this.jdField_a_of_type_Int = Integer.valueOf(localObject1[0]).intValue();
            this.jdField_a_of_type_Boolean = "1".equals(localObject1[2]);
            this.b = "1".equals(localObject1[3]);
            this.c = "1".equals(localObject1[4]);
            if (localObject1.length > 5)
            {
              localObject2 = new File(BaseApplicationImpl.getContext().getFilesDir(), "disableSmallLock");
              if (!"1".equals(localObject1[5])) {
                break label405;
              }
              if (((File)localObject2).exists()) {
                ((File)localObject2).delete();
              }
            }
            label186:
            if (localObject1.length > 6)
            {
              if (!"1".equals(localObject1[6])) {
                break label413;
              }
              com.tencent.common.config.AppSetting.m = true;
            }
            label209:
            if (localObject1.length > 7)
            {
              localObject2 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
              boolean bool1 = ((SharedPreferences)localObject2).getBoolean("enableUpdateIconStep", false);
              boolean bool2 = "1".equals(localObject1[7]);
              if (bool1 != bool2) {
                ((SharedPreferences)localObject2).edit().putBoolean("enableUpdateIconStep", bool2).commit();
              }
            }
            label276:
            if (!this.b) {
              if (!this.c) {
                continue;
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = Thread.currentThread().getThreadGroup();
          localObject2 = new Thread[((ThreadGroup)localObject1).activeCount()];
          ((ThreadGroup)localObject1).enumerate((Thread[])localObject2);
          int j = localObject2.length;
          label315:
          if (i < j)
          {
            Object localObject3 = localObject2[i];
            if (localObject3 != null)
            {
              if (((Thread)localObject3).getName() == null) {
                break label420;
              }
              localObject1 = ((Thread)localObject3).getName();
              label347:
              if ((!this.b) || (!"MSF-Receiver".equals(localObject1))) {
                break label426;
              }
              ((Thread)localObject3).setPriority(1);
            }
            for (;;)
            {
              i += 1;
              break label315;
              this.jdField_a_of_type_Int = 0;
              break;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                break label276;
              }
              QLog.d("ThreadManager.Optimizer", 2, "", localException1);
              break label276;
              label405:
              ((File)localObject2).createNewFile();
              break label186;
              label413:
              com.tencent.common.config.AppSetting.m = false;
              break label209;
              label420:
              String str = "";
              break label347;
              label426:
              if ((this.c) && (("logWriteThread".equals(str)) || (str.startsWith("GlobalPool")) || (str.startsWith("Face")) || (str.startsWith("um-stack")) || (str.startsWith("QQ_FTS")) || (str.startsWith("httpcomm")))) {
                ((Thread)localObject3).setPriority(1);
              }
            }
          }
          if (!this.c) {}
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThreadManager.Optimizer", 2, "", localException2);
          }
        }
      }
    }
    ThreadManager.b().setPriority(1);
    ThreadManager.a().setPriority(1);
    ThreadManager.c().getThread().setPriority(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ThreadOptimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */