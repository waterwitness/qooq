import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class gdp
  implements Comparator
{
  private gdp(CreateArrageActivity paramCreateArrageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
  {
    if ((paramDiscussionMemberInfo1 != null) && (paramDiscussionMemberInfo2 != null)) {
      return paramDiscussionMemberInfo1.discussionUin.compareTo(paramDiscussionMemberInfo2.discussionUin);
    }
    if (paramDiscussionMemberInfo1 != null) {
      return 1;
    }
    if (paramDiscussionMemberInfo2 != null) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */