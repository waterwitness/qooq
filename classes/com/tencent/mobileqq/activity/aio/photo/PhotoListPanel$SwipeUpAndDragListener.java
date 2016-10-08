package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.widget.HorizontalListView;
import java.util.concurrent.atomic.AtomicBoolean;
import nvo;
import nvp;
import nvr;
import nvt;

public class PhotoListPanel$SwipeUpAndDragListener
  implements View.OnTouchListener
{
  private static int e = 0;
  private static final int jdField_f_of_type_Int = 100;
  public float a;
  public int a;
  public long a;
  public VelocityTracker a;
  public PhotoListPanel.SwipeUpAndDragCallBack a;
  public PhotoListPanel a;
  public AtomicBoolean a;
  nvp jdField_a_of_type_Nvp;
  nvr jdField_a_of_type_Nvr;
  nvt jdField_a_of_type_Nvt;
  boolean jdField_a_of_type_Boolean;
  public int[] a;
  public float b;
  public int b;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  public float d;
  int d;
  public float e;
  float jdField_f_of_type_Float;
  public float g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_e_of_type_Int = 60;
  }
  
  public PhotoListPanel$SwipeUpAndDragListener(Context paramContext, ViewGroup paramViewGroup, int[] paramArrayOfInt, int paramInt, PhotoListPanel.SwipeUpAndDragCallBack paramSwipeUpAndDragCallBack, PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.f = 0.7F;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack = paramSwipeUpAndDragCallBack;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = paramPhotoListPanel;
    this.jdField_e_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    jdField_e_of_type_Int = (int)(30.0F * this.jdField_e_of_type_Float);
    this.jdField_a_of_type_Nvr = new nvr(this, paramContext, paramViewGroup);
    this.jdField_a_of_type_Nvp = new nvp(this, paramContext, paramViewGroup);
  }
  
  public float a(int paramInt1, int paramInt2, int paramInt3)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = 160.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
    }
    for (;;)
    {
      Logger.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f1 + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.i + ",info.mediaHeight = " + localLocalMediaInfo.j);
      return f1;
      if ((localLocalMediaInfo.i > 100) || (localLocalMediaInfo.j > 100)) {
        f1 = 135.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      } else {
        f1 = Math.max(localLocalMediaInfo.i, localLocalMediaInfo.j) * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      }
    }
  }
  
  nvt a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    boolean bool4 = false;
    boolean bool5 = true;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_Boolean = true;
      i = paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
      if (-f1 > 1500.0F)
      {
        bool1 = true;
        if (paramFloat2 >= 0.0F) {
          break label383;
        }
        bool2 = true;
        label81:
        if (Math.abs(paramFloat1 / paramFloat2) >= Math.tan(0.7853981633974483D)) {
          break label389;
        }
        bool3 = true;
        label101:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k != 4097) {
          break label395;
        }
      }
      label383:
      label389:
      label395:
      for (bool4 = bool5;; bool4 = false)
      {
        Logger.a("PhotoListPanel", "detectGesture", "Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4 + ",mGestureHandler = " + this.jdField_a_of_type_Nvt);
        Logger.a("PhotoListPanel", "detectGesture", "mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
        if ((this.jdField_a_of_type_Nvt != null) || (!bool2) || (!bool3) || (!bool4)) {
          break label774;
        }
        Logger.a("PhotoListPanel", "detectGesture", "return mDragHandler.");
        return this.jdField_a_of_type_Nvp;
        bool1 = false;
        break;
        bool2 = false;
        break label81;
        bool3 = false;
        break label101;
      }
    }
    int i = paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
    if (-f1 > 3000.0F)
    {
      bool1 = true;
      if (paramFloat2 >= 0.0F) {
        break label762;
      }
      bool2 = true;
      label462:
      if (Math.abs(paramFloat1 / paramFloat2) >= Math.tan(0.7853981633974483D)) {
        break label768;
      }
    }
    label762:
    label768:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k == 4097) {
        bool4 = true;
      }
      Logger.a("PhotoListPanel", "detectGesture", "2 Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4);
      Logger.a("PhotoListPanel", "detectGesture", "2 mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
      if ((this.jdField_a_of_type_Nvt != null) || (!bool2) || (!bool3) || (!bool4) || (!bool1)) {
        break label774;
      }
      this.jdField_a_of_type_Boolean = true;
      Logger.a("PhotoListPanel", "detectGesture", "return mFlingHandler.");
      return this.jdField_a_of_type_Nvr;
      bool1 = false;
      break;
      bool2 = false;
      break label462;
    }
    label774:
    return null;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Logger.a("PhotoListPanel", "onTouch", "x = " + f1 + ",y = " + f2 + ",event = " + paramMotionEvent + ", mPanel.mDisableGuestrueSend = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean) {
      return bool1;
    }
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      Logger.a("PhotoListPanel", "onTouch", " ACTION_DOWN,x = " + f1 + ",y = " + f2);
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Float = f1;
      this.jdField_c_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_d_of_type_Float = f2;
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.a((int)f1, (int)f2);
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        this.jdField_d_of_type_Int = paramMotionEvent.getPointerId(0);
        Logger.a("PhotoListPanel", "onTouch", " ACTION_DOWN,mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
        this.jdField_a_of_type_Nvt = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.postDelayed(new nvo(this), 100L);
        break;
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      }
      Logger.a("PhotoListPanel", "onTouch", " ACTION_MOVE,x = " + f1 + ",y = " + f2 + ",mGestureHandler = " + this.jdField_a_of_type_Nvt);
      float f3 = this.jdField_a_of_type_Float;
      float f4 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition());
      if (paramView == null) {
        return false;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Nvt = a(paramMotionEvent, f1 - f3, f2 - f4);
        if (this.jdField_a_of_type_Nvt != null) {
          return this.jdField_a_of_type_Nvt.a(paramView, this.jdField_c_of_type_Int);
        }
      }
      else if (this.jdField_a_of_type_Nvt != null)
      {
        return this.jdField_a_of_type_Nvt.a(paramMotionEvent);
      }
      Logger.a("PhotoListPanel", "onTouch", "f ACTION_MOVE,x = " + f1 + ",y = " + f2);
      continue;
      if (this.jdField_a_of_type_Nvt != null)
      {
        boolean bool2 = this.jdField_a_of_type_Nvt.b(paramMotionEvent);
        this.jdField_a_of_type_Nvt = null;
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          break;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        return bool2;
      }
      long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k == 4097) && ((l > 200L) || (Math.abs(f2 - this.jdField_b_of_type_Float) > this.jdField_b_of_type_Int) || (Math.abs(f1 - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)))
      {
        Logger.a("PhotoListPanel", "onTouch", " ACTION_UP,eat up event.dx = " + Math.abs(f1 - this.jdField_a_of_type_Float) + ",dy = " + Math.abs(f2 - this.jdField_b_of_type_Float) + ",duration = " + l);
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          break;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        return true;
      }
      Logger.a("PhotoListPanel", "onTouch", "f ACTION_UP,x = " + f1 + ",y = " + f2);
      continue;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\PhotoListPanel$SwipeUpAndDragListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */