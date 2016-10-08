package com.tencent.mobileqq.activity.qqcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class QQCardAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CardItemBuilderFactory jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory;
  private List jdField_a_of_type_JavaUtilList;
  
  public QQCardAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory = new CardItemBuilderFactory(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory.a(this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    BaseCardItemBuilder localBaseCardItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory.a(localObject);
    if ((localBaseCardItemBuilder == null) || (localObject == null)) {
      return null;
    }
    return localBaseCardItemBuilder.a(localObject, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */