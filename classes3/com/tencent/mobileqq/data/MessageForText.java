package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.eqq.CrmIvrText;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.widgets.PubAccountQQText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class MessageForText
  extends ChatMessage
{
  private static final boolean DEBUG_LOG = true;
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForText";
  public String action;
  public String latitude;
  public String location;
  public URL locationUrl;
  public String longitude;
  public boolean mIsMsgSignalOpen;
  public long mMsgSendTime;
  public int mMsgSignalCount;
  public int mMsgSignalNetType;
  public int mMsgSignalSum;
  public int mPasswdRedBagFlag;
  public long mPasswdRedBagSender;
  public int msgVia;
  public CharSequence sb;
  public CharSequence sb2;
  public String url;
  
  public MessageForText()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    boolean bool3 = true;
    doParse(false);
    String str1 = getExtInfoFromExtStr("sens_msg_need_parse");
    if (!TextUtils.isEmpty(str1)) {}
    String str2;
    do
    {
      for (;;)
      {
        try
        {
          bool1 = Boolean.parseBoolean(str1);
          boolean bool2 = bool1;
          if (bool1) {
            if (!(BaseActivity.sTopActivity instanceof MultiForwardActivity))
            {
              bool2 = bool1;
              if (!(BaseActivity.sTopActivity instanceof ChatHistoryForC2C)) {}
            }
            else
            {
              bool2 = false;
            }
          }
          if (bool2) {
            break;
          }
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        bool1 = true;
      }
      str2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty(str2));
    Object localObject = getExtInfoFromExtStr("sens_msg_confirmed");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase("1"))) {}
    for (boolean bool1 = bool3;; bool1 = false)
    {
      if (!bool1) {
        saveExtInfoToExtStr("sens_msg_original_text", this.msg);
      }
      localObject = new CopyOnWriteArrayList();
      ((List)localObject).add(this);
      MQPSensitiveMsgUtil.a(this, (List)localObject, bool1, HexUtil.hexStr2Bytes(str2));
      return;
    }
  }
  
  protected void doParse(boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject3 = this.msg;
    Object localObject1 = localObject3;
    if (this.msgtype == 64533)
    {
      localObject1 = ActionMsgUtil.a((String)localObject3);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    int i;
    if (!paramBoolean)
    {
      i = ((String)localObject3).indexOf("http://maps.google.com/maps?q=");
      if (i != -1)
      {
        this.url = ((String)localObject3).substring(i);
        localObject1 = MessageUtils.a(this.url);
        this.latitude = localObject1[0];
        this.longitude = localObject1[1];
        this.location = localObject1[2];
        if ((TextUtils.isEmpty(this.latitude)) || (TextUtils.isEmpty(this.longitude))) {
          break label690;
        }
      }
    }
    for (;;)
    {
      try
      {
        Float.parseFloat(this.latitude);
        Float.parseFloat(this.longitude);
        i = 1;
      }
      catch (Exception localException1)
      {
        try
        {
          i = AIOUtils.a(200.0F, BaseApplication.getContext().getResources());
          int j = AIOUtils.a(100.0F, BaseApplication.getContext().getResources());
          localObject1 = new StringBuilder("http://st.map.soso.com/api");
          ((StringBuilder)localObject1).append("?size=").append(i).append("*").append(j);
          ((StringBuilder)localObject1).append("&center=").append(this.longitude).append(",").append(this.latitude);
          ((StringBuilder)localObject1).append("&zoom=14");
          ((StringBuilder)localObject1).append("&markers=").append(this.longitude).append(",").append(this.latitude).append(",").append("red");
          this.locationUrl = new URL(((StringBuilder)localObject1).toString());
          if (this.istroop != 1008) {
            continue;
          }
          this.sb = new PubAccountQQText((CharSequence)localObject3, 13);
          ((PubAccountQQText)this.sb).jdField_a_of_type_JavaLangString = this.selfuin;
          ((PubAccountQQText)this.sb).b = this.frienduin;
          return;
          localException1 = localException1;
          i = 0;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.locationUrl = null;
          localMalformedURLException.printStackTrace();
          continue;
        }
        this.locationUrl = null;
        continue;
        if ((this.istroop != 1024) || (isSendFromLocal())) {
          continue;
        }
        Object localObject2 = null;
        try
        {
          localAppRuntime = BaseApplicationImpl.a.getAppRuntime(this.selfuin);
          localObject2 = localAppRuntime;
          if (!QQAppInterface.class.isInstance(localAppRuntime)) {
            continue;
          }
          localObject2 = localAppRuntime;
          paramBoolean = CrmUtils.b((QQAppInterface)localAppRuntime, this.frienduin, this.istroop);
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          AppRuntime localAppRuntime;
          localAccountNotMatchException.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MessageForText", 2, String.format("User %s don't match current accound", new Object[] { this.selfuin }));
          paramBoolean = bool;
          localObject4 = localObject2;
          continue;
          this.sb = new QQText((CharSequence)localObject3, 13, 32, this);
          return;
        }
        if (!paramBoolean) {
          continue;
        }
        this.sb = new CrmIvrText((CharSequence)localObject3, 13, 32, this, this.frienduin, this.selfuin, (QQAppInterface)localAppRuntime);
        return;
        localObject2 = localAppRuntime;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localAppRuntime;
        QLog.d("MessageForText", 2, "We get error AppRuntime");
        paramBoolean = false;
        continue;
        Object localObject4;
        this.sb = new QQText((CharSequence)localObject3, 13, 32, this);
        localObject2 = getExtInfoFromExtStr("disc_at_info_list");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = new StringBuilder((String)localObject3);
        try
        {
          localObject4 = BaseApplicationImpl.a.a();
          if (QQAppInterface.class.isInstance(localObject4))
          {
            this.msg2 = AtTroopMemberSpan.a((QQAppInterface)localObject4, (StringBuilder)localObject3, (String)localObject2, this.frienduin).toString();
            this.sb2 = new QQText(this.msg2, 13, 32, this);
            return;
          }
        }
        catch (Exception localException2)
        {
          QLog.e("MessageForText", 1, "replaceAtMsgByMarkName", localException2);
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForText", 2, "We get error AppRuntime");
        return;
      }
      if (i != 0) {}
      label690:
      i = 0;
    }
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.w(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
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
  
  public void setSendMsgParams(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    this.mMsgSignalSum = paramSendMsgParams.jdField_a_of_type_Int;
    this.mMsgSignalCount = paramSendMsgParams.jdField_b_of_type_Int;
    this.mIsMsgSignalOpen = paramSendMsgParams.jdField_c_of_type_Boolean;
    this.mMsgSignalNetType = paramSendMsgParams.jdField_c_of_type_Int;
    this.mMsgSendTime = paramSendMsgParams.jdField_a_of_type_Long;
    this.mPasswdRedBagFlag = paramSendMsgParams.jdField_d_of_type_Int;
    this.mPasswdRedBagSender = paramSendMsgParams.jdField_b_of_type_Long;
    if ((this instanceof MessageForFoldMsg))
    {
      MessageForFoldMsg localMessageForFoldMsg = (MessageForFoldMsg)this;
      localMessageForFoldMsg.redBagId = paramSendMsgParams.jdField_a_of_type_JavaLangString;
      localMessageForFoldMsg.foldFlagTemp = paramSendMsgParams.jdField_d_of_type_Boolean;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */