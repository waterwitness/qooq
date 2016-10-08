package com.tencent.mobileqq.app.soso;

import android.os.SystemClock;
import android.util.AndroidRuntimeException;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class SosoInterface$OnLocationListener
{
  private boolean a;
  public int b;
  public String b;
  private boolean b;
  protected int c;
  protected String c;
  public long d;
  protected long e;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  
  public SosoInterface$OnLocationListener(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 3;
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Int = paramInt;
      this.h = paramBoolean2;
      this.g = paramBoolean1;
      this.f = paramBoolean4;
      this.jdField_e_of_type_Boolean = paramBoolean3;
      this.jdField_e_of_type_Long = paramLong;
      this.d = SystemClock.elapsedRealtime();
      return;
    }
    throw new AndroidRuntimeException("invalid level=" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public abstract void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\soso\SosoInterface$OnLocationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */