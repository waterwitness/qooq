import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofc
  implements DialogInterface.OnClickListener
{
  public ofc(VideoStatusTipsBar paramVideoStatusTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ofc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */