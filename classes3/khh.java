import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;

class khh
  implements Runnable
{
  khh(khg paramkhg, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Khg.a.app, this.jdField_a_of_type_JavaLangString, (byte)3);
      ((ImageView)this.jdField_a_of_type_Khg.a.a.getChildAt(this.jdField_a_of_type_Int).findViewById(2131296790)).setImageDrawable(localFaceDrawable);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */