import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class sil
  implements DialogInterface.OnClickListener
{
  public sil(FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */