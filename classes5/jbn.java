import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jbn
  implements Runnable
{
  public jbn(QRDisplayActivity paramQRDisplayActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getLeft();
    int j = this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getRight();
    Rect localRect = new Rect(i, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getTop(), j, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.getBottom());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setClickable(false);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setTouchDelegate(new jbo(this, localRect, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setClickable(true);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setOnClickListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.d.setTouchDelegate(null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */