package com.tencent.mobileqq.shortvideo.hwcodec;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class HwMergeMp4
{
  private static final String a = "HwMergeMp4";
  
  public HwMergeMp4()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("HwMergeMp4", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  /* Error */
  public static int a(java.util.ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 24	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 84	android/media/MediaExtractor:<init>	()V
    //   7: astore_2
    //   8: new 24	android/media/MediaExtractor
    //   11: dup
    //   12: invokespecial 84	android/media/MediaExtractor:<init>	()V
    //   15: astore_3
    //   16: aload_2
    //   17: aload_0
    //   18: iconst_1
    //   19: invokevirtual 90	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   22: checkcast 72	java/lang/String
    //   25: invokevirtual 94	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   28: aload_3
    //   29: aload_0
    //   30: iconst_1
    //   31: invokevirtual 90	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   34: checkcast 72	java/lang/String
    //   37: invokevirtual 94	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokestatic 96	com/tencent/mobileqq/shortvideo/hwcodec/HwMergeMp4:a	(Landroid/media/MediaExtractor;)I
    //   44: istore 7
    //   46: aload_3
    //   47: invokestatic 99	com/tencent/mobileqq/shortvideo/hwcodec/HwMergeMp4:b	(Landroid/media/MediaExtractor;)I
    //   50: istore 6
    //   52: iload 6
    //   54: iflt +8 -> 62
    //   57: iload 7
    //   59: ifge +25 -> 84
    //   62: aload_2
    //   63: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   66: aload_3
    //   67: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   70: bipush -2
    //   72: ireturn
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   78: aload_3
    //   79: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   82: iconst_m1
    //   83: ireturn
    //   84: new 104	android/media/MediaMuxer
    //   87: dup
    //   88: aload_1
    //   89: iconst_0
    //   90: invokespecial 107	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   93: astore_1
    //   94: aload_1
    //   95: aload_2
    //   96: iload 7
    //   98: invokevirtual 52	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   101: invokevirtual 111	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   104: istore 14
    //   106: aload_1
    //   107: aload_3
    //   108: iload 6
    //   110: invokevirtual 52	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   113: invokevirtual 111	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   116: istore 15
    //   118: aload_1
    //   119: invokevirtual 114	android/media/MediaMuxer:start	()V
    //   122: aload_2
    //   123: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   126: aload_3
    //   127: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   130: sipush 16000
    //   133: invokestatic 120	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   136: astore_2
    //   137: new 122	android/media/MediaCodec$BufferInfo
    //   140: dup
    //   141: invokespecial 123	android/media/MediaCodec$BufferInfo:<init>	()V
    //   144: astore_3
    //   145: aload_0
    //   146: invokevirtual 126	java/util/ArrayList:size	()I
    //   149: istore 16
    //   151: lconst_0
    //   152: lstore 34
    //   154: lconst_0
    //   155: lstore 36
    //   157: lconst_0
    //   158: lstore 22
    //   160: lconst_0
    //   161: lstore 26
    //   163: ldc2_w 127
    //   166: lstore 18
    //   168: ldc2_w 127
    //   171: lstore 20
    //   173: iconst_0
    //   174: istore 11
    //   176: iload 11
    //   178: iload 16
    //   180: if_icmpge +968 -> 1148
    //   183: new 24	android/media/MediaExtractor
    //   186: dup
    //   187: invokespecial 84	android/media/MediaExtractor:<init>	()V
    //   190: astore 4
    //   192: new 24	android/media/MediaExtractor
    //   195: dup
    //   196: invokespecial 84	android/media/MediaExtractor:<init>	()V
    //   199: astore 5
    //   201: aload 4
    //   203: aload_0
    //   204: iload 11
    //   206: invokevirtual 90	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   209: checkcast 72	java/lang/String
    //   212: invokevirtual 94	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   215: aload 5
    //   217: aload_0
    //   218: iload 11
    //   220: invokevirtual 90	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   223: checkcast 72	java/lang/String
    //   226: invokevirtual 94	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   229: iconst_1
    //   230: istore 13
    //   232: iconst_0
    //   233: istore 9
    //   235: aload 4
    //   237: invokestatic 96	com/tencent/mobileqq/shortvideo/hwcodec/HwMergeMp4:a	(Landroid/media/MediaExtractor;)I
    //   240: istore 7
    //   242: aload 5
    //   244: invokestatic 99	com/tencent/mobileqq/shortvideo/hwcodec/HwMergeMp4:b	(Landroid/media/MediaExtractor;)I
    //   247: istore 6
    //   249: iload 7
    //   251: ifge +1020 -> 1271
    //   254: iconst_0
    //   255: istore 12
    //   257: iload 6
    //   259: ifge +6 -> 265
    //   262: iconst_0
    //   263: istore 13
    //   265: iconst_1
    //   266: istore 8
    //   268: lconst_0
    //   269: lstore 40
    //   271: lconst_0
    //   272: lstore 38
    //   274: lconst_0
    //   275: lstore 30
    //   277: lconst_0
    //   278: lstore 32
    //   280: lconst_0
    //   281: lstore 24
    //   283: lconst_0
    //   284: lstore 28
    //   286: iconst_1
    //   287: istore 6
    //   289: iconst_0
    //   290: istore 7
    //   292: iload 7
    //   294: ifeq +8 -> 302
    //   297: iload 9
    //   299: ifne +828 -> 1127
    //   302: iload 12
    //   304: ifeq +948 -> 1252
    //   307: aload_2
    //   308: iconst_0
    //   309: invokevirtual 132	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   312: pop
    //   313: aload 4
    //   315: aload_2
    //   316: iconst_0
    //   317: invokevirtual 136	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   320: istore 17
    //   322: iload 17
    //   324: ifgt +219 -> 543
    //   327: lload 18
    //   329: lstore 42
    //   331: iconst_1
    //   332: istore 7
    //   334: lload 22
    //   336: lstore 18
    //   338: lload 42
    //   340: lstore 22
    //   342: aload 4
    //   344: invokevirtual 139	android/media/MediaExtractor:advance	()Z
    //   347: ifne +871 -> 1218
    //   350: lload 24
    //   352: lstore 42
    //   354: iconst_1
    //   355: istore 7
    //   357: lload 22
    //   359: lstore 24
    //   361: lload 42
    //   363: lstore 22
    //   365: iload 13
    //   367: ifeq +832 -> 1199
    //   370: aload_2
    //   371: iconst_0
    //   372: invokevirtual 132	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   375: pop
    //   376: aload 5
    //   378: aload_2
    //   379: iconst_0
    //   380: invokevirtual 136	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   383: istore 10
    //   385: iload 10
    //   387: ifgt +405 -> 792
    //   390: lload 40
    //   392: lstore 42
    //   394: iconst_1
    //   395: istore 9
    //   397: lload 20
    //   399: lstore 46
    //   401: lload 26
    //   403: lstore 20
    //   405: lload 30
    //   407: lstore 44
    //   409: lload 38
    //   411: lstore 40
    //   413: lload 46
    //   415: lstore 26
    //   417: lload 42
    //   419: lstore 30
    //   421: lload 32
    //   423: lstore 38
    //   425: lload 44
    //   427: lstore 32
    //   429: aload 5
    //   431: invokevirtual 139	android/media/MediaExtractor:advance	()Z
    //   434: ifne +6 -> 440
    //   437: iconst_1
    //   438: istore 9
    //   440: lload 38
    //   442: lstore 42
    //   444: lload 32
    //   446: lstore 44
    //   448: lload 30
    //   450: lstore 46
    //   452: lload 20
    //   454: lstore 48
    //   456: lload 22
    //   458: lstore 20
    //   460: lload 18
    //   462: lstore 22
    //   464: lload 24
    //   466: lstore 18
    //   468: lload 20
    //   470: lstore 24
    //   472: lload 40
    //   474: lstore 38
    //   476: lload 42
    //   478: lstore 32
    //   480: lload 44
    //   482: lstore 30
    //   484: lload 46
    //   486: lstore 40
    //   488: lload 26
    //   490: lstore 20
    //   492: lload 48
    //   494: lstore 26
    //   496: goto -204 -> 292
    //   499: astore_0
    //   500: aload_2
    //   501: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   504: aload_3
    //   505: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   508: bipush -3
    //   510: ireturn
    //   511: astore 4
    //   513: aload 4
    //   515: invokevirtual 142	java/io/IOException:printStackTrace	()V
    //   518: lload 36
    //   520: lstore 28
    //   522: lload 34
    //   524: lstore 24
    //   526: iload 11
    //   528: iconst_1
    //   529: iadd
    //   530: istore 11
    //   532: lload 28
    //   534: lstore 36
    //   536: lload 24
    //   538: lstore 34
    //   540: goto -364 -> 176
    //   543: aload 4
    //   545: invokevirtual 146	android/media/MediaExtractor:getSampleTime	()J
    //   548: lstore 42
    //   550: iload 6
    //   552: istore 10
    //   554: iload 6
    //   556: ifeq +677 -> 1233
    //   559: iconst_0
    //   560: istore 10
    //   562: iload 11
    //   564: iconst_1
    //   565: if_icmplt +668 -> 1233
    //   568: ldc2_w 127
    //   571: lstore 24
    //   573: iconst_0
    //   574: istore 6
    //   576: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq +49 -> 628
    //   582: ldc 8
    //   584: iconst_2
    //   585: new 36	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   592: ldc -108
    //   594: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: lload 42
    //   599: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   602: ldc -103
    //   604: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload 11
    //   609: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: ldc -101
    //   614: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: lload 34
    //   619: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   622: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: lload 42
    //   630: lstore 22
    //   632: iload 11
    //   634: iconst_1
    //   635: if_icmplt +10 -> 645
    //   638: lload 42
    //   640: lload 18
    //   642: ladd
    //   643: lstore 22
    //   645: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq +49 -> 697
    //   651: ldc 8
    //   653: iconst_2
    //   654: new 36	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   661: ldc -108
    //   663: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: lload 22
    //   668: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   671: ldc -103
    //   673: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: iload 11
    //   678: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: ldc -101
    //   683: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: lload 34
    //   688: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   697: lload 22
    //   699: lload 28
    //   701: lsub
    //   702: lstore 42
    //   704: lload 24
    //   706: lstore 28
    //   708: lload 42
    //   710: lconst_0
    //   711: lcmp
    //   712: ifeq +19 -> 731
    //   715: lload 24
    //   717: lstore 28
    //   719: lload 42
    //   721: lload 24
    //   723: lcmp
    //   724: ifge +7 -> 731
    //   727: lload 42
    //   729: lstore 28
    //   731: aload_3
    //   732: iload 17
    //   734: putfield 158	android/media/MediaCodec$BufferInfo:size	I
    //   737: aload_3
    //   738: lload 34
    //   740: lload 22
    //   742: ladd
    //   743: putfield 162	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   746: aload_3
    //   747: aload 4
    //   749: invokevirtual 165	android/media/MediaExtractor:getSampleFlags	()I
    //   752: putfield 168	android/media/MediaCodec$BufferInfo:flags	I
    //   755: aload_1
    //   756: iload 14
    //   758: aload_2
    //   759: aload_3
    //   760: invokevirtual 172	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   763: aload_3
    //   764: getfield 162	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   767: lstore 42
    //   769: lload 28
    //   771: lstore 44
    //   773: lload 18
    //   775: lstore 24
    //   777: lload 22
    //   779: lstore 28
    //   781: lload 44
    //   783: lstore 22
    //   785: lload 42
    //   787: lstore 18
    //   789: goto -447 -> 342
    //   792: aload_3
    //   793: iload 10
    //   795: putfield 158	android/media/MediaCodec$BufferInfo:size	I
    //   798: aload 5
    //   800: invokevirtual 146	android/media/MediaExtractor:getSampleTime	()J
    //   803: lstore 42
    //   805: iload 8
    //   807: istore 10
    //   809: iload 8
    //   811: ifeq +365 -> 1176
    //   814: iconst_0
    //   815: istore 8
    //   817: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   820: ifeq +39 -> 859
    //   823: ldc 8
    //   825: iconst_2
    //   826: new 36	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   833: ldc -82
    //   835: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: lload 36
    //   840: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   843: ldc -80
    //   845: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: lload 20
    //   850: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   853: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: iload 8
    //   861: istore 10
    //   863: iload 11
    //   865: iconst_1
    //   866: if_icmplt +310 -> 1176
    //   869: iload 8
    //   871: istore 10
    //   873: lload 42
    //   875: lconst_0
    //   876: lcmp
    //   877: ifne +299 -> 1176
    //   880: ldc2_w 127
    //   883: lstore 32
    //   885: lload 20
    //   887: lstore 30
    //   889: iconst_0
    //   890: istore 8
    //   892: lload 20
    //   894: lstore 26
    //   896: lload 30
    //   898: lstore 20
    //   900: lload 42
    //   902: lload 40
    //   904: lsub
    //   905: lstore 40
    //   907: lload 32
    //   909: lstore 30
    //   911: lload 40
    //   913: lconst_0
    //   914: lcmp
    //   915: ifeq +19 -> 934
    //   918: lload 32
    //   920: lstore 30
    //   922: lload 40
    //   924: lload 32
    //   926: lcmp
    //   927: ifge +7 -> 934
    //   930: lload 40
    //   932: lstore 30
    //   934: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   937: ifeq +39 -> 976
    //   940: ldc 8
    //   942: iconst_2
    //   943: new 36	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   950: ldc -78
    //   952: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: lload 42
    //   957: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   960: ldc -76
    //   962: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: lload 40
    //   967: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   970: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: iload 11
    //   978: iconst_1
    //   979: if_icmplt +182 -> 1161
    //   982: lload 40
    //   984: ldc2_w 181
    //   987: lload 26
    //   989: lmul
    //   990: lcmp
    //   991: ifle +167 -> 1158
    //   994: lload 20
    //   996: lload 40
    //   998: lload 26
    //   1000: lsub
    //   1001: lsub
    //   1002: lstore 20
    //   1004: lload 42
    //   1006: lload 20
    //   1008: ladd
    //   1009: lstore 40
    //   1011: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1014: ifeq +42 -> 1056
    //   1017: ldc 8
    //   1019: iconst_2
    //   1020: new 36	java/lang/StringBuilder
    //   1023: dup
    //   1024: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   1027: ldc -78
    //   1029: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: lload 40
    //   1034: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1037: ldc -72
    //   1039: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: lload 40
    //   1044: lload 38
    //   1046: lsub
    //   1047: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1056: lload 40
    //   1058: lstore 32
    //   1060: lload 40
    //   1062: lstore 38
    //   1064: aload_3
    //   1065: lload 38
    //   1067: lload 36
    //   1069: ladd
    //   1070: putfield 162	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   1073: aload_3
    //   1074: aload 5
    //   1076: invokevirtual 165	android/media/MediaExtractor:getSampleFlags	()I
    //   1079: putfield 168	android/media/MediaCodec$BufferInfo:flags	I
    //   1082: aload_1
    //   1083: iload 15
    //   1085: aload_2
    //   1086: aload_3
    //   1087: invokevirtual 172	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   1090: aload_3
    //   1091: getfield 162	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   1094: lstore 46
    //   1096: lload 32
    //   1098: lstore 40
    //   1100: lload 30
    //   1102: lstore 44
    //   1104: lload 26
    //   1106: lstore 32
    //   1108: lload 20
    //   1110: lstore 38
    //   1112: lload 42
    //   1114: lstore 30
    //   1116: lload 44
    //   1118: lstore 26
    //   1120: lload 46
    //   1122: lstore 20
    //   1124: goto -695 -> 429
    //   1127: aload 4
    //   1129: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   1132: aload 5
    //   1134: invokevirtual 102	android/media/MediaExtractor:release	()V
    //   1137: lload 26
    //   1139: lstore 28
    //   1141: lload 22
    //   1143: lstore 24
    //   1145: goto -619 -> 526
    //   1148: aload_1
    //   1149: invokevirtual 187	android/media/MediaMuxer:stop	()V
    //   1152: aload_1
    //   1153: invokevirtual 188	android/media/MediaMuxer:release	()V
    //   1156: iconst_0
    //   1157: ireturn
    //   1158: goto -154 -> 1004
    //   1161: lload 42
    //   1163: lstore 40
    //   1165: lload 38
    //   1167: lstore 32
    //   1169: lload 40
    //   1171: lstore 38
    //   1173: goto -109 -> 1064
    //   1176: lload 32
    //   1178: lstore 26
    //   1180: iload 10
    //   1182: istore 8
    //   1184: lload 20
    //   1186: lstore 32
    //   1188: lload 26
    //   1190: lstore 20
    //   1192: lload 30
    //   1194: lstore 26
    //   1196: goto -296 -> 900
    //   1199: lload 18
    //   1201: lstore 42
    //   1203: lload 24
    //   1205: lstore 18
    //   1207: lload 22
    //   1209: lstore 24
    //   1211: lload 42
    //   1213: lstore 22
    //   1215: goto -923 -> 292
    //   1218: lload 22
    //   1220: lstore 42
    //   1222: lload 24
    //   1224: lstore 22
    //   1226: lload 42
    //   1228: lstore 24
    //   1230: goto -865 -> 365
    //   1233: iload 10
    //   1235: istore 6
    //   1237: lload 18
    //   1239: lstore 22
    //   1241: lload 24
    //   1243: lstore 18
    //   1245: lload 22
    //   1247: lstore 24
    //   1249: goto -673 -> 576
    //   1252: lload 22
    //   1254: lstore 42
    //   1256: lload 24
    //   1258: lstore 22
    //   1260: lload 18
    //   1262: lstore 24
    //   1264: lload 42
    //   1266: lstore 18
    //   1268: goto -903 -> 365
    //   1271: iconst_1
    //   1272: istore 12
    //   1274: goto -1017 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1277	0	paramArrayList	java.util.ArrayList
    //   0	1277	1	paramString	String
    //   7	1079	2	localObject1	Object
    //   15	1076	3	localObject2	Object
    //   190	153	4	localMediaExtractor1	MediaExtractor
    //   511	617	4	localIOException	java.io.IOException
    //   199	934	5	localMediaExtractor2	MediaExtractor
    //   50	1186	6	i	int
    //   44	312	7	j	int
    //   266	917	8	k	int
    //   233	206	9	m	int
    //   383	851	10	n	int
    //   174	806	11	i1	int
    //   255	1018	12	i2	int
    //   230	136	13	i3	int
    //   104	653	14	i4	int
    //   116	968	15	i5	int
    //   149	32	16	i6	int
    //   320	413	17	i7	int
    //   166	1101	18	l1	long
    //   171	1020	20	l2	long
    //   158	1101	22	l3	long
    //   281	982	24	l4	long
    //   161	1034	26	l5	long
    //   284	856	28	l6	long
    //   275	918	30	l7	long
    //   278	909	32	l8	long
    //   152	587	34	l9	long
    //   155	913	36	l10	long
    //   272	900	38	l11	long
    //   269	901	40	l12	long
    //   329	936	42	l13	long
    //   407	710	44	l14	long
    //   399	722	46	l15	long
    //   454	39	48	l16	long
    // Exception table:
    //   from	to	target	type
    //   16	40	73	java/io/IOException
    //   84	94	499	java/io/IOException
    //   201	229	511	java/io/IOException
  }
  
  private static int b(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("HwMergeMp4", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("audio/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\HwMergeMp4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */