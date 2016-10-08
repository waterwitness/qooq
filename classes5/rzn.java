import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rzn
  implements Runnable
{
  public rzn(QfavFilePreviewController paramQfavFilePreviewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (3 != QfavFilePreviewController.b(this.a))
    {
      this.a.a.a(false, QfavFilePreviewController.a(this.a), String.valueOf(QfavFilePreviewController.a(this.a)), QfavFilePreviewController.a(this.a), null, QfavFilePreviewController.b(this.a), null, QfavFilePreviewController.c(this.a));
      QfavFilePreviewController.b(this.a, 3);
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "QfavFilePreviewController.run:wait for remote command timeout(5min).");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */