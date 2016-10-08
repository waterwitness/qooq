package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.OnSegmentDataChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class SegmentView
{
  public Context a;
  public MyStoryListEventListener a;
  public MystoryListView.OnSegmentDataChangeListener a;
  public SegmentList a;
  protected boolean b;
  protected boolean c;
  
  public SegmentView(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup);
  
  public BaseViewHolder a(int paramInt)
  {
    return null;
  }
  
  public abstract BaseViewHolder a(int paramInt, ViewGroup paramViewGroup);
  
  public abstract String a();
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(MyStoryListEventListener paramMyStoryListEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener = paramMyStoryListEventListener;
  }
  
  public void a(MystoryListView.OnSegmentDataChangeListener paramOnSegmentDataChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$OnSegmentDataChangeListener = paramOnSegmentDataChangeListener;
  }
  
  public void a(SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList = paramSegmentList;
  }
  
  public abstract void a(Object paramObject);
  
  public void b() {}
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void e() {}
  
  public void g() {}
  
  public void h() {}
  
  public void y_() {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\SegmentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */