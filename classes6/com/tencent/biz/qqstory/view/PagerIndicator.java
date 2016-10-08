package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.view.PagerAdapter;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import izw;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

public class PagerIndicator
  extends LinearLayout
{
  public static final String a = "PagerIndicator";
  public static final boolean a = true;
  public static final int[] a;
  protected int a;
  protected Drawable a;
  public EmptySupportViewPager a;
  public final izw a;
  protected WeakReference a;
  protected Queue a;
  protected int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 16843161, 16843327, 16843245 };
  }
  
  public PagerIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Izw = new izw(this, null);
    setOrientation(0);
    setGravity(17);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    if (paramContext.hasValue(0)) {}
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(0);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-7829368))
    {
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(1, this.jdField_a_of_type_Int);
      this.b = paramContext.getInt(2, this.b);
      paramContext.recycle();
      a(0, this.b);
      Log.d("PagerIndicator", "init");
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Log.d("PagerIndicator", "updatePoints : current item = " + paramInt1);
    int i = getChildCount();
    Object localObject;
    if (i > paramInt2)
    {
      i -= 1;
      for (;;)
      {
        if (i < paramInt2) {
          break label204;
        }
        localObject = getChildAt(i);
        if (!(localObject instanceof PagerIndicator.InnerImageView)) {
          break;
        }
        removeView((View)localObject);
        this.jdField_a_of_type_JavaUtilQueue.offer((PagerIndicator.InnerImageView)localObject);
        i -= 1;
      }
      throw new AndroidRuntimeException("find illegal child view, all child view should be InnerImageView");
    }
    if (paramInt2 > i) {
      while (i < paramInt2)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(this.jdField_a_of_type_Int, 0, 0, 0);
        PagerIndicator.InnerImageView localInnerImageView = (PagerIndicator.InnerImageView)this.jdField_a_of_type_JavaUtilQueue.poll();
        localObject = localInnerImageView;
        if (localInnerImageView == null)
        {
          localObject = new PagerIndicator.InnerImageView(getContext());
          ((PagerIndicator.InnerImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
        }
        addView((View)localObject, i, localLayoutParams);
        i += 1;
      }
    }
    label204:
    i = 0;
    if (i < paramInt2)
    {
      localObject = getChildAt(i);
      if (paramInt1 == i) {
        ((View)localObject).setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        ((View)localObject).setSelected(false);
      }
    }
  }
  
  public void a(int paramInt, PagerAdapter paramPagerAdapter)
  {
    if (paramPagerAdapter != null) {}
    for (int i = paramPagerAdapter.getCount();; i = 0)
    {
      a(paramInt, i);
      return;
    }
  }
  
  public void setViewPager(EmptySupportViewPager paramEmptySupportViewPager)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager != paramEmptySupportViewPager)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.b(this.jdField_a_of_type_Izw);
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager = null;
      }
      if (paramEmptySupportViewPager != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager = paramEmptySupportViewPager;
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.a(this.jdField_a_of_type_Izw);
      }
    }
  }
  
  public void setViewPagerAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter;
    int j;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localPagerAdapter = (PagerAdapter)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localPagerAdapter != paramPagerAdapter)
      {
        if (localPagerAdapter != null)
        {
          localPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Izw);
          this.jdField_a_of_type_JavaLangRefWeakReference = null;
        }
        if (paramPagerAdapter != null)
        {
          paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_Izw);
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPagerAdapter);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager != null)
        {
          j = this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.getCurrentItem();
          if (paramPagerAdapter == null) {
            break label102;
          }
        }
      }
    }
    label102:
    for (int i = paramPagerAdapter.getCount();; i = 0)
    {
      a(j, i);
      return;
      localPagerAdapter = null;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\PagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */