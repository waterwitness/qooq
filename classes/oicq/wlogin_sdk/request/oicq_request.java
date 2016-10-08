package oicq.wlogin_sdk.request;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.b.aa;
import oicq.wlogin_sdk.b.ac;
import oicq.wlogin_sdk.b.ad;
import oicq.wlogin_sdk.b.ag;
import oicq.wlogin_sdk.b.ah;
import oicq.wlogin_sdk.b.ai;
import oicq.wlogin_sdk.b.aj;
import oicq.wlogin_sdk.b.am;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.ap;
import oicq.wlogin_sdk.b.as;
import oicq.wlogin_sdk.b.at;
import oicq.wlogin_sdk.b.aw;
import oicq.wlogin_sdk.b.ax;
import oicq.wlogin_sdk.b.ay;
import oicq.wlogin_sdk.b.ba;
import oicq.wlogin_sdk.b.bb;
import oicq.wlogin_sdk.b.bc;
import oicq.wlogin_sdk.b.bd;
import oicq.wlogin_sdk.b.bf;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bh;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bk;
import oicq.wlogin_sdk.b.bl;
import oicq.wlogin_sdk.b.bp;
import oicq.wlogin_sdk.b.bq;
import oicq.wlogin_sdk.b.bs;
import oicq.wlogin_sdk.b.bt;
import oicq.wlogin_sdk.b.bw;
import oicq.wlogin_sdk.b.ca;
import oicq.wlogin_sdk.b.cd;
import oicq.wlogin_sdk.b.ce;
import oicq.wlogin_sdk.b.cg;
import oicq.wlogin_sdk.b.cj;
import oicq.wlogin_sdk.b.cm;
import oicq.wlogin_sdk.b.cn;
import oicq.wlogin_sdk.b.co;
import oicq.wlogin_sdk.b.e;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.g;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.l;
import oicq.wlogin_sdk.b.m;
import oicq.wlogin_sdk.b.n;
import oicq.wlogin_sdk.b.o;
import oicq.wlogin_sdk.b.p;
import oicq.wlogin_sdk.b.r;
import oicq.wlogin_sdk.b.s;
import oicq.wlogin_sdk.b.u;
import oicq.wlogin_sdk.b.v;
import oicq.wlogin_sdk.b.w;
import oicq.wlogin_sdk.b.x;
import oicq.wlogin_sdk.b.y;
import oicq.wlogin_sdk.b.z;
import oicq.wlogin_sdk.report.report_t1;
import oicq.wlogin_sdk.report.report_t3;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class oicq_request
{
  static int B = 0;
  static String C = "";
  static String D = "";
  static String[] y = { "183.60.18.138", "112.90.85.191", "112.90.85.193", "183.60.18.150", "183.61.37.157", "120.204.200.34", "163.177.90.224" };
  static String[] z = { "112.90.141.48", "113.108.11.157", "113.108.11.159", "183.61.37.156" };
  int A = 0;
  int a = 4096;
  int b = 0;
  int c = 27;
  int d = 0;
  public int e = 15;
  protected int f = 0;
  protected byte[] g = new byte[this.a];
  protected int h = 8001;
  protected int i = 0;
  protected int j = 3;
  protected int k = 0;
  protected int l = 0;
  protected int m = 2;
  protected int n = 0;
  protected int o = 0;
  protected EncryptionMethod p = EncryptionMethod.EM_ECDH;
  InetSocketAddress q = null;
  int r = 0;
  byte[] s = new byte['᠀'];
  protected int t = 0;
  protected int u = 0;
  protected String v = "";
  byte w;
  public t x;
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramInt2, paramLong, 69, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i1 = this.i + 1;
    this.i = i1;
    this.b = 0;
    util.int8_to_buf(this.g, this.b, 2);
    this.b += 1;
    util.int16_to_buf(this.g, this.b, this.c + 2 + paramInt7);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt1);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt2);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, i1);
    this.b += 2;
    util.int32_to_buf(this.g, this.b, (int)paramLong);
    this.b += 4;
    util.int8_to_buf(this.g, this.b, 3);
    this.b += 1;
    util.int8_to_buf(this.g, this.b, paramInt3);
    this.b += 1;
    util.int8_to_buf(this.g, this.b, paramInt4);
    this.b += 1;
    util.int32_to_buf(this.g, this.b, 2);
    this.b += 4;
    util.int32_to_buf(this.g, this.b, paramInt5);
    this.b += 4;
    util.int32_to_buf(this.g, this.b, paramInt6);
    this.b += 4;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    a(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramArrayOfByte.length);
    a(paramArrayOfByte, paramArrayOfByte.length);
    a();
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    report_t3 localreport_t3 = new report_t3();
    localreport_t3._cmd = this.t;
    localreport_t3._sub = this.u;
    localreport_t3._rst2 = paramInt1;
    localreport_t3._used = ((int)(System.currentTimeMillis() - paramLong));
    localreport_t3._try = paramInt3;
    localreport_t3._host = D;
    if (localreport_t3._host == null) {
      localreport_t3._host = "";
    }
    if (this.q == null)
    {
      localreport_t3._ip = "";
      localreport_t3._port = c(paramBoolean1);
      localreport_t3._conn = paramInt2;
      localreport_t3._net = t.B;
      localreport_t3._str = "";
      localreport_t3._slen = 0;
      localreport_t3._rlen = 0;
      if (!paramBoolean1) {
        break label185;
      }
      if (!paramBoolean2) {
        break label176;
      }
      localreport_t3._wap = 2;
    }
    for (;;)
    {
      t.aj.add_t3(localreport_t3);
      return;
      localreport_t3._ip = this.q.getAddress().getHostAddress();
      break;
      label176:
      localreport_t3._wap = 1;
      continue;
      label185:
      localreport_t3._wap = 0;
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    B = paramInt;
    C = paramString;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public int a(int paramInt)
  {
    t.b(this.x.h)._last_flowid = paramInt;
    return paramInt;
  }
  
  public int a(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    if (this.x.e()) {}
    for (int i1 = b(paramString, paramBoolean, paramWUserSigInfo);; i1 = e())
    {
      if (i1 == 64536)
      {
        paramString = new ErrMsg();
        paramString.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4));
        a(paramString);
      }
      return i1;
    }
  }
  
  public int a(aw paramaw)
  {
    bh localbh = new bh();
    bg localbg = new bg();
    paramaw = paramaw.b();
    int i1 = paramaw.length;
    if (localbh.b(paramaw, 2, i1) > 0) {
      a(localbh);
    }
    if (localbg.b(paramaw, 2, i1) > 0)
    {
      this.x.m = 1;
      this.x.p = localbg.b();
      util.LOGI("get rollback sig", "");
    }
    return 0;
  }
  
  public int a(bh parambh)
  {
    parambh = parambh.b();
    int i3;
    int i2;
    int i1;
    if ((parambh != null) && (parambh.length > 2))
    {
      i3 = util.buf_to_int8(parambh, 1);
      i2 = 2;
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 >= i3) || (parambh.length < i2 + 1)) {}
      int i4;
      byte[] arrayOfByte;
      do
      {
        do
        {
          do
          {
            return 0;
            i4 = util.buf_to_int8(parambh, i2);
            i5 = i2 + 1;
          } while (parambh.length < i5 + 2);
          i2 = util.buf_to_int16(parambh, i5);
          i5 += 2;
        } while (parambh.length < i5 + i2);
        arrayOfByte = new byte[i2];
        System.arraycopy(parambh, i5, arrayOfByte, 0, i2);
        i2 = i5 + i2;
      } while (parambh.length < i2 + 2);
      int i5 = util.buf_to_int16(parambh, i2);
      i2 += 2;
      a(i4, arrayOfByte, i5);
      i1 += 1;
    }
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = cryptor.decrypt(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    if (paramArrayOfByte1 == null) {
      return 64534;
    }
    this.f = paramArrayOfByte1.length;
    if (paramArrayOfByte1.length + this.e + 2 > this.a)
    {
      this.a = (paramArrayOfByte1.length + this.e + 2);
      paramArrayOfByte2 = new byte[this.a];
      System.arraycopy(this.g, 0, paramArrayOfByte2, 0, this.b);
      this.g = paramArrayOfByte2;
    }
    this.b = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.g, paramInt1, paramArrayOfByte1.length);
    paramInt1 = this.b;
    paramInt2 = this.e;
    this.b = (paramArrayOfByte1.length + (paramInt2 + 2) + paramInt1);
    return 0;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str1 = "";
    paramInt /= 2;
    String str2;
    if ((B != 0) && (C != null) && (C.length() > 0)) {
      str2 = C;
    }
    for (;;)
    {
      D = str2;
      return str2;
      if (paramInt < 1)
      {
        if (paramBoolean) {
          if (t.B == 1) {
            str1 = new String(util.get_wap_server_host1(t.r));
          }
        }
        for (;;)
        {
          str2 = str1;
          if (str1.length() > 0) {
            break;
          }
          str2 = b(paramBoolean);
          break;
          if (t.B == 2)
          {
            str1 = new String(util.get_wap_server_host2(t.r));
            continue;
            if (t.B == 1) {
              str1 = new String(util.get_server_host1(t.r));
            } else if (t.B == 2) {
              str1 = new String(util.get_server_host2(t.r));
            }
          }
        }
      }
      if (paramInt < 2) {
        str2 = b(paramBoolean);
      } else {
        str2 = a(paramBoolean);
      }
    }
  }
  
  public String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return y[((int)(Math.random() * 2.147483647E9D) % y.length)];
    }
    return z[((int)(Math.random() * 2.147483647E9D) % z.length)];
  }
  
  public void a()
  {
    util.int8_to_buf(this.g, this.b, 3);
    this.b += 1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt3 = this.i + 1;
    this.i = paramInt3;
    this.b = 0;
    util.int8_to_buf(this.g, this.b, 2);
    this.b += 1;
    util.int16_to_buf(this.g, this.b, this.c + 2 + paramInt8);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt1);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt2);
    this.b += 2;
    util.int16_to_buf(this.g, this.b, paramInt3);
    this.b += 2;
    util.int32_to_buf(this.g, this.b, (int)paramLong);
    this.b += 4;
    util.int8_to_buf(this.g, this.b, 3);
    this.b += 1;
    util.int8_to_buf(this.g, this.b, 7);
    this.b += 1;
    util.int8_to_buf(this.g, this.b, paramInt4);
    this.b += 1;
    util.int32_to_buf(this.g, this.b, paramInt5);
    this.b += 4;
    util.int32_to_buf(this.g, this.b, paramInt6);
    this.b += 4;
    util.int32_to_buf(this.g, this.b, paramInt7);
    this.b += 4;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte)
  {
    a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte, int paramInt8)
  {
    a(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    a(paramArrayOfByte, paramInt8);
    a();
  }
  
  void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    if (paramInt1 == 1) {
      if (t.B == 1) {
        util.set_server_host1(t.r, paramArrayOfByte);
      }
    }
    for (;;)
    {
      util.LOGI("net type:" + t.B + " type:" + paramInt1 + " host:" + new String(paramArrayOfByte) + " port:" + paramInt2, "" + this.x.f);
      return;
      if (t.B == 2)
      {
        util.set_server_host2(t.r, paramArrayOfByte);
        continue;
        if (paramInt1 == 2) {
          if (t.B == 1) {
            util.set_wap_server_host1(t.r, paramArrayOfByte);
          } else if (t.B == 2) {
            util.set_wap_server_host2(t.r, paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    a(this.h, this.t, paramLong, this.l, t.u, this.o, paramArrayOfByte);
  }
  
  public void a(Socket paramSocket)
  {
    this.x.af = paramSocket;
  }
  
  public void a(as paramas)
  {
    try
    {
      ErrMsg localErrMsg = new ErrMsg();
      if (paramas != null)
      {
        localErrMsg.setType(paramas.f());
        localErrMsg.setTitle(new String(paramas.g()));
        localErrMsg.setMessage(new String(paramas.h()));
        localErrMsg.setOtherinfo(new String(paramas.i()));
        new d(t.r, localErrMsg).start();
      }
      return;
    }
    catch (Exception paramas) {}
  }
  
  public void a(ErrMsg paramErrMsg)
  {
    async_context localasync_context = t.b(this.x.h);
    localasync_context._last_err_msg = new ErrMsg(0, "", "", "");
    if (paramErrMsg != null) {}
    try
    {
      localasync_context._last_err_msg = ((ErrMsg)paramErrMsg.clone());
      return;
    }
    catch (CloneNotSupportedException paramErrMsg)
    {
      localasync_context._last_err_msg = new ErrMsg(0, "", "", "");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.b + paramInt + 1 > this.a)
    {
      this.a = (this.b + paramInt + 1 + 128);
      byte[] arrayOfByte = new byte[this.a];
      System.arraycopy(this.g, 0, arrayOfByte, 0, this.b);
      this.g = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.g, this.b, paramInt);
    this.b += paramInt;
  }
  
  public byte[] a(bb parambb)
  {
    Object localObject4 = new oicq.wlogin_sdk.b.h();
    Object localObject3 = new n();
    Object localObject2 = new bc();
    Object localObject1 = new ao();
    parambb = parambb.b();
    int i1 = parambb.length;
    if (((oicq.wlogin_sdk.b.h)localObject4).b(parambb, 2, i1) < 0) {}
    while ((((n)localObject3).b(parambb, 2, i1) < 0) || (((bc)localObject2).b(parambb, 2, i1) < 0)) {
      return null;
    }
    parambb = ((oicq.wlogin_sdk.b.h)localObject4).a();
    localObject3 = ((n)localObject3).a();
    localObject2 = ((bc)localObject2).a();
    localObject1 = ((ao)localObject1).a(t.y);
    localObject4 = new byte[parambb.length + 3 + localObject3.length + localObject2.length + localObject1.length];
    localObject4[0] = 64;
    util.int16_to_buf((byte[])localObject4, 1, 4);
    System.arraycopy(parambb, 0, localObject4, 3, parambb.length);
    i1 = parambb.length + 3;
    System.arraycopy(localObject3, 0, localObject4, i1, localObject3.length);
    i1 += localObject3.length;
    System.arraycopy(localObject2, 0, localObject4, i1, localObject2.length);
    i1 += localObject2.length;
    System.arraycopy(localObject1, 0, localObject4, i1, localObject1.length);
    i1 = localObject1.length;
    return (byte[])localObject4;
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    if (this.x.m == 0) {
      return a(paramArrayOfByte, this.x.c, this.x.n, this.x.o);
    }
    return a(paramArrayOfByte, this.x.c);
  }
  
  byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int16_to_buf(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    if (this.x.m == 0) {
      return a(arrayOfByte, this.x.c, this.x.n, this.x.o);
    }
    return a(arrayOfByte, this.x.c);
  }
  
  protected byte[] a(byte[] paramArrayOfByte, TransReqContext paramTransReqContext)
  {
    if (TransReqContext.EncryptMethod.EM_ECDH == paramTransReqContext.encryptMethod) {
      return a(paramArrayOfByte);
    }
    if (TransReqContext.EncryptMethod.EM_ST == paramTransReqContext.encryptMethod) {
      return a(paramArrayOfByte, paramTransReqContext.wtSessionTicket, paramTransReqContext.wtSessionTicketKey);
    }
    return null;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return new byte[0];
    }
    if (this.x.m == 2) {}
    for (int i1 = 3;; i1 = 2)
    {
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
      byte[] arrayOfByte = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte1.length];
      util.int8_to_buf(arrayOfByte, 0, 1);
      util.int8_to_buf(arrayOfByte, 1, i1);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 2, paramArrayOfByte2.length);
      i1 = paramArrayOfByte2.length + 2;
      util.int16_to_buf(arrayOfByte, i1, 258);
      i1 += 2;
      util.int16_to_buf(arrayOfByte, i1, 0);
      i1 += 2;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, i1, paramArrayOfByte1.length);
      i1 = paramArrayOfByte1.length;
      return arrayOfByte;
    }
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte3);
    paramArrayOfByte3 = new byte[paramArrayOfByte2.length + 2 + paramArrayOfByte1.length];
    util.int16_to_buf(paramArrayOfByte3, 0, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 2, paramArrayOfByte2.length);
    int i1 = paramArrayOfByte2.length + 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, i1, paramArrayOfByte1.length);
    i1 = paramArrayOfByte1.length;
    return paramArrayOfByte3;
  }
  
  byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramArrayOfByte4 == null)) {
      return new byte[0];
    }
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte4);
    paramArrayOfByte4 = new byte[paramArrayOfByte2.length + 2 + 2 + 2 + paramArrayOfByte3.length + paramArrayOfByte1.length];
    util.int8_to_buf(paramArrayOfByte4, 0, 1);
    util.int8_to_buf(paramArrayOfByte4, 1, 1);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 2, paramArrayOfByte2.length);
    int i1 = paramArrayOfByte2.length + 2;
    util.int16_to_buf(paramArrayOfByte4, i1, 258);
    i1 += 2;
    util.int16_to_buf(paramArrayOfByte4, i1, paramArrayOfByte3.length);
    i1 += 2;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, i1, paramArrayOfByte3.length);
    i1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, i1, paramArrayOfByte1.length);
    i1 = paramArrayOfByte1.length;
    return paramArrayOfByte4;
  }
  
  public int b()
  {
    int i1 = this.b;
    int i2;
    if (i1 <= this.e + 2)
    {
      i2 = 64527;
      return i2;
    }
    this.f = (i1 - this.e - 2);
    if (this.x.m == 0)
    {
      i2 = a(this.g, this.e + 1, this.f, this.x.o);
      i1 = i2;
      if (i2 < 0)
      {
        util.LOGI("use ecdh decrypt_body failed", "");
        i2 = a(this.g, this.e + 1, this.f, this.x.c);
        i1 = i2;
        if (i2 < 0)
        {
          util.LOGI("use kc decrypt_body failed", "");
          i1 = i2;
        }
      }
    }
    for (;;)
    {
      i2 = i1;
      if (i1 < 0) {
        break;
      }
      return c(this.g, this.e + 1, this.f);
      i2 = a(this.g, this.e + 1, this.f, this.x.c);
      i1 = i2;
      if (i2 < 0)
      {
        util.LOGI("use kc decrypt_body failed", "");
        i1 = i2;
      }
    }
  }
  
  /* Error */
  public int b(String paramString, boolean paramBoolean, WUserSigInfo paramWUserSigInfo)
  {
    // Byte code:
    //   0: new 385	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 550	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 555	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 557
    //   20: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 385	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   33: ldc 78
    //   35: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   42: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   58: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   61: istore 5
    //   63: aload_0
    //   64: invokevirtual 560	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   67: astore 4
    //   69: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   72: lstore 6
    //   74: new 385	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 562
    //   84: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 564
    //   94: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 133	oicq/wlogin_sdk/request/oicq_request:v	Ljava/lang/String;
    //   101: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 566
    //   107: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 5
    //   112: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 568
    //   118: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_2
    //   122: invokevirtual 571	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: new 385	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   135: ldc 78
    //   137: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   144: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   147: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: new 573	oicq/wlogin_sdk/request/WtloginMsfListener
    //   159: dup
    //   160: aload_1
    //   161: aload_0
    //   162: getfield 133	oicq/wlogin_sdk/request/oicq_request:v	Ljava/lang/String;
    //   165: aload 4
    //   167: iload 5
    //   169: iload_2
    //   170: aload_3
    //   171: invokespecial 576	oicq/wlogin_sdk/request/WtloginMsfListener:<init>	(Ljava/lang/String;Ljava/lang/String;[BIZLoicq/wlogin_sdk/request/WUserSigInfo;)V
    //   174: astore_3
    //   175: new 578	java/lang/Thread
    //   178: dup
    //   179: aload_3
    //   180: invokespecial 581	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 582	java/lang/Thread:start	()V
    //   188: aload_1
    //   189: iload 5
    //   191: i2l
    //   192: invokevirtual 586	java/lang/Thread:join	(J)V
    //   195: aload_3
    //   196: invokevirtual 589	oicq/wlogin_sdk/request/WtloginMsfListener:getRetData	()[B
    //   199: astore_1
    //   200: aload_1
    //   201: ifnonnull +240 -> 441
    //   204: new 385	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 591
    //   214: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_3
    //   218: invokevirtual 594	oicq/wlogin_sdk/request/WtloginMsfListener:getRet	()I
    //   221: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: new 385	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   234: ldc 78
    //   236: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   243: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   246: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: sipush 64536
    //   258: istore 5
    //   260: aload_0
    //   261: getfield 129	oicq/wlogin_sdk/request/oicq_request:t	I
    //   264: sipush 2066
    //   267: if_icmpeq +112 -> 379
    //   270: new 162	oicq/wlogin_sdk/report/report_t3
    //   273: dup
    //   274: invokespecial 163	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: aload_0
    //   280: getfield 129	oicq/wlogin_sdk/request/oicq_request:t	I
    //   283: putfield 166	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   286: aload_3
    //   287: aload_0
    //   288: getfield 131	oicq/wlogin_sdk/request/oicq_request:u	I
    //   291: putfield 169	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   294: aload_3
    //   295: iload 5
    //   297: putfield 172	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   300: aload_3
    //   301: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   304: lload 6
    //   306: lsub
    //   307: l2i
    //   308: putfield 181	oicq/wlogin_sdk/report/report_t3:_used	I
    //   311: aload_3
    //   312: iconst_0
    //   313: putfield 184	oicq/wlogin_sdk/report/report_t3:_try	I
    //   316: aload_3
    //   317: ldc 78
    //   319: putfield 187	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   322: aload_3
    //   323: ldc 78
    //   325: putfield 190	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   328: aload_3
    //   329: iconst_0
    //   330: putfield 196	oicq/wlogin_sdk/report/report_t3:_port	I
    //   333: aload_3
    //   334: iconst_0
    //   335: putfield 199	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   338: aload_3
    //   339: iconst_0
    //   340: putfield 205	oicq/wlogin_sdk/report/report_t3:_net	I
    //   343: aload_3
    //   344: ldc 78
    //   346: putfield 208	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   349: iload 5
    //   351: ifne +143 -> 494
    //   354: aload_3
    //   355: aload 4
    //   357: arraylength
    //   358: putfield 211	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   361: aload_3
    //   362: aload_1
    //   363: arraylength
    //   364: putfield 214	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   367: aload_3
    //   368: iconst_3
    //   369: putfield 217	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   372: getstatic 221	oicq/wlogin_sdk/request/t:aj	Loicq/wlogin_sdk/report/report_t1;
    //   375: aload_3
    //   376: invokevirtual 227	oicq/wlogin_sdk/report/report_t1:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   379: new 385	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   386: aload_0
    //   387: invokevirtual 550	java/lang/Object:getClass	()Ljava/lang/Class;
    //   390: invokevirtual 555	java/lang/Class:getName	()Ljava/lang/String;
    //   393: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc_w 596
    //   399: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload 5
    //   404: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: new 385	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   417: ldc 78
    //   419: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_0
    //   423: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   426: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   429: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: iload 5
    //   440: ireturn
    //   441: aload_0
    //   442: aload_1
    //   443: aload_1
    //   444: arraylength
    //   445: invokevirtual 598	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   448: iconst_0
    //   449: istore 5
    //   451: goto -191 -> 260
    //   454: astore_3
    //   455: aconst_null
    //   456: astore_1
    //   457: aload_3
    //   458: new 385	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   465: ldc 78
    //   467: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_0
    //   471: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   474: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   477: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 602	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   486: sipush 64536
    //   489: istore 5
    //   491: goto -231 -> 260
    //   494: aload_3
    //   495: iconst_0
    //   496: putfield 211	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   499: aload_3
    //   500: iconst_0
    //   501: putfield 214	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   504: goto -137 -> 367
    //   507: astore_3
    //   508: goto -51 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	oicq_request
    //   0	511	1	paramString	String
    //   0	511	2	paramBoolean	boolean
    //   0	511	3	paramWUserSigInfo	WUserSigInfo
    //   67	289	4	arrayOfByte	byte[]
    //   61	429	5	i1	int
    //   72	233	6	l1	long
    // Exception table:
    //   from	to	target	type
    //   74	200	454	java/lang/Exception
    //   204	255	507	java/lang/Exception
    //   441	448	507	java/lang/Exception
  }
  
  public int b(byte[] paramArrayOfByte)
  {
    return util.buf_to_int16(paramArrayOfByte, 1);
  }
  
  public String b(boolean paramBoolean)
  {
    String[] arrayOfString = new String[2];
    if (paramBoolean)
    {
      arrayOfString[0] = "wlogin.qq.com";
      arrayOfString[1] = "wlogin1.qq.com";
    }
    for (;;)
    {
      return arrayOfString[Math.abs(new java.util.Random().nextInt() % arrayOfString.length)];
      arrayOfString[0] = "wtlogin.qq.com";
      arrayOfString[1] = "wtlogin1.qq.com";
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this.a)
    {
      this.a = (paramInt + 128);
      this.g = new byte[this.a];
    }
    this.b = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.g, 0, paramInt);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ap localap = new ap();
    paramInt1 = localap.b(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = t.b(this.x.h);
    if (paramInt1 >= 0)
    {
      paramArrayOfByte._last_err_msg.setTitle(new String(localap.f()));
      paramArrayOfByte._last_err_msg.setMessage(new String(localap.g()));
      paramArrayOfByte._last_err_msg.setType(localap.h());
      paramArrayOfByte._last_err_msg.setOtherinfo(new String(localap.i()));
    }
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null)) {
      return new byte[16];
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    int i1 = paramArrayOfByte1.length + 0;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i1, paramArrayOfByte2.length);
    i1 += paramArrayOfByte2.length;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i1, paramArrayOfByte3.length);
    i1 = paramArrayOfByte3.length;
    return MD5.toMD5Byte(arrayOfByte);
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    return 443;
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt)
  {
    this.w = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt2 < 5)
    {
      i1 = 64527;
      return i1;
    }
    long l2 = 4294967295L;
    f localf = new f();
    Object localObject9 = new g();
    r localr = new r();
    u localu = new u();
    o localo = new o();
    p localp = new p();
    l locall = new l();
    s locals = new s();
    e locale = new e();
    v localv = new v();
    oicq.wlogin_sdk.b.d locald = new oicq.wlogin_sdk.b.d();
    m localm = new m();
    w localw = new w();
    x localx = new x();
    z localz = new z();
    Object localObject4 = new aa();
    ag localag = new ag();
    j localj = new j();
    oicq.wlogin_sdk.b.h localh = new oicq.wlogin_sdk.b.h();
    Object localObject8 = new n();
    Object localObject3 = new ac();
    Object localObject5 = new y();
    aj localaj = new aj();
    ah localah = new ah();
    as localas = new as();
    at localat = new at();
    Object localObject6 = new am();
    cj localcj = new cj();
    ax localax = new ax();
    ay localay = new ay();
    ba localba = new ba();
    bc localbc = new bc();
    bb localbb = new bb();
    aw localaw = new aw();
    bf localbf = new bf();
    a locala = new a(1298);
    bd localbd = new bd();
    bi localbi = new bi();
    bk localbk = new bk();
    bl localbl = new bl();
    bp localbp = new bp();
    bq localbq = new bq();
    ad localad = new ad();
    bs localbs = new bs();
    bt localbt = new bt();
    bw localbw = new bw();
    cm localcm = new cm();
    Object localObject7 = new cn();
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte5 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    byte[] arrayOfByte6 = null;
    ai localai = new ai();
    async_context localasync_context = t.b(this.x.h);
    long l3 = localasync_context._sappid;
    long l4 = localasync_context._appid;
    if (this.t == 2064) {
      switch (this.u)
      {
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 12: 
      case 14: 
      case 16: 
      default: 
        return 64524;
      case 9: 
        paramInt2 = 0;
      }
    }
    for (;;)
    {
      label622:
      i1 = c(paramArrayOfByte, paramInt1 + 2);
      int i4 = paramInt1 + 5;
      this.x.d = null;
      label826:
      label876:
      int i2;
      label1139:
      int i5;
      int i3;
      switch (i1)
      {
      default: 
        b(paramArrayOfByte, i4, this.b - i4 - 1);
        paramInt1 = i1;
      case 0: 
        do
        {
          do
          {
            localObject2 = new StringBuilder().append("type:").append(i1).append(" ret:");
            if (paramInt1 <= 0) {
              break label5747;
            }
            localObject1 = "0x" + Integer.toHexString(paramInt1);
            util.LOGI(localObject1, "" + this.x.f);
            if (paramInt1 != 0) {
              break label5756;
            }
            a(null);
            i1 = paramInt1;
            if ((i1 != 10) && (i1 != 161) && (i1 != 162) && (i1 != 164) && (i1 != 165) && (i1 != 166) && (i1 != 154))
            {
              paramInt1 = i1;
              if (i1 >= 128)
              {
                paramInt1 = i1;
                if (i1 > 143) {}
              }
            }
            else
            {
              paramInt1 = 64536;
            }
            i1 = paramInt1;
            if (paramInt2 == 2) {
              break;
            }
            i1 = paramInt1;
            if (paramInt2 == 6) {
              break;
            }
            i1 = paramInt1;
            if (paramInt2 == 7) {
              break;
            }
            a(paramInt2);
            return paramInt1;
            paramInt2 = 1;
            break label622;
            paramInt2 = 2;
            break label622;
            paramInt2 = 3;
            break label622;
            paramInt2 = 4;
            break label622;
            paramInt2 = 5;
            break label622;
            paramInt2 = 6;
            break label622;
            paramInt2 = 7;
            break label622;
            paramInt2 = 0;
            break label622;
            paramInt2 = 0;
            break label622;
            if (paramInt2 != 1) {
              break label2048;
            }
            if (this.x.b == null) {
              return 64530;
            }
            if (localat.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              this.x.d = localat;
            }
            if (localaw.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              a(localaw);
            }
            i2 = localu.a(paramArrayOfByte, i4, this.b - i4 - 1, this.x.b);
            paramInt1 = i2;
          } while (i2 < 0);
          localObject9 = localu.b();
          i2 = 2;
          i5 = localObject9.length;
          if (localas.b((byte[])localObject9, 2, i5) > 0) {
            a(localas);
          }
          if (localag.b((byte[])localObject9, 2, i5) > 0) {
            this.x.a(localag.f(), localag.g());
          }
          if (localr.b((byte[])localObject9, 2, i5) >= 0)
          {
            this.x.f = localr.f();
            this.x.a(this.x.g, Long.valueOf(this.x.f));
          }
          localo.b((byte[])localObject9, 2, i5);
          localp.b((byte[])localObject9, 2, i5);
          locall.b((byte[])localObject9, 2, i5);
          locals.b((byte[])localObject9, 2, i5);
          i3 = localv.b((byte[])localObject9, 2, i5);
          paramInt1 = i3;
        } while (i3 < 0);
        if (locale.b((byte[])localObject9, 2, i5) >= 0) {
          localObject2 = locale.b();
        }
        if (localj.b((byte[])localObject9, 2, i5) >= 0) {
          util.set_ksid(t.r, localj.b());
        }
        if (locald.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte1 = locald.b();
        }
        if (localm.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte2 = localm.b();
        }
        if (localw.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte3 = localw.b();
        }
        if (localz.b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte4 = localz.b();
        }
        if (((aa)localObject4).b((byte[])localObject9, 2, i5) >= 0) {
          arrayOfByte5 = ((aa)localObject4).b();
        }
        if (((ac)localObject3).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject1 = ((ac)localObject3).f();
          arrayOfByte6 = ((ac)localObject3).g();
        }
        if (localbw.b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject3 = this.x.g;
          if (util.check_uin_account((String)localObject3).booleanValue())
          {
            localObject4 = this.x.e(this.x.f);
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if (((String)localObject4).length() > 0)
              {
                this.x.a((String)localObject4, Long.valueOf(this.x.f), localbw.f());
                localObject3 = localObject4;
              }
            }
            label1593:
            util.LOGI("put t186: name: " + (String)localObject3 + " uin: " + this.x.f + " pwd=" + localbw.f(), "");
          }
        }
        else
        {
          util.LOGI("tgt len:" + util.buf_len(locall.b()) + " tgt_key len:" + util.buf_len(localo.b()) + " st len:" + util.buf_len(locals.b()) + " st_key len:" + util.buf_len(localp.b()) + " stwx_web len:" + util.buf_len((byte[])localObject2) + " a8 len:" + util.buf_len(arrayOfByte1) + " a5 len:" + util.buf_len(arrayOfByte2) + " lskey len:" + util.buf_len(arrayOfByte3) + " skey len:" + util.buf_len(arrayOfByte4) + " sig64 len:" + util.buf_len(arrayOfByte5) + " openid len:" + util.buf_len((byte[])localObject1) + " openkey len:" + util.buf_len(arrayOfByte6) + " pwdflag: " + localbw.c() + " " + localbw.f(), "" + this.x.f);
          if (localbb.b((byte[])localObject9, 2, i5) >= 0)
          {
            localObject3 = a(localbb);
            if ((localObject3 == null) || (localObject3.length <= 0)) {
              break label2504;
            }
          }
        }
        label2048:
        label2504:
        for (this.x.j = new WFastLoginInfo((byte[])localObject3);; this.x.j = new WFastLoginInfo())
        {
          localObject3 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 3, 0 });
          if (localba.b((byte[])localObject9, 2, i5) >= 0)
          {
            localObject3[0] = localba.f();
            localObject3[1] = localba.g();
            localObject3[2] = localba.h();
          }
          localObject4 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, 0 });
          paramInt1 = 0;
          while (paramInt1 < 5)
          {
            localObject4[paramInt1] = new byte[0];
            paramInt1 += 1;
          }
          if (paramInt2 == 2)
          {
            if (localbt.b(paramArrayOfByte, i4, this.b - i4) >= 0) {
              localasync_context._msalt = localbt.f();
            }
            if (f() == 3)
            {
              if (localr.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
              {
                this.x.f = localr.f();
                this.x.a(this.x.g, Long.valueOf(this.x.f));
              }
              if (localf.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
                localasync_context._t104 = localf;
              }
              paramInt1 = 0;
              break;
            }
            if (localat.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              this.x.d = localat;
            }
            if (localaw.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
              a(localaw);
            }
            i2 = localu.a(paramArrayOfByte, i4, this.b - i4 - 1, localasync_context._tgtgt_key);
            break label1139;
          }
          if ((paramInt2 == 3) || (paramInt2 == 7))
          {
            if (localbt.b(paramArrayOfByte, i4, this.b - i4) >= 0) {
              localasync_context._msalt = localbt.f();
            }
            if (localr.b(paramArrayOfByte, i4, this.b - i4) >= 0)
            {
              this.x.f = localr.f();
              this.x.a(this.x.g, Long.valueOf(this.x.f));
            }
            i2 = localf.b(paramArrayOfByte, i4, this.b - i4);
            paramInt1 = i2;
            if (i2 < 0) {
              break;
            }
            localasync_context._t104 = localf;
            paramInt1 = 0;
            break;
          }
          if (localat.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            this.x.d = localat;
          }
          if (localaw.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            a(localaw);
          }
          i2 = localu.a(paramArrayOfByte, i4, this.b - i4 - 1, localasync_context._tgtgt_key);
          r.E = 0;
          break label1139;
          this.x.a((String)localObject3, Long.valueOf(this.x.f), localbw.f());
          break label1593;
        }
        paramInt1 = ((n)localObject8).b((byte[])localObject9, 2, i5);
        if ((localh.b((byte[])localObject9, 2, i5) >= 0) && (paramInt1 >= 0))
        {
          localObject8 = ((n)localObject8).b();
          localObject4[0] = ((byte[])b(localh.b(), (byte[])localObject8).clone());
        }
        if (localbc.b((byte[])localObject9, 2, i5) >= 0) {
          localObject4[1] = localbc.b();
        }
        if (((cn)localObject7).b((byte[])localObject9, 2, i5) >= 0) {
          localObject4[4] = ((cn)localObject7).b();
        }
        if (localasync_context._sec_guid_flag)
        {
          localObject4[2] = localasync_context._G;
          localObject4[3] = localasync_context._dpwd;
          localObject4[4] = localasync_context._t403.b();
          localasync_context._sec_guid_flag = false;
        }
        localObject7 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 15, 0 });
        paramInt1 = 0;
        while (paramInt1 < 15)
        {
          localObject7[paramInt1] = new byte[0];
          paramInt1 += 1;
        }
        if (localai.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[0] = localai.b();
        }
        if (localah.b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[1] = localah.f();
          localObject1 = localah.g();
        }
        if (((am)localObject6).b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[2] = ((am)localObject6).b();
        }
        if (localcj.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[3] = localcj.b();
        }
        if (localax.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[4] = localax.b();
        }
        if (localbf.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[5] = localbf.b();
        }
        if (locala.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[6] = locala.b();
        }
        if (localbd.b((byte[])localObject9, 2, i5) >= 0) {
          localObject7[7] = localbd.b();
        }
        localObject6 = new ce();
        if (((ce)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[8] = ((ce)localObject6).g();
          localObject1 = ((ce)localObject6).f();
        }
        break;
      }
      for (;;)
      {
        localObject6 = new cg();
        if (((cg)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          localObject7[9] = ((cg)localObject6).f();
          localObject7[10] = ((cg)localObject6).g();
        }
        localObject6 = new a(515);
        label3051:
        label3086:
        label3121:
        long l1;
        if (((a)localObject6).b((byte[])localObject9, 2, i5) >= 0)
        {
          util.LOGI("get DA2 in rsp", "");
          localObject7[11] = ((a)localObject6).b();
          localObject6 = new a(791);
          if (((a)localObject6).b((byte[])localObject9, 2, i5) < 0) {
            break label3695;
          }
          oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = ((a)localObject6).b();
          localObject6 = new a(307);
          if (((a)localObject6).b((byte[])localObject9, 2, i5) < 0) {
            break label3704;
          }
          localObject7[13] = ((a)localObject6).b();
          localObject6 = new a(308);
          if (((a)localObject6).b((byte[])localObject9, 2, i5) < 0) {
            break label3738;
          }
          localObject7[14] = ((a)localObject6).b();
          util.LOGI("encrypt_a1 len:" + util.buf_len(localObject4[0]) + " no_pic_sig len:" + util.buf_len(localObject4[1]) + " G len:" + util.buf_len(localObject4[2]) + " dpwd len:" + util.buf_len(localObject4[3]) + " randseed len:" + util.buf_len(localObject4[4]) + " vkey len:" + util.buf_len(localObject7[0]) + " openid len:" + util.buf_len((byte[])localObject1) + " access_token len:" + util.buf_len(localObject7[1]) + " d2 len:" + util.buf_len(localObject7[2]) + " d2_key len:" + util.buf_len(localObject7[3]) + " sid len:" + util.buf_len(localObject7[4]) + " aq_sig len:" + util.buf_len(localObject7[5]) + " pskey len:" + util.buf_len(localObject7[6]) + " super_key len:" + util.buf_len(localObject7[7]) + " paytoken len:" + util.buf_len(localObject7[8]) + " pf len:" + util.buf_len(localObject7[9]) + " pfkey len:" + util.buf_len(localObject7[10]) + " da2 len:" + util.buf_len(localObject7[11]) + " wt session ticket:" + util.buf_len(localObject7[13]) + " wt session ticket key:" + util.buf_len(localObject7[14]), "" + this.x.f);
          if (((y)localObject5).b((byte[])localObject9, 2, i5) >= 0) {
            l2 = 0xFFFFFFFF & ((y)localObject5).f();
          }
          localObject5 = new long[7];
          paramInt1 = 2;
          l1 = 2160000L;
          label3523:
          paramInt1 = localaj.b((byte[])localObject9, paramInt1, i5);
          if (paramInt1 < 0) {
            break label3843;
          }
          if (localaj.f() == 0) {
            break label5845;
          }
          l1 = localaj.f();
        }
        label3572:
        label3590:
        label3608:
        label3626:
        label3644:
        label3695:
        label3704:
        label3738:
        label3782:
        label3792:
        label3802:
        label3812:
        label3822:
        label3832:
        label3843:
        label5239:
        label5303:
        label5747:
        label5756:
        label5845:
        for (;;)
        {
          if (localaj.g() != 0)
          {
            localObject5[0] = localaj.g();
            if (localaj.h() == 0) {
              break label3782;
            }
            localObject5[1] = localaj.h();
            if (localaj.i() == 0) {
              break label3792;
            }
            localObject5[2] = localaj.i();
            if (localaj.j() == 0) {
              break label3802;
            }
            localObject5[3] = localaj.j();
            if (localaj.k() == 0) {
              break label3812;
            }
            localObject5[4] = localaj.k();
            if (localaj.l() == 0) {
              break label3822;
            }
            localObject5[5] = localaj.l();
          }
          for (;;)
          {
            if (localaj.m() == 0) {
              break label3832;
            }
            localObject5[6] = localaj.m();
            break label3523;
            util.LOGI("no DA2 in rsp", "");
            break;
            oicq.wlogin_sdk.sharemem.WloginSigInfo._QRPUSHSig = new byte[0];
            break label3051;
            util.LOGW("get t133 failed", "" + this.x.f);
            break label3086;
            util.LOGW("get t134 failed", "" + this.x.f);
            break label3121;
            localObject5[0] = 1641600L;
            break label3572;
            localObject5[1] = 86400L;
            break label3590;
            localObject5[2] = 1728000L;
            break label3608;
            localObject5[3] = 72000L;
            break label3626;
            localObject5[4] = 6000L;
            break label3644;
            localObject5[5] = 1728000L;
          }
          localObject5[6] = 1728000L;
          break label3523;
          util.LOGI("sappid:" + l3 + " appid:" + l4 + " app_pri:" + l2 + " login_bitmap:" + localasync_context._login_bitmap + " tk_valid:" + 0L + " a2_valid:" + l1 + " lskey_valid:" + localObject5[0] + " skey_valid:" + localObject5[1] + " vkey_valid:" + localObject5[2] + " a8_valid:" + localObject5[3] + " stweb_valid:" + localObject5[4] + " d2_valid:" + localObject5[5] + " sid_valid:" + localObject5[6], "" + this.x.f);
          this.x.am = localasync_context._main_sigmap;
          i3 = this.x.a(this.x.f, l3, (byte[][])localObject4, l4, l2, t.f(), t.f() + 0L, l1 + t.f(), localv.f(), localv.g(), localv.h(), localv.i(), (byte[][])localObject3, locall.b(), localo.b(), locals.b(), localp.b(), (byte[])localObject2, arrayOfByte2, arrayOfByte1, arrayOfByte3, arrayOfByte4, arrayOfByte5, (byte[])localObject1, arrayOfByte6, (byte[][])localObject7, (long[])localObject5, localasync_context._login_bitmap);
          paramInt1 = i2;
          if (i3 != 0)
          {
            localObject1 = new ErrMsg();
            ((ErrMsg)localObject1).setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
            a((ErrMsg)localObject1);
            util.LOGI("put_siginfo fail,ret=" + i3, "" + this.x.f);
            paramInt1 = i3;
            break;
          }
          for (;;)
          {
            paramInt1 = localx.b((byte[])localObject9, paramInt1, i5);
            if (paramInt1 < 0) {
              break;
            }
            this.x.a(this.x.f, localx.f(), t.f(), t.f() + 0L, localx.h(), localx.g());
          }
          paramInt1 = 0;
          break;
          util.LOGI("cmd " + Integer.toHexString(this.t) + " subcmd " + Integer.toHexString(this.u) + " result " + i1 + " will clean sig for uin " + this.x.f + " appid " + l3);
          this.x.d(this.x.f, l3);
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          localObject1 = new ca();
          if (((ca)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            a(new ErrMsg(i1, "", "", ((ca)localObject1).f()));
            paramInt1 = i1;
            break;
          }
          i2 = ((g)localObject9).b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t105 = ((g)localObject9);
          if (localay.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {}
          for (localasync_context._t165 = localay;; localasync_context._t165 = new ay())
          {
            a(null);
            break;
          }
          this.x.d(this.x.f, l3);
          i2 = localag.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          this.x.a(localag.f(), localag.g());
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          localObject1 = new a(405);
          i2 = ((a)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          oicq.wlogin_sdk.sharemem.WloginSigInfo._LHSig = ((a)localObject1).b();
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          if (localr.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            this.x.f = localr.f();
            this.x.a(this.x.g, Long.valueOf(this.x.f));
          }
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          i2 = localbi.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t174 = localbi;
          if (localbk.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.CountryCode = new String(localbk.f());
            localasync_context._devlock_info.Mobile = new String(localbk.g());
            localasync_context._devlock_info.MbItemSmsCodeStatus = localbk.h();
            localasync_context._devlock_info.AvailableMsgCount = localbk.i();
            localasync_context._devlock_info.TimeLimit = localbk.j();
          }
          localObject1 = new cd();
          if (((cd)localObject1).b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.BakCountryCode = ((cd)localObject1).g();
            localasync_context._devlock_info.BakMobile = ((cd)localObject1).h();
            localasync_context._devlock_info.BakMobileState = ((cd)localObject1).f();
          }
          if (localbl.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            localasync_context._devlock_info.UnionVerifyUrl = new String(localbl.f());
          }
          if (localbp.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._devlock_info.MbGuideType = localbp.f();
            localasync_context._devlock_info.MbGuideMsg = new String(localbp.g());
            localasync_context._devlock_info.MbGuideInfoType = localbp.h();
            localasync_context._devlock_info.MbGuideInfo = new String(localbp.i());
          }
          if (localbq.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0) {
            localasync_context._devlock_info.VerifyReason = new String(localbq.b());
          }
          if (localcm.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            localasync_context._t402 = localcm;
            if (((cn)localObject7).b(paramArrayOfByte, i4, this.b - i4 - 1) < 0) {
              break label5303;
            }
          }
          for (localasync_context._t403 = ((cn)localObject7);; localasync_context._t403 = new cn())
          {
            b(paramArrayOfByte, i4, this.b - i4 - 1);
            paramInt1 = i1;
            break;
            localasync_context._t402 = new cm();
            break label5239;
          }
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          this.x.a(this.x.g);
          paramInt1 = i1;
          break;
          i2 = localaw.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          a(localaw);
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          if (localr.b(paramArrayOfByte, i4, this.b - i4 - 1) >= 0)
          {
            this.x.f = localr.f();
            this.x.a(this.x.g, Long.valueOf(this.x.f));
          }
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          i2 = localcm.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t402 = localcm;
          i2 = ((cn)localObject7).b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t403 = ((cn)localObject7);
          b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i1;
          break;
          i2 = localf.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t104 = localf;
          i2 = localad.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._t126 = localad;
          i2 = localbs.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._smslogin_msgcnt = localbs.f();
          localasync_context._smslogin_timelimit = localbs.g();
          i2 = localbt.b(paramArrayOfByte, i4, this.b - i4 - 1);
          paramInt1 = i2;
          if (i2 < 0) {
            break;
          }
          localasync_context._msalt = localbt.f();
          paramInt1 = 0;
          break;
          localObject1 = Integer.valueOf(paramInt1);
          break label826;
          new co().b(paramArrayOfByte, i4, this.b - i4 - 1);
          i1 = paramInt1;
          if (!co.h) {
            break label876;
          }
          paramArrayOfByte = new ErrMsg();
          i2 = new h(this.x, this.t, this.u, paramArrayOfByte).b(paramInt1);
          i1 = paramInt1;
          if (i2 == 64536) {
            break label876;
          }
          a(paramArrayOfByte);
          i1 = i2;
          break label876;
        }
      }
      paramInt2 = 0;
    }
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[this.b];
    System.arraycopy(this.g, 0, arrayOfByte, 0, this.b);
    return arrayOfByte;
  }
  
  public byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((t.z == null) || (t.z.length <= 0))
    {
      localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
      if (localObject != null) {
        break label213;
      }
    }
    label213:
    for (paramArrayOfByte = (byte[])paramArrayOfByte.clone();; paramArrayOfByte = (byte[])localObject)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16))
      {
        return (byte[])null;
        localObject = new byte[16];
        if (t.z.length > localObject.length) {
          System.arraycopy(t.z, 0, localObject, 0, localObject.length);
        }
        for (;;)
        {
          arrayOfByte = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, (byte[])localObject);
          if (arrayOfByte != null)
          {
            localObject = arrayOfByte;
            if (arrayOfByte.length > 0) {
              break;
            }
          }
          localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, "%4;7t>;28<fc.5*6".getBytes());
          break;
          System.arraycopy(t.z, 0, localObject, 0, t.z.length);
          i1 = t.z.length;
          while (i1 < localObject.length)
          {
            localObject[i1] = ((byte)(i1 + 1));
            i1 += 1;
          }
        }
      }
      int i1 = paramArrayOfByte.length - 16;
      localObject = new byte[i1];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, i1);
      byte[] arrayOfByte = new byte[16];
      System.arraycopy(paramArrayOfByte, i1, arrayOfByte, 0, 16);
      t.b(this.x.h)._tgtgt_key = arrayOfByte;
      return (byte[])localObject;
    }
  }
  
  public Socket d()
  {
    return this.x.af;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: new 385	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 550	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: invokevirtual 555	java/lang/Class:getName	()Ljava/lang/String;
    //   14: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 1317
    //   20: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 385	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   33: ldc 78
    //   35: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   42: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   45: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 560	oicq/wlogin_sdk/request/oicq_request:c	()[B
    //   58: astore 8
    //   60: iconst_0
    //   61: istore 11
    //   63: iconst_0
    //   64: istore 10
    //   66: iconst_0
    //   67: istore 9
    //   69: lconst_0
    //   70: lstore 17
    //   72: aload_0
    //   73: invokevirtual 1319	oicq/wlogin_sdk/request/oicq_request:d	()Ljava/net/Socket;
    //   76: astore_2
    //   77: iconst_0
    //   78: istore 22
    //   80: iconst_0
    //   81: istore 21
    //   83: iconst_0
    //   84: istore 12
    //   86: ldc 78
    //   88: astore_3
    //   89: ldc 78
    //   91: astore_1
    //   92: iload 9
    //   94: bipush 6
    //   96: if_icmpge +2341 -> 2437
    //   99: iload 9
    //   101: ifeq +9 -> 110
    //   104: getstatic 343	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   107: invokestatic 1323	oicq/wlogin_sdk/tools/util:chg_retry_type	(Landroid/content/Context;)V
    //   110: getstatic 343	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   113: invokestatic 1327	oicq/wlogin_sdk/tools/util:is_wap_retry	(Landroid/content/Context;)Z
    //   116: istore 23
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   123: iload 9
    //   125: ifeq +29 -> 154
    //   128: aload_0
    //   129: getfield 129	oicq/wlogin_sdk/request/oicq_request:t	I
    //   132: sipush 2066
    //   135: if_icmpeq +19 -> 154
    //   138: aload_0
    //   139: iload 10
    //   141: lload 17
    //   143: iload 12
    //   145: iload 9
    //   147: iload 23
    //   149: iload 21
    //   151: invokespecial 1329	oicq/wlogin_sdk/request/oicq_request:a	(IJIIZZ)V
    //   154: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   157: lstore 17
    //   159: iload 23
    //   161: ifeq +1044 -> 1205
    //   164: new 385	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 1331
    //   174: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload 9
    //   179: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc_w 1333
    //   185: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: new 385	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   198: ldc 78
    //   200: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   207: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   210: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: iload 9
    //   222: iload 23
    //   224: invokevirtual 1335	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   227: astore 7
    //   229: iload 21
    //   231: istore 22
    //   233: getstatic 343	oicq/wlogin_sdk/request/t:r	Landroid/content/Context;
    //   236: invokestatic 1338	oicq/wlogin_sdk/tools/util:is_wap_proxy_retry	(Landroid/content/Context;)Z
    //   239: istore 21
    //   241: iload 21
    //   243: ifeq +2537 -> 2780
    //   246: iload 21
    //   248: istore 22
    //   250: invokestatic 1341	oicq/wlogin_sdk/tools/util:get_proxy_ip	()Ljava/lang/String;
    //   253: astore 4
    //   255: iload 21
    //   257: istore 22
    //   259: invokestatic 1344	oicq/wlogin_sdk/tools/util:get_proxy_port	()I
    //   262: istore 10
    //   264: aload 4
    //   266: ifnull +21 -> 287
    //   269: iload 21
    //   271: istore 22
    //   273: aload 4
    //   275: invokevirtual 340	java/lang/String:length	()I
    //   278: ifle +9 -> 287
    //   281: iload 10
    //   283: iconst_m1
    //   284: if_icmpne +2505 -> 2789
    //   287: iconst_0
    //   288: istore 21
    //   290: iconst_0
    //   291: istore 22
    //   293: new 385	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 1346
    //   303: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 4
    //   308: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 1348
    //   314: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload 10
    //   319: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 1350
    //   325: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iconst_0
    //   329: invokevirtual 571	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   332: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: new 385	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   342: ldc 78
    //   344: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_0
    //   348: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   351: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   354: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   357: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto +2426 -> 2789
    //   366: iload 21
    //   368: ifeq +326 -> 694
    //   371: iload 21
    //   373: istore 22
    //   375: new 1352	java/net/URL
    //   378: dup
    //   379: new 385	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 1354
    //   389: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 4
    //   394: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 1356
    //   400: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: iload 10
    //   405: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: ldc_w 1358
    //   411: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokespecial 1360	java/net/URL:<init>	(Ljava/lang/String;)V
    //   420: astore 4
    //   422: new 385	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 1362
    //   432: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: iload 21
    //   437: invokevirtual 571	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   440: ldc_w 1364
    //   443: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 4
    //   448: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   451: ldc_w 1366
    //   454: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 7
    //   459: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: new 385	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   472: ldc 78
    //   474: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   481: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   484: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload 4
    //   495: invokevirtual 1370	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   498: checkcast 1372	java/net/HttpURLConnection
    //   501: astore 4
    //   503: aload 4
    //   505: ldc_w 1374
    //   508: invokevirtual 1377	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   511: iload 21
    //   513: ifeq +13 -> 526
    //   516: aload 4
    //   518: ldc_w 1379
    //   521: aload 7
    //   523: invokevirtual 1382	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 4
    //   528: ldc_w 1384
    //   531: ldc_w 1386
    //   534: invokevirtual 1382	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload 4
    //   539: ldc_w 1388
    //   542: ldc_w 1390
    //   545: invokevirtual 1382	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload 4
    //   550: ldc_w 1392
    //   553: aload 8
    //   555: arraylength
    //   556: invokestatic 1394	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   559: invokevirtual 1382	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: aload 4
    //   564: aload_0
    //   565: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   568: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   571: invokevirtual 1397	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   574: aload 4
    //   576: aload_0
    //   577: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   580: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   583: invokevirtual 1400	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   586: aload 4
    //   588: iconst_1
    //   589: invokevirtual 1404	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   592: aload 4
    //   594: iconst_1
    //   595: invokevirtual 1407	java/net/HttpURLConnection:setDoInput	(Z)V
    //   598: ldc_w 1409
    //   601: new 385	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   608: ldc 78
    //   610: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload_0
    //   614: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   617: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   620: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   623: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload 4
    //   631: aload_0
    //   632: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   635: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   638: i2l
    //   639: invokestatic 1414	oicq/wlogin_sdk/request/i:a	(Ljava/net/HttpURLConnection;J)Z
    //   642: ifne +232 -> 874
    //   645: ldc_w 1416
    //   648: new 385	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   655: ldc 78
    //   657: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_0
    //   661: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   664: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   667: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   670: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: iload 9
    //   678: iconst_1
    //   679: iadd
    //   680: istore 9
    //   682: sipush 64536
    //   685: istore 10
    //   687: iload 23
    //   689: istore 22
    //   691: goto -599 -> 92
    //   694: iload 21
    //   696: istore 22
    //   698: aload_0
    //   699: aload 7
    //   701: iconst_0
    //   702: aload_0
    //   703: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   706: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   709: i2l
    //   710: invokestatic 1421	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   713: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   716: iload 21
    //   718: istore 22
    //   720: aload_0
    //   721: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   724: ifnull +2049 -> 2773
    //   727: iload 21
    //   729: istore 22
    //   731: aload_0
    //   732: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   735: invokevirtual 233	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   738: invokevirtual 239	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   741: astore 5
    //   743: iload 21
    //   745: istore 22
    //   747: aload_1
    //   748: aload 5
    //   750: invokevirtual 1425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   753: ifeq +59 -> 812
    //   756: iload 21
    //   758: istore 22
    //   760: new 430	java/lang/Exception
    //   763: dup
    //   764: new 385	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   771: ldc_w 1427
    //   774: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload_1
    //   778: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokespecial 1428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   787: athrow
    //   788: astore 4
    //   790: iload 22
    //   792: istore 21
    //   794: sipush 64536
    //   797: istore 10
    //   799: iload 9
    //   801: iconst_1
    //   802: iadd
    //   803: istore 9
    //   805: iload 23
    //   807: istore 22
    //   809: goto -717 -> 92
    //   812: aload 5
    //   814: astore 4
    //   816: aload_0
    //   817: aconst_null
    //   818: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   821: aload 5
    //   823: astore 6
    //   825: aload 5
    //   827: astore_1
    //   828: aload_1
    //   829: astore 4
    //   831: new 1352	java/net/URL
    //   834: dup
    //   835: new 385	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 1354
    //   845: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload 6
    //   850: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: ldc_w 1358
    //   856: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokespecial 1360	java/net/URL:<init>	(Ljava/lang/String;)V
    //   865: astore 5
    //   867: aload 5
    //   869: astore 4
    //   871: goto -449 -> 422
    //   874: ldc_w 1430
    //   877: new 385	java/lang/StringBuilder
    //   880: dup
    //   881: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   884: ldc 78
    //   886: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload_0
    //   890: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   893: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   896: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   899: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload 4
    //   907: invokevirtual 1434	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   910: astore 5
    //   912: aload 5
    //   914: aload 8
    //   916: iconst_0
    //   917: aload 8
    //   919: arraylength
    //   920: invokevirtual 1439	java/io/OutputStream:write	([BII)V
    //   923: aload 5
    //   925: invokevirtual 1442	java/io/OutputStream:flush	()V
    //   928: aload 4
    //   930: invokevirtual 1445	java/net/HttpURLConnection:getResponseCode	()I
    //   933: istore 10
    //   935: new 385	java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   942: ldc_w 1447
    //   945: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: iload 10
    //   950: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   953: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: new 385	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   963: ldc 78
    //   965: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload_0
    //   969: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   972: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   975: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   978: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   984: sipush 200
    //   987: iload 10
    //   989: if_icmpeq +21 -> 1010
    //   992: iload 9
    //   994: iconst_1
    //   995: iadd
    //   996: istore 9
    //   998: sipush 64536
    //   1001: istore 10
    //   1003: iload 23
    //   1005: istore 22
    //   1007: goto -915 -> 92
    //   1010: aload 4
    //   1012: invokevirtual 1451	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1015: astore 5
    //   1017: aload_2
    //   1018: astore 4
    //   1020: aload_3
    //   1021: astore_2
    //   1022: aload_1
    //   1023: astore_3
    //   1024: aload 4
    //   1026: astore_1
    //   1027: aload_1
    //   1028: astore 4
    //   1030: iload 9
    //   1032: istore 10
    //   1034: ldc_w 1453
    //   1037: new 385	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1044: ldc 78
    //   1046: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: aload_0
    //   1050: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1053: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1056: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1065: iconst_0
    //   1066: istore 13
    //   1068: iconst_0
    //   1069: istore 14
    //   1071: aload_1
    //   1072: astore 4
    //   1074: iload 9
    //   1076: istore 10
    //   1078: iload 14
    //   1080: aload_0
    //   1081: getfield 96	oicq/wlogin_sdk/request/oicq_request:e	I
    //   1084: iconst_1
    //   1085: iadd
    //   1086: if_icmpge +37 -> 1123
    //   1089: aload_1
    //   1090: astore 4
    //   1092: iload 9
    //   1094: istore 10
    //   1096: aload 5
    //   1098: aload_0
    //   1099: getfield 127	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   1102: iload 14
    //   1104: aload_0
    //   1105: getfield 96	oicq/wlogin_sdk/request/oicq_request:e	I
    //   1108: iconst_1
    //   1109: iadd
    //   1110: iload 14
    //   1112: isub
    //   1113: invokevirtual 1458	java/io/InputStream:read	([BII)I
    //   1116: istore 13
    //   1118: iload 13
    //   1120: ifge +880 -> 2000
    //   1123: iload 13
    //   1125: ifge +885 -> 2010
    //   1128: sipush 64536
    //   1131: istore 13
    //   1133: iload 9
    //   1135: iconst_1
    //   1136: iadd
    //   1137: istore 9
    //   1139: aload_1
    //   1140: astore 4
    //   1142: iload 23
    //   1144: ifne +43 -> 1187
    //   1147: aload_1
    //   1148: astore 4
    //   1150: iload 9
    //   1152: istore 10
    //   1154: aload_1
    //   1155: invokevirtual 1463	java/net/Socket:close	()V
    //   1158: aload_1
    //   1159: astore 4
    //   1161: iload 9
    //   1163: istore 10
    //   1165: aload_0
    //   1166: aconst_null
    //   1167: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1170: aconst_null
    //   1171: astore 4
    //   1173: aconst_null
    //   1174: astore_1
    //   1175: iload 9
    //   1177: istore 10
    //   1179: aload_0
    //   1180: aconst_null
    //   1181: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1184: aload_1
    //   1185: astore 4
    //   1187: aload_3
    //   1188: astore_1
    //   1189: aload_2
    //   1190: astore_3
    //   1191: iload 13
    //   1193: istore 10
    //   1195: iload 23
    //   1197: istore 22
    //   1199: aload 4
    //   1201: astore_2
    //   1202: goto -1110 -> 92
    //   1205: new 385	java/lang/StringBuilder
    //   1208: dup
    //   1209: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1212: ldc_w 1467
    //   1215: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: iload 9
    //   1220: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1223: ldc_w 1333
    //   1226: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: new 385	java/lang/StringBuilder
    //   1235: dup
    //   1236: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1239: ldc 78
    //   1241: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: aload_0
    //   1245: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1248: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1251: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1260: aload_2
    //   1261: ifnonnull +1509 -> 2770
    //   1264: ldc 78
    //   1266: astore 4
    //   1268: iconst_1
    //   1269: istore 10
    //   1271: iconst_1
    //   1272: istore 12
    //   1274: aload_0
    //   1275: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1278: ifnonnull +99 -> 1377
    //   1281: aload_0
    //   1282: iload 9
    //   1284: iload 23
    //   1286: invokevirtual 1335	oicq/wlogin_sdk/request/oicq_request:a	(IZ)Ljava/lang/String;
    //   1289: astore 4
    //   1291: new 385	java/lang/StringBuilder
    //   1294: dup
    //   1295: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1298: ldc_w 1469
    //   1301: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: aload 4
    //   1306: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: ldc_w 1471
    //   1312: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: new 385	java/lang/StringBuilder
    //   1321: dup
    //   1322: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1325: ldc 78
    //   1327: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: aload_0
    //   1331: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1334: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1337: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1340: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1343: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1346: aload_0
    //   1347: aload_0
    //   1348: iload 23
    //   1350: invokevirtual 193	oicq/wlogin_sdk/request/oicq_request:c	(Z)I
    //   1353: putfield 125	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1356: aload_0
    //   1357: aload 4
    //   1359: aload_0
    //   1360: getfield 125	oicq/wlogin_sdk/request/oicq_request:r	I
    //   1363: aload_0
    //   1364: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1367: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   1370: i2l
    //   1371: invokestatic 1421	oicq/wlogin_sdk/request/a:a	(Ljava/lang/String;IJ)Ljava/net/InetSocketAddress;
    //   1374: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1377: aload_0
    //   1378: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1381: ifnull +84 -> 1465
    //   1384: aload_0
    //   1385: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1388: invokevirtual 233	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1391: ifnonnull +74 -> 1465
    //   1394: aload_0
    //   1395: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1398: invokevirtual 233	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1401: ifnonnull +34 -> 1435
    //   1404: ldc_w 1473
    //   1407: new 385	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1414: ldc 78
    //   1416: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: aload_0
    //   1420: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1423: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1426: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1429: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1432: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1435: sipush 64529
    //   1438: istore 10
    //   1440: iload 9
    //   1442: iconst_1
    //   1443: iadd
    //   1444: istore 9
    //   1446: aload_0
    //   1447: aconst_null
    //   1448: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1451: aload_0
    //   1452: aconst_null
    //   1453: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1456: aconst_null
    //   1457: astore_2
    //   1458: iload 23
    //   1460: istore 22
    //   1462: goto -1370 -> 92
    //   1465: aload_0
    //   1466: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1469: ifnull +20 -> 1489
    //   1472: aload_3
    //   1473: aload_0
    //   1474: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1477: invokevirtual 233	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1480: invokevirtual 239	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1483: invokevirtual 1425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1486: ifeq +151 -> 1637
    //   1489: aload_0
    //   1490: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1493: ifnonnull +88 -> 1581
    //   1496: new 385	java/lang/StringBuilder
    //   1499: dup
    //   1500: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1503: ldc_w 1469
    //   1506: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1509: aload 4
    //   1511: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: ldc_w 1475
    //   1517: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: new 385	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1530: ldc 78
    //   1532: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: aload_0
    //   1536: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1539: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1542: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1545: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1548: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1551: sipush 64529
    //   1554: istore 10
    //   1556: iload 9
    //   1558: iconst_1
    //   1559: iadd
    //   1560: istore 9
    //   1562: aload_0
    //   1563: aconst_null
    //   1564: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1567: aconst_null
    //   1568: astore_2
    //   1569: aload_0
    //   1570: aconst_null
    //   1571: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1574: iload 23
    //   1576: istore 22
    //   1578: goto -1486 -> 92
    //   1581: new 385	java/lang/StringBuilder
    //   1584: dup
    //   1585: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1588: ldc_w 1477
    //   1591: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload_3
    //   1595: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1601: new 385	java/lang/StringBuilder
    //   1604: dup
    //   1605: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1608: ldc 78
    //   1610: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: aload_0
    //   1614: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1617: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1620: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1623: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1626: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1629: sipush 64536
    //   1632: istore 10
    //   1634: goto -78 -> 1556
    //   1637: aload_0
    //   1638: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1641: invokevirtual 233	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   1644: invokevirtual 239	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1647: astore_3
    //   1648: new 385	java/lang/StringBuilder
    //   1651: dup
    //   1652: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1655: ldc_w 1469
    //   1658: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: aload 4
    //   1663: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: ldc_w 1479
    //   1669: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: aload_0
    //   1673: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1676: invokevirtual 1480	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1679: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: ldc_w 1482
    //   1685: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: new 385	java/lang/StringBuilder
    //   1694: dup
    //   1695: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1698: ldc 78
    //   1700: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: aload_0
    //   1704: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1707: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1710: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1713: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1716: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1719: iload 10
    //   1721: istore 12
    //   1723: aload_2
    //   1724: ifnonnull +1043 -> 2767
    //   1727: new 385	java/lang/StringBuilder
    //   1730: dup
    //   1731: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1734: ldc_w 1484
    //   1737: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: aload_0
    //   1741: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1744: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1747: ldc_w 1471
    //   1750: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1753: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1756: new 385	java/lang/StringBuilder
    //   1759: dup
    //   1760: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1763: ldc 78
    //   1765: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: aload_0
    //   1769: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1772: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1775: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1778: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1781: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1784: new 1460	java/net/Socket
    //   1787: dup
    //   1788: invokespecial 1485	java/net/Socket:<init>	()V
    //   1791: astore_2
    //   1792: aload_0
    //   1793: aload_2
    //   1794: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1797: aload_2
    //   1798: aload_0
    //   1799: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1802: aload_0
    //   1803: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1806: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   1809: invokevirtual 1489	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   1812: aload_2
    //   1813: aload_0
    //   1814: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1817: getfield 558	oicq/wlogin_sdk/request/t:l	I
    //   1820: invokevirtual 1492	java/net/Socket:setSoTimeout	(I)V
    //   1823: aload_2
    //   1824: aload_0
    //   1825: getfield 127	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   1828: arraylength
    //   1829: invokevirtual 1495	java/net/Socket:setReceiveBufferSize	(I)V
    //   1832: new 385	java/lang/StringBuilder
    //   1835: dup
    //   1836: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1839: ldc_w 1484
    //   1842: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: aload_0
    //   1846: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1849: invokevirtual 800	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1852: ldc_w 1497
    //   1855: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1861: new 385	java/lang/StringBuilder
    //   1864: dup
    //   1865: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1868: ldc 78
    //   1870: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1873: aload_0
    //   1874: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1877: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1880: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1883: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1889: ldc_w 1499
    //   1892: new 385	java/lang/StringBuilder
    //   1895: dup
    //   1896: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   1899: ldc 78
    //   1901: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: aload_0
    //   1905: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   1908: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   1911: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1914: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1917: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1920: aload_2
    //   1921: invokevirtual 1500	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   1924: astore 4
    //   1926: aload 4
    //   1928: aload 8
    //   1930: iconst_0
    //   1931: aload 8
    //   1933: arraylength
    //   1934: invokevirtual 1439	java/io/OutputStream:write	([BII)V
    //   1937: aload 4
    //   1939: invokevirtual 1442	java/io/OutputStream:flush	()V
    //   1942: aload_2
    //   1943: invokevirtual 1501	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   1946: astore 6
    //   1948: aload_1
    //   1949: astore 4
    //   1951: aload_3
    //   1952: astore 5
    //   1954: aload_2
    //   1955: astore_1
    //   1956: aload 4
    //   1958: astore_3
    //   1959: aload 5
    //   1961: astore_2
    //   1962: aload 6
    //   1964: astore 5
    //   1966: goto -939 -> 1027
    //   1969: astore_2
    //   1970: iload 9
    //   1972: iconst_1
    //   1973: iadd
    //   1974: istore 9
    //   1976: aload_0
    //   1977: aconst_null
    //   1978: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   1981: aload_0
    //   1982: aconst_null
    //   1983: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   1986: sipush 64536
    //   1989: istore 10
    //   1991: aconst_null
    //   1992: astore_2
    //   1993: iload 23
    //   1995: istore 22
    //   1997: goto -1905 -> 92
    //   2000: iload 14
    //   2002: iload 13
    //   2004: iadd
    //   2005: istore 14
    //   2007: goto -936 -> 1071
    //   2010: aload_1
    //   2011: astore 4
    //   2013: iload 9
    //   2015: istore 10
    //   2017: aload_0
    //   2018: aload_0
    //   2019: getfield 127	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2022: invokevirtual 1503	oicq/wlogin_sdk/request/oicq_request:b	([B)I
    //   2025: istore 14
    //   2027: iload 14
    //   2029: istore 10
    //   2031: aload_1
    //   2032: astore 4
    //   2034: iload 9
    //   2036: istore 11
    //   2038: iload 10
    //   2040: aload_0
    //   2041: getfield 96	oicq/wlogin_sdk/request/oicq_request:e	I
    //   2044: iconst_1
    //   2045: iadd
    //   2046: if_icmpgt +60 -> 2106
    //   2049: iload 9
    //   2051: iconst_1
    //   2052: iadd
    //   2053: istore 9
    //   2055: aload_1
    //   2056: astore 4
    //   2058: iload 23
    //   2060: ifne +732 -> 2792
    //   2063: aload_1
    //   2064: astore 4
    //   2066: iload 9
    //   2068: istore 11
    //   2070: aload_1
    //   2071: invokevirtual 1463	java/net/Socket:close	()V
    //   2074: aload_1
    //   2075: astore 4
    //   2077: iload 9
    //   2079: istore 11
    //   2081: aload_0
    //   2082: aconst_null
    //   2083: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2086: aconst_null
    //   2087: astore_1
    //   2088: aconst_null
    //   2089: astore 4
    //   2091: iload 9
    //   2093: istore 11
    //   2095: aload_0
    //   2096: aconst_null
    //   2097: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2100: aload_1
    //   2101: astore 4
    //   2103: goto +689 -> 2792
    //   2106: aload_1
    //   2107: astore 4
    //   2109: iload 9
    //   2111: istore 11
    //   2113: iload 10
    //   2115: aload_0
    //   2116: getfield 127	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2119: arraylength
    //   2120: if_icmplt +60 -> 2180
    //   2123: iload 9
    //   2125: iconst_1
    //   2126: iadd
    //   2127: istore 9
    //   2129: aload_1
    //   2130: astore 4
    //   2132: iload 23
    //   2134: ifne +681 -> 2815
    //   2137: aload_1
    //   2138: astore 4
    //   2140: iload 9
    //   2142: istore 11
    //   2144: aload_1
    //   2145: invokevirtual 1463	java/net/Socket:close	()V
    //   2148: aload_1
    //   2149: astore 4
    //   2151: iload 9
    //   2153: istore 11
    //   2155: aload_0
    //   2156: aconst_null
    //   2157: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2160: aconst_null
    //   2161: astore_1
    //   2162: aconst_null
    //   2163: astore 4
    //   2165: iload 9
    //   2167: istore 11
    //   2169: aload_0
    //   2170: aconst_null
    //   2171: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2174: aload_1
    //   2175: astore 4
    //   2177: goto +638 -> 2815
    //   2180: aload_1
    //   2181: astore 4
    //   2183: iload 9
    //   2185: istore 11
    //   2187: aload_0
    //   2188: getfield 96	oicq/wlogin_sdk/request/oicq_request:e	I
    //   2191: iconst_1
    //   2192: iadd
    //   2193: istore 15
    //   2195: iload 10
    //   2197: iload 15
    //   2199: isub
    //   2200: istore 14
    //   2202: iload 13
    //   2204: istore 16
    //   2206: iload 14
    //   2208: ifle +35 -> 2243
    //   2211: aload_1
    //   2212: astore 4
    //   2214: iload 9
    //   2216: istore 11
    //   2218: aload 5
    //   2220: aload_0
    //   2221: getfield 127	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2224: iload 15
    //   2226: iload 14
    //   2228: invokevirtual 1458	java/io/InputStream:read	([BII)I
    //   2231: istore 13
    //   2233: iload 13
    //   2235: iconst_m1
    //   2236: if_icmpne +110 -> 2346
    //   2239: iload 13
    //   2241: istore 16
    //   2243: iload 10
    //   2245: istore 13
    //   2247: lload 17
    //   2249: lstore 19
    //   2251: iload 12
    //   2253: istore 11
    //   2255: iload 23
    //   2257: istore 22
    //   2259: iload 21
    //   2261: istore 24
    //   2263: iload 16
    //   2265: iconst_m1
    //   2266: if_icmpne +187 -> 2453
    //   2269: iload 9
    //   2271: iconst_1
    //   2272: iadd
    //   2273: istore 9
    //   2275: aload_1
    //   2276: astore 4
    //   2278: iload 23
    //   2280: ifne +43 -> 2323
    //   2283: aload_1
    //   2284: astore 4
    //   2286: iload 9
    //   2288: istore 11
    //   2290: aload_1
    //   2291: invokevirtual 1463	java/net/Socket:close	()V
    //   2294: aload_1
    //   2295: astore 4
    //   2297: iload 9
    //   2299: istore 11
    //   2301: aload_0
    //   2302: aconst_null
    //   2303: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2306: aconst_null
    //   2307: astore 4
    //   2309: aconst_null
    //   2310: astore_1
    //   2311: iload 9
    //   2313: istore 11
    //   2315: aload_0
    //   2316: aconst_null
    //   2317: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2320: aload_1
    //   2321: astore 4
    //   2323: iload 10
    //   2325: istore 11
    //   2327: sipush 64536
    //   2330: istore 10
    //   2332: aload_3
    //   2333: astore_1
    //   2334: aload_2
    //   2335: astore_3
    //   2336: iload 23
    //   2338: istore 22
    //   2340: aload 4
    //   2342: astore_2
    //   2343: goto -2251 -> 92
    //   2346: iload 15
    //   2348: iload 13
    //   2350: iadd
    //   2351: istore 15
    //   2353: iload 14
    //   2355: iload 13
    //   2357: isub
    //   2358: istore 14
    //   2360: goto -158 -> 2202
    //   2363: astore_1
    //   2364: iload 10
    //   2366: istore 9
    //   2368: iload 11
    //   2370: istore 10
    //   2372: iload 9
    //   2374: iconst_1
    //   2375: iadd
    //   2376: istore 9
    //   2378: aload 4
    //   2380: astore_1
    //   2381: iload 23
    //   2383: ifne +28 -> 2411
    //   2386: aload 4
    //   2388: invokevirtual 1506	java/net/Socket:isConnected	()Z
    //   2391: ifeq +8 -> 2399
    //   2394: aload 4
    //   2396: invokevirtual 1463	java/net/Socket:close	()V
    //   2399: aload_0
    //   2400: aconst_null
    //   2401: putfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2404: aconst_null
    //   2405: astore_1
    //   2406: aload_0
    //   2407: aconst_null
    //   2408: invokevirtual 1465	oicq/wlogin_sdk/request/oicq_request:a	(Ljava/net/Socket;)V
    //   2411: aload_1
    //   2412: astore 4
    //   2414: iload 10
    //   2416: istore 11
    //   2418: sipush 64536
    //   2421: istore 10
    //   2423: aload_3
    //   2424: astore_1
    //   2425: aload_2
    //   2426: astore_3
    //   2427: iload 23
    //   2429: istore 22
    //   2431: aload 4
    //   2433: astore_2
    //   2434: goto -2342 -> 92
    //   2437: iload 11
    //   2439: istore 13
    //   2441: iload 21
    //   2443: istore 24
    //   2445: iload 12
    //   2447: istore 11
    //   2449: lload 17
    //   2451: lstore 19
    //   2453: iload 9
    //   2455: bipush 6
    //   2457: if_icmplt +242 -> 2699
    //   2460: sipush 64536
    //   2463: istore 10
    //   2465: iload 10
    //   2467: ifne +13 -> 2480
    //   2470: aload_0
    //   2471: aload_0
    //   2472: getfield 127	oicq/wlogin_sdk/request/oicq_request:s	[B
    //   2475: iload 13
    //   2477: invokevirtual 598	oicq/wlogin_sdk/request/oicq_request:b	([BI)V
    //   2480: iload 10
    //   2482: ifne +155 -> 2637
    //   2485: aload_0
    //   2486: getfield 129	oicq/wlogin_sdk/request/oicq_request:t	I
    //   2489: sipush 2066
    //   2492: if_icmpeq +145 -> 2637
    //   2495: new 162	oicq/wlogin_sdk/report/report_t3
    //   2498: dup
    //   2499: invokespecial 163	oicq/wlogin_sdk/report/report_t3:<init>	()V
    //   2502: astore_1
    //   2503: aload_1
    //   2504: aload_0
    //   2505: getfield 129	oicq/wlogin_sdk/request/oicq_request:t	I
    //   2508: putfield 166	oicq/wlogin_sdk/report/report_t3:_cmd	I
    //   2511: aload_1
    //   2512: aload_0
    //   2513: getfield 131	oicq/wlogin_sdk/request/oicq_request:u	I
    //   2516: putfield 169	oicq/wlogin_sdk/report/report_t3:_sub	I
    //   2519: aload_1
    //   2520: iload 10
    //   2522: putfield 172	oicq/wlogin_sdk/report/report_t3:_rst2	I
    //   2525: aload_1
    //   2526: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   2529: lload 19
    //   2531: lsub
    //   2532: l2i
    //   2533: putfield 181	oicq/wlogin_sdk/report/report_t3:_used	I
    //   2536: aload_1
    //   2537: iload 9
    //   2539: putfield 184	oicq/wlogin_sdk/report/report_t3:_try	I
    //   2542: aload_1
    //   2543: getstatic 82	oicq/wlogin_sdk/request/oicq_request:D	Ljava/lang/String;
    //   2546: putfield 187	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2549: aload_1
    //   2550: getfield 187	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2553: ifnonnull +9 -> 2562
    //   2556: aload_1
    //   2557: ldc 78
    //   2559: putfield 187	oicq/wlogin_sdk/report/report_t3:_host	Ljava/lang/String;
    //   2562: aload_0
    //   2563: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2566: ifnonnull +139 -> 2705
    //   2569: aload_1
    //   2570: ldc 78
    //   2572: putfield 190	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2575: aload_1
    //   2576: aload_0
    //   2577: getfield 125	oicq/wlogin_sdk/request/oicq_request:r	I
    //   2580: putfield 196	oicq/wlogin_sdk/report/report_t3:_port	I
    //   2583: aload_1
    //   2584: iload 11
    //   2586: putfield 199	oicq/wlogin_sdk/report/report_t3:_conn	I
    //   2589: aload_1
    //   2590: getstatic 202	oicq/wlogin_sdk/request/t:B	I
    //   2593: putfield 205	oicq/wlogin_sdk/report/report_t3:_net	I
    //   2596: aload_1
    //   2597: ldc 78
    //   2599: putfield 208	oicq/wlogin_sdk/report/report_t3:_str	Ljava/lang/String;
    //   2602: aload_1
    //   2603: aload 8
    //   2605: arraylength
    //   2606: putfield 211	oicq/wlogin_sdk/report/report_t3:_slen	I
    //   2609: aload_1
    //   2610: iload 13
    //   2612: putfield 214	oicq/wlogin_sdk/report/report_t3:_rlen	I
    //   2615: iload 22
    //   2617: ifeq +113 -> 2730
    //   2620: iload 24
    //   2622: ifeq +100 -> 2722
    //   2625: aload_1
    //   2626: iconst_2
    //   2627: putfield 217	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2630: getstatic 221	oicq/wlogin_sdk/request/t:aj	Loicq/wlogin_sdk/report/report_t1;
    //   2633: aload_1
    //   2634: invokevirtual 227	oicq/wlogin_sdk/report/report_t1:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   2637: new 385	java/lang/StringBuilder
    //   2640: dup
    //   2641: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   2644: aload_0
    //   2645: invokevirtual 550	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2648: invokevirtual 555	java/lang/Class:getName	()Ljava/lang/String;
    //   2651: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: ldc_w 1508
    //   2657: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2660: iload 10
    //   2662: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2665: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2668: new 385	java/lang/StringBuilder
    //   2671: dup
    //   2672: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   2675: ldc 78
    //   2677: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2680: aload_0
    //   2681: getfield 248	oicq/wlogin_sdk/request/oicq_request:x	Loicq/wlogin_sdk/request/t;
    //   2684: getfield 406	oicq/wlogin_sdk/request/t:f	J
    //   2687: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2690: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2693: invokestatic 318	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2696: iload 10
    //   2698: ireturn
    //   2699: iconst_0
    //   2700: istore 10
    //   2702: goto -237 -> 2465
    //   2705: aload_1
    //   2706: aload_0
    //   2707: getfield 123	oicq/wlogin_sdk/request/oicq_request:q	Ljava/net/InetSocketAddress;
    //   2710: invokevirtual 233	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   2713: invokevirtual 239	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2716: putfield 190	oicq/wlogin_sdk/report/report_t3:_ip	Ljava/lang/String;
    //   2719: goto -144 -> 2575
    //   2722: aload_1
    //   2723: iconst_1
    //   2724: putfield 217	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2727: goto -97 -> 2630
    //   2730: aload_1
    //   2731: iconst_0
    //   2732: putfield 217	oicq/wlogin_sdk/report/report_t3:_wap	I
    //   2735: goto -105 -> 2630
    //   2738: astore_1
    //   2739: goto -340 -> 2399
    //   2742: astore_1
    //   2743: iload 11
    //   2745: istore 9
    //   2747: goto -375 -> 2372
    //   2750: astore 5
    //   2752: goto -1375 -> 1377
    //   2755: astore_1
    //   2756: aload 4
    //   2758: astore_1
    //   2759: goto -1965 -> 794
    //   2762: astore 4
    //   2764: goto -1970 -> 794
    //   2767: goto -878 -> 1889
    //   2770: goto -1047 -> 1723
    //   2773: aload 7
    //   2775: astore 6
    //   2777: goto -1949 -> 828
    //   2780: aconst_null
    //   2781: astore 4
    //   2783: iconst_m1
    //   2784: istore 10
    //   2786: goto -2420 -> 366
    //   2789: goto -2423 -> 366
    //   2792: iload 10
    //   2794: istore 11
    //   2796: sipush 64536
    //   2799: istore 10
    //   2801: aload_3
    //   2802: astore_1
    //   2803: aload_2
    //   2804: astore_3
    //   2805: iload 23
    //   2807: istore 22
    //   2809: aload 4
    //   2811: astore_2
    //   2812: goto -2720 -> 92
    //   2815: iload 10
    //   2817: istore 11
    //   2819: sipush 64536
    //   2822: istore 10
    //   2824: aload_3
    //   2825: astore_1
    //   2826: aload_2
    //   2827: astore_3
    //   2828: iload 23
    //   2830: istore 22
    //   2832: aload 4
    //   2834: astore_2
    //   2835: goto -2743 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2838	0	this	oicq_request
    //   91	2243	1	localObject1	Object
    //   2363	1	1	localThrowable1	Throwable
    //   2380	351	1	localObject2	Object
    //   2738	1	1	localException1	Exception
    //   2742	1	1	localThrowable2	Throwable
    //   2755	1	1	localException2	Exception
    //   2758	68	1	localObject3	Object
    //   76	1886	2	localObject4	Object
    //   1969	1	2	localThrowable3	Throwable
    //   1992	843	2	localObject5	Object
    //   88	2740	3	localObject6	Object
    //   253	377	4	localObject7	Object
    //   788	1	4	localException3	Exception
    //   814	1943	4	localObject8	Object
    //   2762	1	4	localException4	Exception
    //   2781	52	4	localObject9	Object
    //   741	1478	5	localObject10	Object
    //   2750	1	5	localException5	Exception
    //   823	1953	6	localObject11	Object
    //   227	2547	7	str	String
    //   58	2546	8	arrayOfByte	byte[]
    //   67	2679	9	i1	int
    //   64	2759	10	i2	int
    //   61	2757	11	i3	int
    //   84	2362	12	i4	int
    //   1066	1545	13	i5	int
    //   1069	1290	14	i6	int
    //   2193	159	15	i7	int
    //   2204	63	16	i8	int
    //   70	2380	17	l1	long
    //   2249	281	19	l2	long
    //   81	2361	21	bool1	boolean
    //   78	2753	22	bool2	boolean
    //   116	2713	23	bool3	boolean
    //   2261	360	24	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   233	241	788	java/lang/Exception
    //   250	255	788	java/lang/Exception
    //   259	264	788	java/lang/Exception
    //   273	281	788	java/lang/Exception
    //   293	363	788	java/lang/Exception
    //   375	422	788	java/lang/Exception
    //   698	716	788	java/lang/Exception
    //   720	727	788	java/lang/Exception
    //   731	743	788	java/lang/Exception
    //   747	756	788	java/lang/Exception
    //   760	788	788	java/lang/Exception
    //   1727	1889	1969	java/lang/Throwable
    //   1889	1948	1969	java/lang/Throwable
    //   1034	1065	2363	java/lang/Throwable
    //   1078	1089	2363	java/lang/Throwable
    //   1096	1118	2363	java/lang/Throwable
    //   1154	1158	2363	java/lang/Throwable
    //   1165	1170	2363	java/lang/Throwable
    //   1179	1184	2363	java/lang/Throwable
    //   2017	2027	2363	java/lang/Throwable
    //   2386	2399	2738	java/lang/Exception
    //   2038	2049	2742	java/lang/Throwable
    //   2070	2074	2742	java/lang/Throwable
    //   2081	2086	2742	java/lang/Throwable
    //   2095	2100	2742	java/lang/Throwable
    //   2113	2123	2742	java/lang/Throwable
    //   2144	2148	2742	java/lang/Throwable
    //   2155	2160	2742	java/lang/Throwable
    //   2169	2174	2742	java/lang/Throwable
    //   2187	2195	2742	java/lang/Throwable
    //   2218	2233	2742	java/lang/Throwable
    //   2290	2294	2742	java/lang/Throwable
    //   2301	2306	2742	java/lang/Throwable
    //   2315	2320	2742	java/lang/Throwable
    //   1346	1377	2750	java/lang/Exception
    //   816	821	2755	java/lang/Exception
    //   831	867	2755	java/lang/Exception
    //   422	511	2762	java/lang/Exception
    //   516	526	2762	java/lang/Exception
    //   526	676	2762	java/lang/Exception
    //   874	984	2762	java/lang/Exception
    //   1010	1017	2762	java/lang/Exception
  }
  
  public int f()
  {
    return t.b(this.x.h)._last_flowid;
  }
  
  public static enum EncryptionMethod
  {
    EM_ECDH,  EM_ST;
    
    private EncryptionMethod() {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\oicq_request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */