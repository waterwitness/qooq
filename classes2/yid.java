import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.ipc.IQQHotSpotService;
import cooperation.qqhotspot.ipc.QQHotSpotRemoteManager;
import java.util.ArrayList;

public class yid
  implements Runnable
{
  public yid(QQHotSpotRemoteManager paramQQHotSpotRemoteManager)
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
          this.a.jdField_a_of_type_CooperationQqhotspotIpcIQQHotSpotService.a("com.qqhotspot.action.notify", localBundle);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQHotSpotRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + str);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQHotSpotRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + str);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */