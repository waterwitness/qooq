import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class lpc
  implements BounceScrollView.OnScrollChangedListener
{
  public lpc(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 >= this.a.h + DisplayUtil.a(this.a, 50.0F))
    {
      this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.a.getResources().getDrawable(2130843150));
      this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131428260));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131428260));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.a.getResources().getDrawable(2130843454));
      this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.getResources().getDrawable(2130843223));
      this.a.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.getResources().getDrawable(2130843226));
      return;
    }
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.a.getResources().getDrawable(2130843567));
    this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.a.getResources().getDrawable(2130839129));
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.getResources().getDrawable(2130843222));
    this.a.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.getResources().getDrawable(2130843225));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */