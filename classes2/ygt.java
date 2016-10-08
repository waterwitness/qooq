import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqfav.widget.FavoriteActionSheet;

public class ygt
  implements DialogInterface.OnDismissListener
{
  public ygt(FavoriteActionSheet paramFavoriteActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */