package com.tencent.mobileqq.vipav;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.funcall.VipFunCallAndRing.TGroupInfo;
import com.tencent.pb.funcall.VipFunCallAndRing.TSourceInfo;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x1Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x1Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x5Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x5Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoReq;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoRsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TUserInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VipSetFunCallHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final String jdField_a_of_type_JavaLangString;
  
  public VipSetFunCallHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "VipSetFunCallHandler";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected Class a()
  {
    return VipFunCallObserver.class;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ToServiceMsg localToServiceMsg = a("FunCallSvr.call");
    VipFunCallAndRing.TSsoReq localTSsoReq = new VipFunCallAndRing.TSsoReq();
    localTSsoReq.i32_implat.set(109);
    localTSsoReq.i32_cmd.set(paramInt);
    localTSsoReq.str_qq_ver.set("6.5.5");
    if ((paramObject instanceof Bundle)) {}
    for (Bundle localBundle1 = (Bundle)paramObject;; localBundle1 = null)
    {
      localBundle2 = localBundle1;
      if (localBundle1 != null) {
        break label120;
      }
      if ((2 != paramInt) && (3 != paramInt) && (5 != paramInt)) {
        break;
      }
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error fcBundle==null funcType=" + paramInt);
      return;
    }
    Bundle localBundle2 = new Bundle();
    label120:
    int i = localBundle2.getInt("from");
    int j;
    switch (paramInt)
    {
    default: 
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + paramInt);
      return;
    case 1: 
      paramObject = new VipFunCallAndRing.TSsoCmd0x1Req();
      long l = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null).getLong("local_version", 0L);
      ((VipFunCallAndRing.TSsoCmd0x1Req)paramObject).u64_local_ver.set(l);
      localTSsoReq.st_cmd0x1_req.set((MessageMicro)paramObject);
      j = 0;
    }
    for (;;)
    {
      localTSsoReq.setHasFlag(true);
      localToServiceMsg.extraData.putInt("srcType", j);
      localToServiceMsg.extraData.putInt("from", i);
      localToServiceMsg.putWupBuffer(localTSsoReq.toByteArray());
      if (QLog.isColorLevel()) {
        QLog.d("VipSetFunCallHandler", 2, "sendReqToSVR funcType=" + paramInt + ", srcType:" + j);
      }
      super.b(localToServiceMsg);
      return;
      paramObject = new VipFunCallAndRing.TSsoCmd0x2Req();
      ((VipFunCallAndRing.TSsoCmd0x2Req)paramObject).u64_friend_uin.set(localBundle2.getLong("uin"));
      ((VipFunCallAndRing.TSsoCmd0x2Req)paramObject).str_friend_phone.set(localBundle2.getString("phone"));
      localTSsoReq.st_cmd0x2_req.set((MessageMicro)paramObject);
      j = 0;
      continue;
      j = localBundle2.getInt("srcType", 0);
      int k = localBundle2.getInt("callId");
      int m = localBundle2.getInt("ringId");
      if (k == 0) {
        QLog.d("VipSetFunCallHandler", 1, "sendReqToSVR Error 3 callId=" + k);
      }
      paramObject = new VipFunCallAndRing.TSsoCmd0x3Req();
      ((VipFunCallAndRing.TSsoCmd0x3Req)paramObject).i32_funcall_id.set(k);
      ((VipFunCallAndRing.TSsoCmd0x3Req)paramObject).i32_ring_id.set(m);
      localTSsoReq.st_cmd0x3_req.set((MessageMicro)paramObject);
      continue;
      paramObject = (VipFunCallAndRing.TSsoCmd0x4Req)paramObject;
      localTSsoReq.st_cmd0x4_req.set((MessageMicro)paramObject);
      i = 1;
      j = 0;
      continue;
      paramObject = new VipFunCallAndRing.TSsoCmd0x5Req();
      j = localBundle2.getInt("srcType", 0);
      k = localBundle2.getInt("callId");
      if (k == 0) {
        QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error 5 callId5=" + k);
      }
      ((VipFunCallAndRing.TSsoCmd0x5Req)paramObject).i32_funcall_id.set(k);
      localTSsoReq.st_cmd0x5_req.set((MessageMicro)paramObject);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    new VipFunCallAndRing.TSsoCmd0x4Req().rpt_uins.set(new ArrayList());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"FunCallSvr.call".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    Object localObject2;
    int j;
    int n;
    int m;
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new VipFunCallAndRing.TSsoReq();
        ((VipFunCallAndRing.TSsoReq)localObject2).mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        if (((VipFunCallAndRing.TSsoReq)localObject2).i32_cmd.has())
        {
          j = ((VipFunCallAndRing.TSsoReq)localObject2).i32_cmd.get();
          n = paramToServiceMsg.extraData.getInt("srcType", 0);
          m = paramToServiceMsg.extraData.getInt("from");
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("srcType", n);
          if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
            break label251;
          }
          i = 1;
          if (i != 0) {
            break;
          }
          QLog.e("VipSetFunCallHandler", 1, "onReceive~ isSuccess=false ,data=" + PkgTools.b((byte[])paramObject) + ", funcType=" + j);
          ReportCenter.a().a("FunCallSvr.call", 100, paramFromServiceMsg.getBusinessFailCode(), this.b.a(), 1000277, "趣味来电设置失败", true);
          ((Bundle)localObject1).putInt("result", -1);
          a(j, false, localObject1);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("VipSetFunCallHandler", 2, "onReceive prb.mergeFrom error: " + paramToServiceMsg.getMessage());
        return;
      }
      j = -1;
      continue;
      label251:
      i = 0;
    }
    paramToServiceMsg = new VipFunCallAndRing.TSsoRsp();
    paramToServiceMsg.mergeFrom((byte[])paramObject);
    int k = paramToServiceMsg.i32_ret.get();
    paramObject = paramToServiceMsg.str_msg.get();
    String str1 = paramToServiceMsg.str_url.get();
    String str2 = paramToServiceMsg.str_act_wording.get();
    ((Bundle)localObject1).putInt("result", k);
    paramFromServiceMsg = (VipFunCallManager)this.b.getManager(83);
    label454:
    boolean bool;
    if (QLog.isColorLevel())
    {
      QLog.d("VipSetFunCallHandler", 2, "VipSetFunCallHandler onReceive~ ret=" + k + ",msg=" + (String)paramObject + ", url=" + str1 + ", funcType=" + j + ", srcType=" + n + ", actStr=" + str2);
      break label1555;
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + j);
      break label1595;
      for (;;)
      {
        ((Bundle)localObject1).putString("message", (String)paramObject);
        ((Bundle)localObject1).putString("svr_url", str1);
        ((Bundle)localObject1).putString("svr_actStr", str2);
        if (k != 0) {
          break label1538;
        }
        bool = true;
        label491:
        a(j, bool, localObject1);
        if ((i < 0) || (TextUtils.isEmpty(paramToServiceMsg))) {
          break;
        }
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramObject = ((FriendsManager)localObject1).a(paramToServiceMsg);
        paramFromServiceMsg = (FromServiceMsg)paramObject;
        if (paramObject == null)
        {
          paramFromServiceMsg = new ExtensionInfo();
          paramFromServiceMsg.uin = paramToServiceMsg;
        }
        paramFromServiceMsg.colorRingId = i;
        paramFromServiceMsg.commingRingId = i;
        ((FriendsManager)localObject1).a(paramFromServiceMsg);
        return;
        if (k != 0) {
          break label1595;
        }
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x1Rsp)paramToServiceMsg.st_cmd0x1_rsp.get();
        long l = paramToServiceMsg.u64_server_ver.get();
        paramToServiceMsg = (VipFunCallAndRing.TUserInfo)paramToServiceMsg.st_User_Info.get();
        localObject2 = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
        ((SharedPreferences)localObject2).getLong("local_version", 0L);
        ((SharedPreferences)localObject2).edit().putLong("local_version", l);
        if (QLog.isColorLevel()) {
          QLog.d("VipSetFunCallHandler", 2, "onReceive~ localVer=" + (String)paramObject + ", ver=" + l);
        }
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, this.b.getAccount(), paramToServiceMsg.i32_common_id.get(), paramToServiceMsg.i32_ring_id.get(), null, l);
          localObject3 = (VipFunCallAndRing.TSourceInfo)paramToServiceMsg.st_src_info.get();
          VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg.i32_common_id.get(), null, (VipFunCallAndRing.TSourceInfo)localObject3, true);
          localObject3 = paramToServiceMsg.rpt_user_groups.get();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            ((SharedPreferences)localObject2).edit().putString("group", "").commit();
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              VipFunCallAndRing.TGroupInfo localTGroupInfo = (VipFunCallAndRing.TGroupInfo)((Iterator)localObject3).next();
              paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, localTGroupInfo.i32_group_id.get(), localTGroupInfo.i32_ring_id.get(), localTGroupInfo.u64_group_uins.get(), 0L);
              VipFunCallAndRing.TSourceInfo localTSourceInfo = (VipFunCallAndRing.TSourceInfo)localTGroupInfo.st_src_info.get();
              VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTGroupInfo.i32_group_id.get(), null, localTSourceInfo, true);
            }
          }
          paramFromServiceMsg.a(paramToServiceMsg.i32_common_id.get(), paramToServiceMsg.i32_ring_id.get(), false, 0, null);
        }
        ((SharedPreferences)localObject2).edit().putLong("update_time", System.currentTimeMillis()).commit();
        paramToServiceMsg = null;
        i = -1;
        continue;
        if (k != 0) {
          break label1595;
        }
        Object localObject3 = (VipFunCallAndRing.TSsoCmd0x2Rsp)paramToServiceMsg.st_cmd0x2_rsp.get();
        localObject2 = (VipFunCallAndRing.TSsoCmd0x2Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x2_req.get();
        paramToServiceMsg = String.valueOf(((VipFunCallAndRing.TSsoCmd0x2Req)localObject2).u64_friend_uin.get());
        i = ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_funcall_id.get();
        m = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 6, true, null);
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, paramToServiceMsg, i, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_ring_id.get(), null, 0L);
        VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_funcall_id.get(), null, (VipFunCallAndRing.TSourceInfo)((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).st_src_info.get(), true);
        paramFromServiceMsg.a(i, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_ring_id.get(), false, 0, null);
        if (i != m)
        {
          if (m != 0) {
            break label1173;
          }
          VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i);
        }
        for (;;)
        {
          ((Bundle)localObject1).putString("uin", ((VipFunCallAndRing.TSsoCmd0x2Req)localObject2).u64_friend_uin.get() + "");
          i = ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_ring_id.get();
          break;
          label1173:
          VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i);
        }
        localObject2 = (VipFunCallAndRing.TSsoCmd0x3Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x3_req.get();
        ((Bundle)localObject1).putInt("callId", ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_funcall_id.get());
        if (k != 0) {
          break label1547;
        }
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x3Rsp)paramToServiceMsg.st_cmd0x3_rsp.get();
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, this.b.getAccount(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_funcall_id.get(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_ring_id.get(), null, 0L);
        i = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_ring_id.get();
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        label1290:
        if (1 != m) {
          break label1544;
        }
        localObject3 = this.b;
        m = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_funcall_id.get();
        if (k != 0) {
          break label1603;
        }
        paramFromServiceMsg = "0";
        label1321:
        VasWebviewUtil.reportVASTo00145((AppInterface)localObject3, String.valueOf(m), "preview", "SetComCall", paramFromServiceMsg, new String[0]);
      }
      localObject2 = (VipFunCallAndRing.TSsoCmd0x4Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x4_req.get();
      ((Bundle)localObject1).putInt("callId", ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_funcall_id.get());
      if (k == 0)
      {
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x4Rsp)paramToServiceMsg.st_cmd0x4_rsp.get();
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_funcall_id.get(), ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_ring_id.get(), ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).rpt_uins.get(), 0L);
      }
      if (1 != m) {
        break label1595;
      }
      paramFromServiceMsg = this.b;
      i = ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_funcall_id.get();
      if (k != 0) {
        break label1610;
      }
    }
    label1538:
    label1544:
    label1547:
    label1555:
    label1595:
    label1603:
    label1610:
    for (paramToServiceMsg = "0";; paramToServiceMsg = "1")
    {
      VasWebviewUtil.reportVASTo00145(paramFromServiceMsg, String.valueOf(i), "preview", "SetGroupCall", paramToServiceMsg, new String[0]);
      paramToServiceMsg = null;
      i = -1;
      break label454;
      if (k == 0)
      {
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x5Rsp)paramToServiceMsg.st_cmd0x5_rsp.get();
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x5Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x5_req.get();
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null, paramToServiceMsg.i32_funcall_id.get(), 0, null, 0L);
        paramToServiceMsg = null;
        i = -1;
        break label454;
        bool = false;
        break label491;
        break label454;
        paramToServiceMsg = null;
        i = -1;
        break label1290;
        switch (j)
        {
        }
        break;
      }
      paramToServiceMsg = null;
      i = -1;
      break label454;
      paramFromServiceMsg = "1";
      break label1321;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vipav\VipSetFunCallHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */