import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.util.SparseArray;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qht
  implements ServiceConnection
{
  public qht(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceConnected()...");
    }
    this.a.jdField_a_of_type_AndroidOsMessenger = new Messenger(paramIBinder);
    this.a.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.a.jdField_a_of_type_AndroidOsHandler);
    TroopQZoneUploadAlbumHandler.a(this.a, this.a.jdField_b_of_type_Int);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadPhoto", 2, "onServiceDisconnected()...");
    }
    this.a.jdField_a_of_type_AndroidOsMessenger = null;
    TroopQZoneUploadAlbumHandler.a(this.a, false);
    this.a.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.a.jdField_b_of_type_AndroidOsMessenger = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */