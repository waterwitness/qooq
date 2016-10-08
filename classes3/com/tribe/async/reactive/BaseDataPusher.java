package com.tribe.async.reactive;

public class BaseDataPusher<T>
  extends DataPusher<T>
{
  private volatile boolean mIsCanceled;
  protected Observer<T> mLastObserver;
  
  public void apply(Observer<T> paramObserver)
  {
    this.mLastObserver = paramObserver;
    this.mIsCanceled = false;
  }
  
  public void cancel()
  {
    this.mIsCanceled = true;
    if (this.mLastObserver != null) {
      this.mLastObserver.onCancel();
    }
  }
  
  public boolean isCanceled()
  {
    return this.mIsCanceled;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\reactive\BaseDataPusher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */