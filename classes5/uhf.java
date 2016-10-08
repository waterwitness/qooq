import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.ActionListActivity;
import com.tencent.mobileqq.richstatus.StateTag;
import java.util.ArrayList;
import java.util.Iterator;

public class uhf
  extends PagerAdapter
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private uhf(ActionListActivity paramActionListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        StateTag localStateTag = (StateTag)localIterator.next();
        GridView localGridView = new GridView(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getApplicationContext());
        localGridView.setNumColumns(3);
        localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        localGridView.setSelector(new ColorDrawable(0));
        localGridView.setScrollingCacheEnabled(false);
        localGridView.setAdapter(new uhe(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity, localStateTag.jdField_a_of_type_JavaUtilArrayList));
        this.jdField_a_of_type_JavaUtilArrayList.add(localGridView);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      System.gc();
      super.notifyDataSetChanged();
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    GridView localGridView = (GridView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup.addView(localGridView);
    return localGridView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */