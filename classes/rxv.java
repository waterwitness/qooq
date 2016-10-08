import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class rxv
{
  private Timer jdField_a_of_type_JavaUtilTimer;
  
  private rxv(OnlineFileSessionCenter paramOnlineFileSessionCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	rxv:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 29	java/util/Timer
    //   18: dup
    //   19: invokespecial 30	java/util/Timer:<init>	()V
    //   22: putfield 27	rxv:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   25: aload_0
    //   26: getfield 27	rxv:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   29: new 32	rxw
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 35	rxw:<init>	(Lrxv;)V
    //   37: ldc2_w 36
    //   40: ldc2_w 36
    //   43: invokevirtual 41	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   46: ldc 43
    //   48: iconst_1
    //   49: ldc 45
    //   51: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: goto -43 -> 11
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	rxv
    //   6	2	1	localTimer	Timer
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	57	finally
    //   14	54	57	finally
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  exit. . .");
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */