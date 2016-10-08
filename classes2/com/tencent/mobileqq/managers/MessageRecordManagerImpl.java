package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageRecordManagerImpl
  implements MessageRecordManager
{
  public MessageRecordManagerImpl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_1
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: new 23	com/tencent/mobileqq/data/QQEntityManagerFactory
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 25	com/tencent/mobileqq/data/QQEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   18: astore 5
    //   20: aload 5
    //   22: aload_1
    //   23: invokevirtual 31	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   26: invokevirtual 36	com/tencent/mobileqq/app/SQLiteOpenHelper:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   29: astore 6
    //   31: aload 6
    //   33: ldc 38
    //   35: aconst_null
    //   36: invokevirtual 43	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +70 -> 111
    //   44: aload_1
    //   45: invokeinterface 49 1 0
    //   50: ifeq +61 -> 111
    //   53: aload 6
    //   55: aload_1
    //   56: iconst_0
    //   57: invokeinterface 53 2 0
    //   62: invokestatic 59	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   71: pop
    //   72: goto -28 -> 44
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_1
    //   79: ifnull +9 -> 88
    //   82: aload_1
    //   83: invokeinterface 69 1 0
    //   88: aload_2
    //   89: ifnull +9 -> 98
    //   92: aload_2
    //   93: invokeinterface 69 1 0
    //   98: aload 4
    //   100: ifnull -91 -> 9
    //   103: aload 4
    //   105: invokeinterface 69 1 0
    //   110: return
    //   111: aload 6
    //   113: ldc 71
    //   115: aconst_null
    //   116: invokevirtual 43	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +40 -> 161
    //   124: aload_3
    //   125: astore 4
    //   127: aload_2
    //   128: invokeinterface 49 1 0
    //   133: ifeq +28 -> 161
    //   136: aload_3
    //   137: astore 4
    //   139: aload 6
    //   141: aload_2
    //   142: iconst_0
    //   143: invokeinterface 53 2 0
    //   148: invokestatic 59	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   151: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   157: pop
    //   158: goto -34 -> 124
    //   161: aload_3
    //   162: astore 4
    //   164: aload 6
    //   166: ldc 73
    //   168: aconst_null
    //   169: invokevirtual 43	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   172: astore_3
    //   173: aload_3
    //   174: ifnull +90 -> 264
    //   177: aload_3
    //   178: astore 4
    //   180: aload_3
    //   181: invokeinterface 49 1 0
    //   186: ifeq +78 -> 264
    //   189: aload_3
    //   190: astore 4
    //   192: aload 6
    //   194: aload_3
    //   195: iconst_0
    //   196: invokeinterface 53 2 0
    //   201: invokestatic 59	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   207: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   210: pop
    //   211: goto -34 -> 177
    //   214: astore 6
    //   216: aload_3
    //   217: astore 5
    //   219: aload_1
    //   220: astore 4
    //   222: aload_2
    //   223: astore_3
    //   224: aload 5
    //   226: astore_2
    //   227: aload 6
    //   229: astore_1
    //   230: aload 4
    //   232: ifnull +10 -> 242
    //   235: aload 4
    //   237: invokeinterface 69 1 0
    //   242: aload_3
    //   243: ifnull +9 -> 252
    //   246: aload_3
    //   247: invokeinterface 69 1 0
    //   252: aload_2
    //   253: ifnull +9 -> 262
    //   256: aload_2
    //   257: invokeinterface 69 1 0
    //   262: aload_1
    //   263: athrow
    //   264: aload_3
    //   265: astore 4
    //   267: aload 6
    //   269: new 75	com/tencent/mobileqq/data/RecentUser
    //   272: dup
    //   273: invokespecial 76	com/tencent/mobileqq/data/RecentUser:<init>	()V
    //   276: invokevirtual 80	com/tencent/mobileqq/data/RecentUser:getTableName	()Ljava/lang/String;
    //   279: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   285: pop
    //   286: aload_3
    //   287: astore 4
    //   289: aload 6
    //   291: new 82	com/tencent/mobileqq/data/QCallRecent
    //   294: dup
    //   295: invokespecial 83	com/tencent/mobileqq/data/QCallRecent:<init>	()V
    //   298: invokevirtual 84	com/tencent/mobileqq/data/QCallRecent:getTableName	()Ljava/lang/String;
    //   301: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   304: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   307: pop
    //   308: aload_3
    //   309: astore 4
    //   311: aload 6
    //   313: new 86	com/tencent/mobileqq/data/TroopAssistantData
    //   316: dup
    //   317: invokespecial 87	com/tencent/mobileqq/data/TroopAssistantData:<init>	()V
    //   320: invokevirtual 88	com/tencent/mobileqq/data/TroopAssistantData:getTableName	()Ljava/lang/String;
    //   323: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   326: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   329: pop
    //   330: aload_3
    //   331: astore 4
    //   333: aload 6
    //   335: new 90	com/tencent/mobileqq/data/PubAccountAssistantData
    //   338: dup
    //   339: invokespecial 91	com/tencent/mobileqq/data/PubAccountAssistantData:<init>	()V
    //   342: invokevirtual 92	com/tencent/mobileqq/data/PubAccountAssistantData:getTableName	()Ljava/lang/String;
    //   345: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   348: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   351: pop
    //   352: aload_3
    //   353: astore 4
    //   355: aload 6
    //   357: new 94	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   360: dup
    //   361: invokespecial 95	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:<init>	()V
    //   364: invokevirtual 96	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:getTableName	()Ljava/lang/String;
    //   367: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   373: pop
    //   374: aload_3
    //   375: astore 4
    //   377: aload 6
    //   379: new 98	com/tencent/mobileqq/data/NeedHandleUserData
    //   382: dup
    //   383: invokespecial 99	com/tencent/mobileqq/data/NeedHandleUserData:<init>	()V
    //   386: invokevirtual 100	com/tencent/mobileqq/data/NeedHandleUserData:getTableName	()Ljava/lang/String;
    //   389: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   392: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   395: pop
    //   396: aload_3
    //   397: astore 4
    //   399: aload 6
    //   401: new 102	com/tencent/mobileqq/data/ConversationInfo
    //   404: dup
    //   405: invokespecial 103	com/tencent/mobileqq/data/ConversationInfo:<init>	()V
    //   408: invokevirtual 104	com/tencent/mobileqq/data/ConversationInfo:getTableName	()Ljava/lang/String;
    //   411: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   414: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   417: pop
    //   418: aload_3
    //   419: astore 4
    //   421: aload 6
    //   423: new 106	com/tencent/mobileqq/data/RecommendContact
    //   426: dup
    //   427: invokespecial 107	com/tencent/mobileqq/data/RecommendContact:<init>	()V
    //   430: invokevirtual 108	com/tencent/mobileqq/data/RecommendContact:getTableName	()Ljava/lang/String;
    //   433: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   439: pop
    //   440: aload_3
    //   441: astore 4
    //   443: aload 6
    //   445: new 110	com/tencent/mobileqq/data/SubAccountInfo
    //   448: dup
    //   449: invokespecial 111	com/tencent/mobileqq/data/SubAccountInfo:<init>	()V
    //   452: invokevirtual 112	com/tencent/mobileqq/data/SubAccountInfo:getTableName	()Ljava/lang/String;
    //   455: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   458: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   461: pop
    //   462: aload_3
    //   463: astore 4
    //   465: aload 6
    //   467: new 114	com/tencent/mobileqq/data/SubAccountMessage
    //   470: dup
    //   471: invokespecial 115	com/tencent/mobileqq/data/SubAccountMessage:<init>	()V
    //   474: invokevirtual 116	com/tencent/mobileqq/data/SubAccountMessage:getTableName	()Ljava/lang/String;
    //   477: invokestatic 63	com/tencent/mobileqq/persistence/TableBuilder:a	(Ljava/lang/String;)Ljava/lang/String;
    //   480: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   483: pop
    //   484: aload_3
    //   485: astore 4
    //   487: aload 5
    //   489: invokevirtual 117	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   492: aload_1
    //   493: ifnull +9 -> 502
    //   496: aload_1
    //   497: invokeinterface 69 1 0
    //   502: aload_2
    //   503: ifnull +9 -> 512
    //   506: aload_2
    //   507: invokeinterface 69 1 0
    //   512: aload_3
    //   513: ifnull -504 -> 9
    //   516: aload_3
    //   517: invokeinterface 69 1 0
    //   522: return
    //   523: astore_1
    //   524: aconst_null
    //   525: astore_3
    //   526: aconst_null
    //   527: astore 4
    //   529: aconst_null
    //   530: astore_2
    //   531: goto -301 -> 230
    //   534: astore_2
    //   535: aload_1
    //   536: astore 4
    //   538: aconst_null
    //   539: astore_3
    //   540: aload_2
    //   541: astore_1
    //   542: aconst_null
    //   543: astore_2
    //   544: goto -314 -> 230
    //   547: astore 5
    //   549: aload_1
    //   550: astore 4
    //   552: aload_2
    //   553: astore_3
    //   554: aconst_null
    //   555: astore_2
    //   556: aload 5
    //   558: astore_1
    //   559: goto -329 -> 230
    //   562: astore_1
    //   563: aconst_null
    //   564: astore_2
    //   565: aconst_null
    //   566: astore_1
    //   567: goto -489 -> 78
    //   570: astore_3
    //   571: goto -493 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	this	MessageRecordManagerImpl
    //   0	574	1	paramString	String
    //   75	1	2	localException1	Exception
    //   77	454	2	localObject1	Object
    //   534	7	2	localObject2	Object
    //   543	22	2	localObject3	Object
    //   1	553	3	localObject4	Object
    //   570	1	3	localException2	Exception
    //   3	548	4	localObject5	Object
    //   18	470	5	localObject6	Object
    //   547	10	5	localObject7	Object
    //   29	164	6	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   214	252	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   44	72	75	java/lang/Exception
    //   111	120	75	java/lang/Exception
    //   180	189	214	finally
    //   192	211	214	finally
    //   267	286	214	finally
    //   289	308	214	finally
    //   311	330	214	finally
    //   333	352	214	finally
    //   355	374	214	finally
    //   377	396	214	finally
    //   399	418	214	finally
    //   421	440	214	finally
    //   443	462	214	finally
    //   465	484	214	finally
    //   487	492	214	finally
    //   31	40	523	finally
    //   44	72	534	finally
    //   111	120	534	finally
    //   127	136	547	finally
    //   139	158	547	finally
    //   164	173	547	finally
    //   31	40	562	java/lang/Exception
    //   127	136	570	java/lang/Exception
    //   139	158	570	java/lang/Exception
    //   164	173	570	java/lang/Exception
    //   180	189	570	java/lang/Exception
    //   192	211	570	java/lang/Exception
    //   267	286	570	java/lang/Exception
    //   289	308	570	java/lang/Exception
    //   311	330	570	java/lang/Exception
    //   333	352	570	java/lang/Exception
    //   355	374	570	java/lang/Exception
    //   377	396	570	java/lang/Exception
    //   399	418	570	java/lang/Exception
    //   421	440	570	java/lang/Exception
    //   443	462	570	java/lang/Exception
    //   465	484	570	java/lang/Exception
    //   487	492	570	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\managers\MessageRecordManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */