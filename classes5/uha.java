import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.ActionGridActivity;
import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import java.util.ArrayList;

public class uha
  extends GridListView.GridListAdapter
{
  private uha(ActionGridActivity paramActionGridActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public int getCount()
  {
    return ActionGridActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ActionGridActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130905016, null);
      paramView = new uhb(null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131305046));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131305047));
      paramViewGroup.setTag(paramView);
    }
    paramView = (uhb)paramViewGroup.getTag();
    ActionInfo localActionInfo = (ActionInfo)ActionGridActivity.a(this.a).get(paramInt);
    if (paramView.jdField_a_of_type_Int != localActionInfo.i)
    {
      paramView.jdField_a_of_type_Int = localActionInfo.i;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(this.a.getResources(), ActionGridActivity.a(this.a).a(localActionInfo.i, 201), false, false));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localActionInfo.c);
    }
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */