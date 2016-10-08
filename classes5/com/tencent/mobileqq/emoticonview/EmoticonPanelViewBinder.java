package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public abstract class EmoticonPanelViewBinder
  extends EmoticonViewBinder
{
  private static EmoticonPanelViewPool jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool;
  private static final String jdField_a_of_type_JavaLangString = "EmoticonPanelViewBinder";
  public Context a;
  protected SparseArray a;
  public int b;
  protected int c;
  
  public EmoticonPanelViewBinder(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramInt1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramContext == null) {
      throw new IllegalArgumentException("Context MUST NOT be null!!!");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool != null)
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool.a();
      jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool = null;
    }
  }
  
  protected abstract int a(int paramInt);
  
  protected View a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, " createEmoticonPanelView, type=" + paramInt);
    }
    long l = System.currentTimeMillis();
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelViewBinder", 2, "[Performance] createEmoticonPanelView, type=" + paramInt + ",duration=" + (System.currentTimeMillis() - l));
      }
      return (View)localObject;
      localObject = new EmoticonLinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      ((EmoticonLinearLayout)localObject).setPanelViewType(paramInt);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        } while (localView == null);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        paramInt = a(paramInt);
      } while (!a(paramInt));
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool = new EmoticonPanelViewPool();
      }
    } while (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool.a(paramInt, localView));
  }
  
  protected abstract void a(View paramView, int paramInt);
  
  public int b()
  {
    return a();
  }
  
  protected View b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, "getEmoticonPanelView, pageIndex=" + paramInt + ",viewBinder=" + this);
    }
    int i = a(paramInt);
    View localView1 = null;
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool != null) {
      localView1 = jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool.a(i);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = a(i);
    }
    if (localView2 != null)
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView2);
      a(localView2, paramInt);
    }
    return localView2;
  }
  
  protected View c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return null;
    }
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmoticonPanelViewBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */