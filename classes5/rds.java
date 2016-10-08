import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;

public class rds
  extends BaseAdapter
{
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  
  public rds(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
    }
    for (;;)
    {
      if (paramString.hasNext())
      {
        appoint_define.LocaleInfo localLocaleInfo = (appoint_define.LocaleInfo)paramString.next();
        if ((localLocaleInfo.str_name != null) && (this.jdField_a_of_type_JavaLangString.equals(localLocaleInfo.str_name.get()))) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else
      {
        notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        appoint_define.LocaleInfo localLocaleInfo = (appoint_define.LocaleInfo)paramList.next();
        if ((localLocaleInfo.str_name != null) && (this.jdField_a_of_type_JavaLangString.equals(localLocaleInfo.str_name.get()))) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else
      {
        notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  boolean a(appoint_define.LocaleInfo paramLocaleInfo1, appoint_define.LocaleInfo paramLocaleInfo2)
  {
    paramLocaleInfo1 = paramLocaleInfo1.str_name.get();
    paramLocaleInfo2 = paramLocaleInfo2.str_name.get();
    if ((paramLocaleInfo1 == null) || (paramLocaleInfo2 == null)) {
      return false;
    }
    return paramLocaleInfo1.equals(paramLocaleInfo2);
  }
  
  public int getCount()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        j = this.jdField_a_of_type_JavaUtilList.size();
      }
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_JavaLangString != null)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      int i = paramInt;
      if (this.jdField_a_of_type_JavaLangString != null) {
        i = paramInt - 1;
      }
      return (appoint_define.LocaleInfo)localList.get(i);
    }
    return null;
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
      localView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.getLayoutInflater().inflate(2130904136, paramViewGroup, false);
      localView.setTag(new rdr(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity, (TextView)localView.findViewById(2131301070), (TextView)localView.findViewById(2131301534), (ImageView)localView.findViewById(2131301532)));
    }
    if (getCount() == 1) {
      localView.setBackgroundResource(2130838349);
    }
    for (;;)
    {
      paramView = (rdr)localView.getTag();
      if ((paramInt != 0) || (this.jdField_a_of_type_JavaLangString == null)) {
        break label246;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      paramView.b.setText("故乡");
      localView.setContentDescription(this.jdField_a_of_type_JavaLangString + " 你的故乡  选为目的地按钮");
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.f != 2) {
        break;
      }
      paramView.b.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return localView;
      if (paramInt == 0) {
        localView.setBackgroundResource(2130838357);
      } else if (paramInt == getCount() - 1) {
        localView.setBackgroundResource(2130838352);
      } else {
        localView.setBackgroundResource(2130838355);
      }
    }
    paramView.b.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return localView;
    label246:
    paramViewGroup = (appoint_define.LocaleInfo)getItem(paramInt);
    paramView.b.setVisibility(8);
    paramView.b.setText("");
    String str = paramViewGroup.str_name.get();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localView.setContentDescription(str + " 选为目的地 按钮");
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.f == 3) && (a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.b)))
    {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return localView;
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */