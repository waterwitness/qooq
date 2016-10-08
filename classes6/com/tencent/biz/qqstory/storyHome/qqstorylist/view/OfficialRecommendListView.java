package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class OfficialRecommendListView
  extends HorizontalListView
  implements InfoCardOnDismissListener, Runnable
{
  public float a;
  protected int a;
  public long a;
  public MyStoryListEventListener a;
  public OfficialRecommendAdapter a;
  protected OfficialRecommendListView.OnOverScrollRightListener a;
  public List a;
  protected boolean a;
  public float b;
  protected int b;
  protected boolean b;
  public float c;
  protected int c;
  protected boolean c;
  public float d;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  
  public OfficialRecommendListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.e = true;
    this.f = true;
    a(paramContext);
  }
  
  public OfficialRecommendListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.e = true;
    this.f = true;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = DisplayUtil.a(paramContext, 83.0F);
    super.setPadding(UIUtils.a(paramContext, 12.0F), 0, UIUtils.a(paramContext, 12.0F), 0);
    super.setClipToPadding(false);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendAdapter = new OfficialRecommendAdapter(getContext(), this.jdField_a_of_type_JavaUtilList, this);
    super.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendAdapter);
    setAutoFlip(true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {}
    int m;
    int j;
    for (int i = this.jdField_a_of_type_Int;; i = this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      i = this.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
      m = getFirstVisiblePosition();
      j = getCount();
      if (j > i) {
        break;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "autoFlip mScreenWidth=" + this.jdField_a_of_type_Int + " mScreenHeight=" + this.jdField_b_of_type_Int + " mItemViewWidth=" + this.jdField_c_of_type_Int);
    }
    int k = DisplayUtil.a(getContext(), 24.0F);
    if (m + i >= j - 1)
    {
      i = (int)(j * 1.0F / i * 'Ϩ');
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "autoFlip to position 0 offset=" + k + "duration=" + i);
      }
      d(0, -getPaddingLeft());
    }
    for (;;)
    {
      StoryReportor.a("recommend", "slide", 0, 2, new String[0]);
      return;
      if (i * 2 + m >= j)
      {
        k = DisplayUtil.a(getContext(), 2.0F) * (i - 1) + (this.jdField_c_of_type_Int * i - this.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "autoFlip to position " + (j - i) + " offset=" + k + "duration=" + 1000);
        }
        a(j - i, k, 1000);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "autoFlip to position " + (m + i) + " offset=" + -k + "duration=" + 1000);
        }
        a(i + m, -k, 1000);
      }
    }
  }
  
  public void a(UserInfo paramUserInfo, boolean paramBoolean)
  {
    setAutoFlip(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ((QQStoryHandler)((QQAppInterface)BaseApplicationImpl.a().a()).a(98)).d();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.jdField_b_of_type_Float = paramMotionEvent.getY();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendListView dispatchTouchEvent:ACTION_DOWN. isPressed=" + this.jdField_c_of_type_Boolean);
      }
      this.jdField_c_of_type_Float = this.jdField_a_of_type_Float;
      this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_c_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendListView dispatchTouchEvent:ACTION_MOVE. isPressed=" + this.jdField_c_of_type_Boolean);
      }
      float f1 = this.jdField_a_of_type_Float;
      float f2 = this.jdField_c_of_type_Float;
      float f3 = this.jdField_b_of_type_Float - this.jdField_d_of_type_Float;
      if ((this.jdField_c_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f = false;
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if ((i == 3) || (i == 1))
      {
        if (this.f) {
          StoryReportor.a("recommend", "slide", 0, 1, new String[0]);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "OfficialRecommendListView dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " isPressed=" + this.jdField_c_of_type_Boolean);
        }
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendAdapter != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendAdapter.getCount();
    }
    return 0;
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt3 > DisplayUtil.a(getContext(), 50.0F)))
    {
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView$OnOverScrollRightListener != null) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView$OnOverScrollRightListener.a();
      }
    }
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (this.o != 4097) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "run time=" + l + " mLastTouchTime=" + this.jdField_a_of_type_Long + " isScrolling=" + bool);
      }
      if ((l > this.jdField_a_of_type_Long + 10000L) && (!bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "run autoFlip time=" + l + " mLastTouchTime" + this.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_Long = l;
        b();
      }
      if (!this.jdField_d_of_type_Boolean) {
        postDelayed(this, 'Ϩ');
      }
      return;
    }
  }
  
  public void setAutoFlip(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "setAutoFlip autoFlip:" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      postDelayed(this, 1000L);
    }
    Handler localHandler;
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
      localHandler = getHandler();
    } while (localHandler == null);
    localHandler.removeCallbacksAndMessages(this);
  }
  
  public void setCanHandleClick(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setData(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendAdapter.notifyDataSetChanged();
  }
  
  public void setItemClickListener(MyStoryListEventListener paramMyStoryListEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener = paramMyStoryListEventListener;
  }
  
  public void setOnOverScrollRightListener(OfficialRecommendListView.OnOverScrollRightListener paramOnOverScrollRightListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewOfficialRecommendListView$OnOverScrollRightListener = paramOnOverScrollRightListener;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\OfficialRecommendListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */