package com.tencent.mobileqq.activity.bless;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import oft;
import ofu;
import ofv;
import ofw;

public class BlessManager
  implements Manager
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final String b = ".qrc";
  public static final int c = 2;
  public static final String c = ".m4a";
  private static int jdField_d_of_type_Int = 0;
  public static final String d = ".png";
  public static final String e = ".zip";
  public static final String f = "mvip.pt.vipzx.xgn_ptv_qfzf_";
  public static final String g = "bless" + File.separator;
  public static final String h = "bless_uin_to_send";
  public static final String i = "bless_send_wording";
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private BlessTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  private BlessUinList jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile boolean jdField_d_of_type_Boolean;
  public String j;
  public String k;
  private String l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BlessManager.class.getSimpleName();
  }
  
  public BlessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = AppConstants.bj + g;
    this.j = paramQQAppInterface;
    BlessPtvModule.path = paramQQAppInterface;
    this.k = (this.j + File.separator + "history" + File.separator + "ptvHistory");
    h();
    g();
  }
  
  public static Date a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void a(BlessPtvModule paramBlessPtvModule, String paramString)
  {
    int m = NetworkUtil.a(BaseApplicationImpl.a());
    if ((m == 2) || (m == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "download 2g give up " + paramString);
      }
    }
    do
    {
      return;
      localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localDownloadTask == null) {
        break label154;
      }
      if ((localDownloadTask.a() != 2) && (localDownloadTask.a() != 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "download duplicated " + paramString);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "download task status error, cancel it " + paramString);
    }
    localDownloadTask.a(true);
    label154:
    DownloadTask localDownloadTask = new DownloadTask(paramBlessPtvModule.data, new File(paramString));
    localDownloadTask.l = true;
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "start download " + paramBlessPtvModule.id);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localDownloadTask);
    localDownloaderInterface.a(localDownloadTask, new oft(this, paramString, paramBlessPtvModule), null);
  }
  
  private void a(BlessTask paramBlessTask)
  {
    if (paramBlessTask == null) {}
    String[] arrayOfString;
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfString = new String[7];
      arrayOfString[0] = paramBlessTask.mainBanner;
      arrayOfString[1] = paramBlessTask.mainCenter;
      arrayOfString[2] = paramBlessTask.typeBanner;
      arrayOfString[3] = paramBlessTask.succeededBanner;
      arrayOfString[4] = paramBlessTask.defaultVoice;
      arrayOfString[5] = paramBlessTask.starAvator;
      arrayOfString[6] = paramBlessTask.starVideo;
      arrayOfFile = new File(this.j).listFiles();
    } while (arrayOfFile == null);
    int i1 = 0;
    label93:
    if (i1 < arrayOfFile.length) {
      if ((!arrayOfFile[i1].getName().endsWith(".zip")) && (!arrayOfFile[i1].isDirectory())) {
        break label137;
      }
    }
    label137:
    label143:
    label431:
    for (;;)
    {
      i1 += 1;
      break label93;
      break;
      int i2 = 0;
      int m = 0;
      Object localObject;
      if (i2 < arrayOfString.length)
      {
        String str = a(arrayOfString[i2]);
        n = m;
        localObject = str;
        if (!TextUtils.isEmpty(arrayOfString[i2]))
        {
          n = m;
          localObject = str;
          if (arrayOfString[i2].equals(paramBlessTask.starVideo))
          {
            localObject = MD5Utils.b(arrayOfString[i2]);
            n = 1;
          }
        }
        if (arrayOfFile[i1].getName().equals(localObject))
        {
          i2 = 0;
          m = n;
        }
      }
      for (int n = i2;; n = 1)
      {
        if (n == 0) {
          break label431;
        }
        arrayOfFile[i1].delete();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteOldBanner=" + arrayOfFile[i1].getName());
        }
        if (m == 0) {
          break;
        }
        localObject = this.j + paramBlessTask.starVideoCoverFolderName + File.separator;
        localObject = new File((String)localObject + paramBlessTask.starVideoCoverFileName);
        if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
          break;
        }
        ((File)localObject).delete();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteOldCover=" + ((File)localObject).getName());
        break;
        i2 += 1;
        m = n;
        break label143;
      }
    }
  }
  
  private void a(BlessTask paramBlessTask, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        localEntityManager.a(BlessTask.class);
        if (paramBlessTask != null) {
          localEntityManager.b(paramBlessTask);
        }
        localEntityManager.a(BlessPtvModule.class);
        if (paramArrayList1 != null)
        {
          paramBlessTask = paramArrayList1.iterator();
          if (paramBlessTask.hasNext())
          {
            localEntityManager.b((BlessPtvModule)paramBlessTask.next());
            continue;
          }
        }
      }
      catch (Exception paramBlessTask)
      {
        paramBlessTask.printStackTrace();
        localEntityTransaction.b();
        return;
        localEntityManager.a(BlessWording.class);
        if (paramArrayList2 != null)
        {
          paramBlessTask = paramArrayList2.iterator();
          if (paramBlessTask.hasNext())
          {
            localEntityManager.b((BlessWording)paramBlessTask.next());
            continue;
          }
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "save task and modules to db");
      }
      localEntityTransaction.b();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refresh recent");
      }
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  private void a(RecentUserProxy paramRecentUserProxy)
  {
    RecentUser localRecentUser = paramRecentUserProxy.a(AppConstants.aU, 9003);
    long l1 = NetConnInfoCenter.getServerTime();
    localRecentUser.uin = AppConstants.aU;
    localRecentUser.type = 9003;
    if (localRecentUser.lastmsgtime < l1) {
      localRecentUser.lastmsgtime = l1;
    }
    paramRecentUserProxy.a(localRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser)
  {
    paramRecentUserProxy.b(paramRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int m = NetworkUtil.a(BaseApplicationImpl.a());
    if ((m == 2) || (m == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "download 2g give up " + paramString2);
      }
    }
    do
    {
      return;
      localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
      if (localDownloadTask == null) {
        break label154;
      }
      if ((localDownloadTask.a() != 2) && (localDownloadTask.a() != 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "download duplicated " + paramString2);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "download task status error, cancel it " + paramString2);
    }
    localDownloadTask.a(true);
    label154:
    DownloadTask localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.l = true;
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownload: " + paramString1 + " path=" + paramString2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localDownloadTask);
    localDownloaderInterface.a(localDownloadTask, new ofu(this, paramString2, paramString1), null);
  }
  
  private boolean a(BlessTask paramBlessTask)
  {
    if (paramBlessTask == null) {
      return false;
    }
    String[] arrayOfString = new String[7];
    arrayOfString[0] = paramBlessTask.mainBanner;
    arrayOfString[1] = paramBlessTask.mainCenter;
    arrayOfString[2] = paramBlessTask.typeBanner;
    arrayOfString[3] = paramBlessTask.succeededBanner;
    arrayOfString[4] = paramBlessTask.defaultVoice;
    arrayOfString[5] = paramBlessTask.starAvator;
    arrayOfString[6] = paramBlessTask.starVideo;
    int i1 = arrayOfString.length;
    int m = 0;
    boolean bool2 = true;
    String str2;
    String str1;
    if (m < i1)
    {
      str2 = arrayOfString[m];
      str1 = a(str2);
      if ((TextUtils.isEmpty(str2)) || (!str2.equals(paramBlessTask.starVideo))) {
        break label381;
      }
      str1 = MD5Utils.b(str2);
      paramBlessTask.ex1 = str1;
    }
    label372:
    label381:
    for (int n = 1;; n = 0)
    {
      if (str1 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBannersReady error banner: " + str2);
        return false;
      }
      str1 = this.j + str1;
      boolean bool1;
      if (!new File(str1).exists())
      {
        a(str2, str1);
        if (!QLog.isColorLevel()) {
          break label372;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBannersReady no banner: " + str1);
        bool1 = false;
      }
      for (;;)
      {
        m += 1;
        bool2 = bool1;
        break;
        bool1 = bool2;
        if (n != 0)
        {
          str2 = this.j + paramBlessTask.starVideoCoverFolderName + File.separator + paramBlessTask.starVideoCoverFileName;
          bool1 = bool2;
          if (VersionUtils.d())
          {
            bool1 = bool2;
            if (!new File(str2).exists())
            {
              j();
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "checkAllDownloaded no cover: " + str1);
              }
              bool1 = false;
            }
          }
        }
      }
      return bool2;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Date localDate1 = a(paramString1);
    Date localDate2 = a(paramString2);
    if ((localDate1 == null) || (localDate2 == null)) {}
    do
    {
      return false;
      if ((l1 > localDate1.getTime()) && (l1 < localDate2.getTime())) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "not in time" + paramString1 + " " + paramString2);
    return false;
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (!e())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkModulesReady not enable ptv");
      }
      return true;
    }
    paramArrayList = paramArrayList.iterator();
    boolean bool = true;
    if (paramArrayList.hasNext())
    {
      BlessPtvModule localBlessPtvModule = (BlessPtvModule)paramArrayList.next();
      String str = localBlessPtvModule.id + ".zip";
      str = this.j + str;
      if (new File(str).exists())
      {
        Object localObject2 = this.j + localBlessPtvModule.id + File.separator + localBlessPtvModule.id + ".png";
        Object localObject3 = this.j + localBlessPtvModule.id + File.separator + localBlessPtvModule.id + ".m4a";
        Object localObject1 = this.j + localBlessPtvModule.id + File.separator + localBlessPtvModule.id + ".qrc";
        localObject2 = new File((String)localObject2);
        localObject3 = new File((String)localObject3);
        localObject1 = new File((String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject3).exists()) || (!((File)localObject1).exists()) || (localBlessPtvModule.broken))
        {
          a(localBlessPtvModule, true);
          a(localBlessPtvModule, str);
          localBlessPtvModule.broken = false;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkModulesReady broken zip: " + localBlessPtvModule.id);
          }
        }
      }
      for (bool = false;; bool = false)
      {
        break;
        a(localBlessPtvModule, str);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkModulesReady no zip: " + localBlessPtvModule.id);
        }
      }
    }
    return bool;
  }
  
  private void b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = new File(this.j).listFiles();
    } while (arrayOfFile == null);
    int n = 0;
    label27:
    if (n < arrayOfFile.length) {
      if ((arrayOfFile[n].getName().endsWith(".zip")) && (!arrayOfFile[n].isDirectory())) {
        break label68;
      }
    }
    label68:
    label76:
    label253:
    for (;;)
    {
      n += 1;
      break label27;
      break;
      String str1 = null;
      Iterator localIterator = paramArrayList.iterator();
      int m;
      if (localIterator.hasNext())
      {
        BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
        str1 = localBlessPtvModule.id;
        String str2 = localBlessPtvModule.id + ".zip";
        if (arrayOfFile[n].getName().equals(str2)) {
          if (localBlessPtvModule.broken)
          {
            localBlessPtvModule.broken = false;
            m = 1;
          }
        }
      }
      for (;;)
      {
        if (m == 0) {
          break label253;
        }
        arrayOfFile[n].delete();
        FileUtils.a(this.j + str1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteOldModules=" + arrayOfFile[n].getName());
        break;
        m = 0;
        continue;
        break label76;
        m = 1;
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = true;
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.aU, 9003);
    int m;
    label96:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      m = 1;
      if ((m == 0) || (!c()) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted)) {
        break label212;
      }
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("initEntrance show=").append(bool).append(" hasConfig=").append(paramBoolean).append(" task=").append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask).append(" isDeleted=");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) {
          break label218;
        }
        localObject = "";
        label167:
        QLog.d(str, 2, localObject);
      }
      if (!bool) {
        break label257;
      }
      if (localRecentUser != null) {
        break label232;
      }
      a(localRecentUserProxy);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew = false;
    }
    label212:
    label218:
    label232:
    label257:
    while (localRecentUser == null) {
      for (;;)
      {
        return;
        m = 0;
        break;
        bool = false;
        break label96;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted);
        break label167;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew)
        {
          a(localRecentUserProxy, localRecentUser);
          a(localRecentUserProxy);
        }
      }
    }
    a(localRecentUserProxy, localRecentUser);
  }
  
  public static int g()
  {
    if (jdField_d_of_type_Int <= 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (jdField_d_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; jdField_d_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return jdField_d_of_type_Int;
    }
  }
  
  private void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList = BlessUinList.a((SharedPreferences)localObject1);
    Object localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "bless_uin_to_send", null);
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList((Collection)localObject2);
      this.l = ((SharedPreferences)localObject1).getString("bless_send_wording", null);
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("initUinSendRecordFromSp sendWording=").append(this.l).append(" uinListToSend=");
        if (this.jdField_c_of_type_JavaUtilArrayList != null) {
          break label151;
        }
        localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
        label102:
        localStringBuilder = localStringBuilder.append(localObject1).append(" blessUinList=");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList != null) {
          break label165;
        }
      }
    }
    label151:
    label165:
    for (localObject1 = null;; localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a()))
    {
      QLog.d((String)localObject2, 2, localObject1);
      return;
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      break;
      localObject1 = Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size());
      break label102;
    }
  }
  
  private void h()
  {
    boolean bool2 = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject2 = (ArrayList)((EntityManager)localObject1).a(BlessTask.class, new BlessTask().getTableName(), false, null, null, null, null, null, null);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)((ArrayList)localObject2).get(0));
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((EntityManager)localObject1).a(BlessPtvModule.class, new BlessPtvModule().getTableName(), false, null, null, null, null, null, null));
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)((EntityManager)localObject1).a(BlessWording.class, new BlessWording().getTableName(), false, null, null, null, null, null, null));
    ((EntityManager)localObject1).a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("initTaskAndModuleFromDB task=").append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask).append(" blessWordings=").append(this.jdField_b_of_type_JavaUtilArrayList).append(" module=");
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label274;
      }
    }
    label274:
    for (localObject1 = this.jdField_a_of_type_JavaUtilArrayList;; localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      QLog.d((String)localObject2, 2, localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
        break;
      }
      this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_d_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      boolean bool1 = bool2;
      if (this.jdField_c_of_type_Boolean)
      {
        bool1 = bool2;
        if (this.jdField_d_of_type_Boolean) {
          bool1 = true;
        }
      }
      d(bool1);
      return;
    }
    d(false);
  }
  
  private void i()
  {
    int i1 = 0;
    Object localObject2;
    int m;
    Object localObject1;
    int n;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      localObject2 = new String[7];
      localObject2[0] = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner;
      localObject2[1] = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter;
      localObject2[2] = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.typeBanner;
      localObject2[3] = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner;
      localObject2[4] = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultVoice;
      localObject2[5] = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator;
      localObject2[6] = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo;
      m = 0;
      if (m >= localObject2.length) {
        break label801;
      }
      localObject1 = a(localObject2[m]);
      if ((TextUtils.isEmpty(localObject2[m])) || (!localObject2[m].equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo))) {
        break label795;
      }
      localObject1 = MD5Utils.b(localObject2[m]);
      n = 1;
      label151:
      if (localObject1 == null) {
        d(false);
      }
    }
    else
    {
      label160:
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = this.j + (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if (!new File((String)localObject1).exists())
        {
          if (!QLog.isColorLevel()) {
            break label789;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkAllDownloaded no banner: " + (String)localObject1);
          m = 0;
        }
      }
    }
    for (;;)
    {
      label247:
      Object localObject3;
      if ((m != 0) && (e()))
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject4 = (BlessPtvModule)((Iterator)localObject1).next();
            localObject2 = ((BlessPtvModule)localObject4).id + ".zip";
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (new File(this.j + (String)localObject2).exists()))
            {
              Object localObject5 = this.j + ((BlessPtvModule)localObject4).id + File.separator + ((BlessPtvModule)localObject4).id + ".png";
              localObject3 = this.j + ((BlessPtvModule)localObject4).id + File.separator + ((BlessPtvModule)localObject4).id + ".m4a";
              localObject4 = this.j + ((BlessPtvModule)localObject4).id + File.separator + ((BlessPtvModule)localObject4).id + ".qrc";
              localObject5 = new File((String)localObject5);
              localObject3 = new File((String)localObject3);
              localObject4 = new File((String)localObject4);
              if ((!((File)localObject5).exists()) || (!((File)localObject3).exists()) || (!((File)localObject4).exists()))
              {
                m = i1;
                if (QLog.isColorLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "checkModulesReady no module: " + (String)localObject2);
                  m = i1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        n = m;
        for (;;)
        {
          if (n == 0) {
            break label784;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "check Modules and banners all ready");
          }
          if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
            break label160;
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_c_of_type_Boolean = true;
          d(true);
          return;
          if (n != 0)
          {
            localObject3 = this.j + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
            if ((VersionUtils.d()) && (!new File((String)localObject3).exists()))
            {
              if (!QLog.isColorLevel()) {
                break label789;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "checkAllDownloaded no cover: " + (String)localObject1);
              m = 0;
              break label247;
            }
          }
          m += 1;
          break;
          n = m;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkModulesReady not enable ptv");
            n = m;
          }
        }
        label784:
        break label160;
      }
      label789:
      m = 0;
      continue;
      label795:
      n = 0;
      break label151;
      label801:
      m = 1;
    }
  }
  
  private boolean i()
  {
    String str1 = h();
    String str2 = g();
    if ((str1 == null) || (str2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isStarVideoFileReady() videoCoverPath=" + str1 + ", videoPath=" + str2);
      }
      return false;
    }
    return true;
  }
  
  private void j()
  {
    if ((VersionUtils.d()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.a(new ofv(this), 5, null, false);
    }
  }
  
  public int a()
  {
    int m = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      m = -1;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread > 1) {
      return m;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread;
  }
  
  public Drawable a()
  {
    Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130837988);
    if (!h()) {}
    do
    {
      return localDrawable;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        String str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator);
        if (!TextUtils.isEmpty(str))
        {
          str = this.j + str;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          int m = AIOUtils.a(50.0F, BaseApplication.getContext().getResources());
          localURLDrawableOptions.mRequestHeight = m;
          localURLDrawableOptions.mRequestWidth = m;
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
        }
      }
    } while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null);
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public BlessTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  }
  
  public MessageForShortVideo a()
  {
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getPtvMessage: " + localMessageForShortVideo);
    }
    return localMessageForShortVideo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner);
    } while (str == null);
    return this.j + File.separator + str;
  }
  
  public String a(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.startsWith("http://"))
      {
        str1 = paramString.substring("http://".length(), paramString.length());
        int m = str1.lastIndexOf('/');
        if (m == -1) {
          return null;
        }
        str1 = str1.substring(m + 1);
        return str1;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getFileNameFromUrl failed: " + paramString);
      }
      String str2 = null;
      return str2;
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", new String[0]).commit();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {}
    int m;
    do
    {
      return;
      m = paramInt1;
      if (paramInt2 == this.jdField_b_of_type_JavaUtilArrayList.size() + 1) {
        m = paramInt1 - 1;
      }
    } while ((m < 0) || (m >= this.jdField_b_of_type_JavaUtilArrayList.size()));
    ((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(m)).setEditingWording(paramString);
  }
  
  public void a(BlessPtvModule paramBlessPtvModule, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteOneModuleFile " + paramBlessPtvModule.id + " del zip=" + paramBoolean);
    }
    FileUtils.a(this.j + paramBlessPtvModule.id);
    if (paramBoolean) {
      FileUtils.d(this.j + paramBlessPtvModule.id + ".zip");
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setPtvMessage: " + paramMessageForShortVideo);
    }
  }
  
  public void a(String paramString)
  {
    BlessTask localBlessTask = new BlessTask();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    boolean bool = BlessTask.parse(paramString, localBlessTask, localArrayList1, localArrayList2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNewConfigReceived newTask=" + localBlessTask + " newBlessWordings=" + localArrayList2.size() + " module=" + localArrayList1.size() + " result=" + bool);
    }
    if (!bool)
    {
      a(null, null, null);
      d(false);
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label241;
        }
        localObject = (BlessPtvModule)paramString.next();
        Iterator localIterator = localArrayList1.iterator();
        if (localIterator.hasNext())
        {
          BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
          if (!((BlessPtvModule)localObject).id.equals(localBlessPtvModule.id)) {
            break;
          }
          if (((BlessPtvModule)localObject).data.equals(localBlessPtvModule.data)) {
            localBlessPtvModule.broken = ((BlessPtvModule)localObject).broken;
          } else {
            localBlessPtvModule.broken = true;
          }
        }
      }
    }
    label241:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null)
    {
      paramString = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo);
      localObject = a(localBlessTask.starVideo);
      if ((paramString != null) && (paramString.equals(localObject))) {
        localBlessTask.videoPlayed = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed;
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!TextUtils.isEmpty(localBlessTask.starAvator)) && (!localBlessTask.starAvator.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator))) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = localBlessTask;
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
    this.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
    b(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_d_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {}
    for (bool = true;; bool = false)
    {
      d(bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.b();
      BlessUinList.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences(), this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList);
      a(localBlessTask, localArrayList1, localArrayList2);
      return;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(str);
    }
    BlessUinList.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences(), this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList);
  }
  
  public void a(List paramList)
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.addAll(paramList);
    SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", paramList.toArray()).commit();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(AppConstants.aU, 9003) != null;
  }
  
  public boolean a(BlessPtvModule paramBlessPtvModule)
  {
    if (paramBlessPtvModule == null) {
      return false;
    }
    try
    {
      String str = this.j + paramBlessPtvModule.id + ".zip";
      a(paramBlessPtvModule, false);
      FileUtils.a(str, this.j + paramBlessPtvModule.id + File.separator, false);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "un compressZip success: " + str);
      }
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "un compressZip failed: " + localException.getMessage());
      }
      a(paramBlessPtvModule, true);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(paramString);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getHistory blessPTVMsg: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      }
      arrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData;
    }
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1 == null)
    {
      arrayOfByte1 = FileUtils.a(this.k);
      arrayOfByte2 = arrayOfByte1;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getHistory readFile: " + this.k);
        arrayOfByte2 = arrayOfByte1;
      }
    }
    return arrayOfByte2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread < 1) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getUnreadNum=1");
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter);
    } while (str == null);
    return this.j + File.separator + str;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.l)) {
      localArrayList.add(this.l);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BlessWording localBlessWording = (BlessWording)localIterator.next();
        if (localBlessWording.hasEditingWording()) {
          localArrayList.add(localBlessWording.getEditingWording());
        } else {
          localArrayList.add(localBlessWording.wording);
        }
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((BlessWording)localIterator.next()).setEditingWording(null);
      }
    }
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        str = paramString;
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          str = paramString;
          if (paramString.equals(((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(0)).wording)) {
            str = "";
          }
        }
      }
    } while ((this.l != null) && (this.l.equals(str)));
    this.l = str;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramString.putString("bless_send_wording", str);
    paramString.commit();
  }
  
  public void b(List paramList)
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.addAll(paramList);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread == 0) {}
      }
      else {
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "update task to db read=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread + " videoPlayed=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread = -1;
          EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          localEntityTransaction = localEntityManager.a();
          try
          {
            localEntityTransaction.a();
            localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
            localEntityTransaction.c();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              localEntityTransaction.b();
            }
          }
          finally
          {
            localEntityTransaction.b();
          }
          localEntityManager.a();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed = true;
        }
      }
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {}
    for (int m = 1; (m != 0) && (c()) && (this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean); m = 0) {
      return true;
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.uinTotalLimit;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.typeBanner);
    } while (str == null);
    return this.j + File.separator + str;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size() + 2);
    Object localObject = new BlessPtvModule();
    ((BlessPtvModule)localObject).setDefaultModule(f());
    ((BlessPtvModule)localObject).id = "0";
    ((BlessPtvModule)localObject).title = "原创";
    ((BlessPtvModule)localObject).vipLevel = "0";
    ((BlessPtvModule)localObject).audioLength = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultVoiceLength;
    ((BlessPtvModule)localObject).shareTitle = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultShareTitle;
    localArrayList.add(localObject);
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((BlessPtvModule)((Iterator)localObject).next());
    }
    return localArrayList;
  }
  
  public void c()
  {
    EntityManager localEntityManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "update task to db isDeleted");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted = true;
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localEntityTransaction = localEntityManager.a();
    }
    try
    {
      localEntityTransaction.a();
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localEntityTransaction.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityManager.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPushCmd: " + paramBoolean);
    }
    if (paramBoolean) {
      c();
    }
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnd)) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnabled == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return c() - this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner);
    } while (str == null);
    return this.j + File.separator + str;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "check entrance.");
    }
    if (!c())
    {
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.aU, 9003);
      if (localRecentUser != null) {
        a(localRecentUserProxy, localRecentUser);
      }
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starEnd);
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.sendTotalLimit;
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceHint;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveHistory blessPTVMsg: " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
      byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData;
      if (arrayOfByte != null) {
        FileUtils.a(arrayOfByte, this.k);
      }
    }
  }
  
  public boolean e()
  {
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.BlessPTVEnable.name()).equals("1");
    boolean bool3 = VideoEnvironment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool4 = VideoEnvironment.c();
    boolean bool5 = VcSystemInfo.g();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isPTVEnabled task=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled + " ptvRecord=" + bool3 + " isX86=" + bool4 + " frontCamera=" + true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled == 1) && (bool3) && (!bool4) && (bool5) && (!bool2)) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public int f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    int n = e();
    int m = n;
    if (n > 0) {
      m = n - this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.b();
    }
    return m;
  }
  
  public String f()
  {
    return this.j + a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultVoice);
  }
  
  public void f()
  {
    ThreadManager.a(new ofw(this), 5, null, true);
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled != 1) {
      return true;
    }
    return false;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.j + a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ex1);
      File localFile = new File(str);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getStarVideoPath: " + str);
      }
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getStarVideoPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.j + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
      if (new File(str).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getStartVideoCoverPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while ((!VersionUtils.d()) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed) || (!d()) || (!i())) {
      return false;
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */