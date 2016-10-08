import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jec
  implements DialogInterface.OnClickListener
{
  public jec(MoveFileActivity paramMoveFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */