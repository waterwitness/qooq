package com.tencent.mobileqq.activity.qwallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagDBManager
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private PasswdRedBagDBHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper;
  private PasswdRedBagManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager;
  private String jdField_a_of_type_JavaLangString;
  
  public PasswdRedBagDBManager(PasswdRedBagManager paramPasswdRedBagManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper = new PasswdRedBagDBHelper(paramPasswdRedBagManager.jdField_a_of_type_AndroidContentContext, paramPasswdRedBagManager.e);
    this.jdField_a_of_type_AndroidContentContext = paramPasswdRedBagManager.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_JavaLangString = paramPasswdRedBagManager.e;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = paramPasswdRedBagManager;
  }
  
  /* Error */
  public java.util.HashMap a()
  {
    // Byte code:
    //   0: new 46	java/util/HashMap
    //   3: dup
    //   4: invokespecial 47	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 35	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   14: invokevirtual 51	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 55
    //   26: iconst_4
    //   27: anewarray 57	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 59
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 61
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc 63
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc 65
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +197 -> 257
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: ldc 59
    //   68: invokeinterface 77 2 0
    //   73: istore 5
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: ldc 61
    //   80: invokeinterface 77 2 0
    //   85: istore 6
    //   87: aload_2
    //   88: astore_1
    //   89: aload_2
    //   90: ldc 63
    //   92: invokeinterface 77 2 0
    //   97: istore 7
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: ldc 65
    //   104: invokeinterface 77 2 0
    //   109: istore 8
    //   111: aload_2
    //   112: astore_1
    //   113: aload_2
    //   114: invokeinterface 81 1 0
    //   119: ifeq +138 -> 257
    //   122: aload_2
    //   123: astore_1
    //   124: new 83	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   131: astore_3
    //   132: aload_2
    //   133: astore_1
    //   134: aload_3
    //   135: aload_2
    //   136: iload 7
    //   138: invokeinterface 88 2 0
    //   143: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_2
    //   148: astore_1
    //   149: aload_3
    //   150: ldc 94
    //   152: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: astore_1
    //   158: aload_3
    //   159: aload_2
    //   160: iload 6
    //   162: invokeinterface 88 2 0
    //   167: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_2
    //   172: astore_1
    //   173: aload_3
    //   174: ldc 94
    //   176: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_2
    //   181: astore_1
    //   182: aload_3
    //   183: aload_2
    //   184: iload 5
    //   186: invokeinterface 88 2 0
    //   191: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: astore_1
    //   197: aload 4
    //   199: aload_3
    //   200: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: aload_2
    //   204: iload 8
    //   206: invokeinterface 88 2 0
    //   211: invokevirtual 102	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: goto -104 -> 111
    //   218: astore_3
    //   219: aload_2
    //   220: astore_1
    //   221: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +14 -> 238
    //   227: aload_2
    //   228: astore_1
    //   229: getstatic 108	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   232: iconst_2
    //   233: ldc 110
    //   235: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_2
    //   239: astore_1
    //   240: aload_3
    //   241: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   244: aload_2
    //   245: ifnull +9 -> 254
    //   248: aload_2
    //   249: invokeinterface 120 1 0
    //   254: aload 4
    //   256: areturn
    //   257: aload_2
    //   258: ifnull -4 -> 254
    //   261: aload_2
    //   262: invokeinterface 120 1 0
    //   267: aload 4
    //   269: areturn
    //   270: astore_2
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +9 -> 283
    //   277: aload_1
    //   278: invokeinterface 120 1 0
    //   283: aload_2
    //   284: athrow
    //   285: astore_2
    //   286: goto -13 -> 273
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_2
    //   292: goto -73 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	PasswdRedBagDBManager
    //   64	214	1	localCursor1	android.database.Cursor
    //   58	204	2	localCursor2	android.database.Cursor
    //   270	14	2	localObject1	Object
    //   285	1	2	localObject2	Object
    //   291	1	2	localObject3	Object
    //   131	69	3	localStringBuilder	StringBuilder
    //   218	23	3	localException1	Exception
    //   289	1	3	localException2	Exception
    //   7	261	4	localHashMap	java.util.HashMap
    //   73	112	5	i	int
    //   85	76	6	j	int
    //   97	40	7	k	int
    //   109	96	8	m	int
    // Exception table:
    //   from	to	target	type
    //   65	75	218	java/lang/Exception
    //   77	87	218	java/lang/Exception
    //   89	99	218	java/lang/Exception
    //   101	111	218	java/lang/Exception
    //   113	122	218	java/lang/Exception
    //   124	132	218	java/lang/Exception
    //   134	147	218	java/lang/Exception
    //   149	156	218	java/lang/Exception
    //   158	171	218	java/lang/Exception
    //   173	180	218	java/lang/Exception
    //   182	195	218	java/lang/Exception
    //   197	215	218	java/lang/Exception
    //   9	59	270	finally
    //   65	75	285	finally
    //   77	87	285	finally
    //   89	99	285	finally
    //   101	111	285	finally
    //   113	122	285	finally
    //   124	132	285	finally
    //   134	147	285	finally
    //   149	156	285	finally
    //   158	171	285	finally
    //   173	180	285	finally
    //   182	195	285	finally
    //   197	215	285	finally
    //   221	227	285	finally
    //   229	238	285	finally
    //   240	244	285	finally
    //   9	59	289	java/lang/Exception
  }
  
  /* Error */
  public List a()
  {
    // Byte code:
    //   0: new 123	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 124	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 35	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   14: invokevirtual 51	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 126
    //   26: bipush 7
    //   28: anewarray 57	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 59
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc -128
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc -126
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc -124
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc -122
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc -120
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc -118
    //   66: aastore
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: ldc -116
    //   73: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +310 -> 388
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ldc 59
    //   86: invokeinterface 77 2 0
    //   91: istore 5
    //   93: aload_2
    //   94: astore_1
    //   95: aload_2
    //   96: ldc -128
    //   98: invokeinterface 77 2 0
    //   103: istore 6
    //   105: aload_2
    //   106: astore_1
    //   107: aload_2
    //   108: ldc -126
    //   110: invokeinterface 77 2 0
    //   115: istore 7
    //   117: aload_2
    //   118: astore_1
    //   119: aload_2
    //   120: ldc -124
    //   122: invokeinterface 77 2 0
    //   127: istore 8
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: ldc -122
    //   134: invokeinterface 77 2 0
    //   139: istore 9
    //   141: aload_2
    //   142: astore_1
    //   143: aload_2
    //   144: ldc -120
    //   146: invokeinterface 77 2 0
    //   151: istore 10
    //   153: aload_2
    //   154: astore_1
    //   155: aload_2
    //   156: ldc -118
    //   158: invokeinterface 77 2 0
    //   163: istore 11
    //   165: aload_2
    //   166: astore_1
    //   167: aload_2
    //   168: invokeinterface 81 1 0
    //   173: ifeq +215 -> 388
    //   176: aload_2
    //   177: astore_1
    //   178: new 142	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo
    //   181: dup
    //   182: invokespecial 143	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:<init>	()V
    //   185: astore_3
    //   186: aload_2
    //   187: astore_1
    //   188: aload_2
    //   189: iload 10
    //   191: invokeinterface 147 2 0
    //   196: iconst_1
    //   197: if_icmpne +173 -> 370
    //   200: iconst_1
    //   201: istore 12
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: iload 12
    //   208: putfield 150	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_b_of_type_Boolean	Z
    //   211: aload_2
    //   212: astore_1
    //   213: aload_2
    //   214: iload 9
    //   216: invokeinterface 147 2 0
    //   221: iconst_1
    //   222: if_icmpne +154 -> 376
    //   225: iconst_1
    //   226: istore 12
    //   228: aload_2
    //   229: astore_1
    //   230: aload_3
    //   231: iload 12
    //   233: putfield 152	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_a_of_type_Boolean	Z
    //   236: aload_2
    //   237: astore_1
    //   238: aload_3
    //   239: aload_2
    //   240: iload 8
    //   242: invokeinterface 88 2 0
    //   247: putfield 155	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   250: aload_2
    //   251: astore_1
    //   252: aload_3
    //   253: aload_2
    //   254: iload 5
    //   256: invokeinterface 88 2 0
    //   261: putfield 156	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   264: aload_2
    //   265: astore_1
    //   266: aload_3
    //   267: aload_2
    //   268: iload 6
    //   270: invokeinterface 88 2 0
    //   275: putfield 158	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   278: aload_2
    //   279: astore_1
    //   280: aload_3
    //   281: aload_2
    //   282: iload 7
    //   284: invokeinterface 162 2 0
    //   289: putfield 165	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_a_of_type_Long	J
    //   292: aload_2
    //   293: astore_1
    //   294: aload_2
    //   295: iload 11
    //   297: invokeinterface 147 2 0
    //   302: iconst_1
    //   303: if_icmpne +79 -> 382
    //   306: iconst_1
    //   307: istore 12
    //   309: aload_2
    //   310: astore_1
    //   311: aload_3
    //   312: iload 12
    //   314: putfield 167	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_c_of_type_Boolean	Z
    //   317: aload_2
    //   318: astore_1
    //   319: aload 4
    //   321: aload_3
    //   322: invokeinterface 173 2 0
    //   327: pop
    //   328: goto -163 -> 165
    //   331: astore_3
    //   332: aload_2
    //   333: astore_1
    //   334: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +14 -> 351
    //   340: aload_2
    //   341: astore_1
    //   342: getstatic 108	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   345: iconst_2
    //   346: ldc -81
    //   348: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload_2
    //   352: astore_1
    //   353: aload_3
    //   354: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   357: aload_2
    //   358: ifnull +9 -> 367
    //   361: aload_2
    //   362: invokeinterface 120 1 0
    //   367: aload 4
    //   369: areturn
    //   370: iconst_0
    //   371: istore 12
    //   373: goto -170 -> 203
    //   376: iconst_0
    //   377: istore 12
    //   379: goto -151 -> 228
    //   382: iconst_0
    //   383: istore 12
    //   385: goto -76 -> 309
    //   388: aload_2
    //   389: ifnull -22 -> 367
    //   392: aload_2
    //   393: invokeinterface 120 1 0
    //   398: aload 4
    //   400: areturn
    //   401: astore_2
    //   402: aconst_null
    //   403: astore_1
    //   404: aload_1
    //   405: ifnull +9 -> 414
    //   408: aload_1
    //   409: invokeinterface 120 1 0
    //   414: aload_2
    //   415: athrow
    //   416: astore_2
    //   417: goto -13 -> 404
    //   420: astore_3
    //   421: aconst_null
    //   422: astore_2
    //   423: goto -91 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	PasswdRedBagDBManager
    //   82	327	1	localCursor1	android.database.Cursor
    //   76	317	2	localCursor2	android.database.Cursor
    //   401	14	2	localObject1	Object
    //   416	1	2	localObject2	Object
    //   422	1	2	localObject3	Object
    //   185	137	3	localPasswdRedBagInfo	PasswdRedBagInfo
    //   331	23	3	localException1	Exception
    //   420	1	3	localException2	Exception
    //   7	392	4	localArrayList	java.util.ArrayList
    //   91	164	5	i	int
    //   103	166	6	j	int
    //   115	168	7	k	int
    //   127	114	8	m	int
    //   139	76	9	n	int
    //   151	39	10	i1	int
    //   163	133	11	i2	int
    //   201	183	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   83	93	331	java/lang/Exception
    //   95	105	331	java/lang/Exception
    //   107	117	331	java/lang/Exception
    //   119	129	331	java/lang/Exception
    //   131	141	331	java/lang/Exception
    //   143	153	331	java/lang/Exception
    //   155	165	331	java/lang/Exception
    //   167	176	331	java/lang/Exception
    //   178	186	331	java/lang/Exception
    //   188	200	331	java/lang/Exception
    //   205	211	331	java/lang/Exception
    //   213	225	331	java/lang/Exception
    //   230	236	331	java/lang/Exception
    //   238	250	331	java/lang/Exception
    //   252	264	331	java/lang/Exception
    //   266	278	331	java/lang/Exception
    //   280	292	331	java/lang/Exception
    //   294	306	331	java/lang/Exception
    //   311	317	331	java/lang/Exception
    //   319	328	331	java/lang/Exception
    //   9	77	401	finally
    //   83	93	416	finally
    //   95	105	416	finally
    //   107	117	416	finally
    //   119	129	416	finally
    //   131	141	416	finally
    //   143	153	416	finally
    //   155	165	416	finally
    //   167	176	416	finally
    //   178	186	416	finally
    //   188	200	416	finally
    //   205	211	416	finally
    //   213	225	416	finally
    //   230	236	416	finally
    //   238	250	416	finally
    //   252	264	416	finally
    //   266	278	416	finally
    //   280	292	416	finally
    //   294	306	416	finally
    //   311	317	416	finally
    //   319	328	416	finally
    //   334	340	416	finally
    //   342	351	416	finally
    //   353	357	416	finally
    //   9	77	420	java/lang/Exception
  }
  
  /* Error */
  public List a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 123	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 124	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 35	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   16: invokevirtual 51	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: putfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   22: aload_0
    //   23: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore_2
    //   27: new 83	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   34: iload_1
    //   35: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc -75
    //   40: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 4
    //   48: aload_2
    //   49: ldc -73
    //   51: iconst_2
    //   52: anewarray 57	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc 61
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: ldc -71
    //   64: aastore
    //   65: ldc -69
    //   67: iconst_1
    //   68: anewarray 57	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload 4
    //   75: aastore
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_2
    //   83: aload_2
    //   84: astore_3
    //   85: aload_3
    //   86: ifnull +143 -> 229
    //   89: aload_3
    //   90: astore_2
    //   91: aload_3
    //   92: ldc 61
    //   94: invokeinterface 77 2 0
    //   99: istore 6
    //   101: aload_3
    //   102: astore_2
    //   103: aload_3
    //   104: ldc -71
    //   106: invokeinterface 77 2 0
    //   111: istore 7
    //   113: aload_3
    //   114: astore_2
    //   115: aload_3
    //   116: invokeinterface 81 1 0
    //   121: ifeq +108 -> 229
    //   124: aload_3
    //   125: astore_2
    //   126: new 189	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo
    //   129: dup
    //   130: invokespecial 190	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:<init>	()V
    //   133: astore 4
    //   135: aload_3
    //   136: astore_2
    //   137: aload 4
    //   139: iload_1
    //   140: putfield 193	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Int	I
    //   143: aload_3
    //   144: astore_2
    //   145: aload 4
    //   147: aload_3
    //   148: iload 6
    //   150: invokeinterface 162 2 0
    //   155: putfield 194	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Long	J
    //   158: aload_3
    //   159: astore_2
    //   160: aload 4
    //   162: aload_3
    //   163: iload 7
    //   165: invokeinterface 162 2 0
    //   170: putfield 196	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:b	J
    //   173: aload_3
    //   174: astore_2
    //   175: aload 5
    //   177: aload 4
    //   179: invokeinterface 173 2 0
    //   184: pop
    //   185: goto -72 -> 113
    //   188: astore 4
    //   190: aload_3
    //   191: astore_2
    //   192: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +14 -> 209
    //   198: aload_3
    //   199: astore_2
    //   200: getstatic 108	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   203: iconst_2
    //   204: ldc -58
    //   206: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_3
    //   210: astore_2
    //   211: aload 4
    //   213: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   216: aload_3
    //   217: ifnull +9 -> 226
    //   220: aload_3
    //   221: invokeinterface 120 1 0
    //   226: aload 5
    //   228: areturn
    //   229: aload_3
    //   230: ifnull -4 -> 226
    //   233: aload_3
    //   234: invokeinterface 120 1 0
    //   239: aload 5
    //   241: areturn
    //   242: astore_2
    //   243: aload_3
    //   244: ifnull +9 -> 253
    //   247: aload_3
    //   248: invokeinterface 120 1 0
    //   253: aload_2
    //   254: athrow
    //   255: astore 4
    //   257: aload_2
    //   258: astore_3
    //   259: aload 4
    //   261: astore_2
    //   262: goto -19 -> 243
    //   265: astore 4
    //   267: aconst_null
    //   268: astore_3
    //   269: goto -79 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	PasswdRedBagDBManager
    //   0	272	1	paramInt	int
    //   26	185	2	localObject1	Object
    //   242	16	2	localObject2	Object
    //   261	1	2	localObject3	Object
    //   1	268	3	localObject4	Object
    //   46	132	4	localObject5	Object
    //   188	24	4	localException1	Exception
    //   255	5	4	localObject6	Object
    //   265	1	4	localException2	Exception
    //   9	231	5	localArrayList	java.util.ArrayList
    //   99	50	6	i	int
    //   111	53	7	j	int
    // Exception table:
    //   from	to	target	type
    //   91	101	188	java/lang/Exception
    //   103	113	188	java/lang/Exception
    //   115	124	188	java/lang/Exception
    //   126	135	188	java/lang/Exception
    //   137	143	188	java/lang/Exception
    //   145	158	188	java/lang/Exception
    //   160	173	188	java/lang/Exception
    //   175	185	188	java/lang/Exception
    //   11	83	242	finally
    //   91	101	255	finally
    //   103	113	255	finally
    //   115	124	255	finally
    //   126	135	255	finally
    //   137	143	255	finally
    //   145	158	255	finally
    //   160	173	255	finally
    //   175	185	255	finally
    //   192	198	255	finally
    //   200	209	255	finally
    //   211	216	255	finally
    //   11	83	265	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
    }
  }
  
  public void a(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    int j = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
      localContentValues.put("uint64_creator_uin", paramPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
      localContentValues.put("expire_time", Long.valueOf(paramPasswdRedBagInfo.jdField_a_of_type_Long));
      localContentValues.put("password", paramPasswdRedBagInfo.jdField_c_of_type_JavaLangString);
      if (paramPasswdRedBagInfo.jdField_a_of_type_Boolean)
      {
        i = 1;
        localContentValues.put("is_open", Integer.valueOf(i));
        if (!paramPasswdRedBagInfo.jdField_b_of_type_Boolean) {
          break label141;
        }
        i = 1;
        label93:
        localContentValues.put("is_finish", Integer.valueOf(i));
        if (!paramPasswdRedBagInfo.jdField_c_of_type_Boolean) {
          break label146;
        }
      }
      label141:
      label146:
      for (int i = j;; i = 0)
      {
        localContentValues.put("is_overdue", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bags", null, localContentValues);
        return;
        i = 0;
        break;
        i = 0;
        break label93;
      }
      return;
    }
    catch (Exception paramPasswdRedBagInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "insertPasswdRedBag failed ");
      }
      paramPasswdRedBagInfo.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramString3);
      localContentValues.put("source", paramString1);
      localContentValues.put("code", paramString2);
      localContentValues.put("authkey", paramString4);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bag_relations", null, localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "insertPasswdRedBagRelation failed ");
      }
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_open", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "setOpen failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(List paramList)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localPasswdRedBagInfo = (PasswdRedBagInfo)paramList.next();
        localContentValues = new ContentValues();
        localContentValues.put("redbag_id", localPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
        localContentValues.put("uint64_creator_uin", localPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
        localContentValues.put("expire_time", Long.valueOf(localPasswdRedBagInfo.jdField_a_of_type_Long));
        localContentValues.put("password", localPasswdRedBagInfo.jdField_c_of_type_JavaLangString);
        if (!localPasswdRedBagInfo.jdField_a_of_type_Boolean) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramList)
      {
        PasswdRedBagInfo localPasswdRedBagInfo;
        ContentValues localContentValues;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "insertPasswdRedBags failed ");
        paramList.printStackTrace();
        if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.inTransaction())) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
          return;
        }
        catch (Exception paramList)
        {
          paramList.printStackTrace();
          return;
        }
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
        if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.inTransaction())) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
          return;
        }
        catch (Exception paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
      finally
      {
        if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.inTransaction())) {
          break label306;
        }
      }
      localContentValues.put("is_open", Integer.valueOf(i));
      if (!localPasswdRedBagInfo.jdField_b_of_type_Boolean) {
        continue;
      }
      i = 1;
      localContentValues.put("is_finish", Integer.valueOf(i));
      if (!localPasswdRedBagInfo.jdField_c_of_type_Boolean) {
        continue;
      }
      i = 1;
      localContentValues.put("is_overdue", Integer.valueOf(i));
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bags", null, localContentValues);
    }
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
      label306:
      throw paramList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("red_bags", "expire_time < ?", new String[] { String.valueOf(l - 604800L) });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "clearExpirePasswdRedBag failed ");
      }
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_finish", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "setFinish failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public void b(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 35	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   7: invokevirtual 51	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: putfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_0
    //   14: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: invokevirtual 245	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   20: new 202	android/content/ContentValues
    //   23: dup
    //   24: invokespecial 203	android/content/ContentValues:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: invokeinterface 249 1 0
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 254 1 0
    //   41: ifeq +107 -> 148
    //   44: aload_1
    //   45: invokeinterface 258 1 0
    //   50: checkcast 189	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 295	android/content/ContentValues:clear	()V
    //   58: aload_2
    //   59: ldc 61
    //   61: aload_3
    //   62: getfield 194	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Long	J
    //   65: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: invokevirtual 215	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   71: aload_2
    //   72: ldc 63
    //   74: aload_3
    //   75: getfield 193	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Int	I
    //   78: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: invokevirtual 223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   84: aload_2
    //   85: ldc -71
    //   87: aload_3
    //   88: getfield 196	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:b	J
    //   91: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokevirtual 215	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   97: aload_0
    //   98: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   101: ldc -73
    //   103: aconst_null
    //   104: aload_2
    //   105: invokevirtual 227	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   108: pop2
    //   109: goto -74 -> 35
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   117: aload_0
    //   118: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   121: ifnull +24 -> 145
    //   124: aload_0
    //   125: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   128: invokevirtual 263	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   131: istore 4
    //   133: iload 4
    //   135: ifeq +10 -> 145
    //   138: aload_0
    //   139: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   142: invokevirtual 266	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   145: aload_0
    //   146: monitorexit
    //   147: return
    //   148: aload_0
    //   149: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   152: invokevirtual 269	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   155: aload_0
    //   156: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   159: ifnull -14 -> 145
    //   162: aload_0
    //   163: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   166: invokevirtual 263	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   169: istore 4
    //   171: iload 4
    //   173: ifeq -28 -> 145
    //   176: aload_0
    //   177: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   180: invokevirtual 266	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   183: goto -38 -> 145
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   191: goto -46 -> 145
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   204: goto -59 -> 145
    //   207: astore_1
    //   208: aload_0
    //   209: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   212: ifnull +24 -> 236
    //   215: aload_0
    //   216: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   219: invokevirtual 263	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   222: istore 4
    //   224: iload 4
    //   226: ifeq +10 -> 236
    //   229: aload_0
    //   230: getfield 53	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   233: invokevirtual 266	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_2
    //   239: aload_2
    //   240: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   243: goto -7 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	PasswdRedBagDBManager
    //   0	246	1	paramList	List
    //   27	78	2	localContentValues	ContentValues
    //   238	2	2	localException	Exception
    //   53	35	3	localPasswdRedBagUpdateInfo	PasswdRedBagUpdateInfo
    //   131	94	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	35	112	java/lang/Exception
    //   35	109	112	java/lang/Exception
    //   148	155	112	java/lang/Exception
    //   176	183	186	java/lang/Exception
    //   117	133	194	finally
    //   138	145	194	finally
    //   155	171	194	finally
    //   176	183	194	finally
    //   187	191	194	finally
    //   200	204	194	finally
    //   208	224	194	finally
    //   229	236	194	finally
    //   236	238	194	finally
    //   239	243	194	finally
    //   138	145	199	java/lang/Exception
    //   2	35	207	finally
    //   35	109	207	finally
    //   113	117	207	finally
    //   148	155	207	finally
    //   229	236	238	java/lang/Exception
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 36	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8: ldc_w 297
    //   11: invokevirtual 303	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 308	java/io/File:exists	()Z
    //   19: istore 22
    //   21: iload 22
    //   23: ifne +28 -> 51
    //   26: iconst_0
    //   27: ifeq +11 -> 38
    //   30: new 310	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 311	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 310	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 311	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: return
    //   51: aload_3
    //   52: invokevirtual 314	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: aconst_null
    //   56: iconst_0
    //   57: invokestatic 318	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   60: astore_3
    //   61: aload_3
    //   62: astore_1
    //   63: aload_1
    //   64: ifnonnull +24 -> 88
    //   67: iconst_0
    //   68: ifeq +11 -> 79
    //   71: new 310	java/lang/NullPointerException
    //   74: dup
    //   75: invokespecial 311	java/lang/NullPointerException:<init>	()V
    //   78: athrow
    //   79: aload_1
    //   80: ifnull -30 -> 50
    //   83: aload_1
    //   84: invokevirtual 199	android/database/sqlite/SQLiteDatabase:close	()V
    //   87: return
    //   88: aload_1
    //   89: ldc_w 320
    //   92: iconst_1
    //   93: anewarray 57	java/lang/String
    //   96: dup
    //   97: iconst_0
    //   98: aload_0
    //   99: getfield 38	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: aastore
    //   103: invokevirtual 324	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +299 -> 407
    //   111: aload_3
    //   112: ldc 59
    //   114: invokeinterface 77 2 0
    //   119: istore 12
    //   121: aload_3
    //   122: ldc -128
    //   124: invokeinterface 77 2 0
    //   129: istore 16
    //   131: aload_3
    //   132: ldc -126
    //   134: invokeinterface 77 2 0
    //   139: istore 7
    //   141: aload_3
    //   142: ldc -124
    //   144: invokeinterface 77 2 0
    //   149: istore 14
    //   151: aload_3
    //   152: ldc 65
    //   154: invokeinterface 77 2 0
    //   159: istore 17
    //   161: aload_3
    //   162: ldc 61
    //   164: invokeinterface 77 2 0
    //   169: istore 15
    //   171: aload_3
    //   172: ldc 63
    //   174: invokeinterface 77 2 0
    //   179: istore 13
    //   181: aload_3
    //   182: ldc -122
    //   184: invokeinterface 77 2 0
    //   189: istore 10
    //   191: aload_3
    //   192: ldc -120
    //   194: invokeinterface 77 2 0
    //   199: istore 9
    //   201: aload_3
    //   202: invokeinterface 81 1 0
    //   207: ifeq +200 -> 407
    //   210: aload_0
    //   211: getfield 40	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagManager;
    //   214: astore 6
    //   216: aload_3
    //   217: iload 12
    //   219: invokeinterface 88 2 0
    //   224: astore_2
    //   225: aload_3
    //   226: iload 14
    //   228: invokeinterface 88 2 0
    //   233: astore 5
    //   235: aload_3
    //   236: iload 16
    //   238: invokeinterface 162 2 0
    //   243: lstore 18
    //   245: aload_3
    //   246: iload 7
    //   248: invokeinterface 162 2 0
    //   253: lstore 20
    //   255: aload_3
    //   256: iload 13
    //   258: invokeinterface 147 2 0
    //   263: istore 11
    //   265: aload_3
    //   266: iload 15
    //   268: invokeinterface 147 2 0
    //   273: istore 8
    //   275: aload_3
    //   276: iload 17
    //   278: invokeinterface 88 2 0
    //   283: astore 4
    //   285: aload_3
    //   286: iload 10
    //   288: invokeinterface 147 2 0
    //   293: iconst_1
    //   294: if_icmpne +101 -> 395
    //   297: iconst_1
    //   298: istore 22
    //   300: aload_3
    //   301: iload 9
    //   303: invokeinterface 147 2 0
    //   308: iconst_1
    //   309: if_icmpne +92 -> 401
    //   312: iconst_1
    //   313: istore 23
    //   315: aload 6
    //   317: aload_2
    //   318: aload 5
    //   320: lload 18
    //   322: invokestatic 284	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   325: lload 20
    //   327: iload 11
    //   329: invokestatic 326	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   332: iload 8
    //   334: invokestatic 326	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   337: aload 4
    //   339: iload 22
    //   341: iload 23
    //   343: invokevirtual 329	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    //   346: goto -145 -> 201
    //   349: astore 4
    //   351: aload_3
    //   352: astore_2
    //   353: aload 4
    //   355: astore_3
    //   356: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +13 -> 372
    //   362: getstatic 108	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   365: iconst_2
    //   366: ldc_w 331
    //   369: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload_3
    //   373: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   376: aload_2
    //   377: ifnull +9 -> 386
    //   380: aload_2
    //   381: invokeinterface 120 1 0
    //   386: aload_1
    //   387: ifnull -337 -> 50
    //   390: aload_1
    //   391: invokevirtual 199	android/database/sqlite/SQLiteDatabase:close	()V
    //   394: return
    //   395: iconst_0
    //   396: istore 22
    //   398: goto -98 -> 300
    //   401: iconst_0
    //   402: istore 23
    //   404: goto -89 -> 315
    //   407: aload_3
    //   408: ifnull +9 -> 417
    //   411: aload_3
    //   412: invokeinterface 120 1 0
    //   417: aload_1
    //   418: ifnull -368 -> 50
    //   421: aload_1
    //   422: invokevirtual 199	android/database/sqlite/SQLiteDatabase:close	()V
    //   425: return
    //   426: astore_2
    //   427: aconst_null
    //   428: astore_3
    //   429: aconst_null
    //   430: astore_1
    //   431: aload_3
    //   432: ifnull +9 -> 441
    //   435: aload_3
    //   436: invokeinterface 120 1 0
    //   441: aload_1
    //   442: ifnull +7 -> 449
    //   445: aload_1
    //   446: invokevirtual 199	android/database/sqlite/SQLiteDatabase:close	()V
    //   449: aload_2
    //   450: athrow
    //   451: astore_2
    //   452: aconst_null
    //   453: astore_3
    //   454: goto -23 -> 431
    //   457: astore_2
    //   458: goto -27 -> 431
    //   461: astore 4
    //   463: aload_2
    //   464: astore_3
    //   465: aload 4
    //   467: astore_2
    //   468: goto -37 -> 431
    //   471: astore_3
    //   472: goto -116 -> 356
    //   475: astore_3
    //   476: goto -120 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	PasswdRedBagDBManager
    //   1	445	1	localObject1	Object
    //   3	378	2	localObject2	Object
    //   426	24	2	localObject3	Object
    //   451	1	2	localObject4	Object
    //   457	7	2	localObject5	Object
    //   467	1	2	localObject6	Object
    //   14	451	3	localObject7	Object
    //   471	1	3	localException1	Exception
    //   475	1	3	localException2	Exception
    //   283	55	4	str1	String
    //   349	5	4	localException3	Exception
    //   461	5	4	localObject8	Object
    //   233	86	5	str2	String
    //   214	102	6	localPasswdRedBagManager	PasswdRedBagManager
    //   139	108	7	i	int
    //   273	60	8	j	int
    //   199	103	9	k	int
    //   189	98	10	m	int
    //   263	65	11	n	int
    //   119	99	12	i1	int
    //   179	78	13	i2	int
    //   149	78	14	i3	int
    //   169	98	15	i4	int
    //   129	108	16	i5	int
    //   159	118	17	i6	int
    //   243	78	18	l1	long
    //   253	73	20	l2	long
    //   19	378	22	bool1	boolean
    //   313	90	23	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   111	201	349	java/lang/Exception
    //   201	297	349	java/lang/Exception
    //   300	312	349	java/lang/Exception
    //   315	346	349	java/lang/Exception
    //   4	21	426	finally
    //   51	61	426	finally
    //   88	107	451	finally
    //   111	201	457	finally
    //   201	297	457	finally
    //   300	312	457	finally
    //   315	346	457	finally
    //   356	372	461	finally
    //   372	376	461	finally
    //   4	21	471	java/lang/Exception
    //   51	61	471	java/lang/Exception
    //   88	107	475	java/lang/Exception
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_overdue", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PasswdRedBagManager.jdField_a_of_type_JavaLangString, 2, "setOverDue failed ");
      }
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\PasswdRedBagDBManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */