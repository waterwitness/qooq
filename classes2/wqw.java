import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.DeviceFriendListOpenFrame;
import com.tencent.open.agent.DeviceFriendListOpenFrame.FriendListAdapter;

public class wqw
  extends Handler
{
  public wqw(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 40, 0);
      return;
    case 2: 
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$FriendListAdapter.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */