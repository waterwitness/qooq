package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.msfmqpsdkbridge.MSFEmuDetectWrapper;
import com.tencent.qphone.base.util.QLog;

public class QPSingleUpdThread
  extends Thread
{
  QPSingleUpdEngine jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine;
  String jdField_a_of_type_JavaLangString;
  final String b;
  
  public QPSingleUpdThread(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine = null;
    this.b = "QPSingleUpdEngine";
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    super.run();
    int i = 1;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine = new QPSingleUpdEngine(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine.a();
        return;
      }
      catch (Exception localException)
      {
        if (i >= 3)
        {
          QLog.i("QPSingleUpdEngine", 0, "QPSingleUpdThread.run() Exception 3 times!!!");
          QPSupportUpdCfg.deleteCfg();
          MSFEmuDetectWrapper.a();
          return;
        }
        i += 1;
        QLog.i("QPSingleUpdEngine", 0, "QPSingleUpdThread.run() Exception !!!");
        try
        {
          Thread.sleep(10000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\QPSingleUpdThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */