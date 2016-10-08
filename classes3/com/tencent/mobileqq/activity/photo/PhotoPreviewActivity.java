package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import ory;
import orz;
import osa;
import osb;
import osc;
import osd;
import osf;
import osg;
import osh;
import osi;

public class PhotoPreviewActivity
  extends PeakActivity
  implements CompoundButton.OnCheckedChangeListener
{
  static int jdField_a_of_type_Int = 19922944;
  public static final String a = "FROM_WHERE";
  public static final String b = "FromCamera";
  public static final String c = "FromFastImage";
  public static final String d = "showFlashPic";
  public static final String e = "back_btn_text";
  public static final String f = "from_health";
  public long a;
  public View a;
  public Button a;
  public CheckBox a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProGallery a;
  public NumberCheckBox a;
  public BubblePopupWindow a;
  public ArrayList a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  osi jdField_a_of_type_Osi;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public View b;
  public Button b;
  public CheckBox b;
  TextView b;
  public ArrayList b;
  public boolean b;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public ArrayList c;
  public int d;
  public TextView d;
  public boolean d;
  public int e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  boolean jdField_f_of_type_Boolean = false;
  public int g;
  public String g;
  boolean g;
  public int h;
  public String h;
  boolean h;
  public int i;
  public String i;
  boolean i;
  public int j;
  public String j;
  boolean j;
  private int jdField_k_of_type_Int;
  public String k;
  boolean jdField_k_of_type_Boolean = false;
  String l;
  public boolean l;
  String jdField_m_of_type_JavaLangString;
  boolean jdField_m_of_type_Boolean = false;
  String n;
  public boolean n;
  String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean;
  String jdField_p_of_type_JavaLangString;
  private boolean jdField_p_of_type_Boolean;
  String jdField_q_of_type_JavaLangString;
  private boolean jdField_q_of_type_Boolean;
  String jdField_r_of_type_JavaLangString;
  private boolean jdField_r_of_type_Boolean;
  String s;
  public String t = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PhotoPreviewActivity()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 1007;
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((localInteger == null) || (localInteger.intValue() < 0) || (localInteger.intValue() >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(localInteger.intValue())).length() <= jdField_a_of_type_Int)) {
        break label95;
      }
      i1 += 1;
    }
    label95:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.s();
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
      }
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    return localArrayList;
  }
  
  void a()
  {
    this.jdField_q_of_type_Boolean = BaseApplicationImpl.a().getSharedPreferences(BaseApplicationImpl.a().a().getAccount(), 4).getBoolean("showFlashPic", true);
    Intent localIntent = getIntent();
    this.jdField_j_of_type_JavaLangString = localIntent.getStringExtra("FROM_WHERE");
    this.jdField_l_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.t = localIntent.getStringExtra("readSource");
    this.jdField_o_of_type_Boolean = localIntent.getBooleanExtra("showFlashPic", false);
    this.jdField_k_of_type_Int = localIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    Object localObject;
    String str;
    if ((!this.jdField_l_of_type_Boolean) && (("FromCamera".equals(this.jdField_j_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_j_of_type_JavaLangString))))
    {
      localObject = (BinderWarpper)localIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).b();
        }
        localObject = PresendPicMgr.b(IPresendPicMgr.Stub.a(((BinderWarpper)localObject).a));
        if (!"FromFastImage".equals(this.jdField_j_of_type_JavaLangString)) {
          break label912;
        }
        this.jdField_i_of_type_Int = 1037;
        str = (String)localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        ((PresendPicMgr)localObject).a(str, this.jdField_i_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d(y, 2, "  initData , presendMgr = " + localObject + ",picpath = " + str + ",from = " + this.jdField_j_of_type_JavaLangString + ",mBusiType = " + this.jdField_i_of_type_Int);
        }
      }
    }
    this.jdField_n_of_type_Boolean = localIntent.getBooleanExtra("callFromFastImage", false);
    if ("FromFastImage".equals(this.jdField_j_of_type_JavaLangString)) {
      StatisticConstants.c();
    }
    if ("FromCamera".equals(this.jdField_j_of_type_JavaLangString)) {
      StatisticConstants.a();
    }
    localIntent.removeExtra("FROM_WHERE");
    this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.jdField_i_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    this.jdField_j_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_OVERLOAD", false);
    this.jdField_q_of_type_JavaLangString = localIntent.getStringExtra("back_btn_text");
    localIntent.removeExtra("PhotoConst.SHOW_ALBUM");
    localIntent.removeExtra("PhotoConst.IS_OVERLOAD");
    if (this.jdField_i_of_type_Boolean) {
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilArrayList = PhotoListActivity.jdField_a_of_type_JavaUtilArrayList;
        label397:
        this.jdField_b_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        this.jdField_c_of_type_JavaUtilArrayList = localIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
        if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
          break label1160;
        }
        if (QLog.isColorLevel()) {
          QLog.d(y, 2, "initData(): Error! selectedItem or sSelectedIndex is null");
        }
        finish();
      }
    }
    label630:
    label912:
    label1129:
    label1137:
    label1160:
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0)
      {
        this.jdField_f_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_j_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
        localIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
        this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
        this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        if (this.jdField_e_of_type_Boolean)
        {
          this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_UIN");
          this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_NICK");
          this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.MY_HEAD_DIR");
        }
        this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PasterConstants.pasters_data"));
          this.jdField_r_of_type_JavaLangString = localIntent.getStringExtra("PasterConstants.paster_id");
          this.s = localIntent.getStringExtra("PasterConstants.paster_cate_id");
        }
        if (this.jdField_g_of_type_JavaLangString != null) {
          break label1129;
        }
        localObject = this.z;
        this.jdField_g_of_type_JavaLangString = ((String)localObject);
        this.jdField_b_of_type_Int = localIntent.getIntExtra("uintype", -1);
        this.jdField_g_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
        this.jdField_h_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", false);
        this.jdField_e_of_type_Int = localIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        this.jdField_m_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
        if (this.jdField_m_of_type_Boolean)
        {
          localIntent.removeExtra("PhotoConst.SEND_FLAG");
          localObject = PresendPicMgr.a(null);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(y, 2, "Photo+ send pic,cancel presend!");
            }
            ((PresendPicMgr)localObject).a(1003);
          }
          PhotoUtils.a(this, getIntent(), this.jdField_b_of_type_JavaUtilArrayList, this.jdField_e_of_type_Int, true);
        }
        this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
        this.jdField_k_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
        if (this.jdField_k_of_type_Boolean)
        {
          this.jdField_n_of_type_JavaLangString = localIntent.getStringExtra("uinname");
          this.jdField_m_of_type_JavaLangString = localIntent.getStringExtra("uin");
        }
        if ((this.jdField_b_of_type_Int == 1) && (this.jdField_g_of_type_JavaLangString != null))
        {
          localObject = QZoneHelper.a(this.jdField_g_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString);
          if ((localObject == null) || (((BaseBusinessAlbumInfo)localObject).b() == null) || (((BaseBusinessAlbumInfo)localObject).b().equals(""))) {
            break label1137;
          }
          this.jdField_o_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).b();
          this.jdField_p_of_type_JavaLangString = ((BaseBusinessAlbumInfo)localObject).c();
          localIntent.putExtra("UploadPhoto.key_album_id", this.jdField_o_of_type_JavaLangString);
          localIntent.putExtra("UploadPhoto.key_album_name", this.jdField_p_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("from_health", false);
        return;
        this.jdField_i_of_type_Int = 1008;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        break label397;
        this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          if (str != null)
          {
            if (!new File(str).exists()) {
              ((Iterator)localObject).remove();
            }
          }
          else {
            ((Iterator)localObject).remove();
          }
        }
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        if (this.jdField_l_of_type_Boolean) {
          break label1160;
        }
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
          i1 += 1;
        }
        localObject = this.jdField_g_of_type_JavaLangString;
        break label630;
        localIntent.putExtra("UploadPhoto.key_album_id", "");
        localIntent.putExtra("UploadPhoto.key_album_name", "");
      }
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  void b()
  {
    this.L = true;
    this.M = false;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298645);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297952);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298658));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298659));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298660));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298661));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298662));
    if (this.jdField_o_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ory(this));
    }
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new orz(this));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298657));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298663));
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)findViewById(2131298656));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131298655);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297123));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new osa(this));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298646));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new osb(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new osc(this));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new osd(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery = ((ProGallery)findViewById(2131298351));
      this.jdField_a_of_type_Osi = new osi(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setAdapter(this.jdField_a_of_type_Osi);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnNoBlankListener(this.jdField_a_of_type_Osi);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemSelectedListener(new osf(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSpacing(getResources().getDimensionPixelSize(2131492970));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setSelection(this.jdField_j_of_type_Int);
      c();
      if ((this.jdField_h_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.setOnItemClickListener(new osg(this));
      if (("FromCamera".equals(this.jdField_j_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_j_of_type_JavaLangString)) || ("FROM_PHOTO_LIST_FLOW".equals(this.jdField_j_of_type_JavaLangString)))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131370327);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
        if (!"FROM_PHOTO_LIST_FLOW".equals(this.jdField_j_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new osh(this));
      if (this.jdField_l_of_type_Boolean) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_q_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_Int == 1001)
      {
        this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void c()
  {
    if (this.jdField_e_of_type_Boolean) {}
    for (Object localObject = getString(2131370123);; localObject = getString(2131370124))
    {
      if (this.jdField_k_of_type_Boolean) {
        localObject = getString(2131370125);
      }
      if (this.jdField_l_of_type_JavaLangString != null) {
        localObject = this.jdField_l_of_type_JavaLangString;
      }
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label197;
      }
      if ((!this.jdField_h_of_type_Boolean) && (!this.jdField_l_of_type_Boolean)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || ((this.jdField_b_of_type_JavaUtilArrayList.size() == 1) && (!this.jdField_k_of_type_Boolean))) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      d();
      this.jdField_b_of_type_AndroidWidgetButton.setText((String)localObject + "(" + this.jdField_b_of_type_JavaUtilArrayList.size() + ")");
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    label197:
    this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
    localObject = this.jdField_b_of_type_AndroidWidgetCheckBox;
    if (this.jdField_e_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((CheckBox)localObject).setChecked(bool);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      if (this.jdField_e_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16734752);
      }
      d();
      return;
    }
  }
  
  void d()
  {
    switch (this.jdField_e_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131370122));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
    }
    e();
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
  }
  
  void e()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    int i2 = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      long l1 = new File(str).length();
      int i3 = i2;
      if (l1 > jdField_a_of_type_Int) {
        i3 = i2 + 1;
      }
      int i4 = (int)(i1 + l1);
      i1 = i4;
      i2 = i3;
      if (QLog.isColorLevel())
      {
        QLog.d("_photo", 2, "setQualityTextViewText, path:" + str + ",len:" + l1);
        i1 = i4;
        i2 = i3;
      }
    }
    localObject = PhotoUtils.a(this, i1);
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = getString(2131370122);; localObject = getString(2131370122) + "(" + "共" + (String)localObject + ")")
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void f()
  {
    getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    Object localObject;
    if ("FROM_PHOTO_LIST".equals(this.jdField_j_of_type_JavaLangString))
    {
      localObject = getIntent();
      ((Intent)localObject).setClass(this, PhotoListActivity.class);
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
      if (this.jdField_l_of_type_Boolean)
      {
        ((Intent)localObject).removeExtra("PhotoConst.PHOTO_PATHS");
        startActivity((Intent)localObject);
      }
    }
    label235:
    do
    {
      do
      {
        for (;;)
        {
          if (getIntent().getBooleanExtra("keep_selected_status_after_finish", false))
          {
            localObject = new Intent();
            ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
            ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
            ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
            setResult(-1, (Intent)localObject);
          }
          super.finish();
          AlbumUtil.a(this, true, false);
          return;
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
          break;
          if ((!"FROM_PHOTO_LIST_FLOW".equals(this.jdField_j_of_type_JavaLangString)) || (this.jdField_l_of_type_Boolean)) {
            break label235;
          }
          localObject = new Intent();
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
          ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.jdField_c_of_type_JavaUtilArrayList);
          ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.jdField_e_of_type_Int);
          setResult(-1, (Intent)localObject);
        }
      } while ((!"FromCamera".equals(this.jdField_j_of_type_JavaLangString)) && (!"FromFastImage".equals(this.jdField_j_of_type_JavaLangString)));
      localObject = PresendPicMgr.a(null);
    } while (localObject == null);
    if ("FromCamera".equals(this.jdField_j_of_type_JavaLangString)) {}
    for (int i1 = 1016;; i1 = 1017)
    {
      ((PresendPicMgr)localObject).a(i1);
      break;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putStringArrayListExtra("img_list", this.jdField_b_of_type_JavaUtilArrayList);
      super.setResult(-1, (Intent)localObject1);
      super.finish();
      return;
    }
    if (this.jdField_k_of_type_Boolean)
    {
      localObject1 = PresendPicMgr.a(null);
      if (localObject1 != null) {
        ((PresendPicMgr)localObject1).a(1009);
      }
      localObject1 = a();
      if (localObject1 != null) {
        StatisticConstants.b(getIntent(), ((ArrayList)localObject1).size());
      }
      localObject2 = getIntent();
      ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
      AIOGalleryUtils.a(this, (Intent)localObject2, this.jdField_g_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, this.jdField_o_of_type_JavaLangString, this.jdField_p_of_type_JavaLangString, this.jdField_e_of_type_Int, (ArrayList)localObject1, 42);
    }
    for (;;)
    {
      Intent localIntent = getIntent();
      if ((localIntent == null) || (!localIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false))) {
        break;
      }
      localObject3 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIntent.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if ((localObject3 == null) || (localObject1 == null)) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      return;
      if ((!this.jdField_f_of_type_Boolean) || ((TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) && (TextUtils.isEmpty(this.s)))) {
        break label276;
      }
      this.jdField_a_of_type_AndroidWidgetButton.performClick();
    }
    label276:
    if ("FromFastImage".equals(this.jdField_j_of_type_JavaLangString))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      StatisticConstants.d();
    }
    if ("FromCamera".equals(this.jdField_j_of_type_JavaLangString)) {
      StatisticConstants.b();
    }
    Object localObject1 = a();
    if (localObject1 != null)
    {
      StatisticConstants.a(((ArrayList)localObject1).size(), this.jdField_f_of_type_Int);
      StatisticConstants.a(getIntent(), ((ArrayList)localObject1).size(), this.jdField_e_of_type_Int);
    }
    Object localObject2 = getIntent();
    Object localObject3 = PresendPicMgr.a(null);
    if (this.jdField_e_of_type_Int == 2)
    {
      if ((this.jdField_c_of_type_JavaUtilArrayList.size() == 0) && (((ArrayList)localObject1).size() == 1) && (FileUtils.a((String)((ArrayList)localObject1).get(0)) > 19922944L))
      {
        QQToast.a(this, getResources().getString(2131370138), 0).b(getResources().getDimensionPixelSize(2131492908));
        this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
        return;
      }
      if (localObject3 != null)
      {
        ((PresendPicMgr)localObject3).a(1010);
        ((PresendPicMgr)localObject3).a();
      }
      if (("FromCamera".equals(this.jdField_j_of_type_JavaLangString)) || ("FromFastImage".equals(this.jdField_j_of_type_JavaLangString)))
      {
        ReportController.b(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
        label526:
        if (this.jdField_p_of_type_Boolean)
        {
          ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
          if (this.jdField_b_of_type_Int != 0) {
            break label702;
          }
          ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
          ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      PhotoUtils.a(this, (Intent)localObject2, (ArrayList)localObject1, this.jdField_e_of_type_Int, this.jdField_d_of_type_Boolean);
      break;
      ReportController.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
      break label526;
      if ((localObject3 == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) || (this.jdField_p_of_type_Boolean) || (this.jdField_r_of_type_Boolean)) {
        break label526;
      }
      ((PresendPicMgr)localObject3).a((Intent)localObject2);
      break label526;
      label702:
      if (this.jdField_b_of_type_Int == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (this.jdField_b_of_type_Int == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d(y, 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    if ((paramInt2 == -1) && (paramInt1 == 100003))
    {
      if (this.jdField_k_of_type_JavaLangString != null)
      {
        if (!"FROM_PHOTO_LIST".equals(this.jdField_j_of_type_JavaLangString)) {
          break label159;
        }
        paramInt1 = 5;
        paramIntent = getIntent();
        if (!this.jdField_p_of_type_Boolean) {
          break label164;
        }
        paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      for (;;)
      {
        if (this.jdField_f_of_type_Boolean) {
          break label178;
        }
        PhotoMagicStickUtils.a(this.jdField_k_of_type_JavaLangString, this, this.jdField_d_of_type_Boolean, paramInt1, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString);
        overridePendingTransition(2130968620, 2130968621);
        return;
        label159:
        paramInt1 = 3;
        break;
        label164:
        paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
      }
      label178:
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {}
      for (paramIntent = null;; paramIntent = (byte[])this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_k_of_type_JavaLangString))
      {
        String str2 = this.jdField_k_of_type_JavaLangString;
        HashMap localHashMap = (HashMap)getIntent().getSerializableExtra("PasterConstants.original_to_bottom");
        String str1 = str2;
        if (localHashMap != null)
        {
          str1 = str2;
          if (localHashMap.containsKey(this.jdField_k_of_type_JavaLangString)) {
            str1 = (String)localHashMap.get(this.jdField_k_of_type_JavaLangString);
          }
        }
        PhotoMagicStickUtils.a(str1, this.jdField_k_of_type_JavaLangString, this, this.jdField_d_of_type_Boolean, 3, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, paramInt1, this.jdField_r_of_type_JavaLangString, this.s, paramIntent);
        this.jdField_r_of_type_JavaLangString = null;
        this.s = null;
        break;
      }
    }
    PhotoUtils.a(this, paramInt1, paramInt2, paramIntent, this.jdField_g_of_type_Boolean, this.jdField_g_of_type_JavaLangString);
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.a(false)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      super.setResult(0);
      super.finish();
      return;
    }
    f();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    label467:
    do
    {
      do
      {
        int i1;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!paramBoolean) {
                    break label467;
                  }
                  paramCompoundButton = this.jdField_a_of_type_AndroidWidgetCheckBox;
                  if (!paramBoolean) {}
                  for (paramBoolean = true;; paramBoolean = false)
                  {
                    paramCompoundButton.setChecked(paramBoolean);
                    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
                    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5855578);
                    if (a() <= 0) {
                      break;
                    }
                    QQToast.a(this, getResources().getString(2131370138), 0).b(getResources().getDimensionPixelSize(2131492908));
                    this.jdField_e_of_type_Int = 0;
                    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131370122));
                    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
                    return;
                  }
                  if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
                    break;
                  }
                  i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.s();
                } while (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size());
                if (new File((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).length() > 19922944L)
                {
                  QQToast.a(this, getResources().getString(2131370138), 0).b(getResources().getDimensionPixelSize(2131492908));
                  this.jdField_e_of_type_Int = 0;
                  this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131370122));
                  this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
                  return;
                }
                this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(1);
                this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
                this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
                this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
                this.jdField_e_of_type_Int = 2;
                e();
                c();
                paramCompoundButton = PresendPicMgr.a();
                if (paramCompoundButton != null) {
                  paramCompoundButton.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1), this.jdField_i_of_type_Int);
                }
                paramCompoundButton = getIntent();
              } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
              paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
            } while (paramCompoundButton == null);
            ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
            return;
            this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
            this.jdField_e_of_type_Int = 2;
            e();
            paramCompoundButton = getIntent();
          } while ((paramCompoundButton == null) || (!paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")));
          paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
        } while (paramCompoundButton == null);
        ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
        return;
        this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_e_of_type_Int = 0;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131370122));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16734752);
        return;
        this.jdField_p_of_type_Boolean = paramBoolean;
        if (!paramBoolean) {
          break;
        }
        this.jdField_r_of_type_Boolean = true;
        paramCompoundButton = this.jdField_b_of_type_AndroidWidgetCheckBox;
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-5855578);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16734752);
          if ((this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoProGallery.s() < this.jdField_a_of_type_JavaUtilArrayList.size()))
          {
            this.jdField_c_of_type_AndroidViewView.performClick();
            c();
          }
          if ((this.jdField_q_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null))
          {
            this.jdField_q_of_type_Boolean = false;
            BaseApplicationImpl.a().getSharedPreferences(BaseApplicationImpl.a().a().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
            paramCompoundButton = new TextView(this);
            i1 = AIOUtils.a(10.0F, getResources());
            paramCompoundButton.setPadding(i1, 0, i1, 0);
            paramCompoundButton.setTextColor(-1);
            paramCompoundButton.setText("选中的图片每人只能查看一次");
            paramCompoundButton.setTextSize(15.0F);
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(paramCompoundButton);
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(this.jdField_a_of_type_AndroidWidgetCheckBox);
          }
          if (this.jdField_b_of_type_Int != 0) {
            break;
          }
          ReportController.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_b_of_type_Int == 3000)
        {
          ReportController.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_b_of_type_Int != 1);
      ReportController.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16734752);
    } while (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow == null);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903452);
    this.jdField_g_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_h_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.jdField_k_of_type_Int);
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
    super.onDestroy();
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (localObject != null)
        {
          localObject = new File((String)localObject);
          URLDrawable.removeMemoryCacheByUrl(((File)localObject).toURL().toString());
          URLDrawable.removeMemoryCacheByUrl(((File)localObject).toURL().toString() + "#NOSAMPLE");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, "remove file error");
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    a();
    b();
  }
  
  protected void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PhotoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */