package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DragSortItemViewCheckable
  extends DragSortItemView
  implements Checkable
{
  public DragSortItemViewCheckable(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean isChecked()
  {
    View localView = super.getChildAt(0);
    if ((localView instanceof Checkable)) {
      return ((Checkable)localView).isChecked();
    }
    return false;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    View localView = super.getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).setChecked(paramBoolean);
    }
  }
  
  public void toggle()
  {
    View localView = super.getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).toggle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\view\DragSortItemViewCheckable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */