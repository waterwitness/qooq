import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qhs
  extends Handler
{
  public qhs(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler, Looper paramLooper, QQAppInterface paramQQAppInterface)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message Progress. clientKey= " + paramMessage.arg1 + " progress=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1000: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message Finished. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1003: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message failed. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1005: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message task removed. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a.remove(i);
      return;
    case 1004: 
      if (QLog.isColorLevel()) {
        QLog.d("UploadPhoto", 2, "Get Message no task. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a.clear();
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    int i = ((Integer)paramMessage[0]).intValue();
    qhv localqhv = (qhv)paramMessage[1];
    int j = ((Integer)paramMessage[2]).intValue();
    int k = ((Integer)paramMessage[3]).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(localqhv.jdField_a_of_type_Long, j, k);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, localqhv.jdField_a_of_type_JavaLangString, localqhv.jdField_a_of_type_Long, j, k);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */