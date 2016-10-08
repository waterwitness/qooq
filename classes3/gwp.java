import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gwp
  implements View.OnClickListener
{
  public gwp(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_video", 0, 0, this.a.b, "", "", "");
    this.a.b(2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */