import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class spy
  implements ActionSheet.OnButtonClickListener
{
  public spy(FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      ThreadManager.a(new spz(this), 10, null, false);
      this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X80061A3", "0X80061A3", 0, 0, "", "", "", "");
      continue;
      FreshNewsFeedAdapter.a(this.a, this.a.b.a, this.a.b.e);
      ThreadManager.a(new sqa(this), 10, null, false);
      this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X80061A5", "0X80061A5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */