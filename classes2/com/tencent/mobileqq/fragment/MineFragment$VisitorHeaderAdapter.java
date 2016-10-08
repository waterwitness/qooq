package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.widget.CustomImgView;
import java.util.ArrayList;
import java.util.List;

public class MineFragment$VisitorHeaderAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList;
  
  public MineFragment$VisitorHeaderAdapter(MineFragment paramMineFragment, Context paramContext, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public StrangerInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0; (paramInt >= 0) && (paramInt < i); i = this.jdField_a_of_type_JavaUtilList.size()) {
      return (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904141, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
    }
    for (;;)
    {
      paramViewGroup = (CustomImgView)paramView;
      StrangerInfo localStrangerInfo = a(paramInt);
      if (localStrangerInfo != null)
      {
        Drawable localDrawable = paramViewGroup.a();
        if ((localDrawable != null) && ((localDrawable instanceof AsynLoadDrawable))) {
          ((AsynLoadDrawable)localDrawable).a();
        }
        paramViewGroup.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment.a, 202, String.valueOf(localStrangerInfo.tinyId), true));
      }
      return paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\MineFragment$VisitorHeaderAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */