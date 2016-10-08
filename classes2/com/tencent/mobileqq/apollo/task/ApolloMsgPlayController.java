package com.tencent.mobileqq.apollo.task;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;
import psm;
import psn;
import pso;
import psp;
import psq;

public class ApolloMsgPlayController
  implements IApolloActDldCallback, IApolloTaskListener
{
  private static ApolloMsgPlayController jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController;
  public static final String a = "ApolloMsgPlayController";
  public ChatAdapter1 a;
  public XListView a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  private ApolloMsgPlayController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static ApolloMsgPlayController a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController == null) {
        jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController = new ApolloMsgPlayController();
      }
      ApolloMsgPlayController localApolloMsgPlayController = jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController;
      return localApolloMsgPlayController;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    this.jdField_a_of_type_MqqOsMqqHandler = null;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[onApolloActionDownloadStatusNotify], downloadStatus:" + paramInt2 + ",usrData:" + paramObject);
    }
    if ((paramObject == null) || (!(paramObject instanceof Long)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_MqqOsMqqHandler == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, "usrData is null or NOT Long");
      }
    }
    int i;
    do
    {
      do
      {
        return;
        i = AIOUtils.a(((Long)paramObject).longValue(), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      } while (i < 0);
      paramObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
    } while ((paramObject == null) || (!(paramObject instanceof MessageForApollo)));
    this.jdField_a_of_type_MqqOsMqqHandler.post(new psq(this, (ChatMessage)paramObject, i, paramInt2, paramInt1));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[onTaskComplete], usrData:" + paramObject + ",errCode:" + paramInt);
    }
    if ((paramObject == null) || (this.jdField_a_of_type_MqqOsMqqHandler == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {}
    do
    {
      do
      {
        return;
        paramInt = AIOUtils.a(((Long)paramObject).longValue(), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
        if (-1 != paramInt) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloMsgPlayController", 2, "pos = -1;");
      return;
      paramObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(paramInt);
    } while ((paramObject == null) || (!(paramObject instanceof MessageForApollo)));
    this.jdField_a_of_type_MqqOsMqqHandler.post(new psp(this, (ChatMessage)paramObject, paramInt));
  }
  
  public void a(ApolloMsgPlayParam paramApolloMsgPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[startPlayApolloMsg]");
    }
    ApolloActionManager localApolloActionManager = ApolloActionManager.a();
    if ((paramApolloMsgPlayParam == null) || (paramApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(paramApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo))) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, "erroInfo->playParam is invalid.");
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          break label53;
          do
          {
            return;
          } while (localApolloActionManager.c());
          if (ApolloManager.a(BaseApplicationImpl.getContext())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ApolloMsgPlayController", 2, "Apollo switch NOT open.");
        return;
      } while ((!a(paramApolloMsgPlayParam.jdField_b_of_type_Int, paramApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), paramApolloMsgPlayParam.jdField_a_of_type_Int, paramApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || ((localApolloActionManager.jdField_b_of_type_Boolean) && (paramApolloMsgPlayParam.jdField_b_of_type_Int != 2)));
      paramApolloMsgPlayParam.jdField_c_of_type_Int = 0;
      if (-1 != paramApolloMsgPlayParam.jdField_c_of_type_Int) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloMsgPlayController", 2, "troop case: task running, return.");
    return;
    MessageForApollo localMessageForApollo = (MessageForApollo)paramApolloMsgPlayParam.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (ApolloManager.a(localMessageForApollo.mApolloMessage.id))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, "current action is invalid,id:" + localMessageForApollo.mApolloMessage.id);
      }
      paramApolloMsgPlayParam = BaseApplicationImpl.getContext();
      QQToast.a(paramApolloMsgPlayParam, paramApolloMsgPlayParam.getResources().getString(2131372340), 0).a();
      return;
    }
    ThreadManager.a(new psn(this, paramApolloMsgPlayParam, localApolloActionManager), 5, null, true);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      MessageForApollo localMessageForApollo;
      ApolloTaskParam localApolloTaskParam;
      boolean bool;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloMsgPlayController", 2, "[playCurMsg] pos:" + paramInt4);
        }
        if ((-1 == paramInt4) || (paramChatMessage == null)) {
          return;
        }
        localMessageForApollo = (MessageForApollo)paramChatMessage;
        localApolloTaskParam = new ApolloTaskParam();
        localApolloTaskParam.jdField_b_of_type_Int = localMessageForApollo.mApolloMessage.id;
        localApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloTaskListener = this;
        localApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloActDldCallback = this;
        localApolloTaskParam.jdField_d_of_type_Int = paramInt2;
        localApolloTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
        localApolloTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
        localApolloTaskParam.jdField_a_of_type_Int = paramInt1;
        localApolloTaskParam.e = paramInt3;
        if (!ApolloActionManager.a().b()) {
          localApolloTaskParam.jdField_d_of_type_Boolean = true;
        }
        if (localApolloTaskParam.e == 0)
        {
          localApolloTaskParam.jdField_a_of_type_JavaLangString = localMessageForApollo.selfuin;
          localApolloTaskParam.jdField_b_of_type_JavaLangString = localMessageForApollo.frienduin;
          localApolloTaskParam.jdField_c_of_type_JavaLangString = localMessageForApollo.inputText;
          localApolloTaskParam.jdField_b_of_type_Boolean = localMessageForApollo.isBarrageMode();
          if (!localMessageForApollo.isDoubleAction()) {
            break label439;
          }
          paramInt1 = 1;
          localApolloTaskParam.jdField_c_of_type_Int = paramInt1;
          if (ApolloActionManager.a().a != null)
          {
            paramChatMessage = ((ApolloDaoManager)ApolloActionManager.a().a.getManager(154)).a(localApolloTaskParam.jdField_b_of_type_Int);
            if ((paramChatMessage != null) && (TextUtils.isEmpty(localApolloTaskParam.jdField_c_of_type_JavaLangString))) {
              localApolloTaskParam.jdField_c_of_type_JavaLangString = ApolloActionHelper.a(paramChatMessage.bubbleText);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloMsgPlayController", 2, "senderUin:" + localApolloTaskParam.jdField_a_of_type_JavaLangString + ",recUin:" + localApolloTaskParam.jdField_b_of_type_JavaLangString + ",manNum:" + localApolloTaskParam.jdField_c_of_type_Int + ",actionID:" + localApolloTaskParam.jdField_b_of_type_Int);
          }
          paramChatMessage = ApolloActionManager.a().a;
          if (TextUtils.isEmpty(localMessageForApollo.inputText)) {
            break label444;
          }
          bool = true;
          ApolloActionHelper.a(paramChatMessage, localApolloTaskParam, bool, localApolloTaskParam.jdField_b_of_type_Boolean);
          ApolloActionManager.a().a(localApolloTaskParam);
          continue;
        }
        if (localApolloTaskParam.e == 1) {
          break label411;
        }
      }
      finally {}
      if (localApolloTaskParam.e == 3000)
      {
        label411:
        localApolloTaskParam.jdField_b_of_type_JavaLangString = Long.toString(localMessageForApollo.mApolloMessage.peer_uin);
        localApolloTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
        continue;
        label439:
        paramInt1 = 0;
        continue;
        label444:
        bool = false;
      }
    }
  }
  
  public void a(XListView paramXListView, ChatAdapter1 paramChatAdapter1, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[onTaskStart], usrData:" + paramObject);
    }
    if ((paramObject == null) || (this.jdField_a_of_type_MqqOsMqqHandler == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {}
    int i;
    do
    {
      do
      {
        return;
        i = AIOUtils.a(((Long)paramObject).longValue(), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      } while (i < 0);
      paramObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
    } while (paramObject == null);
    this.jdField_a_of_type_MqqOsMqqHandler.post(new pso(this, (ChatMessage)paramObject, i));
  }
  
  public boolean a(int paramInt1, boolean paramBoolean, int paramInt2, ChatMessage paramChatMessage)
  {
    ApolloActionManager localApolloActionManager = ApolloActionManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[isValidApolloStatus], frmWhere:" + paramInt1 + ",isSend:" + paramBoolean + ",sessionType:" + paramInt2);
    }
    int j = localApolloActionManager.e;
    int i = j;
    if (-1 == j)
    {
      i = j;
      if (localApolloActionManager.a != null)
      {
        i = ApolloActionHelper.a(localApolloActionManager.a.a(), localApolloActionManager.a);
        localApolloActionManager.e = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "funSwitch:" + i);
    }
    ThreadManager.a(new psm(this, paramInt1, paramChatMessage, localApolloActionManager, paramInt2, paramBoolean), 5, null, true);
    if (localApolloActionManager.e == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, "close status, return.");
      }
      if ((2 == paramInt1) && (this.jdField_a_of_type_MqqOsMqqHandler != null)) {
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(49).sendToTarget();
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[valid status]");
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[isActionRunning], pos:" + paramLong);
    }
    ApolloActionTask localApolloActionTask = ApolloActionManager.a().a();
    if ((localApolloActionTask == null) || (localApolloActionTask.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam == null) || (!localApolloActionTask.jdField_a_of_type_Boolean)) {}
    while (localApolloActionTask.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Long != paramLong) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "Running");
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\task\ApolloMsgPlayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */