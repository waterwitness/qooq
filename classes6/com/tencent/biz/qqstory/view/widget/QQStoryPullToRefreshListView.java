package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.PullRefreshHeader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import jac;

public class QQStoryPullToRefreshListView
  extends XListView
  implements AbsListView.OnScrollListener, OverScrollViewListener
{
  public PullRefreshHeader a;
  public LoadingMoreHelper a;
  protected QQStoryPullToRefreshListView.PullToRefreshListener a;
  protected boolean a;
  
  public QQStoryPullToRefreshListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c();
    d();
  }
  
  public QQStoryPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
    d();
  }
  
  private void c()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper = new LoadingMoreHelper(localLoadMoreLayout);
    b(localLoadMoreLayout);
    super.setOnScrollListener(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getContext()).inflate(2130904478, this, false));
    setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    setOverScrollHeader(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader);
    setOverScrollListener(this);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.c(0L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper.b(true);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 >= paramInt3) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(0);
    }
    for (;;)
    {
      postDelayed(new jac(this), 800L);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(1);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$PullToRefreshListener.b();
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewPullRefreshHeader.a(0L);
  }
  
  public void setPullToRefreshListener(QQStoryPullToRefreshListView.PullToRefreshListener paramPullToRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView$PullToRefreshListener = paramPullToRefreshListener;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\QQStoryPullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */