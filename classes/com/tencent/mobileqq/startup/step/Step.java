package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

public class Step
  implements Runnable
{
  public static final int A = 23;
  public static final int B = 24;
  public static final int C = 25;
  public static final int D = 26;
  public static final int E = 27;
  public static final int F = 28;
  public static final int G = 29;
  public static final int H = 30;
  public static final int I = 31;
  public static final int J = 32;
  public static final int K = 33;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = 9;
  public static final int n = 10;
  public static final int o = 11;
  public static final int p = 12;
  public static final int q = 13;
  public static final int r = 14;
  public static final int s = 15;
  public static final int t = 16;
  public static final int u = 17;
  public static final int v = 18;
  public static final int w = 19;
  public static final int x = 20;
  public static final int y = 21;
  public static final int z = 22;
  protected int L;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected StartupDirector a;
  private int[] jdField_a_of_type_ArrayOfInt;
  protected String b;
  
  public void a(Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected boolean a()
  {
    if (this.L == 0)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int i2 = arrayOfInt.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (!Step.AmStepFactory.b(arrayOfInt[i1], this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, null).c()) {
          return false;
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  public final boolean c()
  {
    long l1 = 0L;
    int i1 = 5;
    Thread localThread = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      localThread = Thread.currentThread();
      i1 = localThread.getPriority();
      localThread.setPriority(10);
    }
    if (StartupDirector.d)
    {
      l1 = SystemClock.uptimeMillis();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label168;
      }
      TraceUtils.a(this.b);
    }
    for (;;)
    {
      boolean bool1 = false;
      try
      {
        boolean bool2 = a();
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "", localThrowable);
          continue;
          TraceUtils.b(4096L, this.b, Process.myTid());
        }
      }
      if (StartupDirector.d)
      {
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        TraceUtils.a();
        Log.i("AutoMonitor", this.b + ", cost=" + (SystemClock.uptimeMillis() - l1) + " results: " + bool1);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(this.jdField_a_of_type_Int, Boolean.valueOf(bool1)).sendToTarget();
        localThread.setPriority(i1);
      }
      return bool1;
      label168:
      TraceUtils.a(4096L, this.b, Process.myTid());
    }
  }
  
  public void run()
  {
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\Step.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */