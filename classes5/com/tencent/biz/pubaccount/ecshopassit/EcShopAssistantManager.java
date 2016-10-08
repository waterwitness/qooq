package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import htz;
import hua;
import hub;
import huc;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class EcShopAssistantManager
  implements Manager
{
  public static final String A = "recommed_shop_uin";
  public static final String B = "nearby_cleared";
  public static final String C = "folder_can_del";
  public static String D;
  public static String E;
  public static final String F;
  public static final String G = "ad_id";
  public static final String H = "ad_start";
  public static final String I = "ad_end";
  public static final String J = "ad_puin";
  public static final String K = "ad_icon_url";
  public static final String L = "ad_title";
  public static final String M = "ad_pics";
  public static final String N = "is_ad_added";
  public static final String O = "ad_nick";
  public static final String P = "ad_cert";
  public static final String Q = "ad_url";
  public static final String R = "ecshop_dns";
  public static String S;
  public static final int a = 8388608;
  public static final String a = "EcShopAssistantManager";
  public static HashMap a;
  public static boolean a = false;
  public static EcShopAssistantManager.BannerConfig[] a;
  public static String[] a;
  public static volatile int b = 0;
  public static final String b = "init_ec_shop_assist";
  public static HashMap b;
  public static List b;
  public static int c = 0;
  public static final String c = "ec_shop_assist_deleted";
  public static HashMap c;
  public static List c;
  public static final String d = "is_update_ec_shop_assist";
  public static List d;
  public static final String e = "ec_shop_assist_show_in_msg";
  public static final String f = "ec_shop_assist_new_unread_list";
  public static final String g = "ec_shop_assist_first_show_in_list";
  public static final String h = "last_read_time";
  public static final String i = "last_modified_time";
  public static final String j = "http://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json";
  public static final String k = "http://imgcache.qq.com/zzapp/qqshop/banner/image/";
  public static final String l;
  public static final String m;
  public static String n;
  public static String o;
  public static final String p = "ecshop_sp";
  public static final String q = "str_ecshop_diy";
  public static final String r = "disc_reddot";
  public static final String s = "welfare_reddot";
  public static final String t = "nearby_reddot";
  public static final String u = "mine_reddot";
  public static final String v = "folder_reddot";
  public static final String w = "reddot_start";
  public static final String x = "reddot_end";
  public static final String y = "max_reddot_time";
  public static final String z = "last_show_time1";
  private String T;
  private long jdField_a_of_type_Long;
  public Handler a;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new huc(this);
  final Object jdField_a_of_type_JavaLangObject = new Object();
  public List a;
  private Map jdField_a_of_type_JavaUtilMap;
  public Set a;
  public final Object b;
  public boolean b;
  private boolean c;
  private boolean d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    l = BaseApplication.getContext().getFilesDir() + File.separator + "shop_assit_banner_json.txt";
    m = AppConstants.bj + ".shop_assit/image/";
    n = "";
    o = "";
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_Int = 600000;
    D = "last_modified_report_json";
    E = "http://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_wl_conf.json";
    F = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://gouwu.qq.com/m/cgi-bin/shop/collection?_wv=1027", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://gouwu.qq.com/m/cgi-bin/shop/my?_wv=1027" };
  }
  
  public EcShopAssistantManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.T = paramQQAppInterface.a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManager.a(new htz(this), 5, null, true);
  }
  
  public static Drawable a(Context paramContext)
  {
    if (!TextUtils.isEmpty(o))
    {
      Object localObject1 = paramContext.getResources().getDrawable(2130838381);
      Object localObject2 = o.split("/");
      localObject2 = m + localObject2[(localObject2.length - 1)];
      String str = o;
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_icon", str, (String)localObject2), (Drawable)localObject1, (Drawable)localObject1);
        return (Drawable)localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return paramContext.getResources().getDrawable(2130841642);
      }
    }
    return paramContext.getResources().getDrawable(2130841642);
  }
  
  public static String a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if ((jdField_d_of_type_JavaUtilList == null) || (!jdField_d_of_type_JavaUtilList.contains(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!paramString2.contains("qq.com")) || (paramString2.contains("&g_tk="))) {
      return paramString2;
    }
    paramQQAppInterface = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.a());
    StringBuilder localStringBuilder = new StringBuilder(paramString2);
    if (paramString2.contains("?")) {}
    for (paramString1 = "&g_tk=";; paramString1 = "?g_tk=")
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(String.valueOf(TroopUtils.b(paramQQAppInterface)));
      return localStringBuilder.toString();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h();
      return;
    }
    finally {}
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1008) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h();
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if ((localObject2 == null) || (localObject1 == null)) {
      return false;
    }
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.aK, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      EcShopData localEcShopData = a();
      if (localEcShopData != null)
      {
        ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
        ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("EcShopAssistantManager", 2, "update ecshop folder...");
        }
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      return true;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      break;
      localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.aK, 7120);
      if (localObject2 != null) {
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantManager", 2, "del ecshop folder...");
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    EcShopData localEcShopData;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.remove(localEcShopData);
        }
        if (localEcShopData != null)
        {
          bool = paramEntityManager.b(localEcShopData);
          if (QLog.isColorLevel()) {
            QLog.d("EcShopAssistantManager", 2, "removeEcShopData puin: " + paramString);
          }
          return bool;
          paramEntityManager = finally;
          throw paramEntityManager;
        }
      }
      boolean bool = false;
    }
  }
  
  private void b(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1008) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      h();
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("is_update_ec_shop_assist", paramBoolean).commit();
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("is_update_ec_shop_assist", true);
  }
  
  public static void c()
  {
    int i2 = 0;
    Object localObject2;
    Object localObject3;
    int i1;
    Object localObject4;
    if (jdField_a_of_type_ArrayOfComTencentBizPubaccountEcshopassitEcShopAssistantManager$BannerConfig == null)
    {
      Object localObject1 = new File(l);
      if (!((File)localObject1).exists()) {
        break label652;
      }
      localObject1 = FileUtils.a((File)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).has("shopEnterFlag")) {
            jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("shopEnterFlag");
          }
          localObject2 = ((JSONObject)localObject1).getJSONArray("shopTopBanner");
          localObject3 = new ArrayList();
          i1 = 0;
          if (i1 >= ((JSONArray)localObject2).length()) {
            break label298;
          }
          localObject4 = (JSONObject)((JSONArray)localObject2).get(i1);
          Object localObject5 = ((JSONObject)localObject4).getString("shieldver");
          if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (((String)localObject5).contains("6.5.5".substring(0, 3))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EcShopAssistantManager", 2, "QQ ver:6.5.5,shieldVer:" + (String)localObject5);
            }
          }
          else
          {
            localObject5 = new EcShopAssistantManager.BannerConfig();
            ((EcShopAssistantManager.BannerConfig)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).getString("pic");
            ((EcShopAssistantManager.BannerConfig)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).getString("url");
            ((EcShopAssistantManager.BannerConfig)localObject5).c = ((JSONObject)localObject4).getString("title");
            ((EcShopAssistantManager.BannerConfig)localObject5).jdField_a_of_type_Int = ((JSONObject)localObject4).getInt("seq");
            ((EcShopAssistantManager.BannerConfig)localObject5).jdField_a_of_type_Long = ((JSONObject)localObject4).getLong("startTs");
            ((EcShopAssistantManager.BannerConfig)localObject5).jdField_b_of_type_Long = ((JSONObject)localObject4).getLong("endTs");
            ((EcShopAssistantManager.BannerConfig)localObject5).d = ((JSONObject)localObject4).getString("adtag");
            ((List)localObject3).add(localObject5);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EcShopAssistantManager", 2, "parse banner config fail", localException);
          }
        }
      }
    }
    label297:
    return;
    label298:
    if (((List)localObject3).size() > 0)
    {
      Collections.sort((List)localObject3, new hub());
      jdField_a_of_type_ArrayOfComTencentBizPubaccountEcshopassitEcShopAssistantManager$BannerConfig = (EcShopAssistantManager.BannerConfig[])((List)localObject3).toArray(new EcShopAssistantManager.BannerConfig[0]);
    }
    if (localException.has("shopFolderName")) {
      n = localException.getString("shopFolderName");
    }
    if (localException.has("shopFolderIcon")) {
      o = localException.getString("shopFolderIcon");
    }
    if (localException.has("shopDiscovery"))
    {
      localObject2 = localException.getJSONArray("shopDiscovery");
      if (((JSONArray)localObject2).length() <= 0) {
        break label696;
      }
      jdField_b_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      if (i1 < ((JSONArray)localObject2).length())
      {
        localObject3 = (JSONObject)((JSONArray)localObject2).get(i1);
        localObject4 = new EcShopAssistantManager.DiscoveryConfig();
        ((EcShopAssistantManager.DiscoveryConfig)localObject4).jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("id");
        ((EcShopAssistantManager.DiscoveryConfig)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("pic");
        ((EcShopAssistantManager.DiscoveryConfig)localObject4).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("title");
        ((EcShopAssistantManager.DiscoveryConfig)localObject4).c = ((JSONObject)localObject3).getString("url");
        jdField_b_of_type_JavaUtilList.add(localObject4);
        i1 += 1;
      }
      else
      {
        if (!localException.has("shopButton")) {
          break label297;
        }
        JSONArray localJSONArray = localException.getJSONArray("shopButton");
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.i("EcShopAssistantManager", 2, "shopButton info found:" + localJSONArray.toString());
          i1 = i2;
        }
        while (i1 < localJSONArray.length())
        {
          localObject2 = (JSONObject)localJSONArray.get(i1);
          localObject3 = new EcShopAssistantManager.TopBtnInfo();
          ((EcShopAssistantManager.TopBtnInfo)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("title");
          ((EcShopAssistantManager.TopBtnInfo)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("pic");
          ((EcShopAssistantManager.TopBtnInfo)localObject3).c = ((JSONObject)localObject2).getString("url");
          i2 = ((JSONObject)localObject2).getInt("id");
          jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(i2), localObject3);
          i1 += 1;
        }
        break label297;
        label652:
        if (!QLog.isColorLevel()) {
          break label297;
        }
        QLog.d("EcShopAssistantManager", 2, "banner json config file is not existed path=" + l);
        return;
        i1 += 1;
        break;
        label696:
        i1 = 0;
      }
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 261	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 669	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   12: invokevirtual 675	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_2
    //   16: aload_2
    //   17: ldc_w 425
    //   20: iconst_0
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc_w 677
    //   28: aconst_null
    //   29: invokevirtual 680	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   32: astore_1
    //   33: invokestatic 442	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +39 -> 75
    //   39: new 149	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 682
    //   49: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: astore_3
    //   53: aload_1
    //   54: ifnonnull +175 -> 229
    //   57: iconst_0
    //   58: istore 5
    //   60: ldc 60
    //   62: iconst_2
    //   63: aload_3
    //   64: iload 5
    //   66: invokevirtual 685	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 447	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: getfield 245	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   79: astore_3
    //   80: aload_3
    //   81: monitorenter
    //   82: aload_0
    //   83: aload_1
    //   84: putfield 471	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   87: aload_0
    //   88: getfield 471	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   91: ifnonnull +16 -> 107
    //   94: aload_0
    //   95: new 199	java/util/ArrayList
    //   98: dup
    //   99: bipush 16
    //   101: invokespecial 688	java/util/ArrayList:<init>	(I)V
    //   104: putfield 471	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   107: aload_3
    //   108: monitorexit
    //   109: aload_0
    //   110: getfield 269	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   113: astore_1
    //   114: aload_1
    //   115: monitorenter
    //   116: aload_0
    //   117: getfield 269	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   120: invokeinterface 689 1 0
    //   125: aload_0
    //   126: getfield 471	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   129: invokeinterface 693 1 0
    //   134: astore_3
    //   135: aload_3
    //   136: invokeinterface 698 1 0
    //   141: ifeq +119 -> 260
    //   144: aload_3
    //   145: invokeinterface 702 1 0
    //   150: checkcast 425	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   153: astore 4
    //   155: aload_0
    //   156: getfield 269	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   159: aload 4
    //   161: getfield 705	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   164: aload 4
    //   166: invokeinterface 706 3 0
    //   171: pop
    //   172: goto -37 -> 135
    //   175: astore_3
    //   176: aload_1
    //   177: monitorexit
    //   178: aload_3
    //   179: athrow
    //   180: astore_3
    //   181: aload_2
    //   182: astore_1
    //   183: invokestatic 442	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +34 -> 220
    //   189: aload_2
    //   190: astore_1
    //   191: ldc 60
    //   193: iconst_2
    //   194: new 149	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 708
    //   204: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: invokevirtual 711	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   211: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 713	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 715	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   228: return
    //   229: aload_1
    //   230: invokeinterface 610 1 0
    //   235: istore 5
    //   237: goto -177 -> 60
    //   240: astore_1
    //   241: aload_3
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: aload_2
    //   247: astore_3
    //   248: aload_1
    //   249: astore_2
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 715	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   258: aload_2
    //   259: athrow
    //   260: aload_1
    //   261: monitorexit
    //   262: aload_2
    //   263: ifnull -35 -> 228
    //   266: aload_2
    //   267: invokevirtual 715	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   270: return
    //   271: astore_2
    //   272: aload_1
    //   273: astore_3
    //   274: goto -24 -> 250
    //   277: astore_3
    //   278: aload 4
    //   280: astore_2
    //   281: goto -100 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	EcShopAssistantManager
    //   240	4	1	localObject2	Object
    //   245	28	1	localObject3	Object
    //   15	252	2	localObject4	Object
    //   271	1	2	localObject5	Object
    //   280	1	2	localEcShopData1	EcShopData
    //   175	4	3	localObject7	Object
    //   180	62	3	localException1	Exception
    //   247	27	3	localObject8	Object
    //   277	1	3	localException2	Exception
    //   3	276	4	localEcShopData2	EcShopData
    //   58	178	5	i1	int
    // Exception table:
    //   from	to	target	type
    //   116	135	175	finally
    //   135	172	175	finally
    //   176	178	175	finally
    //   260	262	175	finally
    //   16	53	180	java/lang/Exception
    //   60	75	180	java/lang/Exception
    //   75	82	180	java/lang/Exception
    //   109	116	180	java/lang/Exception
    //   178	180	180	java/lang/Exception
    //   229	237	180	java/lang/Exception
    //   243	245	180	java/lang/Exception
    //   82	107	240	finally
    //   107	109	240	finally
    //   241	243	240	finally
    //   16	53	245	finally
    //   60	75	245	finally
    //   75	82	245	finally
    //   109	116	245	finally
    //   178	180	245	finally
    //   229	237	245	finally
    //   243	245	245	finally
    //   5	16	271	finally
    //   183	189	271	finally
    //   191	220	271	finally
    //   5	16	277	java/lang/Exception
  }
  
  private void h()
  {
    ThreadManager.b(new hua(this));
  }
  
  private void i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i1 = 1;
        if (i1 != 0) {
          g();
        }
        return;
      }
      int i1 = 0;
    }
  }
  
  public int a()
  {
    int i1;
    int i2;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i1 = 0;
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label118;
      }
      localObject1 = (EcShopData)localIterator.next();
      i2 = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject1).mUin);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject2 == null) {
        break label124;
      }
    }
    label118:
    label124:
    for (Object localObject1 = ((QQMessageFacade)localObject2).a(((EcShopData)localObject1).mUin, i2);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localObject2 != null) {
          i1 += ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        }
      }
      for (;;)
      {
        break;
        i2 = 0;
        return i2;
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int i1;
    int i2;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          i2 = paramQQAppInterface.a().a(str, 1008);
          if (i2 <= 0) {
            break label97;
          }
        }
        else
        {
          return i1;
        }
      }
      else
      {
        return 0;
      }
    }
    for (;;)
    {
      i1 += i2;
      break;
      label97:
      i2 = 0;
    }
  }
  
  public EcShopData a()
  {
    Object localObject3 = null;
    i();
    Object localObject4 = this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject3;
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(0);
        }
      }
      return (EcShopData)localObject1;
    }
    finally {}
  }
  
  public EcShopData a(String paramString)
  {
    i();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      ??? = localEcShopData;
      if (localEcShopData == null)
      {
        localEcShopData = new EcShopData();
        localEcShopData.mUin = paramString;
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ??? = localEcShopData;
        if (localQQMessageFacade != null)
        {
          paramString = localQQMessageFacade.a(paramString, 1008);
          ??? = localEcShopData;
          if (paramString != null)
          {
            localEcShopData.mLastDraftTime = paramString.getTime();
            ??? = localEcShopData;
          }
        }
      }
      return (EcShopData)???;
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "";
    Object localObject = str;
    if (paramQQAppInterface != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramString))
      {
        PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        localObject = str;
        if (localPublicAccountDataManager != null)
        {
          localObject = localPublicAccountDataManager.b(paramString);
          if (localObject == null) {
            break label85;
          }
        }
      }
    }
    label85:
    for (localObject = ((PublicAccountInfo)localObject).name;; localObject = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramQQAppInterface = PublicAccountUtil.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface != null)
        {
          localObject = paramQQAppInterface.name;
          return (String)localObject;
        }
      }
      return (String)localObject;
    }
  }
  
  public List a()
  {
    int i2 = 0;
    i();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          i1 = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(i1);
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("getAllEcShopAssitData size: ");
            if (localArrayList == null)
            {
              i1 = i2;
              QLog.d("EcShopAssistantManager", 2, i1);
            }
          }
          else
          {
            return localArrayList;
          }
        }
        else
        {
          i1 = 0;
        }
      }
      int i1 = ((List)localObject2).size();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EcShopData localEcShopData;
    do
    {
      return;
      localEcShopData = a();
    } while (localEcShopData == null);
    a(localEcShopData.mLastMsgTime);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putLong("last_read_time", paramLong).commit();
    this.jdField_a_of_type_Long = paramLong;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      h();
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      } while (localObject2 == null);
      this.jdField_b_of_type_Boolean = paramBoolean;
      Object localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.aK, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    } while (localObject1 == null);
    ((MqqHandler)localObject1).sendEmptyMessage(1009);
  }
  
  public void a(EcShopData paramEcShopData)
  {
    if ((paramEcShopData == null) || (TextUtils.isEmpty(paramEcShopData.mUin))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramEcShopData.mUin, paramEcShopData);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramEcShopData);
        i1 = 0;
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label288;
        }
        EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (Math.max(paramEcShopData.mLastMsgTime, paramEcShopData.mLastDraftTime) > Math.max(localEcShopData.mLastMsgTime, localEcShopData.mLastDraftTime))
        {
          this.jdField_a_of_type_JavaUtilList.add(i1, paramEcShopData);
          i1 = 1;
          if (i1 == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramEcShopData);
          }
          ??? = (ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
          if (paramEcShopData.getStatus() != 1000) {
            break label266;
          }
          ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EcShopAssistantManager", 2, "saveEcShopData(db&cache) puin: " + paramEcShopData.mUin + ", status: " + paramEcShopData.getStatus());
          return;
          paramEcShopData = finally;
          throw paramEcShopData;
        }
        i1 += 1;
      }
      label266:
      ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
      continue;
      label288:
      int i1 = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject2;
    Object localObject3;
    if (paramQQAppInterface != null)
    {
      this.T = paramQQAppInterface.getAccount();
      localObject2 = paramQQAppInterface.a().getSharedPreferences(this.T, 0);
      this.jdField_c_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_show_in_msg", true);
      this.jdField_d_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_deleted", false);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("last_read_time", 0L);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList = null;
        localObject3 = a();
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet = SharedPreferencesHandler.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
      if (this.jdField_a_of_type_JavaUtilSet == null)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        if (b())
        {
          b(false);
          localObject2 = paramQQAppInterface.a();
          if (localObject2 == null)
          {
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
            QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localEcShopData.mUin, 1008);
            if ((paramQQAppInterface.a().a(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
              a(localMessage.frienduin, paramQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "addMsgToAssist puin: " + paramMessageRecord.senderuin);
    }
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    EcShopData localEcShopData = a(str);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {}
    for (localEcShopData.mLastMsgTime = paramMessageRecord.time;; localEcShopData.mLastMsgTime = l1)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localEcShopData.mUin, 1008);
      if (localMessage != null)
      {
        long l2 = localMessage.time;
        if (l2 > localEcShopData.mLastMsgTime) {
          localEcShopData.mLastMsgTime = l2;
        }
      }
      a(localEcShopData);
      a(paramMessageRecord, str);
      if (this.jdField_d_of_type_Boolean) {
        a(false);
      }
      a(paramQQAppInterface, str);
      a(l1);
      return;
    }
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      b(paramString);
    }
    localEntityManager.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "refreshSettings.... paUin: " + paramString1 + ", src: " + paramString2);
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ??? = paramString2.a(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).type == 1008) && (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList()))
        {
          ((ArrayList)localObject2).add(localObject4);
          if (QLog.isColorLevel()) {
            QLog.d("EcShopAssistantManager", 2, "add to ecshop folder puin: " + ((RecentUser)localObject4).uin + ", size: " + ((ArrayList)localObject2).size());
          }
        }
      }
    }
    i();
    Object localObject5;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (EcShopData)((Iterator)localObject4).next();
          if ((!ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(S)))
          {
            ((ArrayList)localObject1).add(localObject5);
            if (QLog.isColorLevel()) {
              QLog.d("EcShopAssistantManager", 2, "remove form ecshop folder puin: " + ((EcShopData)localObject5).mUin);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "toRecentUser size: " + ((ArrayList)localObject1).size());
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((EcShopData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((EcShopData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((EcShopData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a((EcShopData)localObject4);
          paramString2.b((RecentUser)???);
          a(((RecentUser)???).uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EcShopData)((Iterator)localObject1).next();
        ??? = paramString2.a(((EcShopData)localObject2).mUin, 1008);
        ((RecentUser)???).uin = ((EcShopData)localObject2).mUin;
        ((RecentUser)???).type = 1008;
        ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
        ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
        if (a(paramString1, ((EcShopData)localObject2).mUin))
        {
          localObject4 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if ((localObject4 != null) && (((PublicAccountDataManager)localObject4).c(((EcShopData)localObject2).mUin) != null))
          {
            paramString2.a((RecentUser)???);
            if (QLog.isColorLevel()) {
              QLog.d("EcShopAssistantManager", 2, "add to msgtab puin: " + ((EcShopData)localObject2).mUin);
            }
          }
        }
      }
    }
    paramString2 = a();
    if (paramString2 != null) {
      a(paramString2.mLastMsgTime);
    }
    if (paramString1 != null) {
      paramString1.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("ec_shop_assist_deleted", paramBoolean).commit();
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("init_ec_shop_assist", true);
  }
  
  public boolean a(String paramString)
  {
    return ((jdField_c_of_type_JavaUtilList != null) && (jdField_c_of_type_JavaUtilList.contains(paramString))) || (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject;
    do
    {
      return;
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localObject = str;
      if (str == null) {
        localObject = "noLogin";
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject, 4);
    } while (((SharedPreferences)localObject).getBoolean("ec_shop_assist_first_show_in_list", false));
    this.jdField_b_of_type_Boolean = true;
    ((SharedPreferences)localObject).edit().putBoolean("ec_shop_assist_first_show_in_list", true).commit();
    a(NetConnInfoCenter.getServerTime());
  }
  
  public void d()
  {
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
    if (localDownloaderInterface != null)
    {
      Object localObject2 = EmosmUtils.a("VIP_shop_assit_cfg", "http://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localDownloaderInterface.a((String)localObject2) == null)
      {
        Object localObject1 = new File(l);
        localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l1 = ((File)localObject1).lastModified();
          ((DownloadTask)localObject2).i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l1).longValue() != ((DownloadTask)localObject2).i) {
            ((DownloadTask)localObject2).k = true;
          }
        }
        ((DownloadTask)localObject2).h = true;
        ((DownloadTask)localObject2).n = false;
        localObject1 = new Bundle();
        localDownloaderInterface.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject1);
      }
    }
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        i();
        RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        Object localObject = localRecentUserProxy.a(false);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((1008 == localRecentUser.type) && (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)))
        {
          EcShopData localEcShopData = a(localRecentUser.uin);
          localEcShopData.mLastDraftTime = localRecentUser.lastmsgdrafttime;
          localEcShopData.mLastMsgTime = localRecentUser.lastmsgtime;
          if (localEcShopData.mLastMsgTime == 0L)
          {
            QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localEcShopData.mUin, 1008);
            if (localMessage != null)
            {
              l1 = localMessage.time;
              localEcShopData.mLastMsgTime = l1;
            }
          }
          else
          {
            a(localEcShopData);
            localRecentUserProxy.b(localRecentUser);
            a(localEcShopData.mUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            continue;
          }
          long l1 = localEcShopData.mLastMsgTime;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EcShopAssistantManager", 2, "initEcShopAssist fail msg:" + localException.getMessage());
        }
        return;
      }
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (localPublicAccountHandler != null) {
      localPublicAccountHandler.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("init_ec_shop_assist", false).commit();
  }
  
  public void f()
  {
    if (a()) {
      e();
    }
    a();
  }
  
  public void onDestroy()
  {
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_ArrayOfComTencentBizPubaccountEcshopassitEcShopAssistantManager$BannerConfig = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopAssistantManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */