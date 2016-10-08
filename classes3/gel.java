import android.graphics.Bitmap;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gel
  implements Runnable
{
  public gel(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().l, this.a.a().s, null);
    Bitmap localBitmap = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().l, this.a.a().s, null, true, true);
    QAVNotification.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().b, str, localBitmap, this.a.a().s, 44, this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().l, this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().f);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */