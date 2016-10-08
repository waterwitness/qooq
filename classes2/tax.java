import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder;

public class tax
  implements Runnable
{
  public tax(MagicfaceXBigDecoder paramMagicfaceXBigDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: lconst_0
    //   3: lstore 7
    //   5: aload_0
    //   6: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   9: getfield 31	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_Boolean	Z
    //   12: ifeq +566 -> 578
    //   15: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   18: lstore 5
    //   20: aload_0
    //   21: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   24: aload_0
    //   25: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   28: getfield 40	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ArrayOfByte	[B
    //   31: aload_0
    //   32: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   35: getfield 44	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:h	I
    //   38: invokevirtual 47	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	([BI)I
    //   41: istore 4
    //   43: aload_0
    //   44: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   47: iload 4
    //   49: aload_0
    //   50: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   53: getfield 44	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:h	I
    //   56: isub
    //   57: putfield 50	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	I
    //   60: aload_0
    //   61: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   64: getfield 50	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	I
    //   67: ifgt +4 -> 71
    //   70: return
    //   71: aload_0
    //   72: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   75: aload_0
    //   76: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   79: getfield 50	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	I
    //   82: aload_0
    //   83: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   86: getfield 44	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:h	I
    //   89: aload_0
    //   90: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   93: getfield 40	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ArrayOfByte	[B
    //   96: invokevirtual 53	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(II[B)V
    //   99: aload_0
    //   100: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   103: iload 4
    //   105: putfield 44	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:h	I
    //   108: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   111: lstore 9
    //   113: aload_0
    //   114: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   117: getfield 56	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   120: aload_0
    //   121: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   124: getfield 59	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:b	[B
    //   127: aload_0
    //   128: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   131: getfield 50	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	I
    //   134: aload_0
    //   135: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   138: getfield 62	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:c	[B
    //   141: invokevirtual 68	com/tencent/mobileqq/magicface/DecoderUtil:decodeVideoDecoder	([BI[B)I
    //   144: pop
    //   145: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +48 -> 196
    //   151: ldc 76
    //   153: iconst_2
    //   154: new 78	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   161: ldc 81
    //   163: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   169: lload 9
    //   171: lsub
    //   172: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: ldc 90
    //   177: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   184: getfield 50	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:g	I
    //   187: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   200: getfield 104	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:i	I
    //   203: iconst_m1
    //   204: if_icmpne +61 -> 265
    //   207: aload_0
    //   208: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   211: aload_0
    //   212: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   215: getfield 56	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   218: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:getWidthVideoDecoder	()I
    //   221: putfield 104	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:i	I
    //   224: aload_0
    //   225: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   228: aload_0
    //   229: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   232: getfield 56	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   235: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:getHeightVideoDecoder	()I
    //   238: putfield 114	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:j	I
    //   241: aload_0
    //   242: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   245: aload_0
    //   246: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   249: getfield 114	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:j	I
    //   252: aload_0
    //   253: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   256: getfield 104	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:i	I
    //   259: imul
    //   260: newarray <illegal type>
    //   262: putfield 117	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ArrayOfInt	[I
    //   265: aload_0
    //   266: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   269: invokestatic 120	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   272: astore_1
    //   273: aload_1
    //   274: monitorenter
    //   275: aload_0
    //   276: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   279: invokestatic 123	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Z
    //   282: istore 11
    //   284: iload 11
    //   286: ifne +13 -> 299
    //   289: aload_0
    //   290: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   293: invokestatic 120	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   296: invokevirtual 126	java/lang/Object:wait	()V
    //   299: aload_1
    //   300: monitorexit
    //   301: aload_0
    //   302: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   305: aload_0
    //   306: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   309: getfield 62	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:c	[B
    //   312: aload_0
    //   313: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   316: getfield 129	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_f_of_type_ArrayOfByte	[B
    //   319: invokevirtual 132	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	([B[B)[I
    //   322: astore_1
    //   323: aload_0
    //   324: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   327: getfield 135	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener	Lcom/tencent/mobileqq/magicface/model/MagicfaceDecoder$MagicfaceRenderListener;
    //   330: ifnull +30 -> 360
    //   333: aload_0
    //   334: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   337: getfield 135	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener	Lcom/tencent/mobileqq/magicface/model/MagicfaceDecoder$MagicfaceRenderListener;
    //   340: aload_1
    //   341: aload_0
    //   342: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   345: getfield 104	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:i	I
    //   348: aload_0
    //   349: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   352: getfield 114	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:j	I
    //   355: invokeinterface 140 4 0
    //   360: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   363: lload 5
    //   365: lsub
    //   366: lstore 9
    //   368: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +29 -> 400
    //   374: ldc 76
    //   376: iconst_2
    //   377: new 78	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   384: ldc -114
    //   386: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: lload 9
    //   391: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   394: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: lload 9
    //   402: aload_0
    //   403: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   406: getfield 144	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_f_of_type_Int	I
    //   409: i2l
    //   410: lcmp
    //   411: ifge +125 -> 536
    //   414: lload 7
    //   416: lconst_0
    //   417: lcmp
    //   418: ifle +91 -> 509
    //   421: aload_0
    //   422: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   425: getfield 144	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_f_of_type_Int	I
    //   428: i2l
    //   429: lload 9
    //   431: lsub
    //   432: lstore 5
    //   434: lload 5
    //   436: lload 7
    //   438: lcmp
    //   439: ifle +60 -> 499
    //   442: lload 5
    //   444: lload 7
    //   446: lsub
    //   447: invokestatic 150	java/lang/Thread:sleep	(J)V
    //   450: lload 7
    //   452: lstore 5
    //   454: aload_0
    //   455: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   458: invokestatic 152	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:b	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   461: astore_1
    //   462: aload_1
    //   463: monitorenter
    //   464: aload_0
    //   465: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   468: invokestatic 152	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:b	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   471: invokevirtual 155	java/lang/Object:notify	()V
    //   474: aload_1
    //   475: monitorexit
    //   476: iconst_0
    //   477: istore_3
    //   478: lload 5
    //   480: lstore 7
    //   482: goto -477 -> 5
    //   485: astore_2
    //   486: aload_1
    //   487: monitorexit
    //   488: aload_2
    //   489: athrow
    //   490: astore_1
    //   491: aload_1
    //   492: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   495: return
    //   496: astore_1
    //   497: aload_1
    //   498: athrow
    //   499: lload 7
    //   501: lload 5
    //   503: lsub
    //   504: lstore 5
    //   506: goto -52 -> 454
    //   509: aload_0
    //   510: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   513: getfield 144	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_f_of_type_Int	I
    //   516: i2l
    //   517: lload 9
    //   519: lsub
    //   520: invokestatic 150	java/lang/Thread:sleep	(J)V
    //   523: lload 7
    //   525: lstore 5
    //   527: goto -73 -> 454
    //   530: astore_1
    //   531: aload_1
    //   532: invokevirtual 159	java/lang/OutOfMemoryError:printStackTrace	()V
    //   535: return
    //   536: lload 7
    //   538: lstore 5
    //   540: iload_3
    //   541: ifne -87 -> 454
    //   544: aload_0
    //   545: getfield 12	tax:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   548: getfield 144	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_f_of_type_Int	I
    //   551: istore_3
    //   552: lload 7
    //   554: lload 9
    //   556: iload_3
    //   557: i2l
    //   558: lsub
    //   559: ladd
    //   560: lstore 5
    //   562: goto -108 -> 454
    //   565: astore_2
    //   566: aload_1
    //   567: monitorexit
    //   568: aload_2
    //   569: athrow
    //   570: astore_1
    //   571: goto -95 -> 476
    //   574: astore_2
    //   575: goto -276 -> 299
    //   578: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	tax
    //   490	2	1	localException1	Exception
    //   496	2	1	localObject2	Object
    //   530	37	1	localOutOfMemoryError	OutOfMemoryError
    //   570	1	1	localException2	Exception
    //   485	4	2	localObject3	Object
    //   565	4	2	localObject4	Object
    //   574	1	2	localException3	Exception
    //   1	556	3	i	int
    //   41	63	4	j	int
    //   18	543	5	l1	long
    //   3	550	7	l2	long
    //   111	444	9	l3	long
    //   282	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   275	284	485	finally
    //   289	299	485	finally
    //   299	301	485	finally
    //   486	488	485	finally
    //   5	70	490	java/lang/Exception
    //   71	196	490	java/lang/Exception
    //   196	265	490	java/lang/Exception
    //   265	275	490	java/lang/Exception
    //   301	360	490	java/lang/Exception
    //   360	400	490	java/lang/Exception
    //   400	414	490	java/lang/Exception
    //   421	434	490	java/lang/Exception
    //   442	450	490	java/lang/Exception
    //   488	490	490	java/lang/Exception
    //   509	523	490	java/lang/Exception
    //   544	552	490	java/lang/Exception
    //   5	70	496	finally
    //   71	196	496	finally
    //   196	265	496	finally
    //   265	275	496	finally
    //   301	360	496	finally
    //   360	400	496	finally
    //   400	414	496	finally
    //   421	434	496	finally
    //   442	450	496	finally
    //   454	464	496	finally
    //   488	490	496	finally
    //   491	495	496	finally
    //   509	523	496	finally
    //   531	535	496	finally
    //   544	552	496	finally
    //   568	570	496	finally
    //   5	70	530	java/lang/OutOfMemoryError
    //   71	196	530	java/lang/OutOfMemoryError
    //   196	265	530	java/lang/OutOfMemoryError
    //   265	275	530	java/lang/OutOfMemoryError
    //   301	360	530	java/lang/OutOfMemoryError
    //   360	400	530	java/lang/OutOfMemoryError
    //   400	414	530	java/lang/OutOfMemoryError
    //   421	434	530	java/lang/OutOfMemoryError
    //   442	450	530	java/lang/OutOfMemoryError
    //   454	464	530	java/lang/OutOfMemoryError
    //   488	490	530	java/lang/OutOfMemoryError
    //   509	523	530	java/lang/OutOfMemoryError
    //   544	552	530	java/lang/OutOfMemoryError
    //   568	570	530	java/lang/OutOfMemoryError
    //   464	476	565	finally
    //   566	568	565	finally
    //   454	464	570	java/lang/Exception
    //   568	570	570	java/lang/Exception
    //   289	299	574	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */