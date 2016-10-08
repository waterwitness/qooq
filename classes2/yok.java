import android.os.RemoteException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.QZonePluginManger;
import cooperation.qzone.plugin.QZonePluginUpdater;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;

public class yok
  implements NetworkState.NetworkStateListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qzone_live_video_plugin_hack.apk" };
  private QZonePluginManger jdField_a_of_type_CooperationQzonePluginQZonePluginManger;
  private QZonePluginUpdater jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public yok(QZonePluginManger paramQZonePluginManger, QZonePluginUpdater paramQZonePluginUpdater)
  {
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater = paramQZonePluginUpdater;
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger = paramQZonePluginManger;
    NetworkState.a(this);
  }
  
  public void a()
  {
    if ((NetworkState.c()) && (this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater.a() != null)) {
      try
      {
        String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_CooperationQzonePluginQZonePluginManger.a(str, null);
          i += 1;
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (NetworkState.c()) {
      a();
    }
  }
  
  public void b()
  {
    NetworkState.b(this);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */