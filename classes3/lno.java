import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lno
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public lno(GesturePWDCreateActivity paramGesturePWDCreateActivity, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length) && (paramInt >= 0)) {
      return Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a[paramInt]);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903367, null);
    }
    paramView = paramViewGroup.findViewById(2131298302);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length) && (this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a[paramInt] > 0))
    {
      paramView.setBackgroundResource(2130840729);
      return paramViewGroup;
    }
    paramView.setBackgroundResource(2130843537);
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */