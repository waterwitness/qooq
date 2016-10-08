package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class QPSingleUpdTimerTask
  extends TimerTask
{
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  
  public QPSingleUpdTimerTask(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaLangThread = new QPSingleUpdThread(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangThread.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\QPSingleUpdTimerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */