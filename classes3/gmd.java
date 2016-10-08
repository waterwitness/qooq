import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gmd
  implements Runnable
{
  public gmd(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d) == null)) {
      return;
    }
    String str = UITools.a(this.a.jdField_a_of_type_ComTencentAvVideoController.b());
    if (this.a.b != null)
    {
      this.a.b.setContentDescription(UITools.a(str));
      this.a.b.setText(str);
      if (SessionMgr.a().a(this.a.jdField_a_of_type_ComTencentAvRandomRandomController.d).a.b == 5) {
        this.a.b.setVisibility(0);
      }
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */