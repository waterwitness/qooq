import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;

public class ype
  implements DialogInterface.OnClickListener
{
  public ype(QZoneShareActivity paramQZoneShareActivity, Activity paramActivity, QZoneShareData paramQZoneShareData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationQzoneQZoneShareData, false);
    this.jdField_a_of_type_AndroidAppActivity.setResult(0);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */