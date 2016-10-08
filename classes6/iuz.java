import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.FilterData;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;

public class iuz
  implements ViewPager.OnPageChangeListener
{
  private iuz(NewStoryFilterViewPagerController paramNewStoryFilterViewPagerController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = 0;
    int i = paramInt1 % this.a.jdField_a_of_type_Ivb.a();
    NewStoryFilterViewPagerController.FilterData localFilterData = this.a.jdField_a_of_type_Ivb.a(i);
    if (localFilterData != null) {}
    for (paramInt1 = localFilterData.e;; paramInt1 = 0)
    {
      localFilterData = this.a.jdField_a_of_type_Ivb.a((i + 1) % this.a.jdField_a_of_type_Ivb.a());
      if (localFilterData != null) {
        paramInt2 = localFilterData.e;
      }
      VideoSourceHelper.nativeSetPlayMode(paramInt1);
      VideoSourceHelper.nativeSetSlideMode(paramInt2, paramFloat);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a(paramInt1, paramInt2, paramFloat);
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    NewStoryFilterViewPagerController.FilterData localFilterData = this.a.jdField_a_of_type_Ivb.a(paramInt);
    if (localFilterData != null)
    {
      paramInt = localFilterData.e;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a(paramInt);
      if ((localFilterData == null) || ((localFilterData.d != 2) && (localFilterData.d != 3))) {
        break label83;
      }
    }
    label83:
    for (this.a.jdField_a_of_type_Boolean = true;; this.a.jdField_a_of_type_Boolean = false)
    {
      SLog.a("Q.qqstory.record.FilterViewPagerController", "mCanGetFilterBitmap = %s", Boolean.valueOf(this.a.jdField_a_of_type_Boolean));
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */