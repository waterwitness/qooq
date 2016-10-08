import PersonalState.UserProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.Comparator;

public class ujs
  implements Comparator
{
  public ujs(StatusManager paramStatusManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(UserProfile paramUserProfile1, UserProfile paramUserProfile2)
  {
    return (int)(paramUserProfile2.richTime - paramUserProfile1.richTime);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */