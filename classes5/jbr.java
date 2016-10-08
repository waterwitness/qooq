import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class jbr
  implements Runnable
{
  public jbr(QRDisplayActivity paramQRDisplayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = (int)(20.0F * QRDisplayActivity.a(this.a));
    int i = this.a.c.getWidth() - j * 2;
    j = this.a.c.getHeight() - j * 2;
    if ((i >= 540) && (j >= 740))
    {
      this.a.jdField_h_of_type_Int = 540;
      this.a.jdField_i_of_type_Int = 740;
      if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        if (this.a.g != 1) {
          break label535;
        }
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.a(this.a.jdField_h_of_type_JavaLangString, false);
        label129:
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
        }
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("B", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("W", 16777215);
        this.a.jdField_a_of_type_AndroidOsBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("head", 1);
      }
      if (this.a.g == 5) {
        break label747;
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
        this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = this.a.a(this.a.jdField_h_of_type_JavaLangString, this.a.g, -1);
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
        break label639;
      }
      this.a.f();
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidViewView.post(this.a.jdField_b_of_type_JavaLangRunnable);
      return;
      if (i * 740 < j * 540) {
        this.a.jdField_h_of_type_Int = i;
      }
      for (this.a.jdField_i_of_type_Int = ((int)(i / 540.0D * 740.0D));; this.a.jdField_i_of_type_Int = j)
      {
        localObject1 = this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.a.jdField_h_of_type_Int;
        ((ViewGroup.LayoutParams)localObject1).height = this.a.jdField_i_of_type_Int;
        this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.a.d.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.a.jdField_h_of_type_Int;
        ((ViewGroup.LayoutParams)localObject1).height = this.a.jdField_i_of_type_Int;
        this.a.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        this.a.jdField_h_of_type_Int = ((int)(j / 740.0D * 540.0D));
      }
      label535:
      if (this.a.g == 2)
      {
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.a(this.a.jdField_h_of_type_JavaLangString, (byte)3, false, false);
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          break label129;
        }
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
        break label129;
      }
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.a.jdField_h_of_type_JavaLangString, true);
      if (!(localObject1 instanceof BitmapDrawable)) {
        break label129;
      }
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localObject1).getBitmap();
      break label129;
      label639:
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
      }
      Object localObject2 = (TicketManager)this.a.app.getManager(2);
      localObject1 = this.a.app.getAccount();
      localObject2 = ((TicketManager)localObject2).getSkey((String)localObject1);
      Intent localIntent = this.a.getIntent();
      String str = localIntent.getStringExtra("uin");
      i = localIntent.getIntExtra("type", 1);
      QRUtils.a(this.a.app, this.a, str, i, (String)localObject1, (String)localObject2, new jbs(this, str, i));
    }
    label747:
    Object localObject1 = this.a.getSharedPreferences("qrcode", 0);
    this.a.jdField_b_of_type_Long = ((SharedPreferences)localObject1).getLong("discussionvalidtime" + this.a.jdField_h_of_type_JavaLangString, 0L);
    this.a.jdField_i_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("discussion" + this.a.jdField_h_of_type_JavaLangString, null);
    this.a.j = ((SharedPreferences)localObject1).getString("discussionfullSig" + this.a.jdField_h_of_type_JavaLangString, null);
    if (this.a.jdField_b_of_type_Long - System.currentTimeMillis() / 1000L > 0L) {}
    for (i = 1;; i = 0)
    {
      this.a.findViewById(2131300041).setOnClickListener(this.a);
      if ((this.a.jdField_i_of_type_JavaLangString == null) || (this.a.j == null) || (i == 0)) {
        break label999;
      }
      ((TextView)this.a.findViewById(2131300040)).setText(this.a.jdField_i_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a(this.a.jdField_i_of_type_JavaLangString, -1);
      this.a.f();
      break;
    }
    label999:
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.a.jdField_h_of_type_JavaLangString), true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */