package com.tencent.mobileqq.highway.openup;

public class SessionInfo
{
  private static final String HW_SESSION_EXT_NAME = ".highways";
  private static final String HW_SESSION_INFO_DIRNAME = "highway_session_info_dir";
  private static final String HW_SESSION_INFO_FILENAME = "highway_session_info";
  private static volatile SessionInfo sessionInfo;
  private byte[] bytes_httpconn_sig_session;
  private byte[] bytes_session_key;
  
  private SessionInfo(String paramString)
  {
    loadFromDisk(paramString);
  }
  
  /* Error */
  public static void clearOldSession()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 37
    //   11: iconst_2
    //   12: ldc 39
    //   14: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull +7 -> 29
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: new 51	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   37: ldc 14
    //   39: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 63	java/io/File:exists	()Z
    //   47: ifeq -22 -> 25
    //   50: aload_0
    //   51: invokevirtual 66	java/io/File:delete	()Z
    //   54: pop
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	31	0	localObject1	Object
    //   58	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	58	finally
    //   17	21	58	finally
    //   29	55	58	finally
  }
  
  public static SessionInfo getInstance(String paramString)
  {
    if (sessionInfo == null) {}
    try
    {
      if (sessionInfo == null) {
        sessionInfo = new SessionInfo(paramString);
      }
      return sessionInfo;
    }
    finally {}
  }
  
  /* Error */
  private void loadFromDisk(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull -6 -> 4
    //   13: new 51	java/io/File
    //   16: dup
    //   17: new 51	java/io/File
    //   20: dup
    //   21: aload_2
    //   22: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   25: ldc 11
    //   27: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: new 78	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   37: aload_1
    //   38: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 8
    //   43: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 63	java/io/File:exists	()Z
    //   57: ifeq +131 -> 188
    //   60: new 89	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   63: dup
    //   64: invokespecial 90	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   67: astore 9
    //   69: aconst_null
    //   70: astore 8
    //   72: aconst_null
    //   73: astore_3
    //   74: aconst_null
    //   75: astore 6
    //   77: aconst_null
    //   78: astore 4
    //   80: aconst_null
    //   81: astore_2
    //   82: aconst_null
    //   83: astore 7
    //   85: aconst_null
    //   86: astore 5
    //   88: new 92	java/io/FileInputStream
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore_1
    //   97: new 97	java/io/ByteArrayOutputStream
    //   100: dup
    //   101: invokespecial 98	java/io/ByteArrayOutputStream:<init>	()V
    //   104: astore_2
    //   105: sipush 128
    //   108: newarray <illegal type>
    //   110: astore_3
    //   111: aload_1
    //   112: aload_3
    //   113: iconst_0
    //   114: aload_3
    //   115: arraylength
    //   116: invokevirtual 102	java/io/FileInputStream:read	([BII)I
    //   119: istore 10
    //   121: iload 10
    //   123: iconst_m1
    //   124: if_icmpeq +97 -> 221
    //   127: aload_2
    //   128: aload_3
    //   129: iconst_0
    //   130: iload 10
    //   132: invokevirtual 106	java/io/ByteArrayOutputStream:write	([BII)V
    //   135: goto -24 -> 111
    //   138: astore 5
    //   140: aload_2
    //   141: astore 4
    //   143: aload 4
    //   145: astore_2
    //   146: aload_1
    //   147: astore_3
    //   148: ldc 37
    //   150: iconst_2
    //   151: ldc 108
    //   153: aload 5
    //   155: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 115	java/io/FileInputStream:close	()V
    //   166: aload 4
    //   168: ifnull -164 -> 4
    //   171: aload 4
    //   173: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   176: return
    //   177: astore_1
    //   178: ldc 37
    //   180: iconst_2
    //   181: ldc 108
    //   183: aload_1
    //   184: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: return
    //   188: new 51	java/io/File
    //   191: dup
    //   192: aload_2
    //   193: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   196: ldc 14
    //   198: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 63	java/io/File:exists	()Z
    //   206: ifeq +6 -> 212
    //   209: goto -149 -> 60
    //   212: ldc 37
    //   214: iconst_2
    //   215: ldc 118
    //   217: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: aload_2
    //   222: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   225: aload 9
    //   227: aload_2
    //   228: invokevirtual 127	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   231: invokevirtual 131	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   234: pop
    //   235: aload 9
    //   237: getfield 134	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 139	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   243: ifeq +18 -> 261
    //   246: aload_0
    //   247: aload 9
    //   249: getfield 134	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   252: invokevirtual 143	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   255: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   258: putfield 148	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_httpconn_sig_session	[B
    //   261: aload 9
    //   263: getfield 150	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   266: invokevirtual 139	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   269: ifeq +18 -> 287
    //   272: aload_0
    //   273: aload 9
    //   275: getfield 150	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   278: invokevirtual 143	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   281: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   284: putfield 152	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_session_key	[B
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 115	java/io/FileInputStream:close	()V
    //   295: aload_2
    //   296: ifnull +214 -> 510
    //   299: aload_2
    //   300: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   303: return
    //   304: astore_1
    //   305: ldc 37
    //   307: iconst_2
    //   308: ldc 108
    //   310: aload_1
    //   311: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   314: goto -19 -> 295
    //   317: astore_1
    //   318: ldc 37
    //   320: iconst_2
    //   321: ldc 108
    //   323: aload_1
    //   324: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: return
    //   328: astore_1
    //   329: ldc 37
    //   331: iconst_2
    //   332: ldc 108
    //   334: aload_1
    //   335: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: goto -172 -> 166
    //   341: astore 5
    //   343: aload 8
    //   345: astore_1
    //   346: aload 4
    //   348: astore_2
    //   349: aload_1
    //   350: astore_3
    //   351: ldc 37
    //   353: iconst_2
    //   354: ldc 108
    //   356: aload 5
    //   358: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: aload_1
    //   362: ifnull +7 -> 369
    //   365: aload_1
    //   366: invokevirtual 115	java/io/FileInputStream:close	()V
    //   369: aload 4
    //   371: ifnull -367 -> 4
    //   374: aload 4
    //   376: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   379: return
    //   380: astore_1
    //   381: ldc 37
    //   383: iconst_2
    //   384: ldc 108
    //   386: aload_1
    //   387: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   390: return
    //   391: astore_1
    //   392: ldc 37
    //   394: iconst_2
    //   395: ldc 108
    //   397: aload_1
    //   398: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   401: goto -32 -> 369
    //   404: astore_1
    //   405: aload_3
    //   406: ifnull +7 -> 413
    //   409: aload_3
    //   410: invokevirtual 115	java/io/FileInputStream:close	()V
    //   413: aload_2
    //   414: ifnull +7 -> 421
    //   417: aload_2
    //   418: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   421: aload_1
    //   422: athrow
    //   423: astore_3
    //   424: ldc 37
    //   426: iconst_2
    //   427: ldc 108
    //   429: aload_3
    //   430: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   433: goto -20 -> 413
    //   436: astore_2
    //   437: ldc 37
    //   439: iconst_2
    //   440: ldc 108
    //   442: aload_2
    //   443: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   446: goto -25 -> 421
    //   449: astore 4
    //   451: aload 7
    //   453: astore_2
    //   454: aload_1
    //   455: astore_3
    //   456: aload 4
    //   458: astore_1
    //   459: goto -54 -> 405
    //   462: astore 4
    //   464: aload_1
    //   465: astore_3
    //   466: aload 4
    //   468: astore_1
    //   469: goto -64 -> 405
    //   472: astore 5
    //   474: goto -128 -> 346
    //   477: astore 5
    //   479: aload_2
    //   480: astore 4
    //   482: goto -136 -> 346
    //   485: astore_1
    //   486: aload 5
    //   488: astore 4
    //   490: aload_1
    //   491: astore 5
    //   493: aload 6
    //   495: astore_1
    //   496: goto -353 -> 143
    //   499: astore_2
    //   500: aload 5
    //   502: astore 4
    //   504: aload_2
    //   505: astore 5
    //   507: goto -364 -> 143
    //   510: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	SessionInfo
    //   0	511	1	paramString	String
    //   8	410	2	localObject1	Object
    //   436	7	2	localIOException1	java.io.IOException
    //   453	27	2	localObject2	Object
    //   499	6	2	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   73	337	3	localObject3	Object
    //   423	7	3	localIOException2	java.io.IOException
    //   455	11	3	str	String
    //   78	297	4	localObject4	Object
    //   449	8	4	localObject5	Object
    //   462	5	4	localObject6	Object
    //   480	23	4	localObject7	Object
    //   86	1	5	localObject8	Object
    //   138	16	5	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   341	16	5	localIOException3	java.io.IOException
    //   472	1	5	localIOException4	java.io.IOException
    //   477	10	5	localIOException5	java.io.IOException
    //   491	15	5	localObject9	Object
    //   75	419	6	localObject10	Object
    //   83	369	7	localObject11	Object
    //   70	274	8	localObject12	Object
    //   67	207	9	localHwSessionInfoPB	com.tencent.mobileqq.highway.protocol.HwSessionInfoPersistentPB.HwSessionInfoPB
    //   119	12	10	i	int
    // Exception table:
    //   from	to	target	type
    //   105	111	138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   111	121	138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	135	138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   221	261	138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   261	287	138	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   171	176	177	java/io/IOException
    //   291	295	304	java/io/IOException
    //   299	303	317	java/io/IOException
    //   162	166	328	java/io/IOException
    //   88	97	341	java/io/IOException
    //   374	379	380	java/io/IOException
    //   365	369	391	java/io/IOException
    //   88	97	404	finally
    //   148	158	404	finally
    //   351	361	404	finally
    //   409	413	423	java/io/IOException
    //   417	421	436	java/io/IOException
    //   97	105	449	finally
    //   105	111	462	finally
    //   111	121	462	finally
    //   127	135	462	finally
    //   221	261	462	finally
    //   261	287	462	finally
    //   97	105	472	java/io/IOException
    //   105	111	477	java/io/IOException
    //   111	121	477	java/io/IOException
    //   127	135	477	java/io/IOException
    //   221	261	477	java/io/IOException
    //   261	287	477	java/io/IOException
    //   88	97	485	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   97	105	499	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  public static void updateSessionInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 37
    //   11: iconst_2
    //   12: ldc -101
    //   14: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: arraylength
    //   23: ifeq +18 -> 41
    //   26: aload_1
    //   27: ifnull +14 -> 41
    //   30: aload_1
    //   31: arraylength
    //   32: istore_3
    //   33: iload_3
    //   34: ifeq +7 -> 41
    //   37: aload_2
    //   38: ifnonnull +7 -> 45
    //   41: ldc 2
    //   43: monitorexit
    //   44: return
    //   45: invokestatic 157	com/tencent/mobileqq/highway/openup/SessionInfo:clearOldSession	()V
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: invokestatic 161	com/tencent/mobileqq/highway/openup/SessionInfo:write2Disk	([B[BLjava/lang/String;)Z
    //   54: ifeq -13 -> 41
    //   57: aconst_null
    //   58: putstatic 70	com/tencent/mobileqq/highway/openup/SessionInfo:sessionInfo	Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   61: goto -20 -> 41
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramArrayOfByte1	byte[]
    //   0	70	1	paramArrayOfByte2	byte[]
    //   0	70	2	paramString	String
    //   32	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   3	17	64	finally
    //   21	26	64	finally
    //   30	33	64	finally
    //   45	61	64	finally
  }
  
  /* Error */
  private static boolean write2Disk(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: new 51	java/io/File
    //   16: dup
    //   17: aload_3
    //   18: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   21: ldc 11
    //   23: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 63	java/io/File:exists	()Z
    //   31: ifne +8 -> 39
    //   34: aload_3
    //   35: invokevirtual 166	java/io/File:mkdir	()Z
    //   38: pop
    //   39: new 51	java/io/File
    //   42: dup
    //   43: aload_3
    //   44: invokevirtual 169	java/io/File:getPath	()Ljava/lang/String;
    //   47: new 78	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   54: aload_2
    //   55: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 8
    //   60: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 63	java/io/File:exists	()Z
    //   74: ifeq +8 -> 82
    //   77: aload_3
    //   78: invokevirtual 66	java/io/File:delete	()Z
    //   81: pop
    //   82: aconst_null
    //   83: astore 5
    //   85: aconst_null
    //   86: astore_2
    //   87: aconst_null
    //   88: astore 4
    //   90: new 174	java/io/FileOutputStream
    //   93: dup
    //   94: aload_3
    //   95: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: astore_3
    //   99: new 89	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   102: dup
    //   103: invokespecial 90	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   106: astore_2
    //   107: aload_2
    //   108: getfield 134	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   111: aload_0
    //   112: invokestatic 179	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   115: invokevirtual 183	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   118: aload_2
    //   119: getfield 150	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   122: aload_1
    //   123: invokestatic 179	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 183	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   129: aload_3
    //   130: aload_2
    //   131: invokevirtual 184	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:toByteArray	()[B
    //   134: invokevirtual 187	java/io/FileOutputStream:write	([B)V
    //   137: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +11 -> 151
    //   143: ldc 37
    //   145: iconst_2
    //   146: ldc -67
    //   148: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_3
    //   152: ifnull +7 -> 159
    //   155: aload_3
    //   156: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   159: iload 6
    //   161: ireturn
    //   162: astore_0
    //   163: ldc 37
    //   165: iconst_2
    //   166: ldc -64
    //   168: aload_0
    //   169: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: iconst_0
    //   173: istore 6
    //   175: goto -16 -> 159
    //   178: astore_1
    //   179: aload 4
    //   181: astore_0
    //   182: aload_0
    //   183: astore_2
    //   184: ldc 37
    //   186: iconst_2
    //   187: ldc -64
    //   189: aload_1
    //   190: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: iconst_0
    //   194: istore 7
    //   196: iload 7
    //   198: istore 6
    //   200: aload_0
    //   201: ifnull -42 -> 159
    //   204: aload_0
    //   205: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   208: iload 7
    //   210: istore 6
    //   212: goto -53 -> 159
    //   215: astore_0
    //   216: ldc 37
    //   218: iconst_2
    //   219: ldc -64
    //   221: aload_0
    //   222: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: iconst_0
    //   226: istore 6
    //   228: goto -69 -> 159
    //   231: astore_1
    //   232: aload 5
    //   234: astore_0
    //   235: aload_0
    //   236: astore_2
    //   237: ldc 37
    //   239: iconst_2
    //   240: ldc -64
    //   242: aload_1
    //   243: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   246: iconst_0
    //   247: istore 7
    //   249: iload 7
    //   251: istore 6
    //   253: aload_0
    //   254: ifnull -95 -> 159
    //   257: aload_0
    //   258: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   261: iload 7
    //   263: istore 6
    //   265: goto -106 -> 159
    //   268: astore_0
    //   269: ldc 37
    //   271: iconst_2
    //   272: ldc -64
    //   274: aload_0
    //   275: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: iconst_0
    //   279: istore 6
    //   281: goto -122 -> 159
    //   284: astore_0
    //   285: aload_2
    //   286: ifnull +7 -> 293
    //   289: aload_2
    //   290: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   293: aload_0
    //   294: athrow
    //   295: astore_1
    //   296: ldc 37
    //   298: iconst_2
    //   299: ldc -64
    //   301: aload_1
    //   302: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   305: goto -12 -> 293
    //   308: astore_0
    //   309: aload_3
    //   310: astore_2
    //   311: goto -26 -> 285
    //   314: astore_1
    //   315: aload_3
    //   316: astore_0
    //   317: goto -82 -> 235
    //   320: astore_1
    //   321: aload_3
    //   322: astore_0
    //   323: goto -141 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramArrayOfByte1	byte[]
    //   0	326	1	paramArrayOfByte2	byte[]
    //   0	326	2	paramString	String
    //   6	316	3	localObject1	Object
    //   88	92	4	localObject2	Object
    //   83	150	5	localObject3	Object
    //   1	279	6	bool1	boolean
    //   194	68	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   155	159	162	java/io/IOException
    //   90	99	178	java/io/FileNotFoundException
    //   204	208	215	java/io/IOException
    //   90	99	231	java/io/IOException
    //   257	261	268	java/io/IOException
    //   90	99	284	finally
    //   184	193	284	finally
    //   237	246	284	finally
    //   289	293	295	java/io/IOException
    //   99	151	308	finally
    //   99	151	314	java/io/IOException
    //   99	151	320	java/io/FileNotFoundException
  }
  
  public byte[] getHttpconn_sig_session()
  {
    return this.bytes_httpconn_sig_session;
  }
  
  public byte[] getSessionKey()
  {
    return this.bytes_session_key;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\openup\SessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */