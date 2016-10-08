package com.tencent.mobileqq.emoticonview;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class PanelRecycleBin
{
  private static final int jdField_a_of_type_Int = 3;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public PanelRecycleBin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public View a()
  {
    if (this.a.size() > 0) {
      return (View)this.a.remove(0);
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(View paramView)
  {
    if (this.a.size() >= 3) {
      return;
    }
    this.a.add(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\PanelRecycleBin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */