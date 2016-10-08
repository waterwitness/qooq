package com.tencent.av.opengl.effects;

import android.content.Context;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AbstractEffects
{
  Context a;
  public GLRootView a;
  
  public AbstractEffects(Context paramContext, GLRootView paramGLRootView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a() {}
  
  public void a(GLCanvas paramGLCanvas) {}
  
  public void b() {}
  
  public void b(GLCanvas paramGLCanvas) {}
  
  public void c() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\effects\AbstractEffects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */