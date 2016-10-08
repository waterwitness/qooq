package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import wep;

public class IndividualRedPacketResDownloader
{
  static final String jdField_a_of_type_JavaLangString = "IndividualRedPacketResDownloader";
  public static final int b = 1;
  public static final String b = "aioTail";
  public static final int c = 0;
  public static final String c = "tencentPay";
  public static final String d = "personalityMall";
  public static final String h = "load_action";
  public static final String i = "res_type";
  public static final String j = "load_index";
  public static final String k = "res_id";
  public static final String l = "aio_request_key";
  public static final String m = "_tp";
  public static final String n = "send_requst_key";
  public static final String o = "_send";
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public QQAppInterface a;
  public IndividualRedPacketResDownloader.AfterDownloadCallback a;
  public IndividualRedPacketResDownloader.Char300Info a;
  IndividualRedPacketResDownloader.IndividUpdateRedPacketLisener jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$IndividUpdateRedPacketLisener;
  public IndividualRedPacketResDownloader.RedPacketResInfo a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  public ArrayList a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  public Map a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public boolean a;
  public IndividualRedPacketResDownloader.Char300Info b;
  public Map b;
  public AtomicBoolean b;
  public boolean b;
  boolean c;
  public String e;
  public String f;
  public String g;
  
  public IndividualRedPacketResDownloader(QQAppInterface paramQQAppInterface, IndividualRedPacketResDownloader.AfterDownloadCallback paramAfterDownloadCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = new IndividualRedPacketResDownloader.Char300Info();
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = new IndividualRedPacketResDownloader.Char300Info();
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo = new IndividualRedPacketResDownloader.RedPacketResInfo();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new wep(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback = paramAfterDownloadCallback;
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_JavaLangString = "";
    paramQQAppInterface = (IndividualRedPacketManager)paramQQAppInterface.getManager(130);
    this.jdField_b_of_type_Boolean = paramQQAppInterface.a().getBoolean(IndividualRedPacketManager.q, false);
    this.jdField_a_of_type_Boolean = paramQQAppInterface.a().getBoolean("RedpacketIsShowSwitch", false);
  }
  
  public static boolean a(IndividualRedPacketResDownloader.RedPacketResInfo paramRedPacketResInfo)
  {
    if ((paramRedPacketResInfo == null) || (TextUtils.isEmpty(paramRedPacketResInfo.jdField_c_of_type_JavaLangString))) {}
    do
    {
      return false;
      paramRedPacketResInfo = new File(IndividualRedPacketManager.a(paramRedPacketResInfo.jdField_c_of_type_JavaLangString, null, paramRedPacketResInfo.j, paramRedPacketResInfo.jdField_d_of_type_Int, 0));
    } while ((paramRedPacketResInfo == null) || (!paramRedPacketResInfo.exists()) || (!paramRedPacketResInfo.isFile()));
    return true;
  }
  
  JSONArray a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString)) && ((paramJSONObject.get(paramString) instanceof JSONArray))) {
      return paramJSONObject.getJSONArray(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse,getJsonArray == null; keyName:" + paramString);
    }
    return null;
  }
  
  public void a()
  {
    Object localObject1 = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "running preDownload loadIndex:" + this.jdField_a_of_type_Int);
    }
    Object localObject2 = (IndividualRedPacketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (localObject2 == null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      int i1 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ClubContentJsonTask.k.e);
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "preDownload ok version: " + i1);
      }
      if (i1 > 0) {
        ((IndividualRedPacketManager)localObject2).a().edit().putLong("resPreload_ok_" + i1, NetConnInfoCenter.getServerTime()).commit();
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    localObject2 = (IndividualRedPacketResDownloader.RedPacketResInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    Object localObject3 = IndividualRedPacketManager.a(((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).jdField_c_of_type_JavaLangString, null, ((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).j, ((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).jdField_d_of_type_Int, 0);
    if (TextUtils.isEmpty((CharSequence)localObject3)) {}
    while ((localObject1 == null) || ((((File)localObject1).exists()) && (((File)localObject1).isFile())))
    {
      this.jdField_a_of_type_Int += 1;
      a();
      return;
      localObject1 = new File((String)localObject3);
    }
    localObject1 = new DownloadTask(((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).jdField_d_of_type_JavaLangString, (File)localObject1);
    if ((((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).j == 1) || (((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).j == 8)) {
      ((DownloadTask)localObject1).l = true;
    }
    ((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).e = 1;
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("res_type", ((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).j);
    ((Bundle)localObject3).putInt("load_index", this.jdField_a_of_type_Int);
    ((Bundle)localObject3).putInt("load_action", 1);
    ((Bundle)localObject3).putString("res_id", ((IndividualRedPacketResDownloader.RedPacketResInfo)localObject2).jdField_c_of_type_JavaLangString);
    ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject3);
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "running preDownload over loadIndex:" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(IndividualRedPacketResDownloader.IndividUpdateRedPacketLisener paramIndividUpdateRedPacketLisener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$IndividUpdateRedPacketLisener = paramIndividUpdateRedPacketLisener;
      return;
    }
  }
  
  public void a(IndividualRedPacketResDownloader.RedPacketResInfo paramRedPacketResInfo, Bundle paramBundle)
  {
    DownloadTask localDownloadTask = null;
    boolean bool = false;
    for (;;)
    {
      int i1;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("downloadResIfNotExsit resInfo: ");
          if (paramRedPacketResInfo == null) {
            bool = true;
          }
          localObject2 = ((StringBuilder)localObject1).append(bool).append(", resInfo.id:");
          if (paramRedPacketResInfo == null)
          {
            localObject1 = "null";
            QLog.d("IndividualRedPacketResDownloader", 2, (String)localObject1);
          }
        }
        else
        {
          localObject1 = (IndividualRedPacketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(130);
          if ((paramRedPacketResInfo != null) && (localObject1 != null))
          {
            bool = ((IndividualRedPacketManager)localObject1).b();
            if (bool) {
              continue;
            }
          }
          return;
        }
        Object localObject1 = paramRedPacketResInfo.jdField_c_of_type_JavaLangString;
        continue;
        IndividualRedPacketManager.a();
        Object localObject2 = IndividualRedPacketManager.a(paramRedPacketResInfo.jdField_c_of_type_JavaLangString, null, paramRedPacketResInfo.j, paramRedPacketResInfo.jdField_d_of_type_Int, 0);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localDownloadTask;
          if ((localObject1 == null) || ((((File)localObject1).exists()) && (((File)localObject1).isFile()))) {
            continue;
          }
          if (this.jdField_a_of_type_JavaUtilHashMap == null) {
            this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
          }
          i1 = ((String)localObject2).hashCode();
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i1))) {
            break label429;
          }
          if (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1))).intValue() > 3) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i1), Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1))).intValue() + 1));
          paramRedPacketResInfo.e = 1;
          localDownloadTask = new DownloadTask(paramRedPacketResInfo.jdField_d_of_type_JavaLangString, (File)localObject1);
          if (paramRedPacketResInfo.j == 1) {
            localDownloadTask.l = true;
          }
          localDownloadTask.jdField_b_of_type_Boolean = true;
          localObject1 = paramBundle;
          if (paramBundle == null) {
            localObject1 = new Bundle();
          }
          ((Bundle)localObject1).putInt("res_type", paramRedPacketResInfo.j);
          ((Bundle)localObject1).putInt("load_action", 0);
          ((Bundle)localObject1).putString("res_id", paramRedPacketResInfo.jdField_c_of_type_JavaLangString);
          ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject1);
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= this.jdField_a_of_type_Int)) {
            continue;
          }
          a();
          continue;
        }
        localObject1 = new File((String)localObject2);
      }
      finally {}
      continue;
      label429:
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i1), Integer.valueOf(1));
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 74	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +52 -> 64
    //   15: ldc 8
    //   17: iconst_2
    //   18: new 194	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 365
    //   28: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: ldc_w 367
    //   38: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_2
    //   42: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: ldc_w 369
    //   48: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 371	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Z
    //   55: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: getfield 100	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   68: iconst_0
    //   69: invokevirtual 211	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   72: aload_0
    //   73: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: sipush 130
    //   79: invokevirtual 121	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   82: checkcast 123	com/tencent/mobileqq/app/IndividualRedPacketManager
    //   85: astore 6
    //   87: iload_1
    //   88: ifne +114 -> 202
    //   91: aload_0
    //   92: getfield 371	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Z
    //   95: ifne +107 -> 202
    //   98: aload 6
    //   100: invokevirtual 327	com/tencent/mobileqq/app/IndividualRedPacketManager:b	()Z
    //   103: ifeq +99 -> 202
    //   106: iconst_1
    //   107: istore_2
    //   108: aload_0
    //   109: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   112: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   115: iload_2
    //   116: invokestatic 374	com/tencent/mobileqq/vas/ClubContentJsonTask:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Z)Lorg/json/JSONObject;
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 371	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Z
    //   124: ifne +16 -> 140
    //   127: iload_1
    //   128: ifne +79 -> 207
    //   131: iconst_1
    //   132: istore 20
    //   134: aload_0
    //   135: iload 20
    //   137: putfield 371	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Z
    //   140: aload_3
    //   141: ifnonnull +72 -> 213
    //   144: iload_2
    //   145: ifne +11 -> 156
    //   148: aload_0
    //   149: getfield 100	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   152: iconst_1
    //   153: invokevirtual 211	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   156: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +39 -> 198
    //   162: ldc 8
    //   164: iconst_2
    //   165: new 194	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 376
    //   175: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload_1
    //   179: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: ldc_w 378
    //   185: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload_2
    //   189: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   192: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 381	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 5
    //   200: monitorexit
    //   201: return
    //   202: iconst_0
    //   203: istore_2
    //   204: goto -96 -> 108
    //   207: iconst_0
    //   208: istore 20
    //   210: goto -76 -> 134
    //   213: aload_3
    //   214: ldc_w 383
    //   217: invokevirtual 387	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   220: lstore 16
    //   222: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +43 -> 268
    //   228: ldc 8
    //   230: iconst_2
    //   231: new 194	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 389
    //   241: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: lload 16
    //   246: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: ldc_w 394
    //   252: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: getfield 396	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_Long	J
    //   259: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   262: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 381	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload_0
    //   269: getfield 396	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_Long	J
    //   272: lstore 18
    //   274: lload 16
    //   276: lload 18
    //   278: lcmp
    //   279: ifgt +13 -> 292
    //   282: aload 5
    //   284: monitorexit
    //   285: return
    //   286: astore_3
    //   287: aload 5
    //   289: monitorexit
    //   290: aload_3
    //   291: athrow
    //   292: aload_0
    //   293: lload 16
    //   295: putfield 396	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_Long	J
    //   298: new 224	java/util/ArrayList
    //   301: dup
    //   302: invokespecial 397	java/util/ArrayList:<init>	()V
    //   305: astore 7
    //   307: new 224	java/util/ArrayList
    //   310: dup
    //   311: invokespecial 397	java/util/ArrayList:<init>	()V
    //   314: astore 8
    //   316: aload_3
    //   317: ldc_w 399
    //   320: invokevirtual 403	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   323: astore 9
    //   325: aload_0
    //   326: aload 9
    //   328: ldc_w 405
    //   331: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   334: astore_3
    //   335: aload_3
    //   336: ifnull +285 -> 621
    //   339: aload_3
    //   340: invokevirtual 410	org/json/JSONArray:length	()I
    //   343: ifle +278 -> 621
    //   346: aload_3
    //   347: iconst_0
    //   348: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   351: astore_3
    //   352: iconst_0
    //   353: istore_1
    //   354: aload_3
    //   355: ifnull +292 -> 647
    //   358: aload_3
    //   359: ldc_w 415
    //   362: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   365: ifeq +261 -> 626
    //   368: aload_3
    //   369: ldc_w 415
    //   372: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 4
    //   377: aload 4
    //   379: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   382: ifne +34 -> 416
    //   385: new 421	java/text/SimpleDateFormat
    //   388: dup
    //   389: ldc_w 423
    //   392: invokespecial 424	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   395: aload 4
    //   397: invokevirtual 428	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   400: invokevirtual 433	java/util/Date:getTime	()J
    //   403: invokestatic 436	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   406: lsub
    //   407: ldc2_w 437
    //   410: lcmp
    //   411: ifge +221 -> 632
    //   414: iconst_1
    //   415: istore_1
    //   416: aload_3
    //   417: ldc_w 440
    //   420: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   423: ifeq +48 -> 471
    //   426: aload_3
    //   427: ldc_w 440
    //   430: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   433: iconst_1
    //   434: if_icmpne +203 -> 637
    //   437: iconst_1
    //   438: istore_2
    //   439: aload_0
    //   440: iload_2
    //   441: putfield 141	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_Boolean	Z
    //   444: aload 6
    //   446: invokevirtual 126	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Landroid/content/SharedPreferences;
    //   449: invokeinterface 256 1 0
    //   454: ldc -117
    //   456: aload_0
    //   457: getfield 141	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_Boolean	Z
    //   460: invokeinterface 448 3 0
    //   465: invokeinterface 273 1 0
    //   470: pop
    //   471: aload_3
    //   472: ldc_w 450
    //   475: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   478: ifeq +3388 -> 3866
    //   481: aload_3
    //   482: ldc_w 450
    //   485: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   488: iconst_1
    //   489: if_icmpne +153 -> 642
    //   492: iconst_1
    //   493: istore_2
    //   494: aload_0
    //   495: iload_2
    //   496: putfield 137	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_Boolean	Z
    //   499: aload 6
    //   501: invokevirtual 126	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Landroid/content/SharedPreferences;
    //   504: invokeinterface 256 1 0
    //   509: getstatic 129	com/tencent/mobileqq/app/IndividualRedPacketManager:q	Ljava/lang/String;
    //   512: aload_0
    //   513: getfield 137	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_Boolean	Z
    //   516: invokeinterface 448 3 0
    //   521: invokeinterface 273 1 0
    //   526: pop
    //   527: aload_0
    //   528: getfield 315	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$IndividUpdateRedPacketLisener	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$IndividUpdateRedPacketLisener;
    //   531: ifnull +3335 -> 3866
    //   534: aload_0
    //   535: getfield 315	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$IndividUpdateRedPacketLisener	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$IndividUpdateRedPacketLisener;
    //   538: invokeinterface 453 1 0
    //   543: goto +3323 -> 3866
    //   546: aload_0
    //   547: aload 9
    //   549: ldc_w 455
    //   552: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   555: astore 4
    //   557: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +52 -> 612
    //   563: new 194	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 457
    //   573: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: iload_1
    //   577: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   580: ldc_w 459
    //   583: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: astore 10
    //   588: aload 4
    //   590: ifnonnull +75 -> 665
    //   593: ldc_w 325
    //   596: astore_3
    //   597: ldc 8
    //   599: iconst_2
    //   600: aload 10
    //   602: aload_3
    //   603: invokevirtual 462	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload 4
    //   614: ifnonnull +3260 -> 3874
    //   617: aload 5
    //   619: monitorexit
    //   620: return
    //   621: aconst_null
    //   622: astore_3
    //   623: goto -271 -> 352
    //   626: aconst_null
    //   627: astore 4
    //   629: goto -252 -> 377
    //   632: iconst_0
    //   633: istore_1
    //   634: goto -218 -> 416
    //   637: iconst_0
    //   638: istore_2
    //   639: goto -200 -> 439
    //   642: iconst_0
    //   643: istore_2
    //   644: goto -150 -> 494
    //   647: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +3219 -> 3869
    //   653: ldc 8
    //   655: iconst_2
    //   656: ldc_w 464
    //   659: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: goto +3207 -> 3869
    //   665: aload 4
    //   667: invokevirtual 410	org/json/JSONArray:length	()I
    //   670: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   673: astore_3
    //   674: goto -77 -> 597
    //   677: iload 14
    //   679: aload 4
    //   681: invokevirtual 410	org/json/JSONArray:length	()I
    //   684: if_icmpge +1549 -> 2233
    //   687: aload 4
    //   689: iload 14
    //   691: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   694: astore 11
    //   696: new 466	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo
    //   699: dup
    //   700: invokespecial 467	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:<init>	()V
    //   703: astore 10
    //   705: aload 10
    //   707: new 469	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo
    //   710: dup
    //   711: invokespecial 470	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:<init>	()V
    //   714: putfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   717: aload 10
    //   719: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   722: iconst_2
    //   723: putfield 474	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:j	I
    //   726: aload 10
    //   728: new 469	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo
    //   731: dup
    //   732: invokespecial 470	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:<init>	()V
    //   735: putfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   738: aload 10
    //   740: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   743: iconst_3
    //   744: putfield 474	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:j	I
    //   747: aload 10
    //   749: new 469	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo
    //   752: dup
    //   753: invokespecial 470	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:<init>	()V
    //   756: putfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   759: aload 10
    //   761: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   764: bipush 14
    //   766: putfield 474	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:j	I
    //   769: aload 10
    //   771: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   774: astore_3
    //   775: aload 10
    //   777: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   780: astore 12
    //   782: aload 11
    //   784: ldc_w 480
    //   787: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   790: invokestatic 483	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   793: astore 13
    //   795: aload 12
    //   797: aload 13
    //   799: putfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   802: aload_3
    //   803: aload 13
    //   805: putfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   808: aload 10
    //   810: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   813: astore_3
    //   814: aload 10
    //   816: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   819: astore 12
    //   821: aload 11
    //   823: ldc_w 486
    //   826: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   829: astore 13
    //   831: aload 12
    //   833: aload 13
    //   835: putfield 488	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   838: aload_3
    //   839: aload 13
    //   841: putfield 488	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   844: aload 11
    //   846: ldc_w 490
    //   849: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   852: ifeq +805 -> 1657
    //   855: aload 11
    //   857: ldc_w 490
    //   860: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   863: istore 15
    //   865: aload 10
    //   867: iload 15
    //   869: putfield 491	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   872: aload 11
    //   874: ldc_w 493
    //   877: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   880: ifeq +3000 -> 3880
    //   883: aload 11
    //   885: ldc_w 493
    //   888: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   891: istore 15
    //   893: aload 10
    //   895: iload 15
    //   897: putfield 494	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:e	I
    //   900: aload 10
    //   902: getfield 491	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   905: getstatic 496	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_Int	I
    //   908: if_icmpne +249 -> 1157
    //   911: aload_0
    //   912: aload 11
    //   914: ldc_w 498
    //   917: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   920: astore_3
    //   921: aload_3
    //   922: ifnull +743 -> 1665
    //   925: aload_3
    //   926: invokevirtual 410	org/json/JSONArray:length	()I
    //   929: iconst_4
    //   930: if_icmplt +735 -> 1665
    //   933: aload 10
    //   935: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   938: new 500	android/graphics/Rect
    //   941: dup
    //   942: aload_3
    //   943: iconst_0
    //   944: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   947: aload_3
    //   948: iconst_1
    //   949: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   952: aload_3
    //   953: iconst_0
    //   954: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   957: aload_3
    //   958: iconst_2
    //   959: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   962: iadd
    //   963: aload_3
    //   964: iconst_1
    //   965: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   968: aload_3
    //   969: iconst_3
    //   970: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   973: iadd
    //   974: invokespecial 506	android/graphics/Rect:<init>	(IIII)V
    //   977: putfield 509	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   980: aload 10
    //   982: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   985: aload_3
    //   986: iconst_2
    //   987: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   990: putfield 510	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_Int	I
    //   993: aload_0
    //   994: aload 11
    //   996: ldc_w 512
    //   999: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   1002: astore_3
    //   1003: aload_3
    //   1004: ifnull +812 -> 1816
    //   1007: aload_3
    //   1008: invokevirtual 410	org/json/JSONArray:length	()I
    //   1011: iconst_4
    //   1012: if_icmplt +804 -> 1816
    //   1015: aload 10
    //   1017: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1020: new 500	android/graphics/Rect
    //   1023: dup
    //   1024: aload_3
    //   1025: iconst_0
    //   1026: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1029: aload_3
    //   1030: iconst_1
    //   1031: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1034: aload_3
    //   1035: iconst_0
    //   1036: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1039: aload_3
    //   1040: iconst_2
    //   1041: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1044: iadd
    //   1045: aload_3
    //   1046: iconst_1
    //   1047: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1050: aload_3
    //   1051: iconst_3
    //   1052: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1055: iadd
    //   1056: invokespecial 506	android/graphics/Rect:<init>	(IIII)V
    //   1059: putfield 509	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   1062: aload 10
    //   1064: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1067: aload_3
    //   1068: iconst_2
    //   1069: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1072: putfield 510	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_Int	I
    //   1075: aload_0
    //   1076: aload 11
    //   1078: ldc_w 514
    //   1081: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   1084: astore_3
    //   1085: aload_3
    //   1086: ifnull +828 -> 1914
    //   1089: aload_3
    //   1090: invokevirtual 410	org/json/JSONArray:length	()I
    //   1093: iconst_4
    //   1094: if_icmplt +820 -> 1914
    //   1097: aload 10
    //   1099: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1102: new 500	android/graphics/Rect
    //   1105: dup
    //   1106: aload_3
    //   1107: iconst_0
    //   1108: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1111: aload_3
    //   1112: iconst_1
    //   1113: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1116: aload_3
    //   1117: iconst_0
    //   1118: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1121: aload_3
    //   1122: iconst_2
    //   1123: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1126: iadd
    //   1127: aload_3
    //   1128: iconst_1
    //   1129: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1132: aload_3
    //   1133: iconst_3
    //   1134: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1137: iadd
    //   1138: invokespecial 506	android/graphics/Rect:<init>	(IIII)V
    //   1141: putfield 509	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   1144: aload 10
    //   1146: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1149: aload_3
    //   1150: iconst_2
    //   1151: invokevirtual 503	org/json/JSONArray:getInt	(I)I
    //   1154: putfield 510	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_Int	I
    //   1157: aload 10
    //   1159: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1162: astore 12
    //   1164: aload 11
    //   1166: ldc_w 516
    //   1169: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1172: ifeq +2714 -> 3886
    //   1175: aload 11
    //   1177: ldc_w 516
    //   1180: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1183: astore_3
    //   1184: aload 12
    //   1186: aload_3
    //   1187: putfield 517	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1190: aload 10
    //   1192: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1195: astore 12
    //   1197: aload 11
    //   1199: ldc_w 519
    //   1202: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1205: ifeq +2687 -> 3892
    //   1208: aload 11
    //   1210: ldc_w 519
    //   1213: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1216: astore_3
    //   1217: aload 12
    //   1219: aload_3
    //   1220: putfield 517	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1223: aload 10
    //   1225: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1228: astore 12
    //   1230: aload 11
    //   1232: ldc_w 521
    //   1235: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1238: ifeq +735 -> 1973
    //   1241: aload 11
    //   1243: ldc_w 521
    //   1246: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1249: astore_3
    //   1250: aload 12
    //   1252: aload_3
    //   1253: putfield 517	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1256: aload 11
    //   1258: ldc_w 523
    //   1261: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1264: ifeq +715 -> 1979
    //   1267: aload 11
    //   1269: ldc_w 523
    //   1272: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1275: istore 15
    //   1277: aload 10
    //   1279: iload 15
    //   1281: putfield 524	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   1284: aload 10
    //   1286: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1289: aload 10
    //   1291: getfield 524	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   1294: putfield 525	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_Int	I
    //   1297: aload 10
    //   1299: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1302: aload 10
    //   1304: getfield 524	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   1307: putfield 525	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_Int	I
    //   1310: aload 10
    //   1312: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1315: aload 10
    //   1317: getfield 524	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   1320: putfield 525	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_Int	I
    //   1323: aload_0
    //   1324: getfield 74	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1327: aload 10
    //   1329: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1332: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1335: aload 10
    //   1337: invokeinterface 528 3 0
    //   1342: pop
    //   1343: aload_0
    //   1344: getfield 91	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   1347: astore_3
    //   1348: aload_3
    //   1349: monitorenter
    //   1350: aload_0
    //   1351: getfield 91	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   1354: aload 10
    //   1356: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1359: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1362: invokeinterface 529 2 0
    //   1367: ifeq +685 -> 2052
    //   1370: aload_0
    //   1371: getfield 91	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   1374: aload 10
    //   1376: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1379: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1382: invokeinterface 530 2 0
    //   1387: checkcast 532	java/util/List
    //   1390: astore 11
    //   1392: iconst_0
    //   1393: istore 15
    //   1395: iload 15
    //   1397: aload 11
    //   1399: invokeinterface 533 1 0
    //   1404: if_icmpge +630 -> 2034
    //   1407: new 291	android/os/Bundle
    //   1410: dup
    //   1411: invokespecial 292	android/os/Bundle:<init>	()V
    //   1414: astore 12
    //   1416: aload 12
    //   1418: ldc 35
    //   1420: aload 11
    //   1422: iload 15
    //   1424: invokeinterface 534 2 0
    //   1429: checkcast 332	java/lang/String
    //   1432: invokevirtual 300	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1435: aload 10
    //   1437: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1440: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   1443: ifeq +542 -> 1985
    //   1446: aload_0
    //   1447: getfield 111	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$AfterDownloadCallback;
    //   1450: aload 10
    //   1452: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1455: getfield 517	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1458: aload 10
    //   1460: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1463: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1466: iconst_2
    //   1467: iconst_1
    //   1468: aload 12
    //   1470: invokeinterface 541 6 0
    //   1475: new 291	android/os/Bundle
    //   1478: dup
    //   1479: invokespecial 292	android/os/Bundle:<init>	()V
    //   1482: astore 12
    //   1484: aload 12
    //   1486: ldc 35
    //   1488: new 194	java/lang/StringBuilder
    //   1491: dup
    //   1492: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1495: aload 11
    //   1497: iload 15
    //   1499: invokeinterface 534 2 0
    //   1504: checkcast 332	java/lang/String
    //   1507: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: ldc 38
    //   1512: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1518: invokevirtual 300	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1521: aload 10
    //   1523: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1526: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   1529: ifeq +477 -> 2006
    //   1532: aload_0
    //   1533: getfield 111	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$AfterDownloadCallback;
    //   1536: aload 10
    //   1538: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1541: getfield 517	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1544: aload 10
    //   1546: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1549: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1552: iconst_2
    //   1553: iconst_1
    //   1554: aload 12
    //   1556: invokeinterface 541 6 0
    //   1561: new 291	android/os/Bundle
    //   1564: dup
    //   1565: invokespecial 292	android/os/Bundle:<init>	()V
    //   1568: astore 12
    //   1570: aload 12
    //   1572: ldc 41
    //   1574: new 194	java/lang/StringBuilder
    //   1577: dup
    //   1578: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1581: aload 11
    //   1583: iload 15
    //   1585: invokeinterface 534 2 0
    //   1590: checkcast 332	java/lang/String
    //   1593: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: ldc 44
    //   1598: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: invokevirtual 300	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1607: aload 10
    //   1609: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1612: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   1615: ifeq +405 -> 2020
    //   1618: aload_0
    //   1619: getfield 111	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$AfterDownloadCallback;
    //   1622: aload 10
    //   1624: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1627: getfield 517	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1630: aload 10
    //   1632: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1635: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1638: bipush 14
    //   1640: iconst_1
    //   1641: aload 12
    //   1643: invokeinterface 541 6 0
    //   1648: iload 15
    //   1650: iconst_1
    //   1651: iadd
    //   1652: istore 15
    //   1654: goto -259 -> 1395
    //   1657: getstatic 543	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_Int	I
    //   1660: istore 15
    //   1662: goto -797 -> 865
    //   1665: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1668: ifeq -675 -> 993
    //   1671: ldc 8
    //   1673: iconst_2
    //   1674: new 194	java/lang/StringBuilder
    //   1677: dup
    //   1678: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1681: ldc_w 545
    //   1684: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: aload 10
    //   1689: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1692: getfield 488	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1695: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: ldc_w 547
    //   1701: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: aload 10
    //   1706: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1709: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1712: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1718: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1721: goto -728 -> 993
    //   1724: astore_3
    //   1725: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1728: ifeq +32 -> 1760
    //   1731: ldc 8
    //   1733: iconst_2
    //   1734: new 194	java/lang/StringBuilder
    //   1737: dup
    //   1738: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1741: ldc_w 549
    //   1744: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: aload_3
    //   1748: invokevirtual 552	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1751: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1757: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1760: aload_0
    //   1761: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1764: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1767: invokevirtual 238	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   1770: astore_3
    //   1771: aload_3
    //   1772: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1775: getfield 247	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   1778: iconst_0
    //   1779: invokestatic 555	com/tencent/mobileqq/vas/ClubContentJsonTask:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1782: new 194	java/lang/StringBuilder
    //   1785: dup
    //   1786: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1789: aload_3
    //   1790: invokevirtual 561	android/content/Context:getFilesDir	()Ljava/io/File;
    //   1793: invokevirtual 462	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1796: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   1799: getfield 562	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1802: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1808: invokestatic 566	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1811: pop
    //   1812: aload 5
    //   1814: monitorexit
    //   1815: return
    //   1816: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1819: ifeq -744 -> 1075
    //   1822: ldc 8
    //   1824: iconst_2
    //   1825: new 194	java/lang/StringBuilder
    //   1828: dup
    //   1829: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1832: ldc_w 568
    //   1835: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: aload 10
    //   1840: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1843: getfield 488	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1846: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: ldc_w 547
    //   1852: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: aload 10
    //   1857: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1860: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1863: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1869: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1872: goto -797 -> 1075
    //   1875: astore_3
    //   1876: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1879: ifeq -67 -> 1812
    //   1882: ldc 8
    //   1884: iconst_2
    //   1885: new 194	java/lang/StringBuilder
    //   1888: dup
    //   1889: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1892: ldc_w 570
    //   1895: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1898: aload_3
    //   1899: invokevirtual 571	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1902: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1908: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1911: goto -99 -> 1812
    //   1914: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1917: ifeq -760 -> 1157
    //   1920: ldc 8
    //   1922: iconst_2
    //   1923: new 194	java/lang/StringBuilder
    //   1926: dup
    //   1927: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1930: ldc_w 573
    //   1933: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1936: aload 10
    //   1938: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1941: getfield 488	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1944: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: ldc_w 547
    //   1950: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: aload 10
    //   1955: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1958: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1961: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1967: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1970: goto -813 -> 1157
    //   1973: ldc 113
    //   1975: astore_3
    //   1976: goto -726 -> 1250
    //   1979: iconst_0
    //   1980: istore 15
    //   1982: goto -705 -> 1277
    //   1985: aload_0
    //   1986: aload 10
    //   1988: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   1991: aload 12
    //   1993: invokevirtual 575	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;Landroid/os/Bundle;)V
    //   1996: goto -521 -> 1475
    //   1999: astore 4
    //   2001: aload_3
    //   2002: monitorexit
    //   2003: aload 4
    //   2005: athrow
    //   2006: aload_0
    //   2007: aload 10
    //   2009: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2012: aload 12
    //   2014: invokevirtual 575	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;Landroid/os/Bundle;)V
    //   2017: goto -456 -> 1561
    //   2020: aload_0
    //   2021: aload 10
    //   2023: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2026: aload 12
    //   2028: invokevirtual 575	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;Landroid/os/Bundle;)V
    //   2031: goto -383 -> 1648
    //   2034: aload_0
    //   2035: getfield 91	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2038: aload 10
    //   2040: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2043: getfield 484	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2046: invokeinterface 578 2 0
    //   2051: pop
    //   2052: aload_3
    //   2053: monitorexit
    //   2054: aload 10
    //   2056: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2059: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   2062: ifeq +129 -> 2191
    //   2065: aload 10
    //   2067: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2070: iconst_2
    //   2071: putfield 579	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:e	I
    //   2074: aload 10
    //   2076: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2079: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   2082: ifeq +123 -> 2205
    //   2085: aload 10
    //   2087: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2090: iconst_2
    //   2091: putfield 579	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:e	I
    //   2094: aload 10
    //   2096: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2099: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   2102: ifeq +117 -> 2219
    //   2105: aload 10
    //   2107: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2110: iconst_2
    //   2111: putfield 579	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:e	I
    //   2114: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2117: ifeq +1781 -> 3898
    //   2120: new 194	java/lang/StringBuilder
    //   2123: dup
    //   2124: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2127: ldc_w 581
    //   2130: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2133: astore_3
    //   2134: aload 10
    //   2136: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2139: getfield 579	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:e	I
    //   2142: iconst_2
    //   2143: if_icmpne +1764 -> 3907
    //   2146: iconst_1
    //   2147: istore_2
    //   2148: aload_3
    //   2149: iload_2
    //   2150: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2153: ldc_w 583
    //   2156: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: astore_3
    //   2160: aload 10
    //   2162: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2165: getfield 579	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:e	I
    //   2168: iconst_2
    //   2169: if_icmpne +1743 -> 3912
    //   2172: iconst_1
    //   2173: istore_2
    //   2174: ldc 8
    //   2176: iconst_2
    //   2177: aload_3
    //   2178: iload_2
    //   2179: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2182: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2185: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2188: goto +1710 -> 3898
    //   2191: aload 7
    //   2193: aload 10
    //   2195: getfield 473	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2198: invokevirtual 586	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2201: pop
    //   2202: goto -128 -> 2074
    //   2205: aload 8
    //   2207: aload 10
    //   2209: getfield 476	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2212: invokevirtual 586	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2215: pop
    //   2216: goto -122 -> 2094
    //   2219: aload 8
    //   2221: aload 10
    //   2223: getfield 478	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   2226: invokevirtual 586	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2229: pop
    //   2230: goto -116 -> 2114
    //   2233: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2236: ifeq +37 -> 2273
    //   2239: ldc 8
    //   2241: iconst_2
    //   2242: new 194	java/lang/StringBuilder
    //   2245: dup
    //   2246: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2249: ldc_w 588
    //   2252: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: aload_0
    //   2256: getfield 74	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   2259: invokeinterface 589 1 0
    //   2264: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2267: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2270: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2273: aload_0
    //   2274: aload 9
    //   2276: ldc_w 591
    //   2279: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   2282: astore 4
    //   2284: aload 4
    //   2286: ifnull +1435 -> 3721
    //   2289: iconst_0
    //   2290: istore 14
    //   2292: iload 14
    //   2294: aload 4
    //   2296: invokevirtual 410	org/json/JSONArray:length	()I
    //   2299: if_icmpge +143 -> 2442
    //   2302: aload 4
    //   2304: iload 14
    //   2306: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2309: astore 10
    //   2311: aload 10
    //   2313: ldc_w 486
    //   2316: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2319: ifeq +1607 -> 3926
    //   2322: aload 10
    //   2324: ldc_w 486
    //   2327: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2330: astore_3
    //   2331: ldc 13
    //   2333: aload_3
    //   2334: invokevirtual 594	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2337: ifeq +31 -> 2368
    //   2340: aload 10
    //   2342: ldc_w 596
    //   2345: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2348: ifeq +1583 -> 3931
    //   2351: aload 10
    //   2353: ldc_w 596
    //   2356: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2359: astore_3
    //   2360: aload_0
    //   2361: aload_3
    //   2362: putfield 598	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:f	Ljava/lang/String;
    //   2365: goto +1552 -> 3917
    //   2368: ldc 20
    //   2370: aload_3
    //   2371: invokevirtual 594	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2374: ifeq +31 -> 2405
    //   2377: aload 10
    //   2379: ldc_w 596
    //   2382: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2385: ifeq +1551 -> 3936
    //   2388: aload 10
    //   2390: ldc_w 596
    //   2393: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2396: astore_3
    //   2397: aload_0
    //   2398: aload_3
    //   2399: putfield 599	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:e	Ljava/lang/String;
    //   2402: goto +1515 -> 3917
    //   2405: ldc 17
    //   2407: aload_3
    //   2408: invokevirtual 594	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2411: ifeq +1506 -> 3917
    //   2414: aload 10
    //   2416: ldc_w 596
    //   2419: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2422: ifeq +1519 -> 3941
    //   2425: aload 10
    //   2427: ldc_w 596
    //   2430: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2433: astore_3
    //   2434: aload_0
    //   2435: aload_3
    //   2436: putfield 601	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:g	Ljava/lang/String;
    //   2439: goto +1478 -> 3917
    //   2442: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2445: ifeq +58 -> 2503
    //   2448: ldc 8
    //   2450: iconst_2
    //   2451: new 194	java/lang/StringBuilder
    //   2454: dup
    //   2455: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2458: ldc_w 603
    //   2461: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2464: aload_0
    //   2465: getfield 598	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:f	Ljava/lang/String;
    //   2468: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2471: ldc_w 605
    //   2474: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: aload_0
    //   2478: getfield 601	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:g	Ljava/lang/String;
    //   2481: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2484: ldc_w 607
    //   2487: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2490: aload_0
    //   2491: getfield 599	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:e	Ljava/lang/String;
    //   2494: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2497: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2500: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2503: aload_0
    //   2504: aload 9
    //   2506: ldc_w 609
    //   2509: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   2512: astore 4
    //   2514: aload 4
    //   2516: ifnull +299 -> 2815
    //   2519: aload 4
    //   2521: invokevirtual 410	org/json/JSONArray:length	()I
    //   2524: ifle +291 -> 2815
    //   2527: aload_0
    //   2528: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2531: astore 10
    //   2533: aload 4
    //   2535: iconst_0
    //   2536: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2539: ldc_w 480
    //   2542: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2545: ifeq +1401 -> 3946
    //   2548: aload 4
    //   2550: iconst_0
    //   2551: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2554: ldc_w 480
    //   2557: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2560: astore_3
    //   2561: aload 10
    //   2563: aload_3
    //   2564: putfield 610	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2567: aload_0
    //   2568: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2571: astore 10
    //   2573: aload 4
    //   2575: iconst_0
    //   2576: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2579: ldc_w 486
    //   2582: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2585: ifeq +1367 -> 3952
    //   2588: aload 4
    //   2590: iconst_0
    //   2591: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2594: ldc_w 486
    //   2597: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2600: astore_3
    //   2601: aload 10
    //   2603: aload_3
    //   2604: putfield 611	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2607: aload_0
    //   2608: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2611: astore 10
    //   2613: aload 4
    //   2615: iconst_0
    //   2616: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2619: ldc_w 596
    //   2622: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2625: ifeq +1333 -> 3958
    //   2628: new 194	java/lang/StringBuilder
    //   2631: dup
    //   2632: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   2635: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   2638: getfield 612	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2641: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2644: aload 4
    //   2646: iconst_0
    //   2647: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2650: ldc_w 596
    //   2653: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2656: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2662: astore_3
    //   2663: aload 10
    //   2665: aload_3
    //   2666: putfield 613	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2669: aload_0
    //   2670: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2673: astore_3
    //   2674: aload 4
    //   2676: iconst_0
    //   2677: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2680: ldc_w 615
    //   2683: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2686: ifeq +1278 -> 3964
    //   2689: aload 4
    //   2691: iconst_0
    //   2692: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2695: ldc_w 615
    //   2698: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2701: istore 14
    //   2703: aload_3
    //   2704: iload 14
    //   2706: putfield 616	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_Int	I
    //   2709: aload_0
    //   2710: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2713: astore_3
    //   2714: aload 4
    //   2716: iconst_0
    //   2717: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2720: ldc_w 618
    //   2723: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2726: ifeq +1244 -> 3970
    //   2729: aload 4
    //   2731: iconst_0
    //   2732: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2735: ldc_w 618
    //   2738: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2741: istore 14
    //   2743: aload_3
    //   2744: iload 14
    //   2746: putfield 619	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_b_of_type_Int	I
    //   2749: aload_0
    //   2750: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2753: astore_3
    //   2754: aload 4
    //   2756: iconst_0
    //   2757: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2760: ldc_w 621
    //   2763: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2766: ifeq +1211 -> 3977
    //   2769: aload 4
    //   2771: iconst_0
    //   2772: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2775: ldc_w 621
    //   2778: invokevirtual 444	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2781: istore 14
    //   2783: aload_3
    //   2784: iload 14
    //   2786: putfield 622	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_c_of_type_Int	I
    //   2789: aload_0
    //   2790: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2793: iconst_1
    //   2794: putfield 623	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:j	I
    //   2797: aload_0
    //   2798: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2801: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   2804: ifeq +935 -> 3739
    //   2807: aload_0
    //   2808: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2811: iconst_2
    //   2812: putfield 624	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:e	I
    //   2815: aload_0
    //   2816: aload 9
    //   2818: ldc_w 626
    //   2821: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   2824: astore_3
    //   2825: aload_3
    //   2826: ifnull +100 -> 2926
    //   2829: aload_3
    //   2830: invokevirtual 410	org/json/JSONArray:length	()I
    //   2833: ifle +93 -> 2926
    //   2836: aload_0
    //   2837: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   2840: aload_3
    //   2841: iconst_0
    //   2842: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2845: ldc_w 480
    //   2848: ldc 113
    //   2850: invokevirtual 630	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2853: putfield 145	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2856: aload_0
    //   2857: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   2860: aload_3
    //   2861: iconst_0
    //   2862: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2865: ldc_w 486
    //   2868: ldc 113
    //   2870: invokevirtual 630	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2873: putfield 631	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2876: aload_0
    //   2877: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   2880: aload_3
    //   2881: iconst_0
    //   2882: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2885: ldc_w 633
    //   2888: invokevirtual 635	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2891: putfield 282	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2894: aload_0
    //   2895: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   2898: bipush 8
    //   2900: putfield 155	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo:j	I
    //   2903: aload 6
    //   2905: invokevirtual 637	com/tencent/mobileqq/app/IndividualRedPacketManager:b	()V
    //   2908: aload_0
    //   2909: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   2912: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   2915: ifeq +837 -> 3752
    //   2918: aload_0
    //   2919: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   2922: iconst_2
    //   2923: putfield 289	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo:e	I
    //   2926: aload_0
    //   2927: aload 9
    //   2929: ldc_w 639
    //   2932: invokevirtual 407	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   2935: astore 4
    //   2937: aload 4
    //   2939: ifnull +262 -> 3201
    //   2942: aload 4
    //   2944: invokevirtual 410	org/json/JSONArray:length	()I
    //   2947: ifle +254 -> 3201
    //   2950: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2953: ifeq +12 -> 2965
    //   2956: ldc 8
    //   2958: iconst_2
    //   2959: ldc_w 641
    //   2962: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2965: aload_0
    //   2966: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   2969: astore 9
    //   2971: aload 4
    //   2973: iconst_0
    //   2974: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2977: ldc_w 480
    //   2980: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2983: ifeq +1001 -> 3984
    //   2986: aload 4
    //   2988: iconst_0
    //   2989: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   2992: ldc_w 480
    //   2995: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2998: astore_3
    //   2999: aload 9
    //   3001: aload_3
    //   3002: putfield 610	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3005: aload_0
    //   3006: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3009: astore 9
    //   3011: aload 4
    //   3013: iconst_0
    //   3014: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   3017: ldc_w 486
    //   3020: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3023: ifeq +967 -> 3990
    //   3026: aload 4
    //   3028: iconst_0
    //   3029: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   3032: ldc_w 486
    //   3035: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3038: astore_3
    //   3039: aload 9
    //   3041: aload_3
    //   3042: putfield 611	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3045: aload_0
    //   3046: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3049: astore 9
    //   3051: aload 4
    //   3053: iconst_0
    //   3054: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   3057: ldc_w 596
    //   3060: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3063: ifeq +933 -> 3996
    //   3066: new 194	java/lang/StringBuilder
    //   3069: dup
    //   3070: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3073: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   3076: getfield 612	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3079: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3082: aload 4
    //   3084: iconst_0
    //   3085: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   3088: ldc_w 596
    //   3091: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3094: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3100: astore_3
    //   3101: aload 9
    //   3103: aload_3
    //   3104: putfield 613	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3107: aload_0
    //   3108: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3111: bipush 11
    //   3113: putfield 623	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:j	I
    //   3116: new 194	java/lang/StringBuilder
    //   3119: dup
    //   3120: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3123: astore_3
    //   3124: aload_0
    //   3125: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3128: astore 9
    //   3130: aload_3
    //   3131: aload 9
    //   3133: getfield 115	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3136: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3139: astore 10
    //   3141: aload 4
    //   3143: iconst_0
    //   3144: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   3147: ldc_w 643
    //   3150: invokevirtual 177	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3153: ifeq +849 -> 4002
    //   3156: aload 4
    //   3158: iconst_0
    //   3159: invokevirtual 413	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   3162: ldc_w 643
    //   3165: invokevirtual 419	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3168: astore_3
    //   3169: aload 9
    //   3171: aload 10
    //   3173: aload_3
    //   3174: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3180: putfield 115	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3183: aload_0
    //   3184: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3187: invokestatic 536	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   3190: ifeq +575 -> 3765
    //   3193: aload_0
    //   3194: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3197: iconst_2
    //   3198: putfield 624	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:e	I
    //   3201: aload 7
    //   3203: aload 8
    //   3205: invokevirtual 647	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   3208: pop
    //   3209: aload_0
    //   3210: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3213: getfield 624	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:e	I
    //   3216: iconst_2
    //   3217: if_icmpne +561 -> 3778
    //   3220: aload_0
    //   3221: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   3224: getfield 289	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo:e	I
    //   3227: iconst_2
    //   3228: if_icmpne +550 -> 3778
    //   3231: aload 6
    //   3233: invokevirtual 327	com/tencent/mobileqq/app/IndividualRedPacketManager:b	()Z
    //   3236: ifeq +542 -> 3778
    //   3239: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3242: ifeq +12 -> 3254
    //   3245: ldc 8
    //   3247: iconst_2
    //   3248: ldc_w 649
    //   3251: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3254: aload_0
    //   3255: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3258: aload_0
    //   3259: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3262: invokevirtual 652	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3265: pop
    //   3266: aload 6
    //   3268: aload_0
    //   3269: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3272: invokevirtual 655	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;)V
    //   3275: aload_0
    //   3276: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3279: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3282: invokevirtual 238	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   3285: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   3288: getfield 247	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   3291: invokestatic 250	com/tencent/mobileqq/vas/ClubContentJsonTask:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   3294: istore 14
    //   3296: aload 6
    //   3298: invokevirtual 126	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Landroid/content/SharedPreferences;
    //   3301: new 194	java/lang/StringBuilder
    //   3304: dup
    //   3305: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3308: ldc_w 258
    //   3311: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3314: iload 14
    //   3316: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3319: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3322: lconst_0
    //   3323: invokeinterface 658 4 0
    //   3328: lstore 16
    //   3330: aload_0
    //   3331: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3334: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3337: invokevirtual 238	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   3340: invokestatic 663	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   3343: istore 15
    //   3345: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3348: ifeq +66 -> 3414
    //   3351: ldc 8
    //   3353: iconst_2
    //   3354: new 194	java/lang/StringBuilder
    //   3357: dup
    //   3358: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3361: ldc_w 665
    //   3364: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3367: iload 15
    //   3369: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3372: ldc_w 667
    //   3375: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3378: aload 7
    //   3380: invokevirtual 228	java/util/ArrayList:size	()I
    //   3383: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3386: ldc_w 669
    //   3389: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3392: iload 14
    //   3394: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3397: ldc_w 671
    //   3400: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3403: lload 16
    //   3405: invokevirtual 392	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3408: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3411: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3414: aload_0
    //   3415: getfield 222	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3418: ifnonnull +435 -> 3853
    //   3421: aload_0
    //   3422: aload 7
    //   3424: putfield 222	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3427: aload_0
    //   3428: getfield 98	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3431: invokevirtual 358	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3434: ifne +39 -> 3473
    //   3437: iconst_1
    //   3438: iload 15
    //   3440: if_icmpeq +7 -> 3447
    //   3443: iload_1
    //   3444: ifeq +29 -> 3473
    //   3447: aload_0
    //   3448: getfield 222	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3451: invokevirtual 228	java/util/ArrayList:size	()I
    //   3454: aload_0
    //   3455: getfield 215	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_Int	I
    //   3458: if_icmple +15 -> 3473
    //   3461: aload 6
    //   3463: invokevirtual 327	com/tencent/mobileqq/app/IndividualRedPacketManager:b	()Z
    //   3466: ifeq +7 -> 3473
    //   3469: aload_0
    //   3470: invokevirtual 278	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	()V
    //   3473: aload_0
    //   3474: getfield 100	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3477: iconst_1
    //   3478: invokevirtual 211	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   3481: aload_0
    //   3482: getfield 91	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   3485: astore_3
    //   3486: aload_3
    //   3487: monitorenter
    //   3488: aload_0
    //   3489: getfield 91	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   3492: invokeinterface 589 1 0
    //   3497: ifle +212 -> 3709
    //   3500: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3503: ifeq +12 -> 3515
    //   3506: ldc 8
    //   3508: iconst_2
    //   3509: ldc_w 673
    //   3512: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3515: aload 6
    //   3517: invokevirtual 126	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Landroid/content/SharedPreferences;
    //   3520: ldc_w 675
    //   3523: lconst_0
    //   3524: invokeinterface 658 4 0
    //   3529: lstore 16
    //   3531: invokestatic 436	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   3534: lstore 18
    //   3536: lload 18
    //   3538: lload 16
    //   3540: lsub
    //   3541: ldc2_w 676
    //   3544: lcmp
    //   3545: ifle +164 -> 3709
    //   3548: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3551: ifeq +12 -> 3563
    //   3554: ldc 8
    //   3556: iconst_2
    //   3557: ldc_w 679
    //   3560: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3563: aload_0
    //   3564: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3567: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3570: invokevirtual 238	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   3573: astore 4
    //   3575: new 153	java/io/File
    //   3578: dup
    //   3579: aload 4
    //   3581: invokevirtual 561	android/content/Context:getFilesDir	()Ljava/io/File;
    //   3584: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   3587: getfield 562	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3590: invokespecial 682	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3593: astore 7
    //   3595: new 291	android/os/Bundle
    //   3598: dup
    //   3599: invokespecial 292	android/os/Bundle:<init>	()V
    //   3602: astore 8
    //   3604: aload 8
    //   3606: ldc_w 523
    //   3609: aload 4
    //   3611: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   3614: getfield 247	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   3617: invokestatic 250	com/tencent/mobileqq/vas/ClubContentJsonTask:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   3620: invokevirtual 296	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3623: aload 8
    //   3625: ldc_w 684
    //   3628: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   3631: getfield 247	com/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo:e	Ljava/lang/String;
    //   3634: invokevirtual 300	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3637: aload 8
    //   3639: ldc_w 686
    //   3642: ldc_w 688
    //   3645: invokevirtual 300	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3648: aload 8
    //   3650: ldc_w 690
    //   3653: ldc_w 692
    //   3656: invokevirtual 300	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3659: aload 8
    //   3661: ldc_w 694
    //   3664: iconst_1
    //   3665: invokevirtual 697	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   3668: aload_0
    //   3669: getfield 109	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3672: getstatic 243	com/tencent/mobileqq/vas/ClubContentJsonTask:k	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;
    //   3675: aconst_null
    //   3676: aload 7
    //   3678: aload 8
    //   3680: invokestatic 700	com/tencent/mobileqq/vas/ClubContentJsonTask:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/vas/ClubContentJsonTask$TaskInfo;Ljava/lang/String;Ljava/io/File;Landroid/os/Bundle;)V
    //   3683: aload 6
    //   3685: invokevirtual 126	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Landroid/content/SharedPreferences;
    //   3688: invokeinterface 256 1 0
    //   3693: ldc_w 675
    //   3696: lload 18
    //   3698: invokeinterface 270 4 0
    //   3703: invokeinterface 273 1 0
    //   3708: pop
    //   3709: aload_3
    //   3710: monitorexit
    //   3711: goto -1899 -> 1812
    //   3714: astore 4
    //   3716: aload_3
    //   3717: monitorexit
    //   3718: aload 4
    //   3720: athrow
    //   3721: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3724: ifeq -1221 -> 2503
    //   3727: ldc 8
    //   3729: iconst_2
    //   3730: ldc_w 702
    //   3733: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3736: goto -1233 -> 2503
    //   3739: aload 7
    //   3741: aload_0
    //   3742: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3745: invokevirtual 586	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3748: pop
    //   3749: goto -934 -> 2815
    //   3752: aload 7
    //   3754: aload_0
    //   3755: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   3758: invokevirtual 586	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3761: pop
    //   3762: goto -836 -> 2926
    //   3765: aload 7
    //   3767: aload_0
    //   3768: getfield 81	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3771: invokevirtual 586	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3774: pop
    //   3775: goto -574 -> 3201
    //   3778: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3781: ifeq -506 -> 3275
    //   3784: new 194	java/lang/StringBuilder
    //   3787: dup
    //   3788: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   3791: ldc_w 704
    //   3794: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3797: astore_3
    //   3798: aload_0
    //   3799: getfield 79	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   3802: getfield 624	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:e	I
    //   3805: iconst_2
    //   3806: if_icmpne +202 -> 4008
    //   3809: iconst_1
    //   3810: istore_2
    //   3811: aload_3
    //   3812: iload_2
    //   3813: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3816: ldc_w 706
    //   3819: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3822: astore_3
    //   3823: aload_0
    //   3824: getfield 86	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   3827: getfield 289	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo:e	I
    //   3830: iconst_2
    //   3831: if_icmpne +182 -> 4013
    //   3834: iconst_1
    //   3835: istore_2
    //   3836: ldc 8
    //   3838: iconst_2
    //   3839: aload_3
    //   3840: iload_2
    //   3841: invokevirtual 321	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3844: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3847: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3850: goto -575 -> 3275
    //   3853: aload_0
    //   3854: getfield 222	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3857: aload 7
    //   3859: invokevirtual 647	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   3862: pop
    //   3863: goto -436 -> 3427
    //   3866: goto -3320 -> 546
    //   3869: iconst_0
    //   3870: istore_1
    //   3871: goto -3325 -> 546
    //   3874: iconst_0
    //   3875: istore 14
    //   3877: goto -3200 -> 677
    //   3880: iconst_1
    //   3881: istore 15
    //   3883: goto -2990 -> 893
    //   3886: ldc 113
    //   3888: astore_3
    //   3889: goto -2705 -> 1184
    //   3892: ldc 113
    //   3894: astore_3
    //   3895: goto -2678 -> 1217
    //   3898: iload 14
    //   3900: iconst_1
    //   3901: iadd
    //   3902: istore 14
    //   3904: goto -3227 -> 677
    //   3907: iconst_0
    //   3908: istore_2
    //   3909: goto -1761 -> 2148
    //   3912: iconst_0
    //   3913: istore_2
    //   3914: goto -1740 -> 2174
    //   3917: iload 14
    //   3919: iconst_1
    //   3920: iadd
    //   3921: istore 14
    //   3923: goto -1631 -> 2292
    //   3926: aconst_null
    //   3927: astore_3
    //   3928: goto -1597 -> 2331
    //   3931: aconst_null
    //   3932: astore_3
    //   3933: goto -1573 -> 2360
    //   3936: aconst_null
    //   3937: astore_3
    //   3938: goto -1541 -> 2397
    //   3941: aconst_null
    //   3942: astore_3
    //   3943: goto -1509 -> 2434
    //   3946: ldc 113
    //   3948: astore_3
    //   3949: goto -1388 -> 2561
    //   3952: ldc 113
    //   3954: astore_3
    //   3955: goto -1354 -> 2601
    //   3958: ldc 113
    //   3960: astore_3
    //   3961: goto -1298 -> 2663
    //   3964: iconst_1
    //   3965: istore 14
    //   3967: goto -1264 -> 2703
    //   3970: bipush 100
    //   3972: istore 14
    //   3974: goto -1231 -> 2743
    //   3977: bipush 20
    //   3979: istore 14
    //   3981: goto -1198 -> 2783
    //   3984: ldc 113
    //   3986: astore_3
    //   3987: goto -988 -> 2999
    //   3990: ldc 113
    //   3992: astore_3
    //   3993: goto -954 -> 3039
    //   3996: ldc 113
    //   3998: astore_3
    //   3999: goto -898 -> 3101
    //   4002: ldc 113
    //   4004: astore_3
    //   4005: goto -836 -> 3169
    //   4008: iconst_0
    //   4009: istore_2
    //   4010: goto -199 -> 3811
    //   4013: iconst_0
    //   4014: istore_2
    //   4015: goto -179 -> 3836
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4018	0	this	IndividualRedPacketResDownloader
    //   0	4018	1	paramBoolean1	boolean
    //   0	4018	2	paramBoolean2	boolean
    //   119	95	3	localJSONObject	JSONObject
    //   286	31	3	localObject1	Object
    //   334	1015	3	localObject2	Object
    //   1724	24	3	localJSONException	org.json.JSONException
    //   1770	20	3	localContext	android.content.Context
    //   1875	24	3	localException	Exception
    //   375	313	4	localObject4	Object
    //   1999	5	4	localObject5	Object
    //   2282	1328	4	localObject6	Object
    //   3714	5	4	localObject7	Object
    //   4	1809	5	localMap	Map
    //   85	3599	6	localIndividualRedPacketManager	IndividualRedPacketManager
    //   305	3553	7	localObject8	Object
    //   314	3365	8	localObject9	Object
    //   323	2847	9	localObject10	Object
    //   586	2586	10	localObject11	Object
    //   694	888	11	localObject12	Object
    //   780	1247	12	localObject13	Object
    //   793	47	13	str	String
    //   677	3303	14	i1	int
    //   863	3019	15	i2	int
    //   220	3319	16	l1	long
    //   272	3425	18	l2	long
    //   132	77	20	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	64	286	finally
    //   64	87	286	finally
    //   91	106	286	finally
    //   108	127	286	finally
    //   134	140	286	finally
    //   148	156	286	finally
    //   156	198	286	finally
    //   198	201	286	finally
    //   213	268	286	finally
    //   268	274	286	finally
    //   282	285	286	finally
    //   287	290	286	finally
    //   292	335	286	finally
    //   339	352	286	finally
    //   358	377	286	finally
    //   377	414	286	finally
    //   416	437	286	finally
    //   439	471	286	finally
    //   471	492	286	finally
    //   494	543	286	finally
    //   546	588	286	finally
    //   597	612	286	finally
    //   617	620	286	finally
    //   647	662	286	finally
    //   665	674	286	finally
    //   677	865	286	finally
    //   865	893	286	finally
    //   893	921	286	finally
    //   925	993	286	finally
    //   993	1003	286	finally
    //   1007	1075	286	finally
    //   1075	1085	286	finally
    //   1089	1157	286	finally
    //   1157	1184	286	finally
    //   1184	1217	286	finally
    //   1217	1250	286	finally
    //   1250	1277	286	finally
    //   1277	1350	286	finally
    //   1657	1662	286	finally
    //   1665	1721	286	finally
    //   1725	1760	286	finally
    //   1760	1812	286	finally
    //   1812	1815	286	finally
    //   1816	1872	286	finally
    //   1876	1911	286	finally
    //   1914	1970	286	finally
    //   2003	2006	286	finally
    //   2054	2074	286	finally
    //   2074	2094	286	finally
    //   2094	2114	286	finally
    //   2114	2146	286	finally
    //   2148	2172	286	finally
    //   2174	2188	286	finally
    //   2191	2202	286	finally
    //   2205	2216	286	finally
    //   2219	2230	286	finally
    //   2233	2273	286	finally
    //   2273	2284	286	finally
    //   2292	2331	286	finally
    //   2331	2360	286	finally
    //   2360	2365	286	finally
    //   2368	2397	286	finally
    //   2397	2402	286	finally
    //   2405	2434	286	finally
    //   2434	2439	286	finally
    //   2442	2503	286	finally
    //   2503	2514	286	finally
    //   2519	2561	286	finally
    //   2561	2601	286	finally
    //   2601	2663	286	finally
    //   2663	2703	286	finally
    //   2703	2743	286	finally
    //   2743	2783	286	finally
    //   2783	2815	286	finally
    //   2815	2825	286	finally
    //   2829	2926	286	finally
    //   2926	2937	286	finally
    //   2942	2965	286	finally
    //   2965	2999	286	finally
    //   2999	3039	286	finally
    //   3039	3101	286	finally
    //   3101	3169	286	finally
    //   3169	3201	286	finally
    //   3201	3254	286	finally
    //   3254	3275	286	finally
    //   3275	3414	286	finally
    //   3414	3427	286	finally
    //   3427	3437	286	finally
    //   3447	3473	286	finally
    //   3473	3488	286	finally
    //   3718	3721	286	finally
    //   3721	3736	286	finally
    //   3739	3749	286	finally
    //   3752	3762	286	finally
    //   3765	3775	286	finally
    //   3778	3809	286	finally
    //   3811	3834	286	finally
    //   3836	3850	286	finally
    //   3853	3863	286	finally
    //   213	268	1724	org/json/JSONException
    //   268	274	1724	org/json/JSONException
    //   292	335	1724	org/json/JSONException
    //   339	352	1724	org/json/JSONException
    //   358	377	1724	org/json/JSONException
    //   377	414	1724	org/json/JSONException
    //   416	437	1724	org/json/JSONException
    //   439	471	1724	org/json/JSONException
    //   471	492	1724	org/json/JSONException
    //   494	543	1724	org/json/JSONException
    //   546	588	1724	org/json/JSONException
    //   597	612	1724	org/json/JSONException
    //   647	662	1724	org/json/JSONException
    //   665	674	1724	org/json/JSONException
    //   677	865	1724	org/json/JSONException
    //   865	893	1724	org/json/JSONException
    //   893	921	1724	org/json/JSONException
    //   925	993	1724	org/json/JSONException
    //   993	1003	1724	org/json/JSONException
    //   1007	1075	1724	org/json/JSONException
    //   1075	1085	1724	org/json/JSONException
    //   1089	1157	1724	org/json/JSONException
    //   1157	1184	1724	org/json/JSONException
    //   1184	1217	1724	org/json/JSONException
    //   1217	1250	1724	org/json/JSONException
    //   1250	1277	1724	org/json/JSONException
    //   1277	1350	1724	org/json/JSONException
    //   1657	1662	1724	org/json/JSONException
    //   1665	1721	1724	org/json/JSONException
    //   1816	1872	1724	org/json/JSONException
    //   1914	1970	1724	org/json/JSONException
    //   2003	2006	1724	org/json/JSONException
    //   2054	2074	1724	org/json/JSONException
    //   2074	2094	1724	org/json/JSONException
    //   2094	2114	1724	org/json/JSONException
    //   2114	2146	1724	org/json/JSONException
    //   2148	2172	1724	org/json/JSONException
    //   2174	2188	1724	org/json/JSONException
    //   2191	2202	1724	org/json/JSONException
    //   2205	2216	1724	org/json/JSONException
    //   2219	2230	1724	org/json/JSONException
    //   2233	2273	1724	org/json/JSONException
    //   2273	2284	1724	org/json/JSONException
    //   2292	2331	1724	org/json/JSONException
    //   2331	2360	1724	org/json/JSONException
    //   2360	2365	1724	org/json/JSONException
    //   2368	2397	1724	org/json/JSONException
    //   2397	2402	1724	org/json/JSONException
    //   2405	2434	1724	org/json/JSONException
    //   2434	2439	1724	org/json/JSONException
    //   2442	2503	1724	org/json/JSONException
    //   2503	2514	1724	org/json/JSONException
    //   2519	2561	1724	org/json/JSONException
    //   2561	2601	1724	org/json/JSONException
    //   2601	2663	1724	org/json/JSONException
    //   2663	2703	1724	org/json/JSONException
    //   2703	2743	1724	org/json/JSONException
    //   2743	2783	1724	org/json/JSONException
    //   2783	2815	1724	org/json/JSONException
    //   2815	2825	1724	org/json/JSONException
    //   2829	2926	1724	org/json/JSONException
    //   2926	2937	1724	org/json/JSONException
    //   2942	2965	1724	org/json/JSONException
    //   2965	2999	1724	org/json/JSONException
    //   2999	3039	1724	org/json/JSONException
    //   3039	3101	1724	org/json/JSONException
    //   3101	3169	1724	org/json/JSONException
    //   3169	3201	1724	org/json/JSONException
    //   3201	3254	1724	org/json/JSONException
    //   3254	3275	1724	org/json/JSONException
    //   3275	3414	1724	org/json/JSONException
    //   3414	3427	1724	org/json/JSONException
    //   3427	3437	1724	org/json/JSONException
    //   3447	3473	1724	org/json/JSONException
    //   3473	3488	1724	org/json/JSONException
    //   3718	3721	1724	org/json/JSONException
    //   3721	3736	1724	org/json/JSONException
    //   3739	3749	1724	org/json/JSONException
    //   3752	3762	1724	org/json/JSONException
    //   3765	3775	1724	org/json/JSONException
    //   3778	3809	1724	org/json/JSONException
    //   3811	3834	1724	org/json/JSONException
    //   3836	3850	1724	org/json/JSONException
    //   3853	3863	1724	org/json/JSONException
    //   213	268	1875	java/lang/Exception
    //   268	274	1875	java/lang/Exception
    //   292	335	1875	java/lang/Exception
    //   339	352	1875	java/lang/Exception
    //   358	377	1875	java/lang/Exception
    //   377	414	1875	java/lang/Exception
    //   416	437	1875	java/lang/Exception
    //   439	471	1875	java/lang/Exception
    //   471	492	1875	java/lang/Exception
    //   494	543	1875	java/lang/Exception
    //   546	588	1875	java/lang/Exception
    //   597	612	1875	java/lang/Exception
    //   647	662	1875	java/lang/Exception
    //   665	674	1875	java/lang/Exception
    //   677	865	1875	java/lang/Exception
    //   865	893	1875	java/lang/Exception
    //   893	921	1875	java/lang/Exception
    //   925	993	1875	java/lang/Exception
    //   993	1003	1875	java/lang/Exception
    //   1007	1075	1875	java/lang/Exception
    //   1075	1085	1875	java/lang/Exception
    //   1089	1157	1875	java/lang/Exception
    //   1157	1184	1875	java/lang/Exception
    //   1184	1217	1875	java/lang/Exception
    //   1217	1250	1875	java/lang/Exception
    //   1250	1277	1875	java/lang/Exception
    //   1277	1350	1875	java/lang/Exception
    //   1657	1662	1875	java/lang/Exception
    //   1665	1721	1875	java/lang/Exception
    //   1816	1872	1875	java/lang/Exception
    //   1914	1970	1875	java/lang/Exception
    //   2003	2006	1875	java/lang/Exception
    //   2054	2074	1875	java/lang/Exception
    //   2074	2094	1875	java/lang/Exception
    //   2094	2114	1875	java/lang/Exception
    //   2114	2146	1875	java/lang/Exception
    //   2148	2172	1875	java/lang/Exception
    //   2174	2188	1875	java/lang/Exception
    //   2191	2202	1875	java/lang/Exception
    //   2205	2216	1875	java/lang/Exception
    //   2219	2230	1875	java/lang/Exception
    //   2233	2273	1875	java/lang/Exception
    //   2273	2284	1875	java/lang/Exception
    //   2292	2331	1875	java/lang/Exception
    //   2331	2360	1875	java/lang/Exception
    //   2360	2365	1875	java/lang/Exception
    //   2368	2397	1875	java/lang/Exception
    //   2397	2402	1875	java/lang/Exception
    //   2405	2434	1875	java/lang/Exception
    //   2434	2439	1875	java/lang/Exception
    //   2442	2503	1875	java/lang/Exception
    //   2503	2514	1875	java/lang/Exception
    //   2519	2561	1875	java/lang/Exception
    //   2561	2601	1875	java/lang/Exception
    //   2601	2663	1875	java/lang/Exception
    //   2663	2703	1875	java/lang/Exception
    //   2703	2743	1875	java/lang/Exception
    //   2743	2783	1875	java/lang/Exception
    //   2783	2815	1875	java/lang/Exception
    //   2815	2825	1875	java/lang/Exception
    //   2829	2926	1875	java/lang/Exception
    //   2926	2937	1875	java/lang/Exception
    //   2942	2965	1875	java/lang/Exception
    //   2965	2999	1875	java/lang/Exception
    //   2999	3039	1875	java/lang/Exception
    //   3039	3101	1875	java/lang/Exception
    //   3101	3169	1875	java/lang/Exception
    //   3169	3201	1875	java/lang/Exception
    //   3201	3254	1875	java/lang/Exception
    //   3254	3275	1875	java/lang/Exception
    //   3275	3414	1875	java/lang/Exception
    //   3414	3427	1875	java/lang/Exception
    //   3427	3437	1875	java/lang/Exception
    //   3447	3473	1875	java/lang/Exception
    //   3473	3488	1875	java/lang/Exception
    //   3718	3721	1875	java/lang/Exception
    //   3721	3736	1875	java/lang/Exception
    //   3739	3749	1875	java/lang/Exception
    //   3752	3762	1875	java/lang/Exception
    //   3765	3775	1875	java/lang/Exception
    //   3778	3809	1875	java/lang/Exception
    //   3811	3834	1875	java/lang/Exception
    //   3836	3850	1875	java/lang/Exception
    //   3853	3863	1875	java/lang/Exception
    //   1350	1392	1999	finally
    //   1395	1475	1999	finally
    //   1475	1561	1999	finally
    //   1561	1648	1999	finally
    //   1985	1996	1999	finally
    //   2001	2003	1999	finally
    //   2006	2017	1999	finally
    //   2020	2031	1999	finally
    //   2034	2052	1999	finally
    //   2052	2054	1999	finally
    //   3488	3515	3714	finally
    //   3515	3536	3714	finally
    //   3548	3563	3714	finally
    //   3563	3709	3714	finally
    //   3709	3711	3714	finally
    //   3716	3718	3714	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividualRedPacketResDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */