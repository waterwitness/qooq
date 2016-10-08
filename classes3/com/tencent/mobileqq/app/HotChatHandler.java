package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.HCSeatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupNextVisitor;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupUinCode;
import tencent.im.oidb.cmd0x897.cmd0x897.ReqBody;
import tencent.im.oidb.cmd0x897.cmd0x897.RspBody;
import tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ExitPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.RspBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.ReqBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.ReqBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.groupinfo;
import tencent.im.oidb.cmd0xa81.oidb_0xa81.ReqBody;
import tencent.im.oidb.cmd0xa81.oidb_0xa81.RspBody;
import tencent.im.oidb.cmd0xa88.oidb_0xa88.ReqBody;
import tencent.im.oidb.cmd0xa88.oidb_0xa88.RspBody;
import tencent.im.oidb.cmd0xa8a.oidb_0xa8a.MsgBodyInfo;
import tencent.im.oidb.cmd0xa8a.oidb_0xa8a.ReqBody;
import tencent.im.oidb.cmd0xa8a.oidb_0xa8a.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import tencent.im.oidb.hotchat.CreateHotChat.ReqBody;
import tencent.im.oidb.hotchat.CreateHotChat.RspBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.ReqBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.RspBody;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.GPS;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;
import tencent.im.oidb.hotchat.cmd0x8a3_7.ReqBody;
import tencent.im.oidb.hotchat.cmd0x8a3_7.RspBody;
import tencent.im.oidb.hotchat.oidb_0x8a8.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.RspBody;
import tencent.im.oidb.hotchat.oidb_0xa8b.DeletePoid;
import tencent.im.oidb.hotchat.oidb_0xa8b.ReqBody;
import tencent.im.oidb.hotchat.oidb_0xa8b.RspBody;
import tencent.im.oidb.hotchat.oidb_0xa8b.StorePoid;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class HotChatHandler
  extends BusinessHandler
  implements Handler.Callback
{
  public static final String a = "退出热聊失败";
  public static final String b = "退出热聊成功";
  public static final String c = "加入热聊失败，请稍后再试。";
  private static final String d = HotChatHandler.class.getSimpleName();
  final Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.b(), this);
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  HotChatHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static String a()
  {
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.add(5, 1);
    localDate = localCalendar.getTime();
    return new SimpleDateFormat("yyyyMMdd").format(localDate);
  }
  
  public static LBS.LBSInfo a(boolean paramBoolean)
  {
    LBS.LBSInfo localLBSInfo = new LBS.LBSInfo();
    SosoInterface.a(3600000L, HotChatHandler.class.getSimpleName());
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    Object localObject2 = new LBS.GPS();
    ((LBS.GPS)localObject2).latitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
    ((LBS.GPS)localObject2).longitude.set((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
    ((LBS.GPS)localObject2).altitude.set(-1);
    ((LBS.GPS)localObject2).coordinate.set(0);
    localLBSInfo.gps.set((MessageMicro)localObject2);
    Object localObject3;
    if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
    {
      localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
        LBS.Wifi localWifi = new LBS.Wifi();
        localWifi.mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
        localWifi.rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
        localLBSInfo.rpt_wifi.add(localWifi);
      }
    }
    if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localObject3 = new LBS.Cell();
        ((LBS.Cell)localObject3).mcc.set(((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int);
        ((LBS.Cell)localObject3).mnc.set(((SosoInterface.SosoCell)localObject2).b);
        ((LBS.Cell)localObject3).lac.set(((SosoInterface.SosoCell)localObject2).c);
        ((LBS.Cell)localObject3).cellid.set(((SosoInterface.SosoCell)localObject2).d);
        ((LBS.Cell)localObject3).rssi.set(((SosoInterface.SosoCell)localObject2).e);
        localLBSInfo.rpt_cell.add((MessageMicro)localObject3);
      }
    }
    localObject1 = new LBS.Attribute();
    localObject2 = DeviceInfoUtil.a();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imei.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localObject2 = DeviceInfoUtil.b();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((LBS.Attribute)localObject1).imsi.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
    }
    localLBSInfo.attribute.set((MessageMicro)localObject1);
    return localLBSInfo;
  }
  
  public static LBS.Wifi a()
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!((WifiManager)localObject1).isWifiEnabled()) {
      return null;
    }
    Object localObject2 = ((WifiManager)localObject1).getConnectionInfo();
    localObject1 = HotChatManager.a((WifiInfo)localObject2);
    long l = SosoInterface.SosoWifi.a(((WifiInfo)localObject2).getBSSID());
    int i = ((WifiInfo)localObject2).getRssi();
    localObject2 = new LBS.Wifi();
    ((LBS.Wifi)localObject2).rssi.set(i);
    ((LBS.Wifi)localObject2).essid.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
    ((LBS.Wifi)localObject2).mac.set(l);
    return (LBS.Wifi)localObject2;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleGetMyHostChatListRespError timeOut: " + paramBoolean);
    }
    a(1031, false, null);
    if (paramBoolean) {
      ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(null);
    }
  }
  
  private void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    int i = 2;
    int j = 0;
    if (QLog.isColorLevel()) {
      NearbyUtils.a(d, new Object[] { "createHotChat", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramWifiPOIInfo });
    }
    if (paramWifiPOIInfo == null) {
      return;
    }
    Object localObject = paramWifiPOIInfo.uint32_wifi_poi_type;
    if (paramBoolean) {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localObject = HotChatInfo.createHotChat(paramWifiPOIInfo, paramBoolean, paramInt);
    CreateHotChat.ReqBody localReqBody = new CreateHotChat.ReqBody();
    localReqBody.create_req_info.setHasFlag(true);
    localReqBody.create_req_info.set(paramWifiPOIInfo);
    paramInt = j;
    if (paramBoolean)
    {
      paramWifiPOIInfo = a(true);
      if (paramWifiPOIInfo != null) {
        localReqBody.lbs_info.set(paramWifiPOIInfo);
      }
      paramInt = 1;
    }
    paramWifiPOIInfo = a("OidbSvc.0x8a2", 2210, paramInt, localReqBody.toByteArray(), 10000L);
    paramWifiPOIInfo.extraData.putSerializable("HOT_CHAT_INFO", (Serializable)localObject);
    b(paramWifiPOIInfo);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "<<---handleError serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, false);
    }
    do
    {
      do
      {
        return;
        if (!"OidbSvc.0x89b_3".equals(str)) {
          break;
        }
        if (paramToServiceMsg.extraData.getBoolean("kick", false))
        {
          m(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
      e(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("OidbSvc.0x8a2".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8a8".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8ab".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8b3".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8b2".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa81".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x88d_0".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x89a_0".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa8b".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa88".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa8a".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x897_0".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x8a3_7".equals(str));
    switch (paramToServiceMsg.extraData.getInt("flag"))
    {
    default: 
      return;
    case 1: 
      b(paramToServiceMsg, paramFromServiceMsg, null, true);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, null, true);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("OidbSvc.0x8a4".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, true);
    }
    do
    {
      do
      {
        return;
        if (!"OidbSvc.0x89b_3".equals(str)) {
          break;
        }
        if (paramToServiceMsg.extraData.getBoolean("kick", false))
        {
          m(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
      e(paramToServiceMsg, paramFromServiceMsg);
      return;
      if ("OidbSvc.0x8a2".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8a8".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8ab".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8b3".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8b2".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa81".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x88d_0".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x89a_0".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa8b".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa88".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa8a".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x897_0".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x8a3_7".equals(str));
    switch (paramToServiceMsg.extraData.getInt("flag"))
    {
    default: 
      return;
    case 1: 
      b(paramToServiceMsg, paramFromServiceMsg, null, true);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, null, true);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleExtHotChatRespErrorOrTimeOut()");
    }
    a(1033, false, new Object[] { paramToServiceMsg.extraData.getString("troopUin"), "退出热聊失败" });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleExitHotChatResp()");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(1033, false, new Object[] { str, "退出热聊失败" });
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg == null)
      {
        a(1033, false, new Object[] { str, "退出热聊失败" });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg = null;
      }
      if (!paramFromServiceMsg.uint32_result.has())
      {
        a(1033, false, new Object[] { str, "退出热聊失败" });
        return;
      }
      int i = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i(d, 2, "handleExitHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramToServiceMsg = (HotChatManager.HotChatStateWrapper)paramToServiceMsg.extraData.getSerializable("targetHotChatState");
        paramFromServiceMsg = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        paramFromServiceMsg.a(paramFromServiceMsg.a(str), paramToServiceMsg);
        a(1033, true, new Object[] { str, "退出热聊成功" });
        return;
      }
      a(1033, false, new Object[] { str, "退出热聊失败" });
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (HotChatInfo)paramToServiceMsg.extraData.get("HOT_CHAT_INFO");
    a(1032, false, new Object[] { paramToServiceMsg.troopUin, "加入热聊失败，请稍后再试。", paramToServiceMsg.name });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    HotChatInfo localHotChatInfo = (HotChatInfo)paramToServiceMsg.extraData.getSerializable("HOT_CHAT_INFO");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isWifiHotChat", false);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg == null)
      {
        a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = null;
      }
      if (!paramToServiceMsg.uint32_result.has())
      {
        a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
        return;
      }
      int i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i(d, 2, "handleCreateHotChatResp result " + i);
      }
      if (i == 0)
      {
        paramFromServiceMsg = new CreateHotChat.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l1 = Utils.a(paramFromServiceMsg.uint32_group_code.get());
          long l2 = Utils.a(paramFromServiceMsg.uint32_group_uin.get());
          localHotChatInfo.troopUin = String.valueOf(l1);
          localHotChatInfo.troopCode = String.valueOf(l2);
          localHotChatInfo.state = 0;
          ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(localHotChatInfo, 4);
          a(1032, true, new Object[] { "加群成功", localHotChatInfo.troopCode, localHotChatInfo.troopUin, localHotChatInfo.name, Boolean.valueOf(bool) });
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          a(1032, false, new Object[] { localHotChatInfo.troopUin, "加入热聊失败，请稍后再试。", localHotChatInfo.name });
          return;
        }
      }
      switch (i)
      {
      case 1284: 
      case 1285: 
      case 1286: 
      case 1287: 
      case 1288: 
      case 1289: 
      default: 
        paramToServiceMsg = "加入热聊失败，请稍后再试。";
      }
    }
    for (;;)
    {
      a(1032, false, new Object[] { localHotChatInfo.troopUin, paramToServiceMsg, localHotChatInfo.name });
      return;
      paramToServiceMsg = "你加入的热聊已达到数量上限，请退出其他热聊后再试。";
      continue;
      paramToServiceMsg = "由于你发表了不良信息，暂不允许加入热聊。";
      continue;
      paramToServiceMsg = "退出热聊失败，请稍后再试。";
      continue;
      paramToServiceMsg = "获取位置失败，无法加入热聊。";
      continue;
      paramToServiceMsg = "WiFi热聊已失效，无法加入。";
      continue;
      paramToServiceMsg = "WiFi热聊已失效，无法加入。";
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleReportWifiRespErrorOrTimeOut");
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = false;
    paramToServiceMsg = new GetJoinedHotChatList.RspBody();
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label299;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label293;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {}
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.i(d, 2, "handleGetMyHotChatListResp isSuccess: " + bool + ", result:" + i + ",resp=" + paramToServiceMsg);
          }
          if (paramToServiceMsg == null) {
            break label279;
          }
          paramFromServiceMsg = paramToServiceMsg.rpt_msg_wifi_poi_info.get();
          paramToServiceMsg = new ArrayList();
          if (paramFromServiceMsg == null) {
            continue;
          }
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          if (!paramFromServiceMsg.hasNext()) {
            continue;
          }
          paramObject = (Common.WifiPOIInfo)paramFromServiceMsg.next();
          if (((Common.WifiPOIInfo)paramObject).uint32_wifi_poi_type.get() != 1) {
            continue;
          }
          bool = true;
          paramToServiceMsg.add(HotChatInfo.createHotChat((Common.WifiPOIInfo)paramObject, bool));
          continue;
          bool = false;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        i = 0;
        bool = false;
        paramToServiceMsg = null;
        continue;
        bool = false;
        continue;
        ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramToServiceMsg);
        a(1031, true, null);
        return;
      }
      label279:
      a(1031, false, null);
      return;
      label293:
      int i = 0;
      continue;
      label299:
      i = 0;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleQuickJoinHotChatErrorOrTimeOut");
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    System.out.println("-----> handleReportWifi");
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("uid");
    int i = paramFromServiceMsg.getResultCode();
    a(1035, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleSetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + paramToServiceMsg);
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("hotnamecode");
    int j = paramToServiceMsg.extraData.getInt("HOTCHAT_EXTRA_FLAG");
    int k = paramToServiceMsg.extraData.getInt("preHotChatState");
    Object localObject1 = null;
    paramToServiceMsg = null;
    Object localObject2 = new oidb_0x8ab.RspBody();
    int m = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    if (m == 0) {
      paramFromServiceMsg = (FromServiceMsg)localObject1;
    }
    for (;;)
    {
      try
      {
        if (((oidb_0x8ab.RspBody)localObject2).poi_info.has())
        {
          paramFromServiceMsg = (FromServiceMsg)localObject1;
          paramToServiceMsg = (Common.WifiPOIInfo)((oidb_0x8ab.RspBody)localObject2).poi_info.get();
        }
        paramFromServiceMsg = paramToServiceMsg;
        if (!((oidb_0x8ab.RspBody)localObject2).join_poi_status.has()) {
          break label622;
        }
        paramFromServiceMsg = paramToServiceMsg;
        i = ((oidb_0x8ab.RspBody)localObject2).join_poi_status.get();
        paramFromServiceMsg = paramToServiceMsg;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(d, 2, paramToServiceMsg.toString());
        i = 0;
        continue;
        if ((((HotChatInfo)localObject2).userCreate != paramToServiceMsg.userCreate) || (!Utils.a(((HotChatInfo)localObject2).uuid, paramToServiceMsg.uuid)) || (Utils.a(((HotChatInfo)localObject2).troopUin, paramToServiceMsg.troopUin))) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        NearbyUtils.a(d, new Object[] { "handleQuickJoinHotChat_check", String.format("userCreate:%d, uuid:%s, local:[%s,%s], server:[%s,%s]", new Object[] { Integer.valueOf(((HotChatInfo)localObject2).userCreate), ((HotChatInfo)localObject2).uuid, ((HotChatInfo)localObject2).troopUin, ((HotChatInfo)localObject2).troopCode, paramToServiceMsg.troopUin, paramToServiceMsg.troopCode }) });
        ((HotChatManager)paramObject).a((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
        continue;
      }
      if (paramFromServiceMsg != null)
      {
        paramToServiceMsg = HotChatInfo.createHotChat(paramFromServiceMsg, false, j);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("PttShow", new Object[] { "handleQuickJoinHotChat", paramToServiceMsg });
        }
        paramObject = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        localObject1 = ((HotChatManager)paramObject).a();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          j = ((List)localObject1).size() - 1;
          if (j >= 0)
          {
            localObject2 = (HotChatInfo)((List)localObject1).get(j);
            if (localObject2 == null)
            {
              j -= 1;
              continue;
            }
          }
        }
        if (i == 1) {
          ((HotChatManager)paramObject).a(paramToServiceMsg, k);
        }
      }
      for (;;)
      {
        a(1034, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), str });
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(d, 2, "handleQuickJoinHotChat, " + m + "," + paramToServiceMsg + "," + paramFromServiceMsg);
          }
          return;
          if (i == 2)
          {
            localObject1 = ((HotChatManager)paramObject).a(paramToServiceMsg.troopUin);
            if (localObject1 == null)
            {
              ((HotChatManager)paramObject).a(paramToServiceMsg, 4);
              break;
            }
            if (k == 1)
            {
              ((HotChatManager)paramObject).a(paramToServiceMsg, k);
              break;
            }
            ((HotChatInfo)localObject1).updateHotChatInfo(paramToServiceMsg);
            paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
            ((EntityManager)paramObject).a((Entity)localObject1);
            ((EntityManager)paramObject).a();
          }
          break;
          a(1034, false, new Object[] { null, null, Integer.valueOf(m), str });
          paramToServiceMsg = null;
          paramFromServiceMsg = null;
        }
        paramToServiceMsg = null;
      }
      label622:
      int i = 0;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
    int i = paramFromServiceMsg.getResultCode();
    a(1036, false, new Object[] { paramToServiceMsg, arrayOfByte, Integer.valueOf(i), "", "", null });
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleGetHotChatAnnounceTimeOutOrError,result= " + i + ",uid=" + arrayOfByte);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        int j;
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramObject = paramToServiceMsg;
          j = -1;
          i = j;
          if (paramObject != null)
          {
            i = j;
            if (((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has()) {
              i = ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get();
            }
          }
          if (i != 0) {
            break label174;
          }
          a(1035, true, new Object[] { arrayOfByte, Integer.valueOf(i), null });
          if (QLog.isColorLevel()) {
            QLog.i(d, 2, "handleSetHotChatAnnounce,result= " + i + ",strErr=" + null);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          int i;
          for (;;) {}
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramToServiceMsg = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.i(d, 2, paramFromServiceMsg.toString());
        paramObject = paramToServiceMsg;
        continue;
        label174:
        a(1035, false, new Object[] { arrayOfByte, Integer.valueOf(i), null });
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    a(1039, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "", Long.valueOf(0L) });
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleGetUserCreateHotChatAnnounceTimeOutOrError,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  /* Error */
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 426	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 710
    //   7: invokevirtual 714	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   10: astore 6
    //   12: aload_1
    //   13: getfield 426	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 804
    //   19: invokevirtual 557	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 7
    //   24: new 566	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   27: dup
    //   28: invokespecial 567	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: aload_3
    //   34: checkcast 569	[B
    //   37: checkcast 569	[B
    //   40: invokevirtual 573	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: pop
    //   44: aload_1
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +528 -> 575
    //   50: aload_2
    //   51: getfield 576	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   54: invokevirtual 579	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   57: ifeq +518 -> 575
    //   60: aload_2
    //   61: getfield 576	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   64: invokevirtual 582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   67: istore 9
    //   69: aconst_null
    //   70: astore 4
    //   72: aconst_null
    //   73: astore 5
    //   75: aconst_null
    //   76: astore_3
    //   77: iload 9
    //   79: ifne +418 -> 497
    //   82: new 824	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody
    //   85: dup
    //   86: invokespecial 825	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:<init>	()V
    //   89: astore 4
    //   91: aload 4
    //   93: aload_2
    //   94: getfield 620	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   97: invokevirtual 623	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   100: invokevirtual 624	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   103: invokevirtual 826	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: pop
    //   107: aload 4
    //   109: getfield 829	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   112: invokevirtual 830	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   115: ifeq +455 -> 570
    //   118: aload 4
    //   120: getfield 829	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 623	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 833	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   129: astore_1
    //   130: aload 4
    //   132: getfield 836	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   135: invokevirtual 830	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   138: ifeq +427 -> 565
    //   141: aload 4
    //   143: getfield 836	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   146: invokevirtual 623	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   149: invokevirtual 833	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   152: astore_2
    //   153: aload 4
    //   155: getfield 840	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   158: invokevirtual 843	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   161: ifeq +12 -> 173
    //   164: aload 4
    //   166: getfield 840	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   169: invokevirtual 844	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   172: astore_3
    //   173: aload_1
    //   174: astore 4
    //   176: aload_3
    //   177: astore_1
    //   178: aload 4
    //   180: astore_3
    //   181: aload_0
    //   182: getfield 347	com/tencent/mobileqq/app/HotChatHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 59
    //   187: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 296	com/tencent/mobileqq/app/HotChatManager
    //   193: astore 4
    //   195: aload 4
    //   197: aload 7
    //   199: invokevirtual 598	com/tencent/mobileqq/app/HotChatManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   202: astore 5
    //   204: aload 5
    //   206: ifnull +183 -> 389
    //   209: aload_3
    //   210: ifnonnull +144 -> 354
    //   213: aload 5
    //   215: getfield 847	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   218: ifnonnull +148 -> 366
    //   221: aload 5
    //   223: aload_3
    //   224: putfield 847	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   227: aload 5
    //   229: aload_2
    //   230: putfield 850	com/tencent/mobileqq/data/HotChatInfo:memoUrl	Ljava/lang/String;
    //   233: new 150	java/util/ArrayList
    //   236: dup
    //   237: invokespecial 696	java/util/ArrayList:<init>	()V
    //   240: astore 8
    //   242: aload_1
    //   243: ifnull +132 -> 375
    //   246: aload_1
    //   247: invokeinterface 754 1 0
    //   252: ifle +123 -> 375
    //   255: iconst_0
    //   256: istore 10
    //   258: iload 10
    //   260: aload_1
    //   261: invokeinterface 754 1 0
    //   266: if_icmpge +109 -> 375
    //   269: aload 8
    //   271: aload_1
    //   272: iload 10
    //   274: invokeinterface 757 2 0
    //   279: checkcast 815	java/lang/Long
    //   282: invokestatic 853	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   285: invokevirtual 854	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   288: pop
    //   289: iload 10
    //   291: iconst_1
    //   292: iadd
    //   293: istore 10
    //   295: goto -37 -> 258
    //   298: astore_3
    //   299: aconst_null
    //   300: astore_1
    //   301: aload_1
    //   302: astore_2
    //   303: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq -260 -> 46
    //   309: getstatic 34	com/tencent/mobileqq/app/HotChatHandler:d	Ljava/lang/String;
    //   312: iconst_2
    //   313: aload_3
    //   314: invokevirtual 811	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   317: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload_1
    //   321: astore_2
    //   322: goto -276 -> 46
    //   325: astore_3
    //   326: aconst_null
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_2
    //   330: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +14 -> 347
    //   336: getstatic 34	com/tencent/mobileqq/app/HotChatHandler:d	Ljava/lang/String;
    //   339: iconst_2
    //   340: aload_3
    //   341: invokevirtual 758	java/lang/Exception:toString	()Ljava/lang/String;
    //   344: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload_1
    //   348: astore_3
    //   349: aconst_null
    //   350: astore_1
    //   351: goto -170 -> 181
    //   354: aload_3
    //   355: aload 5
    //   357: getfield 847	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   360: invokevirtual 453	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   363: ifne -142 -> 221
    //   366: aload 5
    //   368: iconst_0
    //   369: putfield 857	com/tencent/mobileqq/data/HotChatInfo:memoShowed	Z
    //   372: goto -151 -> 221
    //   375: aload 5
    //   377: aload 8
    //   379: putfield 861	com/tencent/mobileqq/data/HotChatInfo:adminUins	Ljava/util/List;
    //   382: aload 4
    //   384: aload 5
    //   386: invokevirtual 863	com/tencent/mobileqq/app/HotChatManager:b	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   389: aload_0
    //   390: sipush 1036
    //   393: iconst_1
    //   394: bipush 6
    //   396: anewarray 359	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload 7
    //   403: aastore
    //   404: dup
    //   405: iconst_1
    //   406: aload 6
    //   408: aastore
    //   409: dup
    //   410: iconst_2
    //   411: iload 9
    //   413: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   416: aastore
    //   417: dup
    //   418: iconst_3
    //   419: aload_3
    //   420: aastore
    //   421: dup
    //   422: iconst_4
    //   423: aload_2
    //   424: aastore
    //   425: dup
    //   426: iconst_5
    //   427: aload_1
    //   428: aastore
    //   429: invokevirtual 344	com/tencent/mobileqq/app/HotChatHandler:a	(IZLjava/lang/Object;)V
    //   432: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +61 -> 496
    //   438: getstatic 34	com/tencent/mobileqq/app/HotChatHandler:d	Ljava/lang/String;
    //   441: iconst_2
    //   442: new 324	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 865
    //   452: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload 9
    //   457: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc_w 867
    //   463: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_3
    //   467: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 869
    //   473: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_2
    //   477: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc_w 871
    //   483: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload_1
    //   487: invokevirtual 689	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: return
    //   497: aload_0
    //   498: sipush 1036
    //   501: iconst_0
    //   502: bipush 6
    //   504: anewarray 359	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: aload 7
    //   511: aastore
    //   512: dup
    //   513: iconst_1
    //   514: aload 6
    //   516: aastore
    //   517: dup
    //   518: iconst_2
    //   519: iload 9
    //   521: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: dup
    //   526: iconst_3
    //   527: aconst_null
    //   528: aastore
    //   529: dup
    //   530: iconst_4
    //   531: aconst_null
    //   532: aastore
    //   533: dup
    //   534: iconst_5
    //   535: aconst_null
    //   536: aastore
    //   537: invokevirtual 344	com/tencent/mobileqq/app/HotChatHandler:a	(IZLjava/lang/Object;)V
    //   540: aconst_null
    //   541: astore_1
    //   542: aload 5
    //   544: astore_2
    //   545: aload 4
    //   547: astore_3
    //   548: goto -116 -> 432
    //   551: astore_3
    //   552: aconst_null
    //   553: astore_2
    //   554: goto -224 -> 330
    //   557: astore_3
    //   558: goto -228 -> 330
    //   561: astore_3
    //   562: goto -261 -> 301
    //   565: aconst_null
    //   566: astore_2
    //   567: goto -414 -> 153
    //   570: aconst_null
    //   571: astore_1
    //   572: goto -442 -> 130
    //   575: iconst_m1
    //   576: istore 9
    //   578: goto -509 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	HotChatHandler
    //   0	581	1	paramToServiceMsg	ToServiceMsg
    //   0	581	2	paramFromServiceMsg	FromServiceMsg
    //   0	581	3	paramObject	Object
    //   70	476	4	localObject	Object
    //   73	470	5	localHotChatInfo	HotChatInfo
    //   10	505	6	arrayOfByte	byte[]
    //   22	488	7	str	String
    //   240	138	8	localArrayList	ArrayList
    //   67	510	9	i	int
    //   256	38	10	j	int
    // Exception table:
    //   from	to	target	type
    //   24	32	298	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   91	130	325	java/lang/Exception
    //   130	153	551	java/lang/Exception
    //   153	173	557	java/lang/Exception
    //   32	44	561	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    a(1040, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        try
        {
          label57:
          oidb_0x88d.RspBody localRspBody;
          localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          if (localRspBody.stzrspgroupinfo.has()) {
            paramFromServiceMsg = localRspBody.stzrspgroupinfo.get();
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
            if (!paramFromServiceMsg.uint32_result.has()) {
              break label641;
            }
            j = paramFromServiceMsg.uint32_result.get();
            i = j;
            if (i != 0) {}
          }
        }
        catch (Exception localException2)
        {
          HotChatInfo localHotChatInfo;
          int j;
          long l;
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!paramFromServiceMsg.stgroupinfo.has()) {
            break label636;
          }
          paramObject = (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get();
          if (paramObject == null) {
            break label627;
          }
          paramFromServiceMsg = localHotChatInfo;
          if (((oidb_0x88d.GroupInfo)paramObject).string_group_memo.has()) {
            paramFromServiceMsg = ((oidb_0x88d.GroupInfo)paramObject).string_group_memo.get().toStringUtf8();
          }
        }
        catch (Exception localException3)
        {
          paramFromServiceMsg = null;
          continue;
        }
        try
        {
          if (!((oidb_0x88d.GroupInfo)paramObject).uint64_group_owner.has()) {
            break;
          }
          l = ((oidb_0x88d.GroupInfo)paramObject).uint64_group_owner.get();
          paramObject = Long.valueOf(l);
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          try
          {
            paramObject = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            localHotChatInfo = ((HotChatManager)paramObject).a((String)localObject);
            if (localHotChatInfo != null)
            {
              if (paramToServiceMsg == null)
              {
                if (localHotChatInfo.memo != null) {
                  continue;
                }
                localHotChatInfo.memo = paramToServiceMsg;
                localHotChatInfo.memoUrl = null;
                localHotChatInfo.ownerUin = String.valueOf(paramFromServiceMsg);
                ((HotChatManager)paramObject).b(localHotChatInfo);
              }
            }
            else
            {
              a(1039, true, new Object[] { localObject, Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg });
              j = i;
              localObject = paramToServiceMsg;
              paramObject = paramFromServiceMsg;
              if (QLog.isColorLevel()) {
                QLog.i(d, 2, "handleGetUserCreateHotChatAnnounce,result= " + j + ",memo=" + (String)localObject + ",troopOwner=" + paramObject);
              }
              return;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg = null;
              if (QLog.isColorLevel()) {
                QLog.i(d, 2, paramFromServiceMsg.toString());
              }
              paramFromServiceMsg = paramToServiceMsg;
              continue;
            }
            if (paramToServiceMsg.equals(localHotChatInfo.memo)) {
              continue;
            }
            localHotChatInfo.memoShowed = false;
            continue;
            paramObject = paramToServiceMsg;
          }
          catch (Exception localException1)
          {
            paramObject = paramFromServiceMsg;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = (ToServiceMsg)paramObject;
          }
        }
        catch (Exception localException4)
        {
          continue;
        }
        localObject = paramFromServiceMsg;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.i(d, 2, localException1.toString());
          paramObject = paramToServiceMsg;
          localObject = paramFromServiceMsg;
          j = i;
          continue;
          a(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
          continue;
          a(1039, false, new Object[] { localObject, Integer.valueOf(i), null, paramToServiceMsg });
          localObject = null;
          paramObject = paramToServiceMsg;
          j = i;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label644;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label415;
      paramObject = paramFromServiceMsg;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = (ToServiceMsg)paramObject;
      break label249;
      paramObject = null;
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = (ToServiceMsg)paramObject;
      break label249;
      paramObject = null;
      break label192;
      break label166;
      i = -1;
      break label57;
    }
    localHotChatInfo = null;
    paramToServiceMsg = Long.valueOf(0L);
    paramObject = null;
    if (i == 0) {
      localRspBody = new oidb_0x88d.RspBody();
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("memberuin");
    int i = paramFromServiceMsg.getResultCode();
    a(1037, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg, null });
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleKickHotChatMemberErrorOrTimeout,result= " + i + ",groupuin=" + str + ",memberUin=" + paramToServiceMsg);
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label55:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i(d, 2, paramFromServiceMsg.toString());
        }
        continue;
        paramFromServiceMsg = new oidb_0x89a.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          boolean bool = paramFromServiceMsg.str_errorinfo.has();
          if (!bool) {}
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(d, 2, paramToServiceMsg.toString());
            }
          }
        }
        a(1040, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label251;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label137;
      i = -1;
      break label55;
    }
    if (i == 0)
    {
      a(1040, true, new Object[] { str, Integer.valueOf(i), null });
      if (QLog.isColorLevel()) {
        QLog.i(d, 2, "handleSetUserCreateHotChatAnnounce,result= " + i + ",strErr=" + null);
      }
      return;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    a(1038, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "handleDismissHotChatTimeOutOrError,result= " + i + ",groupuin=" + str + ",groupcode=" + paramToServiceMsg);
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("groupuin");
    String str3 = paramToServiceMsg.extraData.getString("groupcode");
    str2 = paramToServiceMsg.extraData.getString("memberuin");
    String str4 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        label93:
        paramToServiceMsg = null;
        paramFromServiceMsg = paramToServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.i(d, 2, ((InvalidProtocolBufferMicroException)paramObject).toString());
          paramFromServiceMsg = paramToServiceMsg;
          continue;
          a(1037, false, new Object[] { str1, Integer.valueOf(i), str2, null });
          paramToServiceMsg = null;
        }
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = paramToServiceMsg;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
        break label377;
      }
      i = paramFromServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label287;
      i = -1;
      break label93;
    }
    paramToServiceMsg = null;
    if (i == 0)
    {
      paramObject = new oidb_0x89b.RspBody();
      try
      {
        ((oidb_0x89b.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (((oidb_0x89b.RspBody)paramObject).str_err_msg.has()) {
          paramToServiceMsg = ((oidb_0x89b.RspBody)paramObject).str_err_msg.get();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(d, 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      AddMessageHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(str3), str4 + BaseApplicationImpl.getContext().getString(2131371493), 1, false, true);
      a(1037, true, new Object[] { str1, Integer.valueOf(i), str2, paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i(d, 2, "handleKickHotChatMemberResp,result= " + i + ",groupuin=" + str1 + ",memberUin=" + str2 + ",strErr=" + paramToServiceMsg);
      }
      return;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1044, false, new Object[] { Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("favorite", false)), paramToServiceMsg.extraData.getString("uin"), Integer.valueOf(0), "网络超时,请检查网络连接" });
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        label57:
        paramToServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.i(d, 2, paramFromServiceMsg.toString());
        }
        continue;
        a(1038, false, new Object[] { str, Integer.valueOf(i), null });
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = null;
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label297;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label218;
      i = -1;
      break label57;
    }
    if (i == 0)
    {
      paramObject = new oidb_0xa81.RspBody();
      try
      {
        ((oidb_0xa81.RspBody)paramObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = paramFromServiceMsg;
        if (((oidb_0xa81.RspBody)paramObject).str_err_msg.has()) {
          paramToServiceMsg = ((oidb_0xa81.RspBody)paramObject).str_err_msg.get().toStringUtf8();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(d, 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = null;
        }
      }
      paramFromServiceMsg = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      paramObject = paramFromServiceMsg.a(str);
      if (paramObject != null) {
        paramFromServiceMsg.a((HotChatInfo)paramObject, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      }
      a(1038, true, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.i(d, 2, "handleDismissHotChat,result= " + i + ",groupcode=" + str);
      }
      return;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isHotChat");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = Boolean.valueOf(bool);
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "handleGetTroopInfo isHotChat = " + bool);
    }
    if ((paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      a(1048, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(1048, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(1048, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x88d.RspBody();
    int i;
    try
    {
      ((oidb_0x88d.RspBody)paramObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = ((oidb_0x88d.RspBody)paramObject).stzrspgroupinfo.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label365;
      }
      paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
      i = paramFromServiceMsg.uint32_result.get();
      if (i == 0)
      {
        a(1048, true, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get() });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(1048, false, paramToServiceMsg);
      return;
    }
    a(1048, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
    return;
    label365:
    a(1048, false, paramToServiceMsg);
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("uitag"));
    if ((paramFromServiceMsg == null) || (paramObject == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      a(1047, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
    }
    for (;;)
    {
      return;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramObject == null) || (!((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null))
        {
          a(1047, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(1047, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        return;
      }
      paramFromServiceMsg = new cmd0x897.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray());
        if (paramFromServiceMsg.uint32_result.has()) {
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            if (!paramFromServiceMsg.rpt_msg_grp_visitor_info.isEmpty()) {
              a(1047, true, new Object[] { Integer.valueOf(0), paramFromServiceMsg.rpt_msg_grp_visitor_info.get(), paramToServiceMsg });
            }
            while (QLog.isColorLevel())
            {
              int i = -1;
              if (paramFromServiceMsg.uint32_result.has()) {
                i = paramFromServiceMsg.uint32_result.get();
              }
              QLog.i("HotChatHandler", 2, "handleGetHotChatTroopMemberList.result=" + i);
              return;
              a(1047, false, new Object[] { Integer.valueOf(2), null, paramToServiceMsg });
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          a(1047, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
          continue;
          a(1047, false, new Object[] { Integer.valueOf(3), null, paramToServiceMsg });
          continue;
          a(1047, false, new Object[] { Integer.valueOf(1), null, paramToServiceMsg });
        }
      }
    }
  }
  
  protected Class a()
  {
    return HotChatObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(d, new Object[] { "getMyHotChatList()", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    Object localObject = new GetJoinedHotChatList.ReqBody();
    ((GetJoinedHotChatList.ReqBody)localObject).uint64_uin.set(l);
    ((GetJoinedHotChatList.ReqBody)localObject).uint32_req_type.set(3);
    localObject = a("OidbSvc.0x8a4", 2212, 0, ((GetJoinedHotChatList.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    a(paramHotChatInfo, true);
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt)
  {
    a(paramHotChatInfo, paramInt, true);
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramHotChatInfo == null) || (TextUtils.isEmpty(paramHotChatInfo.uuid)) || (paramInt <= 0)) {}
    do
    {
      return;
      Object localObject = new cmd0x8a3_7.ReqBody();
      ((cmd0x8a3_7.ReqBody)localObject).uint32_req_flag.set(2);
      ((cmd0x8a3_7.ReqBody)localObject).bytes_uid.set(ByteStringMicro.copyFrom(paramHotChatInfo.uuid.getBytes()));
      ((cmd0x8a3_7.ReqBody)localObject).praise_num.set(paramInt);
      localObject = a("OidbSvc.0x8a3_7", 2211, 7, ((cmd0x8a3_7.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uuid", paramHotChatInfo.uuid);
      ((ToServiceMsg)localObject).extraData.putInt("praiseCount", paramInt);
      ((ToServiceMsg)localObject).extraData.putBoolean("needRequestNext", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putInt("flag", 2);
      b((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.d(d, 2, "uploadPttshowPraise, info=" + paramHotChatInfo + ", praiseCount=" + paramInt + ", needRequestNext=" + paramBoolean);
  }
  
  public void a(HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramHotChatInfo, paramLong, paramInt1, paramInt2, 2, 0);
  }
  
  public void a(HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1;
    if (paramHotChatInfo == null)
    {
      localObject1 = null;
      if (paramHotChatInfo != null) {
        break label129;
      }
    }
    label129:
    for (paramHotChatInfo = null;; paramHotChatInfo = paramHotChatInfo.uuid)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "getHotChatMsg", String.format("troopUin:%s lStartMsgSeq:%d nReqMsgNum:%d  nOrder:%d  nFlag:%d  nTryCount:%d", new Object[] { localObject1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }) });
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramHotChatInfo)) && (paramInt2 >= 0) && (paramInt2 <= 2)) {
        break label137;
      }
      return;
      localObject1 = paramHotChatInfo.troopUin;
      break;
    }
    label137:
    Object localObject2 = new oidb_0xa8a.ReqBody();
    ((oidb_0xa8a.ReqBody)localObject2).bytes_poid.set(ByteStringMicro.copyFrom(paramHotChatInfo.getBytes()));
    ((oidb_0xa8a.ReqBody)localObject2).uint64_start_msg_seq.set(paramLong);
    ((oidb_0xa8a.ReqBody)localObject2).uint32_req_msg_num.set(paramInt1);
    ((oidb_0xa8a.ReqBody)localObject2).uint32_order.set(paramInt2);
    localObject2 = a("OidbSvc.0xa8a", 2698, 1, ((oidb_0xa8a.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("troopUin", (String)localObject1);
    ((ToServiceMsg)localObject2).extraData.putString("uuid", paramHotChatInfo);
    ((ToServiceMsg)localObject2).extraData.putLong("lStartMsgSeq", paramLong);
    ((ToServiceMsg)localObject2).extraData.putInt("nReqMsgNum", paramInt1);
    ((ToServiceMsg)localObject2).extraData.putInt("nOrder", paramInt2);
    ((ToServiceMsg)localObject2).extraData.putInt("nFlag", paramInt3);
    ((ToServiceMsg)localObject2).extraData.putInt("nTryCount", paramInt4);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(d, new Object[] { "exitHotChat", paramHotChatInfo, paramHotChatStateWrapper });
    }
    if (paramHotChatInfo == null)
    {
      a(1033, false, new Object[] { "", "退出热聊失败" });
      return;
    }
    Object localObject = new oidb_0x89b.ExitPublicGroupReqBody();
    ((oidb_0x89b.ExitPublicGroupReqBody)localObject).uint64_visitor_uin.set(BizTroopHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_code.set(BizTroopHandler.a(paramHotChatInfo.troopUin));
    localReqBody.uint32_req_type.set(5);
    localReqBody.msg_exit_group.set((MessageMicro)localObject);
    localObject = a("OidbSvc.0x89b_3", 2203, 3, localReqBody.toByteArray(), 10000L);
    ((ToServiceMsg)localObject).extraData.putBoolean("isJoin", false);
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramHotChatInfo.troopUin);
    ((ToServiceMsg)localObject).extraData.putSerializable("targetHotChatState", paramHotChatStateWrapper);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(HotChatInfo paramHotChatInfo, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      NearbyUtils.a(d, new Object[] { "updateSeatsInfo", Integer.valueOf(paramInt1), paramHotChatInfo });
    }
    if ((paramHotChatInfo == null) || (paramHotChatInfo.uuid == null) || (paramHotChatInfo.uuid.length() == 0)) {
      return;
    }
    Object localObject = new oidb_0xa88.ReqBody();
    ((oidb_0xa88.ReqBody)localObject).bytes_poid.set(ByteStringMicro.copyFrom(paramHotChatInfo.uuid.getBytes()));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      ((oidb_0xa88.ReqBody)localObject).uint32_seat_id.set(paramInt2);
      ((oidb_0xa88.ReqBody)localObject).uint32_seat_op.set(paramInt3);
      try
      {
        l1 = Long.parseLong(paramHotChatInfo.troopUin);
        ((oidb_0xa88.ReqBody)localObject).uint64_groupcode.set(l1);
        localObject = a("OidbSvc.0xa88", 2696, paramInt1, ((oidb_0xa88.ReqBody)localObject).toByteArray());
        ((ToServiceMsg)localObject).extraData.putString("uuid", paramHotChatInfo.uuid);
        ((ToServiceMsg)localObject).extraData.putString("troopUin", paramHotChatInfo.troopUin);
        ((ToServiceMsg)localObject).extraData.putString("guestUin", paramString);
        ((ToServiceMsg)localObject).extraData.putInt("cmd", paramInt1);
        ((ToServiceMsg)localObject).extraData.putInt("seatID", paramInt2);
        ((ToServiceMsg)localObject).extraData.putInt("seatOp", paramInt3);
        b((ToServiceMsg)localObject);
        return;
        String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        try
        {
          l1 = Long.parseLong(str);
          ((oidb_0xa88.ReqBody)localObject).uint64_guest_uin.set(l1);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
            l1 = 0L;
          }
        }
        try
        {
          l1 = Long.parseLong(paramString);
          ((oidb_0xa88.ReqBody)localObject).uint64_guest_uin.set(l1);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            l1 = 0L;
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          localException3.printStackTrace();
          long l1 = l2;
        }
      }
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, boolean paramBoolean)
  {
    if ((paramHotChatInfo == null) || (TextUtils.isEmpty(paramHotChatInfo.uuid))) {}
    do
    {
      return;
      Object localObject = new cmd0x8a3_7.ReqBody();
      ((cmd0x8a3_7.ReqBody)localObject).uint32_req_flag.set(1);
      ((cmd0x8a3_7.ReqBody)localObject).bytes_uid.set(ByteStringMicro.copyFrom(paramHotChatInfo.uuid.getBytes()));
      localObject = a("OidbSvc.0x8a3_7", 2211, 7, ((cmd0x8a3_7.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uuid", paramHotChatInfo.uuid);
      ((ToServiceMsg)localObject).extraData.putInt("flag", 1);
      ((ToServiceMsg)localObject).extraData.putBoolean("needShowHeart", paramBoolean);
      b((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.d(d, 2, "getPttshowPraise, info=" + paramHotChatInfo);
  }
  
  public void a(HotChatInfo paramHotChatInfo, boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "sendFavoriteHotchat");
    }
    Object localObject2;
    if ((paramHotChatInfo == null) || (TextUtils.isEmpty(paramHotChatInfo.uuid)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = d;
        localObject2 = new StringBuilder().append("sendFavoriteHotchat return. hc==null:");
        if (paramHotChatInfo != null) {
          break label119;
        }
      }
      label119:
      for (boolean bool = true;; bool = false)
      {
        QLog.i((String)localObject1, 2, bool);
        a(1044, false, new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(0), "" });
        return;
      }
    }
    Object localObject1 = new oidb_0xa8b.ReqBody();
    if (paramBoolean)
    {
      localObject2 = new oidb_0xa8b.StorePoid();
      ((oidb_0xa8b.StorePoid)localObject2).bytes_poid.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.uuid));
      paramHotChatInfo = new ArrayList(1);
      paramHotChatInfo.add(localObject2);
      ((oidb_0xa8b.ReqBody)localObject1).rpt_msg_store_poid.set(paramHotChatInfo);
      if (!paramBoolean) {
        break label293;
      }
    }
    for (;;)
    {
      paramHotChatInfo = a("OidbSvc.0xa8b", 2699, i, ((oidb_0xa8b.ReqBody)localObject1).toByteArray());
      paramHotChatInfo.extraData.putBoolean("favorite", paramBoolean);
      paramHotChatInfo.extraData.putString("uin", paramString);
      b(paramHotChatInfo);
      return;
      localObject2 = new oidb_0xa8b.DeletePoid();
      ((oidb_0xa8b.DeletePoid)localObject2).bytes_poid.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.uuid));
      paramHotChatInfo = new ArrayList(1);
      paramHotChatInfo.add(localObject2);
      ((oidb_0xa8b.ReqBody)localObject1).rpt_msg_delete_poid.set(paramHotChatInfo);
      break;
      label293:
      i = 2;
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getResultCode();
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("uuid");
    String str3 = paramToServiceMsg.extraData.getString("guestUin");
    int j = paramToServiceMsg.extraData.getInt("cmd");
    a(1045, false, new Object[] { Boolean.valueOf(false), Integer.valueOf(j), str1, str3, Integer.valueOf(i), null, Integer.valueOf(paramToServiceMsg.extraData.getInt("seatID")), Integer.valueOf(paramToServiceMsg.extraData.getInt("seatOp")) });
    if (QLog.isColorLevel()) {
      NearbyUtils.a(d, new Object[] { "handleUpdateSeatsInfoTimeOutOrError", Integer.valueOf(paramFromServiceMsg.getResultCode()), Integer.valueOf(j), str1, str2, str3 });
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramFromServiceMsg.getResultCode() == 1002)
          {
            d(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if (paramFromServiceMsg.getResultCode() != 1000)
          {
            c(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if ("OidbSvc.0x8a4".equals(str))
          {
            g(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (!"OidbSvc.0x89b_3".equals(str)) {
            break;
          }
          if (paramToServiceMsg.extraData.getBoolean("kick", false))
          {
            n(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        } while (paramToServiceMsg.extraData.getBoolean("isJoin"));
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if ("OidbSvc.0x8a2".equals(str))
        {
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8a8".equals(str))
        {
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8ab".equals(str))
        {
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8b3".equals(str))
        {
          j(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8b2".equals(str))
        {
          k(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0xa81".equals(str))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x88d_0".equals(str))
        {
          l(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x89a_0".equals(str))
        {
          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x435".equals(str));
      if ("OidbSvc.0xa8b".equals(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa88".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa8a".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x897_0".equals(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x8a3_7".equals(str));
    switch (paramToServiceMsg.extraData.getInt("flag"))
    {
    default: 
      return;
    case 1: 
      b(paramToServiceMsg, paramFromServiceMsg, paramObject, false);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || ((!paramBoolean) && (paramObject == null))) {}
    do
    {
      return;
      String str = paramToServiceMsg.extraData.getString("uuid");
      int i = paramToServiceMsg.extraData.getInt("praiseCount", 0);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needRequestNext", true);
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "handleUploadPttshowPraise error, req=" + paramToServiceMsg.toString() + ", resp=" + paramFromServiceMsg.toString() + ", needRequestNext" + bool);
        }
        a(1049, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(-1) });
        return;
      }
      cmd0x8a3_7.RspBody localRspBody = new cmd0x8a3_7.RspBody();
      int j = a(paramFromServiceMsg, paramObject, localRspBody);
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "handleUploadPttshowPraise , result=" + j + ", uuid=" + str + ", req=" + paramToServiceMsg.toString() + ", resp=" + paramFromServiceMsg.toString() + ", rspBody=" + localRspBody.toString() + ", needRequestNext" + bool);
      }
      if (j != 0)
      {
        a(1049, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j) });
        return;
      }
      paramToServiceMsg = (Common.WifiPOIInfo)localRspBody.wifi_info.get();
      a(1049, true, new Object[] { str, Integer.valueOf(i), paramToServiceMsg, Boolean.valueOf(bool), Integer.valueOf(j) });
    } while ((!QLog.isColorLevel()) || (paramToServiceMsg == null));
    QLog.d(d, 2, "handleUploadPttshowPraise , gap=" + paramToServiceMsg.uint64_report_praise_gap_time.get());
  }
  
  public void a(String paramString, long paramLong, int paramInt, boolean paramBoolean, int... paramVarArgs)
  {
    Object localObject = new cmd0x897.VisitorInfo();
    ((cmd0x897.VisitorInfo)localObject).uint64_visitor_uin.set(0L);
    ((cmd0x897.VisitorInfo)localObject).uint32_visitor_faceid.set(0);
    ((cmd0x897.VisitorInfo)localObject).string_visitor_nick.set(ByteStringMicro.copyFrom(new byte[0]));
    cmd0x897.GroupUinCode localGroupUinCode = new cmd0x897.GroupUinCode();
    try
    {
      localGroupUinCode.uint64_group_code.set(Long.parseLong(paramString));
      paramString = new cmd0x897.GroupNextVisitor();
      paramString.msg_group_uin_code.set(localGroupUinCode);
      paramString.uint64_next_visitor.set(paramInt);
      paramString.msg_req_field.set((MessageMicro)localObject);
      if (paramInt == 0)
      {
        if (paramBoolean) {
          paramString.uint32_guest_field.set(1);
        }
        paramString.uint32_administrator_field.set(1);
      }
      if ((paramVarArgs.length > 0) && (paramVarArgs[0] > 0))
      {
        paramString.uint32_max_count.set(paramVarArgs[0]);
        paramVarArgs = new cmd0x897.ReqBody();
        localObject = new ArrayList();
        ((List)localObject).add(paramString);
        paramVarArgs.rpt_msg_grp_next_visitor.set((List)localObject);
        paramString = a("OidbSvc.0x897_0", 2199, 0, paramVarArgs.toByteArray());
        paramString.extraData.putLong("uitag", paramLong);
        b(paramString);
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e(d, 2, "get open troop member list, send pb request, params : troopUin / troop Code, NumberFormatException");
          continue;
          paramString.uint32_max_count.set(0);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject).uint32_appid.set(0);
    oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
    localReqGroupInfo.uint64_group_code.set(Long.parseLong(paramString));
    localReqGroupInfo.uint32_last_get_group_name_time.set(0);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.string_group_class_text.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.string_group_name.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.uint32_group_visitor_cur_num.set(0);
    localGroupInfo.uint32_group_member_num.set(0);
    localGroupInfo.uint32_group_class_ext.set(0);
    int i = (int)(System.currentTimeMillis() / 1000L);
    localGroupInfo.uint32_group_aio_skin_timestamp.set(i);
    localGroupInfo.uint32_group_board_skin_timestamp.set(i);
    localGroupInfo.uint32_group_cover_skin_timestamp.set(i);
    localReqGroupInfo.stgroupinfo.set(localGroupInfo);
    ((oidb_0x88d.ReqBody)localObject).stzreqgroupinfo.add(localReqGroupInfo);
    localObject = a("OidbSvc.0x88d_1", 2189, 1, ((oidb_0x88d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString);
    ((ToServiceMsg)localObject).extraData.putBoolean("isHotChat", paramBoolean);
    b((ToServiceMsg)localObject);
  }
  
  public void a(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {}
    try
    {
      QLog.i(d, 2, "joinHotChat() WifiPOIInfo = " + paramWifiPOIInfo.bytes_name.get().toStringUtf8() + ", " + paramWifiPOIInfo.bytes_uid.get().toStringUtf8());
      int i = 0;
      String str = null;
      if (paramWifiPOIInfo.uint32_group_uin.has()) {
        str = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_uin.get()));
      }
      if ((str == null) || (str.equals("")) || (str.equals("0"))) {
        i = 1;
      }
      if (i != 0)
      {
        a(paramWifiPOIInfo, paramBoolean, paramInt2);
        return;
      }
      try
      {
        a(paramWifiPOIInfo.bytes_uid.get().toStringUtf8(), paramInt2, true, paramInt1);
        return;
      }
      catch (Exception paramWifiPOIInfo)
      {
        paramWifiPOIInfo.printStackTrace();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8a4");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89b_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8a2");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8a8");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8ab");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8b3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8b2");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xa81");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x88d_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x89a_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x435");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xa88");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xa8a");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x897_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x88d_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xa8b");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x8a3_7");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, 4);
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      localObject2 = a(false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!paramBoolean) {
          localObject1 = new LBS.LBSInfo();
        }
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(d, 2, "quickJoinHotChat, lbs is null, needLBS = " + paramBoolean);
    return false;
    Object localObject2 = new oidb_0x8ab.ReqBody();
    ((oidb_0x8ab.ReqBody)localObject2).hotnamecode.set(paramString);
    ((oidb_0x8ab.ReqBody)localObject2).lbs_info.set((MessageMicro)localObject1);
    Object localObject1 = a("OidbSvc.0x8ab", 2219, 0, ((oidb_0x8ab.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("hotnamecode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("HOTCHAT_EXTRA_FLAG", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("preHotChatState", paramInt2);
    b((ToServiceMsg)localObject1);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "setUserCreateHotChatAnnounce.groupcode=" + paramString1 + ",memo=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
      return false;
    }
    oidb_0x89a.groupinfo localgroupinfo = new oidb_0x89a.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint64_original_operator_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.st_group_info.set(localgroupinfo);
    paramString2 = a("OidbSvc.0x89a_0", 2202, 0, localReqBody.toByteArray());
    paramString2.extraData.putString("groupcode", paramString1);
    b(paramString2);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "kickHotChatMember.groupcode=" + paramString1 + ",groupuin=" + paramString2 + ",memberuin=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    Object localObject = new oidb_0x89b.KickPublicGroupVisitorReqBody();
    ((oidb_0x89b.KickPublicGroupVisitorReqBody)localObject).rpt_uint64_visitor_uin.add(Long.valueOf(paramString3));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
    localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    localReqBody.uint32_req_type.set(6);
    localReqBody.msg_kick_visitor.set((MessageMicro)localObject);
    localObject = a("OidbSvc.0x89b_3", 2203, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("groupcode", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("groupuin", paramString2);
    ((ToServiceMsg)localObject).extraData.putString("memberuin", paramString3);
    ((ToServiceMsg)localObject).extraData.putBoolean("kick", true);
    ((ToServiceMsg)localObject).extraData.putString("nickname", paramString4);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(LBS.Wifi paramWifi)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("qb_hc_hotchat_global", 0);
    String str2 = localSharedPreferences.getString("qb_hc_report_wifi_cache2", "");
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "isTodayWiFiReported wifiCache = " + str2);
    }
    String str1 = MD5Utils.b("" + paramWifi.essid.get().toStringUtf8() + paramWifi.mac.get());
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str2))
        {
          paramWifi = new JSONObject();
          long l1 = paramWifi.optLong(str1, 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 <= 86400000L) {
            continue;
          }
          bool1 = true;
          bool2 = bool1;
          if (!bool1) {}
        }
      }
      catch (Exception paramWifi)
      {
        long l2;
        bool1 = false;
      }
      try
      {
        paramWifi.put(str1, l2);
        localSharedPreferences.edit().putString("qb_hc_report_wifi_cache2", paramWifi.toString()).commit();
        bool2 = bool1;
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "isTodayWiFiReported isNeed = " + bool2);
        }
        return bool2;
      }
      catch (Exception paramWifi)
      {
        for (;;) {}
      }
      paramWifi = new JSONObject(str2);
      continue;
      boolean bool1 = false;
      continue;
      paramWifi.printStackTrace();
      localSharedPreferences.edit().putString("qb_hc_report_wifi_cache2", "").commit();
      boolean bool2 = bool1;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "getHotChatAnnounce.uid=" + new String(paramArrayOfByte) + ", troopUin=" + paramString);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    Object localObject = new oidb_0x8b2.ReqBody();
    ((oidb_0x8b2.ReqBody)localObject).string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localObject = a("OidbSvc.0x8b2", 2226, 2, ((oidb_0x8b2.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putByteArray("uid", paramArrayOfByte);
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "setHotChatAnnounce.memo=" + paramString1 + ",url=" + paramString2 + ",uid=" + new String(paramArrayOfByte));
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return false;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    paramString2 = new oidb_0x8b3.ReqBody();
    paramString2.string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    oidb_0x8b3.groupinfo localgroupinfo = new oidb_0x8b3.groupinfo();
    localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(str.getBytes()));
    localgroupinfo.string_jumping_url.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString2.st_group_info.set(localgroupinfo);
    paramString1 = a("OidbSvc.0x8b3", 2227, 0, paramString2.toByteArray());
    paramString1.extraData.putByteArray("uid", paramArrayOfByte);
    b(paramString1);
    return true;
  }
  
  public void b()
  {
    if (!NetworkUtil.i(BaseApplication.getContext())) {
      if (QLog.isColorLevel()) {
        QLog.i(d, 2, "reportWifi no wifi connect");
      }
    }
    do
    {
      do
      {
        return;
        localObject = a();
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(d, 2, "reportWifi no wifiInfo getted");
      return;
      if (QLog.isColorLevel()) {
        QLog.i(d, 2, "reportWifi call wifi = " + localObject);
      }
      if (!a((LBS.Wifi)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(d, 2, "reportWifi already report today");
    return;
    oidb_0x8a8.ReqBody localReqBody = new oidb_0x8a8.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.joined_wifi.set((MessageMicro)localObject);
    Object localObject = a("OidbSvc.0x8a8", 2216, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    String str = paramToServiceMsg.extraData.getString("uuid");
    long l = paramToServiceMsg.extraData.getLong("lStartMsgSeq");
    int j = paramToServiceMsg.extraData.getInt("lStartMsgSeq");
    int k = paramToServiceMsg.extraData.getInt("nOrder");
    int m = paramToServiceMsg.extraData.getInt("nFlag");
    if (m == 2) {
      a(1046, false, new Object[] { Integer.valueOf(i), paramFromServiceMsg, str, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(0L), null });
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, paramFromServiceMsg.toString());
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("favorite", false);
    String str = paramToServiceMsg.extraData.getString("uin");
    if (paramFromServiceMsg.getResultCode() != 1000) {
      a(1044, false, new Object[] { Boolean.valueOf(bool), str, Integer.valueOf(0), "" });
    }
    for (;;)
    {
      return;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i(d, 2, "handleGetHotChatListResp result " + i);
        }
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()))
        {
          a(1044, false, new Object[] { Boolean.valueOf(bool), str, Integer.valueOf(0), "" });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        int i;
        for (;;) {}
        if (i == 0)
        {
          paramFromServiceMsg = new oidb_0xa8b.RspBody();
          try
          {
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (!paramFromServiceMsg.bytes_msg_error_info.has()) {
              break label399;
            }
            paramToServiceMsg = paramFromServiceMsg.bytes_msg_error_info.get().toStringUtf8();
            if (TextUtils.isEmpty(paramToServiceMsg)) {
              break label399;
            }
            a(1044, false, new Object[] { Boolean.valueOf(bool), str, Integer.valueOf(0), paramToServiceMsg });
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i(d, 2, "handleGetHotChatListResp errorMsg:" + paramToServiceMsg);
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            a(1044, false, new Object[] { Boolean.valueOf(bool), str, Integer.valueOf(0), "" });
          }
          if (QLog.isColorLevel())
          {
            QLog.i(d, 2, "handleGetHotChatListResp exception", paramToServiceMsg);
            return;
            label399:
            paramToServiceMsg = ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(str);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.isFavorite = bool;
              paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
              paramFromServiceMsg.a(paramToServiceMsg);
              paramFromServiceMsg.a();
            }
            a(1044, true, new Object[] { Boolean.valueOf(bool), str });
          }
        }
        else
        {
          paramToServiceMsg = "";
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      a(1044, false, new Object[] { Boolean.valueOf(bool), str, Integer.valueOf(0), paramToServiceMsg });
      return;
      paramToServiceMsg = "没有权限";
      continue;
      paramToServiceMsg = "系统失败";
      continue;
      paramToServiceMsg = "参数错误";
      continue;
      paramToServiceMsg = "话题下架";
      continue;
      paramToServiceMsg = "收藏数量已达上限";
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || ((!paramBoolean) && (paramObject == null))) {}
    do
    {
      return;
      String str = paramToServiceMsg.extraData.getString("uuid");
      boolean bool = paramToServiceMsg.extraData.getBoolean("needShowHeart", true);
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "handleGetPttshowPraise error, req=" + paramToServiceMsg.toString() + ", resp=" + paramFromServiceMsg.toString());
        }
        a(1050, false, new Object[] { str, Integer.valueOf(-1), Boolean.valueOf(bool) });
        return;
      }
      cmd0x8a3_7.RspBody localRspBody = new cmd0x8a3_7.RspBody();
      int i = a(paramFromServiceMsg, paramObject, localRspBody);
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "handleGetPttshowPraise , result=" + i + ", uuid=" + str + ", req=" + paramToServiceMsg.toString() + ", resp=" + paramFromServiceMsg.toString() + ", rspBody=" + localRspBody.toString());
      }
      if (i != 0)
      {
        a(1050, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        return;
      }
      paramToServiceMsg = (Common.WifiPOIInfo)localRspBody.wifi_info.get();
      a(1050, true, new Object[] { str, paramToServiceMsg, Integer.valueOf(i), Boolean.valueOf(bool) });
    } while ((!QLog.isColorLevel()) || (paramToServiceMsg == null));
    QLog.d(d, 2, "handleGetPttshowPraise , praiseCount=" + paramToServiceMsg.uint64_praise_nums.get() + ", gap=" + paramToServiceMsg.uint64_get_praise_gap_time.get());
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "getUserCreateHotChatAnnounce.groupcode=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(1L);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.copyFrom("1".getBytes()));
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = a("OidbSvc.0x88d_0", 2189, 6, ((oidb_0x88d.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString);
    b((ToServiceMsg)localObject1);
    return true;
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    paramToServiceMsg.extraData.getString("uuid");
    String str2 = paramToServiceMsg.extraData.getString("guestUin");
    int i = paramToServiceMsg.extraData.getInt("cmd");
    int j = paramToServiceMsg.extraData.getInt("seatID");
    int k = paramToServiceMsg.extraData.getInt("seatOp");
    oidb_0xa88.RspBody localRspBody = new oidb_0xa88.RspBody();
    int m = a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = null;
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(str1);
    paramObject = null;
    if (localRspBody != null) {
      paramToServiceMsg = localRspBody.bytes_msg_error_info.get().toStringUtf8();
    }
    paramFromServiceMsg = (FromServiceMsg)paramObject;
    if (localRspBody != null)
    {
      paramFromServiceMsg = (FromServiceMsg)paramObject;
      if (localRspBody.rpt_msg_seats_info.has()) {
        paramFromServiceMsg = HCSeatInfo.convert(localRspBody.rpt_msg_seats_info.get());
      }
    }
    paramObject = paramFromServiceMsg;
    if (localHotChatInfo != null)
    {
      paramObject = paramFromServiceMsg;
      if (m == 0) {
        if (paramFromServiceMsg != null)
        {
          paramObject = paramFromServiceMsg;
          if (paramFromServiceMsg.size() != 0) {}
        }
        else
        {
          paramObject = HotChatUtil.a(localHotChatInfo, i, j, k, Long.parseLong(str2), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        }
      }
    }
    if ((localHotChatInfo != null) && (paramObject != null))
    {
      localHotChatInfo.updateHCSeatInfoList((List)paramObject);
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (localHotChatInfo.getStatus() == 1001) {
        break label406;
      }
      paramFromServiceMsg.b(localHotChatInfo);
    }
    for (;;)
    {
      paramFromServiceMsg.a();
      if (m != 0) {
        break;
      }
      a(1045, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), str1, str2, Integer.valueOf(m), paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(k) });
      if (QLog.isColorLevel()) {
        NearbyUtils.a(d, new Object[] { "handleUpdateSeatsInfo", Integer.valueOf(m), Integer.valueOf(i), str1, str2, paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(k) });
      }
      return;
      label406:
      paramFromServiceMsg.a(localHotChatInfo);
    }
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
      switch (m)
      {
      }
    }
    for (;;)
    {
      a(1045, false, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), str1, str2, Integer.valueOf(m), paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(k) });
      break;
      paramToServiceMsg = "来晚啦，座位已经被占了~";
      continue;
      paramToServiceMsg = "该座位已被房主关闭。";
      continue;
      if (i == 1)
      {
        paramToServiceMsg = "你已经是嘉宾了哦。";
      }
      else if (i == 3)
      {
        paramToServiceMsg = "你邀请的用户，已经是嘉宾了哦。";
      }
      else
      {
        paramToServiceMsg = "请求占座的嘉宾已经占了座位，不能占多个。";
        continue;
        paramToServiceMsg = "来晚啦，座位已经被占了~";
        continue;
        paramToServiceMsg = "你没有权限操作。";
        continue;
        paramToServiceMsg = "操作失败，请重试。";
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "dismissHotChat.groupcode=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = new oidb_0xa81.ReqBody();
    long l = Long.valueOf(paramString).longValue();
    ((oidb_0xa81.ReqBody)localObject).uint64_groupcode.set(l);
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "dismissHotChat.intcode=" + l);
    }
    localObject = a("OidbSvc.0xa81", 2689, 0, ((oidb_0xa81.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("groupcode", paramString);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troopUin");
    Object localObject1 = paramToServiceMsg.extraData.getString("uuid");
    long l2 = paramToServiceMsg.extraData.getLong("lStartMsgSeq");
    int j = paramToServiceMsg.extraData.getInt("nReqMsgNum");
    int k = paramToServiceMsg.extraData.getInt("nOrder");
    int m = paramToServiceMsg.extraData.getInt("nFlag");
    Object localObject2 = new oidb_0xa8a.RspBody();
    int n = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    long l3;
    if (localObject2 != null)
    {
      paramFromServiceMsg = ((oidb_0xa8a.RspBody)localObject2).bytes_msg_error_info.get().toStringUtf8();
      paramObject = ((oidb_0xa8a.RspBody)localObject2).bytes_poid.get().toStringUtf8();
      l3 = ((oidb_0xa8a.RspBody)localObject2).uint64_next_msg_seq.get();
    }
    for (;;)
    {
      if (n == 0) {
        if ((localObject2 == null) || (!((oidb_0xa8a.RspBody)localObject2).rpt_msg_body.has())) {
          break label1049;
        }
      }
      label409:
      Object localObject3;
      label793:
      label1022:
      label1049:
      for (localObject2 = ((oidb_0xa8a.RspBody)localObject2).rpt_msg_body.get();; localObject3 = null)
      {
        long l1;
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          ArrayList localArrayList = new ArrayList(((List)localObject2).size());
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder(200);
            ((StringBuilder)localObject1).append("msgseq: ");
            Iterator localIterator = ((List)localObject2).iterator();
            l1 = l2;
            while (localIterator.hasNext())
            {
              localObject2 = (oidb_0xa8a.MsgBodyInfo)localIterator.next();
              if ((localObject2 != null) && (((oidb_0xa8a.MsgBodyInfo)localObject2).bytes_msg_body.has()))
              {
                long l5 = ((oidb_0xa8a.MsgBodyInfo)localObject2).uint64_msg_seq.get();
                ByteStringMicro localByteStringMicro = ((oidb_0xa8a.MsgBodyInfo)localObject2).bytes_msg_body.get();
                if (localByteStringMicro == null)
                {
                  localObject2 = null;
                  if (localObject2 == null) {
                    break label409;
                  }
                }
                while (!QLog.isDevelopLevel()) {
                  try
                  {
                    localObject2 = (msg_comm.Msg)new msg_comm.Msg().mergeFrom((byte[])localObject2);
                    ((msg_comm.Msg)localObject2).msg_head.msg_seq.set((int)l5);
                    localArrayList.add(localObject2);
                    long l4 = l1;
                    if (l1 < l5) {
                      l4 = l5;
                    }
                    l1 = l4;
                    if (localObject1 == null) {
                      break;
                    }
                    ((StringBuilder)localObject1).append(l5).append(",");
                    l1 = l4;
                    break;
                    localObject2 = localByteStringMicro.toByteArray();
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      localException.printStackTrace();
                    }
                  }
                }
                if (localByteStringMicro == null) {}
                for (localObject3 = "bsm is null";; localObject3 = "buf is null")
                {
                  NearbyUtils.a("PttShow", "handleGetHotChatMsg", new Object[] { localObject3 });
                  break;
                }
              }
            }
            if ((QLog.isDevelopLevel()) && (localObject1 != null)) {
              NearbyUtils.a("PttShow", "handleGetHotChatMsg", new Object[] { ((StringBuilder)localObject1).toString() });
            }
            localObject1 = localArrayList;
          }
        }
        for (;;)
        {
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject3 = (MessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
            i = 1002;
            if (m == 2) {
              i = 1003;
            }
            ((MessageHandler)localObject3).a("hctopic_processor").a(i, new Object[] { localObject1, str, paramObject, Long.valueOf(l3) });
            localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            if (((MessageCacheItem)localObject1).a(0, str) < l1) {
              HotChatUtil.a((MessageCacheItem)localObject1, l1, str, 3);
            }
          }
          if (QLog.isColorLevel()) {
            NearbyUtils.a("PttShow", new Object[] { "handleGetHotChatMsg", String.format("result:%d troopUin:%s lStartMsgSeq:%d nReqMsgNum:%d  nOrder:%d nFlag:%d lNextMsgSeq:%d errorMsg:%s", new Object[] { Integer.valueOf(n), str, Long.valueOf(l2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l3), paramFromServiceMsg }) });
          }
          int i = paramToServiceMsg.extraData.getInt("nTryCount");
          if ((n != 0) && (n != 1284) && (i > 0) && (i < 3))
          {
            paramToServiceMsg = new Bundle(paramToServiceMsg.extraData);
            paramFromServiceMsg = Message.obtain();
            paramFromServiceMsg.obj = "OidbSvc.0xa8a";
            paramFromServiceMsg.setData(paramToServiceMsg);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramFromServiceMsg, i * 500);
          }
          boolean bool;
          do
          {
            return;
            if (n != 0) {
              break;
            }
            bool = true;
            a(1046, bool, new Object[] { Integer.valueOf(n), str, paramObject, Long.valueOf(l2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l3), paramFromServiceMsg });
          } while (m != 1);
          paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          ((MessageCacheItem)paramObject).a(str, 2);
          paramFromServiceMsg = ((MessageCacheItem)paramObject).a(str);
          if (QLog.isColorLevel())
          {
            localObject1 = d;
            if (paramFromServiceMsg != null) {
              break label1022;
            }
          }
          for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.size()))
          {
            NearbyUtils.a((String)localObject1, new Object[] { "handleGetHotChatMsg", "finish get pull msg, deal cache push: ", paramToServiceMsg });
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
              break;
            }
            ((MessageCacheItem)paramObject).a(str);
            paramToServiceMsg = (MessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
            paramFromServiceMsg = paramFromServiceMsg.iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (Object[])paramFromServiceMsg.next();
              paramToServiceMsg.a("hctopic_processor").a(1001, (Object[])paramObject);
            }
            break;
            bool = false;
            break label793;
          }
          localObject1 = null;
          break;
          localObject1 = null;
          l1 = l2;
        }
      }
      l3 = 0L;
      paramFromServiceMsg = null;
      paramObject = localObject1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      String str = (String)paramMessage.obj;
      paramMessage = paramMessage.getData();
      if ("OidbSvc.0xa8a".equals(str))
      {
        int i = paramMessage.getInt("nTryCount") + 1;
        if (i <= 3) {
          a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(true).a(paramMessage.getString("troopUin")), paramMessage.getLong("lStartMsgSeq"), paramMessage.getInt("nReqMsgNum"), paramMessage.getInt("nOrder"), paramMessage.getInt("nFlag"), i);
        }
      }
      return true;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotChatHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */