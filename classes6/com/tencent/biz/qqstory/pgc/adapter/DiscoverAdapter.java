package com.tencent.biz.qqstory.pgc.adapter;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.network.handler.GetPreloadVideoHandler;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.BaseDiscoverFrameLayout;
import com.tencent.biz.qqstory.pgc.view.DiscoverFrameLayoutLargeThreeLeft;
import com.tencent.biz.qqstory.pgc.view.DiscoverFrameLayoutLargeThreeRight;
import com.tencent.biz.qqstory.pgc.view.DiscoverFrameLayoutSmallThree;
import com.tencent.biz.qqstory.pgc.view.DiscoverFrameLayoutTwo;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem.OnItemTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import ilf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscoverAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  protected SparseArray a;
  protected AdapterView.OnItemClickListener a;
  protected AdapterView.OnItemLongClickListener a;
  protected DiscoverItem.OnItemTouchListener a;
  protected ArrayList a;
  protected List a;
  
  public DiscoverAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private int a(int paramInt)
  {
    int i = 3;
    if (paramInt == 3) {
      i = 2;
    }
    return i;
  }
  
  private void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecommendItem localRecommendItem = (RecommendItem)paramList.next();
      if ((localRecommendItem.a != null) && (!TextUtils.isEmpty(localRecommendItem.a.unionId))) {
        localArrayList.add(localRecommendItem.a.unionId);
      }
    }
    new GetPreloadVideoHandler().a(3, null, localArrayList);
  }
  
  public RecommendItem a(int paramInt)
  {
    return (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void a(DiscoverItem.OnItemTouchListener paramOnItemTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem$OnItemTouchListener = paramOnItemTouchListener;
  }
  
  public void a(List paramList)
  {
    int m = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilList = paramList;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j % 3 == 1)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_JavaUtilArrayList.size(), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - j));
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
      i = j - a(3);
    }
    int k = 0;
    j = i;
    if (j >= 5) {
      if (k % 3 == 0) {
        i = 0;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_JavaUtilArrayList.size(), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - j));
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      j -= a(i);
      k += 1;
      break;
      if (k % 3 == 1)
      {
        i = 2;
      }
      else if (k % 3 == 2)
      {
        i = 1;
        continue;
        if (j == 3) {
          if (k % 3 == 0)
          {
            i = m;
            this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_JavaUtilArrayList.size(), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - j));
            this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
          }
        }
        for (;;)
        {
          b(paramList);
          super.notifyDataSetChanged();
          return;
          if (k % 3 == 1)
          {
            i = 2;
            break;
          }
          i = m;
          if (k % 3 != 2) {
            break;
          }
          i = 1;
          break;
          if (j == 2)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_JavaUtilArrayList.size(), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - j));
            this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
          }
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        RecommendItem localRecommendItem = (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localRecommendItem.a.unionId.equals(paramString)) {
          localRecommendItem.a.isSubscribe = paramBoolean;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null) {
      switch (i)
      {
      default: 
        paramViewGroup = new ilf(this, paramView);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      i = 0;
      while (i < localViewGroup.getChildCount())
      {
        Object localObject = localViewGroup.getChildAt(i);
        if ((localObject instanceof DiscoverItem))
        {
          localObject = (DiscoverItem)localObject;
          ((DiscoverItem)localObject).setMaskAlpha(((DiscoverItem)localObject).c);
        }
        i += 1;
      }
      paramView = new DiscoverFrameLayoutLargeThreeLeft(paramViewGroup.getContext(), paramViewGroup.getMeasuredWidth(), paramViewGroup.getMeasuredHeight(), this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem$OnItemTouchListener);
      break;
      paramView = new DiscoverFrameLayoutLargeThreeRight(paramViewGroup.getContext(), paramViewGroup.getMeasuredWidth(), paramViewGroup.getMeasuredHeight(), this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem$OnItemTouchListener);
      break;
      paramView = new DiscoverFrameLayoutSmallThree(paramViewGroup.getContext(), paramViewGroup.getMeasuredWidth(), paramViewGroup.getMeasuredHeight(), this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem$OnItemTouchListener);
      break;
      paramView = new DiscoverFrameLayoutTwo(paramViewGroup.getContext(), paramViewGroup.getMeasuredWidth(), paramViewGroup.getMeasuredHeight(), this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener, this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem$OnItemTouchListener);
      break;
      paramViewGroup = (ilf)paramView.getTag();
    }
    i = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).intValue();
    if (getItemViewType(paramInt) == 3) {
      if (i + 1 < this.jdField_a_of_type_JavaUtilList.size()) {
        paramViewGroup.a.setRecommendItem(i, new RecommendItem[] { (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i), (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i + 1) });
      }
    }
    while (paramInt < getCount() - 1)
    {
      paramView.setPadding(0, 0, 0, DisplayUtil.a(paramView.getContext(), 2.0F));
      return paramView;
      paramViewGroup.a.setRecommendItem(i, new RecommendItem[] { (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i) });
      continue;
      if (i + 2 < this.jdField_a_of_type_JavaUtilList.size()) {
        paramViewGroup.a.setRecommendItem(i, new RecommendItem[] { (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i), (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i + 1), (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i + 2) });
      } else if (i + 1 < this.jdField_a_of_type_JavaUtilList.size()) {
        paramViewGroup.a.setRecommendItem(i, new RecommendItem[] { (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i), (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i + 1) });
      } else {
        paramViewGroup.a.setRecommendItem(i, new RecommendItem[] { (RecommendItem)this.jdField_a_of_type_JavaUtilList.get(i) });
      }
    }
    paramView.setPadding(0, 0, 0, 0);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\adapter\DiscoverAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */