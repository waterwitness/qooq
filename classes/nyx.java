import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nyx
  implements Runnable
{
  public nyx(MultiForwardChatPie paramMultiForwardChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MultiForwardChatPie.a(this.a).notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */