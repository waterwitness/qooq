package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;
import tf;
import tg;
import tk;
import tl;

public class FontManager
  implements Manager
{
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "FontManager";
  public static ConcurrentHashMap a;
  public static final int b = 2;
  public static final String b;
  public static final String c;
  public static volatile boolean c = false;
  public static final String d = "http://i.gtimg.cn/qqshow/admindata/comdata/vipfont_%d/android.zip";
  private static final int e = 20;
  public static final String e = "font_local.cfg";
  public static final String f = ".ttf";
  public static final String g = "fonttest";
  public static final String h = "font_test_switch";
  public static final String i = "font_test_type";
  public static final String j = "font_test_file";
  protected static final String l = "Font_download_succ";
  protected static final String m = "Font_download_cancel";
  protected static final String n = "Font_download";
  protected static final String o = "AIO_Font_download";
  public static final String p = "isUserOpenFontSwitch_";
  public static final String q = "font_open_switch";
  public static final String s = "/FontTest";
  public static final String t = Environment.getExternalStorageDirectory() + "/FontTest" + "/hanyifont/";
  public static final String u = Environment.getExternalStorageDirectory() + "/FontTest" + "/fangzhengfont/";
  public ETEngine a;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new tk(this, "param_WIFIFontDownloadFlow", "param_XGFontDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  public IPCDownloadListener a;
  public AtomicBoolean a;
  public boolean a;
  ConcurrentHashMap b;
  public AtomicBoolean b;
  public volatile boolean b;
  public int c;
  public AtomicBoolean c;
  private int jdField_d_of_type_Int = 5000000;
  public AtomicBoolean d;
  boolean jdField_d_of_type_Boolean = false;
  public AtomicBoolean e;
  private int f;
  public AtomicBoolean f;
  public AtomicBoolean g = new AtomicBoolean(false);
  public AtomicBoolean h;
  AtomicBoolean i = new AtomicBoolean(false);
  public String k;
  String r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = AppConstants.bj + "font_info";
    jdField_c_of_type_JavaLangString = AppConstants.bj + "font_tmp";
  }
  
  public FontManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.e = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.h = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    paramQQAppInterface = new StringBuilder();
    if (!this.jdField_d_of_type_Boolean) {
      paramQQAppInterface.append(DeviceInfoUtil.i()).append("; CPU number: ").append(DeviceInfoUtil.b()).append("; CPU frequency: ").append(DeviceInfoUtil.a()).append("; RAM: ").append(DeviceInfoUtil.c());
    }
    this.r = paramQQAppInterface.toString();
    this.jdField_a_of_type_Boolean = a();
    b(false);
  }
  
  public static int a(long paramLong)
  {
    return (int)(paramLong >> 16 & 0xFF);
  }
  
  public static long a(long paramLong)
  {
    return ((paramLong & 0xFF) << 8) + (paramLong >> 8 & 0xFF);
  }
  
  private FontInfo a()
  {
    FontInfo localFontInfo = (FontInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.k);
    if (localFontInfo != null) {
      return localFontInfo;
    }
    localFontInfo = new FontInfo(this.k.hashCode(), this.k);
    localFontInfo.b = this.jdField_c_of_type_Int;
    if (this.jdField_c_of_type_Int == 1)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return null;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(t + this.k, this.k.hashCode(), true);
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.k, localFontInfo);
      return localFontInfo;
      if (this.jdField_c_of_type_Int == 2) {
        localFontInfo.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(u + this.k);
      }
    }
  }
  
  private static String a(int paramInt)
  {
    String str = String.format("http://i.gtimg.cn/qqshow/admindata/comdata/vipfont_%d/android.zip", new Object[] { Integer.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getDownLoadResUri" + str);
    }
    return EmosmUtils.a("VIP_font", str);
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    switch (paramMessageRecord.istroop)
    {
    default: 
    case 0: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1010: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1025: 
    case 7100: 
    case 1: 
      do
      {
        return null;
        if (paramMessageRecord.isSend()) {
          return paramMessageRecord.selfuin;
        }
        return paramMessageRecord.frienduin;
      } while (AnonymousChatHelper.a(paramMessageRecord));
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      return paramMessageRecord.senderuin;
    }
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    return paramMessageRecord.senderuin;
  }
  
  private boolean b()
  {
    if (this.jdField_f_of_type_Int == -1)
    {
      if (((DeviceInfoUtil.b() < 2) || (DeviceInfoUtil.a() <= 1000L)) && ((DeviceInfoUtil.b() < 4) || (DeviceInfoUtil.c() <= 838860800L))) {
        break label72;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "getChatFontAbilityFromLocal return true");
      }
      this.jdField_f_of_type_Int = 1;
    }
    while (this.jdField_f_of_type_Int == 1)
    {
      return true;
      label72:
      this.jdField_f_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "getChatFontAbilityFromLocal return false. CPU number = " + DeviceInfoUtil.b() + " CPU Frequency = " + DeviceInfoUtil.a() + " Memory = " + DeviceInfoUtil.c());
      }
    }
    return false;
  }
  
  public int a(int paramInt)
  {
    String str = a(paramInt);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(false, str);
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "stopDownload  id=" + paramInt + ", ret=" + i1);
    }
    return i1;
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: new 373	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 376	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 379	java/io/File:exists	()Z
    //   19: ifne +123 -> 142
    //   22: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +12 -> 37
    //   28: ldc 12
    //   30: iconst_2
    //   31: ldc_w 381
    //   34: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_1
    //   38: invokevirtual 384	java/io/File:mkdirs	()Z
    //   41: ifne +18 -> 59
    //   44: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +12 -> 59
    //   50: ldc 12
    //   52: iconst_2
    //   53: ldc_w 386
    //   56: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +54 -> 116
    //   65: ldc 12
    //   67: iconst_2
    //   68: new 80	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 388
    //   78: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   84: lload_3
    //   85: lsub
    //   86: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: ldc_w 390
    //   92: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 392
    //   98: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 188	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   104: invokevirtual 395	java/util/concurrent/ConcurrentHashMap:size	()I
    //   107: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_0
    //   117: getfield 172	com/etrump/mixlayout/FontManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   120: iconst_1
    //   121: invokevirtual 398	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   124: aload_0
    //   125: getfield 126	com/etrump/mixlayout/FontManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   128: invokestatic 403	com/tencent/mobileqq/utils/VasUtils:a	(Lcom/tencent/common/app/AppInterface;)V
    //   131: getstatic 188	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   134: invokevirtual 395	java/util/concurrent/ConcurrentHashMap:size	()I
    //   137: istore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: iload_2
    //   141: ireturn
    //   142: aload_1
    //   143: new 405	th
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 408	th:<init>	(Lcom/etrump/mixlayout/FontManager;)V
    //   151: invokevirtual 412	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   154: pop
    //   155: goto -96 -> 59
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	FontManager
    //   0	163	1	paramString	String
    //   137	4	2	i1	int
    //   5	80	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   2	37	158	finally
    //   37	59	158	finally
    //   59	116	158	finally
    //   116	138	158	finally
    //   142	155	158	finally
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject1 = new File(jdField_b_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return null;
      try
      {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        localObject1 = BitmapFactory.decodeStream(new FileInputStream((File)localObject1));
        if (localObject1 == null) {
          continue;
        }
        return new BitmapDrawable((Bitmap)localObject1);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FontManager", 2, localFileNotFoundException.toString());
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public FontInfo a(int paramInt)
  {
    FontInfo localFontInfo = (FontInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject = localFontInfo;
    if (localFontInfo == null)
    {
      localObject = new File(jdField_b_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + paramInt + ".ttf");
      boolean bool = ((File)localObject).exists();
      if (bool)
      {
        localFontInfo = new FontInfo(paramInt, ((File)localObject).getAbsolutePath());
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localFontInfo);
      }
      localObject = localFontInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("FontManager", 2, "findFontInfo|find from local|fontExists=" + bool);
        localObject = localFontInfo;
      }
    }
    return (FontInfo)localObject;
  }
  
  public FontInfo a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Boolean = a();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FontManager", 2, "getUserFont fontFeatureSupported=" + this.jdField_a_of_type_Boolean);
      }
      return null;
    }
    if ((this.g.get()) && (!TextUtils.isEmpty(this.k))) {
      return a();
    }
    if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.i("FontManager", 2, "getUserFont Font cache not init.");
      }
      return null;
    }
    String str = a(paramChatMessage);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    ExtensionInfo localExtensionInfo = localFriendsManager.a(str, false);
    if (localExtensionInfo != null) {
      return a(paramChatMessage, localExtensionInfo);
    }
    ThreadManager.a(new tg(this, localFriendsManager, str, paramChatMessage), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.i("FontManager", 2, "getUserFont extensionInfo no cache.");
    }
    return null;
  }
  
  public FontInfo a(ChatMessage paramChatMessage, ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "doAfterGetExtensionInfo extensionInfo = null.");
      }
      paramChatMessage = null;
    }
    boolean bool;
    FontInfo localFontInfo;
    label471:
    do
    {
      return paramChatMessage;
      if (paramExtensionInfo.uVipFont == 0L) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "doAfterGetExtensionInfo fontID = " + paramExtensionInfo.uVipFont + " type = " + paramExtensionInfo.vipFontType);
      }
      if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
        bool = true;
      }
      for (;;)
      {
        localFontInfo = (FontInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf((int)paramExtensionInfo.uVipFont));
        if (localFontInfo == null) {
          break label471;
        }
        localFontInfo.b = paramExtensionInfo.vipFontType;
        if (paramExtensionInfo.vipFontType == 0) {
          paramExtensionInfo.vipFontType = 1;
        }
        if (paramExtensionInfo.vipFontType == 2)
        {
          if (localFontInfo.jdField_a_of_type_AndroidGraphicsTypeface == null) {}
          try
          {
            if (new File(localFontInfo.jdField_a_of_type_JavaLangString).exists())
            {
              localFontInfo.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localFontInfo.jdField_a_of_type_JavaLangString);
              jdField_c_of_type_Boolean = true;
              return localFontInfo;
              bool = false;
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("FontManager", 2, "doAfterGetExtensionInfo startDownload no file");
              }
              a(localFontInfo.jdField_a_of_type_Int, null, true, false);
              return null;
            }
          }
          catch (Exception paramChatMessage)
          {
            for (;;)
            {
              QLog.e("FontManager", 1, "doAfterGetExtensionInfo createTypeface error: " + paramChatMessage.getMessage());
              localFontInfo.jdField_a_of_type_AndroidGraphicsTypeface = null;
            }
          }
        }
      }
      if (paramExtensionInfo.vipFontType != 1) {
        break;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FontManager", 2, "doAfterGetExtensionInfo mEngine = null");
          }
          return null;
        }
        if ((!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded((int)paramExtensionInfo.uVipFont)) && (!a(localFontInfo, paramChatMessage.isSend())))
        {
          if (QLog.isColorLevel()) {
            QLog.e("FontManager", 2, "doAfterGetExtensionInfo setActiveFont");
          }
          return null;
        }
        jdField_c_of_type_Boolean = true;
        return localFontInfo;
      }
      if ((bool) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("FontManager", 2, "doAfterGetExtensionInfo isTroopOrDiscussion and fontEngine not init");
        }
        this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        a(a(paramChatMessage));
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.e("FontManager", 2, "doAfterGetExtensionInfo fontEngine not init mIsFontEngineReady = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mIsFontEngineInited = " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " isTroopOrDiscussion = " + bool);
      }
      return null;
      localFontInfo = a((int)paramExtensionInfo.uVipFont);
      paramChatMessage = localFontInfo;
    } while (localFontInfo != null);
    if ((bool) && (!NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FontManager", 2, "doAfterGetExtensionInfo isTroopOrDiscussion but no wifi.");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "doAfterGetExtensionInfo startDownload no cache");
    }
    a((int)paramExtensionInfo.uVipFont, null, true, false);
    return null;
    if (QLog.isColorLevel()) {
      QLog.e("FontManager", 2, "doAfterGetExtensionInfo no font fontid = " + paramExtensionInfo.uVipFont + " fontType = " + paramExtensionInfo.vipFontType);
    }
    return null;
  }
  
  public File a()
  {
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONObject a(int paramInt)
  {
    int i1 = 1;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (a(paramInt) != null)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "本地已存在");
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "queryInfo fontId=" + paramInt + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        Object localObject = a(paramInt);
        localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((String)localObject);
        if (localObject == null) {
          break;
        }
        switch (((DownloadTask)localObject).a())
        {
        case 0: 
        case 1: 
          localJSONObject2.put("status", 1);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "未知状态");
          if (!((DownloadTask)localObject).b()) {
            break label412;
          }
          localJSONObject2.put("canceling", i1);
          localJSONObject2.put("progress", ((DownloadTask)localObject).a);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载中");
        continue;
        localException.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载完毕");
        continue;
        localException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", "下载失败");
        continue;
        localException.put("status", 1);
        localException.put("progress", 0);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "未知状态");
        continue;
        continue;
        label412:
        i1 = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "reDownloadFont start");
    }
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
      localObject = new File(((FontInfo)localObject).jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists()) {
        break label229;
      }
      localObject = new File(((File)localObject).getParent());
      File[] arrayOfFile = ((File)localObject).listFiles();
      if (arrayOfFile != null)
      {
        int i1 = 0;
        while (i1 < arrayOfFile.length)
        {
          bool = arrayOfFile[i1].delete();
          if (QLog.isColorLevel()) {
            QLog.d("FontManager", 2, "reDownloadFont delete " + arrayOfFile[i1].getName() + " ret = " + bool);
          }
          i1 += 1;
        }
      }
      boolean bool = ((File)localObject).delete();
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "reDownloadFont delete " + ((File)localObject).getName() + " ret = " + bool);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "reDownload startDownload");
      }
      a(paramInt, null, false, true);
      return;
      label229:
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "reDownloadFont fontFile not exist");
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString == null) && (!DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))) {}
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = new Bundle();
        localBundle.putInt("id", paramInt);
        localBundle.putBoolean("needRefresh", paramBoolean1);
        localBundle.putBoolean("isUpdate", paramBoolean2);
        if ((FontInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null) || (TextUtils.isEmpty(paramString)));
      localBundle.putInt("srcType", 2);
      localBundle.putString("callbackId", paramString);
      this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramInt, 0, localBundle);
      return;
      DownloadTask localDownloadTask = new DownloadTask(a(paramInt), new File(jdField_c_of_type_JavaLangString, paramInt + ".zip"));
      localDownloadTask.e = this.jdField_d_of_type_Int;
      if (paramString != null)
      {
        localBundle.putInt("srcType", 2);
        localBundle.putString("callbackId", paramString);
        localDownloadTask.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("FontManager", 2, "startDownload  id=" + paramInt);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FontManager", 2, "inited=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ",ready=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return;
    }
    ThreadManager.c(new tf(this, paramString));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "Font_Mall", paramString, 0, 1, String.valueOf(paramInt), Integer.toString(NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext())), "", String.valueOf(paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("font_open_switch", 4).edit().putBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramBoolean).commit();
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.g.set(paramBoolean);
    this.jdField_c_of_type_Int = paramInt;
    this.k = paramString;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("fonttest", 0).edit();
    localEditor.putBoolean("font_test_switch", paramBoolean);
    localEditor.putInt("font_test_type", paramInt);
    localEditor.putString("font_test_file", paramString);
    localEditor.commit();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean1);
      return;
    }
    this.e.set(paramBoolean1);
  }
  
  public boolean a()
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name(), "default");
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "fontSwitch = " + str);
    }
    if (str.equals("1"))
    {
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_d_of_type_Boolean)
      {
        VasWebviewUtil.reportVasStatus("FontDPC", "FontAbility", "0", 0, 0, 1, 1, this.r, "");
        this.jdField_d_of_type_Boolean = true;
      }
      this.jdField_f_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int = 1;
      return this.jdField_a_of_type_Boolean;
    }
    if ((str.equals("000")) || (str.equals("default"))) {
      this.jdField_a_of_type_Boolean = b();
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_d_of_type_Boolean = true;
      if (!str.equals("default")) {
        break label259;
      }
    }
    label259:
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 == 1) {
        QLog.e("FontManager", 1, "Font not available: " + this.r);
      }
      VasWebviewUtil.reportVasStatus("FontDPC", "FontAbility", "0", 0, 0, 0, i1, this.r, "");
      this.jdField_d_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a(int paramInt, File paramFile)
  {
    boolean bool1 = true;
    if (paramFile == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)));
      bool2 = DownloaderFactory.a(paramFile, new File(jdField_b_of_type_JavaLangString, String.valueOf(paramInt)), true);
      if (bool2)
      {
        paramFile = new FontInfo(paramInt, jdField_b_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + paramInt + ".ttf");
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramFile);
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("FontManager", 2, "saveFont|fontId=" + paramInt + ",result=" + bool2);
    return bool2;
  }
  
  /* Error */
  public boolean a(FontInfo paramFontInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_2
    //   4: invokevirtual 818	com/etrump/mixlayout/FontManager:a	(Z)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +7 -> 16
    //   12: aload_0
    //   13: monitorexit
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: iconst_1
    //   18: iload_2
    //   19: invokevirtual 820	com/etrump/mixlayout/FontManager:a	(ZZ)V
    //   22: new 822	tj
    //   25: dup
    //   26: aload_0
    //   27: aload_1
    //   28: iload_2
    //   29: invokespecial 825	tj:<init>	(Lcom/etrump/mixlayout/FontManager;Lcom/etrump/mixlayout/FontInfo;Z)V
    //   32: invokestatic 717	com/tencent/mobileqq/app/ThreadManager:c	(Ljava/lang/Runnable;)V
    //   35: goto -23 -> 12
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	FontManager
    //   0	43	1	paramFontInfo	FontInfo
    //   0	43	2	paramBoolean	boolean
    //   7	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	38	finally
    //   16	35	38	finally
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    return this.e.get();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.i.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "checkFontUpdate has checked");
      }
      return;
    }
    if (paramBoolean) {
      this.i.set(true);
    }
    ThreadManager.c(new tl(this));
  }
  
  public void c(boolean paramBoolean)
  {
    this.g.set(paramBoolean);
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("fonttest", 0).edit();
    localEditor.putBoolean("font_test_switch", paramBoolean);
    localEditor.commit();
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) {}
    try
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_doneEngine();
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "onDestroy...");
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FontManager", 2, localUnsatisfiedLinkError.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\etrump\mixlayout\FontManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */