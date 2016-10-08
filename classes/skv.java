import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class skv
  extends UiCallBack.DownAdapter
{
  skv(sku paramsku, MessageForPic paramMessageForPic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    this.jdField_a_of_type_Sku.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a.setProgressBarVisibility(8);
    paramPicResult = AbsDownloader.d(URLDrawableHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 1, null).toString().toString());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DownloadBigPic finish");
    }
    ForwardBaseOption.a(this.jdField_a_of_type_Sku.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, paramPicResult, this.jdField_a_of_type_Sku.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\skv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */