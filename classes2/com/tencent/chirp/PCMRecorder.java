package com.tencent.chirp;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import jkg;

public class PCMRecorder
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "PCMRecorder";
  public static final int b = -2;
  private static final int c = 2;
  private static final int d = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private PCMRecorder.OnQQRecorderListener jdField_a_of_type_ComTencentChirpPCMRecorder$OnQQRecorderListener;
  private volatile jkg jdField_a_of_type_Jkg;
  private int e;
  private int f;
  
  public PCMRecorder(Context paramContext, int paramInt, PCMRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 44100;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.e = paramInt;
    this.f = (paramInt / 50 * 2 * 2);
    this.jdField_a_of_type_ComTencentChirpPCMRecorder$OnQQRecorderListener = paramOnQQRecorderListener;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Jkg != null)
    {
      this.jdField_a_of_type_Jkg.a = false;
      this.jdField_a_of_type_Jkg = null;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Jkg == null)
    {
      this.jdField_a_of_type_Jkg = new jkg(this);
      this.jdField_a_of_type_Jkg.start();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\chirp\PCMRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */