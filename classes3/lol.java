import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class lol
  implements View.OnClickListener
{
  public lol(H5MagicPlayerActivity paramH5MagicPlayerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    H5MagicPlayerActivity.a(this.a);
    if ((this.a.e.equals(this.a.d)) && (this.a.a != null))
    {
      ReportController.b(null, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.a.a.epId, "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.a.a.epId, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */