import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nvg
  implements DialogInterface.OnClickListener
{
  public nvg(PhotoListPanel paramPhotoListPanel, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_Boolean);
      com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.b = System.currentTimeMillis();
    }
    ReportController.b(null, "CliOper", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, this.b, this.c, "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */