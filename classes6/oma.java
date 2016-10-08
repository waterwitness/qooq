import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class oma
  implements Comparator
{
  public oma(C2CMessageResultAdapter paramC2CMessageResultAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageItem paramMessageItem1, MessageItem paramMessageItem2)
  {
    return (int)(paramMessageItem2.a.time - paramMessageItem1.a.time);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */