import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

public class oqe
  implements AdapterView.OnItemClickListener
{
  private oqe(AlbumListActivity paramAlbumListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name)))
    {
      QQToast.a(this.a, 2131370346, 0).a();
      return;
    }
    if (this.a.f)
    {
      paramView = this.a.getIntent();
      paramView.putExtra("ALBUM_ID", paramAdapterView._id);
      paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      paramView.putExtra("album_enter_directly", false);
      this.a.setResult(-1, paramView);
      this.a.finish();
      AlbumUtil.a(this.a, true, true);
      return;
    }
    if (paramAdapterView._id == "qzone_album")
    {
      paramView = this.a.getIntent();
      paramAdapterView = paramView.getExtras();
      paramAdapterView.putInt("key_personal_album_enter_model", 1);
      paramAdapterView.putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      paramAdapterView.putSerializable("PhotoConst.PHOTO_INFOS", paramView.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      paramAdapterView.putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      paramAdapterView.putLong("PhotoConst.QZONE_ALBUM_NUM", paramView.getLongExtra("PhotoConst.QZONE_ALBUM_NUM", 0L));
      paramAdapterView.putStringArrayList("PhotoConst.PHOTO_PATHS", paramView.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      paramView = QZoneHelper.UserInfo.a();
      paramView.jdField_a_of_type_JavaLangString = BaseApplicationImpl.a().a().getAccount();
      paramAdapterView.putString("keyAction", "actionSelectPicture");
      QZoneHelper.a(this.a, paramView, paramAdapterView, 0);
      this.a.finish();
      AlbumUtil.a(this.a, true, true);
      return;
    }
    paramView = this.a.getIntent();
    paramView.putExtra("ALBUM_ID", paramAdapterView._id);
    paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    paramView.putExtra("album_enter_directly", false);
    AlbumListActivity.a(this.a, true);
    paramView.setClass(this.a, PhotoListActivity.class);
    paramView.addFlags(603979776);
    this.a.startActivity(paramView);
    if ("$VideoAlbumId".equals(paramAdapterView._id)) {
      ReportController.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
    }
    try
    {
      this.a.finish();
      AlbumUtil.a(this.a, true, true);
      return;
    }
    catch (Exception paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(AlbumListActivity.jdField_a_of_type_JavaLangString, 2, "onItemClick finish() exception=" + paramAdapterView.getMessage());
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */