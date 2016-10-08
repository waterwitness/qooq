package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatInfo.ExitedHotChatInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pyq;
import pyr;
import pys;
import pyt;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;

public class HotChatManager
  implements Manager
{
  public static final int a = 1;
  public static final long a = 10000L;
  static Boolean jdField_a_of_type_JavaLangBoolean;
  public static final String a = "qq_update_5.9";
  public static final boolean a = false;
  public static final int b = 2;
  public static final long b = 10000L;
  static Boolean jdField_b_of_type_JavaLangBoolean;
  public static final String b = "HotChatManager";
  public static final int c = 3;
  public static final String c = "KEY_SPLASHPIC_CHARM_REQUIREMENT";
  public static final int d = 4;
  public static final String d = "PREF_KEY_EXITED_HOTCHATINFO";
  public static final int e = 3;
  public static final String e = "http://play.mobile.qq.com/play/mqqplay/hotchat/index.html?_wv=1027&_bid=2152";
  public static final int f = 200;
  private static final String f = "hotchat_auth_flag";
  public static final int g = 20;
  private static final String g = "hotchat_topic_ptt_flag";
  private static final int i = 5;
  private static final int j = 604800000;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  public HotChatManager.OnVListUpdateListener a;
  public QQAppInterface a;
  PttShowRoomMng jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng;
  private final Object jdField_a_of_type_JavaLangObject;
  public List a;
  public final Map a;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  boolean jdField_b_of_type_Boolean;
  public long c;
  Boolean c;
  public volatile boolean c;
  public long d;
  public long e;
  public long f;
  int h;
  private int k;
  
  public HotChatManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = false;
    this.h = 0;
    this.jdField_c_of_type_JavaLangBoolean = null;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    this.d = 20000L;
    this.f = 20000L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    d();
    ThreadManager.a().post(new pyq(this));
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      if (paramInt1 == 2) {
        return 2130839445;
      }
      break;
    case 1: 
      return 2130839458;
    }
    if (paramInt1 == 3) {
      return 2130839457;
    }
    return 2130839455;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface).getInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", 3);
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int n = 2130839460;
    HotChatManager localHotChatManager = paramQQAppInterface.a(false);
    paramQQAppInterface = null;
    if (localHotChatManager != null) {
      paramQQAppInterface = localHotChatManager.a(paramString);
    }
    int m = n;
    if (paramQQAppInterface != null)
    {
      m = n;
      if (!paramQQAppInterface.isWifiHotChat) {
        m = a(paramQQAppInterface.hotThemeGroupFlag, 2130839460);
      }
    }
    return m;
  }
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    return BaseApplicationImpl.a.getSharedPreferences("Config_Before_load_RU" + paramQQAppInterface.a(), 0);
  }
  
  public static String a(WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      paramWifiInfo = "";
    }
    String str;
    do
    {
      do
      {
        return paramWifiInfo;
        str = paramWifiInfo.getSSID();
        if (str == null) {
          break;
        }
        paramWifiInfo = str;
      } while (!str.startsWith("\""));
      paramWifiInfo = str;
    } while (!str.endsWith("\""));
    return str.substring(1, str.length() - 1);
    return "";
  }
  
  public static Map a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = a(paramQQAppInterface).getString("PREF_KEY_EXITED_HOTCHATINFO", "");
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label76;
        }
        paramQQAppInterface = (Map)new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramQQAppInterface.getBytes(), 0))).readObject();
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("HotChatManager", 2, "", paramQQAppInterface);
      return null;
      label76:
      paramQQAppInterface = null;
    }
  }
  
  public static im_msg_body.Elem a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (!a(paramAppInterface, false)) {
      return null;
    }
    paramAppInterface = new im_msg_body.NearByMessageType();
    paramAppInterface.uint32_identify_type.set(1);
    paramMessageRecord = new im_msg_body.Elem();
    paramMessageRecord.near_by_msg.set(paramAppInterface);
    return paramMessageRecord;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null) {
      return;
    }
    paramContext = new Intent((Context)localObject, NearbyActivity.class);
    paramContext.putExtra("ENTER_TIME", System.currentTimeMillis());
    paramContext.putExtra("TAB", 2);
    paramContext.setFlags(67108864);
    if (paramBoolean) {
      paramContext.putExtra("abp_flag", paramBoolean);
    }
    ((Context)localObject).startActivity(paramContext);
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "update authFlag:" + paramBoolean + " old:" + jdField_b_of_type_JavaLangBoolean);
    }
    if ((jdField_b_of_type_JavaLangBoolean != null) && (jdField_b_of_type_JavaLangBoolean.booleanValue() == paramBoolean)) {
      return;
    }
    paramAppInterface.getPreferences().edit().putBoolean("hotchat_auth_flag", paramBoolean).commit();
    jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      return;
    }
    ((HotChatHandler)paramQQAppInterface.a(35)).a(HotChatInfo.createWifiPOIInfo(paramHotChatInfo), paramHotChatInfo.isWifiHotChat, 1, 0);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004B60", "0X8004B60", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int m = 0;
    try
    {
      int n = Integer.parseInt(paramString);
      m = n;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramQQAppInterface = a(paramQQAppInterface).edit();
    paramQQAppInterface.putInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", m);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Map paramMap)
  {
    if ((paramQQAppInterface == null) || (paramMap == null)) {}
    do
    {
      return;
      try
      {
        paramQQAppInterface = a(paramQQAppInterface);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramMap);
        paramMap = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
        paramQQAppInterface = paramQQAppInterface.edit();
        paramQQAppInterface.putString("PREF_KEY_EXITED_HOTCHATINFO", paramMap);
        paramQQAppInterface.commit();
        return;
      }
      catch (Exception paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("HotChatManager", 2, "", paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "saveSupportHotChatFlag", Boolean.valueOf(paramBoolean), jdField_a_of_type_JavaLangBoolean });
    }
    Object localObject = paramQQAppInterface.getPreferences().edit();
    ((SharedPreferences.Editor)localObject).putBoolean("DOES_SUPPORT_HOT_CHAT", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (((jdField_a_of_type_JavaLangBoolean == null) || (!jdField_a_of_type_JavaLangBoolean.booleanValue())) && (paramBoolean))
    {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      localObject = (HotChatManager)paramQQAppInterface.getManager(59);
      ((HotChatManager)localObject).jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotChatManager", new Object[] { "saveSupportHotChatFlag", "needGetMessage", Boolean.valueOf(((HotChatManager)localObject).jdField_b_of_type_Boolean) });
      }
      ((HotChatHandler)paramQQAppInterface.a(35)).a();
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (jdField_b_of_type_JavaLangBoolean == null) {
      jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(paramAppInterface.getPreferences().getBoolean("hotchat_auth_flag", paramBoolean));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "get authFlag:" + jdField_b_of_type_JavaLangBoolean);
    }
    return jdField_b_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "doesSupportHotChat:" + jdField_a_of_type_JavaLangBoolean);
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("identify_flag")));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("NOT_SHOW_WIFI_SHELL", false);
  }
  
  private void c(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {
      return;
    }
    HashMap localHashMap = (HashMap)a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      if (localHashMap.containsKey(paramHotChatInfo.troopUin)) {
        ((HotChatInfo.ExitedHotChatInfo)localHashMap.get(paramHotChatInfo.troopUin)).leftTime = paramHotChatInfo.leftTime;
      }
      for (;;)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHashMap);
        return;
        HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo = new HotChatInfo.ExitedHotChatInfo();
        localExitedHotChatInfo.leftTime = paramHotChatInfo.leftTime;
        localExitedHotChatInfo.troopUin = paramHotChatInfo.troopUin;
        localHashMap.put(localExitedHotChatInfo.troopUin, localExitedHotChatInfo);
      }
    }
  }
  
  private void d()
  {
    boolean bool = a().getBoolean("HAS_USING_HOTCHAT", false);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "hasJoinedHotChat = " + bool);
    }
    if ((bool) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(HotChatInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
          if ((localHotChatInfo.state != 5) && (!localHotChatInfo.isWifiHotChat)) {
            this.jdField_a_of_type_JavaUtilMap.put(localHotChatInfo.troopUin, localHotChatInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.d("HotChatManager", 2, "initCache  HotChatInfo = " + localHotChatInfo);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "initCache  size = " + this.jdField_a_of_type_JavaUtilMap.size());
      }
    }
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private void e()
  {
    try
    {
      Object localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Object localObject2 = new File(BaseApplicationImpl.a().getFilesDir() + "/hotchatclassify");
      if (!((File)localObject2).exists()) {
        return;
      }
      localObject1 = ((DocumentBuilder)localObject1).parse((File)localObject2).getElementsByTagName("data");
      localObject2 = new SparseArray();
      int m = 0;
      while (m < ((NodeList)localObject1).getLength())
      {
        Object localObject3 = (Element)((NodeList)localObject1).item(m);
        String str = ((Element)localObject3).getElementsByTagName("key").item(0).getFirstChild().getNodeValue();
        localObject3 = ((Element)localObject3).getElementsByTagName("value").item(0).getFirstChild().getNodeValue();
        if (QLog.isColorLevel()) {
          QLog.i("HotChatManager", 2, "buildClassifyInfos, key = " + str + ",value=" + (String)localObject3);
        }
        ((SparseArray)localObject2).put(Integer.valueOf(str).intValue(), localObject3);
        m += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray = ((SparseArray)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("HotChatManager", 1, "buildClassifyInfos exception happen:" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  public SharedPreferences a()
  {
    return BaseApplicationImpl.a.getSharedPreferences("Config_Before_load_RU" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
  }
  
  public HotChatInfo a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.userCreate == 0) && (localHotChatInfo.state == 0)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public HotChatInfo a(String paramString)
  {
    return (HotChatInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public PttShowRoomMng a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng == null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng = new PttShowRoomMng(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng;
  }
  
  public String a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "getHotChatClassify, type = " + paramInt);
    }
    return (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (HotChatInfo)localIterator.next();
        if ((localObject != null) && (((HotChatInfo)localObject).troopCode != null) && (((HotChatInfo)localObject).troopCode.equals(paramString)))
        {
          localObject = ((HotChatInfo)localObject).troopUin;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
            return (String)localObject;
          }
        }
      }
    }
    return null;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  public void a()
  {
    if (this.h <= 0) {
      ThreadManager.a(new pyr(this), 10, null, false);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "setMyUinCharmLevel, charmLevel = " + paramInt);
    }
    this.h = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(String.valueOf(paramLong)) != null)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotChatManager", new Object[] { "checkHotChatInfo", Long.valueOf(paramLong) });
      }
      return;
    }
    Object localObject = new HotChatInfo();
    ((HotChatInfo)localObject).troopUin = String.valueOf(paramLong);
    ((HotChatInfo)localObject).name = ((HotChatInfo)localObject).troopUin;
    ((HotChatInfo)localObject).hotThemeGroupFlag = 1;
    ((HotChatInfo)localObject).userCreate = 0;
    ((HotChatInfo)localObject).supportFlashPic = true;
    ((HotChatInfo)localObject).isWifiHotChat = false;
    ((HotChatInfo)localObject).adminLevel = 2;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "checkHotChatInfo", "need AddHotChatInfoRunnable", Long.valueOf(paramLong) });
    }
    localObject = new pyt(this, (HotChatInfo)localObject);
    ThreadManager.b().post((Runnable)localObject);
  }
  
  public void a(HotChatManager.OnVListUpdateListener paramOnVListUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener = paramOnVListUpdateListener;
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    long l;
    if (paramHotChatInfo.isPttShowRoom())
    {
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(0, paramHotChatInfo.troopUin);
      if (l >= paramHotChatInfo.lLastMsgSeq) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramHotChatInfo.troopUin, 1);
      ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(paramHotChatInfo, paramHotChatInfo.lLastMsgSeq, (int)Math.min(paramHotChatInfo.lLastMsgSeq - l, 20L), 0, 1, 1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotChatManager", new Object[] { "pullPttRoomMsg", paramHotChatInfo.troopUin, Long.valueOf(l), Long.valueOf(paramHotChatInfo.lLastMsgSeq) });
      }
      return;
      label135:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramHotChatInfo.troopUin, 2);
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onJoinedHotChat hc = " + paramHotChatInfo + ", preState:" + paramInt);
    }
    if (paramHotChatInfo.adminLevel == 0)
    {
      localObject = a();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
          if ((localHotChatInfo.adminLevel == 0) && (!paramHotChatInfo.troopUin.equals(localHotChatInfo.troopUin))) {
            a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
          }
        }
      }
    }
    else if (paramHotChatInfo.adminLevel == 1)
    {
      ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105)).b(paramHotChatInfo.ownerUin);
    }
    paramHotChatInfo.state = 0;
    paramHotChatInfo.ruState = 0;
    this.jdField_a_of_type_JavaUtilMap.put(paramHotChatInfo.troopUin, paramHotChatInfo);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ((EntityManager)localObject).b(paramHotChatInfo);
    ((EntityManager)localObject).a();
    NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramHotChatInfo.troopUin);
    b(paramHotChatInfo, paramInt);
    HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramHotChatInfo = a().edit();
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      paramHotChatInfo.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatInfo.commit();
      return;
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "onExitHotChat hc = " + paramHotChatInfo + ", ts = " + paramHotChatStateWrapper);
    }
    if ((paramHotChatInfo == null) || (paramHotChatStateWrapper == null)) {
      return;
    }
    ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105)).b(paramHotChatInfo.ownerUin);
    int m = paramHotChatStateWrapper.targetState;
    paramHotChatInfo.onExit(m);
    paramHotChatStateWrapper = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (m == 4)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramHotChatInfo.troopUin);
      paramHotChatStateWrapper.b(paramHotChatInfo);
      paramHotChatStateWrapper.a();
      if ((m != 1) && (m != 6) && (m != 7)) {
        break label220;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("HotChatManager", 2, "onExitHotChat no need to clear message");
      }
      label152:
      paramHotChatStateWrapper = a().edit();
      if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        break label248;
      }
    }
    label220:
    label248:
    for (boolean bool = true;; bool = false)
    {
      paramHotChatStateWrapper.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatStateWrapper.commit();
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d(paramHotChatInfo.troopUin);
      return;
      paramHotChatStateWrapper.a(paramHotChatInfo);
      break;
      c(paramHotChatInfo.troopUin);
      c(paramHotChatInfo);
      HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHotChatInfo.troopUin, m);
      break label152;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString.ruState = 1;
    localEntityManager.a(paramString);
    localEntityManager.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "handleGetHotchatVList, json:" + paramString2);
    }
    FileUtils.a(BaseApplicationImpl.getContext().getFilesDir() + File.separator + paramString1 + "_nearby_hotchat_v_list", paramString2);
    ArrayList localArrayList;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localArrayList = new ArrayList();
      paramString1 = null;
      try
      {
        paramString2 = new JSONObject(paramString2).getJSONArray("vusers");
        paramString1 = paramString2;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          int m;
          paramString2.printStackTrace();
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener.a();
      }
      if (paramString1 != null)
      {
        m = 0;
        while (m < paramString1.length())
        {
          paramString2 = paramString1.optString(m);
          if (!TextUtils.isEmpty(paramString2)) {
            localArrayList.add(paramString2);
          }
          m += 1;
        }
      }
    }
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    paramPbGetGroupMsgResp = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onPullRecentGroupMsg troopUin = " + paramString + ", doSome:" + paramInt + ", hotChat = " + paramPbGetGroupMsgResp);
    }
    if (paramPbGetGroupMsgResp != null)
    {
      if (paramInt != 1) {
        break label90;
      }
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbGetGroupMsgResp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371499), true);
    }
    for (;;)
    {
      return;
      label90:
      if (paramInt == 4)
      {
        if (paramPbGetGroupMsgResp.isWifiHotChat)
        {
          HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbGetGroupMsgResp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371475, new Object[] { paramPbGetGroupMsgResp.name }), true);
          return;
        }
        if (1 == paramPbGetGroupMsgResp.adminLevel) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371474, new Object[] { paramPbGetGroupMsgResp.name });
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPbGetGroupMsgResp.troopUin, 1, 10);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (((localMessageRecord instanceof MessageForNewGrayTips)) && (localMessageRecord.msg.equals(paramString))) {
              NearbyUtils.a("HotChatManager", new Object[] { "onPullRecentGroupMsg", "grayTips exist in last 10 msgs" });
            }
          }
        }
        for (paramInt = 0; paramInt != 0; paramInt = 1)
        {
          HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbGetGroupMsgResp, paramString, true);
          return;
        }
      }
    }
  }
  
  final void a(List paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetJoinedHotChatList,hotchat list = null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "onGetJoinedHotChatList", Integer.valueOf(paramList.size()), Boolean.valueOf(this.jdField_b_of_type_Boolean) });
    }
    HashSet localHashSet = new HashSet();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HotChatInfo)((Iterator)localObject2).next();
        if (!((HotChatInfo)localObject3).isWifiHotChat) {
          if (((HotChatInfo)localObject3).userCreate == 0)
          {
            ((ArrayList)localObject1).add(localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newPOIHotChat = " + localObject3);
            }
          }
          else
          {
            ((ArrayList)localObject1).add(localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newUserCreateHotChat = " + localObject3);
            }
          }
        }
      }
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramList);
    }
    Object localObject2 = a();
    boolean bool2 = ((SharedPreferences)localObject2).getBoolean("qq_update_5.9", true);
    Object localObject3 = a();
    Iterator localIterator1 = ((ArrayList)localObject1).iterator();
    label265:
    Object localObject4;
    if (localIterator1.hasNext())
    {
      localObject4 = (HotChatInfo)localIterator1.next();
      Iterator localIterator2 = ((ArrayList)localObject3).iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramList = (HotChatInfo)localIterator2.next();
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "onGetJoinedHotChatList old.trooUin=:" + paramList.troopUin + ",hc.troopUin=:" + ((HotChatInfo)localObject4).troopUin);
        }
      } while (!paramList.troopUin.equals(((HotChatInfo)localObject4).troopUin));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetJoinedHotChatList exist=:" + bool1);
      }
      if (bool1)
      {
        paramList.updateHotChatInfo((HotChatInfo)localObject4);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        ((EntityManager)localObject4).a(paramList);
        ((EntityManager)localObject4).a();
        if (!bool2) {
          break label265;
        }
        b(paramList.troopUin);
        break label265;
      }
      a((HotChatInfo)localObject4, 4);
      localHashSet.add(((HotChatInfo)localObject4).troopUin);
      break label265;
      paramList = ((ArrayList)localObject3).iterator();
      label492:
      label763:
      label817:
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject3 = (HotChatInfo)paramList.next();
          localIterator1 = ((ArrayList)localObject1).iterator();
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
          } while (!((HotChatInfo)localIterator1.next()).troopUin.equals(((HotChatInfo)localObject3).troopUin));
        }
        for (int m = 1;; m = 0)
        {
          if (m != 0) {
            break label817;
          }
          a((HotChatInfo)localObject3, HotChatManager.HotChatStateWrapper.wrap(4));
          c((HotChatInfo)localObject3);
          break label492;
          HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramList = ((SharedPreferences)localObject2).edit();
          if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {}
          for (bool1 = true;; bool1 = false)
          {
            paramList.putBoolean("HAS_USING_HOTCHAT", bool1);
            if (bool2) {
              paramList.putBoolean("qq_update_5.9", false);
            }
            paramList.commit();
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
            this.jdField_b_of_type_Boolean = false;
            localObject1 = b();
            if (!QLog.isColorLevel()) {
              break label763;
            }
            localObject2 = ((List)localObject1).iterator();
            for (paramList = ""; ((Iterator)localObject2).hasNext(); paramList = paramList + " " + ((HotChatInfo)localObject3).troopUin) {
              localObject3 = (HotChatInfo)((Iterator)localObject2).next();
            }
          }
          QLog.d("HotChatManager", 2, "troopUin:" + paramList);
          paramList = ((List)localObject1).iterator();
          while (paramList.hasNext())
          {
            localObject1 = (HotChatInfo)paramList.next();
            if ((localObject1 != null) && (!localHashSet.contains(((HotChatInfo)localObject1).troopUin))) {
              b((HotChatInfo)localObject1, 0);
            }
          }
          break;
        }
      }
      paramList = null;
    }
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_introduce_dialog", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_introduce_dialog", false).commit();
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (HotChatInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (paramString.state == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString, HotChatManager.OnVListUpdateListener paramOnVListUpdateListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatManager", 2, "isUinInVList, mVlist is null,initing:" + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener != paramOnVListUpdateListener) {
        this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener = paramOnVListUpdateListener;
      }
      if (!this.jdField_c_of_type_Boolean) {}
    }
    for (;;)
    {
      return false;
      this.jdField_c_of_type_Boolean = true;
      ThreadManager.a(new pys(this), null, false);
      return false;
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((String)this.jdField_a_of_type_JavaUtilList.get(m)).equals(paramString)) {
          return true;
        }
        m += 1;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2;
    boolean bool1;
    if (this.jdField_c_of_type_JavaLangBoolean == null)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      Boolean localBoolean = Boolean.valueOf(localSharedPreferences.getBoolean("hotchat_topic_ptt_flag", true));
      this.jdField_c_of_type_JavaLangBoolean = localBoolean;
      bool2 = localBoolean.booleanValue();
      bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (this.jdField_c_of_type_JavaLangBoolean.booleanValue())
        {
          this.jdField_c_of_type_JavaLangBoolean = Boolean.valueOf(false);
          localSharedPreferences.edit().putBoolean("hotchat_topic_ptt_flag", false).commit();
          bool1 = bool2;
        }
      }
    }
    do
    {
      do
      {
        return bool1;
        bool2 = this.jdField_c_of_type_JavaLangBoolean.booleanValue();
        bool1 = bool2;
      } while (!paramBoolean);
      bool1 = bool2;
    } while (!this.jdField_c_of_type_JavaLangBoolean.booleanValue());
    this.jdField_c_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("hotchat_topic_ptt_flag", false).commit();
    return bool2;
  }
  
  public HotChatInfo b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if (localHotChatInfo.uuid.equals(paramString)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public List b()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
      if ((localHotChatInfo != null) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    for (;;)
    {
      Iterator localIterator;
      HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo;
      try
      {
        Map localMap1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localMap1 == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
          continue;
        }
        long l = System.currentTimeMillis();
        localIterator = localMap1.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label154;
        }
        localExitedHotChatInfo = (HotChatInfo.ExitedHotChatInfo)((Map.Entry)localIterator.next()).getValue();
        if (localExitedHotChatInfo == null) {
          continue;
        }
        HotChatInfo localHotChatInfo = a(localExitedHotChatInfo.troopUin);
        if ((localHotChatInfo != null) && (localHotChatInfo.state == 0))
        {
          localIterator.remove();
          continue;
        }
        if (Math.abs(l - localExitedHotChatInfo.leftTime) < 604800000L) {
          continue;
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localExitedHotChatInfo.troopUin, 1);
      localIterator.remove();
      continue;
      label154:
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMap2);
    }
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.k = paramInt;
      return;
    }
  }
  
  public void b(HotChatInfo paramHotChatInfo)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.a(paramHotChatInfo);
    localEntityManager.a();
  }
  
  public void b(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "pullRecentGroupMsg", Integer.valueOf(paramInt), paramHotChatInfo.troopUin, paramHotChatInfo.name });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramHotChatInfo.troopUin, paramInt);
    if (paramHotChatInfo.isPttShowRoom()) {
      a(paramHotChatInfo);
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1, true, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("HotChatManager", 2, "clear hotChat msgCache done");
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_wifi_shell_setting", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_wifi_shell_setting", false).commit();
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public HotChatInfo c(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (TextUtils.equals(localHotChatInfo.troopCode, paramString))) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.k += 1;
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    do
    {
      String str;
      do
      {
        SQLiteDatabase localSQLiteDatabase;
        do
        {
          return;
          localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        } while (localSQLiteDatabase == null);
        str = MessageRecord.getTableName(paramString, 1);
        m = localSQLiteDatabase.a(str);
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "clearLimitCountHotChatMsgCache, totalcount=" + m);
        }
      } while ((m <= 250) || (str == null));
      int n = Math.max(m - 200, 50);
      ((TroopMessageManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1)).a(paramString, 1, true, false, str, n);
    } while (!QLog.isColorLevel());
    QLog.d("HotChatManager", 2, "clearLimitCountHotChatMsgCache, count=" + m);
  }
  
  public boolean c()
  {
    int m = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "isAllowedToSendSplashpic, myUinCharmLevel = " + this.h + ", splashpicCharmRequirement = " + m);
    }
    return this.h >= m;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.supportDemo) {
          bool1 = ((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf(false))).booleanValue();
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("HotChatManager", 4, "isSupportDemo,  bRet = " + bool1);
    }
    return bool1;
  }
  
  public void d(String paramString)
  {
    FileUtils.a(BaseApplicationImpl.a().getFilesDir() + "/hotchatclassify", paramString);
    e();
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "updateClassifyInfo, xmldata = " + paramString);
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaLangBoolean = null;
    jdField_b_of_type_JavaLangBoolean = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotChatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */