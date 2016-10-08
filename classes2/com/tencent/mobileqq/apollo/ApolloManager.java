package com.tencent.mobileqq.apollo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ppu;
import ppv;
import ppw;
import ppx;
import ppy;
import ppz;
import pqa;
import pqb;
import pqc;
import pqd;
import pqe;
import pqf;

public class ApolloManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 6;
  public static final String a = "ApolloManager";
  public static ArrayList a;
  public static Vector a;
  public static boolean a = false;
  private static int jdField_b_of_type_Int = 0;
  public static String b;
  public static ArrayList b;
  public static Vector b;
  public static boolean b = false;
  private static final String jdField_c_of_type_JavaLangString = "apollo_res_version_info.json";
  public static boolean c = false;
  private static final String jdField_d_of_type_JavaLangString = "role_version";
  private static boolean jdField_d_of_type_Boolean = false;
  private static final String jdField_e_of_type_JavaLangString = "dress_version";
  private static boolean jdField_e_of_type_Boolean = false;
  private static final String jdField_f_of_type_JavaLangString = "action_version";
  private static boolean jdField_f_of_type_Boolean;
  private static String jdField_g_of_type_JavaLangString;
  public Handler a;
  ApolloResDownloader.OnApolloDownLoadListener jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener;
  public ApolloListenerManager a;
  public QQAppInterface a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new pqb(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ppu(this);
  public HashMap a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public JSONObject a;
  public DownloadListener b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ppz(this);
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_c_of_type_Int = 4096;
  private Runnable jdField_c_of_type_JavaLangRunnable = new pqa(this);
  private int jdField_d_of_type_Int = 4097;
  private volatile boolean jdField_g_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    f = true;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
    jdField_b_of_type_JavaUtilArrayList = new ArrayList(16);
    jdField_b_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  public ApolloManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new pqc(this);
    this.jdField_a_of_type_AndroidOsHandler = new ppw(this, ThreadManager.b());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaUtilVector.clear();
    jdField_b_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    if (b(paramQQAppInterface.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager = new ApolloListenerManager();
      c();
      ThreadManager.b().post(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.a().post(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    for (;;)
    {
      try
      {
        if (jdField_b_of_type_Int == -1)
        {
          jdField_b_of_type_Int = 0;
          if (paramAppInterface != null)
          {
            i = SharedPreUtils.o(paramAppInterface.getApplication());
            if (i != 0) {
              continue;
            }
            jdField_b_of_type_Int = paramAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramAppInterface.a() + "_whiteList", 0);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "white list global: " + i + ", mWhiteUserStatus: " + jdField_b_of_type_Int);
            }
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloManager", 2, "getWhiteListStatus error = " + paramAppInterface.toString());
        continue;
      }
      return jdField_b_of_type_Int;
      if (1 == i) {
        jdField_b_of_type_Int = 1;
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int j;
    if ((paramQQAppInterface == null) || (!b(paramQQAppInterface.getApplication())) || (TextUtils.isEmpty(paramString1)) || (ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject == null))
    {
      j = -1;
      return j;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramQQAppInterface.a()))
      {
        Object localObject = (ApolloManager)paramQQAppInterface.getManager(152);
        str = paramString2;
        if (localObject != null)
        {
          localObject = ((ApolloManager)localObject).b(paramQQAppInterface.a());
          str = paramString2;
          if (localObject != null)
          {
            i = ((ApolloBaseInfo)localObject).apolloStatus;
            j = a(paramQQAppInterface);
            str = j + "x" + i;
          }
        }
      }
    }
    if (ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      paramQQAppInterface = ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(str);
      if (paramQQAppInterface == null) {}
    }
    for (int i = paramQQAppInterface.optInt(paramString1);; i = -1)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloManager", 2, "queryStatusInConfig ruleKey: " + str + ", entry = " + paramString1 + ", value=" + i);
      return i;
    }
  }
  
  private DownloaderInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +39 -> 47
    //   11: ldc 12
    //   13: iconst_2
    //   14: new 204	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 296
    //   24: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 298
    //   34: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: invokevirtual 304	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   51: aload_1
    //   52: invokevirtual 310	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore_0
    //   56: new 312	java/io/FileOutputStream
    //   59: dup
    //   60: new 314	java/io/File
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 317	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: astore_1
    //   72: sipush 4096
    //   75: newarray <illegal type>
    //   77: astore_2
    //   78: aload_0
    //   79: aload_2
    //   80: invokevirtual 326	java/io/InputStream:read	([B)I
    //   83: istore 5
    //   85: iload 5
    //   87: iconst_m1
    //   88: if_icmpeq +75 -> 163
    //   91: aload_1
    //   92: aload_2
    //   93: iconst_0
    //   94: iload 5
    //   96: invokevirtual 330	java/io/FileOutputStream:write	([BII)V
    //   99: goto -21 -> 78
    //   102: astore_3
    //   103: aload_0
    //   104: astore_2
    //   105: aload_3
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   111: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +32 -> 146
    //   117: ldc 12
    //   119: iconst_2
    //   120: new 204	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 335
    //   130: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: invokevirtual 338	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   137: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 341	java/io/InputStream:close	()V
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 342	java/io/FileOutputStream:close	()V
    //   162: return
    //   163: aload_1
    //   164: invokevirtual 345	java/io/FileOutputStream:flush	()V
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 341	java/io/InputStream:close	()V
    //   175: aload_1
    //   176: ifnull -14 -> 162
    //   179: aload_1
    //   180: invokevirtual 342	java/io/FileOutputStream:close	()V
    //   183: return
    //   184: astore_0
    //   185: return
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_1
    //   189: aload 4
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 341	java/io/InputStream:close	()V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 342	java/io/FileOutputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: astore_1
    //   211: goto -3 -> 208
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_0
    //   218: astore_2
    //   219: aload_3
    //   220: astore_0
    //   221: goto -29 -> 192
    //   224: astore_3
    //   225: aload_0
    //   226: astore_2
    //   227: aload_3
    //   228: astore_0
    //   229: goto -37 -> 192
    //   232: astore_0
    //   233: goto -41 -> 192
    //   236: astore_0
    //   237: return
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_1
    //   241: aload_3
    //   242: astore_2
    //   243: goto -136 -> 107
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_1
    //   249: aload_0
    //   250: astore_2
    //   251: aload_3
    //   252: astore_0
    //   253: goto -146 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramContext	Context
    //   0	256	1	paramString1	String
    //   0	256	2	paramString2	String
    //   4	1	3	localObject1	Object
    //   102	4	3	localException1	Exception
    //   214	6	3	localObject2	Object
    //   224	18	3	localObject3	Object
    //   246	6	3	localException2	Exception
    //   1	189	4	localObject4	Object
    //   83	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   72	78	102	java/lang/Exception
    //   78	85	102	java/lang/Exception
    //   91	99	102	java/lang/Exception
    //   163	167	102	java/lang/Exception
    //   171	175	184	java/lang/Exception
    //   179	183	184	java/lang/Exception
    //   47	56	186	finally
    //   196	200	210	java/lang/Exception
    //   204	208	210	java/lang/Exception
    //   56	72	214	finally
    //   72	78	224	finally
    //   78	85	224	finally
    //   91	99	224	finally
    //   163	167	224	finally
    //   107	146	232	finally
    //   150	154	236	java/lang/Exception
    //   158	162	236	java/lang/Exception
    //   47	56	238	java/lang/Exception
    //   56	72	246	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    ThreadManager.a().post(new ppx(paramAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      Object localObject = (ApolloManager)paramQQAppInterface.getManager(152);
      paramQQAppInterface = (VasExtensionHandler)paramQQAppInterface.a(71);
      localObject = ((ApolloManager)localObject).b(paramString1 + "");
      if ((localObject == null) || (((ApolloBaseInfo)localObject).apolloUpdateTime == 0L))
      {
        paramQQAppInterface.b(paramString1 + "");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "checkUserDress---> getApolloBaseInfo uin: " + paramString1.substring(0, 4));
        }
      }
      while ((QLog.isColorLevel()) && (localObject != null) && (((ApolloBaseInfo)localObject).apolloStatus != 1))
      {
        QLog.d("ApolloManager", 2, "checkUserDress---> user apollo status is not open uin: " + paramString1 + ", status: " + ((ApolloBaseInfo)localObject).apolloStatus);
        return;
        if ((((ApolloBaseInfo)localObject).apolloStatus == 1) && (((ApolloBaseInfo)localObject).apolloServerTS != ((ApolloBaseInfo)localObject).apolloLocalTS))
        {
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(Long.valueOf(Long.parseLong(paramString1)));
          paramQQAppInterface.a(localArrayList, paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "checkUserDress---> getGetUserApolloDress uin: " + paramString1.substring(0, 4) + ", old dress: " + ((ApolloBaseInfo)localObject).getApolloDress());
          }
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if (ApolloConfigUtils.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt))) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "queryErrorAction actionId=" + paramInt + " is " + bool);
    }
    return bool;
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, Boolean.valueOf(true));
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    if (!b(paramContext)) {
      return false;
    }
    if ((paramBoolean.booleanValue()) && (1 != a((QQAppInterface)BaseApplicationImpl.a.a()))) {
      return false;
    }
    paramContext = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.apollo_info.name(), "");
    if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals(jdField_g_of_type_JavaLangString)))
    {
      jdField_g_of_type_JavaLangString = paramContext;
      paramBoolean = paramContext.split("\\|");
      if (paramBoolean.length > 0) {
        f = "1".equals(paramBoolean[0]);
      }
    }
    if ((!f) && (QLog.isColorLevel())) {
      QLog.d("ApolloManager", 2, "apolloInfo : " + paramContext);
    }
    return f;
  }
  
  public static boolean b(Context paramContext)
  {
    if (jdField_d_of_type_Boolean) {
      return e;
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      if (e) {
        break;
      }
      jdField_d_of_type_Boolean = true;
      return e;
    }
    if (paramContext != null)
    {
      e = c(paramContext);
      jdField_d_of_type_Boolean = true;
    }
    return e;
  }
  
  public static int c(String paramString)
  {
    if (ApolloConfigUtils.b == null) {
      return 0;
    }
    return ApolloConfigUtils.b.optInt(paramString);
  }
  
  private void c()
  {
    ThreadManager.a(new ppy(this), 5, null, false);
  }
  
  private static boolean c(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
        if (paramContext != null)
        {
          int i = paramContext.reqGlEsVersion;
          if (i >= 131072) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Throwable paramContext) {}
    }
    QLog.e("ApolloManager", 2, "isOpenglSupport:" + paramContext.getMessage());
    return false;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "initApolloBaseInfoCache begin");
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      if (this.jdField_g_of_type_Boolean) {}
      for (;;)
      {
        return;
        try
        {
          ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloBaseInfo.class);
          if (??? == null) {
            break label214;
          }
          Iterator localIterator = ((ArrayList)???).iterator();
          while (localIterator.hasNext())
          {
            ApolloBaseInfo localApolloBaseInfo2 = (ApolloBaseInfo)localIterator.next();
            if ((localApolloBaseInfo2 != null) && (!TextUtils.isEmpty(localApolloBaseInfo2.uin))) {
              synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
              {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localApolloBaseInfo2.uin, localApolloBaseInfo2);
              }
            }
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "initApolloBaseInfoCache oom", localOutOfMemoryError);
          }
        }
      }
    }
    ApolloBaseInfo localApolloBaseInfo1 = (ApolloBaseInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (localApolloBaseInfo1 != null) {}
    for (int i = localApolloBaseInfo1.apolloStatus;; i = 0)
    {
      QLog.d("ApolloManager", 2, "initApolloBaseInfoCache end size: " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ", apollo status: " + i);
      return;
      label214:
      this.jdField_g_of_type_Boolean = true;
      break;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "initApolloPandoraCache begin...");
    }
    try
    {
      ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloPandora.class);
      if (??? != null)
      {
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext())
        {
          ApolloPandora localApolloPandora = (ApolloPandora)localIterator.next();
          if ((localApolloPandora != null) && (localApolloPandora.uin != null)) {
            synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localApolloPandora.uin, localApolloPandora);
            }
          }
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloManager", 2, "initApolloPandoraCache oom", localOutOfMemoryError);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "initApolloPandoraCache end size:" + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
    }
  }
  
  public int a(String paramString)
  {
    paramString = b(paramString);
    if ((paramString == null) || (paramString.apolloVipLevel < 1)) {
      return 1;
    }
    return paramString.apolloVipLevel;
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {}
    for (;;)
    {
      return 0L;
      JSONObject localJSONObject = null;
      if (paramInt1 == 3) {
        localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("action_version");
      }
      while (localJSONObject != null)
      {
        return localJSONObject.optLong(String.valueOf(paramInt2));
        if (paramInt1 == 2) {
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("dress_version");
        } else if (paramInt1 == 1) {
          localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("role_version");
        }
      }
    }
  }
  
  public ApolloResDownloader.OnApolloDownLoadListener a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener = new pqf(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloResDownloader$OnApolloDownLoadListener;
  }
  
  public ApolloBaseInfo a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return null;
    }
    return (ApolloBaseInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ApolloPandora a(String paramString, boolean paramBoolean)
  {
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    ApolloPandora localApolloPandora;
    do
    {
      do
      {
        return (ApolloPandora)???;
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramString)) {
          return (ApolloPandora)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        }
      } while (!paramBoolean);
      localApolloPandora = (ApolloPandora)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloPandora.class, paramString);
      ??? = localApolloPandora;
    } while (localApolloPandora == null);
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localApolloPandora);
      return localApolloPandora;
    }
  }
  
  public File a(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return new File(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public File a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    return new File(ApolloUtil.a(paramApolloActionPackage));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "start download action json");
    }
    DownloadTask localDownloadTask = new DownloadTask("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/action_android_v3.json", new File(ApolloUtil.c));
    localDownloadTask.n = false;
    localDownloadTask.h = false;
    localDownloadTask.l = true;
    localDownloadTask.o = false;
    if (a() != null)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_begin", 0, 0, new String[0]);
      a().a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, null);
    }
  }
  
  public void a(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0).edit().putInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_whiteList", paramInt).commit();
      i = SharedPreUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      if (i != 0) {
        break label135;
      }
      jdField_b_of_type_Int = paramInt;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "update white list " + i + ", mWhiteUserStatus: " + jdField_b_of_type_Int + ", status: " + paramInt);
      }
      return;
      label135:
      if (1 == i) {
        jdField_b_of_type_Int = 1;
      } else {
        jdField_b_of_type_Int = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    }
    if (paramInt1 == 3) {}
    label249:
    Object localObject2;
    for (String str = "action_version";; localObject2 = null) {
      for (;;)
      {
        JSONObject localJSONObject1;
        int j;
        if (str != null)
        {
          ??? = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(str);
          localJSONObject1 = ???;
          if (??? == null) {
            localJSONObject1 = new JSONObject();
          }
          j = 0;
        }
        synchronized (this.jdField_a_of_type_OrgJsonJSONObject)
        {
          try
          {
            l2 = localJSONObject1.optLong(String.valueOf(paramInt2), 0L);
            if (l2 >= paramLong) {
              break label249;
            }
            l1 = l2;
            localJSONObject1.put(String.valueOf(paramInt2), paramLong);
            l1 = l2;
            this.jdField_a_of_type_OrgJsonJSONObject.put(str, localJSONObject1);
            i = 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              int i = j;
              long l2 = l1;
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloManager", 2, localException.getMessage());
                i = j;
                l2 = l1;
              }
            }
          }
          if (i != 0)
          {
            ThreadManager.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
            ThreadManager.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 100L);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "saveLocalTS id: " + paramInt2 + ", old TS: " + l2 + ", new TS: " + paramLong + ", type: " + paramInt1);
            }
          }
          return;
          if (paramInt1 == 2)
          {
            str = "dress_version";
          }
          else if (paramInt1 == 1)
          {
            str = "role_version";
            continue;
            if (l2 > paramLong)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                l1 = l2;
                QLog.e("ApolloManager", 2, "saveLocalTS err id: " + paramInt2 + ", old TS: " + l2 + ", new TS: " + paramLong + ", type: " + paramInt1);
              }
            }
            i = 0;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.a(new pqd(this, paramBoolean, paramInt), 5, null, false);
  }
  
  public void a(Context paramContext)
  {
    if (!FileUtils.a(ApolloConstant.j + "/apolloConfig.json"))
    {
      SharedPreUtils.j(paramContext, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "apollo config file not exists");
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (ApolloConfigUtils.jdField_a_of_type_OrgJsonJSONObject != null);
        localObject = FileUtils.a(ApolloConstant.j + "/apolloConfig.json");
      } while (localObject == null);
      localObject = new String((byte[])localObject);
      ApolloConfigUtils.a((String)localObject, paramContext);
    } while ((localObject != null) || (!QLog.isColorLevel()));
    QLog.e("ApolloManager", 2, "apollo config json is null" + (String)localObject);
  }
  
  public void a(SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
    do
    {
      do
      {
        return;
        jdField_b_of_type_JavaUtilArrayList.clear();
      } while ((paramSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramSessionInfo.jdField_a_of_type_JavaLangString) != null));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (1 == b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "doAfterOpenAIO: apollo function is not opened status: " + b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()));
    return;
    ThreadManager.b().post(new pqe(this, paramSessionInfo));
  }
  
  public void a(IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener != null) {}
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a().contains(paramIResDownloadListener))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(paramIResDownloadListener);
      }
      return;
    }
    finally
    {
      paramIResDownloadListener = finally;
      throw paramIResDownloadListener;
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) && (!FileUtils.a(ApolloUtil.a(paramApolloActionData, 7)))) {}
    while ((!a(FileUtils.a(new File(ApolloUtil.a(paramApolloActionData, 7))), paramApolloActionData)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramApolloActionData);
  }
  
  public void a(ApolloBaseInfo paramApolloBaseInfo)
  {
    if ((paramApolloBaseInfo == null) || (TextUtils.isEmpty(paramApolloBaseInfo.uin))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramApolloBaseInfo.uin, paramApolloBaseInfo);
        a(paramApolloBaseInfo);
        if ((!QLog.isColorLevel()) || (!paramApolloBaseInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()))) {
          continue;
        }
        QLog.d("ApolloManager", 2, "save apollo info vip status: " + paramApolloBaseInfo.apolloVipFlag + ", vip lev: " + paramApolloBaseInfo.apolloVipFlag + ", apollo status: " + paramApolloBaseInfo.apolloStatus + ", apollo local TS: " + paramApolloBaseInfo.apolloLocalTS + ", apollo svr TS:" + paramApolloBaseInfo.apolloServerTS + ", apollo upt TS:" + paramApolloBaseInfo.apolloUpdateTime);
        return;
      }
    }
  }
  
  public void a(ApolloPandora paramApolloPandora)
  {
    if ((paramApolloPandora == null) || (TextUtils.isEmpty(paramApolloPandora.uin))) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramApolloPandora.uin, paramApolloPandora);
      a(paramApolloPandora);
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = this.jdField_d_of_type_Int;
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Bundle localBundle;
    ArrayList localArrayList;
    do
    {
      return;
      localBundle = new Bundle();
      localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      a(localArrayList, localHashMap, paramList, localBundle);
      paramList = new DownloadTask(localArrayList, localHashMap, "apollo_key");
      paramList.l = true;
      paramList.f = "apollo_res";
      paramList.o = false;
    } while ((localArrayList.size() == 0) || (a() == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_begin", 0, 0, new String[0]);
    a().a(paramList, this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(List paramList1, Map paramMap, List paramList2, Bundle paramBundle)
  {
    if ((paramList2 == null) || (paramList2.size() <= 0) || (paramList1 == null) || (paramMap == null)) {
      return;
    }
    int i = 0;
    label25:
    ApolloActionData localApolloActionData;
    String str1;
    Object localObject;
    String str2;
    String str3;
    if (i < paramList2.size())
    {
      localApolloActionData = (ApolloActionData)paramList2.get(i);
      str1 = ApolloUtil.a(localApolloActionData, 1);
      localObject = ApolloUtil.a(localApolloActionData, 0);
      str2 = ApolloUtil.a(localApolloActionData, 5);
      str3 = ApolloUtil.a(localApolloActionData, 4);
      if (!FileUtil.a((String)localObject)) {
        break label216;
      }
      localObject = new DownloadTask(str1, new File((String)localObject));
      Bundle localBundle = new Bundle();
      localBundle.putSerializable(str1, localApolloActionData);
      ((DownloadTask)localObject).c = str1;
      ((DownloadTask)localObject).a(localBundle);
      this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener.onDoneFile((DownloadTask)localObject);
    }
    for (;;)
    {
      if (!ApolloUtil.a(localApolloActionData.actionId, localApolloActionData.personNum))
      {
        paramList1.add(str2);
        paramMap.put(str2, new File(str3));
        if (paramBundle != null) {
          paramBundle.putSerializable(str2, localApolloActionData);
        }
      }
      i += 1;
      break label25;
      break;
      label216:
      paramList1.add(str1);
      paramMap.put(str1, new File((String)localObject));
      if (paramBundle != null) {
        paramBundle.putSerializable(str1, localApolloActionData);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "checkApolloPanelJsonCfg begin..." + paramString);
    }
    if ((paramBoolean) || (!FileUtil.a(ApolloUtil.c)))
    {
      a();
      QLog.d("ApolloManager", 1, "checkApolloPanelJsonCfg download json  forceDownload is: " + paramBoolean);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "apollo json is parsing,return.");
      }
      return true;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Object localObject3 = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1;
    int i;
    label197:
    long l;
    try
    {
      localObject1 = FileUtils.b(new File(ApolloUtil.c));
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("parseActionPanelJSon start file size:");
        if (localObject1 == null)
        {
          i = 0;
          QLog.d("ApolloManager", 2, i + " byte");
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label197;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("ApolloManager", 2, "read json fail e =" + localThrowable.toString());
          localObject1 = localObject3;
          continue;
          i = ((String)localObject1).length();
        }
      }
      l = System.currentTimeMillis();
    }
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject4;
        Object localObject5;
        if ((localObject1 != null) && (((JSONObject)localObject1).has("data")))
        {
          localObject3 = ((JSONObject)localObject1).getJSONArray("data");
          if (localObject3 != null)
          {
            i = 0;
            j = ((JSONArray)localObject3).length();
            if (i < j)
            {
              localObject4 = ((JSONArray)localObject3).getJSONObject(i);
              if (localObject4 == null) {
                break label1581;
              }
              localObject5 = new ApolloActionData();
              ((ApolloActionData)localObject5).actionId = ((JSONObject)localObject4).getInt("id");
              ((ApolloActionData)localObject5).sessionType = ((JSONObject)localObject4).getInt("use");
              ((ApolloActionData)localObject5).actionName = ((JSONObject)localObject4).getString("name");
              ((ApolloActionData)localObject5).vipLevel = ((JSONObject)localObject4).getInt("vipLevel");
              ((ApolloActionData)localObject5).feeType = ((JSONObject)localObject4).getInt("feeType");
              if (((JSONObject)localObject4).has("icon")) {
                ((ApolloActionData)localObject5).icon = ((JSONObject)localObject4).getInt("icon");
              }
              ((ApolloActionData)localObject5).personNum = ((JSONObject)localObject4).getInt("type");
              ((ApolloActionData)localObject5).anmiName = ((JSONObject)localObject4).optString("animationName");
              ((ApolloActionData)localObject5).isShow = ((JSONObject)localObject4).optInt("isShow");
              ((ApolloActionData)localObject5).textImg = ((JSONObject)localObject4).optString("textImg");
              if ((((ApolloActionData)localObject5).isShow == 0) && (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(((ApolloActionData)localObject5).actionId)))) {
                ((ApolloActionData)localObject5).isShow = 1;
              }
              if (((JSONObject)localObject4).has("limitFree"))
              {
                ((ApolloActionData)localObject5).limitFree = ((JSONObject)localObject4).getInt("limitFree");
                ((ApolloActionData)localObject5).limitStart = ((JSONObject)localObject4).getLong("begin");
                ((ApolloActionData)localObject5).limitEnd = ((JSONObject)localObject4).getLong("end");
              }
              ((ApolloActionData)localObject5).url = ((JSONObject)localObject4).optString("url");
              ((ApolloActionData)localObject5).version = ((JSONObject)localObject4).getLong("version");
              b((ApolloActionData)localObject5);
              localArrayList1.add(localObject5);
              break label1581;
            }
          }
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject3 == null) {
          return false;
        }
        localObject3 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        if ((localObject1 != null) && (((JSONObject)localObject1).has("packageInfo")))
        {
          localObject4 = ((JSONObject)localObject1).getJSONArray("packageInfo");
          if (localObject4 != null)
          {
            i = 0;
            if (i < ((JSONArray)localObject4).length())
            {
              Object localObject6 = ((JSONArray)localObject4).getJSONObject(i);
              if (localObject6 == null) {
                break label1590;
              }
              localObject5 = new ApolloActionPackage();
              ((ApolloActionPackage)localObject5).packageId = ((JSONObject)localObject6).getInt("packageId");
              ((ApolloActionPackage)localObject5).version = ((JSONObject)localObject6).optInt("version");
              ((ApolloActionPackage)localObject5).type = ((JSONObject)localObject6).optInt("type");
              ((ApolloActionPackage)localObject5).sessionType = ((JSONObject)localObject6).optInt("use");
              ((ApolloActionPackage)localObject5).name = ((JSONObject)localObject6).optString("name");
              ((ApolloActionPackage)localObject5).mIconUnselectedUrl = ((JSONObject)localObject6).optString("apImg");
              ((ApolloActionPackage)localObject5).mIconSelectedUrl = ((JSONObject)localObject6).optString("apcImg");
              Object localObject7 = ((ApolloDaoManager)localObject3).a(((ApolloActionPackage)localObject5).packageId);
              if (localObject7 != null)
              {
                if (((ApolloActionPackage)localObject7).version < ((ApolloActionPackage)localObject5).version) {
                  ((ApolloActionPackage)localObject5).isUpdate = true;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloManager", 2, "ActionPackage pid = " + ((ApolloActionPackage)localObject5).packageId + " actionPackage.isUpdate = " + ((ApolloActionPackage)localObject5).isUpdate);
                }
                localArrayList2.add(localObject5);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloManager", 2, "add actionPackage pid=" + ((ApolloActionPackage)localObject5).packageId);
                }
                localObject6 = ((JSONObject)localObject6).optJSONArray("actionSet");
                if ((localObject6 != null) && (((JSONArray)localObject6).length() > 0))
                {
                  j = 0;
                  if (j >= ((JSONArray)localObject6).length()) {
                    break label1590;
                  }
                  localObject7 = ((JSONArray)localObject6).getJSONObject(j);
                  ApolloActionPackageData localApolloActionPackageData = new ApolloActionPackageData();
                  localApolloActionPackageData.packageId = ((ApolloActionPackage)localObject5).packageId;
                  localApolloActionPackageData.acitonId = ((JSONObject)localObject7).optInt("actionId");
                  localApolloActionPackageData.text = ((JSONObject)localObject7).optString("text");
                  localApolloActionPackageData.textType = ((JSONObject)localObject7).optInt("textType");
                  localArrayList3.add(localApolloActionPackageData);
                  if (!QLog.isColorLevel()) {
                    break label1599;
                  }
                  QLog.d("ApolloManager", 2, "addActionPackageData packageId=" + ((ApolloActionPackage)localObject5).packageId + " actionId=" + localApolloActionPackageData.acitonId);
                  break label1599;
                }
              }
              else
              {
                if (((ApolloActionPackage)localObject5).version != 0L) {
                  continue;
                }
                ((ApolloActionPackage)localObject5).isUpdate = true;
                continue;
              }
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label1312;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloManager", 2, "parseActionPanelJSon failed", localException);
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return true;
        if (((ApolloActionPackage)localObject5).type == 2) {
          break label1590;
        }
        localArrayList2.remove(localObject5);
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
      }
      ((ApolloDaoManager)localObject3).a();
      ((ApolloDaoManager)localObject3).a(localArrayList1);
      ((ApolloDaoManager)localObject3).b();
      ((ApolloDaoManager)localObject3).c(localArrayList2);
      ((ApolloDaoManager)localObject3).c();
      ((ApolloDaoManager)localObject3).d(localArrayList3);
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 128, "refreshAction");
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(true));
      label1312:
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true).commit();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        if (!((SharedPreferences)localObject3).getBoolean("6.5.5" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false)) {
          ((SharedPreferences)localObject3).edit().putBoolean("6.5.5" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true).commit();
        }
        if (localObject2 != null) {
          ((SharedPreferences)localObject3).edit().putInt("apollo_json_version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (int)(((JSONObject)localObject2).optLong("timeStamp") / 1000L)).commit();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      QLog.d("ApolloManager", 1, "parseActionPanelJSon end cost: " + (System.currentTimeMillis() - l) + "ms");
      continue;
      label1581:
      i += 1;
      continue;
      label1590:
      i += 1;
      continue;
      label1599:
      j += 1;
    }
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt)
  {
    return a(paramApolloActionData, paramInt, null);
  }
  
  public boolean a(ApolloActionData paramApolloActionData, int paramInt, IResDownloadListener paramIResDownloadListener)
  {
    if (paramApolloActionData == null) {}
    label96:
    Object localObject1;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (!Utils.b()) {
                break;
              }
              if (Utils.b() >= 1048576L) {
                break label96;
              }
            } while (!QLog.isColorLevel());
            QLog.e("ApolloManager", 2, "2sdcardcheck,sdcard full .return. aid=" + paramApolloActionData.actionId);
            return false;
          } while (!QLog.isColorLevel());
          QLog.e("ApolloManager", 2, "2sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionData.actionId);
          return false;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "start download action res aid=" + paramApolloActionData.actionId);
          }
          if ((paramInt & 0x1) != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "start download action panelpic aid=" + paramApolloActionData.actionId);
          }
          localObject1 = ApolloUtil.a(paramApolloActionData, 1);
          localObject2 = ApolloUtil.a(paramApolloActionData, 0);
          if (FileUtils.a((String)localObject2)) {
            break;
          }
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).l = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        } while (i != 0);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "ret:" + i);
        }
        if ((paramInt & 0x2) != 2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "start download action gif aid=" + paramApolloActionData.actionId);
        }
        localObject1 = ApolloUtil.a(paramApolloActionData, 3);
        localObject2 = ApolloUtil.a(paramApolloActionData, 2);
        if (FileUtils.a((String)localObject2)) {
          break;
        }
        localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
        ((DownloadTask)localObject1).l = true;
        i = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } while (i != 0);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "ret:" + i);
      }
      if ((paramInt & 0x4) != 4) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download action zip aid=" + paramApolloActionData.actionId);
      }
      Object localObject2 = ApolloUtil.a(paramApolloActionData, 5);
      localObject1 = ApolloUtil.a(paramApolloActionData, 4);
      if (ApolloUtil.a(paramApolloActionData.actionId, paramApolloActionData.personNum)) {
        break;
      }
      localObject2 = new DownloadTask((String)localObject2, new File((String)localObject1));
      ((DownloadTask)localObject2).l = true;
      paramInt = DownloaderFactory.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (paramInt != 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "ret:" + paramInt);
    }
    try
    {
      FileUtils.a((String)localObject1, ApolloUtil.a(paramApolloActionData, 6), false);
      FileUtils.d((String)localObject1);
      a(paramApolloActionData);
      if (paramIResDownloadListener != null) {
        paramIResDownloadListener.b(paramApolloActionData);
      }
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloManager", 2, "uncompresszip error" + localException.toString());
        }
      }
    }
  }
  
  public boolean a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {}
    label96:
    int i;
    do
    {
      do
      {
        do
        {
          return false;
          if (!Utils.b()) {
            break;
          }
          if (Utils.b() >= 1048576L) {
            break label96;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ApolloManager", 2, "2sdcardcheck,sdcard full .return. aid=" + paramApolloActionPackage.packageId);
        return false;
      } while (!QLog.isColorLevel());
      QLog.e("ApolloManager", 2, "2sdcardcheck,has sdcard FALSE .return. aid=" + paramApolloActionPackage.packageId);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "start download actionPackage tab pid=" + paramApolloActionPackage.packageId);
      }
      paramApolloActionPackage = new DownloadTask(ApolloUtil.b(paramApolloActionPackage), new File(ApolloUtil.a(paramApolloActionPackage)));
      paramApolloActionPackage.l = true;
      i = DownloaderFactory.a(paramApolloActionPackage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (i != 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "ret:" + i);
    }
    return true;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.e("ApolloManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloVipFlag == 1;
    }
    return false;
  }
  
  public boolean a(String paramString, ApolloActionData paramApolloActionData)
  {
    int j = 0;
    if ((paramString == null) || (paramApolloActionData == null)) {
      bool2 = false;
    }
    do
    {
      for (;;)
      {
        return bool2;
        for (;;)
        {
          try
          {
            paramString = new JSONObject(paramString);
            bool1 = paramString.has("audio");
            if (!bool1) {
              continue;
            }
          }
          catch (Exception paramString)
          {
            Object localObject;
            int i;
            boolean bool3;
            boolean bool1 = false;
            continue;
            bool2 = false;
            continue;
            i += 1;
            continue;
            i += 1;
            continue;
          }
          try
          {
            paramApolloActionData.hasSound = paramString.optJSONObject("audio").optBoolean("hasSound");
            bool2 = true;
            bool1 = bool2;
          }
          catch (Exception paramString)
          {
            bool1 = true;
            continue;
          }
          try
          {
            if (paramString.has("vibrate")) {
              bool1 = true;
            }
            bool2 = bool1;
            localObject = paramString.optJSONArray("vibrate");
            if (localObject != null)
            {
              bool2 = bool1;
              StringBuilder localStringBuilder = new StringBuilder(50);
              i = 0;
              bool2 = bool1;
              if (i < ((JSONArray)localObject).length())
              {
                bool2 = bool1;
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
                if (localJSONObject == null) {
                  continue;
                }
                bool2 = bool1;
                int k = localJSONObject.optInt("time");
                bool2 = bool1;
                int m = localJSONObject.optInt("duration");
                bool2 = bool1;
                localStringBuilder.append(k).append(",").append(m);
                bool2 = bool1;
                if (i >= ((JSONArray)localObject).length() - 1) {
                  continue;
                }
                bool2 = bool1;
                localStringBuilder.append(",");
                continue;
              }
              bool2 = bool1;
              paramApolloActionData.vibrate = localStringBuilder.toString();
            }
            bool2 = bool1;
            bool3 = paramString.has("bubbleText");
            if (!bool3) {
              continue;
            }
            bool1 = true;
          }
          catch (Exception paramString)
          {
            bool1 = bool2;
            continue;
            continue;
          }
          try
          {
            paramString = paramString.optJSONArray("bubbleText");
            if (paramString != null)
            {
              localObject = new StringBuilder(50);
              i = j;
              if (i < paramString.length())
              {
                ((StringBuilder)localObject).append(paramString.getString(i));
                if (i >= paramString.length() - 1) {
                  continue;
                }
                ((StringBuilder)localObject).append("@$");
                continue;
              }
              paramApolloActionData.bubbleText = ((StringBuilder)localObject).toString();
            }
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            if ((!paramApolloActionData.hasSound) && (TextUtils.isEmpty(paramApolloActionData.vibrate)))
            {
              bool2 = bool1;
              if (TextUtils.isEmpty(paramApolloActionData.bubbleText)) {
                break;
              }
            }
            QLog.d("ApolloManager", 2, "action id " + paramApolloActionData.actionId + ", name: " + paramApolloActionData.actionName + ", hasSound: " + paramApolloActionData.hasSound + ", vibrate=" + paramApolloActionData.vibrate + ", bubbleText =" + paramApolloActionData.bubbleText);
            return bool1;
          }
          catch (Exception paramString)
          {
            bool2 = bool1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloManager", 2, "parse action config.json error", paramString);
    return bool1;
  }
  
  public int b(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.apolloStatus;
    }
    return 0;
  }
  
  public ApolloBaseInfo b(String paramString)
  {
    ??? = null;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return (ApolloBaseInfo)???;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          paramString = (ApolloBaseInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          return paramString;
        }
      }
      if ((0 == 0) && (!this.jdField_g_of_type_Boolean))
      {
        ??? = (ApolloBaseInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ApolloBaseInfo.class, paramString);
        if (??? != null) {
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, ???);
            ??? = ???;
            if (QLog.isColorLevel())
            {
              ??? = ???;
              if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
              {
                QLog.d("ApolloManager", 2, "getApolloBaseInfo from db uin: " + paramString + ", apollo status: " + ((ApolloBaseInfo)???).apolloStatus);
                return (ApolloBaseInfo)???;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          ??? = new ApolloBaseInfo();
          ((ApolloBaseInfo)???).uin = paramString;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, ???);
          if ((QLog.isColorLevel()) && (??? == null)) {
            QLog.e("ApolloManager", 2, "getApolloBaseInfo apolloBaseInfo is null uin: " + paramString);
          }
          return (ApolloBaseInfo)???;
        }
      }
      ??? = (ApolloBaseInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(this.jdField_c_of_type_Int);
  }
  
  public void b(IResDownloadListener paramIResDownloadListener)
  {
    if ((paramIResDownloadListener != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.b(paramIResDownloadListener);
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData != null)
    {
      Object localObject = new File(ApolloUtil.a(paramApolloActionData, 7));
      if (((File)localObject).exists()) {
        try
        {
          localObject = FileUtils.a((File)localObject);
          if (new JSONObject((String)localObject).optLong("version") < paramApolloActionData.version)
          {
            boolean bool = FileUtil.c(ApolloUtil.a(paramApolloActionData, 6));
            URLDrawable.removeMemoryCacheByUrl(new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName).toString());
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "del old action res id:" + paramApolloActionData.actionId + ", ret: " + bool);
            }
          }
          else
          {
            a((String)localObject, paramApolloActionData);
            return;
          }
        }
        catch (Exception paramApolloActionData)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloManager", 2, "checkActionVersion failed " + paramApolloActionData.toString());
          }
        }
      }
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ThreadManager.b().post(new ppv(this, paramList));
  }
  
  public boolean b(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    String str = "";
    if ((paramInt & 0x1) == 1) {
      str = ApolloUtil.a(paramApolloActionData, 0);
    }
    for (;;)
    {
      return FileUtil.a(str);
      if ((paramInt & 0x2) == 2) {
        str = ApolloUtil.a(paramApolloActionData, 2);
      }
    }
  }
  
  public boolean b(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return false;
    }
    return FileUtil.a(ApolloUtil.a(paramApolloActionPackage));
  }
  
  public void c(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (paramList.size() == 1)
      {
        a((ApolloBaseInfo)paramList.get(0));
        return;
      }
      Iterator localIterator = paramList.iterator();
      ApolloBaseInfo localApolloBaseInfo;
      while (localIterator.hasNext())
      {
        localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
        if (!TextUtils.isEmpty(localApolloBaseInfo.uin)) {
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localApolloBaseInfo.uin, localApolloBaseInfo);
          }
        }
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)???).a();
      try
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
          if (!TextUtils.isEmpty(localApolloBaseInfo.uin)) {
            a(localApolloBaseInfo);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)???).b();
        while ((QLog.isColorLevel()) && (paramList.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f())))
        {
          paramList = (ApolloBaseInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
          QLog.d("ApolloManager", 2, "save apollo info vip flag: " + paramList.apolloVipFlag + ", level: " + paramList.apolloVipFlag + ", apollo status: " + paramList.apolloStatus + ", apollo local TS: " + paramList.apolloLocalTS + ", apollo svr TS:" + paramList.apolloServerTS + ", apollo upt TS:" + paramList.apolloUpdateTime);
          return;
          ((EntityTransaction)???).c();
          ((EntityTransaction)???).b();
        }
      }
      finally
      {
        ((EntityTransaction)???).b();
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    ApolloResDownloader.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_c_of_type_Boolean = false;
    com.tencent.mobileqq.apollo.view.ApolloPanel.jdField_a_of_type_Int = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\ApolloManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */