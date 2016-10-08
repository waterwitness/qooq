import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gfl
  implements Runnable
{
  gfl(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a() == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "MultiHideCallNotAcceptRunnable");
    }
    this.a.a().E = false;
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(702) });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */