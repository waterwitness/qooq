package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.HandlerUtil;
import com.facebook.stetho.inspector.elements.DocumentProvider;
import com.facebook.stetho.inspector.elements.DocumentProviderFactory;

public final class AndroidDocumentProviderFactory
  implements DocumentProviderFactory, ThreadBound
{
  private final Application mApplication;
  private final Handler mHandler;
  
  public AndroidDocumentProviderFactory(Application paramApplication)
  {
    this.mApplication = ((Application)Util.throwIfNull(paramApplication));
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean checkThreadAccess()
  {
    return HandlerUtil.checkThreadAccess(this.mHandler);
  }
  
  public DocumentProvider create()
  {
    return new AndroidDocumentProvider(this.mApplication, this);
  }
  
  public <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable)
  {
    return (V)HandlerUtil.postAndWait(this.mHandler, paramUncheckedCallable);
  }
  
  public void postAndWait(Runnable paramRunnable)
  {
    HandlerUtil.postAndWait(this.mHandler, paramRunnable);
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    if (!this.mHandler.postDelayed(paramRunnable, paramLong)) {
      throw new RuntimeException("Handler.postDelayed() returned false");
    }
  }
  
  public void removeCallbacks(Runnable paramRunnable)
  {
    this.mHandler.removeCallbacks(paramRunnable);
  }
  
  public void verifyThreadAccess()
  {
    HandlerUtil.verifyThreadAccess(this.mHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\AndroidDocumentProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */