import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

public class jeb
  implements DialogInterface.OnClickListener
{
  public jeb(MoveFileActivity paramMoveFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (InputDialog)paramDialogInterface;
    this.a.d = paramDialogInterface.getInputValue().trim();
    if (this.a.d.length() > TroopFileUtils.h)
    {
      paramDialogInterface.a(this.a.getString(2131364103), -65536);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this.a.a + "", "", "", "");
    }
    do
    {
      return;
      if (TroopFileUtils.a(this.a.d))
      {
        paramDialogInterface.a(this.a.getString(2131364105), -65536);
        ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.a + "", "0", "", "");
        return;
      }
      paramDialogInterface.dismiss();
    } while (TroopFileUtils.a(this.a.app, this.a, this.a.a) == 0);
    TroopFileProtocol.a(this.a.app, this.a.a, "/", this.a.d, MoveFileActivity.a(this.a));
    this.a.a(2131364095);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */