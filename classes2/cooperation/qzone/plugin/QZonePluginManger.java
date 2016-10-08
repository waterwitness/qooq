package cooperation.qzone.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import yoe;
import yof;
import yoh;
import yoi;
import yok;
import yon;

public class QZonePluginManger
  extends IQZonePluginManager
  implements Handler.Callback, QZonePluginDownloader.OnPluginDownloadListner, QZonePluginUpdater.OnUpdateListner, Manager, yoe, yof
{
  public static final int a = 0;
  public static final String a = "patch";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static final int k = 0;
  Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QZonePluginChecker jdField_a_of_type_CooperationQzonePluginQZonePluginChecker;
  private QZonePluginDownloader jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader;
  private QZonePluginInstaller jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller;
  QZonePluginManger.LaunchState jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState;
  private QZonePluginUpdater jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater;
  Object jdField_a_of_type_JavaLangObject;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private yok jdField_a_of_type_Yok;
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public QZonePluginManger(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.a();
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater = new QZonePluginUpdater(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader = new QZonePluginDownloader(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller = new QZonePluginInstaller(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Yok = new yok(this, this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater);
    yon.a().a(paramQQAppInterface);
  }
  
  private void a(int paramInt, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + paramPluginParams.b);
    }
    if (!this.jdField_b_of_type_Boolean) {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramOnPluginReadyListener == null);
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      localObject1 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramPluginParams.b);
      if (localObject1 != null) {
        paramPluginParams.c = ((PluginRecord)localObject1).k;
      }
      paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
      return;
      if (paramInt == 1)
      {
        localObject1 = paramPluginParams.b;
        localObject2 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a((String)localObject1);
        if (localObject2 == null) {}
        for (;;)
        {
          localObject2 = new QZonePluginManger.LaunchState();
          ((QZonePluginManger.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
          ((QZonePluginManger.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams = paramPluginParams;
          ((QZonePluginManger.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          try
          {
            a((String)localObject1, new yoi(this, (QZonePluginManger.LaunchState)localObject2));
            return;
          }
          catch (RemoteException paramContext)
          {
            paramContext.printStackTrace();
            return;
          }
          localObject2 = ((PluginRecord)localObject2).f;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = paramPluginParams.b;
    Object localObject2 = new QZonePluginManger.LaunchState();
    ((QZonePluginManger.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
    ((QZonePluginManger.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams = paramPluginParams;
    ((QZonePluginManger.LaunchState)localObject2).jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
    try
    {
      a((String)localObject1, new yoi(this, (QZonePluginManger.LaunchState)localObject2));
      return;
    }
    catch (RemoteException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("pluginid", paramString);
    StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(null, "actQzonePluginPatch", true, 0L, 0L, localHashMap, null);
  }
  
  private PluginRecord b(String paramString)
  {
    if ((!QLog.isColorLevel()) || (TextUtils.isEmpty(paramString)))
    {
      paramString = null;
      return paramString;
    }
    PluginRecord localPluginRecord = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    Object localObject;
    if ((!QLog.isColorLevel()) || (localPluginRecord == null))
    {
      localObject = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramString);
      if ((!QLog.isColorLevel()) || (localObject == null))
      {
        localObject = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
        if (!QLog.isColorLevel()) {}
      }
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      return (PluginRecord)localObject;
      boolean bool = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a((PluginRecord)localObject);
      if ((!QLog.isColorLevel()) || (!bool))
      {
        paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          localObject = paramString;
          continue;
          int i = localPluginRecord.e;
          if ((i != -1) && (i != 4))
          {
            localObject = localPluginRecord;
            if (i != -2) {}
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            localObject = localPluginRecord;
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "getPluginList  pluginInfoRequesting:" + this.jdField_a_of_type_Boolean + "");
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a();
    }
  }
  
  private void b(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (paramPluginParams == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("patch", 2, "checkUpdate:" + paramPluginParams.b);
        }
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      return;
      localObject = paramPluginParams.b;
      PluginRecord localPluginRecord = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.b((String)localObject);
      if (localPluginRecord == null)
      {
        a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
      }
      boolean bool = a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "installed :" + bool);
      }
      localObject = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a((String)localObject);
      if (bool)
      {
        bool = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a((PluginRecord)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("patch", 2, "up to day :" + bool);
        }
        if (bool)
        {
          a(2, paramContext, paramPluginParams, paramOnPluginReadyListener);
          return;
        }
      }
      if ((!QZonePluginUtils.a(localPluginRecord, paramContext)) || (localPluginRecord == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "plugin still running");
      }
    } while (paramOnPluginReadyListener == null);
    paramPluginParams.c = ((PluginRecord)localObject).k;
    paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "forceUpdate, deamonInstall：" + true + ", " + true);
    }
    a(3, paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "getPluginListIfNeed  pluginInfoRequesting:" + this.jdField_a_of_type_Boolean + "" + " isReady:" + a() + " :lastUpdateSuccess:" + this.c);
    }
    if (this.jdField_a_of_type_Boolean) {}
    while (this.c) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public PluginRecord a(String paramString)
  {
    if ((!QLog.isColorLevel()) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    PluginRecord localPluginRecord = b(paramString);
    paramString = localPluginRecord;
    if (localPluginRecord != null) {
      paramString = localPluginRecord.a();
    }
    c();
    return paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    c();
  }
  
  public void a(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "not ready");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("patch", 2, "mPengdingLaunchState already set");
          }
          if (paramOnPluginReadyListener != null) {
            paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
          }
          return;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          c();
          QZonePluginManger.LaunchState localLaunchState = new QZonePluginManger.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState = localLaunchState;
          if (QLog.isColorLevel()) {
            QLog.d("patch", 2, "set mPendingLaunchState");
          }
          return;
        }
      }
    }
    b(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public void a(PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onDownLoadStart record:" + paramPluginRecord);
    }
    if (paramPluginRecord == null) {}
    for (;;)
    {
      return;
      ((PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g)).e = 1;
      Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g);
      if (localObject != null) {
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.g);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          paramPluginRecord.printStackTrace();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onUpdatefinish success:" + paramBoolean);
    }
    this.c = paramBoolean;
    this.jdField_b_of_type_Boolean = true;
    if (paramBoolean) {
      this.jdField_a_of_type_Yok.a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("patch", 2, "onUpdateFinish. handle pending launch state");
        }
        localLaunchState = this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState;
        b(localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$PluginParams, localLaunchState.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager$OnPluginReadyListener);
        this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger$LaunchState = null;
      }
      while (!QLog.isColorLevel())
      {
        QZonePluginManger.LaunchState localLaunchState;
        this.jdField_a_of_type_AndroidOsHandler.post(new yoh(this));
        return;
      }
      QLog.d("patch", 2, "mPendingLaunchState is null");
    }
  }
  
  public void a(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onInstallFinish record:" + paramPluginRecord);
    }
    if (paramPluginRecord == null) {
      return;
    }
    Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.g);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.g);
      if (paramBoolean)
      {
        if (localObject != null)
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null) {
            ((OnQZonePluginInstallListner)localObject).b(paramPluginRecord.g);
          }
        }
        a(paramPluginRecord.g, 0);
        return;
      }
    }
    catch (RemoteException paramPluginRecord)
    {
      paramPluginRecord.printStackTrace();
      return;
    }
    localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
    if (localObject != null) {
      ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.g, 7);
    }
    a(paramPluginRecord.g, 7);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "isPluginInstalled: " + paramString + "");
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = a(paramString);
      } while (paramString == null);
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, " isPluginInstalled record :" + paramString);
      }
    } while (paramString.e != 4);
    return true;
  }
  
  public boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "installPlugin pluginid:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      QLog.d("patch", 2, "installPlugin pluginid:" + paramString + "正在处理，skip。。。");
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new WeakReference(paramOnQZonePluginInstallListner));
    PluginRecord localPluginRecord1 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
    if (localPluginRecord1 != null)
    {
      PluginRecord localPluginRecord2 = this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramString);
      if ((localPluginRecord2 != null) && (localPluginRecord2.e == 4) && (this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(localPluginRecord2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("patch", 2, "installPlugin " + paramString + " 已安装");
        }
        if (paramOnQZonePluginInstallListner != null) {
          paramOnQZonePluginInstallListner.b(paramString);
        }
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "installPlugin " + paramString + " 未安装,开始下载");
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginRecord1);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a(localPluginRecord1, this);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("patch", 2, "installPlugin record==null 没有插件信息，失败");
      }
      if (paramOnQZonePluginInstallListner != null) {
        paramOnQZonePluginInstallListner.a(paramString, 1);
      }
      a(paramString, 1);
    }
  }
  
  public void b(PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onDownloadCanceled record:" + paramPluginRecord);
    }
    if (paramPluginRecord == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.g);
    Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.g);
    if (localObject != null) {}
    try
    {
      localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.g, 3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
    a(paramPluginRecord.g, 3);
  }
  
  public void b(boolean paramBoolean, PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onUnInstallFinish reslut:" + paramBoolean + "record:" + paramPluginRecord);
    }
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "cancelInstall " + paramString + "");
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramString, null);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a(paramString);
    }
  }
  
  public void c(PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onDownloadFailed record:" + paramPluginRecord);
    }
    if (paramPluginRecord == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.g);
    Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPluginRecord.g);
    if (localObject != null) {}
    try
    {
      localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
      if (localObject != null) {
        ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.g, 5);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
    a(paramPluginRecord.g, 5);
  }
  
  public boolean c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "uninstallPlugin " + paramString + "");
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a(paramString);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(paramString, null);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginDownloader.a(paramString);
    }
  }
  
  public void d(PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onDownloadSucceed record:" + paramPluginRecord);
    }
    if (paramPluginRecord == null) {
      return;
    }
    PluginRecord localPluginRecord = (PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g);
    localPluginRecord.e = 2;
    Object localObject;
    if (QZonePluginUtils.a(paramPluginRecord, this.jdField_a_of_type_AndroidContentContext))
    {
      localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g);
      if (localObject != null)
      {
        localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
        if (localObject == null) {}
      }
    }
    try
    {
      ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.g, 2);
      a(paramPluginRecord.g, 2);
      this.jdField_a_of_type_CooperationQzonePluginQZonePluginInstaller.a(localPluginRecord, this);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  public void e(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {}
    for (;;)
    {
      return;
      ((PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g)).e = 1;
      Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g);
      if (localObject != null) {
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.g, paramPluginRecord.jdField_a_of_type_Float, paramPluginRecord.jdField_a_of_type_Long);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          paramPluginRecord.printStackTrace();
        }
      }
    }
  }
  
  public void f(PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onInstallBegin record:" + paramPluginRecord);
    }
    if (paramPluginRecord == null) {}
    for (;;)
    {
      return;
      ((PluginRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g)).e = 3;
      Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramPluginRecord.g);
      if (localObject != null) {
        try
        {
          localObject = (OnQZonePluginInstallListner)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((OnQZonePluginInstallListner)localObject).a(paramPluginRecord.g);
            return;
          }
        }
        catch (RemoteException paramPluginRecord)
        {
          paramPluginRecord.printStackTrace();
        }
      }
    }
  }
  
  public void g(PluginRecord paramPluginRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onUnInstallBegin record:" + paramPluginRecord);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "onDestroy");
    }
    this.jdField_a_of_type_Yok.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZonePluginManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */