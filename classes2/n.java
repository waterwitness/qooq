import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.activities.DLRouterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class n
  extends BaseAdapter
{
  private o jdField_a_of_type_O;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int[][] jdField_a_of_type_Array2dOfInt;
  private final int[] jdField_b_of_type_ArrayOfInt;
  private final int[][] jdField_b_of_type_Array2dOfInt;
  private final int[] c;
  private final int[] d;
  private final int[] e;
  
  private n(DLRouterActivity paramDLRouterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131362138, 2130838162 };
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2131362140, 2130838169 };
    this.c = new int[] { 2131362333, 2130838161 };
    this.d = new int[] { 2131362334, 2130838151 };
    this.e = new int[] { 2131362335, 2130838152 };
    this.jdField_a_of_type_Array2dOfInt = new int[][] { this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.c, this.d, this.e };
    this.jdField_b_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt;
  }
  
  public int[][] a()
  {
    return this.jdField_b_of_type_Array2dOfInt;
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_Array2dOfInt.length;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getLayoutInflater().inflate(2130903262, null);
    }
    this.jdField_a_of_type_O = ((o)paramViewGroup.getTag());
    if (this.jdField_a_of_type_O == null)
    {
      this.jdField_a_of_type_O = new o(this, null);
      this.jdField_a_of_type_O.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297585));
      this.jdField_a_of_type_O.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297586));
    }
    this.jdField_a_of_type_O.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_Array2dOfInt[paramInt][0]);
    paramView = this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getResources().getDrawable(this.jdField_b_of_type_Array2dOfInt[paramInt][1]);
    this.jdField_a_of_type_O.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
    paramViewGroup.setTag(this.jdField_a_of_type_O);
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */