package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import izq;
import izr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmptySupportViewPager
  extends ViewPager
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  public List a;
  public Set a;
  
  public EmptySupportViewPager(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new izq(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new izr(this);
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
  }
  
  public EmptySupportViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new izq(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new izr(this);
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
  }
  
  private void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if (((Boolean)localPair.second).booleanValue()) {}
      int i;
      switch (paramInt)
      {
      default: 
        i = paramInt;
      }
      for (;;)
      {
        ((View)localPair.first).setVisibility(i);
        break;
        i = 0;
        continue;
        i = 8;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnPageChangeListener);
  }
  
  public boolean a(View paramView)
  {
    return a(paramView, false);
  }
  
  public boolean a(View paramView, boolean paramBoolean)
  {
    paramBoolean = this.jdField_a_of_type_JavaUtilSet.add(new Pair(paramView, Boolean.valueOf(paramBoolean)));
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    return paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnPageChangeListener);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = getAdapter();
    if (localPagerAdapter != null) {
      localPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    super.setAdapter(paramPagerAdapter);
    if (paramPagerAdapter != null)
    {
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\EmptySupportViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */