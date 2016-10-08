import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ger
  implements Runnable
{
  public ger(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().H) {
      ((AudioManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).setSpeakerphoneOn(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */