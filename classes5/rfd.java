import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearpeople.ranking.ShowLoveEditorActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public final class rfd
  implements ActionSheet.OnButtonClickListener
{
  public rfd(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, AppInterface paramAppInterface, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      label290:
      do
      {
        return;
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhotoListActivity.class);
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", NearbyPeopleProfileActivity.class.getName());
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq.activity");
        paramView.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ShowLoveEditorActivity.class.getName());
        paramView.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
        paramView.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
        paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        paramView.putExtra("PhotoConst.CUSTOM_SENDBTN_TEXT", this.jdField_a_of_type_AndroidAppActivity.getString(2131367974));
        paramView.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        paramView.putExtra("PHOTO_TYPE", 0);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            paramView.putExtra("uinname", this.jdField_b_of_type_JavaLangString);
          }
          paramView.putExtra("uintype", this.jdField_a_of_type_Int);
          paramView.putExtra("gender", this.jdField_b_of_type_Int);
          if (this.jdField_a_of_type_ArrayOfByte != null)
          {
            if (this.jdField_a_of_type_Int != 1010) {
              break label290;
            }
            paramView.putExtra("rich_date_sig", this.jdField_a_of_type_ArrayOfByte);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
          AlbumUtil.a(this.jdField_a_of_type_AndroidAppActivity, false, true);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005292", "0X8005292", 0, 0, "", "", "", "");
          break;
          if (this.jdField_a_of_type_Int == 1001) {
            paramView.putExtra("rich_accost_sig", this.jdField_a_of_type_ArrayOfByte);
          }
        }
      } while (QavCameraUsage.b(BaseApplicationImpl.getContext()));
      if (!Utils.b()) {
        QQToast.a(BaseApplicationImpl.getContext(), 2131368967, 0).a();
      }
      paramView = new File(AppConstants.bt);
      if (!paramView.exists()) {
        paramView.mkdirs();
      }
      DatingUtil.d = DatingUtil.a();
      paramView = Uri.fromFile(new File(DatingUtil.d));
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.putExtra("output", paramView);
      localIntent.putExtra("android.intent.extra.videoQuality", 100);
      DatingUtil.a = new Intent(this.jdField_a_of_type_AndroidAppActivity, ShowLoveEditorActivity.class);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
        DatingUtil.a.putExtra("uin", this.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localIntent.putExtra("uinname", this.jdField_b_of_type_JavaLangString);
          DatingUtil.a.putExtra("uinname", this.jdField_b_of_type_JavaLangString);
        }
        localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
        localIntent.putExtra("gender", this.jdField_b_of_type_Int);
        DatingUtil.a.putExtra("uintype", this.jdField_a_of_type_Int);
        DatingUtil.a.putExtra("gender", this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_ArrayOfByte != null)
        {
          if (this.jdField_a_of_type_Int != 1010) {
            break label625;
          }
          localIntent.putExtra("rich_date_sig", this.jdField_a_of_type_ArrayOfByte);
          DatingUtil.a.putExtra("rich_date_sig", this.jdField_a_of_type_ArrayOfByte);
        }
      }
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 8);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X8005293", "0X8005293", 0, 0, "", "", "", "");
          break;
          label625:
          if (this.jdField_a_of_type_Int == 1001)
          {
            localIntent.putExtra("rich_accost_sig", this.jdField_a_of_type_ArrayOfByte);
            DatingUtil.a.putExtra("rich_accost_sig", this.jdField_a_of_type_ArrayOfByte);
          }
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          QQToast.a(BaseApplicationImpl.getContext(), 2131368990, 0).a();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */