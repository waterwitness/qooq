import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.biz.ui.MenuItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;

public final class jfq
  implements View.OnClickListener
{
  public jfq(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener, MenuItem paramMenuItem, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener.a(this.jdField_a_of_type_ComTencentBizUiMenuItem.b(), this.jdField_a_of_type_ComTencentBizUiMenuItem.a(), 1);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      paramView = PublicAccountManager.a().a(localQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizUiMenuItem.a());
    } while ((paramView == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = paramView.name.get();
    int i = this.jdField_a_of_type_Int;
    if (paramView.url.has()) {}
    for (paramView = paramView.url.get();; paramView = "")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC6", "0X8005EC6", 0, 0, str1, str2, String.valueOf(i), paramView);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */