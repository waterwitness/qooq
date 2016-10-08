import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager.Config;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.freshnews.QQInputPopupWindow.IQQInputPopupWindowCallback;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class spr
  implements QQInputPopupWindow.IQQInputPopupWindowCallback
{
  public spr(FreshNewsFeedAdapter paramFreshNewsFeedAdapter, FNDefaultItemData paramFNDefaultItemData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return AIOUtils.a(100.0F, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
  }
  
  public String a()
  {
    FreshNewsManager localFreshNewsManager = (FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(211);
    if (localFreshNewsManager == null) {
      return "";
    }
    return localFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.e, null);
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "onSend content = " + paramString + ",feedid = " + this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.e);
    }
    FreshNewsManager localFreshNewsManager = (FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(211);
    if (!localFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.b))
    {
      paramString = localFreshNewsManager.a();
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.cannotCommentTip)))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString.cannotCommentTip, 0).b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131372185), 0).b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localFreshNewsManager.b();
    if ((l1 > l2) && (l1 - l2 < 10000L))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131372186), 0).b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.b("评论中...");
    paramString = FreshNewsUtil.a(false, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.e, (int)(System.currentTimeMillis() / 1000L), paramString, "", 0L);
    ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.e, paramString, 0, "");
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "onQQInputPopupWindowDismiss content=" + paramString + ",feedid=" + this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.e);
    }
    ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(211)).a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.e, "", paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */