package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FriendTitleSegment
  extends SegmentView
{
  public static final String a = "friends_story_title";
  
  public FriendTitleSegment(Context paramContext)
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
    ((TextView)paramBaseViewHolder.a(2131302925)).setText("好 友 的 一 天");
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.a).inflate(2130904491, paramViewGroup, false));
  }
  
  public String a()
  {
    return "friends_story_title";
  }
  
  public void a(Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\FriendTitleSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */