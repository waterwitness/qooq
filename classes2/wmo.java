import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import java.util.Stack;

public class wmo
{
  private Stack jdField_a_of_type_JavaUtilStack;
  
  public wmo(MixedMsgLinearLayout paramMixedMsgLinearLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilStack = new Stack();
  }
  
  public AnimationTextView a()
  {
    if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
      return null;
    }
    return (AnimationTextView)this.jdField_a_of_type_JavaUtilStack.pop();
  }
  
  public void a(AnimationTextView paramAnimationTextView)
  {
    this.jdField_a_of_type_JavaUtilStack.push(paramAnimationTextView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */