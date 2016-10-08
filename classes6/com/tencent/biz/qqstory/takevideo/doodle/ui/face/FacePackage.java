package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class FacePackage
{
  public Drawable a;
  public final String a;
  public String b;
  public String c;
  public String d;
  
  public FacePackage(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("FacePackage'id can not be null.");
    }
    this.a = paramString;
  }
  
  public abstract int a();
  
  public abstract String a();
  
  public abstract String a(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\FacePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */