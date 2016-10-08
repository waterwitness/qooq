package com.tencent.mobileqq.olympic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.data.OlympicPredownInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.WeakReferenceHandler;
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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.oidb.olympic.torch_transfer.TorchLimitInfo;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;
import tencent.im.oidb.olympic.torch_transfer.TorcherRankInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;
import tqx;
import tqy;
import tqz;
import tra;
import trb;
import trc;
import trd;
import tre;
import trf;
import trg;
import trh;
import tri;
import trj;
import trk;

public class OlympicManager
  implements SoundPool.OnLoadCompleteListener, Handler.Callback, Manager, BusinessObserver
{
  public static final int a = 0;
  public static final long a = 86400000L;
  public static Bitmap a;
  public static Pair a;
  public static final String a = "OlympicManager";
  private static Comparator jdField_a_of_type_JavaUtilComparator = new tqy();
  static Map jdField_a_of_type_JavaUtilMap = new HashMap(8);
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "olympic_shuayishua_config";
  private static final int[] jdField_b_of_type_ArrayOfInt;
  public static final int c = 2;
  public static long c = 0L;
  private static ShuayishuaConfig jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
  public static final String c = "in_breath_procedure";
  public static final int d = 3;
  public static long d = 0L;
  public static final String d = "breath_real_begin_time";
  public static final int e = 1;
  public static long e = 0L;
  public static final String e = "breath_time_config_type";
  public static final int f = 2;
  private static final long jdField_f_of_type_Long = 60000L;
  public static final String f = "breath_days_config_type";
  public static final int g = 3;
  private static final long jdField_g_of_type_Long = 300000L;
  public static final String g = "breath_remind_type_value";
  static final int jdField_h_of_type_Int = 0;
  private static final long jdField_h_of_type_Long = 900000L;
  public static final String h = "olympic_torchinfo";
  static final int jdField_i_of_type_Int = 1;
  public static final int j = 0;
  public static final int k = 1;
  public static final String k = "ol_icon_path";
  public static final int l = 600000;
  public static final String l = "ol_left_logo_path";
  private static final int m = 2;
  public static final String m = "ol_torch_path";
  private static final int n = 3;
  public static final String n = "ol_shuayishua_bg";
  private static final int o = 4;
  public static final String o = "olympic_entrance_setting";
  private static final int p = 5;
  public static final String p = "olympic_flag_setting";
  private static final int q = 6;
  public static final String q = "olympic_atend_flag";
  private static final int r = 7;
  private static final int s = 8;
  private static final int t = 9;
  private static final int u = 10;
  private static final int v = 11;
  private static final int w = 12;
  private int A;
  private int B;
  private int C;
  private int D = (int)(Math.random() * 5.0D + 5.0D);
  private int E;
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool;
  private Handler jdField_a_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(1);
  public QQAppInterface a;
  private OlyimpicConfig jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig;
  public OlympicActConfig a;
  private OlympicDPC jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
  public OlympicListener a;
  private OlympicObserver jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver = new trj(this);
  private OlympicResources.DownloadListener jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources$DownloadListener = new tqz(this);
  private OlympicResources jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources;
  private OlympicTorchManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager;
  private ShuayishuaConfig jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
  private TorchInfo jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = null;
  List jdField_a_of_type_JavaUtilList;
  public final byte[] a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 0, 0 };
  private final boolean[] jdField_a_of_type_ArrayOfBoolean = { 0, 0, 0 };
  long jdField_b_of_type_Long = 0L;
  private Handler jdField_b_of_type_AndroidOsHandler;
  SparseArrayCompat jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(100);
  private ShuayishuaConfig jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
  boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  boolean jdField_c_of_type_Boolean = false;
  private byte[] jdField_c_of_type_ArrayOfByte = new byte[0];
  boolean jdField_d_of_type_Boolean = false;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private boolean jdField_e_of_type_Boolean;
  private byte[] jdField_e_of_type_ArrayOfByte;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_i_of_type_Long;
  public String i;
  private long j = 2500L;
  public String j;
  private long k = 180000L;
  private long l = 180000L;
  private int x = -1;
  private int y;
  private int z = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_ArrayOfInt = new int[] { 2131165209, 2131165208, 2131165207 };
    jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig = new ShuayishuaConfig();
  }
  
  public OlympicManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[0];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources = new OlympicResources(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources$DownloadListener);
    paramQQAppInterface.registObserver(this);
    ThreadManager.a(new tqx(this), 5, null, false);
    if (QLog.isColorLevel()) {
      QLog.e("OlympicManager", 2, "OlympicManager constructor ,mDebugUseLocalTime = " + this.jdField_b_of_type_Boolean + ",mUiHandler = " + this.jdField_a_of_type_AndroidOsHandler);
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, BitmapFactory.Options paramOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "getBitmap ,resMD5 = " + paramString1 + ",defaultPath = " + paramString2);
    }
    String str2 = OlympicResources.a();
    for (;;)
    {
      Object localObject;
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          return a(paramString2, true);
        }
        str1 = "olympic_" + paramString1;
        Bitmap localBitmap = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str1);
        localObject = localBitmap;
        if (localBitmap != null) {
          break label264;
        }
        localObject = localBitmap;
      }
      catch (Throwable paramString2)
      {
        String str1;
        localObject = null;
        continue;
      }
      try
      {
        paramString1 = BitmapFactory.decodeFile(str2 + paramString1, paramOptions);
        if (paramString1 != null)
        {
          localObject = paramString1;
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str1, paramString1);
          return paramString1;
        }
      }
      catch (Throwable paramString2)
      {
        paramString1 = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("OlympicManager", 2, "", paramString2);
          paramString1 = (String)localObject;
        }
        localObject = paramString1;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicManager", 2, "getBitmap ,result = " + paramString1);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        if (!QLog.isColorLevel()) {
          break label266;
        }
        QLog.e("OlympicManager", 2, "getBitmap Exception ", paramString1);
      }
      catch (OutOfMemoryError paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OlympicManager", 2, "getBitmap OOM ", paramString1);
        }
        paramString1 = null;
        continue;
        localObject = paramString1;
        paramString1 = a(paramString2, true);
        continue;
      }
      label264:
      return (Bitmap)localObject;
      label266:
      paramString1 = null;
    }
  }
  
  private static Bitmap a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("OlympicManager", 2, "getDefaultIconBitmap path = " + paramString + ",needCache = " + paramBoolean);
    }
    try
    {
      localObject = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("olympic_" + paramString);
      if (localObject != null) {
        return (Bitmap)localObject;
      }
      i1 = 0;
      if (TextUtils.isEmpty(paramString)) {
        break label190;
      }
      if (!"ol_icon_path".equals(paramString)) {
        break label175;
      }
      i1 = 2130840556;
    }
    catch (OutOfMemoryError paramString)
    {
      boolean bool;
      do
      {
        int i1;
        Bitmap localBitmap;
        if (QLog.isColorLevel()) {
          QLog.e("OlympicManager", 2, "getDefaultIconBitmap OOM ", paramString);
        }
        return null;
        bool = "ol_torch_path".equals(paramString);
      } while (bool);
      return null;
      return null;
    }
    catch (Exception paramString)
    {
      if (!QLog.isColorLevel()) {
        break label209;
      }
      QLog.e("OlympicManager", 2, "getDefaultIconBitmap exception ", paramString);
      localObject = null;
    }
    localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i1);
    Object localObject = localBitmap;
    if (localBitmap != null)
    {
      localObject = localBitmap;
      if (paramBoolean)
      {
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("olympic_" + paramString, localBitmap);
        return localBitmap;
      }
    }
    label175:
    label190:
    label209:
    return (Bitmap)localObject;
  }
  
  protected static OlyimpicConfig a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("OlympicManager", 2, "parseConfig OlyimpicConfig.xmlConfigContent=" + paramString);
      QLog.i("OlympicManager", 2, "parseConfig OlyimpicConfig.version=" + paramInt + ",diffTimes=" + paramArrayList);
    }
    Object localObject1 = Xml.newPullParser();
    OlyimpicConfig localOlyimpicConfig = new OlyimpicConfig();
    localOlyimpicConfig.version = paramInt;
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
            break label1122;
          }
          if (paramInt != 2) {
            break label301;
          }
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (!((String)localObject2).equalsIgnoreCase("Common")) {
            break label311;
          }
          paramInt = ((XmlPullParser)localObject1).next();
          if (paramInt == 1) {
            break label301;
          }
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (paramInt != 2) {
            break;
          }
          if (((String)localObject2).equalsIgnoreCase("GrabReqInterval"))
          {
            localOlyimpicConfig.grabInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            paramInt = ((XmlPullParser)localObject1).next();
            continue;
          }
          if (((String)localObject2).equalsIgnoreCase("ReportActiveInterval"))
          {
            localOlyimpicConfig.reportActiveInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            continue;
          }
          if (!((String)localObject2).equalsIgnoreCase("ReportNormalInterval")) {
            continue;
          }
        }
        catch (Exception paramArrayList)
        {
          if (QLog.isColorLevel()) {
            QLog.e("OlympicManager", 2, paramString, paramArrayList);
          }
          return null;
        }
        localOlyimpicConfig.reportNormalInterval = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
      }
    } while ((paramInt != 3) || (!"Common".equals(localObject2)));
    label301:
    label311:
    ArrayList localArrayList;
    label386:
    String str;
    for (;;)
    {
      paramInt = ((XmlPullParser)localObject1).next();
      break;
      if (((String)localObject2).equalsIgnoreCase("ConfigId"))
      {
        localOlyimpicConfig.id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
      else if (((String)localObject2).equalsIgnoreCase("Activity"))
      {
        localObject2 = new ShuayishuaConfig();
        localArrayList = new ArrayList(2);
        ((ShuayishuaConfig)localObject2).grabWordingList = localArrayList;
        paramInt = ((XmlPullParser)localObject1).next();
        if (paramInt == 1) {
          break label537;
        }
        str = ((XmlPullParser)localObject1).getName();
        if ((paramInt != 3) || (!str.equalsIgnoreCase("Activity"))) {
          break label496;
        }
        if (((ShuayishuaConfig)localObject2).realEnd >= ((ShuayishuaConfig)localObject2).realBegin) {
          localOlyimpicConfig.shuayishuaConfigs.add(localObject2);
        } else if (QLog.isColorLevel()) {
          QLog.i("OlympicManager", 2, "parseConfig.begin=" + ((ShuayishuaConfig)localObject2).realBegin + ", end=" + ((ShuayishuaConfig)localObject2).realEnd);
        }
      }
    }
    label496:
    if (paramInt == 2)
    {
      if (!str.equalsIgnoreCase("Id")) {
        break label539;
      }
      ((ShuayishuaConfig)localObject2).id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
    }
    for (;;)
    {
      paramInt = ((XmlPullParser)localObject1).next();
      break label386;
      label537:
      break;
      label539:
      if (str.equalsIgnoreCase("Type"))
      {
        ((ShuayishuaConfig)localObject2).type = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
      }
      else if (str.equalsIgnoreCase("Begin"))
      {
        ((ShuayishuaConfig)localObject2).realBegin = OlympicUtil.a(((XmlPullParser)localObject1).nextText());
      }
      else if (str.equalsIgnoreCase("End"))
      {
        ((ShuayishuaConfig)localObject2).realEnd = OlympicUtil.a(((XmlPullParser)localObject1).nextText());
      }
      else if (str.equalsIgnoreCase("BackGroundImg"))
      {
        ((ShuayishuaConfig)localObject2).bgImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("BackGroundMd5"))
      {
        ((ShuayishuaConfig)localObject2).bgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TopWording"))
      {
        ((ShuayishuaConfig)localObject2).topWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TipWording"))
      {
        ((ShuayishuaConfig)localObject2).tipWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("LUIconImg"))
      {
        ((ShuayishuaConfig)localObject2).LUIconImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("LUIconMd5"))
      {
        ((ShuayishuaConfig)localObject2).LUIconImgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("ActTime"))
      {
        ((ShuayishuaConfig)localObject2).actTime = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("PendantImg"))
      {
        ((ShuayishuaConfig)localObject2).pendantImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("PendantMd5"))
      {
        ((ShuayishuaConfig)localObject2).pendantImgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("Timer"))
      {
        ((ShuayishuaConfig)localObject2).timer = (Integer.parseInt(((XmlPullParser)localObject1).nextText()) * 1000);
      }
      else if (str.equalsIgnoreCase("GrabBeginWording1"))
      {
        ((ShuayishuaConfig)localObject2).grabBeginWording1 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("GrabBeginWording2"))
      {
        ((ShuayishuaConfig)localObject2).grabBeginWording2 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchLogoImg"))
      {
        ((ShuayishuaConfig)localObject2).torchLogoImg = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchLogoMd5"))
      {
        ((ShuayishuaConfig)localObject2).torchLogoImgMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("NoRPWording1"))
      {
        ((ShuayishuaConfig)localObject2).noRPWording1 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("NoRPWording2"))
      {
        ((ShuayishuaConfig)localObject2).noRPWording2 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchAnimUrl"))
      {
        ((ShuayishuaConfig)localObject2).torchAnimUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("TorchAnimMd5"))
      {
        ((ShuayishuaConfig)localObject2).torchAnimMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (str.equalsIgnoreCase("GrabWording"))
      {
        str = ((XmlPullParser)localObject1).nextText();
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
      }
    }
    label1122:
    int i3 = localOlyimpicConfig.shuayishuaConfigs.size();
    if (paramArrayList != null) {}
    for (int i1 = paramArrayList.size();; i1 = 0)
    {
      long l1;
      if ((i1 != 0) && (i3 > 0))
      {
        Collections.sort(localOlyimpicConfig.shuayishuaConfigs, jdField_a_of_type_JavaUtilComparator);
        localObject1 = (ShuayishuaConfig)localOlyimpicConfig.shuayishuaConfigs.get(0);
        if (((ShuayishuaConfig)localObject1).type == 2)
        {
          paramInt = ((Integer)paramArrayList.get(0 % i1)).intValue() * 1000;
          if (QLog.isColorLevel()) {
            QLog.i("OlympicManager", 2, "parseConfig last.realBegin=" + ((ShuayishuaConfig)localObject1).realBegin + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject1).realBegin) + ")" + ",countHitConfig =" + 0 + ",diff = " + paramInt);
          }
          l1 = ((ShuayishuaConfig)localObject1).realBegin;
          ((ShuayishuaConfig)localObject1).realBegin = (paramInt + l1);
          l1 = ((ShuayishuaConfig)localObject1).realEnd;
          ((ShuayishuaConfig)localObject1).uiEnd = l1;
          ((ShuayishuaConfig)localObject1).uiBegin = l1;
          paramInt = 1;
          break label1576;
        }
      }
      for (;;)
      {
        if (i2 < i3)
        {
          localObject2 = (ShuayishuaConfig)localOlyimpicConfig.shuayishuaConfigs.get(i2);
          if (((ShuayishuaConfig)localObject2).type == 2)
          {
            int i4 = ((Integer)paramArrayList.get(paramInt % i1)).intValue() * 1000;
            if (QLog.isColorLevel()) {
              QLog.i("OlympicManager", 2, "parseConfig cur.realBegin=" + ((ShuayishuaConfig)localObject2).realBegin + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject2).realBegin) + ")" + ",countHitConfig =" + paramInt + ",diff = " + i4);
            }
            ((ShuayishuaConfig)localObject2).realBegin += i4;
            l1 = ((ShuayishuaConfig)localObject2).realEnd;
            ((ShuayishuaConfig)localObject2).uiEnd = l1;
            ((ShuayishuaConfig)localObject2).uiBegin = l1;
            if ((localObject1 == null) || (((ShuayishuaConfig)localObject1).type != 1)) {
              break label1582;
            }
            l1 = ((ShuayishuaConfig)localObject2).realBegin;
            ((ShuayishuaConfig)localObject1).realEnd = l1;
            ((ShuayishuaConfig)localObject1).uiEnd = l1;
            break label1582;
            ((ShuayishuaConfig)localObject1).uiBegin = ((ShuayishuaConfig)localObject1).realBegin;
            ((ShuayishuaConfig)localObject1).uiEnd = ((ShuayishuaConfig)localObject1).realEnd;
            paramInt = 0;
          }
          else
          {
            ((ShuayishuaConfig)localObject2).uiBegin = ((ShuayishuaConfig)localObject2).realBegin;
            ((ShuayishuaConfig)localObject2).uiEnd = ((ShuayishuaConfig)localObject2).realEnd;
            break label1586;
          }
        }
        else
        {
          Collections.sort(localOlyimpicConfig.shuayishuaConfigs, jdField_a_of_type_JavaUtilComparator);
          return localOlyimpicConfig;
        }
        label1576:
        int i2 = 1;
        continue;
        label1582:
        paramInt += 1;
        label1586:
        i2 += 1;
        localObject1 = localObject2;
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    OlympicUtil.b("OlympicManager", new Object[] { "playSound.soundType=", Integer.valueOf(paramInt), ",fromLoad=", Boolean.valueOf(paramBoolean) });
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
      }
      if (paramInt == 2)
      {
        if ((this.z != 1) || (!paramBoolean))
        {
          if ((this.z == 0) && (!paramBoolean)) {
            return;
          }
          this.z = 0;
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
        if (this.jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {
          if (paramInt == 2) {}
        }
        for (i1 = this.jdField_a_of_type_AndroidMediaSoundPool.play(i1, 1.0F, 1.0F, 0, 0, 1.0F); QLog.isColorLevel(); i1 = -1)
        {
          QLog.d("OlympicManager", 2, "playSound, " + paramInt + ", " + this.jdField_a_of_type_ArrayOfInt[paramInt] + ", " + this.jdField_a_of_type_ArrayOfBoolean[paramInt] + ", " + i1);
          return;
          if (this.A == 0) {
            this.A = this.jdField_a_of_type_AndroidMediaSoundPool.play(i1, 1.0F, 1.0F, 0, -1, 1.0F);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(OlympicActConfig paramOlympicActConfig, boolean paramBoolean)
  {
    OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource ，forceDownload = " + paramBoolean });
    if (paramOlympicActConfig == null)
    {
      QLog.i("OlympicManager", 1, "tryDownloadActResource actconfig == null!");
      return;
    }
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      localObject1 = "dpc is null";
      QLog.i("OlympicManager", 1, "tryDownloadActResource dpc =" + (String)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC != null) && (!this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Boolean)) {
        break label217;
      }
      bool = true;
      label103:
      localObject1 = new HashMap();
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC != null) {
        break label223;
      }
    }
    label217:
    label223:
    for (int i1 = 0;; i1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.j)
    {
      ((HashMap)localObject1).put("dpc", String.valueOf(i1));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "olympic_down_dpc", bool, 0L, 0L, (HashMap)localObject1, "", false);
      if (paramBoolean) {
        break label258;
      }
      if (i()) {
        break label235;
      }
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, can't auto pre download, return" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString == null)
      {
        localObject1 = "dpc.string is null";
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString;
      break;
      bool = false;
      break label103;
    }
    label235:
    if (!h())
    {
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, isNetworkCanPredown is false, return" });
      return;
    }
    label258:
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1 = paramOlympicActConfig.getConfigString("HomePage", "End");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (OlympicUtil.a((String)localObject1) < l1))
    {
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, time expired!" });
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = "";
    Object localObject3;
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo != null))
    {
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, cityPic & starPic, isSelfTorchbearer() && mTorchbearerInfo != null" });
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.size() > 0)
      {
        localObject3 = (TorchInfo.CityInfo)this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.get(0);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).city_pic_url, ((TorchInfo.CityInfo)localObject3).city_pic_md5, new String[] { "ActConfig", "CityImage", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).city_pic_md5);
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).cons_pic_url, ((TorchInfo.CityInfo)localObject3).cons_pic_md5, new String[] { "ActConfig", "StarImage", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).cons_pic_md5);
          localObject1 = localObject2;
          if (TextUtils.isEmpty("")) {
            localObject1 = ((TorchInfo.CityInfo)localObject3).city_pic_md5;
          }
        }
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.size() > 1)
      {
        localObject3 = (TorchInfo.CityInfo)this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.get(1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).city_pic_url, ((TorchInfo.CityInfo)localObject3).city_pic_md5, new String[] { "ActConfig", "City2Image", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).city_pic_md5);
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((TorchInfo.CityInfo)localObject3).cons_pic_url, ((TorchInfo.CityInfo)localObject3).cons_pic_md5, new String[] { "ActConfig", "Star2Image", ((TorchInfo.CityInfo)localObject3).city_id + "_" + ((TorchInfo.CityInfo)localObject3).city_pic_id }, false, 2, true);
          localArrayList1.add(((TorchInfo.CityInfo)localObject3).cons_pic_md5);
          localObject2 = localObject1;
        }
      }
    }
    label815:
    label900:
    label914:
    Object localObject4;
    String str;
    label1154:
    label1197:
    do
    {
      localObject1 = paramOlympicActConfig.getHomePageBg("1");
      if (localObject1 != null) {
        break;
      }
      paramBoolean = true;
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, homePageBg==null?", Boolean.valueOf(paramBoolean) });
      if (localObject1 == null) {
        break label1908;
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.HomePageBg)localObject1).url, ((OlympicActConfig.HomePageBg)localObject1).md5, new String[] { "ActConfig", "homePageBg", "01" }, false, 2, true);
      localArrayList1.add(((OlympicActConfig.HomePageBg)localObject1).md5);
      localObject3 = ((OlympicActConfig.HomePageBg)localObject1).md5;
      localObject1 = paramOlympicActConfig.getHomePageBg("2");
      if (localObject1 != null) {
        break label1418;
      }
      paramBoolean = true;
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, homePageBg2==null?", Boolean.valueOf(paramBoolean) });
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.HomePageBg)localObject1).url, ((OlympicActConfig.HomePageBg)localObject1).md5, new String[] { "ActConfig", "homePageBg", "02" }, false, 2, true);
        localArrayList1.add(((OlympicActConfig.HomePageBg)localObject1).md5);
      }
      localObject1 = "";
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, actConfig.mTorchImageMap.size() = ", Integer.valueOf(paramOlympicActConfig.getTorchImageMap().size()) });
      localObject4 = paramOlympicActConfig.getTorchImageMap().keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        str = (String)((Iterator)localObject4).next();
        OlympicActConfig.TorchImage localTorchImage = (OlympicActConfig.TorchImage)paramOlympicActConfig.getTorchImageMap().get(str);
        if (localTorchImage == null) {
          break label1905;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localTorchImage.url, localTorchImage.md5, new String[] { "ActConfig", "TorchImage", str }, false, 2, true);
        localArrayList1.add(localTorchImage.md5);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1905;
        }
        localObject1 = localTorchImage.md5;
      }
      OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, actConfig.getChosenCityImageList.size() = ", Integer.valueOf(paramOlympicActConfig.getChosenCityImageList().size()) });
      localObject3 = paramOlympicActConfig.getChosenCityImageList().iterator();
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (!((Iterator)localObject3).hasNext());
    localObject2 = (OlympicActConfig.CityImage)((Iterator)localObject3).next();
    if (localObject2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.CityImage)localObject2).url, ((OlympicActConfig.CityImage)localObject2).md5, new String[] { "ActConfig", "CityImage", ((OlympicActConfig.CityImage)localObject2).companyId + "_" + ((OlympicActConfig.CityImage)localObject2).picId }, false, 2, true);
      localArrayList1.add(((OlympicActConfig.CityImage)localObject2).md5);
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(((OlympicActConfig.CityImage)localObject2).starUrl, ((OlympicActConfig.CityImage)localObject2).starMd5, new String[] { "ActConfig", "StarImage", ((OlympicActConfig.CityImage)localObject2).companyId + "_" + ((OlympicActConfig.CityImage)localObject2).picId }, false, 2, true);
      localArrayList1.add(((OlympicActConfig.CityImage)localObject2).starMd5);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = ((OlympicActConfig.CityImage)localObject2).md5;
      }
    }
    for (;;)
    {
      break label1197;
      paramBoolean = false;
      break label815;
      label1418:
      paramBoolean = false;
      break label914;
      localObject4 = paramOlympicActConfig.getConfigString("TorchAnim", "FileUrl");
      str = paramOlympicActConfig.getConfigString("TorchAnim", "FileMd5");
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty(str)))
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, str, new String[] { "ActConfig", "TorchAnim" }, false, 2, true);
        localArrayList2.add(str);
        label1504:
        localObject4 = paramOlympicActConfig.getConfigString("MsgTabBG", "Img");
        str = paramOlympicActConfig.getConfigString("MsgTabBG", "Md5");
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(str))) {
          break label1857;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, str, new String[] { "ActConfig", "MsgTabBG" }, false, 2, true);
        localArrayList1.add(str);
        label1585:
        localObject4 = paramOlympicActConfig.getConfigString("TorchImageNoBg", "FileUrl");
        str = paramOlympicActConfig.getConfigString("TorchImageNoBg", "FileMd5");
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(str))) {
          break label1875;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, str, new String[] { "ActConfig", "TorchImageNoBg" }, false, 2, true);
        localArrayList1.add(str);
        label1666:
        localObject4 = paramOlympicActConfig.getConfigString("cityaward", "Img");
        paramOlympicActConfig = paramOlympicActConfig.getConfigString("cityaward", "Md5");
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(paramOlympicActConfig))) {
          break label1887;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a((String)localObject4, paramOlympicActConfig, null, false, 2, true);
        localArrayList1.add(paramOlympicActConfig);
      }
      for (;;)
      {
        if (OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_predown_act")) {
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new trb(this, localArrayList1, localArrayList2), 60000L);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OlympicManager", 2, "firstTorchMD5:" + (String)localObject1 + ",firstCityMD5:" + (String)localObject2 + ",firstCityBgMD5:" + (String)localObject3 + ",takeAwardImgUrl " + (String)localObject4 + ",takeAwardImgMd5" + paramOlympicActConfig);
        return;
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, TorchAnim,  torchAnimUrl or torchAnimMd5 is empty" });
        break label1504;
        label1857:
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, MsgTabBG,  msgTabImgUrl or msgTabImgMD5 is empty" });
        break label1585;
        label1875:
        QLog.i("OlympicManager", 1, "tryDownloadActResource, TorchImageNoBg,  torchImageNoBgUrl or torchImageNoBgMD5 is empty");
        break label1666;
        label1887:
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownloadActResource, takeAwardImg,  takeAwardImgUrl or takeAwardImgUrl is empty" });
      }
      label1905:
      break label1154;
      label1908:
      localObject3 = "";
      break label900;
    }
  }
  
  private void a(String paramString, List paramList1, List paramList2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList1 == null) || (paramList2 == null)) {}
    boolean bool1;
    boolean bool3;
    boolean bool2;
    label188:
    label274:
    label277:
    do
    {
      return;
      bool1 = true;
      bool3 = true;
      for (;;)
      {
        try
        {
          paramList1 = paramList1.iterator();
          bool2 = bool1;
          if (paramList1.hasNext())
          {
            bool1 = OlympicResources.a((String)paramList1.next()) & bool1;
            if (!bool1) {
              bool2 = bool1;
            }
          }
          else
          {
            paramList1 = paramList2.iterator();
            bool1 = bool3;
            bool3 = bool1;
            if (paramList1.hasNext())
            {
              bool1 = OlympicResources.a((String)paramList1.next()) & bool1;
              if (bool1) {
                break label274;
              }
              bool3 = bool1;
            }
            bool1 = bool3 & bool2;
            paramList2 = new HashMap();
            if (!"olympic_predown_act".equals(paramString)) {
              break;
            }
            if (!bool2) {
              break label277;
            }
            paramList1 = "1";
            paramList2.put("act_pic", paramList1);
            if (!bool3) {
              break label384;
            }
            paramList1 = "1";
            paramList2.put("act_anim", paramList1);
            if (!bool1) {
              break label391;
            }
            paramList1 = "1";
            paramList2.put("act_all_resource", paramList1);
            StatisticCollector.a(BaseApplicationImpl.getContext()).a("", paramString, true, 0L, 0L, paramList2, "", false);
            OlympicUtil.a(BaseApplicationImpl.getContext(), paramString);
            return;
          }
        }
        catch (Throwable paramList1)
        {
          if (QLog.isColorLevel()) {
            paramList1.printStackTrace();
          }
          QLog.d("OlympicManager", 1, new Object[] { "reportPredown, reportKey=", paramString, ", t=", paramList1.getMessage() });
          return;
        }
        continue;
        continue;
        paramList1 = "0";
      }
    } while (!"olympic_predown_shua".equals(paramString));
    if (bool2)
    {
      paramList1 = "1";
      label303:
      paramList2.put("shua_pic", paramList1);
      if (!bool3) {
        break label405;
      }
    }
    label384:
    label391:
    label405:
    for (paramList1 = "1";; paramList1 = "0")
    {
      paramList2.put("shua_anim", paramList1);
      if (bool1) {}
      for (paramList1 = "1";; paramList1 = "0")
      {
        paramList2.put("shua_all_resource", paramList1);
        StatisticCollector.a(BaseApplicationImpl.getContext()).a("", paramString, true, 0L, 0L, paramList2, "", false);
        OlympicUtil.a(BaseApplicationImpl.getContext(), paramString);
        return;
      }
      paramList1 = "0";
      break;
      paramList1 = "0";
      break label188;
      paramList1 = "0";
      break label303;
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    this.g = false;
    int i1;
    if (paramBoolean)
    {
      i1 = paramBundle.getInt("k_code", -1);
      if (i1 == 28)
      {
        a(1);
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5).sendToTarget();
        this.C += 1;
        long l1 = paramBundle.getLong("k_interval", -1L);
        if (l1 > 0L) {
          this.j = l1;
        }
        l1 = paramBundle.getLong("k_active_interval", -1L);
        if (l1 > 0L) {
          this.k = l1;
        }
        l1 = paramBundle.getLong("k_normal_interval", -1L);
        if (l1 > 0L) {
          this.l = l1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "handleGrabTorch.isSuccess=" + paramBoolean + ",errCode=" + i1 + ",interval=" + l1);
        }
      }
    }
    do
    {
      return;
      if (i1 == 0)
      {
        byte[] arrayOfByte = paramBundle.getByteArray("k_pack_id");
        int i2 = paramBundle.getInt("k_business", -1);
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "handleGrabTorch.pack_id=" + arrayOfByte + ",business=" + i2);
        }
        this.jdField_d_of_type_ArrayOfByte = arrayOfByte;
        this.y = i2;
        this.f = true;
        this.C += 1;
        break;
      }
      this.B += 1;
      break;
      this.B += 1;
    } while (!QLog.isColorLevel());
    QLog.d("OlympicManager", 2, "handleGrabTorch.isSuccess=" + paramBoolean);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    boolean bool = false;
    OlympicManager localOlympicManager = (OlympicManager)paramQQAppInterface.getManager(166);
    if (localOlympicManager.b(paramString2)) {
      bool = true;
    }
    if (bool)
    {
      bool = localOlympicManager.a(paramQQAppInterface.a());
      if ((bool) && (paramString1.equals(paramQQAppInterface.a()))) {
        return localOlympicManager.a("olympic_flag_setting", true);
      }
      return bool;
    }
    return bool;
  }
  
  private OlyimpicConfig b()
  {
    OlyimpicConfig localOlyimpicConfig = new OlyimpicConfig();
    localOlyimpicConfig.id = 1;
    localOlyimpicConfig.version = 0;
    localOlyimpicConfig.grabInterval = 2500L;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    ArrayList localArrayList = new ArrayList(2);
    Object localObject = new ShuayishuaConfig();
    ((ShuayishuaConfig)localObject).type = 1;
    ((ShuayishuaConfig)localObject).id = 1727;
    l1 += 10000L;
    ((ShuayishuaConfig)localObject).realBegin = l1;
    ((ShuayishuaConfig)localObject).uiBegin = l1;
    l1 = ((ShuayishuaConfig)localObject).uiBegin + 30000L;
    ((ShuayishuaConfig)localObject).realEnd = l1;
    ((ShuayishuaConfig)localObject).uiEnd = l1;
    ((ShuayishuaConfig)localObject).topWording = "连续刷一刷，抢QQ火炬";
    ((ShuayishuaConfig)localObject).actTime = "20:00-21:00";
    localArrayList.add(localObject);
    ShuayishuaConfig localShuayishuaConfig = new ShuayishuaConfig();
    localShuayishuaConfig.type = 2;
    localShuayishuaConfig.id = 1728;
    localShuayishuaConfig.realBegin = ((ShuayishuaConfig)localObject).uiEnd;
    localShuayishuaConfig.uiBegin = (localShuayishuaConfig.realBegin + 10000L);
    l1 = localShuayishuaConfig.realBegin + 120000L;
    localShuayishuaConfig.realEnd = l1;
    localShuayishuaConfig.uiEnd = l1;
    localShuayishuaConfig.timer = 60000L;
    localShuayishuaConfig.tipWording = "加油刷！还剩";
    localShuayishuaConfig.grabBeginWording1 = "QQ火炬开抢啦";
    localShuayishuaConfig.grabBeginWording2 = "刷一刷，抢QQ火炬";
    localShuayishuaConfig.noRPWording1 = "很遗憾，火炬没有点燃";
    localShuayishuaConfig.noRPWording2 = "你还可以找其他QQ火炬手传递点燃火炬";
    localObject = new ArrayList();
    ((ArrayList)localObject).add("继续刷，马上抢到火炬了");
    ((ArrayList)localObject).add("往下刷，就要抢到火炬了");
    localShuayishuaConfig.grabWordingList = ((ArrayList)localObject);
    localArrayList.add(localShuayishuaConfig);
    localOlyimpicConfig.shuayishuaConfigs = localArrayList;
    return localOlyimpicConfig;
  }
  
  private void b(long paramLong)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
    OlympicListener localOlympicListener = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener;
    if (localOlympicListener == null) {
      return;
    }
    long l1 = paramLong;
    if (paramLong == 0L) {
      l1 = NetConnInfoCenter.getServerTimeMillis();
    }
    boolean bool1 = ARDeviceController.a().b();
    boolean bool2 = j();
    boolean bool3 = a("olympic_entrance_setting", true);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("refreshUI,arEnable = ").append(bool1).append(",mActConfig: ");
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null) {
        break label252;
      }
      localObject1 = "null";
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(",mCurrentConfig: ");
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig != null) {
        break label259;
      }
    }
    label252:
    label259:
    for (Object localObject1 = "null";; localObject1 = "not null")
    {
      QLog.d("OlympicManager", 2, (String)localObject1 + ",currentTime = " + l1 + "(" + OlympicUtil.a(l1) + ")" + ",closeEntrance = " + bool2 + ",mHasChechBreathOnRecovery = " + this.jdField_d_of_type_Boolean + ",olympicSettingFlag = " + bool3 + ",mTorchbearerFlag = " + this.x);
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null) && (!c("HomePage")) && (bool1) && (!bool2)) {
        break label266;
      }
      localOlympicListener.a();
      return;
      localObject1 = "not null";
      break;
    }
    label266:
    String str1;
    Object localObject4;
    if (this.x == 1)
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new trd(this));
      if (!bool3) {
        localOlympicListener.a();
      }
      for (;;)
      {
        a(l1);
        return;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("TorchImageNoBg", "FileMd5");
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MsgTabBG", "Md5");
        str1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MsgTabBG", "Wording");
        localObject1 = null;
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("TorchAnim", "FileMd5");
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources;
          localObject1 = OlympicResources.a((String)localObject1);
          localObject1 = (String)localObject1 + "fire";
        }
        localOlympicListener.a((String)localObject3, (String)localObject2, (String)localObject1, this.jdField_e_of_type_Boolean, str1);
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = true;
          b();
        }
        if (this.jdField_e_of_type_Boolean)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          bool1 = ((SharedPreferences)localObject1).getBoolean("in_breath_procedure", false);
          if (QLog.isColorLevel()) {
            QLog.d("OlympicManager", 2, "refreshUI breath inProcedure :" + bool1);
          }
          if (!bool1)
          {
            this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, 1, 0).sendToTarget();
            ((SharedPreferences)localObject1).edit().putBoolean("in_breath_procedure", true).commit();
            ((SharedPreferences)localObject1).edit().putInt("breath_remind_type_value", 1).commit();
            if (QLog.isColorLevel()) {
              QLog.d("OlympicManager", 2, "refreshUI set inProcedure true");
            }
          }
        }
        this.jdField_e_of_type_Boolean = false;
      }
    }
    if (!bool3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "refreshUI olympicSettingFlag is false，restoreNormal ");
      }
      localOlympicListener.a();
      return;
    }
    long l2;
    if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.type == 1))
    {
      l2 = ((ShuayishuaConfig)localObject2).id;
      localObject1 = ((ShuayishuaConfig)localObject2).topWording;
      localObject3 = ((ShuayishuaConfig)localObject2).actTime;
      str1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MsgTabBG", "Md5");
      this.jdField_b_of_type_AndroidOsHandler.post(new tre(this));
      paramLong = -1L;
      if (l1 > ((ShuayishuaConfig)localObject2).realEnd) {
        paramLong = 0L;
      }
      for (;;)
      {
        localOlympicListener.a(l2, (String)localObject1, (String)localObject3, str1, ((ShuayishuaConfig)localObject2).LUIconImgMd5, ((ShuayishuaConfig)localObject2).pendantImgMd5, paramLong);
        return;
        if (((ShuayishuaConfig)localObject2).realEnd - l1 <= 300000L) {
          paramLong = ((ShuayishuaConfig)localObject2).realEnd - l1;
        }
      }
    }
    if ((localObject2 != null) && (((ShuayishuaConfig)localObject2).type == 2))
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new trf(this));
      long l3 = ((ShuayishuaConfig)localObject2).id;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MsgTabBG", "Md5");
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("TorchImageNoBg", "FileMd5");
      str1 = ((ShuayishuaConfig)localObject2).tipWording;
      localObject4 = ((ShuayishuaConfig)localObject2).grabBeginWording1;
      String str2 = ((ShuayishuaConfig)localObject2).grabBeginWording2;
      String str3 = ((ShuayishuaConfig)localObject2).noRPWording1;
      String str4 = ((ShuayishuaConfig)localObject2).noRPWording2;
      ArrayList localArrayList = ((ShuayishuaConfig)localObject2).grabWordingList;
      long l4 = ((ShuayishuaConfig)localObject2).uiBegin;
      long l5 = ((ShuayishuaConfig)localObject2).realBegin;
      if (l1 < ((ShuayishuaConfig)localObject2).uiBegin) {
        paramLong = -1L;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "refreshUI,currentTime  = " + l1 + "(" + OlympicUtil.a(l1) + ")" + ",config.uiBegin = " + ((ShuayishuaConfig)localObject2).uiBegin + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject2).uiBegin) + ")" + ",config.timer = " + ((ShuayishuaConfig)localObject2).timer + ",config.uiEnd = " + ((ShuayishuaConfig)localObject2).uiEnd + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject2).uiEnd) + ")" + ",config.realBegin = " + ((ShuayishuaConfig)localObject2).realBegin + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject2).realBegin) + ")" + ",config.realEnd = " + ((ShuayishuaConfig)localObject2).realEnd + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject2).realEnd) + ")");
        }
        Object localObject5 = new StringBuilder();
        Object localObject6 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources;
        String str6 = OlympicResources.a() + ((ShuayishuaConfig)localObject2).torchAnimMd5 + "_dir" + File.separator;
        localObject5 = str6 + "pullfire";
        localObject6 = str6 + "takefire";
        String str5 = str6 + "firestart";
        str6 = str6 + "fire";
        localOlympicListener.a(l3, (String)localObject1, ((ShuayishuaConfig)localObject2).LUIconImgMd5, ((ShuayishuaConfig)localObject2).pendantImgMd5, (String)localObject3, ((ShuayishuaConfig)localObject2).torchLogoImgMd5, str1, (String)localObject4, str2, str3, str4, localArrayList, paramLong, l4 - l5, (String)localObject5, (String)localObject6, str5, str6);
        return;
        if (l1 > ((ShuayishuaConfig)localObject2).uiBegin + ((ShuayishuaConfig)localObject2).timer)
        {
          l2 = 0L;
          paramLong = l2;
          if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(7))
          {
            paramLong = ((ShuayishuaConfig)localObject2).uiBegin;
            this.jdField_b_of_type_AndroidOsHandler.obtainMessage(7, Long.valueOf(paramLong)).sendToTarget();
            paramLong = l2;
          }
        }
        else
        {
          l2 = ((ShuayishuaConfig)localObject2).uiBegin + ((ShuayishuaConfig)localObject2).timer;
          paramLong = l2;
          if (((ShuayishuaConfig)localObject2).realEnd < l2) {
            paramLong = ((ShuayishuaConfig)localObject2).realEnd;
          }
          paramLong -= l1;
        }
      }
    }
    localOlympicListener.a();
  }
  
  private void b(OlyimpicConfig paramOlyimpicConfig)
  {
    if (paramOlyimpicConfig == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      if (!i())
      {
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownload, can't auto pre download, return" });
        return;
      }
      if (!h())
      {
        OlympicUtil.b("OlympicManager", new Object[] { "tryDownload, isNetworkCanPredown is false, return" });
        return;
      }
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramOlyimpicConfig = paramOlyimpicConfig.shuayishuaConfigs.iterator();
      while (paramOlyimpicConfig.hasNext())
      {
        ShuayishuaConfig localShuayishuaConfig = (ShuayishuaConfig)paramOlyimpicConfig.next();
        if ((localShuayishuaConfig.uiEnd > l1) || (localShuayishuaConfig.realEnd > l1))
        {
          if ((!TextUtils.isEmpty(localShuayishuaConfig.LUIconImg)) && (!TextUtils.isEmpty(localShuayishuaConfig.LUIconImgMd5)))
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localShuayishuaConfig.LUIconImg, localShuayishuaConfig.LUIconImgMd5, new String[] { "shuayishua", String.valueOf(localShuayishuaConfig.id) }, false, 1, true);
            localArrayList1.add(localShuayishuaConfig.LUIconImgMd5);
          }
          if ((!TextUtils.isEmpty(localShuayishuaConfig.torchLogoImg)) && (!TextUtils.isEmpty(localShuayishuaConfig.torchLogoImgMd5)))
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localShuayishuaConfig.torchLogoImg, localShuayishuaConfig.torchLogoImgMd5, new String[] { "shuayishua", String.valueOf(localShuayishuaConfig.id) }, false, 1, true);
            localArrayList1.add(localShuayishuaConfig.torchLogoImgMd5);
          }
          if ((!TextUtils.isEmpty(localShuayishuaConfig.torchAnimUrl)) && (!TextUtils.isEmpty(localShuayishuaConfig.torchAnimMd5)))
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.a(localShuayishuaConfig.torchAnimUrl, localShuayishuaConfig.torchAnimMd5, new String[] { "shuayishua_anim", String.valueOf(localShuayishuaConfig.id) }, false, 1, true);
            localArrayList2.add(localShuayishuaConfig.torchAnimMd5);
          }
        }
      }
    } while (!OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_predown_shua"));
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new tra(this, localArrayList1, localArrayList2), 60000L);
  }
  
  private void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "handleConfig.isSuccess=" + paramBoolean + ",bundle=" + paramBundle);
    }
    int i1;
    if ((paramBoolean) && (paramBundle != null))
    {
      i1 = paramBundle.getInt("k_code", -1);
      paramBundle = paramBundle.getParcelable("k_config");
      if (i1 != 3) {
        break label85;
      }
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, null).sendToTarget();
    }
    label85:
    do
    {
      return;
      if (i1 == 2)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig);
        return;
      }
    } while ((paramBundle == null) || (!(paramBundle instanceof OlyimpicConfig)));
    b((OlyimpicConfig)paramBundle);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramBundle).sendToTarget();
  }
  
  private void c(long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "handleCheckTime, mConfig is null!");
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realBegin = paramLong;
    Object localObject2 = ((OlyimpicConfig)localObject1).shuayishuaConfigs;
    int i3 = Collections.binarySearch((List)localObject2, jdField_c_of_type_ComTencentMobileqqOlympicShuayishuaConfig, jdField_a_of_type_JavaUtilComparator);
    int i1;
    if (i3 >= 0) {
      i1 = i3 + 1;
    }
    while (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      int i2 = 0;
      for (;;)
      {
        if (i2 < ((ArrayList)localObject2).size())
        {
          ShuayishuaConfig localShuayishuaConfig = (ShuayishuaConfig)((ArrayList)localObject2).get(i2);
          ((StringBuilder)localObject1).append(localShuayishuaConfig.realBegin + "(" + OlympicUtil.a(localShuayishuaConfig.realBegin) + ")").append("-").append(localShuayishuaConfig.uiEnd + "(" + OlympicUtil.a(localShuayishuaConfig.uiEnd) + ")").append(";");
          i2 += 1;
          continue;
          i1 = -i3 - 1;
          break;
        }
      }
      QLog.d("OlympicManager", 2, "handleCheckTime ,nextIndex = " + i1 + ",index = " + i3 + ";" + ((StringBuilder)localObject1).toString() + ",mTorchbearerFlag = " + this.x + ",mHasSendLastCheckRequest = " + this.jdField_c_of_type_Boolean);
    }
    if ((i1 > 0) && (i1 <= ((ArrayList)localObject2).size()))
    {
      localObject1 = (ShuayishuaConfig)((ArrayList)localObject2).get(i1 - 1);
      if (((ShuayishuaConfig)localObject1).uiEnd < paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "handleCheckTime ,cConfig.uiEnd = " + ((ShuayishuaConfig)localObject1).uiEnd + "(" + OlympicUtil.a(((ShuayishuaConfig)localObject1).uiEnd) + ")" + ",current = " + paramLong + "(" + OlympicUtil.a(paramLong) + ")");
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      if ((i1 < ((ArrayList)localObject2).size()) && (i1 >= 0)) {}
      for (localObject2 = (ShuayishuaConfig)((ArrayList)localObject2).get(i1);; localObject2 = null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig = ((ShuayishuaConfig)localObject1);
        this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig = ((ShuayishuaConfig)localObject2);
        long l2 = Long.MAX_VALUE;
        long l1;
        if (this.x == 1)
        {
          l1 = l2;
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("HomePage", "End");
            l1 = l2;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              l1 = l2;
              if (!this.jdField_c_of_type_Boolean)
              {
                if (jdField_a_of_type_JavaUtilMap.containsKey(localObject1))
                {
                  l1 = ((Long)jdField_a_of_type_JavaUtilMap.get(localObject1)).longValue();
                  label559:
                  this.jdField_c_of_type_Boolean = true;
                  if (l1 < paramLong) {
                    break label686;
                  }
                }
                label686:
                for (paramLong = l1 - paramLong;; paramLong = 1000L)
                {
                  this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), paramLong);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("OlympicManager", 2, "handleCheckTime ,strTimeEnd=" + (String)localObject1 + ",end=" + l1 + ",delay = " + paramLong);
                  return;
                  l2 = OlympicUtil.a((String)localObject1);
                  l1 = l2;
                  if (l2 <= 0L) {
                    break label559;
                  }
                  jdField_a_of_type_JavaUtilMap.put(localObject1, Long.valueOf(l2));
                  l1 = l2;
                  break label559;
                }
              }
            }
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig == null) {
            break label1068;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.type != 1) {
            break label897;
          }
          if (paramLong > this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd - 300000L) {
            break label885;
          }
          l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd - 300000L;
          label740:
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i("OlympicManager", 2, "handleCheckTime.type=1,mCurrentConfig.realEnd=" + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd + ",current=" + paramLong);
            l1 = l2;
          }
        }
        label796:
        if (l1 != Long.MAX_VALUE) {
          if (l1 < paramLong) {
            break label1147;
          }
        }
        label885:
        label897:
        label1068:
        label1147:
        for (paramLong = l1 - paramLong;; paramLong = 60000L)
        {
          l1 = paramLong;
          if (paramLong > 60000L) {
            l1 = 60000L;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), l1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("OlympicManager", 2, "handleCheckTime ,delay=" + l1);
          return;
          l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd;
          break label740;
          l1 = l2;
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.type != 2) {
            break label796;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin == this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd) {
            l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd;
          }
          for (;;)
          {
            l1 = l2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("OlympicManager", 2, "handleCheckTime.type=2,mCurrentConfig.uiBegin=" + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin + ",mCurrentConfig.realEnd=" + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd + ",current=" + paramLong);
            l1 = l2;
            break;
            l1 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realEnd;
            l2 = l1;
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.timer < l1) {
              l2 = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin + this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.timer;
            }
          }
          l1 = l2;
          if (this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig == null) {
            break label796;
          }
          l2 = this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realBegin;
          l1 = l2;
          if (!QLog.isColorLevel()) {
            break label796;
          }
          QLog.i("OlympicManager", 2, "handleCheckTime.mNextConfig.realBegin=" + this.jdField_b_of_type_ComTencentMobileqqOlympicShuayishuaConfig.realBegin + ",current=" + paramLong);
          l1 = l2;
          break label796;
          break;
        }
      }
      continue;
      localObject1 = null;
    }
  }
  
  private void r()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong("OlympicBreatheTime", -1L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    long l3 = l2 - l2 % 86400000L;
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "checkBreatheOnTransferNumChange.lastBreatheTime=" + l1 + ",current=" + l2 + ",zeroTime=" + l3);
    }
    if (l1 < l3)
    {
      if (!localSharedPreferences.getBoolean("in_breath_procedure", false)) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "checkBreatheOnTransferNumChange inProcedure return");
      }
    }
    return;
    label126:
    localSharedPreferences.edit().putLong("OlympicBreatheTime", l2).commit();
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, 2, 0).sendToTarget();
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "checkBreatheOnTransferNumChange set inProcedure true");
    }
    localSharedPreferences.edit().putBoolean("in_breath_procedure", true).commit();
    localSharedPreferences.edit().putInt("breath_remind_type_value", 2).commit();
  }
  
  public int a()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_ArrayOfByte)
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        if (localSharedPreferences != null)
        {
          int i2 = localSharedPreferences.getInt("isTorchbearer", -1);
          if (this.x == -1) {
            this.x = i2;
          }
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.i("OlympicManager", 2, "loadTorchbearerFlagFromLocal.flag=" + i2 + ",mTorchbearerFlag=" + this.x);
            i1 = i2;
          }
          return i1;
        }
      }
      int i1 = -1;
    }
  }
  
  public OlympicPredownInfo a(String paramString)
  {
    Object localObject = null;
    String str;
    if (paramString == null) {
      str = "null";
    }
    try
    {
      OlympicUtil.b("OlympicManager", new Object[] { "getEntity, url=", str });
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        paramString = (String)localObject;
      }
      for (;;)
      {
        return paramString;
        str = paramString;
        break;
        try
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OlympicPredownInfo.class, false, "url = ?", new String[] { paramString }, null, null, null, null);
          if ((paramString != null) && (paramString.size() > 0)) {
            paramString = (OlympicPredownInfo)paramString.get(0);
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              paramString.printStackTrace();
            }
            paramString = null;
          }
          paramString = null;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public OlyimpicConfig a()
  {
    // Byte code:
    //   0: new 1245	java/io/File
    //   3: dup
    //   4: getstatic 393	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   7: invokevirtual 1391	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   10: new 291	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1393
    //   20: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 226	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 1396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   30: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 1399	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 1402	java/io/File:exists	()Z
    //   44: ifeq +351 -> 395
    //   47: new 1404	java/io/FileInputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 1407	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_2
    //   56: new 1409	java/io/ObjectInputStream
    //   59: dup
    //   60: new 1411	java/io/BufferedInputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 1414	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 1415	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore_1
    //   72: aload_2
    //   73: astore 4
    //   75: aload_1
    //   76: astore_3
    //   77: aload_1
    //   78: invokevirtual 1418	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   81: checkcast 426	com/tencent/mobileqq/olympic/OlyimpicConfig
    //   84: astore 5
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 1421	java/io/ObjectInputStream:close	()V
    //   94: aload 5
    //   96: astore_1
    //   97: aload_2
    //   98: ifnull +10 -> 108
    //   101: aload_2
    //   102: invokevirtual 1422	java/io/FileInputStream:close	()V
    //   105: aload 5
    //   107: astore_1
    //   108: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +29 -> 140
    //   114: ldc 23
    //   116: iconst_2
    //   117: new 291	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 1424
    //   127: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 411	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: getfield 1291	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig	Lcom/tencent/mobileqq/olympic/OlyimpicConfig;
    //   144: ifnonnull +19 -> 163
    //   147: aload_1
    //   148: ifnull +15 -> 163
    //   151: aload_0
    //   152: getfield 239	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   155: iconst_4
    //   156: aload_1
    //   157: invokevirtual 1267	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   160: invokevirtual 1043	android/os/Message:sendToTarget	()V
    //   163: aload_1
    //   164: areturn
    //   165: astore_1
    //   166: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq -75 -> 94
    //   172: ldc 23
    //   174: iconst_2
    //   175: ldc_w 368
    //   178: aload_1
    //   179: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: goto -88 -> 94
    //   185: astore_2
    //   186: aload 5
    //   188: astore_1
    //   189: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -84 -> 108
    //   195: ldc 23
    //   197: iconst_2
    //   198: ldc_w 368
    //   201: aload_2
    //   202: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload 5
    //   207: astore_1
    //   208: goto -100 -> 108
    //   211: astore 5
    //   213: aconst_null
    //   214: astore_2
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_2
    //   218: astore 4
    //   220: aload_1
    //   221: astore_3
    //   222: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +19 -> 244
    //   228: aload_2
    //   229: astore 4
    //   231: aload_1
    //   232: astore_3
    //   233: ldc 23
    //   235: iconst_2
    //   236: ldc_w 368
    //   239: aload 5
    //   241: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 1421	java/io/ObjectInputStream:close	()V
    //   252: aload_2
    //   253: ifnull +142 -> 395
    //   256: aload_2
    //   257: invokevirtual 1422	java/io/FileInputStream:close	()V
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -154 -> 108
    //   265: astore_1
    //   266: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -17 -> 252
    //   272: ldc 23
    //   274: iconst_2
    //   275: ldc_w 368
    //   278: aload_1
    //   279: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto -30 -> 252
    //   285: astore_1
    //   286: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc 23
    //   294: iconst_2
    //   295: ldc_w 368
    //   298: aload_1
    //   299: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: aconst_null
    //   303: astore_1
    //   304: goto -196 -> 108
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_2
    //   310: aconst_null
    //   311: astore_3
    //   312: aload_3
    //   313: ifnull +7 -> 320
    //   316: aload_3
    //   317: invokevirtual 1421	java/io/ObjectInputStream:close	()V
    //   320: aload_2
    //   321: ifnull +7 -> 328
    //   324: aload_2
    //   325: invokevirtual 1422	java/io/FileInputStream:close	()V
    //   328: aload_1
    //   329: athrow
    //   330: astore_3
    //   331: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq -14 -> 320
    //   337: ldc 23
    //   339: iconst_2
    //   340: ldc_w 368
    //   343: aload_3
    //   344: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   347: goto -27 -> 320
    //   350: astore_2
    //   351: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq -26 -> 328
    //   357: ldc 23
    //   359: iconst_2
    //   360: ldc_w 368
    //   363: aload_2
    //   364: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: goto -39 -> 328
    //   370: astore_1
    //   371: aconst_null
    //   372: astore_3
    //   373: goto -61 -> 312
    //   376: astore_1
    //   377: aload 4
    //   379: astore_2
    //   380: goto -68 -> 312
    //   383: astore 5
    //   385: aconst_null
    //   386: astore_1
    //   387: goto -170 -> 217
    //   390: astore 5
    //   392: goto -175 -> 217
    //   395: aconst_null
    //   396: astore_1
    //   397: goto -289 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	OlympicManager
    //   39	125	1	localObject1	Object
    //   165	14	1	localIOException1	java.io.IOException
    //   188	74	1	localObject2	Object
    //   265	14	1	localIOException2	java.io.IOException
    //   285	14	1	localIOException3	java.io.IOException
    //   303	1	1	localObject3	Object
    //   307	22	1	localObject4	Object
    //   370	1	1	localObject5	Object
    //   376	1	1	localObject6	Object
    //   386	11	1	localObject7	Object
    //   55	47	2	localFileInputStream	java.io.FileInputStream
    //   185	17	2	localIOException4	java.io.IOException
    //   214	111	2	localObject8	Object
    //   350	14	2	localIOException5	java.io.IOException
    //   379	1	2	localObject9	Object
    //   76	241	3	localObject10	Object
    //   330	14	3	localIOException6	java.io.IOException
    //   372	1	3	localObject11	Object
    //   73	305	4	localObject12	Object
    //   84	122	5	localOlyimpicConfig	OlyimpicConfig
    //   211	29	5	localThrowable1	Throwable
    //   383	1	5	localThrowable2	Throwable
    //   390	1	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   90	94	165	java/io/IOException
    //   101	105	185	java/io/IOException
    //   47	56	211	java/lang/Throwable
    //   248	252	265	java/io/IOException
    //   256	260	285	java/io/IOException
    //   47	56	307	finally
    //   316	320	330	java/io/IOException
    //   324	328	350	java/io/IOException
    //   56	72	370	finally
    //   77	86	376	finally
    //   222	228	376	finally
    //   233	244	376	finally
    //   56	72	383	java/lang/Throwable
    //   77	86	390	java/lang/Throwable
  }
  
  public OlympicActConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig;
  }
  
  public OlympicDPC a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
  }
  
  public OlympicResources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources;
  }
  
  public OlympicTorchManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager = new OlympicTorchManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager;
  }
  
  /* Error */
  public TorchInfo a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 167	com/tencent/mobileqq/olympic/OlympicManager:jdField_c_of_type_ArrayOfByte	[B
    //   9: astore 6
    //   11: aload 6
    //   13: monitorenter
    //   14: new 1245	java/io/File
    //   17: dup
    //   18: getstatic 393	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 1391	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   24: new 291	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 1438
    //   34: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 226	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: invokevirtual 1396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   44: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 1399	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 1402	java/io/File:exists	()Z
    //   58: istore 7
    //   60: iload 7
    //   62: ifeq +361 -> 423
    //   65: new 1404	java/io/FileInputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 1407	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: astore_2
    //   74: new 1409	java/io/ObjectInputStream
    //   77: dup
    //   78: new 1411	java/io/BufferedInputStream
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 1414	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: invokespecial 1415	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 1418	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   94: checkcast 805	com/tencent/mobileqq/olympic/TorchInfo
    //   97: astore_3
    //   98: aload_0
    //   99: getfield 684	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo	Lcom/tencent/mobileqq/olympic/TorchInfo;
    //   102: ifnonnull +8 -> 110
    //   105: aload_0
    //   106: aload_3
    //   107: putfield 684	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo	Lcom/tencent/mobileqq/olympic/TorchInfo;
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 1421	java/io/ObjectInputStream:close	()V
    //   118: aload_3
    //   119: astore_1
    //   120: aload_2
    //   121: ifnull +9 -> 130
    //   124: aload_2
    //   125: invokevirtual 1422	java/io/FileInputStream:close	()V
    //   128: aload_3
    //   129: astore_1
    //   130: aload 6
    //   132: monitorexit
    //   133: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +29 -> 165
    //   139: ldc 23
    //   141: iconst_2
    //   142: new 291	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 1440
    //   152: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 411	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_1
    //   166: areturn
    //   167: astore_1
    //   168: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -53 -> 118
    //   174: ldc 23
    //   176: iconst_2
    //   177: ldc_w 368
    //   180: aload_1
    //   181: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -66 -> 118
    //   187: astore_1
    //   188: aload 6
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    //   193: astore_2
    //   194: aload_3
    //   195: astore_1
    //   196: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq -69 -> 130
    //   202: ldc 23
    //   204: iconst_2
    //   205: ldc_w 368
    //   208: aload_2
    //   209: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_3
    //   213: astore_1
    //   214: goto -84 -> 130
    //   217: astore 5
    //   219: aconst_null
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_1
    //   223: aload 4
    //   225: astore_2
    //   226: aload 5
    //   228: astore 4
    //   230: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +14 -> 247
    //   236: ldc 23
    //   238: iconst_2
    //   239: ldc_w 368
    //   242: aload 4
    //   244: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 1421	java/io/ObjectInputStream:close	()V
    //   255: aload_2
    //   256: ifnull +164 -> 420
    //   259: aload_2
    //   260: invokevirtual 1422	java/io/FileInputStream:close	()V
    //   263: goto -133 -> 130
    //   266: astore_3
    //   267: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -15 -> 255
    //   273: ldc 23
    //   275: iconst_2
    //   276: ldc_w 368
    //   279: aload_3
    //   280: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: goto -28 -> 255
    //   286: astore_2
    //   287: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +13 -> 303
    //   293: ldc 23
    //   295: iconst_2
    //   296: ldc_w 368
    //   299: aload_2
    //   300: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   303: goto -173 -> 130
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_2
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 1421	java/io/ObjectInputStream:close	()V
    //   317: aload_2
    //   318: ifnull +7 -> 325
    //   321: aload_2
    //   322: invokevirtual 1422	java/io/FileInputStream:close	()V
    //   325: aload_1
    //   326: athrow
    //   327: astore_3
    //   328: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq -14 -> 317
    //   334: ldc 23
    //   336: iconst_2
    //   337: ldc_w 368
    //   340: aload_3
    //   341: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   344: goto -27 -> 317
    //   347: astore_2
    //   348: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq -26 -> 325
    //   354: ldc 23
    //   356: iconst_2
    //   357: ldc_w 368
    //   360: aload_2
    //   361: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: goto -39 -> 325
    //   367: astore_1
    //   368: goto -59 -> 309
    //   371: astore 4
    //   373: aload_1
    //   374: astore_3
    //   375: aload 4
    //   377: astore_1
    //   378: goto -69 -> 309
    //   381: astore_1
    //   382: goto -73 -> 309
    //   385: astore 4
    //   387: aconst_null
    //   388: astore_1
    //   389: aconst_null
    //   390: astore_3
    //   391: goto -161 -> 230
    //   394: astore 4
    //   396: aconst_null
    //   397: astore 5
    //   399: aload_1
    //   400: astore_3
    //   401: aload 5
    //   403: astore_1
    //   404: goto -174 -> 230
    //   407: astore 4
    //   409: aload_3
    //   410: astore 5
    //   412: aload_1
    //   413: astore_3
    //   414: aload 5
    //   416: astore_1
    //   417: goto -187 -> 230
    //   420: goto -290 -> 130
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -295 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	OlympicManager
    //   53	113	1	localObject1	Object
    //   167	14	1	localIOException1	java.io.IOException
    //   187	5	1	localObject2	Object
    //   195	28	1	localTorchInfo1	TorchInfo
    //   306	20	1	localObject3	Object
    //   367	7	1	localObject4	Object
    //   377	1	1	localObject5	Object
    //   381	1	1	localObject6	Object
    //   388	37	1	localObject7	Object
    //   73	52	2	localFileInputStream	java.io.FileInputStream
    //   193	16	2	localIOException2	java.io.IOException
    //   225	35	2	localObject8	Object
    //   286	14	2	localIOException3	java.io.IOException
    //   308	14	2	localObject9	Object
    //   347	14	2	localIOException4	java.io.IOException
    //   1	251	3	localTorchInfo2	TorchInfo
    //   266	48	3	localIOException5	java.io.IOException
    //   327	14	3	localIOException6	java.io.IOException
    //   374	40	3	localObject10	Object
    //   3	240	4	localObject11	Object
    //   371	5	4	localObject12	Object
    //   385	1	4	localThrowable1	Throwable
    //   394	1	4	localThrowable2	Throwable
    //   407	1	4	localThrowable3	Throwable
    //   217	10	5	localThrowable4	Throwable
    //   397	18	5	localObject13	Object
    //   9	180	6	arrayOfByte	byte[]
    //   58	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   114	118	167	java/io/IOException
    //   14	60	187	finally
    //   114	118	187	finally
    //   124	128	187	finally
    //   130	133	187	finally
    //   168	184	187	finally
    //   188	191	187	finally
    //   196	212	187	finally
    //   251	255	187	finally
    //   259	263	187	finally
    //   267	283	187	finally
    //   287	303	187	finally
    //   313	317	187	finally
    //   321	325	187	finally
    //   325	327	187	finally
    //   328	344	187	finally
    //   348	364	187	finally
    //   124	128	193	java/io/IOException
    //   65	74	217	java/lang/Throwable
    //   251	255	266	java/io/IOException
    //   259	263	286	java/io/IOException
    //   65	74	306	finally
    //   313	317	327	java/io/IOException
    //   321	325	347	java/io/IOException
    //   74	90	367	finally
    //   90	98	371	finally
    //   98	110	371	finally
    //   230	247	381	finally
    //   74	90	385	java/lang/Throwable
    //   90	98	394	java/lang/Throwable
    //   98	110	407	java/lang/Throwable
  }
  
  public TorchInfo a(torch_transfer.TorchbearerInfo paramTorchbearerInfo)
  {
    if ((paramTorchbearerInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo == null)) {
      return null;
    }
    Object localObject = new TorchInfo(paramTorchbearerInfo);
    TorchInfo localTorchInfo = this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.clone();
    localTorchInfo.transfer_num = ((TorchInfo)localObject).transfer_num;
    localTorchInfo.cur_city_id = ((TorchInfo)localObject).cur_city_id;
    localTorchInfo.reach_next_city_num = ((TorchInfo)localObject).reach_next_city_num;
    if (paramTorchbearerInfo.msg_limit_info.has())
    {
      localTorchInfo.transferOverLimit = ((TorchInfo)localObject).transferOverLimit;
      localTorchInfo.transferLimitTs = ((TorchInfo)localObject).transferLimitTs;
    }
    localTorchInfo.business_entry_seq = ((TorchInfo)localObject).business_entry_seq;
    localTorchInfo.business_entry_new = ((TorchInfo)localObject).business_entry_new;
    if (paramTorchbearerInfo.msg_torcher_rank_info.has())
    {
      if (((TorchInfo)localObject).ranking > localTorchInfo.ranking) {
        localTorchInfo.ranking = ((TorchInfo)localObject).ranking;
      }
      if ((localTorchInfo.isOnlyTorcher) && (!((TorchInfo)localObject).isOnlyTorcher)) {
        localTorchInfo.isOnlyTorcher = ((TorchInfo)localObject).isOnlyTorcher;
      }
    }
    paramTorchbearerInfo = ((TorchInfo)localObject).city_list.iterator();
    label332:
    for (;;)
    {
      if (paramTorchbearerInfo.hasNext())
      {
        localObject = (TorchInfo.CityInfo)paramTorchbearerInfo.next();
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.city_list.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (((TorchInfo.CityInfo)localIterator.next()).city_id != ((TorchInfo.CityInfo)localObject).city_id);
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label332;
        }
        localTorchInfo.city_list.add(localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OlympicManager", 2, "add new city,id:" + ((TorchInfo.CityInfo)localObject).city_id);
        break;
        a(localTorchInfo);
        if ("handlePush0xb4, torchInfo=" + localTorchInfo == null) {}
        for (paramTorchbearerInfo = "null";; paramTorchbearerInfo = localTorchInfo.toString())
        {
          OlympicUtil.b("OlympicManager", new Object[] { paramTorchbearerInfo });
          return localTorchInfo;
        }
      }
    }
  }
  
  public String a(long paramLong)
  {
    List localList = a();
    if ((localList == null) || (localList.size() < 6)) {
      return "";
    }
    if (paramLong == 1L) {
      return (String)localList.get(0);
    }
    if (paramLong == 2L) {
      return (String)localList.get(1);
    }
    if (paramLong == 3L) {
      return (String)localList.get(2);
    }
    if (paramLong == 4L) {
      return (String)localList.get(3);
    }
    if (paramLong == 5L) {
      return (String)localList.get(4);
    }
    if (paramLong == 6L) {
      return (String)localList.get(5);
    }
    return "";
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject6 = "";
      Object localObject5 = "";
      Object localObject4 = "";
      Object localObject3 = "";
      Object localObject2 = "";
      Object localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
      {
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("cityname", "city1");
        String str1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("cityname", "city2");
        String str2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("cityname", "city3");
        String str3 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("cityname", "city4");
        String str4 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("cityname", "city5");
        String str5 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("cityname", "city6");
        localObject1 = str5;
        localObject2 = str4;
        localObject3 = str3;
        localObject4 = str2;
        localObject5 = str1;
        localObject6 = localObject7;
        if (QLog.isColorLevel())
        {
          QLog.d("OlympicManager", 2, "getCityNameList,xml|city1Name:" + (String)localObject7 + ",city2Name:" + str1 + ",city3Name:" + str3 + ",city3Name:" + str3 + ",city5Name:" + str4 + ",city6Name:" + str5);
          localObject6 = localObject7;
          localObject5 = str1;
          localObject4 = str2;
          localObject3 = str3;
          localObject2 = str4;
          localObject1 = str5;
        }
      }
      Object localObject7 = localObject6;
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        localObject7 = BaseApplicationImpl.getContext().getString(2131372640);
      }
      localObject6 = localObject5;
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        localObject6 = BaseApplicationImpl.getContext().getString(2131372641);
      }
      localObject5 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject5 = BaseApplicationImpl.getContext().getString(2131372642);
      }
      localObject4 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject4 = BaseApplicationImpl.getContext().getString(2131372643);
      }
      localObject3 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject3 = BaseApplicationImpl.getContext().getString(2131372644);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = BaseApplicationImpl.getContext().getString(2131372645);
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject7);
      this.jdField_a_of_type_JavaUtilList.add(localObject6);
      this.jdField_a_of_type_JavaUtilList.add(localObject5);
      this.jdField_a_of_type_JavaUtilList.add(localObject4);
      this.jdField_a_of_type_JavaUtilList.add(localObject3);
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "getCityNameList:" + this.jdField_a_of_type_JavaUtilList.toString());
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3).sendToTarget();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicManager", 2, "updateTorchbearerFlag.flag=" + paramInt + ",mTorchbearerFlag=" + this.x);
    }
    if (this.x == paramInt) {}
    while ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    if ((this.x == 0) && (paramInt == 1)) {
      this.jdField_e_of_type_Boolean = true;
    }
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      this.x = paramInt;
      if (this.x == 1) {
        this.E = 0;
      }
      ThreadManager.a(new trg(this, paramInt), 5, null, false);
      return;
    }
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "checkBreathOnConfigTime ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig == null) {}
    for (;;)
    {
      return;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("RemindTime", "Begin");
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("RemindTime", "End");
      String str1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("RemindTime", "Times");
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "checkBreathOnConfigTime ,beginTimeStr = " + str2 + ",endTimeStr = " + (String)localObject + ",totalDays" + str1);
      }
      if (str1 == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("OlympicManager", 2, "checkBreathOnConfigTime totalDays is null");
        return;
      }
      if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null)
      {
        this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        this.jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      }
      long l1 = -1L;
      long l3 = -1L;
      if (jdField_a_of_type_JavaUtilMap.containsKey(str2))
      {
        l1 = ((Long)jdField_a_of_type_JavaUtilMap.get(str2)).longValue();
        label219:
        if (!jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {
          break label373;
        }
        l2 = ((Long)jdField_a_of_type_JavaUtilMap.get(localObject)).longValue();
        label250:
        l3 = paramLong % 86400000L;
        if ((l3 > l2 % 86400000L) || (l3 < l1 % 86400000L)) {
          break label423;
        }
      }
      label373:
      label423:
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label427;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        if (!((SharedPreferences)localObject).getBoolean("in_breath_procedure", false)) {
          break label429;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OlympicManager", 2, "checkBreathOnConfigTime inProcedure return");
        return;
        try
        {
          l2 = this.jdField_a_of_type_JavaTextSimpleDateFormat.parse(str2).getTime();
          l1 = l2;
          jdField_a_of_type_JavaUtilMap.put(str2, Long.valueOf(l2));
          l1 = l2;
        }
        catch (ParseException localParseException2) {}
        break label219;
        l2 = l3;
        try
        {
          l3 = this.jdField_a_of_type_JavaTextSimpleDateFormat.parse((String)localObject).getTime();
          l2 = l3;
          jdField_a_of_type_JavaUtilMap.put(localObject, Long.valueOf(l3));
          l2 = l3;
        }
        catch (ParseException localParseException1) {}
        break label250;
      }
      label427:
      continue;
      label429:
      l1 = localParseException1.getLong("breath_time_config_type", -1L);
      long l2 = paramLong - paramLong % 86400000L;
      int i3 = localParseException1.getInt("breath_days_config_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "checkBreathOnConfigTime.lastBreatheTime=" + l1 + ",currentTime=" + paramLong + ",zeroTime=" + l2 + ",breathDays = " + i3 + ",totalDays = " + str1);
      }
      int i2 = 0;
      try
      {
        i1 = Integer.parseInt(str1);
        if ((l1 >= l2) || (i3 >= i1)) {
          continue;
        }
        localParseException1.edit().putLong("breath_time_config_type", paramLong).commit();
        localParseException1.edit().putInt("breath_days_config_type", i3 + 1).commit();
        localParseException1.edit().putBoolean("in_breath_procedure", true).commit();
        localParseException1.edit().putInt("breath_remind_type_value", 3).commit();
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "checkBreathOnConfigTime set inProcedure true");
        }
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, 3, 0).sendToTarget();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("OlympicManager", 2, "checkBreathOnConfigTime NumberFormatException", localNumberFormatException);
            i1 = i2;
          }
        }
      }
    }
  }
  
  /* Error */
  public void a(OlympicPredownInfo paramOlympicPredownInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +33 -> 36
    //   6: ldc_w 1142
    //   9: astore_2
    //   10: ldc 23
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc_w 1631
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_2
    //   25: aastore
    //   26: invokestatic 700	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_1
    //   30: ifnonnull +11 -> 41
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_1
    //   37: astore_2
    //   38: goto -28 -> 10
    //   41: aload_0
    //   42: getfield 267	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   45: invokevirtual 1634	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 1637	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   53: aload_0
    //   54: getfield 267	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: aload_1
    //   58: invokevirtual 1640	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   61: aload_2
    //   62: invokevirtual 1642	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   65: aload_2
    //   66: invokevirtual 1643	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   69: goto -36 -> 33
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 1385	java/lang/Exception:printStackTrace	()V
    //   88: aload_2
    //   89: invokevirtual 1643	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   92: goto -59 -> 33
    //   95: astore_1
    //   96: aload_2
    //   97: invokevirtual 1643	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	OlympicManager
    //   0	102	1	paramOlympicPredownInfo	OlympicPredownInfo
    //   9	88	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	29	72	finally
    //   41	49	72	finally
    //   65	69	72	finally
    //   88	92	72	finally
    //   96	102	72	finally
    //   49	65	77	java/lang/Exception
    //   49	65	95	finally
    //   78	88	95	finally
  }
  
  public void a(OlyimpicConfig paramOlyimpicConfig)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "saveConfigFile.config=" + paramOlyimpicConfig);
        }
        if (paramOlyimpicConfig != null) {
          continue;
        }
      }
      finally
      {
        try
        {
          ByteArrayOutputStream localByteArrayOutputStream;
          ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
          localObjectOutputStream.writeObject(paramOlyimpicConfig);
          localObjectOutputStream.close();
          localByteArrayOutputStream.close();
          FileUtils.a(new File(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir(), "olympic_shuayishua_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
        }
        catch (Throwable paramOlyimpicConfig)
        {
          paramOlyimpicConfig.printStackTrace();
        }
        paramOlyimpicConfig = finally;
      }
      return;
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
  }
  
  public void a(OlympicActConfig paramOlympicActConfig)
  {
    OlympicUtil.b("OlympicManager", new Object[] { "onGetActConfig" });
    if (paramOlympicActConfig == null)
    {
      OlympicUtil.b("OlympicManager", new Object[] { "onGetActConfig, config is null!" });
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig = paramOlympicActConfig;
      a();
      ThreadManager.a(new trk(this), 5, null, true);
      return;
    }
  }
  
  public void a(OlympicListener paramOlympicListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "setOlympicListener.listener=" + paramOlympicListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener = paramOlympicListener;
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
  }
  
  public void a(TorchInfo paramTorchInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "updateTorchInfo.info=" + paramTorchInfo + ",[mTorchbearerInfo] = " + this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo);
    }
    if (paramTorchInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.transfer_num < paramTorchInfo.transfer_num)) {
      ThreadManager.a(new trh(this, paramTorchInfo), 5, null, false);
    }
    synchronized (this.jdField_c_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo = paramTorchInfo;
      ThreadManager.a(new tri(this, paramTorchInfo), 5, null, false);
      return;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (paramString == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      long l1;
      try
      {
        OlympicUtil.b("OlympicManager", new Object[] { "updateEntity, url=", localObject1, ", dailyInc=", Integer.valueOf(paramInt) });
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool)
        {
          return;
          localObject1 = paramString;
          continue;
        }
        l1 = System.currentTimeMillis();
        localObject1 = a(paramString);
        if (localObject1 == null)
        {
          localObject1 = new OlympicPredownInfo();
          ((OlympicPredownInfo)localObject1).dailyRetryCount = 0;
          ((OlympicPredownInfo)localObject1).url = paramString;
          ((OlympicPredownInfo)localObject1).dailyStartTime = l1;
          ((OlympicPredownInfo)localObject1).totalRetryCount = 0;
          a((OlympicPredownInfo)localObject1);
          continue;
        }
        if (paramBoolean) {
          break label230;
        }
      }
      finally {}
      if (((OlympicPredownInfo)localObject1).dailyStartTime >= 86400000L)
      {
        ((OlympicPredownInfo)localObject1).dailyRetryCount = paramInt;
        ((OlympicPredownInfo)localObject1).dailyStartTime = l1;
        ((OlympicPredownInfo)localObject1).totalRetryCount += paramInt;
        label170:
        paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      }
      try
      {
        paramString.a();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
        paramString.c();
        paramString.b();
        continue;
        ((OlympicPredownInfo)localObject1).dailyRetryCount += paramInt;
        ((OlympicPredownInfo)localObject1).totalRetryCount += paramInt;
        break label170;
        label230:
        ((OlympicPredownInfo)localObject1).dailyRetryCount = 0;
        ((OlympicPredownInfo)localObject1).dailyStartTime = l1;
        ((OlympicPredownInfo)localObject1).totalRetryCount = 0;
        break label170;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        paramString.b();
      }
      finally
      {
        paramString.b();
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean(paramString, paramBoolean).commit();
    if ("olympic_entrance_setting".equals(paramString)) {
      a();
    }
  }
  
  public void a(submsgtype0x78.MsgBody paramMsgBody)
  {
    boolean bool = paramMsgBody.uint32_version.has();
    int i1 = paramMsgBody.uint32_version.get();
    int i2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "handlePush, " + bool + ", " + i2 + ", " + i1);
    }
    if ((i1 != i2) && (bool)) {
      OlympicServlet.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = 900000L;
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "notifyBreathRealBegin,isRecovery = " + paramBoolean);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    long l3 = l2 - localSharedPreferences.getLong("breath_real_begin_time", -1L);
    if (paramBoolean) {
      if (l3 > 900000L) {
        l1 = 0L;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, l1);
      return;
      l1 = 900000L - l3;
      continue;
      localSharedPreferences.edit().putLong("breath_real_begin_time", l2).commit();
    }
  }
  
  public boolean a()
  {
    return this.x == 1;
  }
  
  public boolean a(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
      return ((a()) && (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.transfer_num >= 1L)) || (a().a(paramString));
    }
    return a().a(paramString);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean(paramString, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("OlympicManager", 2, "getOlympicSettingFlag " + paramString + " " + paramBoolean);
    }
    return paramBoolean;
  }
  
  public long[] a()
  {
    ShuayishuaConfig localShuayishuaConfig = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
    if ((localShuayishuaConfig == null) || (localShuayishuaConfig.type != 2)) {}
    long l3;
    do
    {
      return null;
      l3 = NetConnInfoCenter.getServerTimeMillis();
    } while ((l3 < localShuayishuaConfig.uiBegin) || (l3 > localShuayishuaConfig.uiBegin + localShuayishuaConfig.timer));
    long l2 = localShuayishuaConfig.uiBegin + localShuayishuaConfig.timer;
    long l1 = l2;
    if (l2 > localShuayishuaConfig.realEnd) {
      l1 = localShuayishuaConfig.realEnd;
    }
    return new long[] { localShuayishuaConfig.timer, l1 - l3 };
  }
  
  public int b()
  {
    OlyimpicConfig localOlyimpicConfig2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig;
    OlyimpicConfig localOlyimpicConfig1 = localOlyimpicConfig2;
    if (localOlyimpicConfig2 == null) {
      localOlyimpicConfig1 = a();
    }
    if (localOlyimpicConfig1 == null) {
      return 0;
    }
    return localOlyimpicConfig1.version;
  }
  
  public TorchInfo b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "chechBreathOnRecovery");
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    int i1;
    if (localSharedPreferences.getBoolean("in_breath_procedure", false))
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = localSharedPreferences.getLong("breath_real_begin_time", -1L);
      i1 = localSharedPreferences.getInt("breath_remind_type_value", -1);
      if (l1 - l2 <= 900000L) {
        break label89;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "chechBreathOnRecovery more than 5min ");
      }
    }
    return;
    label89:
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "chechBreathOnRecovery less than 5min,remindType =  " + i1);
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, i1, 1).sendToTarget();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(TorchInfo paramTorchInfo)
  {
    if (paramTorchInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "preDecodeActPic");
      }
      Object localObject;
      if ((OlympicUtil.a(paramTorchInfo.torch_pic_url) == null) && (jdField_a_of_type_Boolean))
      {
        localObject = OlympicResources.a() + paramTorchInfo.torch_pic_md5;
        if (jdField_a_of_type_Boolean)
        {
          localObject = OlympicUtil.a(paramTorchInfo.torch_pic_url, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC, 0);
          if (((Pair)localObject).second != null) {
            jdField_a_of_type_AndroidGraphicsBitmap = (Bitmap)((Pair)localObject).second;
          }
        }
      }
      if ((paramTorchInfo.city_list != null) && (paramTorchInfo.city_list.size() > 0))
      {
        long l1 = paramTorchInfo.cur_city_id;
        localObject = paramTorchInfo.city_list.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramTorchInfo = (TorchInfo.CityInfo)((Iterator)localObject).next();
          if (paramTorchInfo.city_id == l1) {
            if ((OlympicUtil.a(paramTorchInfo.city_pic_url) == null) && (jdField_a_of_type_Boolean))
            {
              localObject = OlympicResources.a() + paramTorchInfo.city_pic_md5;
              if (jdField_a_of_type_Boolean)
              {
                paramTorchInfo = OlympicUtil.a(paramTorchInfo.city_pic_url, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC, 2);
                if (paramTorchInfo.second != null) {
                  jdField_a_of_type_ComTencentUtilPair = new Pair(Long.valueOf(l1), paramTorchInfo.second);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("olympic_atend_flag", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicManager", 2, "showTorch " + paramString);
    }
    if (j()) {
      if (QLog.isColorLevel()) {
        QLog.i("OlympicManager", 2, "close entrace,return false. showTorch: " + paramString);
      }
    }
    while (c(paramString)) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "notifyBreathEndForPullDown");
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    localSharedPreferences.edit().putBoolean("in_breath_procedure", false).commit();
    localSharedPreferences.edit().putInt("breath_remind_type_value", -1).commit();
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(12)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
        {
          bool = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.save2File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          OlympicUtil.b("OlympicManager", new Object[] { "saveActConfigToLocal, result=", Boolean.valueOf(bool) });
          return bool;
        }
      }
      boolean bool = false;
      continue;
      bool = false;
    }
  }
  
  public boolean c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicTorchManager", 2, "torchExpired " + paramString);
    }
    for (;;)
    {
      String str;
      boolean bool;
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig == null) {
          return true;
        }
        str = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString(paramString, "Begin");
        paramString = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString(paramString, "End");
        if (QLog.isColorLevel()) {
          QLog.i("OlympicTorchManager", 2, "torchExpired,start:" + str + " end:" + paramString);
        }
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        if (jdField_a_of_type_JavaUtilMap.containsKey(str))
        {
          l1 = ((Long)jdField_a_of_type_JavaUtilMap.get(str)).longValue();
          if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
            break label336;
          }
          l2 = ((Long)jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
          if ((l1 <= 0L) || (l2 <= 0L)) {
            break label381;
          }
          l3 = NetConnInfoCenter.getServerTimeMillis();
          if ((l3 >= l1) && (l3 < l2)) {
            break label375;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("OlympicTorchManager", 2, "torchExpired:" + bool + ",s = " + l1 + ",n = " + l3 + ",e = " + l2);
          }
          return bool;
        }
      }
      long l1 = OlympicUtil.a(str);
      if (l1 > 0L) {
        jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l1));
      }
      continue;
      label336:
      long l3 = OlympicUtil.a(paramString);
      long l2 = l3;
      if (l3 > 0L)
      {
        jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l3));
        l2 = l3;
        continue;
        label375:
        bool = false;
        continue;
        label381:
        bool = true;
        l3 = 0L;
      }
    }
    return true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "rmOlympicListener......");
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener = null;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig == null) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    do
    {
      return false;
      bool1 = a();
      bool2 = e();
      bool3 = f();
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "isTorchBearer:" + bool1 + ",showActPageSetting:" + bool2 + ",showFlagSetting:" + bool3);
      }
    } while ((!bool1) || ((!bool2) && (!bool3)));
    return true;
  }
  
  public boolean d(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    int i2;
    label55:
    label102:
    label113:
    label119:
    do
    {
      long l1;
      do
      {
        return bool1;
        paramString = a(paramString);
        l1 = System.currentTimeMillis();
        bool1 = bool2;
      } while (paramString == null);
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
      {
        i1 = 3;
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC != null) {
          break label102;
        }
        i2 = 1000;
        if ((paramString.dailyRetryCount < i1) || (paramString.totalRetryCount >= i2)) {
          break label119;
        }
        if (l1 - paramString.dailyStartTime <= 86400000L) {
          break label113;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        return bool1;
        i1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.k;
        break;
        i2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.l;
        break label55;
      }
      bool1 = bool2;
    } while (paramString.totalRetryCount < i2);
    return false;
  }
  
  public void e()
  {
    this.x = 1;
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5).sendToTarget();
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    if (this.z == 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "stopSound, " + this.A + ", " + this.z);
    }
    if (this.A != 0) {}
    try
    {
      if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
        this.jdField_a_of_type_AndroidMediaSoundPool.pause(this.A);
      }
      this.A = 0;
      this.z = 1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo.transfer_num > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OlympicManager", 2, "shouldShowFlagSetting null or not transfer");
    return false;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MCard", "Begin");
    String str2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MCard", "End");
    String str3 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("C2CAIO", "Begin");
    String str4 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("C2CAIO", "End");
    String str5 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("GroupAIO", "Begin");
    String str6 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("GroupAIO", "End");
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "shouldShowFlagSetting|cardBeginTimeStr:" + str1 + ",cardEndTimeStr:" + str2 + "|aioBeginTimeStr:" + str3 + ",aioEndTimeStr:" + str4 + "|groupBeginTimeStr:" + str5 + ",groupEndTimeStr:" + str6);
    }
    long l1 = MessageCache.a() * 1000L;
    boolean bool1;
    label249:
    boolean bool2;
    if ((OlympicUtil.a(str1) < l1) && (OlympicUtil.a(str2) > l1))
    {
      bool1 = true;
      if ((OlympicUtil.a(str3) >= l1) || (OlympicUtil.a(str4) <= l1)) {
        break label376;
      }
      bool2 = true;
      label273:
      if ((OlympicUtil.a(str5) >= l1) || (OlympicUtil.a(str6) <= l1)) {
        break label382;
      }
    }
    label376:
    label382:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "shouldShowFlagSetting|isCardOpen:" + bool1 + ",isAioOpen:" + bool2 + ",isGroupOpen:" + bool3);
      }
      if ((!bool1) && (!bool2) && (!bool3)) {
        break;
      }
      return true;
      bool1 = false;
      break label249;
      bool2 = false;
      break label273;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "startGrab....");
    }
    ShuayishuaConfig localShuayishuaConfig = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
    if ((localShuayishuaConfig != null) && (localShuayishuaConfig.type == 2) && (localShuayishuaConfig.uiBegin == localShuayishuaConfig.realEnd))
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      if ((l1 > localShuayishuaConfig.realBegin) && (l1 < localShuayishuaConfig.realEnd))
      {
        localShuayishuaConfig.uiBegin = l1;
        a();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80069C6", "0X80069C6", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "startGrab set uiBegin time..");
        }
        this.jdField_b_of_type_AndroidOsHandler.obtainMessage(10).sendToTarget();
      }
    }
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("olympic_atend_flag", false);
  }
  
  public void h()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("OlympicManager", 2, "grabTorch.begin.time=" + l1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
    ArrayList localArrayList1;
    if ((localObject != null) && (((ShuayishuaConfig)localObject).type == 2))
    {
      localArrayList1 = (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(((ShuayishuaConfig)localObject).id);
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList(60);
        localArrayList1.add(Long.valueOf(l1));
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(((ShuayishuaConfig)localObject).id, localArrayList1);
      }
    }
    else
    {
      if (this.x != 1) {
        break label143;
      }
      if (QLog.isColorLevel()) {
        QLog.i("OlympicManager", 2, "grabTorch.isAlreadyTorchbearer...");
      }
    }
    label143:
    label230:
    label354:
    label397:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localArrayList1.add(Long.valueOf(l1));
            break;
            if ((localObject == null) || (((ShuayishuaConfig)localObject).type != 2) || (l1 <= ((ShuayishuaConfig)localObject).realEnd - ((ShuayishuaConfig)localObject).timer)) {
              break label230;
            }
          } while (!QLog.isColorLevel());
          QLog.i("OlympicManager", 2, "grabTorch.last time do not need to send request. current = " + l1 + ",config.timer = " + ((ShuayishuaConfig)localObject).timer + ",config.realEnd = " + ((ShuayishuaConfig)localObject).realEnd);
          return;
          if (this.E >= this.D) {
            break label354;
          }
          if (QLog.isColorLevel()) {
            QLog.i("OlympicManager", 2, "grabTorch.tryCout=" + this.E + ",minTryCount=" + this.D);
          }
          if (this.E == 0) {
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9), 120000L);
          }
          this.E += 1;
          if (this.E == 1) {
            this.jdField_b_of_type_Long = l1;
          }
        } while (l1 - this.jdField_b_of_type_Long < 5000L);
        if (!this.g) {
          break label397;
        }
      } while (!QLog.isColorLevel());
      QLog.i("OlympicManager", 2, "grabTorch.isRequesting=" + this.g);
      return;
      if (!this.f) {
        break label596;
      }
      localObject = (OlympicHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(94);
      localArrayList1 = new ArrayList(5);
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
      {
        ArrayList localArrayList2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getChosenCityImageList();
        if ((localArrayList2 != null) && (localArrayList2.size() > 0))
        {
          int i1 = 0;
          while (i1 < localArrayList2.size())
          {
            OlympicActConfig.CityImage localCityImage = (OlympicActConfig.CityImage)localArrayList2.get(i1);
            if (localCityImage != null) {
              localArrayList1.add(Long.valueOf(localCityImage.picId));
            }
            i1 += 1;
          }
        }
      }
      if (localArrayList1.size() > 0) {
        break label531;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OlympicManager", 2, "grabTorch.list is empty....");
    return;
    label531:
    ((OlympicHandler)localObject).a(this.y, this.jdField_d_of_type_ArrayOfByte, this.jdField_e_of_type_ArrayOfByte, localArrayList1);
    for (;;)
    {
      this.g = true;
      this.i = NetConnInfoCenter.getServerTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OlympicManager", 2, "grabTorch.hasTicket=" + this.f);
      return;
      label596:
      if ((l1 >= this.i) && (l1 - this.i < this.j))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OlympicManager", 2, "grabTorch.interval is too short...");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OlympicManager", 2, "grabTorch mCurrentConfig is null!");
        return;
      }
      OlympicServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.id);
    }
  }
  
  public boolean h()
  {
    boolean bool = false;
    OlympicUtil.b("OlympicManager", new Object[] { "isNetworkCanPredown" });
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null) {}
    for (int i1 = 0; i1 == 1; i1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.j) {
      return true;
    }
    int i2 = NetworkUtil.a(BaseApplicationImpl.getContext());
    OlympicUtil.b("OlympicManager", new Object[] { "isNetworkCanPredown, type=", Integer.valueOf(i2) });
    if (i1 == 0) {
      if ((i2 != 1) && (i2 != 4)) {}
    }
    for (bool = true;; bool = true) {
      do
      {
        return bool;
      } while ((i2 != 1) && (i2 != 4) && (i2 != 3));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1 = 0L;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (QLog.isColorLevel()) {
            QLog.d("OlympicManager", 2, "handleMessage, MSG_UPDATE_CONFIG ,msg.obj = " + paramMessage.obj + ",mTorchbearerFlag = " + this.x);
          }
          if (paramMessage.obj == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig = null;
            this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig = null;
            if ((this.x != 1) && (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener != null)) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a();
            }
            this.j = 2500L;
            this.k = 180000L;
            this.l = 180000L;
          }
          for (;;)
          {
            l1 = NetConnInfoCenter.getServerTimeMillis();
            c(l1);
            b(l1);
            return false;
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig = ((OlyimpicConfig)paramMessage.obj);
            this.j = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig.grabInterval;
            this.k = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig.reportActiveInterval;
            this.l = this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig.reportNormalInterval;
            this.jdField_c_of_type_Boolean = false;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener == null);
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a(this.jdField_a_of_type_ComTencentMobileqqOlympicTorchInfo);
        return false;
        l1 = ((Long)paramMessage.obj).longValue();
        if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0) && (l1 > 0L)) {
          this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.B, this.C, l1, false));
        }
        this.C = 0;
        this.B = 0;
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
        return false;
        this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0L, false));
        this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 600000L);
        return false;
        this.E = 0;
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig == null);
      a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlyimpicConfig);
      return false;
      int i1 = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "MSG_BREATHE,type = " + i1 + ",isRecovery = " + bool);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a(true, bool, i1);
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putBoolean("in_breath_procedure", false).commit();
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "MSG_STOP_BREATHE");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener == null);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicListener.a(false, false, -1);
    return false;
  }
  
  public void i()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "deleteConfigFile...");
      }
      File localFile = new File(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir(), "olympic_shuayishua_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if ((localFile.delete()) && (!localFile.delete()))
      {
        boolean bool = localFile.delete();
        if (!bool) {}
      }
      return;
    }
    finally {}
  }
  
  public boolean i()
  {
    OlympicUtil.b("OlympicManager", new Object[] { "isNetworkCanPredown" });
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null) {}
    for (int i1 = 1; i1 == 1; i1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.n) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public void j()
  {
    // Byte code:
    //   0: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 23
    //   8: iconst_2
    //   9: ldc_w 1990
    //   12: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: lconst_0
    //   16: putstatic 1992	com/tencent/mobileqq/olympic/OlympicManager:jdField_c_of_type_Long	J
    //   19: new 1994	java/io/BufferedReader
    //   22: dup
    //   23: new 1996	java/io/InputStreamReader
    //   26: dup
    //   27: new 1404	java/io/FileInputStream
    //   30: dup
    //   31: ldc_w 1998
    //   34: invokespecial 2001	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 2002	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: invokespecial 2005	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_2
    //   44: aload_2
    //   45: astore_1
    //   46: aload_2
    //   47: invokevirtual 2008	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +91 -> 143
    //   55: aload_2
    //   56: astore_1
    //   57: aload_3
    //   58: ldc_w 1306
    //   61: invokevirtual 2012	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore_3
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: iconst_0
    //   69: aaload
    //   70: invokestatic 547	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	(Ljava/lang/String;)J
    //   73: putstatic 1992	com/tencent/mobileqq/olympic/OlympicManager:jdField_c_of_type_Long	J
    //   76: aload_2
    //   77: astore_1
    //   78: aload_3
    //   79: iconst_1
    //   80: aaload
    //   81: invokestatic 599	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   84: i2l
    //   85: putstatic 2014	com/tencent/mobileqq/olympic/OlympicManager:jdField_e_of_type_Long	J
    //   88: aload_2
    //   89: astore_1
    //   90: getstatic 2014	com/tencent/mobileqq/olympic/OlympicManager:jdField_e_of_type_Long	J
    //   93: lconst_1
    //   94: lcmp
    //   95: ifge +9 -> 104
    //   98: aload_2
    //   99: astore_1
    //   100: lconst_1
    //   101: putstatic 2014	com/tencent/mobileqq/olympic/OlympicManager:jdField_e_of_type_Long	J
    //   104: aload_2
    //   105: astore_1
    //   106: getstatic 1992	com/tencent/mobileqq/olympic/OlympicManager:jdField_c_of_type_Long	J
    //   109: lconst_0
    //   110: lcmp
    //   111: ifeq +11 -> 122
    //   114: aload_2
    //   115: astore_1
    //   116: invokestatic 788	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   119: putstatic 2016	com/tencent/mobileqq/olympic/OlympicManager:jdField_d_of_type_Long	J
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 239	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   128: aload_0
    //   129: getfield 239	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   132: iconst_3
    //   133: invokevirtual 1038	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   136: ldc2_w 1335
    //   139: invokevirtual 1327	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   142: pop
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 2017	java/io/BufferedReader:close	()V
    //   151: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +97 -> 251
    //   157: ldc 23
    //   159: iconst_2
    //   160: new 291	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 2019
    //   170: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 1992	com/tencent/mobileqq/olympic/OlympicManager:jdField_c_of_type_Long	J
    //   176: invokevirtual 530	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   179: ldc_w 660
    //   182: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: getstatic 1992	com/tencent/mobileqq/olympic/OlympicManager:jdField_c_of_type_Long	J
    //   188: invokestatic 663	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	(J)Ljava/lang/String;
    //   191: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc_w 665
    //   197: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 2021
    //   203: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: getstatic 2016	com/tencent/mobileqq/olympic/OlympicManager:jdField_d_of_type_Long	J
    //   209: invokevirtual 530	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 660
    //   215: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 2016	com/tencent/mobileqq/olympic/OlympicManager:jdField_d_of_type_Long	J
    //   221: invokestatic 663	com/tencent/mobileqq/olympic/utils/OlympicUtil:a	(J)Ljava/lang/String;
    //   224: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 665
    //   230: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 2023
    //   236: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: getstatic 2014	com/tencent/mobileqq/olympic/OlympicManager:jdField_e_of_type_Long	J
    //   242: invokevirtual 530	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   245: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 1001	java/lang/Throwable:printStackTrace	()V
    //   257: goto -106 -> 151
    //   260: astore_3
    //   261: aconst_null
    //   262: astore_2
    //   263: aload_2
    //   264: astore_1
    //   265: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +15 -> 283
    //   271: aload_2
    //   272: astore_1
    //   273: ldc 23
    //   275: iconst_2
    //   276: ldc_w 2025
    //   279: aload_3
    //   280: invokestatic 1628	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_2
    //   284: ifnull -133 -> 151
    //   287: aload_2
    //   288: invokevirtual 2017	java/io/BufferedReader:close	()V
    //   291: goto -140 -> 151
    //   294: astore_1
    //   295: aload_1
    //   296: invokevirtual 1001	java/lang/Throwable:printStackTrace	()V
    //   299: goto -148 -> 151
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_1
    //   305: aload_1
    //   306: ifnull +7 -> 313
    //   309: aload_1
    //   310: invokevirtual 2017	java/io/BufferedReader:close	()V
    //   313: aload_2
    //   314: athrow
    //   315: astore_1
    //   316: aload_1
    //   317: invokevirtual 1001	java/lang/Throwable:printStackTrace	()V
    //   320: goto -7 -> 313
    //   323: astore_2
    //   324: goto -19 -> 305
    //   327: astore_3
    //   328: goto -65 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	OlympicManager
    //   45	79	1	localBufferedReader1	java.io.BufferedReader
    //   252	2	1	localThrowable1	Throwable
    //   264	9	1	localBufferedReader2	java.io.BufferedReader
    //   294	2	1	localThrowable2	Throwable
    //   304	6	1	localObject1	Object
    //   315	2	1	localThrowable3	Throwable
    //   43	245	2	localBufferedReader3	java.io.BufferedReader
    //   302	12	2	localObject2	Object
    //   323	1	2	localObject3	Object
    //   50	29	3	localObject4	Object
    //   260	20	3	localThrowable4	Throwable
    //   327	1	3	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   147	151	252	java/lang/Throwable
    //   19	44	260	java/lang/Throwable
    //   287	291	294	java/lang/Throwable
    //   19	44	302	finally
    //   309	313	315	java/lang/Throwable
    //   46	51	323	finally
    //   57	65	323	finally
    //   67	76	323	finally
    //   78	88	323	finally
    //   90	98	323	finally
    //   100	104	323	finally
    //   106	114	323	finally
    //   116	122	323	finally
    //   124	143	323	finally
    //   265	271	323	finally
    //   273	283	323	finally
    //   46	51	327	java/lang/Throwable
    //   57	65	327	java/lang/Throwable
    //   67	76	327	java/lang/Throwable
    //   78	88	327	java/lang/Throwable
    //   90	98	327	java/lang/Throwable
    //   100	104	327	java/lang/Throwable
    //   106	114	327	java/lang/Throwable
    //   116	122	327	java/lang/Throwable
    //   124	143	327	java/lang/Throwable
  }
  
  public boolean j()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.getConfigString("MsgTabBG", "Wording");
      if ((str == null) || (!str.contains("alltaskoff"))) {
        break label75;
      }
    }
    label75:
    for (bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, "isCloseOlympicEntrace result = " + bool1);
      }
      return bool1;
    }
  }
  
  /* Error */
  public void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 226	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokestatic 758	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: invokestatic 2036	com/tencent/mobileqq/olympic/OlympicActConfig:readFromFile	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +18 -> 44
    //   29: ldc 23
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 2038
    //   40: aastore
    //   41: invokestatic 700	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: getfield 179	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ArrayOfByte	[B
    //   48: astore_2
    //   49: aload_2
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   55: ifnonnull +44 -> 99
    //   58: aload_0
    //   59: aload_1
    //   60: putfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_0
    //   66: invokevirtual 1676	com/tencent/mobileqq/olympic/OlympicManager:a	()V
    //   69: goto -58 -> 11
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +13 -> 94
    //   84: ldc 23
    //   86: iconst_2
    //   87: ldc_w 2040
    //   90: aload_1
    //   91: invokestatic 1628	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   94: aconst_null
    //   95: astore_1
    //   96: goto -71 -> 25
    //   99: aload_1
    //   100: ifnull -37 -> 63
    //   103: ldc 23
    //   105: iconst_2
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: ldc_w 2042
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_0
    //   118: getfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   121: getfield 2043	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   124: invokestatic 690	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic 700	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: getfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   135: getfield 2043	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   138: aload_1
    //   139: getfield 2043	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   142: if_icmpge -79 -> 63
    //   145: aload_0
    //   146: aload_1
    //   147: putfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   150: ldc 23
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: ldc_w 2045
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload_1
    //   165: getfield 2043	com/tencent/mobileqq/olympic/OlympicActConfig:version	I
    //   168: invokestatic 690	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aastore
    //   172: invokestatic 700	com/tencent/mobileqq/olympic/utils/OlympicUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: goto -112 -> 63
    //   178: astore_1
    //   179: aload_2
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	OlympicManager
    //   6	54	1	localOlympicActConfig1	OlympicActConfig
    //   72	4	1	localObject1	Object
    //   77	14	1	localException	Exception
    //   95	70	1	localOlympicActConfig2	OlympicActConfig
    //   178	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	72	finally
    //   14	25	72	finally
    //   29	44	72	finally
    //   44	51	72	finally
    //   65	69	72	finally
    //   78	94	72	finally
    //   181	183	72	finally
    //   14	25	77	java/lang/Exception
    //   51	63	178	finally
    //   63	65	178	finally
    //   103	175	178	finally
    //   179	181	178	finally
  }
  
  public void l()
  {
    boolean bool2 = true;
    int i1;
    int i2;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC = new OlympicDPC();
      i1 = (int)(DeviceInfoUtil.c() / 1024L / 1024L);
      i2 = ViewUtils.a();
      str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.olympic_act_config.name());
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_JavaLangString = str;
    }
    try
    {
      if (str.length() > 0)
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 9)
        {
          if (i1 <= Integer.valueOf(arrayOfString[0]).intValue()) {}
          for (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;; this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true)
          {
            if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Boolean = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.j = Integer.valueOf(arrayOfString[4]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.k = Integer.valueOf(arrayOfString[5]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.l = Integer.valueOf(arrayOfString[6]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.m = Integer.valueOf(arrayOfString[7]).intValue();
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.n = Integer.valueOf(arrayOfString[8]).intValue();
            bool1 = false;
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_a_of_type_Boolean = bool1;
            if (bool1)
            {
              if (i1 > 512) {
                break label478;
              }
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_d_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.j = 0;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.k = 3;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.l = 1000;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.m = 1;
              this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.n = 1;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.m != 1) {
              break label516;
            }
            OlympicUtil.a(bool2);
            if (QLog.isColorLevel()) {
              QLog.d("OlympicManager", 2, "loadDPCConfig|featureValue:" + str + ",systemTotalMem:" + i1 + ",screenWidth:" + i2 + ",isUseDefault:" + bool1 + ",dpc:" + this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.toString());
            }
            return;
            if (i2 > Integer.valueOf(arrayOfString[1]).intValue()) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OlympicManager", 2, "loadDPCConfig Exception:" + localException.toString());
        }
        boolean bool1 = true;
        continue;
        if (i2 <= Integer.valueOf(localException[2]).intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
          continue;
          label478:
          if (i2 <= 480)
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_b_of_type_Boolean = true;
          }
          else if (i2 <= 720)
          {
            this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC.jdField_c_of_type_Boolean = true;
            continue;
            label516:
            bool2 = false;
          }
        }
      }
    }
  }
  
  public void m()
  {
    OlympicUtil.b("OlympicManager", new Object[] { "clearActConfig" });
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig = null;
      a();
      return;
    }
  }
  
  /* Error */
  public void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   6: ifnonnull +15 -> 21
    //   9: ldc 23
    //   11: iconst_1
    //   12: ldc_w 2101
    //   15: invokestatic 411	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 1140	com/tencent/mobileqq/olympic/OlympicManager:jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig	Lcom/tencent/mobileqq/olympic/OlympicActConfig;
    //   26: iconst_0
    //   27: invokespecial 982	com/tencent/mobileqq/olympic/OlympicManager:a	(Lcom/tencent/mobileqq/olympic/OlympicActConfig;Z)V
    //   30: goto -12 -> 18
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	OlympicManager
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	33	finally
    //   21	30	33	finally
  }
  
  public void o()
  {
    ThreadManager.a(new trc(this), 5, null, false);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.type == 2))
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 1, this.B, this.C, this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig.uiBegin, true));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
    }
    if (this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.size() > 0)
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new OlympicManager.ShuayishuaReport(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clone(), 2, 0, 0, 0L, true));
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicResources$DownloadListener);
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager.a();
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
      this.jdField_a_of_type_AndroidMediaSoundPool = null;
    }
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if ((i1 >= 3) || (this.jdField_a_of_type_ArrayOfInt[i1] == paramInt1)) {
      if (i1 != 3) {
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
    this.jdField_a_of_type_ArrayOfBoolean[i1] = true;
    a(i1, true);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicManager", 2, "onReceive, " + paramInt + ", " + paramBoolean + ", " + paramBundle);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramBundle);
      return;
    }
    b(paramBoolean, paramBundle);
  }
  
  public void p()
  {
    ShuayishuaConfig localShuayishuaConfig = this.jdField_a_of_type_ComTencentMobileqqOlympicShuayishuaConfig;
    ArrayList localArrayList;
    if (localShuayishuaConfig != null)
    {
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(localShuayishuaConfig.id);
      if (localArrayList != null) {
        break label87;
      }
      localArrayList = new ArrayList(60);
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(localShuayishuaConfig.id, localArrayList);
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(8)) {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 600000L);
      }
      return;
      label87:
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    }
  }
  
  public void q()
  {
    if (OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OlympicManager", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act" });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig == null) {
        break label106;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicActConfig.version));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act", false, 0L, 0L, localHashMap, "", false);
    }
    for (;;)
    {
      OlympicUtil.a(BaseApplicationImpl.getContext(), "olympic_config_act");
      return;
      label106:
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "olympic_config_act", true, 0L, 0L, null, "", false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */