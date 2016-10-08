package com.tencent.mobileqq.activity.aio.tips;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;

public class NearbyMarketGrayTips
  implements Handler.Callback, GrayTipsTask
{
  private static final String jdField_a_of_type_JavaLangString = NearbyMarketGrayTips.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private NearbyGrayTipsManager jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQMessageFacade jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
  private Random jdField_a_of_type_JavaUtilRandom;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.b(), this);
  private int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NearbyMarketGrayTips(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
      this.b = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager = ((NearbyGrayTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)paramQQAppInterface.getManager(19));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
        this.b = 2;
      }
    }
  }
  
  private NearbyGrayTipsManager.GrayTipsConfig a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig1, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig2)
  {
    if (paramGrayTipsConfig1 != null)
    {
      if (paramGrayTipsConfig2 == null) {}
      do
      {
        do
        {
          return paramGrayTipsConfig1;
          if (paramGrayTipsConfig1.priority != paramGrayTipsConfig2.priority) {
            break;
          }
          if (paramGrayTipsConfig1.createTime < paramGrayTipsConfig2.createTime) {
            return paramGrayTipsConfig2;
          }
        } while (paramGrayTipsConfig1.createTime != paramGrayTipsConfig2.createTime);
        return paramGrayTipsConfig1;
      } while (paramGrayTipsConfig1.priority >= paramGrayTipsConfig2.priority);
      return paramGrayTipsConfig2;
    }
    if (paramGrayTipsConfig2 != null) {
      return paramGrayTipsConfig2;
    }
    return null;
  }
  
  private boolean a(int paramInt, Object... paramVarArgs)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800524B", "0X800524B", 0, 0, String.valueOf(paramInt), "", "", "");
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, paramVarArgs);
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    MessageRecord localMessageRecord = null;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {}
    for (paramVarArgs = paramVarArgs[0].toString();; paramVarArgs = null)
    {
      if (!TextUtils.isEmpty(paramVarArgs))
      {
        localMessageRecord = MessageRecordFactory.a(63509);
        long l = MessageCache.a();
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localMessageRecord.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramVarArgs, l, 63509, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
        localMessageRecord.isread = true;
      }
      return localMessageRecord;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setOtherGender, " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onAIOEvent, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(paramInt));
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(paramInt);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1006;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      switch (paramMessage.what)
      {
      }
      break;
    }
    long l1;
    label368:
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig;
    do
    {
      do
      {
        do
        {
          return false;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(MessageCache.a() * 1000L))) {
            break;
          }
          return false;
          l1 = MessageCache.a() * 1000L;
          long l2 = System.currentTimeMillis();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          long l3 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getAIOList cost:" + (l3 - l2) + " ms");
          }
          if ((paramMessage == null) || (paramMessage.size() <= 0)) {
            break label368;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage));
        paramMessage = (ChatMessage)paramMessage.get(paramMessage.size() - 1);
      } while (MessageUtils.a(paramMessage.msgtype));
      if (paramMessage.isSend()) {}
      for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, paramMessage.msg, 1, l1); paramMessage != null; paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, paramMessage.msg, 2, l1))
      {
        localObject = paramMessage.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
        if (localObject == null) {
          break;
        }
        localObject = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, paramMessage.url);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!a(paramMessage.id, new Object[] { localObject })) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage.id, l1);
        break;
      }
      localGrayTipsConfig = a(this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, l1), this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.c(this.b, this.jdField_a_of_type_Int, l1));
    } while (localGrayTipsConfig == null);
    this.jdField_a_of_type_JavaUtilRandom.setSeed(l1);
    Object localObject = localGrayTipsConfig.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
    if (localGrayTipsConfig.sceneId == 2)
    {
      if (localObject == null) {
        break label1260;
      }
      paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 2, localGrayTipsConfig.url);
    }
    while (!TextUtils.isEmpty(paramMessage))
    {
      if (!a(localGrayTipsConfig.id, new Object[] { paramMessage })) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(localGrayTipsConfig.id, l1);
      break;
      if (localGrayTipsConfig.sceneId == 4)
      {
        if (localObject != null)
        {
          paramMessage = (Message)localObject;
          if (!TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text)) {}
        }
        else
        {
          paramMessage = new NearbyGrayTipsManager.Wording();
          paramMessage.text = "不知道如何开口，试试推荐的打招呼吧！";
          paramMessage.highlightText = "打招呼";
        }
        paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, paramMessage.text, paramMessage.highlightText, 8, localGrayTipsConfig.url);
        continue;
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage)) {
          return false;
        }
        l1 = MessageCache.a() * 1000L;
        int i;
        label644:
        label796:
        int j;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(l1)))
        {
          i = 1;
          if ((i == 0) || (paramMessage == null) || (paramMessage.size() <= 0)) {
            break label840;
          }
          localObject = (ChatMessage)paramMessage.get(paramMessage.size() - 1);
          if (QLog.isDevelopLevel()) {
            QLog.d("longchen", 4, "last msg=" + ((ChatMessage)localObject).toString());
          }
          if (!MsgUtils.b(((ChatMessage)localObject).issend)) {
            break label1123;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QQMessageFacade.Message)localObject)) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, ((QQMessageFacade.Message)localObject).msg, 1, l1);
          if (paramMessage == null) {
            break label842;
          }
          paramMessage = paramMessage.iterator();
          i = 0;
          j = i;
          if (!paramMessage.hasNext()) {
            break label845;
          }
          if (MessageUtils.a(((ChatMessage)paramMessage.next()).msgtype)) {
            break label1257;
          }
          i += 1;
        }
        label840:
        label842:
        label845:
        label909:
        label930:
        label950:
        label1069:
        label1080:
        label1091:
        label1121:
        label1123:
        label1257:
        for (;;)
        {
          break label796;
          i = 0;
          break label644;
          break;
          j = 0;
          if (j == 1) {}
          for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.b(this.b, this.jdField_a_of_type_Int, l1);; paramMessage = null)
          {
            localGrayTipsConfig = a((NearbyGrayTipsManager.GrayTipsConfig)localObject, paramMessage);
            if (QLog.isDevelopLevel())
            {
              StringBuilder localStringBuilder1 = new StringBuilder();
              StringBuilder localStringBuilder2 = localStringBuilder1.append("send msg done. config1 id=");
              if (localObject == null)
              {
                localObject = "null";
                localObject = localStringBuilder2.append(localObject).append("|config2 id=");
                if (paramMessage != null) {
                  break label1069;
                }
                paramMessage = "null";
                localObject = ((StringBuilder)localObject).append(paramMessage).append("|chosen config id=");
                if (localGrayTipsConfig != null) {
                  break label1080;
                }
                paramMessage = "null";
                ((StringBuilder)localObject).append(paramMessage);
                QLog.d("nearby_aio_operation_gray_tips", 4, localStringBuilder1.toString());
              }
            }
            else
            {
              if (localGrayTipsConfig == null) {
                break;
              }
              localObject = localGrayTipsConfig.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
              if (localObject == null) {
                break;
              }
              paramMessage = null;
              if (localGrayTipsConfig.sceneId != 1) {
                break label1091;
              }
              paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 1, localGrayTipsConfig.url);
            }
            for (;;)
            {
              if (TextUtils.isEmpty(paramMessage)) {
                break label1121;
              }
              if (!a(localGrayTipsConfig.id, new Object[] { paramMessage })) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(localGrayTipsConfig.id, l1);
              break;
              localObject = Integer.valueOf(((NearbyGrayTipsManager.GrayTipsConfig)localObject).id);
              break label909;
              paramMessage = Integer.valueOf(paramMessage.id);
              break label930;
              paramMessage = Integer.valueOf(localGrayTipsConfig.id);
              break label950;
              if (localGrayTipsConfig.sceneId == 3) {
                paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, localGrayTipsConfig.url);
              }
            }
            break;
            if (QLog.isDevelopLevel()) {
              QLog.d("nearby_aio_operation_gray_tips", 4, "receive message");
            }
            if (MessageUtils.a(((ChatMessage)localObject).msgtype)) {
              break;
            }
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, ((ChatMessage)localObject).msg, 2, l1);
            if (paramMessage == null) {
              break;
            }
            localObject = paramMessage.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
            if (localObject == null) {
              break;
            }
            localObject = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, paramMessage.url);
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            if (!a(paramMessage.id, new Object[] { localObject })) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage.id, l1);
            break;
          }
        }
      }
      label1260:
      paramMessage = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\tips\NearbyMarketGrayTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */