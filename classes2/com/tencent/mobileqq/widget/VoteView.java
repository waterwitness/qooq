package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.SingleLineTextView;

public class VoteView
  extends RelativeLayout
{
  public static final String a = "VoteView";
  private double jdField_a_of_type_Double;
  public int a;
  public FrameLayout a;
  public TextView a;
  HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  FloatViewBuilder jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder;
  public SingleLineTextView a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private boolean b;
  
  public VoteView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    Object localObject = getResources();
    this.jdField_a_of_type_Double = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = new SingleLineTextView(getContext());
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setId(2131300563);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setBackgroundResource(2130841114);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(2130843100, 0);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(this.jdField_a_of_type_Double * 3.0D));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setPadding((int)(this.jdField_a_of_type_Double * 8.0D), (int)(this.jdField_a_of_type_Double * 3.0D), (int)(this.jdField_a_of_type_Double * 8.0D), (int)(this.jdField_a_of_type_Double * 3.0D));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(13.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_a_of_type_Double * 24.0D));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Double * 6.0D));
    addView(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131298511);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130843329);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumWidth((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(((Resources)localObject).getString(2131362058));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131300563);
    addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131298512);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 11.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, -2, -2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
    Object localObject3;
    int j;
    Object localObject2;
    int i;
    Object localObject1;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int > 0))
    {
      localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (paramBoolean)
      {
        j = 2130843322;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = 0;
        }
        localObject2 = String.valueOf(this.jdField_a_of_type_Int);
        i = j;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((RelativeLayout.LayoutParams)localObject3).width = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).height = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(3.0D % this.jdField_a_of_type_Double + 0.5D));
          localObject1 = localObject2;
          i = j;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(i);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(paramInt);
        localObject3 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label305;
        }
        localObject2 = "";
        label179:
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label332;
        }
        paramInt = 4;
        label198:
        ((TextView)localObject2).setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams(localLayoutParams);
      return;
      j = 2130843325;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = ((int)(15.0D * this.jdField_a_of_type_Double + 0.5D));
      }
      localObject2 = String.valueOf(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      i = j;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject3).width = -2;
      ((RelativeLayout.LayoutParams)localObject3).height = -2;
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
      i = j;
      localObject1 = localObject2;
      break;
      label305:
      localObject2 = "+" + this.jdField_b_of_type_Int;
      break label179;
      label332:
      paramInt = 0;
      break label198;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      localObject1 = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (paramInt2 <= this.jdField_a_of_type_Int) {
        break label203;
      }
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int % 20);
      label39:
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        break label238;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
        break label225;
      }
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(2130843101, 0);
    }
    for (;;)
    {
      setContentDescription(this.jdField_a_of_type_Int + "人已赞过");
      if (this.jdField_b_of_type_Boolean) {
        break label271;
      }
      a(false, 4);
      if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null))
      {
        paramNewVoteAnimHelper = new int[2];
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLocationInWindow(paramNewVoteAnimHelper);
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder = new FloatViewBuilder(getContext(), 2130841113);
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.a(), (float)(paramNewVoteAnimHelper[0] + this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.b() * 0.5D), paramNewVoteAnimHelper[1]);
      }
      return;
      paramInt1 = 0;
      break;
      label203:
      if (paramInt2 < 0)
      {
        this.jdField_b_of_type_Int = 0;
        break label39;
      }
      this.jdField_b_of_type_Int = paramInt2;
      break label39;
      label225:
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(2130843101, 0);
      continue;
      label238:
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout == null) {
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(2130843100, 0);
      } else {
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(2130843100, 0);
      }
    }
    label271:
    if (paramNewVoteAnimHelper != null)
    {
      paramNewVoteAnimHelper.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      return;
    }
    a(true, 0);
  }
  
  public void setHeartLayout(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
    FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\VoteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */