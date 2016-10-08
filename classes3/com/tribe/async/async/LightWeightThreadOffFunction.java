package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction;

public class LightWeightThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  protected void call(IN paramIN)
  {
    paramIN = new ThreadOffRunnable(paramIN);
    Bosses.get().postLightWeightJob(paramIN, 0);
  }
  
  protected void error(Error paramError)
  {
    paramError = new ThreadOffErrRunnable(paramError);
    Bosses.get().postLightWeightJob(paramError, 0);
  }
  
  protected void onCancel() {}
  
  private class ThreadOffErrRunnable
    implements Runnable
  {
    private Error mError;
    
    public ThreadOffErrRunnable(Error paramError)
    {
      this.mError = paramError;
    }
    
    public void run()
    {
      LightWeightThreadOffFunction.this.notifyError(this.mError);
    }
  }
  
  private class ThreadOffRunnable
    implements Runnable
  {
    private IN mResult;
    
    public ThreadOffRunnable()
    {
      Object localObject;
      this.mResult = localObject;
    }
    
    public void run()
    {
      LightWeightThreadOffFunction.this.notifyResult(this.mResult);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\async\LightWeightThreadOffFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */