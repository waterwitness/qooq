package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopCreateAdvanceData;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.troop.data.TroopCreatePermissionData;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.pb.CommunityForumLatestPost.ReqBody;
import com.tencent.mobileqq.troop.utils.HummerParser;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.ReqBody;
import com.tencent.troop.group_activity_info.RspBody;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import pui;
import tencent.im.cs.modifyexamine.modifyexamine.ReqBody;
import tencent.im.cs.modifyexamine.modifyexamine.RspBody;
import tencent.im.lbs.member_lbs.Location;
import tencent.im.lbs.member_lbs.NeighbourNumber;
import tencent.im.lbs.member_lbs.ReqBody;
import tencent.im.lbs.member_lbs.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x78f.oidb_0x78f.ReqBody;
import tencent.im.oidb.cmd0x78f.oidb_0x78f.RspBody;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupReq;
import tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupRsp;
import tencent.im.oidb.cmd0x874.cmd0x874.ReqBody;
import tencent.im.oidb.cmd0x874.cmd0x874.RspBody;
import tencent.im.oidb.cmd0x88c.oidb_0x88c.ReqBody;
import tencent.im.oidb.cmd0x88c.oidb_0x88c.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupGeoInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.CreateGroupInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.GroupGeoInfo;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.ReqBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.RspBody;
import tencent.im.oidb.cmd0x8a1.cmd0x8a1.SelectGroupCodeInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.video_url.video_url.ReqBody;
import tencent.im.video_url.video_url.RspBody;
import tencent.qun.group_activity.group_activity.ReqBody;
import tencent.qun.group_activity.group_activity.RspBody;

public class BizTroopHandler
  extends BusinessHandler
{
  public static final int A = 33;
  public static final int B = 34;
  public static final int C = 36;
  public static final int D = 37;
  public static final int H = 38;
  public static final int I = 39;
  public static final int J = 40;
  public static final int K = 41;
  public static final int L = 42;
  public static final int M = 1;
  public static final int N = 2;
  public static final int O = 3;
  public static final int P = 0;
  public static final int Q = 1;
  public static final int R = 1;
  public static final int S = 3;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 6;
  public static final int e = 8;
  public static final int f = 9;
  public static final int g = 10;
  public static final int h = 11;
  public static final int i = 12;
  public static final int j = 13;
  public static final int k = 14;
  public static final int l = 18;
  public static final int m = 19;
  public static final int n = 20;
  public static final int o = 21;
  public static final int p = 22;
  public static final int q = 23;
  public static final int r = 24;
  public static final int s = 25;
  public static final int t = 26;
  public static final int u = 27;
  public static final int v = 28;
  public static final int w = 29;
  public static final int x = 30;
  public static final int y = 31;
  public static final int z = 32;
  private String a;
  protected Map a;
  protected Map b;
  
  BizTroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "TroopFileHandler";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  public static long a(String paramString)
  {
    try
    {
      long l1 = Long.valueOf(paramString).longValue();
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("model", Build.MODEL);
    localJSONObject1.put("sdk", Build.VERSION.SDK_INT);
    localJSONObject1.put("os", Build.VERSION.RELEASE);
    localJSONObject1.put("cpu", DeviceInfoUtil.g());
    JSONObject localJSONObject2 = new JSONObject();
    long[] arrayOfLong = DeviceInfoUtil.b();
    localJSONObject2.put("avail", String.valueOf(arrayOfLong[1]) + "MB");
    localJSONObject2.put("total", String.valueOf(arrayOfLong[0]) + "MB");
    localJSONObject1.put("sd", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("avail", String.valueOf(DeviceInfoUtil.d() / 1024L) + "KB");
    localJSONObject2.put("total", MsfSdkUtils.getTotalMemory());
    localJSONObject1.put("memory", localJSONObject2);
    localJSONObject2 = new JSONObject();
    arrayOfLong = DeviceInfoUtil.a();
    localJSONObject2.put("avail", String.valueOf(arrayOfLong[1]) + "MB");
    localJSONObject2.put("total", String.valueOf(arrayOfLong[0]) + "MB");
    localJSONObject1.put("rom", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isFromAIO");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      if (bool) {
        this.jdField_a_of_type_JavaUtilMap.remove(str);
      }
      for (;;)
      {
        a(6, false, new Object[] { str, Boolean.valueOf(bool) });
        return;
        this.jdField_b_of_type_JavaUtilMap.remove(str);
      }
    }
    paramToServiceMsg = new group_activity_info.RspBody();
    try
    {
      paramToServiceMsg = (group_activity_info.RspBody)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.error_code.get() == 0)) {
        break label250;
      }
      if (!bool) {
        break label235;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(str);
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (bool) {
          this.jdField_a_of_type_JavaUtilMap.remove(str);
        }
        for (;;)
        {
          a(6, false, new Object[] { str, Boolean.valueOf(bool) });
          return;
          this.jdField_b_of_type_JavaUtilMap.remove(str);
        }
        this.jdField_b_of_type_JavaUtilMap.remove(str);
      }
    }
    a(6, false, new Object[] { str, Boolean.valueOf(bool) });
    return;
    label235:
    label250:
    if (bool) {
      this.jdField_a_of_type_JavaUtilMap.remove(str);
    }
    for (;;)
    {
      a(6, false, new Object[] { str, Boolean.valueOf(bool) });
      return;
      this.jdField_b_of_type_JavaUtilMap.remove(str);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    long l1 = paramToServiceMsg.extraData.getLong("troopUin");
    int i1 = paramToServiceMsg.extraData.getInt("pageIndex");
    int i2 = paramToServiceMsg.extraData.getInt("pageCount");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = (ToServiceMsg)paramObject;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
      }
      i3 = paramToServiceMsg.uint32_result.get();
      if (i3 == 0) {
        break label278;
      }
      a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) });
      return;
      label278:
      paramFromServiceMsg = new oidb_0x78f.RspBody();
    }
    if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()))
    {
      a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    }
    try
    {
      int i3;
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      try
      {
        paramToServiceMsg = HummerParser.a(l1, paramFromServiceMsg.opt_msg_record.get().toByteArray(), paramFromServiceMsg.uint32_cur_cnt.get());
        a(12, true, new Object[] { Integer.valueOf(i1), Integer.valueOf(paramFromServiceMsg.uint32_total_cnt.get()), Integer.valueOf(paramFromServiceMsg.uint32_cur_cnt.get()), paramToServiceMsg });
        return;
      }
      catch (IOException paramToServiceMsg)
      {
        a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        a(12, false, new Object[] { str, Long.valueOf(l1), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(-1) });
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg = (RecommendTroopManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramFromServiceMsg = new group_activity.RspBody();
    try
    {
      paramFromServiceMsg = (group_activity.RspBody)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_error_code.get() != 0))
      {
        paramToServiceMsg.b(null);
        a(11, false, null);
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramObject = paramFromServiceMsg.act_list.get();
    if (paramObject == null)
    {
      paramToServiceMsg.b(null);
      a(11, false, null);
      return;
    }
    paramToServiceMsg.b((List)paramObject);
    a(11, true, paramObject);
    if (NetworkUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()) == 1)
    {
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_WIFIRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_WIFIFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramToServiceMsg, paramFromServiceMsg.getSerializedSize());
      return;
      paramToServiceMsg = new String[3];
      paramToServiceMsg[0] = "param_XGRecommendTroopYunYingDownload";
      paramToServiceMsg[1] = "param_XGFlow";
      paramToServiceMsg[2] = "param_Flow";
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    int i1;
    do
    {
      return;
      i1 = paramToServiceMsg.extraData.getInt("update_sns_type");
      if (i1 == 13569)
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (i1 != 13571);
    q(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    int i1 = paramToServiceMsg.extraData.getInt("reqType");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(i1);
    arrayOfObject[2] = Integer.valueOf(-1);
    arrayOfObject[3] = null;
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(18, false, arrayOfObject);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(18, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(18, false, arrayOfObject);
      return;
    }
    paramObject = new oidb_0x5d6.RspBody();
    for (;;)
    {
      try
      {
        ((oidb_0x5d6.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = ((oidb_0x5d6.RspBody)paramObject).str_wording.get();
        int i2 = paramFromServiceMsg.uint32_result.get();
        if (i2 == 0)
        {
          paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (i1 == 0) {
            paramFromServiceMsg.a(str, paramToServiceMsg.extraData.getLong("timestamp"));
          }
        }
        else
        {
          a(18, true, new Object[] { str, Integer.valueOf(i1), Integer.valueOf(i2), paramObject });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(18, false, arrayOfObject);
        return;
      }
      if (i1 == 1) {
        paramFromServiceMsg.b(str);
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopCreatePermissionData localTroopCreatePermissionData = new TroopCreatePermissionData();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(19, false, localTroopCreatePermissionData);
      return;
    }
    int i1 = paramFromServiceMsg.getResultCode();
    if ((i1 == 1002) || (i1 == 1013))
    {
      a(19, false, localTroopCreatePermissionData);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        if (paramToServiceMsg.uint32_result.has()) {
          localTroopCreatePermissionData.d = paramToServiceMsg.uint32_result.get();
        }
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
          break label159;
        }
        a(19, false, localTroopCreatePermissionData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(19, false, localTroopCreatePermissionData);
      return;
    }
    a(19, false, localTroopCreatePermissionData);
    return;
    label159:
    paramFromServiceMsg = new oidb_0x88c.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      localTroopCreatePermissionData.a(paramFromServiceMsg.uint32_uin.get());
      if (localTroopCreatePermissionData.d != 0) {
        localTroopCreatePermissionData.b = paramFromServiceMsg.str_errorinfo.get();
      }
      localTroopCreatePermissionData.f = paramFromServiceMsg.uint32_group_mini.get();
      localTroopCreatePermissionData.g = paramFromServiceMsg.uint32_group_500.get();
      localTroopCreatePermissionData.h = paramFromServiceMsg.uint32_group_1k.get();
      localTroopCreatePermissionData.i = paramFromServiceMsg.uint32_group_2k.get();
      localTroopCreatePermissionData.j = paramFromServiceMsg.uint32_created_group_mini.get();
      localTroopCreatePermissionData.k = paramFromServiceMsg.uint32_created_group_500.get();
      localTroopCreatePermissionData.l = paramFromServiceMsg.uint32_created_group_1k.get();
      localTroopCreatePermissionData.m = paramFromServiceMsg.uint32_created_group_2k.get();
      if ((paramFromServiceMsg.uint32_group_mini_freq_avail.has()) && (paramFromServiceMsg.uint32_group_500_freq_avail.has()) && (paramFromServiceMsg.uint32_group_1k_freq_avail.has()) && (paramFromServiceMsg.uint32_group_2k_freq_avail.has()))
      {
        localTroopCreatePermissionData.n = paramFromServiceMsg.uint32_group_mini_freq_avail.get();
        localTroopCreatePermissionData.o = paramFromServiceMsg.uint32_group_500_freq_avail.get();
        localTroopCreatePermissionData.p = paramFromServiceMsg.uint32_group_1k_freq_avail.get();
        localTroopCreatePermissionData.q = paramFromServiceMsg.uint32_group_2k_freq_avail.get();
      }
      a(19, true, localTroopCreatePermissionData);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(19, false, localTroopCreatePermissionData);
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopCreateAdvanceData localTroopCreateAdvanceData = new TroopCreateAdvanceData();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(27, false, localTroopCreateAdvanceData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    localTroopCreateAdvanceData.e = paramToServiceMsg.uint32_result.get();
    paramFromServiceMsg = new cmd0x8a1.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_create_option.get() != 2))
      {
        a(27, false, localTroopCreateAdvanceData);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(27, false, localTroopCreateAdvanceData);
      return;
    }
    localTroopCreateAdvanceData.jdField_a_of_type_Long = (paramFromServiceMsg.uint32_group_uin.get() & 0xFFFFFFFF);
    localTroopCreateAdvanceData.f = paramFromServiceMsg.uint32_group_size.get();
    localTroopCreateAdvanceData.b = paramFromServiceMsg.uint32_group_code.get();
    paramObject = paramFromServiceMsg.string_sign.get().toByteArray();
    localTroopCreateAdvanceData.jdField_a_of_type_ArrayOfByte = ((byte[])paramObject);
    int i1 = 0;
    while (i1 < paramObject.length)
    {
      paramFromServiceMsg = Integer.toHexString(paramObject[i1] & 0xFF);
      paramToServiceMsg = paramFromServiceMsg;
      if (paramFromServiceMsg.length() == 1) {
        paramToServiceMsg = '0' + paramFromServiceMsg;
      }
      localTroopCreateAdvanceData.jdField_a_of_type_JavaLangString += paramToServiceMsg.toUpperCase();
      i1 += 1;
    }
    a(27, true, localTroopCreateAdvanceData);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    TroopCreateLogic.TroopCreateResult localTroopCreateResult = new TroopCreateLogic.TroopCreateResult();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(28, false, localTroopCreateResult);
    }
    for (;;)
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(28, false, localTroopCreateResult);
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null)
        {
          a(28, false, localTroopCreateResult);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(28, false, localTroopCreateResult);
        return;
      }
      int i1 = paramToServiceMsg.uint32_result.get();
      if ((i1 != 0) && ((i1 != 129) || (i1 != 130)))
      {
        localTroopCreateResult.b = i1;
        a(28, false, localTroopCreateResult);
        return;
      }
      paramFromServiceMsg = new cmd0x8a1.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_create_option.get() != 1))
        {
          a(28, false, localTroopCreateResult);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(28, false, localTroopCreateResult);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(42, false, new Object[] { Integer.valueOf(2131364297) });
    }
    for (;;)
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(42, false, new Object[] { Integer.valueOf(2131364297) });
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
        {
          a(42, false, new Object[] { Integer.valueOf(2131364297) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(42, false, new Object[] { Integer.valueOf(2131364297) });
        return;
      }
      paramFromServiceMsg = new cmd0x874.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramFromServiceMsg.uint32_code.get() != 0) {
          break label520;
        }
        paramToServiceMsg = String.valueOf(paramFromServiceMsg.msg_convert_group.uint64_conf_uin.get());
        paramFromServiceMsg = String.valueOf(paramFromServiceMsg.msg_convert_group.uint64_group_code.get());
        if (!TextUtils.isEmpty(paramFromServiceMsg)) {
          break label289;
        }
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleTransferDiscussionToTroop, troopUin:" + paramFromServiceMsg);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        i1 = 2131364297;
      }
    }
    a(42, false, new Object[] { Integer.valueOf(i1) });
    return;
    label289:
    paramObject = new TroopInfo();
    ((TroopInfo)paramObject).troopuin = paramFromServiceMsg;
    ((TroopInfo)paramObject).dwAdditionalFlag = 1L;
    Object localObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null) {
      ((TroopManager)localObject).c((TroopInfo)paramObject);
    }
    localObject = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localObject != null) {
      ((TroopHandler)localObject).a(((TroopInfo)paramObject).troopuin, (byte)0, ((TroopInfo)paramObject).dwTimeStamp, -1);
    }
    localObject = (TroopCreateLogic)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    if (localObject != null) {
      ((TroopCreateLogic)localObject).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopInfo)paramObject).troopuin);
    }
    localObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null) {
      ((TroopManager)localObject).d(((TroopManager)localObject).a(((TroopInfo)paramObject).troopuin));
    }
    paramObject = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    ((DiscussionManager)paramObject).jdField_a_of_type_JavaUtilMap.put(paramToServiceMsg, new String[] { paramFromServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() });
    ((DiscussionManager)paramObject).jdField_a_of_type_JavaUtilSet.add(paramFromServiceMsg);
    a(42, true, new Object[] { Integer.valueOf(2131364296), paramToServiceMsg, paramFromServiceMsg, Boolean.valueOf(true) });
    return;
    label520:
    int i1 = paramFromServiceMsg.uint32_code.get();
    switch (i1)
    {
    case 8: 
    case 9: 
    default: 
      i1 = 2131364297;
    }
    for (;;)
    {
      try
      {
        a(42, false, new Object[] { Integer.valueOf(i1) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      break;
      i1 = 2131364296;
      continue;
      i1 = 2131364298;
      continue;
      i1 = 2131364299;
      continue;
      i1 = 2131364300;
      continue;
      i1 = 2131364301;
      continue;
      i1 = 2131364302;
      continue;
      i1 = 2131364303;
      continue;
      i1 = 2131364304;
      continue;
      i1 = 2131364305;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(29, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(29, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(29, false, null);
      return;
    }
    paramFromServiceMsg = new oidb_0x89a.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg == null)
      {
        a(29, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(29, false, null);
      return;
    }
    int i1 = paramToServiceMsg.uint32_result.get();
    if (i1 != 0)
    {
      paramToServiceMsg = new String(paramFromServiceMsg.str_errorinfo.get().toByteArray());
      a(29, false, new Object[] { Long.valueOf(i1), paramToServiceMsg });
      return;
    }
    a(29, true, new Object[] { Long.valueOf(paramFromServiceMsg.uint64_group_code.get()), "" });
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("pageUrl");
    ArrayList localArrayList = new ArrayList();
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramFromServiceMsg = new video_url.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg.int32_result.get() != 0)
      {
        a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      a(25, false, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(-1) });
      return;
    }
    paramObject = paramFromServiceMsg.rpt_bytes_play_urls.get();
    int i1 = paramFromServiceMsg.uint32_total_time.get();
    paramFromServiceMsg = ((List)paramObject).iterator();
    while (paramFromServiceMsg.hasNext()) {
      localArrayList.add(new String(((ByteStringMicro)paramFromServiceMsg.next()).toByteArray()));
    }
    a(25, true, new Object[] { paramToServiceMsg, localArrayList, Integer.valueOf(i1) });
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("hideTroopIsHide", false);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(26, false, Boolean.valueOf(bool));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    if (paramToServiceMsg.uint32_result.get() != 0)
    {
      a(26, false, Boolean.valueOf(bool));
      return;
    }
    a(26, true, Boolean.valueOf(bool));
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isShare");
    paramToServiceMsg = new Object[4];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Boolean.valueOf(bool);
    paramToServiceMsg[2] = Integer.valueOf(-1);
    paramToServiceMsg[3] = null;
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(31, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(31, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(31, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x5d6.RspBody();
    for (;;)
    {
      try
      {
        ((oidb_0x5d6.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = ((oidb_0x5d6.RspBody)paramObject).str_wording.get();
        int i1 = paramFromServiceMsg.uint32_result.get();
        if (i1 != 0) {
          break;
        }
        paramFromServiceMsg = (TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if (bool)
        {
          paramFromServiceMsg.c(str);
          a(31, true, new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(i1), paramObject });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(31, false, paramToServiceMsg);
        return;
      }
      paramFromServiceMsg.d(str);
      paramFromServiceMsg.a(str);
    }
    a(31, false, paramToServiceMsg);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleShareLbsInTroopBeforeJoinedTroopResp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    int i1 = paramToServiceMsg.extraData.getInt("servicetype");
    String str = paramToServiceMsg.extraData.getString("troopCode");
    paramToServiceMsg = new cmd0x8b4.RspBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null))
      {
        a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i1), Integer.valueOf(0) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i1), Integer.valueOf(0) });
      return;
    }
    for (;;)
    {
      int i2;
      try
      {
        paramToServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.isSuccess()) {
          break;
        }
        if (i1 == 3)
        {
          i2 = paramToServiceMsg.uint32_flag.get();
          paramFromServiceMsg = (TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          if (i2 == 1) {
            paramFromServiceMsg.c(str);
          }
        }
        else
        {
          a(33, true, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i1), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i1), Integer.valueOf(0) });
        return;
      }
      if (i2 == 2) {
        paramFromServiceMsg.d(str);
      }
    }
    a(33, false, new Object[] { Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(i1), Integer.valueOf(0) });
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramToServiceMsg.extraData.getString("troopCode");
    paramToServiceMsg = new Object[2];
    paramToServiceMsg[0] = Long.valueOf(0L);
    paramToServiceMsg[1] = Long.valueOf(0L);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(32, false, paramToServiceMsg);
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new member_lbs.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = (TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramFromServiceMsg = (member_lbs.Location)paramFromServiceMsg.msg_location.get();
          if (paramFromServiceMsg == null) {
            break label215;
          }
          l2 = (int)paramFromServiceMsg.int64_latitude.get();
          l1 = (int)paramFromServiceMsg.int64_longitude.get();
          a(32, true, new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(32, false, paramToServiceMsg);
        paramFromServiceMsg.printStackTrace();
        return;
      }
      a(32, false, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
      return;
      label215:
      long l1 = 0L;
      long l2 = 0L;
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    for (;;)
    {
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(34, false, new Object[] { paramToServiceMsg, null });
        return;
      }
      try
      {
        paramFromServiceMsg = new member_lbs.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = (TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          long l1 = ((member_lbs.NeighbourNumber)paramFromServiceMsg.msg_neighbour_number.get()).uint64_neighbour_number.get();
          boolean bool = paramFromServiceMsg.bool_show_tips.get();
          a(34, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.jdField_a_of_type_JavaLangString + ".troop.nearby_mem", 2, "handleGetNeighbours uint64_neighbour_number:" + l1 + "|showTips:" + bool);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(34, false, new Object[] { paramToServiceMsg, null });
        paramFromServiceMsg.printStackTrace();
        return;
      }
    }
    a(34, false, new Object[] { paramToServiceMsg, paramFromServiceMsg });
  }
  
  protected Class a()
  {
    return BizTroopObserver.class;
  }
  
  public void a()
  {
    SosoInterface.a(new pui(this, 0, false, true, 60000L, false, false, this.jdField_a_of_type_JavaLangString));
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new cmd0x8a1.ReqBody();
    ((cmd0x8a1.ReqBody)localObject1).uint32_create_option.set(2);
    Object localObject2 = new cmd0x8a1.SelectGroupCodeInfo();
    ((cmd0x8a1.SelectGroupCodeInfo)localObject2).uint64_owner_uin.set(paramLong);
    ((cmd0x8a1.ReqBody)localObject1).msg_select_group_code_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2209);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8a1.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x8a1_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("type", 1);
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "BizHandler, startTroopCreateAdvance: ownerUin=" + paramLong);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, long paramLong3, long paramLong4, int paramInt6, String paramString3, byte[] paramArrayOfByte, int paramInt7, boolean paramBoolean)
  {
    cmd0x8a1.ReqBody localReqBody = new cmd0x8a1.ReqBody();
    localReqBody.uint32_create_option.set(1);
    cmd0x8a1.CreateGroupInfo localCreateGroupInfo = new cmd0x8a1.CreateGroupInfo();
    if ((paramInt4 != 0) || (paramInt7 == 3))
    {
      localCreateGroupInfo.uint32_group_code.set(0);
      localCreateGroupInfo.uint32_group_size.set(paramInt1);
      localCreateGroupInfo.uint64_owner_uin.set(paramLong2);
      localCreateGroupInfo.uint32_group_option.set(paramInt2);
      localCreateGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
      localCreateGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
      localCreateGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString2));
      localCreateGroupInfo.uint32_group_class.set(0);
      localCreateGroupInfo.uint32_group_class_ext.set(paramInt3);
      localCreateGroupInfo.uint32_conf_uin.set(paramInt4);
      localCreateGroupInfo.uint32_group_type_flag.set(paramInt5);
      if (!paramBoolean) {
        break label411;
      }
      localCreateGroupInfo.uint32_group_face_flag.set(0);
      label168:
      paramString1 = new cmd0x8a1.GroupGeoInfo();
      paramString1.uint32_city_id.set(paramInt6);
      paramString1.uint64_latitude.set(paramLong3);
      paramString1.uint64_longtitude.set(paramLong4);
      paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString3));
      localCreateGroupInfo.msg_group_geo_info.set(paramString1);
      if ((paramInt4 == 0) && (paramInt7 != 3)) {
        localCreateGroupInfo.string_sign.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      if ((paramInt4 == 0) && (paramInt7 != 3)) {
        break label423;
      }
      localCreateGroupInfo.uint64_create_flag.set(128L);
    }
    for (;;)
    {
      localCreateGroupInfo.uint32_group_face.set(0);
      localCreateGroupInfo.uint32_app_id.set(200000007);
      localReqBody.msg_create_group_info.set(localCreateGroupInfo);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2209);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = a("OidbSvc.0x8a1_0");
      paramString2.putWupBuffer(paramString1.toByteArray());
      paramString2.extraData.putInt("type", 2);
      b(paramString2);
      return;
      localCreateGroupInfo.uint32_group_code.set((int)paramLong1);
      break;
      label411:
      localCreateGroupInfo.uint32_group_face_flag.set(1);
      break label168;
      label423:
      localCreateGroupInfo.uint64_create_flag.set(0L);
    }
  }
  
  public void a(long paramLong1, int paramInt1, String paramString1, long paramLong2, List paramList, int paramInt2, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString + ".troop.location_info", 2, "modifyTroopInfoBy0x89a==>cityId:" + paramInt2 + "|lat:" + paramLong3 + "|lon:" + paramLong4);
    }
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.uint32_group_type_flag.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      localgroupinfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    localgroupinfo.uint32_group_class_ext.set((int)paramLong2);
    paramString1 = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      if (!TextUtils.isEmpty((CharSequence)paramList.get(paramInt1))) {
        paramString1.add(ByteStringMicro.copyFromUtf8((String)paramList.get(paramInt1)));
      }
      paramInt1 += 1;
    }
    if (paramString1.size() == 0) {
      paramString1.add(ByteStringMicro.copyFrom("".getBytes()));
    }
    localgroupinfo.rpt_string_group_tag.set(paramString1);
    if ((paramLong3 != 0L) || (paramLong4 != 0L))
    {
      paramString1 = new oidb_0x89a.GroupGeoInfo();
      paramString1.uint32_city_id.set(paramInt2);
      paramString1.uint64_latitude.set(paramLong3);
      paramString1.uint64_longtitude.set(paramLong4);
      if (paramString2 != null) {
        paramString1.string_geo_content.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      paramString1.uint64_poi_id.set(paramLong5);
      localgroupinfo.msg_group_geo_info.set(paramString1);
    }
    if (paramString3 != null)
    {
      localgroupinfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
      localgroupinfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.st_group_info.set(localgroupinfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2202);
    paramString1.uint32_result.set(0);
    paramString1.uint32_service_type.set(0);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramList = a("OidbSvc.0x89a_0");
    paramList.putWupBuffer(paramString1.toByteArray());
    paramList.extraData.putInt("key_subcmd", 1);
    b(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "onReceive");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "res.getServiceCmd():" + paramFromServiceMsg.getServiceCmd());
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        long l1;
        long l2;
        int i2;
        do
        {
          do
          {
            do
            {
              do
              {
                int i3;
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
                          if (!"OidbSvc.0x8a1_0".equals(str)) {
                            break;
                          }
                          if (paramToServiceMsg.extraData.getInt("type", 0) == 1)
                          {
                            k(paramToServiceMsg, paramFromServiceMsg, paramObject);
                            return;
                          }
                        } while (paramToServiceMsg.extraData.getInt("type", 0) != 2);
                        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
                        return;
                        if ("OidbSvc.0x874_1".equals(str))
                        {
                          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
                          return;
                        }
                        if ((!"OidbSvc.0x89a_0".equals(str)) && (!"OidbSvc.0x570_8".equals(str))) {
                          break;
                        }
                        i1 = paramToServiceMsg.extraData.getInt("key_subcmd", -1);
                        if (i1 == 1)
                        {
                          n(paramToServiceMsg, paramFromServiceMsg, paramObject);
                          return;
                        }
                        if (i1 == 2)
                        {
                          ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                          return;
                        }
                      } while (i1 != 3);
                      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                      if (!"OidbSvc.0x89a_8".equals(str)) {
                        break;
                      }
                    } while (paramToServiceMsg.extraData.getInt("key_subcmd", -1) != 3);
                    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                    if ("CommunityForum.GetLatestPost".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {}
                      for (bool = true;; bool = false)
                      {
                        a(4, bool, paramObject);
                        return;
                      }
                    }
                    if ("OpenGroupSvc.GroupActivityInfo".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("GroupActivity.GetList".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("OidbSvc.0x78f_1".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("OidbSvc.0x5d6_1".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("OidbSvc.0x88c_1".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if (!"OidbSvc.0x580_1".equals(paramFromServiceMsg.getServiceCmd())) {
                      break;
                    }
                  } while (paramFromServiceMsg.getResultCode() != 1000);
                  i1 = paramToServiceMsg.extraData.getInt("appId");
                  l1 = paramToServiceMsg.extraData.getLong("troopUin");
                  l2 = paramToServiceMsg.extraData.getLong("troopCode");
                  l3 = paramToServiceMsg.extraData.getLong("userUin");
                  paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
                  i2 = paramToServiceMsg.extraData.getInt("time");
                  str = paramToServiceMsg.extraData.getString("cmd");
                  i3 = paramToServiceMsg.extraData.getInt("feedType");
                  bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
                  paramToServiceMsg = (byte[])paramObject;
                  paramToServiceMsg = TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, l3, paramFromServiceMsg, i2, paramToServiceMsg);
                } while ((TextUtils.isEmpty(str)) || (paramToServiceMsg == null));
                short s1 = (short)paramToServiceMsg.length;
                if ("OidbSvc.0x852_35".equals(str))
                {
                  TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, s1, paramToServiceMsg, l3, paramFromServiceMsg, i2);
                  return;
                }
                if ("OidbSvc.0x852_48".equals(str))
                {
                  TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, s1, paramToServiceMsg, (short)i3, bool);
                  return;
                }
              } while (!"OidbSvc.0x8ca_2".equals(str));
              ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "" + l1, paramToServiceMsg);
              return;
              if (!"OidbSvc.0x852_35".equals(paramFromServiceMsg.getServiceCmd())) {
                break;
              }
            } while (paramFromServiceMsg.getResultCode() != 1000);
            i1 = paramToServiceMsg.extraData.getInt("appId");
            l1 = paramToServiceMsg.extraData.getLong("troopUin");
            l2 = paramToServiceMsg.extraData.getLong("troopCode");
            long l3 = paramToServiceMsg.extraData.getLong("userUin");
            paramFromServiceMsg = paramToServiceMsg.extraData.getString("feedsId");
            i2 = paramToServiceMsg.extraData.getInt("time");
            paramToServiceMsg = (byte[])paramObject;
            TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, l2, l3, paramFromServiceMsg, i2, paramToServiceMsg);
            return;
            if (!"OidbSvc.0x852_48".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
          } while (paramFromServiceMsg.getResultCode() != 1000);
          i1 = paramToServiceMsg.extraData.getInt("appId");
          l1 = paramToServiceMsg.extraData.getLong("troopUin");
          l2 = paramToServiceMsg.extraData.getLong("troopCode");
          paramToServiceMsg.extraData.getLong("userUin");
          paramToServiceMsg.extraData.getString("feedsId");
          paramToServiceMsg.extraData.getInt("time");
          i2 = paramToServiceMsg.extraData.getInt("feedType");
          boolean bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
          paramToServiceMsg = (byte[])paramObject;
          paramToServiceMsg = TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2, paramToServiceMsg, i2, i1);
          if ((paramToServiceMsg != null) && (bool))
          {
            BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).edit().putBoolean(String.valueOf(l2), true).commit();
            a(24, true, Long.valueOf(l2));
            return;
          }
          if ((i2 == 23) && (paramToServiceMsg != null))
          {
            a(21, true, paramToServiceMsg);
            return;
          }
        } while ((i2 != 34) || (paramToServiceMsg == null));
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramObject = new ArrayList();
        ((ArrayList)paramObject).add(paramToServiceMsg);
        int i1 = (int)MessageCache.a();
        paramFromServiceMsg.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), String.valueOf(l2), (ArrayList)paramObject, 34, i1, 0);
        paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.sendEmptyMessage(1009);
        }
        BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 4).edit().putBoolean(String.valueOf(l2), true).commit();
        return;
        if ("VideoShareSrv.get_video_src".equals(paramFromServiceMsg.getServiceCmd()))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x568_22".equals(paramFromServiceMsg.getServiceCmd()))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x568_21".equals(paramFromServiceMsg.getServiceCmd()))
        {
          p(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("GrpMemberLBS.ReportLBS".equals(paramFromServiceMsg.getServiceCmd()))
        {
          s(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
        {
          r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"OidbSvc.0x5d6_3".equals(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        str = paramToServiceMsg.extraData.getString("bizname");
      } while ((str == null) || (!str.equals("shareSelfLbs")));
      q(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("GrpMemberLBS.GetNeighbours".equals(paramFromServiceMsg.getServiceCmd()))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ModifyExamine.GetModifyTimes".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupFileAppSvr.GetFileInfo".equals(str))
      {
        a(39, true, paramObject);
        return;
      }
    } while (!"GroupFileAppSvr.GetFileSearch".equals(str));
    a(41, true, paramObject);
  }
  
  public void a(Object paramObject)
  {
    a(9, true, paramObject);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "CommunityForum.GetLatestPost");
    CommunityForumLatestPost.ReqBody localReqBody = new CommunityForumLatestPost.ReqBody();
    try
    {
      localReqBody.troop_uin.set(a(paramString));
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "get community forum latest posts, send pb request, params : troopUin, NumberFormatException");
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
    ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13569);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramInt == 0)
    {
      int i1 = (byte)(int)(l1 >> 24 & 0xFF);
      int i2 = (byte)(int)(l1 >> 16 & 0xFF);
      int i3 = (byte)(int)(l1 >> 8 & 0xFF);
      int i4 = (byte)(int)(l1 & 0xFF);
      ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i1, i2, i3, i4 }));
    }
    for (;;)
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(a(paramString));
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set((List)localObject1);
      localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(11);
      ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
      paramString = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramString);
      localObject2 = a("OidbSvc.0x5d6_1");
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject2).extraData.putInt("reqType", paramInt);
      ((ToServiceMsg)localObject2).extraData.putLong("timestamp", l1);
      ((ToServiceMsg)localObject2).extraData.putInt("update_sns_type", 13569);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      b((ToServiceMsg)localObject2);
      return;
      if (paramInt != 1) {}
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(40, true, new Object[] { paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    int i1 = 1;
    paramString1 = new cmd0x8b4.ReqBody();
    paramString1.uint64_gc.set(Long.parseLong(paramString2));
    Object localObject;
    if (paramInt == 3)
    {
      localObject = paramString1.uint32_flag;
      if (paramBoolean != true) {
        break label148;
      }
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(i1);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2228);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
      paramString1 = a("OidbSvc.0x8b4");
      paramString1.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      paramString1.extraData.putLong("troop_code", Long.parseLong(paramString2));
      paramString1.extraData.putInt("servicetype", paramInt);
      paramString1.extraData.putString("troopCode", paramString2);
      b(paramString1);
      return;
      label148:
      i1 = 2;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ByteBuffer.allocate(5);
    for (;;)
    {
      try
      {
        ((ByteBuffer)localObject).putInt(Integer.valueOf(paramString).intValue());
        if (!paramBoolean) {
          break label155;
        }
        ((ByteBuffer)localObject).put((byte)1);
        localObject = ((ByteBuffer)localObject).array();
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1384);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(22);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
        localObject = a("OidbSvc.0x568_22");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        ((ToServiceMsg)localObject).extraData.putBoolean("isAllowAnonymousChat", paramBoolean);
        b((ToServiceMsg)localObject);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setAnonymousChat failed because NumberFormatException, troopUin : " + paramString);
      return;
      label155:
      localNumberFormatException.put((byte)0);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i1 = 1;
    Object localObject = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString).longValue());
    paramString = new oidb_0x89a.groupinfo();
    int i2;
    if (paramBoolean3) {
      if (!paramBoolean4) {
        i2 = 1;
      }
    }
    for (;;)
    {
      int i4 = i1;
      int i3 = i2;
      if (paramBoolean1)
      {
        i2 |= 0x2;
        i4 = i1;
        i3 = i2;
        if (!paramBoolean2)
        {
          i4 = i1 | 0x2;
          i3 = i2;
        }
      }
      if (i3 == 0) {
        return;
      }
      paramString.uint32_app_privilege_mask.set(i3);
      paramString.uint32_app_privilege_flag.set(i4);
      ((oidb_0x89a.ReqBody)localObject).st_group_info.set(paramString);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2202);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(8);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject).toByteArray()));
      localObject = a("OidbSvc.0x89a_8");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("key_subcmd", 3);
      b((ToServiceMsg)localObject);
      return;
      i2 = 1;
      i1 = 0;
      continue;
      i1 = 0;
      i2 = 0;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    if (paramBundle != null) {
      paramString.extraData = paramBundle;
    }
    b(paramString);
  }
  
  public void a(List paramList)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "GroupActivity.GetList");
    group_activity.ReqBody localReqBody = new group_activity.ReqBody();
    if ((paramList != null) && (paramList.size() != 0)) {
      localReqBody.uint32_act_id.addAll(paramList);
    }
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    b(localToServiceMsg);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89b_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8a1_0");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.DelFile");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileList");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileListV2");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileInfo");
      this.jdField_b_of_type_JavaUtilSet.add("GroupFileAppSvr.GetFileSearch");
      this.jdField_b_of_type_JavaUtilSet.add("CommunityForum.GetLatestPost");
      this.jdField_b_of_type_JavaUtilSet.add("OpenGroupSvc.GroupActivityInfo");
      this.jdField_b_of_type_JavaUtilSet.add("GroupActivity.GetList");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x78f_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d6_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d6_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8cf_6");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8d3_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x852_35");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x580_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x88c_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x852_48");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89a_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89a_8");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x570_8");
      this.jdField_b_of_type_JavaUtilSet.add("VideoShareSrv.get_video_src");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x568_22");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x568_21");
      this.jdField_b_of_type_JavaUtilSet.add("GrpMemberLBS.ReportLBS");
      this.jdField_b_of_type_JavaUtilSet.add("GrpMemberLBS.GetNeighbours");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_b_of_type_JavaUtilSet.add("ModifyExamine.GetModifyTimes");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x874_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x904_1");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = new oidb_0x78f.ReqBody();
    ((oidb_0x78f.ReqBody)localObject1).group_code.set(a(paramString));
    ((oidb_0x78f.ReqBody)localObject1).num_per_page.set(paramInt2);
    ((oidb_0x78f.ReqBody)localObject1).page_id.set(paramInt1);
    ((oidb_0x78f.ReqBody)localObject1).time_end.set(paramInt3);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(Integer.valueOf(3));
    ((oidb_0x78f.ReqBody)localObject1).elem_type_list.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1935);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x78f.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x78f_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("troopCode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("pageIndex", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("pageCount", paramInt2);
    ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong);
    b((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return b(paramString);
    }
    return c(paramString);
  }
  
  public void b(long paramLong)
  {
    Object localObject1 = new cmd0x874.ReqBody();
    ((cmd0x874.ReqBody)localObject1).uint32_subcmd.set(1);
    Object localObject2 = new cmd0x874.ConvertToGroupReq();
    ((cmd0x874.ConvertToGroupReq)localObject2).uint64_conf_uin.set(paramLong);
    ((cmd0x874.ReqBody)localObject1).msg_convert_group.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2164);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x874.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x874_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("isAllowAnonymousChat", false);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(30, false, Boolean.valueOf(bool));
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(30, false, Boolean.valueOf(bool));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(30, false, Boolean.valueOf(bool));
      return;
    }
    if (paramToServiceMsg.uint32_result.get() != 0)
    {
      a(30, false, Boolean.valueOf(bool));
      return;
    }
    a(30, true, Boolean.valueOf(bool));
  }
  
  public void b(Object paramObject)
  {
    a(13, true, paramObject);
  }
  
  public void b(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "VideoShareSrv.get_video_src");
    Object localObject = ByteStringMicro.copyFrom(paramString.getBytes());
    video_url.ReqBody localReqBody = new video_url.ReqBody();
    localReqBody.bytes_share_url.set((ByteStringMicro)localObject);
    localReqBody.uint32_platform_type.set(2);
    try
    {
      localObject = a();
      localReqBody.bytes_machine_info.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      i1 = NetworkUtil.a(BaseApplication.getContext());
      if (i1 == 2)
      {
        localReqBody.uint32_network_type.set(1);
        localReqBody.uint32_cur_play_time.set(0);
        localReqBody.bytes_mobileQ_ver.set(ByteStringMicro.copyFrom("6.5.5".getBytes()));
        localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
        localToServiceMsg.extraData.putString("pageUrl", paramString);
        b(localToServiceMsg);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        String str = "";
        continue;
        if (i1 == 3) {
          localReqBody.uint32_network_type.set(2);
        } else if (i1 == 4) {
          localReqBody.uint32_network_type.set(3);
        } else if (i1 == 1) {
          localReqBody.uint32_network_type.set(4);
        } else {
          localReqBody.uint32_network_type.set(255);
        }
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    modifyexamine.ReqBody localReqBody = new modifyexamine.ReqBody();
    localReqBody.uint64_gc.set(Long.valueOf(paramString1).longValue());
    localReqBody.skey.set(paramString2);
    paramString1 = a("ModifyExamine.GetModifyTimes");
    paramString1.putWupBuffer(localReqBody.toByteArray());
    b(paramString1);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(5);
    ((ByteBuffer)localObject).putInt((int)Long.valueOf(paramString).longValue());
    if (paramBoolean) {
      ((ByteBuffer)localObject).put((byte)1);
    }
    for (;;)
    {
      localObject = ((ByteBuffer)localObject).array();
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1384);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(21);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = a("OidbSvc.0x568_21");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("hideTroopIsHide", paramBoolean);
      b((ToServiceMsg)localObject);
      return;
      ((ByteBuffer)localObject).put((byte)0);
    }
  }
  
  protected boolean b(String paramString)
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "OGroupActiInterval");
    long l1;
    if ((str == null) || ("".equals(str)))
    {
      l1 = 86400L;
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break label253;
      }
    }
    label253:
    for (long l2 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();; l2 = 0L)
    {
      long l3 = System.currentTimeMillis() / 1000L;
      if ((l2 != 0L) && (l3 - l2 < l1))
      {
        return false;
        try
        {
          l1 = Long.valueOf(str).longValue();
        }
        catch (Exception localException)
        {
          l1 = 86400L;
        }
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l3));
      group_activity_info.ReqBody localReqBody = new group_activity_info.ReqBody();
      localReqBody.group_code.set(a(paramString));
      localReqBody.type.set(2);
      localReqBody.big_pic.set(true);
      localReqBody.small_pic.set(false);
      localReqBody.title.set(true);
      localReqBody.summary.set(true);
      localReqBody.url.set(true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OpenGroupSvc.GroupActivityInfo");
      localToServiceMsg.extraData.putString("troopCode", paramString);
      localToServiceMsg.extraData.putBoolean("isFromAIO", true);
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return true;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(36, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(36, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(36, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(36, false, null);
      return;
    }
    int i1 = paramToServiceMsg.uint32_result.get();
    if (i1 != 0)
    {
      a(36, false, new Object[] { Long.valueOf(i1) });
      return;
    }
    paramFromServiceMsg = new oidb_0x89a.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg == null)
      {
        a(36, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(36, false, null);
      return;
    }
    a(36, true, new Object[] { Long.valueOf(paramFromServiceMsg.uint64_group_code.get()) });
  }
  
  public void c(Object paramObject)
  {
    a(20, true, paramObject);
  }
  
  public void c(String paramString)
  {
    Object localObject = new oidb_0x88c.ReqBody();
    ((oidb_0x88c.ReqBody)localObject).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88c.ReqBody)localObject).uint32_uin.set((int)Long.parseLong(paramString));
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2188);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88c.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x88c_1");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    int i2 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopMemberDistance", 2, "BizHandler, setShareSelfLbsInTroop:" + paramString + ", " + paramBoolean);
    }
    Object localObject2 = new oidb_0x5d6.SnsUpdateItem();
    ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_update_sns_type.set(13571);
    if (paramBoolean) {
      i2 = 1;
    }
    if (paramBoolean) {}
    for (int i1 = (byte)(i2 & 0x1);; i1 = (byte)(i2 & 0x2))
    {
      ((oidb_0x5d6.SnsUpdateItem)localObject2).bytes_value.set(ByteStringMicro.copyFrom(new byte[] { i1 }));
      ((oidb_0x5d6.SnsUpdateItem)localObject2).uint32_value_offset.set(0);
      Object localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(a(paramString));
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set((List)localObject1);
      localObject1 = new ArrayList();
      ((List)localObject1).add(localObject2);
      localObject2 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(11);
      ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(3);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
      TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = a("OidbSvc.0x5d6_3");
      paramString = localTroopManager.b(paramString);
      ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject2).extraData.putString("bizname", "shareSelfLbs");
      ((ToServiceMsg)localObject2).extraData.putBoolean("isShare", paramBoolean);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      b((ToServiceMsg)localObject2);
      return;
    }
  }
  
  protected boolean c(String paramString)
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "OGroupActiInterval");
    long l1;
    if ((str == null) || ("".equals(str)))
    {
      l1 = 86400L;
      if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
        break label253;
      }
    }
    label253:
    for (long l2 = ((Long)this.jdField_b_of_type_JavaUtilMap.get(paramString)).longValue();; l2 = 0L)
    {
      long l3 = System.currentTimeMillis() / 1000L;
      if ((l2 != 0L) && (l3 - l2 < l1))
      {
        return false;
        try
        {
          l1 = Long.valueOf(str).longValue();
        }
        catch (Exception localException)
        {
          l1 = 86400L;
        }
        break;
      }
      this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(l3));
      group_activity_info.ReqBody localReqBody = new group_activity_info.ReqBody();
      localReqBody.group_code.set(a(paramString));
      localReqBody.type.set(1);
      localReqBody.big_pic.set(false);
      localReqBody.small_pic.set(true);
      localReqBody.title.set(true);
      localReqBody.summary.set(true);
      localReqBody.url.set(true);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "OpenGroupSvc.GroupActivityInfo");
      localToServiceMsg.extraData.putString("troopCode", paramString);
      localToServiceMsg.extraData.putBoolean("isFromAIO", false);
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return true;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l3 = -1L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(38, false, null);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(38, false, null);
      return;
    }
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(38, false, null);
      return;
    }
    paramToServiceMsg = (byte[])paramObject;
    paramFromServiceMsg = new modifyexamine.RspBody();
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label236;
        }
        l1 = paramFromServiceMsg.uint32_result.get();
        if (!paramFromServiceMsg.uint32_limit_times.has()) {
          break label228;
        }
        l2 = paramFromServiceMsg.uint32_limit_times.get();
        if (paramFromServiceMsg.uint32_modify_times.has()) {
          l3 = paramFromServiceMsg.uint32_modify_times.get();
        }
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_errmsg.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_errmsg.get();
        }
        a(38, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), paramToServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onRspResend parsing error");
      return;
      label228:
      long l2 = -1L;
      continue;
      label236:
      long l1 = -1L;
    }
  }
  
  public void d(Object paramObject)
  {
    a(14, true, paramObject);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "GrpMemberLBS.GetNeighbours");
    member_lbs.ReqBody localReqBody = new member_lbs.ReqBody();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
      localReqBody.bool_need_neighbours.set(paramBoolean);
      localToServiceMsg.extraData.putString("troopUin", paramString);
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      b(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString + ".troop.nearby_mem", 2, "getNearbyTroopMemberCount, send pb request, params : troopUin, NumberFormatException");
        }
      }
    }
  }
  
  public void e(Object paramObject)
  {
    a(22, true, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\BizTroopHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */