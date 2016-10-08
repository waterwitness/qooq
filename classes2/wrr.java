import android.text.Editable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.SendStoryActivity;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class wrr
  implements Comparator
{
  public wrr(SendStoryActivity paramSendStoryActivity, Editable paramEditable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend1) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */