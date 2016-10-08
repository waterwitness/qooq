import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.ICallBack;
import com.tencent.mobileqq.richmedia.LOG;
import com.tencent.mobileqq.richmedia.RichmediaService;

public final class uga
  implements Runnable
{
  public uga(int paramInt, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService != null)
    {
      ICallBack localICallBack = RichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaRichmediaService.jdField_a_of_type_ComTencentMobileqqRichmediaICallBack;
      if (localICallBack != null) {
        try
        {
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
          localICallBack.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
          return;
        }
        catch (RemoteException localRemoteException)
        {
          LOG.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + localRemoteException.getMessage());
          return;
        }
      }
      LOG.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
      return;
    }
    LOG.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */