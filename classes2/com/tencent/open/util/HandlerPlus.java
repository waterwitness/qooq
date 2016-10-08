package com.tencent.open.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import wxz;

public class HandlerPlus
  extends Handler
{
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public HandlerPlus(Handler.Callback paramCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCallback);
  }
  
  public HandlerPlus(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCallback);
  }
  
  public void a(Runnable paramRunnable)
  {
    removeCallbacks(paramRunnable);
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      wxz localwxz = (wxz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramRunnable.hashCode());
      if (localwxz != null)
      {
        removeCallbacks(localwxz);
        this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramRunnable.hashCode());
      }
      return;
    }
  }
  
  public boolean a(Runnable paramRunnable, int paramInt, long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      wxz localwxz2 = (wxz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramRunnable.hashCode());
      wxz localwxz1 = localwxz2;
      if (localwxz2 == null)
      {
        localwxz1 = new wxz(this, paramRunnable);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramRunnable.hashCode(), localwxz1);
      }
      localwxz1.jdField_a_of_type_Int = paramInt;
      localwxz1.jdField_a_of_type_Long = paramLong1;
      return postDelayed(localwxz1, paramLong2);
    }
  }
  
  public boolean a(Runnable paramRunnable, long paramLong)
  {
    return a(paramRunnable, 1, 0L, paramLong);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\util\HandlerPlus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */