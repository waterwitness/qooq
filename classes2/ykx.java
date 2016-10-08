import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2;
import cooperation.qzone.plugin.IQZonePluginManager;

public class ykx
  implements Runnable
{
  public ykx(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2, PluginBaseInfo paramPluginBaseInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_CooperationQzoneQZoneLiveVideoDownLoadActivtyV2.a.a(this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginBaseInfo.mID, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */