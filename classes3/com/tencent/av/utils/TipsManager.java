package com.tencent.av.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hbw;
import hbx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TipsManager
{
  public static final int A = 26;
  public static final int B = 27;
  public static final int C = 28;
  public static final int D = 29;
  public static final int E = 30;
  public static final int F = 31;
  public static final int G = 32;
  public static final int H = 33;
  public static final int I = 34;
  public static final int J = 35;
  public static final int K = 36;
  public static final int L = 37;
  public static final int M = 38;
  public static final int N = 39;
  public static final int O = 40;
  public static final int P = 41;
  public static final int Q = 42;
  public static final int R = 43;
  public static final int S = 44;
  public static final int T = 45;
  public static final int U = 46;
  public static final int V = 47;
  public static final int W = 48;
  public static final int X = 49;
  public static final int Y = 50;
  public static final int Z = 51;
  public static final int a = 0;
  public static ResidentTip a;
  static final String jdField_a_of_type_JavaLangString = "TipsManager";
  public static final int aa = 52;
  public static final int ab = 53;
  public static final int ac = 54;
  public static final int ad = 55;
  public static final int ae = 56;
  public static final int af = 57;
  public static final int ag = 58;
  public static final int ah = 59;
  public static final int ai = 60;
  public static final int aj = 61;
  public static final int ak = 62;
  public static final int al = 63;
  public static final int am = 64;
  public static final int an = 65;
  public static final int ao = 66;
  public static final int ap = 67;
  public static final int aq = 68;
  public static final int ar = 69;
  public static final int as = 70;
  public static final int at = 71;
  public static final int au = 72;
  public static final int av = 73;
  public static final int aw = 74;
  public static final int ax = 75;
  public static final int ay = 76;
  public static final int az = 77;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = 15;
  public static final int q = 16;
  public static final int r = 17;
  public static final int s = 18;
  public static final int t = 19;
  public static final int u = 20;
  public static final int v = 21;
  public static final int w = 22;
  public static final int x = 23;
  public static final int y = 24;
  public static final int z = 25;
  public Handler a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  public LinearLayout a;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map a;
  boolean jdField_a_of_type_Boolean = false;
  int aA = 0;
  public int aB = 0;
  int aC = 0;
  int aD = 0;
  public TextView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new hbx(this);
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  boolean c = false;
  boolean d = true;
  public boolean e = false;
  private boolean f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentAvUtilsResidentTip = new ResidentTip(0, null);
  }
  
  public TipsManager(VideoAppInterface paramVideoAppInterface, LinearLayout paramLinearLayout)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131297996));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131297995));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131298950));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new hbw(this);
  }
  
  private void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TipsManager.TipsListener localTipsListener = (TipsManager.TipsListener)localIterator.next();
        if (localTipsListener != null) {
          localTipsListener.a(paramBoolean1, paramInt, paramBoolean2, paramLong, paramString, paramBoolean3, paramBoolean4);
        }
      }
    }
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "setResidentTips-->type=" + paramInt + " ,wording" + paramString + " ,originalType=" + jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int);
    }
    if (paramInt > jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int)
    {
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int = paramInt;
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_JavaLangString = paramString;
      return true;
    }
    return false;
  }
  
  public static void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "removeResidentTips-->type=" + paramInt);
    }
    if ((paramInt == jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int) || (paramInt == 108))
    {
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int = 0;
      jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public void a()
  {
    this.d = false;
    c();
  }
  
  void a(int paramInt)
  {
    this.aB = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    String str = ((VideoController)localObject).a().c;
    int i1 = ((VideoController)localObject).b(str);
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showTips mCurrentType = " + this.aB + " # mFullScreen = " + this.c + " # mCurrentState = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    long l1 = 32767L;
    label437:
    boolean bool2;
    boolean bool1;
    label446:
    boolean bool3;
    switch (this.aB)
    {
    case 11: 
    case 36: 
    case 40: 
    case 48: 
    case 62: 
    case 63: 
    case 64: 
    case 67: 
    case 69: 
    case 70: 
    default: 
      a();
      i1 = 0;
      bool2 = false;
      bool1 = true;
      b(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_b_of_type_JavaLangString != null) {
        b(bool1, bool2);
      }
      if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int == 0)
      {
        bool3 = true;
        label497:
        a(true, paramInt, l1, bool3, this.jdField_b_of_type_JavaLangString, bool1, bool2);
        if ((!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) && (this.d)) {
          break label4094;
        }
        c();
      }
      break;
    }
    while (i1 != 0)
    {
      a();
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363677);
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363183);
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d();
        if (!this.c) {
          break label437;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l1 = 3000L;
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363188);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363189);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l1 = 3000L;
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363190);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363178);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363675);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l1 = 3000L;
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363179);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        if (((VideoController)localObject).b(str) == 5)
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363187);
          this.aC = this.aB;
          i1 = 0;
          bool2 = false;
          bool1 = true;
          break label446;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363594);
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      a();
      this.aC = 0;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363186);
        this.aC = this.aB;
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      a();
      this.aC = 0;
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363615);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363616);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (this.f) {}
        for (i1 = 2131363866;; i1 = 2131363193)
        {
          this.jdField_b_of_type_JavaLangString = ((BaseApplication)localObject).getString(i1);
          this.aC = this.aB;
          i1 = 0;
          bool2 = false;
          bool1 = true;
          break;
        }
      }
      if (!this.f) {}
      for (this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363195);; this.jdField_b_of_type_JavaLangString = "")
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        this.aC = 0;
        l1 = 3000L;
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363685);
        this.aC = this.aB;
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      e();
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (this.f) {}
        for (i1 = 2131363865;; i1 = 2131363198)
        {
          this.jdField_b_of_type_JavaLangString = ((BaseApplication)localObject).getString(i1);
          i1 = 0;
          bool2 = false;
          bool1 = true;
          break;
        }
      }
      e();
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363199);
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      e();
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      g();
      i1 = ((VideoController)localObject).a().a.jdField_a_of_type_Int;
      if ((i1 == 3) || (i1 == 1))
      {
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      i1 = 0;
      bool2 = true;
      bool1 = false;
      break label446;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363825);
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363827);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363826);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363914);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363570);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363237);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363182);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363591);
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363608);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = true;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363607);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = true;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363592);
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363609);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      l1 = 5000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363610);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363609);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363457);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      l1 = 30000L;
      i1 = 0;
      bool2 = true;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363191);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363192);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363656);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363657);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363604);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363605);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363664);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363617);
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363650);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363651);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363649);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363654);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131368275);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363655);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363652);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363653);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363667);
        i1 = 0;
        bool2 = true;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = true;
      bool1 = false;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363709);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      int i2 = ((VideoController)localObject).c(str);
      if (((VideoController)localObject).a().l == 1011) {
        if (i2 < 45) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363660);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l1 = 3000L;
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break;
        if (!VcSystemInfo.h()) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363290);
        } else if (!VcSystemInfo.d()) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363289);
        } else if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363284);
        } else if (i2 < 16) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363659);
        } else if ((i1 != 4) && (i1 != 2) && (i1 != 3)) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363660);
        }
      }
      if ((i1 != 4) && (i1 != 2)) {}
      for (this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363662);; this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363663))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        l1 = 3000L;
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363661);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363285);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      l1 = 3000L;
      i1 = 0;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363820);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      i1 = 1;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363821);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      i1 = 1;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363807);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      i1 = 1;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363840);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      i1 = 1;
      bool2 = false;
      bool1 = true;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363722);
        UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString);
        i1 = 0;
        bool2 = false;
        bool1 = false;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363886);
        UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        l1 = 2000L;
        i1 = 0;
        bool2 = false;
        bool1 = true;
        break label446;
      }
      a();
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363220);
      this.aC = this.aB;
      i1 = 0;
      bool2 = false;
      bool1 = false;
      break label446;
      bool3 = false;
      break label497;
      label4094:
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showApnTips type = " + paramInt1);
    }
    this.aA = paramInt2;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) || (!this.d)) {
      c();
    }
    while ((paramInt1 != 37) || ((this.aB > paramInt1) && (this.aB < 100))) {
      return;
    }
    if ((this.aB > 0) && (this.aB <= 33))
    {
      this.jdField_b_of_type_Boolean = true;
      this.aC = this.aB;
    }
    a(paramInt1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showNetTips-->Type=" + paramInt + " Str=" + paramString);
    }
    if ((paramString == null) && (this.aB != paramInt)) {}
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) || (!this.d))
        {
          c();
          return;
        }
      } while ((this.aB > paramInt) && (this.aB < 100));
      this.aB = paramInt;
      this.jdField_b_of_type_JavaLangString = paramString;
      if (this.jdField_b_of_type_JavaLangString == null) {
        break;
      }
      a(paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("TipsManager", 2, "showNetTips type = " + paramInt + " # msg = " + this.jdField_b_of_type_JavaLangString);
    return;
    a();
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showTips-->Str =" + paramString + " type=" + paramInt1 + " period=" + paramLong + " flag=" + paramInt2);
    }
    if ((this.aB <= 100) && (paramInt1 < this.aB))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "showTips-->Type<mCurrentType,mCurrentType=" + this.aB);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showTips-->type =" + paramInt1 + " ,str=" + paramString + " ,period=" + paramLong + " ,flag=" + paramInt2);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    b(paramInt1);
    this.aB = paramInt1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) || (!this.d))
    {
      c();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    if (paramLong > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    }
    boolean bool1;
    label314:
    boolean bool2;
    if (paramInt2 == 0)
    {
      b(false, false);
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label439;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label433;
      }
      bool1 = true;
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        break label451;
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
        break label445;
      }
      bool2 = true;
      label334:
      if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int != 0) {
        break label457;
      }
    }
    label433:
    label439:
    label445:
    label451:
    label457:
    for (boolean bool3 = true;; bool3 = false)
    {
      a(true, paramInt1, paramLong, bool3, paramString, bool1, bool2);
      return;
      if (paramInt2 == 1)
      {
        b(true, false);
        break;
      }
      if (paramInt2 == 2)
      {
        b(false, true);
        break;
      }
      b(false, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TipsManager", 2, "showTips-->flag value is wrong:" + paramInt2);
      break;
      bool1 = false;
      break label314;
      bool1 = false;
      break label314;
      bool2 = false;
      break label334;
      bool2 = false;
      break label334;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.aB = paramInt;
    label32:
    label58:
    label82:
    boolean bool;
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      if ((paramInt != 106) && (paramInt != 103)) {
        break label155;
      }
      b(false, true);
      if (this.jdField_b_of_type_JavaLangString == null) {
        break label179;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      b(paramInt);
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label204;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label199;
      }
      paramBoolean = true;
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        break label215;
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
        break label209;
      }
      bool = true;
      label102:
      a(true, paramInt, 2147483647L, true, this.jdField_b_of_type_JavaLangString, paramBoolean, bool);
      if ((!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().p) && (this.d)) {
        break label221;
      }
      c();
    }
    label155:
    label179:
    label199:
    label204:
    label209:
    label215:
    label221:
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      return;
      this.jdField_b_of_type_JavaLangString = null;
      break;
      if (paramInt == 107)
      {
        b(true, false);
        break label32;
      }
      b(false, false);
      break label32;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label58;
      paramBoolean = false;
      break label82;
      paramBoolean = false;
      break label82;
      bool = false;
      break label102;
      bool = false;
      break label102;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showStatusTipWithoutOrder-->TYPE=" + paramInt + " flag=" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramInt);
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131297996));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131297995));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131298950));
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getColor(2131427779));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839247);
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839248);
      }
    } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "removeTips");
    }
    if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int != 0)
    {
      int i1 = jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int;
      String str = jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_JavaLangString;
      if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int == 106) {}
      for (boolean bool = true;; bool = false)
      {
        a(i1, str, bool);
        return false;
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    b(false, false);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    f();
    this.jdField_b_of_type_JavaLangString = null;
    this.aB = 0;
    a(false, 0, 0L, false, this.jdField_b_of_type_JavaLangString, false, false);
    return true;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "remove tip Type=" + paramInt);
    }
    if (this.aB == paramInt)
    {
      a();
      return true;
    }
    return false;
  }
  
  public boolean a(TipsManager.TipsListener paramTipsListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramTipsListener) != -1) {
        return false;
      }
      boolean bool = this.jdField_a_of_type_JavaUtilArrayList.add(paramTipsListener);
      return bool;
    }
  }
  
  public void b()
  {
    this.d = true;
    d();
  }
  
  void b(int paramInt)
  {
    if (paramInt == 104) {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
      {
        if (!this.c) {
          break label39;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    label39:
    while ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showStatusTips type = " + paramInt);
    }
    if ((this.aB != paramInt) || (this.jdField_a_of_type_Boolean != paramBoolean))
    {
      if ((this.aB == 28) && (this.jdField_a_of_type_Boolean) && (paramInt != 42) && (paramInt != 41) && (paramInt != 28))
      {
        this.jdField_b_of_type_Boolean = true;
        this.aC = this.aB;
      }
      if ((paramInt >= this.aB) || (this.aB >= 100))
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        a(paramInt);
      }
    }
    else
    {
      return;
    }
    if (((paramInt == 21) || (paramInt == 19)) && ((this.aB == 28) || (this.aB == 27) || (this.aB == 26)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TipsManager", 2, "show");
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_Boolean = true;
      this.aC = this.aB;
      a(paramInt);
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.aC = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "setFullScreenFlag: " + this.c);
    }
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (((this.aB != 0) || (!localVideoController.a().d)) || (((!paramBoolean) || (this.aB != 26)) || (((!paramBoolean) || (this.aB != 28)) || ((paramBoolean) && (this.aB == 14))))) {
      a();
    }
    if (this.aB == 104)
    {
      if (paramBoolean) {
        f();
      }
    }
    else {
      return;
    }
    b(this.aB);
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean1)
      {
        i1 = 0;
        ((ImageView)localObject).setVisibility(i1);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!paramBoolean2) {
        break label62;
      }
    }
    label62:
    for (int i1 = i2;; i1 = 8)
    {
      ((ProgressBar)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
    }
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean b(TipsManager.TipsListener paramTipsListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilArrayList.remove(paramTipsListener);
      return bool;
    }
  }
  
  public void c()
  {
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    a(false, this.aB, 0L, false, this.jdField_b_of_type_JavaLangString, false, false);
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public void d()
  {
    if (this.d)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((this.aB == 70) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "recoverTips");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      a(this.aC);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    a();
  }
  
  void f()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  void g()
  {
    f();
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "mApnType = " + this.aA);
    }
    int i1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().a.jdField_a_of_type_Int;
    switch (this.aA)
    {
    default: 
      return;
    case 0: 
      if (this.f)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363863);
        b(false, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        return;
        if ((i1 == 3) || (i1 == 1))
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363341);
          b(false, false);
        }
        else
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363340);
          b(false, true);
        }
      }
    case 2: 
      if (this.f)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363861);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        b(false, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        return;
        if ((i1 == 3) || (i1 == 1))
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363343);
          b(false, false);
        }
        else
        {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363339);
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          b(false, true);
        }
      }
    }
    if (this.f)
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363862);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      b(false, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      return;
      if ((i1 == 3) || (i1 == 1))
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363342);
        b(false, false);
      }
      else
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getString(2131363338);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        b(false, true);
      }
    }
  }
  
  public void h()
  {
    b(false, false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    int i1 = this.aB;
    if (jdField_a_of_type_ComTencentAvUtilsResidentTip.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(false, i1, 0L, bool, this.jdField_b_of_type_JavaLangString, false, false);
      return;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\TipsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */