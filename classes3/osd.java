import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.Iterator;

public class osd
  implements View.OnClickListener
{
  public osd(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
    if (this.a.getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = this.a.jdField_b_of_type_JavaUtilArrayList.iterator();
      for (long l = 0L; paramView.hasNext(); l += FileUtils.a((String)paramView.next())) {}
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() == 0)
      {
        int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.s();
        if (i < this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
          FileUtils.a((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if (FileManagerUtil.a()) {
        FMDialogUtil.a(this.a, 2131362855, 2131362851, new ose(this));
      }
    }
    for (;;)
    {
      QZoneClickReport.report(this.a.g, "603", "1", "", this.a.t, true);
      return;
      this.a.g();
      continue;
      this.a.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */