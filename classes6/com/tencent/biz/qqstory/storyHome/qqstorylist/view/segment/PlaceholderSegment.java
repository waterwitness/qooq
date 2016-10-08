package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView.LayoutParams;

public class PlaceholderSegment
  extends SegmentView
{
  public static final String a = "PlaceholderSegment";
  private static final String b = "PlaceholderSegment";
  private boolean a;
  private boolean d;
  
  public PlaceholderSegment(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = false;
  }
  
  public int a()
  {
    if (this.b) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904447, paramViewGroup, false);
    Object localObject = (RelativeLayout)paramViewGroup.findViewById(2131302768);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131302769);
    float f2 = UIUtils.b(this.jdField_a_of_type_AndroidContentContext) - UIUtils.c(this.jdField_a_of_type_AndroidContentContext) - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 80.0F) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 98.0F);
    float f1 = f2;
    if (this.d) {
      f1 = f2 - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 54.0F);
    }
    if (this.jdField_a_of_type_Boolean) {
      f1 = f1 - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 60.0F) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 134.0F);
    }
    for (;;)
    {
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.height = ((int)f1);
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      if (f1 < 300.0F) {
        localImageView.setVisibility(4);
      }
      for (;;)
      {
        return new BaseViewHolder(paramViewGroup);
        localImageView.setVisibility(0);
        if (f1 < UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 205.0F))
        {
          localObject = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = ((int)(f1 - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 30.0F)));
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public String a()
  {
    return "PlaceholderSegment";
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\PlaceholderSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */