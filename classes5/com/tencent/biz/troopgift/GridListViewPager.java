package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class GridListViewPager
  extends absMultiViewPager
{
  protected int a;
  protected String a;
  protected int b;
  protected int c;
  
  public GridListViewPager(Context paramContext)
  {
    super(paramContext);
    this.b = 4;
    this.c = 2;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = Math.min(paramContext.heightPixels, paramContext.widthPixels);
  }
  
  public GridListViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 4;
    this.c = 2;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = Math.min(paramContext.heightPixels, paramContext.widthPixels);
  }
  
  public int a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size() / (this.b * this.c);
    int i = j;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() % (this.b * this.c) > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public View a(int paramInt)
  {
    return a(paramInt, a(paramInt));
  }
  
  public View a(int paramInt, ArrayList paramArrayList)
  {
    GridView localGridView = new GridView(getContext());
    localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localGridView.setVerticalSpacing(0);
    localGridView.setHorizontalSpacing(10);
    localGridView.setColumnWidth(this.jdField_a_of_type_Int / this.b - 40);
    localGridView.setNumColumns(this.b);
    Object localObject = getContext().getResources();
    localGridView.setPadding(AIOUtils.a(5.0F, (Resources)localObject), AIOUtils.a(1.0F, (Resources)localObject), AIOUtils.a(5.0F, (Resources)localObject), AIOUtils.a(1.0F, (Resources)localObject));
    localGridView.setGravity(1);
    localGridView.setSelector(new ColorDrawable(0));
    localObject = new GridListAdapter(getContext());
    ((GridListAdapter)localObject).a(paramArrayList);
    ((GridListAdapter)localObject).a(this.jdField_a_of_type_JavaLangString);
    localGridView.setAdapter((ListAdapter)localObject);
    localGridView.setOnItemClickListener(this);
    ((GridListAdapter)localObject).notifyDataSetChanged();
    return localGridView;
  }
  
  public ArrayList a(int paramInt)
  {
    if (paramInt == this.d - 1) {
      return a(this.jdField_a_of_type_JavaUtilArrayList, this.b * this.c * paramInt, this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    return a(this.jdField_a_of_type_JavaUtilArrayList, this.b * this.c * paramInt, (paramInt + 1) * (this.b * this.c));
  }
  
  public void a()
  {
    ArrayList localArrayList = ((absMultiViewPager.ViewPagerAdapter)getAdapter()).a();
    int i = 0;
    while (i < localArrayList.size())
    {
      ((GridListAdapter)((GridView)localArrayList.get(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void setGridGiftIcon(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    if (this.b != paramInt1)
    {
      this.b = paramInt1;
      i = 1;
    }
    if (this.c != paramInt2) {
      this.c = paramInt2;
    }
    for (paramInt1 = j;; paramInt1 = i)
    {
      if (paramInt1 != 0) {
        b();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\GridListViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */