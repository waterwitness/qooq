import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ojy
  extends TroopObserver
{
  public ojy(ShowExternalTroopListActivity paramShowExternalTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2)
  {
    this.a.b = false;
    if ((!paramBoolean) || (paramList1 == null) || (paramList1.size() == 0) || (paramInt != 0))
    {
      this.a.c = 0;
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView.c())
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
        ShowExternalTroopListActivity.a(this.a);
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        paramList1 = new ArrayList();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList1);
        paramInt = this.a.getTitleBarHeight();
        QQToast.a(this.a, 1, this.a.getString(2131364862), 0).b(paramInt);
        return;
      }
      this.a.a();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.c())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.a);
    }
    this.a.d.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null)
    {
      this.a.c = paramList1.size();
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList1);
    }
    this.a.a(paramList2, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */