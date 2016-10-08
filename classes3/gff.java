import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gff
  implements Runnable
{
  public gff(VideoController paramVideoController, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a.a(3000, this.jdField_a_of_type_JavaLangString, null, true, true);
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a.a(1004, this.b, this.jdField_a_of_type_JavaLangString);
    QAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a).a(this.c, str, localBitmap, this.jdField_a_of_type_JavaLangString, 57, 3000, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */