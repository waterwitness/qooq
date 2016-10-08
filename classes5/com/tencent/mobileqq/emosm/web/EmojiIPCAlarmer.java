package com.tencent.mobileqq.emosm.web;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import rhr;
import rhs;

public class EmojiIPCAlarmer
{
  static final String jdField_a_of_type_JavaLangString = "Q.emoji.web.EmojiIPC.Alarmer";
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  public EmojiIPCAlarmer.TimeoutObserver a;
  
  public EmojiIPCAlarmer(EmojiIPCAlarmer.TimeoutObserver paramTimeoutObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer$TimeoutObserver = paramTimeoutObserver;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public Runnable a(int paramInt, long paramLong)
  {
    rhs localrhs = new rhs(this, paramInt);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localrhs, paramLong);
    return localrhs;
  }
  
  public Runnable a(Object paramObject, int paramInt)
  {
    paramObject = new rhr(this, paramObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)paramObject, paramInt);
    return (Runnable)paramObject;
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = new HandlerThread("EmojiIPCTimeoutChecker", 5);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\web\EmojiIPCAlarmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */