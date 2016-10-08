import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rwh
  extends FMObserver
{
  public rwh(DiscOfflinePreviewController paramDiscOfflinePreviewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 25	com/tencent/mobileqq/filemanager/data/FMConfig:a	Z
    //   5: ifeq +44 -> 49
    //   8: ldc 27
    //   10: astore 5
    //   12: ldc 29
    //   14: astore 6
    //   16: aload_0
    //   17: getfield 10	rwh:a	Lcom/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController;
    //   20: getfield 34	com/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback	Lcom/tencent/mobileqq/filemanager/activity/FilePreviewActivity$ControlerCallback;
    //   23: iload_1
    //   24: aload 5
    //   26: aload 6
    //   28: iload_2
    //   29: i2l
    //   30: aload_3
    //   31: aload 4
    //   33: aconst_null
    //   34: aload_0
    //   35: getfield 10	rwh:a	Lcom/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController;
    //   38: getfield 37	com/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokeinterface 42 10 0
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload 5
    //   51: ifnull +31 -> 82
    //   54: aload 5
    //   56: invokevirtual 48	java/lang/String:length	()I
    //   59: ifle +23 -> 82
    //   62: aload 5
    //   64: ldc 50
    //   66: invokevirtual 54	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   69: ifne +13 -> 82
    //   72: iload 7
    //   74: invokestatic 58	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: astore 6
    //   79: goto -63 -> 16
    //   82: aload 6
    //   84: astore 5
    //   86: goto -14 -> 72
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	rwh
    //   0	94	1	paramBoolean	boolean
    //   0	94	2	paramInt1	int
    //   0	94	3	paramString1	String
    //   0	94	4	paramString2	String
    //   0	94	5	paramString3	String
    //   0	94	6	paramString4	String
    //   0	94	7	paramInt2	int
    //   0	94	8	paramString5	String
    // Exception table:
    //   from	to	target	type
    //   2	8	89	finally
    //   16	46	89	finally
    //   54	72	89	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rwh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */