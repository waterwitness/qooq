import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class rzm
  implements Runnable
{
  rzm(rzl paramrzl, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = true;
    QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    QfavFilePreviewController.b(this.jdField_a_of_type_Rzl.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    QfavFilePreviewController.c(this.jdField_a_of_type_Rzl.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a) + ", port=" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a)) + ", key=" + QfavFilePreviewController.b(this.jdField_a_of_type_Rzl.a) + ", retCode =" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a)));
    }
    FilePreviewActivity.ControlerCallback localControlerCallback;
    if (1 == QfavFilePreviewController.b(this.jdField_a_of_type_Rzl.a))
    {
      localControlerCallback = this.jdField_a_of_type_Rzl.a.a;
      if (0L != QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a)) {
        break label320;
      }
    }
    for (;;)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a), String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a)), QfavFilePreviewController.a(this.jdField_a_of_type_Rzl.a), null, QfavFilePreviewController.b(this.jdField_a_of_type_Rzl.a), null, QfavFilePreviewController.c(this.jdField_a_of_type_Rzl.a));
      QfavFilePreviewController.b(this.jdField_a_of_type_Rzl.a, 3);
      return;
      label320:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */