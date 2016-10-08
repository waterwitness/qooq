import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hlb
  implements View.OnClickListener
{
  public hlb(EqqAccountDetailActivity paramEqqAccountDetailActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.b);
    EqqAccountDetailActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */