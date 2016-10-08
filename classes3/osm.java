import android.content.Intent;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class osm
  implements Runnable
{
  public osm(SendPhotoActivity.sendPhotoTask paramsendPhotoTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.a.a();
      this.a.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra(AlbumConstants.i, 2);
      if (!this.a.jdField_a_of_type_AndroidContentIntent.hasExtra("extra_image_sender_tag")) {
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("open_chatfragment_fromphoto", true);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("param_selNum", this.a.jdField_b_of_type_JavaUtilArrayList.size());
      if (!this.a.jdField_c_of_type_Boolean)
      {
        ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
        ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2130968586);
        if (!this.a.jdField_b_of_type_Boolean)
        {
          String str1 = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          String str2 = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
          this.a.jdField_a_of_type_AndroidContentIntent.setClassName(str2, str1);
          this.a.jdField_a_of_type_AndroidContentIntent.addFlags(603979776);
          ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(this.a.jdField_a_of_type_AndroidContentIntent);
        }
      }
      Utils.a(BaseApplication.getContext(), this.a.jdField_c_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */