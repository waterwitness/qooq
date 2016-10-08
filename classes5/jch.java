import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;

class jch
  extends Thread
{
  jch(jcg paramjcg, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Jcg.a.app, 1, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Jcg.a.runOnUiThread(new jci(this, localFaceDrawable));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */