import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class gkt
{
  static final int jdField_a_of_type_Int = 0;
  static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  static final int e = -100;
  static final int f = 0;
  static final int g = 1;
  static final int h = 2;
  static final int i = 4;
  static final int j = 5;
  static final int k = 6;
  static final int l = 7;
  static final int m = 8;
  static final int n = 9;
  static final int o = 10;
  static final int p = 11;
  static final int q = 12;
  static final int r = 13;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  int s;
  int t;
  int u;
  int v;
  public int w;
  
  gkt(RandomWebProtocol paramRandomWebProtocol)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.u = 7000;
    this.v = 1000;
    this.w = 0;
  }
  
  /* Error */
  void a(String paramString)
  {
    // Byte code:
    //   0: new 73	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 75	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: ldc 77
    //   10: invokevirtual 81	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 83
    //   17: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   20: ifeq +13 -> 33
    //   23: aload_0
    //   24: aload_1
    //   25: ldc 83
    //   27: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   30: putfield 93	gkt:s	I
    //   33: aload_1
    //   34: ldc 95
    //   36: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   39: ifeq +13 -> 52
    //   42: aload_0
    //   43: aload_1
    //   44: ldc 95
    //   46: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   49: putfield 97	gkt:t	I
    //   52: aload_1
    //   53: ldc 99
    //   55: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   58: ifeq +13 -> 71
    //   61: aload_0
    //   62: aload_1
    //   63: ldc 99
    //   65: invokevirtual 103	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: putfield 105	gkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: aload_1
    //   72: ldc 107
    //   74: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   77: ifeq +13 -> 90
    //   80: aload_0
    //   81: aload_1
    //   82: ldc 107
    //   84: invokevirtual 81	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   87: putfield 109	gkt:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   90: aload_1
    //   91: ldc 111
    //   93: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   96: ifeq +21 -> 117
    //   99: aload_1
    //   100: ldc 111
    //   102: invokevirtual 103	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_1
    //   106: aload_0
    //   107: aload_1
    //   108: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   111: invokevirtual 121	java/lang/Integer:intValue	()I
    //   114: putfield 65	gkt:w	I
    //   117: return
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 124	org/json/JSONException:printStackTrace	()V
    //   123: return
    //   124: astore_1
    //   125: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	gkt
    //   0	126	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   0	33	118	org/json/JSONException
    //   33	52	118	org/json/JSONException
    //   52	71	118	org/json/JSONException
    //   71	90	118	org/json/JSONException
    //   90	106	118	org/json/JSONException
    //   106	117	118	org/json/JSONException
    //   106	117	124	java/lang/NumberFormatException
  }
  
  /* Error */
  void b(String paramString)
  {
    // Byte code:
    //   0: new 73	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 75	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: ldc 126
    //   12: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   15: ifeq +13 -> 28
    //   18: aload_0
    //   19: aload_1
    //   20: ldc 126
    //   22: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   25: putfield 93	gkt:s	I
    //   28: aload_1
    //   29: ldc -128
    //   31: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   34: ifeq +13 -> 47
    //   37: aload_0
    //   38: aload_1
    //   39: ldc -128
    //   41: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   44: putfield 97	gkt:t	I
    //   47: aload_1
    //   48: ldc -126
    //   50: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   53: ifeq +13 -> 66
    //   56: aload_0
    //   57: aload_1
    //   58: ldc -126
    //   60: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   63: putfield 63	gkt:v	I
    //   66: aload_1
    //   67: ldc -124
    //   69: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   72: ifeq +17 -> 89
    //   75: aload_0
    //   76: aload_1
    //   77: ldc -124
    //   79: invokevirtual 91	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: sipush 1000
    //   85: iadd
    //   86: putfield 61	gkt:u	I
    //   89: aload_1
    //   90: ldc 111
    //   92: invokevirtual 87	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   95: ifeq +21 -> 116
    //   98: aload_1
    //   99: ldc 111
    //   101: invokevirtual 103	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_1
    //   105: aload_0
    //   106: aload_1
    //   107: invokestatic 117	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   110: invokevirtual 121	java/lang/Integer:intValue	()I
    //   113: putfield 65	gkt:w	I
    //   116: return
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 124	org/json/JSONException:printStackTrace	()V
    //   122: return
    //   123: astore_1
    //   124: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	gkt
    //   0	125	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   0	28	117	org/json/JSONException
    //   28	47	117	org/json/JSONException
    //   47	66	117	org/json/JSONException
    //   66	89	117	org/json/JSONException
    //   89	105	117	org/json/JSONException
    //   105	116	117	org/json/JSONException
    //   105	116	123	java/lang/NumberFormatException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */