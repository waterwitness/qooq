import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HexUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class gku
  extends gkt
{
  public Bitmap a;
  public byte[] a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int x;
  int y;
  
  gku(RandomWebProtocol paramRandomWebProtocol)
  {
    super(paramRandomWebProtocol);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.x = -1;
  }
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((1 == this.s) && (this.a != null)) {}
    try
    {
      if (this.a.has("ismask")) {
        this.x = this.a.getInt("ismask");
      }
      if (this.a.has("peer_enuin")) {
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentAvRandomRandomWebProtocol.a(this.a.getString("peer_enuin"));
      }
      if (this.a.has("peer_gender")) {
        this.y = this.a.getInt("peer_gender");
      }
      if (this.a.has("peer_ennick")) {
        this.c = HexUtil.a(this.a.getString("peer_ennick").trim());
      }
      if (this.a.has("ensessionname")) {
        this.d = HexUtil.a(this.a.getString("ensessionname")).trim();
      }
      if (this.a.has("vaskey")) {
        this.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ComTencentAvRandomRandomWebProtocol.a(this.a.getString("vaskey"));
      }
      if (this.a.has("headurl")) {
        this.e = this.a.getString("headurl");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    if ((this.t == 0) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.equals(this.e, "null"))) {
      this.jdField_b_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_b_of_type_JavaLangString, this.e);
    }
  }
  
  /* Error */
  void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 124	gkt:b	(Ljava/lang/String;)V
    //   5: iconst_1
    //   6: aload_0
    //   7: getfield 39	gkt:s	I
    //   10: if_icmpne +208 -> 218
    //   13: new 46	org/json/JSONObject
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc -128
    //   25: invokevirtual 50	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   28: ifeq +20 -> 48
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 20	gku:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   36: aload_1
    //   37: ldc -128
    //   39: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 64	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 66	gku:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   48: aload_1
    //   49: ldc -126
    //   51: invokevirtual 50	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: ifeq +20 -> 74
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 20	gku:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   62: aload_1
    //   63: ldc -126
    //   65: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual 92	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;)[B
    //   71: putfield 94	gku:jdField_a_of_type_ArrayOfByte	[B
    //   74: aload_1
    //   75: ldc -124
    //   77: invokevirtual 50	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   80: istore_3
    //   81: iload_3
    //   82: ifeq +16 -> 98
    //   85: aload_0
    //   86: aload_1
    //   87: ldc -124
    //   89: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokestatic 137	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: putfield 70	gku:y	I
    //   98: aload_1
    //   99: ldc -117
    //   101: invokevirtual 50	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   104: ifeq +19 -> 123
    //   107: aload_0
    //   108: aload_1
    //   109: ldc -117
    //   111: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: invokevirtual 78	java/lang/String:trim	()Ljava/lang/String;
    //   117: invokestatic 81	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 83	gku:c	Ljava/lang/String;
    //   123: aload_1
    //   124: ldc -115
    //   126: invokevirtual 50	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   129: ifeq +19 -> 148
    //   132: aload_0
    //   133: aload_1
    //   134: ldc -115
    //   136: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokestatic 81	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokevirtual 78	java/lang/String:trim	()Ljava/lang/String;
    //   145: putfield 87	gku:d	Ljava/lang/String;
    //   148: aload_1
    //   149: ldc 96
    //   151: invokevirtual 50	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   154: ifeq +13 -> 167
    //   157: aload_0
    //   158: aload_1
    //   159: ldc 96
    //   161: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: putfield 98	gku:e	Ljava/lang/String;
    //   167: aload_0
    //   168: getfield 101	gkt:t	I
    //   171: sipush 1000
    //   174: if_icmpne +44 -> 218
    //   177: aload_0
    //   178: getfield 98	gku:e	Ljava/lang/String;
    //   181: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +34 -> 218
    //   187: aload_0
    //   188: getfield 98	gku:e	Ljava/lang/String;
    //   191: ldc 109
    //   193: invokestatic 113	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   196: ifne +22 -> 218
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 20	gku:jdField_b_of_type_ComTencentAvRandomRandomWebProtocol	Lcom/tencent/av/random/RandomWebProtocol;
    //   204: aload_0
    //   205: getfield 66	gku:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   208: aload_0
    //   209: getfield 98	gku:e	Ljava/lang/String;
    //   212: invokevirtual 144	com/tencent/av/random/RandomWebProtocol:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   215: putfield 146	gku:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   218: return
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 120	org/json/JSONException:printStackTrace	()V
    //   224: goto -57 -> 167
    //   227: astore_2
    //   228: goto -130 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	gku
    //   0	231	1	paramString	String
    //   227	1	2	localNumberFormatException	NumberFormatException
    //   80	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	48	219	org/json/JSONException
    //   48	74	219	org/json/JSONException
    //   74	81	219	org/json/JSONException
    //   85	98	219	org/json/JSONException
    //   98	123	219	org/json/JSONException
    //   123	148	219	org/json/JSONException
    //   148	167	219	org/json/JSONException
    //   85	98	227	java/lang/NumberFormatException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */