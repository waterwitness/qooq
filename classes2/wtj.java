import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.smtt.sdk.WebView;

public class wtj
  implements Runnable
{
  public wtj(OpenJsBridge paramOpenJsBridge, String paramString, WebView paramWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 16	wtj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 42
    //   16: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: ldc 48
    //   24: invokevirtual 54	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   27: astore_3
    //   28: new 56	java/util/ArrayList
    //   31: dup
    //   32: aload_3
    //   33: invokestatic 62	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   36: invokespecial 65	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 69	java/util/ArrayList:size	()I
    //   44: iconst_3
    //   45: if_icmpge +4 -> 49
    //   48: return
    //   49: aload_2
    //   50: iconst_2
    //   51: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   54: checkcast 50	java/lang/String
    //   57: astore 5
    //   59: ldc 75
    //   61: astore_1
    //   62: aload_2
    //   63: invokevirtual 69	java/util/ArrayList:size	()I
    //   66: iconst_5
    //   67: if_icmplt -19 -> 48
    //   70: aload_2
    //   71: invokevirtual 69	java/util/ArrayList:size	()I
    //   74: iconst_5
    //   75: if_icmpne +234 -> 309
    //   78: aload_3
    //   79: iconst_3
    //   80: aaload
    //   81: ldc 77
    //   83: invokevirtual 54	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   86: astore_2
    //   87: aload_2
    //   88: arraylength
    //   89: iconst_1
    //   90: if_icmple +7 -> 97
    //   93: aload_2
    //   94: iconst_1
    //   95: aaload
    //   96: astore_1
    //   97: aload_2
    //   98: iconst_0
    //   99: aaload
    //   100: ldc 79
    //   102: invokevirtual 54	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   105: astore 4
    //   107: aload 4
    //   109: arraylength
    //   110: iconst_1
    //   111: if_icmple +79 -> 190
    //   114: aload 4
    //   116: iconst_1
    //   117: aaload
    //   118: ldc 81
    //   120: invokevirtual 54	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   123: astore_3
    //   124: aload_3
    //   125: arraylength
    //   126: istore 8
    //   128: iconst_0
    //   129: istore 7
    //   131: aload_3
    //   132: astore_2
    //   133: iload 7
    //   135: iload 8
    //   137: if_icmpge +58 -> 195
    //   140: aload_3
    //   141: iload 7
    //   143: aaload
    //   144: bipush 61
    //   146: invokevirtual 85	java/lang/String:indexOf	(I)I
    //   149: istore 9
    //   151: iload 9
    //   153: iconst_m1
    //   154: if_icmpeq +27 -> 181
    //   157: aload_3
    //   158: iload 7
    //   160: aload_3
    //   161: iload 7
    //   163: aaload
    //   164: iload 9
    //   166: iconst_1
    //   167: iadd
    //   168: invokevirtual 89	java/lang/String:substring	(I)Ljava/lang/String;
    //   171: aastore
    //   172: iload 7
    //   174: iconst_1
    //   175: iadd
    //   176: istore 7
    //   178: goto -47 -> 131
    //   181: aload_3
    //   182: iload 7
    //   184: ldc 75
    //   186: aastore
    //   187: goto -15 -> 172
    //   190: iconst_0
    //   191: anewarray 50	java/lang/String
    //   194: astore_2
    //   195: new 56	java/util/ArrayList
    //   198: dup
    //   199: invokespecial 90	java/util/ArrayList:<init>	()V
    //   202: astore_3
    //   203: aload_2
    //   204: arraylength
    //   205: istore 8
    //   207: iconst_0
    //   208: istore 7
    //   210: iload 7
    //   212: iload 8
    //   214: if_icmpge +23 -> 237
    //   217: aload_3
    //   218: aload_2
    //   219: iload 7
    //   221: aaload
    //   222: invokeinterface 96 2 0
    //   227: pop
    //   228: iload 7
    //   230: iconst_1
    //   231: iadd
    //   232: istore 7
    //   234: goto -24 -> 210
    //   237: aload 4
    //   239: iconst_0
    //   240: aaload
    //   241: astore 4
    //   243: aload_3
    //   244: astore_2
    //   245: aload_1
    //   246: astore_3
    //   247: aload_3
    //   248: invokestatic 102	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   251: lstore 10
    //   253: getstatic 107	com/tencent/open/appcommon/js/AsyncMethodMap:a	Ljava/util/ArrayList;
    //   256: aload 4
    //   258: invokevirtual 110	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   261: ifeq +11 -> 272
    //   264: aload_2
    //   265: aload_3
    //   266: invokeinterface 96 2 0
    //   271: pop
    //   272: aload_0
    //   273: getfield 18	wtj:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   276: ifnull -228 -> 48
    //   279: aload_0
    //   280: getfield 14	wtj:jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge	Lcom/tencent/open/appcommon/js/OpenJsBridge;
    //   283: aload 5
    //   285: aload 4
    //   287: aload_2
    //   288: new 112	com/tencent/open/appcommon/js/OpenJsBridge$OpenJsBridgeListener
    //   291: dup
    //   292: aload_0
    //   293: getfield 18	wtj:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   296: lload 10
    //   298: aload_0
    //   299: getfield 16	wtj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   302: invokespecial 115	com/tencent/open/appcommon/js/OpenJsBridge$OpenJsBridgeListener:<init>	(Lcom/tencent/smtt/sdk/WebView;JLjava/lang/String;)V
    //   305: invokevirtual 120	com/tencent/open/appcommon/js/OpenJsBridge:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/jsbridge/JsBridge$JsBridgeListener;)V
    //   308: return
    //   309: aload_2
    //   310: iconst_3
    //   311: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   314: checkcast 50	java/lang/String
    //   317: astore_1
    //   318: aload_2
    //   319: iconst_4
    //   320: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   323: checkcast 50	java/lang/String
    //   326: astore_3
    //   327: aload_1
    //   328: invokevirtual 123	java/lang/String:trim	()Ljava/lang/String;
    //   331: ldc 125
    //   333: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   336: ifeq +157 -> 493
    //   339: aload_2
    //   340: iconst_5
    //   341: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   344: checkcast 50	java/lang/String
    //   347: astore 4
    //   349: aload_2
    //   350: bipush 6
    //   352: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   355: checkcast 50	java/lang/String
    //   358: astore 6
    //   360: aload_2
    //   361: bipush 7
    //   363: invokevirtual 73	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   366: checkcast 50	java/lang/String
    //   369: astore_2
    //   370: aload_3
    //   371: invokestatic 102	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   374: lstore 10
    //   376: aload 6
    //   378: invokestatic 102	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   381: lstore 12
    //   383: aload_2
    //   384: invokestatic 134	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   387: istore 7
    //   389: aload_0
    //   390: getfield 14	wtj:jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge	Lcom/tencent/open/appcommon/js/OpenJsBridge;
    //   393: getfield 138	com/tencent/open/appcommon/js/OpenJsBridge:b	Ljava/util/HashMap;
    //   396: aload 5
    //   398: invokevirtual 143	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   401: checkcast 145	com/tencent/mobileqq/jsbridge/JsBridge$JsHandler
    //   404: astore_2
    //   405: aload_2
    //   406: ifnull +43 -> 449
    //   409: aload_2
    //   410: instanceof 147
    //   413: ifeq +36 -> 449
    //   416: aload_2
    //   417: checkcast 147	com/tencent/open/appcommon/js/BaseInterface
    //   420: aload_0
    //   421: getfield 18	wtj:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   424: aload_0
    //   425: getfield 14	wtj:jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge	Lcom/tencent/open/appcommon/js/OpenJsBridge;
    //   428: getfield 138	com/tencent/open/appcommon/js/OpenJsBridge:b	Ljava/util/HashMap;
    //   431: lload 10
    //   433: aload 4
    //   435: lload 12
    //   437: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   440: invokevirtual 155	java/lang/Long:longValue	()J
    //   443: iload 7
    //   445: invokevirtual 158	com/tencent/open/appcommon/js/BaseInterface:callBatch	(Lcom/tencent/smtt/sdk/WebView;Ljava/util/HashMap;JLjava/lang/String;JI)V
    //   448: return
    //   449: aload_0
    //   450: getfield 18	wtj:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   453: new 35	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   460: ldc -96
    //   462: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc -94
    //   471: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: lload 10
    //   476: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   479: ldc -89
    //   481: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokevirtual 173	com/tencent/smtt/sdk/WebView:loadUrl	(Ljava/lang/String;)V
    //   490: return
    //   491: astore_1
    //   492: return
    //   493: aload_2
    //   494: iconst_5
    //   495: aload_2
    //   496: invokevirtual 69	java/util/ArrayList:size	()I
    //   499: iconst_1
    //   500: isub
    //   501: invokevirtual 177	java/util/ArrayList:subList	(II)Ljava/util/List;
    //   504: astore_2
    //   505: aload_1
    //   506: astore 4
    //   508: goto -261 -> 247
    //   511: astore_1
    //   512: return
    //   513: astore_1
    //   514: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	515	0	this	wtj
    //   61	405	1	str1	String
    //   491	15	1	localException1	Exception
    //   511	1	1	localException2	Exception
    //   513	1	1	localNumberFormatException	NumberFormatException
    //   39	466	2	localObject1	Object
    //   27	344	3	localObject2	Object
    //   105	402	4	localObject3	Object
    //   57	340	5	str2	String
    //   358	19	6	str3	String
    //   129	315	7	i	int
    //   126	89	8	j	int
    //   149	19	9	k	int
    //   251	224	10	l1	long
    //   381	55	12	l2	long
    // Exception table:
    //   from	to	target	type
    //   449	490	491	java/lang/Exception
    //   247	253	511	java/lang/Exception
    //   370	389	513	java/lang/NumberFormatException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */