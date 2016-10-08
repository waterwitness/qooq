package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.NotifyList;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqExit;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqGetList;
import tencent.im.nearfield_discuss.nearfield_discuss.ReqJoinDiscuss;
import tencent.im.nearfield_discuss.nearfield_discuss.RespGetList;
import tencent.im.nearfield_discuss.nearfield_discuss.RespJoinDiscuss;

public class NearFieldDiscussHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = NearFieldDiscussHandler.class.getSimpleName();
  byte[] jdField_a_of_type_ArrayOfByte;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  NearFieldDiscussHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(64532);
    localMessageRecord.init(paramLong1, paramLong2, paramLong1, paramString, NetConnInfoCenter.getServerTime(), 64532, 3000, NetConnInfoCenter.getServerTime());
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addMsgToDB msgType: -1004 friendType: 3000 msgContent: " + Utils.a(paramString));
    }
    if (!MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "<<---handleError serviceCmd:" + str);
    }
    if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(str)) {
      d(paramToServiceMsg, paramFromServiceMsg);
    }
    while (!"NearFieldDiscussSvr.ReqGetList".equals(str)) {
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("NearFieldDiscussSvr.ReqJoinDiscuss".equals(str)) {
      e(paramToServiceMsg, paramFromServiceMsg);
    }
    while (!"NearFieldDiscussSvr.ReqGetList".equals(str)) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1021, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetFaceToFaceDiscussInfo");
      }
      if (!bool1) {
        break label530;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new nearfield_discuss.RespJoinDiscuss();
        ((nearfield_discuss.RespJoinDiscuss)localObject).mergeFrom((byte[])paramObject);
        if (((nearfield_discuss.BusiRespHead)((nearfield_discuss.RespJoinDiscuss)localObject).msg_head.get()).int32_reply_code.get() == 0)
        {
          bool1 = true;
          if (!bool1) {
            continue;
          }
          j = ((nearfield_discuss.RespJoinDiscuss)localObject).uint32_discuss_id.get();
          ((DiscussionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(j);
          paramFromServiceMsg = String.valueOf(j);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          bool2 = ((nearfield_discuss.RespJoinDiscuss)localObject).bool_is_creater.get();
          i = ((nearfield_discuss.RespJoinDiscuss)localObject).uint32_session_id.get();
          if (!bool2) {}
        }
        catch (Exception paramObject)
        {
          Object localObject;
          boolean bool2;
          i = -1;
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          continue;
        }
        try
        {
          paramToServiceMsg = paramToServiceMsg.extraData.getString("FACE_TO_FACE_ID");
          paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371325, new Object[] { paramToServiceMsg });
          a(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()), j, paramToServiceMsg);
          if (bool2)
          {
            paramToServiceMsg = MessageRecordFactory.a(64520);
            long l = MessageCache.a();
            paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131370172);
            localObject = (String)paramObject + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131370168);
            paramToServiceMsg.init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(j), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject, l, 64520, 3000, l);
            paramToServiceMsg.isread = true;
            paramToServiceMsg.extStr = ((String)paramObject);
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramToServiceMsg, paramToServiceMsg.selfuin);
          }
          paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          if (paramToServiceMsg.b(paramFromServiceMsg, 3000) != null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetFaceToFaceDiscussInfo ru alreadyintab");
            paramToServiceMsg = paramFromServiceMsg;
            paramObject = paramToServiceMsg;
            j = i;
            a(1020, bool1, new Object[] { Integer.valueOf(j), paramObject });
            return;
            bool1 = false;
            break;
            bool1 = false;
            continue;
          }
          paramObject = paramToServiceMsg.a(paramFromServiceMsg, 3000);
          RecentUtil.a((RecentUser)paramObject, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ((RecentUser)paramObject).uin = paramFromServiceMsg;
          ((RecentUser)paramObject).lastmsgtime = MessageCache.a();
          ((RecentUser)paramObject).type = 3000;
          paramToServiceMsg.a((RecentUser)paramObject);
          paramToServiceMsg = paramFromServiceMsg;
          continue;
          paramFromServiceMsg = paramFromServiceMsg;
          i = -1;
          paramToServiceMsg = "";
        }
        catch (Exception paramObject)
        {
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          continue;
        }
        bool2 = false;
        j = i;
        paramObject = paramToServiceMsg;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetFaceToFaceDiscussInfo exp", paramFromServiceMsg);
        j = i;
        paramObject = paramToServiceMsg;
        bool1 = bool2;
        continue;
        int i = -1;
        paramToServiceMsg = "";
        continue;
      }
      label530:
      paramObject = "";
      int j = -1;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1020, false, new Object[] { Integer.valueOf(paramToServiceMsg.extraData.getInt("session_id")) });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNotifyPush");
    }
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    }
    for (;;)
    {
      j = -1;
      i = j;
      bool2 = bool1;
      if (bool1) {}
      for (;;)
      {
        try
        {
          paramToServiceMsg = new nearfield_discuss.NotifyList();
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNotifyPush exp", paramToServiceMsg);
          bool2 = false;
          i = j;
          continue;
        }
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          i = paramToServiceMsg.uint32_session_id.get();
          bool2 = bool1;
          a(1022, bool2, new Object[] { Integer.valueOf(i) });
          return;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          bool1 = false;
        }
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      a(paramToServiceMsg);
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg);
  }
  
  protected Class a()
  {
    return NearFieldDiscussObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() == 1002)
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("NearFieldDiscussSvr.ReqJoinDiscuss".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NearFieldDiscussSvr.ReqGetList".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"NearFieldDiscussSvr.ReqExit".equalsIgnoreCase(str));
  }
  
  public void a(String paramString, int paramInt, nearfield_discuss.LBSInfo paramLBSInfo)
  {
    ToServiceMsg localToServiceMsg = a("NearFieldDiscussSvr.ReqExit");
    nearfield_discuss.ReqExit localReqExit = new nearfield_discuss.ReqExit();
    if (paramLBSInfo != null) {
      localReqExit.msg_lbs_info.set(paramLBSInfo);
    }
    localReqExit.str_number.set(paramString);
    localReqExit.uint32_session_id.set(paramInt);
    localToServiceMsg.putWupBuffer(localReqExit.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, nearfield_discuss.LBSInfo paramLBSInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "get list | sessionId = " + paramInt + " | digits = " + paramString);
    }
    ToServiceMsg localToServiceMsg = a("NearFieldDiscussSvr.ReqGetList");
    nearfield_discuss.ReqGetList localReqGetList = new nearfield_discuss.ReqGetList();
    if (paramLBSInfo != null) {
      localReqGetList.msg_lbs_info.set(paramLBSInfo);
    }
    localReqGetList.str_number.set(paramString);
    localReqGetList.uint32_session_id.set(paramInt);
    if ((!paramBoolean) && (this.jdField_a_of_type_ArrayOfByte != null)) {
      localReqGetList.bytes_cookie.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    }
    localToServiceMsg.putWupBuffer(localReqGetList.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("NearFieldDiscussSvr.ReqJoinDiscuss");
      this.jdField_b_of_type_JavaUtilSet.add("NearFieldDiscussSvr.ReqGetList");
      this.jdField_b_of_type_JavaUtilSet.add("NearFieldDiscussSvr.ReqExit");
      this.jdField_b_of_type_JavaUtilSet.add("NearFieldDiscussSvr.NotifyList");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = bool1;
      if (!bool1) {
        break label252;
      }
      paramToServiceMsg = new nearfield_discuss.RespGetList();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (bool1))
        {
          paramFromServiceMsg = (FromServiceMsg)localObject;
          if (paramToServiceMsg.rpt_msg_user_list.has()) {
            paramFromServiceMsg = paramToServiceMsg.rpt_msg_user_list.get();
          }
          int i = 60000;
          if (paramToServiceMsg.int32_update_interval.has()) {
            i = paramToServiceMsg.int32_update_interval.get();
          }
          if (paramToServiceMsg.bytes_cookie.has()) {
            this.jdField_a_of_type_ArrayOfByte = paramToServiceMsg.bytes_cookie.get().toByteArray();
          }
          if (!paramToServiceMsg.uint32_session_id.has()) {
            break label263;
          }
          j = paramToServiceMsg.uint32_session_id.get();
          paramObject = new nearfield_discuss.BusiRespHead();
          if (paramToServiceMsg.msg_head.has())
          {
            ((nearfield_discuss.BusiRespHead)paramObject).int32_reply_code.set(paramToServiceMsg.msg_head.int32_reply_code.get());
            ((nearfield_discuss.BusiRespHead)paramObject).str_result.set(paramToServiceMsg.msg_head.str_result.get());
          }
          a(1021, bool1, new Object[] { paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j), paramObject });
          return;
          bool1 = false;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = false;
        paramToServiceMsg = null;
        continue;
        bool2 = bool1;
      }
      label252:
      a(1021, bool2, null);
      return;
      label263:
      int j = 0;
    }
  }
  
  public void b(String paramString, int paramInt, nearfield_discuss.LBSInfo paramLBSInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getNearFieldDiscussInfo hallId=" + paramString + " sessionId=" + paramInt);
    }
    nearfield_discuss.ReqJoinDiscuss localReqJoinDiscuss = new nearfield_discuss.ReqJoinDiscuss();
    localReqJoinDiscuss.str_number.set(paramString);
    if (paramLBSInfo != null) {
      localReqJoinDiscuss.msg_lbs_info.set(paramLBSInfo);
    }
    localReqJoinDiscuss.uint32_session_id.set(paramInt);
    paramLBSInfo = a("NearFieldDiscussSvr.ReqJoinDiscuss");
    paramLBSInfo.extraData.putString("FACE_TO_FACE_ID", paramString);
    paramLBSInfo.extraData.putInt("session_id", paramInt);
    paramLBSInfo.putWupBuffer(localReqJoinDiscuss.toByteArray());
    paramLBSInfo.setTimeout(30000L);
    b(paramLBSInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearFieldDiscussHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */