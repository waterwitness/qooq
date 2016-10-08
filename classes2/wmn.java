import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import java.util.Stack;

public class wmn
{
  private Stack jdField_a_of_type_JavaUtilStack;
  
  public wmn(MixedMsgLinearLayout paramMixedMsgLinearLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilStack = new Stack();
  }
  
  public ChatThumbView a()
  {
    if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
      return null;
    }
    return (ChatThumbView)this.jdField_a_of_type_JavaUtilStack.pop();
  }
  
  public void a(ChatThumbView paramChatThumbView)
  {
    this.jdField_a_of_type_JavaUtilStack.push(paramChatThumbView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */