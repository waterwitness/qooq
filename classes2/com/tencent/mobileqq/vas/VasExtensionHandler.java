package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.IndividPub.IndividPub.Platform_Comm_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Rsp;
import com.tencent.IndividPub.IndividPub.expTips_Req;
import com.tencent.IndividPub.IndividPub.expTips_Rsp;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonReq;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VasExtensionHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static String a;
  public static final int b = 1;
  public static String b;
  public static final int c = 2;
  public static String c = "IndividPub.ExpTips";
  public static final int d = 3;
  public static final String d = "apollo_core.get_avatar";
  public static final int e = 4;
  public static final String e = "apollo_core.set_status";
  public static final int f = 5;
  public static final String f = "apollo_core.get_user_info";
  public static final int g = 6;
  public static final String g = "apollo_core.check_act";
  public static final int h = 7;
  public static final String h = "apollo_extend.zan";
  public static final int i = 8;
  public static final String i = "apollo_interact.get_user_chipdata";
  public static final int j = 9;
  public static final String j = "OidbSvc.0x5eb_15";
  public static final int k = 1;
  public static final String k = "last_pull_individual_expire_info_time";
  public static final int l = 2;
  private static final String l = "from";
  private static final int m = 1;
  private Vector a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "VasExtensionHandler";
    jdField_b_of_type_JavaLangString = "Addon.Set";
  }
  
  public VasExtensionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleExpireInfoResponse");
    }
    long l2;
    try
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleExpireInfoResponse, isSuccess false, error code=" + paramFromServiceMsg.getResultCode());
        return;
      }
      paramFromServiceMsg = new IndividPub.expTips_Rsp();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      long l1 = paramFromServiceMsg.ret.get();
      if (l1 != 0L) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleExpireInfoResponse, ret=" + l1 + ", error msg=" + paramFromServiceMsg.errmsg.get());
      }
      l2 = paramIntent.getIntExtra("from", 1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleExpireInfoResponse, from=" + l2);
      }
      if (l2 == 1L)
      {
        if (l1 != 0L) {
          return;
        }
        paramObject = (IndividPub.expTips_Pull_Rsp)paramFromServiceMsg.rspcmd_0x01.get();
        int n = ((IndividPub.expTips_Pull_Rsp)paramObject).expFlag.get();
        paramIntent = ((IndividPub.expTips_Pull_Rsp)paramObject).content.get();
        paramFromServiceMsg = ((IndividPub.expTips_Pull_Rsp)paramObject).clickText.get();
        int i1 = ((IndividPub.expTips_Pull_Rsp)paramObject).action.get();
        paramObject = ((IndividPub.expTips_Pull_Rsp)paramObject).url.get();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleExpireInfoResponse, from aio, expireFlag=" + n + ", expireTipContent=" + paramIntent + ", clickText=" + paramFromServiceMsg + ", action=" + i1 + ", url=" + (String)paramObject);
        }
        if ((n == 0) || (i1 < 0) || (i1 > 8)) {
          return;
        }
        paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
        ((SharedPreferences.Editor)paramObject).putInt("renewal_tail_tip_exit", n);
        ((SharedPreferences.Editor)paramObject).putInt("renewal_tail_action", i1);
        ((SharedPreferences.Editor)paramObject).putString("renewal_tail_tip", paramIntent);
        ((SharedPreferences.Editor)paramObject).putString("renewal_tail_click_text", paramFromServiceMsg);
        ((SharedPreferences.Editor)paramObject).putString("renewal_tail_activity_url", paramFromServiceMsg);
        ((SharedPreferences.Editor)paramObject).commit();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "aio_pay", "aio_preshow", 0, 0, "" + n, "", "", "");
        paramIntent = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
        if (paramIntent == null) {
          return;
        }
        paramIntent.sendMessage(paramIntent.obtainMessage(26));
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleExpireInfoResponse exception", paramIntent);
      return;
    }
    if (l2 == 2L) {}
  }
  
  private void a(Long[] paramArrayOfLong, String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "android";; paramString = "android." + paramString)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("from", paramString);
        paramString = new JSONArray();
        int i1 = paramArrayOfLong.length;
        int n = 0;
        while (n < i1)
        {
          paramString.put(paramArrayOfLong[n].longValue());
          n += 1;
        }
      }
      ((JSONObject)localObject).put("uins", paramString);
      ((JSONObject)localObject).put("detail", 1);
      ((JSONObject)localObject).put("cmd", "apollo_core.get_avatar");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
      paramString.putExtra("cmd", "apollo_core.get_avatar");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.putExtra("uinArr", paramArrayOfLong);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        this.jdField_a_of_type_JavaUtilVector.remove(paramArrayOfLong);
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
    }
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "; isSuccess: " + paramFromServiceMsg.isSuccess() + ", ret: " + paramFromServiceMsg.getResultCode());
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress ret: " + paramFromServiceMsg.ret.get());
        }
        if (0L == paramFromServiceMsg.ret.get())
        {
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
          if (paramFromServiceMsg == null) {
            continue;
          }
          ApolloManager localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
          ArrayList localArrayList = new ArrayList();
          JSONArray localJSONArray = paramFromServiceMsg.getJSONArray("data");
          n = 0;
          if (n < localJSONArray.length())
          {
            paramFromServiceMsg = (JSONObject)localJSONArray.opt(n);
            l1 = paramFromServiceMsg.optLong("uin");
            ApolloBaseInfo localApolloBaseInfo = localApolloManager.b(l1 + "");
            long l2 = paramFromServiceMsg.optLong("ts");
            paramArrayOfByte = paramFromServiceMsg.toString();
            paramFromServiceMsg = localApolloBaseInfo.getApolloDress();
            localApolloBaseInfo.setApolloDress(l2, paramArrayOfByte);
            paramArrayOfByte = localApolloBaseInfo.getApolloDress();
            if (paramFromServiceMsg == null)
            {
              paramFromServiceMsg = "";
              break label670;
              if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.equals(paramFromServiceMsg, paramArrayOfByte)))
              {
                localApolloBaseInfo.apolloHistoryDress = paramFromServiceMsg;
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "save history uin:" + l1 + ", dress: " + paramFromServiceMsg + ", new dres: " + paramArrayOfByte);
                }
              }
              localArrayList.add(localApolloBaseInfo);
              n += 1;
              continue;
            }
            paramFromServiceMsg = paramFromServiceMsg.a();
            break label670;
            paramArrayOfByte = paramArrayOfByte.a();
            continue;
          }
          if (localArrayList.size() > 0)
          {
            localApolloManager.c(localArrayList);
            ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(localArrayList);
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        int n;
        long l1;
        int i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramFromServiceMsg);
        continue;
      }
      paramIntent = (Long[])paramIntent.getExtras().get("uinArr");
      if (paramIntent != null)
      {
        i1 = paramIntent.length;
        n = 0;
        if (n < i1)
        {
          l1 = paramIntent[n].longValue();
          this.jdField_a_of_type_JavaUtilVector.remove(Long.valueOf(l1));
          n += 1;
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramFromServiceMsg = (Long[])paramIntent.getExtras().get("uinArr");
          i1 = paramFromServiceMsg.length;
          n = 0;
          if (n < i1)
          {
            l1 = paramFromServiceMsg[n].longValue();
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress no dress info uin:" + l1);
            n += 1;
            continue;
          }
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress fail ret: " + paramFromServiceMsg.getResultCode());
          continue;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress done  mSendingQueue size: " + this.jdField_a_of_type_JavaUtilVector.size());
      }
      return;
      label670:
      if (paramArrayOfByte == null) {
        paramArrayOfByte = "";
      }
    }
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("handleGetApolloBaseInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label624;
      }
    }
    label624:
    for (int n = paramArrayOfByte.length;; n = -1)
    {
      QLog.d((String)localObject1, 2, n);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
      do
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
          {
            paramIntent = new oidb_0x5eb.RspBody();
            paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
            paramFromServiceMsg = new ArrayList(paramIntent.rpt_msg_uin_data.size());
            paramArrayOfByte = new ArrayList(paramIntent.rpt_msg_uin_data.size());
            localObject1 = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
            n = 0;
            while (n < paramIntent.rpt_msg_uin_data.size())
            {
              localObject2 = (oidb_0x5eb.UdcUinData)paramIntent.rpt_msg_uin_data.get(n);
              ApolloBaseInfo localApolloBaseInfo = ((ApolloManager)localObject1).b(((oidb_0x5eb.UdcUinData)localObject2).uint64_uin.get() + "");
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_flag.has()) {
                localApolloBaseInfo.apolloVipFlag = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_flag.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_level.has()) {
                localApolloBaseInfo.apolloVipLevel = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_level.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_status.has()) {
                localApolloBaseInfo.apolloStatus = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_status.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_timestamp.has()) {
                localApolloBaseInfo.apolloServerTS = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_timestamp.get();
              }
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetApolloBaseInfo uin: " + localApolloBaseInfo.uin + ",apollo vipFlag: " + localApolloBaseInfo.apolloVipFlag + ", apollo status: " + localApolloBaseInfo.apolloStatus + ", apollo level: " + localApolloBaseInfo.apolloVipLevel + ", svr TS: " + localApolloBaseInfo.apolloServerTS);
              }
              if (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS) {
                paramFromServiceMsg.add(Long.valueOf(((oidb_0x5eb.UdcUinData)localObject2).uint64_uin.get()));
              }
              localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
              paramArrayOfByte.add(localApolloBaseInfo);
              n += 1;
            }
            ((ApolloManager)localObject1).c(paramArrayOfByte);
            a(paramFromServiceMsg, "AIO");
          }
          return;
        }
        catch (Throwable paramIntent)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramIntent);
          return;
        }
        paramIntent = paramIntent.getStringArrayExtra("uins");
      } while (paramIntent == null);
      paramFromServiceMsg = new ArrayList(paramIntent.length);
      int i1 = paramIntent.length;
      n = 0;
      while (n < i1)
      {
        paramArrayOfByte = paramIntent[n];
        localObject1 = ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(paramArrayOfByte);
        if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloLocalTS != ((ApolloBaseInfo)localObject1).apolloServerTS)) {
          paramFromServiceMsg.add(Long.valueOf(Long.parseLong(paramArrayOfByte)));
        }
        n += 1;
      }
      a(paramFromServiceMsg, "AIOPanel");
      return;
    }
  }
  
  protected Class a()
  {
    return VasExtensionObserver.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestExpireInfo, from=" + paramInt);
    }
    IndividPub.expTips_Req localexpTips_Req = new IndividPub.expTips_Req();
    Object localObject = new IndividPub.Platform_Comm_Req();
    ((IndividPub.Platform_Comm_Req)localObject).platForm.set(109L);
    ((IndividPub.Platform_Comm_Req)localObject).osver.set(Build.VERSION.RELEASE);
    ((IndividPub.Platform_Comm_Req)localObject).mqqver.set("6.5.5.2880");
    localexpTips_Req.comm.set((MessageMicro)localObject);
    localexpTips_Req.cmd.set(1);
    localexpTips_Req.setHasFlag(true);
    localObject = new IndividPub.expTips_Pull_Req();
    ((IndividPub.expTips_Pull_Req)localObject).from.set(paramInt);
    localexpTips_Req.reqcmd_0x01.set((MessageMicro)localObject);
    localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
    ((NewIntent)localObject).putExtra("cmd", c);
    ((NewIntent)localObject).putExtra("data", localexpTips_Req.toByteArray());
    ((NewIntent)localObject).putExtra("from", paramInt);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_core.set_status");
        if (!TextUtils.isEmpty(paramString)) {
          break label209;
        }
        paramString = "android";
        ((JSONObject)localObject).put("from", paramString);
        ((JSONObject)localObject).put("status", paramInt);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
        paramString.putExtra("cmd", "apollo_core.set_status");
        paramString.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString.putExtra("apollo_status", paramInt);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "changeApolloStatus failed ", paramString);
      return;
      label209:
      paramString = "android." + paramString;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_core.check_act");
      if (TextUtils.isEmpty(paramString3)) {}
      for (localObject = "android";; localObject = "android." + paramString3)
      {
        localJSONObject.put("from", localObject);
        localJSONObject.put("actid", paramInt);
        localUniSsoServerReq.reqdata.set(localJSONObject.toString());
        localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
        ((NewIntent)localObject).putExtra("cmd", "apollo_core.check_act");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("actionId", paramInt);
        if (!TextUtils.isEmpty(paramString1)) {
          ((NewIntent)localObject).putExtra("actionText", paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          ((NewIntent)localObject).putExtra("textType", paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          ((NewIntent)localObject).putExtra("optFrom", paramString3);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "checkActionAuth failed id: " + paramInt, paramString1);
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
    localNewIntent.putExtra("cmd", jdField_b_of_type_JavaLangString);
    localNewIntent.putExtra("pendantId", paramLong);
    localNewIntent.putExtra("seriesId", paramInt);
    localNewIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    PendantMarket.SetAddonReq localSetAddonReq = new PendantMarket.SetAddonReq();
    localSetAddonReq.cmd.set(2);
    localSetAddonReq.int_platform.set(2);
    localSetAddonReq.long_addon_id.set(paramLong);
    localSetAddonReq.str_qq_version.set("6.5.5");
    localNewIntent.putExtra("data", localSetAddonReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      if (str.equals(jdField_b_of_type_JavaLangString))
      {
        a(paramIntent, paramArrayOfByte);
        return;
      }
      if ("apollo_core.get_avatar".equals(str))
      {
        f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.set_status".equals(str))
      {
        b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.get_user_info".equals(str))
      {
        c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.check_act".equals(str))
      {
        d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("OidbSvc.0x5eb_15".equals(str))
      {
        g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_extend.zan".equals(str))
      {
        e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if (c.equals(str))
      {
        a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "unknow cmd :" + str);
  }
  
  public void a(Intent paramIntent, byte[] paramArrayOfByte)
  {
    Object localObject = new PendantMarket.SetAddonRsp();
    try
    {
      ((PendantMarket.SetAddonRsp)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      localObject = new Bundle();
      int n = paramArrayOfByte.int_result.get();
      ((Bundle)localObject).putLong("pendantId", paramIntent.getLongExtra("pendantId", -1L));
      ((Bundle)localObject).getInt("seriesId", paramIntent.getIntExtra("seriesId", -1));
      ((Bundle)localObject).putString("uin", paramIntent.getStringExtra("uin"));
      if (n == 0) {
        break label271;
      }
      if (!QLog.isColorLevel()) {
        break label133;
      }
      QLog.e("VasExtensionHandler", 2, "response from server error: " + n);
      label133:
      ((Bundle)localObject).putInt("result", n);
      switch (n)
      {
      case 1002: 
      case 1004: 
      case 2001: 
      case 2002: 
      default: 
        a(1, false, localObject);
        return;
      }
      if (!paramArrayOfByte.str_msg.has()) {
        break label259;
      }
      paramIntent = paramArrayOfByte.str_msg.get();
      label222:
      if (!paramArrayOfByte.str_url.has()) {
        break label265;
      }
      label259:
      label265:
      for (paramArrayOfByte = paramArrayOfByte.str_url.get();; paramArrayOfByte = "")
      {
        ((Bundle)localObject).putString("tips", paramIntent);
        ((Bundle)localObject).putString("url", paramArrayOfByte);
        break;
        paramIntent = "";
        break label222;
      }
      label271:
      a(1, true, localObject);
    }
    if (paramArrayOfByte == null) {
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
      a(localArrayList, paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    int n = paramInt;
    if (paramInt == 0) {
      n = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "");
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_core.get_user_info");
        if (!TextUtils.isEmpty(paramString2)) {
          break label259;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("touin", Long.valueOf(paramString1));
        ((JSONObject)localObject).put("mask", n);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString2 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
        paramString2.putExtra("cmd", "apollo_core.get_user_info");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString2.putExtra("touin", paramString1);
        paramString2.putExtra("mask", n);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getUserApolloInfo failed ", paramString1);
      return;
      label259:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_extend.zan");
        if (!TextUtils.isEmpty(paramString2)) {
          break label200;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("touin", Long.parseLong(paramString1));
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString1 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
        paramString1.putExtra("cmd", "apollo_extend.zan");
        paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "changeApolloStatus failed ", paramString1);
      return;
      label200:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramArrayList.removeAll(this.jdField_a_of_type_JavaUtilVector);
    this.jdField_a_of_type_JavaUtilVector.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getGetUserApolloDress uinList size: " + paramArrayList.size() + ", queue size: " + this.jdField_a_of_type_JavaUtilVector.size() + ",from: " + paramString);
    }
    int n = 0;
    label94:
    if (n < paramArrayList.size()) {
      if (n + 16 >= paramArrayList.size()) {
        break label156;
      }
    }
    label156:
    for (int i1 = n + 16;; i1 = paramArrayList.size())
    {
      a((Long[])new ArrayList(paramArrayList.subList(n, i1)).toArray(new Long[0]), paramString);
      n += 16;
      break label94;
      break;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    int i1 = paramArrayOfString.length;
    int n = 0;
    for (;;)
    {
      if (n < i1)
      {
        String str = paramArrayOfString[n];
        try
        {
          long l1 = Long.parseLong(str);
          ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l1));
          n += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_level.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_status.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_timestamp.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1515);
    localOIDBSSOPkg.uint32_service_type.set(15);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), VasExtensionServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x5eb_15");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("uins", paramArrayOfString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        int n = paramIntent.getIntExtra("apollo_status", 0);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus ret: " + paramFromServiceMsg.ret.get() + ", apollo status:" + n);
        }
        ApolloActionManager.a().e = n;
        paramIntent = new Pair(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(), Integer.valueOf(n));
        if (0L != paramFromServiceMsg.ret.get()) {
          break label206;
        }
        if (n != 0)
        {
          paramFromServiceMsg = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
          paramArrayOfByte = paramFromServiceMsg.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f());
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte.apolloStatus = n;
            paramFromServiceMsg.a(paramArrayOfByte);
          }
          a(3, true, paramIntent);
          return;
        }
        a(3, false, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramIntent);
      return;
      label206:
      a(3, false, paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void b(String paramString)
  {
    a(new String[] { paramString });
  }
  
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1 = paramIntent.getStringExtra("touin");
    int n = paramIntent.getIntExtra("mask", 0);
    ApolloManager localApolloManager;
    int i1;
    HashMap localHashMap;
    label418:
    Object localObject2;
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramIntent.rspdata.has())) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo ret: " + paramIntent.ret.get() + ", msg: " + paramIntent.rspdata.get() + ", touin:" + (String)localObject1 + ", mask: " + n);
        }
        if (0L != paramIntent.ret.get()) {
          break label1080;
        }
        paramArrayOfByte = new JSONObject(paramIntent.rspdata.get()).getJSONObject("data");
        if ((paramArrayOfByte == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label1080;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo apollo data: " + paramArrayOfByte.toString());
        }
        localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if (localApolloManager == null) {
          break label1080;
        }
        localObject1 = localApolloManager.b((String)localObject1);
        i1 = 0;
        n = i1;
        int i2;
        if (paramArrayOfByte.has("vip"))
        {
          i2 = paramArrayOfByte.getInt("vip");
          n = i1;
          if (i2 != ((ApolloBaseInfo)localObject1).apolloVipFlag)
          {
            ((ApolloBaseInfo)localObject1).apolloVipFlag = i2;
            n = 1;
          }
        }
        i1 = n;
        if (paramArrayOfByte.has("viplevel"))
        {
          i2 = paramArrayOfByte.getInt("viplevel");
          i1 = n;
          if (i2 != ((ApolloBaseInfo)localObject1).apolloVipLevel)
          {
            ((ApolloBaseInfo)localObject1).apolloVipLevel = i2;
            i1 = 1;
          }
        }
        if (!paramArrayOfByte.has("userstatus")) {
          break label1064;
        }
        n = paramArrayOfByte.getInt("userstatus");
        if (n == ((ApolloBaseInfo)localObject1).apolloStatus) {
          break label1064;
        }
        ((ApolloBaseInfo)localObject1).apolloStatus = n;
        n = 1;
        if (!paramArrayOfByte.has("actlist")) {
          break label966;
        }
        paramIntent = paramArrayOfByte.getJSONArray("actlist");
        localHashMap = new HashMap(paramIntent.length());
        i1 = 0;
        if (i1 < paramIntent.length())
        {
          paramFromServiceMsg = new Bundle();
          localObject2 = paramIntent.getJSONObject(i1);
          i2 = ((JSONObject)localObject2).optInt("id");
          paramFromServiceMsg.putLong("endts", ((JSONObject)localObject2).optLong("endts"));
          paramFromServiceMsg.putInt("way", ((JSONObject)localObject2).optInt("way"));
          if (i2 == 0) {
            break label1071;
          }
          localHashMap.put(Integer.valueOf(i2), paramFromServiceMsg);
          break label1071;
        }
        if (localHashMap.size() <= 0) {
          break label966;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
          return;
        }
        paramIntent = (ApolloManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(152);
        if (paramIntent != null) {
          paramIntent.a = localHashMap;
        }
        localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(154);
        if (localObject2 == null) {
          break label1080;
        }
        paramIntent = ((ApolloDaoManager)localObject2).a(6);
        paramFromServiceMsg = ((ApolloDaoManager)localObject2).a(9);
        if (paramIntent == null) {
          break label1090;
        }
        paramIntent.addAll(paramFromServiceMsg);
        label591:
        paramFromServiceMsg = ((ApolloDaoManager)localObject2).b();
        if (paramIntent == null) {
          break label1095;
        }
        i1 = 0;
        label604:
        if (i1 >= paramIntent.size()) {
          break label829;
        }
        ApolloActionData localApolloActionData = (ApolloActionData)paramIntent.get(i1);
        if (localHashMap.containsKey(Integer.valueOf(localApolloActionData.actionId)))
        {
          if ((((Bundle)localHashMap.get(Integer.valueOf(localApolloActionData.actionId))).getInt("way") == 2) && (localApolloActionData.feeType != 7))
          {
            localApolloActionData.feeType = 7;
            ApolloActionPackageData localApolloActionPackageData = new ApolloActionPackageData();
            i2 = ((ApolloDaoManager)localObject2).a(3);
            localApolloActionPackageData.acitonId = localApolloActionData.actionId;
            localApolloActionPackageData.packageId = i2;
            ((ApolloDaoManager)localObject2).a(localApolloActionPackageData);
          }
          localApolloActionData.limitFree = 1;
          localApolloActionData.limitEnd = ((Bundle)localHashMap.get(Integer.valueOf(localApolloActionData.actionId))).getLong("endts");
        }
        while (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo update actlist id: " + localApolloActionData.actionId);
          break;
          localApolloActionData.limitFree = 0;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo failed", paramIntent);
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label1080;
        }
      }
      return;
      label829:
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (localObject2 == null)) {
        break label1095;
      }
      ((ApolloDaoManager)localObject2).b(paramIntent);
    }
    for (;;)
    {
      if (i1 < paramFromServiceMsg.size())
      {
        paramIntent = (ApolloActionData)paramFromServiceMsg.get(i1);
        if (localHashMap.containsKey(Integer.valueOf(paramIntent.actionId))) {}
        for (paramIntent.isShow = 1; QLog.isColorLevel(); paramIntent.isShow = 0)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo update show actlist id: " + paramIntent.actionId);
          break;
        }
      }
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (localObject2 != null))
      {
        ((ApolloDaoManager)localObject2).b(paramFromServiceMsg);
        a(9, true, null);
      }
      label966:
      label1064:
      label1071:
      label1080:
      label1090:
      label1095:
      do
      {
        if (paramArrayOfByte.has("zancount")) {
          a(6, true, Integer.valueOf(paramArrayOfByte.optInt("zancount")));
        }
        if (n != 0)
        {
          localApolloManager.a((ApolloBaseInfo)localObject1);
          return;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo fail ret: " + paramFromServiceMsg.getResultCode());
          }
          if (1 == (n & 0x100))
          {
            a(6, false, Integer.valueOf(0));
            return;
            n = i1;
            break;
            i1 += 1;
            break label418;
          }
        }
        return;
        i1 += 1;
        break label604;
        paramIntent = paramFromServiceMsg;
        break label591;
      } while (paramFromServiceMsg == null);
      i1 = 0;
      continue;
      i1 += 1;
    }
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int n = paramIntent.getIntExtra("actionId", 0);
    String str1 = paramIntent.getStringExtra("actionText");
    String str2 = paramIntent.getStringExtra("textType");
    String str3 = paramIntent.getStringExtra("optFrom");
    paramIntent = new HashMap();
    paramIntent.put("id", n + "");
    paramIntent.put("actionText", str1);
    paramIntent.put("textType", str2);
    paramIntent.put("optFrom", str3);
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramFromServiceMsg.rspdata.has())) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCheckActionAuth ret: " + paramFromServiceMsg.ret.get() + ", msg: " + paramFromServiceMsg.rspdata.get());
        }
        paramIntent.put("ret", paramFromServiceMsg.ret.get() + "");
        if (0L == paramFromServiceMsg.ret.get())
        {
          a(5, true, paramIntent);
          return;
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get()).getJSONObject("data").getJSONObject("acresult");
        paramIntent.put("type", paramFromServiceMsg.optInt("type") + "");
        paramIntent.put("id", paramFromServiceMsg.optInt("id") + "");
        paramIntent.put("content", paramFromServiceMsg.optString("msg"));
        paramIntent.put("url", paramFromServiceMsg.optString("url"));
        a(5, false, paramIntent);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramFromServiceMsg);
        }
        paramIntent.put("ret", "-1");
        a(5, false, paramIntent);
        return;
      }
    }
    paramIntent.put("ret", paramFromServiceMsg.getResultCode() + "");
    a(5, false, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleSetZanCount ret: " + paramIntent.ret.get());
        }
        if (0L == paramIntent.ret.get())
        {
          a(7, true, Integer.valueOf(new JSONObject(paramIntent.rspdata.get()).getJSONObject("data").optInt("zancount")));
          return;
        }
        a(7, false, Long.valueOf(paramIntent.ret.get()));
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramIntent);
        }
        a(7, false, Integer.valueOf(-1));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
    a(7, false, Integer.valueOf(paramFromServiceMsg.getResultCode()));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\VasExtensionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */