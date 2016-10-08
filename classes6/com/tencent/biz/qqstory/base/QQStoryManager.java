package com.tencent.biz.qqstory.base;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igu;
import igw;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QQStoryManager
  implements Manager
{
  public static final int a = 1;
  public static final String a = "StorySvc.video_config_get";
  public static final int b = 2;
  public static final String b = "StorySvc.video_config_set";
  public static final int c = 3;
  public static final String c = "StorySvc.video_get_user_mask_list";
  public static final int d = 1001;
  public static final String d = "StorySvc.video_set_user_mask";
  public static final String e = "StorySvc.video_get_user_mask_states";
  public static final String f = "StorySvc.video_show_video_list";
  public static final String g = "QQStory_Config_SP_";
  public static final String h = "sp_key_net_type";
  public static final String i = "http://pub.idqqimg.com/pc/misc/files/20160826/d5421100bd454ee1bffec912bceb0c89.zip";
  public static final String j = "animation_path_key";
  public static final String k = "netType";
  public static final String l = "9999_HD";
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public QQStoryContext a;
  public AppInterface a;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public DownloadListener a;
  public SoftReference a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  List jdField_a_of_type_JavaUtilList;
  public ConcurrentHashMap a;
  List b;
  
  public QQStoryManager(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new igw(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppInterface.a().getSharedPreferences("QQStory_Config_SP_" + paramAppInterface.getAccount(), 4);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.a();
  }
  
  public static void a(String paramString) {}
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_key_net_type", 1001);
  }
  
  public int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), 0).getString(paramString, "");
    long l1 = 0L;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("&");
      if (localObject.length >= 2) {
        l1 = Long.parseLong(localObject[0]);
      }
    }
    for (int m = Integer.parseInt(localObject[1]);; m = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "getPGCRequestCache key:" + paramString + "  seq:" + m + " time:" + l1);
      }
      if (l1 - System.currentTimeMillis() > 1800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "getPGCRequestCache key:" + paramString + "  seq:" + m + " time:" + l1 + " 缓存过期了");
        }
        return 0;
      }
      return m;
    }
  }
  
  public QQStoryUserInfo a(String paramString)
  {
    Object localObject = (QQStoryUserInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject != null) {}
    QQStoryUserInfo localQQStoryUserInfo;
    do
    {
      return (QQStoryUserInfo)localObject;
      localQQStoryUserInfo = (QQStoryUserInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(QQStoryUserInfo.class, paramString);
      localObject = localQQStoryUserInfo;
    } while (localQQStoryUserInfo == null);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localQQStoryUserInfo);
    return localQQStoryUserInfo;
  }
  
  public List a(boolean paramBoolean)
  {
    Object localObject;
    label43:
    QQStoryUserInfo localQQStoryUserInfo;
    if (paramBoolean)
    {
      localObject = " isAllowed=? ";
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(QQStoryUserInfo.class, true, (String)localObject, new String[] { "1" }, null, null, null, null);
      if (localObject == null) {
        break label149;
      }
      Iterator localIterator = ((List)localObject).iterator();
      if (!localIterator.hasNext()) {
        break label147;
      }
      localQQStoryUserInfo = (QQStoryUserInfo)localIterator.next();
      if (!paramBoolean) {
        break label118;
      }
      if (!this.b.contains(localQQStoryUserInfo)) {
        this.b.add(localQQStoryUserInfo);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
      break label43;
      localObject = " isInterested=? ";
      break;
      label118:
      if (!this.jdField_a_of_type_JavaUtilList.contains(localQQStoryUserInfo)) {
        this.jdField_a_of_type_JavaUtilList.add(localQQStoryUserInfo);
      }
    }
    label147:
    return (List)localObject;
    label149:
    return new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_pgc_media_has_subscribe", 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_net_type", paramInt).commit();
  }
  
  public void a(QQStoryUserInfo paramQQStoryUserInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramQQStoryUserInfo);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramQQStoryUserInfo.uin);
    if ((paramBoolean) && (paramQQStoryUserInfo.isAllowed == 1)) {
      this.b.remove(paramQQStoryUserInfo);
    }
    if ((!paramBoolean) && (paramQQStoryUserInfo.isInterested == 1)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramQQStoryUserInfo);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_pgc_read_id_and_index", 0).edit().putString("unionId_" + paramString1, paramString2 + "&" + paramInt).commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_pgc_v_has_subscribe", 0).getBoolean("has_subscribe", false);
  }
  
  /* Error */
  public boolean a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +12 -> 16
    //   7: aload_3
    //   8: ifnull +8 -> 16
    //   11: aload_3
    //   12: arraylength
    //   13: ifgt +47 -> 60
    //   16: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +39 -> 58
    //   22: ldc -54
    //   24: iconst_2
    //   25: new 110	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 337
    //   35: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 339
    //   45: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_3
    //   49: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: aconst_null
    //   61: astore 4
    //   63: new 110	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   70: getstatic 347	com/tencent/mobileqq/app/AppConstants:db	Ljava/lang/String;
    //   73: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 6
    //   85: new 349	java/io/File
    //   88: dup
    //   89: getstatic 347	com/tencent/mobileqq/app/AppConstants:db	Ljava/lang/String;
    //   92: invokespecial 351	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore 5
    //   97: aload 5
    //   99: invokevirtual 354	java/io/File:exists	()Z
    //   102: ifne +9 -> 111
    //   105: aload 5
    //   107: invokevirtual 357	java/io/File:mkdirs	()Z
    //   110: pop
    //   111: new 349	java/io/File
    //   114: dup
    //   115: aload 6
    //   117: invokespecial 351	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore 5
    //   122: aload 5
    //   124: invokevirtual 354	java/io/File:exists	()Z
    //   127: ifne +9 -> 136
    //   130: aload 5
    //   132: invokevirtual 360	java/io/File:createNewFile	()Z
    //   135: pop
    //   136: aload 5
    //   138: invokevirtual 363	java/io/File:isFile	()Z
    //   141: istore 7
    //   143: iload 7
    //   145: ifne +34 -> 179
    //   148: iconst_0
    //   149: ifeq -91 -> 58
    //   152: new 365	java/lang/NullPointerException
    //   155: dup
    //   156: invokespecial 366	java/lang/NullPointerException:<init>	()V
    //   159: athrow
    //   160: astore_1
    //   161: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq -106 -> 58
    //   167: ldc -54
    //   169: iconst_2
    //   170: ldc_w 368
    //   173: aload_1
    //   174: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: iconst_0
    //   178: ireturn
    //   179: new 373	java/io/FileOutputStream
    //   182: dup
    //   183: aload 5
    //   185: invokespecial 376	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   188: astore 5
    //   190: aload 5
    //   192: astore 4
    //   194: aload 5
    //   196: aload_3
    //   197: invokevirtual 380	java/io/FileOutputStream:write	([B)V
    //   200: aload 5
    //   202: astore 4
    //   204: aload_0
    //   205: getfield 103	com/tencent/biz/qqstory/base/QQStoryManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   208: invokevirtual 108	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   211: aload_0
    //   212: getfield 103	com/tencent/biz/qqstory/base/QQStoryManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   215: invokevirtual 164	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   218: iconst_0
    //   219: invokevirtual 128	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   222: invokeinterface 284 1 0
    //   227: aload_1
    //   228: new 110	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   235: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   238: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   241: ldc -78
    //   243: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload_2
    //   247: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokeinterface 324 3 0
    //   258: pop
    //   259: aload 5
    //   261: astore 4
    //   263: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +53 -> 319
    //   269: aload 5
    //   271: astore 4
    //   273: ldc -54
    //   275: iconst_2
    //   276: new 110	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 382
    //   286: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 384
    //   296: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload_2
    //   300: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc_w 386
    //   306: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_3
    //   310: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 5
    //   321: ifnull +8 -> 329
    //   324: aload 5
    //   326: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   329: iconst_1
    //   330: ireturn
    //   331: astore_1
    //   332: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -6 -> 329
    //   338: ldc -54
    //   340: iconst_2
    //   341: ldc_w 368
    //   344: aload_1
    //   345: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto -19 -> 329
    //   351: astore_3
    //   352: aload 4
    //   354: astore_1
    //   355: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +13 -> 371
    //   361: ldc -54
    //   363: iconst_2
    //   364: ldc_w 391
    //   367: aload_3
    //   368: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: aload_1
    //   372: ifnull -43 -> 329
    //   375: aload_1
    //   376: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   379: goto -50 -> 329
    //   382: astore_1
    //   383: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq -57 -> 329
    //   389: ldc -54
    //   391: iconst_2
    //   392: ldc_w 368
    //   395: aload_1
    //   396: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: goto -70 -> 329
    //   402: astore_1
    //   403: aconst_null
    //   404: astore 5
    //   406: aload 5
    //   408: astore 4
    //   410: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +17 -> 430
    //   416: aload 5
    //   418: astore 4
    //   420: ldc -54
    //   422: iconst_2
    //   423: ldc_w 368
    //   426: aload_1
    //   427: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: aload 5
    //   432: ifnull -103 -> 329
    //   435: aload 5
    //   437: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   440: goto -111 -> 329
    //   443: astore_1
    //   444: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq -118 -> 329
    //   450: ldc -54
    //   452: iconst_2
    //   453: ldc_w 368
    //   456: aload_1
    //   457: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   460: goto -131 -> 329
    //   463: astore_1
    //   464: aconst_null
    //   465: astore 4
    //   467: aload 4
    //   469: ifnull +8 -> 477
    //   472: aload 4
    //   474: invokevirtual 389	java/io/FileOutputStream:close	()V
    //   477: aload_1
    //   478: athrow
    //   479: astore_3
    //   480: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq -6 -> 477
    //   486: ldc -54
    //   488: iconst_2
    //   489: ldc_w 368
    //   492: aload_3
    //   493: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   496: goto -19 -> 477
    //   499: astore_1
    //   500: goto -33 -> 467
    //   503: astore_3
    //   504: aload_1
    //   505: astore 4
    //   507: aload_3
    //   508: astore_1
    //   509: goto -42 -> 467
    //   512: astore_1
    //   513: goto -107 -> 406
    //   516: astore_3
    //   517: aload 5
    //   519: astore_1
    //   520: goto -165 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	QQStoryManager
    //   0	523	1	paramString	String
    //   0	523	2	paramInt	int
    //   0	523	3	paramArrayOfByte	byte[]
    //   61	445	4	localObject1	Object
    //   95	423	5	localObject2	Object
    //   83	33	6	str	String
    //   141	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   152	160	160	java/io/IOException
    //   324	329	331	java/io/IOException
    //   111	136	351	java/io/FileNotFoundException
    //   136	143	351	java/io/FileNotFoundException
    //   179	190	351	java/io/FileNotFoundException
    //   375	379	382	java/io/IOException
    //   111	136	402	java/io/IOException
    //   136	143	402	java/io/IOException
    //   179	190	402	java/io/IOException
    //   435	440	443	java/io/IOException
    //   111	136	463	finally
    //   136	143	463	finally
    //   179	190	463	finally
    //   472	477	479	java/io/IOException
    //   194	200	499	finally
    //   204	259	499	finally
    //   263	269	499	finally
    //   273	319	499	finally
    //   410	416	499	finally
    //   420	430	499	finally
    //   355	371	503	finally
    //   194	200	512	java/io/IOException
    //   204	259	512	java/io/IOException
    //   263	269	512	java/io/IOException
    //   273	319	512	java/io/IOException
    //   194	200	516	java/io/FileNotFoundException
    //   204	259	516	java/io/FileNotFoundException
    //   263	269	516	java/io/FileNotFoundException
    //   273	319	516	java/io/FileNotFoundException
  }
  
  public boolean a(String paramString, QQStoryManager.OnAnimationReadiedListener paramOnAnimationReadiedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "start downloadAnimationResource.");
    }
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    boolean bool = ((Boolean)localStoryConfigManager.b("first_time_pic", Boolean.valueOf(false))).booleanValue();
    if (bool) {
      ThreadManager.a(new igu(this, paramString, localStoryConfigManager, paramOnAnimationReadiedListener), 8, null, true);
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("Q.qqstory.pgc", 2, "loadAnimationResource. flag is false. no need to play animation.");
    return bool;
  }
  
  /* Error */
  public byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 8
    //   6: aload_0
    //   7: getfield 103	com/tencent/biz/qqstory/base/QQStoryManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   10: invokevirtual 108	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_0
    //   14: getfield 103	com/tencent/biz/qqstory/base/QQStoryManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   17: invokevirtual 164	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   20: iconst_0
    //   21: invokevirtual 128	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   24: aload_1
    //   25: ldc -90
    //   27: invokeinterface 170 3 0
    //   32: astore_2
    //   33: lconst_0
    //   34: lstore 11
    //   36: lload 11
    //   38: lstore 9
    //   40: aload_2
    //   41: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +28 -> 72
    //   47: aload_2
    //   48: ldc -78
    //   50: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   53: astore_2
    //   54: lload 11
    //   56: lstore 9
    //   58: aload_2
    //   59: arraylength
    //   60: iconst_1
    //   61: if_icmplt +11 -> 72
    //   64: aload_2
    //   65: iconst_0
    //   66: aaload
    //   67: invokestatic 190	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lstore 9
    //   72: lload 9
    //   74: lconst_0
    //   75: lcmp
    //   76: ifgt +207 -> 283
    //   79: iload 8
    //   81: istore 7
    //   83: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +38 -> 124
    //   89: ldc -54
    //   91: iconst_2
    //   92: new 110	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   99: ldc -52
    //   101: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 430
    //   111: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: iload 8
    //   122: istore 7
    //   124: aload 6
    //   126: astore_2
    //   127: iload 7
    //   129: ifeq +152 -> 281
    //   132: new 432	java/io/BufferedInputStream
    //   135: dup
    //   136: new 434	java/io/FileInputStream
    //   139: dup
    //   140: new 110	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   147: getstatic 347	com/tencent/mobileqq/app/AppConstants:db	Ljava/lang/String;
    //   150: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokespecial 435	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   163: invokespecial 438	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   166: astore_1
    //   167: new 440	java/io/ByteArrayOutputStream
    //   170: dup
    //   171: sipush 1024
    //   174: invokespecial 442	java/io/ByteArrayOutputStream:<init>	(I)V
    //   177: astore 4
    //   179: aload 4
    //   181: astore_3
    //   182: aload_1
    //   183: astore_2
    //   184: sipush 1024
    //   187: newarray <illegal type>
    //   189: astore 5
    //   191: aload 4
    //   193: astore_3
    //   194: aload_1
    //   195: astore_2
    //   196: aload_1
    //   197: aload 5
    //   199: invokevirtual 446	java/io/BufferedInputStream:read	([B)I
    //   202: istore 7
    //   204: iload 7
    //   206: iconst_m1
    //   207: if_icmpeq +185 -> 392
    //   210: aload 4
    //   212: astore_3
    //   213: aload_1
    //   214: astore_2
    //   215: aload 4
    //   217: aload 5
    //   219: iconst_0
    //   220: iload 7
    //   222: invokevirtual 449	java/io/ByteArrayOutputStream:write	([BII)V
    //   225: goto -34 -> 191
    //   228: astore 5
    //   230: aload 4
    //   232: astore_3
    //   233: aload_1
    //   234: astore_2
    //   235: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +19 -> 257
    //   241: aload 4
    //   243: astore_3
    //   244: aload_1
    //   245: astore_2
    //   246: ldc -54
    //   248: iconst_2
    //   249: ldc_w 451
    //   252: aload 5
    //   254: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 452	java/io/BufferedInputStream:close	()V
    //   265: aload 6
    //   267: astore_2
    //   268: aload 4
    //   270: ifnull +11 -> 281
    //   273: aload 4
    //   275: invokevirtual 453	java/io/ByteArrayOutputStream:close	()V
    //   278: aload 6
    //   280: astore_2
    //   281: aload_2
    //   282: areturn
    //   283: lload 9
    //   285: invokestatic 223	java/lang/System:currentTimeMillis	()J
    //   288: lsub
    //   289: ldc2_w 224
    //   292: lcmp
    //   293: ifle +51 -> 344
    //   296: iload 8
    //   298: istore 7
    //   300: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -179 -> 124
    //   306: ldc -54
    //   308: iconst_2
    //   309: new 110	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   316: ldc -52
    //   318: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 455
    //   328: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: iload 8
    //   339: istore 7
    //   341: goto -217 -> 124
    //   344: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +39 -> 386
    //   350: ldc -54
    //   352: iconst_2
    //   353: new 110	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   360: ldc -52
    //   362: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_1
    //   366: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 457
    //   372: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 9
    //   377: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: iconst_1
    //   387: istore 7
    //   389: goto -265 -> 124
    //   392: aload 4
    //   394: astore_3
    //   395: aload_1
    //   396: astore_2
    //   397: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +38 -> 438
    //   403: aload 4
    //   405: astore_3
    //   406: aload_1
    //   407: astore_2
    //   408: ldc -54
    //   410: iconst_2
    //   411: new 110	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 459
    //   421: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 4
    //   426: invokevirtual 462	java/io/ByteArrayOutputStream:size	()I
    //   429: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload 4
    //   440: astore_3
    //   441: aload_1
    //   442: astore_2
    //   443: aload 4
    //   445: invokevirtual 466	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   448: astore 5
    //   450: aload 5
    //   452: astore_3
    //   453: aload_1
    //   454: ifnull +7 -> 461
    //   457: aload_1
    //   458: invokevirtual 452	java/io/BufferedInputStream:close	()V
    //   461: aload_3
    //   462: astore_2
    //   463: aload 4
    //   465: ifnull -184 -> 281
    //   468: aload 4
    //   470: invokevirtual 453	java/io/ByteArrayOutputStream:close	()V
    //   473: aload_3
    //   474: areturn
    //   475: astore_1
    //   476: aload_3
    //   477: astore_2
    //   478: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq -200 -> 281
    //   484: ldc -54
    //   486: iconst_2
    //   487: ldc_w 468
    //   490: aload_1
    //   491: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload_3
    //   495: areturn
    //   496: astore_1
    //   497: aload 6
    //   499: astore_2
    //   500: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -222 -> 281
    //   506: ldc -54
    //   508: iconst_2
    //   509: ldc_w 468
    //   512: aload_1
    //   513: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   516: aconst_null
    //   517: areturn
    //   518: astore 5
    //   520: aconst_null
    //   521: astore 4
    //   523: aconst_null
    //   524: astore_1
    //   525: aload 4
    //   527: astore_3
    //   528: aload_1
    //   529: astore_2
    //   530: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq +19 -> 552
    //   536: aload 4
    //   538: astore_3
    //   539: aload_1
    //   540: astore_2
    //   541: ldc -54
    //   543: iconst_2
    //   544: ldc_w 468
    //   547: aload 5
    //   549: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   552: aload_1
    //   553: ifnull +7 -> 560
    //   556: aload_1
    //   557: invokevirtual 452	java/io/BufferedInputStream:close	()V
    //   560: aload 6
    //   562: astore_2
    //   563: aload 4
    //   565: ifnull -284 -> 281
    //   568: aload 4
    //   570: invokevirtual 453	java/io/ByteArrayOutputStream:close	()V
    //   573: aconst_null
    //   574: areturn
    //   575: astore_1
    //   576: aload 6
    //   578: astore_2
    //   579: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq -301 -> 281
    //   585: ldc -54
    //   587: iconst_2
    //   588: ldc_w 468
    //   591: aload_1
    //   592: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   595: aconst_null
    //   596: areturn
    //   597: astore 4
    //   599: aconst_null
    //   600: astore_3
    //   601: aconst_null
    //   602: astore_1
    //   603: aload_1
    //   604: ifnull +7 -> 611
    //   607: aload_1
    //   608: invokevirtual 452	java/io/BufferedInputStream:close	()V
    //   611: aload_3
    //   612: ifnull +7 -> 619
    //   615: aload_3
    //   616: invokevirtual 453	java/io/ByteArrayOutputStream:close	()V
    //   619: aload 4
    //   621: athrow
    //   622: astore_1
    //   623: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq -7 -> 619
    //   629: ldc -54
    //   631: iconst_2
    //   632: ldc_w 468
    //   635: aload_1
    //   636: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   639: goto -20 -> 619
    //   642: astore 4
    //   644: aconst_null
    //   645: astore_3
    //   646: goto -43 -> 603
    //   649: astore 4
    //   651: aload_2
    //   652: astore_1
    //   653: goto -50 -> 603
    //   656: astore 5
    //   658: aconst_null
    //   659: astore 4
    //   661: goto -136 -> 525
    //   664: astore 5
    //   666: goto -141 -> 525
    //   669: astore 5
    //   671: aconst_null
    //   672: astore 4
    //   674: aconst_null
    //   675: astore_1
    //   676: goto -446 -> 230
    //   679: astore 5
    //   681: aconst_null
    //   682: astore 4
    //   684: goto -454 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	QQStoryManager
    //   0	687	1	paramString	String
    //   32	620	2	localObject1	Object
    //   181	465	3	localObject2	Object
    //   177	392	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   597	23	4	localObject3	Object
    //   642	1	4	localObject4	Object
    //   649	1	4	localObject5	Object
    //   659	24	4	localObject6	Object
    //   189	29	5	arrayOfByte1	byte[]
    //   228	25	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   448	3	5	arrayOfByte2	byte[]
    //   518	30	5	localIOException1	java.io.IOException
    //   656	1	5	localIOException2	java.io.IOException
    //   664	1	5	localIOException3	java.io.IOException
    //   669	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   679	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	576	6	localObject7	Object
    //   81	307	7	m	int
    //   4	334	8	n	int
    //   38	338	9	l1	long
    //   34	21	11	l2	long
    // Exception table:
    //   from	to	target	type
    //   184	191	228	java/io/FileNotFoundException
    //   196	204	228	java/io/FileNotFoundException
    //   215	225	228	java/io/FileNotFoundException
    //   397	403	228	java/io/FileNotFoundException
    //   408	438	228	java/io/FileNotFoundException
    //   443	450	228	java/io/FileNotFoundException
    //   457	461	475	java/io/IOException
    //   468	473	475	java/io/IOException
    //   261	265	496	java/io/IOException
    //   273	278	496	java/io/IOException
    //   132	167	518	java/io/IOException
    //   556	560	575	java/io/IOException
    //   568	573	575	java/io/IOException
    //   132	167	597	finally
    //   607	611	622	java/io/IOException
    //   615	619	622	java/io/IOException
    //   167	179	642	finally
    //   184	191	649	finally
    //   196	204	649	finally
    //   215	225	649	finally
    //   235	241	649	finally
    //   246	257	649	finally
    //   397	403	649	finally
    //   408	438	649	finally
    //   443	450	649	finally
    //   530	536	649	finally
    //   541	552	649	finally
    //   167	179	656	java/io/IOException
    //   184	191	664	java/io/IOException
    //   196	204	664	java/io/IOException
    //   215	225	664	java/io/IOException
    //   397	403	664	java/io/IOException
    //   408	438	664	java/io/IOException
    //   443	450	664	java/io/IOException
    //   132	167	669	java/io/FileNotFoundException
    //   167	179	679	java/io/FileNotFoundException
  }
  
  public String[] a(String paramString)
  {
    Object localObject = null;
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_pgc_read_id_and_index", 0).getString("unionId_" + paramString, null);
    paramString = (String)localObject;
    if (str != null) {
      paramString = str.split("&");
    }
    return paramString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_pgc_v_has_subscribe", 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_pgc_media_has_subscribe", 0).getBoolean("has_subscribe", false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("qqstory", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "pgc_enter_discover", true).commit();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("qqstory", 0).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "pgc_enter_discover", false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    SuperManager.a().c();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\QQStoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */