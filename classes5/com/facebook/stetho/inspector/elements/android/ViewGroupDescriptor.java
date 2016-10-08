package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.android.FragmentCompatUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

final class ViewGroupDescriptor
  extends AbstractChainedDescriptor<ViewGroup>
{
  private final Map<View, Object> mViewToElementMap = Collections.synchronizedMap(new WeakHashMap());
  
  private Object getElement(View paramView, Object paramObject)
  {
    if (paramObject == this) {
      return paramView;
    }
    return ((WeakReference)paramObject).get();
  }
  
  private Object getElementForView(ViewGroup paramViewGroup, View paramView)
  {
    Object localObject = this.mViewToElementMap.get(paramView);
    if (localObject != null)
    {
      localObject = getElement(paramView, localObject);
      if ((localObject != null) && (paramView.getParent() == paramViewGroup)) {
        return localObject;
      }
      this.mViewToElementMap.remove(paramView);
    }
    paramViewGroup = FragmentCompatUtil.findFragmentForView(paramView);
    if ((paramViewGroup != null) && (!FragmentCompatUtil.isDialogFragment(paramViewGroup)))
    {
      this.mViewToElementMap.put(paramView, new WeakReference(paramViewGroup));
      return paramViewGroup;
    }
    this.mViewToElementMap.put(paramView, this);
    return paramView;
  }
  
  private boolean isChildVisible(View paramView)
  {
    return !(paramView instanceof DocumentHiddenView);
  }
  
  protected void onGetChildren(ViewGroup paramViewGroup, Accumulator<Object> paramAccumulator)
  {
    int i = 0;
    int j = paramViewGroup.getChildCount();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      View localView = paramViewGroup.getChildAt(i);
      if (isChildVisible(localView)) {
        paramAccumulator.store(getElementForView(paramViewGroup, localView));
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ViewGroupDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */