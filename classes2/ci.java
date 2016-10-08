import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ci
  implements View.OnClickListener
{
  public ci(PrinterSubOptionActivity.PrinterItemAdapter paramPrinterItemAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131296886);
    if (paramView != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sPrinterName", paramView.getText());
      this.a.a.setResult(-1, localIntent);
      this.a.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */