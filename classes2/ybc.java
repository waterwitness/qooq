import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongPluginManager;

public class ybc
  extends AsyncTask
{
  public ybc(DingdongPluginManager paramDingdongPluginManager, int paramInt, ybd paramybd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  protected Void a(com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	ybc:jdField_a_of_type_CooperationDingdongDingdongPluginManager	Lcooperation/dingdong/DingdongPluginManager;
    //   4: invokestatic 32	cooperation/dingdong/DingdongPluginManager:a	(Lcooperation/dingdong/DingdongPluginManager;)Ljava/util/HashMap;
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_1
    //   11: iconst_0
    //   12: aaload
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 12	ybc:jdField_a_of_type_CooperationDingdongDingdongPluginManager	Lcooperation/dingdong/DingdongPluginManager;
    //   18: invokestatic 35	cooperation/dingdong/DingdongPluginManager:a	(Lcooperation/dingdong/DingdongPluginManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 41	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   24: new 43	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   31: aload_0
    //   32: getfield 12	ybc:jdField_a_of_type_CooperationDingdongDingdongPluginManager	Lcooperation/dingdong/DingdongPluginManager;
    //   35: invokestatic 35	cooperation/dingdong/DingdongPluginManager:a	(Lcooperation/dingdong/DingdongPluginManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   41: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 53
    //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: iconst_0
    //   53: invokevirtual 62	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   56: aload_1
    //   57: getfield 67	com/tencent/mobileqq/app/utils/DingdongPluginBizObserver$ScheduleMoreSummaryData:a	Lcooperation/dingdong/DingdongPluginDataFactory$ScheduleSummaryData;
    //   60: getfield 73	cooperation/dingdong/DingdongPluginDataFactory$ScheduleSummaryData:id	Ljava/lang/String;
    //   63: lconst_0
    //   64: invokeinterface 79 4 0
    //   69: lstore_3
    //   70: lload_3
    //   71: lconst_0
    //   72: lcmp
    //   73: ifne +15 -> 88
    //   76: aload_0
    //   77: getfield 14	ybc:jdField_a_of_type_Int	I
    //   80: aload_1
    //   81: invokestatic 85	cooperation/dingdong/DingdongCalendarSyncUtil:b	(ILcom/tencent/mobileqq/app/utils/DingdongPluginBizObserver$ScheduleMoreSummaryData;)V
    //   84: aload_2
    //   85: monitorexit
    //   86: aconst_null
    //   87: areturn
    //   88: lload_3
    //   89: lconst_0
    //   90: lcmp
    //   91: ifle +15 -> 106
    //   94: lload_3
    //   95: aload_0
    //   96: getfield 16	ybc:jdField_a_of_type_Ybd	Lybd;
    //   99: getfield 90	ybd:b	J
    //   102: lcmp
    //   103: ifgt -19 -> 84
    //   106: aload_0
    //   107: getfield 14	ybc:jdField_a_of_type_Int	I
    //   110: aload_1
    //   111: invokestatic 85	cooperation/dingdong/DingdongCalendarSyncUtil:b	(ILcom/tencent/mobileqq/app/utils/DingdongPluginBizObserver$ScheduleMoreSummaryData;)V
    //   114: goto -30 -> 84
    //   117: astore_1
    //   118: aload_2
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	ybc
    //   0	122	1	paramVarArgs	com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData[]
    //   7	112	2	localHashMap	java.util.HashMap
    //   69	26	3	l	long
    // Exception table:
    //   from	to	target	type
    //   14	70	117	finally
    //   76	84	117	finally
    //   84	86	117	finally
    //   94	106	117	finally
    //   106	114	117	finally
    //   118	120	117	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */