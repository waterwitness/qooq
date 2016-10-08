import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lcc
  implements Runnable
{
  public lcc(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReadInJoyUtils.a(Conversation.a(this.a).getMeasuredHeight(), Conversation.a(this.a).getResources());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */