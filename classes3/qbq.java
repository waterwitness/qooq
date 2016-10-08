import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import java.util.Comparator;

public class qbq
  implements Comparator
{
  public qbq(NewFriendManager paramNewFriendManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(NewFriendMessage paramNewFriendMessage1, NewFriendMessage paramNewFriendMessage2)
  {
    return (int)(paramNewFriendMessage2.a - paramNewFriendMessage1.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */