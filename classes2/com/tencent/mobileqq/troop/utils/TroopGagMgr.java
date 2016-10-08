package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.MemberGagInfo;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.PushParam;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import vqq;
import vqs;
import vqt;

public class TroopGagMgr
  implements Manager
{
  public static final int a = 10;
  public static final String a = "TroopGagMgr";
  public static final int b = 5;
  public static final String b = "GagMemberConfig";
  public static final int c = 1;
  public static final String c = "GagMemberCustomConfig";
  public static final int d = 2;
  public static final String d = "troopUin";
  public static final int e = 3;
  public static final String e = "memberUin";
  public static final int f = 4;
  public static final String f = "timpStamp";
  public static final int g = 5;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public QQAppInterface a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  Queue jdField_a_of_type_JavaUtilQueue;
  
  public TroopGagMgr(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vqt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("troop_gag_seqlist", 32768);
    paramQQAppInterface = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("seqs", null);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.split(";");
      int m = paramQQAppInterface.length;
      int k = 0;
      while (k < m)
      {
        String str = paramQQAppInterface[k];
        this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(str));
        k += 1;
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).e(new TroopGagMgr.GagStatus(paramString, new TroopGagMgr.GagTroopResult(paramBoolean, paramLong)));
  }
  
  private void b(String paramString)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).e(new TroopGagMgr.GagStatus(paramString, a(paramString)));
  }
  
  private void b(String paramString, boolean paramBoolean, long paramLong)
  {
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    paramString = new TroopGagMgr.GagStatus(paramString, new TroopGagMgr.GagTroopMemberResult(paramBoolean, paramLong));
    paramString.b = 3;
    localBizTroopHandler.e(paramString);
  }
  
  private void c(String paramString)
  {
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    ThreadManager.a(new vqq(this, paramString, new Handler(Looper.getMainLooper()), localBizTroopHandler), 8, null, false);
  }
  
  public TroopGagMgr.GagCustomConfig a()
  {
    Object localObject = Base64Util.encodeToString("{\"defday\":2,\"defhour\":0,\"defminute\":0,\"maxday\":30}".getBytes(), 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GagMemberCustomConfig");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      return a(new String(Base64Util.decode(((String)localObject).getBytes(), 0)));
    }
  }
  
  public TroopGagMgr.GagCustomConfig a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("parseGagCustomConfig = %s", new Object[] { paramString }));
    }
    try
    {
      paramString = new JSONObject(paramString);
      paramString = new TroopGagMgr.GagCustomConfig(this, paramString.optInt("defday"), paramString.optInt("defhour"), paramString.optInt("defminute"), paramString.optInt("maxday"));
      return paramString;
    }
    catch (JSONException paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, "parseGagCustomConfig failed");
      }
    }
    return null;
  }
  
  public TroopGagMgr.GagItem a(String paramString, int paramInt)
  {
    if (paramString != null) {
      return new TroopGagMgr.GagItem(this, paramString, paramInt);
    }
    return null;
  }
  
  public TroopGagMgr.SelfGagInfo a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject == null) {
      return new TroopGagMgr.SelfGagInfo(this, paramString, false, "", 0L);
    }
    localObject = ((TroopManager)localObject).b(paramString);
    if (localObject == null) {
      return new TroopGagMgr.SelfGagInfo(this, paramString, false, "", 0L);
    }
    long l = NetConnInfoCenter.getServerTime();
    boolean bool = a(paramString);
    if ((((TroopInfo)localObject).dwGagTimeStamp != 0L) && (!bool))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, Troop Gag", new Object[] { paramString }));
      }
      return new TroopGagMgr.SelfGagInfo(this, paramString, true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131364703), 60L);
    }
    if ((((TroopInfo)localObject).dwGagTimeStamp_me != 0L) && (l < ((TroopInfo)localObject).dwGagTimeStamp_me + 3L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, self Gag", new Object[] { paramString }));
      }
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      String str = localContext.getString(2131364704);
      l = ((TroopInfo)localObject).dwGagTimeStamp_me + 3L;
      if (paramBoolean) {
        l = ((TroopInfo)localObject).dwGagTimeStamp_me - 30L;
      }
      return new TroopGagMgr.SelfGagInfo(this, paramString, true, String.format(str, new Object[] { b(localContext, l) }), 60L);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("getTroopGagInfo:sUin=%s, not Gag", new Object[] { paramString }));
    }
    return new TroopGagMgr.SelfGagInfo(this, paramString, false, "", 0L);
  }
  
  public TroopGagMgr.TroopGagInfo a(String paramString)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject == null) {
      return new TroopGagMgr.TroopGagInfo(this, paramString, 0L);
    }
    localObject = ((TroopManager)localObject).b(paramString);
    if (localObject == null) {
      return new TroopGagMgr.TroopGagInfo(this, paramString, 0L);
    }
    return new TroopGagMgr.TroopGagInfo(this, paramString, ((TroopInfo)localObject).dwGagTimeStamp);
  }
  
  public String a(Context paramContext, long paramLong)
  {
    return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(2131364705), new Object[] { b(paramContext, paramLong) });
  }
  
  public String a(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    paramContext = ((Context)localObject).getString(2131364706);
    String str = ((Context)localObject).getString(2131364707);
    localObject = ((Context)localObject).getString(2131364708);
    if (paramLong1 < 60L) {
      return String.format("约%d%s", new Object[] { Integer.valueOf(1), paramContext });
    }
    if (paramLong1 <= 3540L) {
      return String.format("约%d%s", new Object[] { Long.valueOf((57L + paramLong1) / 60L), paramContext });
    }
    if (paramLong1 <= 84600L) {
      return String.format("约%d%s", new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 3600.0F)), str });
    }
    return String.format("约%d%s", new Object[] { Long.valueOf(Math.round((float)paramLong1 * 1.0F / 86400.0F)), localObject });
  }
  
  public String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localTroopManager == null) {
      return "";
    }
    paramString = localTroopManager.a(paramString);
    if (paramString == null) {
      return "";
    }
    if (paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
      return "1";
    }
    return "2";
  }
  
  public ArrayList a()
  {
    Object localObject = Base64Util.encodeToString("[{\"seconds\":600,\"text\":\"10分钟\"},{\"seconds\":3600,\"text\":\"1小时\"},{\"seconds\":43200,\"text\":\"12小时\"},{\"seconds\":86400,\"text\":\"1天\"}]".getBytes(), 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GagMemberConfig");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      return a(new String(Base64Util.decode(((String)localObject).getBytes(), 0)));
    }
  }
  
  public ArrayList a(String paramString)
  {
    int k = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("parseGagConfig = %s", new Object[] { paramString }));
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      while (k < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(k);
        localArrayList.add(new TroopGagMgr.GagItem(this, localJSONObject.optString("text"), localJSONObject.optInt("seconds")));
        k += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, "parseGagConfig failed");
      }
    }
  }
  
  public ArrayList a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject == null) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return (ArrayList)localObject;
      localArrayList = ((TroopManager)localObject).a(paramString);
      localObject = localArrayList;
    } while (!paramBoolean);
    b(paramString, null);
    return localArrayList;
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (paramInt1 == ((Integer)((Iterator)localObject1).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt1));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    localObject1 = String.valueOf(paramLong1);
    if (TextUtils.isEmpty(paramString)) {
      if (paramLong3 == 0L) {
        paramString = ((Context)localObject2).getResources().getString(2131364936);
      }
    }
    for (;;)
    {
      localObject2 = (MessageForGrayTips)MessageRecordFactory.a(63506);
      ((MessageForGrayTips)localObject2).frienduin = ((String)localObject1);
      ((MessageForGrayTips)localObject2).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject1, (String)localObject1, paramString, paramLong2, 63506, 1, paramInt1);
      ((MessageForGrayTips)localObject2).isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return;
      paramString = ((Context)localObject2).getResources().getString(2131364937);
      continue;
      if (paramLong3 == 0L) {
        paramString = ((Context)localObject2).getResources().getString(2131364935, new Object[] { paramString });
      } else {
        paramString = ((Context)localObject2).getResources().getString(2131364934, new Object[] { paramString, c((Context)localObject2, paramLong3) });
      }
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList)
  {
    int m = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((Integer)((Iterator)localObject).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopGagMgr", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    String str1 = String.valueOf(paramLong1);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    localObject = localTroopManager.a(String.valueOf(paramLong1));
    if (localObject == null)
    {
      localObject = new TroopInfo();
      ((TroopInfo)localObject).troopuin = String.valueOf(paramLong1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) {
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(((TroopInfo)localObject).troopuin, false);
      }
      String str3 = String.valueOf(paramLong2);
      boolean bool = str3.equalsIgnoreCase(((TroopInfo)localObject).troopowneruin);
      paramArrayList = paramArrayList.iterator();
      int k = 0;
      if (paramArrayList.hasNext())
      {
        PushParam localPushParam = (PushParam)paramArrayList.next();
        String str4 = localPushParam.jdField_a_of_type_JavaLangString;
        if ((localPushParam.jdField_a_of_type_Long == 0L) || (localPushParam.jdField_a_of_type_Long == 4294967295L))
        {
          paramLong2 = localPushParam.jdField_a_of_type_Long;
          label284:
          if (str4.equals(str2))
          {
            ((TroopInfo)localObject).dwGagTimeStamp_me = paramLong2;
            localTroopManager.b((TroopInfo)localObject);
            a(str1, true);
            a(str1, str3, paramLong3, localPushParam.jdField_a_of_type_Long, paramInt, false, bool);
            m = 1;
          }
          if (!str4.equals("0")) {
            break label413;
          }
          ((TroopInfo)localObject).dwGagTimeStamp = paramLong2;
          localTroopManager.b((TroopInfo)localObject);
          b(str1);
          a(str1, true);
          a(str1, str3, paramLong3, localPushParam.jdField_a_of_type_Long, paramInt, true, bool);
          m = 1;
        }
        for (;;)
        {
          break;
          paramLong2 = paramLong3 + localPushParam.jdField_a_of_type_Long;
          break label284;
          label413:
          if (!str4.equals(str2)) {
            a(str1, paramLong3, localPushParam.jdField_a_of_type_Long, paramInt, str3, str4, bool);
          }
          k = 1;
          localTroopManager.a(paramLong1 + "", str4, null, -100, null, null, -100, -100, -100, -100L, paramLong2);
        }
      }
      if (k != 0) {
        c(str1);
      }
      if (m == 0) {
        break;
      }
      paramArrayList = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      try
      {
        paramArrayList.h(str1);
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getString(paramInt), paramBoolean);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!a(paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!b(paramToServiceMsg, paramFromServiceMsg, paramObject))) {}
    for (int k = 0;; k = 1)
    {
      if ((k == 0) && (QLog.isDevelopLevel())) {
        QLog.i("TroopGagMgr", 4, "bad subcmd" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    paramString = localTroopManager.c(paramString);
    TroopInfo localTroopInfo = localTroopManager.a(paramString);
    if (localTroopInfo != null)
    {
      localTroopInfo.dwGagTimeStamp = 0L;
      localTroopInfo.dwGagTimeStamp_me = 0L;
      localTroopManager.b(localTroopInfo);
      localTroopManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, -100, null, null, -100, -100, -100, -100L, 0L);
    }
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).h(paramString);
  }
  
  public final void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroop : sUin = %s", new Object[] { paramString }));
    }
    Object localObject1 = new oidb_0x89a.ReqBody();
    ((oidb_0x89a.ReqBody)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    Object localObject2 = new oidb_0x89a.groupinfo();
    ((oidb_0x89a.groupinfo)localObject2).uint32_shutup_time.set((int)paramLong);
    ((oidb_0x89a.ReqBody)localObject1).st_group_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2202);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89a.ReqBody)localObject1).toByteArray()));
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("troopUin", paramString);
    ((Bundle)localObject1).putLong("timpStamp", paramLong);
    ((Bundle)localObject1).putInt("key_subcmd", 2);
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a("OidbSvc.0x89a_0", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray(), (Bundle)localObject1);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = a(paramString1);
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    int k;
    Object localObject1;
    label87:
    Object localObject3;
    String str1;
    String str2;
    int m;
    Object localObject2;
    if ((paramBoolean) && (bool))
    {
      k = 2131364718;
      localObject1 = localContext.getString(k);
      if (paramLong2 == 0L) {
        break label530;
      }
      k = 2131364721;
      localObject3 = localContext.getString(k);
      str1 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      str2 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString3);
      m = 0;
      k = 0;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (((String)localObject2).equalsIgnoreCase(paramString2))
      {
        localObject1 = "被你";
        str1 = "";
        k = 1;
      }
      if (!((String)localObject2).equalsIgnoreCase(paramString3)) {
        break label607;
      }
      localObject2 = "你" + (String)localObject1;
      str2 = "";
      m = 1;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (m == 0) {
        localObject1 = " " + (String)localObject2;
      }
      if ((!bool) || (k != 0)) {
        str1 = "";
      }
      for (localObject2 = localObject3;; localObject2 = " " + (String)localObject3)
      {
        localObject3 = str2 + (String)localObject1 + str1 + (String)localObject2;
        localObject2 = localObject3;
        if (paramLong2 != 0L) {
          localObject2 = (String)localObject3 + c(localContext, paramLong2);
        }
        localObject3 = (MessageForGrayTips)MessageRecordFactory.a(63506);
        ((MessageForGrayTips)localObject3).frienduin = paramString1;
        ((MessageForGrayTips)localObject3).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, (String)localObject2, paramLong1, 63506, 1, paramInt);
        if (!StringUtil.b(str2))
        {
          paramString1 = new Bundle();
          paramString1.putInt("key_action", 5);
          paramString1.putString("troop_mem_uin", paramString3);
          paramString1.putBoolean("need_update_nick", true);
          ((MessageForGrayTips)localObject3).addHightlightItem(0, str2.length(), paramString1);
        }
        paramString1 = str2 + (String)localObject1;
        if (!StringUtil.b(str1))
        {
          paramString3 = new Bundle();
          paramString3.putInt("key_action", 5);
          paramString3.putString("troop_mem_uin", paramString2);
          paramString3.putBoolean("need_update_nick", true);
          ((MessageForGrayTips)localObject3).addHightlightItem(paramString1.length(), paramString1.length() + str1.length(), paramString3);
        }
        ((MessageForGrayTips)localObject3).isread = true;
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false)) {
          break label587;
        }
        return;
        k = 2131364719;
        break;
        label530:
        k = 2131364722;
        break label87;
        localObject1 = (String)localObject1 + " ";
      }
      label587:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return;
      label607:
      localObject2 = localObject1;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagMgr", 2, "----------addTroopGagTipsMr friendUin: " + paramString1);
    }
    boolean bool = a(paramString1);
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject1;
    Object localObject2;
    label126:
    Object localObject3;
    if (!paramBoolean1)
    {
      localObject1 = ((Context)localObject4).getString(2131364720);
      if ((paramBoolean2) && (bool))
      {
        localObject2 = (String)localObject1 + ((Context)localObject4).getString(2131364718);
        if (!paramBoolean1) {
          break label412;
        }
        if (paramLong2 == 0L) {
          break label399;
        }
        localObject1 = ((Context)localObject4).getString(2131364725);
        localObject3 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equalsIgnoreCase(paramString2)) {
          break label560;
        }
        localObject2 = "你";
      }
    }
    label399:
    label412:
    label540:
    label560:
    for (int k = 1;; k = 0)
    {
      if ((!bool) || (k != 0))
      {
        localObject4 = "";
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
      for (;;)
      {
        localObject4 = (String)localObject3 + (String)localObject2 + (String)localObject1;
        localObject1 = (MessageForGrayTips)MessageRecordFactory.a(63506);
        ((MessageForGrayTips)localObject1).frienduin = paramString1;
        ((MessageForGrayTips)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, (String)localObject4, paramLong1, 63506, 1, paramInt);
        if (!StringUtil.b((String)localObject2))
        {
          paramString1 = new Bundle();
          paramString1.putInt("key_action", 5);
          paramString1.putString("troop_mem_uin", paramString2);
          paramString1.putBoolean("need_update_nick", true);
          ((MessageForGrayTips)localObject1).addHightlightItem(((String)localObject3).length(), ((String)localObject3).length() + ((String)localObject2).length(), paramString1);
        }
        ((MessageForGrayTips)localObject1).isread = true;
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject1, false)) {
          break label540;
        }
        return;
        localObject2 = (String)localObject1 + ((Context)localObject4).getString(2131364719);
        break;
        if ((paramBoolean2) && (bool))
        {
          localObject2 = ((Context)localObject4).getString(2131364724);
          break;
        }
        localObject2 = ((Context)localObject4).getString(2131364723);
        break;
        localObject1 = ((Context)localObject4).getString(2131364726);
        break label126;
        if (paramLong2 != 0L) {}
        for (k = 2131364721;; k = 2131364722)
        {
          localObject3 = ((Context)localObject4).getString(k);
          localObject1 = localObject3;
          if (paramLong2 == 0L) {
            break;
          }
          localObject1 = (String)localObject3 + c((Context)localObject4, paramLong2);
          break;
        }
        localObject4 = (String)localObject2 + " ";
        localObject1 = " " + (String)localObject1;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return;
    }
  }
  
  public final void a(String paramString, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s, empty arList error", new Object[] { paramString }));
      }
      return;
    }
    int k = 0;
    String str = "";
    while (k < paramArrayList.size())
    {
      localObject = (TroopGagMgr.GagMemberParam)paramArrayList.get(k);
      str = str + ((TroopGagMgr.GagMemberParam)localObject).jdField_a_of_type_JavaLangString + ((TroopGagMgr.GagMemberParam)localObject).jdField_a_of_type_Long + "|";
      k += 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("doGagTroopMember:sUin=%s sMemberUins=%s", new Object[] { paramString, str }));
    }
    Object localObject = ByteBuffer.allocate(paramArrayList.size() * 8 + 7);
    ((ByteBuffer)localObject).putInt((int)Long.valueOf(paramString).longValue());
    ((ByteBuffer)localObject).put((byte)32);
    ((ByteBuffer)localObject).putShort((short)paramArrayList.size());
    k = 0;
    str = null;
    long l = 0L;
    while (k < paramArrayList.size())
    {
      TroopGagMgr.GagMemberParam localGagMemberParam = (TroopGagMgr.GagMemberParam)paramArrayList.get(k);
      ((ByteBuffer)localObject).putInt((int)Long.valueOf(localGagMemberParam.jdField_a_of_type_JavaLangString).longValue());
      ((ByteBuffer)localObject).putInt((int)localGagMemberParam.jdField_a_of_type_Long);
      str = localGagMemberParam.jdField_a_of_type_JavaLangString;
      l = localGagMemberParam.jdField_a_of_type_Long;
      k += 1;
    }
    localObject = ((ByteBuffer)localObject).array();
    paramArrayList = new oidb_sso.OIDBSSOPkg();
    paramArrayList.uint32_command.set(1392);
    paramArrayList.uint32_result.set(0);
    paramArrayList.uint32_service_type.set(8);
    paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
    localObject = new Bundle();
    ((Bundle)localObject).putString("troopUin", paramString);
    ((Bundle)localObject).putString("memberUin", str);
    ((Bundle)localObject).putLong("timpStamp", l);
    ((Bundle)localObject).putInt("key_subcmd", 2);
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a("OidbSvc.0x570_8", paramArrayList.toByteArray(), (Bundle)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).e(new TroopGagMgr.GagStatus(paramString, a(paramString, paramBoolean)));
  }
  
  public final boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = 2131364714;
    if (!"OidbSvc.0x89a_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(str, false, l);
      if (l == 0L) {}
      for (k = 2131364714;; k = 2131364710)
      {
        a(k, false);
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, failed", new Object[] { str }));
        }
        return true;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(str, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(str, false, l);
      if (l == 0L) {}
      for (;;)
      {
        a(k, false);
        return true;
        k = 2131364710;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (l == 0L) {}
        for (;;)
        {
          a(k, false);
          a(str, false, l);
          return true;
          k = 2131364710;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspGagTroop : sUin = %s, succeeded", new Object[] { str }));
      }
      a(str, true, l);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((TroopManager)localObject).a(paramString);
    } while (localObject == null);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (paramString.equals(((TroopInfo)localObject).troopowneruin))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator))
      {
        localObject = ((TroopInfo)localObject).Administrator.split("\\|");
        if (localObject != null)
        {
          int m = localObject.length;
          int k = 0;
          for (;;)
          {
            if (k >= m) {
              break label124;
            }
            if (localObject[k].equalsIgnoreCase(paramString))
            {
              bool = true;
              break;
            }
            k += 1;
          }
        }
      }
      label124:
      bool = false;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroop: sUin=%s", new Object[] { paramString }));
    }
    a(paramString, paramLong);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localTroopManager == null) {
      return false;
    }
    paramString1 = localTroopManager.a(paramString1, paramString2);
    NetConnInfoCenter.getServerTime();
    if ((paramString1.jdField_a_of_type_Long != 0L) && (paramString1.jdField_a_of_type_Long > NetConnInfoCenter.getServerTime())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    int k = 2131364716;
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("0")))
    {
      if (paramLong == 0L) {}
      for (;;)
      {
        a(k, false);
        return false;
        k = 2131364712;
      }
    }
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.equals("0")))
    {
      if (paramLong == 0L) {}
      for (;;)
      {
        a(k, false);
        return false;
        k = 2131364712;
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TroopGagMgr.GagMemberParam(paramString2, paramLong));
    a(paramString1, localArrayList);
    return true;
  }
  
  public boolean a(String paramString, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("gagTroopMember:sUin=%s ", new Object[] { paramString }));
    }
    a(paramString, paramArrayList);
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    int k = paramArrayOfByte[4];
    long l2;
    long l3;
    if (k == 12)
    {
      k = paramArrayOfByte[5];
      l2 = PkgTools.a(paramArrayOfByte, 6);
      PkgTools.a(paramArrayOfByte, 10);
      l3 = NetConnInfoCenter.getServerTime();
      int n = PkgTools.a(paramArrayOfByte, 14);
      int m = 16;
      ArrayList localArrayList = new ArrayList();
      k = 0;
      while (k < n)
      {
        long l4 = PkgTools.a(paramArrayOfByte, m);
        m += 4;
        long l5 = PkgTools.a(paramArrayOfByte, m);
        m += 4;
        localArrayList.add(new PushParam(String.valueOf(l4), l5));
        k += 1;
      }
      a(paramInt, l1, l2, l3, localArrayList);
      return true;
    }
    if (k == 14)
    {
      k = paramArrayOfByte[5];
      PkgTools.a(paramArrayOfByte, 6);
      l2 = NetConnInfoCenter.getServerTime();
      l3 = PkgTools.a(paramArrayOfByte, 10);
      k = paramArrayOfByte[14];
      a(paramInt, l1, l2, l3, PkgTools.a(paramArrayOfByte, 15, k), paramArrayOfByte[(k + 15)]);
    }
    return false;
  }
  
  public String b(Context paramContext, long paramLong)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (paramLong <= l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("error: gagTimeToStringCountDown gagTime <= currentTimeMs", new Object[0]));
      }
      return "";
    }
    return a(paramContext, paramLong - l, paramLong);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    int k = localContext.getResources().getDimensionPixelSize(2131492908);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new vqs(this, paramBoolean, localContext, paramString, k));
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(localContext, 2, paramString, 0).b(k);
      return;
    }
    QQToast.a(localContext, 2130838454, paramString, 0).b(k);
  }
  
  public final boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"OidbSvc.0x570_8".equals(paramFromServiceMsg.getServiceCmd())) {
      return false;
    }
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    long l = paramToServiceMsg.extraData.getLong("timpStamp");
    paramToServiceMsg = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopGagMgr", 4, String.format("onRspTroopMember:sUin %s sMemberUin=%s, failed", new Object[] { str1, str2 }));
      }
      if (paramFromServiceMsg.getResultCode() == 10)
      {
        if (l == 0L) {}
        for (k = 2131364716;; k = 2131364727)
        {
          a(k, false);
          b(str1, false, l);
          return true;
        }
      }
      if (l == 0L) {}
      for (k = 2131364716;; k = 2131364712)
      {
        a(k, false);
        break;
      }
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        b(str1, false, l);
        return true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      b(str1, false, l);
      if (l == 0L) {}
      for (k = 2131364716;; k = 2131364712)
      {
        a(k, false);
        return true;
      }
      if (paramToServiceMsg.uint32_result.get() != 0)
      {
        if (paramToServiceMsg.uint32_result.get() == 10)
        {
          if (l == 0L) {}
          for (k = 2131364716;; k = 2131364727)
          {
            a(k, false);
            b(str1, false, l);
            return true;
          }
        }
        if (l == 0L) {}
        for (k = 2131364716;; k = 2131364712)
        {
          a(k, false);
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopGagMgr", 4, String.format("onRspTroopMember:sUin=%s sMemberUin=%s, succeeded", new Object[] { str1, str2 }));
      }
      b(str1, true, l);
      if (l != 0L) {}
    }
    for (int k = 2131364715;; k = 2131364711)
    {
      a(k, true);
      return true;
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagMgr", 4, String.format("fetchGagTroopList:sUin=%s", new Object[] { paramString1 }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          localTroopHandler.b(Long.parseLong(paramString1), 0L, 6, null, 0, 0);
        }
        else
        {
          long l1 = Long.parseLong(paramString1);
          long l2 = Long.parseLong(paramString2);
          paramString1 = new ArrayList();
          paramString1.add(Long.valueOf(l2));
          localTroopHandler.b(l1, 0L, 3, paramString1, 0, 0);
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopGagMgr", 2, paramString1.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label196;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    label196:
    return true;
  }
  
  public String c(Context paramContext, long paramLong)
  {
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    String str1 = paramContext.getString(2131364706);
    String str2 = paramContext.getString(2131364707);
    Object localObject = paramContext.getString(2131364708);
    if (paramLong < 60L) {
      paramContext = 1 + str1;
    }
    long l2;
    do
    {
      return paramContext;
      l2 = 59L + paramLong;
      paramLong = l2 / 86400L;
      long l1 = (l2 - 86400L * paramLong) / 3600L;
      l2 = (l2 - 86400L * paramLong - 3600L * l1) / 60L;
      paramContext = "";
      if (paramLong > 0L) {
        paramContext = "" + paramLong + (String)localObject;
      }
      localObject = paramContext;
      if (l1 > 0L) {
        localObject = paramContext + l1 + str2;
      }
      paramContext = (Context)localObject;
    } while (l2 <= 0L);
    return (String)localObject + l2 + str1;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() != 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      while (this.jdField_a_of_type_JavaUtilQueue.size() != 0)
      {
        localStringBuffer.append(((Integer)this.jdField_a_of_type_JavaUtilQueue.poll()).intValue());
        if (this.jdField_a_of_type_JavaUtilQueue.size() != 0) {
          localStringBuffer.append(";");
        }
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("seqs", localStringBuffer.toString()).commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopGagMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */