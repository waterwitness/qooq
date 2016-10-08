import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;

public class kxg
  implements Runnable
{
  public kxg(ChatHistoryForC2C paramChatHistoryForC2C)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (VipUtils.a(this.a.app)) {
      ChatHistoryForC2C.a(this.a, "svip");
    }
    for (;;)
    {
      VipUtils.a(this.a.app, "vip", "0X8004FAB", "0X8004FAB", 0, 0, new String[] { ChatHistoryForC2C.a(this.a) });
      return;
      if (VipUtils.b(this.a.app)) {
        ChatHistoryForC2C.a(this.a, "vip");
      } else {
        ChatHistoryForC2C.a(this.a, "notvip");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */