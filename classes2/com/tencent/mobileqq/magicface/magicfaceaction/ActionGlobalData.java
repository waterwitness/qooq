package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Timer;
import java.util.TimerTask;
import tau;

public class ActionGlobalData
{
  public static final String a = "%param%";
  public static final String b = "mic";
  public static final String c = "gravity";
  public static final String d = "touch";
  public static final String e = "non-ver";
  public static final String f = "send";
  public static final String g = "receive";
  private static final int n = 100;
  public float a;
  public int a;
  private ActionGlobalData.ActionCountdownOver jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver;
  public MagicfacebackText a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public String n;
  private int o;
  public String o;
  public String p;
  
  public ActionGlobalData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.h = "send";
    this.jdField_c_of_type_Boolean = true;
    this.i = "non-ver";
    this.f = 50;
    this.g = 30;
    this.e = true;
    this.jdField_a_of_type_JavaUtilTimerTask = new tau(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = this.jdField_c_of_type_Int;
    ThreadManager.a().schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 100L);
  }
  
  public void a(ActionGlobalData.ActionCountdownOver paramActionCountdownOver)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver = paramActionCountdownOver;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\magicfaceaction\ActionGlobalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */