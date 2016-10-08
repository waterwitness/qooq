import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;

public class hum
  implements View.OnClickListener
{
  public hum(EcShopRecommendView paramEcShopRecommendView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    VipUtils.a(null, "Shop_lifeservice", "Shop_ulikeclose", "Shop_ulikeclose", 0, 0, new String[0]);
    ((EcShopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(68)).a(1);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
    EcShopRecommendView.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */