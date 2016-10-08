import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rzo
  implements Runnable
{
  public rzo(QfavFilePreviewController paramQfavFilePreviewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FilePreviewActivity.ControlerCallback localControlerCallback = this.a.a;
    if (0L == QfavFilePreviewController.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.a), String.valueOf(QfavFilePreviewController.a(this.a)), QfavFilePreviewController.a(this.a), null, QfavFilePreviewController.b(this.a), null, QfavFilePreviewController.c(this.a));
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + QfavFilePreviewController.a(this.a) + ", port=" + QfavFilePreviewController.a(this.a) + ", key=" + QfavFilePreviewController.b(this.a) + ", retCode =" + QfavFilePreviewController.a(this.a));
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */