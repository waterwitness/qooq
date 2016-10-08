import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.smooth.ItemManager;

class tqa
  extends BaseAdapter
{
  final BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  final ItemManager jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager;
  
  tqa(ItemManager paramItemManager, BaseAdapter paramBaseAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager = paramItemManager;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
  }
  
  ListAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(paramInt, paramView, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManager.a(paramViewGroup, paramView, paramInt);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */