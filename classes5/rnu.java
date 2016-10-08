import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rnu
  implements DialogInterface.OnClickListener
{
  rnu(rnq paramrnq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FileManagerReporter.a("0X80052CF");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rnu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */