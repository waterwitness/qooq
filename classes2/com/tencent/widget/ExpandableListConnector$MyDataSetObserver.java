package com.tencent.widget;

import android.database.DataSetObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ExpandableListConnector$MyDataSetObserver
  extends DataSetObserver
{
  protected ExpandableListConnector$MyDataSetObserver(ExpandableListConnector paramExpandableListConnector)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChanged()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ExpandableListConnector$MyDataSetObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */