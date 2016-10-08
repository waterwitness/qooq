package com.tencent.mobileqq.businessCard.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Gallery;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import qwa;
import qwb;
import qwc;
import qwd;
import qwe;
import qwf;
import qwg;
import qwh;
import qwi;

public class CardPicGalleryActivity
  extends BaseActivity
{
  public static final int a = 10;
  public static final String a = "business_card_pics";
  public static final int b = 1;
  public static final String b = "is_edit_mode";
  public static final int c = 2;
  public static final String c = "extra_mode";
  public static final String d = "extra_default";
  public Drawable a;
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  public ArrayList a;
  public boolean a;
  public int d;
  public int e;
  public int f;
  
  public CardPicGalleryActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = -1;
    this.f = 1;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = new qwi(this);
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new qwh(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  String a(URLDrawable paramURLDrawable)
  {
    Object localObject = new File(AppConstants.cb);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    String str = AppConstants.cb + this.app.a() + Utils.Crc64String(paramURLDrawable.getURL().toString());
    localObject = str;
    if (!new File(str).exists()) {}
    try
    {
      localObject = paramURLDrawable.saveTo(str);
      return (String)localObject;
    }
    catch (IOException paramURLDrawable)
    {
      do
      {
        localObject = str;
      } while (!QLog.isColorLevel());
      QLog.e("foward", 2, "IOException", paramURLDrawable);
    }
    return str;
  }
  
  public void a()
  {
    if ((this.f == 1) && (!this.jdField_a_of_type_Boolean)) {}
    label15:
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label15;
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentWidgetGallery == null);
          localObject = this.jdField_a_of_type_ComTencentWidgetGallery.a();
        } while (localObject == null);
        localObject = ((ImageView)((View)localObject).findViewById(2131301383)).getDrawable();
      } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
      localObject = (URLDrawable)localObject;
    } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (((URLDrawable)localObject).getStatus() != 1));
    ActionSheet localActionSheet = ActionSheet.a(this);
    a(localActionSheet);
    localActionSheet.a(new qwe(this, (URLDrawable)localObject, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (this.f)
    {
    default: 
      return;
    case 1: 
      b(paramInt, paramURLDrawable);
      return;
    }
    c(paramInt, paramURLDrawable);
  }
  
  void a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = a(paramURLDrawable);
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.app.a();
    QZoneHelper.a(this, localUserInfo, false, "0", "", 1, paramURLDrawable, "", System.currentTimeMillis(), 0L, -1);
  }
  
  void a(URLDrawable paramURLDrawable, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    String str = a(paramURLDrawable);
    localBundle.putBoolean("forward_urldrawable", true);
    localBundle.putString("forward_urldrawable_thumb_url", paramString);
    localBundle.putString("forward_filepath", str);
    localBundle.putString("forward_urldrawable_big_url", paramURLDrawable.getURL().toString());
    localBundle.putString("forward_extra", str);
    paramURLDrawable = new Intent();
    paramURLDrawable.putExtras(localBundle);
    ForwardBaseOption.a(this, paramURLDrawable, 21);
  }
  
  protected void a(ActionSheet paramActionSheet)
  {
    switch (this.f)
    {
    default: 
      return;
    case 1: 
      paramActionSheet.c(2131371256);
      paramActionSheet.c(2131371251);
      paramActionSheet.c(2131371233);
      paramActionSheet.d(2131367262);
      return;
    }
    paramActionSheet.c(2131370093);
    paramActionSheet.c(2131370099);
    paramActionSheet.c(2131370097);
    paramActionSheet.d(2131367262);
  }
  
  protected void b(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      c(paramURLDrawable);
      return;
    case 1: 
      paramURLDrawable = new Intent(getActivity(), FlowCameraPhotoActivity.class);
      paramURLDrawable.putExtra("extra_return_result", true);
      startActivityForResult(paramURLDrawable, 10);
      return;
    }
    BusinessCardUtils.a(this.app, this);
  }
  
  void b(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = a(paramURLDrawable);
    try
    {
      QfavBuilder.b(paramURLDrawable).a(this, this.app.a());
      QfavReport.a(null, 40, 3);
      return;
    }
    catch (Exception paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "", paramURLDrawable);
      }
      QQToast.a(this, getString(2131368692), 0).a();
    }
  }
  
  protected void c(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramURLDrawable, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.e));
      return;
    case 1: 
      c(paramURLDrawable);
      return;
    }
    b(paramURLDrawable);
  }
  
  void c(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.bo).mkdirs();
      str = AppConstants.bo + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131368778), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131368781)).setMessage(getString(2131368783)).setPositiveButton(getString(2131368782), new qwg(this, paramURLDrawable, str)).setNegativeButton(getString(2131367259), new qwf(this)).show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10) {
      if ((paramIntent != null) && ((CardOCRInfo)paramIntent.getParcelableExtra("extra_return_ocr_info") != null))
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    while ((paramInt1 != 21) || (paramInt2 != -1)) {
      return;
    }
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130904096);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra("business_card_pics");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("is_edit_mode", false);
    this.f = paramBundle.getIntExtra("extra_mode", 1);
    this.d = paramBundle.getIntExtra("extra_default", 0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300191));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new qwa(this));
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131298351));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301382));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new qwb(this));
    if ((this.f == 1) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131492970));
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new qwc(this));
    if (this.f == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new qwd(this));
    }
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      Intent localIntent = new Intent(this, FlowCameraPhotoActivity.class);
      localIntent.putExtra("is_upload_photo", true);
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramIntent);
      localIntent.putExtra("extra_return_result", true);
      startActivityForResult(localIntent, 10);
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130968823);
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\activity\CardPicGalleryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */