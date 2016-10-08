import android.content.Context;
import android.view.Window;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class gzp
  extends ActionSheet
{
  public gzp(VideoInviteActivity paramVideoInviteActivity, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    super.getWindow().addFlags(2097152);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */