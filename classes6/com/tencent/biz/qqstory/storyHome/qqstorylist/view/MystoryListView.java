package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.DividerSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FriendTitleSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FriendsSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.HotTopicTitleSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MyStoryChildSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MyStorySegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.OfficialRecommendSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.OfficialRecommendTitle;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.PlaceholderSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.RecentStorySegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.RecentTitleSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.SegmentList;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.SegmentList.Builder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.SegmentList.SegmentNotiChangeListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.SegmentView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.SplashSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.StoryHomeAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.UGCSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import itn;
import ito;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MystoryListView
  extends XListView
  implements SegmentList.SegmentNotiChangeListener, OverScrollViewListener
{
  public static final String a = "Q.qqstory.home.MystoryListView";
  protected MyStorys a;
  public MyStoryListEventListener a;
  private MystoryListView.OnSegmentDataChangeListener a;
  public PullRefreshHeader a;
  public StoryHomeAdapter a;
  protected boolean a;
  private boolean b;
  
  public MystoryListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$OnSegmentDataChangeListener = new ito(this);
    E();
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$OnSegmentDataChangeListener = new ito(this);
    E();
  }
  
  public MystoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$OnSegmentDataChangeListener = new ito(this);
    E();
  }
  
  private void E()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = new MyStorys();
    Object localObject = new SegmentList.Builder(this).a(new MyStorySegment(getContext())).a(new SplashSegment(getContext(), "mystory_splash_top")).a(new MyStoryChildSegment(getContext())).a(new SplashSegment(getContext(), "mystory_splash_bottom")).a(new DividerSegment(getContext())).a(new OfficialRecommendTitle(getContext())).a(new OfficialRecommendSegment(getContext())).a(new PlaceholderSegment(getContext())).a(new RecentTitleSegment(getContext())).a(new RecentStorySegment(getContext())).a(new HotTopicTitleSegment(getContext())).a(new UGCSegment(getContext())).a(new FriendTitleSegment(getContext())).a(new FriendsSegment(getContext()));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter = new StoryHomeAdapter(getContext(), (SegmentList.Builder)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SegmentView localSegmentView = (SegmentView)((Iterator)localObject).next();
      if (localSegmentView != null) {
        localSegmentView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView$OnSegmentDataChangeListener);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2130904478, this, false));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.setHeaderBgColor(-16777216);
    super.setOverScrollHeader(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader);
    super.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    super.setOverScrollListener(this);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
    super.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter);
    super.setOnScrollListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter);
  }
  
  private void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("PlaceholderSegment", false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("friends_story", paramArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("friends_story_title", true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.notifyDataSetChanged();
  }
  
  public void a()
  {
    ((MyStorySegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("my_story")).w_();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
      while (localIterator.hasNext())
      {
        SegmentView localSegmentView = (SegmentView)localIterator.next();
        if (localSegmentView != null) {
          localSegmentView.a(paramInt1, paramInt2, paramIntent);
        }
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.c(0L);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      if (paramString1.equals(IPreloadVideoSource.b)) {
        ((FriendsSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("friends_story")).a(l);
      }
      do
      {
        return;
        if (paramString1.equals(IPreloadVideoSource.a))
        {
          ((RecentStorySegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("recent_story")).a(l);
          return;
        }
      } while (!paramString1.equals(IPreloadVideoSource.c));
      ((MyStorySegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("my_story")).x_();
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(boolean paramBoolean)
  {
    ((MyStorySegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("my_story")).a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SLog.a("Q.qqstory.home.MystoryListView", "pullRefreshCompleted success=%s,isManualPullRefresh=%s", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
    Object localObject;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        localObject = "1";
        StoryReportor.a("home_page", "refresh", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label147;
      }
      if (paramBoolean2) {
        StoryReportor.a("home_page", "network", 0, 0, new String[] { "", "", StoryReportor.a(getContext()) });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(0);
      localObject = QQStoryContext.a().a();
      if (localObject != null) {
        ((TroopRedTouchManager)((QQAppInterface)localObject).getManager(69)).a();
      }
    }
    for (;;)
    {
      postDelayed(new itn(this), 800L);
      return;
      localObject = "2";
      break;
      label147:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(1);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(0L);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.e();
    }
    while (paramInt != 1) {
      return true;
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.notifyDataSetChanged();
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.b(0L);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a() == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(paramBoolean);
    b();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
      while (localIterator.hasNext())
      {
        SegmentView localSegmentView = (SegmentView)localIterator.next();
        if (localSegmentView != null) {
          localSegmentView.c();
        }
      }
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(0L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_top", true);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_bottom", true);
    }
    for (;;)
    {
      b();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_top", false);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_bottom", false);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
      while (localIterator.hasNext())
      {
        SegmentView localSegmentView = (SegmentView)localIterator.next();
        if (localSegmentView != null) {
          localSegmentView.g();
        }
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
      while (localIterator.hasNext())
      {
        SegmentView localSegmentView = (SegmentView)localIterator.next();
        if (localSegmentView != null) {
          localSegmentView.b();
        }
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
      while (localIterator.hasNext())
      {
        SegmentView localSegmentView = (SegmentView)localIterator.next();
        if (localSegmentView != null) {
          localSegmentView.y_();
        }
      }
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
      while (localIterator.hasNext())
      {
        SegmentView localSegmentView = (SegmentView)localIterator.next();
        if (localSegmentView != null) {
          localSegmentView.h();
        }
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a != null))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a.iterator();
        while (localIterator.hasNext())
        {
          SegmentView localSegmentView = (SegmentView)localIterator.next();
          if (localSegmentView != null) {
            localSegmentView.e();
          }
        }
      }
      ((MyStorySegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("my_story")).d();
    }
  }
  
  public void setData(MyStorys paramMyStorys, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    String str1;
    label42:
    String str2;
    label60:
    String str3;
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      if ((paramArrayList3 == null) || (paramArrayList3.size() == 0))
      {
        i = 2;
        if ((paramArrayList1 != null) && (paramArrayList1.size() != 0)) {
          break label419;
        }
        str1 = "2";
        if ((paramArrayList4 != null) && (paramArrayList4.size() != 0)) {
          break label427;
        }
        str2 = "2";
        if ((paramArrayList2 != null) && (paramArrayList2.size() != 0)) {
          break label435;
        }
        str3 = "2";
        label76:
        StoryReportor.a("home_page", "exp", 0, i, new String[] { str1, str2, str3 });
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(paramMyStorys.a());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("my_story", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("my_story_child", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("offical_recommend", paramArrayList2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("recent_story", paramArrayList1);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("DividerSegment", true);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("friends_story", paramArrayList3);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("UGCSegment", paramArrayList4);
      if ((paramArrayList1 == null) || (paramArrayList1.size() <= 0)) {
        break label443;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("recent_story_title", true);
      label238:
      if ((paramArrayList3 == null) || (paramArrayList3.size() <= 0)) {
        break label457;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("friends_story_title", true);
      label261:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("UGCSegment", true);
      if ((paramArrayList4 == null) || (paramArrayList4.size() <= 0)) {
        break label470;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("HotTopicTitleSegment", true);
      label296:
      if ((paramArrayList2 == null) || (paramArrayList2.size() <= 0)) {
        break label484;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("OfficialRecommendTitle", true);
      label318:
      if ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a() <= 0)) {
        break label498;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_top", true);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_bottom", true);
      label358:
      if (((paramArrayList1 != null) && (paramArrayList1.size() != 0)) || ((paramArrayList4 != null) && (paramArrayList4.size() != 0)) || ((paramArrayList3 != null) && (paramArrayList3.size() != 0))) {
        break label521;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("PlaceholderSegment", true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.notifyDataSetChanged();
      return;
      i = 1;
      break;
      label419:
      str1 = "1";
      break label42;
      label427:
      str2 = "1";
      break label60;
      label435:
      str3 = "1";
      break label76;
      label443:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("recent_story_title", false);
      break label238;
      label457:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("friends_story_title", false);
      break label261;
      label470:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("HotTopicTitleSegment", false);
      break label296;
      label484:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("OfficialRecommendTitle", false);
      break label318;
      label498:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_top", false);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("mystory_splash_bottom", false);
      break label358;
      label521:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("PlaceholderSegment", false);
      if (((paramArrayList1 == null) || (paramArrayList1.size() == 0)) && ((paramArrayList4 == null) || (paramArrayList4.size() == 0)) && ((paramArrayList3 == null) || (paramArrayList3.size() == 0)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("PlaceholderSegment", true);
        ((PlaceholderSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("PlaceholderSegment")).b(this.b);
        if ((paramArrayList2 == null) || (paramArrayList2.size() == 0)) {
          ((PlaceholderSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("PlaceholderSegment")).a(false);
        } else {
          ((PlaceholderSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a.a("PlaceholderSegment")).a(true);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a("PlaceholderSegment", false);
      }
    }
  }
  
  public void setListEventListener(MyStoryListEventListener paramMyStoryListEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener = paramMyStoryListEventListener;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a(paramMyStoryListEventListener);
  }
  
  public void setLoadMoreCompleted(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void setOneSegmentData(String paramString, Object paramObject)
  {
    if ("friends_story".equals(paramString))
    {
      a((ArrayList)paramObject);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.a(paramString, paramObject);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentStoryHomeAdapter.notifyDataSetChanged();
  }
  
  public void setmIsNow(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\MystoryListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */