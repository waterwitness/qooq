import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class goe
  implements DialogInterface.OnClickListener
{
  public goe(SmallScreenDialogActivity paramSmallScreenDialogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = this.a.getIntent().getBooleanExtra("is_video", false);
    paramDialogInterface = this.a.a.a();
    SmallScreenUtils.a(paramDialogInterface, SmallScreenUtils.a(paramDialogInterface, bool) + 1, bool);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\goe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */