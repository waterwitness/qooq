import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.activity.recent.RecommendCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class oym
  implements Runnable
{
  oym(oyl paramoyl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {}
    try
    {
      this.a.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.endFakeDrag();
      this.a.a.jdField_a_of_type_Boolean = false;
      RecommendCallHelper.a(this.a.a, 1000);
      return;
    }
    catch (Exception localException1) {}
    try
    {
      this.a.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.endFakeDrag();
      this.a.a.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */