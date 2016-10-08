package com.tencent.biz.qqstory.takevideo.publish;

import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class GenerateDoodleArgs
{
  public final String a;
  public final WeakReference a;
  
  public GenerateDoodleArgs(DoodleLayout paramDoodleLayout, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleLayout);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "GenerateDoodleArgs{" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateDoodleArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */