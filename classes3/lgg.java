import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class lgg
  implements Comparator
{
  public lgg(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
  {
    if ((paramDiscussionMemberInfo1 != null) && (paramDiscussionMemberInfo2 != null))
    {
      paramDiscussionMemberInfo1 = Long.valueOf(Long.parseLong(paramDiscussionMemberInfo1.memberUin));
      paramDiscussionMemberInfo2 = Long.valueOf(Long.parseLong(paramDiscussionMemberInfo2.memberUin));
      if (paramDiscussionMemberInfo1.longValue() <= paramDiscussionMemberInfo2.longValue()) {}
    }
    while (paramDiscussionMemberInfo1 != null)
    {
      return 1;
      if (paramDiscussionMemberInfo1.longValue() < paramDiscussionMemberInfo2.longValue()) {
        return -1;
      }
      return 0;
    }
    if (paramDiscussionMemberInfo2 != null) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */