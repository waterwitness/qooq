package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DividerSegment
  extends SegmentView
{
  public static final String a = "DividerSegment";
  
  public DividerSegment(Context paramContext)
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
    return new BaseViewHolder(LayoutInflater.from(this.a).inflate(2130904442, paramViewGroup, false));
  }
  
  public String a()
  {
    return "DividerSegment";
  }
  
  public void a(Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\DividerSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */