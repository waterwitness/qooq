package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;

public class MessageForDeviceText
  extends ChatMessage
{
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForDeviceText";
  public String action;
  public int msgVia;
  public CharSequence sb;
  
  public MessageForDeviceText()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    doParse(false);
  }
  
  protected void doParse(boolean paramBoolean)
  {
    Object localObject2 = this.msg;
    Object localObject1 = localObject2;
    if (this.msgtype == 64533)
    {
      localObject1 = ActionMsgUtil.a((String)localObject2);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    this.sb = new QQText((CharSequence)localObject2, 13, 32, this.istroop);
  }
  
  protected void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForDeviceText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */