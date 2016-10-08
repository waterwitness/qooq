import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.activity.recent.RecommendCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oyp
  implements Runnable
{
  private float jdField_a_of_type_Float;
  
  public oyp(RecommendCallHelper paramRecommendCallHelper, float paramFloat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager.getVisibility() == 0))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager.isFakeDragging()) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager.beginFakeDrag()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager.fakeDragBy(this.jdField_a_of_type_Float);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager.endFakeDrag();
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager.endFakeDrag();
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_Boolean = false;
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_AndroidSupportV4ViewViewPager.endFakeDrag();
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecommendCallHelper.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */