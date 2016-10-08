import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.qphone.base.util.QLog;

public class tav
  implements Runnable
{
  public tav(MagicFaceSuperBigDecoder paramMagicFaceSuperBigDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l2;
    label669:
    int i;
    label698:
    long l1;
    for (;;)
    {
      long l3;
      Object localObject;
      try
      {
        if (!QLog.isColorLevel()) {
          break label698;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run begins, isStartDecodr:" + this.a.jdField_a_of_type_Boolean);
      }
      catch (Exception localException)
      {
        int j;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run ends, error is catched.msg:" + localException.getMessage());
        return;
        this.a.l = j;
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoderReturnYUV(this.a.e, this.a.k, this.a.jdField_f_of_type_ArrayOfByte);
        if (this.a.m != -1) {
          continue;
        }
        this.a.m = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthAlphaDecoder();
        this.a.n = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightAlphaDecoder();
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener == null) {
          continue;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener.a(this.a.c, this.a.jdField_f_of_type_ArrayOfByte, this.a.i, this.a.j, 0.0F);
        l3 = System.currentTimeMillis() - l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run, 【useFrameTime】 " + l3);
        if (l3 >= this.a.jdField_f_of_type_Int) {
          break label669;
        }
        if (localObject <= 0L) {
          continue;
        }
        l2 = this.a.jdField_f_of_type_Int - l3;
        if (l2 <= localObject) {
          break label720;
        }
        Thread.sleep(l2 - localObject);
        break label707;
        Thread.sleep(this.a.jdField_f_of_type_Int - l3);
        l2 = localObject;
        break label711;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        break;
      }
      l2 = System.currentTimeMillis();
      j = this.a.a(this.a.jdField_a_of_type_ArrayOfByte, this.a.h);
      this.a.g = (j - this.a.h);
      if (this.a.g <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run ends, 【condition】 frame len <= 0, videoFrameLength:" + this.a.g);
        return;
      }
      this.a.a(this.a.g, this.a.h, this.a.jdField_a_of_type_ArrayOfByte);
      this.a.h = j;
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoderReturnYUV(this.a.b, this.a.g, this.a.c);
      if (this.a.i == -1)
      {
        this.a.i = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
        this.a.j = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
      }
      j = this.a.a(this.a.d, this.a.l);
      this.a.k = (j - this.a.l);
      this.a.b(this.a.k, this.a.l, this.a.d);
      if (this.a.k <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(MagicFaceSuperBigDecoder.jdField_a_of_type_JavaLangString, 2, "func mDecoder.run ends, 【condition】 frame len <= 0, alphaFrameLength:" + this.a.k);
        return;
      }
      l2 = localObject;
      if (i != 0) {
        break label711;
      }
      i = this.a.jdField_f_of_type_Int;
      l2 = localObject + (l3 - i);
      break label711;
      l1 = 0L;
      i = 1;
    }
    return;
    for (;;)
    {
      label707:
      l2 = l1;
      label711:
      i = 0;
      l1 = l2;
      break;
      label720:
      l1 -= l2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */