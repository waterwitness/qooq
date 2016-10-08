package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.b.ab;
import oicq.wlogin_sdk.b.af;
import oicq.wlogin_sdk.b.ak;
import oicq.wlogin_sdk.b.al;
import oicq.wlogin_sdk.b.an;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.aq;
import oicq.wlogin_sdk.b.av;
import oicq.wlogin_sdk.b.az;
import oicq.wlogin_sdk.b.b;
import oicq.wlogin_sdk.b.bc;
import oicq.wlogin_sdk.b.be;
import oicq.wlogin_sdk.b.bg;
import oicq.wlogin_sdk.b.bj;
import oicq.wlogin_sdk.b.br;
import oicq.wlogin_sdk.b.bv;
import oicq.wlogin_sdk.b.bx;
import oicq.wlogin_sdk.b.by;
import oicq.wlogin_sdk.b.bz;
import oicq.wlogin_sdk.b.c;
import oicq.wlogin_sdk.b.cc;
import oicq.wlogin_sdk.b.ch;
import oicq.wlogin_sdk.b.ci;
import oicq.wlogin_sdk.b.ck;
import oicq.wlogin_sdk.b.cp;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.h;
import oicq.wlogin_sdk.b.i;
import oicq.wlogin_sdk.b.j;
import oicq.wlogin_sdk.b.q;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public class k
  extends oicq_request
{
  public static boolean E = false;
  public static byte[] F = new byte[0];
  public static byte[] G = new byte[0];
  public static byte[] H = new byte[0];
  
  public k(t paramt)
  {
    this.t = 2064;
    this.u = 9;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    Object localObject = t.b(this.x.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(t.z);
    byte[] arrayOfByte1 = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new f();
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte2 = a(paramLong1, paramLong2, j, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte1, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((f)localObject).b(), t.C, paramWUserSigInfo._domains);
        a(this.h, this.t, this.i, paramLong3, this.l, this.m, j, this.o, arrayOfByte2);
        int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (k != 0) {
          return k;
        }
        k = b();
        util.LOGI("retry num:" + i + " ret:" + k, "" + paramLong3);
        if (k != 180) {
          return k;
        }
        if (i >= 1) {
          return k;
        }
        i += 1;
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.u;
    f localf = t.b(this.x.h)._t104;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      paramArrayOfByte2 = c(paramArrayOfByte2);
      int j;
      if (paramArrayOfByte2 == null)
      {
        j = 64522;
        return j;
      }
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localf.b(), t.C, paramWUserSigInfo._domains);
        a(this.h, this.t, this.i, paramLong3, this.l, this.m, m, this.o, arrayOfByte);
        int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        j = k;
        if (k != 0) {
          break;
        }
        j = b();
        util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
        if (j != 180) {
          return j;
        }
        if (i >= 1) {
          return j;
        }
        i += 1;
      }
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, List<String> paramList)
  {
    int[] arrayOfInt = new int[30];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 24;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 1;
    int[] tmp17_13 = tmp13_8;
    tmp17_13[2] = 'Ć';
    int[] tmp23_17 = tmp17_13;
    tmp23_17[3] = 'Ė';
    int[] tmp29_23 = tmp23_17;
    tmp29_23[4] = 'Ā';
    int[] tmp35_29 = tmp29_23;
    tmp35_29[5] = 'ć';
    int[] tmp41_35 = tmp35_29;
    tmp41_35[6] = 'Ĉ';
    int[] tmp48_41 = tmp41_35;
    tmp48_41[7] = 'Ą';
    int[] tmp55_48 = tmp48_41;
    tmp55_48[8] = 'ł';
    int[] tmp62_55 = tmp55_48;
    tmp62_55[9] = 'Ē';
    int[] tmp69_62 = tmp62_55;
    tmp69_62[10] = 'ń';
    int[] tmp76_69 = tmp69_62;
    tmp76_69[11] = 'Ņ';
    int[] tmp83_76 = tmp76_69;
    tmp83_76[12] = 'Ň';
    int[] tmp90_83 = tmp83_76;
    tmp90_83[13] = 'Ŧ';
    int[] tmp97_90 = tmp90_83;
    tmp97_90[14] = 'Ū';
    int[] tmp104_97 = tmp97_90;
    tmp104_97[15] = 'Ŕ';
    int[] tmp111_104 = tmp104_97;
    tmp111_104[16] = 'Ł';
    int[] tmp118_111 = tmp111_104;
    tmp118_111[17] = 8;
    int[] tmp124_118 = tmp118_111;
    tmp124_118[18] = 'ԑ';
    int[] tmp131_124 = tmp124_118;
    tmp131_124[19] = 'Ų';
    int[] tmp138_131 = tmp131_124;
    tmp138_131[20] = 'ƅ';
    int[] tmp145_138 = tmp138_131;
    tmp145_138[21] = 'Ѐ';
    int[] tmp152_145 = tmp145_138;
    tmp152_145[22] = 'Ƈ';
    int[] tmp159_152 = tmp152_145;
    tmp159_152[23] = 'ƈ';
    int[] tmp166_159 = tmp159_152;
    tmp166_159[24] = 'Ɣ';
    int[] tmp173_166 = tmp166_159;
    tmp173_166[25] = 'Ƒ';
    int[] tmp180_173 = tmp173_166;
    tmp180_173[26] = 'ȁ';
    int[] tmp187_180 = tmp180_173;
    tmp187_180[27] = 'Ȃ';
    int[] tmp194_187 = tmp187_180;
    tmp194_187[28] = 'ŷ';
    int[] tmp201_194 = tmp194_187;
    tmp201_194[29] = 'Ԗ';
    tmp201_194;
    async_context localasync_context = t.b(this.x.h);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    Object localObject2;
    Object localObject1;
    if (j < k)
    {
      m = arrayOfInt[j];
      localObject2 = null;
      switch (m)
      {
      default: 
        localObject1 = localObject2;
        label516:
        if (localObject1 != null)
        {
          localArrayList.add(localObject1);
          i = localObject1.length + i;
        }
        break;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      localObject1 = new br().a(paramLong1, paramInt1, paramLong3, paramInt2);
      break label516;
      localObject1 = new b().a(paramLong3, paramArrayOfByte1);
      break label516;
      localObject1 = new h();
      if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0))
      {
        ((h)localObject1).a(paramArrayOfByte5, paramArrayOfByte5.length);
        localObject1 = ((h)localObject1).a();
        break label516;
      }
      localObject1 = ((h)localObject1).a(paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfByte2, paramArrayOfByte1, 1, paramArrayOfByte3, localasync_context._msalt, this.x.g.getBytes(), paramArrayOfByte4, t.S, t.y, paramInt3);
      break label516;
      localObject1 = new oicq.wlogin_sdk.b.t().a(paramInt4, paramInt5, paramArrayOfLong);
      break label516;
      localObject1 = new c().a(paramLong1, paramLong4, paramInt1, paramInt6);
      break label516;
      localObject1 = new i().a(paramInt7, paramInt8, paramInt9, paramInt10);
      break label516;
      localObject1 = localObject2;
      if (paramArrayOfByte7 == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (paramArrayOfByte7.length == 0) {
        break label516;
      }
      localObject1 = new j().a(paramArrayOfByte7);
      break label516;
      localObject1 = localObject2;
      if (paramArrayOfByte8 == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (paramArrayOfByte8.length == 0) {
        break label516;
      }
      localObject1 = new f().a(paramArrayOfByte8);
      break label516;
      localObject1 = new al().a(paramArrayOfByte9);
      break label516;
      localObject1 = localObject2;
      if (this.x.g == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (util.check_uin_account(this.x.g).booleanValue()) {
        break label516;
      }
      localObject1 = new q().a(this.x.g.getBytes());
      break label516;
      localObject1 = new oicq.wlogin_sdk.b.k().a(t.K);
      localObject2 = new ab();
      Object localObject3 = util.get_os_type();
      byte[] arrayOfByte1 = util.get_os_version();
      m = t.B;
      byte[] arrayOfByte2 = t.A;
      byte[] arrayOfByte3 = t.D;
      localObject2 = ((ab)localObject2).a((byte[])localObject3, arrayOfByte1, m, arrayOfByte2, new byte[0], arrayOfByte3);
      localObject3 = new af().a(t.R, t.S, t.T, t.W, t.G, t.y, t.N);
      arrayOfByte1 = new be().a(t.G);
      localObject1 = new an().a((byte[])localObject1, (byte[])localObject2, (byte[])localObject3, arrayOfByte1, localasync_context._tgtgt_key);
      break label516;
      localObject1 = new ao().a(t.y);
      break label516;
      localObject1 = new aq().a(paramLong1, t.E, t.F);
      break label516;
      localObject1 = localObject2;
      if ((paramInt4 & 0x80) == 0) {
        break label516;
      }
      localObject1 = new az().b(t.v);
      break label516;
      localObject1 = localObject2;
      if (paramArrayOfByte6 == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (paramArrayOfByte6.length == 0) {
        break label516;
      }
      localObject1 = new bc().a(paramArrayOfByte6);
      break label516;
      localObject1 = new av().b(this.x.i);
      break label516;
      localObject1 = new ak().b(t.A, t.B, t.D);
      break label516;
      localObject1 = new cq().a(0, t.s, 0);
      break label516;
      localObject1 = localObject2;
      if (paramList == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (paramList.size() == 0) {
        break label516;
      }
      localObject1 = new cp().a(paramList);
      break label516;
      localObject1 = localObject2;
      if (this.x.p == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (this.x.p.length == 0) {
        break label516;
      }
      localObject1 = new bg().a(this.x.p);
      break label516;
      localObject1 = localObject2;
      if (paramInt3 != 3) {
        break label516;
      }
      localObject1 = new bv().b(1);
      break label516;
      localObject3 = this.x.a(paramLong3, paramLong1);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._G == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._G.length == 0) {
        break label516;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._dpwd == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._dpwd.length == 0) {
        break label516;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._randseed == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (((WloginSigInfo)localObject3)._randseed.length == 0) {
        break label516;
      }
      localObject1 = new ck().a(((WloginSigInfo)localObject3)._G, paramLong3, t.y, ((WloginSigInfo)localObject3)._dpwd, paramLong1, paramLong2, ((WloginSigInfo)localObject3)._randseed);
      break label516;
      localObject1 = localObject2;
      if (t.L == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (t.L.length == 0) {
        break label516;
      }
      localObject1 = new bx().a(t.L);
      break label516;
      localObject1 = localObject2;
      if (t.M == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (t.M.length == 0) {
        break label516;
      }
      localObject1 = new by().a(t.M);
      break label516;
      localObject1 = localObject2;
      if (t.J == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (t.J.length == 0) {
        break label516;
      }
      localObject1 = new cc().a(t.J);
      break label516;
      localObject1 = new bz().a(E);
      break label516;
      localObject1 = localObject2;
      if (F == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (F.length == 0) {
        break label516;
      }
      localObject1 = new ch().a(F, G, "qq".getBytes(), H);
      break label516;
      localObject1 = localObject2;
      if (t.P == null) {
        break label516;
      }
      localObject1 = localObject2;
      if (t.P.length == 0) {
        break label516;
      }
      localObject1 = new ci().a(t.P, t.Q);
      break label516;
      localObject1 = new bj().a(1472635589L, "6.3.1.1668");
      break label516;
      localObject1 = new a(1302);
      localObject2 = new byte[4];
      util.int32_to_buf((byte[])localObject2, 0, t.ad);
      ((a)localObject1).a((byte[])localObject2, 4);
      localObject1 = ((a)localObject1).a();
      break label516;
      paramArrayOfByte1 = new byte[i];
      paramInt3 = localArrayList.size();
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt3)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
        paramInt2 += paramArrayOfByte2.length;
        paramInt1 += 1;
      }
      return a(paramArrayOfByte1, this.u, paramInt3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */