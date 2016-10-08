import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.ipc.HYRemoteManager;
import cooperation.huangye.ipc.IHuangyeService;
import java.util.ArrayList;

public class ydc
  implements Runnable
{
  public ydc(HYRemoteManager paramHYRemoteManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    while (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      Bundle localBundle = (Bundle)this.a.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (localBundle != null)
      {
        String str = localBundle.getString("notify_cmd");
        try
        {
          localBundle.setClassLoader(getClass().getClassLoader());
          this.a.jdField_a_of_type_CooperationHuangyeIpcIHuangyeService.a("com.huangye.action.notify", localBundle);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HYRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + str);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("HYRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + str);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */