package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import wdt;
import wdu;

public class VoicePlayer
  implements IPttPlayerListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 500;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = 50;
  public static final int n = 200;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IPttPlayer jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new wdt(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private int o;
  private int p;
  
  public VoicePlayer(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = new AmrPlayer(paramContext, paramInt);
    this.o = 1;
    this.p = 1;
  }
  
  public VoicePlayer(String paramString, Handler paramHandler)
  {
    this(paramString, paramHandler, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VoicePlayer(String paramString, Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = new AmrPlayer();
    }
    for (this.p = 2;; this.p = 3)
    {
      this.o = 1;
      return;
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = new SilkPlayer();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 0;
    if (this.b) {
      AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (paramBoolean) {}
    for (this.o = 8;; this.o = 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
      {
        i1 = i2;
        if (this.o == 4) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.b();
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.e();
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).a(this.o, this.jdField_a_of_type_JavaLangString, i1);
      }
    }
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a();
    }
    return 0;
  }
  
  private int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.b();
    }
    return 0;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onCompletion duration=" + d() + " current=" + c() + " enableEndBuffer=" + this.jdField_a_of_type_Boolean + " thread=" + Thread.currentThread().getName());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.o = 7;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new wdu(this), 500L);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  public int a()
  {
    return this.o;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    g();
  }
  
  public void a(IPttPlayer paramIPttPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.VoicePlayer", 2, "onError what=" + paramInt1 + " extra=" + paramInt2);
    }
    a(true);
  }
  
  public void a(VoicePlayer.VoicePlayerListener paramVoicePlayerListener)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramVoicePlayerListener)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramVoicePlayerListener);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public boolean a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.b = true;
    }
    return this.b;
  }
  
  public int b()
  {
    return this.p;
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.o == 1)
    {
      try
      {
        this.o = 2;
        if (this.p != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.g();
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          a(true);
        }
      }
      if (this.b) {
        AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "start to play...  for test time=" + System.currentTimeMillis());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      if (this.o == 3)
      {
        this.o = 2;
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a();
        if (this.b) {
          AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
        }
        QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer instanceof AmrPlayer))
    {
      this.o = 2;
      ((AmrPlayer)this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer).b();
      if (this.b) {
        AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void e()
  {
    if (this.o == 7) {}
    for (;;)
    {
      return;
      if (this.b) {
        AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
      }
      this.o = 3;
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).b(this.jdField_a_of_type_JavaLangString, d(), c());
      }
    }
  }
  
  public void f()
  {
    if (this.b) {
      AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
    }
    this.o = 6;
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\VoicePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */