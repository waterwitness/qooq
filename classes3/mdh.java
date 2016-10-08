import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class mdh
  implements Comparator
{
  public mdh(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1.time == paramChatMessage2.time) {
      return 0;
    }
    if (paramChatMessage1.time > paramChatMessage2.time) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */