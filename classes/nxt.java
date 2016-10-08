import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class nxt
  extends FriendListObserver
{
  public nxt(FriendChatPie paramFriendChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    super.a(paramBoolean, paramArrayList);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(FriendChatPie.an, 2, "onUpdateHotFriendLevel");
      }
      if (!this.a.b(2131296642)) {
        FriendChatPie.a(this.a, 2130840985, 2131296648);
      }
    }
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (FriendChatPie.a(this.a) != null))
    {
      if ((FriendChatPie.a(this.a).a()) && (!FriendChatPie.a(this.a).b()))
      {
        FriendChatPie.a(this.a).b(1);
        FriendChatPie.a(this.a).a(2);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131371905), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (FriendChatPie.a(this.a) != null)) {
      FriendChatPie.a(this.a).b(2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */