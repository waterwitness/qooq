package com.tencent.mobileqq.app.message;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class DiscMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public DiscMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.a.a().equals(paramString1)) {
      return this.a.a().getResources().getString(2131369246);
    }
    return ContactUtils.c(this.a, paramString2, paramString1);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:" + paramMessageRecord);
    }
    Map localMap = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Object localObject = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(str1, paramMessageRecord.istroop);
    localObject = null;
    TroopInfoManager localTroopInfoManager = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager;
    String str2;
    MessageInfo localMessageInfo;
    if (localTroopInfoManager != null)
    {
      str2 = str1 + "&" + 3000;
      localMessageInfo = localTroopInfoManager.a(str2);
      if (localMessageInfo == null) {
        break label558;
      }
      if (localMessageInfo.a() == paramMessageRecord.shmsgseq) {
        break label501;
      }
      localMessageInfo = null;
      localObject = localMessageInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
        localObject = localMessageInfo;
      }
    }
    if ((localObject != null) && (((MessageInfo)localObject).a()))
    {
      int j = ((MessageInfo)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + j + "|ru.msgType:" + localRecentUser.msgType);
      }
      if (j >= localRecentUser.msgType)
      {
        localRecentUser.msgType = j;
        localRecentUser.msg = MessageInfo.a(this.a, str1, (MessageInfo)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(MsgProxyUtils.a(str1, i), localRecentUser);
      }
    }
    if (localMap.containsKey(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type))) {}
    for (localObject = (RecentUser)localMap.get(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type));; localObject = localRecentUser)
    {
      if (!MsgProxyUtils.g(paramMessageRecord.msgtype))
      {
        ((RecentUser)localObject).uin = str1;
        ((RecentUser)localObject).type = i;
        boolean bool = true;
        if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
          bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
        }
        if ((l > ((RecentUser)localObject).lastmsgtime) && (bool))
        {
          ((RecentUser)localObject).lastmsgtime = l;
          localMap.put(MsgProxyUtils.a(str1, i), localObject);
        }
      }
      super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
      return;
      label501:
      localObject = localMessageInfo;
      if (!paramMessageRecord.isread) {
        break;
      }
      localTroopInfoManager.b(str2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
      }
      localObject = null;
      break;
      label558:
      localObject = localMessageInfo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
      localObject = localMessageInfo;
      break;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt);
    }
    super.a(paramString, paramInt);
    ProxyManager localProxyManager = this.a.a();
    paramString = localProxyManager.a().a(paramString, paramInt);
    if (paramString.shouldShowInRecentList())
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      localProxyManager.a().a(paramString);
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    super.b(paramString, paramInt, paramLong);
    d(paramString, paramInt, paramLong);
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    if (this.a.a().a(paramString, paramInt) > 0) {
      d(paramString, paramInt, paramLong);
    }
    super.c(paramString, paramInt, paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\DiscMessageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */