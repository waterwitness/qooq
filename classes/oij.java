import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.JumpSrcConstants;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.Map;

public class oij
  implements View.OnClickListener
{
  oij(SearchContactsFragment paramSearchContactsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    oik localoik;
    int i;
    if ((paramView != null) && ((paramView instanceof oik)))
    {
      localoik = (oik)paramView;
      if ((localoik.b != 80000003) || (SearchContactsFragment.c(this.a) == null)) {
        break label281;
      }
      this.a.a(SearchContactsFragment.c(this.a), SearchContactsFragment.a(this.a), SearchContactsFragment.b(this.a));
      Integer localInteger = (Integer)SearchContactsFragment.a(this.a).get(Integer.valueOf(localoik.b));
      Object localObject = null;
      paramView = (View)localObject;
      if (localoik.a != null)
      {
        paramView = (View)localObject;
        if (localoik.a.uin != null) {
          paramView = String.valueOf(localoik.a.uin.get());
        }
      }
      int j = localoik.b;
      if (localInteger == null) {
        break label322;
      }
      i = localInteger.intValue();
      label151:
      SearchUtils.a(j, i, 0, true, paramView, this.a.d, SearchContactsFragment.c());
      if (localoik.b != 80000002) {
        break label376;
      }
      localObject = this.a.getActivity();
      if ((localObject != null) && ((localObject instanceof SearchBaseActivity)))
      {
        i = ((SearchBaseActivity)localObject).a();
        if (SearchContactsFragment.c() != 12) {
          break label328;
        }
        ReportController.b(this.a.a, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), paramView, this.a.d);
        localObject = PADetailReportUtil.a();
        if (localInteger == null) {
          break label370;
        }
        i = localInteger.intValue();
        ((PADetailReportUtil)localObject).a(2, paramView, i, SearchContactsFragment.c());
      }
    }
    label281:
    label322:
    label328:
    label370:
    label376:
    while (localoik.b != 80000003) {
      for (;;)
      {
        return;
        paramView = this.a;
        i = localoik.b;
        if (localoik.c == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.a(i, bool);
          break;
        }
        i = 0;
        break label151;
        ReportController.b(this.a.a, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D20", "0X8005D20", 0, 1, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), this.a.d, "");
        continue;
        i = 0;
      }
    }
    if (SearchContactsFragment.c() == 12)
    {
      ReportController.b(this.a.a, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", this.a.d, "0");
      return;
    }
    ReportController.b(this.a.a, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", this.a.d, "0");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */