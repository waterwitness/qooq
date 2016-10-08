import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ioc
  implements DialogInterface.OnDismissListener
{
  public ioc(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(this.a.P);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ioc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */