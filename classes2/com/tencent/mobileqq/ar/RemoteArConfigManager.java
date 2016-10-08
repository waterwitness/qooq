package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.ar.model.ModelResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import qpl;
import qpm;
import qpn;

public class RemoteArConfigManager
  implements Handler.Callback
{
  public static final int a = 1;
  public static final String a = "ArConfig_RemoteArConfigManager";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  private Activity a;
  public ServiceConnection a;
  public Handler a;
  public IArConfigListener a;
  public ArConfigInfo a;
  public ArEffectConfig a;
  public IArConfigManager a;
  public IArRemoteCallback a;
  public boolean a;
  boolean b;
  
  public RemoteArConfigManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = false;
    this.jdField_a_of_type_AndroidContentServiceConnection = new qpl(this);
    this.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback = new qpn(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public ArConfigInfo a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
    }
    for (;;)
    {
      return (ArConfigInfo)localObject2;
      localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|info=" + localObject1);
        return (ArConfigInfo)localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getArConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public ArEffectConfig a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
    }
    for (;;)
    {
      return (ArEffectConfig)localObject2;
      Object localObject3 = null;
      localObject2 = null;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager == null) {
        continue;
      }
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|info=" + localObject1);
        return (ArEffectConfig)localObject1;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Object localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("ArConfig_RemoteArConfigManager", 2, "getEffectConfig|RemoteException e= " + localRemoteException);
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.b)
    {
      this.jdField_a_of_type_AndroidAppActivity.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.b = false;
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener = null;
  }
  
  public void a(Activity paramActivity, IArConfigListener paramIArConfigListener)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
      paramActivity = new Intent(this.jdField_a_of_type_AndroidAppActivity, ArConfigService.class);
      this.jdField_a_of_type_AndroidAppActivity.bindService(paramActivity, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      this.b = true;
    } while (paramIArConfigListener == null);
    this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener = paramIArConfigListener;
  }
  
  public boolean a()
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return true;
    }
    if (NetConnInfoCenter.getServerTimeMillis() > ((ArConfigInfo)localObject1).aREnd) {
      return true;
    }
    Object localObject2;
    if (!((ArConfigInfo)localObject1).featureResources.isEmpty())
    {
      localObject2 = ((ArConfigInfo)localObject1).featureResources.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (!FileUtils.a(((ArResourceInfo)((Iterator)localObject2).next()).n)) {
          return false;
        }
      }
    }
    if (!((ArConfigInfo)localObject1).modelResources.isEmpty())
    {
      localObject1 = ((ArConfigInfo)localObject1).modelResources.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (ModelResource)((Iterator)localObject1).next();
          localObject2 = new File(((ModelResource)localObject3).c);
          if ((((File)localObject2).exists()) && (((ModelResource)localObject3).jdField_a_of_type_Boolean))
          {
            localObject2 = ((File)localObject2).getParentFile().getAbsolutePath();
            localObject3 = ((ModelResource)localObject3).jdField_a_of_type_JavaUtilHashMap;
            if (((HashMap)localObject3).isEmpty()) {
              return false;
            }
            localObject3 = ((HashMap)localObject3).entrySet().iterator();
            if (!((Iterator)localObject3).hasNext()) {
              continue;
            }
            Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
            String str = (String)localObject2 + File.separator + (String)((Map.Entry)localObject4).getKey();
            long l = ((Long)((Map.Entry)localObject4).getValue()).longValue();
            localObject4 = new File(str);
            if ((((File)localObject4).exists()) && (((File)localObject4).length() == l)) {
              break;
            }
            return false;
          }
          if (((ModelResource)localObject3).jdField_a_of_type_Boolean) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload");
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_RemoteArConfigManager", 2, "cancelDownload|RemoteException e= " + localRemoteException);
    }
  }
  
  public void c()
  {
    ThreadManager.a(new qpm(this), 5, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return false;
                } while (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null);
                paramMessage = paramMessage.obj;
              } while (!(paramMessage instanceof ArConfigInfo));
              this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a((ArConfigInfo)paramMessage);
              return false;
            } while (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null);
            paramMessage = paramMessage.obj;
          } while (!(paramMessage instanceof ArEffectConfig));
          this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a((ArEffectConfig)paramMessage);
          return false;
        } while (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null);
        this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a();
        this.jdField_a_of_type_Boolean = false;
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null);
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a(i, j);
      return false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener == null) || (!(paramMessage.obj instanceof Integer)));
    this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener.a(((Integer)paramMessage.obj).intValue());
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\RemoteArConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */