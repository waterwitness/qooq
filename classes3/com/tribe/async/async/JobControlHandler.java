package com.tribe.async.async;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public abstract interface JobControlHandler
{
  public abstract boolean accept(@NonNull Job paramJob);
  
  public abstract void handleCancel(@NonNull JobController.CancelCommand paramCancelCommand);
  
  public abstract void handleDone(@NonNull Worker paramWorker);
  
  public abstract void handleExecute(@NonNull Executor[] paramArrayOfExecutor, @NonNull Worker paramWorker);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\async\JobControlHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */