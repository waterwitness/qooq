import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class han
  implements Runnable
{
  public han(VideoLayerUI paramVideoLayerUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (this.a.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.c);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.d);
      RecvMsg localRecvMsg = (RecvMsg)this.a.jdField_a_of_type_JavaUtilList.remove(0);
      this.a.b(localRecvMsg);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.c, 3000L);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.d, 3000L);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\han.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */