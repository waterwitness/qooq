package com.facebook.react.bridge.queue;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public class CatalystQueueConfigurationSpec
{
  private final MessageQueueThreadSpec mJSQueueThreadSpec;
  private final MessageQueueThreadSpec mNativeModulesQueueThreadSpec;
  
  private CatalystQueueConfigurationSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec1, MessageQueueThreadSpec paramMessageQueueThreadSpec2)
  {
    this.mNativeModulesQueueThreadSpec = paramMessageQueueThreadSpec1;
    this.mJSQueueThreadSpec = paramMessageQueueThreadSpec2;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static CatalystQueueConfigurationSpec createDefault()
  {
    return builder().setJSQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("js")).setNativeModulesQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("native_modules")).build();
  }
  
  public MessageQueueThreadSpec getJSQueueThreadSpec()
  {
    return this.mJSQueueThreadSpec;
  }
  
  public MessageQueueThreadSpec getNativeModulesQueueThreadSpec()
  {
    return this.mNativeModulesQueueThreadSpec;
  }
  
  public static class Builder
  {
    @Nullable
    private MessageQueueThreadSpec mJSQueueSpec;
    @Nullable
    private MessageQueueThreadSpec mNativeModulesQueueSpec;
    
    public CatalystQueueConfigurationSpec build()
    {
      return new CatalystQueueConfigurationSpec((MessageQueueThreadSpec)Assertions.assertNotNull(this.mNativeModulesQueueSpec), (MessageQueueThreadSpec)Assertions.assertNotNull(this.mJSQueueSpec), null);
    }
    
    public Builder setJSQueueThreadSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec)
    {
      if ((this.mJSQueueSpec != null) && (FLog.isLoggable(6))) {
        FLog.e("Exception", "Setting JS queue multiple times!");
      }
      this.mJSQueueSpec = paramMessageQueueThreadSpec;
      return this;
    }
    
    public Builder setNativeModulesQueueThreadSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec)
    {
      if ((this.mNativeModulesQueueSpec != null) && (FLog.isLoggable(6))) {
        FLog.e("Exception", "Setting native modules queue spec multiple times!");
      }
      this.mNativeModulesQueueSpec = paramMessageQueueThreadSpec;
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\queue\CatalystQueueConfigurationSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */