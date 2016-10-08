import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class stt
  extends stu
{
  private stt(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    super(paramHotChatMemberListActivity, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(sts paramsts1, sts paramsts2)
  {
    int i = HotChatMemberListActivity.a(this.a, paramsts1);
    int j = HotChatMemberListActivity.a(this.a, paramsts2);
    if (i != j) {
      return i - j;
    }
    return super.a(paramsts1, paramsts2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */