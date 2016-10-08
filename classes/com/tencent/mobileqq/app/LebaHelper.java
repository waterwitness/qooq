package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import pzi;
import pzj;
import pzk;

public class LebaHelper
{
  public static final String a = "qzone_feedlist";
  private static final int jdField_b_of_type_Int = 3;
  public static final String b = "nearby_friends";
  public static final String c = "nearby_troops";
  public static final String d = "com.tx.xingqubuluo.android";
  public static final String e = "hot_chat";
  private static final String f = "LebaHelper";
  private static final String g = "mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s";
  private static final String h = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqq&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
  private static final String i = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqq&cmp=com.tencent.mobileqq.troop.activity.NearbyTroopsActivity";
  private static final String j = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=aHR0cDovL2J1bHVvLnFxLmNvbS9tb2JpbGUvaW5kZXguaHRtbD9fd3Y9MTAyNyZfYmlkPTEyOCNmcm9tPWRvbmd0YWkmdGFyZ2V0PWhvdA==";
  int jdField_a_of_type_Int;
  public QQAppInterface a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  List jdField_a_of_type_JavaUtilList;
  public Set a;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  List jdField_b_of_type_JavaUtilList;
  public boolean b;
  public List c;
  public List d;
  
  public LebaHelper(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfByte = new byte[0];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_MqqObserverServerConfigObserver = new pzi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(10);
    this.c = new ArrayList(2);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.d = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int k = localOptions.outWidth;
    int m = localOptions.outHeight;
    if ((k > 300) && (m > 300)) {
      localOptions.inSampleSize = 3;
    }
    localOptions.inJustDecodeBounds = false;
    return BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.a(paramRunnable, 5, null, true);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "Download success icon key = " + paramString);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Map localMap;
    while (localIterator.hasNext())
    {
      localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          if (!localMap.containsKey("TIME")) {
            break label175;
          }
        }
      }
    }
    label175:
    for (int k = ((Integer)localMap.get("TIME")).intValue();; k = 0)
    {
      if (k >= 3) {
        localIterator.remove();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "Download failed icon key = " + paramString + ",time=" + k);
        }
        return;
        k += 1;
        localMap.put("TIME", Integer.valueOf(k));
        localMap.put("LOADING", Boolean.valueOf(false));
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("mobileQQ", 0);
    } while (!localSharedPreferences.getBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true));
    if (QLog.isDevelopLevel()) {
      QLog.d("LebaHelper", 4, "clearLocalDBPlugin.local plugin.");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      List localList = ResourcePluginInfo.getAll((EntityManager)localObject1, 64, false);
      if (localList != null)
      {
        int k = 0;
        while (k < localList.size())
        {
          ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localList.get(k);
          if ((localResourcePluginInfo != null) && (localResourcePluginInfo.cDataType == 1) && (localResourcePluginInfo.iPluginType == 64)) {
            ResourcePluginInfo.remove((EntityManager)localObject1, localResourcePluginInfo.strPkgName);
          }
          k += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((EntityManager)localObject1).a();
      }
    }
    finally
    {
      ((EntityManager)localObject1).a();
    }
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  private void f()
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "qzone_feedlist";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368179);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "tab_qzone" });
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 860;
    this.jdField_b_of_type_JavaUtilList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "nearby_friends";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368168);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_neighbour";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369368);
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqq&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 270;
    this.jdField_b_of_type_JavaUtilList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.xingqubuluo.android";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368188);
    localResourcePluginInfo.strResURL = "qb_leba_xingqu_buluo";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368188);
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 826L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=aHR0cDovL2J1bHVvLnFxLmNvbS9tb2JpbGUvaW5kZXguaHRtbD9fd3Y9MTAyNyZfYmlkPTEyOCNmcm9tPWRvbmd0YWkmdGFyZ2V0PWhvdA==";
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 0;
    this.jdField_b_of_type_JavaUtilList.add(localResourcePluginInfo);
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 69	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   14: ifne +19 -> 33
    //   17: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 25
    //   25: iconst_2
    //   26: ldc_w 382
    //   29: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload_0
    //   34: getfield 78	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 78	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   44: invokeinterface 385 1 0
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: invokespecial 387	com/tencent/mobileqq/app/LebaHelper:f	()V
    //   55: aload_0
    //   56: invokespecial 389	com/tencent/mobileqq/app/LebaHelper:h	()V
    //   59: aload_0
    //   60: getfield 56	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ArrayOfByte	[B
    //   63: astore_3
    //   64: aload_3
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 76	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   70: invokeinterface 385 1 0
    //   75: aload_0
    //   76: getfield 76	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: aload_0
    //   80: getfield 78	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   83: invokeinterface 393 2 0
    //   88: pop
    //   89: aload_0
    //   90: getfield 76	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   93: invokeinterface 278 1 0
    //   98: ifle +110 -> 208
    //   101: iconst_0
    //   102: istore 4
    //   104: iload 4
    //   106: aload_0
    //   107: getfield 76	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   110: invokeinterface 278 1 0
    //   115: if_icmpge +93 -> 208
    //   118: aload_0
    //   119: getfield 76	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   122: iload 4
    //   124: invokeinterface 281 2 0
    //   129: checkcast 269	com/tencent/mobileqq/data/ResourcePluginInfo
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +18 -> 152
    //   137: aload_1
    //   138: getfield 351	com/tencent/mobileqq/data/ResourcePluginInfo:uiResId	J
    //   141: lstore 5
    //   143: lload 5
    //   145: ldc2_w 394
    //   148: lcmp
    //   149: ifeq +25 -> 174
    //   152: iload 4
    //   154: iconst_1
    //   155: iadd
    //   156: istore 4
    //   158: goto -54 -> 104
    //   161: astore_2
    //   162: aload_1
    //   163: monitorexit
    //   164: aload_2
    //   165: athrow
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   171: goto -116 -> 55
    //   174: aload_1
    //   175: getfield 323	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   178: astore_2
    //   179: aload_2
    //   180: astore_1
    //   181: aload_2
    //   182: ifnonnull +7 -> 189
    //   185: ldc_w 397
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 69	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   193: invokevirtual 400	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   196: ldc_w 402
    //   199: aload_1
    //   200: invokestatic 407	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   203: pop
    //   204: goto -52 -> 152
    //   207: astore_1
    //   208: aload_3
    //   209: monitorexit
    //   210: aload_0
    //   211: iconst_1
    //   212: putfield 409	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_Boolean	Z
    //   215: return
    //   216: astore_1
    //   217: aload_3
    //   218: monitorexit
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	LebaHelper
    //   37	126	1	localObject1	Object
    //   166	9	1	localException	Exception
    //   180	20	1	localObject2	Object
    //   207	1	1	localThrowable	Throwable
    //   216	4	1	localObject3	Object
    //   161	4	2	localObject4	Object
    //   178	4	2	str	String
    //   102	55	4	k	int
    //   141	3	5	l	long
    // Exception table:
    //   from	to	target	type
    //   40	51	161	finally
    //   162	164	161	finally
    //   51	55	166	java/lang/Exception
    //   89	101	207	java/lang/Throwable
    //   104	133	207	java/lang/Throwable
    //   137	143	207	java/lang/Throwable
    //   174	179	207	java/lang/Throwable
    //   189	204	207	java/lang/Throwable
    //   66	89	216	finally
    //   89	101	216	finally
    //   104	133	216	finally
    //   137	143	216	finally
    //   174	179	216	finally
    //   189	204	216	finally
    //   208	210	216	finally
    //   217	219	216	finally
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = ResourcePluginInfo.getAll((EntityManager)localObject2, 64, false);
    ((EntityManager)localObject2).a();
    int k;
    ResourcePluginInfo localResourcePluginInfo1;
    int m;
    if ((localList != null) && (localList.size() > 0))
    {
      k = 0;
      if (k < localList.size())
      {
        localResourcePluginInfo1 = (ResourcePluginInfo)localList.get(k);
        if ((localResourcePluginInfo1 == null) || (localResourcePluginInfo1.strPkgName == null)) {
          break label258;
        }
        if ((localResourcePluginInfo1.strGotoUrl != null) && (!TextUtils.isEmpty(localResourcePluginInfo1.strGotoUrl))) {
          localResourcePluginInfo1.strGotoUrl = localResourcePluginInfo1.strGotoUrl.replace("com.qqreader.QRBridgeActivity", "cooperation.qqreader.QRBridgeActivity");
        }
        localObject2 = this.jdField_b_of_type_JavaUtilList;
        m = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (m >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label252;
        }
        ResourcePluginInfo localResourcePluginInfo2 = (ResourcePluginInfo)this.jdField_b_of_type_JavaUtilList.get(m);
        if ((localResourcePluginInfo2 == null) || (localResourcePluginInfo2.strPkgName == null) || (localResourcePluginInfo2.strPkgName.compareTo(localResourcePluginInfo1.strPkgName) != 0)) {
          break label267;
        }
        m = 1;
        if (m == 0)
        {
          this.jdField_b_of_type_JavaUtilList.add(localResourcePluginInfo1);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "addItem=" + localResourcePluginInfo1);
          }
        }
      }
      finally {}
      return;
      label252:
      m = 0;
      continue;
      label258:
      k += 1;
      break;
      label267:
      m += 1;
    }
  }
  
  private void i()
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
  
  public ResourcePluginInfo a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = ResourcePluginInfo.getAll((EntityManager)localObject, 64, false);
    ((EntityManager)localObject).a();
    if ((localList != null) && (localList.size() > 0))
    {
      int k = 0;
      while (k < localList.size())
      {
        localObject = (ResourcePluginInfo)localList.get(k);
        if (((ResourcePluginInfo)localObject).uiResId == paramInt) {
          return (ResourcePluginInfo)localObject;
        }
        k += 1;
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    a(new pzj(this));
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "send to get leba config");
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "sendLebaConfig, hasCallLoadPluginOnce=" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("LebaHelper", 2, "sendLebaConfig, mResourcePluginInfoList.size()=" + this.jdField_a_of_type_JavaUtilList.size());
          break label323;
          if (k < this.jdField_a_of_type_JavaUtilList.size())
          {
            ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)this.jdField_a_of_type_JavaUtilList.get(k);
            if (localResourcePluginInfo.cDataType != 0) {
              break label329;
            }
            GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
            localGetResourceReqInfoV2.cState = 0;
            localGetResourceReqInfoV2.sLanType = localResourcePluginInfo.sLanType;
            localGetResourceReqInfoV2.sResSubType = 0;
            localGetResourceReqInfoV2.strPkgName = localResourcePluginInfo.strPkgName;
            localGetResourceReqInfoV2.uiCurVer = localResourcePluginInfo.uiCurVer;
            localGetResourceReqInfoV2.uiResId = localResourcePluginInfo.uiResId;
            localArrayList.add(localGetResourceReqInfoV2);
            if (!QLog.isColorLevel()) {
              break label329;
            }
            QLog.d("LebaHelper", 2, "sendLebaConfig, add local info=" + localResourcePluginInfo);
            break label329;
          }
          HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "on Get Leba start send: " + localArrayList.size());
          }
          paramPluginConfigProxy.a(64, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
          return;
        }
      }
      label323:
      int k = 0;
      continue;
      label329:
      k += 1;
    }
  }
  
  public void a(DownloadIconsListener paramDownloadIconsListener)
  {
    synchronized (this.d)
    {
      if (!this.d.contains(paramDownloadIconsListener)) {
        this.d.add(paramDownloadIconsListener);
      }
      return;
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramResourcePluginListener)) {
        this.c.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(String paramString, URL paramURL, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "Download icon for " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new pzk(this, paramURL, paramFile, paramString));
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, "Download " + paramList.size() + " icons");
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str = (String)localMap.get("KEY");
        paramList = (URL)localMap.get("URL");
        Object localObject = MsfSdkUtils.insertMtype("Dynamic", paramList.toString());
        try
        {
          localObject = new URL((String)localObject);
          paramList = (List)localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.d("LebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
          }
        }
        localObject = (File)localMap.get("FILE");
        if (this.jdField_a_of_type_JavaUtilSet.add(str))
        {
          a(str, paramList, (File)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "Download icon key = " + str);
          }
          localMap.put("LOADING", Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      PluginConfigProxy localPluginConfigProxy = new PluginConfigProxy();
      a(localPluginConfigProxy);
      localPluginConfigProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void b(DownloadIconsListener paramDownloadIconsListener)
  {
    synchronized (this.d)
    {
      this.d.remove(paramDownloadIconsListener);
      return;
    }
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.c)
    {
      this.c.remove(paramResourcePluginListener);
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str;
        Object localObject1;
        if (localMap != null)
        {
          str = (String)localMap.get("KEY");
          localObject1 = (URL)localMap.get("URL");
          localObject2 = MsfSdkUtils.insertMtype("Dynamic", ((URL)localObject1).toString());
        }
        try
        {
          localObject2 = new URL((String)localObject2);
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            Object localObject3;
            QLog.d("LebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
            continue;
            boolean bool = false;
          }
        }
        Object localObject2 = (File)localMap.get("FILE");
        localObject3 = localMap.get("LOADING");
        if ((localObject3 == null) || (!(localObject3 instanceof Boolean))) {
          break label272;
        }
        bool = ((Boolean)localObject3).booleanValue();
        if ((!TextUtils.isEmpty(str)) && (!bool) && (this.jdField_a_of_type_JavaUtilSet.add(str)))
        {
          a(str, (URL)localObject1, (File)localObject2);
          localMap.put("LOADING", Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "reDownload icon key = " + str);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\LebaHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */