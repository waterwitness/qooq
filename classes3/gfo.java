import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gfo
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  
  public gfo(VideoController paramVideoController, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int < 0)
    {
      VcSystemInfo.a();
      long l = VcSystemInfo.c();
      int i = VcSystemInfo.f();
      int j = Build.VERSION.SDK_INT;
      if ((i < 4) || (l / 1000L < 800L) || (j < 9)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_Int = 0;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().b == 1L) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_p_of_type_JavaLangString });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.g();
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Gfo = null;
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), this.jdField_a_of_type_JavaLangString });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */