import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.HashMap;

public class orp
  implements AdapterView.OnItemClickListener
{
  public orp(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.a.jdField_u_of_type_Boolean) {
      this.a.jdField_u_of_type_Boolean = true;
    }
    switch (this.a.jdField_a_of_type_Orv.getItemViewType(paramInt))
    {
    default: 
    case 0: 
    case 1: 
      String str;
      label928:
      do
      {
        do
        {
          do
          {
            return;
            PhotoListActivity.a(this.a);
            if (this.a.g)
            {
              paramAdapterView = this.a.jdField_a_of_type_Orv.a(paramInt);
              if ((this.a.B) && (paramAdapterView.i > 0) && (paramAdapterView.j > 0))
              {
                if ((this.a.jdField_a_of_type_Double > 0.0D) && ((paramAdapterView.j * 1.0F / paramAdapterView.i < this.a.jdField_b_of_type_Double) || (paramAdapterView.j * 1.0F / paramAdapterView.i > this.a.jdField_a_of_type_Double)))
                {
                  QQToast.a(this.a, this.a.getResources().getString(2131369000), 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
                  return;
                }
                if ((this.a.s > 0) && (paramAdapterView.jdField_b_of_type_Long > this.a.s))
                {
                  QQToast.a(this.a, this.a.getResources().getString(2131369001, new Object[] { Integer.valueOf(this.a.s / 1048576) }), 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
                  return;
                }
              }
              this.a.b(paramAdapterView.jdField_a_of_type_JavaLangString);
              return;
            }
            AlbumUtil.a();
            paramAdapterView = this.a.getIntent();
            paramAdapterView.putExtra("ALBUM_NAME", this.a.jdField_l_of_type_JavaLangString);
            paramAdapterView.putExtra("ALBUM_ID", this.a.m);
            paramAdapterView.putExtra("PhotoConst.IS_OVERLOAD", this.a.t);
            if (!this.a.t) {
              paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_b_of_type_JavaUtilArrayList);
            }
            paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
            paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.a.jdField_d_of_type_JavaUtilArrayList);
            paramAdapterView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
            paramAdapterView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.a.jdField_p_of_type_Int);
            paramAdapterView.putExtra("PhotoConst.SHOW_ALBUM", true);
            paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.jdField_l_of_type_Boolean);
            paramAdapterView.putExtra("PasterConstants.paster_id", this.a.n);
            paramAdapterView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_o_of_type_JavaLangString);
            PhotoListActivity.q = this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
            paramView = this.a.jdField_a_of_type_Orv.a(paramInt);
            if (AlbumUtil.a(paramView) == 0) {
              paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.jdField_a_of_type_JavaLangInteger);
            }
            paramAdapterView.putExtra("PasterConstants.pasters_data", this.a.jdField_b_of_type_JavaUtilHashMap);
            paramAdapterView.setClass(this.a, PhotoPreviewActivity.class);
            paramAdapterView.addFlags(603979776);
            if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
              ReportController.b(null, "CliOper", "", this.a.jdField_p_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.a.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
            }
            if (this.a.E)
            {
              paramAdapterView.putExtra("from_health", true);
              this.a.startActivityForResult(paramAdapterView, 100010);
            }
            for (;;)
            {
              AlbumUtil.a(this.a, true, true);
              return;
              this.a.startActivity(paramAdapterView);
              PhotoListActivity.b(this.a);
            }
            if ((!this.a.D) && (!this.a.jdField_c_of_type_JavaUtilArrayList.isEmpty()))
            {
              paramAdapterView = DialogUtil.a(this.a, 230);
              paramAdapterView.setMessage("不能同时选择照片和视频");
              paramAdapterView.setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter());
              paramAdapterView.show();
              return;
            }
            if (!Utils.b())
            {
              QQToast.a(this.a, this.a.getResources().getString(2131368967), 0).a();
              return;
            }
            paramAdapterView = this.a.jdField_a_of_type_Orv.a(paramInt);
          } while (paramAdapterView == null);
          paramView = this.a.getIntent();
          localObject = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
          str = paramView.getStringExtra("video_refer");
          paramInt = 0;
          if (!TextUtils.isEmpty(str))
          {
            if ((!str.contains("QZonePublishMoodActivity")) && (!str.contains("QZoneUploadPhotoActivity"))) {
              break label928;
            }
            paramInt = 1;
          }
          while (paramInt != 0)
          {
            paramLong = paramView.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", Long.MAX_VALUE);
            if (paramAdapterView.e > paramLong)
            {
              paramAdapterView = "请上传不超过" + paramLong / 60L / 1000L + "分钟的视频";
              QQToast.a(this.a, paramAdapterView, 0).b(this.a.f());
              return;
              paramInt = 0;
            }
            else if (paramAdapterView.e < 2000L)
            {
              QQToast.a(this.a, "请选择大于2秒的视频", 0).b(this.a.f());
              return;
            }
          }
          if ((this.a.F) || (paramInt != 0) || (paramAdapterView.jdField_b_of_type_Long <= this.a.jdField_b_of_type_Long)) {
            break;
          }
          paramAdapterView = DialogUtil.a(this.a, "你选择的视频文件过大，无法发送");
          paramAdapterView.setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter());
          paramAdapterView.show();
        } while (!this.a.A);
        paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        paramView = new Intent("key_video_size_overflow");
        paramView.putExtra("className", paramAdapterView);
        this.a.sendBroadcast(paramView);
        return;
        if (((!this.a.B) && (!this.a.A)) || (paramAdapterView.e - this.a.jdField_c_of_type_Long <= 999L)) {
          break;
        }
        paramAdapterView = DialogUtil.a(this.a, "你选择的视频时间过长，无法发送");
        paramAdapterView.setPositiveButton(2131367263, new DialogUtil.DialogOnClickAdapter());
        paramAdapterView.show();
        paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      } while (!this.a.A);
      paramView = new Intent("key_video_time_overflow");
      paramView.putExtra("className", paramAdapterView);
      this.a.sendBroadcast(paramView);
      return;
      HashMap localHashMap = AlbumUtil.c;
      if (!localHashMap.containsKey(paramAdapterView.jdField_a_of_type_JavaLangString))
      {
        Pair localPair = new Pair(this.a.m, this.a.jdField_l_of_type_JavaLangString);
        localHashMap.put(paramAdapterView.jdField_a_of_type_JavaLangString, localPair);
      }
      this.a.a(paramAdapterView.jdField_a_of_type_JavaLangString);
      boolean bool = "cover_mall_record_video".equals(str);
      if ("qzone_plugin.apk".equals(localObject))
      {
        if ((bool) && (paramAdapterView.e > this.a.jdField_c_of_type_Long))
        {
          paramAdapterView = "视频时间不能超过" + this.a.jdField_c_of_type_Long / 1000L + "s，请重新选择";
          QQToast.a(this.a, paramAdapterView, 0).b(this.a.f());
          QLog.i(PhotoListActivity.jdField_a_of_type_JavaLangString, 1, "QQToast:" + paramAdapterView);
          return;
        }
        if (paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME").contains("TrimVideoActivity")) {
          break label1624;
        }
        if ((!this.a.e) && (paramAdapterView.e <= this.a.jdField_c_of_type_Long)) {
          break label1550;
        }
        this.a.jdField_d_of_type_Boolean = true;
      }
      while (!this.a.jdField_d_of_type_Boolean)
      {
        paramView.putExtra("file_send_path", paramAdapterView.jdField_a_of_type_JavaLangString);
        paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
        paramView.putExtra("PhotoConst.VIDEO_SIZE", paramAdapterView.jdField_b_of_type_Long);
        paramView.putExtra("file_send_duration", paramAdapterView.e);
        paramView.putExtra("file_width", paramAdapterView.i);
        paramView.putExtra("file_height", paramAdapterView.j);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramAdapterView.jdField_a_of_type_JavaLangString);
        PhotoUtils.a(this.a, paramView, (ArrayList)localObject, 2, false);
        return;
        label1550:
        this.a.jdField_d_of_type_Boolean = false;
        paramView.putExtra("support_record", false);
        paramView.putExtra("support_trim", true);
        paramView.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
        paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.jdField_l_of_type_Boolean);
      }
      label1624:
      Object localObject = this.a;
      if (paramAdapterView.e > this.a.jdField_c_of_type_Long) {}
      for (bool = true;; bool = false)
      {
        ((PhotoListActivity)localObject).jdField_d_of_type_Boolean = bool;
        paramView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.a.jdField_d_of_type_Boolean);
        break;
      }
      localObject = new Intent(this.a, ShortVideoPreviewActivity.class);
      ((Intent)localObject).putExtra("file_send_path", paramAdapterView.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("file_send_size", paramAdapterView.jdField_b_of_type_Long);
      ((Intent)localObject).putExtra("file_send_duration", paramAdapterView.e);
      ((Intent)localObject).putExtra("file_width", paramAdapterView.i);
      ((Intent)localObject).putExtra("file_height", paramAdapterView.j);
      ((Intent)localObject).putExtra("uin", this.a.jdField_u_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", this.a.jdField_o_of_type_Int);
      ((Intent)localObject).putExtra("file_source", "album");
      ((Intent)localObject).putExtra("is_from_system_media", paramAdapterView.jdField_b_of_type_Boolean);
      ((Intent)localObject).putExtras(paramView);
      ((Intent)localObject).putExtra("PhotoConst.IS_FROM_TROOP_BAR", this.a.A);
      if (this.a.F)
      {
        ((Intent)localObject).putExtra("from_health", true);
        paramInt = ((Intent)localObject).getIntExtra("size_before_compress", 104857600);
        int i = ((Intent)localObject).getIntExtra("duration_max", 180000);
        if ((paramAdapterView.jdField_b_of_type_Long > paramInt) || (paramAdapterView.e > i))
        {
          QQToast.a(this.a, "视频文件过大，无法发送", 0).b(this.a.f());
          return;
        }
      }
      if (this.a.D)
      {
        ((Intent)localObject).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
        ((Intent)localObject).putExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
      }
      this.a.startActivityForResult((Intent)localObject, 17);
      return;
    }
    if (!Utils.b())
    {
      QQToast.a(this.a, this.a.getResources().getString(2131368967), 0).a();
      return;
    }
    if (this.a.E)
    {
      paramAdapterView = new Intent();
      paramAdapterView.putStringArrayListExtra("img_list", this.a.jdField_c_of_type_JavaUtilArrayList);
      this.a.setResult(16, paramAdapterView);
      this.a.finish();
      return;
    }
    this.a.h();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */