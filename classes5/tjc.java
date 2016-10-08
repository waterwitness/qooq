import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

public class tjc
  implements Runnable
{
  public tjc(NearbyGuideActivity paramNearbyGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = (int)(this.a.b.getBottom() - this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() + 30.0F * this.a.getResources().getDisplayMetrics().density);
    this.a.jdField_a_of_type_AndroidWidgetScrollView.smoothScrollBy(0, i);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */