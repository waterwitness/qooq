package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ABTestControlMsgRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.MpGetNotifycationRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.MpIsAdminUinRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import ifa;
import ifb;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PublicAccountConfigUtil
{
  public static String A;
  public static String B;
  public static String C;
  public static String D;
  public static String E;
  public static final String F = "PubAccountSvc.mp_is_admin_uin";
  public static final String G = "PubAccountSvc.mp_get_notifycation";
  public static final int a = 1;
  public static final long a = 86400000L;
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  public static final String a = "PublicAccountConfigUtil";
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static boolean a = false;
  public static final int b = 2131364532;
  public static final long b = 60000L;
  public static final String b = "version";
  public static boolean b = false;
  public static final int c = 2130838603;
  public static long c = 0L;
  public static final String c = "public-account-folder";
  public static boolean c = false;
  public static final int d = 2;
  public static final String d = "id";
  public static boolean d = false;
  public static final int e = 2131362961;
  public static final String e = "name";
  public static boolean e = false;
  public static final int f = 2130838608;
  public static final String f = "icon";
  public static boolean f = false;
  public static final int g = 3;
  public static final String g = "show";
  public static boolean g = false;
  public static final int h = 2131362962;
  public static final String h = "msg";
  public static final int i = 2130838608;
  public static final String i = "recommendBottomVersion";
  public static int j = 10;
  public static final String j = "recommendFullVersion";
  public static int k = 30;
  public static final String k = "recommendBottom";
  public static final String l = "recommendFullScreen";
  public static final String m = "recommendURL";
  public static final String n = "id";
  public static final String o = "name";
  public static final String p = "icon";
  public static final String q = "kandian_read_data";
  public static final String r = "channel_version";
  public static final String s = "channel_id";
  public static final String t = "channel_name";
  public static final String u = "channel_type";
  public static final String v = "video_sound";
  public static final String w = "multi_video_support_enable";
  public static final String x = "rn_switch";
  public static final String y = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
  public static final String z = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    A = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    B = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    jdField_c_of_type_Long = 86400000L;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("service_account_folder_config_version", 0);
    }
    return i1;
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getResources().getDrawable(2130838582);
    case 1: 
      return paramContext.getResources().getDrawable(2130838603);
    }
    return paramContext.getResources().getDrawable(2130838608);
  }
  
  public static PublicAccountConfigUtil.PublicAccountConfigFolder a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 3) {
      i1 = 2;
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(paramQQAppInterface, paramContext);
    }
    if (jdField_a_of_type_AndroidUtilSparseArray == null) {
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    return (PublicAccountConfigUtil.PublicAccountConfigFolder)jdField_a_of_type_AndroidUtilSparseArray.get(i1);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localSharedPreferences != null) {
      paramQQAppInterface = localSharedPreferences.getString("public_account_center_url_config_data", null);
    }
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 1);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    PublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = a(paramQQAppInterface, paramContext, paramInt);
    if (localPublicAccountConfigFolder != null) {
      return localPublicAccountConfigFolder.a();
    }
    return b(paramQQAppInterface, paramContext, paramInt);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "resetPublicAccountConfig");
    }
    A = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    B = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    jdField_a_of_type_Boolean = false;
    b = false;
    jdField_c_of_type_Long = 86400000L;
    jdField_c_of_type_Boolean = false;
    d = false;
    j = 10;
    k = 30;
    e = false;
    f = false;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
    if (localSharedPreferences != null)
    {
      D = localSharedPreferences.getString("service_account_folder_name", null);
      E = localSharedPreferences.getString("service_account_folder_icon", null);
      jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("service_account_folder_delete", false);
      b = localSharedPreferences.getBoolean("service_account_folder_redspots", false);
      g = localSharedPreferences.getBoolean("public_account_mp_config", false);
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("service_account_folder_config_version", paramInt);
      paramQQAppInterface.commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "PubAccountSvc.mp_get_notifycation");
    mobileqq_mp.MpGetNotifycationRequest localMpGetNotifycationRequest = new mobileqq_mp.MpGetNotifycationRequest();
    localMpGetNotifycationRequest.versionInfo.set("6.5.5,3,2880");
    localMpGetNotifycationRequest.cuin.set(paramLong);
    localMpGetNotifycationRequest.puin.set(PublicAccountHandler.d);
    localMpGetNotifycationRequest.fans_msg_id.set(PublicAccountHandler.jdField_c_of_type_Long);
    localMpGetNotifycationRequest.publish_msg_id.set(PublicAccountHandler.b);
    localNewIntent.putExtra("data", localMpGetNotifycationRequest.toByteArray());
    PublicAccountServlet.a(localNewIntent);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (jdField_a_of_type_AndroidUtilSparseArray == null) {
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    if (!c(paramQQAppInterface, paramContext, SharedPreUtils.e(paramContext)))
    {
      localObject = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 1, 2131364532, 2130838603);
      jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject);
    }
    Object localObject = SharedPreUtils.h(paramContext);
    String str = SharedPreUtils.i(paramContext);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)))
    {
      paramQQAppInterface = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 2, 2131362961, 2130838608);
      jdField_a_of_type_AndroidUtilSparseArray.put(2, paramQQAppInterface);
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
      paramQQAppInterface = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 2, (String)localObject, str);
      jdField_a_of_type_AndroidUtilSparseArray.put(2, paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      A = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      B = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (a(str1))
        {
          A = str1;
          if (!a(str2)) {
            break label159;
          }
          B = str2;
          if (!paramString.has("readinjoy_search_url")) {
            break label167;
          }
          str1 = paramString.getString("readinjoy_search_url");
          if (a(str1)) {
            C = str1;
          }
          if (!paramString.has("image_collection_comment")) {
            break;
          }
          e = paramString.getBoolean("image_collection_comment");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "loadPublicAccountCenterUrlConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        A = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
        B = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
        e = false;
        return;
      }
      A = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      continue;
      label159:
      B = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      continue;
      label167:
      b(paramQQAppInterface, 0);
    }
    b(paramQQAppInterface, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    boolean bool = c(paramQQAppInterface, paramContext, paramString);
    if (bool) {
      SharedPreUtils.e(paramContext, paramString);
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.e("PublicAccountConfigUtil", 2, "updateEqqConfig fail");
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeRecommendConfig xml: " + paramString);
    }
    for (;;)
    {
      int i1;
      boolean bool;
      try
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        Object localObject1 = paramString.getElementsByTagName("recommendFullVersion");
        int i2;
        Object localObject2;
        int i3;
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = SubscriptRecommendController.b(paramQQAppInterface);
          if (i1 <= i2) {
            continue;
          }
          localObject1 = (Element)paramString.getElementsByTagName("recommendFullScreen").item(0);
          localObject2 = (Element)paramString.getElementsByTagName("recommendURL").item(0);
          i3 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = ((Element)localObject2).getFirstChild().getNodeValue();
          if (i3 != 1) {
            break label1301;
          }
          bool = true;
          SubscriptRecommendController.a(paramQQAppInterface, bool, (String)localObject1);
          SubscriptRecommendController.b(paramQQAppInterface, i1);
          if (i3 == 1)
          {
            localObject2 = (WebProcessManager)paramQQAppInterface.getManager(12);
            if (localObject2 != null) {
              ((WebProcessManager)localObject2).a(66);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("SubscriptRecommendConfig update fullrecommend config. version : ").append(i1).append(" switch : ");
            if (i3 != 1) {
              break label1307;
            }
            bool = true;
            QLog.d("PublicAccountConfigUtil", 2, bool + " url : " + (String)localObject1 + " oldVersion : " + i2);
          }
        }
        localObject1 = paramString.getElementsByTagName("recommendBottomVersion");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = SubscriptRecommendController.c(paramQQAppInterface);
          if (i1 <= i2) {
            break label1203;
          }
          i3 = Integer.valueOf(((Element)paramString.getElementsByTagName("recommendBottom").item(0)).getFirstChild().getNodeValue()).intValue();
          if (i3 != 1) {
            break label1197;
          }
          bool = true;
          SubscriptRecommendController.a(paramQQAppInterface, bool);
          SubscriptRecommendController.c(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update innerrecommend config. preversion -> version " + i2 + "->" + i1 + " switch : " + i3);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("kandian_read_data").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.a();
          if (i1 != 1) {
            break label1313;
          }
          bool = true;
          SharedPreUtils.a((Context)localObject1, bool);
        }
        localObject1 = paramString.getElementsByTagName("channel_version");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = ReadInJoyHelper.a(paramQQAppInterface);
          if (i1 <= i2) {
            break label1239;
          }
          localObject2 = (Element)paramString.getElementsByTagName("channel_id").item(0);
          Element localElement = (Element)paramString.getElementsByTagName("channel_name").item(0);
          localObject1 = (Element)paramString.getElementsByTagName("channel_type").item(0);
          i3 = Integer.valueOf(((Element)localObject2).getFirstChild().getNodeValue()).intValue();
          localObject2 = String.valueOf(localElement.getFirstChild().getNodeValue());
          int i4 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.a(paramQQAppInterface, i3, (String)localObject2, i4);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "update channelInfo config. preversion -> version " + i2 + "->" + i1 + " channelID : " + i3 + " channelName: " + (String)localObject2 + " channelType: " + i4);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("video_sound").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.a();
          if (i1 != 0) {
            break label1275;
          }
          bool = true;
          SharedPreUtils.b((Context)localObject1, bool);
          localObject1 = VideoVolumeControl.a();
          if (i1 != 0) {
            break label1281;
          }
          bool = true;
          ((VideoVolumeControl)localObject1).a(bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get video sound config " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_support_enable");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (i1 <= 0) {
            break label1287;
          }
          bool = true;
          ReadInJoyHelper.b(paramQQAppInterface, bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "updateSupportMultiVideoSwitch， supportEnable = " + i1);
          }
        }
        paramString = (Element)paramString.getElementsByTagName("rn_switch").item(0);
        if (paramString == null) {
          break label1299;
        }
        i1 = Integer.valueOf(paramString.getFirstChild().getNodeValue()).intValue();
        paramString = paramQQAppInterface.a();
        if (i1 == 1) {
          break label1293;
        }
        bool = true;
        SharedPreUtils.a(paramString, bool, paramQQAppInterface.f());
        if (!QLog.isColorLevel()) {
          break label1299;
        }
        QLog.d("PublicAccountConfigUtil", 2, "get interesrLableRn config " + i1);
        break label1299;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig same version ! " + i1);
        continue;
        bool = false;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "update subscript recommend config error." + paramQQAppInterface);
        }
        return false;
      }
      label1197:
      continue;
      label1203:
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update fail same version " + i1);
        continue;
        label1239:
        if (QLog.isColorLevel())
        {
          QLog.d("PublicAccountConfigUtil", 2, "update channelInfo fail same version " + i1);
          continue;
          label1275:
          bool = false;
          continue;
          label1281:
          bool = false;
          continue;
          label1287:
          bool = false;
          continue;
          label1293:
          bool = false;
          continue;
          label1299:
          return true;
          label1301:
          bool = false;
          continue;
          label1307:
          bool = false;
          continue;
          label1313:
          bool = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return false;
    }
    return true;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("public_account_center_url_config_version", 0);
    }
    return i1;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 2);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return paramContext.getString(2131364532);
    }
    return paramContext.getString(2131362961);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.c(new ifa(paramQQAppInterface));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("public_account_center_url_config_version", paramInt);
      paramQQAppInterface.commit();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = paramString.trim();
        paramContext = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramContext.getBytes("utf-8")));
        int i1 = Integer.parseInt(paramContext.getElementsByTagName("version").item(0).getFirstChild().getNodeValue());
        int i2 = SubscriptRecommendController.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig prevVersion = " + i2 + ", version = " + i1);
        }
        if (i1 == i2)
        {
          if (!QLog.isColorLevel()) {
            break label326;
          }
          QLog.d("PublicAccountConfigUtil", 2, "IGNORE THIS ACTION because of SAME VERSION");
          break label326;
        }
        paramContext = paramContext.getElementsByTagName("public-account-folder");
        if (paramContext.getLength() <= 0) {
          break label328;
        }
        paramContext = (Element)paramContext.item(0);
        i2 = Integer.parseInt(paramContext.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
        paramContext = paramContext.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
        SubscriptRecommendController.a(paramQQAppInterface, i1);
        SubscriptRecommendController.a(paramQQAppInterface, i2, paramContext);
        paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(12);
        if (paramQQAppInterface == null) {
          break label328;
        }
        paramQQAppInterface.e();
        break label328;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "updateSubscribeConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    label326:
    return false;
    label328:
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i1;
    do
    {
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "update readinjoy folder xml: " + paramString);
        }
        try
        {
          paramString = paramString.trim();
          paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          Object localObject = paramString.getElementsByTagName("id");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            i1 = Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue();
            if (i1 > SharedPreUtils.x(paramQQAppInterface.a()))
            {
              localObject = (Element)paramString.getElementsByTagName("name").item(0);
              paramString = (Element)paramString.getElementsByTagName("icon").item(0);
              localObject = ((Element)localObject).getFirstChild().getNodeValue();
              paramString = paramString.getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
                SharedPreUtils.d(paramQQAppInterface.a(), (String)localObject, paramString);
              }
              SharedPreUtils.s(paramQQAppInterface.a(), i1);
              return false;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return false;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountConfigUtil", 2, "readinjoy folder config same id ! " + i1);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      boolean bool2;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (!a(str1)) {
          break label146;
        }
        A = str1;
        bool1 = true;
        if (a(str2))
        {
          B = str2;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramString.has("readinjoy_search_url"))
        {
          str1 = paramString.getString("readinjoy_search_url");
          bool2 = bool1;
          if (a(str1))
          {
            C = str1;
            bool2 = true;
          }
        }
        if (paramString.has("image_collection_comment"))
        {
          e = paramString.getBoolean("image_collection_comment");
          return true;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "checkPublicAccountCenterUrlConfigData error", paramString);
        }
        paramString.printStackTrace();
        return false;
      }
      return bool2;
      label146:
      boolean bool1 = false;
    }
  }
  
  public static String c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 3);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
    if (localObject != null) {}
    try
    {
      paramQQAppInterface = new JSONObject();
      paramQQAppInterface.put("pacenter_url", A);
      paramQQAppInterface.put("pacategory_url", B);
      paramQQAppInterface.put("readinjoy_search_url", C);
      paramQQAppInterface.put("image_collection_comment", e);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("public_account_center_url_config_data", paramQQAppInterface.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
    }
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "parseConfigXml xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int i2 = paramString.getLength();
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject = (Element)paramString.item(i1);
          int i3 = Integer.parseInt(((Element)localObject).getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
          localObject = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, i3, ((Element)localObject).getElementsByTagName("name").item(0).getFirstChild().getNodeValue(), ((Element)localObject).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue());
          if (jdField_a_of_type_AndroidUtilSparseArray == null) {
            jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
          }
          jdField_a_of_type_AndroidUtilSparseArray.put(i3, localObject);
          i1 += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("service_folder_name")) {
          break label419;
        }
        paramString = localJSONObject.getString("service_folder_name");
        String str;
        if (localJSONObject.has("service_folder_icon"))
        {
          str = localJSONObject.getString("service_folder_icon");
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str))) {
            break label367;
          }
          D = paramString;
          E = str;
          if (!QLog.isColorLevel()) {
            break label373;
          }
          QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:" + D + " SERVICE_ACCOUNT_FOLDER_ICON:" + E);
          break label373;
          if (!localJSONObject.has("service_folder_redspots")) {
            break label361;
          }
          b = localJSONObject.getBoolean("service_folder_redspots");
          if (!QLog.isColorLevel()) {
            break label379;
          }
          QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + b);
          break label379;
          if (!localJSONObject.has("service_folder_delete")) {
            break label355;
          }
          jdField_a_of_type_Boolean = localJSONObject.getBoolean("service_folder_delete");
          if (!QLog.isColorLevel()) {
            break label385;
          }
          QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + jdField_a_of_type_Boolean);
          break label385;
          if (localJSONObject.has("mp_enable"))
          {
            g = localJSONObject.getBoolean("mp_enable");
            if (!QLog.isColorLevel()) {
              break label391;
            }
            QLog.d("PublicAccountConfigUtil", 2, "is mp config:" + g);
            break label391;
            paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
            if (paramQQAppInterface == null) {
              break label417;
            }
            paramQQAppInterface.sendEmptyMessage(1009);
            break label417;
          }
        }
        else
        {
          str = "";
          continue;
        }
        i4 = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "checkPublicAccountCenterUrlConfigData error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        return false;
      }
      break label394;
      label355:
      int i3 = 0;
      continue;
      label361:
      int i2 = 0;
      continue;
      label367:
      int i1 = 0;
      continue;
      label373:
      i1 = 1;
      continue;
      label379:
      i2 = 1;
      continue;
      label385:
      i3 = 1;
      continue;
      label391:
      int i4 = 1;
      label394:
      if ((i1 == 0) && (i2 == 0) && (i3 == 0))
      {
        if (i4 == 0) {
          break;
        }
        continue;
        label417:
        return true;
        label419:
        paramString = "";
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = paramQQAppInterface.getApplication().getApplicationContext().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.a(), 0);
      if (localSharedPreferences == null) {
        break;
      }
      d = localSharedPreferences.getBoolean("public_account_manage_enable", false);
      j = localSharedPreferences.getInt("public_account_manage_count_limit", 10);
      k = localSharedPreferences.getInt("public_account_manage_day_limit", 30);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "getPaManageABTestInfo->cuin:" + paramQQAppInterface.a() + ", PUBLIC_ACCOUNT_MANAGE_ENABLE:" + d + ", PUBLIC_ACCOUNT_MANAGE_RED_COUNT_LIMIT:" + j + ", PUBLIC_ACCOUNT_MANAGE_RED_DAY_LIMIT:" + k);
      }
      localObject2 = new SimpleDateFormat("yyyy-MM-dd");
      localObject1 = ((SimpleDateFormat)localObject2).format(new Date(PublicAccountUtil.b(localSharedPreferences.getLong("public_account_manage_abtest_load_time", 0L))));
      localObject2 = ((SimpleDateFormat)localObject2).format(new Date(PublicAccountUtil.b(NetConnInfoCenter.getServerTimeMillis())));
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "getPaManageABTestInfo->cuin:" + paramQQAppInterface.a() + ", newDate:" + (String)localObject2 + ", oldDate:" + (String)localObject1);
      }
    } while (((String)localObject2).equals(localObject1));
    Object localObject1 = new NewIntent(paramQQAppInterface.getApplication().getApplicationContext(), PublicAccountServlet.class);
    ((NewIntent)localObject1).putExtra("cmd", "ab_test_control");
    Object localObject2 = new mobileqq_mp.ABTestControlMsgRequest();
    ((mobileqq_mp.ABTestControlMsgRequest)localObject2).versionInfo.set(PublicAccountUtil.a());
    ((mobileqq_mp.ABTestControlMsgRequest)localObject2).testType.set(2);
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "getPaManageABTestInfo->cuin:" + paramQQAppInterface.a() + ", versionInfo:" + ((mobileqq_mp.ABTestControlMsgRequest)localObject2).versionInfo.get() + ", testType:" + ((mobileqq_mp.ABTestControlMsgRequest)localObject2).testType.get());
    }
    ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.ABTestControlMsgRequest)localObject2).toByteArray());
    ((NewIntent)localObject1).setObserver(new ifb((NewIntent)localObject1, paramQQAppInterface, localSharedPreferences));
    paramQQAppInterface.startServlet((NewIntent)localObject1);
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l1 = paramQQAppInterface.getLongAccountUin();
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "PubAccountSvc.mp_is_admin_uin");
    mobileqq_mp.MpIsAdminUinRequest localMpIsAdminUinRequest = new mobileqq_mp.MpIsAdminUinRequest();
    localMpIsAdminUinRequest.versionInfo.set("6.5.5,3,2880");
    localMpIsAdminUinRequest.cuin.set(l1);
    localNewIntent.putExtra("data", localMpIsAdminUinRequest.toByteArray());
    PublicAccountServlet.a(localNewIntent);
    paramQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PublicAccountConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */