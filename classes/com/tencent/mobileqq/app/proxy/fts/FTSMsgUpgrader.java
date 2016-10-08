package com.tencent.mobileqq.app.proxy.fts;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FTSMsgUpgrader
  implements FTSUpgrader
{
  public static final String a = "msg_upgrade_log";
  public static final String b = "UpgradeCursor";
  private static final String c = "Q.fts.FTSMsgUpgrader";
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FTSMsgOperator jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSMsgOperator;
  private FTSSyncHandler jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  FTSMsgUpgrader(QQAppInterface paramQQAppInterface, FTSMsgOperator paramFTSMsgOperator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSMsgOperator = paramFTSMsgOperator;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSMsgOperator.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler = this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSMsgOperator.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler;
  }
  
  private long a(long paramLong1, String paramString, long paramLong2, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramLong1 != -1L)
    {
      paramString = new ContentValues();
      paramString.put("MAX_ID", Long.valueOf(paramLong2));
      return paramSQLiteDatabase.a("msg_upgrade_log", paramString, "id=?", new String[] { String.valueOf(paramLong1) });
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tablename", paramString);
    localContentValues.put("MAX_ID", Long.valueOf(paramLong2));
    return paramSQLiteDatabase.a("msg_upgrade_log", null, localContentValues);
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_table", String.valueOf(SQLiteFTSUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    localHashMap.put("param_msg", String.valueOf(SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actFTSUpgradeCost", true, SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0L, localHashMap, null, false);
    SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade table complete, cost =" + SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "us, tables = " + SQLiteFTSUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + ", msgs = " + SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
  }
  
  private void c()
  {
    long l1 = SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l2 = System.nanoTime();
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("UpgradeCursor"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: upgradeCursorTable has not exist");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("UpgradeCursor"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: create upgradeCursorTable failure");
        }
        return;
      }
    }
    for (int i = 0;; i = -1)
    {
      int j = i;
      if (i != 1) {
        j = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("UpgradeCursor");
      }
      if (j == -1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: curCursor == -1");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: curCursor = " + j);
      }
      this.jdField_b_of_type_Int = j;
      l2 = (System.nanoTime() - l2) / 1000L;
      SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokestatic 211	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   7: iconst_1
    //   8: if_icmpeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokestatic 214	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   20: ifeq +19 -> 39
    //   23: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 16
    //   31: iconst_2
    //   32: ldc -40
    //   34: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: iconst_1
    //   38: ireturn
    //   39: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 16
    //   47: iconst_2
    //   48: ldc -38
    //   50: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokestatic 136	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   60: lstore 4
    //   62: invokestatic 184	java/lang/System:nanoTime	()J
    //   65: lstore 6
    //   67: aload_0
    //   68: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: invokevirtual 221	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   74: ldc -33
    //   76: aconst_null
    //   77: invokevirtual 226	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +301 -> 383
    //   85: aload_1
    //   86: invokeinterface 232 1 0
    //   91: istore_2
    //   92: iload_2
    //   93: iconst_1
    //   94: if_icmpne +289 -> 383
    //   97: iconst_1
    //   98: istore_2
    //   99: iload_2
    //   100: istore_3
    //   101: aload_1
    //   102: ifnull +11 -> 113
    //   105: aload_1
    //   106: invokeinterface 235 1 0
    //   111: iload_2
    //   112: istore_3
    //   113: iload_3
    //   114: ifne +55 -> 169
    //   117: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +11 -> 131
    //   123: ldc 16
    //   125: iconst_2
    //   126: ldc -19
    //   128: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: invokespecial 176	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:b	()V
    //   135: iconst_1
    //   136: ireturn
    //   137: astore_1
    //   138: iconst_0
    //   139: istore_2
    //   140: aload_1
    //   141: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   144: iload_2
    //   145: istore_3
    //   146: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq -36 -> 113
    //   152: ldc 16
    //   154: iconst_2
    //   155: ldc -14
    //   157: aload_1
    //   158: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: iload_2
    //   162: istore_3
    //   163: goto -50 -> 113
    //   166: astore_1
    //   167: aload_1
    //   168: athrow
    //   169: aload_0
    //   170: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   173: invokevirtual 221	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   176: ldc -8
    //   178: aconst_null
    //   179: invokevirtual 226	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +194 -> 378
    //   187: aload_1
    //   188: invokeinterface 232 1 0
    //   193: iconst_1
    //   194: if_icmpne +184 -> 378
    //   197: aload_1
    //   198: invokeinterface 251 1 0
    //   203: pop
    //   204: aload_1
    //   205: aload_1
    //   206: ldc 58
    //   208: invokeinterface 254 2 0
    //   213: invokeinterface 258 2 0
    //   218: istore_2
    //   219: iload_2
    //   220: istore_3
    //   221: aload_1
    //   222: ifnull +11 -> 233
    //   225: aload_1
    //   226: invokeinterface 235 1 0
    //   231: iload_2
    //   232: istore_3
    //   233: iload_3
    //   234: iconst_m1
    //   235: if_icmpne +56 -> 291
    //   238: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +12 -> 253
    //   244: ldc 16
    //   246: iconst_2
    //   247: ldc_w 260
    //   250: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: invokespecial 176	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:b	()V
    //   257: iconst_1
    //   258: ireturn
    //   259: astore_1
    //   260: iconst_m1
    //   261: istore_2
    //   262: aload_1
    //   263: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   266: iload_2
    //   267: istore_3
    //   268: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq -38 -> 233
    //   274: ldc 16
    //   276: iconst_2
    //   277: ldc -14
    //   279: aload_1
    //   280: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: iload_2
    //   284: istore_3
    //   285: goto -52 -> 233
    //   288: astore_1
    //   289: aload_1
    //   290: athrow
    //   291: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +29 -> 323
    //   297: ldc 16
    //   299: iconst_2
    //   300: new 150	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 262
    //   310: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload_3
    //   314: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_0
    //   324: iload_3
    //   325: putfield 100	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_Int	I
    //   328: invokestatic 184	java/lang/System:nanoTime	()J
    //   331: lload 6
    //   333: lsub
    //   334: ldc2_w 203
    //   337: ldiv
    //   338: lstore 6
    //   340: aload_0
    //   341: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   344: lload 4
    //   346: lload 6
    //   348: invokestatic 207	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   351: pop2
    //   352: aload_0
    //   353: getfield 46	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler	Lcom/tencent/mobileqq/app/proxy/fts/FTSSyncHandler;
    //   356: new 264	qno
    //   359: dup
    //   360: aload_0
    //   361: invokespecial 266	qno:<init>	(Lcom/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader;)V
    //   364: invokevirtual 272	com/tencent/mobileqq/app/proxy/fts/FTSSyncHandler:post	(Ljava/lang/Runnable;)Z
    //   367: pop
    //   368: iconst_0
    //   369: ireturn
    //   370: astore_1
    //   371: goto -109 -> 262
    //   374: astore_1
    //   375: goto -235 -> 140
    //   378: iconst_m1
    //   379: istore_2
    //   380: goto -161 -> 219
    //   383: iconst_0
    //   384: istore_2
    //   385: goto -286 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	FTSMsgUpgrader
    //   80	26	1	localCursor1	Cursor
    //   137	21	1	localException1	Exception
    //   166	2	1	localObject1	Object
    //   182	44	1	localCursor2	Cursor
    //   259	21	1	localException2	Exception
    //   288	2	1	localObject2	Object
    //   370	1	1	localException3	Exception
    //   374	1	1	localException4	Exception
    //   91	294	2	i	int
    //   100	225	3	j	int
    //   60	285	4	l1	long
    //   65	282	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   67	81	137	java/lang/Exception
    //   85	92	137	java/lang/Exception
    //   67	81	166	finally
    //   85	92	166	finally
    //   105	111	166	finally
    //   140	144	166	finally
    //   146	161	166	finally
    //   169	183	259	java/lang/Exception
    //   187	219	259	java/lang/Exception
    //   169	183	288	finally
    //   187	219	288	finally
    //   225	231	288	finally
    //   262	266	288	finally
    //   268	283	288	finally
    //   225	231	370	java/lang/Exception
    //   105	111	374	java/lang/Exception
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 16
    //   8: iconst_2
    //   9: ldc_w 278
    //   12: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore_1
    //   17: aconst_null
    //   18: astore_3
    //   19: new 280	java/util/ArrayList
    //   22: dup
    //   23: sipush 512
    //   26: invokespecial 283	java/util/ArrayList:<init>	(I)V
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   35: invokestatic 110	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   38: istore 6
    //   40: aload_0
    //   41: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokestatic 121	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   47: istore 7
    //   49: aload_0
    //   50: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokestatic 136	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   56: lstore 11
    //   58: invokestatic 184	java/lang/System:nanoTime	()J
    //   61: lstore 13
    //   63: aload_0
    //   64: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 286	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   70: invokevirtual 292	com/tencent/mobileqq/persistence/EntityManagerFactory:createMessageRecordEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   73: checkcast 294	com/tencent/mobileqq/persistence/MessageRecordEntityManager
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   81: invokevirtual 221	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   84: ldc_w 296
    //   87: iconst_1
    //   88: anewarray 72	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   97: iconst_1
    //   98: iadd
    //   99: invokestatic 113	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   102: aastore
    //   103: invokevirtual 226	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +460 -> 568
    //   111: aload_3
    //   112: invokeinterface 232 1 0
    //   117: iconst_1
    //   118: if_icmpne +450 -> 568
    //   121: aload_3
    //   122: invokeinterface 251 1 0
    //   127: pop
    //   128: aload_3
    //   129: aload_3
    //   130: ldc 82
    //   132: invokeinterface 254 2 0
    //   137: invokeinterface 299 2 0
    //   142: astore_1
    //   143: aload_3
    //   144: aload_3
    //   145: ldc 58
    //   147: invokeinterface 254 2 0
    //   152: invokeinterface 303 2 0
    //   157: lstore 9
    //   159: aload_3
    //   160: ifnull +9 -> 169
    //   163: aload_3
    //   164: invokeinterface 235 1 0
    //   169: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +40 -> 212
    //   175: ldc 16
    //   177: iconst_2
    //   178: new 150	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 305
    //   188: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 307
    //   198: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: lload 9
    //   203: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aconst_null
    //   213: astore 4
    //   215: aload 4
    //   217: astore_3
    //   218: aload_1
    //   219: ifnull +163 -> 382
    //   222: aload 4
    //   224: astore_3
    //   225: lload 9
    //   227: lconst_0
    //   228: lcmp
    //   229: ifle +153 -> 382
    //   232: new 150	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 309
    //   242: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_1
    //   246: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 311
    //   252: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_3
    //   259: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +46 -> 308
    //   265: ldc 16
    //   267: iconst_2
    //   268: new 150	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 313
    //   278: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 315
    //   288: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: lload 9
    //   293: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: ldc_w 317
    //   299: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_0
    //   309: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: astore_1
    //   313: aload_2
    //   314: aload_3
    //   315: iconst_1
    //   316: anewarray 72	java/lang/String
    //   319: dup
    //   320: iconst_0
    //   321: lload 9
    //   323: invokestatic 75	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   326: aastore
    //   327: aload_1
    //   328: invokevirtual 320	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   331: astore 4
    //   333: aload 4
    //   335: astore_3
    //   336: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +43 -> 382
    //   342: new 150	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 322
    //   352: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: astore_3
    //   356: aload 4
    //   358: ifnonnull +256 -> 614
    //   361: ldc_w 324
    //   364: astore_1
    //   365: ldc 16
    //   367: iconst_2
    //   368: aload_3
    //   369: aload_1
    //   370: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload 4
    //   381: astore_3
    //   382: aload_3
    //   383: ifnull +249 -> 632
    //   386: aload_3
    //   387: invokeinterface 332 1 0
    //   392: ifne +240 -> 632
    //   395: aload_3
    //   396: invokeinterface 336 1 0
    //   401: astore_1
    //   402: aload_1
    //   403: invokeinterface 341 1 0
    //   408: ifeq +224 -> 632
    //   411: aload_1
    //   412: invokeinterface 345 1 0
    //   417: checkcast 347	com/tencent/mobileqq/data/MessageRecord
    //   420: astore_3
    //   421: aload_3
    //   422: invokevirtual 350	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   425: ifeq -23 -> 402
    //   428: aload_3
    //   429: getfield 353	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   432: ifeq -30 -> 402
    //   435: aload_3
    //   436: getfield 356	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   439: sipush 63530
    //   442: if_icmpeq -40 -> 402
    //   445: aload_3
    //   446: invokestatic 361	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/fts/FTSMessage;
    //   449: astore_3
    //   450: aload_3
    //   451: ifnull -49 -> 402
    //   454: aload_3
    //   455: invokevirtual 366	com/tencent/mobileqq/data/fts/FTSMessage:insertOpt	()V
    //   458: aload_3
    //   459: invokevirtual 369	com/tencent/mobileqq/data/fts/FTSMessage:preWrite	()V
    //   462: aload 5
    //   464: aload_3
    //   465: invokevirtual 373	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   468: pop
    //   469: goto -67 -> 402
    //   472: astore_1
    //   473: aload_1
    //   474: invokevirtual 374	java/lang/Throwable:printStackTrace	()V
    //   477: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +29 -> 509
    //   483: ldc 16
    //   485: iconst_2
    //   486: new 150	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 376
    //   496: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 378	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +46 -> 558
    //   515: ldc 16
    //   517: iconst_2
    //   518: new 150	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 380
    //   528: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload 5
    //   533: invokevirtual 383	java/util/ArrayList:size	()I
    //   536: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: ldc_w 385
    //   542: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload_0
    //   546: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   549: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   552: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: aload_2
    //   559: ifnull +7 -> 566
    //   562: aload_2
    //   563: invokevirtual 387	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   566: iconst_0
    //   567: ireturn
    //   568: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +652 -> 1223
    //   574: ldc 16
    //   576: iconst_2
    //   577: new 150	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 389
    //   587: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   594: iconst_1
    //   595: iadd
    //   596: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   599: ldc_w 391
    //   602: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: goto +612 -> 1223
    //   614: aload 4
    //   616: invokeinterface 392 1 0
    //   621: istore 8
    //   623: iload 8
    //   625: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: astore_1
    //   629: goto -264 -> 365
    //   632: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +46 -> 681
    //   638: ldc 16
    //   640: iconst_2
    //   641: new 150	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 380
    //   651: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 5
    //   656: invokevirtual 383	java/util/ArrayList:size	()I
    //   659: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   662: ldc_w 385
    //   665: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_0
    //   669: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   672: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   675: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: aload_2
    //   682: ifnull +7 -> 689
    //   685: aload_2
    //   686: invokevirtual 387	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   689: aload_0
    //   690: getfield 43	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   693: aload 5
    //   695: iconst_1
    //   696: invokevirtual 400	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   699: iconst_m1
    //   700: if_icmpne +139 -> 839
    //   703: ldc2_w 401
    //   706: invokestatic 408	java/lang/Thread:sleep	(J)V
    //   709: aload_0
    //   710: getfield 43	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   713: aload 5
    //   715: iconst_1
    //   716: invokevirtual 400	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   719: istore 8
    //   721: invokestatic 184	java/lang/System:nanoTime	()J
    //   724: lload 13
    //   726: lsub
    //   727: ldc2_w 203
    //   730: ldiv
    //   731: lstore 9
    //   733: aload_0
    //   734: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   737: lload 11
    //   739: lload 9
    //   741: invokestatic 207	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   744: pop2
    //   745: iload 8
    //   747: iconst_m1
    //   748: if_icmpne +53 -> 801
    //   751: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq +12 -> 766
    //   757: ldc 16
    //   759: iconst_2
    //   760: ldc_w 410
    //   763: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: aload_0
    //   767: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   770: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   773: invokestatic 131	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   776: aconst_null
    //   777: ldc_w 412
    //   780: iconst_0
    //   781: ldc2_w 52
    //   784: lconst_0
    //   785: aconst_null
    //   786: aconst_null
    //   787: iconst_0
    //   788: invokevirtual 139	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   791: iconst_0
    //   792: ireturn
    //   793: astore_1
    //   794: aload_1
    //   795: invokevirtual 413	java/lang/InterruptedException:printStackTrace	()V
    //   798: goto -89 -> 709
    //   801: aload_0
    //   802: aload_0
    //   803: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   806: iconst_1
    //   807: iadd
    //   808: putfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   811: aload_0
    //   812: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   815: iload 6
    //   817: iconst_1
    //   818: invokestatic 416	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   821: pop
    //   822: aload_0
    //   823: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   826: iload 7
    //   828: aload 5
    //   830: invokevirtual 383	java/util/ArrayList:size	()I
    //   833: invokestatic 418	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   836: pop
    //   837: iconst_1
    //   838: ireturn
    //   839: invokestatic 184	java/lang/System:nanoTime	()J
    //   842: lload 13
    //   844: lsub
    //   845: ldc2_w 203
    //   848: ldiv
    //   849: lstore 9
    //   851: aload_0
    //   852: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   855: lload 11
    //   857: lload 9
    //   859: invokestatic 207	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   862: pop2
    //   863: aload_0
    //   864: aload_0
    //   865: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   868: iconst_1
    //   869: iadd
    //   870: putfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   873: goto -62 -> 811
    //   876: astore_1
    //   877: aload_3
    //   878: astore_2
    //   879: aload_1
    //   880: astore_3
    //   881: aload_2
    //   882: astore_1
    //   883: aload_3
    //   884: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   887: aload_2
    //   888: astore_1
    //   889: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   892: ifeq +15 -> 907
    //   895: aload_2
    //   896: astore_1
    //   897: ldc 16
    //   899: iconst_2
    //   900: ldc_w 420
    //   903: aload_3
    //   904: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   907: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   910: ifeq +46 -> 956
    //   913: ldc 16
    //   915: iconst_2
    //   916: new 150	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   923: ldc_w 380
    //   926: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: aload 5
    //   931: invokevirtual 383	java/util/ArrayList:size	()I
    //   934: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   937: ldc_w 385
    //   940: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: aload_0
    //   944: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   947: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   950: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   956: aload_2
    //   957: ifnull +7 -> 964
    //   960: aload_2
    //   961: invokevirtual 387	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   964: iconst_0
    //   965: ireturn
    //   966: astore_3
    //   967: aload_1
    //   968: astore_2
    //   969: aload_3
    //   970: astore_1
    //   971: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   974: ifeq +46 -> 1020
    //   977: ldc 16
    //   979: iconst_2
    //   980: new 150	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   987: ldc_w 380
    //   990: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: aload 5
    //   995: invokevirtual 383	java/util/ArrayList:size	()I
    //   998: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1001: ldc_w 385
    //   1004: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload_0
    //   1008: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   1011: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1014: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1020: aload_2
    //   1021: ifnull +7 -> 1028
    //   1024: aload_2
    //   1025: invokevirtual 387	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	()V
    //   1028: aload_0
    //   1029: getfield 43	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   1032: aload 5
    //   1034: iconst_1
    //   1035: invokevirtual 400	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   1038: iconst_m1
    //   1039: if_icmpne +139 -> 1178
    //   1042: ldc2_w 401
    //   1045: invokestatic 408	java/lang/Thread:sleep	(J)V
    //   1048: aload_0
    //   1049: getfield 43	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   1052: aload 5
    //   1054: iconst_1
    //   1055: invokevirtual 400	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   1058: istore 8
    //   1060: invokestatic 184	java/lang/System:nanoTime	()J
    //   1063: lload 13
    //   1065: lsub
    //   1066: ldc2_w 203
    //   1069: ldiv
    //   1070: lstore 9
    //   1072: aload_0
    //   1073: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1076: lload 11
    //   1078: lload 9
    //   1080: invokestatic 207	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   1083: pop2
    //   1084: iload 8
    //   1086: iconst_m1
    //   1087: if_icmpne +53 -> 1140
    //   1090: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1093: ifeq +12 -> 1105
    //   1096: ldc 16
    //   1098: iconst_2
    //   1099: ldc_w 410
    //   1102: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1105: aload_0
    //   1106: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1109: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1112: invokestatic 131	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1115: aconst_null
    //   1116: ldc_w 412
    //   1119: iconst_0
    //   1120: ldc2_w 52
    //   1123: lconst_0
    //   1124: aconst_null
    //   1125: aconst_null
    //   1126: iconst_0
    //   1127: invokevirtual 139	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1130: iconst_0
    //   1131: ireturn
    //   1132: astore_2
    //   1133: aload_2
    //   1134: invokevirtual 413	java/lang/InterruptedException:printStackTrace	()V
    //   1137: goto -89 -> 1048
    //   1140: aload_0
    //   1141: aload_0
    //   1142: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   1145: iconst_1
    //   1146: iadd
    //   1147: putfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   1150: aload_0
    //   1151: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1154: iload 6
    //   1156: iconst_1
    //   1157: invokestatic 416	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   1160: pop
    //   1161: aload_0
    //   1162: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1165: iload 7
    //   1167: aload 5
    //   1169: invokevirtual 383	java/util/ArrayList:size	()I
    //   1172: invokestatic 418	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   1175: pop
    //   1176: aload_1
    //   1177: athrow
    //   1178: invokestatic 184	java/lang/System:nanoTime	()J
    //   1181: lload 13
    //   1183: lsub
    //   1184: ldc2_w 203
    //   1187: ldiv
    //   1188: lstore 9
    //   1190: aload_0
    //   1191: getfield 36	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1194: lload 11
    //   1196: lload 9
    //   1198: invokestatic 207	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   1201: pop2
    //   1202: aload_0
    //   1203: aload_0
    //   1204: getfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   1207: iconst_1
    //   1208: iadd
    //   1209: putfield 50	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   1212: goto -62 -> 1150
    //   1215: astore_1
    //   1216: goto -245 -> 971
    //   1219: astore_3
    //   1220: goto -339 -> 881
    //   1223: aconst_null
    //   1224: astore_1
    //   1225: ldc2_w 52
    //   1228: lstore 9
    //   1230: goto -1071 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1233	0	this	FTSMsgUpgrader
    //   16	396	1	localObject1	Object
    //   472	28	1	localThrowable	Throwable
    //   628	1	1	localInteger	Integer
    //   793	2	1	localInterruptedException1	InterruptedException
    //   876	4	1	localException1	Exception
    //   882	295	1	localObject2	Object
    //   1215	1	1	localObject3	Object
    //   1224	1	1	localObject4	Object
    //   76	949	2	localObject5	Object
    //   1132	2	2	localInterruptedException2	InterruptedException
    //   18	886	3	localObject6	Object
    //   966	4	3	localObject7	Object
    //   1219	1	3	localException2	Exception
    //   213	402	4	localList	java.util.List
    //   29	1139	5	localArrayList	java.util.ArrayList
    //   38	1117	6	i	int
    //   47	1119	7	j	int
    //   621	467	8	k	int
    //   157	1072	9	l1	long
    //   56	1139	11	l2	long
    //   61	1121	13	l3	long
    // Exception table:
    //   from	to	target	type
    //   462	469	472	java/lang/Throwable
    //   703	709	793	java/lang/InterruptedException
    //   63	77	876	java/lang/Exception
    //   63	77	966	finally
    //   883	887	966	finally
    //   889	895	966	finally
    //   897	907	966	finally
    //   1042	1048	1132	java/lang/InterruptedException
    //   77	107	1215	finally
    //   111	159	1215	finally
    //   163	169	1215	finally
    //   169	212	1215	finally
    //   232	308	1215	finally
    //   308	333	1215	finally
    //   336	356	1215	finally
    //   365	379	1215	finally
    //   386	402	1215	finally
    //   402	450	1215	finally
    //   454	462	1215	finally
    //   462	469	1215	finally
    //   473	509	1215	finally
    //   568	611	1215	finally
    //   614	623	1215	finally
    //   77	107	1219	java/lang/Exception
    //   111	159	1219	java/lang/Exception
    //   163	169	1219	java/lang/Exception
    //   169	212	1219	java/lang/Exception
    //   232	308	1219	java/lang/Exception
    //   308	333	1219	java/lang/Exception
    //   336	356	1219	java/lang/Exception
    //   365	379	1219	java/lang/Exception
    //   386	402	1219	java/lang/Exception
    //   402	450	1219	java/lang/Exception
    //   454	462	1219	java/lang/Exception
    //   462	469	1219	java/lang/Exception
    //   473	509	1219	java/lang/Exception
    //   568	611	1219	java/lang/Exception
    //   614	623	1219	java/lang/Exception
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return !SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    if (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade log has complete");
      }
      return c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade log start");
    }
    long l3 = SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l4 = System.nanoTime();
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        Object localObject3 = localSQLiteDatabase.a();
        boolean bool1;
        long l1;
        if ((localObject3 == null) || (localObject3.length == 0))
        {
          SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          bool1 = c();
          return bool1;
        }
        HashMap localHashMap = new HashMap();
        int j = localObject3.length;
        int i = 0;
        String str;
        Cursor localCursor;
        if (i < j)
        {
          str = localObject3[i];
          if ((str.endsWith("_New")) && ((str.startsWith("mr_friend_")) || (str.startsWith("mr_troop_")) || (str.startsWith("mr_discusssion_")) || (str.startsWith("mr_contact_")) || (str.startsWith("mr_devicemsg_"))))
          {
            localCursor = localSQLiteDatabase.a("SELECT max(_id) AS MAX_ID FROM " + str + ";", null);
            if ((localCursor != null) && (localCursor.getCount() == 1))
            {
              localCursor.moveToNext();
              localHashMap.put(str, Long.valueOf(localCursor.getLong(localCursor.getColumnIndex("MAX_ID"))));
            }
            if (localCursor != null) {
              localCursor.close();
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = localHashMap.keySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: msgUpgradeInfo[key=" + str + ", value=" + localHashMap.get(str) + "]");
            continue;
          }
        }
        long l2;
        boolean bool2;
        i += 1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: ", localException1);
        }
        return false;
        try
        {
          localException1.a("CREATE TABLE IF NOT EXISTS msg_upgrade_log(id INTEGER PRIMARY KEY AUTOINCREMENT, tablename TEXT, MAX_ID INTEGER);");
          localObject3 = localHashMap.keySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localCursor = localException1.a("msg_upgrade_log", new String[] { "id" }, "tablename=?", new String[] { str }, null, null);
            l2 = -1L;
            l1 = l2;
            if (localCursor != null)
            {
              l1 = l2;
              if (localCursor.getCount() == 1)
              {
                localCursor.moveToNext();
                l1 = localCursor.getLong(localCursor.getColumnIndex("id"));
              }
            }
            if (localCursor != null) {
              localCursor.close();
            }
            if (a(l1, str, ((Long)localHashMap.get(str)).longValue(), localException1) != -1L) {
              continue;
            }
            Thread.sleep(5L);
            if (a(l1, str, ((Long)localHashMap.get(str)).longValue(), localException1) != -1L) {
              continue;
            }
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actFTSUpgradeLogFailure", false, -1L, 0L, null, null, false);
            return false;
          }
          SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          bool1 = c();
        }
        catch (Exception localException2)
        {
          localException2 = localException2;
          bool2 = false;
          localException2.printStackTrace();
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: ", localException2);
          bool1 = bool2;
          continue;
        }
        finally {}
        return bool1;
      }
      finally
      {
        l1 = (System.nanoTime() - l4) / 1000L;
        SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l3, l1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\fts\FTSMsgUpgrader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */