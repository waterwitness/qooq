import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.data.NearbyMember;
import java.util.Comparator;

public class vdy
  implements Comparator
{
  public vdy(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(NearbyMember paramNearbyMember1, NearbyMember paramNearbyMember2)
  {
    if (paramNearbyMember1.c == paramNearbyMember2.c) {
      return 0;
    }
    if (paramNearbyMember1.c < paramNearbyMember2.c) {
      return -1;
    }
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */