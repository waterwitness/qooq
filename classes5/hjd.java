import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hjd
  implements DialogInterface.OnClickListener
{
  public hjd(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ThreadManager.a(new hje(this), 10, null, true);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */