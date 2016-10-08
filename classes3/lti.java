import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class lti
  extends ArrayAdapter
  implements View.OnClickListener
{
  Filter jdField_a_of_type_AndroidWidgetFilter;
  
  public lti(LoginActivity paramLoginActivity, Context paramContext)
  {
    super(paramContext, 2130903045, 2131296822, paramLoginActivity.jdField_a_of_type_JavaUtilList);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.app.b(((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin());
  }
  
  public String b(int paramInt)
  {
    return ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    }
    for (;;)
    {
      return super.getCount();
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(0);
    }
  }
  
  public Filter getFilter()
  {
    if (this.jdField_a_of_type_AndroidWidgetFilter == null) {
      this.jdField_a_of_type_AndroidWidgetFilter = new ltj(this);
    }
    return this.jdField_a_of_type_AndroidWidgetFilter;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (LinearLayout)paramView.findViewById(2131296820);
    ImageView localImageView = (ImageView)paramView.findViewById(2131296821);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.a(((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin(), false);
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      localImageView = (ImageView)paramView.findViewById(2131296823);
      localImageView.setTag(Integer.valueOf(paramInt));
      localImageView.setOnClickListener(this);
      localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getString(2131362080));
      paramView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getString(2131367467) + "%s", new Object[] { ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin() }));
      paramViewGroup.setOnClickListener(new ltk(this, paramInt));
      return paramView;
      localImageView.setImageResource(2130838678);
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.e = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.showDialog(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */