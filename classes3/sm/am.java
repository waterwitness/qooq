package sm;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.securemodule.ui.TransparentActivity;
import com.tencent.securemodule.ui.TransparentActivity.a;

public class am
  implements DialogInterface.OnClickListener
{
  public am(TransparentActivity paramTransparentActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TransparentActivity.c(this.a).sendEmptyMessage(1);
    new TransparentActivity.a(this.a, 0).start();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */