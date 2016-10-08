import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;

class mmr
  implements Runnable
{
  mmr(mmq parammmq, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Mmq.a.app, 1, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Mmq.a.runOnUiThread(new mms(this, localFaceDrawable));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */