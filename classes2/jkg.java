import com.tencent.chirp.PCMRecorder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jkg
  extends Thread
{
  public volatile boolean a;
  
  public jkg(PCMRecorder paramPCMRecorder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 33
    //   8: iconst_2
    //   9: ldc 35
    //   11: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   18: invokestatic 44	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)I
    //   21: iconst_2
    //   22: iconst_2
    //   23: invokestatic 50	android/media/AudioRecord:getMinBufferSize	(III)I
    //   26: istore_3
    //   27: new 46	android/media/AudioRecord
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   36: invokestatic 44	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)I
    //   39: iconst_2
    //   40: iconst_2
    //   41: iload_3
    //   42: invokespecial 53	android/media/AudioRecord:<init>	(IIIII)V
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 57	android/media/AudioRecord:getState	()I
    //   50: iconst_1
    //   51: if_icmpeq +60 -> 111
    //   54: aload_0
    //   55: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   58: invokestatic 60	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   61: iconst_m1
    //   62: invokeinterface 65 2 0
    //   67: aload_0
    //   68: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   71: invokestatic 68	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   74: iconst_0
    //   75: invokestatic 73	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   78: pop
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 76	android/media/AudioRecord:release	()V
    //   87: aload_0
    //   88: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   91: aconst_null
    //   92: invokestatic 79	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Ljkg;)Ljkg;
    //   95: pop
    //   96: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +11 -> 110
    //   102: ldc 33
    //   104: iconst_2
    //   105: ldc 81
    //   107: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    //   111: aload_0
    //   112: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   115: invokestatic 68	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   118: iconst_1
    //   119: invokestatic 73	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   122: pop
    //   123: aload_1
    //   124: invokevirtual 84	android/media/AudioRecord:startRecording	()V
    //   127: aload_0
    //   128: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   131: invokestatic 87	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   134: newarray <illegal type>
    //   136: astore_2
    //   137: iconst_0
    //   138: istore_3
    //   139: aload_0
    //   140: getfield 21	jkg:jdField_a_of_type_Boolean	Z
    //   143: ifeq +55 -> 198
    //   146: iload_3
    //   147: aload_1
    //   148: aload_2
    //   149: iload_3
    //   150: aload_0
    //   151: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   154: invokestatic 87	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   157: iload_3
    //   158: isub
    //   159: invokevirtual 91	android/media/AudioRecord:read	([BII)I
    //   162: iadd
    //   163: istore 4
    //   165: iload 4
    //   167: istore_3
    //   168: iload 4
    //   170: aload_0
    //   171: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   174: invokestatic 87	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   177: if_icmpne -38 -> 139
    //   180: aload_0
    //   181: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   184: invokestatic 60	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   187: aload_2
    //   188: invokeinterface 94 2 0
    //   193: iconst_0
    //   194: istore_3
    //   195: goto -56 -> 139
    //   198: aload_0
    //   199: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   202: invokestatic 68	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   205: iconst_0
    //   206: invokestatic 73	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   209: pop
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 76	android/media/AudioRecord:release	()V
    //   218: aload_0
    //   219: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   222: aconst_null
    //   223: invokestatic 79	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Ljkg;)Ljkg;
    //   226: pop
    //   227: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq -120 -> 110
    //   233: ldc 33
    //   235: iconst_2
    //   236: ldc 81
    //   238: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: return
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_1
    //   245: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +12 -> 260
    //   251: ldc 33
    //   253: iconst_2
    //   254: ldc 96
    //   256: aload_2
    //   257: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_0
    //   261: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   264: invokestatic 60	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   267: ifnull +17 -> 284
    //   270: aload_0
    //   271: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   274: invokestatic 60	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   277: bipush -2
    //   279: invokeinterface 65 2 0
    //   284: aload_0
    //   285: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   288: invokestatic 68	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   291: iconst_0
    //   292: invokestatic 73	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   295: pop
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 76	android/media/AudioRecord:release	()V
    //   304: aload_0
    //   305: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   308: aconst_null
    //   309: invokestatic 79	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Ljkg;)Ljkg;
    //   312: pop
    //   313: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq -206 -> 110
    //   319: ldc 33
    //   321: iconst_2
    //   322: ldc 81
    //   324: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: return
    //   328: astore_2
    //   329: aconst_null
    //   330: astore_1
    //   331: aload_0
    //   332: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   335: invokestatic 68	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   338: iconst_0
    //   339: invokestatic 73	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   342: pop
    //   343: aload_1
    //   344: ifnull +7 -> 351
    //   347: aload_1
    //   348: invokevirtual 76	android/media/AudioRecord:release	()V
    //   351: aload_0
    //   352: getfield 11	jkg:jdField_a_of_type_ComTencentChirpPCMRecorder	Lcom/tencent/chirp/PCMRecorder;
    //   355: aconst_null
    //   356: invokestatic 79	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Ljkg;)Ljkg;
    //   359: pop
    //   360: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +11 -> 374
    //   366: ldc 33
    //   368: iconst_2
    //   369: ldc 81
    //   371: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload_2
    //   375: athrow
    //   376: astore_2
    //   377: goto -46 -> 331
    //   380: astore_2
    //   381: goto -50 -> 331
    //   384: astore_2
    //   385: goto -140 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	jkg
    //   45	303	1	localAudioRecord	android.media.AudioRecord
    //   136	52	2	arrayOfByte	byte[]
    //   242	15	2	localThrowable1	Throwable
    //   328	47	2	localObject1	Object
    //   376	1	2	localObject2	Object
    //   380	1	2	localObject3	Object
    //   384	1	2	localThrowable2	Throwable
    //   26	169	3	i	int
    //   163	15	4	j	int
    // Exception table:
    //   from	to	target	type
    //   14	46	242	java/lang/Throwable
    //   14	46	328	finally
    //   46	67	376	finally
    //   111	137	376	finally
    //   139	165	376	finally
    //   168	193	376	finally
    //   245	260	380	finally
    //   260	284	380	finally
    //   46	67	384	java/lang/Throwable
    //   111	137	384	java/lang/Throwable
    //   139	165	384	java/lang/Throwable
    //   168	193	384	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\jkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */