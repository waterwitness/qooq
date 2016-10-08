import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.VipGifObserver;

public class nyb
  extends VipGifObserver
{
  public nyb(FriendChatPie paramFriendChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true))
    {
      paramBundle.getInt("gif_ui_show_bid");
      long l = paramBundle.getLong("gif_ui_show_seq");
      this.a.a(65536);
      FriendChatPie.a(this.a, Long.valueOf(l).longValue());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */