package com.tencent.mobileqq.utils.httputils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile.TimeoutParam;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class HttpMsg
{
  public static final String A = "application/vnd.wap.xhtml+xml";
  public static final String B = "application/xhtml+xml";
  public static final String C = "image";
  public static final String D = "the package is over max limit";
  public static final String E = "HttpCommunicator closed or msg caceled!";
  public static final String F = "preempted by higher msg";
  public static final String G = "httpcommunicator closed";
  public static final String H = "request cancelled";
  public static final String I = "jad";
  public static final String J = "jar";
  public static final String K = "wtai://wp/mc;";
  public static final String L = "unknown";
  public static final String M = "charset";
  public static final String N = "utf-8";
  public static final String O = "GET";
  public static final String P = "POST";
  public static final String Q = "Range";
  public static final String R = "X-Range";
  public static final String S = "If-Modified-Since";
  public static final String T = "Content-Length";
  public static final String U = "User-ReturnCode";
  public static final String V = "X-User-ReturnCode";
  public static final String W = "User-Range";
  public static final String X = "2";
  public static final String Y = "Connection";
  public static final String Z = "multipart/form-data";
  public static final int a = 2048;
  public static final String a = "cache-control";
  public static final String aa = "content-range";
  public static final String ab = "host";
  public static final String ac = "Content-Encoding";
  public static final String ad = "Transfer-Encoding";
  public static final String ae = "X-RtFlag";
  public static final String af = "X-httime";
  public static final String ag = "X-piccachetime";
  public static final String ah = "User-Agent";
  public static String am = "param_reason";
  public static final String b = "last-modified";
  public static final String c = "max-age";
  public static final String d = "no-cache";
  public static final String e = "Pragma";
  public static final String f = "Expires";
  public static final String g = "0";
  public static final String h = "Accept";
  public static final String i = "text/vnd.wap.wml,image/*,audio/*,text/vnd.sun.j2me.app-descriptor,application/*";
  public static final String j = "Location";
  public static final String k = "Referer";
  public static final String l = "X-ErrNo";
  public static final String m = "Content-Type";
  public static final String n = "Set-Q-Cookie";
  public static final String o = "Q-Cookie";
  public static final String p = "Set-Cookie";
  public static final String q = "Cookie";
  public static final String r = "Accept-Encoding";
  public static final String s = "mType";
  public static final String t = "text/vnd.wap.wml";
  public static final String u = "application/vnd.wap.wmlc";
  public static final String v = "application/vnd.wap.wbxml";
  public static final String w = "text/vnd.sun.j2me.app-descriptor";
  public static final String x = "application/java-archive";
  public static final String y = "text/html";
  public static final String z = "text/plain";
  public long a;
  public RichMediaStrategy.OldEngineDPCProfile.TimeoutParam a;
  private final IHttpCommunicatorListener jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener;
  public Object a;
  public HttpURLConnection a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public String[] a;
  public String ai;
  public String aj;
  public String ak;
  public String al;
  private String an;
  private String ao;
  private String ap = "GET";
  public int b;
  public long b;
  public HashMap b;
  public AtomicBoolean b;
  final boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  public int c;
  public long c;
  public AtomicBoolean c;
  public boolean c;
  public int d;
  public long d;
  public boolean d;
  public int e;
  public long e;
  public boolean e;
  public int f;
  public long f;
  public boolean f;
  public int g = -1;
  public long g;
  public boolean g;
  public int h;
  public long h;
  public boolean h;
  public int i;
  private boolean i = true;
  public int j;
  private int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    this(paramString, paramArrayOfByte, paramIHttpCommunicatorListener, false);
  }
  
  public HttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = 201;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_Boolean = true;
    this.an = paramString;
    if (paramString != null)
    {
      this.ao = paramString.substring(0, paramString.length());
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener = paramIHttpCommunicatorListener;
      if (paramArrayOfByte != null) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
      this.ao = null;
      break;
      label139:
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public IHttpCommunicatorListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener;
  }
  
  public String a()
  {
    return this.an;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.c != null) {
      this.c.set(false);
    }
    this.jdField_a_of_type_JavaNetHttpURLConnection = null;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.h = paramInt1;
    this.g = paramInt2;
    this.aj = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener instanceof BaseTransProcessor)) {
      ((BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener).b(paramInt1, paramInt2, 0L, paramString);
    }
  }
  
  public void a(String paramString)
  {
    this.an = paramString;
    this.ao = this.an.substring(0, this.an.length());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.ao;
  }
  
  public void b()
  {
    a();
    this.h = 0;
    this.g = 0;
    this.aj = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 5)
    {
      this.jdField_b_of_type_Int = 201;
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Int = 202;
      return;
    }
    if (paramInt == 10)
    {
      this.jdField_b_of_type_Int = 200;
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.ao = paramString;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean b()
  {
    return this.i;
  }
  
  public byte[] b()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public String c()
  {
    String str2 = a();
    String str1 = str2;
    if (!this.jdField_e_of_type_Boolean) {
      str1 = RichMediaUtil.a(str2);
    }
    return str1;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void c(String paramString)
  {
    this.ap = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public String d()
  {
    return this.aj;
  }
  
  public void d(String paramString)
  {
    this.an = paramString;
  }
  
  public boolean d()
  {
    if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey("X-RtFlag")) && ("0".equals(this.jdField_b_of_type_JavaUtilHashMap.get("X-RtFlag")))) {
      return false;
    }
    if ((this.h == 56009) && (this.g == 404))
    {
      String str = (String)this.jdField_b_of_type_JavaUtilHashMap.get(am);
      return (!"H_404_-6101".equals(str)) && (!"H_404_-5062".equals(str));
    }
    return (this.h != 9048) && (this.h != 9057) && (this.h != 9020) && (this.h != 9022) && (this.h != 9366) && (this.h != 9058);
  }
  
  public String e()
  {
    return this.ap;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\httputils\HttpMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */