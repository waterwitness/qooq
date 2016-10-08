package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SplashSegment
  extends SegmentView
{
  protected String a;
  
  public SplashSegment(Context paramContext, String paramString)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
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
    paramViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setMinimumHeight(DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 4.0F));
    return new BaseViewHolder(paramViewGroup);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\SplashSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */