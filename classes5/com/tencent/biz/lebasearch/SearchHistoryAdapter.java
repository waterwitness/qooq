package com.tencent.biz.lebasearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hjo;
import java.lang.ref.WeakReference;
import java.util.List;

public class SearchHistoryAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public SearchHistoryAdapter.OnItemClickObserver a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  List jdField_a_of_type_JavaUtilList;
  
  public SearchHistoryAdapter(Context paramContext, List paramList, SearchHistoryAdapter.OnItemClickObserver paramOnItemClickObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver = paramOnItemClickObserver;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (SearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    View localView;
    if (paramViewGroup == null) {
      localView = null;
    }
    do
    {
      return localView;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup).inflate(2130903626, null);
        paramViewGroup = new hjo(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299489));
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131299487));
        paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131299490));
        paramView.setTag(paramViewGroup);
        paramView.setOnClickListener(this);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Int = paramInt;
        if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((SearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).keyWord);
        return paramView;
        paramViewGroup = (hjo)paramView.getTag();
      }
      localView = paramView;
    } while (paramInt != this.jdField_a_of_type_JavaUtilList.size());
    paramViewGroup.b.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof hjo))
    {
      paramView = (hjo)paramView.getTag();
      if (paramView.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label69;
      }
      if (this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver != null)
      {
        paramView = (SearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramView.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver.a(paramView);
      }
    }
    label69:
    while ((paramView.jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\SearchHistoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */