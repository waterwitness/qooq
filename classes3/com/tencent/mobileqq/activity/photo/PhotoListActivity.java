package com.tencent.mobileqq.activity.photo;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.servlet.QZoneAlbumListNumServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.photoplus.PhotoPlusBridgeActivity;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import ori;
import orj;
import ork;
import orm;
import orn;
import oro;
import orp;
import orq;
import orr;
import ors;
import oru;
import orv;
import orw;
import orx;

public class PhotoListActivity
  extends PeakActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, MediaScanner.OnMediaScannerListener
{
  static int jdField_a_of_type_Int = 0;
  public static final String a;
  public static ArrayList a;
  private static orx jdField_a_of_type_Orx = new orx();
  public static final int b = 0;
  public static final String b = "FROM_WHERE";
  static final int c = 100;
  public static final String c = "FROM_PHOTO_LIST";
  static final int jdField_d_of_type_Int = -1;
  public static long d = 0L;
  public static final String d = "FROM_PHOTO_LIST_FLOW";
  public static final int e = 1000;
  public static final String e = "FROM_NEARBY_PROFILE";
  static final int jdField_f_of_type_Int = 3;
  public static final String f = "FROM_TROOP_ORG_PROFILE";
  public static final String g = "ALBUMLIST_POSITION";
  public static final String h = "ALBUMLIST_ITEM_DURATION";
  public static final String i = "PHOTOLIST_START_POSITION";
  public static final String j = "from_health";
  public static final String k = "health_video";
  public static int q;
  private String A;
  public boolean A;
  public boolean B = false;
  public boolean C = false;
  public boolean D = false;
  public boolean E;
  public boolean F;
  public boolean G = false;
  private boolean H = true;
  public double a;
  public long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public AsyncTask a;
  Handler jdField_a_of_type_AndroidOsHandler = new oru(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public LocalMediaInfo a;
  MediaFileFilter jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  public PhotoListActivity.onSelectionChangeListener a;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new orp(this);
  GestureSelectGridView.OnSelectListener jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener = new ori(this);
  public GestureSelectGridView a;
  protected HashMap a;
  public orv a;
  boolean jdField_a_of_type_Boolean = false;
  public double b;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  protected Button b;
  public CheckBox b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ArrayList b;
  public HashMap b;
  public HashSet b;
  boolean jdField_b_of_type_Boolean = false;
  public long c;
  public View c;
  public Button c;
  public TextView c;
  public ArrayList c;
  public HashSet c;
  View jdField_d_of_type_AndroidViewView;
  public TextView d;
  public ArrayList d;
  public boolean d;
  TextView e;
  public boolean e;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean = true;
  public int g;
  TextView g;
  public boolean g;
  public int h;
  protected boolean h;
  int jdField_i_of_type_Int;
  boolean jdField_i_of_type_Boolean = false;
  int jdField_j_of_type_Int;
  boolean jdField_j_of_type_Boolean = false;
  int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean = true;
  int l;
  public String l;
  public boolean l;
  protected int m;
  public String m;
  boolean m;
  public int n;
  public String n;
  boolean n;
  public int o;
  public String o;
  boolean o;
  public int p;
  public String p;
  boolean p;
  String jdField_q_of_type_JavaLangString;
  boolean jdField_q_of_type_Boolean = false;
  public int r;
  String jdField_r_of_type_JavaLangString;
  boolean jdField_r_of_type_Boolean = false;
  public int s;
  String s;
  protected boolean s;
  public int t;
  String t;
  public boolean t;
  int u;
  public String u;
  public boolean u;
  public int v;
  String jdField_v_of_type_JavaLangString;
  boolean jdField_v_of_type_Boolean;
  public int w;
  String w;
  public boolean w;
  public int x;
  String jdField_x_of_type_JavaLangString;
  boolean jdField_x_of_type_Boolean = false;
  boolean y = true;
  public boolean z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PhotoListActivity.class.getSimpleName();
    jdField_a_of_type_Int = 19922944;
    jdField_q_of_type_Int = -1;
  }
  
  public PhotoListActivity()
  {
    this.jdField_a_of_type_Orv = null;
    this.jdField_n_of_type_Int = 1;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_z_of_type_Boolean = false;
    this.jdField_A_of_type_Boolean = false;
    this.jdField_t_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = null;
    this.jdField_A_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_A_of_type_JavaLangString)) {
      return;
    }
    Object localObject1 = "";
    String str3 = "";
    int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();
    String str2;
    Object localObject2;
    String str1;
    if (i1 == 0)
    {
      str2 = "601";
      switch (paramInt)
      {
      default: 
        return;
      case 2131297083: 
        if (i1 == 0)
        {
          localObject2 = "3";
          str1 = str3;
        }
        break;
      }
    }
    for (;;)
    {
      if (!str2.equals("601")) {
        break label319;
      }
      QZoneClickReport.report(this.jdField_p_of_type_JavaLangString, str2, "0", (String)localObject2, this.jdField_A_of_type_JavaLangString, true);
      return;
      str2 = "600";
      if (i1 == 1) {}
      for (str1 = "1";; str1 = "2")
      {
        localObject1 = str1;
        break;
      }
      if (i1 == 1)
      {
        str1 = "3";
        localObject2 = localObject1;
      }
      else
      {
        str1 = "3";
        localObject2 = localObject1;
        continue;
        if (i1 == 0)
        {
          localObject2 = "2";
          str1 = str3;
        }
        else if (i1 == 1)
        {
          str1 = "2";
          localObject2 = localObject1;
        }
        else
        {
          str1 = "2";
          localObject2 = localObject1;
          continue;
          localObject2 = localObject1;
          str1 = str3;
          if (i1 != 0) {
            if (i1 == 1)
            {
              str1 = "4";
              localObject2 = localObject1;
            }
            else
            {
              str1 = "4";
              localObject2 = localObject1;
              continue;
              localObject2 = localObject1;
              str1 = str3;
              if (i1 != 0) {
                if (i1 == 1)
                {
                  str1 = "1";
                  localObject2 = localObject1;
                }
                else
                {
                  str1 = "1";
                  localObject2 = localObject1;
                  continue;
                  localObject2 = localObject1;
                  str1 = str3;
                  if (i1 != 0)
                  {
                    localObject2 = localObject1;
                    str1 = str3;
                    if (i1 == 1)
                    {
                      str1 = "5";
                      localObject2 = localObject1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label319:
    QZoneClickReport.report(this.jdField_p_of_type_JavaLangString, str2, (String)localObject2, str1, this.jdField_A_of_type_JavaLangString, true);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
    int i3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t();
    int i1 = i2;
    if (i1 <= i3)
    {
      if ((paramBoolean) && (paramInt != i1)) {}
      label410:
      for (;;)
      {
        i1 += 1;
        break;
        Object localObject = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i1 - i2);
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_Orv.a(i1);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateCheckbox view = null at " + i1);
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateCheckbox info = null at " + i1);
          }
        }
        else
        {
          int i4;
          if (paramInt != i1)
          {
            i4 = this.jdField_c_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
            if (i4 >= 0) {
              ((orw)((View)localObject).getTag()).a.setCheckedNumber(i4 + 1);
            }
          }
          else
          {
            i4 = AlbumUtil.a(localLocalMediaInfo);
            if ((i4 == 0) || (i4 == 1))
            {
              orw localorw = (orw)((View)localObject).getTag();
              ImageView localImageView = localorw.b;
              int i5 = localLocalMediaInfo.jdField_b_of_type_Int;
              if (i5 == 1)
              {
                localImageView.setVisibility(0);
                localorw.a.setCheckedNumber(this.jdField_c_of_type_JavaUtilArrayList.indexOf(localLocalMediaInfo.jdField_a_of_type_JavaLangString) + 1);
                if (((View)localObject).getBackground() != null) {
                  ((View)localObject).setBackgroundDrawable(null);
                }
              }
              for (;;)
              {
                if (!AppSetting.jdField_j_of_type_Boolean) {
                  break label410;
                }
                localObject = PhotoUtils.a(i4, localLocalMediaInfo, i1, localorw.a.isChecked());
                localorw.a.setContentDescription((CharSequence)localObject);
                break;
                if (i5 == 3)
                {
                  localImageView.setVisibility(4);
                  localorw.a.setChecked(false);
                  if (!this.jdField_u_of_type_Boolean)
                  {
                    if (((View)localObject).getBackground() == null) {
                      ((View)localObject).setBackgroundResource(2130837640);
                    }
                  }
                  else {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
                else
                {
                  localImageView.setVisibility(4);
                  localorw.a.setChecked(false);
                  if (((View)localObject).getBackground() != null) {
                    ((View)localObject).setBackgroundDrawable(null);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private int c()
  {
    return QzoneConfig.a().a("PhotoUpload", "QunAiOthresholdNum", 3);
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_qun_album" + this.jdField_u_of_type_JavaLangString)) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("qzone_will_upload_to_qun_album" + this.jdField_u_of_type_JavaLangString, false);
    }
    return bool;
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.contains("qzone_will_upload_to_qun_album" + this.jdField_u_of_type_JavaLangString);
  }
  
  private boolean f()
  {
    boolean bool = true;
    if (e()) {
      bool = c();
    }
    while (QzoneConfig.a().a("PhotoUpload", "QunAioCheckBoxState", 0) == 1) {
      return bool;
    }
    return false;
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    if ((!e()) || (!c())) {
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        break label54;
      }
    }
    label54:
    for (int i1 = this.jdField_c_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      boolean bool1 = bool2;
      if (i1 >= c())
      {
        bool1 = bool2;
        if (f()) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private void j()
  {
    if (TextUtils.isEmpty(this.jdField_A_of_type_JavaLangString)) {}
    while (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    QZoneClickReport.report(this.jdField_p_of_type_JavaLangString, "601", "0", "1", this.jdField_A_of_type_JavaLangString, true);
  }
  
  int a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (new File((String)localIterator.next()).length() <= jdField_a_of_type_Int) {
        break label55;
      }
      i1 += 1;
    }
    label55:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  File a()
  {
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String str = "JPEG_" + (String)localObject + "_";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      while (bool)
      {
        localObject = File.createTempFile(str, ".jpg", (File)localObject);
        this.jdField_x_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
        return (File)localObject;
        File localFile = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject = localFile;
        if (!localFile.exists())
        {
          bool = localFile.mkdirs();
          localObject = localFile;
        }
      }
    }
    return null;
  }
  
  void a()
  {
    Object localObject = (RelativeLayout)findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_e_of_type_AndroidWidgetTextView.setText("相册");
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setText("取消");
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    label449:
    int i1;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      localObject = this.jdField_l_of_type_JavaLangString;
      setTitle((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298658));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298661));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298662));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301287));
      g();
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131302151));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131298663));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131301285);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131301737);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301740));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)findViewById(2131302152));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(3);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_g_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_i_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_j_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_k_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_k_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_Orv = new orv(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Orv);
      String str = this.jdField_s_of_type_JavaLangString;
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (!this.jdField_z_of_type_Boolean) {
          break label777;
        }
        localObject = getString(2131370125);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_m_of_type_Int != 2)) {
        break label806;
      }
      i1 = 8;
      label480:
      ((View)localObject).setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_i_of_type_Boolean) {
        break label811;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    for (;;)
    {
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      }
      e();
      if ((this.jdField_v_of_type_Boolean) && (this.jdField_p_of_type_JavaLangString != null))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301741));
        this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131301739));
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131301742);
        this.jdField_d_of_type_AndroidViewView = findViewById(2131301738);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      }
      if (this.jdField_o_of_type_Int == 1001)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.F) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      if (this.jdField_m_of_type_Int == 2)
      {
        localObject = "视频";
        break;
      }
      localObject = "最近照片";
      break;
      label777:
      if (this.jdField_i_of_type_Boolean)
      {
        localObject = getString(2131370123);
        break label449;
      }
      localObject = getString(2131370124);
      break label449;
      label806:
      i1 = 0;
      break label480;
      label811:
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Orv == null) || (this.jdField_a_of_type_Orv.jdField_a_of_type_JavaUtilArrayList == null));
      localObject = (LocalMediaInfo)this.jdField_a_of_type_Orv.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while ((localObject == null) || (paramLocalMediaInfo == null) || (((LocalMediaInfo)localObject).jdField_a_of_type_JavaLangString == null) || (paramLocalMediaInfo.jdField_a_of_type_JavaLangString == null) || (!((LocalMediaInfo)localObject).jdField_a_of_type_JavaLangString.equals(paramLocalMediaInfo.jdField_a_of_type_JavaLangString)));
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 0;
    Bundle localBundle = new Bundle();
    localBundle.putInt("ALBUMLIST_POSITION", paramInt);
    localBundle.putLong("ALBUMLIST_ITEM_DURATION", paramLocalMediaInfo.e);
    ((Message)localObject).setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
    if (paramIntent != null) {}
    for (paramIntent = PresendPicMgr.b(IPresendPicMgr.Stub.a(paramIntent.a));; paramIntent = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + "  initPresendMgr , presendMgr = " + paramIntent);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + "  initPresendMgr , bw is null ! ");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_q_of_type_Boolean)
    {
      AlbumUtil.jdField_c_of_type_Long = System.currentTimeMillis();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_m_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Orv.getCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        AlbumUtil.jdField_a_of_type_JavaLangString = paramString;
        HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          AlbumUtil.jdField_b_of_type_JavaLangString = (String)paramString.first;
          AlbumUtil.jdField_c_of_type_JavaLangString = (String)paramString.second;
          AlbumUtil.a(this, AlbumUtil.jdField_b_of_type_JavaLangString, AlbumUtil.jdField_c_of_type_JavaLangString);
        }
      }
    }
    AlbumUtil.c();
  }
  
  void a(boolean paramBoolean)
  {
    AlbumUtil.a();
    Intent localIntent = getIntent();
    if (!paramBoolean)
    {
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
        ReportController.b(null, "CliOper", "", this.jdField_p_of_type_JavaLangString, "0X8004072", "0X8004072", 0, this.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
      }
      localIntent.putExtra("ALBUM_NAME", this.jdField_l_of_type_JavaLangString);
      localIntent.putExtra("ALBUM_ID", this.jdField_m_of_type_JavaLangString);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_p_of_type_Int);
      localIntent.putExtra("readSource", this.jdField_A_of_type_JavaLangString);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.jdField_z_of_type_Boolean);
      jdField_q_of_type_Int = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
      localIntent.setClass(this, PhotoPreviewActivity.class);
      localIntent.addFlags(603979776);
      if (!this.E) {
        break label230;
      }
      localIntent.putExtra("from_health", true);
      startActivityForResult(localIntent, 100010);
    }
    for (;;)
    {
      AlbumUtil.a(this, true, true);
      return;
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.jdField_x_of_type_JavaLangString);
      break;
      label230:
      startActivity(localIntent);
      super.finish();
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    Object localObject = MimeHelper.a(paramLocalMediaInfo.jdField_b_of_type_JavaLangString);
    if ((!this.D) && (localObject != null) && (!"image".equals(localObject[0]))) {}
    long l1;
    do
    {
      int i1;
      do
      {
        return false;
        i1 = paramLocalMediaInfo.jdField_b_of_type_Int;
      } while (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean)));
      if ((i1 != 2) || (!paramBoolean) || (this.jdField_c_of_type_JavaUtilArrayList.size() < this.jdField_n_of_type_Int)) {
        break;
      }
      l1 = System.currentTimeMillis();
    } while (l1 - this.jdField_a_of_type_Long < 700L);
    QQToast.a(this, "最多只能选择" + this.jdField_n_of_type_Int + "张图片", 1000).b(this.jdField_r_of_type_Int);
    this.jdField_a_of_type_Long = l1;
    this.G = true;
    return false;
    this.G = false;
    String str = paramLocalMediaInfo.jdField_a_of_type_JavaLangString;
    PresendPicMgr.a();
    if (paramBoolean)
    {
      if ((this.D) && (localObject != null) && ("video".equals(localObject[0])))
      {
        this.jdField_t_of_type_Int += 1;
        if (this.jdField_t_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        }
      }
      this.jdField_c_of_type_JavaUtilArrayList.add(str);
      this.jdField_d_of_type_JavaUtilArrayList.add(paramLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
      if (this.jdField_c_of_type_JavaUtilHashSet.contains(str)) {
        this.jdField_c_of_type_JavaUtilHashSet.remove(str);
      }
      this.jdField_b_of_type_JavaUtilHashSet.add(str);
      StatisticConstants.a(getIntent(), "param_totalSelNum");
      localObject = getIntent();
      if (!((Intent)localObject).hasExtra("param_initTime")) {
        ((Intent)localObject).putExtra("param_initTime", System.currentTimeMillis());
      }
      paramLocalMediaInfo.jdField_b_of_type_Int = 1;
      localObject = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_m_of_type_JavaLangString);
      paramLocalMediaInfo = (LocalMediaInfo)localObject;
      if (localObject == null)
      {
        paramLocalMediaInfo = new LinkedHashMap();
        AlbumUtil.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_m_of_type_JavaLangString, paramLocalMediaInfo);
      }
      paramLocalMediaInfo.put(str, Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s()));
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        paramLocalMediaInfo.put(str, new Pair(this.jdField_m_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString));
      }
      paramBoolean = g();
      if (this.jdField_b_of_type_AndroidWidgetCheckBox != null) {
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      }
      return true;
    }
    if ((this.D) && (localObject != null) && ("video".equals(localObject[0])))
    {
      this.jdField_t_of_type_Int -= 1;
      if (this.jdField_t_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.jdField_a_of_type_JavaLangString);
    this.jdField_d_of_type_JavaUtilArrayList.remove(paramLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
    if (this.jdField_b_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramLocalMediaInfo.jdField_b_of_type_Int = 2;
      StatisticConstants.a(getIntent(), "param_cancelSelNum");
      paramLocalMediaInfo = (HashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_m_of_type_JavaLangString);
      if (paramLocalMediaInfo != null) {
        paramLocalMediaInfo.remove(str);
      }
      paramLocalMediaInfo = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!paramLocalMediaInfo.containsKey(str)) {
        break;
      }
      paramLocalMediaInfo.remove(str);
      break;
      this.jdField_c_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  void b()
  {
    Intent localIntent = getIntent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_p_of_type_Int);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", this.jdField_h_of_type_Boolean);
    localIntent.putExtra("PhotoConst.PHOTO_INFOS", this.jdField_a_of_type_JavaUtilHashMap);
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_NUM", jdField_d_of_type_Long);
    localIntent.putExtra("peak.myUin", this.jdField_p_of_type_JavaLangString);
    localIntent.setClass(this, AlbumListActivity.class);
    localIntent.addFlags(603979776);
    if ((this.E) || (this.F))
    {
      localIntent.putExtra("key_is_for_health", true);
      startActivityForResult(localIntent, 100009);
    }
    for (;;)
    {
      AlbumUtil.a(this, true, false);
      return;
      startActivity(localIntent);
      super.finish();
    }
  }
  
  void b(Intent paramIntent)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " initData(),intent extras is:" + paramIntent.getExtras());
    }
    this.jdField_q_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    label425:
    label456:
    Object localObject;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = AlbumUtil.jdField_c_of_type_Long;
      if ((this.jdField_q_of_type_Boolean) && (l1 - l2 < 60000L))
      {
        this.jdField_l_of_type_JavaLangString = AlbumUtil.jdField_c_of_type_JavaLangString;
        this.jdField_m_of_type_JavaLangString = AlbumUtil.jdField_b_of_type_JavaLangString;
      }
      if (this.jdField_m_of_type_JavaLangString == null)
      {
        this.jdField_m_of_type_JavaLangString = "$RecentAlbumId";
        this.jdField_l_of_type_JavaLangString = null;
      }
      this.jdField_c_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_n_of_type_Int = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
      this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.original_button", false);
      this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.quality_count_tv", true);
      this.jdField_p_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_UIN");
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_q_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_NICK");
        this.jdField_r_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
      }
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_NEED_EDIT", false);
      this.jdField_o_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      this.jdField_o_of_type_Int = paramIntent.getIntExtra("uintype", -1);
      this.jdField_p_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      if (this.jdField_n_of_type_Int > 1) {
        this.jdField_g_of_type_Boolean = false;
      }
      this.jdField_p_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.jdField_r_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if ((this.jdField_o_of_type_Int != 1) || (paramIntent.getBooleanExtra("is_anonymous", false))) {
        break label1115;
      }
      bool1 = true;
      this.jdField_v_of_type_Boolean = bool1;
      bool1 = paramIntent.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      if ((!this.jdField_v_of_type_Boolean) || (bool1)) {
        break label1121;
      }
      bool1 = true;
      this.jdField_v_of_type_Boolean = bool1;
      this.jdField_t_of_type_JavaLangString = paramIntent.getStringExtra("uinname");
      this.jdField_u_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      if (this.jdField_o_of_type_Int == 9501) {
        this.C = paramIntent.getBooleanExtra("isdevicesupportmultiupload", false);
      }
      if (this.jdField_p_of_type_JavaLangString != null) {
        break label1127;
      }
      localObject = this.jdField_z_of_type_JavaLangString;
      label518:
      this.jdField_p_of_type_JavaLangString = ((String)localObject);
      this.jdField_m_of_type_Int = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)MediaFileFilter.a.get(this.jdField_m_of_type_Int));
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = new DynamicImageMediaFileFilter(MediaFileFilter.b);
        this.jdField_m_of_type_Int = 1;
      }
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 293601280L);
      this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_PREVIEW_VIDEO", true);
      this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_TRIM_VIDEO_BLACK_LIST", false);
      this.jdField_c_of_type_Long = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", Long.MAX_VALUE);
      if (this.jdField_r_of_type_Boolean)
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        localObject = PresendPicMgr.a();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Photo+ send pic,cancel presend!");
          }
          ((PresendPicMgr)localObject).a(1004);
        }
        PhotoUtils.a(this, paramIntent, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_p_of_type_Int, true);
      }
      this.jdField_s_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      if ((this.jdField_v_of_type_Boolean) && (this.jdField_p_of_type_JavaLangString != null))
      {
        localObject = QZoneHelper.a(this.jdField_p_of_type_JavaLangString, this.jdField_u_of_type_JavaLangString);
        if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).b() == null) || (((BaseBusinessAlbumInfo)localObject).b().equals(""))) {
          break label1135;
        }
        this.jdField_v_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
        this.jdField_w_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).c();
        paramIntent.putExtra("UploadPhoto.key_album_id", this.jdField_v_of_type_JavaLangString);
        paramIntent.putExtra("UploadPhoto.key_album_name", this.jdField_w_of_type_JavaLangString);
      }
      label801:
      this.jdField_z_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
      this.jdField_A_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
      this.B = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_REWARD", false);
      if ((this.jdField_z_of_type_Boolean) || (this.jdField_A_of_type_Boolean) || (this.B)) {
        break label1158;
      }
    }
    label1115:
    label1121:
    label1127:
    label1135:
    label1158:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_w_of_type_Boolean = bool1;
      this.jdField_x_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
      if (this.B)
      {
        this.jdField_a_of_type_Double = paramIntent.getDoubleExtra("maxProportion", 0.0D);
        this.jdField_b_of_type_Double = paramIntent.getDoubleExtra("minProportion", 0.0D);
        this.jdField_s_of_type_Int = paramIntent.getIntExtra("imageSizeLimit", 0);
      }
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PasterConstants.pasters_data"));
        this.jdField_n_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_id");
        this.jdField_o_of_type_JavaLangString = paramIntent.getStringExtra("PasterConstants.paster_cate_id");
      }
      this.D = paramIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      this.jdField_A_of_type_JavaLangString = paramIntent.getStringExtra("report_from");
      this.jdField_u_of_type_Int = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      this.E = paramIntent.getBooleanExtra("from_health", false);
      this.F = paramIntent.getBooleanExtra("health_video", false);
      if (this.E)
      {
        this.jdField_v_of_type_Int = paramIntent.getIntExtra("min_width", 200);
        this.jdField_w_of_type_Int = paramIntent.getIntExtra("min_height", 200);
        this.jdField_x_of_type_Int = paramIntent.getIntExtra("max_gif_size", 8388608);
      }
      return;
      this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
      break;
      bool1 = false;
      break label425;
      bool1 = false;
      break label456;
      localObject = this.jdField_p_of_type_JavaLangString;
      break label518;
      paramIntent.putExtra("UploadPhoto.key_album_id", "");
      paramIntent.putExtra("UploadPhoto.key_album_name", "");
      break label801;
    }
  }
  
  public void b(String paramString)
  {
    AlbumUtil.a();
    Intent localIntent = getIntent();
    localIntent.putExtra("ALBUM_NAME", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("ALBUM_ID", this.jdField_m_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    if (this.jdField_m_of_type_Boolean)
    {
      HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!localHashMap.containsKey(paramString)) {
        localHashMap.put(paramString, new Pair(this.jdField_m_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString));
      }
      a(paramString);
      PhotoUtils.a(this, localIntent, this.jdField_c_of_type_JavaUtilArrayList, 0, this.jdField_a_of_type_Boolean);
      return;
    }
    if (!this.jdField_n_of_type_Boolean)
    {
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this, PhotoPreviewActivity.class);
      localIntent.putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.jdField_z_of_type_Boolean);
      localIntent.putExtra("PasterConstants.pasters_data", this.jdField_b_of_type_JavaUtilHashMap);
      localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      localIntent.addFlags(603979776);
      startActivity(localIntent);
      super.finish();
      AlbumUtil.a(this, true, true);
      return;
    }
    if (100 == localIntent.getIntExtra("Business_Origin", 0))
    {
      localIntent.setClass(this, PhotoCropForPortraitActivity.class);
      localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    }
    for (;;)
    {
      AlbumUtil.a(localIntent, this.jdField_m_of_type_JavaLangString, paramString, this.jdField_q_of_type_Boolean);
      localIntent.putExtra("PHOTOLIST_START_POSITION", this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s());
      break;
      localIntent.setClass(this, PhotoCropActivity.class);
    }
  }
  
  public boolean b()
  {
    return QzoneConfig.a().a("PhotoUpload", "QunAioRememberUpload", 1) != 0;
  }
  
  void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        d();
      }
      while (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.show();
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903453);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "dialog error");
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  void c(Intent paramIntent)
  {
    this.jdField_v_of_type_JavaLangString = paramIntent.getStringExtra("UploadPhoto.key_album_id");
    this.jdField_w_of_type_JavaLangString = paramIntent.getStringExtra("UploadPhoto.key_album_name");
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_z_of_type_Boolean);
    ThreadManager.a(new ork(this), 8, null, true);
    String str1 = "";
    paramIntent = "";
    String str2;
    if (TextUtils.isEmpty(this.jdField_v_of_type_JavaLangString))
    {
      str2 = getString(2131370133);
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        if (!"群相册".equals(str2)) {
          break label159;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131370132);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.post(new orm(this, str2));
      getIntent().putExtra("UploadPhoto.key_album_name", str1);
      getIntent().putExtra("UploadPhoto.key_album_id", paramIntent);
      return;
      str2 = this.jdField_w_of_type_JavaLangString;
      str1 = this.jdField_w_of_type_JavaLangString;
      paramIntent = this.jdField_v_of_type_JavaLangString;
      break;
      label159:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131370131);
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public void e()
  {
    Object localObject1;
    boolean bool1;
    if (this.jdField_s_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_s_of_type_JavaLangString;
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label392;
      }
      bool1 = true;
      label24:
      Object localObject2 = localObject1;
      if (bool1) {
        localObject2 = (String)localObject1 + "(" + this.jdField_c_of_type_JavaUtilArrayList.size() + ")";
      }
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "updateButton selectedPhotoList.size()=" + this.jdField_c_of_type_JavaUtilArrayList.size());
      }
      this.jdField_c_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(bool1);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool1);
      if ((this.D) || ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0))) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      }
      if (!bool1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
      }
      if (!this.jdField_i_of_type_Boolean) {
        break label403;
      }
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
        if ((this.jdField_c_of_type_JavaUtilArrayList.size() != 1) || (this.jdField_z_of_type_Boolean)) {
          break label397;
        }
      }
    }
    label392:
    label397:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((Button)localObject1).setEnabled(bool2);
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (bool1)
        {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        }
      }
      g();
      if (!this.jdField_k_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      if (this.jdField_z_of_type_Boolean)
      {
        localObject1 = getString(2131370125);
        break;
      }
      if (this.jdField_i_of_type_Boolean)
      {
        localObject1 = getString(2131370123);
        break;
      }
      localObject1 = getString(2131370124);
      break;
      bool1 = false;
      break label24;
    }
    label403:
    if (this.jdField_l_of_type_Boolean) {
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 1) && ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0))) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void f()
  {
    int i2 = 0;
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    int i3;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      long l1 = new File(str).length();
      i3 = (int)(i1 + l1);
      i1 = i3;
      if (QLog.isColorLevel())
      {
        QLog.d("_photo", 2, "setQualityTextViewText, path:" + str + ",len:" + l1);
        i1 = i3;
      }
    }
    localObject = PhotoUtils.a(this, i1);
    if (((String)localObject).equals("0"))
    {
      localObject = "(999K)";
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      i3 = ((String)localObject).length();
      i1 = i2;
      while (i1 < 6 - i3)
      {
        localObject = (String)localObject + " ";
        i1 += 1;
      }
      localObject = "(" + (String)localObject + ")";
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  public void g()
  {
    switch (this.jdField_p_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    f();
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  public void h()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    do
    {
      Intent localIntent;
      do
      {
        return;
        localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      } while (localIntent.resolveActivity(getPackageManager()) == null);
      Object localObject = null;
      try
      {
        File localFile = a();
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    } while (localObject == null);
    localIntent.putExtra("output", Uri.fromFile((File)localObject));
    startActivityForResult(localIntent, 16);
  }
  
  public void i()
  {
    Object localObject = PresendPicMgr.a();
    if (this.jdField_b_of_type_AndroidWidgetCheckBox != null) {}
    for (boolean bool = this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked();; bool = false)
    {
      this.jdField_z_of_type_Boolean = bool;
      if (!this.jdField_z_of_type_Boolean) {
        break;
      }
      if (localObject != null) {
        ((PresendPicMgr)localObject).a(1007);
      }
      StatisticConstants.b(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size());
      localIntent = getIntent();
      localIntent.putExtra("open_chatfragment_fromphoto", true);
      AIOGalleryUtils.a(this, localIntent, this.jdField_p_of_type_JavaLangString, this.jdField_u_of_type_JavaLangString, this.jdField_t_of_type_JavaLangString, this.jdField_v_of_type_JavaLangString, this.jdField_w_of_type_JavaLangString, this.jdField_p_of_type_Int, this.jdField_c_of_type_JavaUtilArrayList, 42);
      return;
    }
    if ((this.jdField_l_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_AndroidWidgetButton.performClick();
      return;
    }
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      StatisticConstants.a(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size());
      StatisticConstants.a(getIntent(), this.jdField_c_of_type_JavaUtilArrayList.size(), this.jdField_p_of_type_Int);
    }
    Intent localIntent = getIntent();
    if (this.jdField_p_of_type_Int == 2)
    {
      if (localObject != null)
      {
        ((PresendPicMgr)localObject).a(1008);
        ((PresendPicMgr)localObject).a();
      }
      ReportController.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      if (("qzone_plugin.apk".equals(localObject)) && ("com.qzone.video.activity.TrimVideoActivity".equals(str)))
      {
        localIntent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
      }
      PhotoUtils.a(this, localIntent, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_p_of_type_Int, this.jdField_a_of_type_Boolean);
      return;
      if (localObject != null) {
        ((PresendPicMgr)localObject).a(localIntent);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((QLog.isDevelopLevel()) && (this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() != 0)) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "[PhotoListActivity] [onActivityResult] selectedPhotoList = " + this.jdField_c_of_type_JavaUtilArrayList.size());
    }
    if ((this.jdField_v_of_type_Boolean) && (paramIntent != null) && (paramInt1 == 100) && (paramInt2 == -1) && (paramInt1 != 100003))
    {
      c(paramIntent);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    label172:
    do
    {
      return;
      if (paramInt2 != -1) {
        break;
      }
      switch (paramInt1)
      {
      default: 
        PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_o_of_type_Boolean, this.jdField_p_of_type_JavaLangString);
        return;
      case 16: 
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null) {
          paramIntent.a(this.jdField_x_of_type_JavaLangString, 1008);
        }
        a(true);
        return;
      }
    } while ((this.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() == 0));
    if (!this.jdField_l_of_type_Boolean)
    {
      PhotoMagicStickUtils.a((String)this.jdField_c_of_type_JavaUtilArrayList.get(0), this, this.jdField_a_of_type_Boolean, 5, this.jdField_p_of_type_JavaLangString, this.jdField_q_of_type_JavaLangString, this.jdField_r_of_type_JavaLangString);
      label269:
      overridePendingTransition(2130968620, 2130968621);
      return;
    }
    String str = (String)this.jdField_c_of_type_JavaUtilArrayList.get(0);
    if (this.jdField_b_of_type_JavaUtilHashMap == null)
    {
      paramIntent = null;
      label302:
      localObject = (HashMap)getIntent().getSerializableExtra("PasterConstants.original_to_bottom");
      if ((localObject == null) || (!((HashMap)localObject).containsKey(str))) {
        break label616;
      }
    }
    label616:
    for (Object localObject = (String)((HashMap)localObject).get(str);; localObject = str)
    {
      PhotoMagicStickUtils.a((String)localObject, str, this, this.jdField_a_of_type_Boolean, 5, this.jdField_p_of_type_JavaLangString, this.jdField_q_of_type_JavaLangString, this.jdField_r_of_type_JavaLangString, 8, this.jdField_n_of_type_JavaLangString, this.jdField_o_of_type_JavaLangString, paramIntent);
      this.jdField_n_of_type_JavaLangString = null;
      this.jdField_o_of_type_JavaLangString = null;
      break label269;
      paramIntent = (byte[])this.jdField_b_of_type_JavaUtilHashMap.get(str);
      break label302;
      paramIntent = new Intent();
      paramIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_p_of_type_Int);
      setResult(-1, paramIntent);
      super.finish();
      return;
      if (paramIntent == null) {
        break;
      }
      this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("ALBUM_ID");
      this.jdField_p_of_type_Int = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      if (this.jdField_l_of_type_JavaLangString != null) {}
      for (localObject = this.jdField_l_of_type_JavaLangString;; localObject = "最近照片")
      {
        setTitle((CharSequence)localObject);
        runOnUiThread(new orn(this));
        break;
      }
      if (paramIntent == null) {
        break;
      }
      this.jdField_c_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("img_list");
      if (!this.E) {
        break label172;
      }
      paramIntent = new Intent();
      paramIntent.putStringArrayListExtra("img_list", this.jdField_c_of_type_JavaUtilArrayList);
      super.setResult(-1, paramIntent);
      super.finish();
      return;
      if (!this.F) {
        break label172;
      }
      super.setResult(-1, paramIntent);
      super.finish();
      break label172;
      if (paramInt1 != 17) {
        break label172;
      }
      AlbumUtil.jdField_c_of_type_Long = 0L;
      return;
    }
  }
  
  public void onBackPressed()
  {
    this.jdField_s_of_type_Boolean = true;
    if ((this.E) || (this.F))
    {
      finish();
      AlbumUtil.a(this, false, false);
      return;
    }
    b();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    switch (paramCompoundButton.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCheckedChanged, error, default id is checked");
      }
      break;
    }
    for (;;)
    {
      return;
      if (LocalMultiProcConfig.a(this.jdField_p_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_u_of_type_JavaLangString, -1, this.jdField_p_of_type_JavaLangString) != 0) {}
      for (;;)
      {
        this.y = bool;
        if (this.y) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        paramCompoundButton = new QQCustomDialog(this, 2131558973);
        paramCompoundButton.setContentView(2130903241);
        paramCompoundButton.setTitle(getString(2131364348));
        paramCompoundButton.setMessage(getString(2131364350));
        paramCompoundButton.setNegativeButton(getString(2131364351), new orq(this));
        paramCompoundButton.setCanceledOnTouchOutside(false);
        paramCompoundButton.setCancelable(false);
        paramCompoundButton.show();
        QZoneClickReport.startReportImediately(this.jdField_p_of_type_JavaLangString, "40", "1");
        return;
        bool = false;
      }
      this.jdField_z_of_type_Boolean = paramBoolean;
      getIntent().putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", this.jdField_z_of_type_Boolean);
      e();
      return;
      if (paramBoolean) {
        if (a() > 0)
        {
          QQToast.a(this, getResources().getString(2131370138), 0).b(getResources().getDimensionPixelSize(2131492908));
          this.jdField_p_of_type_Int = 0;
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
      while (!this.jdField_k_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        this.jdField_p_of_type_Int = 2;
        f();
        continue;
        this.jdField_p_of_type_Int = 0;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    int i1 = paramView.getId();
    boolean bool1;
    if (LocalMultiProcConfig.a(this.jdField_p_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_u_of_type_JavaLangString, -1, this.jdField_p_of_type_JavaLangString) != 0)
    {
      bool1 = true;
      this.y = bool1;
      a(i1);
      switch (i1)
      {
      }
    }
    label785:
    label1097:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            bool1 = false;
            break;
            if (this.E)
            {
              b();
              return;
            }
            onBackPressed();
            return;
            AlbumUtil.c();
            AlbumUtil.a();
            if (this.E)
            {
              super.setResult(0);
              super.finish();
              AlbumUtil.a(this, false, false);
              return;
            }
            paramView = PresendPicMgr.a();
            if (paramView != null) {
              paramView.a(1006);
            }
            paramView = getIntent();
            if (this.jdField_c_of_type_JavaUtilArrayList != null) {}
            for (i1 = this.jdField_c_of_type_JavaUtilArrayList.size();; i1 = 0)
            {
              StatisticConstants.b(paramView, i1);
              if (this.jdField_p_of_type_Boolean) {
                break;
              }
              super.finish();
              AlbumUtil.a(this, false, false);
              return;
            }
            paramView = getIntent();
            String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            if (str1 == null)
            {
              QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
              return;
            }
            paramView.setClassName(str2, str1);
            paramView.removeExtra("PhotoConst.PHOTO_PATHS");
            paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
            paramView.addFlags(603979776);
            if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
              startActivity(paramView);
            }
            for (;;)
            {
              super.finish();
              AlbumUtil.a(this, false, false);
              return;
              paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
              str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
              String str3 = paramView.getStringExtra("PhotoConst.UIN");
              if ("qzone_plugin.apk".equals(str2))
              {
                QzonePluginProxyActivity.a(paramView, str1);
                QZoneHelper.a(this, str3, paramView, 2);
              }
              else if ("qqfav.apk".equals(str2))
              {
                QfavHelper.a(this, str3, paramView, 2);
              }
              else
              {
                QLog.e(jdField_a_of_type_JavaLangString, 1, "Watermark has been deleted!");
              }
            }
            if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
            {
              if (a() > 0)
              {
                QQToast.a(this, getResources().getString(2131370138), 0).b(getResources().getDimensionPixelSize(2131492908));
                return;
              }
              this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
              return;
            }
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            return;
          } while (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0);
          getIntent().removeExtra("param_initTime");
          getIntent().putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_c_of_type_JavaUtilArrayList);
          ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
          paramView = new Intent(BaseApplication.getContext(), PhotoPlusBridgeActivity.class);
          paramView.putExtra("photo_path", (String)this.jdField_c_of_type_JavaUtilArrayList.get(0));
          paramView.putExtra("iswaitforsult", this.jdField_a_of_type_Boolean);
          paramView.putExtra("type", this.jdField_o_of_type_Int);
          paramView.putExtra("uin", this.jdField_p_of_type_JavaLangString);
          paramView.putExtra("nick", this.jdField_q_of_type_JavaLangString);
          paramView.putExtra("headDir", this.jdField_r_of_type_JavaLangString);
          startActivityForResult(paramView, 100003);
          this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
          return;
          a(false);
          return;
          this.jdField_c_of_type_AndroidWidgetButton.setClickable(false);
          if (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
            a((String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1));
          }
          AlbumUtil.a();
          if (this.jdField_c_of_type_JavaUtilArrayList.size() != 0) {
            break label785;
          }
        } while (!QLog.isColorLevel());
        QLog.e("PhotoList", 2, "size == 0");
        return;
        if (getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
        {
          paramView = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          for (long l1 = 0L; paramView.hasNext(); l1 += FileUtils.a((String)paramView.next())) {}
          if (FileManagerUtil.a())
          {
            FMDialogUtil.a(this, 2131362855, 2131362851, new orr(this));
            return;
          }
        }
        if (this.E)
        {
          paramView = new Intent();
          paramView.putStringArrayListExtra("img_list", this.jdField_c_of_type_JavaUtilArrayList);
          super.setResult(-1, paramView);
          super.finish();
          AlbumUtil.a(this, false, false);
          return;
        }
        i();
        return;
        if (!this.y)
        {
          this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
          paramView = new QQCustomDialog(this, 2131558973);
          paramView.setContentView(2130903241);
          paramView.setTitle(getString(2131364348));
          paramView.setMessage(getString(2131364350));
          paramView.setNegativeButton(getString(2131364351), new ors(this));
          paramView.setCanceledOnTouchOutside(false);
          paramView.setCancelable(false);
          paramView.show();
          QZoneClickReport.startReportImediately(this.jdField_p_of_type_JavaLangString, "40", "1");
          return;
        }
        if (this.jdField_b_of_type_AndroidWidgetCheckBox != null)
        {
          paramView = this.jdField_b_of_type_AndroidWidgetCheckBox;
          if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label1097;
          }
          bool1 = bool2;
          paramView.setChecked(bool1);
        }
      } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
      if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()) {}
      for (paramView = "0X80047F8";; paramView = "0X80047F9")
      {
        ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, this.jdField_p_of_type_JavaLangString, "", "", "");
        return;
        bool1 = false;
        break;
      }
      if (!this.y)
      {
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        paramView = new QQCustomDialog(this, 2131558973);
        paramView.setContentView(2130903241);
        paramView.setTitle(getString(2131364348));
        paramView.setMessage(getString(2131364350));
        paramView.setNegativeButton(getString(2131364351), new orj(this));
        paramView.setCanceledOnTouchOutside(false);
        paramView.setCancelable(false);
        paramView.show();
        QZoneClickReport.startReportImediately(this.jdField_p_of_type_JavaLangString, "40", "1");
        return;
      }
      paramView = QZoneHelper.UserInfo.a();
      paramView.jdField_a_of_type_JavaLangString = this.jdField_p_of_type_JavaLangString;
      paramView.jdField_b_of_type_JavaLangString = this.jdField_t_of_type_JavaLangString;
      QZoneHelper.d(this, paramView, this.jdField_u_of_type_JavaLangString, this.jdField_t_of_type_JavaLangString, 100);
      return;
    } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
    if (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())
    {
      paramView = "0X80047F8";
      if ((b()) && (this.jdField_w_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null))
      {
        if ((Build.VERSION.SDK_INT < 9) || (!TextUtils.isEmpty(this.jdField_v_of_type_JavaLangString))) {
          break label1393;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("qzone_will_upload_to_qun_album" + this.jdField_u_of_type_JavaLangString, this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()).apply();
      }
    }
    for (;;)
    {
      ReportController.a(null, "CliOper", "", "", paramView, paramView, 0, 0, this.jdField_p_of_type_JavaLangString, "", "", "");
      return;
      paramView = "0X80047F9";
      break;
      label1393:
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("qzone_will_upload_to_qun_album" + this.jdField_u_of_type_JavaLangString, this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()).commit();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    try
    {
      super.setContentView(2130904280);
      getWindow().setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
      paramBundle = getResources();
      int i1 = paramBundle.getDisplayMetrics().widthPixels;
      this.jdField_k_of_type_Int = paramBundle.getDimensionPixelSize(2131493036);
      this.jdField_i_of_type_Int = paramBundle.getDimensionPixelSize(2131493034);
      this.jdField_j_of_type_Int = paramBundle.getDimensionPixelSize(2131493035);
      this.jdField_l_of_type_Int = AIOUtils.a(1.0F, paramBundle);
      this.jdField_g_of_type_Int = ((i1 - this.jdField_k_of_type_Int * 2 - this.jdField_i_of_type_Int * 2) / 3);
      this.jdField_h_of_type_Int = this.jdField_g_of_type_Int;
      paramBundle = getIntent();
      b(paramBundle);
      a();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " onCreate(),extra is:" + paramBundle.getExtras());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + ",hashCode is:" + System.identityHashCode(this));
      }
      if (this.jdField_h_of_type_Boolean)
      {
        paramBundle = new NewIntent(BaseApplicationImpl.a(), QZoneAlbumListNumServlet.class);
        paramBundle.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.a().a().getAccount()));
        BaseApplicationImpl.a().a().registObserver(jdField_a_of_type_Orx);
        BaseApplicationImpl.a().a().startServlet(paramBundle);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      super.finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_s_of_type_Boolean) {
      AlbumThumbManager.a(this).a();
    }
    if (this.jdField_a_of_type_Orv != null)
    {
      int i1 = this.jdField_a_of_type_Orv.getCount();
      AlbumUtil.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_m_of_type_JavaLangString, Integer.valueOf(i1));
    }
    if (this.jdField_h_of_type_Boolean) {
      BaseApplicationImpl.a().a().unRegistObserver(jdField_a_of_type_Orx);
    }
    jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + " onNewIntent() is called,extra is:" + paramIntent.getExtras());
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPhotoTrace", 2, jdField_a_of_type_JavaLangString + "hashCode is:" + System.identityHashCode(this));
    }
    setIntent(paramIntent);
    b(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    runOnUiThread(new oro(this));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.H) && (this.jdField_v_of_type_Boolean) && (this.jdField_p_of_type_JavaLangString != null))
    {
      c(getIntent());
      this.H = false;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PhotoListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */