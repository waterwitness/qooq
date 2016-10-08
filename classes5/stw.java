import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class stw
  implements Comparator
{
  private stw(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(sts paramsts1, sts paramsts2)
  {
    return paramsts1.f.compareToIgnoreCase(paramsts2.f);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */