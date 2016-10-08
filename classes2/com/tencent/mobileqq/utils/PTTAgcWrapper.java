package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PTTAgcWrapper
{
  private static PTTAgcWrapper jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper;
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  
  private PTTAgcWrapper(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    PTTAGCCreateAPI();
    PTTAGCCalcuAPI(paramInt);
    PTTAGCResetAPI();
  }
  
  private static native void PTTAGCCalcuAPI(int paramInt);
  
  public static native int PTTAGCCreateAPI();
  
  public static native int PTTAGCFreeAPI();
  
  public static native void PTTAGCResetAPI();
  
  public static native void PTTAGCRunAPI(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void PTTVMICRunAPI(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  /* Error */
  public static PTTAgcWrapper a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   6: ifnonnull +42 -> 48
    //   9: getstatic 40	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Boolean	Z
    //   12: ifne +25 -> 37
    //   15: aload_0
    //   16: ldc 42
    //   18: invokestatic 48	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifne +10 -> 33
    //   26: aconst_null
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: iconst_1
    //   34: putstatic 40	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Boolean	Z
    //   37: new 2	com/tencent/mobileqq/utils/PTTAgcWrapper
    //   40: dup
    //   41: iload_1
    //   42: invokespecial 50	com/tencent/mobileqq/utils/PTTAgcWrapper:<init>	(I)V
    //   45: putstatic 38	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   48: iload_1
    //   49: getstatic 38	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   52: getfield 20	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Int	I
    //   55: if_icmpeq +14 -> 69
    //   58: getstatic 38	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   61: iload_1
    //   62: putfield 20	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Int	I
    //   65: iload_1
    //   66: invokestatic 27	com/tencent/mobileqq/utils/PTTAgcWrapper:PTTAGCCalcuAPI	(I)V
    //   69: getstatic 38	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   72: astore_0
    //   73: goto -45 -> 28
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	android.content.Context
    //   0	82	1	paramInt	int
    //   21	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	22	76	finally
    //   33	37	76	finally
    //   37	48	76	finally
    //   48	69	76	finally
    //   69	73	76	finally
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PTTVMICRunAPI(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PTTAGCRunAPI(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected void finalize()
  {
    super.finalize();
    PTTAGCFreeAPI();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\PTTAgcWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */