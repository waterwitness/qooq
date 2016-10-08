package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import oqd;
import oqe;

public class AlbumListActivity
  extends PeakActivity
{
  public static final int a = 100;
  public static final String a;
  public static final String b = "_size>0) GROUP BY (_data";
  public static final String c = "qzone_album";
  public static final String d = "peak.myUin";
  public static final String e = "key_is_for_health";
  long jdField_a_of_type_Long;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public AlbumListAdapter a;
  MediaFileFilter jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = true;
  boolean e;
  String f;
  public boolean f;
  private boolean g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AlbumListActivity.class.getSimpleName();
  }
  
  public AlbumListActivity()
  {
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.e = localIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("PhotoConst.QZONE_ALBUM_NUM", 0L);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)MediaFileFilter.a.get(this.jdField_d_of_type_Int));
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = new DynamicImageMediaFileFilter(MediaFileFilter.b);
      this.jdField_d_of_type_Int = 1;
    }
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("peak.myUin");
    if (this.jdField_f_of_type_JavaLangString == null)
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
      if (this.jdField_f_of_type_JavaLangString == null) {
        throw new RuntimeException("must set MY_UIN");
      }
    }
    this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("key_is_for_health", false);
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter = new AlbumListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131301300));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new oqe(this, null));
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131366641);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("取消");
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new oqd(this));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    Object localObject1 = PresendPicMgr.a(null);
    if (localObject1 != null) {
      ((PresendPicMgr)localObject1).a(1005);
    }
    localObject1 = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    Object localObject2 = getIntent();
    if (localObject1 != null) {}
    for (int i = ((ArrayList)localObject1).size();; i = 0)
    {
      StatisticConstants.b((Intent)localObject2, i);
      if (this.e) {
        break;
      }
      finish();
      AlbumUtil.a();
      AlbumUtil.a(this, false, false);
      return;
    }
    localObject1 = getIntent();
    localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str1 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (localObject2 == null)
    {
      QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    ((Intent)localObject1).removeExtra("PhotoConst.PHOTO_PATHS");
    ((Intent)localObject1).removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ((Intent)localObject1).addFlags(603979776);
    if (((String)localObject2).startsWith("com.qzone"))
    {
      QzonePluginProxyActivity.a((Intent)localObject1, (String)localObject2);
      ((Intent)localObject1).putExtra("cleartop", true);
      QZoneHelper.a(this, this.jdField_f_of_type_JavaLangString, (Intent)localObject1, -1);
    }
    for (;;)
    {
      finish();
      AlbumUtil.a(this, false, false);
      return;
      ((Intent)localObject1).setClassName(str1, (String)localObject2);
      if (!((Intent)localObject1).getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        startActivity((Intent)localObject1);
      }
      else
      {
        ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_NAME");
        str1 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
        String str2 = ((Intent)localObject1).getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(str1))
        {
          ((Intent)localObject1).putExtra("qzone_plugin_activity_name", (String)localObject2);
          QZoneHelper.a(this, str2, (Intent)localObject1, 2);
        }
        else if ("qqfav.apk".equals(str1))
        {
          QfavHelper.a(this, this.jdField_f_of_type_JavaLangString, (Intent)localObject1, -1);
        }
        else
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "Watermark has been deleted!");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130904081);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131493030);
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    AlbumThumbManager.a(this).a();
    if (!this.g) {
      AlbumUtil.c();
    }
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\AlbumListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */