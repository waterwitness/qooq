import android.graphics.Bitmap;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gkx
  extends gkt
{
  static final int A = 3;
  static final int B = 4;
  static final int x = 0;
  static final int y = 1;
  static final int z = 2;
  int C;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  
  gkx(RandomWebProtocol paramRandomWebProtocol)
  {
    super(paramRandomWebProtocol);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.C = 0;
    this.u = 5000;
    this.v = 900;
  }
  
  /* Error */
  void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 53	gkt:a	(Ljava/lang/String;)V
    //   5: iconst_3
    //   6: aload_0
    //   7: getfield 56	gkt:s	I
    //   10: if_icmpne +179 -> 189
    //   13: aload_0
    //   14: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   17: ifnull +172 -> 189
    //   20: aload_0
    //   21: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   24: ldc 61
    //   26: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   29: ifeq +16 -> 45
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   37: ldc 61
    //   39: invokevirtual 71	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   42: putfield 39	gkx:C	I
    //   45: aload_0
    //   46: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   49: ldc 73
    //   51: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: ifeq +22 -> 76
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   62: ldc 73
    //   64: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokevirtual 83	java/lang/String:trim	()Ljava/lang/String;
    //   70: invokestatic 87	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   73: putfield 89	gkx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   76: aload_0
    //   77: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   80: ldc 91
    //   82: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   85: ifeq +16 -> 101
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   93: ldc 91
    //   95: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: putfield 93	gkx:c	Ljava/lang/String;
    //   101: aload_0
    //   102: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   105: ldc 95
    //   107: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   110: ifeq +22 -> 132
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   118: ldc 95
    //   120: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 87	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   126: invokevirtual 83	java/lang/String:trim	()Ljava/lang/String;
    //   129: putfield 97	gkx:d	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   136: ldc 99
    //   138: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   141: ifeq +16 -> 157
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   149: ldc 99
    //   151: invokevirtual 103	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   154: putfield 105	gkx:jdField_a_of_type_Long	J
    //   157: aload_0
    //   158: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   161: ldc 107
    //   163: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   166: ifeq +23 -> 189
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   174: aload_0
    //   175: getfield 59	gkt:a	Lorg/json/JSONObject;
    //   178: ldc 107
    //   180: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokevirtual 110	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;)Ljava/lang/String;
    //   186: putfield 112	gkx:e	Ljava/lang/String;
    //   189: iconst_1
    //   190: aload_0
    //   191: getfield 39	gkx:C	I
    //   194: if_icmpeq +19 -> 213
    //   197: iconst_3
    //   198: aload_0
    //   199: getfield 39	gkx:C	I
    //   202: if_icmpeq +11 -> 213
    //   205: iconst_4
    //   206: aload_0
    //   207: getfield 39	gkx:C	I
    //   210: if_icmpne +144 -> 354
    //   213: aload_0
    //   214: getfield 105	gkx:jdField_a_of_type_Long	J
    //   217: invokestatic 116	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   220: astore_2
    //   221: aload_2
    //   222: astore_1
    //   223: aload_2
    //   224: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifeq +14 -> 241
    //   230: aload_0
    //   231: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   234: getfield 125	com/tencent/av/random/RandomWebProtocol:a	Lcom/tencent/av/app/VideoAppInterface;
    //   237: invokevirtual 130	com/tencent/av/app/VideoAppInterface:getAccount	()Ljava/lang/String;
    //   240: astore_1
    //   241: iconst_2
    //   242: aload_0
    //   243: getfield 39	gkx:C	I
    //   246: if_icmpne +8 -> 254
    //   249: aload_0
    //   250: getfield 112	gkx:e	Ljava/lang/String;
    //   253: astore_1
    //   254: aload_1
    //   255: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +32 -> 290
    //   261: aload_0
    //   262: getfield 89	gkx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   265: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: ifne +22 -> 290
    //   271: aload_0
    //   272: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   275: getfield 125	com/tencent/av/random/RandomWebProtocol:a	Lcom/tencent/av/app/VideoAppInterface;
    //   278: invokevirtual 133	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   281: aload_1
    //   282: aload_0
    //   283: getfield 89	gkx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   286: iconst_1
    //   287: invokevirtual 138	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   290: aload_0
    //   291: getfield 93	gkx:c	Ljava/lang/String;
    //   294: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne +40 -> 337
    //   300: aload_0
    //   301: getfield 93	gkx:c	Ljava/lang/String;
    //   304: ldc -116
    //   306: invokestatic 144	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   309: ifne +28 -> 337
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   317: aload_1
    //   318: aload_0
    //   319: getfield 93	gkx:c	Ljava/lang/String;
    //   322: invokevirtual 147	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   325: putfield 149	gkx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   328: return
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 153	org/json/JSONException:printStackTrace	()V
    //   334: goto -145 -> 189
    //   337: aload_0
    //   338: aconst_null
    //   339: putfield 149	gkx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   342: return
    //   343: astore_1
    //   344: aload_1
    //   345: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   348: aload_0
    //   349: aconst_null
    //   350: putfield 149	gkx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   353: return
    //   354: aconst_null
    //   355: astore_1
    //   356: goto -115 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	gkx
    //   0	359	1	paramString	String
    //   220	4	2	str	String
    // Exception table:
    //   from	to	target	type
    //   20	45	329	org/json/JSONException
    //   45	76	329	org/json/JSONException
    //   76	101	329	org/json/JSONException
    //   101	132	329	org/json/JSONException
    //   132	157	329	org/json/JSONException
    //   157	189	329	org/json/JSONException
    //   189	213	343	java/lang/Exception
    //   213	221	343	java/lang/Exception
    //   223	241	343	java/lang/Exception
    //   241	254	343	java/lang/Exception
    //   254	290	343	java/lang/Exception
    //   290	328	343	java/lang/Exception
    //   337	342	343	java/lang/Exception
  }
  
  /* Error */
  void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 156	gkt:b	(Ljava/lang/String;)V
    //   5: iconst_3
    //   6: aload_0
    //   7: getfield 56	gkt:s	I
    //   10: if_icmpne +286 -> 296
    //   13: new 63	org/json/JSONObject
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 158	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc -96
    //   25: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   28: ifeq +13 -> 41
    //   31: aload_0
    //   32: aload_1
    //   33: ldc -96
    //   35: invokevirtual 71	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   38: putfield 39	gkx:C	I
    //   41: aload_1
    //   42: ldc -94
    //   44: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   47: ifeq +37 -> 84
    //   50: aload_1
    //   51: ldc -94
    //   53: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: ldc -92
    //   58: invokevirtual 168	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   61: astore_2
    //   62: aload_2
    //   63: arraylength
    //   64: ifle +20 -> 84
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   72: aload_2
    //   73: iconst_0
    //   74: aaload
    //   75: invokevirtual 83	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokevirtual 110	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 112	gkx:e	Ljava/lang/String;
    //   84: aload_1
    //   85: ldc -86
    //   87: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   90: ifeq +30 -> 120
    //   93: aload_1
    //   94: ldc -86
    //   96: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: ldc -84
    //   101: invokevirtual 168	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   104: astore_2
    //   105: aload_2
    //   106: arraylength
    //   107: ifle +13 -> 120
    //   110: aload_0
    //   111: aload_2
    //   112: iconst_0
    //   113: aaload
    //   114: invokevirtual 83	java/lang/String:trim	()Ljava/lang/String;
    //   117: putfield 93	gkx:c	Ljava/lang/String;
    //   120: aload_1
    //   121: ldc -82
    //   123: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   126: ifeq +33 -> 159
    //   129: aload_1
    //   130: ldc -82
    //   132: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: ldc -84
    //   137: invokevirtual 168	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   140: astore_2
    //   141: aload_2
    //   142: arraylength
    //   143: ifle +16 -> 159
    //   146: aload_0
    //   147: aload_2
    //   148: iconst_0
    //   149: aaload
    //   150: invokevirtual 83	java/lang/String:trim	()Ljava/lang/String;
    //   153: invokestatic 87	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   156: putfield 89	gkx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   159: aload_1
    //   160: ldc -80
    //   162: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   165: ifeq +19 -> 184
    //   168: aload_0
    //   169: aload_1
    //   170: ldc -80
    //   172: invokevirtual 77	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: invokevirtual 83	java/lang/String:trim	()Ljava/lang/String;
    //   178: invokestatic 87	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   181: putfield 97	gkx:d	Ljava/lang/String;
    //   184: aload_0
    //   185: getfield 112	gkx:e	Ljava/lang/String;
    //   188: ifnonnull +25 -> 213
    //   191: aload_0
    //   192: getfield 39	gkx:C	I
    //   195: iconst_1
    //   196: if_icmpne +17 -> 213
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   204: getfield 125	com/tencent/av/random/RandomWebProtocol:a	Lcom/tencent/av/app/VideoAppInterface;
    //   207: invokevirtual 130	com/tencent/av/app/VideoAppInterface:getAccount	()Ljava/lang/String;
    //   210: putfield 112	gkx:e	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 112	gkx:e	Ljava/lang/String;
    //   217: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +35 -> 255
    //   223: aload_0
    //   224: getfield 89	gkx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   227: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifne +25 -> 255
    //   233: aload_0
    //   234: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   237: getfield 125	com/tencent/av/random/RandomWebProtocol:a	Lcom/tencent/av/app/VideoAppInterface;
    //   240: invokevirtual 133	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   243: aload_0
    //   244: getfield 112	gkx:e	Ljava/lang/String;
    //   247: aload_0
    //   248: getfield 89	gkx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   251: iconst_1
    //   252: invokevirtual 138	com/tencent/av/VideoController:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   255: aload_0
    //   256: getfield 93	gkx:c	Ljava/lang/String;
    //   259: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifne +43 -> 305
    //   265: aload_0
    //   266: getfield 93	gkx:c	Ljava/lang/String;
    //   269: ldc -116
    //   271: invokestatic 144	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   274: ifne +31 -> 305
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 29	gkx:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   282: aload_0
    //   283: getfield 112	gkx:e	Ljava/lang/String;
    //   286: aload_0
    //   287: getfield 93	gkx:c	Ljava/lang/String;
    //   290: invokevirtual 147	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   293: putfield 149	gkx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   296: return
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 153	org/json/JSONException:printStackTrace	()V
    //   302: goto -118 -> 184
    //   305: aload_0
    //   306: aconst_null
    //   307: putfield 149	gkx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   310: return
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 149	gkx:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   321: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	gkx
    //   0	322	1	paramString	String
    //   61	87	2	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   13	41	297	org/json/JSONException
    //   41	84	297	org/json/JSONException
    //   84	120	297	org/json/JSONException
    //   120	159	297	org/json/JSONException
    //   159	184	297	org/json/JSONException
    //   184	213	311	java/lang/Exception
    //   213	255	311	java/lang/Exception
    //   255	296	311	java/lang/Exception
    //   305	310	311	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */