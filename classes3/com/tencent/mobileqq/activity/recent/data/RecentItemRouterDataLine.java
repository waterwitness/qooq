package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class RecentItemRouterDataLine
  extends RecentUserBaseData
{
  public RecentItemRouterDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private QQMessageFacade.Message a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a(this.a.uin, this.a.type);
      if (localMessage != null)
      {
        paramQQAppInterface = localMessage;
        if (localMessage.msgtype != 0) {}
      }
      else
      {
        return null;
      }
    }
    else
    {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1)
      {
        paramCharSequence.append("F ");
        paramCharSequence.append(paramString);
        paramCharSequence = new SpannableStringBuilder(paramCharSequence.toString());
      }
    }
    for (paramMsgSummary.g = 0;; paramMsgSummary.g = 1)
    {
      if (!paramBoolean1) {
        break label90;
      }
      paramMsgSummary.f = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label90:
    if (paramBoolean2)
    {
      paramMsgSummary.f = 1;
      return paramCharSequence;
    }
    paramMsgSummary.f = 0;
    return paramCharSequence;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.H = 0;
    this.jdField_b_of_type_Long = 0L;
    RouterHandler localRouterHandler = (RouterHandler)paramQQAppInterface.a(48);
    Object localObject2 = a(paramQQAppInterface);
    Object localObject1 = localObject2;
    QQMessageFacade localQQMessageFacade;
    String str;
    if (localObject2 == null)
    {
      localQQMessageFacade = paramQQAppInterface.a();
      str = MsgProxyUtils.a(this.a.uin, 6002);
      localObject2 = localRouterHandler.a(this.a.uin);
      if (localObject2 != null) {
        break label250;
      }
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).extInt = 0;
      ((QQMessageFacade.Message)localObject1).time = MessageCache.a();
      ((QQMessageFacade.Message)localObject1).msgtype = 0;
    }
    for (;;)
    {
      localQQMessageFacade.a.put(str, localObject1);
      this.jdField_b_of_type_JavaLangString = localRouterHandler.a(Long.parseLong(this.a.uin));
      this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = a();
      a((QQMessageFacade.Message)localObject1, this.a.type, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (!AppSetting.j) {
        break;
      }
      this.d = ("与我的路由的会话 [有" + this.H + "条未读] " + " " + ((MsgSummary)localObject2).b + this.c);
      return;
      label250:
      if (localQQMessageFacade == null) {
        break;
      }
      localObject1 = localObject2;
      if (localQQMessageFacade.a.containsKey(str))
      {
        localQQMessageFacade.a.remove(str);
        localObject1 = localObject2;
      }
    }
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    boolean bool2 = false;
    if (paramMessage != null)
    {
      paramInt = paramMessage.extInt;
      if (paramInt != 4) {
        break label442;
      }
    }
    label439:
    label442:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      if (paramMessage.msgtype == 64536)
      {
        paramQQAppInterface = paramMessage.getMessageText();
        if (paramQQAppInterface != null) {
          if (bool1) {
            paramQQAppInterface = "F " + paramQQAppInterface;
          }
        }
      }
      for (;;)
      {
        paramMsgSummary.b = a(null, bool1, bool2, new QQText(paramQQAppInterface, 1, 16), paramMsgSummary);
        for (;;)
        {
          if (paramMessage != null) {
            QLog.d("RecentItemRouterDataLine", 2, "msg info: " + paramMessage.extInt + ":" + paramMessage.msgtype + "msgSummary.strContent:" + paramMsgSummary.b);
          }
          return;
          if (!bool2) {
            break label439;
          }
          paramQQAppInterface = "S " + paramQQAppInterface;
          break;
          paramQQAppInterface = new StringBuffer();
          if (bool1) {
            paramQQAppInterface.append("F ");
          }
          for (;;)
          {
            paramQQAppInterface.append("");
            try
            {
              paramMsgSummary.b = a(null, bool1, bool2, new QQText(paramQQAppInterface, 1, 16), paramMsgSummary);
            }
            catch (Exception paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
            }
            break;
            if (bool2) {
              paramQQAppInterface.append("S ");
            }
          }
          if (paramMessage.msgtype == 63536)
          {
            paramMsgSummary.b = a(paramContext.getString(2131368433), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == 63531)
          {
            paramMsgSummary.b = a(paramContext.getString(2131369279), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == 63527)
          {
            paramMsgSummary.b = a(paramContext.getString(2131370155), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == 63201)
          {
            paramMsgSummary.b = a(paramContext.getString(2131369279), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == 63521)
          {
            paramMsgSummary.b = "";
            continue;
            paramMsgSummary.b = "";
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemRouterDataLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */