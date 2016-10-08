package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.android.FragmentAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import javax.annotation.Nullable;

final class FragmentDescriptor
  extends AbstractChainedDescriptor<Object>
  implements HighlightableDescriptor
{
  private static final String ID_ATTRIBUTE_NAME = "id";
  private static final String TAG_ATTRIBUTE_NAME = "tag";
  private final FragmentAccessor mAccessor;
  
  private FragmentDescriptor(FragmentCompat paramFragmentCompat)
  {
    this.mAccessor = paramFragmentCompat.forFragment();
  }
  
  private static void maybeRegister(DescriptorMap paramDescriptorMap, @Nullable FragmentCompat paramFragmentCompat)
  {
    if (paramFragmentCompat != null)
    {
      Class localClass = paramFragmentCompat.getFragmentClass();
      LogUtil.d("Adding support for %s", new Object[] { localClass.getName() });
      paramDescriptorMap.register(localClass, new FragmentDescriptor(paramFragmentCompat));
    }
  }
  
  public static DescriptorMap register(DescriptorMap paramDescriptorMap)
  {
    maybeRegister(paramDescriptorMap, FragmentCompat.getSupportLibInstance());
    maybeRegister(paramDescriptorMap, FragmentCompat.getFrameworkInstance());
    return paramDescriptorMap;
  }
  
  public View getViewForHighlighting(Object paramObject)
  {
    return this.mAccessor.getView(paramObject);
  }
  
  protected void onGetAttributes(Object paramObject, AttributeAccumulator paramAttributeAccumulator)
  {
    int i = this.mAccessor.getId(paramObject);
    if (i != 0) {
      paramAttributeAccumulator.store("id", ResourcesUtil.getIdStringQuietly(paramObject, this.mAccessor.getResources(paramObject), i));
    }
    paramObject = this.mAccessor.getTag(paramObject);
    if ((paramObject != null) && (((String)paramObject).length() > 0)) {
      paramAttributeAccumulator.store("tag", (String)paramObject);
    }
  }
  
  protected void onGetChildren(Object paramObject, Accumulator<Object> paramAccumulator)
  {
    paramObject = this.mAccessor.getView(paramObject);
    if (paramObject != null) {
      paramAccumulator.store(paramObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\FragmentDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */