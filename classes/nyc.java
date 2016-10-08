import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.ReduFriendObserver;

public class nyc
  extends ReduFriendObserver
{
  public nyc(FriendChatPie paramFriendChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */