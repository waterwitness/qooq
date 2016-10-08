package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;
import tuc;
import tud;
import tue;
import tuf;
import tuh;
import tui;

public class PortalManager
  implements SoundPool.OnLoadCompleteListener, Handler.Callback, INetEngine.INetEngineListener, Manager, BusinessObserver
{
  private static final int A = 1;
  private static final int B = 2;
  private static final int C = 3;
  private static final int D = 5;
  private static final int E = 6;
  private static final int F = 12;
  private static final int G = 13;
  private static final int H = 14;
  private static final int I = 15;
  private static final int J = 16;
  private static final int K = 100;
  private static final float jdField_a_of_type_Float = 1048576.0F;
  public static final int a = 1;
  public static long a = 0L;
  private static PortalManager.TimerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig = new PortalManager.TimerConfig(null);
  protected static INetEngine.IBreakDownFix a;
  public static final String a = "PortalManager";
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static Comparator jdField_a_of_type_JavaUtilComparator;
  public static boolean a = false;
  private static final boolean[] jdField_a_of_type_ArrayOfBoolean = { 0, 0, 0, 0 };
  public static final int b = 2;
  public static long b = 0L;
  public static final String b = "hb_icon_path";
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131165204, 2131165206, 2131165205, 2131165204 };
  public static final int c = 3;
  public static long c = 0L;
  public static final String c = "hb_banner_path";
  public static final int d = 4;
  public static final String d = "hb_b_logo_path";
  protected static final int e = 1;
  public static long e = 0L;
  public static final String e = "hb_l_logo_path";
  protected static final int f = 2;
  public static long f = 0L;
  private static final String f;
  protected static final int g = 3;
  private static final String jdField_g_of_type_JavaLangString = "red_packet_config";
  protected static final int h = 4;
  private static final long jdField_h_of_type_Long = 60000L;
  private static final String jdField_h_of_type_JavaLangString = "http://mmatest.qq.com/impchen3/cgi/redbag/up";
  protected static final int i = 5;
  private static long jdField_i_of_type_Long = 0L;
  private static final String jdField_i_of_type_JavaLangString = "http://mmb.qq.com/pansocial/cgi/redbag/up";
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 7;
  public static final int q = 8;
  public static final int r = 0;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  public static final int v = 4;
  public static final int w = 1;
  public static final int x = 4;
  private static final int z = 1000;
  private int L;
  private int M;
  private int N;
  private Context jdField_a_of_type_AndroidContentContext;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Handler jdField_a_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(1);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tuf(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PortalManager.BannerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  private PortalManager.PortalShower jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
  public volatile PortalManager.RedPacketConfig a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  public final ConcurrentHashMap a;
  tui jdField_a_of_type_Tui;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 0, 0, 0 };
  private Handler jdField_b_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(100);
  private PortalManager.BannerConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  volatile long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private long j;
  int y = 4;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = 2500L;
    jdField_b_of_type_Long = 180000L;
    jdField_c_of_type_Long = 180000L;
    jdField_f_of_type_JavaLangString = File.separator + "redPacketRes/";
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new tud();
    jdField_a_of_type_JavaUtilComparator = new tue();
  }
  
  public PortalManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(1000);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    this.jdField_a_of_type_Tui = new tui(this, null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(this.jdField_a_of_type_Tui, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.msg.permission.pushnotify", null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("PortalManager", 1, "", paramQQAppInterface);
      }
    }
  }
  
  static long a(String paramString)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l1 = -1L;
    try
    {
      long l2 = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PortalManager", 2, "", paramString);
    }
    return l1;
    return -1L;
  }
  
  public static Bitmap a(String paramString1, String paramString2)
  {
    String str2 = BaseApplicationImpl.a().getFilesDir() + jdField_f_of_type_JavaLangString;
    Object localObject2;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          return a(paramString2, true);
        }
        str1 = "red_packet_" + paramString1;
        localObject1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str1);
        localObject2 = localObject1;
        if (localObject1 != null) {
          return localObject2;
        }
      }
      catch (Exception paramString1)
      {
        String str1;
        Object localObject1 = null;
        continue;
      }
      try
      {
        paramString1 = BitmapFactory.decodeFile(str2 + paramString1);
        if (paramString1 != null)
        {
          localObject1 = paramString1;
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str1, paramString1);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("PortalManager", 2, "", paramString1);
          return (Bitmap)localObject1;
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", paramString1);
        }
        paramString1 = null;
        continue;
        localObject1 = paramString1;
        paramString1 = a(paramString2, true);
        return paramString1;
      }
    }
    return (Bitmap)localObject2;
  }
  
  private static Bitmap a(String paramString, boolean paramBoolean)
  {
    try
    {
      localObject = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("red_packet_" + paramString);
      if (localObject != null) {
        return (Bitmap)localObject;
      }
      if (TextUtils.isEmpty(paramString)) {
        break label187;
      }
      if (!"hb_icon_path".equals(paramString)) {
        break label130;
      }
      i1 = 2130840556;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        int i1;
        Bitmap localBitmap;
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", paramString);
        }
        return null;
        if ("hb_banner_path".equals(paramString))
        {
          i1 = 2130840740;
        }
        else if ("hb_b_logo_path".equals(paramString))
        {
          i1 = 2130840556;
        }
        else
        {
          boolean bool = "hb_l_logo_path".equals(paramString);
          if (!bool) {
            break;
          }
          i1 = 2130840556;
        }
      }
      return null;
      return null;
    }
    catch (Exception paramString)
    {
      label130:
      label187:
      if (!QLog.isColorLevel()) {
        break label206;
      }
      QLog.e("PortalManager", 2, "", paramString);
      label206:
      localObject = null;
    }
    localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i1);
    Object localObject = localBitmap;
    if (localBitmap != null)
    {
      localObject = localBitmap;
      if (paramBoolean)
      {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("red_packet_" + paramString, localBitmap);
        return localBitmap;
      }
    }
    return (Bitmap)localObject;
  }
  
  protected static PortalManager.RedPacketConfig a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    Object localObject1 = Xml.newPullParser();
    PortalManager.RedPacketConfig localRedPacketConfig = new PortalManager.RedPacketConfig();
    localRedPacketConfig.version = paramInt;
    Object localObject2;
    do
    {
      for (;;)
      {
        try
        {
          ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
          paramInt = ((XmlPullParser)localObject1).getEventType();
          if (paramInt == 1) {
            break label1652;
          }
          if (paramInt != 2) {
            break label233;
          }
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (!((String)localObject2).equalsIgnoreCase("Common")) {
            break label243;
          }
          paramInt = ((XmlPullParser)localObject1).next();
          if (paramInt == 1) {
            break label233;
          }
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (paramInt != 2) {
            break;
          }
          if (((String)localObject2).equalsIgnoreCase("GrabReqInterval"))
          {
            localRedPacketConfig.grebInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            paramInt = ((XmlPullParser)localObject1).next();
            continue;
          }
          if (((String)localObject2).equalsIgnoreCase("ReportActiveInterval"))
          {
            localRedPacketConfig.reportActiveInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            continue;
          }
          if (!((String)localObject2).equalsIgnoreCase("ReportNormalInterval")) {
            continue;
          }
        }
        catch (Exception paramArrayList)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PortalManager", 2, paramString, paramArrayList);
          }
          return null;
        }
        localRedPacketConfig.reportNormalInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
      }
    } while ((paramInt != 3) || (!"Common".equals(localObject2)));
    label233:
    label243:
    label302:
    Object localObject3;
    for (;;)
    {
      paramInt = ((XmlPullParser)localObject1).next();
      break;
      if (((String)localObject2).equalsIgnoreCase("ConfigId"))
      {
        localRedPacketConfig.id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
      else if (((String)localObject2).equalsIgnoreCase("BBanner"))
      {
        localObject2 = new PortalManager.BannerConfig(null);
        paramInt = ((XmlPullParser)localObject1).next();
        if (paramInt != 1)
        {
          localObject3 = ((XmlPullParser)localObject1).getName();
          if ((paramInt == 3) && (((String)localObject3).equalsIgnoreCase("BBanner")))
          {
            localRedPacketConfig.bannerConfigs.add(localObject2);
            continue;
          }
          if (paramInt == 2)
          {
            if (!((String)localObject3).equalsIgnoreCase("Id")) {
              break label388;
            }
            ((PortalManager.BannerConfig)localObject2).id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
          }
        }
        for (;;)
        {
          paramInt = ((XmlPullParser)localObject1).next();
          break label302;
          break;
          label388:
          if (((String)localObject3).equalsIgnoreCase("Begin")) {
            ((PortalManager.BannerConfig)localObject2).uiBegin = a(((XmlPullParser)localObject1).nextText());
          } else if (((String)localObject3).equalsIgnoreCase("End")) {
            ((PortalManager.BannerConfig)localObject2).uiEnd = a(((XmlPullParser)localObject1).nextText());
          } else if (((String)localObject3).equalsIgnoreCase("Img")) {
            ((PortalManager.BannerConfig)localObject2).bannerImg = ((XmlPullParser)localObject1).nextText();
          } else if (((String)localObject3).equalsIgnoreCase("Md5")) {
            ((PortalManager.BannerConfig)localObject2).bannarMd5 = ((XmlPullParser)localObject1).nextText();
          } else if (((String)localObject3).equalsIgnoreCase("JumpH5")) {
            ((PortalManager.BannerConfig)localObject2).jumpUrl = ((XmlPullParser)localObject1).nextText();
          }
        }
      }
      else if (((String)localObject2).equalsIgnoreCase("Activity"))
      {
        localObject2 = new PortalManager.PortalConfig();
        paramInt = ((XmlPullParser)localObject1).next();
        label546:
        if (paramInt == 1) {
          break label697;
        }
        localObject3 = ((XmlPullParser)localObject1).getName();
        if ((paramInt != 3) || (!((String)localObject3).equalsIgnoreCase("Activity"))) {
          break label656;
        }
        if (((PortalManager.PortalConfig)localObject2).realEnd >= ((PortalManager.PortalConfig)localObject2).realBegin) {
          localRedPacketConfig.portalConfigs.add(localObject2);
        } else if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "parseConfig" + ((PortalManager.PortalConfig)localObject2).realBegin + ", " + ((PortalManager.PortalConfig)localObject2).realEnd);
        }
      }
    }
    label656:
    if (paramInt == 2)
    {
      if (!((String)localObject3).equalsIgnoreCase("Id")) {
        break label699;
      }
      ((PortalManager.PortalConfig)localObject2).id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
    }
    label697:
    label699:
    long l1;
    for (;;)
    {
      paramInt = ((XmlPullParser)localObject1).next();
      break label546;
      break;
      if (((String)localObject3).equalsIgnoreCase("Type"))
      {
        ((PortalManager.PortalConfig)localObject2).type = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
      else if (((String)localObject3).equalsIgnoreCase("Begin"))
      {
        l1 = a(((XmlPullParser)localObject1).nextText());
        ((PortalManager.PortalConfig)localObject2).realBegin = l1;
        ((PortalManager.PortalConfig)localObject2).uiBegin = l1;
      }
      else if (((String)localObject3).equalsIgnoreCase("End"))
      {
        l1 = a(((XmlPullParser)localObject1).nextText());
        ((PortalManager.PortalConfig)localObject2).realEnd = l1;
        ((PortalManager.PortalConfig)localObject2).uiEnd = l1;
      }
      else if (((String)localObject3).equalsIgnoreCase("BackGroundImg"))
      {
        ((PortalManager.PortalConfig)localObject2).bgImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("BackGroundMd5"))
      {
        ((PortalManager.PortalConfig)localObject2).bgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("TopImg"))
      {
        ((PortalManager.PortalConfig)localObject2).topImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("TopMd5"))
      {
        ((PortalManager.PortalConfig)localObject2).topMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("LUIconImg"))
      {
        ((PortalManager.PortalConfig)localObject2).leftImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("LUIconMd5"))
      {
        ((PortalManager.PortalConfig)localObject2).leftMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("ActTime"))
      {
        ((PortalManager.PortalConfig)localObject2).rightMsg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("PendantImg"))
      {
        ((PortalManager.PortalConfig)localObject2).pendantImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("PendantMd5"))
      {
        ((PortalManager.PortalConfig)localObject2).pendantMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("Timer"))
      {
        ((PortalManager.PortalConfig)localObject2).countTime = (Integer.parseInt(((XmlPullParser)localObject1).nextText()) * 1000);
      }
      else if (((String)localObject3).equalsIgnoreCase("GrabWording"))
      {
        ((PortalManager.PortalConfig)localObject2).grabMsg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("NoRPWording"))
      {
        ((PortalManager.PortalConfig)localObject2).emptyMsg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardLogoImg"))
      {
        ((PortalManager.PortalConfig)localObject2).awardImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardLogoMd5"))
      {
        ((PortalManager.PortalConfig)localObject2).awardMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardLogo2Img"))
      {
        ((PortalManager.PortalConfig)localObject2).starImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardLogo2Md5"))
      {
        ((PortalManager.PortalConfig)localObject2).starMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardLogoBGImg"))
      {
        ((PortalManager.PortalConfig)localObject2).ctfBgImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardLogoBGMd5"))
      {
        ((PortalManager.PortalConfig)localObject2).ctfBgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("Grettings"))
      {
        ((PortalManager.PortalConfig)localObject2).awardMsg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardName"))
      {
        ((PortalManager.PortalConfig)localObject2).awardTitle = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AddWording"))
      {
        ((PortalManager.PortalConfig)localObject2).addMsg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("PublicId"))
      {
        ((PortalManager.PortalConfig)localObject2).publicId = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("HCUrl"))
      {
        ((PortalManager.PortalConfig)localObject2).hotUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("HCLogoImg"))
      {
        ((PortalManager.PortalConfig)localObject2).hotImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("HCLogoMd5"))
      {
        ((PortalManager.PortalConfig)localObject2).hotMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("HCTopic"))
      {
        ((PortalManager.PortalConfig)localObject2).hotTopic = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("HCAddWording"))
      {
        ((PortalManager.PortalConfig)localObject2).hotAddMsg = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("HCPublicId"))
      {
        ((PortalManager.PortalConfig)localObject2).hotPublicId = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("NextActTime"))
      {
        ((PortalManager.PortalConfig)localObject2).nextActTime = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("ActEndWording"))
      {
        ((PortalManager.PortalConfig)localObject2).actEndWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("AwardLogoType"))
      {
        ((PortalManager.PortalConfig)localObject2).logoType = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
      else if (((String)localObject3).equalsIgnoreCase("TipWording"))
      {
        ((PortalManager.PortalConfig)localObject2).countDownTips = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject3).equalsIgnoreCase("ShareTimes"))
      {
        ((PortalManager.PortalConfig)localObject2).shareBaseLine = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
    }
    label1652:
    paramInt = 0;
    int i3 = localRedPacketConfig.portalConfigs.size();
    int i1;
    label1749:
    int i2;
    if (paramArrayList != null)
    {
      i1 = paramArrayList.size();
      if ((i1 != 0) && (i3 > 0))
      {
        Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
        localObject1 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(0);
        if (((PortalManager.PortalConfig)localObject1).type != 2) {
          break label2056;
        }
        l1 = ((PortalManager.PortalConfig)localObject1).realBegin;
        ((PortalManager.PortalConfig)localObject1).uiBegin = (((Integer)paramArrayList.get(0 % i1)).intValue() + l1);
        paramInt = 1;
        break label2056;
        if (i2 < i3)
        {
          localObject2 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(i2);
          if (((PortalManager.PortalConfig)localObject2).type != 2) {
            break label2053;
          }
          ((PortalManager.PortalConfig)localObject2).uiBegin = (((PortalManager.PortalConfig)localObject2).realBegin + ((Integer)paramArrayList.get(paramInt % i1)).intValue() * 1000);
          if ((localObject1 == null) || (((PortalManager.PortalConfig)localObject1).type != 1) || (((PortalManager.PortalConfig)localObject1).realEnd + 2000L < ((PortalManager.PortalConfig)localObject2).realBegin)) {
            break label2062;
          }
          ((PortalManager.PortalConfig)localObject1).uiEnd = (((PortalManager.PortalConfig)localObject1).realEnd + ((Integer)paramArrayList.get(paramInt % i1)).intValue() * 1000);
          break label2062;
        }
      }
      Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
      paramInt = localRedPacketConfig.bannerConfigs.size() - 1;
    }
    for (;;)
    {
      if (paramInt >= 0)
      {
        localObject1 = (PortalManager.BannerConfig)localRedPacketConfig.bannerConfigs.get(paramInt);
        localObject2 = localRedPacketConfig.portalConfigs.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (PortalManager.PortalConfig)((Iterator)localObject2).next();
          if ((((PortalManager.BannerConfig)localObject1).uiBegin >= ((PortalManager.PortalConfig)localObject3).realBegin) && (((PortalManager.BannerConfig)localObject1).uiBegin < ((PortalManager.PortalConfig)localObject3).realEnd))
          {
            if (((PortalManager.BannerConfig)localObject1).uiBegin != ((PortalManager.PortalConfig)localObject3).realBegin) {
              break;
            }
            ((PortalManager.BannerConfig)localObject1).uiBegin = ((PortalManager.PortalConfig)localObject3).uiBegin;
            break;
          }
        } while (((PortalManager.PortalConfig)localObject3).uiBegin <= ((PortalManager.BannerConfig)localObject1).uiBegin);
      }
      else
      {
        Collections.sort(localRedPacketConfig.bannerConfigs, jdField_a_of_type_JavaUtilComparator);
        if (QLog.isColorLevel()) {
          a(localRedPacketConfig, "parseConfig, " + paramArrayList);
        }
        return localRedPacketConfig;
        label2053:
        break label2066;
        label2056:
        i2 = 1;
        break label1749;
        label2062:
        paramInt += 1;
        label2066:
        i2 += 1;
        localObject1 = localObject2;
        break label1749;
        i1 = 0;
        break;
      }
      paramInt -= 1;
    }
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("http://newyear.qq.com/redEnvelopeRank/release/html/share.html?_bid=2257&_wv=1027&adtag=first_share&");
    localStringBuilder.append("key=").append(PortalUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue())).append("&").append("share_uin=").append(new String(Base64Util.encode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().getBytes(), 2))).append("&").append("tc=").append(new String(Base64Util.encode(String.valueOf(paramInt1).getBytes(), 2))).append("&").append("cc=").append(new String(Base64Util.encode(String.valueOf(paramInt2).getBytes(), 2)));
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "getShareUrl:" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("errorCode", paramInt3);
      if (!TextUtils.isEmpty(paramString2)) {
        ((JSONObject)localObject).put("errorMsg", paramString2);
      }
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        localObject = paramString1;
      }
    }
    a(paramInt1, (String)localObject, paramInt2);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((!QLog.isColorLevel()) || (paramInt1 == 1009)) {}
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        localObject = "get head returned , key = " + ((JSONObject)localObject).getString("key");
        QLog.d("PortalManager", 2, "sendBroadcastRespData, " + paramInt1 + ", " + paramInt2 + ", " + (String)localObject);
        localObject = new Intent("com.tencent.portal.resp.action");
        ((Intent)localObject).putExtra("portal_type_key", paramInt1);
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("bc_data", PortalUtils.a(paramString));
        ((Intent)localObject).putExtras(localBundle);
        if (paramInt2 > 0) {
          ((Intent)localObject).putExtra("bc_seq", paramInt2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str = paramString;
        continue;
      }
      String str = paramString;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PortalManager", 2, "downLoad, " + paramInt + ", " + paramString1 + ", " + paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + jdField_f_of_type_JavaLangString;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString1;
    localHttpNetReq.jdField_c_of_type_Int = 0;
    localHttpNetReq.b = (str + paramString2);
    localHttpNetReq.m = 2;
    localHttpNetReq.a(new String[] { String.valueOf(paramInt), paramString2 });
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  private void a(long paramLong)
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    if (localObject3 == null) {
      return;
    }
    long l2 = paramLong;
    if (e > 0L) {
      l2 = e + i * (paramLong - jdField_f_of_type_Long);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
    ArrayList localArrayList = ((PortalManager.RedPacketConfig)localObject3).bannerConfigs;
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig.uiBegin = l2;
    PortalManager.PortalConfig localPortalConfig = null;
    int i1 = Collections.binarySearch(localArrayList, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, jdField_a_of_type_JavaUtilComparator);
    Object localObject1;
    if (i1 >= 0)
    {
      i1 += 1;
      if ((i1 <= 0) || (i1 > localArrayList.size())) {
        break label893;
      }
      localObject1 = (PortalManager.BannerConfig)localArrayList.get(i1 - 1);
      if (((PortalManager.BannerConfig)localObject1).uiEnd >= l2) {
        break label890;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localPortalConfig;
      if (i1 < localArrayList.size())
      {
        localObject2 = localPortalConfig;
        if (i1 >= 0) {
          localObject2 = (PortalManager.BannerConfig)localArrayList.get(i1);
        }
      }
      localObject3 = ((PortalManager.RedPacketConfig)localObject3).portalConfigs;
      i1 = Collections.binarySearch((List)localObject3, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, jdField_a_of_type_JavaUtilComparator);
      if (i1 >= 0)
      {
        i1 += 1;
        label195:
        if ((i1 <= 0) || (i1 > ((ArrayList)localObject3).size())) {
          break label884;
        }
        localPortalConfig = (PortalManager.PortalConfig)((ArrayList)localObject3).get(i1 - 1);
        if (localPortalConfig.uiEnd >= l2) {
          break label881;
        }
        localPortalConfig = null;
      }
      for (;;)
      {
        if ((i1 < ((ArrayList)localObject3).size()) && (i1 >= 0)) {}
        for (localObject3 = (PortalManager.PortalConfig)((ArrayList)localObject3).get(i1);; localObject3 = null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject1);
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = localPortalConfig;
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = ((PortalManager.PortalConfig)localObject3);
          paramLong = Long.MAX_VALUE;
          label307:
          long l1;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
          {
            paramLong = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiEnd;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
              break label797;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd <= l2) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd >= paramLong)) {
              break label754;
            }
            l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
            label348:
            paramLong = l1;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2)
            {
              long l3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime;
              paramLong = l1;
              if (l3 >= l2)
              {
                paramLong = l1;
                if (l3 < l1)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PortalManager", 2, "updateCurrentTimer last minutes in, countTime = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime + ", diffTime = " + l3 + ", timeout = " + l3);
                  }
                  paramLong = l3;
                }
              }
            }
            this.j = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
          }
          label476:
          label497:
          label574:
          label603:
          label632:
          label661:
          label754:
          label797:
          label827:
          label841:
          label847:
          label853:
          label859:
          label865:
          label872:
          for (;;)
          {
            if (paramLong != Long.MAX_VALUE)
            {
              if (paramLong <= l2) {
                break label827;
              }
              l1 = paramLong - l2;
              l2 = l1;
              if (l1 > 60000L) {
                l2 = 60000L;
              }
              if (e == 0L) {
                break label865;
              }
            }
            for (l1 = 1000L;; l1 = l2)
            {
              a(true, 100, l1, null);
              if (!QLog.isColorLevel()) {
                break;
              }
              localObject1 = new StringBuilder().append("updateCurrentTimer, ");
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
              {
                i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i1).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label841;
                }
                i1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i1).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label847;
                }
                i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i1).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label853;
                }
                i1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i1).append(", ").append(paramLong).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label859;
                }
              }
              for (i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag;; i1 = -1)
              {
                QLog.d("PortalManager", 2, i1);
                return;
                i1 = -i1 - 1;
                break;
                i1 = -i1 - 1;
                break label195;
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label307;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiBegin;
                break label307;
                l1 = paramLong;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd <= l2) {
                  break label348;
                }
                l1 = paramLong;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd >= paramLong) {
                  break label348;
                }
                l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd;
                break label348;
                if ((this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin >= paramLong)) {
                  break label872;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin;
                break label476;
                l1 = 60000L;
                break label497;
                i1 = -1;
                break label574;
                i1 = -1;
                break label603;
                i1 = -1;
                break label632;
                i1 = -1;
                break label661;
              }
            }
          }
        }
        label881:
        continue;
        label884:
        localPortalConfig = null;
      }
      label890:
      continue;
      label893:
      localObject1 = null;
    }
  }
  
  public static void a(Activity paramActivity, PortalManager.ResultData paramResultData)
  {
    if ((paramResultData == null) || (paramActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showResultActivity" + paramResultData + ", " + paramActivity);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "showResultActivity, " + paramResultData.jdField_d_of_type_Int + ", " + paramResultData.b + ", " + paramResultData.jdField_c_of_type_Int);
      }
      Intent localIntent = new Intent(paramActivity, HongbaoShowerActivity.class);
      localIntent.putExtra("a_hb_type", paramResultData.jdField_d_of_type_Int);
      localIntent.putExtra("a_hg_url", paramResultData.b);
      localIntent.putExtra("a_hb_task_id", paramResultData.jdField_c_of_type_Int);
      localIntent.putExtra("money", paramResultData.jdField_e_of_type_Int);
      localIntent.putExtra("show_follow", paramResultData.jdField_a_of_type_Boolean);
      localIntent.addFlags(67108864);
      paramActivity.startActivity(localIntent);
    } while ((paramResultData.jdField_e_of_type_Int <= 0) || (QWalletHelper.a(paramActivity)));
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "preload qwallet process by shua yi shua");
    }
    QWalletHelper.a(0, "qwallet_red");
  }
  
  private void a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (FileUtils.a() < 1048576.0F) {}
    for (;;)
    {
      return;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject = paramRedPacketConfig.bannerConfigs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PortalManager.BannerConfig localBannerConfig = (PortalManager.BannerConfig)((Iterator)localObject).next();
        if ((localBannerConfig.uiEnd > l1) && (a(localBannerConfig.bannarMd5))) {
          a(localBannerConfig.id, localBannerConfig.bannerImg, localBannerConfig.bannarMd5);
        }
      }
      paramRedPacketConfig = paramRedPacketConfig.portalConfigs.iterator();
      while (paramRedPacketConfig.hasNext())
      {
        localObject = (PortalManager.PortalConfig)paramRedPacketConfig.next();
        if ((((PortalManager.PortalConfig)localObject).uiEnd > l1) || (((PortalManager.PortalConfig)localObject).realEnd > l1))
        {
          if (a(((PortalManager.PortalConfig)localObject).topMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).topImg, ((PortalManager.PortalConfig)localObject).topMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).leftMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).leftImg, ((PortalManager.PortalConfig)localObject).leftMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).awardMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).awardImg, ((PortalManager.PortalConfig)localObject).awardMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).hotMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).hotImg, ((PortalManager.PortalConfig)localObject).hotMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).bgMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).bgImg, ((PortalManager.PortalConfig)localObject).bgMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).pendantMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).pendantImg, ((PortalManager.PortalConfig)localObject).pendantMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).starMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).starImg, ((PortalManager.PortalConfig)localObject).starMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).ctfBgMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).ctfBgImg, ((PortalManager.PortalConfig)localObject).ctfBgMd5);
          }
        }
      }
    }
  }
  
  private static void a(PortalManager.RedPacketConfig paramRedPacketConfig, String paramString)
  {
    int i2 = 0;
    int i4 = paramRedPacketConfig.bannerConfigs.size();
    int i3 = paramRedPacketConfig.portalConfigs.size();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(paramString).append(", ").append(paramRedPacketConfig.id).append(", ").append(paramRedPacketConfig.version);
    localStringBuilder.append('[');
    int i1 = 0;
    while (i1 < i4)
    {
      localStringBuilder.append(((PortalManager.BannerConfig)paramRedPacketConfig.bannerConfigs.get(i1)).id).append(", ");
      i1 += 1;
    }
    localStringBuilder.append(']').append(", ").append('[');
    i1 = i2;
    while (i1 < i3)
    {
      localStringBuilder.append(((PortalManager.PortalConfig)paramRedPacketConfig.portalConfigs.get(i1)).id).append(", ");
      i1 += 1;
    }
    localStringBuilder.append(']');
    QLog.d("PortalManager", 2, localStringBuilder.toString());
  }
  
  private boolean a(PortalManager.RedPacketConfig paramRedPacketConfig1, PortalManager.RedPacketConfig paramRedPacketConfig2, boolean paramBoolean)
  {
    int i2 = 0;
    int i3 = paramRedPacketConfig1.portalConfigs.size();
    if (paramRedPacketConfig2 != null) {}
    HashMap localHashMap;
    PortalManager.PortalConfig localPortalConfig1;
    for (int i1 = paramRedPacketConfig2.portalConfigs.size();; i1 = 0)
    {
      if (paramRedPacketConfig2 != null) {
        paramRedPacketConfig1.showGesturesTime = paramRedPacketConfig2.showGesturesTime;
      }
      if ((i3 <= 0) || (i1 <= 0)) {
        break label284;
      }
      localHashMap = new HashMap(i1);
      localObject = paramRedPacketConfig2.portalConfigs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localPortalConfig1 = (PortalManager.PortalConfig)((Iterator)localObject).next();
        localHashMap.put(Integer.valueOf(localPortalConfig1.id), localPortalConfig1);
      }
    }
    Object localObject = paramRedPacketConfig1.portalConfigs.iterator();
    boolean bool = false;
    PortalManager.PortalConfig localPortalConfig2;
    do
    {
      paramBoolean = bool;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localPortalConfig1 = (PortalManager.PortalConfig)((Iterator)localObject).next();
      localPortalConfig2 = (PortalManager.PortalConfig)localHashMap.get(Integer.valueOf(localPortalConfig1.id));
    } while (localPortalConfig2 == null);
    if (localPortalConfig2.useFlag != localPortalConfig1.useFlag)
    {
      localPortalConfig1.useFlag = localPortalConfig2.useFlag;
      bool = true;
    }
    if (localPortalConfig2.useTime != localPortalConfig1.useTime)
    {
      localPortalConfig1.useTime = localPortalConfig2.useTime;
      bool = true;
    }
    if (localPortalConfig2.countGrab != localPortalConfig1.countGrab)
    {
      localPortalConfig1.countGrab = localPortalConfig2.countGrab;
      bool = true;
    }
    if (localPortalConfig2.continuousRecord != localPortalConfig1.continuousRecord) {
      localPortalConfig1.continuousRecord = localPortalConfig2.continuousRecord;
    }
    for (paramBoolean = true;; paramBoolean = bool)
    {
      bool = paramBoolean;
      break;
      label284:
      paramBoolean = false;
      i3 = paramRedPacketConfig1.bannerConfigs.size();
      i1 = i2;
      if (paramRedPacketConfig2 != null) {
        i1 = paramRedPacketConfig2.bannerConfigs.size();
      }
      bool = paramBoolean;
      if (i3 > 0)
      {
        bool = paramBoolean;
        if (i1 > 0)
        {
          localHashMap = new HashMap(i1);
          paramRedPacketConfig2 = paramRedPacketConfig2.bannerConfigs.iterator();
          while (paramRedPacketConfig2.hasNext())
          {
            localObject = (PortalManager.BannerConfig)paramRedPacketConfig2.next();
            localHashMap.put(Integer.valueOf(((PortalManager.BannerConfig)localObject).id), localObject);
          }
          paramRedPacketConfig1 = paramRedPacketConfig1.bannerConfigs.iterator();
          for (;;)
          {
            bool = paramBoolean;
            if (!paramRedPacketConfig1.hasNext()) {
              break;
            }
            paramRedPacketConfig2 = (PortalManager.BannerConfig)paramRedPacketConfig1.next();
            localObject = (PortalManager.BannerConfig)localHashMap.get(Integer.valueOf(paramRedPacketConfig2.id));
            if ((localObject != null) && (((PortalManager.BannerConfig)localObject).useFlag != paramRedPacketConfig2.useFlag))
            {
              paramRedPacketConfig2.useFlag = ((PortalManager.BannerConfig)localObject).useFlag;
              paramBoolean = true;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "updateUsedFlag, " + bool);
      }
      return bool;
    }
  }
  
  private boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {}
    String str;
    do
    {
      return false;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + jdField_f_of_type_JavaLangString;
    } while (new File(str + paramString).exists());
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    return true;
  }
  
  private int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord;
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1) != this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id)
        {
          this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.remove(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1));
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "purifyBrashReporter delete key = " + this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1));
          }
        }
        i1 += 1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
    }
    return -1;
  }
  
  public PortalManager.PortalConfig a(long paramLong)
  {
    long l2 = paramLong;
    long l1;
    int i1;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
    {
      l1 = paramLong;
      if (paramLong == -1L)
      {
        paramLong = NetConnInfoCenter.getServerTimeMillis();
        l1 = paramLong;
        if (e > 0L) {
          l1 = e + i * (paramLong - jdField_f_of_type_Long);
        }
      }
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs;
      int i2 = localArrayList.size();
      i1 = 0;
      l2 = l1;
      if (i1 < i2)
      {
        localObject2 = (PortalManager.PortalConfig)localArrayList.get(i1);
        localObject1 = localObject2;
        l2 = l1;
        if (((PortalManager.PortalConfig)localObject2).id != l1)
        {
          if ((((PortalManager.PortalConfig)localObject2).realBegin > l1) || (((PortalManager.PortalConfig)localObject2).realEnd <= l1)) {
            break label201;
          }
          l2 = l1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      label141:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("findRealPortal, ").append(l2).append(", ");
        if (localObject1 == null) {
          break label239;
        }
      }
      label201:
      label239:
      for (i1 = ((PortalManager.PortalConfig)localObject1).id;; i1 = -1)
      {
        QLog.d("PortalManager", 2, i1);
        return (PortalManager.PortalConfig)localObject1;
        if ((l1 > 536870911L) && (((PortalManager.PortalConfig)localObject2).realBegin > l1))
        {
          localObject1 = null;
          l2 = l1;
          break label141;
        }
        i1 += 1;
        break;
      }
      localObject1 = null;
    }
  }
  
  /* Error */
  protected PortalManager.RedPacketConfig a()
  {
    // Byte code:
    //   0: new 137	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 228	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: invokevirtual 1099	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: new 132	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1101
    //   21: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 221	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: invokevirtual 776	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   31: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 1104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 1077	java/io/File:exists	()Z
    //   45: ifeq +353 -> 398
    //   48: new 1106	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 1109	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: new 1111	java/io/ObjectInputStream
    //   60: dup
    //   61: new 1113	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 1116	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: invokespecial 1117	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore 6
    //   74: aload_1
    //   75: astore_3
    //   76: aload 6
    //   78: astore_2
    //   79: aload 6
    //   81: invokevirtual 1120	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   84: checkcast 416	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   87: astore 4
    //   89: aload 6
    //   91: ifnull +8 -> 99
    //   94: aload 6
    //   96: invokevirtual 1123	java/io/ObjectInputStream:close	()V
    //   99: aload_1
    //   100: ifnull +303 -> 403
    //   103: aload_1
    //   104: invokevirtual 1124	java/io/FileInputStream:close	()V
    //   107: aload 4
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: aload_1
    //   113: ifnonnull +11 -> 124
    //   116: new 416	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   119: dup
    //   120: invokespecial 417	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:<init>	()V
    //   123: astore_2
    //   124: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +10 -> 137
    //   130: aload_2
    //   131: ldc_w 1126
    //   134: invokestatic 767	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 914	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   141: ifnonnull +11 -> 152
    //   144: aload_0
    //   145: iconst_1
    //   146: iconst_2
    //   147: lconst_0
    //   148: aload_2
    //   149: invokevirtual 951	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   152: aload_2
    //   153: areturn
    //   154: astore_2
    //   155: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -59 -> 99
    //   161: ldc 45
    //   163: iconst_2
    //   164: ldc_w 289
    //   167: aload_2
    //   168: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: goto -72 -> 99
    //   174: astore_1
    //   175: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +13 -> 191
    //   181: ldc 45
    //   183: iconst_2
    //   184: ldc_w 289
    //   187: aload_1
    //   188: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload 4
    //   193: astore_1
    //   194: goto -84 -> 110
    //   197: astore 5
    //   199: aconst_null
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_1
    //   204: aload 4
    //   206: astore_3
    //   207: aload_1
    //   208: astore_2
    //   209: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +19 -> 231
    //   215: aload 4
    //   217: astore_3
    //   218: aload_1
    //   219: astore_2
    //   220: ldc 45
    //   222: iconst_2
    //   223: ldc_w 289
    //   226: aload 5
    //   228: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 1123	java/io/ObjectInputStream:close	()V
    //   239: aload 4
    //   241: ifnull +157 -> 398
    //   244: aload 4
    //   246: invokevirtual 1124	java/io/FileInputStream:close	()V
    //   249: aconst_null
    //   250: astore_1
    //   251: goto -141 -> 110
    //   254: astore_1
    //   255: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -19 -> 239
    //   261: ldc 45
    //   263: iconst_2
    //   264: ldc_w 289
    //   267: aload_1
    //   268: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -32 -> 239
    //   274: astore_1
    //   275: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +13 -> 291
    //   281: ldc 45
    //   283: iconst_2
    //   284: ldc_w 289
    //   287: aload_1
    //   288: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: aconst_null
    //   292: astore_1
    //   293: goto -183 -> 110
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_1
    //   300: aconst_null
    //   301: astore_2
    //   302: aload_2
    //   303: ifnull +7 -> 310
    //   306: aload_2
    //   307: invokevirtual 1123	java/io/ObjectInputStream:close	()V
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 1124	java/io/FileInputStream:close	()V
    //   318: aload 4
    //   320: athrow
    //   321: astore_2
    //   322: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq -15 -> 310
    //   328: ldc 45
    //   330: iconst_2
    //   331: ldc_w 289
    //   334: aload_2
    //   335: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: goto -28 -> 310
    //   341: astore_1
    //   342: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq -27 -> 318
    //   348: ldc 45
    //   350: iconst_2
    //   351: ldc_w 289
    //   354: aload_1
    //   355: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -40 -> 318
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_2
    //   365: goto -63 -> 302
    //   368: astore 4
    //   370: aload_3
    //   371: astore_1
    //   372: goto -70 -> 302
    //   375: astore 5
    //   377: aconst_null
    //   378: astore_2
    //   379: aload_1
    //   380: astore 4
    //   382: aload_2
    //   383: astore_1
    //   384: goto -180 -> 204
    //   387: astore 5
    //   389: aload_1
    //   390: astore 4
    //   392: aload 6
    //   394: astore_1
    //   395: goto -191 -> 204
    //   398: aconst_null
    //   399: astore_1
    //   400: goto -290 -> 110
    //   403: aload 4
    //   405: astore_1
    //   406: goto -296 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	PortalManager
    //   40	73	1	localObject1	Object
    //   174	14	1	localIOException1	java.io.IOException
    //   193	58	1	localObject2	Object
    //   254	14	1	localIOException2	java.io.IOException
    //   274	14	1	localIOException3	java.io.IOException
    //   292	23	1	localObject3	Object
    //   341	14	1	localIOException4	java.io.IOException
    //   371	35	1	localObject4	Object
    //   78	75	2	localObject5	Object
    //   154	14	2	localIOException5	java.io.IOException
    //   208	99	2	localObject6	Object
    //   321	14	2	localIOException6	java.io.IOException
    //   364	19	2	localObject7	Object
    //   75	296	3	localObject8	Object
    //   87	158	4	localRedPacketConfig	PortalManager.RedPacketConfig
    //   296	23	4	localObject9	Object
    //   361	1	4	localObject10	Object
    //   368	1	4	localObject11	Object
    //   380	24	4	localObject12	Object
    //   197	30	5	localThrowable1	Throwable
    //   375	1	5	localThrowable2	Throwable
    //   387	1	5	localThrowable3	Throwable
    //   72	321	6	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   94	99	154	java/io/IOException
    //   103	107	174	java/io/IOException
    //   48	57	197	java/lang/Throwable
    //   235	239	254	java/io/IOException
    //   244	249	274	java/io/IOException
    //   48	57	296	finally
    //   306	310	321	java/io/IOException
    //   314	318	341	java/io/IOException
    //   57	74	361	finally
    //   79	89	368	finally
    //   209	215	368	finally
    //   220	231	368	finally
    //   57	74	375	java/lang/Throwable
    //   79	89	387	java/lang/Throwable
  }
  
  protected PortalManager.RedPacketConfig a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    PortalManager.RedPacketConfig localRedPacketConfig1;
    if (QLog.isColorLevel())
    {
      if (paramRedPacketConfig == null) {
        QLog.d("PortalManager", 2, "handleNewConfig");
      }
    }
    else
    {
      PortalManager.RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      localRedPacketConfig1 = localRedPacketConfig2;
      if (localRedPacketConfig2 == null) {
        localRedPacketConfig1 = a();
      }
      if (paramRedPacketConfig == null) {
        break label124;
      }
      a(paramRedPacketConfig, localRedPacketConfig1, false);
      a(paramRedPacketConfig);
    }
    for (;;)
    {
      a(paramRedPacketConfig);
      return paramRedPacketConfig;
      QLog.d("PortalManager", 2, "handleNewConfig, " + paramRedPacketConfig.version + ", " + paramRedPacketConfig.bannerConfigs.size() + ", " + paramRedPacketConfig.portalConfigs.size());
      break;
      label124:
      paramRedPacketConfig = localRedPacketConfig1;
    }
  }
  
  public PortalManager.ResultData a(int paramInt1, int paramInt2)
  {
    if (0 == 0) {}
    for (PortalManager.PortalConfig localPortalConfig = a(paramInt2);; localPortalConfig = null)
    {
      if (localPortalConfig == null) {
        return null;
      }
      PortalManager.ResultData localResultData = new PortalManager.ResultData();
      switch (paramInt1)
      {
      default: 
        return null;
      }
      localResultData.jdField_a_of_type_AndroidGraphicsBitmap = a(localPortalConfig.awardMd5, null);
      localResultData.jdField_a_of_type_JavaLangString = localPortalConfig.addMsg;
      localResultData.h = localPortalConfig.publicId;
      localResultData.g = localPortalConfig.addMsg;
      StringBuilder localStringBuilder = new StringBuilder().append(BaseApplicationImpl.a().getFilesDir()).append(jdField_f_of_type_JavaLangString);
      if (localPortalConfig.logoType == 2) {}
      for (String str = localPortalConfig.starMd5;; str = localPortalConfig.awardMd5)
      {
        localResultData.jdField_c_of_type_JavaLangString = str;
        localResultData.jdField_d_of_type_JavaLangString = (BaseApplicationImpl.a().getFilesDir() + jdField_f_of_type_JavaLangString + localPortalConfig.ctfBgMd5);
        localResultData.jdField_f_of_type_JavaLangString = localPortalConfig.awardMsg;
        localResultData.jdField_e_of_type_JavaLangString = localPortalConfig.awardTitle;
        localResultData.jdField_f_of_type_Int = localPortalConfig.logoType;
        return localResultData;
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    e();
    a(true, 100, 0L, null);
    if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(16)) {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
        break label127;
      }
    }
    label127:
    for (long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime).longValue();; l1 = 10000L)
    {
      a(true, 16, 1000L, Long.valueOf(l1));
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
        QLog.d("PortalManager", 2, "setGrabTimeFinish activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {}
    do
    {
      do
      {
        return;
      } while (paramInt <= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord);
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord = paramInt;
    } while (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6));
    a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
      }
      if (paramInt == 2)
      {
        if ((this.y != 4) || (!paramBoolean))
        {
          if ((this.y == 1) && (!paramBoolean)) {
            return;
          }
          this.y = 1;
        }
      }
      else
      {
        int i1 = this.jdField_a_of_type_ArrayOfInt[paramInt];
        if (i1 == 0)
        {
          i1 = this.jdField_a_of_type_AndroidMediaSoundPool.load(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), jdField_b_of_type_ArrayOfInt[paramInt], 1);
          this.jdField_a_of_type_ArrayOfInt[paramInt] = i1;
          return;
        }
        if (jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {
          if (paramInt == 2) {}
        }
        for (i1 = this.jdField_a_of_type_AndroidMediaSoundPool.play(i1, 1.0F, 1.0F, 0, 0, 1.0F); QLog.isColorLevel(); i1 = -1)
        {
          QLog.d("PortalManager", 2, "playSound, " + paramInt + ", " + this.jdField_a_of_type_ArrayOfInt[paramInt] + ", " + jdField_a_of_type_ArrayOfBoolean[paramInt] + ", " + i1);
          return;
          if (this.N == 0) {
            this.N = this.jdField_a_of_type_AndroidMediaSoundPool.play(i1, 1.0F, 1.0F, 0, -1, 1.0F);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new tuc(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("clickBanner, ");
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
      {
        localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id);
        QLog.i("PortalManager", 2, localObject + ", " + paramBoolean);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag < 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        a(null, 1, false, 0L);
      }
      if (!paramBoolean) {
        break label346;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)) {
        break label310;
      }
      if (paramActivity == null) {
        break label267;
      }
      localObject = paramActivity;
      label143:
      localObject = new Intent((Context)localObject, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).addFlags(67108864);
      if (paramActivity == null) {
        break label274;
      }
      paramActivity.startActivity((Intent)localObject);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060A1", "0X80060A1", 0, 0, "", "", "", "");
      return;
      localObject = "";
      break;
      label267:
      localObject = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      break label143;
      label274:
      paramActivity = BaseActivity.sTopActivity;
      if (paramActivity != null)
      {
        paramActivity.startActivity((Intent)localObject);
      }
      else
      {
        paramActivity = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
        ((Intent)localObject).addFlags(268435456);
        paramActivity.startActivity((Intent)localObject);
        continue;
        label310:
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
        }
      }
    }
    label346:
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060A0", "0X80060A0", 0, 0, "", "", "", "");
  }
  
  public void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (QLog.isColorLevel())) {
      QLog.d("PortalManager", 2, "currentPortal.shareBaseLine = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.shareBaseLine + ", currentPortal.countGrab = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
    }
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.showSharePageTime <= 0L))
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.shareBaseLine > 0) {
        break label130;
      }
      i1 = 100;
      if ((i2 >= i1) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.currentCountGrab != 0)) {
        break label141;
      }
    }
    label130:
    label141:
    do
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.shareBaseLine;
      break;
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.showSharePageTime = NetConnInfoCenter.getServerTimeMillis();
      a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
    } while (paramContext == null);
    Intent localIntent = new Intent(paramContext, HongBaoShareActivity.class);
    localIntent.putExtra("all_counts", this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
    localIntent.putExtra("max_counts", this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord);
    localIntent.putExtra("s_url", a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord));
    paramContext.startActivity(localIntent);
  }
  
  public void a(PortalManager.PortalShower paramPortalShower)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower = null;
  }
  
  public void a(PortalManager.PortalShower paramPortalShower, int paramInt)
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8, paramInt, 0, paramPortalShower).sendToTarget();
  }
  
  public void a(PortalManager.PortalShower paramPortalShower, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower == null) {
      return;
    }
    int i2 = 0;
    int i1 = i2;
    long l3;
    long l1;
    long l2;
    Bitmap localBitmap1;
    Object localObject;
    if (1 == (paramInt & 0x1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.b();
        i1 = i2;
      }
    }
    else
    {
      i2 = i1;
      if (2 == (paramInt & 0x2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
          break label700;
        }
        l3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.version << 30 | this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
        l1 = paramLong;
        if (paramLong == 0L) {
          l1 = NetConnInfoCenter.getServerTimeMillis();
        }
        l2 = l1;
        if (e > 0L) {
          l2 = e + i * (l1 - jdField_f_of_type_Long);
        }
        paramPortalShower = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, null);
        localBitmap1 = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.pendantMd5, "hb_b_logo_path");
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
          break label395;
        }
        localObject = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.topMd5, null);
        paramLong = -1L;
        if (l2 > this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd) {
          paramLong = Math.min(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - l2, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(l3, paramPortalShower, (Bitmap)localObject, localBitmap1, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.rightMsg, paramLong, paramBoolean);
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag >= 2) || (this.jdField_d_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a())) {
          break label714;
        }
        this.jdField_d_of_type_Boolean = true;
        paramInt = 1;
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
      }
    }
    for (;;)
    {
      i2 = paramInt;
      for (;;)
      {
        if (i2 == 0) {
          break label712;
        }
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        return;
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
          break;
        }
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag >= 2) {
          break;
        }
        paramPortalShower = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.bannarMd5, "hb_banner_path");
        i1 = i2;
        if (paramPortalShower == null) {
          break;
        }
        i1 = i2;
        if (!this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(paramPortalShower, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
        i1 = 1;
        break;
        label395:
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.grabMsg;
          String str1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.actEndWording;
          String str2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.nextActTime;
          String str3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countDownTips;
          Bitmap localBitmap2 = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.leftMd5, null);
          l1 = -1L;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime > 0L)
          {
            l1 = l2 - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime;
            if (l1 <= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime)
            {
              paramLong = l1;
              if (l1 > 0L) {}
            }
            else
            {
              paramLong = 0L;
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(l3, paramPortalShower, localBitmap2, localBitmap1, (String)localObject, str1, str2, str3, paramLong, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
            i2 = i1;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime > 0L) {
              break;
            }
            i2 = i1;
            if (!this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.b()) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime = l2;
            i2 = 1;
            break;
            paramLong = l1;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime == 0L)
            {
              paramLong = l1;
              if (l2 >= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime) {
                paramLong = 0L;
              }
            }
          }
        }
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 3)
        {
          paramPortalShower = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, null);
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(paramPortalShower))
          {
            i2 = 1;
            this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
        continue;
        label700:
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a();
        i2 = i1;
      }
      label712:
      break;
      label714:
      paramInt = i1;
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    boolean bool;
    HttpNetReq localHttpNetReq;
    Object localObject1;
    HashMap localHashMap;
    int i1;
    PortalManager.PortalConfig localPortalConfig;
    if (paramNetResp.jdField_e_of_type_Int == 0)
    {
      bool = true;
      localHttpNetReq = (HttpNetReq)paramNetResp.a;
      localObject1 = new File(localHttpNetReq.b);
      Object localObject2 = localHttpNetReq.a();
      localHashMap = new HashMap();
      if ((localObject2 == null) || (!(localObject2 instanceof String[]))) {
        break label437;
      }
      localObject2 = (String[])localObject2;
      i1 = Integer.valueOf(localObject2[0]).intValue();
      localObject2 = localObject2[1];
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject2)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject2);
      }
      if (bool)
      {
        if (!((String)localObject2).equals(PortalUtils.a(((File)localObject1).getAbsolutePath()))) {
          break label417;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
        localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        if ((localObject1 == null) || (((PortalManager.BannerConfig)localObject1).id != i1)) {
          break label391;
        }
        a((String)localObject2, "hb_banner_path");
        a(true, 5, 0L, null);
        label176:
        if (QLog.isColorLevel()) {
          QLog.i("PortalManager", 2, "onRespMSG_UPDATE_UI, md5 = " + (String)localObject2);
        }
      }
      label209:
      if (QLog.isColorLevel()) {
        QLog.i("PortalManager", 2, "onResp" + localHttpNetReq.jdField_a_of_type_JavaLangString + ", " + paramNetResp.jdField_e_of_type_Int + ", " + paramNetResp.jdField_f_of_type_Int + ", " + (String)localHashMap.get("param_checkMd5Fail"));
      }
      i1 = 0;
      if (bool) {
        break label446;
      }
      localHashMap.put("param_Url", localHttpNetReq.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.jdField_e_of_type_Int));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.jdField_f_of_type_Int));
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        paramNetResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()).a(paramNetResp, "RedPacketPicDownload", bool, 0L, 0L, localHashMap, "", false);
      }
      return;
      bool = false;
      break;
      label391:
      if ((localPortalConfig == null) || (localPortalConfig.id != i1)) {
        break label176;
      }
      a(true, 5, 0L, null);
      break label176;
      label417:
      ((File)localObject1).delete();
      localHashMap.put("param_checkMd5Fail", "checkMd5Fail");
      break label209;
      label437:
      ((File)localObject1).delete();
      break label209;
      label446:
      if (new Random().nextInt(10000) == 1000)
      {
        localHashMap.put("param_Url", localHttpNetReq.jdField_a_of_type_JavaLangString);
        localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.jdField_e_of_type_Int));
        i1 = 1;
      }
    }
  }
  
  public void a(submsgtype0x78.MsgBody paramMsgBody)
  {
    boolean bool = paramMsgBody.uint32_version.has();
    int i1 = paramMsgBody.uint32_version.get();
    int i2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handlePush, " + bool + ", " + i2 + ", " + i1);
    }
    if ((i1 != i2) && (bool)) {
      RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i2);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.jdField_c_of_type_Boolean) {
      try
      {
        if (!this.jdField_c_of_type_Boolean) {
          if (!paramBoolean) {
            break label46;
          }
        }
        label46:
        for (Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;; localHandler = this.jdField_a_of_type_AndroidOsHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    long l1;
    long l3;
    if (e > 0L)
    {
      l1 = e;
      l3 = i;
      l2 = (l2 - jdField_f_of_type_Long) * l3 + l1;
    }
    for (;;)
    {
      boolean bool = NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder(128);
        ((StringBuilder)localObject2).append("grabHongbao").append(", ").append(bool);
        if (localObject1 != null) {
          ((StringBuilder)localObject2).append(", ").append(((PortalManager.PortalConfig)localObject1).id).append(", ").append(((PortalManager.PortalConfig)localObject1).type).append(", ").append(((PortalManager.PortalConfig)localObject1).useFlag).append(", ").append(((PortalManager.PortalConfig)localObject1).useTime).append(", ").append(l2).append(((PortalManager.PortalConfig)localObject1).hotUrl);
        }
        QLog.e("PortalManager", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 == null) || (((PortalManager.PortalConfig)localObject1).type == 1)) {}
      label244:
      do
      {
        return false;
        localObject2 = (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
        if (localObject2 != null) {
          break;
        }
        localObject2 = new ArrayList(60);
        ((ArrayList)localObject2).add(Long.valueOf(l2));
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id, localObject2);
        if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 1) {
          k();
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        i1 = localPortalConfig.countGrab + 1;
        localPortalConfig.countGrab = i1;
        ((PortalManager.PortalConfig)localObject2).currentCountGrab = i1;
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
          a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        }
        if (((PortalManager.PortalConfig)localObject1).type != 3) {
          break label409;
        }
      } while (((PortalManager.PortalConfig)localObject1).useFlag >= 4);
      int i1 = 1;
      for (;;)
      {
        if (i1 != 0)
        {
          localObject1 = new PortalManager.ResultData();
          ((PortalManager.ResultData)localObject1).b = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.hotUrl;
          ((PortalManager.ResultData)localObject1).jdField_d_of_type_Int = 2;
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(1, (PortalManager.ResultData)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 4;
          a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return false;
          ((ArrayList)localObject2).add(Long.valueOf(l2));
          break label244;
          label409:
          if (!((PortalManager.PortalConfig)localObject1).isOver(l2)) {
            break label736;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.hotUrl)) || (((PortalManager.PortalConfig)localObject1).useFlag >= 4)) {
            break;
          }
          i1 = 1;
          continue;
        }
        if (!bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower.a(false, "网络不给力，请检查网络是否可用！", null);
          return false;
        }
        if (this.g >= 0L)
        {
          l3 = 30000L;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GetNewPackReq_DelayTime");
          l1 = l3;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
          try
          {
            long l4 = Long.valueOf((String)localObject1).longValue();
            l1 = l3;
            if (l4 > 30000L)
            {
              l1 = l3;
              if (l4 < 300000L) {
                l1 = 1000L * l4;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("PortalManager", 1, (String)localObject1, localException);
              l1 = 30000L;
            }
          }
          if (Math.abs(l2 - this.g) < l1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager", 2, "grabHongbao, " + l2 + ", " + this.g + "," + l1);
            }
            return true;
          }
        }
        else if ((this.g < 0L) && (this.g + l2 < jdField_a_of_type_Long))
        {
          if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(13)) {
            a(true, 13, (1200.0D + Math.random() * 2300.0D), null);
          }
          return true;
        }
        this.g = l2;
        if (jdField_a_of_type_Boolean) {
          RedPacketServlet.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1001);
        }
        for (;;)
        {
          return true;
          RedPacketServlet.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
        }
        label736:
        i1 = 0;
      }
    }
  }
  
  protected boolean a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "saveRedPacketConfig");
    }
    if (paramRedPacketConfig == null) {
      return false;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramRedPacketConfig);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return FileUtils.a(new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "red_packet_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
    catch (Throwable paramRedPacketConfig)
    {
      paramRedPacketConfig.printStackTrace();
    }
    return false;
  }
  
  public long[] a()
  {
    this.jdField_b_of_type_Boolean = true;
    PortalManager.PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (e > 0L)
    {
      long l2 = e;
      long l3 = i;
      l1 = (l1 - jdField_f_of_type_Long) * l3 + l2;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setGrabStartTime");
        if (localPortalConfig != null) {
          localStringBuilder.append(", ").append(localPortalConfig.id).append(", ").append(localPortalConfig.type).append(", ").append(localPortalConfig.useTime).append(", ").append(localPortalConfig.countTime).append(", ").append(l1).append(", ").append(localPortalConfig.realEnd);
        }
        QLog.d("PortalManager", 2, localStringBuilder.toString());
      }
      if ((localPortalConfig == null) || (localPortalConfig.type != 2) || ((localPortalConfig.useTime == 0L) && (localPortalConfig.countTime + l1 >= localPortalConfig.realEnd)) || ((localPortalConfig.useTime > 0L) && (localPortalConfig.useTime + localPortalConfig.countTime >= localPortalConfig.realEnd)) || ((localPortalConfig.useTime > 0L) && (localPortalConfig.useTime + localPortalConfig.countTime <= l1)) || (l1 > localPortalConfig.realEnd)) {
        return null;
      }
      if (localPortalConfig.useTime == 0L)
      {
        localPortalConfig.useTime = l1;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060A2 ", "0X80060A2 ", 0, 0, "", "", l1 + "", "");
      }
      l1 = localPortalConfig.countTime - l1 + localPortalConfig.useTime;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(12);
      a(true, 12, l1, Long.valueOf(localPortalConfig.useTime));
      return new long[] { localPortalConfig.countTime, l1 };
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
    }
    return -1;
  }
  
  public void b()
  {
    a(true, 100, 0L, null);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2);
  }
  
  public int c()
  {
    PortalManager.RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    PortalManager.RedPacketConfig localRedPacketConfig1 = localRedPacketConfig2;
    if (localRedPacketConfig2 == null) {
      localRedPacketConfig1 = a();
    }
    return localRedPacketConfig1.version;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "clearData");
    }
    File localFile = new File(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir(), "red_packet_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if ((localFile.delete()) && (!localFile.delete()) && (localFile.delete())) {}
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "canRefreshMessage : activityEndTime = " + this.j);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {}
    do
    {
      do
      {
        long l1;
        long l2;
        do
        {
          return false;
          if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
            break;
          }
          l1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realBegin;
          l2 = NetConnInfoCenter.getServerTimeMillis();
        } while ((l1 - l2 <= 600000L) || (l2 - this.j < 300000L));
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null));
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
        break;
      }
    } while (NetConnInfoCenter.getServerTimeMillis() - this.j < 300000L);
    return true;
    return true;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: lconst_0
    //   3: putstatic 916	com/tencent/mobileqq/portal/PortalManager:e	J
    //   6: new 1507	java/io/BufferedReader
    //   9: dup
    //   10: new 1509	java/io/InputStreamReader
    //   13: dup
    //   14: new 1106	java/io/FileInputStream
    //   17: dup
    //   18: ldc_w 1511
    //   21: invokespecial 1512	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 1513	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: invokespecial 1516	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 1519	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +185 -> 222
    //   40: aload_1
    //   41: ldc_w 1521
    //   44: invokevirtual 1525	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: astore_1
    //   48: aload_1
    //   49: iconst_0
    //   50: aaload
    //   51: invokestatic 514	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)J
    //   54: putstatic 916	com/tencent/mobileqq/portal/PortalManager:e	J
    //   57: aload_1
    //   58: iconst_1
    //   59: aaload
    //   60: invokestatic 620	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   63: i2l
    //   64: putstatic 918	com/tencent/mobileqq/portal/PortalManager:i	J
    //   67: getstatic 918	com/tencent/mobileqq/portal/PortalManager:i	J
    //   70: lconst_1
    //   71: lcmp
    //   72: ifge +7 -> 79
    //   75: lconst_1
    //   76: putstatic 918	com/tencent/mobileqq/portal/PortalManager:i	J
    //   79: getstatic 916	com/tencent/mobileqq/portal/PortalManager:e	J
    //   82: lconst_0
    //   83: lcmp
    //   84: ifeq +9 -> 93
    //   87: invokestatic 1026	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   90: putstatic 920	com/tencent/mobileqq/portal/PortalManager:jdField_f_of_type_Long	J
    //   93: aload_0
    //   94: getfield 914	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   97: getfield 551	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:portalConfigs	Ljava/util/ArrayList;
    //   100: invokevirtual 754	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   103: astore_1
    //   104: aload_1
    //   105: invokeinterface 759 1 0
    //   110: ifeq +54 -> 164
    //   113: aload_1
    //   114: invokeinterface 762 1 0
    //   119: checkcast 541	com/tencent/mobileqq/portal/PortalManager$PortalConfig
    //   122: astore_3
    //   123: aload_3
    //   124: iconst_0
    //   125: putfield 956	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useFlag	I
    //   128: aload_3
    //   129: lconst_0
    //   130: putfield 1053	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   133: aload_3
    //   134: iconst_0
    //   135: putfield 1056	com/tencent/mobileqq/portal/PortalManager$PortalConfig:countGrab	I
    //   138: aload_3
    //   139: iconst_0
    //   140: putfield 1059	com/tencent/mobileqq/portal/PortalManager$PortalConfig:continuousRecord	I
    //   143: goto -39 -> 104
    //   146: astore_3
    //   147: aload_2
    //   148: astore_1
    //   149: aload_3
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 1492	java/lang/Throwable:printStackTrace	()V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 1526	java/io/BufferedReader:close	()V
    //   163: return
    //   164: aload_0
    //   165: getfield 914	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   168: getfield 502	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:bannerConfigs	Ljava/util/ArrayList;
    //   171: invokevirtual 754	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   174: astore_1
    //   175: aload_1
    //   176: invokeinterface 759 1 0
    //   181: ifeq +30 -> 211
    //   184: aload_1
    //   185: invokeinterface 762 1 0
    //   190: checkcast 497	com/tencent/mobileqq/portal/PortalManager$BannerConfig
    //   193: iconst_0
    //   194: putfield 1060	com/tencent/mobileqq/portal/PortalManager$BannerConfig:useFlag	I
    //   197: goto -22 -> 175
    //   200: astore_1
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 1526	java/io/BufferedReader:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: aload_0
    //   212: iconst_1
    //   213: bipush 100
    //   215: ldc2_w 947
    //   218: aconst_null
    //   219: invokevirtual 951	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   222: aload_2
    //   223: ifnull -60 -> 163
    //   226: aload_2
    //   227: invokevirtual 1526	java/io/BufferedReader:close	()V
    //   230: return
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 1492	java/lang/Throwable:printStackTrace	()V
    //   236: return
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 1492	java/lang/Throwable:printStackTrace	()V
    //   242: return
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 1492	java/lang/Throwable:printStackTrace	()V
    //   248: goto -39 -> 209
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_2
    //   254: goto -53 -> 201
    //   257: astore_3
    //   258: aload_1
    //   259: astore_2
    //   260: aload_3
    //   261: astore_1
    //   262: goto -61 -> 201
    //   265: astore_2
    //   266: goto -115 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	PortalManager
    //   1	184	1	localObject1	Object
    //   200	10	1	localObject2	Object
    //   231	2	1	localThrowable1	Throwable
    //   237	2	1	localThrowable2	Throwable
    //   251	8	1	localObject3	Object
    //   261	1	1	localObject4	Object
    //   30	197	2	localObject5	Object
    //   243	2	2	localThrowable3	Throwable
    //   253	7	2	localObject6	Object
    //   265	1	2	localThrowable4	Throwable
    //   122	17	3	localPortalConfig	PortalManager.PortalConfig
    //   146	4	3	localThrowable5	Throwable
    //   257	4	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   31	36	146	java/lang/Throwable
    //   40	79	146	java/lang/Throwable
    //   79	93	146	java/lang/Throwable
    //   93	104	146	java/lang/Throwable
    //   104	143	146	java/lang/Throwable
    //   164	175	146	java/lang/Throwable
    //   175	197	146	java/lang/Throwable
    //   211	222	146	java/lang/Throwable
    //   31	36	200	finally
    //   40	79	200	finally
    //   79	93	200	finally
    //   93	104	200	finally
    //   104	143	200	finally
    //   164	175	200	finally
    //   175	197	200	finally
    //   211	222	200	finally
    //   226	230	231	java/lang/Throwable
    //   159	163	237	java/lang/Throwable
    //   205	209	243	java/lang/Throwable
    //   6	31	251	finally
    //   151	155	257	finally
    //   6	31	265	java/lang/Throwable
  }
  
  public void e()
  {
    if (this.y == 4) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "stopCountDown, " + this.N + ", " + this.y);
    }
    if (this.N != 0) {}
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
        this.jdField_a_of_type_AndroidMediaSoundPool.pause(this.N);
      }
      this.N = 0;
      this.y = 4;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void f()
  {
    ((Vibrator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("vibrator")).vibrate(300L);
  }
  
  public void g()
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
    {
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
      if (localArrayList != null) {
        break label138;
      }
      localArrayList = new ArrayList(60);
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id, localArrayList);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(15)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 600000L);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800609E", "0X800609E", 0, 0, "", "", "", "");
      }
      return;
      label138:
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    }
  }
  
  public void h()
  {
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (!this.jdField_b_of_type_Boolean))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
        break label66;
      }
    }
    label66:
    for (String str = "1";; str = "2")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800609C", "0X800609C", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handleMessage " + paramMessage.what + ", " + paramMessage.obj);
    }
    int i2 = 0;
    boolean bool = false;
    long l1 = 0L;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig == null) && (NetConnInfoCenter.servetTimeSecondInterv != 0L))
      {
        a();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) {
          return true;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
        Object localObject2 = (PortalManager.RedPacketConfig)paramMessage.obj;
        bool = a((PortalManager.RedPacketConfig)localObject2, (PortalManager.RedPacketConfig)localObject1, true);
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig = ((PortalManager.RedPacketConfig)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) {
          a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.grebInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportActiveInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportNormalInterval);
        }
        l1 = NetConnInfoCenter.getServerTimeMillis();
        a(l1);
        i2 = bool;
        if (paramMessage.what == 5) {}
        for (bool = true;; bool = false)
        {
          a(null, 3, bool, l1);
          if (i2 == 0) {
            break;
          }
          a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          break;
        }
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))
        {
          a((PortalManager.RedPacketConfig)paramMessage.obj);
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          continue;
          localObject1 = (PortalManager.PortalShower)paramMessage.obj;
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower = ((PortalManager.PortalShower)localObject1);
          a((PortalManager.PortalShower)localObject1, paramMessage.arg1, false, 0L);
          continue;
          a();
          if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null))
          {
            QLog.d("PortalManager", 2, "MSG_GRAB_TIMEOUT | activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
            continue;
            this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.L, this.M, d(), ((Long)paramMessage.obj).longValue(), false));
            this.M = 0;
            this.L = 0;
            this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
            if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null))
            {
              QLog.d("PortalManager", 2, "MSG_GRAB_TIMEOUT_REPORT | activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower != null)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {}
                for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.emptyMsg;; paramMessage = "没中红包，继续刷")
                {
                  ((PortalManager.PortalShower)localObject1).a(false, paramMessage, null);
                  break;
                }
                if ((paramMessage.obj != null) && ((paramMessage.obj instanceof ArrayList)))
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  int i1 = paramMessage.arg1;
                  localObject2 = (ArrayList)paramMessage.obj;
                  if (paramMessage.arg2 == 1) {}
                  for (bool = true;; bool = false)
                  {
                    RedPacketServlet.a((AppRuntime)localObject1, i1, (ArrayList)localObject2, bool, paramMessage.getData());
                    break;
                  }
                  this.jdField_a_of_type_AndroidOsHandler.post(new PortalManager.reportRunnable(this, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0, 0L, false));
                  this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
                  this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, 600000L);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void i()
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
        break label59;
      }
    }
    label59:
    for (String str = "1";; str = "2")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800609D ", "0X800609D ", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public void j()
  {
    boolean bool = false;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "reportShareToServer : uin is null!");
      }
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localSharedPreferences != null) {
        bool = localSharedPreferences.getBoolean(str, false);
      }
      if (!bool) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PortalManager", 2, "reportShareToServer | isReported : " + bool);
    return;
    ThreadManager.b().post(new tuh(this, str, localSharedPreferences));
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 45
    //   10: iconst_2
    //   11: ldc_w 1639
    //   14: invokestatic 561	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 1068	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_Boolean	Z
    //   22: aload_0
    //   23: getfield 934	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig	Lcom/tencent/mobileqq/portal/PortalManager$PortalConfig;
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 188	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   31: invokevirtual 1079	android/support/v4/util/SparseArrayCompat:size	()I
    //   34: ifle +60 -> 94
    //   37: aload_1
    //   38: getfield 1053	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   41: lconst_0
    //   42: lcmp
    //   43: ifle +51 -> 94
    //   46: aload_0
    //   47: getfield 240	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   50: new 1578	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   53: dup
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 188	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   59: invokevirtual 1582	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   62: iconst_1
    //   63: aload_0
    //   64: getfield 1584	com/tencent/mobileqq/portal/PortalManager:L	I
    //   67: aload_0
    //   68: getfield 1586	com/tencent/mobileqq/portal/PortalManager:M	I
    //   71: aload_0
    //   72: invokespecial 1588	com/tencent/mobileqq/portal/PortalManager:d	()I
    //   75: aload_1
    //   76: getfield 1053	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   79: iconst_1
    //   80: invokespecial 1591	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   83: invokevirtual 1218	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 188	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   91: invokevirtual 1594	android/support/v4/util/SparseArrayCompat:clear	()V
    //   94: aload_0
    //   95: getfield 207	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   98: invokevirtual 1079	android/support/v4/util/SparseArrayCompat:size	()I
    //   101: ifle +39 -> 140
    //   104: aload_0
    //   105: getfield 240	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   108: new 1578	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   111: dup
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 207	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   117: invokevirtual 1582	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   120: iconst_2
    //   121: iconst_0
    //   122: iconst_0
    //   123: iconst_0
    //   124: lconst_0
    //   125: iconst_1
    //   126: invokespecial 1591	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   129: invokevirtual 1218	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   132: pop
    //   133: aload_0
    //   134: getfield 207	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat	Landroid/support/v4/util/SparseArrayCompat;
    //   137: invokevirtual 1594	android/support/v4/util/SparseArrayCompat:clear	()V
    //   140: aload_0
    //   141: getfield 240	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   144: iconst_1
    //   145: invokevirtual 923	android/os/Handler:removeMessages	(I)V
    //   148: aload_0
    //   149: getfield 240	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   152: bipush 15
    //   154: invokevirtual 923	android/os/Handler:removeMessages	(I)V
    //   157: aload_0
    //   158: getfield 247	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: aconst_null
    //   162: invokevirtual 1642	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   165: aload_0
    //   166: getfield 221	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: aload_0
    //   170: invokevirtual 1645	com/tencent/mobileqq/app/QQAppInterface:unRegistObserver	(Lmqq/observer/BusinessObserver;)V
    //   173: aload_0
    //   174: getfield 221	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   177: aload_0
    //   178: getfield 219	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   181: invokevirtual 1647	com/tencent/mobileqq/app/QQAppInterface:b	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   184: aload_0
    //   185: invokevirtual 1167	com/tencent/mobileqq/portal/PortalManager:e	()V
    //   188: aload_0
    //   189: getfield 221	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   192: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   195: aload_0
    //   196: getfield 260	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_Tui	Ltui;
    //   199: invokevirtual 1651	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   202: aload_0
    //   203: getfield 1183	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   206: ifnull +15 -> 221
    //   209: aload_0
    //   210: getfield 1183	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   213: invokevirtual 1654	android/media/SoundPool:release	()V
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 1183	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   221: aload_0
    //   222: monitorexit
    //   223: return
    //   224: astore_1
    //   225: ldc 45
    //   227: iconst_1
    //   228: ldc_w 1639
    //   231: aload_1
    //   232: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: goto -33 -> 202
    //   238: astore_1
    //   239: aload_0
    //   240: monitorexit
    //   241: aload_1
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	PortalManager
    //   26	50	1	localPortalConfig	PortalManager.PortalConfig
    //   224	8	1	localException	Exception
    //   238	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   188	202	224	java/lang/Exception
    //   2	17	238	finally
    //   17	94	238	finally
    //   94	140	238	finally
    //   140	188	238	finally
    //   188	202	238	finally
    //   202	221	238	finally
    //   225	235	238	finally
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if ((i1 >= 4) || (this.jdField_a_of_type_ArrayOfInt[i1] == paramInt1)) {
      if (i1 != 4) {
        break label36;
      }
    }
    label36:
    while (paramInt2 != 0)
    {
      return;
      i1 += 1;
      break;
    }
    jdField_a_of_type_ArrayOfBoolean[i1] = true;
    a(i1, true);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = null;
    int i1 = -1;
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onReceive, " + paramInt + ", " + paramBoolean + ", " + paramBundle);
    }
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        PortalManager.PortalConfig localPortalConfig;
        do
        {
          return;
          localObject = paramBundle.getString("k_url");
          i2 = paramBundle.getInt("k_id", -1);
          paramInt = paramBundle.getInt("k_code", -1);
          int i3 = paramBundle.getInt("k_money", -1);
          int i4 = paramBundle.getInt("k_type", -1);
          boolean bool = paramBundle.getBoolean("k_s_follow", true);
          if (paramBoolean) {
            this.g = (-this.g);
          }
          if (paramInt > 0) {
            this.L += 1;
          }
          if ((!paramBoolean) || (paramInt != 0)) {
            break;
          }
          this.M += 1;
          switch (i4)
          {
          default: 
            this.M -= 1;
            this.L += 1;
            paramBoolean = false;
            paramInt = i1;
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager", 2, "onReceive cmd = CMD_RESULT, portId = " + i2 + ", url = " + (String)localObject + ", showType = " + paramInt + ", money = " + i3);
            }
            localPortalConfig = a(i2);
            if (localPortalConfig == null) {
              paramBoolean = false;
            }
            paramBundle = str;
            if (paramBoolean)
            {
              paramBundle = str;
              if (localPortalConfig != null) {
                paramBundle = new PortalManager.ResultData(null, localPortalConfig.awardTitle, localPortalConfig.awardMsg, i2, paramInt, (String)localObject, i3, bool);
              }
            }
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower == null);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalShower;
        if (localPortalConfig != null) {}
        for (str = localPortalConfig.emptyMsg;; str = "没中红包，继续刷")
        {
          ((PortalManager.PortalShower)localObject).a(paramBoolean, str, paramBundle);
          return;
          paramInt = 0;
          break;
          paramInt = 1;
          break;
          paramBoolean = false;
          paramInt = i1;
          break;
        }
        paramInt = paramBundle.getInt("k_code", 2);
        if (paramInt == 3)
        {
          handleMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, new PortalManager.RedPacketConfig()));
          return;
        }
        if (paramInt == 4)
        {
          paramBundle = (PortalManager.RedPacketConfig)paramBundle.getSerializable("k_cache");
          handleMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, paramBundle));
          return;
        }
      } while ((!paramBoolean) || (paramInt == 2));
      return;
    }
    paramInt = paramBundle.getInt("k_code", -1);
    i1 = paramBundle.getInt("k_r_type");
    int i2 = paramBundle.getInt("key_seq");
    if ((!paramBoolean) || (paramInt != 0))
    {
      a(i1, i2, null, paramInt, null);
      return;
    }
    a(i1, paramBundle.getString("k_result"), i2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\PortalManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */