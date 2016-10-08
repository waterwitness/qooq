package com.tencent.mobileqq.troop.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef;
import tencent.im.oidb.cmd0x857.TroopTips0x857.AIOGrayTipsInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GroupNotifyInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MessageRecallReminder;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MessageRecallReminder.MessageMeta;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyObjmsgUpdate;
import tencent.im.oidb.cmd0x857.TroopTips0x857.RedGrayTipsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class TroopTipsMsgMgr
  implements Manager
{
  protected static final String a;
  protected static HashMap a;
  protected static final String b = "<([^>])+";
  protected static final String c = "<{text:'A',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>给用户<{text:'B',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>送了一朵<{icon:'/rose',url:'url.qq.com?rose.png',alt:'玫瑰'}>";
  protected QQAppInterface a;
  protected Queue a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopTipsMsgMgr.class.getSimpleName();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public TroopTipsMsgMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(MessageForGrayTips paramMessageForGrayTips, String paramString)
  {
    if ((paramMessageForGrayTips == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      int i;
      Bundle localBundle;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        int k = localJSONObject.getInt("startIndex");
        int m = localJSONObject.optInt("endIndex");
        if (m <= 0) {
          break label342;
        }
        if (!localJSONObject.has("cmd")) {
          break label336;
        }
        j = localJSONObject.getInt("cmd");
        if (!localJSONObject.has("data")) {
          break label331;
        }
        paramString = localJSONObject.getString("data");
        if (!localJSONObject.has("data_a")) {
          break label326;
        }
        str = localJSONObject.getString("data_a");
        if (localJSONObject.has("url")) {
          paramString = localJSONObject.getString("url");
        }
        localBundle = new Bundle();
        localBundle.putInt("key_action", j);
        switch (j)
        {
        case 4: 
          if (localJSONObject.has("icon"))
          {
            localBundle.putString("image_resource", localJSONObject.optString("icon"));
            localBundle.putString("image_alt", localJSONObject.optString("alt"));
          }
          if (localJSONObject.has("textColor")) {
            localBundle.putString("textColor", localJSONObject.getString("textColor"));
          }
          paramMessageForGrayTips.addHightlightItem(k, m, localBundle);
        }
      }
      catch (JSONException paramMessageForGrayTips) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTips==>JSONException");
      return;
      localBundle.putString("key_action_DATA", paramString);
      localBundle.putString("key_a_action_DATA", str);
      continue;
      localBundle.putString("troop_mem_uin", paramString);
      localBundle.putBoolean("need_update_nick", true);
      continue;
      label326:
      String str = null;
      continue;
      label331:
      paramString = null;
      continue;
      label336:
      int j = -1;
      continue;
      label342:
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setUnreadAIOGrayTips");
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString1 + "_" + paramString2, Boolean.valueOf(true));
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeReadedAIOGrayTips");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Boolean.valueOf(true));
    boolean bool = localEntityManager.a(TroopTipsEntity.class.getSimpleName(), localContentValues, "troopUin=? and msgSeq=?", new String[] { paramString1, paramString2 });
    localEntityManager.a();
    if (bool)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeReadedAIOGrayTips ok troopUin:" + paramString1 + "msgSeq:" + paramString2);
      jdField_a_of_type_JavaUtilHashMap.remove(paramString1 + "_" + paramString2);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "removeReadedAIOGrayTips error");
  }
  
  public MessageForGrayTips a(TroopTipsEntity paramTroopTipsEntity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramTroopTipsEntity == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    MessageForGrayTips localMessageForGrayTips = b(paramTroopTipsEntity);
    localArrayList.add(localMessageForGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    b(paramTroopTipsEntity.troopUin, paramTroopTipsEntity.msgSeq + "");
    return localMessageForGrayTips;
  }
  
  public MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayOfByte == null) {
      paramQQAppInterface = null;
    }
    for (;;)
    {
      return paramQQAppInterface;
      Object localObject1 = new TroopTips0x857.NotifyMsgBody();
      try
      {
        localObject1 = (TroopTips0x857.NotifyMsgBody)((TroopTips0x857.NotifyMsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handle0x2dcSubType0x10 ==> notifyMsgBody == null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handle0x2dcSubType0x10 ==> msgSeq:" + paramInt);
          }
          int i = ((TroopTips0x857.NotifyMsgBody)localObject1).opt_enum_type.get();
          int j = ((TroopTips0x857.NotifyMsgBody)localObject1).uint32_service_type.get();
          l2 = ((TroopTips0x857.NotifyMsgBody)localObject1).opt_uint64_group_code.get();
          if (a(l2 + "", paramInt)) {
            return null;
          }
          long l1 = paramLong;
          if (paramLong == 0L) {
            l1 = NetConnInfoCenter.getServerTime();
          }
          paramLong = ((TroopTips0x857.NotifyMsgBody)localObject1).opt_uint64_msg_expires.get();
          if ((paramLong != 0L) && (NetConnInfoCenter.getServerTime() >= paramLong))
          {
            if (!QLog.isColorLevel()) {
              break label1434;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handle0x2dcSubType0x10 ==> time expried!! promptType:" + i);
            break label1434;
          }
          paramArrayOfByte = new TroopTipsEntity();
          paramArrayOfByte.troopUin = String.valueOf(l2);
          paramArrayOfByte.time = l1;
          paramArrayOfByte.expireTime = paramLong;
          paramArrayOfByte.msgSeq = paramInt;
          paramArrayOfByte.isOfflineMsg = paramBoolean1;
          switch (i)
          {
          case 1: 
            if (((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_redtips.has())
            {
              paramQQAppInterface = (TroopTips0x857.RedGrayTipsInfo)((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_redtips.get();
              paramArrayOfByte.currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              localObject1 = (MessageForQQWalletTips)MessageRecordFactory.a(63507);
              ((MessageForQQWalletTips)localObject1).senderUin = (paramQQAppInterface.uint64_sender_uin.get() + "");
              ((MessageForQQWalletTips)localObject1).reciverUin = (paramQQAppInterface.uint64_receiver_uin.get() + "");
              ((MessageForQQWalletTips)localObject1).senderContent = paramQQAppInterface.bytes_sender_rich_content.get().toStringUtf8();
              ((MessageForQQWalletTips)localObject1).reciverContent = paramQQAppInterface.bytes_receiver_rich_content.get().toStringUtf8();
              ((MessageForQQWalletTips)localObject1).authKey = paramQQAppInterface.bytes_authkey.get().toStringUtf8();
              ((MessageForQQWalletTips)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramArrayOfByte.troopUin, "", "[QQWallet Tips]", MessageCache.a(), 63507, 1, MessageCache.a());
              ((MessageForQQWalletTips)localObject1).isread = true;
              ((MessageForQQWalletTips)localObject1).getBytes();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, paramArrayOfByte.currentUin);
              return null;
            }
            paramArrayOfByte.tipsPromptType = 1;
            paramArrayOfByte.currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            paramArrayOfByte.optContent = ((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_graytips.opt_bytes_content.get().toStringUtf8();
            paramArrayOfByte.grayTipsRemindFlag = ((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_graytips.opt_uint32_remind.get();
            if (((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_graytips.opt_bytes_brief.has()) {
              paramArrayOfByte.grayTipsSummary = ((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_graytips.opt_bytes_brief.get().toStringUtf8();
            }
            if (TextUtils.isEmpty(paramArrayOfByte.optContent)) {
              return null;
            }
            paramArrayOfByte.optShowLatest = ((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_graytips.opt_uint32_show_lastest.get();
            a(paramArrayOfByte);
            if (j == 3)
            {
              HWTroopUtils.a(paramQQAppInterface, paramArrayOfByte);
              return null;
            }
            paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte.troopUin, paramArrayOfByte);
            if ((!paramBoolean1) && (MessageHandlerUtils.a(paramQQAppInterface, paramArrayOfByte, false))) {
              return null;
            }
            paramQQAppInterface = paramArrayOfByte;
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte.saveExtInfoToExtStr("gray_tips_serviceType", j + "");
              return paramArrayOfByte;
            }
            break;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        long l2;
        paramQQAppInterface.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handle0x2dcSubType0x10 Exception " + paramQQAppInterface.getStackTrace());
          break label1436;
          if (((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_group_notify.has())
          {
            paramQQAppInterface = (TroopTips0x857.GroupNotifyInfo)((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_group_notify.get();
            paramArrayOfByte = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(Long.valueOf(l2), true);
            if ((paramArrayOfByte != null) && (1 == paramQQAppInterface.opt_uint32_auto_pull_flag.get()))
            {
              paramArrayOfByte.a(paramQQAppInterface.opt_bytes_feeds_id.get().toStringUtf8(), Integer.valueOf(paramQQAppInterface.opt_uint32_auto_pull_flag.get()));
              ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(67, true, new Object[] { String.valueOf(l2), paramQQAppInterface.opt_bytes_feeds_id.get().toStringUtf8(), Integer.valueOf(paramQQAppInterface.opt_uint32_auto_pull_flag.get()) });
              break label1436;
              if ((!paramBoolean2) && (((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_recall.has()))
              {
                localObject1 = (TroopTips0x857.MessageRecallReminder)((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_recall.get();
                paramLong = ((TroopTips0x857.MessageRecallReminder)localObject1).uint64_uin.get();
                paramQQAppInterface = new HashMap();
                Object localObject2;
                try
                {
                  paramArrayOfByte = new msgrevoke_userdef.MsgInfoUserDef();
                  paramArrayOfByte.mergeFrom(((TroopTips0x857.MessageRecallReminder)localObject1).bytes_userdef.get().toByteArray());
                  paramInt = paramArrayOfByte.uint32_long_message_flag.get();
                  if (paramInt != 1) {
                    break label1084;
                  }
                  paramArrayOfByte = ((ArrayList)paramArrayOfByte.long_msg_info.get()).iterator();
                  while (paramArrayOfByte.hasNext())
                  {
                    localObject2 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramArrayOfByte.next();
                    paramQQAppInterface.put(Integer.valueOf(((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).uint32_msg_seq.get()), localObject2);
                  }
                  QLog.d("revokeMsg", 2, "recv 0x2dc_0x11 msg, parse msgInfoUserDef error");
                }
                catch (Exception paramQQAppInterface)
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                }
                break;
                label1084:
                paramArrayOfByte = new ArrayList();
                localObject1 = ((ArrayList)((TroopTips0x857.MessageRecallReminder)localObject1).uint32_recalled_msg_list.get()).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  Object localObject3 = (TroopTips0x857.MessageRecallReminder.MessageMeta)((Iterator)localObject1).next();
                  localObject2 = new RevokeMsgInfo();
                  ((RevokeMsgInfo)localObject2).jdField_b_of_type_JavaLangString = String.valueOf(paramLong);
                  ((RevokeMsgInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l2);
                  ((RevokeMsgInfo)localObject2).jdField_a_of_type_Int = 1;
                  ((RevokeMsgInfo)localObject2).jdField_a_of_type_Long = ((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get();
                  ((RevokeMsgInfo)localObject2).jdField_c_of_type_Long = ((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint32_time.get();
                  if (paramInt == 1)
                  {
                    localObject3 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramQQAppInterface.get(Integer.valueOf(((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get()));
                    ((RevokeMsgInfo)localObject2).jdField_b_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_id.get();
                    ((RevokeMsgInfo)localObject2).jdField_c_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_num.get();
                    ((RevokeMsgInfo)localObject2).d = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_index.get();
                  }
                  paramArrayOfByte.add(localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("revokeMsg", 2, "recv 0x2dc_0x11 msg," + ((RevokeMsgInfo)localObject2).toString());
                  }
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte, false);
                return null;
                if (QLog.isColorLevel()) {
                  QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate push message");
                }
                if (((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_objmsg_update.has())
                {
                  localObject1 = (TroopTips0x857.NotifyObjmsgUpdate)((TroopTips0x857.NotifyMsgBody)localObject1).opt_msg_objmsg_update.get();
                  if (((TroopTips0x857.NotifyObjmsgUpdate)localObject1).bytes_ext_msg.has())
                  {
                    paramArrayOfByte = new SubMsgType0xaa.MsgBody();
                    try
                    {
                      paramArrayOfByte.mergeFrom(((TroopTips0x857.NotifyObjmsgUpdate)localObject1).bytes_ext_msg.get().toByteArray());
                      ((GamePartyManager)paramQQAppInterface.getManager(155)).a(paramArrayOfByte, false);
                    }
                    catch (Exception localException)
                    {
                      for (;;)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate, prase msgBody error");
                        }
                      }
                    }
                    return null;
                    label1434:
                    return null;
                  }
                }
              }
            }
          }
        }
        label1436:
        return null;
      }
    }
    return null;
  }
  
  public List a(String paramString)
  {
    if (paramString == null) {}
    Object localObject;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramString = ((EntityManager)localObject).a(TroopTipsEntity.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() }, null, null, "time ASC", null);
      ((EntityManager)localObject).a();
    } while (paramString == null);
    int i = 0;
    if (i < paramString.size())
    {
      localObject = (TroopTipsEntity)paramString.get(i);
      if ((((TroopTipsEntity)localObject).expireTime != 0L) && (NetConnInfoCenter.getServerTime() >= ((TroopTipsEntity)localObject).expireTime)) {}
      for (;;)
      {
        i += 1;
        break;
        if (((TroopTipsEntity)localObject).optShowLatest == 1) {
          localArrayList2.add(localObject);
        } else {
          localArrayList1.add(localObject);
        }
      }
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initTroopTipsFlag");
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Cursor localCursor = localEntityManager.a(true, TroopTipsEntity.class.getSimpleName(), new String[] { "troopUin" }, "read=?", new String[] { String.valueOf(0) }, "troopUin", null, null, null);
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int i = localCursor.getColumnIndex("troopUin");
          if (i == -1) {
            break label226;
          }
          paramQQAppInterface = localCursor.getString(i);
          i = localCursor.getColumnIndex("msgSeq");
          if (i == -1) {
            break label221;
          }
          str = localCursor.getString(i);
          if ((paramQQAppInterface != null) && (str != null)) {
            a(paramQQAppInterface, str);
          }
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initTroopTipsFlag Exception");
        localCursor.close();
        continue;
      }
      finally
      {
        localCursor.close();
      }
      localEntityManager.a();
      return;
      label221:
      String str = null;
      continue;
      label226:
      paramQQAppInterface = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveTroopTips");
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    paramTroopTipsEntity.read = false;
    paramTroopTipsEntity.currentUin = paramQQAppInterface.a();
    a(paramTroopTipsEntity.troopUin, paramTroopTipsEntity.msgSeq + "");
    localEntityManager.a(paramTroopTipsEntity);
    localEntityManager.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      paramQQAppInterface = a(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
      {
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext()) {
          a((TroopTipsEntity)paramQQAppInterface.next());
        }
      }
    }
  }
  
  public void a(TroopTipsEntity paramTroopTipsEntity)
  {
    int i = 0;
    if ((paramTroopTipsEntity == null) || (paramTroopTipsEntity.optContent == null)) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "decodeContent ===> entity == null || content == null");
      }
    }
    JSONArray localJSONArray;
    label1043:
    do
    {
      return;
      Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramTroopTipsEntity.optContent);
      paramTroopTipsEntity.highlightNum = 0;
      localJSONArray = new JSONArray();
      Object localObject1 = "";
      int j = 0;
      String str2;
      for (;;)
      {
        if (!localMatcher.find()) {
          break label1043;
        }
        j += 1;
        paramTroopTipsEntity.highlightNum = j;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "match count=====>" + j);
        }
        int m = localMatcher.start();
        int k = localMatcher.end();
        String str1 = paramTroopTipsEntity.optContent.substring(m + 1, k);
        str2 = paramTroopTipsEntity.optContent.substring(i, m);
        localObject1 = (String)localObject1 + str2;
        m = ((String)localObject1).length();
        i = k + 1;
        for (;;)
        {
          try
          {
            localStringBuilder = new StringBuilder();
            localJSONObject = new JSONObject(str1);
            localJSONObject.put("startIndex", m);
            if (localJSONObject.has("uin"))
            {
              str1 = localJSONObject.get("uin").toString();
              str2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramTroopTipsEntity.troopUin, str1);
              if (str2 == null) {
                continue;
              }
              str1 = (String)localObject1 + str2;
              localObject1 = str1;
            }
          }
          catch (JSONException localJSONException2)
          {
            StringBuilder localStringBuilder;
            JSONObject localJSONObject;
            boolean bool;
            String str3;
            Object localObject2;
            continue;
            Object localObject4 = localObject2;
            continue;
            localObject4 = localObject2;
            continue;
            localObject4 = localObject2;
            continue;
          }
          try
          {
            localJSONObject.put("endIndex", str2.length() + m);
            localObject1 = str1;
            localStringBuilder.append("text==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
            localObject1 = str1;
            bool = localJSONObject.has("cmd");
            if (bool) {
              localObject1 = str1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            k = Integer.parseInt(localJSONObject.get("cmd").toString());
            localObject1 = str1;
            localJSONObject.put("cmd", k);
            localObject1 = str1;
            localStringBuilder.append(",cmd==>");
            localObject1 = str1;
            localStringBuilder.append(k);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localObject2 = localObject3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject2 = localObject3;
            QLog.e(jdField_a_of_type_JavaLangString, 2, "decodeContent==>NumberFormatException");
            continue;
            localObject2 = str2;
            localJSONArray.put(localJSONObject);
            localObject2 = str2;
            Object localObject3 = str2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject2 = str2;
            QLog.d(jdField_a_of_type_JavaLangString, 2, "decodeContent==>" + localStringBuilder.toString());
            localObject3 = str2;
            continue;
          }
          localObject1 = str1;
          if (localJSONObject.has("textColor"))
          {
            localObject1 = str1;
            str2 = localJSONObject.getString("textColor");
            localObject1 = str1;
            localJSONObject.put("textColor", str2);
            localObject1 = str1;
            localStringBuilder.append(",textColor==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("data"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("data").toString();
            localObject1 = str1;
            localJSONObject.put("data", str2);
            localObject1 = str1;
            localStringBuilder.append(",data==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("data_a"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("data_a").toString();
            localObject1 = str1;
            localJSONObject.put("data_a", str2);
            localObject1 = str1;
            localStringBuilder.append(",data_a==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("url"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("url").toString();
            localObject1 = str1;
            localJSONObject.put("url", str2);
            localObject1 = str1;
            localStringBuilder.append(",url:");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("icon"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("icon").toString();
            localObject1 = str1;
            localJSONObject.put("icon", str2);
            localObject1 = str1;
            localStringBuilder.append(",icon:");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          str2 = str1;
          if (!localJSONObject.has("alt")) {
            continue;
          }
          localObject1 = str1;
          str3 = localJSONObject.get("alt").toString();
          str2 = str1;
          if (str3 == null) {
            continue;
          }
          localObject1 = str1;
          str2 = "[" + str3 + "]";
          localObject1 = str1;
          str1 = str1 + str2;
          localObject1 = str1;
          localJSONObject.put("endIndex", m + str2.length());
          localObject1 = str1;
          localStringBuilder.append(",alt:");
          localObject1 = str1;
          localStringBuilder.append(str2);
          localObject1 = str1;
          bool = paramTroopTipsEntity.isSupportImage;
          str2 = str1;
          if (bool) {
            continue;
          }
          localObject1 = str1;
          break;
          if (!localJSONObject.has("text")) {
            continue;
          }
          str2 = localJSONObject.get("text").toString();
          if (str2 == null) {
            continue;
          }
          str1 = (String)localObject1 + str2;
          localObject1 = str1;
          localJSONObject.put("endIndex", str2.length() + m);
          localObject1 = str1;
          localStringBuilder.append("text==>");
          localObject1 = str1;
          localStringBuilder.append(str2);
        }
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "decodeContent:JSONException");
          localObject3 = localObject1;
        }
        localObject1 = localObject3;
      }
      paramTroopTipsEntity.optContent = ((String)localObject2 + paramTroopTipsEntity.optContent.substring(i, paramTroopTipsEntity.optContent.length()));
    } while (paramTroopTipsEntity.highlightNum == 0);
    paramTroopTipsEntity.highlightItems = localJSONArray.toString();
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    TroopTipsEntity localTroopTipsEntity = new TroopTipsEntity();
    localTroopTipsEntity.troopUin = paramString1;
    localTroopTipsEntity.time = paramLong1;
    localTroopTipsEntity.expireTime = paramLong2;
    localTroopTipsEntity.msgSeq = paramInt;
    localTroopTipsEntity.tipsPromptType = 1;
    localTroopTipsEntity.currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localTroopTipsEntity.optContent = paramString2;
    localTroopTipsEntity.optShowLatest = 1;
    a(localTroopTipsEntity);
    a(localTroopTipsEntity);
  }
  
  public boolean a(String paramString)
  {
    return !jdField_a_of_type_JavaUtilHashMap.isEmpty();
  }
  
  public boolean a(String paramString, long paramLong)
  {
    paramString = paramString + "_" + paramLong;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "tipsMsgFilterBySeq, flag in queue equals uniFlag:" + paramString);
        }
        return true;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(paramString);
    return false;
  }
  
  public MessageForGrayTips b(TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "decodeTroopTipsEntity2GrayTips,entity:" + paramTroopTipsEntity.toString());
    }
    if (paramTroopTipsEntity.grayTipsRemindFlag != 0) {}
    for (int i = 63494;; i = 2024)
    {
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
      localMessageForGrayTips.frienduin = paramTroopTipsEntity.troopUin;
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramTroopTipsEntity.troopUin, paramTroopTipsEntity.troopUin, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, i, 1, paramTroopTipsEntity.msgSeq);
      if (paramTroopTipsEntity.highlightNum != 0) {
        a(localMessageForGrayTips, paramTroopTipsEntity.highlightItems);
      }
      if (paramTroopTipsEntity.optShowLatest == 1) {
        localMessageForGrayTips.shmsgseq = 0L;
      }
      localMessageForGrayTips.isread = true;
      return localMessageForGrayTips;
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopTipsMsgMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */