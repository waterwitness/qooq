package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class FacePanelBaseAdapter
  implements FacePanelAdapter
{
  private List a;
  
  public FacePanelBaseAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AdapterObserver)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AdapterObserver)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(AdapterObserver paramAdapterObserver)
  {
    if (paramAdapterObserver == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramAdapterObserver)) {
      throw new IllegalStateException("Observer " + paramAdapterObserver + " is already registered.");
    }
    this.a.add(paramAdapterObserver);
  }
  
  public void b(AdapterObserver paramAdapterObserver)
  {
    if (paramAdapterObserver == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramAdapterObserver);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramAdapterObserver + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\adapter\FacePanelBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */