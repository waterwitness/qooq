import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomAlertDialog;
import com.tencent.mobileqq.widget.CustomAlertDialog.OnPrepareOptionMenuItem;
import java.util.HashMap;
import java.util.List;

public class wlo
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList;
  
  public wlo(CustomAlertDialog paramCustomAlertDialog, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903192, null);
    }
    ((TextView)paramViewGroup.findViewById(2131297586)).setText((String)((HashMap)this.jdField_a_of_type_JavaUtilList.get(paramInt)).get("optionStr"));
    paramViewGroup.setOnClickListener(new wlp(this, paramInt));
    ((ImageView)paramViewGroup.findViewById(2131297585)).setImageResource(((Integer)((HashMap)this.jdField_a_of_type_JavaUtilList.get(paramInt)).get("imgId")).intValue());
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog$OnPrepareOptionMenuItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog$OnPrepareOptionMenuItem.a(paramInt, paramViewGroup);
    }
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */