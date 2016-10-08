package com.tencent.mobileqq.voicechange;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VoiceChangeModeParams
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  boolean c;
  boolean d;
  boolean e;
  
  public VoiceChangeModeParams(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
    this.c = true;
    this.d = false;
    this.e = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.e = paramBoolean5;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static VoiceChangeModeParams a()
  {
    return new VoiceChangeModeParams(true, false, true, true, true, null);
  }
  
  public static VoiceChangeModeParams a(String paramString)
  {
    return new VoiceChangeModeParams(false, true, true, false, true, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\voicechange\VoiceChangeModeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */