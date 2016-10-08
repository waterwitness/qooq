package com.tencent.mobileqq.app.message;

import ActionMsg.MsgBody;
import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import PushNotifyPack.RequestPushNotify;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.gamecenter.GameCenterPackeger;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import qmj;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;

public class SubAccountMessageProcessor
  extends C2CMessageProcessor
{
  public SubAccountMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1;
    if (paramToServiceMsg == null) {
      str1 = "null";
    }
    for (;;)
    {
      String str2;
      label16:
      int i;
      long l;
      Object localObject2;
      msg_svc.PbBindUinMsgReadedConfirmResp localPbBindUinMsgReadedConfirmResp;
      Object localObject1;
      int j;
      if (paramToServiceMsg == null)
      {
        str2 = "null";
        i = -1;
        l = 0L;
        localObject2 = null;
        paramFromServiceMsg = null;
        localPbBindUinMsgReadedConfirmResp = new msg_svc.PbBindUinMsgReadedConfirmResp();
        localObject1 = localObject2;
        j = i;
      }
      try
      {
        paramObject = (msg_svc.PbBindUinMsgReadedConfirmResp)localPbBindUinMsgReadedConfirmResp.mergeFrom((byte[])paramObject);
        localObject1 = localObject2;
        j = i;
        i = ((msg_svc.PbBindUinMsgReadedConfirmResp)paramObject).result.get();
        localObject1 = localObject2;
        j = i;
        if (((msg_svc.PbBindUinMsgReadedConfirmResp)paramObject).sync_cookie.has())
        {
          localObject1 = localObject2;
          j = i;
          paramFromServiceMsg = ((msg_svc.PbBindUinMsgReadedConfirmResp)paramObject).sync_cookie.get().toByteArray();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (((msg_svc.PbBindUinMsgReadedConfirmResp)paramObject).bind_uin.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          l = ((msg_svc.PbBindUinMsgReadedConfirmResp)paramObject).bind_uin.get();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (((msg_svc.PbBindUinMsgReadedConfirmResp)paramObject).errmsg.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          paramObject = ((msg_svc.PbBindUinMsgReadedConfirmResp)paramObject).errmsg.get();
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() subUin=").append(str2).append(" lSubUin=").append(l).append(" errMsg=").append((String)paramObject).append(" cookie=");
              if (paramFromServiceMsg == null)
              {
                localObject1 = "null";
                QLog.d("SUB_ACCOUNT", 2, localObject1);
                j = i;
                localObject1 = paramFromServiceMsg;
                localObject2 = paramObject;
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() ssoSeq:");
                if (paramToServiceMsg != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                paramFromServiceMsg = paramFromServiceMsg.append(paramToServiceMsg).append(" result=").append(j).append(" syncCookie=");
                if (localObject1 != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                QLog.d("SUB_ACCOUNT", 2, paramToServiceMsg + " errms=" + String.valueOf(localObject2));
              }
              boolean bool = false;
              if (j == 0)
              {
                paramToServiceMsg = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.a(str2, (byte[])localObject1);
                }
                bool = true;
              }
              a(8011, bool, new String[] { str2, str1 });
              return;
              str1 = paramToServiceMsg.extraData.getString("nextAction");
              break;
              str2 = paramToServiceMsg.extraData.getString("subAccount");
              break label16;
            }
            j = paramFromServiceMsg.length;
            localObject1 = Integer.valueOf(j);
            continue;
            localException1 = localException1;
            paramObject = null;
            i = j;
            paramFromServiceMsg = (FromServiceMsg)localObject1;
          }
          catch (Exception localException2)
          {
            continue;
          }
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.e("SUB_ACCOUNT", 2, "handleConfirmSubAccountMsgNumReaded() decode pb:", localException1);
            localObject2 = paramObject;
            localObject1 = paramFromServiceMsg;
            j = i;
            continue;
            paramToServiceMsg = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
            continue;
            paramToServiceMsg = Integer.toString(localObject1.length);
            continue;
            paramObject = null;
          }
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localSubAccountBackProtocData.b = str2;
    localSubAccountBackProtocData.jdField_c_of_type_JavaLangString = str1;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd= CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handleGetSubC2CMessageResp_PB subUin=" + str1);
    }
    Object localObject1 = new msg_svc.PbGetMsgResp();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("printPBuffer", 2, HexUtil.a((byte[])paramObject));
      }
      paramObject = (msg_svc.PbGetMsgResp)((msg_svc.PbGetMsgResp)localObject1).mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB : decode pb:", (Throwable)paramObject);
        }
        paramObject = null;
        continue;
        localObject1 = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
        continue;
        localObject1 = Integer.valueOf(((msg_svc.PbGetMsgResp)paramObject).result.get());
        continue;
        localObject1 = Boolean.valueOf(((msg_svc.PbGetMsgResp)paramObject).sync_cookie.has());
        continue;
        localObject1 = Integer.valueOf(((msg_svc.PbGetMsgResp)paramObject).sync_flag.get());
      }
      localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if (!((msg_svc.PbGetMsgResp)paramObject).result.has()) {
        break label417;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("subaccount <---handleGetSubC2CMessageResp_PB ssoSeq:");
      if (paramToServiceMsg == null)
      {
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(" msgStruct.cReplyCode: ");
        if (paramObject != null) {
          break label338;
        }
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(",hasSyncCookie:");
        if (paramObject != null) {
          break label353;
        }
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(",syncFlag:");
        if (paramObject != null) {
          break label368;
        }
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject1);
      }
    }
    else
    {
      if (paramObject != null) {
        break label383;
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12014");
      paramToServiceMsg.put("fail_step", "getmsgresp_null");
      paramToServiceMsg.put("fail_location", "MessageHandler");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      a(8003, false, localSubAccountBackProtocData);
      return;
    }
    label338:
    label353:
    label368:
    label383:
    SubAccountManager localSubAccountManager;
    label417:
    int i;
    if (((msg_svc.PbGetMsgResp)paramObject).result.get() != 0)
    {
      i = ((msg_svc.PbGetMsgResp)paramObject).result.get();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB rspResult = " + i);
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12015");
      paramToServiceMsg.put("fail_step", "result_" + i);
      paramToServiceMsg.put("fail_location", "MessageHandler");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      if (i <= 100) {
        break label5279;
      }
      i -= 100;
    }
    label1893:
    label1894:
    label2082:
    label2660:
    label2699:
    label3871:
    label4064:
    label4072:
    label4227:
    label4692:
    label4707:
    label4713:
    label4720:
    label5160:
    label5188:
    label5229:
    label5232:
    label5279:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB really rspResult = " + i);
      }
      boolean bool1;
      switch (i)
      {
      default: 
        if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241) || (i == 1242) || (i == 1221))
        {
          localSubAccountBackProtocData.p = 1004;
          localSubAccountBackProtocData.q = i;
          localSubAccountBackProtocData.jdField_a_of_type_JavaLangString = ((msg_svc.PbGetMsgResp)paramObject).errmsg.get();
          localSubAccountBackProtocData.jdField_c_of_type_Boolean = true;
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, str1);
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 6);
          localSubAccountBackProtocData.d = true;
          localSubAccountManager.a(str1, null, true);
          bool1 = localSubAccountManager.a(str1, 3);
          localSubAccountManager.a(str1, i, ((msg_svc.PbGetMsgResp)paramObject).errmsg.get());
          localSubAccountManager.e(str1);
          if (bool1)
          {
            i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 7000);
            if (i != 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, 7000, i);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.ah, str1 });
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "processSubAccountMessage() hint need to verify,msg num=1, subUin=" + str1);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(str1, false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
        }
        break;
      }
      for (;;)
      {
        a(8003, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB getMsgResp == null || !getMsgResp.result.has() || getMsgResp.result.get() != 0 ");
        return;
        localSubAccountBackProtocData.p = 1008;
        SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sub.uin.all");
        continue;
        localSubAccountBackProtocData.p = 1002;
        SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, str1);
        SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
        continue;
        localSubAccountBackProtocData.p = 1006;
        continue;
        localSubAccountBackProtocData.p = 1000;
      }
      localSubAccountManager.a(str1, 1);
      localObject1 = paramFromServiceMsg.getUin();
      long l2 = -1L;
      try
      {
        l1 = Long.parseLong(str1);
        if (localObject1 == null)
        {
          a(8003, false, localSubAccountBackProtocData);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB tmpBackUin == null ");
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12014");
          paramToServiceMsg.put("fail_step", "backuin_null");
          paramToServiceMsg.put("fail_location", "MessageHandler");
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
          return;
        }
      }
      catch (Exception localException3)
      {
        long l1;
        for (;;)
        {
          localException3.printStackTrace();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB subAccount parselong error ");
            l1 = l2;
          }
        }
        try
        {
          l2 = Long.valueOf(paramFromServiceMsg.getUin()).longValue();
          if (l2 == -1L)
          {
            a(8003, false, localSubAccountBackProtocData);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin == -1 ");
            }
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12014");
            paramToServiceMsg.put("fail_step", "selfUin_null");
            paramToServiceMsg.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin parselong error ");
            }
            l2 = -1L;
          }
          if (((msg_svc.PbGetMsgResp)paramObject).sync_cookie.has()) {}
          for (byte[] arrayOfByte = ((msg_svc.PbGetMsgResp)paramObject).sync_cookie.get().toByteArray();; arrayOfByte = null)
          {
            if (((msg_svc.PbGetMsgResp)paramObject).sync_flag.has()) {}
            for (int j = ((msg_svc.PbGetMsgResp)paramObject).sync_flag.get();; j = 2)
            {
              byte b;
              int k;
              if (j < 2)
              {
                b = (byte)1;
                k = 0;
              }
              for (;;)
              {
                if (((msg_svc.PbGetMsgResp)paramObject).bind_uin.has()) {}
                for (long l3 = ((msg_svc.PbGetMsgResp)paramObject).bind_uin.get();; l3 = 0L)
                {
                  if (localSubAccountManager != null) {}
                  for (List localList1 = localSubAccountManager.a(Long.toString(l3));; localList1 = null)
                  {
                    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("hadGetMsgListUin");
                    if (localArrayList == null) {
                      localArrayList = new ArrayList();
                    }
                    for (;;)
                    {
                      HashMap localHashMap = new HashMap();
                      List localList2 = ((msg_svc.PbGetMsgResp)paramObject).uin_pair_msgs.get();
                      int m = 0;
                      if (m < localList2.size())
                      {
                        paramFromServiceMsg = (msg_comm.UinPairMsg)localList2.get(m);
                        long l6 = paramFromServiceMsg.peer_uin.get();
                        long l4 = paramFromServiceMsg.last_read_time.get();
                        paramObject = paramFromServiceMsg.msg.get();
                        if (k == 0) {
                          localArrayList.add(Long.toString(l6));
                        }
                        int n = paramFromServiceMsg.unread_msg_num.get();
                        if (QLog.isColorLevel()) {
                          QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUi cc n:" + l6);
                        }
                        if ((paramObject == null) || (((List)paramObject).size() == 0) || (n == 0))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB msgList == null || msgList.size() == 0 msg is null " + l6);
                          }
                          if (localList1 != null)
                          {
                            paramFromServiceMsg = localList1.iterator();
                            while (paramFromServiceMsg.hasNext())
                            {
                              paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                              if (paramObject != null)
                              {
                                paramObject = ((SubAccountMessage)paramObject).frienduin;
                                if ((paramObject != null) && (((String)paramObject).equalsIgnoreCase(String.valueOf(l6))))
                                {
                                  localArrayList.add(String.valueOf(l6));
                                  localHashMap.put(String.valueOf(l6), Integer.valueOf(n));
                                }
                              }
                            }
                          }
                        }
                        DecodeProtoPkgContext localDecodeProtoPkgContext;
                        do
                        {
                          m += 1;
                          break;
                          if (QLog.isColorLevel()) {
                            QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l6 + ",msgList size:" + ((List)paramObject).size());
                          }
                          localDecodeProtoPkgContext = new DecodeProtoPkgContext(l1, l6, false, false, false, true);
                        } while ((paramObject == null) || (((List)paramObject).size() <= 0));
                        Collections.sort((List)paramObject, new qmj(this));
                        Iterator localIterator1;
                        if ((paramFromServiceMsg.msg_completed.has()) && (paramFromServiceMsg.msg_completed.get() != 0))
                        {
                          bool1 = true;
                          if (QLog.isColorLevel()) {
                            QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l6 + "msgList size: " + ((List)paramObject).size() + ",uMsgCompleted:" + bool1 + ",lastReadTime:" + (l4 & 0xFFFFFFFF));
                          }
                          localIterator1 = ((List)paramObject).iterator();
                          break label2082;
                        }
                        msg_comm.Msg localMsg;
                        int i1;
                        for (;;)
                        {
                          if (!localIterator1.hasNext()) {
                            break label4692;
                          }
                          localMsg = (msg_comm.Msg)localIterator1.next();
                          if (localMsg != null)
                          {
                            localObject1 = (msg_comm.MsgHead)localMsg.msg_head.get();
                            i = ((msg_comm.MsgHead)localObject1).msg_type.get();
                            paramObject = null;
                            i1 = ((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_cmd.get();
                            if ((193 == i) || (734 == i)) {
                              if (l1 == l6) {
                                paramFromServiceMsg = (FromServiceMsg)paramObject;
                              }
                            }
                            for (;;)
                            {
                              if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()) && (localList1 != null) && (!localList1.isEmpty()) && (((MessageRecord)paramFromServiceMsg.get(0)).time < ((SubAccountMessage)localList1.get(0)).time)) {
                                paramFromServiceMsg.clear();
                              }
                              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() != 0)) {
                                break label2660;
                              }
                              if (localList1 == null) {
                                break label1894;
                              }
                              paramFromServiceMsg = localList1.iterator();
                              if (!paramFromServiceMsg.hasNext()) {
                                break label1894;
                              }
                              paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                              if (paramObject == null) {
                                break label1893;
                              }
                              paramObject = ((SubAccountMessage)paramObject).frienduin;
                              if ((paramObject == null) || (!((String)paramObject).equalsIgnoreCase(String.valueOf(l6)))) {
                                break label1893;
                              }
                              localArrayList.add(String.valueOf(l6));
                              localHashMap.put(String.valueOf(l6), Integer.valueOf(n));
                              break label1894;
                              bool1 = false;
                              break;
                              paramFromServiceMsg = new ArrayList();
                              paramObject = MessageRecordFactory.a(193);
                              ((MessageRecord)paramObject).selfuin = String.valueOf(l1);
                              ((MessageRecord)paramObject).frienduin = String.valueOf(l6);
                              ((MessageRecord)paramObject).senderuin = String.valueOf(l6);
                              ((MessageRecord)paramObject).shmsgseq = ((msg_comm.MsgHead)localObject1).msg_seq.get();
                              ((MessageRecord)paramObject).msgUid = ((msg_comm.MsgHead)localObject1).msg_uid.get();
                              ((MessageRecord)paramObject).time = ((msg_comm.MsgHead)localObject1).msg_time.get();
                              ((MessageRecord)paramObject).istroop = 0;
                              ((MessageRecord)paramObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131370155);
                              ((MessageRecord)paramObject).msgtype = 193;
                              paramFromServiceMsg.add(paramObject);
                              continue;
                              if ((MessageUtils.c(i)) && (((msg_comm.MsgHead)localObject1).c2c_cmd.has()) && ((i1 == 169) || (i1 == 241) || (i1 == 242) || (i1 == 243) || (i1 == 129) || (i1 == 131) || (i1 == 133)))
                              {
                                if ((i1 == 129) || (i1 == 131) || (i1 == 133) || (i1 == 135) || (i1 == 243)) {
                                  break label1894;
                                }
                                for (;;)
                                {
                                  try
                                  {
                                    paramFromServiceMsg = ((im_msg_body.NotOnlineFile)((im_msg_body.RichText)((im_msg_body.MsgBody)localMsg.msg_body.get()).rich_text.get()).not_online_file.get()).bytes_file_name.get().toStringUtf8();
                                    paramObject = paramFromServiceMsg;
                                  }
                                  catch (Exception paramObject)
                                  {
                                    try
                                    {
                                      if (QLog.isColorLevel())
                                      {
                                        QLog.d("SUB_ACCOUNT", 2, "fileName = " + paramFromServiceMsg);
                                        paramObject = paramFromServiceMsg;
                                      }
                                      paramFromServiceMsg = (FromServiceMsg)paramObject;
                                      if (TextUtils.isEmpty((CharSequence)paramObject)) {
                                        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369800);
                                      }
                                      paramObject = MessageRecordFactory.a(63531);
                                      ((MessageRecord)paramObject).selfuin = String.valueOf(l1);
                                      ((MessageRecord)paramObject).frienduin = String.valueOf(l6);
                                      ((MessageRecord)paramObject).senderuin = String.valueOf(l6);
                                      ((MessageRecord)paramObject).shmsgseq = ((msg_comm.MsgHead)localObject1).msg_seq.get();
                                      ((MessageRecord)paramObject).msgUid = ((msg_comm.MsgHead)localObject1).msg_uid.get();
                                      ((MessageRecord)paramObject).time = ((msg_comm.MsgHead)localObject1).msg_time.get();
                                      ((MessageRecord)paramObject).istroop = 0;
                                      ((MessageRecord)paramObject).msg = paramFromServiceMsg;
                                      ((MessageRecord)paramObject).msgtype = 63531;
                                      paramFromServiceMsg = new ArrayList();
                                      paramFromServiceMsg.add(paramObject);
                                    }
                                    catch (Exception paramObject)
                                    {
                                      for (;;)
                                      {
                                        StringBuffer localStringBuffer;
                                        MessageRecord localMessageRecord1;
                                        long l5;
                                        Iterator localIterator2;
                                        MessageRecord localMessageRecord2;
                                        Object localObject3;
                                        boolean bool2;
                                        continue;
                                        paramFromServiceMsg = null;
                                        continue;
                                        continue;
                                        paramFromServiceMsg = (FromServiceMsg)paramObject;
                                        continue;
                                        i = 0;
                                      }
                                    }
                                    paramObject = paramObject;
                                    paramFromServiceMsg = null;
                                  }
                                  ((Exception)paramObject).printStackTrace();
                                  paramObject = paramFromServiceMsg;
                                }
                              }
                              try
                              {
                                paramFromServiceMsg = a(localMsg, localDecodeProtoPkgContext);
                              }
                              catch (Exception localException1)
                              {
                                paramFromServiceMsg = (FromServiceMsg)paramObject;
                              }
                              if (QLog.isColorLevel())
                              {
                                QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException1);
                                paramFromServiceMsg = (FromServiceMsg)paramObject;
                              }
                            }
                            localStringBuffer = new StringBuffer();
                            localMessageRecord1 = (MessageRecord)paramFromServiceMsg.get(0);
                            l5 = localMessageRecord1.time;
                            localIterator2 = paramFromServiceMsg.iterator();
                            bool1 = false;
                            do
                            {
                              if (!localIterator2.hasNext()) {
                                break;
                              }
                              localMessageRecord2 = (MessageRecord)localIterator2.next();
                            } while (localMessageRecord2 == null);
                            paramObject = localMessageRecord2.msg;
                            if (paramObject != null) {}
                            try
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  basemsg  = ");
                              }
                              if (localMessageRecord2.frienduin == null) {
                                break label2699;
                              }
                              if (String.valueOf(AppConstants.aq).equalsIgnoreCase(localMessageRecord2.frienduin))
                              {
                                paramFromServiceMsg = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)paramObject, localMessageRecord2.msgtype, localMessageRecord2.senderuin);
                                if (paramFromServiceMsg == null)
                                {
                                  i = 1;
                                  if ((localStringBuffer != null) && (localStringBuffer.length() != 0)) {
                                    break label3871;
                                  }
                                  if (!QLog.isColorLevel()) {
                                    continue;
                                  }
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB show == null || show.length() == 0; msg is not decode success.");
                                }
                              }
                            }
                            catch (Exception paramFromServiceMsg)
                            {
                              for (;;)
                              {
                                paramFromServiceMsg.printStackTrace();
                                continue;
                                localStringBuffer.append(paramFromServiceMsg);
                                i = 1;
                              }
                              switch (localMessageRecord2.msgtype)
                              {
                              }
                            }
                          }
                        }
                        for (;;)
                        {
                          try
                          {
                            if (!ActionMsgUtil.a(localMessageRecord2.msgtype)) {
                              continue;
                            }
                            localObject2 = ActionMsgUtil.a(localMessageRecord2.msg);
                            paramFromServiceMsg = (FromServiceMsg)paramObject;
                            if (localObject2 != null)
                            {
                              if ((((MsgBody)localObject2).actMsgContentValue == null) || (((MsgBody)localObject2).actMsgContentValue.length() <= 0)) {
                                continue;
                              }
                              paramFromServiceMsg = ((MsgBody)localObject2).actMsgContentValue;
                            }
                          }
                          catch (Exception localException2)
                          {
                            Object localObject2;
                            paramObject = null;
                            localException2.printStackTrace();
                            paramFromServiceMsg = (FromServiceMsg)paramObject;
                            if (!QLog.isColorLevel()) {
                              continue;
                            }
                            QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + localException2.getMessage());
                            paramFromServiceMsg = (FromServiceMsg)paramObject;
                            continue;
                          }
                          paramObject = paramFromServiceMsg;
                          if (paramFromServiceMsg == null) {
                            paramObject = "";
                          }
                          localStringBuffer.append((String)paramObject);
                          break;
                          if (!(localMessageRecord2 instanceof MessageForStructing)) {
                            break label5232;
                          }
                          paramFromServiceMsg = (MessageForStructing)localMessageRecord2;
                          if (paramFromServiceMsg.structingMsg == null) {
                            break label5232;
                          }
                          paramFromServiceMsg = paramFromServiceMsg.structingMsg.mMsgBrief;
                          if (!TextUtils.isEmpty(paramFromServiceMsg)) {
                            break label5229;
                          }
                          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131370628);
                          continue;
                          localObject2 = paramObject;
                          if ((localMessageRecord2 instanceof MessageForBitApp))
                          {
                            paramFromServiceMsg = (MessageForBitApp)localMessageRecord2;
                            localObject2 = paramObject;
                            if (paramFromServiceMsg.bitAppMsg != null) {
                              localObject2 = paramFromServiceMsg.bitAppMsg.mMsgBrief;
                            }
                          }
                          paramFromServiceMsg = (FromServiceMsg)localObject2;
                          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                            continue;
                          }
                          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131361792);
                          continue;
                          if (FlashPicHelper.a(localMessageRecord2))
                          {
                            paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369797);
                          }
                          else
                          {
                            paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369796);
                            continue;
                            localObject2 = localMessageRecord2.msg;
                            paramFromServiceMsg = null;
                            paramObject = paramFromServiceMsg;
                            try
                            {
                              if (!TextUtils.isEmpty((CharSequence)localObject2))
                              {
                                localObject2 = ((String)localObject2).split("/");
                                paramObject = paramFromServiceMsg;
                                if (localObject2 != null)
                                {
                                  paramObject = paramFromServiceMsg;
                                  if (localObject2.length > 0)
                                  {
                                    localObject2 = localObject2[(localObject2.length - 1)].split("\\|");
                                    paramObject = paramFromServiceMsg;
                                    if (localObject2 != null)
                                    {
                                      paramObject = paramFromServiceMsg;
                                      if (localObject2.length > 0) {
                                        paramObject = localObject2[0];
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            catch (Exception paramObject)
                            {
                              ((Exception)paramObject).printStackTrace();
                              paramObject = paramFromServiceMsg;
                              continue;
                              paramFromServiceMsg = (FromServiceMsg)paramObject;
                              if (((String)paramObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369800))) {
                                continue;
                              }
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369800) + (String)paramObject;
                              continue;
                            }
                            if (TextUtils.isEmpty((CharSequence)paramObject))
                            {
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369800);
                            }
                            else
                            {
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369798);
                              continue;
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131370467);
                              continue;
                              paramFromServiceMsg = (MessageForApollo)localMessageRecord2;
                              paramFromServiceMsg = "[动作消息]" + ApolloUtil.a(paramFromServiceMsg);
                              continue;
                              paramFromServiceMsg = (FromServiceMsg)paramObject;
                              if (!(localMessageRecord2 instanceof MessageForPubAccount)) {
                                continue;
                              }
                              if ("2010741172".equals(localMessageRecord1.senderuin)) {
                                bool1 = true;
                              }
                              try
                              {
                                paramObject = ((MessageForPubAccount)localMessageRecord2).mPAMessage;
                                if (paramObject == null)
                                {
                                  paramFromServiceMsg = null;
                                  continue;
                                }
                                paramFromServiceMsg = ((PAMessage.Item)((PAMessage)paramObject).items.get(0)).title;
                                if ((((PAMessage.Item)((PAMessage)paramObject).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)paramObject).items.get(0)).digestList != null))
                                {
                                  paramFromServiceMsg = paramFromServiceMsg + "：" + (String)((PAMessage.Item)((PAMessage)paramObject).items.get(0)).digestList.get(0);
                                  continue;
                                }
                                continue;
                              }
                              catch (Exception paramObject)
                              {
                                paramFromServiceMsg = null;
                                ((Exception)paramObject).printStackTrace();
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + ((Exception)paramObject).getMessage());
                                }
                              }
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppShareIDUtil.a(((MsgBody)localObject2).shareAppID));
                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131370148) + paramFromServiceMsg.messagetail + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131370149);
                              continue;
                              paramFromServiceMsg = (FromServiceMsg)paramObject;
                              if (!ActionMsgUtil.b(localMessageRecord2.msgtype))
                              {
                                paramFromServiceMsg = (FromServiceMsg)paramObject;
                                if (localMessageRecord2.msg != null)
                                {
                                  paramFromServiceMsg = (FromServiceMsg)paramObject;
                                  if (localMessageRecord2.msg.indexOf("http://maps.google.com/maps?q=") != -1)
                                  {
                                    localObject2 = MessageUtils.a(localMessageRecord2.msg);
                                    paramObject = "";
                                    paramFromServiceMsg = (FromServiceMsg)paramObject;
                                    if (localObject2 != null)
                                    {
                                      paramFromServiceMsg = (FromServiceMsg)paramObject;
                                      if (localObject2[2] != null) {
                                        paramFromServiceMsg = localObject2[2];
                                      }
                                    }
                                    paramFromServiceMsg = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368106) + "] " + paramFromServiceMsg;
                                  }
                                }
                              }
                            }
                          }
                        }
                        if ((localList1 != null) && (i == 0))
                        {
                          paramFromServiceMsg = localList1.iterator();
                          while (paramFromServiceMsg.hasNext())
                          {
                            paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                            if (paramObject != null)
                            {
                              paramObject = ((SubAccountMessage)paramObject).frienduin;
                              if ((paramObject != null) && (((String)paramObject).equalsIgnoreCase(String.valueOf(l6)))) {
                                localArrayList.add(String.valueOf(l6));
                              }
                            }
                          }
                        }
                        paramFromServiceMsg = (msg_comm.MsgHead)localMsg.msg_head.get();
                        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.from_nick.has()))
                        {
                          paramFromServiceMsg = paramFromServiceMsg.from_nick.get();
                          if (i != 0) {
                            paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131369140);
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("SUB_ACCOUNT", 2, "sub.account.msg isQQMail=" + bool1);
                          }
                          localSubAccountBackProtocData.jdField_c_of_type_Boolean = true;
                          localObject3 = new SubAccountMessage();
                          if (i != 0)
                          {
                            ((SubAccountMessage)localObject3).frienduin = String.valueOf(AppConstants.aq);
                            if (!bool1) {
                              break label4707;
                            }
                            bool2 = true;
                            ((SubAccountMessage)localObject3).isread = bool2;
                            ((SubAccountMessage)localObject3).msg = localStringBuffer.toString();
                            ((SubAccountMessage)localObject3).extInt = localMessageRecord1.extInt;
                            ((SubAccountMessage)localObject3).extLong = localMessageRecord1.extLong;
                            ((SubAccountMessage)localObject3).extraflag = localMessageRecord1.extraflag;
                            ((SubAccountMessage)localObject3).extStr = localMessageRecord1.extStr;
                            ((SubAccountMessage)localObject3).istroop = localMessageRecord1.istroop;
                            ((SubAccountMessage)localObject3).isValid = localMessageRecord1.isValid;
                            ((SubAccountMessage)localObject3).longMsgCount = localMessageRecord1.longMsgCount;
                            ((SubAccountMessage)localObject3).longMsgId = localMessageRecord1.longMsgId;
                            ((SubAccountMessage)localObject3).longMsgIndex = localMessageRecord1.longMsgIndex;
                            ((SubAccountMessage)localObject3).msgUid = localMessageRecord1.msgUid;
                            ((SubAccountMessage)localObject3).shmsgseq = localMessageRecord1.shmsgseq;
                            ((SubAccountMessage)localObject3).uniseq = localMessageRecord1.uniseq;
                            ((SubAccountMessage)localObject3).msgseq = localMessageRecord1.msgseq;
                            if (!bool1) {
                              break label4713;
                            }
                            i = 0;
                            ((SubAccountMessage)localObject3).unreadNum = i;
                            ((SubAccountMessage)localObject3).msgtype = 64536;
                            ((SubAccountMessage)localObject3).selfuin = String.valueOf(l2);
                            if (paramFromServiceMsg != null)
                            {
                              paramObject = paramFromServiceMsg;
                              if (paramFromServiceMsg.length() != 0) {}
                            }
                            else
                            {
                              paramObject = ((SubAccountMessage)localObject3).frienduin;
                            }
                            ((SubAccountMessage)localObject3).sendername = ((String)paramObject);
                            ((SubAccountMessage)localObject3).senderuin = String.valueOf(l6);
                            ((SubAccountMessage)localObject3).subUin = Long.toString(l3);
                            if (l5 != 0L) {
                              break label4720;
                            }
                          }
                          for (l4 = System.currentTimeMillis() / 1000L;; l4 = l5)
                          {
                            ((SubAccountMessage)localObject3).time = l4;
                            ((SubAccountMessage)localObject3).needNotify = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause;
                            ((SubAccountMessage)localObject3).mTimeString = TimeFormatterUtils.a(1000L * l5, true, SubAccountControll.jdField_c_of_type_JavaLangString);
                            ((SubAccountMessage)localObject3).mEmoRecentMsg = new QQText(((SubAccountMessage)localObject3).msg, 3, 16);
                            if (localSubAccountManager != null) {
                              localSubAccountManager.a((SubAccountMessage)localObject3);
                            }
                            if (QLog.isColorLevel())
                            {
                              QLog.d("SUB_ACCOUNT", 2, "subaccount set msg read false hasData = false  unreadNum=" + ((SubAccountMessage)localObject3).unreadNum);
                              if (!TextUtils.isEmpty(((SubAccountMessage)localObject3).msg)) {
                                QLog.d("SUB_ACCOUNT", 2, "msg=" + ((SubAccountMessage)localObject3).msg.charAt(0));
                              }
                            }
                            SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 6);
                            localSubAccountBackProtocData.d = true;
                            paramFromServiceMsg = MessageRecordFactory.a(localMessageRecord1.msgtype);
                            MessageRecord.copyMessageRecordBaseField(paramFromServiceMsg, localMessageRecord1);
                            paramFromServiceMsg.istroop = 7000;
                            paramFromServiceMsg.frienduin = str1;
                            i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop);
                            i = 0;
                            if (localSubAccountManager != null) {
                              i = localSubAccountManager.d(str1);
                            }
                            int i2 = i - i1;
                            if (i2 != 0) {
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop, i2);
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("SUB_ACCOUNT", 2, "sub.account.msg conversion subUin=" + str1 + " target=" + i + " old=" + i1 + " increase=" + i2);
                            }
                            paramObject = new ArrayList();
                            ((ArrayList)paramObject).add(paramFromServiceMsg);
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ArrayList)paramObject, str2, false, false, true);
                            if (bool1) {
                              break label1894;
                            }
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((ArrayList)paramObject).size(), true, true);
                            break label1894;
                            break;
                            ((SubAccountMessage)localObject3).frienduin = String.valueOf(l6);
                            break label4064;
                            bool2 = false;
                            break label4072;
                            i = n;
                            break label4227;
                          }
                        }
                      }
                      else
                      {
                        if ((localList1 != null) && (localList1.size() > 0) && (k != 0))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("SUB_ACCOUNT", 2, "handleGetSubC2CMessageResp_PB dbSubMsgList......");
                          }
                          i = 0;
                          if (i < localList1.size())
                          {
                            paramFromServiceMsg = (SubAccountMessage)localList1.get(i);
                            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.frienduin == null)) {}
                            for (;;)
                            {
                              i += 1;
                              break;
                              if (!paramFromServiceMsg.frienduin.equals(String.valueOf(AppConstants.aq)))
                              {
                                m = 0;
                                paramObject = localArrayList.iterator();
                                do
                                {
                                  k = m;
                                  if (!((Iterator)paramObject).hasNext()) {
                                    break;
                                  }
                                  localObject3 = (String)((Iterator)paramObject).next();
                                } while ((localObject3 == null) || (!paramFromServiceMsg.frienduin.equalsIgnoreCase((String)localObject3)));
                                k = 1;
                                if ((k != 0) && (localHashMap.containsKey(paramFromServiceMsg.frienduin))) {
                                  localSubAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l3), paramFromServiceMsg.frienduin, ((Integer)localHashMap.get(paramFromServiceMsg.frienduin)).intValue());
                                }
                                if ((k == 0) && (localSubAccountManager != null))
                                {
                                  k = localSubAccountManager.a(String.valueOf(l3), paramFromServiceMsg.frienduin);
                                  if (k != 0)
                                  {
                                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, 7000, k);
                                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.ah, str1 });
                                  }
                                }
                              }
                            }
                          }
                        }
                        if (QLog.isColorLevel())
                        {
                          if (arrayOfByte == null) {
                            break label5160;
                          }
                          QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = ");
                        }
                        for (;;)
                        {
                          if (localSubAccountManager != null) {
                            localSubAccountManager.a(str1, arrayOfByte);
                          }
                          paramFromServiceMsg = new HashMap();
                          paramFromServiceMsg.put("param_FailCode", "12016");
                          paramFromServiceMsg.put("fail_step", "success");
                          paramFromServiceMsg.put("fail_location", "MessageHandler");
                          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", true, 0L, 0L, paramFromServiceMsg, "");
                          if (b <= 0) {
                            break label5188;
                          }
                          if (l3 <= 0L) {
                            break;
                          }
                          paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
                          if (paramToServiceMsg == null) {
                            break label5188;
                          }
                          a(b, j, String.valueOf(l3), paramToServiceMsg, localArrayList);
                          localSubAccountBackProtocData.jdField_a_of_type_Boolean = false;
                          a(8003, true, localSubAccountBackProtocData);
                          return;
                          QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = null");
                        }
                        if (QLog.isColorLevel()) {
                          QLog.e("Q.msg.C2CMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB error happen, binduin <= 0 from server");
                        }
                        localSubAccountBackProtocData.p = 0;
                        a(8003, true, localSubAccountBackProtocData);
                        if (!QLog.isColorLevel()) {
                          break;
                        }
                        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB end");
                        return;
                      }
                    }
                  }
                }
                k = 1;
                b = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() start, subUin=" + paramString1);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.PbBindUinGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt);
    localToServiceMsg.extraData.putBoolean("isSubAccount", true);
    localToServiceMsg.extraData.putString("subAccount", paramString1);
    localToServiceMsg.extraData.putString("subaccount_a2", paramString2);
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localToServiceMsg.extraData.putStringArrayList("hadGetMsgListUin", paramArrayList);
    }
    paramArrayList = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if (paramArrayList != null) {}
    for (paramArrayList = paramArrayList.a(paramString1);; paramArrayList = null)
    {
      msg_svc.PbBindUinGetMsgReq localPbBindUinGetMsgReq = new msg_svc.PbBindUinGetMsgReq();
      if (paramString1 != null) {}
      try
      {
        localPbBindUinGetMsgReq.bind_uin.set(Long.parseLong(paramString1));
        if (paramString2 == null) {}
      }
      catch (Exception paramString1)
      {
        try
        {
          do
          {
            localPbBindUinGetMsgReq.bind_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.a(paramString2)));
            if (paramArrayList == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie=" + paramArrayList.length);
            }
            localPbBindUinGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
            localPbBindUinGetMsgReq.sync_flag.set(paramInt);
            localToServiceMsg.putWupBuffer(localPbBindUinGetMsgReq.toByteArray());
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.e("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() subAccount is null or not a long");
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie = null");
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.b = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.p = 1001;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(RequestPushNotify paramRequestPushNotify)
  {
    Object localObject = paramRequestPushNotify.stMsgInfo;
    if (528 == ((MsgInfo)localObject).shMsgType)
    {
      localObject = GameCenterPackeger.a(((MsgInfo)localObject).vMsg);
      if ((localObject != null) && (((MsgType0x210)localObject).vProtobuf != null)) {
        break label35;
      }
    }
    label35:
    do
    {
      do
      {
        return;
      } while ((((MsgType0x210)localObject).uSubMsgType != 138L) && (((MsgType0x210)localObject).uSubMsgType != 139L));
      Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
      try
      {
        localReqBody.mergeFrom(((MsgType0x210)localObject).vProtobuf);
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localReqBody, paramRequestPushNotify.lBindedUin, true);
        return;
      }
      catch (Exception paramRequestPushNotify) {}
    } while (!QLog.isColorLevel());
    QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b sub account msg, prase reqBody error");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() subAccount=" + paramString1);
    }
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (l <= 10000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() return, lSubUin=" + l);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l = 0L;
      }
      localObject = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if (localObject == null) {}
    }
    for (Object localObject = ((SubAccountManager)localObject).a(paramString1);; localObject = null)
    {
      ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("PbMessageSvc.PbBindUinMsgReadedConfirm");
      localToServiceMsg.extraData.putBoolean("isSubAccount", true);
      localToServiceMsg.extraData.putString("subAccount", paramString1);
      localToServiceMsg.extraData.putString("nextAction", paramString2);
      paramString1 = new msg_svc.PbBindUinMsgReadedConfirmReq();
      paramString1.bind_uin.set(l);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  syncCookie=" + Integer.toString(localObject.length));
        }
        paramString1.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      for (;;)
      {
        localToServiceMsg.putWupBuffer(paramString1.toByteArray());
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  cookie = null");
        }
      }
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.b = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.p = 1007;
    a(8003, false, paramFromServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\SubAccountMessageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */