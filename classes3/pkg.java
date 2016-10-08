import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pkg
  implements DialogInterface.OnClickListener
{
  public pkg(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null)
    {
      if (this.a.i == 2) {
        this.a.a();
      }
      this.a.a(this.a.c);
    }
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.a = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */