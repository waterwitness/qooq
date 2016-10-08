package com.tencent.av.app;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ui.JSInterfacePushData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class SessionInfo
{
  public static int L = 0;
  public static final int a = 0;
  static final String a = "SessionInfo";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public int A;
  public boolean A;
  public int B;
  public boolean B;
  public int C;
  public boolean C;
  public int D;
  public boolean D;
  public int E;
  public boolean E;
  public int F;
  public boolean F;
  public int G;
  public boolean G;
  public int H;
  public boolean H;
  public int I;
  public boolean I;
  public int J;
  public boolean J;
  public int K;
  public boolean K;
  public boolean L;
  public boolean M;
  public boolean N;
  public boolean O;
  public boolean P;
  public boolean Q;
  public boolean R;
  public boolean S;
  public boolean T;
  public boolean U;
  public boolean V;
  public boolean W;
  public boolean X;
  public boolean Y;
  public boolean Z;
  public long a;
  public Bitmap a;
  public Drawable a;
  public SessionInfo.Anychat_Info a;
  public SessionInfo.GuildInfo a;
  public volatile JSInterfacePushData a;
  public ArrayList a;
  public boolean a;
  public byte[] a;
  public long[] a;
  public String[] a;
  public boolean aa;
  public boolean ab;
  public boolean ac;
  public boolean ad;
  public boolean ae;
  public boolean af;
  public boolean ag;
  public boolean ah;
  public boolean ai;
  public boolean aj;
  public boolean ak;
  public boolean al;
  public boolean am;
  public boolean an;
  public boolean ao;
  public boolean ap;
  public boolean aq;
  public boolean ar;
  public boolean as;
  public boolean at;
  public long b;
  public String b;
  public ArrayList b;
  public boolean b;
  public long[] b;
  public long c;
  public String c;
  public ArrayList c;
  public boolean c;
  public long d;
  public String d;
  public ArrayList d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public ArrayList e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public ArrayList f;
  public boolean f;
  public int g;
  public long g;
  public String g;
  public ArrayList g;
  public boolean g;
  public int h;
  public long h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  public int n;
  public String n;
  public boolean n;
  public int o;
  public String o;
  public boolean o;
  public int p;
  public String p;
  public boolean p;
  public int q;
  public String q;
  public boolean q;
  public int r;
  public String r;
  public boolean r;
  public int s;
  public String s;
  public boolean s;
  public int t;
  public String t;
  public boolean t;
  public int u;
  public String u;
  public boolean u;
  public int v;
  public String v;
  public boolean v;
  public int w;
  public String w;
  public boolean w;
  public int x;
  public String x;
  public boolean x;
  public int y;
  public String y;
  public boolean y;
  public int z;
  public String z;
  public boolean z;
  
  public SessionInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.i = 0;
    this.jdField_j_of_type_Int = 0;
    this.l = -1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.k = true;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_m_of_type_Int = -1;
    this.n = true;
    this.p = -1;
    this.jdField_u_of_type_Int = 0;
    this.jdField_v_of_type_Int = 5;
    this.jdField_w_of_type_Int = 5;
    this.jdField_x_of_type_Int = 0;
    this.jdField_y_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_z_of_type_Int = -1;
    this.M = true;
    this.N = true;
    this.E = -1;
    this.F = -1;
    this.G = 0;
    this.H = 1;
    this.I = -1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_w_of_type_JavaLangString = "DEVICE_NONE";
    this.af = true;
    this.J = 7;
    this.K = -1;
    this.jdField_y_of_type_JavaLangString = "";
    this.jdField_z_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info = new SessionInfo.Anychat_Info(this);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo = new SessionInfo.GuildInfo(this);
  }
  
  private boolean a(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((AVPhoneUserInfo)localIterator.next()).telInfo.mobile.equalsIgnoreCase(paramAVPhoneUserInfo.telInfo.mobile)) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(long paramLong)
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    int i1;
    if (paramInt != 0)
    {
      i1 = 0;
      while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          return i1;
        }
        i1 += 1;
      }
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= this.jdField_c_of_type_JavaUtilArrayList.size()) {
        break label112;
      }
      i1 = paramInt;
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Long == paramLong) {
        break;
      }
      paramInt += 1;
    }
    label112:
    return -1;
  }
  
  public SessionInfo.HeroDetail a(String paramString)
  {
    SessionInfo.HeroDetail localHeroDetail2 = (SessionInfo.HeroDetail)this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.a.get(paramString);
    SessionInfo.HeroDetail localHeroDetail1 = localHeroDetail2;
    if (localHeroDetail2 == null)
    {
      localHeroDetail1 = new SessionInfo.HeroDetail(this);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.a.put(paramString, localHeroDetail1);
    }
    return localHeroDetail1;
  }
  
  public AVPhoneUserInfo a(long paramLong, ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      if ((localAVPhoneUserInfo.accountType != 1) && (localAVPhoneUserInfo.account == paramLong)) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  void a()
  {
    this.jdField_c_of_type_Long = 0L;
    this.jdField_j_of_type_Int = 0;
    this.l = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.t = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.r = false;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = false;
    this.jdField_y_of_type_Boolean = false;
    this.jdField_z_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "SessionInfo setAvType:" + paramInt);
    }
    this.D = paramInt;
    L = paramInt;
  }
  
  public void a(int paramInt, VideoViewInfo paramVideoViewInfo)
  {
    long l1 = paramVideoViewInfo.jdField_a_of_type_Long;
    int i1 = paramVideoViewInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Pos = " + paramInt);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e("SessionInfo", 2, "ADD VideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramInt, paramVideoViewInfo);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "resetVideoDisplayListExceptTargetUin-->Uin = " + paramLong + " ,clearRenderFlag" + paramBoolean1 + " ,clearRecvDataFlag" + paramBoolean2);
    }
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong)
      {
        if (paramBoolean1) {
          ((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_Boolean = false;
        }
        if (paramBoolean2) {
          ((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_d_of_type_Boolean = false;
        }
      }
      i1 += 1;
    }
  }
  
  public void a(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "onPhoneUserInfoInRoom info = " + paramAVPhoneUserInfo.toString());
    }
    this.jdField_f_of_type_JavaUtilArrayList.add(paramAVPhoneUserInfo);
  }
  
  public void a(VideoViewInfo paramVideoViewInfo)
  {
    long l1 = paramVideoViewInfo.jdField_a_of_type_Long;
    int i1 = paramVideoViewInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "addVideoViewInfo-->Uin = " + l1 + " ,VideoSrcType = " + i1);
    }
    int i2 = a(l1, i1);
    if ((i2 != -1) && (QLog.isColorLevel())) {
      QLog.e("SessionInfo", 2, "ADD VideoViewInfo Error,The View Info Is Exsit.Uin = " + l1 + " ,VideoSrcType = " + i1 + " ,Index = " + i2);
    }
    this.jdField_c_of_type_JavaUtilArrayList.add(paramVideoViewInfo);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.a.remove(paramString);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "addPhoneUserInfo --> Size = " + paramArrayList.size());
    }
    this.jdField_e_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    if (i1 < paramArrayList.size())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.get(i1);
      if (QLog.isColorLevel()) {
        QLog.d("SessionInfo", 2, "addPhoneUserInfo --> Item Info = " + localAVPhoneUserInfo.toString());
      }
      if ((!a(localAVPhoneUserInfo)) && (this.jdField_e_of_type_JavaUtilArrayList.size() <= 10)) {
        this.jdField_e_of_type_JavaUtilArrayList.add(localAVPhoneUserInfo);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("SessionInfo", 2, "addPhoneUserInfo --> Item has exsit. Info = " + localAVPhoneUserInfo.toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        this.jdField_g_of_type_Boolean = true;
        if (this.jdField_f_of_type_Int != 1) {
          break label47;
        }
        this.jdField_f_of_type_Int = 2;
        label26:
        if ((this.jdField_f_of_type_Int != 4) || (!paramBoolean2)) {}
      }
    }
    label47:
    do
    {
      return;
      this.jdField_f_of_type_Boolean = true;
      break;
      if (this.jdField_f_of_type_Int != 3) {
        break label26;
      }
      this.jdField_f_of_type_Int = 4;
      break label26;
      if (paramBoolean2) {
        this.jdField_g_of_type_Boolean = false;
      }
      while (((this.jdField_f_of_type_Int != 4) || (!paramBoolean2)) || ((this.jdField_f_of_type_Int == 2) && (!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)))
      {
        this.jdField_f_of_type_Int = 1;
        return;
        this.jdField_f_of_type_Boolean = false;
      }
    } while ((this.jdField_f_of_type_Int != 4) || (this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean));
    this.jdField_f_of_type_Int = 3;
  }
  
  public boolean a()
  {
    return (this.jdField_j_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          bool1 = ((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_d_of_type_Boolean;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearDoubleVideoSessionInfo sessionId : " + this.jdField_b_of_type_JavaLangString);
    }
    a();
    d();
  }
  
  public void b(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "onPhoneUserInfoGetOutRoom info = " + paramAVPhoneUserInfo.toString());
    }
    Iterator localIterator = this.jdField_f_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)localIterator.next();
      if (localAVPhoneUserInfo.account == paramAVPhoneUserInfo.account) {
        this.jdField_f_of_type_JavaUtilArrayList.remove(localAVPhoneUserInfo);
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_j_of_type_Int == 0) && ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 2));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearRandomSessionInfo sessionId = " + this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_Int = -1;
  }
  
  public boolean c()
  {
    return this.jdField_j_of_type_Int == 1;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo = new SessionInfo.GuildInfo(this);
  }
  
  public boolean d()
  {
    return (this.jdField_j_of_type_Int == 2) || (this.jdField_j_of_type_Int == 7);
  }
  
  public void e()
  {
    a();
    this.I = -1;
    this.V = false;
    this.W = false;
    this.X = false;
    this.Y = false;
    this.Z = false;
    this.aa = false;
    this.ac = false;
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_u_of_type_JavaLangString = null;
    this.jdField_v_of_type_JavaLangString = null;
    f();
    a(0);
  }
  
  public boolean e()
  {
    return this.jdField_j_of_type_Int == 3;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionInfo", 2, "clearPhoneUserInfo");
    }
    this.jdField_e_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean f()
  {
    return this.jdField_j_of_type_Int == 4;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public boolean g()
  {
    return this.jdField_j_of_type_Int == 5;
  }
  
  public boolean h()
  {
    return this.jdField_j_of_type_Int == 6;
  }
  
  public boolean i()
  {
    return this.jdField_j_of_type_Int == 15;
  }
  
  public boolean j()
  {
    return (this.jdField_f_of_type_Int == 3) || (this.jdField_f_of_type_Int == 4) || ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3));
  }
  
  public boolean k()
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_d_of_type_Boolean) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean l()
  {
    return (this.jdField_f_of_type_Int == 2) || (this.jdField_f_of_type_Int == 4);
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((VideoViewInfo)this.jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Boolean) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean n()
  {
    return this.jdField_u_of_type_Int == 1;
  }
  
  public boolean o()
  {
    return (this.jdField_v_of_type_Int == 4) || (this.jdField_v_of_type_Int == 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\app\SessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */