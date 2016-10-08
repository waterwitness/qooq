import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gvz
  implements View.OnClickListener
{
  public gvz(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.a.l();
    paramView = this.a.k.getText().toString();
    if ((paramView != null) && (paramView.equals("自我静音")))
    {
      ReportController.b(null, "CliOper", "", "", "0X8005DF1", "0X8005DF1", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005DF3", "0X8005DF3", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */