package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NearbyUser
  extends Face2FaceUserData
{
  public String a;
  public boolean a;
  public String b;
  
  public NearbyUser(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    super(1, paramString1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\facetoface\NearbyUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */