import com.tencent.chirp.PcmPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jki
  extends Thread
{
  public volatile boolean a;
  
  private jki(PcmPlayer paramPcmPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_2
    //   4: istore 5
    //   6: new 30	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   14: invokestatic 35	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Ljava/lang/String;
    //   17: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +31 -> 55
    //   27: ldc 46
    //   29: iconst_2
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   37: ldc 51
    //   39: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 59	java/io/File:length	()J
    //   46: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_2
    //   56: invokevirtual 73	java/io/File:exists	()Z
    //   59: ifne +36 -> 95
    //   62: aload_0
    //   63: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   66: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   69: ifnull +16 -> 85
    //   72: aload_0
    //   73: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   76: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   79: iconst_1
    //   80: invokeinterface 82 2 0
    //   85: aload_0
    //   86: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   89: aconst_null
    //   90: invokestatic 85	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Ljki;)Ljki;
    //   93: pop
    //   94: return
    //   95: aload_0
    //   96: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   99: invokestatic 88	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)I
    //   102: newarray <illegal type>
    //   104: astore_1
    //   105: new 90	java/io/FileInputStream
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: astore_2
    //   114: new 95	java/io/BufferedInputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore_3
    //   123: aload_0
    //   124: getfield 21	jki:jdField_a_of_type_Boolean	Z
    //   127: ifeq +18 -> 145
    //   130: aload_3
    //   131: aload_1
    //   132: iconst_0
    //   133: aload_1
    //   134: arraylength
    //   135: invokevirtual 102	java/io/BufferedInputStream:read	([BII)I
    //   138: istore 6
    //   140: iload 6
    //   142: ifgt +54 -> 196
    //   145: aload_0
    //   146: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   149: invokestatic 105	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   152: invokevirtual 110	android/media/AudioTrack:stop	()V
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 113	java/io/FileInputStream:close	()V
    //   163: aload_0
    //   164: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   167: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   170: ifnull +16 -> 186
    //   173: aload_0
    //   174: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   177: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   180: iconst_0
    //   181: invokeinterface 82 2 0
    //   186: aload_0
    //   187: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   190: aconst_null
    //   191: invokestatic 85	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Ljki;)Ljki;
    //   194: pop
    //   195: return
    //   196: aload_0
    //   197: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   200: invokestatic 105	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   203: aload_1
    //   204: iconst_0
    //   205: iload 6
    //   207: invokevirtual 116	android/media/AudioTrack:write	([BII)I
    //   210: pop
    //   211: goto -88 -> 123
    //   214: astore_1
    //   215: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +12 -> 230
    //   221: ldc 46
    //   223: iconst_2
    //   224: ldc 118
    //   226: aload_1
    //   227: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_0
    //   231: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   234: invokestatic 105	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   237: invokevirtual 110	android/media/AudioTrack:stop	()V
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 113	java/io/FileInputStream:close	()V
    //   248: aload_0
    //   249: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   252: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   255: ifnull +16 -> 271
    //   258: aload_0
    //   259: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   262: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   265: iconst_2
    //   266: invokeinterface 82 2 0
    //   271: aload_0
    //   272: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   275: aconst_null
    //   276: invokestatic 85	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Ljki;)Ljki;
    //   279: pop
    //   280: return
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_2
    //   284: iconst_0
    //   285: istore 4
    //   287: aload_0
    //   288: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   291: invokestatic 105	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   294: invokevirtual 110	android/media/AudioTrack:stop	()V
    //   297: aload_2
    //   298: ifnull +7 -> 305
    //   301: aload_2
    //   302: invokevirtual 113	java/io/FileInputStream:close	()V
    //   305: aload_0
    //   306: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   309: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   312: ifnull +28 -> 340
    //   315: aload_0
    //   316: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   319: invokestatic 76	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   322: astore_2
    //   323: iload 4
    //   325: ifeq +26 -> 351
    //   328: iload 5
    //   330: istore 4
    //   332: aload_2
    //   333: iload 4
    //   335: invokeinterface 82 2 0
    //   340: aload_0
    //   341: getfield 11	jki:jdField_a_of_type_ComTencentChirpPcmPlayer	Lcom/tencent/chirp/PcmPlayer;
    //   344: aconst_null
    //   345: invokestatic 85	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Ljki;)Ljki;
    //   348: pop
    //   349: aload_1
    //   350: athrow
    //   351: iconst_0
    //   352: istore 4
    //   354: goto -22 -> 332
    //   357: astore_1
    //   358: goto -195 -> 163
    //   361: astore_1
    //   362: goto -114 -> 248
    //   365: astore_2
    //   366: goto -61 -> 305
    //   369: astore_1
    //   370: iconst_0
    //   371: istore 4
    //   373: goto -86 -> 287
    //   376: astore_1
    //   377: goto -90 -> 287
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_2
    //   383: goto -168 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	jki
    //   104	100	1	arrayOfByte	byte[]
    //   214	13	1	localException1	Exception
    //   281	69	1	localObject1	Object
    //   357	1	1	localException2	Exception
    //   361	1	1	localException3	Exception
    //   369	1	1	localObject2	Object
    //   376	1	1	localObject3	Object
    //   380	1	1	localException4	Exception
    //   20	313	2	localObject4	Object
    //   365	1	2	localException5	Exception
    //   382	1	2	localObject5	Object
    //   122	9	3	localBufferedInputStream	java.io.BufferedInputStream
    //   1	371	4	i	int
    //   4	325	5	j	int
    //   138	68	6	k	int
    // Exception table:
    //   from	to	target	type
    //   114	123	214	java/lang/Exception
    //   123	140	214	java/lang/Exception
    //   196	211	214	java/lang/Exception
    //   105	114	281	finally
    //   159	163	357	java/lang/Exception
    //   244	248	361	java/lang/Exception
    //   301	305	365	java/lang/Exception
    //   114	123	369	finally
    //   123	140	369	finally
    //   196	211	369	finally
    //   215	230	376	finally
    //   105	114	380	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\jki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */