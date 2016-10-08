import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.ui.MultiVideoEnterPageMembersControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gwx
  implements Runnable
{
  public gwx(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int j = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int i = 0;
      while (i < j)
      {
        arrayOfMultiVideoEnterPageMembersControlUI[i].a();
        i += 1;
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */