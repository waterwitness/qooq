import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwThumbGen;
import com.tencent.mobileqq.utils.FileUtils;

class uqp
  extends AsyncTask
{
  uqp(uqo paramuqo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramVarArgs = uqo.a(this.a) + "shortvideo_thumb" + ".jpg";
    int j = this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.a(uqo.b(this.a), SVHwEncoder.f(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.g(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.b(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), paramVarArgs);
    int i = j;
    String str;
    if (j == 0)
    {
      str = ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString, "jpg");
      if (!FileUtils.c(paramVarArgs, str)) {
        break label183;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.b = str;
      i = j;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.e = i;
      uqo.a(this.a, true);
      return Integer.valueOf(i);
      label183:
      i = j;
      if (!FileUtils.b(str))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("doInBackground()", "rename failure, mThumbFilePath = " + paramVarArgs + ",thumbPath=" + str);
        i = -3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */