import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptObserver;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class ieg
  extends SubscriptObserver
{
  public ieg(SubscriptRecommendController paramSubscriptRecommendController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetRecommendList isSuccess: " + paramBoolean + " | data: " + paramList + " | isShowRecommend: " + this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_Boolean);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_Boolean))
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.a(paramList);
      paramList = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(SubscriptFeedsActivity.class);
      if ((paramList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendController.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof SubscriptFeedsActivity))) {
        paramList.sendEmptyMessage(1004);
      }
    }
    label146:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetRecommendList data is null or empty");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ieg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */