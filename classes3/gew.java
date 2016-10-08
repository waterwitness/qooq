import android.os.Handler;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gew
  implements Runnable
{
  public gew(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.f) {
      return;
    }
    String str = UITools.a(this.a.b());
    QAVNotification.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().b, this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().f, str);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */