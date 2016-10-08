package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SegmentList$Builder
{
  private SegmentList a;
  
  public SegmentList$Builder(SegmentList.SegmentNotiChangeListener paramSegmentNotiChangeListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new SegmentList(null);
    this.a.a(paramSegmentNotiChangeListener);
  }
  
  public Builder a(SegmentView paramSegmentView)
  {
    SegmentList.a(this.a, paramSegmentView);
    paramSegmentView.a(this.a);
    return this;
  }
  
  public SegmentList a()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\SegmentList$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */