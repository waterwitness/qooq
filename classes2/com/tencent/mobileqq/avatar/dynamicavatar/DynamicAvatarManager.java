package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.FaceManager;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import qsd;
import qse;
import qsf;
import qsg;
import qsh;
import qsi;
import qsj;
import qsk;
import qsl;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarManager
  implements Manager
{
  public static final int a = 1000;
  public static final int b = 86400;
  public static final int c = 5;
  public static final int d = 20;
  public static int e = 8;
  private Resources jdField_a_of_type_AndroidContentResResources;
  public SparseArray a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  DeviceProfileManager.DPCObserver jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver = new qsd(this);
  private DynamicAvatarConfig jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback = new qsi(this);
  public DynamicAvatarDownloadManager a;
  private DynamicAvatarInfoObserver jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver = new qsf(this);
  public Runnable a;
  public String a;
  public ArrayList a;
  public ConcurrentHashMap a;
  public Executor a;
  public boolean a;
  public String b;
  public ArrayList b;
  public ArrayList c;
  public ArrayList d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DynamicAvatarManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaLangRunnable = new qsl(this);
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "new DynamicAvatarManager param app is null.");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver, true);
    this.d = new ArrayList();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = new DynamicAvatarDownloadManager(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback);
    paramAppInterface = new ThreadPoolParams();
    paramAppInterface.a = "dynamic_avatar";
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.a(paramAppInterface);
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    a();
    e = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.b;
    DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver);
  }
  
  private Setting a(int paramInt, String paramString)
  {
    Object localObject2 = null;
    if (paramInt == 18)
    {
      paramString = "stranger_" + Integer.toString(paramInt) + "_" + paramString;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface)) {
        localObject1 = ((FaceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(215)).a(paramString);
      }
    }
    do
    {
      do
      {
        do
        {
          return (Setting)localObject1;
          localObject1 = localObject2;
        } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface));
        return ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a(true).a(paramString);
        localObject1 = localObject2;
      } while ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface));
      localObject1 = localObject2;
    } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface));
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    paramString = (Setting)((EntityManager)localObject1).a(Setting.class, paramString);
    ((EntityManager)localObject1).a();
    return paramString;
  }
  
  public static String a(int paramInt1, int paramInt2, DynamicAvatar paramDynamicAvatar)
  {
    Object localObject;
    if (paramDynamicAvatar == null) {
      localObject = null;
    }
    do
    {
      String str;
      do
      {
        do
        {
          return (String)localObject;
          str = "";
          if (paramInt1 != 17) {
            break;
          }
          if (paramInt2 == 100) {
            return paramDynamicAvatar.basicSmallUrl;
          }
          if (paramInt2 == 200) {
            return paramDynamicAvatar.basicMiddleUrl;
          }
          localObject = str;
        } while (paramInt2 != 640);
        return paramDynamicAvatar.basicBigUrl;
        localObject = str;
      } while (paramInt1 != 18);
      if (paramInt2 == 100) {
        return paramDynamicAvatar.nearbySmallUrl;
      }
      if (paramInt2 == 200) {
        return paramDynamicAvatar.nearbyMiddleUrl;
      }
      localObject = str;
    } while (paramInt2 != 640);
    return paramDynamicAvatar.nearbyBigUrl;
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean)
  {
    if (paramDynamicFaceDrawable == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDynamicFaceDrawable.j).append("_").append(paramDynamicFaceDrawable.k).append("_").append(paramDynamicFaceDrawable.jdField_b_of_type_JavaLangString);
    if ((paramBoolean) || ((paramDynamicFaceDrawable.jdField_e_of_type_Boolean) && (!TextUtils.isEmpty(paramDynamicFaceDrawable.c)))) {
      localStringBuilder.append("_").append(paramDynamicFaceDrawable.c);
    }
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    for (;;)
    {
      int j;
      synchronized (this.c)
      {
        j = this.c.size() - 1;
        if (j >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.c.get(j);
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            this.c.remove(j);
          } else if (paramString1.equals(((DynamicFaceDrawable)localWeakReference.get()).jdField_e_of_type_JavaLangString)) {
            if (TextUtils.isEmpty(paramString2))
            {
              ((DynamicFaceDrawable)localWeakReference.get()).jdField_a_of_type_ComTencentImageURLDrawable = null;
              ((DynamicFaceDrawable)localWeakReference.get()).a();
              this.c.remove(j);
            }
            else if ((((DynamicFaceDrawable)localWeakReference.get()).jdField_a_of_type_MqqUtilWeakReference.get() != null) && (paramString2.equals(((DynamicAvatarView)((DynamicFaceDrawable)localWeakReference.get()).jdField_a_of_type_MqqUtilWeakReference.get()).a)))
            {
              this.c.remove(localWeakReference);
            }
            else
            {
              ((DynamicFaceDrawable)((WeakReference)this.c.get(j)).get()).c = paramString2;
              ((DynamicFaceDrawable)((WeakReference)this.c.get(j)).get()).d = paramString3;
              i = 1;
            }
          }
        }
        else
        {
          if (i != 0) {
            a(paramString2);
          }
          return;
        }
      }
      j -= 1;
    }
  }
  
  public static String b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    int i = 18;
    if (paramInt2 == 200)
    {
      paramInt2 = 17;
      if (paramInt1 != 32) {
        break label37;
      }
    }
    label37:
    for (paramInt1 = i;; paramInt1 = 17)
    {
      return a(paramInt1, paramInt2, paramString, paramInt3);
      paramInt2 = 18;
      break;
    }
  }
  
  private boolean b(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar == null) || (paramSetting == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo dynamicAvatrInfo or setting info is null.");
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          long l = System.currentTimeMillis() / 1000L;
          if ((l - paramDynamicAvatar.getTimeStamp >= 0L) && (l - paramDynamicAvatar.getTimeStamp < 86400L)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo beyond 24h, stamp: " + paramDynamicAvatar.getTimeStamp);
        return true;
        if (paramInt != 17) {
          break;
        }
        if ((paramDynamicAvatar.getTimeStamp + 5 >= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.basicSetTimeStamp + 5) * 1000 >= paramSetting.updateTimestamp)) {
          break label331;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
      return true;
      if ((paramInt != 18) || (paramDynamicAvatar.getTimeStamp + 5 >= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.nearbySetTimeStamp + 5) * 1000 >= paramSetting.updateTimestamp)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "isNeed2GetDynamicAvatarInfo: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
    return true;
    label331:
    return false;
  }
  
  public DynamicAvatarConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig == null) {
      a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.dynamicAvatar", 2, "getConfig DynamicAvatarConfig|" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig;
  }
  
  public DynamicAvatarDownloadManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  }
  
  public DynamicAvatar a(int paramInt, String paramString)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        localObject1 = (DynamicAvatar)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("getDynamicAvatarInfo cache is null: ");
          if (localObject1 != null) {
            break label177;
          }
          bool1 = true;
          QLog.i("Q.dynamicAvatar", 2, bool1);
          localObject2 = localObject1;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = b(paramInt, paramString);
        localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        if (localObject1 == null) {}
      }
    }
    for (;;)
    {
      label177:
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("db find dynamic avatarInfo is null: ");
          if (localObject1 != null) {
            break label218;
          }
          bool1 = bool2;
          QLog.i("Q.dynamicAvatar", 2, bool1);
        }
        return (DynamicAvatar)localObject1;
      }
      finally {}
      bool1 = false;
      break;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface))
      {
        localObject1 = ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a(paramInt, paramString);
        continue;
        label218:
        bool1 = false;
      }
    }
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig = new DynamicAvatarConfig();
    if (QLog.isColorLevel()) {
      QLog.d("Q.dynamicAvatar", 2, "DynamicAvatarConfig|init config:" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig + ",costTime:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public void a(DynamicAvatarInfo paramDynamicAvatarInfo)
  {
    if (paramDynamicAvatarInfo == null) {}
    while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    localEntityManager.a().a();
    for (;;)
    {
      try
      {
        localCursor = localEntityManager.a(false, DynamicAvatar.class.getSimpleName(), null, null, null, null, null, null, null);
        if (localCursor != null) {}
        try
        {
          int i = localCursor.getCount();
          localCursor.moveToFirst();
          if (i >= 1000)
          {
            if (i > 333)
            {
              localCursor.moveToNext();
              i -= 1;
              continue;
            }
            i = localCursor.getInt(localCursor.getColumnIndex("_id"));
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("delete from ");
            ((StringBuilder)localObject1).append(DynamicAvatar.class.getSimpleName());
            ((StringBuilder)localObject1).append(" where ");
            ((StringBuilder)localObject1).append("_id");
            ((StringBuilder)localObject1).append(" < ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(";");
            localEntityManager.b(((StringBuilder)localObject1).toString());
          }
          if ((paramDynamicAvatarInfo == null) || (paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
            continue;
          }
          paramDynamicAvatarInfo = paramDynamicAvatarInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!paramDynamicAvatarInfo.hasNext()) {
            continue;
          }
          localObject1 = DynamicAvatar.convertFrom((DynamicAvatarInfo.OneUinHeadInfo)paramDynamicAvatarInfo.next());
          if (localObject1 == null) {
            continue;
          }
          ??? = (DynamicAvatar)localEntityManager.a(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(((DynamicAvatar)localObject1).uin) });
          if (??? != null)
          {
            ((DynamicAvatar)localObject1).setStatus(((DynamicAvatar)???).getStatus());
            ((DynamicAvatar)localObject1).setId(((DynamicAvatar)???).getId());
          }
          if (((DynamicAvatar)localObject1).getStatus() != 1000) {
            continue;
          }
          localEntityManager.b((Entity)localObject1);
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200)
            {
              Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
              i = 0;
              if (localIterator.hasNext())
              {
                localIterator.remove();
                int j = i + 1;
                i = j;
                if (j < 100) {
                  continue;
                }
              }
            }
            if (((DynamicAvatar)localObject1).uin > 0L) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(((DynamicAvatar)localObject1).uin), localObject1);
            }
            if (((DynamicAvatar)localObject1).tinyId > 0L) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(((DynamicAvatar)localObject1).tinyId), localObject1);
            }
          }
          if (localCursor == null) {
            continue;
          }
        }
        finally {}
      }
      finally
      {
        Object localObject1;
        Cursor localCursor = null;
        continue;
      }
      localCursor.close();
      localEntityManager.a().b();
      localEntityManager.a();
      throw paramDynamicAvatarInfo;
      localEntityManager.a((Entity)localObject1);
    }
    localEntityManager.a().c();
    if (localCursor != null) {
      localCursor.close();
    }
    localEntityManager.a().b();
    localEntityManager.a();
  }
  
  public void a(DynamicAvatar paramDynamicAvatar)
  {
    EntityManager localEntityManager;
    DynamicAvatar localDynamicAvatar;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
      localDynamicAvatar = (DynamicAvatar)localEntityManager.a(DynamicAvatar.class, "uin=?", new String[] { String.valueOf(paramDynamicAvatar.uin) });
      if (localDynamicAvatar != null)
      {
        paramDynamicAvatar.setStatus(localDynamicAvatar.getStatus());
        paramDynamicAvatar.setId(localDynamicAvatar.getId());
      }
      if (paramDynamicAvatar.getStatus() != 1000) {
        break label120;
      }
      localEntityManager.b(paramDynamicAvatar);
    }
    for (;;)
    {
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "updateDynamicAvatarInfo: avatarInfo is : " + localDynamicAvatar);
      }
      return;
      label120:
      localEntityManager.a(paramDynamicAvatar);
    }
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    synchronized (this.d)
    {
      this.d.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      this.b.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      synchronized (this.c)
      {
        this.c.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
        return;
      }
      paramDynamicFaceDrawable = finally;
      throw paramDynamicFaceDrawable;
    }
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean)
  {
    if (paramDynamicFaceDrawable == null) {
      return;
    }
    if (paramBoolean)
    {
      String str = a(paramDynamicFaceDrawable, false);
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.m);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramDynamicFaceDrawable.m, localArrayList1);
      }
      localArrayList1.add(str);
      localArrayList1.add(a(paramDynamicFaceDrawable, true));
      if ((paramDynamicFaceDrawable.m == 1) || (paramDynamicFaceDrawable.m == 0)) {
        ThreadManager.a(new qsj(this, paramDynamicFaceDrawable, System.currentTimeMillis()), 5, null, true);
      }
      if (paramDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
        ((DynamicAvatarView)paramDynamicFaceDrawable.jdField_a_of_type_MqqUtilWeakReference.get()).a = "";
      }
    }
    ThreadManager.a(new qsk(this, paramDynamicFaceDrawable), null, true);
  }
  
  public void a(DynamicFaceDrawable paramDynamicFaceDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.c.size() < e) || (paramBoolean1))
    {
      String str = paramDynamicFaceDrawable.jdField_e_of_type_JavaLangString;
      this.c.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      if (!paramBoolean1) {}
      for (;;)
      {
        long l1;
        synchronized (this.d)
        {
          this.d.remove(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
          ??? = new qsg(this, paramDynamicFaceDrawable, str);
          if (!paramBoolean2)
          {
            l1 = 0L;
            long l2 = l1;
            if (DeviceInfoUtil.b() <= 2) {
              l2 = l1 * 2L;
            }
            ThreadManager.b().postDelayed(new qsh(this, (Runnable)???), l2);
            return;
          }
        }
        if (paramDynamicFaceDrawable.m == 0) {
          l1 = 1500L;
        } else {
          l1 = 400L;
        }
      }
    }
    this.d.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    do
    {
      do
      {
        return;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break;
        }
        oidb_0x74b.RspBody localRspBody = new oidb_0x74b.RspBody();
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          a(DynamicAvatarInfo.a(localRspBody));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      } while (!QLog.isDevelopLevel());
      paramArrayOfByte.printStackTrace();
      return;
    } while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface));
    ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a(paramArrayOfByte);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig != null) {
      switch (paramInt)
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "isPlayDynamicAvatar|source:" + paramInt + ",isPlay:" + bool1 + "\n" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig);
      }
      return bool1;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.c;
      continue;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_d_of_type_Boolean;
      continue;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.f;
      continue;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.g;
      continue;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_e_of_type_Boolean;
      continue;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.h;
      continue;
      bool1 = true;
      continue;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.f;
    }
  }
  
  public boolean a(DynamicAvatar paramDynamicAvatar, Setting paramSetting, int paramInt)
  {
    if ((paramDynamicAvatar == null) || (paramSetting == null)) {}
    do
    {
      do
      {
        return true;
        if (paramInt != 17) {
          break;
        }
        if ((paramDynamicAvatar.getTimeStamp - 5 <= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.basicSetTimeStamp - 5) * 1000 <= paramSetting.updateTimestamp)) {
          break label242;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.dynamicAvatar", 2, "isNeed2UpdateSettingInfo basic: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
      return true;
      if ((paramInt != 18) || (paramDynamicAvatar.getTimeStamp - 5 <= paramSetting.headImgTimestamp) || ((paramDynamicAvatar.nearbySetTimeStamp - 5) * 1000 <= paramSetting.updateTimestamp)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.dynamicAvatar", 2, "isNeed2UpdateSettingInfo nearby: " + paramDynamicAvatar.getTimeStamp + " " + paramSetting.headImgTimestamp + " " + paramDynamicAvatar.basicSetTimeStamp + " " + paramSetting.updateTimestamp);
    return true;
    label242:
    return false;
  }
  
  public boolean a(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    Object localObject2;
    boolean bool1;
    if (!paramDynamicFaceDrawable.f)
    {
      localObject1 = a(paramDynamicFaceDrawable, false);
      localObject2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.m);
      if ((localObject2 != null) && (((ArrayList)localObject2).contains(localObject1)))
      {
        bool1 = false;
        return bool1;
      }
    }
    Object localObject1 = DynamicAvatarDownloadManager.a(paramDynamicFaceDrawable.c);
    int i;
    if (paramDynamicFaceDrawable.l == 640) {
      i = 640;
    }
    for (;;)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramDynamicFaceDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
      localVideoDrawableParams.mPlayVideoFrame = true;
      localVideoDrawableParams.mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarConfig.jdField_d_of_type_Int;
      localVideoDrawableParams.mVideoRoundCorner = i;
      localVideoDrawableParams.mEnableAntiAlias = true;
      localVideoDrawableParams.mEnableFilter = true;
      ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localVideoDrawableParams;
      boolean bool2 = paramDynamicFaceDrawable.a(URLDrawable.getDrawable((File)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      bool1 = bool2;
      if (paramDynamicFaceDrawable.m < 0) {
        break;
      }
      bool1 = bool2;
      if (DynamicFaceDrawable.jdField_a_of_type_ArrayOfInt.length <= paramDynamicFaceDrawable.m) {
        break;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        break;
      }
      DynamicUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "0X800711C", DynamicFaceDrawable.jdField_a_of_type_ArrayOfInt[paramDynamicFaceDrawable.m]);
      return bool2;
      if (paramDynamicFaceDrawable.l == 200) {
        i = 200;
      } else {
        i = 100;
      }
    }
  }
  
  public DynamicAvatar b(int paramInt, String paramString)
  {
    boolean bool = true;
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
      if (paramInt == 18)
      {
        localObject = "tinyId=?";
        localObject = (DynamicAvatar)localEntityManager.a(DynamicAvatar.class, (String)localObject, new String[] { paramString });
        localEntityManager.a();
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("getAvatarInfoFromDb: avatarInfo is null: ");
      if (localObject != null) {
        break label107;
      }
    }
    for (;;)
    {
      QLog.d("Q.dynamicAvatar", 2, bool);
      return (DynamicAvatar)localObject;
      localObject = "uin=?";
      break;
      label107:
      bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.b.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void b(DynamicFaceDrawable paramDynamicFaceDrawable)
  {
    if (paramDynamicFaceDrawable == null) {}
    String str;
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (ShortVideoUtils.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.dynamicAvatar", 2, "getDynamicAvatar isVideoSoLibLoaded false.");
        }
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.b().post(new qse(this));
      return;
      if (paramDynamicFaceDrawable.f) {
        break;
      }
      str = a(paramDynamicFaceDrawable, false);
      localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramDynamicFaceDrawable.m);
    } while ((localArrayList != null) && (localArrayList.contains(str)));
    if (DynamicFaceDrawable.jdField_b_of_type_Boolean)
    {
      this.d.add(paramDynamicFaceDrawable.jdField_b_of_type_MqqUtilWeakReference);
      return;
    }
    a(paramDynamicFaceDrawable, true, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.dynamicAvatar", 2, "resumeAll pausedSize: " + this.d.size() + " loadinging size: " + this.c.size() + " playing size" + this.jdField_a_of_type_JavaUtilArrayList.size() + " waiting play size: " + this.b.size());
    }
    if (DynamicFaceDrawable.jdField_b_of_type_Boolean) {
      return;
    }
    int i;
    synchronized (this.d)
    {
      i = this.d.size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference1 = (WeakReference)this.d.get(i);
        if ((localWeakReference1 != null) && (localWeakReference1.get() != null)) {
          ((DynamicFaceDrawable)localWeakReference1.get()).a();
        } else {
          this.d.remove(i);
        }
      }
    }
    int m = Math.min(e, this.d.size());
    for (;;)
    {
      Object localObject2;
      int j;
      synchronized (this.c)
      {
        int k = this.c.size();
        if (m >= e)
        {
          i = k;
          localObject2 = new ArrayList();
          j = k - 1;
          if (j >= k - i)
          {
            WeakReference localWeakReference2 = (WeakReference)this.c.remove(j);
            if ((localWeakReference2 == null) || (localWeakReference2.get() == null)) {
              break label424;
            }
            ((ArrayList)localObject2).add(((DynamicFaceDrawable)localWeakReference2.get()).c);
            break label424;
          }
        }
        else
        {
          i = k - (e - m);
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.c((ArrayList)localObject2);
        }
      }
      synchronized (this.d)
      {
        i = Math.min(this.d.size() - 1, m - 1);
        while (i >= 0)
        {
          localObject2 = (WeakReference)this.d.get(i);
          if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
          {
            a((DynamicFaceDrawable)((WeakReference)localObject2).get(), false, false);
            i -= 1;
            continue;
            localObject3 = finally;
            throw ((Throwable)localObject3);
          }
          else
          {
            this.d.remove(i);
          }
        }
      }
      return;
      i -= 1;
      break;
      label424:
      j -= 1;
    }
  }
  
  public void d() {}
  
  public void onDestroy()
  {
    DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$DPCObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.b();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarInfoObserver = null;
    this.jdField_a_of_type_JavaUtilConcurrentExecutor = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\DynamicAvatarManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */