import android.widget.LinearLayout;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.List;

public class ssc
  implements AbsListView.OnScrollListener
{
  public ssc(NearbyTopicFeedActivity paramNearbyTopicFeedActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      if ((!this.a.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.t() == this.a.jdField_a_of_type_ComTencentWidgetXListView.d_() - 1) && (this.a.c != 1) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.getHeight() <= this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom()))
      {
        this.a.e();
        this.a.a(true, true);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 1) {
          break;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null);
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.b();
      return;
    } while (paramInt != 2);
    this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */