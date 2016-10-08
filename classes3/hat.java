import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hat
  implements Runnable
{
  public hat(VideoNetStateBar paramVideoNetStateBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoNetStateBar", 2, "mVideoController == null");
      }
    }
    for (;;)
    {
      return;
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.h();
      this.a.g = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoNetStateBar", 2, "multi self net level : " + i);
      }
      switch (i)
      {
      }
      while ((this.a.jdField_a_of_type_JavaLangRunnable != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
        return;
        this.a.a(3);
        continue;
        this.a.a(2);
        continue;
        this.a.a(1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */