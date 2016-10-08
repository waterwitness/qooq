import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mjv
  implements DialogInterface.OnCancelListener
{
  public mjv(SearchTroopListActivity paramSearchTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */