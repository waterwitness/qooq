package com.facebook.react.bridge.queue;

public class MessageQueueThreadSpec
{
  private static final MessageQueueThreadSpec MAIN_UI_SPEC = new MessageQueueThreadSpec(ThreadType.MAIN_UI, "main_ui");
  private final String mName;
  private final ThreadType mThreadType;
  
  private MessageQueueThreadSpec(ThreadType paramThreadType, String paramString)
  {
    this.mThreadType = paramThreadType;
    this.mName = paramString;
  }
  
  public static MessageQueueThreadSpec mainThreadSpec()
  {
    return MAIN_UI_SPEC;
  }
  
  public static MessageQueueThreadSpec newBackgroundThreadSpec(String paramString)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString);
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public ThreadType getThreadType()
  {
    return this.mThreadType;
  }
  
  protected static enum ThreadType
  {
    MAIN_UI,  NEW_BACKGROUND;
    
    private ThreadType() {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\queue\MessageQueueThreadSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */