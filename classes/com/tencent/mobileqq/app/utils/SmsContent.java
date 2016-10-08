package com.tencent.mobileqq.app.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class SmsContent
  extends ContentObserver
{
  public static final String a = "sms.content";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "address", "body", "date" };
  public static final String b = "_id";
  public static final String c = "address";
  public static final String d = "body";
  public static final String e = "date";
  private static final String f = "content://sms/";
  private static final String g = "content://sms/inbox";
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  SMSBodyObserver jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SmsContent(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public SmsContent(Handler paramHandler, long paramLong)
  {
    super(paramHandler);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidContentContext.getContentResolver().unregisterContentObserver(this);
      if (QLog.isColorLevel()) {
        QLog.d("sms.content", 2, "unregister...");
      }
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver = null;
  }
  
  public void a(Context paramContext, SMSBodyObserver paramSMSBodyObserver)
  {
    if (paramContext == null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver = paramSMSBodyObserver;
      this.jdField_a_of_type_AndroidContentContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
    } while (!QLog.isColorLevel());
    QLog.d("sms.content", 2, "register...");
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 96	android/database/ContentObserver:onChange	(Z)V
    //   5: aload_0
    //   6: getfield 52	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: ifnonnull +18 -> 27
    //   12: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 8
    //   20: iconst_2
    //   21: ldc 98
    //   23: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 52	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   31: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: ldc 27
    //   36: invokestatic 84	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: getstatic 42	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   42: aconst_null
    //   43: aconst_null
    //   44: ldc 100
    //   46: invokevirtual 104	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +183 -> 234
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: invokeinterface 109 1 0
    //   62: ifne +172 -> 234
    //   65: aload_3
    //   66: astore_2
    //   67: aload_3
    //   68: invokeinterface 112 1 0
    //   73: ifeq +161 -> 234
    //   76: aload_3
    //   77: astore_2
    //   78: aload_3
    //   79: aload_3
    //   80: ldc 15
    //   82: invokeinterface 116 2 0
    //   87: invokeinterface 120 2 0
    //   92: astore 4
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: aload_3
    //   98: ldc 18
    //   100: invokeinterface 116 2 0
    //   105: invokeinterface 120 2 0
    //   110: astore 5
    //   112: aload_3
    //   113: astore_2
    //   114: aload_3
    //   115: aload_3
    //   116: ldc 21
    //   118: invokeinterface 116 2 0
    //   123: invokeinterface 124 2 0
    //   128: lstore 6
    //   130: aload_3
    //   131: astore_2
    //   132: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +63 -> 198
    //   138: aload_3
    //   139: astore_2
    //   140: ldc 8
    //   142: iconst_2
    //   143: new 126	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   150: ldc -126
    //   152: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 4
    //   157: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc -120
    //   162: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc -118
    //   172: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: lload 6
    //   177: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: ldc -113
    //   182: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield 50	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_Long	J
    //   189: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_3
    //   199: astore_2
    //   200: lload 6
    //   202: aload_0
    //   203: getfield 50	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_Long	J
    //   206: lcmp
    //   207: iflt +27 -> 234
    //   210: aload_3
    //   211: astore_2
    //   212: aload_0
    //   213: getfield 77	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver	Lcom/tencent/mobileqq/app/utils/SMSBodyObserver;
    //   216: ifnull +18 -> 234
    //   219: aload_3
    //   220: astore_2
    //   221: aload_0
    //   222: getfield 77	com/tencent/mobileqq/app/utils/SmsContent:jdField_a_of_type_ComTencentMobileqqAppUtilsSMSBodyObserver	Lcom/tencent/mobileqq/app/utils/SMSBodyObserver;
    //   225: aload 4
    //   227: aload 5
    //   229: invokeinterface 153 3 0
    //   234: aload_3
    //   235: ifnull -209 -> 26
    //   238: aload_3
    //   239: invokeinterface 156 1 0
    //   244: return
    //   245: astore 4
    //   247: aconst_null
    //   248: astore_3
    //   249: aload_3
    //   250: astore_2
    //   251: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +15 -> 269
    //   257: aload_3
    //   258: astore_2
    //   259: ldc 8
    //   261: iconst_2
    //   262: ldc -99
    //   264: aload 4
    //   266: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload_3
    //   270: ifnull -244 -> 26
    //   273: aload_3
    //   274: invokeinterface 156 1 0
    //   279: return
    //   280: astore_3
    //   281: aconst_null
    //   282: astore_2
    //   283: aload_2
    //   284: ifnull +9 -> 293
    //   287: aload_2
    //   288: invokeinterface 156 1 0
    //   293: aload_3
    //   294: athrow
    //   295: astore_3
    //   296: goto -13 -> 283
    //   299: astore 4
    //   301: goto -52 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	SmsContent
    //   0	304	1	paramBoolean	boolean
    //   55	233	2	localCursor1	android.database.Cursor
    //   49	225	3	localCursor2	android.database.Cursor
    //   280	14	3	localObject1	Object
    //   295	1	3	localObject2	Object
    //   92	134	4	str1	String
    //   245	20	4	localException1	Exception
    //   299	1	4	localException2	Exception
    //   110	118	5	str2	String
    //   128	73	6	l	long
    // Exception table:
    //   from	to	target	type
    //   27	50	245	java/lang/Exception
    //   27	50	280	finally
    //   56	65	295	finally
    //   67	76	295	finally
    //   78	94	295	finally
    //   96	112	295	finally
    //   114	130	295	finally
    //   132	138	295	finally
    //   140	198	295	finally
    //   200	210	295	finally
    //   212	219	295	finally
    //   221	234	295	finally
    //   251	257	295	finally
    //   259	269	295	finally
    //   56	65	299	java/lang/Exception
    //   67	76	299	java/lang/Exception
    //   78	94	299	java/lang/Exception
    //   96	112	299	java/lang/Exception
    //   114	130	299	java/lang/Exception
    //   132	138	299	java/lang/Exception
    //   140	198	299	java/lang/Exception
    //   200	210	299	java/lang/Exception
    //   212	219	299	java/lang/Exception
    //   221	234	299	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\utils\SmsContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */