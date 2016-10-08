package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.view.View;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import java.util.ArrayList;

public abstract interface MyStoryListEventListener
{
  public abstract void a(int paramInt, View paramView, StoryItem paramStoryItem);
  
  public abstract void a(int paramInt, View paramView, RecommendItem paramRecommendItem);
  
  public abstract void a(int paramInt, HotTopicItem paramHotTopicItem, View paramView);
  
  public abstract void a(int paramInt, StoryItem paramStoryItem, View paramView);
  
  public abstract void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView);
  
  public abstract void a(int paramInt, MyStorys paramMyStorys);
  
  public abstract void a(MyStorys paramMyStorys, View paramView);
  
  public abstract void b(int paramInt, View paramView, StoryItem paramStoryItem);
  
  public abstract void b(int paramInt, StoryItem paramStoryItem, View paramView);
  
  public abstract void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView);
  
  public abstract void b(ArrayList paramArrayList);
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\MyStoryListEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */