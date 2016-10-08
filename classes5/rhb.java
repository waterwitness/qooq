import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class rhb
  implements View.OnClickListener
{
  public rhb(DragSortAdapter paramDragSortAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (paramView.getTag() == null) {}
    Object localObject;
    EmoticonPackage localEmoticonPackage;
    int i;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)((BaseActivity)this.a.a).getAppRuntime();
        localEmoticonPackage = (EmoticonPackage)paramView.getTag();
      } while (!localEmoticonPackage.valid);
      i = DragSortAdapter.a(this.a, (QQAppInterface)localObject, localEmoticonPackage);
      if (i == 0)
      {
        DragSortAdapter.a(this.a, localEmoticonPackage, paramView);
        ReportController.b((QQAppInterface)localObject, "CliOper", "", ((QQAppInterface)localObject).a(), "ep_mall", "Clk_updatepkg_mine", 0, 0, localEmoticonPackage.epId, "" + localEmoticonPackage.localVersion, "" + localEmoticonPackage.latestVersion, "");
        return;
      }
      if ((i == 1) || (i == 2))
      {
        localObject = this.a;
        if (i == 1) {
          bool = true;
        }
        DragSortAdapter.a((DragSortAdapter)localObject, localEmoticonPackage, paramView, bool);
        return;
      }
    } while (i != 3);
    if (!NetworkUtil.b(this.a.a)) {
      DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131367535)).setMessage(this.a.a.getString(2131370450)).setPositiveButton(this.a.a.getString(2131368407), new rhd(this, localEmoticonPackage, paramView)).setNegativeButton(this.a.a.getString(2131368408), new rhc(this)).show();
    }
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "ep_mall", "0X8005C14", 0, 0, "", "", "", "");
      return;
      if (NetworkUtil.b(this.a.a)) {
        DragSortAdapter.a(this.a, localEmoticonPackage, paramView);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */