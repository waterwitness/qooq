import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class lvv
  extends BaseAdapter
{
  private lvv(MoveToGroupActivity paramMoveToGroupActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return this.a.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
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
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903410, null);
    }
    int i = (byte)((Groups)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).group_id;
    paramView = (ImageView)paramViewGroup.findViewById(2131298473);
    if (i == this.a.jdField_a_of_type_Byte) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      paramView = (TextView)paramViewGroup.findViewById(2131298472);
      paramView.setText(((Groups)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).group_name);
      paramViewGroup.setContentDescription(paramView.getText().toString());
      paramViewGroup.setTag(Integer.valueOf(paramInt));
      paramViewGroup.setOnClickListener(this.a);
      return paramViewGroup;
      paramView.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */