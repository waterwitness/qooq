import android.os.Handler;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qpm
  implements Runnable
{
  public qpm(RemoteArConfigManager paramRemoteArConfigManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadResource");
      }
      try
      {
        if (!this.a.a())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
          this.a.jdField_a_of_type_Boolean = true;
          return;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadResource|RemoteException e= " + localRemoteException);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */