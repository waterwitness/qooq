package oicq.wlogin_sdk.report;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import oicq.wlogin_sdk.tools.util;

public class report_t1
  extends report_t
{
  private static final long serialVersionUID = 1L;
  public String _app_n = new String("");
  public String _app_sig = new String("");
  public String _app_v = new String("");
  public String _btime = util.get_release_time();
  public String _bver = "6.3.1.1668";
  public String _device = new String("");
  public String _disp_name = new String("");
  public String _ksid = new String("");
  public TreeMap<Integer, report_t2> _lst = new TreeMap();
  public int _os = 2;
  public String _os_v = new String("");
  public String _sdk_v = new Integer(5).toString();
  
  public void add_t2(report_t2 paramreport_t2)
  {
    try
    {
      if (this._lst.size() >= 10) {
        this._lst.remove(Integer.valueOf(this._lst.size() - 1));
      }
      this._lst.put(Integer.valueOf(this._lst.size()), paramreport_t2);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void add_t3(report_t3 paramreport_t3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   6: invokevirtual 85	java/util/TreeMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifgt +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   21: aload_0
    //   22: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   25: invokevirtual 85	java/util/TreeMap:size	()I
    //   28: iconst_1
    //   29: isub
    //   30: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   39: aload_1
    //   40: invokevirtual 106	oicq/wlogin_sdk/report/report_t2:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   43: goto -29 -> 14
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	report_t1
    //   0	51	1	paramreport_t3	report_t3
    //   9	2	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	46	finally
    //   17	43	46	finally
  }
  
  public void attr_api(int paramInt)
  {
    try
    {
      add_t2(new report_t2(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void clear_t2()
  {
    try
    {
      Iterator localIterator = this._lst.keySet().iterator();
      while (localIterator.hasNext()) {
        ((report_t2)this._lst.get(localIterator.next())).clear_t3();
      }
      this._lst.clear();
    }
    finally {}
  }
  
  public void commit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    try
    {
      this._os_v = paramString1;
      this._app_v = paramString2;
      this._ksid = paramString4;
      this._app_n = paramString5;
      this._disp_name = paramString6;
      this._device = paramString7;
      this._app_sig = paramString8;
      this._btime = paramString9;
      this._bver = paramString10;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void commit_t2(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   6: invokevirtual 85	java/util/TreeMap:size	()I
    //   9: istore 6
    //   11: iload 6
    //   13: ifgt +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   23: aload_0
    //   24: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   27: invokevirtual 85	java/util/TreeMap:size	()I
    //   30: iconst_1
    //   31: isub
    //   32: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   41: lload_1
    //   42: aload_3
    //   43: iload 4
    //   45: iload 5
    //   47: invokevirtual 143	oicq/wlogin_sdk/report/report_t2:commit	(JLjava/lang/String;II)V
    //   50: getstatic 147	oicq/wlogin_sdk/tools/util:LCB	Loicq/wlogin_sdk/tools/LogCallBack;
    //   53: ifnull -37 -> 16
    //   56: getstatic 147	oicq/wlogin_sdk/tools/util:LCB	Loicq/wlogin_sdk/tools/LogCallBack;
    //   59: aload_0
    //   60: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   63: aload_0
    //   64: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   67: invokevirtual 85	java/util/TreeMap:size	()I
    //   70: iconst_1
    //   71: isub
    //   72: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   81: invokevirtual 151	oicq/wlogin_sdk/report/report_t2:toJasonObj	()Lorg/json/JSONObject;
    //   84: invokevirtual 157	oicq/wlogin_sdk/tools/LogCallBack:OnLog	(Lorg/json/JSONObject;)V
    //   87: goto -71 -> 16
    //   90: astore_3
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	report_t1
    //   0	95	1	paramLong	long
    //   0	95	3	paramString	String
    //   0	95	4	paramInt1	int
    //   0	95	5	paramInt2	int
    //   9	3	6	i	int
    // Exception table:
    //   from	to	target	type
    //   2	11	90	finally
    //   19	87	90	finally
  }
  
  /* Error */
  public org.json.JSONObject toJasonObj()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aconst_null
    //   6: astore_2
    //   7: new 161	org/json/JSONObject
    //   10: dup
    //   11: invokespecial 162	org/json/JSONObject:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc -92
    //   18: ldc -90
    //   20: iconst_1
    //   21: anewarray 168	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 30	oicq/wlogin_sdk/report/report_t1:_os	I
    //   30: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: aastore
    //   34: invokestatic 172	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_1
    //   42: ldc -79
    //   44: aload_0
    //   45: getfield 39	oicq/wlogin_sdk/report/report_t1:_os_v	Ljava/lang/String;
    //   48: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   51: pop
    //   52: aload_1
    //   53: ldc -77
    //   55: aload_0
    //   56: getfield 41	oicq/wlogin_sdk/report/report_t1:_app_v	Ljava/lang/String;
    //   59: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_1
    //   64: ldc -75
    //   66: aload_0
    //   67: getfield 52	oicq/wlogin_sdk/report/report_t1:_sdk_v	Ljava/lang/String;
    //   70: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_1
    //   75: ldc -73
    //   77: aload_0
    //   78: getfield 54	oicq/wlogin_sdk/report/report_t1:_ksid	Ljava/lang/String;
    //   81: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_1
    //   86: ldc -71
    //   88: aload_0
    //   89: getfield 56	oicq/wlogin_sdk/report/report_t1:_app_n	Ljava/lang/String;
    //   92: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: ldc -69
    //   99: aload_0
    //   100: getfield 58	oicq/wlogin_sdk/report/report_t1:_disp_name	Ljava/lang/String;
    //   103: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload_1
    //   108: ldc -67
    //   110: aload_0
    //   111: getfield 60	oicq/wlogin_sdk/report/report_t1:_device	Ljava/lang/String;
    //   114: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_1
    //   119: ldc -65
    //   121: aload_0
    //   122: getfield 62	oicq/wlogin_sdk/report/report_t1:_app_sig	Ljava/lang/String;
    //   125: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload_1
    //   130: ldc -63
    //   132: aload_0
    //   133: getfield 69	oicq/wlogin_sdk/report/report_t1:_btime	Ljava/lang/String;
    //   136: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_1
    //   141: ldc -61
    //   143: aload_0
    //   144: getfield 73	oicq/wlogin_sdk/report/report_t1:_bver	Ljava/lang/String;
    //   147: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: new 197	org/json/JSONArray
    //   154: dup
    //   155: invokespecial 198	org/json/JSONArray:<init>	()V
    //   158: astore_2
    //   159: aload_0
    //   160: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   163: invokevirtual 115	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   166: invokeinterface 121 1 0
    //   171: astore_3
    //   172: aload_3
    //   173: invokeinterface 127 1 0
    //   178: ifeq +38 -> 216
    //   181: aload_2
    //   182: iload 4
    //   184: aload_0
    //   185: getfield 78	oicq/wlogin_sdk/report/report_t1:_lst	Ljava/util/TreeMap;
    //   188: aload_3
    //   189: invokeinterface 131 1 0
    //   194: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   197: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   200: invokevirtual 151	oicq/wlogin_sdk/report/report_t2:toJasonObj	()Lorg/json/JSONObject;
    //   203: invokevirtual 201	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   206: pop
    //   207: iload 4
    //   209: iconst_1
    //   210: iadd
    //   211: istore 4
    //   213: goto -41 -> 172
    //   216: aload_1
    //   217: ldc -53
    //   219: aload_2
    //   220: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_1
    //   227: areturn
    //   228: astore_1
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_1
    //   232: athrow
    //   233: astore_1
    //   234: aload_2
    //   235: astore_1
    //   236: goto -12 -> 224
    //   239: astore_2
    //   240: goto -16 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	report_t1
    //   14	213	1	localJSONObject	org.json.JSONObject
    //   228	4	1	localObject	Object
    //   233	1	1	localException1	Exception
    //   235	1	1	localJSONArray1	org.json.JSONArray
    //   6	229	2	localJSONArray2	org.json.JSONArray
    //   239	1	2	localException2	Exception
    //   171	18	3	localIterator	Iterator
    //   1	211	4	i	int
    // Exception table:
    //   from	to	target	type
    //   7	15	228	finally
    //   15	172	228	finally
    //   172	207	228	finally
    //   216	224	228	finally
    //   7	15	233	java/lang/Exception
    //   15	172	239	java/lang/Exception
    //   172	207	239	java/lang/Exception
    //   216	224	239	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\report\report_t1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */