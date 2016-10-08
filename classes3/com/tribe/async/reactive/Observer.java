package com.tribe.async.reactive;

import android.support.annotation.NonNull;

public abstract interface Observer<T>
{
  public abstract void onCancel();
  
  public abstract void onComplete();
  
  public abstract void onError(@NonNull Error paramError);
  
  public abstract void onNext(T paramT);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\reactive\Observer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */