package cooperation.qqreader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QRPluginBooks
{
  public static final String a = "UTF-8";
  public static final String b = "/Tencent/ReaderZone/";
  public static final String c = "pluginBooks";
  public static final String d = "title";
  public static final String e = "lmcpushname";
  public static final String f = "author";
  public static final String g = "choose";
  private static final String h = "PluginBooks";
  private Context jdField_a_of_type_AndroidContentContext;
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  
  public QRPluginBooks(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_OrgJsonJSONArray = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = a(this.jdField_a_of_type_AndroidContentContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray(paramContext);
      return;
    }
    this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
  }
  
  /* Error */
  private String a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_1
    //   6: invokestatic 69	cooperation/qqreader/QRUtility:a	(Landroid/content/Context;)Ljava/lang/String;
    //   9: astore_1
    //   10: new 71	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 76	java/io/File:exists	()Z
    //   23: ifne +40 -> 63
    //   26: ldc 78
    //   28: astore_2
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 80	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 81	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: iconst_0
    //   42: ifeq +11 -> 53
    //   45: new 80	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 81	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   60: ldc 78
    //   62: areturn
    //   63: new 86	java/io/FileInputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_2
    //   72: new 91	java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial 92	java/io/ByteArrayOutputStream:<init>	()V
    //   79: astore_1
    //   80: sipush 4096
    //   83: newarray <illegal type>
    //   85: astore_3
    //   86: aload_2
    //   87: aload_3
    //   88: iconst_0
    //   89: sipush 4096
    //   92: invokevirtual 98	java/io/InputStream:read	([BII)I
    //   95: istore 5
    //   97: iload 5
    //   99: iconst_m1
    //   100: if_icmpeq +48 -> 148
    //   103: aload_1
    //   104: aload_3
    //   105: iconst_0
    //   106: iload 5
    //   108: invokevirtual 102	java/io/ByteArrayOutputStream:write	([BII)V
    //   111: goto -25 -> 86
    //   114: astore 4
    //   116: aload_1
    //   117: astore_3
    //   118: aload_2
    //   119: astore_1
    //   120: aload_3
    //   121: astore_2
    //   122: aload 4
    //   124: astore_3
    //   125: aload_3
    //   126: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 106	java/io/InputStream:close	()V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   145: ldc 78
    //   147: areturn
    //   148: new 109	java/lang/String
    //   151: dup
    //   152: aload_1
    //   153: invokevirtual 113	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   156: ldc 115
    //   158: invokespecial 118	java/lang/String:<init>	([BLjava/lang/String;)V
    //   161: astore_3
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 106	java/io/InputStream:close	()V
    //   170: aload_3
    //   171: astore_2
    //   172: aload_1
    //   173: ifnull -120 -> 53
    //   176: aload_1
    //   177: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   180: aload_3
    //   181: areturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   187: aload_3
    //   188: areturn
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   194: goto -49 -> 145
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_2
    //   200: aload_2
    //   201: ifnull +7 -> 208
    //   204: aload_2
    //   205: invokevirtual 106	java/io/InputStream:close	()V
    //   208: aload_3
    //   209: ifnull +7 -> 216
    //   212: aload_3
    //   213: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   223: goto -7 -> 216
    //   226: astore_1
    //   227: goto -27 -> 200
    //   230: astore 4
    //   232: aload_1
    //   233: astore_3
    //   234: aload 4
    //   236: astore_1
    //   237: goto -37 -> 200
    //   240: astore_3
    //   241: aload_1
    //   242: astore 4
    //   244: aload_3
    //   245: astore_1
    //   246: aload_2
    //   247: astore_3
    //   248: aload 4
    //   250: astore_2
    //   251: goto -51 -> 200
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_1
    //   257: aload 4
    //   259: astore_2
    //   260: goto -135 -> 125
    //   263: astore_3
    //   264: aload_2
    //   265: astore_1
    //   266: aload 4
    //   268: astore_2
    //   269: goto -144 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	QRPluginBooks
    //   0	272	1	paramContext	Context
    //   28	177	2	localObject1	Object
    //   218	29	2	localIOException	java.io.IOException
    //   250	19	2	localContext1	Context
    //   1	233	3	localObject2	Object
    //   240	5	3	localObject3	Object
    //   247	1	3	localObject4	Object
    //   254	1	3	localException1	Exception
    //   263	1	3	localException2	Exception
    //   3	1	4	localObject5	Object
    //   114	9	4	localException3	Exception
    //   230	5	4	localObject6	Object
    //   242	25	4	localContext2	Context
    //   95	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   33	41	55	java/io/IOException
    //   45	53	55	java/io/IOException
    //   80	86	114	java/lang/Exception
    //   86	97	114	java/lang/Exception
    //   103	111	114	java/lang/Exception
    //   148	162	114	java/lang/Exception
    //   166	170	182	java/io/IOException
    //   176	180	182	java/io/IOException
    //   133	137	189	java/io/IOException
    //   141	145	189	java/io/IOException
    //   10	26	197	finally
    //   63	72	197	finally
    //   204	208	218	java/io/IOException
    //   212	216	218	java/io/IOException
    //   72	80	226	finally
    //   80	86	230	finally
    //   86	97	230	finally
    //   103	111	230	finally
    //   148	162	230	finally
    //   125	129	240	finally
    //   10	26	254	java/lang/Exception
    //   63	72	254	java/lang/Exception
    //   72	80	263	java/lang/Exception
  }
  
  /* Error */
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_1
    //   4: ifnull +10 -> 14
    //   7: aload_1
    //   8: invokevirtual 123	java/lang/String:length	()I
    //   11: ifgt +9 -> 20
    //   14: iconst_0
    //   15: istore 6
    //   17: iload 6
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore_3
    //   25: new 71	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 46	cooperation/qqreader/QRPluginBooks:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   33: invokestatic 69	cooperation/qqreader/QRUtility:a	(Landroid/content/Context;)Ljava/lang/String;
    //   36: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 127	java/io/File:getParentFile	()Ljava/io/File;
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 76	java/io/File:exists	()Z
    //   51: ifne +9 -> 60
    //   54: aload 5
    //   56: invokevirtual 130	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: new 132	java/io/FileOutputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   68: astore_2
    //   69: aload_2
    //   70: aload_1
    //   71: invokevirtual 136	java/lang/String:getBytes	()[B
    //   74: invokevirtual 139	java/io/FileOutputStream:write	([B)V
    //   77: aload_2
    //   78: ifnull -61 -> 17
    //   81: aload_2
    //   82: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_1
    //   88: iconst_1
    //   89: ireturn
    //   90: astore_1
    //   91: aload_3
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_1
    //   104: aload 4
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 140	java/io/FileOutputStream:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: iconst_1
    //   119: ireturn
    //   120: astore_1
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: goto -17 -> 107
    //   127: astore_1
    //   128: aload_2
    //   129: astore_1
    //   130: goto -37 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	QRPluginBooks
    //   0	133	1	paramString	String
    //   39	90	2	localObject1	Object
    //   24	68	3	localObject2	Object
    //   21	84	4	localObject3	Object
    //   44	11	5	localFile	java.io.File
    //   1	17	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   81	85	87	java/io/IOException
    //   25	60	90	java/lang/Exception
    //   60	69	90	java/lang/Exception
    //   25	60	103	finally
    //   60	69	103	finally
    //   97	101	117	java/io/IOException
    //   111	115	120	java/io/IOException
    //   69	77	123	finally
    //   69	77	127	java/lang/Exception
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_a_of_type_OrgJsonJSONArray.length() == 0)) {
      return false;
    }
    return b(this.jdField_a_of_type_OrgJsonJSONArray.toString());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
        try
        {
          int j = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i).getInt("id");
          if (j == paramInt) {
            return true;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i += 1;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
      try
      {
        boolean bool = a(new JSONObject(paramString));
        return bool;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray.put(this.jdField_a_of_type_OrgJsonJSONArray.length(), paramJSONObject);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRPluginBooks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */