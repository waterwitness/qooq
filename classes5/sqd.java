import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class sqd
  implements Runnable
{
  sqd(sqc paramsqc, FNDefaultItemData paramFNDefaultItemData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FreshNewsManager localFreshNewsManager = (FreshNewsManager)this.jdField_a_of_type_Sqc.a.a.getManager(211);
    FreshNewsInfo localFreshNewsInfo = this.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData.a;
    if (localFreshNewsInfo != null) {
      localFreshNewsManager.a(localFreshNewsInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Sqc.a.a.a("CliOper", "", "", "0X800577B", "0X800577B", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "click failimg|info is null");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */