import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ons
  implements Runnable
{
  public ons(AvatarPendantActivity.AnimationScrollListener paramAnimationScrollListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.b.u == 0)
    {
      URLDrawable.resume();
      this.a.b.a.a = false;
      this.a.b.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */