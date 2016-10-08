package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import pil;

public class TroopListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private TroopListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public TroopListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131493346);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0).getBottom() == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.getItem(paramInt);
    } while (!(localObject1 instanceof TroopListAdapter.TroopListItem));
    Object localObject2 = (TroopListAdapter.TroopListItem)localObject1;
    Object localObject1 = null;
    switch (((TroopListAdapter.TroopListItem)localObject2).i)
    {
    default: 
      label124:
      if (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.getCount())
      {
        localObject2 = (TroopListAdapter.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.getItem(paramInt + 1);
        if ((((TroopListAdapter.TroopListItem)localObject2).i != 6) && (((TroopListAdapter.TroopListItem)localObject2).i != 4) && (((TroopListAdapter.TroopListItem)localObject2).i != 2)) {
          break label390;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (paramInt >= this.jdField_a_of_type_Int) {
            break label382;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.jdField_a_of_type_Int);
          label223:
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131364254, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.d) });
      break label124;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131364257, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.c) });
      break label124;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131364255, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.jdField_a_of_type_Int) });
      break label124;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131364256, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.b) });
      break label124;
      label382:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label223;
      label390:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  public ContactSearchFragment a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903793);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131299813));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299652));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelector(2131427379);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter = new TroopListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 4, false, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter);
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(new pil(this));
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131370197), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131370189));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.b();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (TroopListAdapter.TroopViewHolder)paramView.getTag();
    TroopInfo localTroopInfo;
    int i;
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      localTroopInfo = paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      if (localTroopInfo != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("group_uin", localTroopInfo.troopuin);
        localBundle.putString("group_name", localTroopInfo.troopname);
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8, localBundle);
        switch (paramView.jdField_a_of_type_Int)
        {
        case 2: 
        case 4: 
        case 6: 
        default: 
          i = 0;
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, localTroopInfo.troopuin + "", String.valueOf(i), "", "");
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\TroopListInnerFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */