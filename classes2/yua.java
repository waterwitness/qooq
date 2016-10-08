import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.util.HashMap;

public class yua
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public yua(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramHashMap.clone());
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	yua:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   4: getfield 43	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   7: invokevirtual 48	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   10: astore_2
    //   11: aload_2
    //   12: iconst_2
    //   13: invokevirtual 54	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   16: checkcast 56	mqq/manager/TicketManager
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 60	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   24: astore 5
    //   26: aload_1
    //   27: aload 5
    //   29: invokeinterface 64 2 0
    //   34: astore 6
    //   36: aconst_null
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_2
    //   40: aload 6
    //   42: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +328 -> 373
    //   48: aload_0
    //   49: getfield 33	yua:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: invokevirtual 74	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   55: invokeinterface 80 1 0
    //   60: astore 7
    //   62: iconst_0
    //   63: istore 8
    //   65: aload 7
    //   67: invokeinterface 86 1 0
    //   72: ifeq +313 -> 385
    //   75: aload 7
    //   77: invokeinterface 89 1 0
    //   82: checkcast 91	java/util/Map$Entry
    //   85: astore_3
    //   86: aload_3
    //   87: invokeinterface 94 1 0
    //   92: checkcast 96	java/lang/Integer
    //   95: invokevirtual 100	java/lang/Integer:intValue	()I
    //   98: istore 9
    //   100: aload_3
    //   101: invokeinterface 103 1 0
    //   106: checkcast 105	java/lang/String
    //   109: astore 4
    //   111: aload_1
    //   112: astore_3
    //   113: aload 4
    //   115: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +235 -> 353
    //   121: aload_0
    //   122: getfield 25	yua:jdField_a_of_type_Int	I
    //   125: iconst_1
    //   126: if_icmpne +171 -> 297
    //   129: ldc 107
    //   131: aload 4
    //   133: aload 5
    //   135: aload 6
    //   137: ldc2_w 108
    //   140: invokestatic 114	cooperation/troop_homework/TroopHomeworkHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   143: astore 4
    //   145: aload_1
    //   146: astore_3
    //   147: aload 4
    //   149: ifnull +204 -> 353
    //   152: new 116	org/json/JSONObject
    //   155: dup
    //   156: aload 4
    //   158: invokespecial 119	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   161: astore_3
    //   162: aload_3
    //   163: ldc 121
    //   165: iconst_m1
    //   166: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   169: ifne +227 -> 396
    //   172: aload_3
    //   173: ldc 127
    //   175: invokevirtual 131	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +214 -> 396
    //   185: aload 4
    //   187: ldc -123
    //   189: invokevirtual 136	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_3
    //   193: aload_0
    //   194: getfield 25	yua:jdField_a_of_type_Int	I
    //   197: istore 10
    //   199: iload 10
    //   201: ifne +115 -> 316
    //   204: bipush 11
    //   206: istore 8
    //   208: aload_2
    //   209: astore_1
    //   210: aload_3
    //   211: astore_2
    //   212: aload_2
    //   213: astore_3
    //   214: aload_1
    //   215: astore_2
    //   216: aload_3
    //   217: astore_1
    //   218: aload_0
    //   219: getfield 14	yua:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   222: iload 9
    //   224: aload_0
    //   225: getfield 25	yua:jdField_a_of_type_Int	I
    //   228: ldc -118
    //   230: aload_1
    //   231: iload 8
    //   233: invokevirtual 141	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(IILjava/lang/String;Ljava/lang/String;I)Lorg/json/JSONObject;
    //   236: astore_3
    //   237: aload_0
    //   238: getfield 25	yua:jdField_a_of_type_Int	I
    //   241: iconst_1
    //   242: if_icmpne +11 -> 253
    //   245: aload_3
    //   246: ldc -113
    //   248: aload_2
    //   249: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload_0
    //   254: getfield 14	yua:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   257: aload_0
    //   258: getfield 14	yua:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   261: getfield 151	cooperation/troop_homework/jsp/TroopHWJsPlugin:f	Ljava/lang/String;
    //   264: iconst_1
    //   265: anewarray 105	java/lang/String
    //   268: dup
    //   269: iconst_0
    //   270: aload_3
    //   271: invokevirtual 154	org/json/JSONObject:toString	()Ljava/lang/String;
    //   274: aastore
    //   275: invokevirtual 158	cooperation/troop_homework/jsp/TroopHWJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   278: aload_1
    //   279: ifnonnull +89 -> 368
    //   282: aload_0
    //   283: getfield 14	yua:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   286: invokestatic 161	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;)Landroid/os/Handler;
    //   289: iconst_0
    //   290: invokevirtual 167	android/os/Handler:sendEmptyMessage	(I)Z
    //   293: pop
    //   294: goto -229 -> 65
    //   297: ldc -87
    //   299: aload 4
    //   301: aload 5
    //   303: aload 6
    //   305: ldc2_w 108
    //   308: invokestatic 114	cooperation/troop_homework/TroopHomeworkHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   311: astore 4
    //   313: goto -168 -> 145
    //   316: aload 4
    //   318: ldc -113
    //   320: invokevirtual 173	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   323: astore_1
    //   324: aload_1
    //   325: ifnull +13 -> 338
    //   328: aload_1
    //   329: invokevirtual 176	org/json/JSONArray:toString	()Ljava/lang/String;
    //   332: astore_1
    //   333: aload_3
    //   334: astore_2
    //   335: goto -123 -> 212
    //   338: aload_3
    //   339: astore_2
    //   340: ldc -78
    //   342: astore_1
    //   343: goto -131 -> 212
    //   346: astore_3
    //   347: aload_3
    //   348: invokevirtual 181	org/json/JSONException:printStackTrace	()V
    //   351: aload_1
    //   352: astore_3
    //   353: aload_3
    //   354: astore_1
    //   355: goto -137 -> 218
    //   358: astore 4
    //   360: aload 4
    //   362: invokevirtual 181	org/json/JSONException:printStackTrace	()V
    //   365: goto -112 -> 253
    //   368: aconst_null
    //   369: astore_1
    //   370: goto -305 -> 65
    //   373: aload_0
    //   374: getfield 14	yua:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   377: invokestatic 161	cooperation/troop_homework/jsp/TroopHWJsPlugin:a	(Lcooperation/troop_homework/jsp/TroopHWJsPlugin;)Landroid/os/Handler;
    //   380: iconst_0
    //   381: invokevirtual 167	android/os/Handler:sendEmptyMessage	(I)Z
    //   384: pop
    //   385: return
    //   386: astore 4
    //   388: aload_3
    //   389: astore_1
    //   390: aload 4
    //   392: astore_3
    //   393: goto -46 -> 347
    //   396: aload_1
    //   397: astore_3
    //   398: aload_2
    //   399: astore_1
    //   400: aload_3
    //   401: astore_2
    //   402: goto -190 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	yua
    //   19	381	1	localObject1	Object
    //   10	392	2	localObject2	Object
    //   85	254	3	localObject3	Object
    //   346	2	3	localJSONException1	org.json.JSONException
    //   352	49	3	localObject4	Object
    //   109	208	4	localObject5	Object
    //   358	3	4	localJSONException2	org.json.JSONException
    //   386	5	4	localJSONException3	org.json.JSONException
    //   24	278	5	str1	String
    //   34	270	6	str2	String
    //   60	16	7	localIterator	java.util.Iterator
    //   63	169	8	i	int
    //   98	125	9	j	int
    //   197	3	10	k	int
    // Exception table:
    //   from	to	target	type
    //   152	180	346	org/json/JSONException
    //   185	193	346	org/json/JSONException
    //   245	253	358	org/json/JSONException
    //   193	199	386	org/json/JSONException
    //   316	324	386	org/json/JSONException
    //   328	333	386	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */