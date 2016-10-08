import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rih
  implements Runnable
{
  rih(rhz paramrhz, String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 43	android/os/Bundle
    //   3: dup
    //   4: invokespecial 44	android/os/Bundle:<init>	()V
    //   7: astore 6
    //   9: new 46	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 47	org/json/JSONArray:<init>	()V
    //   16: astore 7
    //   18: new 46	org/json/JSONArray
    //   21: dup
    //   22: aload_0
    //   23: getfield 18	rih:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokespecial 50	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore 8
    //   31: iconst_0
    //   32: istore 10
    //   34: iload 10
    //   36: aload 8
    //   38: invokevirtual 54	org/json/JSONArray:length	()I
    //   41: if_icmpge +270 -> 311
    //   44: aload 8
    //   46: iload 10
    //   48: invokevirtual 58	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   51: astore_1
    //   52: aload_1
    //   53: ldc 60
    //   55: invokevirtual 66	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 4
    //   60: aload_1
    //   61: ldc 68
    //   63: invokevirtual 72	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   66: istore 11
    //   68: aload_1
    //   69: ldc 74
    //   71: invokevirtual 66	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 9
    //   76: ldc 76
    //   78: astore 5
    //   80: new 78	java/io/File
    //   83: dup
    //   84: aload_0
    //   85: getfield 20	rih:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: iconst_1
    //   89: aload 4
    //   91: iconst_0
    //   92: invokevirtual 83	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   95: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 88	java/io/File:exists	()Z
    //   103: ifeq +361 -> 464
    //   106: aload_1
    //   107: invokevirtual 91	java/io/File:length	()J
    //   110: lstore 12
    //   112: lload 12
    //   114: ldc2_w 92
    //   117: lcmp
    //   118: ifge +323 -> 441
    //   121: lload 12
    //   123: l2i
    //   124: newarray <illegal type>
    //   126: astore_3
    //   127: new 95	java/io/FileInputStream
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: aload_2
    //   139: aload_3
    //   140: invokevirtual 102	java/io/FileInputStream:read	([B)I
    //   143: pop
    //   144: aload_2
    //   145: astore_1
    //   146: new 104	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   153: ldc 107
    //   155: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_3
    //   159: iconst_2
    //   160: invokestatic 117	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   163: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore_3
    //   170: aload_3
    //   171: astore_1
    //   172: aload_2
    //   173: ifnull +9 -> 182
    //   176: aload_2
    //   177: invokevirtual 124	java/io/FileInputStream:close	()V
    //   180: aload_3
    //   181: astore_1
    //   182: aload_1
    //   183: astore_2
    //   184: iload 11
    //   186: lookupswitch	default:+34->220, 0:+295->481, 1:+312->498, 3000:+329->515
    //   220: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +321 -> 544
    //   226: ldc -125
    //   228: iconst_2
    //   229: ldc -123
    //   231: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: goto +310 -> 544
    //   237: new 62	org/json/JSONObject
    //   240: dup
    //   241: invokespecial 138	org/json/JSONObject:<init>	()V
    //   244: astore_3
    //   245: aload_3
    //   246: ldc 60
    //   248: aload 4
    //   250: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   253: pop
    //   254: aload_3
    //   255: ldc -112
    //   257: aload_1
    //   258: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   261: pop
    //   262: aload_3
    //   263: ldc -110
    //   265: aload_2
    //   266: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   269: pop
    //   270: aload 7
    //   272: aload_3
    //   273: invokevirtual 149	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   276: pop
    //   277: iload 10
    //   279: iconst_1
    //   280: iadd
    //   281: istore 10
    //   283: goto -249 -> 34
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   291: aload_3
    //   292: astore_1
    //   293: goto -111 -> 182
    //   296: astore_1
    //   297: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +11 -> 311
    //   303: ldc -125
    //   305: iconst_2
    //   306: ldc -102
    //   308: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload 6
    //   313: ldc -100
    //   315: aload 7
    //   317: invokevirtual 157	org/json/JSONArray:toString	()Ljava/lang/String;
    //   320: invokevirtual 161	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload_0
    //   324: getfield 22	rih:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   327: ldc -93
    //   329: aload 6
    //   331: invokevirtual 167	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   334: aload_0
    //   335: getfield 24	rih:jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   338: aload_0
    //   339: getfield 22	rih:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   342: invokevirtual 172	com/tencent/mobileqq/emosm/web/MessengerService:a	(Landroid/os/Bundle;)V
    //   345: return
    //   346: astore_3
    //   347: aconst_null
    //   348: astore_2
    //   349: aload_2
    //   350: astore_1
    //   351: aload_3
    //   352: invokevirtual 173	java/io/FileNotFoundException:printStackTrace	()V
    //   355: aload 5
    //   357: astore_1
    //   358: aload_2
    //   359: ifnull -177 -> 182
    //   362: aload_2
    //   363: invokevirtual 124	java/io/FileInputStream:close	()V
    //   366: aload 5
    //   368: astore_1
    //   369: goto -187 -> 182
    //   372: astore_1
    //   373: aload_1
    //   374: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   377: aload 5
    //   379: astore_1
    //   380: goto -198 -> 182
    //   383: astore_3
    //   384: aconst_null
    //   385: astore_2
    //   386: aload_2
    //   387: astore_1
    //   388: aload_3
    //   389: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   392: aload 5
    //   394: astore_1
    //   395: aload_2
    //   396: ifnull -214 -> 182
    //   399: aload_2
    //   400: invokevirtual 124	java/io/FileInputStream:close	()V
    //   403: aload 5
    //   405: astore_1
    //   406: goto -224 -> 182
    //   409: astore_1
    //   410: aload_1
    //   411: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   414: aload 5
    //   416: astore_1
    //   417: goto -235 -> 182
    //   420: astore_2
    //   421: aconst_null
    //   422: astore_1
    //   423: aload_1
    //   424: ifnull +7 -> 431
    //   427: aload_1
    //   428: invokevirtual 124	java/io/FileInputStream:close	()V
    //   431: aload_2
    //   432: athrow
    //   433: astore_1
    //   434: aload_1
    //   435: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   438: goto -7 -> 431
    //   441: aload 5
    //   443: astore_1
    //   444: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq -265 -> 182
    //   450: ldc -125
    //   452: iconst_2
    //   453: ldc -81
    //   455: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload 5
    //   460: astore_1
    //   461: goto -279 -> 182
    //   464: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq +83 -> 550
    //   470: ldc -125
    //   472: iconst_2
    //   473: ldc -79
    //   475: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: goto +72 -> 550
    //   481: aload_0
    //   482: getfield 20	rih:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   485: aload 4
    //   487: aload 9
    //   489: iconst_0
    //   490: iconst_0
    //   491: invokestatic 182	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   494: astore_1
    //   495: goto -258 -> 237
    //   498: aload_0
    //   499: getfield 20	rih:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   502: aload 4
    //   504: aload 9
    //   506: iconst_1
    //   507: iconst_0
    //   508: invokestatic 182	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   511: astore_1
    //   512: goto -275 -> 237
    //   515: aload_0
    //   516: getfield 20	rih:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   519: aload 4
    //   521: aload 9
    //   523: iconst_2
    //   524: iconst_0
    //   525: invokestatic 182	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   528: astore_1
    //   529: goto -292 -> 237
    //   532: astore_2
    //   533: goto -110 -> 423
    //   536: astore_3
    //   537: goto -151 -> 386
    //   540: astore_3
    //   541: goto -192 -> 349
    //   544: aload 4
    //   546: astore_1
    //   547: goto -310 -> 237
    //   550: ldc 76
    //   552: astore_2
    //   553: goto -369 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	rih
    //   51	207	1	localObject1	Object
    //   286	2	1	localIOException1	java.io.IOException
    //   292	1	1	localObject2	Object
    //   296	1	1	localJSONException	org.json.JSONException
    //   350	19	1	localObject3	Object
    //   372	2	1	localIOException2	java.io.IOException
    //   379	27	1	localObject4	Object
    //   409	2	1	localIOException3	java.io.IOException
    //   416	12	1	localObject5	Object
    //   433	2	1	localIOException4	java.io.IOException
    //   443	104	1	localObject6	Object
    //   135	265	2	localObject7	Object
    //   420	12	2	localObject8	Object
    //   532	1	2	localObject9	Object
    //   552	1	2	str1	String
    //   126	166	3	localObject10	Object
    //   346	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   383	6	3	localIOException5	java.io.IOException
    //   536	1	3	localIOException6	java.io.IOException
    //   540	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   58	487	4	str2	String
    //   78	381	5	str3	String
    //   7	323	6	localBundle	Bundle
    //   16	300	7	localJSONArray1	org.json.JSONArray
    //   29	16	8	localJSONArray2	org.json.JSONArray
    //   74	448	9	str4	String
    //   32	250	10	i	int
    //   66	119	11	j	int
    //   110	12	12	l	long
    // Exception table:
    //   from	to	target	type
    //   176	180	286	java/io/IOException
    //   18	31	296	org/json/JSONException
    //   34	76	296	org/json/JSONException
    //   80	112	296	org/json/JSONException
    //   121	127	296	org/json/JSONException
    //   176	180	296	org/json/JSONException
    //   220	234	296	org/json/JSONException
    //   237	277	296	org/json/JSONException
    //   287	291	296	org/json/JSONException
    //   362	366	296	org/json/JSONException
    //   373	377	296	org/json/JSONException
    //   399	403	296	org/json/JSONException
    //   410	414	296	org/json/JSONException
    //   427	431	296	org/json/JSONException
    //   431	433	296	org/json/JSONException
    //   434	438	296	org/json/JSONException
    //   444	458	296	org/json/JSONException
    //   464	478	296	org/json/JSONException
    //   481	495	296	org/json/JSONException
    //   498	512	296	org/json/JSONException
    //   515	529	296	org/json/JSONException
    //   127	136	346	java/io/FileNotFoundException
    //   362	366	372	java/io/IOException
    //   127	136	383	java/io/IOException
    //   399	403	409	java/io/IOException
    //   127	136	420	finally
    //   427	431	433	java/io/IOException
    //   138	144	532	finally
    //   146	170	532	finally
    //   351	355	532	finally
    //   388	392	532	finally
    //   138	144	536	java/io/IOException
    //   146	170	536	java/io/IOException
    //   138	144	540	java/io/FileNotFoundException
    //   146	170	540	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */