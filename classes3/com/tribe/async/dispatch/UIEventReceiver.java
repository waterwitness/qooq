package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import java.lang.ref.WeakReference;

public abstract class UIEventReceiver<T extends IEventReceiver, EVENT extends Dispatcher.Dispatchable>
  extends Subscriber.SingleEventSubscriber<EVENT>
{
  protected String TAG;
  private String mDebugInfo;
  protected WeakReference<T> mRef;
  
  public UIEventReceiver(@NonNull T paramT)
  {
    this.mDebugInfo = (paramT.getClass().getSimpleName() + System.identityHashCode(paramT));
    this.mRef = new WeakReference(paramT);
    this.TAG = (paramT.getClass().getSimpleName() + ":UIEventReceiver");
  }
  
  protected final void onDispatch2(@NonNull EVENT paramEVENT)
  {
    IEventReceiver localIEventReceiver = (IEventReceiver)this.mRef.get();
    if (localIEventReceiver == null)
    {
      SLog.w(this.TAG, "onDispatch2 ignore because weak reference is released : " + this.mDebugInfo);
      return;
    }
    if (!localIEventReceiver.isValidate())
    {
      SLog.w(this.TAG, String.format("ignore receiver one event %s for ui %s is invalidate", new Object[] { paramEVENT, localIEventReceiver }));
      return;
    }
    onEvent(localIEventReceiver, paramEVENT);
  }
  
  public abstract void onEvent(@NonNull T paramT, @NonNull EVENT paramEVENT);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\dispatch\UIEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */