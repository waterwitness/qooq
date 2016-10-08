package com.tencent.mobileqq.emoticonview;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmoticonPanelViewPool
{
  private static final int jdField_a_of_type_Int = 3;
  private static final String jdField_a_of_type_JavaLangString = "EmoticonPanelViewPool";
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  
  public EmoticonPanelViewPool()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new SparseArray();
  }
  
  public int a(int paramInt)
  {
    List localList = (List)this.a.get(paramInt);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public View a(int paramInt)
  {
    List localList = (List)this.a.get(paramInt);
    if ((localList != null) && (localList.size() > 0)) {
      return (View)localList.remove(0);
    }
    return null;
  }
  
  public void a()
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      int k = this.a.keyAt(i);
      ((List)this.a.get(k)).clear();
      i += 1;
    }
    this.a.clear();
  }
  
  public boolean a(int paramInt, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewPool", 2, "[RecyleView] addRecyleView, type=" + paramInt + ", view=" + paramView);
    }
    if (paramView == null) {
      return false;
    }
    List localList = (List)this.a.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(3);
      this.a.put(paramInt, localObject);
    }
    if (((List)localObject).size() >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EmoticonPanelViewPool", 2, "Capacity full for type " + paramInt);
      }
      return false;
    }
    ((List)localObject).add(paramView);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmoticonPanelViewPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */