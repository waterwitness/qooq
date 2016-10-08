import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rfp
  implements View.OnClickListener
{
  rfp(rfo paramrfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((HotChatFlashPicActivity.a(this.a.a) != null) && (!this.a.a.isFinishing()))
    {
      HotChatFlashPicActivity.a(this.a.a).dismiss();
      HotChatFlashPicActivity.a(this.a.a, null);
      this.a.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */