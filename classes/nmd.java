import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class nmd
  implements Runnable
{
  nmd(nlz paramnlz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.b != null) && ((this.a.a.b instanceof FragmentActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.a.a.b;
      if ((localFragmentActivity.getChatFragment() != null) && (localFragmentActivity.getChatFragment().a() != null)) {
        localFragmentActivity.getChatFragment().a().Q();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */