import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import mqq.os.MqqHandler;

public class lee
  implements DragFrameLayout.OnDragModeChangedListener
{
  private final int jdField_a_of_type_Int;
  
  private lee(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = Integer.MIN_VALUE;
  }
  
  public void a(int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramDragFrameLayout.a() == -1)
    {
      Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation).sendEmptyMessage(10);
      FrameHelperActivity.b(true);
      return;
    }
    FrameHelperActivity.b(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */