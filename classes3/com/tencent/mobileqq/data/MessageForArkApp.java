package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForArkApp
  extends ChatMessage
{
  public ArkContainerWrapper arkContainer;
  public ArkAppMessage ark_app_message;
  public String compatibleMsg;
  
  public MessageForArkApp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    if (this.ark_app_message == null) {
      this.ark_app_message = new ArkAppMessage();
    }
    if (this.msgData != null)
    {
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.fromBytes(this.msgData);
      if (localArkAppMessage.appName != null) {
        this.ark_app_message.appName = localArkAppMessage.appName;
      }
      if (localArkAppMessage.appView != null) {
        this.ark_app_message.appView = localArkAppMessage.appView;
      }
      if (localArkAppMessage.appDesc != null) {
        this.ark_app_message.appDesc = localArkAppMessage.appDesc;
      }
      if (localArkAppMessage.promptText != null) {
        this.ark_app_message.promptText = localArkAppMessage.promptText;
      }
      if (localArkAppMessage.appMinVersion != null) {
        this.ark_app_message.appMinVersion = localArkAppMessage.appMinVersion;
      }
      if (localArkAppMessage.metaList != null) {
        this.ark_app_message.metaList = localArkAppMessage.metaList;
      }
      if (localArkAppMessage.config != null) {
        this.ark_app_message.config = localArkAppMessage.config;
      }
    }
    if (this.msg == null) {
      this.msg = this.ark_app_message.getSummery();
    }
  }
  
  public String getSummery()
  {
    if (this.ark_app_message != null) {
      return this.ark_app_message.getSummery();
    }
    return "[轻应用]";
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    byte[] arrayOfByte = null;
    if (this.ark_app_message != null) {
      arrayOfByte = this.ark_app_message.toBytes();
    }
    this.msg = getSummery();
    this.msgData = arrayOfByte;
  }
  
  public void setParsed()
  {
    try
    {
      this.mIsParsed = true;
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForArkApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */