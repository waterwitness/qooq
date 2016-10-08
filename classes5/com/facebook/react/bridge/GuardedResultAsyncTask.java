package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedResultAsyncTask<Result>
  extends AsyncTask<Void, Void, Result>
{
  private final ReactContext mReactContext;
  
  protected GuardedResultAsyncTask(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }
  
  protected final Result doInBackground(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = doInBackgroundGuarded();
      return paramVarArgs;
    }
    catch (RuntimeException paramVarArgs)
    {
      this.mReactContext.handleException(paramVarArgs);
      throw paramVarArgs;
    }
  }
  
  protected abstract Result doInBackgroundGuarded();
  
  protected final void onPostExecute(Result paramResult)
  {
    try
    {
      onPostExecuteGuarded(paramResult);
      return;
    }
    catch (RuntimeException paramResult)
    {
      this.mReactContext.handleException(paramResult);
    }
  }
  
  protected abstract void onPostExecuteGuarded(Result paramResult);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\GuardedResultAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */