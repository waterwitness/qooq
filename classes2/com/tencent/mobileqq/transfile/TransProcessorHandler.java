package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class TransProcessorHandler
  extends Handler
{
  private ArrayList a;
  
  public TransProcessorHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
    this.a.clear();
  }
  
  public TransProcessorHandler(Looper paramLooper)
  {
    super(paramLooper);
    this.a = new ArrayList();
    this.a.clear();
  }
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(Class... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.a.add(paramVarArgs[i]);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\TransProcessorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */