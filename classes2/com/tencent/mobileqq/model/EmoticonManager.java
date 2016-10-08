package com.tencent.mobileqq.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.SupportSize;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PromotionEmoticonPkg;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SupportSize;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tep;
import teq;
import tes;
import tet;
import teu;
import tev;
import tew;
import tey;
import tez;
import tfa;
import tfb;
import tfc;
import tfd;
import tfe;
import tff;
import tfg;

public class EmoticonManager
  implements Manager
{
  public static final String a = "clear_keyword_before_59";
  public static HashMap a;
  public static final int b = 2;
  public static final String b = "EmoticonManager";
  public static final int c = 2;
  public static final String c = "recommendExposeCountSp_";
  public static int d;
  public static int e;
  double jdField_a_of_type_Double = 0.0D;
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public LruCache a;
  public SparseArrayCompat a;
  public QQAppInterface a;
  private EmotionJsonDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener = new tez(this);
  public EntityManager a;
  public EmosmPb.SubCmd0x5RspBQRecommend a;
  List jdField_a_of_type_JavaUtilList = new Vector();
  Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  public boolean[] a;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public LruCache b;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  Map jdField_b_of_type_JavaUtilMap = new HashMap();
  LruCache c = new LruCache(1000);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 6;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public EmoticonManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(400);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    jdField_a_of_type_JavaUtilHashMap.put(Double.valueOf(4.7D), Integer.valueOf(300));
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendExposeCountSp_" + paramQQAppInterface.a(), 0);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramQQAppInterface = ThreadManager.a("emoticonmanager_file", 19);
    paramQQAppInterface.start();
    paramQQAppInterface = paramQQAppInterface.getLooper();
    if (paramQQAppInterface != null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(paramQQAppInterface);
    }
    ThreadManager.a(new tep(this), null, true);
  }
  
  private double a()
  {
    if (this.jdField_a_of_type_Double != 0.0D) {
      return this.jdField_a_of_type_Double;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if ((localDisplayMetrics.xdpi != 0.0F) && (localDisplayMetrics.ydpi != 0.0F)) {}
    for (double d1 = Math.round(Math.sqrt(Math.pow(localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi, 2.0D) + Math.pow(localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi, 2.0D)) * 100.0D) / 100.0D;; d1 = 0.0D)
    {
      if ((d1 >= 4.6D) && (localDisplayMetrics.widthPixels >= 720) && (localDisplayMetrics.heightPixels >= 1280)) {}
      for (this.jdField_a_of_type_Double = 4.7D;; this.jdField_a_of_type_Double = -1.0D)
      {
        QLog.d("screenInch", 1, "screen inches-> screenInch: " + d1 + ", formatInch: " + this.jdField_a_of_type_Double + ", widthPixels: " + localDisplayMetrics.widthPixels + " ,heightPixels: " + localDisplayMetrics.heightPixels + " , xdpi: " + localDisplayMetrics.xdpi + " , ydpi: " + localDisplayMetrics.ydpi + ", densityDpi: " + localDisplayMetrics.densityDpi + " , density: " + localDisplayMetrics.density);
        return this.jdField_a_of_type_Double;
      }
    }
  }
  
  private EmoticonPackage a(String paramString, boolean paramBoolean)
  {
    EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    EmoticonPackage localEmoticonPackage1 = localEmoticonPackage2;
    if (localEmoticonPackage2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "[emo miss] func findEmoticonPackageById, pkgCache.size:" + this.jdField_a_of_type_JavaUtilMap.size());
      }
      localEmoticonPackage1 = localEmoticonPackage2;
      if (paramBoolean)
      {
        localEmoticonPackage2 = (EmoticonPackage)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, paramString);
        if (localEmoticonPackage2 == null) {
          break label152;
        }
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localEmoticonPackage2);
        localEmoticonPackage1 = localEmoticonPackage2;
        if (QLog.isColorLevel())
        {
          QLog.d("EmoticonManager", 2, "[emo miss] func findEmoticonPackageById, find db pkgCache.size:" + this.jdField_a_of_type_JavaUtilMap.size());
          localEmoticonPackage1 = localEmoticonPackage2;
        }
      }
    }
    label152:
    do
    {
      return localEmoticonPackage1;
      localEmoticonPackage1 = localEmoticonPackage2;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, "can not find package:" + paramString);
    return localEmoticonPackage2;
  }
  
  private void a(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    ThreadManager.a(paramRunnable, paramInt, null, true);
  }
  
  private void b(EmoticonPackage paramEmoticonPackage) {}
  
  private void b(boolean paramBoolean)
  {
    a(new tfg(this, paramBoolean), 8);
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ArrayOfBoolean == null)
    {
      localObject1 = ClubContentJsonTask.d.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ArrayOfBoolean = new boolean[8];
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfBoolean.length)
        {
          this.jdField_a_of_type_ArrayOfBoolean[i] = false;
          i += 1;
        }
        this.jdField_a_of_type_ArrayOfBoolean[1] = true;
      }
    }
    JSONObject localJSONObject;
    Object localObject2;
    boolean bool1;
    for (;;)
    {
      try
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = ((JSONObject)localObject1).getJSONObject("data").getJSONArray("vipEmojiKeywordTipsABTest");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = localJSONObject.getString("netEnv");
          if ("4G".equals(localObject2))
          {
            localObject2 = this.jdField_a_of_type_ArrayOfBoolean;
            if (ClubContentJsonTask.a(localJSONObject, str, true)) {
              break label347;
            }
            bool1 = true;
            break label332;
          }
          if (!"3G".equals(localObject2)) {
            break;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfBoolean;
          if (ClubContentJsonTask.a(localJSONObject, str, true)) {
            break label282;
          }
          bool1 = true;
          localObject2[3] = bool1;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, localJSONException.getMessage());
        }
      }
      i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      bool1 = bool2;
      if (i >= 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfBoolean != null)
        {
          bool1 = bool2;
          if (i < this.jdField_a_of_type_ArrayOfBoolean.length)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ArrayOfBoolean[i] != 0) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
      label282:
      bool1 = false;
    }
    if ("2G".equals(localObject2))
    {
      localObject2 = this.jdField_a_of_type_ArrayOfBoolean;
      if (!ClubContentJsonTask.a(localJSONObject, localJSONException, true)) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject2[2] = bool1;
        break;
      }
    }
    for (;;)
    {
      label332:
      localObject2[4] = bool1;
      i += 1;
      break;
      label347:
      bool1 = false;
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend == null)
    {
      QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective recommendRsp is null");
      h();
    }
    label64:
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.int32_red_point_flag.get() == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label64;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective is not white num");
        return false;
      }
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getLong("recommendRedpointStartTime", 0L);
      long l2 = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.int32_light_out_interval.get() * 1000;
      if (System.currentTimeMillis() - l1 <= l2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective redpoint is overtime");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective show redpoint");
    }
    return true;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "initTabs begins");
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("select ").append("EmoticonPackage").append(".* from ").append("EmoticonPackage").append(" inner join ").append("EmoticonTab").append(" on (").append("EmoticonTab").append(".epId=").append("EmoticonPackage").append(".epId) where ").append("EmoticonPackage").append(".jobType in (").append(0).append(",").append(4).append(",").append(3).append(")").append(" order by ").append("EmoticonTab").append("._id;");
    localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, ((StringBuffer)localObject).toString(), null);
    if ((localObject == null) || (((ArrayList)localObject).size() < 1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
      if (localEmoticonPackage != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(localEmoticonPackage.epId, localEmoticonPackage);
        this.jdField_a_of_type_JavaUtilList.add(localEmoticonPackage.epId);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "pkg->id:" + localEmoticonPackage.epId + ",type:" + localEmoticonPackage.jobType + ",pkgCache.size:" + this.jdField_a_of_type_JavaUtilMap.size());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "initTabs ends, tabCache.size:" + this.jdField_a_of_type_JavaUtilList.size() + ",time:" + (System.currentTimeMillis() - l));
    }
    b(false);
    b();
    ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148)).a();
    h();
  }
  
  private void e(String paramString)
  {
    a(new tes(this, paramString), 5);
  }
  
  private void f()
  {
    for (;;)
    {
      Object localObject3;
      synchronized (this.c)
      {
        this.c.evictAll();
        Object localObject1 = new ArrayList();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
        if (localObject3 != null)
        {
          i = ((List)localObject3).size() - 1;
          if (i >= 0)
          {
            localObject4 = (RecentEmotionData)((List)localObject3).get(i);
            if ((localObject4 == null) || (((RecentEmotionData)localObject4).type != 5)) {
              break label558;
            }
            localObject4 = a(String.valueOf(((RecentEmotionData)localObject4).emoIndex), ((RecentEmotionData)localObject4).emoPath);
            if (localObject4 == null) {
              break label558;
            }
            ((ArrayList)localObject1).add(localObject4);
            break label558;
          }
        }
        int j = ((ArrayList)localObject1).size();
        i = 0;
        if (i < j)
        {
          b((Emoticon)((ArrayList)localObject1).get(i));
          i += 1;
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        if (!((SharedPreferences)localObject1).getBoolean("clear_keyword_before_59", false))
        {
          ((SharedPreferences)localObject1).edit().putBoolean("clear_keyword_before_59", true).commit();
          b();
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "refreshEmoticonKeywordsCache, emoticon Keywords recent and favorite Cache size=" + this.c.size());
          }
          return;
        }
        localObject1 = EmoticonKeyword.class.getSimpleName();
        localObject1 = "select * from " + (String)localObject1 + " where valid=1 order by " + (String)localObject1 + "._index;";
        localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonKeyword.class, (String)localObject1, null);
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
          break label511;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label511;
        }
        localObject3 = (EmoticonKeyword)((Iterator)localObject1).next();
        if ((TextUtils.isEmpty(((EmoticonKeyword)localObject3).encryptKey)) || (TextUtils.isEmpty(((EmoticonKeyword)localObject3).keyword))) {
          continue;
        }
        localObject4 = (List)this.c.get(((EmoticonKeyword)localObject3).keyword);
        if (localObject4 != null)
        {
          Iterator localIterator = ((List)localObject4).iterator();
          if (!localIterator.hasNext()) {
            break label552;
          }
          EmoticonKeyword localEmoticonKeyword = (EmoticonKeyword)localIterator.next();
          if ((!localEmoticonKeyword.eId.equals(((EmoticonKeyword)localObject3).eId)) || (!localEmoticonKeyword.epId.equals(((EmoticonKeyword)localObject3).epId))) {
            continue;
          }
          i = 1;
          if ((((List)localObject4).size() >= 2) || (i != 0)) {
            continue;
          }
          ((List)localObject4).add(localObject3);
        }
      }
      Object localObject4 = new ArrayList();
      ((List)localObject4).add(localObject3);
      this.c.put(((EmoticonKeyword)localObject3).keyword, localObject4);
      continue;
      label511:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonManager", 2, "refreshEmoticonKeywordsCache, emoticon Keywords Cache size=" + this.c.size());
      return;
      label552:
      int i = 0;
      continue;
      label558:
      i -= 1;
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 657	com/tencent/mobileqq/model/EmoticonManager:a	()Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: invokeinterface 541 1 0
    //   13: istore 11
    //   15: iconst_0
    //   16: istore 9
    //   18: iload 9
    //   20: iload 11
    //   22: if_icmpge +372 -> 394
    //   25: aload_2
    //   26: iload 9
    //   28: invokeinterface 572 2 0
    //   33: checkcast 303	com/tencent/mobileqq/data/EmoticonPackage
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +287 -> 325
    //   41: aload_3
    //   42: getfield 660	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   45: iconst_2
    //   46: if_icmpne +279 -> 325
    //   49: aload_0
    //   50: aload_3
    //   51: getfield 526	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   54: invokevirtual 663	com/tencent/mobileqq/model/EmoticonManager:a	(Ljava/lang/String;)Ljava/util/List;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +264 -> 325
    //   64: aload_0
    //   65: getfield 114	com/tencent/mobileqq/model/EmoticonManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   68: invokevirtual 666	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 670	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   76: aload 4
    //   78: invokeinterface 647 1 0
    //   83: astore 4
    //   85: aload 4
    //   87: invokeinterface 519 1 0
    //   92: ifeq +225 -> 317
    //   95: aload 4
    //   97: invokeinterface 523 1 0
    //   102: checkcast 591	com/tencent/mobileqq/data/Emoticon
    //   105: astore 5
    //   107: aload 5
    //   109: getfield 673	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   112: ifnull -27 -> 85
    //   115: aload 5
    //   117: getfield 673	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   120: invokevirtual 674	java/lang/String:length	()I
    //   123: ifle -38 -> 85
    //   126: new 385	org/json/JSONArray
    //   129: dup
    //   130: aload 5
    //   132: getfield 673	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   135: invokespecial 676	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   138: astore 6
    //   140: aload 6
    //   142: invokevirtual 388	org/json/JSONArray:length	()I
    //   145: istore 12
    //   147: iconst_0
    //   148: istore 10
    //   150: iload 10
    //   152: iload 12
    //   154: if_icmpge -69 -> 85
    //   157: aload 6
    //   159: iload 10
    //   161: invokevirtual 678	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   164: astore 7
    //   166: new 622	com/tencent/mobileqq/data/EmoticonKeyword
    //   169: dup
    //   170: invokespecial 679	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   173: astore 8
    //   175: aload 8
    //   177: aload 5
    //   179: getfield 680	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   182: putfield 651	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   185: aload 8
    //   187: aload 5
    //   189: getfield 681	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   192: putfield 650	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   195: aload 8
    //   197: aload 5
    //   199: getfield 684	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   202: putfield 685	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   205: aload 8
    //   207: aload 5
    //   209: getfield 686	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   212: putfield 636	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   215: aload 7
    //   217: invokestatic 642	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +13 -> 233
    //   223: aload 8
    //   225: aload 7
    //   227: invokevirtual 689	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   230: putfield 645	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   233: aload 8
    //   235: aload 5
    //   237: getfield 692	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   240: putfield 693	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   243: aload 8
    //   245: aload 5
    //   247: getfield 694	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   250: putfield 695	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   253: aload 8
    //   255: aload 5
    //   257: getfield 698	com/tencent/mobileqq/data/Emoticon:width	I
    //   260: putfield 699	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   263: aload 8
    //   265: aload 5
    //   267: getfield 702	com/tencent/mobileqq/data/Emoticon:height	I
    //   270: putfield 703	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   273: aload 8
    //   275: iload 9
    //   277: putfield 706	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   280: aload 8
    //   282: aload_3
    //   283: getfield 709	com/tencent/mobileqq/data/EmoticonPackage:valid	Z
    //   286: putfield 710	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   289: aload 8
    //   291: aload 5
    //   293: getfield 713	com/tencent/mobileqq/data/Emoticon:businessExtra	Ljava/lang/String;
    //   296: putfield 714	com/tencent/mobileqq/data/EmoticonKeyword:businessExtra	Ljava/lang/String;
    //   299: aload_0
    //   300: getfield 114	com/tencent/mobileqq/model/EmoticonManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   303: aload 8
    //   305: invokevirtual 717	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   308: iload 10
    //   310: iconst_1
    //   311: iadd
    //   312: istore 10
    //   314: goto -164 -> 150
    //   317: aload_1
    //   318: invokevirtual 719	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   321: aload_1
    //   322: invokevirtual 720	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   325: iload 9
    //   327: iconst_1
    //   328: iadd
    //   329: istore 9
    //   331: goto -313 -> 18
    //   334: astore_3
    //   335: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +13 -> 351
    //   341: ldc 16
    //   343: iconst_2
    //   344: ldc_w 722
    //   347: aload_3
    //   348: invokestatic 725	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload_1
    //   352: invokevirtual 720	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   355: goto -30 -> 325
    //   358: astore_1
    //   359: aload_0
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    //   363: astore_3
    //   364: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +13 -> 380
    //   370: ldc 16
    //   372: iconst_2
    //   373: ldc_w 727
    //   376: aload_3
    //   377: invokestatic 725	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   380: aload_1
    //   381: invokevirtual 720	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   384: goto -59 -> 325
    //   387: astore_2
    //   388: aload_1
    //   389: invokevirtual 720	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   392: aload_2
    //   393: athrow
    //   394: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +34 -> 431
    //   400: ldc 16
    //   402: iconst_2
    //   403: new 137	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 729
    //   413: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_2
    //   417: invokeinterface 541 1 0
    //   422: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_0
    //   432: monitorexit
    //   433: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	EmoticonManager
    //   71	281	1	localEntityTransaction	EntityTransaction
    //   358	31	1	localObject1	Object
    //   6	20	2	localList	List
    //   387	30	2	localObject2	Object
    //   36	247	3	localEmoticonPackage	EmoticonPackage
    //   334	14	3	localJSONException	JSONException
    //   363	14	3	localException	Exception
    //   57	39	4	localObject3	Object
    //   105	187	5	localEmoticon	Emoticon
    //   138	20	6	localJSONArray	JSONArray
    //   164	62	7	str	String
    //   173	131	8	localEmoticonKeyword	EmoticonKeyword
    //   16	314	9	i	int
    //   148	165	10	j	int
    //   13	10	11	k	int
    //   145	10	12	m	int
    // Exception table:
    //   from	to	target	type
    //   72	85	334	org/json/JSONException
    //   85	147	334	org/json/JSONException
    //   157	233	334	org/json/JSONException
    //   233	308	334	org/json/JSONException
    //   317	321	334	org/json/JSONException
    //   2	15	358	finally
    //   25	37	358	finally
    //   41	59	358	finally
    //   64	72	358	finally
    //   321	325	358	finally
    //   351	355	358	finally
    //   380	384	358	finally
    //   388	394	358	finally
    //   394	431	358	finally
    //   72	85	363	java/lang/Exception
    //   85	147	363	java/lang/Exception
    //   157	233	363	java/lang/Exception
    //   233	308	363	java/lang/Exception
    //   317	321	363	java/lang/Exception
    //   72	85	387	finally
    //   85	147	387	finally
    //   157	233	387	finally
    //   233	308	387	finally
    //   317	321	387	finally
    //   335	351	387	finally
    //   364	380	387	finally
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "writeRecommendInfoFromFileToCache");
    }
    if (this.jdField_b_of_type_AndroidOsHandler == null)
    {
      QLog.e("EmoticonManager", 1, "writeRecommendInfoFromFileToCache fileThreadHandler == null");
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new tew(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "saveRecommendEpInfoToFile");
      }
    } while (this.jdField_b_of_type_AndroidOsHandler == null);
    this.jdField_b_of_type_AndroidOsHandler.post(new tey(this));
  }
  
  public int a(String paramString)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Double.valueOf(a()));
    if ((localInteger == null) || (localInteger.intValue() == 0)) {
      return -1;
    }
    EmoticonPackage localEmoticonPackage = a(paramString);
    JSONObject localJSONObject2 = null;
    Object localObject = localJSONObject2;
    if (localEmoticonPackage != null)
    {
      localObject = localJSONObject2;
      if (TextUtils.isEmpty(localEmoticonPackage.supportSize)) {}
    }
    try
    {
      localObject = new JSONArray(localEmoticonPackage.supportSize);
      if (localObject == null) {
        return -1;
      }
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject1;
      for (;;)
      {
        QLog.e("EmoticonManager", 1, localJSONException, new Object[0]);
        localJSONObject1 = localJSONObject2;
      }
      int i = 0;
      try
      {
        while (i < localJSONObject1.length())
        {
          localJSONObject2 = localJSONObject1.getJSONObject(i);
          int j = localJSONObject2.getInt("Width");
          int k = localJSONObject2.getInt("Height");
          if ((j == localInteger.intValue()) && (k == localInteger.intValue()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonManager", 2, "get support size from db, betterSize " + localInteger + ", epId: " + paramString);
            }
            i = localInteger.intValue();
            return i;
          }
          i += 1;
        }
        return -1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public Emoticon a(String paramString1, String paramString2)
  {
    Emoticon localEmoticon = (Emoticon)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1 + "_" + paramString2);
    Object localObject = localEmoticon;
    if (localEmoticon == null)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1)) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "[emo miss] func findEmoticonById, can not find epId:" + paramString1);
      }
      localObject = null;
    }
    label93:
    do
    {
      do
      {
        return (Emoticon)localObject;
        paramString1 = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { paramString1, paramString2 });
        localObject = paramString1;
      } while (paramString1 == null);
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString1.getMapKey(), paramString1);
      localObject = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, "[emo miss] func findEmoticonById, emoticonCache.size:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size());
    return paramString1;
  }
  
  public EmoticonPackage a(String paramString)
  {
    return a(paramString, false);
  }
  
  public PicEmoticonInfo a(MarkFaceMessage paramMarkFaceMessage)
  {
    if (paramMarkFaceMessage == null) {}
    Object localObject1;
    do
    {
      return null;
      localObject1 = EmosmUtils.a(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
    } while (localObject1 == null);
    String str = String.valueOf(paramMarkFaceMessage.dwTabID);
    int i = paramMarkFaceMessage.imageWidth;
    int j = paramMarkFaceMessage.imageHeight;
    Object localObject2 = a(str, (String)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((PicEmoticonInfo)localObject1).jdField_c_of_type_Int = 6;
      ((PicEmoticonInfo)localObject1).a = ((Emoticon)localObject2);
      ((Emoticon)localObject2).encryptKey = new String(paramMarkFaceMessage.sbfKey);
      if (((Emoticon)localObject2).width == 0) {
        ((Emoticon)localObject2).width = i;
      }
      if (((Emoticon)localObject2).height == 0) {
        ((Emoticon)localObject2).height = j;
      }
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        ((Emoticon)localObject2).jobType = 2;
        ((Emoticon)localObject2).magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      if (paramMarkFaceMessage.mediaType == 3) {
        ((Emoticon)localObject2).jobType = 4;
      }
      ((PicEmoticonInfo)localObject1).j = paramMarkFaceMessage.cSubType;
      a(str, (Emoticon)localObject2, paramMarkFaceMessage.resvAttr);
      return (PicEmoticonInfo)localObject1;
    }
    localObject2 = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    ((PicEmoticonInfo)localObject2).jdField_c_of_type_Int = 6;
    Emoticon localEmoticon = new Emoticon();
    if (paramMarkFaceMessage.mediaType == 1) {
      localEmoticon.isSound = true;
    }
    for (;;)
    {
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.epId = str;
      localEmoticon.eId = ((String)localObject1);
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      localEmoticon.width = i;
      localEmoticon.height = j;
      localEmoticon.name = paramMarkFaceMessage.faceName;
      ((PicEmoticonInfo)localObject2).a = localEmoticon;
      ((PicEmoticonInfo)localObject2).j = paramMarkFaceMessage.cSubType;
      a(null, localEmoticon, paramMarkFaceMessage.resvAttr);
      return (PicEmoticonInfo)localObject2;
      if (paramMarkFaceMessage.mediaType == 2) {
        localEmoticon.jobType = 1;
      } else if (paramMarkFaceMessage.mediaType == 3) {
        localEmoticon.jobType = 4;
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    Emoticon localEmoticon = (Emoticon)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1 + "_" + paramString2);
    if (localEmoticon == null)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "can not find small emotion in cache, but pkg in cache:" + paramString1);
        }
        a(new tfa(this, paramString1, paramString2), 5);
      }
      return "";
    }
    return localEmoticon.character;
  }
  
  public List a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getTabEmoticonPackages begins, tabCache.size:" + this.jdField_a_of_type_JavaUtilList.size() + ",pkgCache.size:" + this.jdField_a_of_type_JavaUtilMap.size());
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          Object localObject2 = (String)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localObject2 != null)
          {
            localObject2 = a((String)localObject2);
            if (localObject2 != null) {
              localArrayList.add(localObject2);
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "getTabEmoticonPackages ends, list.size:" + localArrayList.size());
          }
          return localArrayList;
        }
      }
      i += 1;
    }
  }
  
  public List a(String paramString)
  {
    return a(paramString, false);
  }
  
  public List a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList;
    synchronized (this.jdField_b_of_type_AndroidSupportV4UtilLruCache)
    {
      localArrayList = (ArrayList)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      if (localArrayList != null) {
        break label205;
      }
      localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, false, "epId=?", new String[] { paramString }, null, null, null, null);
      if (localArrayList != null)
      {
        this.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString, localArrayList);
        localObject = localArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          Emoticon localEmoticon = (Emoticon)((Iterator)localObject).next();
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localEmoticon.getMapKey(), localEmoticon);
        }
      }
    }
    Object localObject = localArrayList;
    if (QLog.isColorLevel())
    {
      QLog.d("EmoticonManager", 2, "[emo miss] getSubEmoticonsByPackageId subEmoticonsCache.size:" + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size() + ",epId:" + paramString);
      localObject = localArrayList;
    }
    while ((localObject != null) && (paramBoolean))
    {
      paramString = (List)((ArrayList)localObject).clone();
      return paramString;
      label205:
      localObject = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonManager", 2, "getSubEmoticonsByPackageId from cache subEmoticonsCache.size:" + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size() + ",epId:" + paramString);
        localObject = localArrayList;
      }
    }
    return (List)localObject;
  }
  
  public List a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getProEmoticonPkgs isFromCache = " + paramBoolean);
    }
    if (paramBoolean) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    Object localObject;
    ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg;
    String str;
    if (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend != null)
    {
      i = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.int32_show_num.get();
      if (i > 0) {
        jdField_e_of_type_Int = i;
      }
      j = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.int32_exposure_num.get();
      if (j > 0) {
        jdField_d_of_type_Int = j;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "getProEmoticonPkgs showNum = " + i);
      }
      List localList1 = a();
      List localList2 = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
      if ((localList2 != null) && (localList2.size() > 0))
      {
        int k = 0;
        i = 0;
        while (k < localList2.size())
        {
          localObject = (EmosmPb.STRecommendTabInfo)localList2.get(k);
          localPromotionEmoticonPkg = new ClubContentJsonTask.PromotionEmoticonPkg();
          str = String.valueOf(((EmosmPb.STRecommendTabInfo)localObject).u32_tab_id.get());
          localPromotionEmoticonPkg.jdField_a_of_type_JavaLangString = str;
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "STRecommendTabInfo id = " + str);
          }
          if ((this.jdField_b_of_type_JavaUtilMap.containsKey(str)) && (((Integer)this.jdField_b_of_type_JavaUtilMap.get(str)).intValue() >= jdField_d_of_type_Int))
          {
            j = i;
            if (!QLog.isColorLevel()) {
              break label767;
            }
            QLog.d("EmoticonManager", 2, "getProEmoticonPkgs exposeNum > max ; epId = " + str);
            k += 1;
          }
          else
          {
            if ((localList1 == null) || (localList1.size() <= 0)) {
              break label976;
            }
            j = 0;
            label354:
            if (j >= localList1.size()) {
              break label976;
            }
            if (!((EmoticonPackage)localList1.get(j)).epId.equals(localPromotionEmoticonPkg.jdField_a_of_type_JavaLangString)) {
              break label444;
            }
          }
        }
      }
    }
    label444:
    label606:
    label767:
    label774:
    label889:
    label976:
    for (int m = 1;; m = 0)
    {
      if (i >= jdField_e_of_type_Int) {}
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilList = localArrayList;
        QLog.d("EmoticonManager", 2, "getProEmoticonPkgs data size = " + localArrayList.size());
        return localArrayList;
        j += 1;
        break label354;
        j = i;
        if (m == 0)
        {
          i += 1;
          localPromotionEmoticonPkg.jdField_c_of_type_JavaLangString = ((EmosmPb.STRecommendTabInfo)localObject).str_tab_name.get();
          localPromotionEmoticonPkg.n = ((EmosmPb.STRecommendTabInfo)localObject).i32_tab_type.get();
          localPromotionEmoticonPkg.o = ((EmosmPb.STRecommendTabInfo)localObject).i32_feetype.get();
          localPromotionEmoticonPkg.jdField_b_of_type_JavaLangString = ((EmosmPb.STRecommendTabInfo)localObject).str_thumb_nail_url.get();
          localPromotionEmoticonPkg.jdField_e_of_type_JavaLangString = ((EmosmPb.STRecommendTabInfo)localObject).str_title_color.get();
          localPromotionEmoticonPkg.f = ((EmosmPb.STRecommendTabInfo)localObject).str_bg_color.get();
          localPromotionEmoticonPkg.p = ((EmosmPb.STRecommendTabInfo)localObject).i32_price.get();
          localPromotionEmoticonPkg.q = ((EmosmPb.STRecommendTabInfo)localObject).i32_recommend_mode.get();
          localPromotionEmoticonPkg.r = ((EmosmPb.STRecommendTabInfo)localObject).int32_red_point_flag.get();
          localPromotionEmoticonPkg.g = ((EmosmPb.STRecommendTabInfo)localObject).str_button_url.get();
          str = "下载";
          if (localPromotionEmoticonPkg.o != 6) {
            break label774;
          }
          localObject = "活动";
          localPromotionEmoticonPkg.jdField_d_of_type_JavaLangString = ((String)localObject);
          if (localPromotionEmoticonPkg.n != ClubContentJsonTask.PromotionEmoticonPkg.jdField_e_of_type_Int) {
            break label889;
          }
          localPromotionEmoticonPkg.n = 4;
        }
        for (;;)
        {
          localArrayList.add(localPromotionEmoticonPkg);
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("EmoticonManager", 2, "recommendemos epid = " + localPromotionEmoticonPkg.jdField_a_of_type_JavaLangString + ";pkgname = " + localPromotionEmoticonPkg.jdField_c_of_type_JavaLangString + ";type = " + localPromotionEmoticonPkg.n + ";feeType" + localPromotionEmoticonPkg.o + ";imgurl = " + localPromotionEmoticonPkg.jdField_b_of_type_JavaLangString + ";btndec = " + localPromotionEmoticonPkg.jdField_d_of_type_JavaLangString + ";price = " + localPromotionEmoticonPkg.p);
            j = i;
          }
          i = j;
          break;
          if (localPromotionEmoticonPkg.o == 1)
          {
            localObject = "免费";
            break label606;
          }
          if (localPromotionEmoticonPkg.o == 4)
          {
            localObject = "VIP";
            break label606;
          }
          if (localPromotionEmoticonPkg.o == 5)
          {
            localObject = "SVIP";
            break label606;
          }
          localObject = str;
          if (localPromotionEmoticonPkg.o != 2) {
            break label606;
          }
          if (localPromotionEmoticonPkg.p == ClubContentJsonTask.PromotionEmoticonPkg.i)
          {
            localObject = "限免";
            break label606;
          }
          if (localPromotionEmoticonPkg.p == ClubContentJsonTask.PromotionEmoticonPkg.j)
          {
            localObject = "￥1.00";
            break label606;
          }
          localObject = str;
          if (localPromotionEmoticonPkg.p != ClubContentJsonTask.PromotionEmoticonPkg.k) {
            break label606;
          }
          localObject = "￥6.00";
          break label606;
          if (localPromotionEmoticonPkg.n == ClubContentJsonTask.PromotionEmoticonPkg.jdField_a_of_type_Int) {
            localPromotionEmoticonPkg.n = 3;
          } else if ((localPromotionEmoticonPkg.n == ClubContentJsonTask.PromotionEmoticonPkg.jdField_c_of_type_Int) || (localPromotionEmoticonPkg.n == ClubContentJsonTask.PromotionEmoticonPkg.jdField_b_of_type_Int)) {
            localPromotionEmoticonPkg.n = 0;
          } else if (localPromotionEmoticonPkg.n == ClubContentJsonTask.PromotionEmoticonPkg.jdField_d_of_type_Int) {
            localPromotionEmoticonPkg.n = 5;
          }
        }
        QLog.d("EmoticonManager", 1, "getProEmoticonPkgs recommendRsp == NULL");
        h();
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "clearCache begins");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
    this.c.evictAll();
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "clearCache ends");
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return;
    }
    a(new tfd(this, paramEmoticon), 8);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramEmoticonPackage.epId, paramEmoticonPackage);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "saveEmoticonPackages, pkgCache.size:" + this.jdField_a_of_type_JavaUtilMap.size() + ",epId:" + paramEmoticonPackage.epId + ",status:" + paramEmoticonPackage.getStatus());
      }
      a(new tfc(this, paramEmoticonPackage), 8);
    }
  }
  
  public void a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    int i = 0;
    if ((paramPromotionEmoticonPkg == null) || (TextUtils.isEmpty(paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString)) {
      i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString)).intValue();
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString, Integer.valueOf(i + 1));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonManager", 2, "recordRecommendEpExpose epid = " + paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString + ";exposeNum = " + (i + 1));
      return;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString, 0);
      }
    }
  }
  
  public void a(EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new tev(this, paramSubCmd0x5RspBQRecommend));
    i();
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramString);
    ThreadManager.a(new tfe(this, paramString), 5, null, true);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    EmoticonPackage localEmoticonPackage = b(paramString1);
    if (localEmoticonPackage != null)
    {
      int i = localEmoticonPackage.latestVersion;
      localEmoticonPackage.updateFlag = paramInt2;
      localEmoticonPackage.updateTip = paramString2;
      localEmoticonPackage.latestVersion = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "epId=" + paramString1 + " localVersion=" + localEmoticonPackage.localVersion + " version=" + paramInt1 + " updateFlag: " + paramInt2 + " latestVersion= " + i);
      }
      if ((EmoticonUtils.a(paramInt2)) && (i < paramInt1))
      {
        localEmoticonPackage.hasReadUpdatePage = false;
        a(localEmoticonPackage);
      }
    }
  }
  
  public void a(String paramString, Emoticon paramEmoticon, byte[] paramArrayOfByte)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Double.valueOf(a()));
    if ((localInteger == null) || (localInteger.intValue() == 0)) {}
    do
    {
      for (;;)
      {
        return;
        int i;
        if ((paramString != null) && (paramEmoticon.extensionHeight == 0) && (paramEmoticon.extensionWidth == 0))
        {
          i = a(paramString);
          if (i != -1)
          {
            paramEmoticon.extensionHeight = i;
            paramEmoticon.extensionWidth = i;
          }
        }
        else if (paramArrayOfByte != null)
        {
          MarketFaceExtPb.ResvAttr localResvAttr = new MarketFaceExtPb.ResvAttr();
          try
          {
            localResvAttr.mergeFrom(paramArrayOfByte);
            if ((localResvAttr.rpt_support_size != null) && (paramEmoticon.extensionHeight == 0) && (paramEmoticon.extensionWidth == 0))
            {
              i = 0;
              if (i < localResvAttr.rpt_support_size.size())
              {
                paramArrayOfByte = (MarketFaceExtPb.SupportSize)localResvAttr.rpt_support_size.get(i);
                int j = paramArrayOfByte.uint32_width.get();
                int k = paramArrayOfByte.uint32_height.get();
                if ((j == localInteger.intValue()) && (k == localInteger.intValue()))
                {
                  paramEmoticon.extensionWidth = localInteger.intValue();
                  paramEmoticon.extensionHeight = localInteger.intValue();
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("EmoticonManager", 2, "get support size from resvAttr, betterSize: " + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticon.eId);
                }
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            for (;;)
            {
              paramArrayOfByte.printStackTrace();
              continue;
              i += 1;
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, "get support size " + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticon.eId + ", height: " + paramEmoticon.extensionHeight + ", width: " + paramEmoticon.extensionWidth);
  }
  
  public void a(String paramString, EmoticonKeywordForCloud paramEmoticonKeywordForCloud, List paramList)
  {
    if ((paramList == null) || (paramEmoticonKeywordForCloud == null)) {
      return;
    }
    Integer localInteger;
    do
    {
      do
      {
        do
        {
          localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Double.valueOf(a()));
        } while ((localInteger == null) || (localInteger.intValue() == 0));
        if (a(paramString) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "get support size from cloud: local exists, better size" + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticonKeywordForCloud.eId);
          }
          a(paramString, paramEmoticonKeywordForCloud, null);
          return;
        }
        paramList = paramList.iterator();
      } while (!paramList.hasNext());
      EmosmPb.SupportSize localSupportSize = (EmosmPb.SupportSize)paramList.next();
      int i = localSupportSize.u32_Width.get();
      int j = localSupportSize.u32_height.get();
      if ((i != localInteger.intValue()) || (j != localInteger.intValue())) {
        break;
      }
      paramEmoticonKeywordForCloud.extensionWidth = localInteger.intValue();
      paramEmoticonKeywordForCloud.extensionHeight = localInteger.intValue();
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManager", 2, "get support size from cloud: , better size" + localInteger + ", epId: " + paramString + " , eId: " + paramEmoticonKeywordForCloud.eId);
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    paramString = b(paramString);
    if ((paramString != null) && (paramString.hasReadUpdatePage != paramBoolean.booleanValue()))
    {
      paramString.hasReadUpdatePage = paramBoolean.booleanValue();
      a(paramString);
    }
  }
  
  public void a(String paramString, List paramList)
  {
    ArrayList localArrayList = (ArrayList)a(paramString);
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(localEmoticon.getMapKey());
          localEmoticon.setStatus(1001);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticon);
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
      localArrayList.clear();
      this.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString, localArrayList);
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramList);
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = (Emoticon)paramString.next();
          paramList.setStatus(1000);
          a(paramList);
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramList.getMapKey(), paramList);
        }
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.b();
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
        if (localEmoticonPackage != null)
        {
          this.jdField_a_of_type_JavaUtilMap.put(localEmoticonPackage.epId, localEmoticonPackage);
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "saveEmoticonPackages, pkgCache.size:" + this.jdField_a_of_type_JavaUtilMap.size() + ",epId:" + localEmoticonPackage.epId);
          }
        }
      }
      ThreadManager.a(new tfb(this, paramList), 8, null, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int j = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).h();
    int i = j;
    if (j > 2) {
      i = 2;
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_Int == i)) {
      return;
    }
    ThreadManager.a().post(new teq(this, i));
  }
  
  public boolean a()
  {
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isShowRecommendRedPoint red isRedEffective");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getBoolean("isClickRecommendRedpoint", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isShowRecommendRedPoint is click");
      }
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)((Iterator)localObject).next();
        String str = String.valueOf(localSTRecommendTabInfo.u32_tab_id.get());
        if ((!TextUtils.isEmpty(str)) && (localSTRecommendTabInfo.int32_red_point_flag.get() == 1) && (this.jdField_b_of_type_JavaUtilMap.containsKey(str)) && (((Integer)this.jdField_b_of_type_JavaUtilMap.get(str)).intValue() < jdField_d_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "isShowRecommendRedPoint showRedpoint");
          }
          return true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "isShowRecommendRedPoint not show");
    }
    return false;
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp)
  {
    boolean bool2 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool1 = bool6;
    ArrayList localArrayList1;
    if (paramInt == 2)
    {
      bool1 = bool6;
      if (paramBoolean)
      {
        localArrayList1 = new ArrayList();
        localArrayList1.addAll(paramEmoticonResp.data);
        localArrayList1.addAll(paramEmoticonResp.magicData);
        localArrayList1.addAll(paramEmoticonResp.smallEmoticonData);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "handleFetchEmoticonPackagesResp, big emoticon list=" + paramEmoticonResp.data + "magic emoticon list=" + paramEmoticonResp.magicData + "small emoticon list=" + paramEmoticonResp.smallEmoticonData + "emoticon tab order list=" + paramEmoticonResp.tabOrderList + "roaming emoji size:" + localArrayList1.size());
        }
        EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
        EmoticonPackage localEmoticonPackage;
        for (;;)
        {
          ArrayList localArrayList2;
          try
          {
            localArrayList2 = new ArrayList();
            paramInt = 0;
            bool1 = bool5;
            paramBoolean = bool4;
            bool3 = paramBoolean;
            bool2 = bool1;
            if (paramInt >= localArrayList1.size()) {
              break label973;
            }
            bool3 = paramBoolean;
            bool2 = bool1;
            localObject1 = (EmoticonPackage)localArrayList1.get(paramInt);
            bool3 = paramBoolean;
            bool2 = bool1;
            localObject2 = a(((EmoticonPackage)localObject1).epId, true);
            if (localObject2 != null)
            {
              bool3 = paramBoolean;
              bool2 = bool1;
              if (((EmoticonPackage)localObject2).valid == ((EmoticonPackage)localObject1).valid)
              {
                bool3 = paramBoolean;
                bool2 = bool1;
                if (((EmoticonPackage)localObject2).wordingId == ((EmoticonPackage)localObject1).wordingId)
                {
                  bool3 = paramBoolean;
                  bool2 = bool1;
                  if (((EmoticonPackage)localObject2).expiretime == ((EmoticonPackage)localObject1).expiretime)
                  {
                    bool3 = paramBoolean;
                    bool2 = bool1;
                    if (((EmoticonPackage)localObject2).jobType == ((EmoticonPackage)localObject1).jobType) {
                      continue;
                    }
                  }
                }
              }
              bool3 = paramBoolean;
              bool2 = bool1;
              if (!TextUtils.isEmpty(((EmoticonPackage)localObject2).name))
              {
                bool3 = paramBoolean;
                bool2 = bool1;
                if (QLog.isColorLevel())
                {
                  bool3 = paramBoolean;
                  bool2 = bool1;
                  QLog.d("EmoticonManager", 2, "handleFetchEmoticonPackagesResp : updateLocalep epDb = " + localObject2 + ";ep = " + localObject1);
                }
                bool3 = paramBoolean;
                bool2 = bool1;
                ((EmoticonPackage)localObject2).expiretime = ((EmoticonPackage)localObject1).expiretime;
                bool3 = paramBoolean;
                bool2 = bool1;
                ((EmoticonPackage)localObject2).valid = ((EmoticonPackage)localObject1).valid;
                bool3 = paramBoolean;
                bool2 = bool1;
                ((EmoticonPackage)localObject2).wordingId = ((EmoticonPackage)localObject1).wordingId;
                bool3 = paramBoolean;
                bool2 = bool1;
                ((EmoticonPackage)localObject2).jobType = ((EmoticonPackage)localObject1).jobType;
                bool3 = paramBoolean;
                bool2 = bool1;
                localArrayList2.add(localObject2);
                bool4 = true;
                bool2 = true;
                bool3 = paramBoolean;
                if (((EmoticonPackage)localObject1).jobType != 3) {
                  break label1173;
                }
                paramBoolean = true;
                bool1 = true;
                break label1166;
              }
            }
            bool4 = bool1;
            if (localObject2 != null) {
              break label1173;
            }
            bool3 = paramBoolean;
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              bool3 = paramBoolean;
              bool2 = bool1;
              QLog.i("EmoticonManager", 2, "handleFetchEmoticonPackagesResp : emoPackage does not exists: " + ((EmoticonPackage)localObject1).epId);
            }
            bool3 = paramBoolean;
            bool2 = bool1;
            a((EmoticonPackage)localObject1);
            bool3 = paramBoolean;
            bool2 = bool1;
            if (4 == ((EmoticonPackage)localObject1).jobType)
            {
              bool3 = paramBoolean;
              bool2 = bool1;
              localEmojiManager.a(((EmoticonPackage)localObject1).epId, EmojiManager.jdField_e_of_type_Int, null, true);
              bool3 = paramBoolean;
              bool2 = bool1;
              if (((EmoticonPackage)localObject1).jobType != 0)
              {
                bool3 = paramBoolean;
                bool2 = bool1;
                if (4 != ((EmoticonPackage)localObject1).jobType) {
                  break label852;
                }
              }
              bool3 = paramBoolean;
              bool2 = bool1;
              localEmojiManager.a((EmoticonPackage)localObject1);
              break label1166;
            }
            bool3 = paramBoolean;
            bool2 = bool1;
            localEmojiManager.a(((EmoticonPackage)localObject1).epId, EmojiManager.jdField_e_of_type_Int, null, false);
            continue;
            if (paramEmoticonResp.tabOrderList.size() != 0) {
              break label1158;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            bool1 = bool2;
            paramBoolean = bool3;
            if (localArrayList1.size() <= 0) {
              break label1158;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("EmoticonManager", 2, "handleFetchEmoticonPackagesResp, svr data wrong, no order list, but allEpList.size()=" + localArrayList1.size());
          }
          localArrayList1 = new ArrayList();
          paramInt = paramEmoticonResp.data.size() - 1;
          while (paramInt >= 0)
          {
            localEmoticonPackage = (EmoticonPackage)paramEmoticonResp.data.get(paramInt);
            if (localEmoticonPackage != null) {
              localArrayList1.add(localEmoticonPackage.epId);
            }
            paramInt -= 1;
          }
          label852:
          bool3 = paramBoolean;
          bool2 = bool1;
          Object localObject2 = EmosmUtils.b(2, ((EmoticonPackage)localObject1).epId);
          bool3 = paramBoolean;
          bool2 = bool1;
          Object localObject1 = new File(EmosmUtils.a(2, ((EmoticonPackage)localObject1).epId));
          bool3 = paramBoolean;
          bool2 = bool1;
          bool4 = bool1;
          if (((File)localObject1).exists()) {
            break label1173;
          }
          bool3 = paramBoolean;
          bool2 = bool1;
          localObject1 = new DownloadTask((String)localObject2, (File)localObject1);
          bool3 = paramBoolean;
          bool2 = bool1;
          ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a((DownloadTask)localObject1, null, null);
          bool4 = bool1;
          break label1173;
          label973:
          bool3 = paramBoolean;
          bool2 = bool1;
          a(localArrayList2);
        }
        paramInt = paramEmoticonResp.magicData.size() - 1;
        while (paramInt >= 0)
        {
          localEmoticonPackage = (EmoticonPackage)paramEmoticonResp.magicData.get(paramInt);
          if (localEmoticonPackage != null) {
            localArrayList1.add(localEmoticonPackage.epId);
          }
          paramInt -= 1;
        }
        paramInt = paramEmoticonResp.smallEmoticonData.size() - 1;
        while (paramInt >= 0)
        {
          localEmoticonPackage = (EmoticonPackage)paramEmoticonResp.smallEmoticonData.get(paramInt);
          if (localEmoticonPackage != null) {
            localArrayList1.add(localEmoticonPackage.epId);
          }
          paramInt -= 1;
        }
      }
    }
    label1158:
    for (paramEmoticonResp = localArrayList1;; paramEmoticonResp = paramEmoticonResp.tabOrderList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "handleFetchEmoticonPackagesResp, save order, orderList=" + paramEmoticonResp + ",dataChanged: " + bool1);
      }
      b(paramEmoticonResp);
      bool1 = paramBoolean;
      return bool1;
    }
    for (;;)
    {
      label1166:
      paramInt += 1;
      break;
      label1173:
      bool1 = bool4;
    }
  }
  
  public int b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat != null) && (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramString.toUpperCase().hashCode()) != null) && (b())) {
      return ((Integer)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramString.toUpperCase().hashCode())).intValue();
    }
    return 0;
  }
  
  public EmoticonPackage b(String paramString)
  {
    if (paramString == null) {}
    while (!this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
      return null;
    }
    return a(paramString);
  }
  
  public List b()
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = a();
    Object localObject3 = new ArrayList();
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (EmoticonPackage)((List)localObject1).get(i);
        if ((3 == ((EmoticonPackage)localObject2).jobType) || (5 == ((EmoticonPackage)localObject2).jobType)) {
          ((List)localObject3).add(localObject2);
        }
        i += 1;
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    localObject3 = ((List)localObject3).iterator();
    int i = 0;
    if (((Iterator)localObject3).hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject3).next();
      Object localObject4 = a(localEmoticonPackage.epId);
      if (localObject4 == null) {
        break label632;
      }
      localObject4 = ((List)localObject4).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        Emoticon localEmoticon = (Emoticon)((Iterator)localObject4).next();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManager", 2, "try to get pack data, id:" + localEmoticonPackage.epId + ",valid:" + localEmoticonPackage.valid + ",status:" + localEmoticonPackage.status);
        }
        if (localEmoticonPackage.jobType == 3)
        {
          localEmoticon.jobType = 2;
          label265:
          if (!TextUtils.isEmpty(localEmoticonPackage.name)) {
            localEmoticon.name = localEmoticonPackage.name;
          }
          localEmoticon.value = localEmoticonPackage.valid;
          PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localPicEmoticonInfo.jdField_c_of_type_Int = 9;
          localPicEmoticonInfo.a = localEmoticon;
          localArrayList.add(localPicEmoticonInfo);
          if ((!localEmoticonPackage.valid) || (localEmoticonPackage.status != 2)) {
            break label391;
          }
          ((List)localObject1).add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          break;
          if (localEmoticonPackage.jobType != 5) {
            break label265;
          }
          localEmoticon.jobType = 4;
          break label265;
          label391:
          ((List)localObject2).add(Integer.valueOf(i));
        }
      }
    }
    label632:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "comp size:" + ((List)localObject1).size() + ",inComp size:" + ((List)localObject2).size());
      }
      if ((((List)localObject1).size() > 0) && (((List)localObject2).size() > 0) && (((Integer)((List)localObject1).get(((List)localObject1).size() - 1)).intValue() > ((Integer)((List)localObject2).get(0)).intValue()))
      {
        localObject3 = new ArrayList();
        i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= ((List)localObject1).size()) {
            break;
          }
          ((List)localObject3).add(localArrayList.get(((Integer)((List)localObject1).get(i)).intValue()));
          i += 1;
        }
        while (j < ((List)localObject2).size())
        {
          ((List)localObject3).add(localArrayList.get(((Integer)((List)localObject2).get(j)).intValue()));
          j += 1;
        }
        return (List)localObject3;
      }
      return localArrayList;
    }
  }
  
  public List b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (List)this.c.get(paramString.toUpperCase());
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonKeyword.class.getSimpleName());
  }
  
  /* Error */
  public void b(Emoticon paramEmoticon)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 686	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   8: invokestatic 642	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 79	com/tencent/mobileqq/model/EmoticonManager:c	Landroid/support/v4/util/LruCache;
    //   19: astore 4
    //   21: aload 4
    //   23: monitorenter
    //   24: aload_1
    //   25: getfield 673	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   28: ifnull +122 -> 150
    //   31: new 385	org/json/JSONArray
    //   34: dup
    //   35: aload_1
    //   36: getfield 673	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   39: invokespecial 676	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual 388	org/json/JSONArray:length	()I
    //   47: iconst_1
    //   48: if_icmpge +69 -> 117
    //   51: aload_1
    //   52: getfield 1357	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   55: ifnull +22 -> 77
    //   58: aload_1
    //   59: getfield 1357	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   62: invokevirtual 674	java/lang/String:length	()I
    //   65: ifle +12 -> 77
    //   68: aload_2
    //   69: aload_1
    //   70: getfield 1357	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   73: invokevirtual 1360	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   76: pop
    //   77: aload_1
    //   78: getfield 684	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   81: ifnull +36 -> 117
    //   84: aload_1
    //   85: getfield 684	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   88: invokevirtual 674	java/lang/String:length	()I
    //   91: ifle +26 -> 117
    //   94: aload_1
    //   95: getfield 684	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   98: aload_1
    //   99: getfield 1357	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   102: invokevirtual 405	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifne +12 -> 117
    //   108: aload_2
    //   109: aload_1
    //   110: getfield 684	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   113: invokevirtual 1360	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   116: pop
    //   117: aload_2
    //   118: invokevirtual 388	org/json/JSONArray:length	()I
    //   121: istore 9
    //   123: iconst_0
    //   124: istore 7
    //   126: iload 7
    //   128: iload 9
    //   130: if_icmpge +192 -> 322
    //   133: aload_2
    //   134: iload 7
    //   136: invokevirtual 678	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   139: astore_3
    //   140: aload_3
    //   141: invokestatic 642	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifeq +17 -> 161
    //   147: goto +340 -> 487
    //   150: new 385	org/json/JSONArray
    //   153: dup
    //   154: invokespecial 1361	org/json/JSONArray:<init>	()V
    //   157: astore_2
    //   158: goto -115 -> 43
    //   161: aload_3
    //   162: invokevirtual 689	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   165: astore 5
    //   167: aload_1
    //   168: instanceof 622
    //   171: ifeq +161 -> 332
    //   174: aload_1
    //   175: checkcast 622	com/tencent/mobileqq/data/EmoticonKeyword
    //   178: astore_3
    //   179: aload_3
    //   180: aload 5
    //   182: putfield 645	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   185: aload_0
    //   186: getfield 79	com/tencent/mobileqq/model/EmoticonManager:c	Landroid/support/v4/util/LruCache;
    //   189: aload_3
    //   190: getfield 645	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   193: invokevirtual 646	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: checkcast 507	java/util/List
    //   199: astore 5
    //   201: aload 5
    //   203: ifnull +223 -> 426
    //   206: iconst_0
    //   207: istore 8
    //   209: iload 8
    //   211: aload 5
    //   213: invokeinterface 541 1 0
    //   218: if_icmpge +263 -> 481
    //   221: aload 5
    //   223: iload 8
    //   225: invokeinterface 572 2 0
    //   230: checkcast 622	com/tencent/mobileqq/data/EmoticonKeyword
    //   233: astore 6
    //   235: aload 6
    //   237: getfield 650	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   240: aload_1
    //   241: getfield 681	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   244: invokevirtual 405	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +249 -> 496
    //   250: aload 6
    //   252: getfield 651	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   255: aload_1
    //   256: getfield 680	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   259: invokevirtual 405	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +234 -> 496
    //   265: aload 5
    //   267: iload 8
    //   269: invokeinterface 1363 2 0
    //   274: pop
    //   275: aload 5
    //   277: iconst_0
    //   278: aload 6
    //   280: invokeinterface 1088 3 0
    //   285: iconst_1
    //   286: istore 8
    //   288: iload 8
    //   290: ifne +197 -> 487
    //   293: aload 5
    //   295: iconst_0
    //   296: aload_3
    //   297: invokeinterface 1088 3 0
    //   302: goto +185 -> 487
    //   305: astore_1
    //   306: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +13 -> 322
    //   312: ldc 16
    //   314: iconst_2
    //   315: ldc_w 1365
    //   318: aload_1
    //   319: invokestatic 725	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   322: aload 4
    //   324: monitorexit
    //   325: return
    //   326: astore_1
    //   327: aload 4
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    //   332: new 622	com/tencent/mobileqq/data/EmoticonKeyword
    //   335: dup
    //   336: invokespecial 679	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   339: astore_3
    //   340: aload_3
    //   341: aload_1
    //   342: getfield 680	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   345: putfield 651	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   348: aload_3
    //   349: aload_1
    //   350: getfield 681	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   353: putfield 650	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   356: aload_3
    //   357: aload_1
    //   358: getfield 684	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   361: putfield 685	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   364: aload_3
    //   365: aload_1
    //   366: getfield 686	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   369: putfield 636	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   372: aload_3
    //   373: aload_1
    //   374: getfield 692	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   377: putfield 693	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   380: aload_3
    //   381: aload_1
    //   382: getfield 694	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   385: putfield 695	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   388: aload_3
    //   389: aload_1
    //   390: getfield 698	com/tencent/mobileqq/data/Emoticon:width	I
    //   393: putfield 699	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   396: aload_3
    //   397: aload_1
    //   398: getfield 702	com/tencent/mobileqq/data/Emoticon:height	I
    //   401: putfield 703	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   404: aload_3
    //   405: aload_3
    //   406: getfield 651	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   409: invokestatic 1368	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   412: invokevirtual 755	java/lang/Integer:intValue	()I
    //   415: putfield 706	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   418: aload_3
    //   419: iconst_1
    //   420: putfield 710	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   423: goto -244 -> 179
    //   426: new 87	java/util/ArrayList
    //   429: dup
    //   430: invokespecial 88	java/util/ArrayList:<init>	()V
    //   433: astore 5
    //   435: aload 5
    //   437: aload_3
    //   438: invokeinterface 529 2 0
    //   443: pop
    //   444: aload_0
    //   445: getfield 79	com/tencent/mobileqq/model/EmoticonManager:c	Landroid/support/v4/util/LruCache;
    //   448: aload_3
    //   449: getfield 645	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   452: aload 5
    //   454: invokevirtual 652	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: pop
    //   458: goto +29 -> 487
    //   461: astore_1
    //   462: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq -143 -> 322
    //   468: ldc 16
    //   470: iconst_2
    //   471: ldc_w 1370
    //   474: aload_1
    //   475: invokestatic 725	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   478: goto -156 -> 322
    //   481: iconst_0
    //   482: istore 8
    //   484: goto -196 -> 288
    //   487: iload 7
    //   489: iconst_1
    //   490: iadd
    //   491: istore 7
    //   493: goto -367 -> 126
    //   496: iload 8
    //   498: iconst_1
    //   499: iadd
    //   500: istore 8
    //   502: goto -293 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	EmoticonManager
    //   0	505	1	paramEmoticon	Emoticon
    //   42	116	2	localJSONArray	JSONArray
    //   139	310	3	localObject1	Object
    //   165	288	5	localObject2	Object
    //   233	46	6	localEmoticonKeyword	EmoticonKeyword
    //   124	368	7	i	int
    //   207	294	8	j	int
    //   121	10	9	k	int
    // Exception table:
    //   from	to	target	type
    //   24	43	305	org/json/JSONException
    //   43	77	305	org/json/JSONException
    //   77	117	305	org/json/JSONException
    //   117	123	305	org/json/JSONException
    //   133	147	305	org/json/JSONException
    //   150	158	305	org/json/JSONException
    //   161	179	305	org/json/JSONException
    //   179	201	305	org/json/JSONException
    //   209	285	305	org/json/JSONException
    //   293	302	305	org/json/JSONException
    //   332	423	305	org/json/JSONException
    //   426	458	305	org/json/JSONException
    //   24	43	326	finally
    //   43	77	326	finally
    //   77	117	326	finally
    //   117	123	326	finally
    //   133	147	326	finally
    //   150	158	326	finally
    //   161	179	326	finally
    //   179	201	326	finally
    //   209	285	326	finally
    //   293	302	326	finally
    //   306	322	326	finally
    //   322	325	326	finally
    //   327	330	326	finally
    //   332	423	326	finally
    //   426	458	326	finally
    //   462	478	326	finally
    //   24	43	461	java/lang/Exception
    //   43	77	461	java/lang/Exception
    //   77	117	461	java/lang/Exception
    //   117	123	461	java/lang/Exception
    //   133	147	461	java/lang/Exception
    //   150	158	461	java/lang/Exception
    //   161	179	461	java/lang/Exception
    //   179	201	461	java/lang/Exception
    //   209	285	461	java/lang/Exception
    //   293	302	461	java/lang/Exception
    //   332	423	461	java/lang/Exception
    //   426	458	461	java/lang/Exception
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    ThreadManager.a(new tff(this, paramString), 5, null, true);
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramString2 = b(paramString1);
    if (paramString2 == null) {
      return;
    }
    paramString2.jsonVersion = paramInt1;
    a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, paramInt1 + "==========KeywordJsonupdate============" + paramString1);
    }
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramString2.epId, EmojiManager.f);
  }
  
  public void b(List paramList)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        int j = paramList.size();
        i = 0;
        if (i < j)
        {
          String str = (String)paramList.get(i);
          if (!this.jdField_a_of_type_JavaUtilList.contains(str)) {
            this.jdField_a_of_type_JavaUtilList.add(str);
          }
        }
        else
        {
          ThreadManager.a(new tet(this, paramList), 5, null, true);
          return;
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "pushRecommendExposeInfoToSP");
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (!TextUtils.isEmpty(str))
      {
        int i = ((Integer)localEntry.getValue()).intValue();
        if ((i < jdField_d_of_type_Int) && (i > 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null)) {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(str, i).commit();
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    Vector localVector = new Vector();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
      this.jdField_a_of_type_JavaUtilList.add(0, paramString);
      paramString = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_JavaUtilList, true);
      }
      localVector.addAll(this.jdField_a_of_type_JavaUtilList);
      a(new teu(this, localVector), 5);
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend == null) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    Object localObject4;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((Integer)((Map.Entry)localObject4).getValue()).intValue() >= jdField_d_of_type_Int) && (localList != null) && (localList.size() > 0))
      {
        localObject4 = localList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)((Iterator)localObject4).next();
          if (((String)localObject3).equals(String.valueOf(localSTRecommendTabInfo.u32_tab_id.get()))) {
            ((List)localObject1).add(localSTRecommendTabInfo);
          }
        }
      }
    }
    if ((QLog.isColorLevel()) && (((List)localObject1).size() > 0))
    {
      localObject2 = new StringBuilder(((List)localObject1).size() * 16);
      ((StringBuilder)localObject2).append("removeExposeRecommendEmotion removeExposeEp:");
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (EmosmPb.STRecommendTabInfo)((Iterator)localObject3).next();
        ((StringBuilder)localObject2).append(";").append(((EmosmPb.STRecommendTabInfo)localObject4).u32_tab_id.get());
      }
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (((List)localObject1).size() > 0) {
      localList.removeAll((Collection)localObject1);
    }
    if ((QLog.isColorLevel()) && (localList != null) && (localList.size() > 0))
    {
      localObject1 = new StringBuilder(((List)localObject1).size() * 16);
      ((StringBuilder)localObject1).append("removeExposeRecommendEmotion remaininfo:");
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EmosmPb.STRecommendTabInfo)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(";").append(((EmosmPb.STRecommendTabInfo)localObject3).u32_tab_id.get());
      }
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.set(localList);
    i();
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "setRecommendEpRedFlag epid = " + paramString);
    }
    List localList = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)localIterator.next();
        if (paramString.equals(String.valueOf(localSTRecommendTabInfo.u32_tab_id.get()))) {
          localSTRecommendTabInfo.int32_red_point_flag.set(0);
        }
      }
    }
    this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.set(localList);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ArrayOfBoolean = null;
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\model\EmoticonManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */