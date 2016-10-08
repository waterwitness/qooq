import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class uxt
  implements Runnable
{
  public uxt(FrameSprite paramFrameSprite, Context paramContext, SpriteGLView paramSpriteGLView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    int i = 0;
    Object localObject1;
    while ((i < FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).length) && (!FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)))
    {
      localObject1 = new Texture(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)[i]);
      FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite, i, (Texture)localObject1);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(FrameSprite.jdField_a_of_type_JavaLangString, 2, "FrameSprite: read time = " + (System.currentTimeMillis() - l));
    }
    l = System.currentTimeMillis();
    i = 0;
    if ((i < FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).length) && (!FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)))
    {
      if ((FrameSprite.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite)) && (i % 2 != 0)) {}
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d(FrameSprite.jdField_a_of_type_JavaLangString, 2, "FrameSprite: deode:" + i);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite;
        int j;
        if (FrameSprite.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite))
        {
          j = i / 2;
          FrameSprite.a((FrameSprite)localObject1, j);
          if (i != this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.jdField_a_of_type_Int - 1) {
            break label399;
          }
          if ((FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite) != 20) || ((int)(System.currentTimeMillis() - l) / this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.jdField_a_of_type_Int <= 50)) {
            break label392;
          }
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a(10);
          FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite, true);
          localObject1 = FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite);
          FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite, new Texture[FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).length / 2]);
          j = 0;
          int k = 0;
          label312:
          if (j >= FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).length) {
            break label392;
          }
          if (j % 2 != 0) {
            break label360;
          }
          FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite, k, localObject1[j]);
          k += 1;
        }
        for (;;)
        {
          j += 1;
          break label312;
          j = i;
          break;
          try
          {
            label360:
            FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).remove(localObject1[j]);
            localObject1[j].c();
          }
          finally {}
        }
        label392:
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.a();
        label399:
        while ((FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite) != null) && (FrameSprite.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite).size() >= this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite.jdField_a_of_type_Int)) {
          try
          {
            Thread.sleep(16L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */