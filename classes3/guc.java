import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.GAudioMemberListCtrl;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class guc
  implements Runnable
{
  private guc(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl != null) {
      this.a.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */