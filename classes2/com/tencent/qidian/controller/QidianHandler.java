package com.tencent.qidian.controller;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.proto.mobileqq_qidian.CRMMsgHead;
import com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagReq;
import com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagRsp;
import com.tencent.qidian.proto.mobileqq_qidian.ClickReplyCmdActionReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetUserDetailInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.ReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.RspBody;
import com.tencent.qidian.proto.mobileqq_qidian.VerifyWpaUinAndKeyReq;
import com.tencent.qidian.proto.mobileqq_qidian.VerifyWpaUinAndKeyRsp;
import com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QidianHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "key_ext_uin";
  public static final int b = 1;
  public static final String b = "key_sigt";
  public static final int c = 2;
  private static final String c = QidianHandler.class.getName();
  public static final int d = 3;
  public static final int e = 1001;
  public static final int f = 1002;
  public static final int g = 1003;
  public static final int h = 1004;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QidianHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private mobileqq_qidian.CRMMsgHead a(String paramString1, int paramInt, String paramString2)
  {
    mobileqq_qidian.CRMMsgHead localCRMMsgHead = new mobileqq_qidian.CRMMsgHead();
    localCRMMsgHead.uint32_crm_sub_cmd.set(paramInt);
    localCRMMsgHead.uint32_crm_sub_cmd.setHasFlag(true);
    long l;
    if (!TextUtils.isEmpty(paramString1))
    {
      l = Long.valueOf(paramString1).longValue();
      localCRMMsgHead.uint64_kf_uin.set(l);
      localCRMMsgHead.uint64_kf_uin.setHasFlag(true);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      l = Long.valueOf(paramString2).longValue();
      localCRMMsgHead.uint64_ext_uin.set(l);
      localCRMMsgHead.uint64_ext_uin.setHasFlag(true);
    }
    return localCRMMsgHead;
  }
  
  private mobileqq_qidian.ReqBody a(String paramString1, int paramInt, String paramString2)
  {
    mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
    paramString1 = a(paramString1, paramInt, paramString2);
    localReqBody.msg_crm_common_head.set(paramString1);
    localReqBody.msg_crm_common_head.setHasFlag(true);
    localReqBody.uint32_sub_cmd.set(paramInt);
    localReqBody.uint32_sub_cmd.setHasFlag(true);
    return localReqBody;
  }
  
  private void a(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    ((QidianManager)this.a.getManager(164)).a(paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo);
  }
  
  private void a(mobileqq_qidian.ReqBody paramReqBody, String paramString, Map paramMap)
  {
    ToServiceMsg localToServiceMsg = super.a(paramString);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localToServiceMsg.extraData.putString(str, (String)paramMap.get(str));
      }
    }
    localToServiceMsg.putWupBuffer(paramReqBody.toByteArray());
    super.b(localToServiceMsg);
    paramReqBody = com.tencent.mobileqq.app.AppConstants.b[NetworkUtil.a(this.a.a().getBaseContext())];
    ReportController.b(this.b, "P_CliOper", "Qidian", "", paramString, paramString, 0, 0, "", "", paramReqBody, "");
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    String str = com.tencent.mobileqq.app.AppConstants.b[NetworkUtil.a(this.a.a().getBaseContext())];
    long l = paramToServiceMsg.extraData.getLong("startTime");
    l = System.currentTimeMillis() - l;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label167;
      }
      ReportController.b(this.b, "P_CliOper", "Qidian", "", paramString + "_success", paramString + "_success", 0, 0, String.valueOf((int)l), "", str, "");
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "handleAssignExt success, delta is " + l);
      }
    }
    label167:
    do
    {
      return bool;
      bool = false;
      break;
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      ReportController.b(this.b, "P_CliOper", "Qidian", "", paramString + "_fail", paramString + "_fail", 0, 0, String.valueOf((int)l), "", str, paramToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d(c, 2, "handleGetAccountType failed, fail message: " + paramToServiceMsg);
    return bool;
  }
  
  protected Class a()
  {
    return QidianBusinessObserver.class;
  }
  
  public void a(long paramLong)
  {
    new StringBuilder().append("QidianSsoProto.getUserDetailInfo").append(paramLong).toString();
    mobileqq_qidian.ReqBody localReqBody = a("", 4, String.valueOf(paramLong));
    Object localObject = new mobileqq_qidian.GetUserDetailInfoReqBody();
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_req_type.set(2);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint64_uin.set(paramLong);
    localReqBody.msg_get_user_detail_info_req.set((MessageMicro)localObject);
    localReqBody.msg_get_user_detail_info_req.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("uin", String.valueOf(paramLong));
    ((Map)localObject).put("reqType", String.valueOf(2));
    a(localReqBody, "QidianSsoProto.getUserDetailInfo", (Map)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "onReceive cmd: " + str);
    }
    if (str.equalsIgnoreCase("QidianSsoProto.WpaAssignKfext")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (str.equalsIgnoreCase("QidianSsoProto.clickReplyCmd"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.getUserDetailInfo"))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.verifyWpaAndKey"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!str.equalsIgnoreCase("QidianSsoProto.getShieldStatus"));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject = this.b.a();
    byte[] arrayOfByte = ((MessageCache)localObject).d(paramString);
    localObject = ((MessageCache)localObject).e(paramString);
    int i;
    if ((arrayOfByte != null) && (localObject != null)) {
      i = 3;
    }
    for (;;)
    {
      int j = 0;
      if (((QidianManager)this.b.getManager(164)).a(paramString)) {
        j = 4;
      }
      ReportController.b(this.b, "dc00899", "Qidian", paramString, "0X8006DEC", "SigCheck", j, 2, "" + paramInt, "" + i, "" + paramLong, "" + NetworkUtil.a(this.b.a()));
      return;
      if (arrayOfByte != null) {
        i = 2;
      } else if (localObject != null) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void a(String paramString1, int paramInt, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2)
  {
    paramString2 = a(paramString2, 3, "");
    mobileqq_qidian.ClickReplyCmdActionReqBody localClickReplyCmdActionReqBody = new mobileqq_qidian.ClickReplyCmdActionReqBody();
    localClickReplyCmdActionReqBody.str_key.set(paramString1);
    localClickReplyCmdActionReqBody.uint32_type.set(paramInt);
    if (paramBoolean)
    {
      localClickReplyCmdActionReqBody.bool_is_need_lbs.set(paramBoolean);
      localClickReplyCmdActionReqBody.double_latitude.set(paramDouble1);
      localClickReplyCmdActionReqBody.double_longitude.set(paramDouble2);
    }
    paramString2.msg_click_reply_cmd_action_req.set(localClickReplyCmdActionReqBody);
    paramString2.msg_click_reply_cmd_action_req.setHasFlag(true);
    a(paramString2, "QidianSsoProto.clickReplyCmd", null);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = this.b.a();
    byte[] arrayOfByte = ((MessageCache)localObject).d(paramString);
    localObject = ((MessageCache)localObject).e(paramString);
    int i;
    if ((arrayOfByte != null) && (localObject != null))
    {
      i = 3;
      if (!((QidianManager)this.b.getManager(164)).a(paramString)) {
        break label181;
      }
    }
    label181:
    for (int j = 4;; j = 0)
    {
      ReportController.b(this.b, "dc00899", "Qidian", paramString, "0X8006DEC", "SigCheck", j, 1, "", "" + i, "" + paramLong, "" + NetworkUtil.a(this.b.a()));
      return;
      if (arrayOfByte != null)
      {
        i = 2;
        break;
      }
      if (localObject != null)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2, 1003, null);
    mobileqq_qidian.CheckMpqqRefuseFlagReq localCheckMpqqRefuseFlagReq = new mobileqq_qidian.CheckMpqqRefuseFlagReq();
    localCheckMpqqRefuseFlagReq.uin64_mpqq_uin.set(Long.parseLong(paramString1));
    localCheckMpqqRefuseFlagReq.uint64_qq_uin.set(this.b.getLongAccountUin());
    paramString2.msg_check_mpqq_refuse_flag_req.set(localCheckMpqqRefuseFlagReq);
    paramString2.msg_check_mpqq_refuse_flag_req.setHasFlag(true);
    a(paramString2, "QidianSsoProto.getShieldStatus", null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
    paramString1 = a(paramString1, 1, "");
    localReqBody.msg_crm_common_head.set(paramString1);
    localReqBody.msg_crm_common_head.setHasFlag(true);
    paramString1 = new mobileqq_qidian.WpaAssignKfextReqBody();
    paramString1.uint32_wpa_type.set(Integer.valueOf(paramString2).intValue());
    paramString1.uint32_wpa_type.setHasFlag(true);
    paramString2 = HexUtil.a(paramString3);
    paramString1.bytes_sigT_kf.set(ByteStringMicro.copyFrom(paramString2));
    paramString1.bytes_sigT_kf.setHasFlag(true);
    paramString1.uint64_assign_id.set(Long.valueOf(paramString4).longValue());
    paramString1.uint64_assign_id.setHasFlag(true);
    paramString1.uint64_customer_uin.set(Long.valueOf(this.b.a()).longValue());
    paramString1.uint64_customer_uin.setHasFlag(true);
    localReqBody.msg_wpa_assign_kfext_req.set(paramString1);
    localReqBody.msg_wpa_assign_kfext_req.setHasFlag(true);
    paramString1 = super.a("QidianSsoProto.WpaAssignKfext");
    paramString1.extraData.putLong("startTime", System.currentTimeMillis());
    paramString1.putWupBuffer(localReqBody.toByteArray());
    super.b(paramString1);
    paramString1 = com.tencent.mobileqq.app.AppConstants.b[NetworkUtil.a(this.a.a().getBaseContext())];
    ReportController.b(this.b, "P_CliOper", "Qidian", "", "qidian_wpa_assign", "qidian_wpa_assign", 0, 0, "", "", paramString1, "");
  }
  
  public void b(long paramLong)
  {
    new StringBuilder().append("QidianSsoProto.getUserDetailInfo").append(paramLong).toString();
    mobileqq_qidian.ReqBody localReqBody = a("", 4, String.valueOf(paramLong));
    Object localObject = new mobileqq_qidian.GetUserDetailInfoReqBody();
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_req_type.set(3);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint64_uin.set(paramLong);
    localReqBody.msg_get_user_detail_info_req.set((MessageMicro)localObject);
    localReqBody.msg_get_user_detail_info_req.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("uin", String.valueOf(paramLong));
    ((Map)localObject).put("reqType", String.valueOf(3));
    a(localReqBody, "QidianSsoProto.getUserDetailInfo", (Map)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject, "qidian_wpa_assign");
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          break label210;
        }
        i = 1;
        if (i == 0) {
          break label200;
        }
        paramToServiceMsg = new mobileqq_qidian.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_wpa_assign_kfext_rsp.has())
        {
          if (paramToServiceMsg.msg_wpa_assign_kfext_rsp.int32_result.get() != 0) {
            break label216;
          }
          i = j;
          if (i != 0)
          {
            long l = paramToServiceMsg.msg_wpa_assign_kfext_rsp.uint64_ext_uin.get();
            paramToServiceMsg = HexUtil.a(paramToServiceMsg.msg_wpa_assign_kfext_rsp.bytes_sigT_ext.get().toByteArray());
            paramFromServiceMsg = new HashMap();
            paramFromServiceMsg.put("key_ext_uin", String.valueOf(l));
            paramFromServiceMsg.put("key_sigt", paramToServiceMsg);
            a(1004, true, paramFromServiceMsg);
            return;
          }
          a(1004, false, null);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "handleAssignExt ", paramToServiceMsg);
        }
        a(1004, false, null);
        return;
      }
      a(1004, false, null);
      return;
      label200:
      a(1004, false, null);
      return;
      label210:
      int i = 0;
      continue;
      label216:
      i = 0;
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = a(paramString2, 1002, null);
    mobileqq_qidian.VerifyWpaUinAndKeyReq localVerifyWpaUinAndKeyReq = new mobileqq_qidian.VerifyWpaUinAndKeyReq();
    localVerifyWpaUinAndKeyReq.str_key.set(paramString3);
    localVerifyWpaUinAndKeyReq.uint64_dst_uin.set(Long.parseLong(paramString1));
    if (paramString4 != null) {
      localVerifyWpaUinAndKeyReq.str_json_info.set(paramString4);
    }
    paramString2.msg_verify_wpa_uin_and_key_req.set(localVerifyWpaUinAndKeyReq);
    paramString2.msg_verify_wpa_uin_and_key_req.setHasFlag(true);
    a(paramString2, "QidianSsoProto.verifyWpaAndKey", null);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.clickReplyCmd");
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.verifyWpaAndKey");
    if (bool2) {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_verify_wpa_uin_and_key_rsp.has())
        {
          paramToServiceMsg = (mobileqq_qidian.VerifyWpaUinAndKeyRsp)paramToServiceMsg.msg_verify_wpa_uin_and_key_rsp.get();
          if (paramToServiceMsg.int32_result.get() != 0) {
            break label303;
          }
          bool1 = true;
          if (bool1)
          {
            paramFromServiceMsg = new HashMap();
            paramObject = paramToServiceMsg.str_welcome_word.get();
            int i = paramToServiceMsg.uint32_is_valid.get();
            paramFromServiceMsg.put("welcome", paramObject);
            paramFromServiceMsg.put("result", Integer.valueOf(i));
            super.a(1002, bool2, paramFromServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, "handleVerifyWpaAndKey uint32_ret_code: " + bool1);
          }
          super.a(1002, bool2, null);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "handleVerifyWpaAndKey exception: " + paramToServiceMsg.getMessage());
        }
        super.a(1002, bool2, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "handleVerifyWpaAndKey no msg_verify_wpa_uin_and_key_rsp");
      }
      super.a(1002, bool2, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "handleVerifyWpaAndKey isSuccess: " + bool2);
      }
      super.a(1002, bool2, null);
      return;
      label303:
      boolean bool1 = false;
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.getShieldStatus");
    if (bool2) {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_check_mpqq_refuse_flag_rsp.has())
        {
          paramToServiceMsg = (mobileqq_qidian.CheckMpqqRefuseFlagRsp)paramToServiceMsg.msg_check_mpqq_refuse_flag_rsp.get();
          if (paramToServiceMsg.int32_result.get() != 0) {
            break label290;
          }
          bool1 = true;
          if (bool1)
          {
            paramFromServiceMsg = new HashMap();
            if (paramToServiceMsg.uint32_is_refuse.get() != 1) {
              break label296;
            }
            bool1 = true;
            paramFromServiceMsg.put("result", Boolean.valueOf(bool1));
            super.a(1003, true, paramFromServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, "handleGetShieldStatus uint32_ret_code: " + bool1);
          }
          super.a(1003, bool2, null);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "handleGetShieldStatus exception: " + paramToServiceMsg.getMessage());
        }
        super.a(1003, bool2, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "handleGetShieldStatus no msg_verify_wpa_uin_and_key_rsp");
      }
      super.a(1003, bool2, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "handleGetShieldStatus isSuccess: " + bool2);
      }
      super.a(1003, bool2, null);
      return;
      label290:
      boolean bool1 = false;
      continue;
      label296:
      bool1 = false;
    }
  }
  
  /* Error */
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: ldc_w 275
    //   7: invokespecial 485	com/tencent/qidian/controller/QidianHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;Ljava/lang/String;)Z
    //   10: istore 13
    //   12: aload_1
    //   13: getfield 136	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 304
    //   19: invokevirtual 624	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: iload 13
    //   25: ifeq +659 -> 684
    //   28: new 487	com/tencent/qidian/proto/mobileqq_qidian$RspBody
    //   31: dup
    //   32: invokespecial 488	com/tencent/qidian/proto/mobileqq_qidian$RspBody:<init>	()V
    //   35: astore 4
    //   37: aload 4
    //   39: aload_3
    //   40: checkcast 490	[B
    //   43: checkcast 490	[B
    //   46: invokevirtual 494	com/tencent/qidian/proto/mobileqq_qidian$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   49: pop
    //   50: new 300	java/util/HashMap
    //   53: dup
    //   54: invokespecial 525	java/util/HashMap:<init>	()V
    //   57: astore 7
    //   59: aload 4
    //   61: getfield 628	com/tencent/qidian/proto/mobileqq_qidian$RspBody:msg_subcmd_get_user_detail_info_rsp_body	Lcom/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody;
    //   64: invokevirtual 631	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:has	()Z
    //   67: ifeq +590 -> 657
    //   70: aload 4
    //   72: getfield 628	com/tencent/qidian/proto/mobileqq_qidian$RspBody:msg_subcmd_get_user_detail_info_rsp_body	Lcom/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody;
    //   75: invokevirtual 632	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: checkcast 630	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody
    //   81: astore 8
    //   83: aload 8
    //   85: getfield 636	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_ret	Lcom/tencent/qidian/proto/mobileqq_qidian$RetInfo;
    //   88: getfield 641	com/tencent/qidian/proto/mobileqq_qidian$RetInfo:uint32_ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   91: invokevirtual 570	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   94: ifne +655 -> 749
    //   97: iconst_1
    //   98: istore 12
    //   100: iload 12
    //   102: ifeq +510 -> 612
    //   105: aload_1
    //   106: getfield 136	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   109: ldc_w 310
    //   112: invokevirtual 624	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_1
    //   116: aload_1
    //   117: invokestatic 645	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore 11
    //   122: aload 8
    //   124: getfield 649	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_external_info	Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;
    //   127: invokevirtual 652	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo:has	()Z
    //   130: ifeq +610 -> 740
    //   133: new 654	com/tencent/qidian/data/QidianExternalInfo
    //   136: dup
    //   137: invokespecial 655	com/tencent/qidian/data/QidianExternalInfo:<init>	()V
    //   140: astore_1
    //   141: aload_1
    //   142: aload 8
    //   144: getfield 649	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_external_info	Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;
    //   147: invokevirtual 656	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 651	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo
    //   153: invokevirtual 660	com/tencent/qidian/data/QidianExternalInfo:from	(Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;)V
    //   156: aload 7
    //   158: ldc_w 662
    //   161: aload_1
    //   162: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: aload_1
    //   167: getfield 664	com/tencent/qidian/data/QidianExternalInfo:uin	Ljava/lang/String;
    //   170: astore_2
    //   171: aload_2
    //   172: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +570 -> 745
    //   178: aload_0
    //   179: getfield 116	com/tencent/qidian/controller/QidianHandler:a	Lcom/tencent/common/app/AppInterface;
    //   182: sipush 164
    //   185: invokevirtual 122	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   188: checkcast 124	com/tencent/qidian/QidianManager
    //   191: new 666	com/tencent/qidian/data/BmqqAccountType
    //   194: dup
    //   195: aload_2
    //   196: invokestatic 669	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: iconst_1
    //   200: invokespecial 672	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   203: invokevirtual 675	com/tencent/qidian/QidianManager:a	(Lcom/tencent/qidian/data/BmqqAccountType;)V
    //   206: goto +539 -> 745
    //   209: aload 8
    //   211: getfield 679	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_internal_info	Lcom/tencent/qidian/proto/mobileqq_qidian$InternalInfo;
    //   214: invokevirtual 682	com/tencent/qidian/proto/mobileqq_qidian$InternalInfo:has	()Z
    //   217: ifeq +518 -> 735
    //   220: new 684	com/tencent/qidian/data/QidianInternalInfo
    //   223: dup
    //   224: invokespecial 685	com/tencent/qidian/data/QidianInternalInfo:<init>	()V
    //   227: astore_3
    //   228: aload_3
    //   229: aload 8
    //   231: getfield 679	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_internal_info	Lcom/tencent/qidian/proto/mobileqq_qidian$InternalInfo;
    //   234: invokevirtual 686	com/tencent/qidian/proto/mobileqq_qidian$InternalInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   237: checkcast 681	com/tencent/qidian/proto/mobileqq_qidian$InternalInfo
    //   240: invokevirtual 689	com/tencent/qidian/data/QidianInternalInfo:from	(Lcom/tencent/qidian/proto/mobileqq_qidian$InternalInfo;)V
    //   243: aload 7
    //   245: ldc_w 691
    //   248: aload_3
    //   249: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: aload 8
    //   255: getfield 695	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_corp_info	Lcom/tencent/qidian/proto/mobileqq_qidian$CorpInfo;
    //   258: invokevirtual 698	com/tencent/qidian/proto/mobileqq_qidian$CorpInfo:has	()Z
    //   261: ifeq +468 -> 729
    //   264: new 700	com/tencent/qidian/data/QidianCorpInfo
    //   267: dup
    //   268: invokespecial 701	com/tencent/qidian/data/QidianCorpInfo:<init>	()V
    //   271: astore 4
    //   273: aload 4
    //   275: aload 8
    //   277: getfield 695	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_corp_info	Lcom/tencent/qidian/proto/mobileqq_qidian$CorpInfo;
    //   280: invokevirtual 702	com/tencent/qidian/proto/mobileqq_qidian$CorpInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   283: checkcast 697	com/tencent/qidian/proto/mobileqq_qidian$CorpInfo
    //   286: invokevirtual 705	com/tencent/qidian/data/QidianCorpInfo:from	(Lcom/tencent/qidian/proto/mobileqq_qidian$CorpInfo;)V
    //   289: aload 7
    //   291: ldc_w 707
    //   294: aload 4
    //   296: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   299: pop
    //   300: aconst_null
    //   301: astore 6
    //   303: aload 6
    //   305: astore 5
    //   307: aload_2
    //   308: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifne +46 -> 357
    //   314: aload 6
    //   316: astore 5
    //   318: aload 8
    //   320: getfield 711	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:rpt_msg_config_group_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   323: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   326: ifeq +31 -> 357
    //   329: new 716	com/tencent/qidian/data/QidianProfileUiInfo
    //   332: dup
    //   333: invokespecial 717	com/tencent/qidian/data/QidianProfileUiInfo:<init>	()V
    //   336: astore 5
    //   338: aload 5
    //   340: aload_2
    //   341: aload 8
    //   343: invokevirtual 720	com/tencent/qidian/data/QidianProfileUiInfo:from	(Ljava/lang/String;Lcom/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody;)V
    //   346: aload 7
    //   348: ldc_w 722
    //   351: aload 5
    //   353: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: iload 11
    //   359: iconst_3
    //   360: if_icmpne +179 -> 539
    //   363: aload_0
    //   364: getfield 116	com/tencent/qidian/controller/QidianHandler:a	Lcom/tencent/common/app/AppInterface;
    //   367: sipush 164
    //   370: invokevirtual 122	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   373: checkcast 124	com/tencent/qidian/QidianManager
    //   376: astore 10
    //   378: aload 10
    //   380: aload_2
    //   381: invokevirtual 725	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianExternalInfo;
    //   384: astore 6
    //   386: aload 6
    //   388: ifnull +9 -> 397
    //   391: aload 6
    //   393: aload_1
    //   394: invokevirtual 729	com/tencent/qidian/data/QidianExternalInfo:update	(Lcom/tencent/qidian/data/QidianExternalInfo;)V
    //   397: aload 10
    //   399: aload_2
    //   400: invokevirtual 732	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianInternalInfo;
    //   403: astore 8
    //   405: aload 8
    //   407: ifnull +9 -> 416
    //   410: aload 8
    //   412: aload_3
    //   413: invokevirtual 735	com/tencent/qidian/data/QidianInternalInfo:update	(Lcom/tencent/qidian/data/QidianInternalInfo;)V
    //   416: aload 4
    //   418: aload_1
    //   419: getfield 738	com/tencent/qidian/data/QidianExternalInfo:masterUin	Ljava/lang/String;
    //   422: putfield 741	com/tencent/qidian/data/QidianCorpInfo:corpUin	Ljava/lang/String;
    //   425: aload 10
    //   427: aload 4
    //   429: getfield 741	com/tencent/qidian/data/QidianCorpInfo:corpUin	Ljava/lang/String;
    //   432: invokevirtual 744	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianCorpInfo;
    //   435: astore 9
    //   437: aload 9
    //   439: ifnull +10 -> 449
    //   442: aload 9
    //   444: aload 4
    //   446: invokevirtual 747	com/tencent/qidian/data/QidianCorpInfo:update	(Lcom/tencent/qidian/data/QidianCorpInfo;)V
    //   449: aload 10
    //   451: aload_2
    //   452: invokevirtual 750	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianProfileUiInfo;
    //   455: astore_2
    //   456: aload 6
    //   458: ifnull +290 -> 748
    //   461: aload 8
    //   463: ifnull +285 -> 748
    //   466: aload 9
    //   468: ifnull +280 -> 748
    //   471: aload_2
    //   472: ifnull +276 -> 748
    //   475: aload 7
    //   477: ldc_w 662
    //   480: aload 6
    //   482: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload 7
    //   488: ldc_w 691
    //   491: aload 8
    //   493: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: pop
    //   497: aload 7
    //   499: ldc_w 707
    //   502: aload 9
    //   504: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: aload 7
    //   510: ldc_w 722
    //   513: aload_2
    //   514: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: pop
    //   518: aload_0
    //   519: aload_1
    //   520: aload_3
    //   521: aload 4
    //   523: aload 5
    //   525: invokespecial 751	com/tencent/qidian/controller/QidianHandler:a	(Lcom/tencent/qidian/data/QidianExternalInfo;Lcom/tencent/qidian/data/QidianInternalInfo;Lcom/tencent/qidian/data/QidianCorpInfo;Lcom/tencent/qidian/data/QidianProfileUiInfo;)V
    //   528: aload_0
    //   529: sipush 1001
    //   532: iconst_1
    //   533: aload 7
    //   535: invokespecial 578	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   538: return
    //   539: aload_0
    //   540: aload_1
    //   541: aload_3
    //   542: aload 4
    //   544: aload 5
    //   546: invokespecial 751	com/tencent/qidian/controller/QidianHandler:a	(Lcom/tencent/qidian/data/QidianExternalInfo;Lcom/tencent/qidian/data/QidianInternalInfo;Lcom/tencent/qidian/data/QidianCorpInfo;Lcom/tencent/qidian/data/QidianProfileUiInfo;)V
    //   549: aload_0
    //   550: sipush 1001
    //   553: iconst_1
    //   554: aload 7
    //   556: invokespecial 578	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   559: return
    //   560: astore_1
    //   561: aload_1
    //   562: invokevirtual 586	java/lang/Exception:printStackTrace	()V
    //   565: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +33 -> 601
    //   571: getstatic 42	com/tencent/qidian/controller/QidianHandler:c	Ljava/lang/String;
    //   574: iconst_2
    //   575: new 237	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 753
    //   585: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   592: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload_0
    //   602: sipush 1001
    //   605: iload 13
    //   607: aconst_null
    //   608: invokespecial 578	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   611: return
    //   612: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +31 -> 646
    //   618: getstatic 42	com/tencent/qidian/controller/QidianHandler:c	Ljava/lang/String;
    //   621: iconst_2
    //   622: new 237	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 755
    //   632: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload 12
    //   637: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload_0
    //   647: sipush 1001
    //   650: iload 13
    //   652: aconst_null
    //   653: invokespecial 578	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   656: return
    //   657: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   660: ifeq +13 -> 673
    //   663: getstatic 42	com/tencent/qidian/controller/QidianHandler:c	Ljava/lang/String;
    //   666: iconst_2
    //   667: ldc_w 757
    //   670: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_0
    //   674: sipush 1001
    //   677: iload 13
    //   679: aconst_null
    //   680: invokespecial 578	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   683: return
    //   684: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +31 -> 718
    //   690: getstatic 42	com/tencent/qidian/controller/QidianHandler:c	Ljava/lang/String;
    //   693: iconst_2
    //   694: new 237	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 759
    //   704: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload 13
    //   709: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   712: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload_0
    //   719: sipush 1001
    //   722: iload 13
    //   724: aconst_null
    //   725: invokespecial 578	com/tencent/mobileqq/app/BusinessHandler:a	(IZLjava/lang/Object;)V
    //   728: return
    //   729: aconst_null
    //   730: astore 4
    //   732: goto -432 -> 300
    //   735: aconst_null
    //   736: astore_3
    //   737: goto -484 -> 253
    //   740: aconst_null
    //   741: astore_1
    //   742: goto -533 -> 209
    //   745: goto -536 -> 209
    //   748: return
    //   749: iconst_0
    //   750: istore 12
    //   752: goto -652 -> 100
    //   755: astore_1
    //   756: iconst_2
    //   757: istore 11
    //   759: goto -637 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	QidianHandler
    //   0	762	1	paramToServiceMsg	ToServiceMsg
    //   0	762	2	paramFromServiceMsg	FromServiceMsg
    //   0	762	3	paramObject	Object
    //   35	696	4	localObject1	Object
    //   305	240	5	localObject2	Object
    //   301	180	6	localQidianExternalInfo	QidianExternalInfo
    //   57	498	7	localHashMap	HashMap
    //   81	411	8	localObject3	Object
    //   435	68	9	localQidianCorpInfo	QidianCorpInfo
    //   376	74	10	localQidianManager	QidianManager
    //   120	638	11	i	int
    //   98	653	12	bool1	boolean
    //   10	713	13	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   37	97	560	java/lang/Exception
    //   105	116	560	java/lang/Exception
    //   122	206	560	java/lang/Exception
    //   209	253	560	java/lang/Exception
    //   253	300	560	java/lang/Exception
    //   307	314	560	java/lang/Exception
    //   318	357	560	java/lang/Exception
    //   363	386	560	java/lang/Exception
    //   391	397	560	java/lang/Exception
    //   397	405	560	java/lang/Exception
    //   410	416	560	java/lang/Exception
    //   416	437	560	java/lang/Exception
    //   442	449	560	java/lang/Exception
    //   449	456	560	java/lang/Exception
    //   475	538	560	java/lang/Exception
    //   539	559	560	java/lang/Exception
    //   612	646	560	java/lang/Exception
    //   646	656	560	java/lang/Exception
    //   657	673	560	java/lang/Exception
    //   673	683	560	java/lang/Exception
    //   116	122	755	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\controller\QidianHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */