package com.facebook.react.uimanager.events;

public abstract class Event<T extends Event>
{
  private boolean mInitialized;
  private long mTimestampMs;
  private int mViewTag;
  
  protected Event() {}
  
  protected Event(int paramInt, long paramLong)
  {
    init(paramInt, paramLong);
  }
  
  public boolean canCoalesce()
  {
    return true;
  }
  
  public T coalesce(T paramT)
  {
    if (getTimestampMs() > paramT.getTimestampMs()) {
      return this;
    }
    return paramT;
  }
  
  public abstract void dispatch(RCTEventEmitter paramRCTEventEmitter);
  
  final void dispose()
  {
    this.mInitialized = false;
    onDispose();
  }
  
  public short getCoalescingKey()
  {
    return 0;
  }
  
  public abstract String getEventName();
  
  public final long getTimestampMs()
  {
    return this.mTimestampMs;
  }
  
  public final int getViewTag()
  {
    return this.mViewTag;
  }
  
  protected void init(int paramInt, long paramLong)
  {
    this.mViewTag = paramInt;
    this.mTimestampMs = paramLong;
    this.mInitialized = true;
  }
  
  boolean isInitialized()
  {
    return this.mInitialized;
  }
  
  public void onDispose() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\events\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */