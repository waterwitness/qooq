import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rdt
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List jdField_a_of_type_JavaUtilList;
  List b;
  
  public rdt(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = null;
    this.b = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(List paramList1, List paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    notifyDataSetChanged();
  }
  
  boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return false;
    }
    return true;
  }
  
  boolean a(appoint_define.LocaleInfo paramLocaleInfo)
  {
    return !TextUtils.isEmpty(paramLocaleInfo.str_region.get());
  }
  
  public void b(List paramList1, List paramList2)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramList1 != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
      }
      if (this.b == null) {
        break label57;
      }
      if (paramList2 != null) {
        this.b.addAll(paramList2);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList = paramList1;
      break;
      label57:
      this.b = paramList2;
    }
  }
  
  public int getCount()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (this.b != null) {
        j = this.b.size();
      }
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        return (appoint_define.LocaleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
      return (appoint_define.LocaleInfo)this.b.get(paramInt - this.jdField_a_of_type_JavaUtilList.size());
    }
    return (appoint_define.LocaleInfo)this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.getLayoutInflater().inflate(2130904138, paramViewGroup, false);
      paramView.setTag(new rdu(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity, (TextView)paramView.findViewById(2131301538), (TextView)paramView.findViewById(2131301539)));
      localView = paramView;
      if (this.jdField_a_of_type_Int == 0)
      {
        paramViewGroup = paramView.findViewById(2131301539);
        paramViewGroup.setVisibility(0);
        paramView.measure(-1, -1);
        paramViewGroup.setVisibility(8);
        this.jdField_a_of_type_Int = (paramView.getMeasuredHeight() - (int)(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.getResources().getDisplayMetrics().density * 30.0F));
        localView = paramView;
      }
    }
    rdu localrdu;
    appoint_define.LocaleInfo localLocaleInfo;
    if (getCount() == 1)
    {
      localView.setBackgroundResource(2130838349);
      localrdu = (rdu)localView.getTag();
      localLocaleInfo = (appoint_define.LocaleInfo)getItem(paramInt);
      if (!a(paramInt)) {
        break label499;
      }
      if (!a(localLocaleInfo)) {
        break label440;
      }
      localrdu.b.setVisibility(0);
      String str = localLocaleInfo.str_name.get();
      localrdu.a.setText(str);
      paramViewGroup = localLocaleInfo.str_address.get();
      paramView = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup))
      {
        paramView = localLocaleInfo.str_city.get();
        paramView = paramView + " " + localLocaleInfo.str_region.get();
      }
      localrdu.b.setText(paramView);
      localView.setContentDescription("搜索结果 " + str + " " + paramView);
      paramInt = 0;
      label302:
      if ((paramInt != 0) || (!TextUtils.isEmpty(paramView))) {
        break label600;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatingDestinationActivity", 2, "has no address:" + localLocaleInfo.str_name.get());
      }
      paramInt = 1;
    }
    label440:
    label499:
    label600:
    for (;;)
    {
      if (paramInt != 0)
      {
        localrdu.b.setVisibility(8);
        paramView = localrdu.a.getLayoutParams();
        paramView.height = this.jdField_a_of_type_Int;
        localrdu.a.setLayoutParams(paramView);
        return localView;
        if (paramInt == 0)
        {
          localView.setBackgroundResource(2130838357);
          break;
        }
        if (paramInt == getCount() - 1)
        {
          localView.setBackgroundResource(2130838352);
          break;
        }
        localView.setBackgroundResource(2130838355);
        break;
        localrdu.b.setVisibility(8);
        paramView = localLocaleInfo.str_name.get();
        localrdu.a.setText(paramView);
        localView.setContentDescription("搜索结果 " + paramView);
        paramView = null;
        paramInt = 1;
        break label302;
        localrdu.b.setVisibility(0);
        paramView = localLocaleInfo.str_name.get();
        localrdu.a.setText(paramView);
        paramView = localLocaleInfo.str_address.get();
        localrdu.b.setText(paramView);
        localView.setContentDescription("搜索结果 " + paramView);
        paramInt = 0;
        break label302;
      }
      paramView = localrdu.a.getLayoutParams();
      paramView.height = -2;
      localrdu.a.setLayoutParams(paramView);
      return localView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */