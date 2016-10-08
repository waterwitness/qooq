import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class lgu
  implements Comparator
{
  private lgu(DiscussionMemberActivity paramDiscussionMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(lgs paramlgs1, lgs paramlgs2)
  {
    return paramlgs1.c.compareToIgnoreCase(paramlgs2.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */