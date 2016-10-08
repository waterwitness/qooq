import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqreader.QRBridgeActivity;

public class yix
  implements Runnable
{
  public yix(QRBridgeActivity paramQRBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   9: getfield 31	cooperation/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokestatic 37	cooperation/qqreader/QRBridgeUtil:getSKey	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_3
    //   17: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +18 -> 38
    //   23: invokestatic 49	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 51
    //   31: iconst_4
    //   32: ldc 53
    //   34: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: new 59	java/net/URL
    //   41: dup
    //   42: new 61	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   49: ldc 64
    //   51: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 70
    //   60: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 77	java/net/URL:<init>	(Ljava/lang/String;)V
    //   69: invokevirtual 81	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   72: checkcast 83	java/net/HttpURLConnection
    //   75: astore_2
    //   76: aload_2
    //   77: sipush 10000
    //   80: invokevirtual 87	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   83: aload_2
    //   84: ldc 89
    //   86: new 61	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   93: ldc 91
    //   95: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   102: getfield 31	cooperation/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   108: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 97
    //   113: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   120: getfield 31	cooperation/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   126: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 99
    //   131: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokevirtual 103	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_2
    //   145: invokevirtual 107	java/net/HttpURLConnection:getResponseCode	()I
    //   148: sipush 200
    //   151: if_icmpne +281 -> 432
    //   154: new 109	java/io/BufferedReader
    //   157: dup
    //   158: new 111	java/io/InputStreamReader
    //   161: dup
    //   162: aload_2
    //   163: invokevirtual 115	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   166: invokespecial 118	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   169: invokespecial 121	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   172: astore_1
    //   173: new 123	java/lang/StringBuffer
    //   176: dup
    //   177: invokespecial 124	java/lang/StringBuffer:<init>	()V
    //   180: astore_3
    //   181: aload_1
    //   182: invokevirtual 127	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   185: astore 4
    //   187: aload 4
    //   189: ifnull +29 -> 218
    //   192: aload_3
    //   193: aload 4
    //   195: invokevirtual 130	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   198: pop
    //   199: goto -18 -> 181
    //   202: astore_3
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   209: aload_2
    //   210: ifnull -173 -> 37
    //   213: aload_2
    //   214: invokevirtual 136	java/net/HttpURLConnection:disconnect	()V
    //   217: return
    //   218: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +31 -> 252
    //   224: ldc 51
    //   226: iconst_2
    //   227: new 61	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   234: ldc -115
    //   236: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_3
    //   240: invokevirtual 142	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   243: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: new 144	org/json/JSONObject
    //   255: dup
    //   256: aload_3
    //   257: invokevirtual 142	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   260: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   263: astore_1
    //   264: aload_0
    //   265: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   268: aload_1
    //   269: ldc -109
    //   271: invokevirtual 151	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   274: putfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   277: aload_0
    //   278: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   281: getfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   284: ldc -100
    //   286: invokevirtual 160	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   289: istore 5
    //   291: iload 5
    //   293: ifne +12 -> 305
    //   296: aload_2
    //   297: ifnull -260 -> 37
    //   300: aload_2
    //   301: invokevirtual 136	java/net/HttpURLConnection:disconnect	()V
    //   304: return
    //   305: aload_0
    //   306: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   309: aload_0
    //   310: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   313: getfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   316: ldc -100
    //   318: invokevirtual 164	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   321: putfield 168	cooperation/qqreader/QRBridgeActivity:y	Ljava/lang/String;
    //   324: aload_0
    //   325: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   328: aload_0
    //   329: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   332: getfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   335: ldc -86
    //   337: invokevirtual 164	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   340: putfield 173	cooperation/qqreader/QRBridgeActivity:u	Ljava/lang/String;
    //   343: aload_0
    //   344: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   347: aload_0
    //   348: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   351: getfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   354: ldc -81
    //   356: invokevirtual 164	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: putfield 178	cooperation/qqreader/QRBridgeActivity:v	Ljava/lang/String;
    //   362: aload_0
    //   363: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   366: aload_0
    //   367: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   370: getfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   373: ldc -76
    //   375: invokevirtual 164	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: putfield 183	cooperation/qqreader/QRBridgeActivity:w	Ljava/lang/String;
    //   381: aload_0
    //   382: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   385: aload_0
    //   386: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   389: getfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   392: ldc -71
    //   394: invokevirtual 164	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   397: putfield 188	cooperation/qqreader/QRBridgeActivity:x	Ljava/lang/String;
    //   400: aload_0
    //   401: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   404: aload_0
    //   405: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   408: getfield 154	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   411: ldc -66
    //   413: invokevirtual 194	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   416: putfield 198	cooperation/qqreader/QRBridgeActivity:i	I
    //   419: aload_0
    //   420: getfield 12	yix:a	Lcooperation/qqreader/QRBridgeActivity;
    //   423: getfield 201	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   426: bipush 100
    //   428: invokevirtual 207	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   431: pop
    //   432: aload_2
    //   433: ifnull -396 -> 37
    //   436: aload_2
    //   437: invokevirtual 136	java/net/HttpURLConnection:disconnect	()V
    //   440: return
    //   441: astore_3
    //   442: aload_1
    //   443: astore_2
    //   444: aload_3
    //   445: astore_1
    //   446: aload_2
    //   447: ifnull +7 -> 454
    //   450: aload_2
    //   451: invokevirtual 136	java/net/HttpURLConnection:disconnect	()V
    //   454: aload_1
    //   455: athrow
    //   456: astore_1
    //   457: goto -11 -> 446
    //   460: astore_3
    //   461: aload 4
    //   463: astore_2
    //   464: goto -261 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	yix
    //   1	454	1	localObject1	Object
    //   456	1	1	localObject2	Object
    //   75	389	2	localObject3	Object
    //   15	178	3	localObject4	Object
    //   202	55	3	localException1	Exception
    //   441	4	3	localObject5	Object
    //   460	1	3	localException2	Exception
    //   3	459	4	str	String
    //   289	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   76	181	202	java/lang/Exception
    //   181	187	202	java/lang/Exception
    //   192	199	202	java/lang/Exception
    //   218	252	202	java/lang/Exception
    //   252	291	202	java/lang/Exception
    //   305	432	202	java/lang/Exception
    //   38	76	441	finally
    //   205	209	441	finally
    //   76	181	456	finally
    //   181	187	456	finally
    //   192	199	456	finally
    //   218	252	456	finally
    //   252	291	456	finally
    //   305	432	456	finally
    //   38	76	460	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */