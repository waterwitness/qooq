package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipCallBack;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import qko;
import qkq;
import qkr;
import qks;
import qkt;

public abstract class BaseMessageManager
  extends Observable
  implements IMessageManager
{
  protected static final long a = 35000L;
  public static final String a = "Q.msg.BaseMessageManager";
  protected static final long b = 40000L;
  protected static final long c = 15000L;
  public QQAppInterface a;
  public QQMessageFacade a;
  private Object a;
  private Object b;
  
  public BaseMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.b = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private long a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject1 = null;
    Object localObject2;
    if (MsgProxyUtils.a(paramInt) == 1009)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.ag, 1009);
      localObject2 = "";
    }
    for (;;)
    {
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (!((List)localObject1).isEmpty())
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
            if (paramString.equals(localMessageRecord.senderuin))
            {
              return localMessageRecord.uniseq;
              if (MsgProxyUtils.a(paramInt) == 1001)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.ar, 1001);
                localObject2 = AppConstants.aO;
                continue;
              }
              if (MsgProxyUtils.a(paramInt) != 1010) {
                break label312;
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.aH, 1010);
              localObject2 = AppConstants.aP;
              continue;
            }
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || ((!AppConstants.aO.equals(localMessageRecord.senderuin)) && (!AppConstants.aP.equals(localMessageRecord.senderuin)))) {
              break label309;
            }
            i = 1;
          }
        }
      }
      label309:
      for (;;)
      {
        break;
        if (i != 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject2, MsgProxyUtils.a(paramInt));
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if (paramString.equals(((MessageRecord)localObject2).senderuin)) {
                return ((MessageRecord)localObject2).uniseq;
              }
            }
          }
        }
        return 0L;
      }
      label312:
      localObject2 = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList1, List paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList1 == null) || (paramList1.isEmpty())) {}
    PasswdRedBagManager localPasswdRedBagManager;
    Object localObject3;
    do
    {
      return;
      localPasswdRedBagManager = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
      localObject3 = new HashMap();
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (MessageRecord)localIterator.next();
        if ((localObject1 instanceof MessageForFoldMsg))
        {
          MessageForFoldMsg localMessageForFoldMsg = (MessageForFoldMsg)localObject1;
          if (((paramBoolean1) || (!localPasswdRedBagManager.a(localMessageForFoldMsg.frienduin, localMessageForFoldMsg.istroop, localMessageForFoldMsg.redBagId))) && ((!localMessageForFoldMsg.isSend()) || (localMessageForFoldMsg.foldFlag) || (localMessageForFoldMsg.msgtype != 63530)))
          {
            localObject2 = (qkt)((HashMap)localObject3).get(localMessageForFoldMsg.redBagId);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new qkt();
              ((HashMap)localObject3).put(localMessageForFoldMsg.redBagId, localObject1);
            }
            if (!localMessageForFoldMsg.foldFlag)
            {
              ((qkt)localObject1).jdField_a_of_type_Boolean = true;
              if (localMessageForFoldMsg.shmsgseq > ((qkt)localObject1).jdField_b_of_type_Long)
              {
                ((qkt)localObject1).jdField_b_of_type_Long = localMessageForFoldMsg.shmsgseq;
                ((qkt)localObject1).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
              }
            }
            else
            {
              ((qkt)localObject1).jdField_a_of_type_Int += 1;
              ((qkt)localObject1).jdField_a_of_type_JavaUtilLinkedHashSet.add(localMessageForFoldMsg.senderuin);
              if (localMessageForFoldMsg.shmsgseq < ((qkt)localObject1).jdField_a_of_type_Long)
              {
                ((qkt)localObject1).jdField_a_of_type_Long = localMessageForFoldMsg.shmsgseq;
                ((qkt)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
              }
            }
          }
        }
      }
    } while (((HashMap)localObject3).isEmpty());
    Object localObject2 = ((HashMap)localObject3).entrySet().iterator();
    label307:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (qkt)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (((qkt)localObject3).jdField_a_of_type_Int > 0)
      {
        if (((qkt)localObject3).jdField_a_of_type_Boolean) {
          ((qkt)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = ((qkt)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg;
        }
        if (paramList2 != null) {
          break label460;
        }
      }
    }
    label460:
    for (Object localObject1 = (List)MsgPool.a(paramQQAppInterface.getAccount()).b().get(MsgProxyUtils.a(((MessageRecord)paramList1.get(0)).frienduin, ((MessageRecord)paramList1.get(0)).istroop));; localObject1 = paramList2)
    {
      localObject1 = localPasswdRedBagManager.a((List)localObject1, ((qkt)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg, ((qkt)localObject3).jdField_a_of_type_JavaUtilLinkedHashSet, ((qkt)localObject3).jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
      if ((localObject1 == null) || (paramList2 != null)) {
        break label307;
      }
      MsgProxyUtils.c(paramList1, (MessageRecord)localObject1, true);
      break label307;
      break;
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qks(this, paramMessageRecord, l));
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0) {
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (!MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 6)
      {
        if ((paramConversationInfo.type == 1001) && (AppConstants.ar.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.ag)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(AppConstants.aH)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 9)
      {
        if ((paramConversationInfo.type == 1008) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else {
        return ConversationFacade.a(paramConversationInfo);
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + paramString + ", type = " + paramInt + ", needDeleteDB = " + paramBoolean1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramBoolean1);
    Object localObject;
    switch (paramInt)
    {
    default: 
      if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString);
      }
      if (i > 0) {
        localMessage.cleanMessageRecordBaseField();
      }
      if ((paramInt != 3000) && (paramInt != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, MsgProxyUtils.a(paramInt))))
      {
        if (MsgProxyUtils.a(paramInt) != 1009) {
          break label332;
        }
        a(AppConstants.ag, 1009, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ag, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, localMessage.istroop);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((RecentUser)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.remove(MsgProxyUtils.a(paramString, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessage);
      return i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0);
      break;
      label332:
      if (MsgProxyUtils.a(paramInt) == 1001)
      {
        a(AppConstants.ar, 1001, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ar, 1001);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (MsgProxyUtils.a(paramInt) == 1010)
      {
        a(AppConstants.aH, 1010, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aH, 1010);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
    }
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    String str = MsgProxyUtils.a(paramString, paramInt);
    Object localObject1 = null;
    Object localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    if ((localObject2 == null) || (!((QQMessageFacade.Message)localObject2).isCacheValid))
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(AppConstants.aj))) {
        localObject1 = DataLineMsgRecord.tableName();
      }
      if (paramString.equals(String.valueOf(AppConstants.ak))) {
        localObject1 = DataLineMsgRecord.tableName(1);
      }
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject1, paramEntityManager);
      Object localObject3 = localObject1;
      localObject2 = localMessage;
      if (localMessage == null) {
        if ((!MsgProxyUtils.c(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject1;
          localObject2 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject3, paramEntityManager);
        }
      }
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" message:" + localObject2);
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).a((String)localObject3, paramEntityManager);
          localObject1 = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject1 = paramEntityManager;
          }
        }
      }
      if (localObject1 != null)
      {
        if (((paramString.equals(String.valueOf(AppConstants.aj))) || (paramString.equals(String.valueOf(AppConstants.ak)))) && (((QQMessageFacade.Message)localObject1).msgData != null))
        {
          paramString = new DataLineMsgRecord();
          DataLineMsgRecord.unpackMsgData(paramString, ((QQMessageFacade.Message)localObject1).msgData, ((QQMessageFacade.Message)localObject1).versionCode);
          ((QQMessageFacade.Message)localObject1).msg = paramString.msg;
        }
        if ((AppConstants.ar.equals(((QQMessageFacade.Message)localObject1).frienduin)) || (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) != 1001))
        {
          paramString = (String)localObject1;
          if (!AppConstants.aH.equals(((QQMessageFacade.Message)localObject1).frienduin))
          {
            paramString = (String)localObject1;
            if (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) != 1010) {}
          }
        }
        else
        {
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          paramString = (String)localObject1;
          if (paramEntityManager != null)
          {
            paramString = (String)localObject1;
            if (paramEntityManager.size() > 0)
            {
              paramEntityManager = paramEntityManager.iterator();
              do
              {
                paramString = (String)localObject1;
                if (!paramEntityManager.hasNext()) {
                  break;
                }
                paramString = (MessageRecord)paramEntityManager.next();
              } while ((paramString.senderuin == null) || (!paramString.senderuin.equals(paramString.frienduin)) || (MessageUtils.a(paramString.msgtype)));
              ((QQMessageFacade.Message)localObject1).hasReply = true;
              paramString = (String)localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
                paramString = (String)localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramEntityManager = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(str);
        if (paramEntityManager != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.put(str, paramString);
        paramEntityManager = paramString;
      }
      catch (Throwable localThrowable)
      {
        paramEntityManager = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramEntityManager = paramString;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramString = paramEntityManager;
      if (paramEntityManager == null) {
        break;
      }
      paramString = paramEntityManager;
      if (!MsgProxyUtils.a(paramEntityManager.frienduin, paramEntityManager.istroop)) {
        break;
      }
      paramEntityManager.istroop = MsgProxyUtils.a(paramEntityManager.istroop);
      return paramEntityManager;
      paramEntityManager = new QQMessageFacade.Message();
      paramEntityManager.frienduin = paramString;
      paramEntityManager.istroop = paramInt;
      paramString = paramEntityManager;
      continue;
      if (a(paramEntityManager) < a(paramString))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.put(str, paramString);
      }
      else if ((!paramEntityManager.isCacheValid) && (paramString.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.put(str, paramString);
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramEntityManager.isCacheValid = true;
        paramString = paramEntityManager;
        continue;
        paramEntityManager = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localObject2);
          paramEntityManager = localThrowable;
        }
      }
    }
  }
  
  public List a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  protected List a(String paramString, int paramInt1, int paramInt2)
  {
    return new ArrayList();
  }
  
  public List a(String paramString, int paramInt, long paramLong)
  {
    if (paramLong >= 0L) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramLong); localObject1 == null; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, true, true)) {
      return new ArrayList();
    }
    Object localObject3 = (List)((ArrayList)localObject1).clone();
    if (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject3, null, false, true);
    }
    MsgProxyUtils.a((List)localObject3);
    MsgProxyUtils.a(paramString, paramInt, (List)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((!((List)localObject3).isEmpty()) && ((((List)localObject3).get(((List)localObject3).size() - 1) instanceof MessageForLongMsg)) && (MsgProxyUtils.a((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt))))
    {
      localObject1 = (MessageForLongMsg)((List)localObject3).get(((List)localObject3).size() - 1);
      if ((((MessageForLongMsg)localObject1).longMsgFragmentList != null) && (!((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty()) && (((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0)).longMsgIndex < this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt).longMsgIndex))
      {
        a((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), true, 2);
        b(paramString, paramInt, (MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), 2);
        a((MessageRecord)localObject1, true, 3);
        b(paramString, paramInt, (MessageRecord)localObject1, 3);
      }
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("newAIOCursor clone ");
      if (localObject3 != null)
      {
        localObject1 = Integer.valueOf(((List)localObject3).size());
        QLog.d("Q.msg.BaseMessageManager", 2, localObject1);
      }
    }
    else
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label855;
      }
      Object localObject4 = (MessageRecord)((Iterator)localObject3).next();
      ((List)localObject1).add((ChatMessage)localObject4);
      Object localObject5 = ((MessageRecord)localObject4).getExtInfoFromExtStr("sens_msg_ctrl_info");
      Object localObject6;
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        if (((MessageRecord)localObject4).isSend())
        {
          ((MessageRecord)localObject4).saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
          continue;
          localObject1 = "clone is null";
          break;
        }
        localObject6 = new bankcode_info.BankcodeCtrlInfo();
      }
      try
      {
        ((bankcode_info.BankcodeCtrlInfo)localObject6).mergeFrom(HexUtil.hexStr2Bytes((String)localObject5));
        int i = 0;
        if (((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.has()) {
          i = ((bankcode_info.BankcodeCtrlInfo)localObject6).msgtail_id.get();
        }
        if (i != 1) {
          continue;
        }
        ((ChatMessage)localObject4).parse();
        localObject5 = MessageRecordFactory.a(64522);
        ((MessageRecord)localObject5).msgtype = 64490;
        ((MessageRecord)localObject5).senderuin = ((MessageRecord)localObject5).selfuin;
        ((MessageRecord)localObject5).frienduin = paramString;
        ((MessageRecord)localObject5).istroop = ((MessageRecord)localObject4).istroop;
        ((MessageRecord)localObject5).msg = "";
        ((MessageRecord)localObject5).isread = true;
        ((MessageRecord)localObject5).shmsgseq = ((MessageRecord)localObject4).shmsgseq;
        ((MessageRecord)localObject5).time = ((MessageRecord)localObject4).time;
        ((MessageRecord)localObject5).saveExtInfoToExtStr("sens_msg_uniseq", Long.toString(((MessageRecord)localObject4).uniseq));
        ((List)localObject1).add((ChatMessage)localObject5);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str;
          localException.printStackTrace();
        }
      }
      if ((paramInt == 1008) && ((localObject4 instanceof MessageForStructing)))
      {
        localObject6 = ((MessageRecord)localObject4).getExtInfoFromExtStr("pa_phone_msg_tip");
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          localObject5 = new TroopTipsEntity();
          ((TroopTipsEntity)localObject5).optContent = ((String)localObject6);
          ((TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80)).a((TroopTipsEntity)localObject5);
          localObject6 = new MessageForGrayTips();
          paramLong = ((MessageRecord)localObject4).time;
          str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          ((MessageForGrayTips)localObject6).init(str, paramString, str, ((TroopTipsEntity)localObject5).optContent, paramLong, 64488, paramInt, paramLong);
          ((MessageForGrayTips)localObject6).isread = true;
          TroopTipsMsgMgr.a((MessageForGrayTips)localObject6, ((TroopTipsEntity)localObject5).highlightItems);
          ((List)localObject1).add(localObject6);
        }
      }
      if ((paramInt == 0) && ((localObject4 instanceof MessageForPoke)))
      {
        localObject4 = (MessageForPoke)localObject4;
        if (!((MessageForPoke)localObject4).isSend()) {
          ((List)localObject2).add(localObject4);
        }
        if ((((MessageForPoke)localObject4).isread) && (!((MessageForPoke)localObject4).isPlayed) && (!((MessageForPoke)localObject4).isSend())) {
          ((MessageForPoke)localObject4).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
    label855:
    paramInt = 0;
    while (paramInt < ((List)localObject2).size())
    {
      paramString = (MessageForPoke)((List)localObject2).get(paramInt);
      if ((paramString != null) && (paramInt != ((List)localObject2).size() - 1)) {
        paramString.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramInt += 1;
    }
    return (List)localObject1;
  }
  
  public List a(List paramList, String paramString, int paramInt, ArrayList paramArrayList)
  {
    if ((paramInt == 3000) || (paramInt == 1)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.next();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((paramInt != 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long))
          {
            if (((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!MsgProxyUtils.a(localMessageRecord))) {
              paramString.add(localMessageRecord);
            }
          }
          else if ((paramInt == 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long) && (localMessageRecord.msgUid == localRevokeMsgInfo.jdField_b_of_type_Long)) {
            paramString.add(localMessageRecord);
          }
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    synchronized (this.b)
    {
      try
      {
        this.b.wait(15000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait over");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait interrupted");
          }
        }
      }
    }
  }
  
  /* Error */
  public void a(QQMessageFacade.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   4: sipush 64533
    //   7: if_icmpeq +23 -> 30
    //   10: aload_1
    //   11: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   14: sipush 64504
    //   17: if_icmpeq +13 -> 30
    //   20: aload_1
    //   21: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   24: sipush 201
    //   27: if_icmpne +27 -> 54
    //   30: aload_1
    //   31: getfield 370	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   34: sipush 1001
    //   37: if_icmpne +17 -> 54
    //   40: aload_1
    //   41: aload_1
    //   42: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   45: invokestatic 706	com/tencent/mobileqq/utils/ActionMsgUtil:a	(Ljava/lang/String;)LActionMsg/MsgBody;
    //   48: getfield 709	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   51: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   54: aload_1
    //   55: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   58: sipush 63518
    //   61: if_icmpeq +13 -> 74
    //   64: aload_1
    //   65: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   68: sipush 63486
    //   71: if_icmpne +592 -> 663
    //   74: new 711	tencent/mobileim/structmsg/structmsg$StructMsg
    //   77: dup
    //   78: invokespecial 712	tencent/mobileim/structmsg/structmsg$StructMsg:<init>	()V
    //   81: astore_3
    //   82: aload_3
    //   83: aload_1
    //   84: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   87: invokevirtual 713	tencent/mobileim/structmsg/structmsg$StructMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: pop
    //   91: aload_3
    //   92: getfield 717	tencent/mobileim/structmsg/structmsg$StructMsg:msg_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   95: invokevirtual 720	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   98: iconst_1
    //   99: if_icmpne +358 -> 457
    //   102: aload_3
    //   103: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   106: getfield 728	tencent/mobileim/structmsg/structmsg$SystemMsg:sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 602	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: tableswitch	default:+2929->3041, 1:+265->377, 2:+40->152, 3:+40->152, 4:+285->397, 5:+305->417, 6:+325->437
    //   152: aload_3
    //   153: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   156: getfield 732	tencent/mobileim/structmsg/structmsg$SystemMsg:msg_describe	Lcom/tencent/mobileqq/pb/PBStringField;
    //   159: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   162: astore_2
    //   163: new 312	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   170: aload_3
    //   171: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   174: getfield 739	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   177: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   180: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_2
    //   184: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore_2
    //   191: aload_1
    //   192: aload_2
    //   193: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   196: aload_1
    //   197: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   200: invokestatic 740	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   203: ifne +33 -> 236
    //   206: aload_1
    //   207: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   210: sipush 62535
    //   213: if_icmpeq +23 -> 236
    //   216: aload_1
    //   217: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   220: sipush 35534
    //   223: if_icmpeq +13 -> 236
    //   226: aload_1
    //   227: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   230: sipush 35533
    //   233: if_icmpne +43 -> 276
    //   236: aload_1
    //   237: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   240: invokestatic 706	com/tencent/mobileqq/utils/ActionMsgUtil:a	(Ljava/lang/String;)LActionMsg/MsgBody;
    //   243: astore_2
    //   244: aload_1
    //   245: aload_2
    //   246: getfield 709	ActionMsg/MsgBody:msg	Ljava/lang/String;
    //   249: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   252: aload_1
    //   253: aload_2
    //   254: getfield 743	ActionMsg/MsgBody:action	Ljava/lang/String;
    //   257: putfield 744	com/tencent/mobileqq/app/message/QQMessageFacade$Message:action	Ljava/lang/String;
    //   260: aload_1
    //   261: aload_2
    //   262: getfield 747	ActionMsg/MsgBody:shareAppID	J
    //   265: putfield 748	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shareAppID	J
    //   268: aload_1
    //   269: aload_2
    //   270: getfield 751	ActionMsg/MsgBody:actMsgContentValue	Ljava/lang/String;
    //   273: putfield 752	com/tencent/mobileqq/app/message/QQMessageFacade$Message:actMsgContentValue	Ljava/lang/String;
    //   276: aconst_null
    //   277: astore_2
    //   278: getstatic 755	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   281: aload_1
    //   282: getfield 361	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   285: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   288: ifeq +13 -> 301
    //   291: aload_1
    //   292: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   295: sipush 63525
    //   298: if_icmpeq +23 -> 321
    //   301: aload_0
    //   302: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   305: aload_1
    //   306: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   309: aload_1
    //   310: getfield 361	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   313: aload_1
    //   314: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   317: invokestatic 761	com/tencent/mobileqq/data/SystemMsg:decode	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/data/SystemMsg;
    //   320: astore_2
    //   321: aload_0
    //   322: aload_1
    //   323: invokevirtual 763	com/tencent/mobileqq/app/message/BaseMessageManager:b	(Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)V
    //   326: aload_2
    //   327: ifnull +719 -> 1046
    //   330: aload_1
    //   331: aload_2
    //   332: getfield 766	com/tencent/mobileqq/data/SystemMsg:message	Ljava/lang/String;
    //   335: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   338: invokestatic 769	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   341: ifeq +32 -> 373
    //   344: ldc 13
    //   346: iconst_4
    //   347: new 312	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 771
    //   357: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_1
    //   361: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   364: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: return
    //   374: astore_1
    //   375: aload_1
    //   376: athrow
    //   377: aload_0
    //   378: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   381: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   384: invokevirtual 780	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   387: ldc_w 781
    //   390: invokevirtual 786	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   393: astore_2
    //   394: goto -231 -> 163
    //   397: aload_0
    //   398: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   401: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   404: invokevirtual 780	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   407: ldc_w 787
    //   410: invokevirtual 786	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   413: astore_2
    //   414: goto -251 -> 163
    //   417: aload_0
    //   418: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   421: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   424: invokevirtual 780	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   427: ldc_w 788
    //   430: invokevirtual 786	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   433: astore_2
    //   434: goto -271 -> 163
    //   437: aload_0
    //   438: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   444: invokevirtual 780	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   447: ldc_w 789
    //   450: invokevirtual 786	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   453: astore_2
    //   454: goto -291 -> 163
    //   457: ldc 68
    //   459: astore_2
    //   460: aload_3
    //   461: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   464: getfield 792	tencent/mobileim/structmsg/structmsg$SystemMsg:group_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   467: invokevirtual 602	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   470: istore 5
    //   472: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +106 -> 581
    //   478: ldc 13
    //   480: iconst_2
    //   481: new 312	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 794
    //   491: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: iload 5
    //   496: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: ldc_w 796
    //   502: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload_3
    //   506: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   509: getfield 739	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   512: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   515: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc_w 798
    //   521: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload_3
    //   525: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   528: getfield 801	tencent/mobileim/structmsg/structmsg$SystemMsg:actor_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   531: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   534: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 803
    //   540: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_3
    //   544: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   547: getfield 806	tencent/mobileim/structmsg/structmsg$SystemMsg:action_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   550: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   553: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 808
    //   559: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_3
    //   563: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   566: getfield 732	tencent/mobileim/structmsg/structmsg$SystemMsg:msg_describe	Lcom/tencent/mobileqq/pb/PBStringField;
    //   569: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   572: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: iload 5
    //   583: invokestatic 811	com/tencent/mobileqq/troop/utils/TroopUtils:a	(I)I
    //   586: istore 5
    //   588: iload 5
    //   590: iconst_1
    //   591: if_icmpne +49 -> 640
    //   594: aload_3
    //   595: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   598: getfield 806	tencent/mobileim/structmsg/structmsg$SystemMsg:action_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   601: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   604: astore_2
    //   605: aload_3
    //   606: new 312	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   613: aload_2
    //   614: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_3
    //   618: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   621: getfield 732	tencent/mobileim/structmsg/structmsg$SystemMsg:msg_describe	Lcom/tencent/mobileqq/pb/PBStringField;
    //   624: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   627: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 814	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ltencent/mobileim/structmsg/structmsg$StructMsg;Ljava/lang/String;)Ljava/lang/String;
    //   636: astore_2
    //   637: goto -446 -> 191
    //   640: iload 5
    //   642: iconst_2
    //   643: if_icmpne -38 -> 605
    //   646: aload_3
    //   647: getfield 723	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   650: getfield 739	tencent/mobileim/structmsg/structmsg$SystemMsg:req_uin_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   653: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   656: astore_2
    //   657: goto -52 -> 605
    //   660: astore_1
    //   661: aload_1
    //   662: athrow
    //   663: aload_1
    //   664: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   667: sipush 63525
    //   670: if_icmpne +31 -> 701
    //   673: aload_1
    //   674: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   677: invokestatic 819	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   680: astore_3
    //   681: ldc 68
    //   683: astore_2
    //   684: aload_3
    //   685: ifnull +8 -> 693
    //   688: aload_3
    //   689: getfield 824	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgBrief	Ljava/lang/String;
    //   692: astore_2
    //   693: aload_1
    //   694: aload_2
    //   695: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   698: goto -502 -> 196
    //   701: aload_1
    //   702: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   705: sipush 60527
    //   708: if_icmpne +31 -> 739
    //   711: aload_1
    //   712: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   715: invokestatic 829	com/tencent/bitapp/BitAppMsgFactory:a	([B)Lcom/tencent/bitapp/BitAppMsg;
    //   718: astore_3
    //   719: ldc 68
    //   721: astore_2
    //   722: aload_3
    //   723: ifnull +8 -> 731
    //   726: aload_3
    //   727: getfield 832	com/tencent/bitapp/BitAppMsg:mMsgBrief	Ljava/lang/String;
    //   730: astore_2
    //   731: aload_1
    //   732: aload_2
    //   733: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   736: goto -540 -> 196
    //   739: aload_1
    //   740: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   743: sipush 60533
    //   746: if_icmpne +38 -> 784
    //   749: new 834	tencent/im/s2c/msgtype0x210/submsgtype0x76/SubMsgType0x76$MsgBody
    //   752: dup
    //   753: invokespecial 835	tencent/im/s2c/msgtype0x210/submsgtype0x76/SubMsgType0x76$MsgBody:<init>	()V
    //   756: astore_2
    //   757: aload_2
    //   758: aload_1
    //   759: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   762: invokevirtual 836	tencent/im/s2c/msgtype0x210/submsgtype0x76/SubMsgType0x76$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   765: pop
    //   766: aload_1
    //   767: aload_0
    //   768: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   771: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   774: aload_2
    //   775: invokestatic 841	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(Landroid/content/Context;Ltencent/im/s2c/msgtype0x210/submsgtype0x76/SubMsgType0x76$MsgBody;)Ljava/lang/String;
    //   778: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   781: goto -585 -> 196
    //   784: aload_1
    //   785: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   788: sipush 64536
    //   791: if_icmpne +104 -> 895
    //   794: aload_1
    //   795: ldc_w 843
    //   798: invokevirtual 844	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   801: ldc_w 846
    //   804: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   807: ifeq -611 -> 196
    //   810: aload_1
    //   811: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   814: ifnull -618 -> 196
    //   817: new 848	localpb/richMsg/RichMsg$FoldMsg
    //   820: dup
    //   821: invokespecial 849	localpb/richMsg/RichMsg$FoldMsg:<init>	()V
    //   824: astore_2
    //   825: aload_2
    //   826: aload_1
    //   827: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   830: invokevirtual 850	localpb/richMsg/RichMsg$FoldMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   833: pop
    //   834: aload_1
    //   835: aload_2
    //   836: getfield 854	localpb/richMsg/RichMsg$FoldMsg:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   839: invokevirtual 859	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   842: invokevirtual 864	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   845: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   848: goto -652 -> 196
    //   851: astore_2
    //   852: aload_2
    //   853: invokevirtual 669	java/lang/Exception:printStackTrace	()V
    //   856: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   859: ifeq -663 -> 196
    //   862: ldc_w 866
    //   865: iconst_2
    //   866: new 312	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 868
    //   876: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_2
    //   880: invokevirtual 871	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   883: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 873	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   892: goto -696 -> 196
    //   895: aload_1
    //   896: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   899: sipush 60524
    //   902: if_icmpne +49 -> 951
    //   905: aload_1
    //   906: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   909: ifnull -713 -> 196
    //   912: aload_1
    //   913: new 875	org/json/JSONObject
    //   916: dup
    //   917: new 94	java/lang/String
    //   920: dup
    //   921: aload_1
    //   922: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   925: invokespecial 878	java/lang/String:<init>	([B)V
    //   928: invokespecial 879	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   931: ldc_w 880
    //   934: invokevirtual 882	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   937: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   940: goto -744 -> 196
    //   943: astore_2
    //   944: aload_2
    //   945: invokevirtual 883	org/json/JSONException:printStackTrace	()V
    //   948: goto -752 -> 196
    //   951: aload_1
    //   952: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   955: invokestatic 886	com/tencent/mobileqq/app/message/MsgProxyUtils:i	(I)Z
    //   958: ifeq -762 -> 196
    //   961: aload_1
    //   962: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   965: ifnull -769 -> 196
    //   968: new 888	localpb/uniteGrayTip/UniteGrayTip$UniteGrayTipMsg
    //   971: dup
    //   972: invokespecial 889	localpb/uniteGrayTip/UniteGrayTip$UniteGrayTipMsg:<init>	()V
    //   975: astore_2
    //   976: aload_2
    //   977: aload_1
    //   978: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   981: invokevirtual 890	localpb/uniteGrayTip/UniteGrayTip$UniteGrayTipMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   984: pop
    //   985: aload_1
    //   986: aload_2
    //   987: getfield 893	localpb/uniteGrayTip/UniteGrayTip$UniteGrayTipMsg:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   990: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   993: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   996: goto -800 -> 196
    //   999: astore_2
    //   1000: aload_2
    //   1001: invokevirtual 669	java/lang/Exception:printStackTrace	()V
    //   1004: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1007: ifeq -811 -> 196
    //   1010: getstatic 897	com/tencent/mobileqq/graytip/UniteGrayTipUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1013: iconst_2
    //   1014: new 312	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   1021: ldc_w 899
    //   1024: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: aload_2
    //   1028: invokevirtual 871	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1031: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 873	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: goto -844 -> 196
    //   1043: astore_1
    //   1044: aload_1
    //   1045: athrow
    //   1046: aload_1
    //   1047: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1050: sipush 63529
    //   1053: if_icmpne +21 -> 1074
    //   1056: aload_1
    //   1057: aload_0
    //   1058: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1061: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1064: ldc_w 900
    //   1067: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1070: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1073: return
    //   1074: aload_1
    //   1075: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1078: sipush 64501
    //   1081: if_icmpne +141 -> 1222
    //   1084: new 903	com/tencent/mobileqq/data/MessageForMixedMsg
    //   1087: dup
    //   1088: invokespecial 904	com/tencent/mobileqq/data/MessageForMixedMsg:<init>	()V
    //   1091: astore_2
    //   1092: aload_2
    //   1093: aload_1
    //   1094: getfield 446	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1097: putfield 905	com/tencent/mobileqq/data/MessageForMixedMsg:frienduin	Ljava/lang/String;
    //   1100: aload_2
    //   1101: aload_1
    //   1102: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1105: putfield 906	com/tencent/mobileqq/data/MessageForMixedMsg:msgData	[B
    //   1108: aload_2
    //   1109: aload_1
    //   1110: getfield 909	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extStr	Ljava/lang/String;
    //   1113: putfield 910	com/tencent/mobileqq/data/MessageForMixedMsg:extStr	Ljava/lang/String;
    //   1116: aload_2
    //   1117: aload_2
    //   1118: getfield 913	com/tencent/mobileqq/data/MessageForMixedMsg:extLong	I
    //   1121: iconst_1
    //   1122: ior
    //   1123: putfield 913	com/tencent/mobileqq/data/MessageForMixedMsg:extLong	I
    //   1126: aload_2
    //   1127: invokevirtual 914	com/tencent/mobileqq/data/MessageForMixedMsg:parse	()V
    //   1130: aload_1
    //   1131: aload_2
    //   1132: getfield 915	com/tencent/mobileqq/data/MessageForMixedMsg:msg	Ljava/lang/String;
    //   1135: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1138: aload_1
    //   1139: aload_2
    //   1140: getfield 918	com/tencent/mobileqq/data/MessageForMixedMsg:msg2	Ljava/lang/String;
    //   1143: putfield 919	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg2	Ljava/lang/String;
    //   1146: aload_1
    //   1147: getfield 919	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg2	Ljava/lang/String;
    //   1150: ifnull +34 -> 1184
    //   1153: ldc 68
    //   1155: aload_1
    //   1156: getfield 919	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg2	Ljava/lang/String;
    //   1159: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1162: ifne +22 -> 1184
    //   1165: aload_1
    //   1166: new 921	com/tencent/mobileqq/text/QQText
    //   1169: dup
    //   1170: aload_1
    //   1171: getfield 919	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg2	Ljava/lang/String;
    //   1174: iconst_3
    //   1175: bipush 16
    //   1177: invokespecial 924	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   1180: putfield 928	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   1183: return
    //   1184: aload_1
    //   1185: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1188: ifnull -815 -> 373
    //   1191: ldc 68
    //   1193: aload_1
    //   1194: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1197: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1200: ifne -827 -> 373
    //   1203: aload_1
    //   1204: new 921	com/tencent/mobileqq/text/QQText
    //   1207: dup
    //   1208: aload_1
    //   1209: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1212: iconst_3
    //   1213: bipush 16
    //   1215: invokespecial 924	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   1218: putfield 928	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   1221: return
    //   1222: aload_1
    //   1223: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1226: sipush 60536
    //   1229: if_icmpeq +13 -> 1242
    //   1232: aload_1
    //   1233: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1236: sipush 60535
    //   1239: if_icmpne +69 -> 1308
    //   1242: new 930	com/tencent/mobileqq/data/MessageForNewGrayTips
    //   1245: dup
    //   1246: invokespecial 931	com/tencent/mobileqq/data/MessageForNewGrayTips:<init>	()V
    //   1249: astore_2
    //   1250: aload_2
    //   1251: aload_1
    //   1252: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1255: putfield 932	com/tencent/mobileqq/data/MessageForNewGrayTips:msgData	[B
    //   1258: aload_2
    //   1259: invokevirtual 933	com/tencent/mobileqq/data/MessageForNewGrayTips:parse	()V
    //   1262: aload_1
    //   1263: aload_2
    //   1264: getfield 934	com/tencent/mobileqq/data/MessageForNewGrayTips:msg	Ljava/lang/String;
    //   1267: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1270: aload_1
    //   1271: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1274: ifnull -901 -> 373
    //   1277: ldc 68
    //   1279: aload_1
    //   1280: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1283: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1286: ifne -913 -> 373
    //   1289: aload_1
    //   1290: new 921	com/tencent/mobileqq/text/QQText
    //   1293: dup
    //   1294: aload_1
    //   1295: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1298: iconst_3
    //   1299: bipush 16
    //   1301: invokespecial 924	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   1304: putfield 928	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   1307: return
    //   1308: aload_1
    //   1309: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1312: sipush 61036
    //   1315: if_icmpeq +43 -> 1358
    //   1318: aload_1
    //   1319: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1322: sipush 61034
    //   1325: if_icmpeq +33 -> 1358
    //   1328: aload_1
    //   1329: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1332: sipush 61033
    //   1335: if_icmpeq +23 -> 1358
    //   1338: aload_1
    //   1339: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1342: sipush 61035
    //   1345: if_icmpeq +13 -> 1358
    //   1348: aload_1
    //   1349: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1352: sipush 61027
    //   1355: if_icmpne +229 -> 1584
    //   1358: aload_1
    //   1359: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1362: ifnull -989 -> 373
    //   1365: aconst_null
    //   1366: astore_2
    //   1367: aload_1
    //   1368: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1371: lookupswitch	default:+57->1428, -5001:+158->1529, -4509:+147->1518, -4503:+136->1507, -4502:+114->1485, -4501:+125->1496, -4500:+103->1474
    //   1428: aload_2
    //   1429: ifnull -1056 -> 373
    //   1432: aload_2
    //   1433: aload_1
    //   1434: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1437: putfield 935	com/tencent/mobileqq/data/ChatMessage:msgData	[B
    //   1440: aload_2
    //   1441: invokevirtual 605	com/tencent/mobileqq/data/ChatMessage:parse	()V
    //   1444: aload_1
    //   1445: aload_2
    //   1446: getfield 936	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   1449: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1452: aload_1
    //   1453: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1456: sipush 61035
    //   1459: if_icmpne +81 -> 1540
    //   1462: aload_1
    //   1463: aload_2
    //   1464: checkcast 938	com/tencent/device/msg/data/MessageForDevPtt
    //   1467: invokevirtual 941	com/tencent/device/msg/data/MessageForDevPtt:getSummary	()Ljava/lang/String;
    //   1470: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1473: return
    //   1474: new 943	com/tencent/mobileqq/data/MessageForDeviceFile
    //   1477: dup
    //   1478: invokespecial 944	com/tencent/mobileqq/data/MessageForDeviceFile:<init>	()V
    //   1481: astore_2
    //   1482: goto -54 -> 1428
    //   1485: new 946	com/tencent/mobileqq/data/MessageForDeviceSingleStruct
    //   1488: dup
    //   1489: invokespecial 947	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:<init>	()V
    //   1492: astore_2
    //   1493: goto -65 -> 1428
    //   1496: new 938	com/tencent/device/msg/data/MessageForDevPtt
    //   1499: dup
    //   1500: invokespecial 948	com/tencent/device/msg/data/MessageForDevPtt:<init>	()V
    //   1503: astore_2
    //   1504: goto -76 -> 1428
    //   1507: new 950	com/tencent/device/msg/data/MessageForDevShortVideo
    //   1510: dup
    //   1511: invokespecial 951	com/tencent/device/msg/data/MessageForDevShortVideo:<init>	()V
    //   1514: astore_2
    //   1515: goto -87 -> 1428
    //   1518: new 953	com/tencent/device/msg/data/MessageForDevLittleVideo
    //   1521: dup
    //   1522: invokespecial 954	com/tencent/device/msg/data/MessageForDevLittleVideo:<init>	()V
    //   1525: astore_2
    //   1526: goto -98 -> 1428
    //   1529: new 930	com/tencent/mobileqq/data/MessageForNewGrayTips
    //   1532: dup
    //   1533: invokespecial 931	com/tencent/mobileqq/data/MessageForNewGrayTips:<init>	()V
    //   1536: astore_2
    //   1537: goto -109 -> 1428
    //   1540: aload_1
    //   1541: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1544: sipush 61033
    //   1547: if_icmpne +15 -> 1562
    //   1550: aload_1
    //   1551: aload_2
    //   1552: checkcast 950	com/tencent/device/msg/data/MessageForDevShortVideo
    //   1555: invokevirtual 955	com/tencent/device/msg/data/MessageForDevShortVideo:getSummary	()Ljava/lang/String;
    //   1558: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1561: return
    //   1562: aload_1
    //   1563: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1566: sipush 61027
    //   1569: if_icmpne -1196 -> 373
    //   1572: aload_1
    //   1573: aload_2
    //   1574: checkcast 953	com/tencent/device/msg/data/MessageForDevLittleVideo
    //   1577: invokevirtual 956	com/tencent/device/msg/data/MessageForDevLittleVideo:getSummary	()Ljava/lang/String;
    //   1580: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1583: return
    //   1584: aload_1
    //   1585: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1588: sipush 63525
    //   1591: if_icmpne +47 -> 1638
    //   1594: aload_1
    //   1595: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1598: invokestatic 819	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1601: astore_2
    //   1602: aload_1
    //   1603: getfield 370	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1606: iconst_1
    //   1607: if_icmpne -1234 -> 373
    //   1610: aload_2
    //   1611: ifnull -1238 -> 373
    //   1614: aload_2
    //   1615: getfield 959	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1618: bipush 43
    //   1620: if_icmpne -1247 -> 373
    //   1623: aload_1
    //   1624: aload_0
    //   1625: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1628: invokestatic 964	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1631: invokestatic 969	com/tencent/biz/pubaccount/util/PublicAccountConfigUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   1634: putfield 972	com/tencent/mobileqq/app/message/QQMessageFacade$Message:nickName	Ljava/lang/String;
    //   1637: return
    //   1638: aload_1
    //   1639: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1642: sipush 62530
    //   1645: if_icmpeq +13 -> 1658
    //   1648: aload_1
    //   1649: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1652: sipush 60532
    //   1655: if_icmpne +67 -> 1722
    //   1658: aload_1
    //   1659: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1662: sipush 62530
    //   1665: if_icmpne +39 -> 1704
    //   1668: aload_1
    //   1669: aload_0
    //   1670: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1673: aload_1
    //   1674: iconst_0
    //   1675: invokestatic 978	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   1678: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1681: aload_1
    //   1682: getfield 370	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1685: iconst_1
    //   1686: if_icmpne -1313 -> 373
    //   1689: aload_1
    //   1690: aload_0
    //   1691: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1694: invokestatic 964	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1697: invokestatic 969	com/tencent/biz/pubaccount/util/PublicAccountConfigUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   1700: putfield 972	com/tencent/mobileqq/app/message/QQMessageFacade$Message:nickName	Ljava/lang/String;
    //   1703: return
    //   1704: aload_1
    //   1705: aload_0
    //   1706: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1709: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1712: ldc_w 979
    //   1715: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1718: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1721: return
    //   1722: aload_1
    //   1723: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1726: sipush 63526
    //   1729: if_icmpne +111 -> 1840
    //   1732: new 981	com/tencent/mobileqq/data/FunnyFaceMessage
    //   1735: dup
    //   1736: invokespecial 982	com/tencent/mobileqq/data/FunnyFaceMessage:<init>	()V
    //   1739: astore_2
    //   1740: aload_2
    //   1741: new 984	java/io/ObjectInputStream
    //   1744: dup
    //   1745: new 986	java/io/ByteArrayInputStream
    //   1748: dup
    //   1749: aload_1
    //   1750: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1753: invokespecial 987	java/io/ByteArrayInputStream:<init>	([B)V
    //   1756: invokespecial 990	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   1759: invokevirtual 994	com/tencent/mobileqq/data/FunnyFaceMessage:readExternal	(Ljava/io/ObjectInput;)V
    //   1762: aload_2
    //   1763: ifnull -1390 -> 373
    //   1766: aload_2
    //   1767: getfield 997	com/tencent/mobileqq/data/FunnyFaceMessage:faceId	I
    //   1770: iconst_1
    //   1771: if_icmpne +43 -> 1814
    //   1774: aload_1
    //   1775: aload_0
    //   1776: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1779: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1782: ldc_w 998
    //   1785: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1788: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1791: return
    //   1792: astore_2
    //   1793: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1796: ifeq +13 -> 1809
    //   1799: ldc 13
    //   1801: iconst_2
    //   1802: aload_2
    //   1803: invokevirtual 999	java/lang/Exception:toString	()Ljava/lang/String;
    //   1806: invokestatic 873	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1809: aconst_null
    //   1810: astore_2
    //   1811: goto -49 -> 1762
    //   1814: aload_2
    //   1815: getfield 997	com/tencent/mobileqq/data/FunnyFaceMessage:faceId	I
    //   1818: iconst_2
    //   1819: if_icmpne -1446 -> 373
    //   1822: aload_1
    //   1823: aload_0
    //   1824: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1827: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1830: ldc_w 1000
    //   1833: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1836: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1839: return
    //   1840: aload_1
    //   1841: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1844: sipush 63536
    //   1847: if_icmpne +21 -> 1868
    //   1850: aload_1
    //   1851: aload_0
    //   1852: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1855: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1858: ldc_w 1001
    //   1861: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1864: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1867: return
    //   1868: aload_1
    //   1869: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1872: sipush 63531
    //   1875: if_icmpne +21 -> 1896
    //   1878: aload_1
    //   1879: aload_0
    //   1880: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1883: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1886: ldc_w 1002
    //   1889: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1892: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1895: return
    //   1896: aload_1
    //   1897: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1900: sipush 63516
    //   1903: if_icmpne +90 -> 1993
    //   1906: aload_1
    //   1907: aload_0
    //   1908: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1911: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1914: ldc_w 1003
    //   1917: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1920: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1923: aload_1
    //   1924: getfield 1006	com/tencent/mobileqq/app/message/QQMessageFacade$Message:issend	I
    //   1927: invokestatic 1009	com/tencent/mobileqq/utils/MsgUtils:a	(I)Z
    //   1930: ifeq +45 -> 1975
    //   1933: aload_0
    //   1934: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1937: aload_1
    //   1938: getfield 446	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1941: ldc 68
    //   1943: iconst_0
    //   1944: iconst_0
    //   1945: invokestatic 1014	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   1948: astore_2
    //   1949: aload_1
    //   1950: aload_0
    //   1951: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1954: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1957: ldc_w 1015
    //   1960: iconst_1
    //   1961: anewarray 35	java/lang/Object
    //   1964: dup
    //   1965: iconst_0
    //   1966: aload_2
    //   1967: aastore
    //   1968: invokevirtual 1018	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1971: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1974: return
    //   1975: aload_1
    //   1976: aload_0
    //   1977: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1980: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1983: ldc_w 1003
    //   1986: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1989: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1992: return
    //   1993: aload_1
    //   1994: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1997: sipush 63534
    //   2000: if_icmpeq +13 -> 2013
    //   2003: aload_1
    //   2004: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2007: sipush 64505
    //   2010: if_icmpne +56 -> 2066
    //   2013: aload_1
    //   2014: aload_0
    //   2015: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2018: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2021: ldc_w 1019
    //   2024: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2027: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2030: aload_1
    //   2031: aload_0
    //   2032: getfield 44	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade	Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   2035: aload_1
    //   2036: getfield 446	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2039: aload_1
    //   2040: getfield 370	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2043: aload_1
    //   2044: getfield 445	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2047: invokevirtual 1022	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2050: checkcast 1024	com/tencent/mobileqq/data/MessageForPtt
    //   2053: getfield 1027	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   2056: putfield 1030	com/tencent/mobileqq/app/message/QQMessageFacade$Message:pttUrl	Ljava/lang/String;
    //   2059: return
    //   2060: astore_1
    //   2061: aload_1
    //   2062: invokevirtual 669	java/lang/Exception:printStackTrace	()V
    //   2065: return
    //   2066: aload_1
    //   2067: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2070: sipush 63511
    //   2073: if_icmpne +57 -> 2130
    //   2076: aload_1
    //   2077: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2080: ifnull -1707 -> 373
    //   2083: new 1032	com/tencent/mobileqq/data/MessageForQQWalletMsg
    //   2086: dup
    //   2087: invokespecial 1033	com/tencent/mobileqq/data/MessageForQQWalletMsg:<init>	()V
    //   2090: astore_2
    //   2091: aload_2
    //   2092: aload_1
    //   2093: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2096: putfield 1034	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   2099: aload_2
    //   2100: invokevirtual 1035	com/tencent/mobileqq/data/MessageForQQWalletMsg:parse	()V
    //   2103: aload_1
    //   2104: aload_2
    //   2105: invokevirtual 1037	com/tencent/mobileqq/data/MessageForQQWalletMsg:getMsgSummary	()Ljava/lang/String;
    //   2108: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2111: return
    //   2112: astore_1
    //   2113: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2116: ifeq -1743 -> 373
    //   2119: ldc 13
    //   2121: iconst_2
    //   2122: aload_1
    //   2123: invokevirtual 999	java/lang/Exception:toString	()Ljava/lang/String;
    //   2126: invokestatic 873	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2129: return
    //   2130: aload_1
    //   2131: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2134: sipush 63497
    //   2137: if_icmpne +93 -> 2230
    //   2140: aload_1
    //   2141: ldc_w 1039
    //   2144: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2147: aload_1
    //   2148: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2151: ifnull -1778 -> 373
    //   2154: new 1041	com/tencent/mobileqq/data/MessageForApollo
    //   2157: dup
    //   2158: invokespecial 1042	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2161: astore_2
    //   2162: aload_2
    //   2163: aload_1
    //   2164: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2167: putfield 1043	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2170: aload_2
    //   2171: invokevirtual 1044	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2174: aload_2
    //   2175: getfield 1048	com/tencent/mobileqq/data/MessageForApollo:mApolloMessage	Lcom/tencent/mobileqq/data/ApolloMessage;
    //   2178: ifnull -1805 -> 373
    //   2181: aload_2
    //   2182: getfield 1048	com/tencent/mobileqq/data/MessageForApollo:mApolloMessage	Lcom/tencent/mobileqq/data/ApolloMessage;
    //   2185: getfield 1053	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   2188: ifnull -1815 -> 373
    //   2191: aload_1
    //   2192: new 312	java/lang/StringBuilder
    //   2195: dup
    //   2196: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   2199: aload_1
    //   2200: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2203: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: new 94	java/lang/String
    //   2209: dup
    //   2210: aload_2
    //   2211: getfield 1048	com/tencent/mobileqq/data/MessageForApollo:mApolloMessage	Lcom/tencent/mobileqq/data/ApolloMessage;
    //   2214: getfield 1053	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   2217: invokespecial 878	java/lang/String:<init>	([B)V
    //   2220: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2226: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2229: return
    //   2230: aload_1
    //   2231: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2234: sipush 60528
    //   2237: if_icmpne +36 -> 2273
    //   2240: aload_1
    //   2241: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2244: ifnull -1871 -> 373
    //   2247: new 1055	com/tencent/mobileqq/data/ArkAppMessage
    //   2250: dup
    //   2251: invokespecial 1056	com/tencent/mobileqq/data/ArkAppMessage:<init>	()V
    //   2254: astore_2
    //   2255: aload_2
    //   2256: aload_1
    //   2257: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2260: invokevirtual 1060	com/tencent/mobileqq/data/ArkAppMessage:fromBytes	([B)Z
    //   2263: pop
    //   2264: aload_1
    //   2265: aload_2
    //   2266: invokevirtual 1063	com/tencent/mobileqq/data/ArkAppMessage:getSummery	()Ljava/lang/String;
    //   2269: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2272: return
    //   2273: aload_1
    //   2274: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2277: sipush 63488
    //   2280: if_icmpne +32 -> 2312
    //   2283: new 1065	com/tencent/mobileqq/data/MessageForTroopReward
    //   2286: dup
    //   2287: invokespecial 1066	com/tencent/mobileqq/data/MessageForTroopReward:<init>	()V
    //   2290: astore_2
    //   2291: aload_2
    //   2292: aload_1
    //   2293: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2296: putfield 1067	com/tencent/mobileqq/data/MessageForTroopReward:msgData	[B
    //   2299: aload_2
    //   2300: invokevirtual 1068	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   2303: aload_1
    //   2304: aload_2
    //   2305: invokevirtual 1071	com/tencent/mobileqq/data/MessageForTroopReward:getSummaryMsg	()Ljava/lang/String;
    //   2308: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2311: return
    //   2312: aload_1
    //   2313: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2316: sipush 63485
    //   2319: if_icmpne +32 -> 2351
    //   2322: new 1073	com/tencent/mobileqq/data/MessageForQQStory
    //   2325: dup
    //   2326: invokespecial 1074	com/tencent/mobileqq/data/MessageForQQStory:<init>	()V
    //   2329: astore_2
    //   2330: aload_2
    //   2331: aload_1
    //   2332: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2335: putfield 1075	com/tencent/mobileqq/data/MessageForQQStory:msgData	[B
    //   2338: aload_2
    //   2339: invokevirtual 1076	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   2342: aload_1
    //   2343: aload_2
    //   2344: invokevirtual 1077	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   2347: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2350: return
    //   2351: aload_1
    //   2352: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2355: ifnull -1982 -> 373
    //   2358: ldc 68
    //   2360: aload_1
    //   2361: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2364: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2367: ifne -1994 -> 373
    //   2370: aload_1
    //   2371: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2374: astore_2
    //   2375: aload_0
    //   2376: aload_2
    //   2377: invokespecial 1079	com/tencent/mobileqq/app/message/BaseMessageManager:a	(Ljava/lang/String;)Z
    //   2380: ifeq +249 -> 2629
    //   2383: aload_2
    //   2384: ldc -17
    //   2386: invokevirtual 243	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   2389: iconst_1
    //   2390: aaload
    //   2391: ldc -11
    //   2393: invokevirtual 243	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   2396: astore_2
    //   2397: aload_2
    //   2398: ifnull -2025 -> 373
    //   2401: aload_2
    //   2402: arraylength
    //   2403: iconst_2
    //   2404: if_icmpge +99 -> 2503
    //   2407: iconst_1
    //   2408: istore 5
    //   2410: aload_1
    //   2411: iload 5
    //   2413: putfield 1082	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   2416: aload_2
    //   2417: arraylength
    //   2418: iconst_2
    //   2419: if_icmpge +98 -> 2517
    //   2422: ldc2_w 505
    //   2425: lstore 6
    //   2427: aload_1
    //   2428: lload 6
    //   2430: putfield 1085	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileSize	J
    //   2433: iload 5
    //   2435: lookupswitch	default:+49->2484, 0:+50->2485, 1:+123->2558, 2:+169->2604, 3:+-2062->373, 65538:+123->2558
    //   2484: return
    //   2485: aload_1
    //   2486: aload_0
    //   2487: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2490: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2493: ldc_w 1002
    //   2496: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2499: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2502: return
    //   2503: aload_2
    //   2504: iconst_2
    //   2505: aaload
    //   2506: invokestatic 256	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2509: invokevirtual 1088	java/lang/Integer:intValue	()I
    //   2512: istore 5
    //   2514: goto -104 -> 2410
    //   2517: aload_2
    //   2518: iconst_1
    //   2519: aaload
    //   2520: invokestatic 251	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2523: invokevirtual 1091	java/lang/Long:longValue	()J
    //   2526: lstore 6
    //   2528: goto -101 -> 2427
    //   2531: astore_3
    //   2532: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2535: ifeq +13 -> 2548
    //   2538: ldc 13
    //   2540: iconst_2
    //   2541: ldc_w 1093
    //   2544: aload_3
    //   2545: invokestatic 1096	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2548: aload_1
    //   2549: ldc2_w 505
    //   2552: putfield 1085	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileSize	J
    //   2555: goto -122 -> 2433
    //   2558: aload_1
    //   2559: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2562: sipush 62535
    //   2565: if_icmpne +21 -> 2586
    //   2568: aload_1
    //   2569: aload_0
    //   2570: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2573: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2576: ldc_w 1097
    //   2579: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2582: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2585: return
    //   2586: aload_1
    //   2587: aload_0
    //   2588: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2591: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2594: ldc_w 1001
    //   2597: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2600: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2603: return
    //   2604: aload_1
    //   2605: aload_0
    //   2606: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2609: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2612: ldc_w 1019
    //   2615: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2618: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2621: aload_1
    //   2622: aload_2
    //   2623: iconst_0
    //   2624: aaload
    //   2625: putfield 1030	com/tencent/mobileqq/app/message/QQMessageFacade$Message:pttUrl	Ljava/lang/String;
    //   2628: return
    //   2629: aload_1
    //   2630: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2633: sipush 63530
    //   2636: if_icmpne +55 -> 2691
    //   2639: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2642: ifeq +12 -> 2654
    //   2645: ldc 13
    //   2647: iconst_2
    //   2648: ldc_w 1099
    //   2651: invokestatic 873	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2654: aload_1
    //   2655: new 312	java/lang/StringBuilder
    //   2658: dup
    //   2659: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   2662: aload_0
    //   2663: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2666: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2669: ldc_w 1019
    //   2672: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2675: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2678: ldc_w 1101
    //   2681: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2684: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2687: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2690: return
    //   2691: aload_1
    //   2692: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2695: sipush 63528
    //   2698: if_icmpne +21 -> 2719
    //   2701: aload_1
    //   2702: aload_0
    //   2703: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2706: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2709: ldc_w 1102
    //   2712: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2715: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2718: return
    //   2719: aload_1
    //   2720: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2723: ldc_w 1104
    //   2726: invokevirtual 1108	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2729: iconst_m1
    //   2730: if_icmpeq +90 -> 2820
    //   2733: aload_1
    //   2734: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2737: invokestatic 1110	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   2740: astore 4
    //   2742: ldc 68
    //   2744: astore_3
    //   2745: aload_3
    //   2746: astore_2
    //   2747: aload 4
    //   2749: ifnull +17 -> 2766
    //   2752: aload_3
    //   2753: astore_2
    //   2754: aload 4
    //   2756: iconst_2
    //   2757: aaload
    //   2758: ifnull +8 -> 2766
    //   2761: aload 4
    //   2763: iconst_2
    //   2764: aaload
    //   2765: astore_2
    //   2766: aload_1
    //   2767: ldc_w 1111
    //   2770: putfield 1082	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   2773: aload_1
    //   2774: new 312	java/lang/StringBuilder
    //   2777: dup
    //   2778: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   2781: ldc_w 1113
    //   2784: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2787: aload_0
    //   2788: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2791: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2794: ldc_w 1114
    //   2797: invokevirtual 901	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   2800: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: ldc_w 1116
    //   2806: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2809: aload_2
    //   2810: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2816: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2819: return
    //   2820: aload_1
    //   2821: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2824: sipush 63507
    //   2827: if_icmpne +86 -> 2913
    //   2830: new 1118	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   2833: dup
    //   2834: invokespecial 1119	com/tencent/mobileqq/data/MessageForQQWalletTips:<init>	()V
    //   2837: astore_2
    //   2838: aload_2
    //   2839: aload_1
    //   2840: getfield 1120	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   2843: aload_1
    //   2844: getfield 446	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2847: aload_1
    //   2848: getfield 361	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2851: ldc_w 1122
    //   2854: invokestatic 1126	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   2857: aload_1
    //   2858: getfield 701	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2861: aload_1
    //   2862: getfield 370	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2865: invokestatic 1126	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   2868: invokevirtual 1127	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   2871: aload_2
    //   2872: aload_1
    //   2873: getfield 454	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2876: putfield 1128	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   2879: aload_2
    //   2880: iconst_1
    //   2881: putfield 1129	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   2884: aload_2
    //   2885: invokevirtual 1130	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   2888: aload_2
    //   2889: aload_0
    //   2890: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2893: aload_0
    //   2894: getfield 42	com/tencent/mobileqq/app/message/BaseMessageManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2897: invokevirtual 774	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2900: aconst_null
    //   2901: invokevirtual 1134	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   2904: aload_1
    //   2905: aload_2
    //   2906: getfield 1137	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   2909: putfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2912: return
    //   2913: new 312	java/lang/StringBuilder
    //   2916: dup
    //   2917: aload_1
    //   2918: getfield 466	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2921: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2924: astore_2
    //   2925: aload_1
    //   2926: ldc_w 1139
    //   2929: invokevirtual 844	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   2932: astore 4
    //   2934: aload_2
    //   2935: astore_3
    //   2936: aload_1
    //   2937: getfield 370	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2940: sipush 3000
    //   2943: if_icmpne +48 -> 2991
    //   2946: aload_2
    //   2947: astore_3
    //   2948: aload 4
    //   2950: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2953: ifne +38 -> 2991
    //   2956: getstatic 1142	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   2959: invokevirtual 1145	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   2962: astore_3
    //   2963: ldc 53
    //   2965: aload_3
    //   2966: invokevirtual 1150	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   2969: ifeq +38 -> 3007
    //   2972: aload_3
    //   2973: checkcast 53	com/tencent/mobileqq/app/QQAppInterface
    //   2976: aload_2
    //   2977: aload 4
    //   2979: aload_1
    //   2980: getfield 446	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2983: invokestatic 1155	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2986: astore_3
    //   2987: aload_3
    //   2988: astore_2
    //   2989: aload_2
    //   2990: astore_3
    //   2991: aload_1
    //   2992: new 921	com/tencent/mobileqq/text/QQText
    //   2995: dup
    //   2996: aload_3
    //   2997: iconst_3
    //   2998: bipush 16
    //   3000: invokespecial 924	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   3003: putfield 928	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   3006: return
    //   3007: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3010: ifeq +12 -> 3022
    //   3013: ldc 13
    //   3015: iconst_1
    //   3016: ldc_w 1157
    //   3019: invokestatic 873	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3022: goto -33 -> 2989
    //   3025: astore_3
    //   3026: ldc 13
    //   3028: iconst_1
    //   3029: ldc_w 1159
    //   3032: aload_3
    //   3033: invokestatic 1161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3036: aload_2
    //   3037: astore_3
    //   3038: goto -47 -> 2991
    //   3041: goto -2889 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3044	0	this	BaseMessageManager
    //   0	3044	1	paramMessage	QQMessageFacade.Message
    //   162	674	2	localObject1	Object
    //   851	29	2	localException1	Exception
    //   943	2	2	localJSONException	org.json.JSONException
    //   975	12	2	localUniteGrayTipMsg	localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg
    //   999	29	2	localException2	Exception
    //   1091	676	2	localObject2	Object
    //   1792	11	2	localException3	Exception
    //   1810	1227	2	localObject3	Object
    //   81	646	3	localObject4	Object
    //   2531	14	3	localException4	Exception
    //   2744	253	3	localObject5	Object
    //   3025	8	3	localException5	Exception
    //   3037	1	3	localObject6	Object
    //   2740	238	4	localObject7	Object
    //   470	2043	5	i	int
    //   2425	102	6	l	long
    // Exception table:
    //   from	to	target	type
    //   40	54	374	java/lang/Exception
    //   74	152	660	java/lang/Exception
    //   152	163	660	java/lang/Exception
    //   163	191	660	java/lang/Exception
    //   191	196	660	java/lang/Exception
    //   377	394	660	java/lang/Exception
    //   397	414	660	java/lang/Exception
    //   417	434	660	java/lang/Exception
    //   437	454	660	java/lang/Exception
    //   460	581	660	java/lang/Exception
    //   581	588	660	java/lang/Exception
    //   594	605	660	java/lang/Exception
    //   605	637	660	java/lang/Exception
    //   646	657	660	java/lang/Exception
    //   825	848	851	java/lang/Exception
    //   912	940	943	org/json/JSONException
    //   976	996	999	java/lang/Exception
    //   236	276	1043	java/lang/Exception
    //   1740	1762	1792	java/lang/Exception
    //   2030	2059	2060	java/lang/Exception
    //   2083	2111	2112	java/lang/Exception
    //   2416	2422	2531	java/lang/Exception
    //   2427	2433	2531	java/lang/Exception
    //   2517	2528	2531	java/lang/Exception
    //   2956	2987	3025	java/lang/Exception
    //   3007	3022	3025	java/lang/Exception
  }
  
  public void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramRefreshMessageContext.h)
      {
        paramRefreshMessageContext.h = false;
        this.jdField_a_of_type_JavaLangObject.notify();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
        }
      }
      return;
    }
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    int j;
    if ((paramRefreshMessageContext.jdField_a_of_type_JavaUtilList != null) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      j = 1;
      MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaUtilList);
      i = j;
      if (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0) {
        MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaLangString, paramRefreshMessageContext.jdField_c_of_type_Int, paramRefreshMessageContext.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (int i = j;; i = 0)
    {
      String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
      j = paramRefreshMessageContext.jdField_d_of_type_Int;
      if ((paramRefreshMessageContext.jdField_d_of_type_Boolean) && (i != 0) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramRefreshMessageContext.jdField_a_of_type_Int < 9))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + paramRefreshMessageContext.jdField_a_of_type_Int + " ]");
        }
        paramRefreshMessageContext.jdField_a_of_type_Int += 1;
        b(str, paramInt, j, paramRefreshMessageContext);
      }
      do
      {
        return;
        paramRefreshMessageContext.jdField_a_of_type_Int = 0;
        paramRefreshMessageContext.b = 0;
      } while (!paramRefreshMessageContext.f);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject1 != null)
    {
      a((MessageRecord)localObject1, true, 4);
      b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, (MessageRecord)localObject1, 4);
    }
    for (;;)
    {
      return;
      Object localObject2 = null;
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1001) {
        if (MsgProxyUtils.c(paramMessageRecord))
        {
          a(AppConstants.aO, 1001, paramMessageRecord.frienduin, (String)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aO, 1001);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((QQMessageFacade.Message)localObject3).senderuin != null)
            {
              localObject1 = localObject2;
              if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
              {
                ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      while ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).senderuin != null) && (((QQMessageFacade.Message)localObject1).senderuin.equals(paramMessageRecord.frienduin)))
      {
        ((QQMessageFacade.Message)localObject1).cleanMessageRecordBaseField();
        return;
        a(AppConstants.ar, 1001, paramMessageRecord.frienduin, (String)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ar, 1001);
        continue;
        if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1009)
        {
          a(AppConstants.ag, 1009, paramMessageRecord.frienduin, (String)localObject3);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ag, 1009);
        }
        else
        {
          localObject1 = localObject2;
          if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1010) {
            if (MsgProxyUtils.c(paramMessageRecord))
            {
              a(AppConstants.aP, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aP, 1010);
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((QQMessageFacade.Message)localObject3).senderuin != null)
                {
                  localObject1 = localObject2;
                  if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
                  {
                    ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                    localObject1 = localObject2;
                  }
                }
              }
            }
            else
            {
              a(AppConstants.aH, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aH, 1010);
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, EcShopAssistantManager paramEcShopAssistantManager)
  {
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    paramMessageRecord = MsgProxyUtils.a(str, i);
    int j = 0;
    Object localObject;
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.containsKey(paramMessageRecord))
    {
      localObject = paramEcShopAssistantManager.a();
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(str, i);
      if (localMessageRecord == null) {
        break label161;
      }
      a(localMessageRecord, true, 4);
      i = j;
      paramMessageRecord = localMessageRecord;
    }
    for (;;)
    {
      if (((localObject != null) && (str.equals(((EcShopData)localObject).mUin))) || (i != 0))
      {
        paramEcShopAssistantManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(9970L), 7120);
        if (paramEcShopAssistantManager != null)
        {
          if (paramMessageRecord != null)
          {
            paramEcShopAssistantManager.lastmsgtime = paramMessageRecord.time;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramEcShopAssistantManager);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramEcShopAssistantManager);
        }
      }
      return;
      label161:
      paramEcShopAssistantManager.a(str);
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramMessageRecord = localMessageRecord;
      i = j;
      if (localQQMessageFacade != null)
      {
        paramEcShopAssistantManager = paramEcShopAssistantManager.a();
        paramMessageRecord = localMessageRecord;
        localObject = paramEcShopAssistantManager;
        i = j;
        if (paramEcShopAssistantManager != null)
        {
          paramMessageRecord = localQQMessageFacade.a(paramEcShopAssistantManager.mUin, 1008);
          i = 1;
          localObject = paramEcShopAssistantManager;
        }
      }
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, true);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramEntityManager = paramAddMessageContext.c;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    paramAddMessageContext = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + paramMessageRecord.getBaseInfoString());
      }
      paramMessageRecord.extraflag = 32772;
      paramMessageRecord.sendFailCode = 0;
    }
    Object localObject;
    if ((paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      localObject = (MessageForUniteGrayTip)paramMessageRecord;
      if (((MessageForUniteGrayTip)localObject).callback != null) {
        ((MessageForUniteGrayTip)localObject).callback.a((MessageForUniteGrayTip)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, null, paramBoolean1, paramBoolean2, paramBoolean4);
    if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) {
      if (a(paramMessageRecord, false, 1))
      {
        if ((paramEntityManager.containsKey(MsgProxyUtils.a(paramAddMessageContext, i))) && (!paramMessageRecord.isSendFromLocal())) {
          break label424;
        }
        paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
      }
    }
    for (;;)
    {
      try
      {
        if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == 64485) || ((paramMessageRecord.isLongMsg()) && (paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1))))
        {
          paramEntityManager = (LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() != 1) {
            continue;
          }
          paramEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
        }
      }
      catch (Exception paramEntityManager)
      {
        label424:
        QLog.d("Q.msg.BaseMessageManager", 1, "longmsg receive report error!", paramEntityManager);
        continue;
        ThreadManager.b().postDelayed(new qkr(this, paramEntityManager, paramMessageRecord), 10000L);
      }
      try
      {
        if ((paramMessageRecord.isSendFromLocal()) || ((paramMessageRecord.msgtype != 64500) && (paramMessageRecord.msgtype != 64501))) {
          break;
        }
        paramEntityManager = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() != 1) {
          continue;
        }
        paramEntityManager.a(paramMessageRecord);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        QLog.d("Q.msg.BaseMessageManager", 1, "mixexmsg receive report error!", paramMessageRecord);
        return;
      }
      localObject = (MessageRecord)paramEntityManager.get(MsgProxyUtils.a(paramAddMessageContext, i));
      if (a(paramMessageRecord) >= a((MessageRecord)localObject))
      {
        paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
        continue;
        a(paramMessageRecord, true, 1);
        continue;
        ThreadManager.b().postDelayed(new qkq(this, paramEntityManager, paramMessageRecord), 10000L);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int j = 0;
    Object localObject1 = new ArrayList();
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      ((List)localObject1).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      if (!MsgProxyUtils.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label450;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + paramMessageRecord);
      }
      Object localObject2 = MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.containsKey(localObject2))
      {
        localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(localObject2);
        if ((!paramMessageRecord.isread) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop, (MessageRecord)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      int k = ((List)localObject1).size();
      for (;;)
      {
        if (j < k)
        {
          localObject2 = (MessageRecord)((List)localObject1).get(j);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject2).istroop).a((MessageRecord)localObject2, paramBoolean2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject2);
          j += 1;
          continue;
          ((List)localObject1).add(paramMessageRecord);
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord)) {
            break;
          }
          i = 0;
          break;
        }
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord);
      }
      if (i != 0)
      {
        localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
        if (!MsgProxyUtils.s(paramMessageRecord.istroop)) {
          break label352;
        }
        a(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).f();
        }
        return;
        label352:
        if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))
        {
          a(paramMessageRecord, (EcShopAssistantManager)localObject1);
        }
        else if ((paramMessageRecord.istroop == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
          ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((paramMessageRecord.istroop != 1008) || (!ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
        }
      }
      label450:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_c_of_type_Int = paramInt1;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt1)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead UNFINISHED ERROR uin = " + paramString + ", type = " + paramInt1);
      }
      if ((paramRefreshMessageContext.h) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.BaseMessageManager", 2, "numTroopRefresh = " + paramRefreshMessageContext.h + ", refreshActionMap[" + MsgProxyUtils.a(paramString, paramInt1) + "] = " + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.get(MsgProxyUtils.a(paramString, paramInt1)));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString, paramInt1), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new qko(this, paramString, paramInt1, paramInt2, paramRefreshMessageContext));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    int j = 1;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, false, false);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    int i = j;
    long l;
    if (paramInt != 3000)
    {
      if (paramInt == 1) {
        i = j;
      }
    }
    else
    {
      if (i == 0) {
        break label122;
      }
      l = ((MessageRecord)localList.get(0)).shmsgseq;
      label77:
      if (i == 0) {
        break label141;
      }
    }
    label122:
    label141:
    for (localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c(paramString, paramInt, paramLong, l);; localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).d(paramString, paramInt, paramLong, l))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, localList);
      return;
      i = 0;
      break;
      l = ((MessageRecord)localList.get(0)).time;
      break label77;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong + ",force=" + paramBoolean);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) <= 0) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong);
    b(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg())) {
      if ((MsgProxyUtils.a(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
      {
        a(paramMessageRecord, true, paramInt2);
        b(paramString, paramInt1, paramMessageRecord, paramInt2);
      }
    }
    while ((paramMessageRecord == null) || (localList == null) || (localList.isEmpty()) || (paramMessageRecord.uniseq != ((MessageRecord)localList.get(localList.size() - 1)).uniseq)) {
      return;
    }
    a(paramMessageRecord, true, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, paramString2, paramString3, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((paramInt == 1008) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt))) {}
    while ((paramInt == 1008) && (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
      return;
    }
    RecentUserProxy localRecentUserProxy;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt)) || (!MsgProxyUtils.s(paramInt)))
    {
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (0L == paramLong)
      {
        paramString2 = localRecentUserProxy.b(paramString1, paramInt);
        if (paramString2 == null) {
          break label200;
        }
        paramString2.lastmsgdrafttime = paramLong;
        if ((0L != paramLong) || (paramString2.lastmsgtime != 0L)) {
          break label185;
        }
        localRecentUserProxy.b(paramString2);
      }
    }
    for (;;)
    {
      if ((paramInt == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
        ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString3, paramLong);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString2);
      return;
      RecentUser localRecentUser = localRecentUserProxy.a(paramString1, paramInt);
      localRecentUser.troopUin = paramString2;
      paramString2 = localRecentUser;
      break;
      label185:
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localRecentUserProxy.a(paramString2);
      label200:
      continue;
      paramString2 = null;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    String str;
    if (MsgProxyUtils.c(paramString1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
      if (paramInt == 1010) {
        str = AppConstants.aH;
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str)) {}
      label535:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  for (;;)
                  {
                    return;
                    if (paramInt != 1001) {
                      break label581;
                    }
                    str = AppConstants.ar;
                    break;
                    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt);
                    if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString2)))
                    {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(str, paramInt, paramString1, paramString3);
                      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString1, paramInt);
                      if ((paramString2 != null) && (!paramString2.isEmpty()))
                      {
                        paramString2 = (MessageRecord)paramString2.get(paramString2.size() - 1);
                        paramString3 = MessageRecordFactory.a(paramString2.msgtype);
                        MessageRecord.copyMessageRecordBaseField(paramString3, paramString2);
                        paramString3.frienduin = str;
                        paramString3.senderuin = paramString1;
                        if (!MsgProxyUtils.g(paramString2.msgtype)) {
                          a(paramString3, null, false, true, 1);
                        }
                        MessageRecord.copyMessageRecordBaseField(localMessage, paramString2);
                        localMessage.frienduin = paramString1;
                        localMessage.emoRecentMsg = null;
                      }
                      try
                      {
                        a(localMessage);
                        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(str, paramInt);
                        if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1)))
                        {
                          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(str, paramInt);
                          if ((paramString1 != null) && (!paramString1.isEmpty()))
                          {
                            MessageRecord.copyMessageRecordBaseField(paramString2, (MessageRecord)paramString1.get(paramString1.size() - 1));
                            paramString2.frienduin = str;
                            paramString2.emoRecentMsg = null;
                            try
                            {
                              a(paramString2);
                              return;
                            }
                            catch (Throwable paramString1) {}
                            if (!QLog.isColorLevel()) {
                              continue;
                            }
                            QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
                          }
                        }
                      }
                      catch (Throwable paramString2)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox decode msgInLBSBox ERROR", paramString2);
                          }
                        }
                        paramString2.emoRecentMsg = null;
                        paramString2.msg = null;
                      }
                    }
                  }
                } while (!paramBoolean);
                paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, paramInt);
              } while (paramString1 == null);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
              return;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
              paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt);
            } while ((paramString3.senderuin == null) || (!paramString3.senderuin.equals(paramString2)));
            paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString1, paramInt);
            if ((paramString2 == null) || (paramString2.isEmpty())) {
              break label535;
            }
            MessageRecord.copyMessageRecordBaseField(paramString3, (MessageRecord)paramString2.get(paramString2.size() - 1));
            paramString3.frienduin = paramString1;
            paramString3.emoRecentMsg = null;
            try
            {
              a(paramString3);
              return;
            }
            catch (Throwable paramString1) {}
          } while (!QLog.isColorLevel());
          QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
          return;
          paramString3.emoRecentMsg = null;
          paramString3.msg = null;
        } while (!paramBoolean);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramInt);
      } while (paramString1 == null);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
      return;
      label581:
      str = "";
    }
  }
  
  public abstract void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle);
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReaded uin=" + paramString + ",type=" + paramInt + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
    return;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localMessageRecord != null) {}
    for (long l = a(localMessageRecord);; l = 0L)
    {
      localConversationFacade.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      a(paramString, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
      return;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Object localObject5 = (RevokeMsgInfo)paramArrayList.get(0);
    int i = ((RevokeMsgInfo)localObject5).jdField_a_of_type_Int;
    ??? = ((RevokeMsgInfo)localObject5).jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "doReplaceRevokedMsgAndNotify frienduin = " + (String)??? + ", istroop = " + i);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).e((String)???, i);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "doReplaceRevokedMsgAndNotify error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((String)???, i, UncommonMessageProcessor.g, UncommonMessageProcessor.m);
    }
    Object localObject3;
    do
    {
      return;
      localObject3 = a((List)localObject1, (String)???, i, paramArrayList);
      if ((localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((String)???, i, UncommonMessageProcessor.g, UncommonMessageProcessor.n);
        return;
      }
    } while ((localObject3 != null) && (((List)localObject3).size() == 1) && (UniteGrayTipUtil.a((MessageRecord)((List)localObject3).get(0))));
    Object localObject4 = "你" + BaseApplicationImpl.a().getString(2131372240);
    paramArrayList = (MessageRecord)((List)localObject3).get(0);
    Iterator localIterator = ((List)localObject3).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (MessageRecord)localIterator.next();
      if ((((MessageRecord)localObject1).shmsgseq == ((RevokeMsgInfo)localObject5).jdField_a_of_type_Long) && (((MessageRecord)localObject1).msgUid == ((RevokeMsgInfo)localObject5).jdField_b_of_type_Long)) {
        paramArrayList = (ArrayList)localObject1;
      }
    }
    for (;;)
    {
      localObject1 = new MessageForUniteGrayTip();
      localObject4 = new UniteGrayTipParam((String)???, paramArrayList.senderuin, (String)localObject4, i, 60496, 1, paramArrayList.time);
      ((UniteGrayTipParam)localObject4).e = true;
      ((UniteGrayTipParam)localObject4).f = false;
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject4);
      ((MessageForUniteGrayTip)localObject1).msgUid = paramArrayList.msgUid;
      ((MessageForUniteGrayTip)localObject1).shmsgseq = paramArrayList.shmsgseq;
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (MessageRecord)((Iterator)localObject3).next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop, ((MessageRecord)localObject5).uniseq, false);
        if (((MessageRecord)localObject5).msgtype == 63531)
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject5 = ((FileManagerDataCenter)localObject4).a(((MessageRecord)localObject5).uniseq, ((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop);
          if (localObject5 != null)
          {
            ((FileManagerDataCenter)localObject4).b((FileManagerEntity)localObject5);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject5).nSessionId);
          }
          if (paramArrayList.istroop == 3000) {
            FileManagerReporter.a("0X8005E50");
          }
          for (;;)
          {
            FileManagerReporter.a("0X8005E4C");
            break;
            FileManagerReporter.a("0X8005E4D");
          }
        }
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).f((String)???, i);
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a((String)???, i))
      {
        MsgProxyUtils.a(paramArrayList, (MessageRecord)localObject1, true);
        UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(null, true);
        return;
      }
    }
  }
  
  public void a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (paramList.size() == 0) {}
    label665:
    label671:
    label774:
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = (MessageRecord)paramList.get(0);
      int i = 1;
      Object localObject2;
      if (i < paramList.size())
      {
        localObject2 = (MessageRecord)paramList.get(i);
        if ((((MessageRecord)localObject2).istroop == 1) || (((MessageRecord)localObject2).istroop == 3000)) {
          if (((MessageRecord)localObject2).shmsgseq > ((MessageRecord)localObject3).shmsgseq) {
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          i += 1;
          localObject3 = localObject1;
          break;
          localObject1 = localObject3;
          if (((MessageRecord)localObject2).shmsgseq == ((MessageRecord)localObject3).shmsgseq)
          {
            localObject1 = localObject3;
            if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId())
            {
              localObject1 = localObject2;
              continue;
              if (((MessageRecord)localObject2).time > ((MessageRecord)localObject3).time)
              {
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject3;
                if (((MessageRecord)localObject2).time == ((MessageRecord)localObject3).time)
                {
                  localObject1 = localObject3;
                  if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId()) {
                    localObject1 = localObject2;
                  }
                }
              }
            }
          }
        }
      }
      Object localObject1 = paramList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForLongMsg)) {
          localArrayList.addAll(((MessageForLongMsg)localObject2).longMsgFragmentList);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + localObject2);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((MessageRecord)localObject2);
          break;
          localArrayList.add(localObject2);
        }
      }
      localObject1 = MsgProxyUtils.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.containsKey(localObject1))
      {
        localObject1 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramList.next();
            if (!localMessageRecord.isread) {
              ((List)localObject2).add(localMessageRecord);
            }
          }
          if (((List)localObject2).size() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, (List)localObject2);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject3).istroop).a(localArrayList, paramBoolean2);
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MessageRecord)paramList.next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject1);
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localArrayList);
      }
      if ((localObject3 instanceof MessageForLongMsg))
      {
        if (!MsgProxyUtils.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop))) {
          break label665;
        }
        i = j;
        if (i != 0)
        {
          paramList = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
          if (!MsgProxyUtils.s(((MessageRecord)localObject3).istroop)) {
            break label671;
          }
          a((MessageRecord)localObject3);
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label774;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject3).istroop).f();
        return;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((MessageRecord)localObject3)) {
          break;
        }
        i = 0;
        break;
        if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin))
        {
          a((MessageRecord)localObject3, paramList);
        }
        else if ((((MessageRecord)localObject3).istroop == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
        {
          b((MessageRecord)localObject3);
          ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((((MessageRecord)localObject3).istroop != 1008) || (!ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
        {
          b((MessageRecord)localObject3);
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramMessageRecord;
      if (localMessageForShortVideo.busiType == 0)
      {
        if ((localMessageForShortVideo.videoFileStatus == 1007) || ((localMessageForShortVideo.videoFileStatus == 1003) && (localMessageForShortVideo.extraflag == 32772))) {}
        for (boolean bool = true; !bool; bool = false) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, holdFlag: " + bool);
        }
        e(paramMessageRecord);
        return true;
      }
    }
    else if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if (paramMessageRecord.extraflag == 32772)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, msgForPic");
        }
        e(paramMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab " + paramMessageRecord.getBaseInfoString() + ",reason " + paramInt);
    }
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return false;
      if (paramMessageRecord.isLongMsg())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord))
        {
          if ((paramInt == 1) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (!String.valueOf(AppConstants.an).equals(paramMessageRecord.frienduin))) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
          }
          return false;
        }
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      }
      while ((paramMessageRecord.isValid) && (!MsgProxyUtils.g(paramMessageRecord.msgtype)) && ((!paramMessageRecord.frienduin.equals(AppConstants.aX)) || (paramMessageRecord.istroop != 0)) && ((!paramMessageRecord.frienduin.equals(AppConstants.bd)) || (paramMessageRecord.istroop != 0)))
      {
        QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + localMessage.getBaseInfoString());
        }
        if (paramInt == 1)
        {
          int i = 0;
          if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1))
          {
            paramInt = i;
            if (!paramMessageRecord.isSendFromLocal())
            {
              paramInt = i;
              if (paramMessageRecord.shmsgseq < localMessage.shmsgseq) {
                paramInt = 1;
              }
            }
          }
          while (MsgProxyUtils.a(paramMessageRecord, localMessage)) {
            if (paramMessageRecord.longMsgIndex >= localMessage.longMsgIndex)
            {
              return false;
              paramInt = i;
              if (MsgProxyUtils.c(paramMessageRecord.istroop))
              {
                paramInt = i;
                if (!paramMessageRecord.isSendFromLocal())
                {
                  paramInt = i;
                  if (paramMessageRecord.time < localMessage.time) {
                    paramInt = 1;
                  }
                }
              }
            }
            else
            {
              paramInt = 0;
            }
          }
        }
        for (;;)
        {
          if (paramInt == 0)
          {
            MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
            localMessage.emoRecentMsg = null;
            localMessage.fileType = -1;
            if (!paramBoolean) {}
          }
          for (;;)
          {
            boolean bool;
            try
            {
              a(localMessage);
              Object localObject;
              if ((paramMessageRecord instanceof MessageForReplyText))
              {
                localObject = (MessageForReplyText)paramMessageRecord;
                if ((((MessageForReplyText)localObject).atInfoList != null) && (((MessageForReplyText)localObject).atInfoList.size() > 0) && (TextUtils.isEmpty(((MessageForReplyText)localObject).mSourceMsgInfo.mAnonymousNickName)))
                {
                  localObject = (MessageForText.AtTroopMemberInfo)((MessageForReplyText)localObject).atInfoList.get(0);
                  localMessage.msg = localMessage.msg.substring(((MessageForText.AtTroopMemberInfo)localObject).textLen + 1);
                }
              }
              bool = true;
              if ((!paramMessageRecord.isSend()) && (!MessageUtils.a(paramMessageRecord.msgtype)))
              {
                localMessage.hasReply = true;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab = " + localMessage + ",hasReply=" + localMessage.hasReply);
                }
              }
              if (((paramMessageRecord.isSendFromLocal()) || (paramMessageRecord.isread)) && (paramMessageRecord.msgtype != 64523) && (paramMessageRecord.msgtype != 64517))
              {
                paramBoolean = bool;
                if (paramMessageRecord.msgtype != 64518) {}
              }
              else
              {
                if ((paramMessageRecord.msgtype == 64523) || (paramMessageRecord.msgtype == 64517) || (paramMessageRecord.msgtype == 64518)) {
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(localMessage);
                }
                if ((!String.valueOf(AppConstants.an).equals(localMessage.frienduin)) && ((!MsgProxyUtils.c(localMessage)) || (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))) && (localMessage.istroop != 7100)) {
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(localMessage);
                }
                if (((localMessage.msgtype == 63527) || (localMessage.msgtype == 63520)) && (paramInt != 0))
                {
                  localObject = new QQMessageFacade.Message();
                  MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramMessageRecord);
                  ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
                  ((QQMessageFacade.Message)localObject).fileType = -1;
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b((QQMessageFacade.Message)localObject);
                }
                paramBoolean = bool;
                if (AppConstants.aw.equals(localMessage.frienduin))
                {
                  paramInt = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  if (paramInt <= 0) {
                    continue;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
                  paramBoolean = bool;
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + localMessage.getBaseInfoString() + " , result = " + paramBoolean);
              }
              if (MsgProxyUtils.a(localMessage.frienduin, localMessage.istroop)) {
                localMessage.istroop = MsgProxyUtils.a(localMessage.istroop);
              }
              return paramBoolean;
            }
            catch (Throwable localThrowable)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable);
              continue;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
              paramBoolean = bool;
              continue;
            }
            if ((paramInt == 4) || (paramInt == 2))
            {
              MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
              localMessage.emoRecentMsg = null;
              localMessage.fileType = -1;
              if (paramBoolean) {}
              try
              {
                a(localMessage);
                paramBoolean = true;
              }
              catch (Throwable paramMessageRecord)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
                  }
                }
              }
            }
            else
            {
              if (paramInt == 3)
              {
                if (localMessage.uniseq == paramMessageRecord.uniseq) {
                  MessageRecord.copyMessageRecordStatusField(localMessage, paramMessageRecord);
                }
                for (;;)
                {
                  paramBoolean = true;
                  break;
                  MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
                  localMessage.emoRecentMsg = null;
                  localMessage.fileType = -1;
                  try
                  {
                    a(localMessage);
                  }
                  catch (Throwable paramMessageRecord) {}
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
                  }
                }
              }
              paramBoolean = false;
              continue;
              bool = false;
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    synchronized (this.b)
    {
      this.b.notify();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest notify");
      }
      return;
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage) {}
  
  public void b(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = paramRefreshMessageContext.h;
      if (bool) {}
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(40000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage wait over");
        }
        return;
      }
      catch (InterruptedException paramRefreshMessageContext)
      {
        for (;;)
        {
          paramRefreshMessageContext.printStackTrace();
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int j = paramMessageRecord.istroop;
    paramMessageRecord = MsgProxyUtils.a((String)localObject, j);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.containsKey(paramMessageRecord)) {
      if (j != 1026) {
        break label221;
      }
    }
    label221:
    for (int i = 1;; i = j)
    {
      RecentUser localRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((String)localObject, i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((String)localObject, j);
      if (localObject != null)
      {
        a((MessageRecord)localObject, true, 4);
        if (localRecentUser != null)
        {
          if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
            localRecentUser.troopUin = ((MessageRecord)localObject).senderuin;
          }
          localRecentUser.type = i;
          localRecentUser.lastmsgtime = ((MessageRecord)localObject).time;
          HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localRecentUser);
        }
      }
      for (;;)
      {
        if (localRecentUser != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
        }
        return;
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.remove(paramMessageRecord);
        }
      }
    }
  }
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext);
  
  public void b(String paramString, int paramInt, long paramLong) {}
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    long l;
    Object localObject;
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      l = a(paramString, paramInt1);
      if (l != 0L)
      {
        if (MsgProxyUtils.a(paramInt1) != 1009) {
          break label272;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ag, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString)))
        {
          paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = AppConstants.ag;
          if (paramInt2 != 3) {
            break label181;
          }
          a(paramString, true, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ag, 1009, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ag, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
      }
    }
    label181:
    label272:
    label1068:
    do
    {
      do
      {
        MessageRecord localMessageRecord;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    if (paramInt2 == 2)
                                    {
                                      a(paramString, true, paramInt2);
                                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ag, 1009, l, paramMessageRecord.msg);
                                      return;
                                    }
                                  } while (paramInt2 != 4);
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ag, 1009, paramString.senderuin, paramString.selfuin);
                                  a(paramString, null, false, true, paramInt2);
                                  a(paramString, true, paramInt2);
                                  return;
                                  if (MsgProxyUtils.a(paramInt1) != 1001) {
                                    break label1068;
                                  }
                                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                                  bool2 = MsgProxyUtils.c(paramMessageRecord);
                                  bool1 = false;
                                  if (bool2) {
                                    bool1 = ((ConversationFacade)localObject).a(paramString, 1001, AppConstants.ar);
                                  }
                                  if ((!bool2) || (bool1)) {
                                    break;
                                  }
                                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aO, 1001);
                                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                                paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                                paramString.frienduin = AppConstants.aO;
                                paramString.senderuin = paramMessageRecord.frienduin;
                                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                                localMessageRecord.frienduin = AppConstants.ar;
                                localMessageRecord.senderuin = AppConstants.aO;
                                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ar, 1001);
                                if (paramInt2 != 3) {
                                  break;
                                }
                                a(paramString, true, paramInt2);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aO, 1001, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aO, 1001, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.aO)));
                              a(localMessageRecord, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              return;
                              if (paramInt2 != 2) {
                                break;
                              }
                              a(paramString, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aO, 1001, l, paramMessageRecord.msg);
                            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.aO)));
                            a(localMessageRecord, true, paramInt2);
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, l, paramMessageRecord.msg);
                            return;
                          } while (paramInt2 != 4);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aO, 1001, paramString.senderuin, paramString.selfuin);
                          a(paramString, null, false, true, 1);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, localMessageRecord.senderuin, localMessageRecord.selfuin);
                          a(localMessageRecord, null, false, true, 1);
                          a(paramString, true, paramInt2);
                        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.aO)));
                        a(localMessageRecord, true, paramInt2);
                        return;
                        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ar, 1001);
                      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                      paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
                      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                      paramString.selfuin = paramMessageRecord.selfuin;
                      paramString.senderuin = paramMessageRecord.frienduin;
                      paramString.frienduin = AppConstants.ar;
                      if (paramInt2 == 3)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                        return;
                      }
                      if (paramInt2 == 2)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, l, paramMessageRecord.msg);
                        return;
                      }
                    } while (paramInt2 != 4);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ar, 1001, paramString.senderuin, paramString.selfuin);
                    a(paramString, null, false, true, paramInt2);
                    a(paramString, true, paramInt2);
                    return;
                  } while (MsgProxyUtils.a(paramInt1) != 1010);
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  boolean bool2 = MsgProxyUtils.c(paramMessageRecord);
                  boolean bool1 = false;
                  if (bool2) {
                    bool1 = ((ConversationFacade)localObject).a(paramString, 1010, AppConstants.aH);
                  }
                  if ((!bool2) || (bool1)) {
                    break;
                  }
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aP, 1010);
                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                paramString.frienduin = AppConstants.aP;
                paramString.senderuin = paramMessageRecord.frienduin;
                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                localMessageRecord.frienduin = AppConstants.aH;
                localMessageRecord.senderuin = AppConstants.aP;
                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aH, 1010);
                if (paramInt2 != 3) {
                  break;
                }
                a(paramString, true, paramInt2);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aP, 1010, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aP, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.aP)));
              a(localMessageRecord, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              return;
              if (paramInt2 != 2) {
                break;
              }
              a(paramString, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aP, 1010, l, paramMessageRecord.msg);
            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.aP)));
            a(localMessageRecord, true, paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, l, paramMessageRecord.msg);
            return;
          } while (paramInt2 != 4);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aP, 1010, paramString.senderuin, paramString.selfuin);
          a(paramString, null, false, true, 1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, localMessageRecord.senderuin, localMessageRecord.selfuin);
          a(localMessageRecord, null, false, true, 1);
          a(paramString, true, paramInt2);
        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.aP)));
        a(localMessageRecord, true, paramInt2);
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.aH, 1010);
      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
      paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = AppConstants.aH;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.aH, 1010, paramString.senderuin, paramString.selfuin);
    a(paramString, null, false, true, paramInt2);
    a(paramString, true, paramInt2);
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded boxUin=" + paramString + ",boxType=" + paramInt + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : boxUin=null");
      }
    }
    for (;;)
    {
      return;
      if (!MsgProxyUtils.a(paramString, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : is not msgbox");
        }
      }
      else
      {
        Object localObject = null;
        int j = 0;
        if (paramString.equals(AppConstants.ar)) {
          localObject = AppConstants.aO;
        }
        ConversationFacade localConversationFacade;
        while (localObject != null) {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, paramInt) > 0)
          {
            paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject, paramInt);
            localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (paramString != null) {
              l = a(paramString);
            }
            localConversationFacade.a((String)localObject, paramInt, l, paramBoolean1, paramBoolean2);
            a((String)localObject, paramInt);
            return;
            if (paramString.equals(AppConstants.aH)) {
              localObject = AppConstants.aP;
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
          }
        }
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
          localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject != null) {
            l = a((MessageRecord)localObject);
          }
          localConversationFacade.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
          a(paramString, paramInt);
          i = 1;
        }
        while (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
          return;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : box unread = 0");
            i = j;
          }
        }
      }
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    Object localObject5 = (RevokeMsgInfo)paramArrayList.get(0);
    int i;
    int n;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    Object localObject6;
    label116:
    boolean bool;
    if (((RevokeMsgInfo)localObject5).jdField_c_of_type_Int > 1)
    {
      i = 1;
      n = ((RevokeMsgInfo)localObject5).jdField_a_of_type_Int;
      localObject1 = ((RevokeMsgInfo)localObject5).jdField_b_of_type_JavaLangString;
      localObject4 = ((RevokeMsgInfo)localObject5).jdField_a_of_type_JavaLangString;
      localObject3 = ((RevokeMsgInfo)localObject5).jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify fromUin = " + (String)localObject1 + ", istroop = " + n);
      }
      localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((n != 1004) && (n != 1000)) {
        break label232;
      }
      bool = TextUtils.equals((CharSequence)localObject6, (CharSequence)localObject1);
      if ((n != 3000) && (n != 1)) {
        break label237;
      }
    }
    Object localObject7;
    for (;;)
    {
      localObject6 = new ArrayList();
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject7 = (RevokeMsgInfo)((Iterator)localObject1).next();
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject4, n, ((RevokeMsgInfo)localObject7).jdField_a_of_type_Long, ((RevokeMsgInfo)localObject7).jdField_b_of_type_Long);
        if ((localObject7 != null) && (!((List)localObject7).isEmpty())) {
          ((List)localObject6).addAll((Collection)localObject7);
        }
      }
      i = 0;
      break;
      label232:
      localObject3 = localObject1;
      break label116;
      label237:
      if (bool) {
        localObject1 = localObject4;
      }
      localObject4 = localObject1;
    }
    if (i != 0) {}
    try
    {
      Collections.sort((List)localObject6, MsgProxyUtils.a);
      localObject1 = ((List)localObject6).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while ((!((MessageRecord)((Iterator)localObject1).next()).isSend()) || (bool));
      QLog.e("revokeMsg", 1, "doHandleRevokedNotifyAndNotify error, msg not send");
      UncommonMessageProcessor.b((String)localObject4, n, UncommonMessageProcessor.l, UncommonMessageProcessor.v);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "sort long msg error", localException);
            }
          }
          if ((localObject6 == null) || (((List)localObject6).size() != 1)) {
            break;
          }
        } while (UniteGrayTipUtil.a((MessageRecord)((List)localObject6).get(0)));
        if ((((MessageRecord)((List)localObject6).get(0)).msgtype != 63530) || (!(((List)localObject6).get(0) instanceof MessageForFoldMsg))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify, error: msg is fold redbag msg");
      return;
      int j = 1;
      if ((localObject6 == null) || (((List)localObject6).isEmpty()))
      {
        j = 0;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList);
          return;
        }
      }
      localObject7 = new MessageForUniteGrayTip();
      long l;
      if ((j != 0) && (((MessageRecord)((List)localObject6).get(0)).msgtype != 63530))
      {
        l = ((MessageRecord)((List)localObject6).get(0)).time;
        if (!bool) {
          break label814;
        }
        ??? = "你";
        paramArrayList = new UniteGrayTipParam((String)localObject4, (String)localObject3, ((String)???).concat(BaseApplicationImpl.a().getString(2131372240)), n, 60496, 1, l);
        paramArrayList.e = true;
        paramArrayList.f = false;
        ((MessageForUniteGrayTip)localObject7).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
        ((MessageForUniteGrayTip)localObject7).msgUid = ((RevokeMsgInfo)localObject5).jdField_b_of_type_Long;
        ((MessageForUniteGrayTip)localObject7).shmsgseq = ((RevokeMsgInfo)localObject5).jdField_a_of_type_Long;
        if (j == 0) {
          break label1046;
        }
        paramArrayList = ((List)localObject6).iterator();
      }
      for (;;)
      {
        label618:
        if (!paramArrayList.hasNext()) {
          break label1046;
        }
        ??? = (MessageRecord)paramArrayList.next();
        int m = 0;
        int k = m;
        if (i != 0)
        {
          k = m;
          if (!((MessageRecord)???).isread)
          {
            k = m;
            if (??? != ((List)localObject6).get(0))
            {
              ((MessageRecord)???).isread = true;
              if (n != 1)
              {
                k = m;
                if (n != 3000) {}
              }
              else
              {
                k = 1;
              }
            }
          }
        }
        if (k != 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(n).a((MessageRecord)???, false);
        }
        for (;;)
        {
          if (((MessageRecord)???).msgtype != 63531) {
            break label1000;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject5 = ((FileManagerDataCenter)localObject3).a(((MessageRecord)???).uniseq, ((MessageRecord)???).frienduin, ((MessageRecord)???).istroop);
          if (localObject5 == null) {
            break label1002;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, "find fileEntity");
          }
          ((FileManagerDataCenter)localObject3).b((FileManagerEntity)localObject5);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject5).nSessionId);
          break label618;
          l = ((RevokeMsgInfo)localObject5).jdField_c_of_type_Long;
          break;
          label814:
          if (n == 1)
          {
            paramArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d((String)localObject4);
            ??? = new Bundle();
            ((Bundle)???).putInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.y);
            ((Bundle)???).putLong(ContactUtils.jdField_b_of_type_JavaLangString, ((MessageForUniteGrayTip)localObject7).uniseq);
            ??? = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)localObject4, paramArrayList, true, (Bundle)???);
            paramArrayList = (ArrayList)???;
            if (TextUtils.isEmpty((CharSequence)???)) {
              paramArrayList = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)localObject4, 1, 0);
            }
          }
          for (;;)
          {
            ??? = paramArrayList;
            if (paramArrayList.length() <= 12) {
              break;
            }
            ??? = paramArrayList.substring(0, 11) + "...";
            break;
            if (n == 3000) {
              paramArrayList = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)localObject4, 2, 0);
            } else {
              paramArrayList = "对方";
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)???).frienduin, ((MessageRecord)???).istroop, ((MessageRecord)???).uniseq, false);
        }
        label1000:
        continue;
        label1002:
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageManager", 2, "can't find fileEntity,uniseq[" + ((MessageRecord)???).uniseq + "],");
        }
      }
      label1046:
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(n).f((String)localObject4, n);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify: AIO is empty");
        }
      }
      for (;;)
      {
        UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject7);
        if ((j != 0) && (!((MessageRecord)((List)localObject6).get(0)).isread)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((List)localObject6, bool);
        return;
        synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a((String)localObject4, n))
        {
          MsgProxyUtils.a(paramArrayList, (MessageRecord)localObject7, true);
        }
      }
    }
  }
  
  public void c(MessageRecord paramMessageRecord) {}
  
  public void d(MessageRecord paramMessageRecord)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    Object localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, "你撤回了一条消息", paramMessageRecord.istroop, 60496, 1, paramMessageRecord.time);
    ((UniteGrayTipParam)localObject).f = false;
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject);
    localMessageForUniteGrayTip.msgUid = paramMessageRecord.msgUid;
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).e(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "doRevokeFakeMsgToGrayTips error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, UncommonMessageProcessor.g, UncommonMessageProcessor.o);
      return;
    }
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\BaseMessageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */