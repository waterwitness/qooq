package com.tencent.biz.troopgift;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import jfc;

public abstract class absMultiViewPager
  extends ViewPager
  implements AdapterView.OnItemClickListener
{
  protected AdapterView.OnItemClickListener a;
  protected absMultiViewPager.ViewPagerAdapter a;
  protected ArrayList a;
  protected jfc a;
  protected ArrayList b;
  protected int d;
  
  public absMultiViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public absMultiViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
  }
  
  public static ArrayList a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > paramArrayList.size()) || (paramInt2 > paramArrayList.size())) {
      throw new IndexOutOfBoundsException("subArrayList exception, start or end is large than src list size. src size:" + paramArrayList.size() + ", start:" + paramInt1 + ", end:" + paramInt2);
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 < paramInt2)
    {
      localArrayList.add(paramArrayList.get(paramInt1));
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt);
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Jfc != null) {
      this.jdField_a_of_type_Jfc.a(paramInt1, paramInt2, getCurrentItem());
    }
  }
  
  public View b(int paramInt)
  {
    return (View)this.b.get(paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter = new absMultiViewPager.ViewPagerAdapter();
    setAdapter(this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter);
    this.b.clear();
    int j = a();
    if (this.d != j)
    {
      a(this.d, j);
      this.d = j;
    }
    int i = 0;
    while (i < j)
    {
      this.b.add(a(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.a(this.b);
    this.jdField_a_of_type_ComTencentBizTroopgiftAbsMultiViewPager$ViewPagerAdapter.notifyDataSetChanged();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void setData(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    b();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnPagerSizeChangeListener(jfc paramjfc)
  {
    this.jdField_a_of_type_Jfc = paramjfc;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\absMultiViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */