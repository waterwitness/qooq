package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.react.common.MapBuilder;
import com.tencent.bitapp.pre.binder.MessageQueueThread;
import java.util.Map;

public class CatalystQueueConfigurationImpl
  implements CatalystQueueConfiguration
{
  private final MessageQueueThreadImpl mJSQueueThread;
  private final MessageQueueThreadImpl mNativeModulesQueueThread;
  private final MessageQueueThreadImpl mUIQueueThread;
  
  private CatalystQueueConfigurationImpl(MessageQueueThreadImpl paramMessageQueueThreadImpl1, MessageQueueThreadImpl paramMessageQueueThreadImpl2, MessageQueueThreadImpl paramMessageQueueThreadImpl3)
  {
    this.mUIQueueThread = paramMessageQueueThreadImpl1;
    this.mNativeModulesQueueThread = paramMessageQueueThreadImpl2;
    this.mJSQueueThread = paramMessageQueueThreadImpl3;
  }
  
  public static CatalystQueueConfigurationImpl create(CatalystQueueConfigurationSpec paramCatalystQueueConfigurationSpec, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    Object localObject3 = MapBuilder.newHashMap();
    Object localObject1 = MessageQueueThreadSpec.mainThreadSpec();
    MessageQueueThreadImpl localMessageQueueThreadImpl = MessageQueueThreadImpl.create((MessageQueueThreadSpec)localObject1, paramQueueThreadExceptionHandler);
    ((Map)localObject3).put(localObject1, localMessageQueueThreadImpl);
    Object localObject2 = (MessageQueueThreadImpl)((Map)localObject3).get(paramCatalystQueueConfigurationSpec.getJSQueueThreadSpec());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MessageQueueThreadImpl.create(paramCatalystQueueConfigurationSpec.getJSQueueThreadSpec(), paramQueueThreadExceptionHandler);
    }
    localObject3 = (MessageQueueThreadImpl)((Map)localObject3).get(paramCatalystQueueConfigurationSpec.getNativeModulesQueueThreadSpec());
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = MessageQueueThreadImpl.create(paramCatalystQueueConfigurationSpec.getNativeModulesQueueThreadSpec(), paramQueueThreadExceptionHandler);
    }
    return new CatalystQueueConfigurationImpl(localMessageQueueThreadImpl, (MessageQueueThreadImpl)localObject2, (MessageQueueThreadImpl)localObject1);
  }
  
  public void destroy()
  {
    if (this.mNativeModulesQueueThread.getLooper() != Looper.getMainLooper()) {
      this.mNativeModulesQueueThread.quitSynchronous();
    }
    if (this.mJSQueueThread.getLooper() != Looper.getMainLooper()) {
      this.mJSQueueThread.quitSynchronous();
    }
  }
  
  public MessageQueueThread getJSQueueThread()
  {
    return this.mJSQueueThread;
  }
  
  public MessageQueueThread getNativeModulesQueueThread()
  {
    return this.mNativeModulesQueueThread;
  }
  
  public MessageQueueThread getUIQueueThread()
  {
    return this.mUIQueueThread;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\queue\CatalystQueueConfigurationImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */