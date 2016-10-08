package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rkz;

public class HorizontalListViewEx
  extends HorizontalListView
{
  private static LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private static List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private int jdField_a_of_type_Int;
  private int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HorizontalListViewEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = AIOUtils.a(54.0F, paramContext.getResources());
    paramAttributeSet = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramAttributeSet);
    this.b = paramAttributeSet.widthPixels;
  }
  
  public static View a()
  {
    if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0)) {
      return (View)jdField_a_of_type_JavaUtilList.remove(0);
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    int j = 0;
    int i = j;
    if (jdField_a_of_type_AndroidViewLayoutInflater == null)
    {
      jdField_a_of_type_AndroidViewLayoutInflater = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
      i = j;
    }
    for (;;)
    {
      if (i < paramInt) {
        try
        {
          View localView = jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903340, null, false);
          if (localView != null) {
            jdField_a_of_type_JavaUtilList.add(localView);
          }
          i += 1;
        }
        catch (InflateException localInflateException)
        {
          for (;;)
          {
            Object localObject1 = null;
          }
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("HorizontalListViewEx", 2, "NotFoundException;err info:" + localNotFoundException.getMessage());
            }
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("HorizontalListViewEx", 2, "OutOfMemoryError;err info:" + localOutOfMemoryError.getMessage());
            }
            Object localObject3 = null;
          }
        }
      }
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilList != null) {
      jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public int a(int paramInt)
  {
    int i = this.i + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.j) {
      return 1;
    }
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.i, 0, paramInt, 0, 20);
    g(4098);
    requestLayout();
    return 0;
  }
  
  public void a_(int paramInt)
  {
    this.h = (this.jdField_a_of_type_Int * paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getChildCount();
    if (a() != null)
    {
      paramCanvas = (EmoticonTabAdapter)a();
      int i = 0;
      if (i < j)
      {
        View localView = getChildAt(i);
        Object localObject = paramCanvas.getItem(this.l + i);
        EmoticonTabAdapter.ViewHolder localViewHolder;
        if (localView.getTag() != null)
        {
          localViewHolder = (EmoticonTabAdapter.ViewHolder)localView.getTag();
          if (localView != getSelectedView()) {
            break label137;
          }
          localView.setSelected(true);
          localViewHolder.a.setSelected(true);
          if (localObject != null)
          {
            localObject = (EmoticonTabAdapter.EmoticonTabItem)localObject;
            localView.setContentDescription("已选定" + ((EmoticonTabAdapter.EmoticonTabItem)localObject).b);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label137:
          localView.setSelected(false);
          localViewHolder.a.setSelected(false);
          if (localObject != null) {
            localView.setContentDescription(((EmoticonTabAdapter.EmoticonTabItem)localObject).b);
          }
        }
      }
    }
  }
  
  public void setSelection(int paramInt)
  {
    int j = 0;
    super.setSelection(paramInt);
    if (this.jdField_a_of_type_AndroidWidgetListAdapter == null) {}
    while ((paramInt >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()) || (paramInt < 0)) {
      return;
    }
    int k = getFirstVisiblePosition();
    int m = getLastVisiblePosition();
    int n;
    int i;
    if ((paramInt > m) && (m != -1))
    {
      n = (paramInt + 2) * this.jdField_a_of_type_Int;
      j = n - this.i - this.b;
      i = j;
      if (g)
      {
        i = j;
        if (QLog.isDevelopLevel())
        {
          QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond right screen, position:" + paramInt + ",lastPosition:" + m + ",tabPosition:" + n + ",mNextX:" + this.i + ",deltaX:" + j + ",mScreenWidth" + this.b);
          i = j;
        }
      }
    }
    while (i != 0)
    {
      a(i);
      return;
      if ((paramInt < k) && (k != -1))
      {
        n = this.jdField_a_of_type_Int * paramInt;
        j = n - this.i;
        i = j;
        if (g)
        {
          i = j;
          if (QLog.isDevelopLevel())
          {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond l eft screen, position:" + paramInt + ",firstPosition:" + k + ",tabPosition:" + n + ",mNextX:" + this.i + ",deltaX:" + j + ",mScreenWidth" + this.b);
            i = j;
          }
        }
      }
      else
      {
        View localView;
        int[] arrayOfInt;
        if (paramInt == k)
        {
          localView = getChildAt(0);
          arrayOfInt = new int[2];
          localView.getLocationOnScreen(arrayOfInt);
          i = arrayOfInt[0];
          if ((g) && (QLog.isDevelopLevel())) {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half left screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.i + ",deltaX:" + i);
          }
        }
        else if (paramInt == m)
        {
          localView = getChildAt(getChildCount() - 1);
          arrayOfInt = new int[2];
          localView.getLocationOnScreen(arrayOfInt);
          j = this.jdField_a_of_type_Int * 2 - (this.b - arrayOfInt[0]);
          i = j;
          if (j < 0) {
            i = 0;
          }
          if ((g) && (QLog.isDevelopLevel())) {
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half right screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.i + ",deltaX:" + i);
          }
        }
        else
        {
          i = j;
          if (g)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view inside screen, position:" + paramInt + ",mNextX:" + this.i);
              i = j;
            }
          }
        }
      }
    }
    if ((k == -1) && (m == -1))
    {
      ViewCompat.postOnAnimation(this, new rkz(this));
      return;
    }
    requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\HorizontalListViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */