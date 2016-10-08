import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.activity.recent.RecommendCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oyl
  implements Runnable
{
  public oyl(RecommendCallHelper paramRecommendCallHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager != null)
    {
      if ((this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount() > 1) && (this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0)) {
        break label68;
      }
      this.a.jdField_a_of_type_Boolean = false;
      if (this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount() <= 1) {
        RecommendCallHelper.a(this.a, 0);
      }
    }
    label68:
    while ((!this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.isFakeDragging()) && (!this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.beginFakeDrag())) {
      return;
    }
    float f1 = this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.getWidth() / 40;
    int i = 0;
    int j = 30;
    while (i < 20)
    {
      float f2 = f1;
      if (i == 10)
      {
        f2 = -f1;
        j = 30;
      }
      this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.postDelayed(new oyp(this.a, f2), i * j);
      i += 1;
      f1 = f2;
    }
    this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.postDelayed(new oym(this), 700L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */