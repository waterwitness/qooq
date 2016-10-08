package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class ApplicationDescriptor
  extends AbstractChainedDescriptor<Application>
{
  private final ActivityTracker mActivityTracker = ActivityTracker.get();
  private final Map<Application, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());
  
  private ElementContext getContext(Application paramApplication)
  {
    return (ElementContext)this.mElementToContextMap.get(paramApplication);
  }
  
  protected void onGetChildren(Application paramApplication, Accumulator<Object> paramAccumulator)
  {
    paramApplication = getContext(paramApplication).getActivitiesList();
    int i = paramApplication.size() - 1;
    for (;;)
    {
      if (i < 0) {
        return;
      }
      paramAccumulator.store(paramApplication.get(i));
      i -= 1;
    }
  }
  
  protected NodeType onGetNodeType(Application paramApplication)
  {
    return NodeType.ELEMENT_NODE;
  }
  
  protected void onHook(Application paramApplication)
  {
    ElementContext localElementContext = new ElementContext();
    localElementContext.hook(paramApplication);
    this.mElementToContextMap.put(paramApplication, localElementContext);
  }
  
  protected void onUnhook(Application paramApplication)
  {
    ((ElementContext)this.mElementToContextMap.remove(paramApplication)).unhook();
  }
  
  private class ElementContext
  {
    private Application mElement;
    private final ActivityTracker.Listener mListener = new ActivityTracker.Listener()
    {
      public void onActivityAdded(Activity paramAnonymousActivity) {}
      
      public void onActivityRemoved(Activity paramAnonymousActivity) {}
    };
    
    public ElementContext() {}
    
    public List<Activity> getActivitiesList()
    {
      return ApplicationDescriptor.this.mActivityTracker.getActivitiesView();
    }
    
    public void hook(Application paramApplication)
    {
      this.mElement = paramApplication;
      ApplicationDescriptor.this.mActivityTracker.registerListener(this.mListener);
    }
    
    public void unhook()
    {
      ApplicationDescriptor.this.mActivityTracker.unregisterListener(this.mListener);
      this.mElement = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ApplicationDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */