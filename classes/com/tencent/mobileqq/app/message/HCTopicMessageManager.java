package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class HCTopicMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public HCTopicMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0) {
      return 0;
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (this.a.a().equals(paramString1)) {}
    String str;
    for (paramString2 = "我";; paramString2 = ContactUtils.f(this.a, paramString2, paramString1))
    {
      if ((paramString2 != null) && (paramString2.length() != 0))
      {
        str = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        str = this.a.a(true).a(true).a(paramString1);
      }
      if (str != null) {
        break;
      }
      return paramString1;
    }
    return str;
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap2 = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Map localMap1 = paramAddMessageContext.c;
    Object localObject = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    String str1 = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    localObject = ((RecentUserProxy)localObject).a(str1, 1);
    if (localMap2.containsKey(MsgProxyUtils.a(((RecentUser)localObject).uin, ((RecentUser)localObject).type))) {
      localObject = (RecentUser)localMap2.get(MsgProxyUtils.a(((RecentUser)localObject).uin, ((RecentUser)localObject).type));
    }
    for (;;)
    {
      String str2;
      if (!MsgProxyUtils.g(paramMessageRecord.msgtype))
      {
        str2 = MsgProxyUtils.a(str1, 1);
        ((RecentUser)localObject).uin = str1;
        ((RecentUser)localObject).type = 1;
        boolean bool = true;
        if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
          bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
        }
        if ((l > ((RecentUser)localObject).lastmsgtime) && (bool)) {
          ((RecentUser)localObject).lastmsgtime = l;
        }
        localMap2.put(str2, localObject);
        localObject = (MessageRecord)localMap1.get(str2);
        if ((localObject != null) && (!paramMessageRecord.isSendFromLocal())) {
          break label290;
        }
        localMap1.put(str2, paramMessageRecord);
      }
      for (;;)
      {
        if (paramMessageRecord.isSendFromLocal())
        {
          paramMessageRecord.extraflag = 32772;
          paramMessageRecord.sendFailCode = 0;
        }
        super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
        return;
        label290:
        if (a(paramMessageRecord) >= a((MessageRecord)localObject)) {
          localMap1.put(str2, paramMessageRecord);
        }
      }
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
    Object localObject;
    if ((paramMessage.nickName == null) || (paramMessage.nickName.equals(paramMessage.senderuin))) {
      localObject = paramMessage.nickName;
    }
    try
    {
      String str = paramMessage.getExtInfoFromExtStr("hotchat_nick");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      paramMessage.nickName = ((String)localObject);
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "processNickName", new Object[] { paramMessage.senderuin, paramMessage.nickName });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\HCTopicMessageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */