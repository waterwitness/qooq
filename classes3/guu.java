import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class guu
  implements View.OnClickListener
{
  public guu(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, Intent paramIntent, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new guv(this), 500L);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b(1);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_ComTencentAvAppSessionInfo);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b), Integer.valueOf(3) });
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */