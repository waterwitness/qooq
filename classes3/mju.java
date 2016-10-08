import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mju
  implements DialogInterface.OnDismissListener
{
  public mju(SearchTroopListActivity paramSearchTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */