import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.biz.troop.file.TroopFileProtocol.CreateFolderObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class jef
  extends TroopFileProtocol.CreateFolderObserver
{
  public jef(MoveFileActivity paramMoveFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, TroopFileInfo paramTroopFileInfo)
  {
    if (this.a.getActivity().isFinishing()) {
      return;
    }
    this.a.b();
    int i = this.a.getActivity().getResources().getDimensionPixelSize(2131492908);
    if (paramBoolean)
    {
      MoveFileActivity.a(this.a).add(0, paramTroopFileInfo);
      MoveFileActivity.c(this.a, 0);
      MoveFileActivity.a(this.a).setEnabled(true);
      MoveFileActivity.a(this.a).setBackgroundResource(2130838224);
      MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131558887);
      MoveFileActivity.a(this.a).i(paramTroopFileInfo);
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, this.a.a + "", paramTroopFileInfo.b, "", "");
      QQToast.a(this.a.getActivity(), 2, "创建成功", 0).b(i);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramTroopFileInfo = this.a.getString(2131364670);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
    case -313: 
      paramTroopFileInfo = this.a.getString(2131364104);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, this.a.a + "", "1", "", "");
    }
    for (;;)
    {
      this.a.a(this.a.getResources().getString(2131364094), null, this.a.d, paramTroopFileInfo);
      return;
      paramTroopFileInfo = this.a.getString(2131364105);
      ReportController.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.a + "", "1", "", "");
      continue;
      paramTroopFileInfo = this.a.getString(2131364107);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
      paramTroopFileInfo = this.a.getString(2131364109);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
      return;
      paramTroopFileInfo = this.a.getString(2131364106);
      QQToast.a(this.a.getActivity(), 1, paramTroopFileInfo, 0).b(i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */