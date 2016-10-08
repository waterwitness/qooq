package com.tencent.av.widget.stageview;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class StageEffectView$StageMember
{
  public long a;
  public Drawable a;
  public MemberEffect a;
  public final String a;
  public String b;
  
  public StageEffectView$StageMember(String paramString, Drawable paramDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public StageEffectView$StageMember(String paramString1, String paramString2, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.b = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof StageMember)) && (((StageMember)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\stageview\StageEffectView$StageMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */