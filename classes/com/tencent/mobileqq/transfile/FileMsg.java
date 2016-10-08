package com.tencent.mobileqq.transfile;

import KQQFS.VerifyCode;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMsg
{
  public static final int A = 33;
  public static String A = "richfile";
  public static final int B = 34;
  public static final String B = "photo/";
  public static final int C = 35;
  public static final String C = "ptt/";
  public static final int D = 36;
  public static final int E = 37;
  public static final int F = 38;
  public static final int G = 39;
  public static final int H = 40;
  public static final int I = 41;
  public static final int J = 48;
  public static final int K = 65536;
  public static final int L = 65537;
  public static final int M = 65538;
  public static final int N = 131072;
  public static final int O = 131074;
  public static final int P = 131075;
  public static final int Q = 131076;
  public static final int R = 131077;
  public static final int S = 131078;
  public static final int T = 131079;
  public static final int U = 131080;
  public static final int V = 196609;
  public static final int W = 196610;
  public static final int X = 196611;
  public static final int Y = 196612;
  public static final String a = "gif";
  static String[] a;
  public static final int aA = 5002;
  public static final int aB = 7000;
  public static final int aF = 0;
  public static final int aG = 1;
  public static final int aH = 2;
  public static final int aI = 3;
  public static final int aJ = 4;
  public static final int aK = 5;
  public static final int aL = 9001;
  public static final int aM = 9006;
  public static final int aN = 9005;
  public static final int aO = 9048;
  public static final int aP = 9015;
  public static final int aQ = 9011;
  public static final int aR = 9003;
  public static final int aS = 9004;
  public static final int aT = 9008;
  public static final int aU = 9023;
  public static final int aV = 9040;
  public static final int aW = 9041;
  public static final int aX = 9042;
  public static final int aY = 9043;
  public static final int aZ = 9045;
  public static final int ab = 998;
  public static final int ac = 999;
  public static final int ad = 1000;
  public static final int ae = 1001;
  public static final int af = 1002;
  public static final int ag = 1003;
  public static final int ah = 1004;
  public static final int ai = 1005;
  public static final int aj = 1006;
  public static final int ak = 1007;
  public static final int al = 2000;
  public static final int am = 2001;
  public static final int an = 2002;
  public static final int ao = 2003;
  public static final int ap = 2004;
  public static final int aq = 2005;
  public static final int ar = 2006;
  public static final int as = 2007;
  public static final int at = 2008;
  public static final int au = 3000;
  public static final int av = 3001;
  public static final int aw = 3002;
  public static final int ax = 4001;
  public static final int ay = 5000;
  public static final int az = 5001;
  public static final int b = 0;
  static String[] b;
  public static final int ba = 9080;
  public static final int bb = 9081;
  public static final int bc = 9082;
  public static final int bd = 9009;
  public static final int be = 4606;
  public static final int bf = 8;
  public static final int bg = 9061;
  public static final int bh = 9060;
  public static final int bi = 9024;
  public static final int bj = 9035;
  public static final int bk = 9053;
  public static final int bl = 9052;
  public static final int bm = 9054;
  public static final int bn = 9057;
  public static final int bo = 9032;
  public static final int bp = 9001;
  public static final int bq = 90451;
  public static final int br = 90460;
  public static final int bs = 0;
  public static final int bt = 1;
  public static final int bu = 2;
  public static final int bw = 0;
  public static final int bx = 1;
  public static final int by = 2;
  public static final int c = 1;
  public static final int d = 2;
  private static String[] d;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 5;
  public static final long k = 612345L;
  public static final int l = 6;
  public static final int m = 7;
  public static final int n = 8;
  public static final int o = 9;
  public static final int p = 16;
  public static final int q = 17;
  public static final int r = 18;
  public static final int s = 19;
  public static final int t = 20;
  public static final int u = 21;
  public static final int v = 22;
  public static final int w = 23;
  public static final int x = 24;
  public static final int y = 25;
  public static String y;
  public static final int z = 32;
  public String D = "";
  public int Z = -1;
  public int a;
  public long a;
  public VerifyCode a;
  public BaseTransProcessor a;
  public FileMsg.StepBaseInfo a;
  public FileMsg.StepTransInfo a;
  public HttpMsg a;
  public File a;
  public InputStream a;
  public OutputStream a;
  public boolean a;
  public byte[] a;
  public int aC;
  public int aD;
  public int aE;
  public int aa = -1;
  public long b;
  public FileMsg.StepBaseInfo b;
  public FileMsg.StepTransInfo b;
  public String b;
  public boolean b;
  public byte[] b;
  public int bv = -1;
  private int bz;
  public long c;
  public FileMsg.StepBaseInfo c;
  public String c;
  public byte[] c;
  public String[] c;
  public long d;
  public String d;
  public byte[] d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f = "";
  public long g;
  public String g = "";
  public long h;
  public String h;
  public long i;
  public String i;
  public long j;
  public String j;
  public String k;
  public long l;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u = "";
  public String v = "";
  public String w;
  public String x = "";
  public String z = y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "up", "down", "down" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "file", "pic", "ptt", "video", "map", "thumbpic", "emo", "multimsg" };
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "LogEventSignalSigFinish", "LogEventSignalUrlFinish", "LogEventRetry", "LogEventFlowUp", "LogEventFlowDown" };
    y = "defaultTag";
  }
  
  public FileMsg()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_i_of_type_Long = System.currentTimeMillis();
  }
  
  public FileMsg(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    try
    {
      this.jdField_i_of_type_Long = System.currentTimeMillis();
      this.r = paramString1;
      this.jdField_a_of_type_Int = paramInt;
      if (paramString2 == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_e_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_JavaIoFile.exists())
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
          paramInt = paramString2.lastIndexOf(".");
          if ((paramInt >= 0) && (paramInt < paramString2.length())) {
            this.jdField_d_of_type_JavaLangString = paramString2.substring(paramInt).toLowerCase();
          }
        }
        g(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    this.jdField_i_of_type_JavaLangString = paramString2;
  }
  
  public static String a()
  {
    try
    {
      Thread.sleep(10L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(paramString);
  }
  
  public InputStream a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_e_of_type_JavaLangString);
      return this.jdField_a_of_type_JavaIoInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoInputStream = null;
      }
    }
  }
  
  public OutputStream a()
  {
    if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      if (this.jdField_e_of_type_Int == 0) {}
      for (this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_e_of_type_JavaLangString, true);; this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_e_of_type_JavaLangString)) {
        return this.jdField_a_of_type_JavaIoOutputStream;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = AppConstants.bj + paramString1 + "/";
    paramString1 = "";
    String str2;
    String str3;
    String str1;
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      return "";
    case 2: 
      str2 = (String)localObject + "ptt/";
      str3 = ".amr";
      localObject = str3;
      str1 = str2;
      if (paramString2 == null)
      {
        paramString1 = "手机qq语音_" + a();
        str1 = str2;
        localObject = str3;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("photo", 2, "getTransferFilePath dir: " + str1);
      }
      paramString2 = new File(str1);
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      return new File(str1 + paramString1 + (String)localObject).getAbsoluteFile().toString();
      str2 = (String)localObject + "photo/";
      str3 = ".jpg";
      localObject = str3;
      str1 = str2;
      if (paramString2 == null)
      {
        paramString1 = a();
        localObject = str3;
        str1 = str2;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoOutputStream != null) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      this.jdField_a_of_type_JavaIoOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("8pic", 2, "exception io FileMsg, " + localIOException.toString());
        }
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    FileMsg.StepTransInfo localStepTransInfo;
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.b += 1;
      return;
    case 4: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.e += paramInt2;
      return;
    case 3: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.d += paramInt2;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.c = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    InputStream localInputStream = this.jdField_a_of_type_JavaIoInputStream;
    this.jdField_b_of_type_ArrayOfByte = new byte[paramInt2];
    if (paramInt1 == 0) {}
    for (;;)
    {
      try
      {
        localInputStream = a();
        if (paramInt1 <= this.bz) {
          continue;
        }
        localInputStream.skip(paramInt1 - this.bz);
        this.bz = paramInt1;
        localInputStream.read(this.jdField_b_of_type_ArrayOfByte, 0, paramInt2);
        this.bz += paramInt2;
      }
      catch (Exception localException)
      {
        this.jdField_b_of_type_ArrayOfByte = null;
        continue;
      }
      return this.jdField_b_of_type_ArrayOfByte;
      if (paramInt1 < this.bz)
      {
        localInputStream = a();
        localInputStream.skip(paramInt1);
      }
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    Object localObject = AppConstants.bj + paramString1 + "/";
    paramString1 = "";
    String str2;
    String str3;
    String str1;
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      return "";
    case 2: 
      str2 = (String)localObject + "ptt/";
      str3 = ".amr";
      localObject = str3;
      str1 = str2;
      if (paramString2 == null)
      {
        paramString1 = "手机qq语音_" + a();
        str1 = str2;
        localObject = str3;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("photo", 2, "getTransferFilePath dir: " + str1);
      }
      paramString2 = new File(str1);
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      paramString1 = new File(str1 + paramString1 + (String)localObject);
      if (!paramString1.exists()) {}
      try
      {
        paramString1.createNewFile();
        paramString1 = paramString1.getAbsoluteFile().toString();
        if (QLog.isColorLevel()) {
          QLog.d("photo", 2, "getTransferFilePath : " + paramString1);
        }
        c(paramString1);
        return paramString1;
        str2 = (String)localObject + "photo/";
        str3 = ".jpg";
        localObject = str3;
        str1 = str2;
        if (paramString2 != null) {
          continue;
        }
        paramString1 = a();
        localObject = str3;
        str1 = str2;
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoInputStream != null) {
        this.jdField_a_of_type_JavaIoInputStream.close();
      }
      this.jdField_a_of_type_JavaIoInputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(int paramInt)
  {
    this.aD = paramInt;
  }
  
  public void c(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      try
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_JavaIoFile = new File(paramString);
        File localFile = this.jdField_a_of_type_JavaIoFile.getParentFile();
        if ((localFile != null) && (!localFile.exists())) {
          localFile.mkdirs();
        }
        if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_JavaIoInputStream == null))
        {
          if (this.jdField_a_of_type_JavaIoFile.exists())
          {
            this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
            if ((paramString != null) && (paramString.contains("."))) {
              this.jdField_d_of_type_JavaLangString = paramString.substring(paramString.lastIndexOf(".")).toLowerCase();
            }
          }
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(paramString);
          return;
        }
      }
      catch (FileNotFoundException paramString)
      {
        this.jdField_e_of_type_JavaLangString = null;
        return;
      }
    } while (this.jdField_a_of_type_JavaIoOutputStream != null);
    if (this.jdField_e_of_type_Int == 0)
    {
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString, true);
      return;
    }
    this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString);
  }
  
  public void d(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          if (this.jdField_e_of_type_Int == 0)
          {
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString, true);
            return;
          }
        }
      }
      catch (FileNotFoundException paramString)
      {
        this.jdField_e_of_type_JavaLangString = null;
        return;
      }
    }
    this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString);
  }
  
  public void e(String paramString)
  {
    this.jdField_i_of_type_JavaLangString = paramString;
  }
  
  public void f(String paramString)
  {
    try
    {
      d(FileUtils.a(paramString).getAbsoluteFile().toString());
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\FileMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */