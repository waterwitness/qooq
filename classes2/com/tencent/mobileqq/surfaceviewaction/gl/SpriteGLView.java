package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import uxu;
import uxv;
import uxw;
import uxx;

public class SpriteGLView
  extends GLSurfaceView
{
  private Object jdField_a_of_type_JavaLangObject;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  private List b;
  
  public SpriteGLView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.b = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    b();
  }
  
  public SpriteGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.b = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    b();
  }
  
  private void b()
  {
    getHolder().setFormat(-3);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setRenderer(new uxx(this, null));
  }
  
  public void a()
  {
    onPause();
    queueEvent(new uxw(this));
  }
  
  public void a(int paramInt, Sprite paramSprite)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == paramSprite) {
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramSprite);
  }
  
  public void a(Sprite paramSprite)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == paramSprite) {
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramSprite);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.b.add(paramRunnable);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  public void b(Sprite paramSprite)
  {
    a(new uxv(this, paramSprite));
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_JavaUtilList.get(i) == paramSprite) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((this.jdField_a_of_type_JavaUtilList.get(i) instanceof uxu)) && (((uxu)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramMotionEvent, getWidth(), getHeight()))) {
        return true;
      }
      i += 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\gl\SpriteGLView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */