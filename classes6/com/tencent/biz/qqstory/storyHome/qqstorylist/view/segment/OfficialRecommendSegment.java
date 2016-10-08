package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.OfficialRecommendListView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import iub;
import iuc;
import java.util.ArrayList;
import java.util.Iterator;

public class OfficialRecommendSegment
  extends SegmentView
{
  public static final String a = "offical_recommend";
  public QQStoryHandler a;
  private QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver;
  public OfficialRecommendListView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ArrayList a;
  protected boolean a;
  
  public OfficialRecommendSegment(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new iuc(this);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment getCount. recommendItems:" + this.jdField_a_of_type_JavaUtilArrayList);
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment bindView. mOfficialRecommendView:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView + " isDataChanged:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView == null) {
      a(paramInt, paramViewGroup);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment bindView recommendItems:" + this.jdField_a_of_type_JavaUtilArrayList);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.setData(this.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView;
      f();
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment newView.");
    }
    OfficialRecommendListView localOfficialRecommendListView = new OfficialRecommendListView(paramViewGroup.getContext());
    localOfficialRecommendListView.setDividerWidth(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
    localOfficialRecommendListView.setItemClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener);
    localOfficialRecommendListView.setMinimumHeight(UIUtils.a(paramViewGroup.getContext(), 134.0F));
    localOfficialRecommendListView.setOnOverScrollRightListener(new iub(this));
    paramViewGroup = new BaseViewHolder(localOfficialRecommendListView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView = localOfficialRecommendListView;
    this.jdField_a_of_type_Boolean = true;
    return paramViewGroup;
  }
  
  public String a()
  {
    return "offical_recommend";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment onActivityResult. requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    f();
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment setData. data is null");
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramObject);
        paramObject = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          RecommendItem localRecommendItem = (RecommendItem)localIterator.next();
          if ((localRecommendItem.a()) && (!TextUtils.isEmpty(localRecommendItem.a.title))) {
            ((ArrayList)paramObject).add(localRecommendItem);
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramObject);
      }
      catch (Exception paramObject)
      {
        ((Exception)paramObject).printStackTrace();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment setData recommendItems.size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendSegment onResume.");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.d();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.setCanHandleClick(true);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.setAutoFlip(true);
    }
    f();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.a().a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView != null)
    {
      Handler localHandler = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.getHandler();
      if (localHandler != null) {
        localHandler.removeCallbacksAndMessages(null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i <= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.getChildAt(i);
        if (localObject != null)
        {
          if (((View)localObject).getVisibility() != 0) {
            ((View)localObject).setVisibility(0);
          }
          if ((localObject instanceof DiscoverItem))
          {
            localObject = (DiscoverItem)localObject;
            ((DiscoverItem)localObject).setMaskAlpha(((DiscoverItem)localObject).c);
          }
        }
        i += 1;
      }
    }
  }
  
  public void y_()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView.setAutoFlip(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\OfficialRecommendSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */