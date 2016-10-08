import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class uvp
  implements View.OnClickListener
{
  public uvp(StructMsgForHypertext paramStructMsgForHypertext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    new StructMsgClickHandler(null, paramView, this.a.message).a("web", this.a.mSourceUrl, null, null);
    ReportController.b(null, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, this.a.mMsgServiceID + "", "", "", "");
    ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */