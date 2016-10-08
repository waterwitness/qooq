import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gfk
  implements Runnable
{
  public gfk(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a() == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
        } while ((!this.a.a().n()) || (!this.a.a().ab));
        if (QLog.isColorLevel()) {
          QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "MultiCheckCallNotAcceptRunnable");
        }
        i = this.a.d().size();
      } while (i <= 0);
      this.a.a().E = true;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(701), Integer.valueOf(i) });
    } while ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null));
    if (this.a.jdField_a_of_type_Gfl == null) {
      this.a.jdField_a_of_type_Gfl = new gfl(this.a);
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_Gfl);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_Gfl, this.a.N * 1000);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */