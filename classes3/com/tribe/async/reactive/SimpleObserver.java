package com.tribe.async.reactive;

import android.support.annotation.NonNull;

public class SimpleObserver<T>
  implements Observer<T>
{
  public void onCancel() {}
  
  public void onComplete() {}
  
  public void onError(@NonNull Error paramError) {}
  
  public void onNext(T paramT) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\reactive\SimpleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */