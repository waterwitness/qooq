package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Face2FaceUserProfile
  extends Face2FaceUserData
{
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  public Face2FaceUserProfile(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    super(2, paramString1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString2;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString3;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\facetoface\Face2FaceUserProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */