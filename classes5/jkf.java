import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class jkf
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  
  public jkf(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297123));
    this.b = ((TextView)paramView.findViewById(2131297386));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296303));
    this.c = ((TextView)paramView.findViewById(2131297387));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297388));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297389);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */