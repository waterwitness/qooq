package com.tribe.async.async;

import android.support.annotation.Nullable;

public abstract interface JobContext<Progress>
{
  @Nullable
  public abstract Object getValue(int paramInt);
  
  public abstract boolean isJobCancelled();
  
  public abstract void publishJobProgress(Progress paramProgress);
  
  public abstract void setCancelListener(@Nullable CancelListener paramCancelListener);
  
  public abstract void setValue(int paramInt, Object paramObject);
  
  public static abstract interface CancelListener
  {
    public abstract void onCancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\async\JobContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */