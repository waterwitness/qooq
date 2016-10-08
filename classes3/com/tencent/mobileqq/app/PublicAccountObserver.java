package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qdr;
import qds;

public class PublicAccountObserver
  implements BusinessObserver
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 102;
  public static final int d = 103;
  public static final int e = 104;
  public static final int f = 105;
  public static final int g = 106;
  public static final int h = 107;
  
  public PublicAccountObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (100 == paramInt)
    {
      paramObject = (qds)paramObject;
      a(((qds)paramObject).jdField_a_of_type_Int, ((qds)paramObject).jdField_a_of_type_Boolean);
    }
    do
    {
      return;
      if (101 == paramInt)
      {
        if ((paramObject instanceof qdr))
        {
          paramObject = (qdr)paramObject;
          b(((qdr)paramObject).jdField_a_of_type_Int, ((qdr)paramObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        a(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (102 == paramInt)
      {
        if ((paramObject instanceof qdr))
        {
          paramObject = (qdr)paramObject;
          a(((qdr)paramObject).jdField_a_of_type_Int, ((qdr)paramObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
          return;
        }
        b(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (103 == paramInt)
      {
        b();
        return;
      }
      if (104 == paramInt)
      {
        a(paramBoolean);
        return;
      }
      if (105 == paramInt)
      {
        a(((Integer)paramObject).intValue());
        return;
      }
      if (107 == paramInt)
      {
        a(paramBoolean, ((Integer)paramObject).intValue());
        return;
      }
    } while (106 != paramInt);
    a(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b() {}
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void b(boolean paramBoolean, String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PublicAccountObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */