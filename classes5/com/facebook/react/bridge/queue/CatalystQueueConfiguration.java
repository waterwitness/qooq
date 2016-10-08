package com.facebook.react.bridge.queue;

import com.tencent.bitapp.pre.binder.MessageQueueThread;

public abstract interface CatalystQueueConfiguration
{
  public abstract MessageQueueThread getJSQueueThread();
  
  public abstract MessageQueueThread getNativeModulesQueueThread();
  
  public abstract MessageQueueThread getUIQueueThread();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\queue\CatalystQueueConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */