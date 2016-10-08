package com.tencent.av.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.av.VideoController;
import com.tencent.av.VideoServlet;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.mediacodec.VideoDecTest;
import com.tencent.av.mediacodec.VideoEncTest;
import com.tencent.av.mediacodec.config.CodecConfigParser;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceForQQ;
import com.tencent.av.service.IQQServiceCallback.Stub;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.ClassLoaderUtil;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.statistics.StatisticCollector.StatisticCallback;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import gfv;
import gfw;
import gfx;
import gfy;
import gfz;
import gga;
import ggb;
import ggc;
import ggd;
import gge;
import ggf;
import ggg;
import ggi;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class VideoAppInterface
  extends AppInterface
  implements StatisticCollector.StatisticCallback
{
  public static final int a = 2;
  public static String a;
  public static final int b = 1;
  public static final String b = "tencent.video.q2v.membersChange";
  public static final int c = 0;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ggc(this);
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new ggg(this);
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public VideoController a;
  VideoNotifyCenter jdField_a_of_type_ComTencentAvAppVideoNotifyCenter = null;
  public IAVServiceForQQ a;
  public IQQServiceCallback.Stub a;
  public IQQServiceForAV a;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new gfw(this);
  EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  ggb jdField_a_of_type_Ggb = null;
  private ggd jdField_a_of_type_Ggd;
  private Object jdField_a_of_type_JavaLangObject;
  private Map jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new ggi(this);
  boolean jdField_b_of_type_Boolean = false;
  BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new gge(this);
  boolean jdField_c_of_type_Boolean = false;
  public volatile int d;
  BroadcastReceiver jdField_d_of_type_AndroidContentBroadcastReceiver = new gfx(this);
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 1;
  public BroadcastReceiver e;
  boolean jdField_e_of_type_Boolean = false;
  boolean f = false;
  public boolean g = true;
  public boolean h;
  public boolean i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "VideoAppInterface";
  }
  
  public VideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub = new ggf(this);
    this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
    this.jdField_e_of_type_AndroidContentBroadcastReceiver = new gga(this);
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(a());
    if (!((SharedPreferences)localObject).getBoolean("hwcodec_avc_decode_test", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startH264DecoderTest");
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hwcodec_avc_decode_test", true);
      ((SharedPreferences.Editor)localObject).commit();
      new VideoDecTest(ImageResUtil.c() + "bitv.mp4", paramBoolean, new gfy(this)).a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "startH264DecoderTest decode tested.");
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(a());
    if (!((SharedPreferences)localObject).getBoolean("hwcodec_avc_encode_test", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed startH264EncoderTest");
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hwcodec_avc_encode_test", true);
      ((SharedPreferences.Editor)localObject).commit();
      new VideoEncTest(ImageResUtil.c() + "test2Frame.yuv", paramBoolean, new gfz(this)).a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed startH264EncoderTest encode tested.");
  }
  
  private void f(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      DexClassLoader localDexClassLoader = ClassLoaderUtil.a();
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          this.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        if (this.jdField_a_of_type_Ggd == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "register camera availability change receiver");
          }
          this.jdField_a_of_type_Ggd = new ggd(this);
          localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("com.tencent.mobileqq.qav.camera.availability");
          this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_Ggd, (IntentFilter)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "register camera availability change callback");
        }
        this.jdField_a_of_type_JavaLangObject = ClassLoaderUtil.a(localDexClassLoader, "com.tencent.av.camera2.CameraManagerWrapper");
        Object localObject = this.jdField_a_of_type_JavaLangObject;
        Context localContext = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext();
        String str = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
        ClassLoaderUtil.a(localDexClassLoader, localObject, "registerAvailabilityCb", new Class[] { Context.class, String.class, Handler.class }, new Object[] { localContext, str, null });
        return;
      }
      if (this.jdField_a_of_type_Ggd != null) {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "UnRegister camera availability change receiver");
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_Ggd);
        this.jdField_a_of_type_Ggd = null;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "UnRegister camera availability change callback");
        }
        if (this.jdField_a_of_type_JavaLangObject == null) {
          continue;
        }
        ClassLoaderUtil.a(localDexClassLoader, this.jdField_a_of_type_JavaLangObject, "unRegisterAvailabilityCb", null, null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "watchCameraAvailability e = " + localException);
          }
        }
      }
    }
  }
  
  private void l()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed");
    }
    Object localObject = ConfigSystemImpl.b(a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed hwcodec test config: \n" + (String)localObject);
      }
      localObject = new CodecConfigParser((String)localObject);
      j = ((CodecConfigParser)localObject).a();
      if ((j == 1) || (j == 2))
      {
        if (!new File(ImageResUtil.c(), "bitv.mp4").exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed start download test file!");
          }
          a(0);
        }
      }
      else
      {
        j = ((CodecConfigParser)localObject).b();
        if ((j == 1) || (j == 2))
        {
          if (new File(ImageResUtil.c(), "test2Frame.yuv").exists()) {
            break label205;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed start download test file!");
          }
          a(0);
        }
      }
    }
    label205:
    while (!QLog.isColorLevel())
    {
      int j;
      return;
      if (j == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        d(bool1);
        break;
      }
      if (j == 2) {}
      for (bool1 = bool2;; bool1 = false)
      {
        e(bool1);
        return;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed do not need test.");
  }
  
  public int a()
  {
    return AppSetting.jdField_a_of_type_Int;
  }
  
  public int a(String paramString)
  {
    int k = 0;
    int j = k;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      j = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return j;
    }
    catch (RemoteException paramString)
    {
      do
      {
        j = k;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getDiscussMemberNum", paramString);
    }
    return 0;
  }
  
  public long a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      l1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return l1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getOtherTermianlAvChatingType", paramString);
    }
    return 0L;
  }
  
  public Bitmap a()
  {
    return ImageUtil.a();
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
        return (Bitmap)localObject1;
      }
      catch (RemoteException paramString2)
      {
        if (paramBoolean2)
        {
          paramString1 = a();
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "getFaceBitmap-->can not get facebitmap", paramString2);
          }
          return paramString1;
        }
      }
      catch (NullPointerException paramString2)
      {
        paramString1 = (String)localObject2;
        if (paramBoolean2) {
          paramString1 = a();
        }
        localObject1 = paramString1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getFaceBitmap-->can not get facebitmap", paramString2);
        return paramString1;
      }
      paramString1 = null;
    }
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public VideoController a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
    }
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public VideoNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter = new VideoNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public INetEngine a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      str = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2);
      return str;
    }
    catch (RemoteException paramString2)
    {
      do
      {
        str = paramString1;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "getDisplayName", paramString2);
    }
    return paramString1;
  }
  
  String a(Context paramContext)
  {
    int j = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == j) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return (String)localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "getPhoneUserNameByPhoneNum", paramString);
    }
    return null;
  }
  
  String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label144;
      }
    }
    label144:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public Map a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    onDestroy();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "startDownloadAVResource", localRemoteException);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "startPumpMessage", paramString);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramInt, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "setPeerInfo", paramString1);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramLong);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "syncChatingTime", localRemoteException);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramLong, paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getGVideoLevelInfo", paramString);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = getApplication().refreAccountList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if (paramString.equals(localSimpleAccount.getUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Switch Account: " + paramString);
          }
          switchAccount(localSimpleAccount, null);
          if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
            this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
          }
          this.jdField_a_of_type_ComTencentAvVideoController = null;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString1, paramString2, paramString3);
      return;
    }
    catch (RemoteException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "sendMessageToTroop", paramString1);
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      a().addObserver(paramObserver);
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "setRandomSpeakerStat", localRemoteException);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramBoolean, paramNotification);
      this.g = paramBoolean;
      return;
    }
    catch (RemoteException paramNotification)
    {
      for (;;) {}
    }
  }
  
  public void a(long[] paramArrayOfLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramArrayOfLong, paramString);
      return;
    }
    catch (RemoteException paramArrayOfLong)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getGVideoLevelInfo", paramArrayOfLong);
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQ Account Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("tencent.video.q2v.membersChange");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramLong);
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getTroopAdmins-->troopUin=" + paramLong, localRemoteException);
    }
    return false;
  }
  
  public boolean a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) && (paramIQQServiceLocationCallback != null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "We will get address config");
      }
    }
    while (!QLog.isColorLevel())
    {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramIQQServiceLocationCallback);
        bool = true;
      }
      catch (RemoteException paramIQQServiceLocationCallback)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w(jdField_a_of_type_JavaLangString, 2, "getAddressConfig fail", paramIQQServiceLocationCallback);
        return false;
      }
      return bool;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getAddressConfig-->mQQServiceForAV is null or cb is null");
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return bool1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "isFriend", paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString, paramInt);
      return bool1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "requestDecodeStrangeFace-->false", paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString, paramInt1, paramInt2, paramArrayOfByte);
      return bool1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "send0x211C2CMsg", paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return true;
      try
      {
        String str = a(a());
        int j = 0;
        for (;;)
        {
          if (j >= paramArrayList.size()) {
            break label58;
          }
          boolean bool = str.equals(paramArrayList.get(j));
          if (bool) {
            break;
          }
          j += 1;
        }
        return false;
      }
      catch (Exception paramArrayList)
      {
        return false;
      }
    }
  }
  
  public int[] a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return (int[])localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getMultiPstnConfig", localRemoteException);
    }
    return null;
  }
  
  public long[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      return (long[])localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getDiscussMemberList", paramString);
    }
    return null;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        int j = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.d();
        return j;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "getPstnState", localRemoteException);
        }
      }
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    int k = 0;
    int j = k;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      j = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramString);
      return j;
    }
    catch (RemoteException paramString)
    {
      do
      {
        j = k;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getOtherTermianlAvChatingType", paramString);
    }
    return 0;
  }
  
  public String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramString);
      return (String)localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getUinByPhoneNum", paramString);
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().j;
        if ((j > 0) && (j <= 4))
        {
          String str = this.jdField_a_of_type_ComTencentAvVideoController.a().c;
          this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.c(str, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.s = false;
          c();
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.E, this.jdField_a_of_type_ComTencentAvVideoController.a, 0, new int[] { this.jdField_a_of_type_ComTencentAvVideoController.a().D });
          }
        }
      }
      System.exit(0);
    }
    catch (Exception localException)
    {
      System.exit(0);
      return;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramInt, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "setBindInfo", paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "acceptAddFriend", paramString);
    }
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "playFlowerAnimation", localRemoteException);
    }
  }
  
  boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQGAudioMsg Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AddDiscussMember");
    localIntentFilter.addAction("tencent.video.q2v.SwitchToDiscuss");
    localIntentFilter.addAction("tencent.video.q2v.GroupSystemMsg");
    localIntentFilter.addAction("tencent.video.q2v.SelectMember");
    localIntentFilter.addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntentFilter.addAction("tencent.video.q2v.GvideoGift");
    localIntentFilter.addAction("tencent.video.q2v.GvideoLevelUpgrade");
    localIntentFilter.addAction("tencent.video.q2v.ACTION_RECV_C2B_PUSH_MSG");
    localIntentFilter.addAction("tencent.video.q2v.pstnCardInfoChanged");
    localIntentFilter.addAction("tencent.video.q2v.GvideoMemUntInvite");
    localIntentFilter.addAction("tencent.video.q2v.close_invite_msg_box");
    localIntentFilter.addAction("tencent.video.q2v.close_invite_msg_box_by_invite_id");
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null;
  }
  
  public boolean b(long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramLong);
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "curGAInviteIsRight", localRemoteException);
    }
    return true;
  }
  
  public boolean b(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) && (paramIQQServiceLocationCallback != null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "We will get current user address");
      }
    }
    while (!QLog.isColorLevel())
    {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramIQQServiceLocationCallback);
        bool = true;
      }
      catch (RemoteException paramIQQServiceLocationCallback)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w(jdField_a_of_type_JavaLangString, 2, "getUserCurrentLocation fail", paramIQQServiceLocationCallback);
        return false;
      }
      return bool;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getUserCurrentLocation-->mQQServiceForAV is null or cb is null");
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool1 = false;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    while (!QLog.isColorLevel())
    {
      try
      {
        boolean bool2 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramString);
        bool1 = bool2;
      }
      catch (RemoteException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(jdField_a_of_type_JavaLangString, 2, "isOtherTerminalAvChatting", paramString);
        return false;
      }
      return bool1;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "mQQServiceForAV is null");
    return false;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(paramString, paramInt);
      return bool1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "avAddFriend", paramString);
    }
    return false;
  }
  
  public int c()
  {
    int k = 0;
    int j = k;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      j = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b();
      return j;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        j = k;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getMultiPstnGraySwitch", localRemoteException);
    }
    return 0;
  }
  
  public int c(String paramString)
  {
    int k = 0;
    int j = k;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      j = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramString);
      return j;
    }
    catch (RemoteException paramString)
    {
      do
      {
        j = k;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getNearbyProfileData", paramString);
    }
    return 0;
  }
  
  public String c()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "We will get current user skey");
      }
    }
    while (!QLog.isColorLevel())
    {
      try
      {
        String str = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
        localObject = str;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w(jdField_a_of_type_JavaLangString, 2, "getSKey fail", localRemoteException);
        return null;
      }
      return (String)localObject;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getSKey-->mQQServiceForAV is null");
    return null;
  }
  
  public String c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.d(paramString);
      return (String)localObject1;
    }
    catch (RemoteException paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getPhoneNumByUin", paramString);
    }
    return null;
  }
  
  public void c()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
      this.jdField_c_of_type_Boolean = false;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver);
      this.jdField_d_of_type_Boolean = false;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_e_of_type_Boolean = false;
    }
    if (this.f)
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_e_of_type_AndroidContentBroadcastReceiver);
      this.f = false;
    }
    f(false);
    Object localObject = new Intent(getApplication(), AVServiceForQQ.class);
    getApplication().stopService((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "exit video process clearNotification");
    }
    ((NotificationManager)getApplication().getApplicationContext().getSystemService("notification")).cancel(2130839263);
    localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localObject != null)
    {
      ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
      ((AudioManager)localObject).setMode(this.jdField_e_of_type_Int);
    }
    getApplication().otherProcessExit(true);
    new gfv(this).run();
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "acceptAddFriend", paramString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQ Process Exit Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString);
      bool1 = true;
    }
    catch (RemoteException paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getNearbyProfileData", paramString);
    }
    return bool1;
    return false;
  }
  
  public int d()
  {
    int k = 5;
    int j = k;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      j = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c();
      return j;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        j = k;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getMultiPstnMembership", localRemoteException);
    }
    return 5;
  }
  
  public String d()
  {
    String str2 = a().getString(2131363184);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().c;
      int j = ((VideoController)localObject).a().l;
      localObject = ((VideoController)localObject).a().e;
      str1 = str2;
      if (j == 9500) {
        str1 = a(j, str3, (String)localObject) + a().getString(2131363185);
      }
    }
    return str1;
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV == null)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, QQServiceForAV.class);
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    }
  }
  
  boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist vipFunCall Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AnnimateDownloadFinish");
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "regist vipFunCall success");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist vipFunCall false");
    }
    return false;
  }
  
  public boolean d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        boolean bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(paramString, a());
        return bool;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return true;
  }
  
  public int e()
  {
    return a().countObservers();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b(this.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          return;
        }
        catch (Exception localException) {}
        localRemoteException = localRemoteException;
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "unbindQQService", localRemoteException);
        }
      }
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "isQQpaused", localRemoteException);
    }
    return false;
  }
  
  public int f()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      j = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return j;
    }
    catch (RemoteException localRemoteException) {}
    return 0;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "stopPumpMessage", localRemoteException);
    }
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "isPhoneCalling", localRemoteException);
    }
    return false;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.b();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(jdField_a_of_type_JavaLangString, 2, "avStartAddFriendService", localRemoteException);
        return;
      }
    }
    this.i = true;
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getNearbyProfileData", localRemoteException);
    }
    return false;
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { VideoServlet.class };
  }
  
  public void h()
  {
    this.i = false;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "avStopAddFriendService", localRemoteException);
    }
  }
  
  boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQ Process Exit Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.EXIT_VIDEO_PROCESS");
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_e_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null;
  }
  
  public void i()
  {
    a().deleteObservers();
  }
  
  public boolean i()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.d();
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getgetTalkBack", localRemoteException);
    }
    return false;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public boolean j()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {}
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.e();
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getEffectsSoLoadIsOk  result " + this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV + "   " + bool1);
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "getEffectsSoLoadIsOk", localRemoteException);
          bool1 = bool2;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Video process launch: " + System.currentTimeMillis() + " UIN " + getAccount());
    }
    try
    {
      ((PowerManager)a().getSystemService("power")).newWakeLock(1, "VideoAppInterfaceOnCreateTag").acquire(10000L);
      a(null);
      AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      UpdateAvSo.a();
      if (this.jdField_a_of_type_ComTencentAvVideoController == null)
      {
        a();
        AudioHelper.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        this.jdField_b_of_type_Boolean = a();
        this.jdField_c_of_type_Boolean = b();
        this.jdField_d_of_type_Boolean = c();
        this.jdField_e_of_type_Boolean = d();
        this.f = h();
        d();
        paramBundle = new Intent(getApplication(), AVServiceForQQ.class);
        getApplication().startService(paramBundle);
        this.jdField_a_of_type_Ggb = new ggb(this);
        getApplication().bindService(paramBundle, this.jdField_a_of_type_Ggb, 1);
        this.jdField_d_of_type_Int = 2;
        AVReport.a().a();
        paramBundle = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
        if (paramBundle != null)
        {
          this.jdField_a_of_type_Boolean = paramBundle.isSpeakerphoneOn();
          this.jdField_e_of_type_Int = paramBundle.getMode();
        }
        f(true);
        QavCameraUsage.a(getApplication(), false);
        if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache == null)
        {
          long l = MemoryManager.a() / 8L;
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache((int)l);
          BaseApplicationImpl.jdField_a_of_type_Int = (int)l;
          Step.AmStepFactory.b(10, BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, null).c();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("Image cache allocated, size: %d...", new Object[] { Integer.valueOf(BaseApplicationImpl.jdField_a_of_type_Int) }));
          }
        }
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this);
      }
    }
  }
  
  protected void onDestroy()
  {
    Intent localIntent = new Intent(getApplication(), AVServiceForQQ.class);
    getApplication().stopService(localIntent);
    e();
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unbindService(this.jdField_a_of_type_Ggb);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
        PtvTemplateManager.b();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {}
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
          super.onDestroy();
          return;
          localException1 = localException1;
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
          }
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\app\VideoAppInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */