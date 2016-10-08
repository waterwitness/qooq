import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService;
import com.tencent.qphone.base.util.QLog;

public class uan
  implements Runnable
{
  public uan(QzonePhotoGuideNotifyService paramQzonePhotoGuideNotifyService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzonePhotoGuideNotifyServlet", 2, "sendRedRunnable");
    }
    if (this.a.a != null) {
      this.a.a.a();
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */