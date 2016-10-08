package com.tencent.mobileqq.activity.qqcard;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CardItemBuilderFactory
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 5;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  
  public CardItemBuilderFactory(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public int a(Object paramObject)
  {
    if ((paramObject instanceof QQCardItem)) {
      return ((QQCardItem)paramObject).itemType;
    }
    return 0;
  }
  
  public BaseCardItemBuilder a(Object paramObject)
  {
    int i = a(paramObject);
    BaseCardItemBuilder localBaseCardItemBuilder = (BaseCardItemBuilder)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBaseCardItemBuilder;
    if (localBaseCardItemBuilder == null)
    {
      paramObject = localBaseCardItemBuilder;
      switch (i)
      {
      default: 
        paramObject = localBaseCardItemBuilder;
      }
    }
    for (;;)
    {
      localObject = paramObject;
      if (paramObject != null)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramObject);
        localObject = paramObject;
      }
      return (BaseCardItemBuilder)localObject;
      paramObject = new CommonCardItemBuilder(this.jdField_a_of_type_AndroidContentContext, 2130904566);
      continue;
      paramObject = new ObtainableCardBuilder(this.jdField_a_of_type_AndroidContentContext, 2130904587);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\CardItemBuilderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */