import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.qqshop.qqshop.SQQSHPRecmdAccount;

public class hui
  implements View.OnClickListener
{
  public hui(EcShopRecommendAdapter paramEcShopRecommendAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while (paramView.getTag() == null);
    huk localhuk = (huk)paramView.getTag();
    if (localhuk.jdField_a_of_type_TencentImOidbQqshopQqshop$SQQSHPRecmdAccount.puin.has()) {}
    for (paramView = Long.valueOf(localhuk.jdField_a_of_type_TencentImOidbQqshopQqshop$SQQSHPRecmdAccount.puin.get());; paramView = "")
    {
      paramView = String.valueOf(paramView);
      if (TextUtils.isEmpty(paramView)) {
        break;
      }
      String str = String.valueOf(localhuk.jdField_a_of_type_AndroidWidgetButton.getText());
      if (!this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131370331).equals(str)) {
        break label162;
      }
      this.a.a(localhuk, 3);
      PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity, paramView, new huj(this.a, localhuk));
      return;
    }
    label162:
    PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity, paramView, -5);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */