import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.FilterData;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.ItemViewGestureListener;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ivb
  extends PagerAdapter
{
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private NewStoryFilterViewPagerController.ItemViewGestureListener jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener;
  private final NewStoryTakeVideoActivity jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity;
  private final List jdField_a_of_type_JavaUtilList;
  private final SparseArray b;
  
  public ivb(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new SparseArray();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity = paramNewStoryTakeVideoActivity;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    return paramInt % this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public NewStoryFilterViewPagerController.FilterData a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (NewStoryFilterViewPagerController.FilterData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public iva a(int paramInt)
  {
    return (iva)this.b.get(paramInt);
  }
  
  public void a(NewStoryFilterViewPagerController.ItemViewGestureListener paramItemViewGestureListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener = paramItemViewGestureListener;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    iva localiva1 = (iva)paramObject;
    paramViewGroup.removeView(localiva1.a);
    localiva1.a.setOnTouchListener(null);
    localiva1.a();
    int i = localiva1.a();
    paramObject = (Queue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.offer(localiva1);
      this.b.remove(paramInt);
      return;
      paramViewGroup = (ViewGroup)paramObject;
      if (((Queue)paramObject).size() > 0)
      {
        iva localiva2 = (iva)((Queue)paramObject).peek();
        if (localiva2 != null)
        {
          paramViewGroup = (ViewGroup)paramObject;
          if (localiva2.a() == i) {}
        }
        else
        {
          SLog.a("Q.qqstory.record.FilterViewPagerController", "data type mismatch, bin data type %d, recycle item data type %d", localiva2, Integer.valueOf(i));
          paramViewGroup = new LinkedList();
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramViewGroup);
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    NewStoryFilterViewPagerController.FilterData localFilterData = a(paramInt);
    if (localFilterData == null)
    {
      SLog.d("Q.qqstory.record.FilterViewPagerController", "instantiateItem find data is null !");
      return null;
    }
    int i = localFilterData.d;
    Object localObject1 = (Queue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (iva)((Queue)localObject1).poll();
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((iva)localObject2).a() == i) {
          break label76;
        }
      }
    }
    for (localObject1 = null;; localObject1 = null)
    {
      label76:
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (i != 1) {
          break label153;
        }
        localObject2 = new ivg(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, paramViewGroup, null);
      }
      for (;;)
      {
        paramViewGroup.addView(((iva)localObject2).a);
        ((iva)localObject2).a.setOnTouchListener(new ivc(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener));
        ((iva)localObject2).a(localFilterData, paramInt);
        this.b.put(paramInt, localObject2);
        return localObject2;
        label153:
        if (i == 3)
        {
          localObject2 = new ivf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, paramViewGroup, null);
        }
        else
        {
          if (i != 2) {
            break;
          }
          localObject2 = new ive(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, paramViewGroup);
        }
      }
      throw new IllegalArgumentException("illegal item type : " + i);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof iva)) && (((iva)paramObject).a == paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */