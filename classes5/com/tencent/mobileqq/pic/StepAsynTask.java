package com.tencent.mobileqq.pic;

import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class StepAsynTask
  extends AsyncTask
{
  StepAsynTask a;
  
  public StepAsynTask()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Object... paramVarArgs)
  {
    return null;
  }
  
  public void a(StepAsynTask paramStepAsynTask)
  {
    this.a = paramStepAsynTask;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    if (this.a != null) {
      this.a.execute(new Object[0]);
    }
    super.onPostExecute(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\StepAsynTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */