package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import javax.microedition.khronos.opengles.GL10;
import uxt;

public class FrameSprite
  extends Sprite
{
  public static final String a;
  public int a;
  private long jdField_a_of_type_Long;
  public FrameSprite.OnFrameEndListener a;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private Texture[] jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private boolean b;
  private boolean c;
  private boolean d;
  private int e = 10;
  private int f = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = FrameSprite.class.getName();
  }
  
  public FrameSprite(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture = new Texture[paramArrayOfString.length];
    a(10);
  }
  
  private Texture a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt]);
        Texture localTexture = this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt];
        return localTexture;
      }
      return null;
    }
    finally {}
  }
  
  private void a(int paramInt, Texture paramTexture)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length > paramInt)) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt] = paramTexture;
    }
  }
  
  private void b(int paramInt)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length > paramInt) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt] != null))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[paramInt].a();
      }
      return;
    }
    finally {}
  }
  
  private void e()
  {
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
      {
        ((Texture)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).c();
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.jdField_a_of_type_Int = ((int)(this.e * 0.8D));
  }
  
  public void a(Context paramContext, SpriteGLView paramSpriteGLView)
  {
    ThreadManager.a(new uxt(this, paramContext, paramSpriteGLView), 8, null, true);
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null))
    {
      i = (int)((float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / (1000.0F / this.e));
      if (i <= this.f) {
        break label284;
      }
      if (i <= this.f + 1) {
        break label177;
      }
      this.f += 1;
      if (this.f >= this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length) {
        break label226;
      }
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[this.f] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[this.f].jdField_a_of_type_Boolean)) {
        break label186;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = a(this.f);
      c();
      super.a(paramGL10, paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "FrameSprite: draw1:" + this.f);
      }
    }
    for (;;)
    {
      return;
      label177:
      this.f = i;
      break;
      label186:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "FrameSprite: mTexture = null:" + this.f);
      }
      e();
      return;
      label226:
      if (this.b) {
        super.a(paramGL10, paramInt1, paramInt2);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
        return;
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
        }
      }
    }
    label284:
    super.a(paramGL10, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture.length)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[i] != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[i].c();
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture[i] = null;
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
    }
    this.jdField_a_of_type_JavaUtilLinkedList = null;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSurfaceviewactionGlTexture = null;
    this.c = true;
    super.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\gl\FrameSprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */