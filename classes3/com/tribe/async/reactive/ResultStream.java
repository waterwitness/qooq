package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class ResultStream<R>
  extends Stream<R>
{
  private R mResult;
  
  public ResultStream(R paramR)
  {
    AssertUtils.checkNotNull(paramR);
    this.mResult = paramR;
    attachDataSupplier(new BaseDataPusher()
    {
      public void apply(Observer<R> paramAnonymousObserver)
      {
        super.apply(paramAnonymousObserver);
        paramAnonymousObserver.onNext(ResultStream.this.mResult);
        paramAnonymousObserver.onComplete();
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\reactive\ResultStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */