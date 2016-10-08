package com.tencent.mobileqq.ar;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;
import qpf;
import qpg;

public class ArConfigService
  extends AppService
{
  public static final String a = "ArConfig_ArConfigService";
  private RemoteCallbackList jdField_a_of_type_AndroidOsRemoteCallbackList;
  public QQAppInterface a;
  public ArResourceManager a;
  private IArConfigListener jdField_a_of_type_ComTencentMobileqqArIArConfigListener;
  private final IArConfigManager.Stub jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager$Stub;
  
  public ArConfigService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqArArResourceManager = null;
    this.jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
    this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener = new qpf(this);
    this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager$Stub = new qpg(this);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "onBind");
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager$Stub;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
      this.jdField_a_of_type_ComTencentMobileqqArArResourceManager = ((ArResourceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(167));
      if (this.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArResourceManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqArIArConfigListener);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ArConfigService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */