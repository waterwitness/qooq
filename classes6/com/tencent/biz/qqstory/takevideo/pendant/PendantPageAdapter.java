package com.tencent.biz.qqstory.takevideo.pendant;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Pair;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantType;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PendantPageAdapter
  extends PagerAdapter
  implements OnPendantItemClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "PendantPageAdapter";
  public static final int[] a;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private OnPendantItemClickListener jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList = new LinkedList();
  private int jdField_c_of_type_Int;
  private List jdField_c_of_type_JavaUtilList = new LinkedList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 2131302822, 2131302823, 2131302824, 2131302825, 2131302826, 2131302827, 2131302828, 2131302829, 2131302830, 2131302831 };
  }
  
  public PendantPageAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private PendantPageHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    int j = this.jdField_c_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j) {
      if (((PendantPageHolder)this.jdField_c_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (;;)
    {
      PendantPageHolder localPendantPageHolder1 = null;
      if (i != -1)
      {
        localPendantPageHolder1 = (PendantPageHolder)this.jdField_c_of_type_JavaUtilList.remove(i);
        SLog.a("PendantPageAdapter", "re use the %d holder in the bin for position %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      }
      PendantPageHolder localPendantPageHolder2 = localPendantPageHolder1;
      if (localPendantPageHolder1 == null)
      {
        if (j > 0)
        {
          localPendantPageHolder1 = (PendantPageHolder)this.jdField_c_of_type_JavaUtilList.remove(0);
          SLog.a("PendantPageAdapter", "re use the first holder in the bin for position %d", new Object[] { Integer.valueOf(paramInt) });
        }
        localPendantPageHolder2 = localPendantPageHolder1;
        if (localPendantPageHolder1 == null)
        {
          localPendantPageHolder2 = new PendantPageHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904464, paramViewGroup, false));
          SLog.a("PendantPageAdapter", "create new holder for position %d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      this.jdField_b_of_type_JavaUtilList.add(localPendantPageHolder2);
      return localPendantPageHolder2;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private NewStoryPendantItem[] a(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      k = j + a((NewStoryPendantType)this.jdField_a_of_type_JavaUtilList.get(i));
      if ((paramInt >= j) && (paramInt < k))
      {
        j = paramInt - j;
        k = jdField_a_of_type_ArrayOfInt.length * j;
        SLog.a("PendantPageAdapter", "getOnePageItems, pageIndex = %d, pageIndexWithinType = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) });
        NewStoryPendantItem[] arrayOfNewStoryPendantItem = ((NewStoryPendantType)this.jdField_a_of_type_JavaUtilList.get(i)).a;
        if ((arrayOfNewStoryPendantItem == null) || (arrayOfNewStoryPendantItem.length == 0)) {
          return new NewStoryPendantItem[0];
        }
        return (NewStoryPendantItem[])Arrays.copyOfRange(arrayOfNewStoryPendantItem, k, Math.min(jdField_a_of_type_ArrayOfInt.length + k, arrayOfNewStoryPendantItem.length));
      }
      i += 1;
    }
    throw new IllegalArgumentException("illegal page index = " + paramInt + ", count = " + getCount());
  }
  
  public int a(int paramInt)
  {
    int j = 0;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      throw new IndexOutOfBoundsException("type index = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    int i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = 0;
    while (i < paramInt)
    {
      j += a((NewStoryPendantType)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt, j);
    return j;
  }
  
  public int a(NewStoryPendantType paramNewStoryPendantType)
  {
    paramNewStoryPendantType = paramNewStoryPendantType.a;
    if (paramNewStoryPendantType != null) {}
    for (int i = paramNewStoryPendantType.length; i <= 0; i = 0) {
      return 0;
    }
    return (i - 1) / jdField_a_of_type_ArrayOfInt.length + 1;
  }
  
  public Pair a(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      k = j + a((NewStoryPendantType)this.jdField_a_of_type_JavaUtilList.get(i));
      if ((paramInt >= j) && (paramInt < k)) {
        return new Pair(Integer.valueOf(paramInt - j), Integer.valueOf(a((NewStoryPendantType)this.jdField_a_of_type_JavaUtilList.get(i))));
      }
      i += 1;
    }
    return new Pair(Integer.valueOf(0), Integer.valueOf(1));
  }
  
  public void a(NewStoryPendantItem paramNewStoryPendantItem, int paramInt1, int paramInt2)
  {
    if (paramNewStoryPendantItem == NewStoryPendantItem.b) {}
    Object localObject;
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PendantPageHolder)((Iterator)localObject).next()).a(paramInt1, paramInt2);
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener;
    } while (localObject == null);
    ((OnPendantItemClickListener)localObject).a(paramNewStoryPendantItem, paramInt1, paramInt2);
  }
  
  public void a(OnPendantItemClickListener paramOnPendantItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener = paramOnPendantItemClickListener;
  }
  
  public void a(List paramList)
  {
    SLog.a("PendantPageAdapter", "updateTypeList : %d", Integer.valueOf(paramList.size()));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    notifyDataSetChanged();
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilList.size(); j = k)
    {
      k = j + a((NewStoryPendantType)this.jdField_a_of_type_JavaUtilList.get(i));
      if ((paramInt >= j) && (paramInt < k)) {
        return i;
      }
      i += 1;
    }
    throw new IllegalArgumentException("illegal page index : " + paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (PendantPageHolder)paramObject;
    paramViewGroup.removeView(((PendantPageHolder)paramObject).jdField_a_of_type_AndroidViewView);
    ((PendantPageHolder)paramObject).b();
    ((PendantPageHolder)paramObject).a(null);
    this.jdField_b_of_type_JavaUtilList.remove(paramObject);
    this.jdField_c_of_type_JavaUtilList.add(paramObject);
    SLog.a("PendantPageAdapter", "destroyItem, position = %d, holder = %s", new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Int != -1) {
      return this.jdField_a_of_type_Int;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = a((NewStoryPendantType)localIterator.next()) + i) {}
    SLog.a("PendantPageAdapter", "getCount %d", Integer.valueOf(i));
    this.jdField_a_of_type_Int = i;
    return i;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    PendantPageHolder localPendantPageHolder = a(paramViewGroup, paramInt);
    localPendantPageHolder.a(a(paramInt), NewStoryPendantItem.b, paramInt);
    localPendantPageHolder.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    paramViewGroup.addView(localPendantPageHolder.jdField_a_of_type_AndroidViewView);
    localPendantPageHolder.a();
    localPendantPageHolder.a(this);
    SLog.a("PendantPageAdapter", "instantiateItem, position = %d, holder = %s", new Object[] { Integer.valueOf(paramInt), localPendantPageHolder });
    return localPendantPageHolder;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((PendantPageHolder)paramObject).jdField_a_of_type_AndroidViewView == paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\pendant\PendantPageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */