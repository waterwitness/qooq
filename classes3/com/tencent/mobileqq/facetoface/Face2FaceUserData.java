package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class Face2FaceUserData
{
  public int a;
  public String e;
  
  public Face2FaceUserData(int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 1;
    this.a = paramInt;
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Face2FaceUserData))
    {
      paramObject = (Face2FaceUserData)paramObject;
      if (this.e == null) {
        if ((this.a != ((Face2FaceUserData)paramObject).a) || (((Face2FaceUserData)paramObject).e != null)) {}
      }
      while ((this.a == ((Face2FaceUserData)paramObject).a) && (this.e.equals(((Face2FaceUserData)paramObject).e)))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\facetoface\Face2FaceUserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */