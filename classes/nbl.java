import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class nbl
  implements Comparator
{
  public nbl(ActivateFriendActivity paramActivateFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    long l = paramMessageRecord1.time - paramMessageRecord2.time;
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */