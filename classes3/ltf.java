import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ltf
  implements Runnable
{
  ltf(lte paramlte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 30	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: ldc 32
    //   5: invokestatic 37	com/tencent/mobileqq/cooperation/ApkUtils:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   8: ifle +185 -> 193
    //   11: new 39	android/content/Intent
    //   14: dup
    //   15: ldc 41
    //   17: invokespecial 44	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 12	ltf:a	Llte;
    //   26: getfield 49	lte:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: invokestatic 55	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   32: invokevirtual 59	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   35: pop
    //   36: aload_0
    //   37: getfield 12	ltf:a	Llte;
    //   40: getfield 62	lte:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   43: aload_1
    //   44: invokevirtual 68	com/tencent/mobileqq/activity/LoginActivity:startActivity	(Landroid/content/Intent;)V
    //   47: iconst_1
    //   48: istore_2
    //   49: aload_0
    //   50: getfield 12	ltf:a	Llte;
    //   53: getfield 62	lte:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   56: getfield 72	com/tencent/mobileqq/activity/LoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   59: ldc 74
    //   61: ldc 76
    //   63: ldc 76
    //   65: ldc 78
    //   67: ldc 78
    //   69: iconst_0
    //   70: iconst_0
    //   71: ldc 76
    //   73: ldc 76
    //   75: ldc 76
    //   77: ldc 76
    //   79: invokestatic 83	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   82: iload_2
    //   83: ifne +97 -> 180
    //   86: aload_0
    //   87: getfield 12	ltf:a	Llte;
    //   90: getfield 62	lte:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   93: getfield 72	com/tencent/mobileqq/activity/LoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   96: ldc 74
    //   98: ldc 76
    //   100: ldc 76
    //   102: ldc 85
    //   104: ldc 85
    //   106: iconst_0
    //   107: iconst_0
    //   108: ldc 76
    //   110: ldc 76
    //   112: ldc 76
    //   114: ldc 76
    //   116: invokestatic 83	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   119: new 39	android/content/Intent
    //   122: dup
    //   123: aload_0
    //   124: getfield 12	ltf:a	Llte;
    //   127: getfield 62	lte:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   130: ldc 87
    //   132: invokespecial 90	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   135: astore_1
    //   136: aload_1
    //   137: ldc 92
    //   139: aload_0
    //   140: getfield 12	ltf:a	Llte;
    //   143: getfield 95	lte:b	Ljava/lang/String;
    //   146: invokevirtual 99	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   149: pop
    //   150: new 101	com/tencent/mobileqq/app/upgrade/AuthCodeWriter
    //   153: dup
    //   154: aload_0
    //   155: getfield 12	ltf:a	Llte;
    //   158: getfield 104	lte:c	Ljava/lang/String;
    //   161: aconst_null
    //   162: invokespecial 107	com/tencent/mobileqq/app/upgrade/AuthCodeWriter:<init>	(Ljava/lang/String;Lcom/tencent/mobileqq/app/upgrade/AuthCodeWriter$ICheckCodeListener;)V
    //   165: invokestatic 112	com/tencent/open/downloadnew/DownloadApi:a	(Lcom/tencent/open/downloadnew/ApkWriteCodeListener;)Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 12	ltf:a	Llte;
    //   173: getfield 62	lte:jdField_a_of_type_ComTencentMobileqqActivityLoginActivity	Lcom/tencent/mobileqq/activity/LoginActivity;
    //   176: aload_1
    //   177: invokevirtual 68	com/tencent/mobileqq/activity/LoginActivity:startActivity	(Landroid/content/Intent;)V
    //   180: return
    //   181: astore_1
    //   182: iconst_0
    //   183: istore_2
    //   184: goto -102 -> 82
    //   187: astore_1
    //   188: iconst_1
    //   189: istore_2
    //   190: goto -6 -> 184
    //   193: iconst_0
    //   194: istore_2
    //   195: goto -113 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	ltf
    //   20	157	1	localIntent	android.content.Intent
    //   181	1	1	localException1	Exception
    //   187	1	1	localException2	Exception
    //   48	147	2	i	int
    // Exception table:
    //   from	to	target	type
    //   36	47	181	java/lang/Exception
    //   49	82	187	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */