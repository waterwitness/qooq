import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;
import cooperation.qqindividuality.QQIndividualityUtils;

class rle
  implements Runnable
{
  rle(rld paramrld, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Rld.jdField_a_of_type_AndroidAppActivity, QQIndividualityBridgeActivity.class);
      localIntent.putExtra(QQIndividualityUtils.f, this.jdField_a_of_type_Rld.jdField_a_of_type_JavaLangString);
      localIntent.putExtra(QQIndividualityUtils.g, this.jdField_a_of_type_Rld.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name);
      if ((this.jdField_a_of_type_Rld.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth != 0) && (this.jdField_a_of_type_Rld.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight != 0))
      {
        localIntent.putExtra(QQIndividualityUtils.h, this.jdField_a_of_type_Rld.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth);
        localIntent.putExtra(QQIndividualityUtils.i, this.jdField_a_of_type_Rld.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight);
      }
      for (;;)
      {
        localIntent.putExtra(QQIndividualityUtils.k, this.jdField_a_of_type_Rld.b);
        localIntent.putExtra(QQIndividualityUtils.l, this.jdField_a_of_type_Rld.c);
        localIntent.putExtra(QQIndividualityUtils.j, 85);
        this.jdField_a_of_type_Rld.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 85);
        return;
        localIntent.putExtra(QQIndividualityUtils.h, this.jdField_a_of_type_Rld.jdField_a_of_type_ComTencentMobileqqDataEmoticon.width);
        localIntent.putExtra(QQIndividualityUtils.i, this.jdField_a_of_type_Rld.jdField_a_of_type_ComTencentMobileqqDataEmoticon.height);
      }
    }
    ChatActivityUtils.a(this.jdField_a_of_type_Rld.jdField_a_of_type_AndroidAppActivity, 2131370491, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */