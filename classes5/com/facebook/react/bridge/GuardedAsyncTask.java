package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedAsyncTask<Params, Progress>
  extends AsyncTask<Params, Progress, Void>
{
  private final ReactContext mReactContext;
  
  protected GuardedAsyncTask(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }
  
  protected final Void doInBackground(Params... paramVarArgs)
  {
    try
    {
      doInBackgroundGuarded(paramVarArgs);
      return null;
    }
    catch (RuntimeException paramVarArgs)
    {
      for (;;)
      {
        this.mReactContext.handleException(paramVarArgs);
      }
    }
  }
  
  protected abstract void doInBackgroundGuarded(Params... paramVarArgs);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\GuardedAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */