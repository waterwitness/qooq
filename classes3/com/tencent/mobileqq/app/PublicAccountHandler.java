package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.biz.pubaccount.DynamicMsgProcessor;
import com.tencent.biz.pubaccount.PublicAccountManageActivity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageReq;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageRsp;
import com.tencent.jungle.weather.WeatherReportInfo.PbReqMsgHead;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgRequest;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgResponse;
import com.tencent.mobileqq.mp.historyMsg.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.MpGetNotifycationResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.MpIsAdminUinResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendLBSInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPreMessageStatusResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendRequest;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONException;
import org.json.JSONObject;
import qdn;
import qdo;
import qdq;
import qdr;
import qds;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.FollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;

public class PublicAccountHandler
  extends BusinessHandler
{
  public static final int a = -1;
  public static final String a = "Pb_account_lifeservice";
  public static final int b = 0;
  public static long b = 0L;
  public static String b;
  public static final int c = 1;
  public static long c = 0L;
  public static String c;
  public static final int d = 2;
  public static long d = 0L;
  public static final String d = "PubAccountSvc.ReportLbs";
  public static final int e = 4;
  public static final String e = "QQWeatherReport.getWeatherInfo";
  private static final int f = 20;
  public static final String f = "list_time";
  private static final int g = 3600000;
  public static final String g = "aio_time";
  private static final int h = 1;
  public static final String h = "location_time";
  private static final int i = 2;
  public static final String i = "loc_lat";
  private static final int j = 1;
  public static final String j = "loc_lng";
  private static final int jdField_k_of_type_Int = 2;
  private static final String jdField_k_of_type_JavaLangString;
  private static final int jdField_l_of_type_Int = 3;
  private static final String jdField_l_of_type_JavaLangString = "PublicAccount_TotalSwitch";
  private static final String m = "PublicAccount_SearchSwitch";
  private static final String n = "PublicAccountFollowSeq2";
  private static final String o = "PublicAccountDataSeq2";
  private static final String p = "time_stamp";
  private static final String q = "get_user_follow_list_begin";
  private static final String r = "get_user_follow_list_follow_seq";
  private static final String s = "get_user_follow_list_data_seq";
  private static final String t = "get_user_follow_list_is_increment";
  public long a;
  public List a;
  private Map a;
  public boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    k = PublicAccountHandler.class.getSimpleName();
    jdField_c_of_type_JavaLangString = "";
  }
  
  PublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_Boolean = true;
    String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_TotalSwitch");
    if (str != null) {}
    try
    {
      this.jdField_b_of_type_Boolean = Boolean.parseBoolean(str);
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_SearchSwitch");
      if (paramQQAppInterface != null) {}
      try
      {
        this.jdField_c_of_type_Boolean = Boolean.parseBoolean(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(k, 2, "getUserFollowList");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_follow_list");
    mobileqq_mp.GetUserFollowListRequest localGetUserFollowListRequest = new mobileqq_mp.GetUserFollowListRequest();
    localGetUserFollowListRequest.follow_seqno.set(Utils.a(paramLong1));
    localGetUserFollowListRequest.public_account_seqno.set(Utils.a(paramLong2));
    localGetUserFollowListRequest.begin.set(Utils.a(paramLong3));
    localGetUserFollowListRequest.limit.set(Utils.a(paramLong4));
    localGetUserFollowListRequest.version.set(1);
    localGetUserFollowListRequest.is_increment.set(paramBoolean);
    localNewIntent.putExtra("data", localGetUserFollowListRequest.toByteArray());
    localNewIntent.putExtra("get_user_follow_list_begin", paramLong3);
    localNewIntent.putExtra("get_user_follow_list_follow_seq", paramLong1);
    localNewIntent.putExtra("get_user_follow_list_data_seq", paramLong2);
    localNewIntent.putExtra("time_stamp", paramLong5);
    localNewIntent.putExtra("get_user_follow_list_is_increment", paramBoolean);
    PublicAccountServlet.a(localNewIntent);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    return 0;
  }
  
  private long a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountFollowSeq2", 0L);
  }
  
  private void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountFollowSeq2", paramLong);
    localEditor.commit();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, paramInt, 0, paramString1, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, paramString5, paramString6, "");
  }
  
  private void a(List paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = ((PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a(paramList, paramLong, paramBoolean1, paramBoolean2);
    paramList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject1 = ((List)localObject1).iterator();
    int i1 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
      localObject2 = paramList.a().b(((PublicAccountInfo)localObject2).getUin(), 1008);
      if (localObject2 == null) {
        break label131;
      }
      paramList.a().b((RecentUser)localObject2);
      i1 = 1;
    }
    label131:
    for (;;)
    {
      break;
      paramList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if ((i1 != 0) && (paramList != null)) {
        paramList.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  private void a(SubMsgType0x28.RspFollowList paramRspFollowList)
  {
    int i1 = 0;
    paramRspFollowList = paramRspFollowList.rpt_msg_followlist.get();
    long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Iterator localIterator = paramRspFollowList.iterator();
    paramRspFollowList = null;
    int i2 = 0;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject2 = (SubMsgType0x28.FollowList)localIterator.next();
      if (l1 == ((SubMsgType0x28.FollowList)localObject2).uint64_uin.get())
      {
        localObject1 = String.valueOf(((SubMsgType0x28.FollowList)localObject2).uint64_puin.get());
        switch (((SubMsgType0x28.FollowList)localObject2).uint32_type.get())
        {
        }
      }
    }
    for (;;)
    {
      break;
      localObject2 = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      ((PublicAccountDataManager)localObject2).b((String)localObject1);
      ((PublicAccountDataManager)localObject2).a((String)localObject1);
      paramRspFollowList = new qdr();
      paramRspFollowList.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject2).a(l1 + "");
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 1008);
      TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject2).a());
      ServiceAccountFolderManager.a().c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = (EcShopAssistantManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      if (localObject1 != null)
      {
        ((EcShopAssistantManager)localObject1).a(l1 + "", "pushmsg");
        i2 = 1;
        continue;
        a();
        i1 = 1;
        continue;
        if (i2 != 0)
        {
          a(103, true, null);
          a(102, true, paramRspFollowList);
        }
        if (i1 != 0) {
          a(101, true, null);
        }
      }
      else
      {
        i2 = 1;
      }
    }
  }
  
  private void a(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private long b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountDataSeq2", 0L);
  }
  
  private void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountDataSeq2", paramLong);
    localEditor.commit();
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      int i1;
      try
      {
        paramIntent = new publicaccount_recommend.BusinessRecommendResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label186;
        }
        i1 = ((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.get();
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "handleGetRecommendList(): package size is " + paramArrayOfByte.length + " Byte");
      }
      if (paramIntent.business.has())
      {
        paramIntent = PublicRecommendAccountInfo.createPublicRecommendAccountInfoList(paramIntent.business.get());
        ((PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a(paramIntent);
        a(104, true, null);
        return;
        a(104, false, null);
        return;
      }
      while (i1 != 0)
      {
        return;
        label186:
        i1 = -1;
      }
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    qds localqds = new qds();
    int i2 = 1;
    boolean bool2 = false;
    int i1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 2901) && (paramIntent != null))
    {
      i1 = paramIntent.getIntExtra("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "handleGetUserFollowListk_resend_cnt" + i1);
      }
      if (i1 < 2)
      {
        paramIntent.putExtra("k_resend_cnt", i1 + 1);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)paramIntent);
        return;
      }
    }
    long l1;
    long l2;
    long l3;
    long l4;
    boolean bool1;
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null))
    {
      localqds.jdField_a_of_type_Int = 0;
      l1 = paramIntent.getLongExtra("time_stamp", 0L);
      l2 = paramIntent.getLongExtra("get_user_follow_list_begin", 0L);
      l3 = paramIntent.getLongExtra("get_user_follow_list_follow_seq", 0L);
      l4 = paramIntent.getLongExtra("get_user_follow_list_data_seq", 0L);
      bool2 = paramIntent.getBooleanExtra("get_user_follow_list_is_increment", true);
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "handleGetUserFollowListtiem: " + l1 + "begin: " + l2 + "preFollowSeq: " + l3 + "preDataSeq: " + l4);
      }
      for (;;)
      {
        try
        {
          paramIntent = new mobileqq_mp.GetUserFollowListResponse();
          paramIntent.mergeFrom(paramArrayOfByte);
          if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
            continue;
          }
          i1 = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
          localqds.jdField_a_of_type_Int = i1;
          if (QLog.isColorLevel()) {
            QLog.d(k, 2, "handleGetUserFollowListerrCode: " + i1);
          }
          if (i1 == 0) {
            continue;
          }
          localqds.jdField_a_of_type_Boolean = true;
          bool1 = false;
          i1 = 1;
        }
        catch (Exception paramIntent)
        {
          label404:
          label430:
          long l5;
          localqds.jdField_a_of_type_Int = -1;
          localqds.jdField_a_of_type_Boolean = true;
          bool1 = false;
          i1 = 1;
          continue;
          a(l4);
          continue;
        }
        if (i1 == 0) {
          break;
        }
        a(100, bool1, localqds);
        return;
        i1 = 0;
        continue;
        if (!paramIntent.follow_seqno.has()) {
          break label844;
        }
        i1 = paramIntent.follow_seqno.get();
        l4 = Utils.a(i1);
        if (!paramIntent.public_account_seqno.has()) {
          break label850;
        }
        i1 = paramIntent.public_account_seqno.get();
        l5 = Utils.a(i1);
        if ((l4 <= l3) || (l3 == 0L)) {
          continue;
        }
        a(l4, l5, 0L, 20L, SystemClock.uptimeMillis(), false);
        i1 = 0;
        bool1 = false;
      }
      if (!paramIntent.total_count.has()) {
        break label862;
      }
      i1 = paramIntent.total_count.get();
      label497:
      l3 = Utils.a(i1);
      paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoList(paramIntent.info.get(), l1);
      localqds.jdField_a_of_type_JavaUtilList = paramFromServiceMsg;
      if (!paramIntent.has_next.has()) {
        break label856;
      }
      if (paramIntent.has_next.get()) {
        break label868;
      }
    }
    for (;;)
    {
      localqds.jdField_a_of_type_Boolean = bool1;
      localqds.jdField_a_of_type_Long = l3;
      paramIntent = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      a(paramFromServiceMsg, l1, bool2, localqds.jdField_a_of_type_Boolean);
      if (localqds.jdField_a_of_type_Boolean)
      {
        TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.a());
        ServiceAccountFolderManager.a().c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        TroopBarAssistantManager.a().i(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        ReadInJoyLogicEngine.a().g();
        paramIntent = new qdq(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
        ThreadManager.b().postDelayed(paramIntent, 15000L);
        ThreadManager.b().postDelayed(new qdn(this), 500L);
      }
      if (!localqds.jdField_a_of_type_Boolean)
      {
        if (bool2) {
          a(l4, l5, 0L, 20L, l1, true);
        }
        for (;;)
        {
          b(l5);
          bool1 = true;
          i1 = 1;
          break;
          a(l4, l5, l2 + 20L, 20L, l1, false);
        }
      }
      localqds.jdField_a_of_type_Int = -1;
      localqds.jdField_a_of_type_Boolean = true;
      bool1 = bool2;
      i1 = i2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(k, 2, "<<---handleGetUserFollowList " + localqds.jdField_a_of_type_Int);
      bool1 = bool2;
      i1 = i2;
      break;
      label844:
      i1 = 0;
      break label404;
      label850:
      i1 = 0;
      break label430;
      label856:
      bool1 = true;
      continue;
      label862:
      i1 = 0;
      break label497;
      label868:
      bool1 = false;
    }
  }
  
  public int a()
  {
    long l1 = a();
    long l2 = b();
    long l3 = SystemClock.uptimeMillis();
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(l3);
    }
    return a(l1, l2, 0L, 20L, l3, true);
  }
  
  public int a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_business_recommend");
    publicaccount_recommend.BusinessRecommendRequest localBusinessRecommendRequest = new publicaccount_recommend.BusinessRecommendRequest();
    localBusinessRecommendRequest.recomend_count.set(20);
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null) || (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString == null)) {
        break label232;
      }
    }
    label232:
    for (String str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "getRecommendList() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.jdField_b_of_type_Double + ", address=" + str);
      }
      localBusinessRecommendRequest.latitude.set(String.valueOf(paramSosoLbsInfo.a.a));
      localBusinessRecommendRequest.longitude.set(String.valueOf(paramSosoLbsInfo.a.jdField_b_of_type_Double));
      localBusinessRecommendRequest.city_info.set(str);
      localBusinessRecommendRequest.platform.set(109);
      localNewIntent.putExtra("data", localBusinessRecommendRequest.toByteArray());
      PublicAccountServlet.a(localNewIntent);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return 0;
    }
  }
  
  protected Class a()
  {
    return PublicAccountObserver.class;
  }
  
  public void a()
  {
    a(103, true, null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject1 = new String();
    i1 = 0;
    while (i1 < "6.5.5".length())
    {
      localObject2 = localObject1;
      if ("6.5.5".charAt(i1) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("6.5.5".charAt(i1)));
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    localObject2 = new WeatherReportInfo.PbReqMsgHead();
    ((WeatherReportInfo.PbReqMsgHead)localObject2).uint32_platform_type.set(1);
    ((WeatherReportInfo.PbReqMsgHead)localObject2).uint32_version.set(Integer.parseInt((String)localObject1));
    localGetWeatherMessageReq = new WeatherReportInfo.GetWeatherMessageReq();
    localGetWeatherMessageReq.pbReqMsgHead.set((MessageMicro)localObject2);
    localGetWeatherMessageReq.uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
    localGetWeatherMessageReq.lat.set(paramInt2);
    localGetWeatherMessageReq.lng.set(paramInt3);
    localGetWeatherMessageReq.fore_flag.set(0);
    localGetWeatherMessageReq.area_id.set(paramInt4);
    try
    {
      localObject1 = new JSONObject();
      if (paramInt1 != 0) {
        break label366;
      }
      localGetWeatherMessageReq.source.set(2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject3;
        int i2;
        try
        {
          localObject3 = NetworkInterface.getNetworkInterfaces();
          localObject2 = localObject1;
          if (((Enumeration)localObject3).hasMoreElements())
          {
            localObject2 = ((NetworkInterface)((Enumeration)localObject3).nextElement()).getInetAddresses();
            if (!((Enumeration)localObject2).hasMoreElements()) {
              break label626;
            }
            InetAddress localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
            if ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address))) {
              continue;
            }
            localObject1 = localInetAddress.getHostAddress().toString();
            continue;
            if (paramInt1 == -1)
            {
              localGetWeatherMessageReq.source.set(1);
              continue;
              localJSONException = localJSONException;
              localJSONException.printStackTrace();
              continue;
            }
            localJSONException.put("cmd", paramInt1);
            localGetWeatherMessageReq.source.set(0);
          }
        }
        catch (Exception localException1)
        {
          localObject2 = "";
          localException1.printStackTrace();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i1 = i2;
          try
          {
            String[] arrayOfString = ((String)localObject2).split(Pattern.quote("."));
            i1 = i2;
            int i4 = arrayOfString.length;
            int i3 = 0;
            int i5;
            for (i1 = 0;; i1 = i2 | i5)
            {
              i2 = i1;
              if (i3 >= i4) {
                break;
              }
              localObject3 = arrayOfString[i3];
              i2 = i1 << 8;
              i1 = i2;
              i5 = Integer.parseInt((String)localObject3);
              i3 += 1;
            }
            localGetWeatherMessageReq.ip.set(i2);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            i2 = i1;
            jdField_b_of_type_JavaLangString = (String)localObject2;
          }
        }
        for (;;)
        {
          ToServiceMsg localToServiceMsg = a("QQWeatherReport.getWeatherInfo");
          localToServiceMsg.putWupBuffer(localGetWeatherMessageReq.toByteArray());
          b(localToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d(k, 2, String.format("send tianqi lat=%d, lng=%d, type=%d, areaid = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4) }));
          }
          return;
          i2 = 0;
        }
      }
    }
    ((JSONObject)localObject1).put("platform", 109);
    ((JSONObject)localObject1).put("version", "6.5.5");
    localObject2 = ((JSONObject)localObject1).toString();
    localObject3 = localGetWeatherMessageReq.extra;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    ((PBStringField)localObject3).set((String)localObject1);
    i2 = 0;
    localObject1 = jdField_b_of_type_JavaLangString;
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
  }
  
  public void a(int paramInt, PublicAccountHandler.IWeatherInfoListener paramIWeatherInfoListener)
  {
    if (paramIWeatherInfoListener != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramIWeatherInfoListener);
    }
    if (paramInt == 1) {
      a(paramInt, 0, 0, 0);
    }
    while (paramInt != 2) {
      return;
    }
    paramIWeatherInfoListener = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    long l1 = paramIWeatherInfoListener.getLong("location_time", 0L);
    if ((l1 != 0L) && (System.currentTimeMillis() - l1 < 3600000L))
    {
      int i1 = paramIWeatherInfoListener.getInt("loc_lat", 0);
      int i2 = paramIWeatherInfoListener.getInt("loc_lng", 0);
      if ((i1 != 0) && (i2 != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i(k, 2, "local time less than 1 hour");
        }
        a(paramInt, i1, i2, 0);
        return;
      }
    }
    SosoInterface.a(new qdo(this, 0, false, true, 60000L, true, false, k, paramInt, paramIWeatherInfoListener));
  }
  
  /* Error */
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: getstatic 89	com/tencent/mobileqq/app/PublicAccountHandler:k	Ljava/lang/String;
    //   9: iconst_2
    //   10: new 379	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 884
    //   20: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: l2i
    //   25: invokestatic 888	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   28: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 390	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: lload_1
    //   38: l2i
    //   39: lookupswitch	default:+25->64, 40:+26->65, 63:+126->165
    //   64: return
    //   65: new 890	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   68: dup
    //   69: invokespecial 891	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:<init>	()V
    //   72: aload_3
    //   73: invokevirtual 892	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: checkcast 890	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   79: astore_3
    //   80: aload_3
    //   81: getfield 895	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 369	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   87: istore 8
    //   89: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +31 -> 123
    //   95: getstatic 89	com/tencent/mobileqq/app/PublicAccountHandler:k	Ljava/lang/String;
    //   98: iconst_2
    //   99: new 379	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 380	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 897
    //   109: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 8
    //   114: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 390	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iload 8
    //   125: iconst_1
    //   126: if_icmpne +18 -> 144
    //   129: aload_0
    //   130: aload_3
    //   131: getfield 901	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_followlist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;
    //   134: invokevirtual 902	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   137: checkcast 326	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList
    //   140: invokespecial 904	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;)V
    //   143: return
    //   144: iload 8
    //   146: iconst_2
    //   147: if_icmpne -83 -> 64
    //   150: aload_0
    //   151: aload_3
    //   152: getfield 908	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_typelist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;
    //   155: invokevirtual 911	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 910	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList
    //   161: invokespecial 913	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;)V
    //   164: return
    //   165: new 915	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody
    //   168: dup
    //   169: invokespecial 916	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:<init>	()V
    //   172: astore 4
    //   174: aload 4
    //   176: aload_3
    //   177: invokevirtual 917	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   180: pop
    //   181: aload 4
    //   183: getfield 920	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:rpt_msg_pubunikey	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   186: invokevirtual 336	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   189: invokeinterface 285 1 0
    //   194: astore_3
    //   195: aload_3
    //   196: invokeinterface 290 1 0
    //   201: ifeq -137 -> 64
    //   204: aload_3
    //   205: invokeinterface 294 1 0
    //   210: checkcast 922	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey
    //   213: astore 4
    //   215: aload 4
    //   217: getfield 925	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_fromPubUin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   220: invokevirtual 354	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   223: lstore_1
    //   224: aload 4
    //   226: getfield 928	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_qwMsgId	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   229: invokevirtual 354	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   232: lstore 9
    //   234: lload_1
    //   235: invokestatic 930	java/lang/Long:toString	(J)Ljava/lang/String;
    //   238: astore 4
    //   240: aload_0
    //   241: getfield 146	com/tencent/mobileqq/app/PublicAccountHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   244: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   247: aload 4
    //   249: sipush 1008
    //   252: aconst_null
    //   253: invokevirtual 933	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I[I)Ljava/util/List;
    //   256: invokeinterface 285 1 0
    //   261: astore 5
    //   263: aload 5
    //   265: invokeinterface 290 1 0
    //   270: ifeq -75 -> 195
    //   273: aload 5
    //   275: invokeinterface 294 1 0
    //   280: checkcast 935	com/tencent/mobileqq/data/MessageRecord
    //   283: astore 6
    //   285: aload 6
    //   287: invokestatic 940	com/tencent/mobileqq/activity/aio/XMLMessageUtils:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/PAMessage;
    //   290: astore 7
    //   292: aload 7
    //   294: ifnull +37 -> 331
    //   297: aload 7
    //   299: getfield 945	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   302: lload 9
    //   304: lcmp
    //   305: ifne +26 -> 331
    //   308: aload_0
    //   309: getfield 146	com/tencent/mobileqq/app/PublicAccountHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   315: aload 4
    //   317: sipush 1008
    //   320: aload 6
    //   322: getfield 948	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   325: invokevirtual 951	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)V
    //   328: goto -133 -> 195
    //   331: aload 6
    //   333: ldc_w 953
    //   336: invokevirtual 956	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   339: astore 7
    //   341: aload 7
    //   343: ifnull -80 -> 263
    //   346: aload 7
    //   348: invokestatic 344	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   351: lload 9
    //   353: lcmp
    //   354: ifne -91 -> 263
    //   357: aload_0
    //   358: getfield 146	com/tencent/mobileqq/app/PublicAccountHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   361: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   364: aload 4
    //   366: sipush 1008
    //   369: aload 6
    //   371: getfield 948	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   374: invokevirtual 951	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)V
    //   377: goto -182 -> 195
    //   380: astore 6
    //   382: goto -119 -> 263
    //   385: astore_3
    //   386: return
    //   387: astore_3
    //   388: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	PublicAccountHandler
    //   0	389	1	paramLong	long
    //   0	389	3	paramArrayOfByte	byte[]
    //   172	193	4	localObject1	Object
    //   261	13	5	localIterator	Iterator
    //   283	87	6	localMessageRecord	com.tencent.mobileqq.data.MessageRecord
    //   380	1	6	localException	Exception
    //   290	57	7	localObject2	Object
    //   87	61	8	i1	int
    //   232	120	9	l1	long
    // Exception table:
    //   from	to	target	type
    //   346	377	380	java/lang/Exception
    //   65	123	385	java/lang/Exception
    //   129	143	385	java/lang/Exception
    //   150	164	385	java/lang/Exception
    //   165	195	387	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   195	263	387	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   263	292	387	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   297	328	387	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   331	341	387	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   346	377	387	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d(k, 2, "<<---onReceive " + str);
    }
    if (str.equals("get_follow_list")) {
      c(paramIntent, paramFromServiceMsg, arrayOfByte);
    }
    do
    {
      do
      {
        return;
      } while (str.equals("secmsg.configs"));
      if (str.equals("get_business_recommend"))
      {
        b(paramIntent, paramFromServiceMsg, arrayOfByte);
        return;
      }
      if (str.equals("send_pre_message_status"))
      {
        a(paramIntent, paramFromServiceMsg, arrayOfByte);
        return;
      }
      if (str.equals("pull_aio_history_msg"))
      {
        e(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equals("pull_account_detail_dynamic_list"))
      {
        d(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equals("PubAccountSvc.mp_is_admin_uin"))
      {
        c(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!str.equals("PubAccountSvc.mp_get_notifycation"));
    b(paramIntent, paramFromServiceMsg, paramObject);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramIntent = new mobileqq_mp.SendPreMessageStatusResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label180;
        }
        i1 = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
        if (i1 != 0)
        {
          if (!QLog.isColorLevel()) {
            break label179;
          }
          QLog.d(k, 2, "handlePreSendMsg error, errcode: " + i1);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label179;
        }
        QLog.d(k, 2, "handlePreSendMsg success: package size is " + paramArrayOfByte.length + " Byte");
        return;
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "handlePreSendMsg  failed!");
      }
      label179:
      return;
      label180:
      int i1 = -1;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {}
    for (;;)
    {
      return;
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
        continue;
      }
      if ("PubAccountSvc.ReportLbs".equalsIgnoreCase(paramToServiceMsg))
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          continue;
        }
        return;
      }
      if ((!"QQWeatherReport.getWeatherInfo".equals(paramToServiceMsg)) || (!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        continue;
      }
      paramToServiceMsg = new WeatherReportInfo.GetWeatherMessageRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        int i1 = paramToServiceMsg.cmd.get();
        paramToServiceMsg = paramToServiceMsg.string_msg.get();
        if ((i1 == 1) || (i1 == 2))
        {
          paramFromServiceMsg = (PublicAccountHandler.IWeatherInfoListener)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i1));
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.a(paramToServiceMsg);
          }
          this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i1));
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(k, 2, "type = " + i1 + " msg =" + paramToServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(Object paramObject)
  {
    qdr localqdr = new qdr();
    localqdr.jdField_a_of_type_Int = 0;
    long l1 = SystemClock.uptimeMillis();
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((paramObject instanceof AccountDetail))
    {
      localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l1);
      localPublicAccountDataManager.a((AccountDetail)paramObject);
    }
    for (;;)
    {
      localPublicAccountDataManager.a(localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localPublicAccountDataManager.a());
      if ((paramObject instanceof AccountDetail)) {
        ServiceAccountFolderManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      }
      paramObject = (EcShopAssistantManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      if (paramObject != null) {
        ((EcShopAssistantManager)paramObject).a(localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), "onFollow");
      }
      a(101, true, localqdr);
      return;
      if ((paramObject instanceof EqqDetail)) {
        localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l1);
      }
    }
  }
  
  public void a(String paramString1, double paramDouble1, double paramDouble2, String paramString2)
  {
    try
    {
      long l1 = Long.valueOf(paramString1).longValue();
      paramString1 = new mobileqq_mp.SendLBSInfoRequest();
      paramString1.luin.set(l1);
      paramString1.latitude.set(paramDouble1);
      paramString1.longitude.set(paramDouble2);
      paramString1.cityinfo.set(paramString2);
      paramString2 = a("PubAccountSvc.ReportLbs");
      paramString2.putWupBuffer(paramString1.toByteArray());
      b(paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    a(paramString, paramLong, paramInt, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt, BusinessObserver paramBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "pull_aio_history_msg");
    historyMsg.AioHistoryMsgRequest localAioHistoryMsgRequest = new historyMsg.AioHistoryMsgRequest();
    localAioHistoryMsgRequest.puin.set(Long.parseLong(paramString));
    localAioHistoryMsgRequest.msg_id.set(paramLong);
    localAioHistoryMsgRequest.msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", localAioHistoryMsgRequest.toByteArray());
    if (paramBusinessObserver != null) {
      localNewIntent.setObserver(paramBusinessObserver);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006502", "0X8006502", 0, 0, "", "", "", "");
      return;
      PublicAccountServlet.a(localNewIntent);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "onReceive get notification :" + bool1);
      }
      if (bool1)
      {
        paramIntent = new mobileqq_mp.MpGetNotifycationResponse();
        try
        {
          paramIntent.mergeFrom((byte[])paramObject);
          long l1 = paramIntent.fans_msg_id.get();
          long l2 = paramIntent.publish_msg_id.get();
          paramIntent.publish_msg_tips.get().toStringUtf8();
          paramIntent = paramIntent.fans_msg_tips.get().toStringUtf8();
          if (l2 > jdField_b_of_type_Long)
          {
            jdField_b_of_type_Long = l2;
            jdField_c_of_type_Long = l1;
          }
          for (jdField_c_of_type_JavaLangString = "公告";; jdField_c_of_type_JavaLangString = "粉丝消息")
          {
            a(106, bool1, Boolean.valueOf(bool2));
            return;
            bool1 = false;
            break;
            if (l1 <= jdField_c_of_type_Long) {
              break label193;
            }
            jdField_c_of_type_Long = l1;
            jdField_c_of_type_JavaLangString = paramIntent;
          }
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
            label193:
            bool2 = false;
          }
        }
      }
    }
    QLog.d(k, 2, "get notification failed" + bool1);
  }
  
  public void b(Object paramObject)
  {
    qdr localqdr = new qdr();
    localqdr.jdField_a_of_type_Int = 0;
    long l1 = SystemClock.uptimeMillis();
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((paramObject instanceof AccountDetail))
    {
      localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l1);
      localPublicAccountDataManager.b((AccountDetail)paramObject);
    }
    for (;;)
    {
      localPublicAccountDataManager.b(localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      if ((paramObject instanceof EqqDetail))
      {
        EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68);
        if (localEqqDetailDataManager != null) {
          localEqqDetailDataManager.b((EqqDetail)paramObject);
        }
      }
      TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localPublicAccountDataManager.a());
      if ((paramObject instanceof AccountDetail)) {
        ServiceAccountFolderManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      }
      paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(PublicAccountManageActivity.class);
      if (paramObject != null) {
        ((MqqHandler)paramObject).sendEmptyMessage(100);
      }
      paramObject = (EcShopAssistantManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      if (paramObject != null) {
        ((EcShopAssistantManager)paramObject).a(localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), "onUnfollow");
      }
      a(102, true, localqdr);
      return;
      if ((paramObject instanceof EqqDetail)) {
        localqdr.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l1);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    b(0L);
    a(0L);
  }
  
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "onReceive handleIsMpAdmin :" + bool);
      }
      if (!bool) {
        break label158;
      }
      paramIntent = new mobileqq_mp.MpIsAdminUinResponse();
    }
    for (;;)
    {
      try
      {
        paramIntent.mergeFrom((byte[])paramObject);
        i1 = paramIntent.is_mp_admin.get();
        if (i1 == 1) {}
        try
        {
          com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.f = true;
          jdField_d_of_type_Long = paramIntent.puin.get();
          if (QLog.isColorLevel()) {
            QLog.d(k, 2, "onReceive handle is MP admin errCode:" + i1);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramIntent) {}
        bool = false;
        break;
        com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.f = false;
        continue;
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        label158:
        int i1 = 2;
        continue;
      }
      paramIntent.printStackTrace();
      continue;
      i1 = 0;
    }
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "onReceive handleAccountDetailDynamicList :" + bool);
      }
      if (bool) {
        i1 = AccountDetailDynamicListModel.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getBooleanExtra("isFirstEnter", false), (byte[])paramObject, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "onReceive handleAccountDetailDynamicList errCode:" + i1);
      }
      a(107, bool, Integer.valueOf(i1));
      return;
    }
  }
  
  public void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 1;
    int i3 = 0;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "handleAIOHistoryMsg onReceive :" + bool);
      }
      if (!bool) {}
    }
    for (;;)
    {
      int i2;
      try
      {
        paramFromServiceMsg = new historyMsg.AioHistoryMsgResponse();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i2 = paramFromServiceMsg.ret_info.ret_code.get();
        if (i2 != 0) {
          break label388;
        }
        if (QLog.isColorLevel()) {
          QLog.e(k, 2, "result: " + i2);
        }
        if (paramFromServiceMsg.msg_infos.has()) {
          break label366;
        }
        i2 = 2;
        a(105, true, Integer.valueOf(i2));
        if ((i1 == 0) || (!paramFromServiceMsg.msg_infos.has()) || (!paramFromServiceMsg.puin.has())) {
          break label381;
        }
        l1 = paramFromServiceMsg.puin.get();
        paramIntent = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.msg_infos.get();
        if (paramFromServiceMsg == null) {
          i1 = 0;
        } else {
          i1 = paramFromServiceMsg.size();
        }
      }
      catch (Exception paramIntent)
      {
        long l1;
        msg_comm.Msg localMsg;
        if (!QLog.isColorLevel()) {
          break label381;
        }
      }
      if (i2 < i1)
      {
        paramObject = ((ByteStringMicro)paramFromServiceMsg.get(i2)).toByteArray();
        localMsg = new msg_comm.Msg();
        localMsg.mergeFrom(Base64Util.decode((byte[])paramObject, 0));
        paramIntent.add(localMsg);
        i2 += 1;
      }
      else if ((paramIntent != null) && (paramIntent.size() != 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Long = l1;
        new DynamicMsgProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).b(l1, paramIntent);
        return;
        QLog.e(k, 2, "handleGetRecommendList onReceive fail: ", paramIntent);
        return;
        a(105, true, Integer.valueOf(1));
        return;
        label366:
        i2 = 0;
        continue;
        i2 = i3;
        if (i1 > 0) {}
      }
      else
      {
        label381:
        return;
        bool = false;
        break;
        label388:
        i1 = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PublicAccountHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */