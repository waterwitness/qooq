import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lwy
  implements DialogInterface.OnClickListener
{
  public lwy(NotificationActivity paramNotificationActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void onClick(android.content.DialogInterface paramDialogInterface, int paramInt)
  {
    // Byte code:
    //   0: new 31	android/content/Intent
    //   3: dup
    //   4: ldc 33
    //   6: aload_0
    //   7: getfield 15	lwy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 39	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: invokespecial 42	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 13	lwy:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   21: aload_1
    //   22: invokevirtual 48	com/tencent/mobileqq/activity/NotificationActivity:startActivity	(Landroid/content/Intent;)V
    //   25: aconst_null
    //   26: ldc 50
    //   28: ldc 52
    //   30: ldc 54
    //   32: ldc 56
    //   34: ldc 58
    //   36: iconst_0
    //   37: iconst_0
    //   38: ldc 54
    //   40: ldc 54
    //   42: ldc 54
    //   44: ldc 54
    //   46: invokestatic 64	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 13	lwy:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   53: invokevirtual 67	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   62: goto -13 -> 49
    //   65: astore_1
    //   66: aconst_null
    //   67: ldc 50
    //   69: ldc 52
    //   71: ldc 54
    //   73: ldc 56
    //   75: ldc 58
    //   77: iconst_0
    //   78: iconst_0
    //   79: ldc 54
    //   81: ldc 54
    //   83: ldc 54
    //   85: ldc 54
    //   87: invokestatic 64	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 13	lwy:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   94: invokevirtual 67	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   103: goto -13 -> 90
    //   106: astore_1
    //   107: aconst_null
    //   108: ldc 50
    //   110: ldc 52
    //   112: ldc 54
    //   114: ldc 56
    //   116: ldc 58
    //   118: iconst_0
    //   119: iconst_0
    //   120: ldc 54
    //   122: ldc 54
    //   124: ldc 54
    //   126: ldc 54
    //   128: invokestatic 64	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 13	lwy:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   135: invokevirtual 67	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_3
    //   141: aload_3
    //   142: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   145: goto -14 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	lwy
    //   0	148	1	paramDialogInterface	android.content.DialogInterface
    //   0	148	2	paramInt	int
    //   140	2	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   25	49	57	java/lang/Exception
    //   0	25	65	java/lang/Exception
    //   66	90	98	java/lang/Exception
    //   0	25	106	finally
    //   107	131	140	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */