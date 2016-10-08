import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;

public class rey
{
  public View a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public XListView a;
  public boolean a;
  public View b;
  
  public rey(View paramView, XListView paramXListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131301542));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301543));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301544));
    this.b = paramView.findViewById(2131301541);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368207);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368205);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131371591);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */