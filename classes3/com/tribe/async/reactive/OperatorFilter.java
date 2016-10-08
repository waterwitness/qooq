package com.tribe.async.reactive;

import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;

public class OperatorFilter<T>
  extends Operator<T, T>
{
  private final Predicate<T> mPredicate;
  
  public OperatorFilter(Predicate<T> paramPredicate)
  {
    AssertUtils.checkNotNull(paramPredicate);
    this.mPredicate = paramPredicate;
  }
  
  public Observer<T> apply(final Observer<T> paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    new SimpleObserver()
    {
      public void onComplete()
      {
        paramObserver.onComplete();
      }
      
      public void onError(@NonNull Error paramAnonymousError)
      {
        paramObserver.onError(paramAnonymousError);
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (OperatorFilter.this.mPredicate.test(paramAnonymousT)) {
          paramObserver.onNext(paramAnonymousT);
        }
      }
    };
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\reactive\OperatorFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */