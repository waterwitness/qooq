import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ros
  implements DialogInterface.OnCancelListener
{
  public ros(LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.a(null);
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ros.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */