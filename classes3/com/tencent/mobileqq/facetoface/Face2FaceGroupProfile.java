package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Face2FaceGroupProfile
  extends Face2FaceUserData
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public Face2FaceGroupProfile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(2, paramString1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString2;
    this.b = paramString3;
    this.c = paramString4;
    this.d = paramString5;
    if (this.b == null) {
      this.b = "";
    }
    if (this.e == null) {
      this.e = "";
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Face2FaceGroupProfile))
    {
      paramObject = (Face2FaceGroupProfile)paramObject;
      bool1 = bool2;
      if (this.b.equals(((Face2FaceGroupProfile)paramObject).b))
      {
        bool1 = bool2;
        if (this.e.equals(((Face2FaceGroupProfile)paramObject).e)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    return this.e + "_" + this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\facetoface\Face2FaceGroupProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */