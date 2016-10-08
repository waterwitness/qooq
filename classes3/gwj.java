import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersVideoUI;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gwj
  implements Runnable
{
  public gwj(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.a();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */