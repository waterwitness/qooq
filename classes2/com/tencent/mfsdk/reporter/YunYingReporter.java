package com.tencent.mfsdk.reporter;

import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kgg;
import kgh;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class YunYingReporter
  implements IReporter
{
  private static final int jdField_a_of_type_Int = 1048576;
  private static final String jdField_a_of_type_JavaLangString = YunYingReporter.class.getSimpleName();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public YunYingReporter()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.a();
    }
  }
  
  /* Error */
  private String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 48	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: new 51	java/io/BufferedReader
    //   13: dup
    //   14: new 53	java/io/InputStreamReader
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 56	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 59	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +44 -> 76
    //   35: aload_3
    //   36: new 48	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   43: aload_2
    //   44: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 68
    //   49: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -33 -> 26
    //   62: astore_2
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 74	java/io/BufferedReader:close	()V
    //   71: aload_3
    //   72: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: areturn
    //   76: aload_1
    //   77: ifnull -6 -> 71
    //   80: aload_1
    //   81: invokevirtual 74	java/io/BufferedReader:close	()V
    //   84: goto -13 -> 71
    //   87: astore_1
    //   88: goto -17 -> 71
    //   91: astore_1
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 74	java/io/BufferedReader:close	()V
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: goto -32 -> 71
    //   106: astore_2
    //   107: goto -7 -> 100
    //   110: astore_3
    //   111: aload_1
    //   112: astore_2
    //   113: aload_3
    //   114: astore_1
    //   115: goto -23 -> 92
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_1
    //   121: goto -58 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	YunYingReporter
    //   0	124	1	paramInputStream	java.io.InputStream
    //   9	35	2	str	String
    //   62	35	2	localException	Exception
    //   106	1	2	localIOException	java.io.IOException
    //   112	1	2	localInputStream	java.io.InputStream
    //   7	65	3	localStringBuilder	StringBuilder
    //   110	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	31	62	java/lang/Exception
    //   35	59	62	java/lang/Exception
    //   80	84	87	java/io/IOException
    //   10	26	91	finally
    //   67	71	102	java/io/IOException
    //   96	100	106	java/io/IOException
    //   26	31	110	finally
    //   35	59	110	finally
    //   10	26	118	java/lang/Exception
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    while ((!paramString.contains("success")) && (!(paramString.contains("-") & paramString.contains("/")))) {
      return false;
    }
    return true;
  }
  
  public boolean a(ResultObject paramResultObject)
  {
    Object localObject1;
    Object localObject2;
    String str;
    try
    {
      if (paramResultObject.params.keySet().contains("fileObj"))
      {
        localObject1 = new StringBuffer(1024);
        localObject2 = ((HashMap)paramResultObject.params.get("clientinfo")).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          ((StringBuffer)localObject1).append(str).append("=").append(URLEncoder.encode((String)((HashMap)paramResultObject.params.get("clientinfo")).get(str), "UTF-8")).append("&");
          continue;
          return false;
        }
      }
    }
    catch (Exception paramResultObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramResultObject.toString());
      }
    }
    for (;;)
    {
      if (((StringBuffer)localObject1).length() > 0) {
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
      }
      localObject1 = new URL("http://zhizi.qq.com/chunkupload.php?" + ((StringBuffer)localObject1).toString());
      paramResultObject = ((HashMap)paramResultObject.params.get("fileObj")).values().iterator();
      while (paramResultObject.hasNext())
      {
        localObject2 = new kgg(this, (URL)localObject1, (String)paramResultObject.next());
        this.jdField_a_of_type_MqqOsMqqHandler.post((Runnable)localObject2);
      }
      continue;
      localObject1 = new JSONObject();
      localObject2 = paramResultObject.params.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        ((JSONObject)localObject1).put(str, new JSONObject((Map)paramResultObject.params.get(str)));
      }
      paramResultObject = new kgh(this, new URL("http://zhizi.qq.com/json.php"), (JSONObject)localObject1);
      this.jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\reporter\YunYingReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */