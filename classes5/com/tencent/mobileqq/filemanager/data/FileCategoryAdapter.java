package com.tencent.mobileqq.filemanager.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.QQUtils;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List jdField_a_of_type_JavaUtilList;
  
  public FileCategoryAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, List paramList, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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
  
  public int getItemViewType(int paramInt)
  {
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).F == 0) {
      return 0;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).F == 3) {
      return 3;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).F == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localFileCategoryEntity == null)
    {
      localObject = null;
      return (View)localObject;
    }
    if (paramView == null)
    {
      localObject = new FileCategoryAdapter.ItemHolder(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localFileCategoryEntity.G, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject);
      if ((localFileCategoryEntity.F == 0) || (localFileCategoryEntity.F == 3))
      {
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131300934));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300935));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300938));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300936));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300937));
        ((FileCategoryAdapter.ItemHolder)localObject).c = ((TextView)paramView.findViewById(2131297387));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = localFileCategoryEntity.J;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFileCategoryEntity.jdField_c_of_type_JavaLangString;
      if (localFileCategoryEntity.F == 0)
      {
        if (localFileCategoryEntity.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label240:
          if (!localFileCategoryEntity.jdField_b_of_type_Boolean) {
            break label524;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localFileCategoryEntity.H);
          label268:
          if (localFileCategoryEntity.jdField_b_of_type_JavaLangString == null) {
            break label536;
          }
          paramViewGroup.c.setVisibility(0);
          paramViewGroup.c.setText(localFileCategoryEntity.jdField_b_of_type_JavaLangString);
          label296:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
          if (localFileCategoryEntity.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localFileCategoryEntity.I + ")");
          }
          switch (localFileCategoryEntity.K)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838349);
          }
        }
        for (;;)
        {
          if (16 != localFileCategoryEntity.J) {
            break label596;
          }
          paramViewGroup = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(35)).a(String.valueOf("100160.100162"));
          ((RedTouch)paramView).a(paramViewGroup);
          return paramView;
          if ((localFileCategoryEntity.F != 1) && (localFileCategoryEntity.F != 4)) {
            break label812;
          }
          ((FileCategoryAdapter.ItemHolder)localObject).d = ((TextView)paramView.findViewById(2131300908));
          ((FileCategoryAdapter.ItemHolder)localObject).e = ((TextView)paramView.findViewById(2131298715));
          paramViewGroup = (ViewGroup)localObject;
          break;
          paramViewGroup = (FileCategoryAdapter.ItemHolder)paramView.getTag();
          break;
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label240;
          label524:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label268;
          label536:
          paramViewGroup.c.setVisibility(8);
          break label296;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838349);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838357);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838352);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838355);
        }
        label596:
        if (17 == localFileCategoryEntity.J)
        {
          paramViewGroup = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(35)).a(String.valueOf("100160.100161"));
          ((RedTouch)paramView).a(paramViewGroup);
          return paramView;
        }
        ((RedTouch)paramView).b();
        return paramView;
      }
      if (localFileCategoryEntity.F == 1)
      {
        if (localFileCategoryEntity.jdField_a_of_type_Boolean)
        {
          paramViewGroup.e.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
          return paramView;
        }
        paramViewGroup.e.setVisibility(4);
        return paramView;
      }
      localObject = paramView;
      if (localFileCategoryEntity.F != 4) {
        break;
      }
      if (localFileCategoryEntity.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setGravity(17);
        localObject = paramView;
        if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362722) })) {
          break;
        }
        localObject = FileManagerUtil.a(localFileCategoryEntity.jdField_a_of_type_JavaLangString, localFileCategoryEntity.jdField_a_of_type_JavaLangString, null);
        paramViewGroup.e.setClickable(true);
        paramViewGroup.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.e.setText((CharSequence)localObject);
        paramViewGroup.e.setTag(paramViewGroup);
        return paramView;
      }
      paramViewGroup.e.setVisibility(4);
      return paramView;
      label812:
      paramViewGroup = (ViewGroup)localObject;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\FileCategoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */