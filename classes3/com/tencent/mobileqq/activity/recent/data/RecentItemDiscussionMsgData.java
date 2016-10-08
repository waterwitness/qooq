package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemDiscussionMsgData
  extends RecentUserBaseData
{
  private static final String a = "RecentItemDiscussionMsgData";
  
  public RecentItemDiscussionMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(Context paramContext)
  {
    if (a().msg == null)
    {
      this.jdField_c_of_type_JavaLangCharSequence = "";
      this.d = "";
    }
    for (;;)
    {
      return;
      if ((a().msg instanceof AbstructRecentUserMsg))
      {
        AbstructRecentUserMsg localAbstructRecentUserMsg = (AbstructRecentUserMsg)a().msg;
        this.jdField_c_of_type_JavaLangCharSequence = localAbstructRecentUserMsg.a;
        this.d = localAbstructRecentUserMsg.jdField_b_of_type_JavaLangString;
        if ((a().msg instanceof TroopAtAllMsg)) {
          this.d = String.format("与%s的会话，有全体消息", new Object[] { this.jdField_b_of_type_JavaLangString });
        }
      }
      for (int i = 2131428324; (!android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (i > 0); i = 0)
      {
        this.J = paramContext.getResources().getColor(i);
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localObject1 = null)
    {
      if (localObject1 != null) {
        if ((((QQMessageFacade.Message)localObject1).istroop == 3000) && (((QQMessageFacade.Message)localObject1).msg == null) && (((QQMessageFacade.Message)localObject1).time == 0L)) {
          this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
        }
      }
      for (;;)
      {
        Object localObject3 = paramQQAppInterface.a();
        if (localObject3 != null)
        {
          this.H = ((ConversationFacade)localObject3).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          label115:
          localObject3 = (DiscussionManager)paramQQAppInterface.getManager(52);
          if (localObject3 != null) {
            localObject2 = ((DiscussionManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          }
          if ((this.H <= 0) || (!MsgProxyUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type))) {
            break label618;
          }
          this.G = 3;
          if ((localObject2 != null) || (TimeManager.a().b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {}
        }
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          ((DiscussionHandler)paramQQAppInterface.a(6)).a(l);
          TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          if ((localObject1 != null) && (!android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).senderuin)))
          {
            if (((QQMessageFacade.Message)localObject1).senderuin.equals(((QQMessageFacade.Message)localObject1).frienduin)) {
              ((QQMessageFacade.Message)localObject1).nickName = "";
            }
          }
          else
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            if (android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramContext, (DiscussionInfo)localObject2);
            }
            MsgSummary localMsgSummary = a();
            a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            localObject2 = "";
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              int i = ((DiscussionManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              localObject1 = localObject2;
              if (i > 0) {
                localObject1 = "(" + i + ")";
              }
            }
            this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
            a(paramQQAppInterface);
            a(paramQQAppInterface, localMsgSummary);
            a(paramQQAppInterface, paramContext, localMsgSummary);
            if (localMsgSummary.a) {
              break label719;
            }
            a(paramContext);
            paramQQAppInterface = a();
            if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
              paramQQAppInterface.reParse();
            }
            if (AppSetting.j)
            {
              if (this.jdField_b_of_type_JavaLangString == null) {
                break label752;
              }
              paramQQAppInterface = this.jdField_b_of_type_JavaLangString + "多人聊天";
              paramContext = new StringBuilder();
              paramContext.append(paramQQAppInterface).append(",");
              if (this.H != 0) {
                break label758;
              }
              if (this.jdField_c_of_type_JavaLangCharSequence != null) {
                paramContext.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
              }
              paramContext.append(com.tencent.mobileqq.text.TextUtils.c(this.jdField_b_of_type_JavaLangCharSequence.toString())).append(",").append(this.jdField_c_of_type_JavaLangString);
              this.d = paramContext.toString();
            }
            d();
            return;
            this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
            continue;
            this.H = 0;
            break label115;
            this.H = 0;
            this.jdField_b_of_type_Long = 0L;
            break label115;
            label618:
            this.G = 1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("discussion", 2, localNumberFormatException.toString());
              continue;
              if (!android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).frienduin)) {
                ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.c(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).senderuin);
              }
              if (android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName)) {
                ((QQMessageFacade.Message)localObject1).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, true);
              }
              if (android.text.TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName))
              {
                ((QQMessageFacade.Message)localObject1).nickName = ((QQMessageFacade.Message)localObject1).senderuin;
                continue;
                label719:
                if ((a().msg instanceof AbstructRecentUserMsg))
                {
                  this.jdField_c_of_type_JavaLangCharSequence = ((AbstructRecentUserMsg)a().msg).a;
                  continue;
                  label752:
                  paramQQAppInterface = "多人聊天";
                  continue;
                  label758:
                  if (this.H == 1) {
                    paramContext.append("有一条未读");
                  } else if (this.H == 2) {
                    paramContext.append("有两条未读");
                  } else if (this.H > 0) {
                    paramContext.append("有").append(this.H).append("条未读,");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemDiscussionMsgData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */