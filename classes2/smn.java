import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class smn
  extends FreshNewsObserver
{
  public smn(FreshNewsFragment paramFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null);
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString);
    } while ((paramString == null) || (!(paramString instanceof FNDefaultItemData)));
    paramString = (FNDefaultItemData)paramString;
    paramString.f = paramBoolean2;
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "FreshnewsFragment onDeleteFeed isSuccess=" + paramBoolean + ",feedid=" + paramString1 + ",errTip=" + paramString2);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.e();
    }
    if (!this.a.c) {}
    do
    {
      return;
      if (!paramBoolean)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "删除失败";
        }
        this.a.a(1, paramString1, 0L);
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString1);
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "FreshnewsFragment onPublishComment isSuccess=" + paramBoolean + ",feedid=" + paramString1 + ",errTip=" + paramString2);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.e();
    }
    if (!this.a.c) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = "评论失败";
          }
          this.a.a(1, paramString1, 0L);
          return;
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null);
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString1);
    } while ((paramString1 == null) || (!(paramString1 instanceof FNDefaultItemData)));
    paramString1 = (FNDefaultItemData)paramString1;
    paramString1.h = paramInt1;
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List paramList, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "onGetFeed isSuccess = " + paramBoolean1 + ",complete = " + paramBoolean4 + ",errTip = " + paramString + " list.size = " + paramList.size() + ",cookie = " + paramArrayOfByte + ",mIsGettingData = " + this.a.d);
    }
    if (this.a.jdField_e_of_type_AndroidViewView.getVisibility() != 8) {
      this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    FreshNewsDetailActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    if (!this.a.d) {}
    do
    {
      return;
      this.a.d = false;
      this.a.a(paramBoolean1, paramBoolean3, 0L);
    } while (!paramBoolean1);
    if (this.a.jdField_e_of_type_Boolean)
    {
      if (this.a.jdField_a_of_type_Int > 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X800599B", "0X800599B", 0, 0, this.a.jdField_a_of_type_Int + "", "", "", "");
      }
      this.a.jdField_a_of_type_Int = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X800599A", "0X800599A", 0, 0, "", "", "", "");
      return;
    }
    paramList = this.a;
    paramList.jdField_a_of_type_Int += 1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */