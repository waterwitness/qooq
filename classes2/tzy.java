import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class tzy
  extends BaseAdapter
{
  public List a;
  boolean jdField_a_of_type_Boolean;
  
  public tzy(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    if ((QCallDetailActivity.a(paramQCallDetailActivity) != null) && (QCallDetailActivity.a(paramQCallDetailActivity).a() == 1)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private int a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.isSender()) {
      return 2130840613;
    }
    if ((paramQCallRecord.isMissCall()) || (paramQCallRecord.state == 1) || ((paramQCallRecord.uinType == 3000) && (paramQCallRecord.state == 8))) {
      return 2130840619;
    }
    return 2130840608;
  }
  
  private String a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord.uinType == 3000)
    {
      switch (paramQCallRecord.state)
      {
      default: 
        paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371145);
      case 1: 
      case 2: 
      case 8: 
      case 3: 
      case 4: 
        String str;
        do
        {
          return paramQCallRecord;
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371145);
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371142);
          paramQCallRecord = paramQCallRecord.getTalkTimeMinute();
          return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371143, new Object[] { paramQCallRecord });
          str = paramQCallRecord.getTalkTimeMinute();
          paramQCallRecord = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371144);
        } while (TextUtils.isEmpty(str));
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371143, new Object[] { str });
      }
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371124), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371141);
    }
    switch (paramQCallRecord.state)
    {
    default: 
      return "";
    case 0: 
    case 9: 
    case 15: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371124), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371125);
    case 2: 
    case 24: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371124), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371126);
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371142);
    case 3: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131363327);
    case 10: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371142);
    case 7: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131363320);
    case 12: 
      if (paramQCallRecord.isSender()) {
        return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371141);
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371142);
    case 42: 
    case 43: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371141);
    case 46: 
    case 47: 
    case 48: 
      if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
        return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371124), new Object[] { paramQCallRecord.getTalkTimeMinute() });
      }
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371125);
    case 49: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131363669);
    case 6: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371142);
    case 58: 
      return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371157);
    }
    if (!TextUtils.isEmpty(paramQCallRecord.getTalkTimeMinute())) {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371124), new Object[] { paramQCallRecord.getTalkTimeMinute() });
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131371141);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
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
  
  public int getItemViewType(int paramInt)
  {
    if (((QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt)).type == QCallRecord.TYPE_DATE) {
      return QCallRecord.TYPE_DATE;
    }
    return QCallRecord.TYPE_REALRECORD;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    paramViewGroup = paramView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new tzz();
      if (i == QCallRecord.TYPE_DATE)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130904101, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301392));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299583));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301422));
        paramView.setTag(paramViewGroup);
        paramViewGroup = paramView;
      }
    }
    else
    {
      paramView = (tzz)paramViewGroup.getTag();
      localObject = (QCallRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (i != QCallRecord.TYPE_DATE) {
        break label237;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((QCallRecord)localObject).getDateString());
      paramInt = this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getResources().getColor(2131428215);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(paramInt);
    }
    label237:
    label325:
    label383:
    label389:
    label505:
    for (;;)
    {
      return paramViewGroup;
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).inflate(2130904106, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299892));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297923));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301421));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131301424));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301422));
      break;
      String str1 = ((QCallRecord)localObject).getTime();
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(a((QCallRecord)localObject));
      String str2;
      if (((QCallRecord)localObject).state == 59)
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        str2 = a((QCallRecord)localObject);
        paramView.c.setText(str2);
        if (!((QCallRecord)localObject).isVideo()) {
          break label389;
        }
        localObject = paramView.jdField_b_of_type_AndroidWidgetTextView;
        if (!this.jdField_a_of_type_Boolean) {
          break label383;
        }
        paramInt = 2131371104;
        ((TextView)localObject).setText(paramInt);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        if (!AppSetting.j) {
          break label505;
        }
        paramViewGroup.setContentDescription(str1 + str2);
        return paramViewGroup;
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        paramInt = 2131371105;
        break label325;
        if ((((QCallRecord)localObject).state == 58) || (((QCallRecord)localObject).state == 59) || (((QCallRecord)localObject).uinType == 26))
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else if (((QCallRecord)localObject).uinType == 8)
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else if (this.jdField_a_of_type_Boolean)
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getString(2131363235));
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else
        {
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */