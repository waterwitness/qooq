package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONObject;

public class MessageForApollo
  extends ChatMessage
{
  public static final int FAKE_MSG_ACTION_ID = 99999;
  private static final String TAG = "MessageForApollo";
  public boolean hasPlayed;
  public String inputText;
  public ApolloMessage mApolloMessage;
  
  public MessageForApollo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    try
    {
      this.mApolloMessage = ((ApolloMessage)MessagePkgUtils.a(this.msgData));
      this.hasPlayed = this.mApolloMessage.isPlayed;
      this.msg = ApolloUtil.a(this);
      if (!TextUtils.isEmpty(this.mApolloMessage.extStr)) {
        this.inputText = new JSONObject(this.mApolloMessage.extStr).optString("inputText");
      }
      if ((TextUtils.isEmpty(this.inputText)) && (this.istroop == 0) && (this.mApolloMessage.text != null)) {
        this.inputText = new String(this.mApolloMessage.text);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.mApolloMessage == null)
      {
        this.mApolloMessage = new ApolloMessage();
        this.mApolloMessage.isPlayed = true;
        this.mApolloMessage.extStr = "{}";
        this.mApolloMessage.id = 99999;
        this.mApolloMessage.name = ApolloUtil.a();
        QLog.e("MessageForApollo", 1, "mApolloMessage == null, make fake Message.");
      }
      if (this.msgData != null) {
        QLog.e("MessageForApollo", 1, " Apollo doParse error, msgData->" + Arrays.toString(this.msgData));
      }
      QLog.e("MessageForApollo", 1, " Apollo doParse error, e->" + localThrowable.getMessage());
    }
  }
  
  public boolean isBarrageMode()
  {
    if (this.mApolloMessage == null) {}
    while (128 != (this.mApolloMessage.flag & 0x80)) {
      return false;
    }
    return true;
  }
  
  public boolean isDoubleAction()
  {
    boolean bool = true;
    if (this.mApolloMessage == null) {
      return false;
    }
    if ((1 == (this.mApolloMessage.flag >> 2 & 0x1)) && (this.mApolloMessage.peer_uin > 0L)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    if (this.mApolloMessage != null) {}
    try
    {
      this.mApolloMessage.isPlayed = this.hasPlayed;
      this.msgData = MessagePkgUtils.a(this.mApolloMessage);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForApollo", 1, "isSend:" + isSend() + " Apollo prewrite error：" + localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForApollo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */