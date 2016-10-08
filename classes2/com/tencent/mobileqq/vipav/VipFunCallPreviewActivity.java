package com.tencent.mobileqq.vipav;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MediaPlayerHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wgf;
import wgg;
import wgh;

public class VipFunCallPreviewActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener
{
  static final String jdField_e_of_type_JavaLangString = "funcType";
  static final int jdField_f_of_type_Int = 1;
  static final String jdField_f_of_type_JavaLangString = "url";
  static final int jdField_g_of_type_Int = 2;
  static final String jdField_g_of_type_JavaLangString = "fcID";
  static final int h = 3;
  static final int i = 4;
  static final int j = 5;
  static final int k = 6;
  public int a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
  VipFullScreenVideoView jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView;
  protected VipFunCallObserver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public Runnable a;
  final String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  public boolean a;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  boolean jdField_b_of_type_Boolean;
  final int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  final String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  public int e;
  View jdField_e_of_type_AndroidViewView;
  public View f;
  public View g;
  
  public VipFunCallPreviewActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "VipFunCallPreviewActivity";
    this.jdField_c_of_type_Int = 201605;
    this.jdField_c_of_type_JavaLangString = "FT";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = MediaPlayerHelper.a();
    this.jdField_a_of_type_JavaLangRunnable = new wgf(this);
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new wgh(this);
  }
  
  Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
    }
    return ImageUtil.a();
  }
  
  protected String a(int paramInt)
  {
    String str = "mvip.gxh.android.funcallnew_" + paramInt;
    if (QLog.isColorLevel()) {
      QLog.e("VipFunCallPreviewActivity", 2, "getAid aid=" + str);
    }
    return str;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null)
    {
      this.jdField_b_of_type_Boolean = true;
      File localFile = new File(ColorRingManager.a(this.jdField_b_of_type_Int, 3));
      if (!localFile.exists()) {
        break label67;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(this, Uri.fromFile(localFile));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
      return;
      label67:
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(this, Uri.parse("android.resource://" + getPackageName() + "/" + 2131165200));
    }
  }
  
  void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject1 = (RelativeLayout)super.findViewById(2131305274);
    int m = ((RelativeLayout)localObject1).getChildCount() - 1;
    while (m >= 0)
    {
      localObject2 = ((RelativeLayout)localObject1).getChildAt(m);
      if ((localObject2 != null) && ((localObject2 instanceof ImageView)) && ("FT".equals(((View)localObject2).getTag()))) {
        ((RelativeLayout)localObject1).removeView((View)localObject2);
      }
      m -= 1;
    }
    Object localObject2 = paramArrayList.iterator();
    m = 0;
    label93:
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label493;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      if (m >= 5) {
        break label493;
      }
      ImageView localImageView = new ImageView(this);
      localImageView.setTag("FT");
      localImageView.setImageBitmap(a((String)localObject3, 1));
      ((RelativeLayout)localObject1).addView(localImageView);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      int n = AIOUtils.a(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = n;
      ((RelativeLayout.LayoutParams)localObject3).width = n;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131305279);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131305279);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(m * 30, getResources());
      m += 1;
    }
    label493:
    for (;;)
    {
      break label93;
      localObject1 = (TextView)super.findViewById(2131305284);
      if (m > 0)
      {
        ((RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin = AIOUtils.a((m - 1) * 30 + 40 + 10, getResources());
        if (5 < paramArrayList.size()) {
          ((TextView)localObject1).setText(String.format("等%s位好友使用", new Object[] { Integer.valueOf(paramArrayList.size()) }));
        }
        for (;;)
        {
          ((TextView)localObject1).setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.g.setVisibility(0);
          this.f.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          if (!paramBoolean) {
            break;
          }
          if ((this.g instanceof Button)) {
            ((Button)this.g).setText("已设置");
          }
          this.g.setEnabled(false);
          return;
          ((TextView)localObject1).setText("正在使用");
        }
        this.g.setEnabled(true);
        if (!(this.g instanceof Button)) {
          break;
        }
        ((Button)this.g).setText("完成");
        return;
      }
      ((TextView)localObject1).setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.g.setVisibility(8);
      this.f.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "温馨提示";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = "设置失败，网速不给力哦，请重试";
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = "取消";
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = "确定";
          }
          for (;;)
          {
            paramString1 = DialogUtil.a(this, 0, paramString1, paramString2, paramString3, paramString4, this, this);
            boolean bool1 = bool2;
            if (paramString1 != null)
            {
              bool1 = bool2;
              if (!super.isFinishing())
              {
                paramString1.show();
                bool1 = true;
              }
            }
            return bool1;
          }
        }
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    Object localObject2 = this.app;
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramIntent != null) {}
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      VasWebviewUtil.reportVASTo00145((AppInterface)localObject2, String.valueOf(paramInt1), "preview", "ClickFriendsEdit", (String)localObject1, new String[0]);
      if (paramIntent == null) {
        break;
      }
      localObject2 = paramIntent.getParcelableArrayListExtra("result_set");
      localObject1 = null;
      paramIntent = (Intent)localObject1;
      if (localObject2 == null) {
        break label151;
      }
      paramIntent = (Intent)localObject1;
      if (((ArrayList)localObject2).size() <= 0) {
        break label151;
      }
      paramIntent = new ArrayList();
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramIntent.add(((ResultRecord)((Iterator)localObject1).next()).jdField_a_of_type_JavaLangString);
      }
    }
    label151:
    a(paramIntent, false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int i1 = 0;
    Object localObject2 = null;
    super.doOnCreate(paramBundle);
    super.setContentView(2130905096);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      if ((paramBundle.hasExtra("callId")) && (paramBundle.hasExtra("key_to_uin")))
      {
        this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("key_to_uin");
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("callId", 0);
      }
      if (paramBundle.hasExtra("ringId")) {
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("ringId", 0);
      }
    }
    for (paramBundle = paramBundle.getBundleExtra("bundle");; paramBundle = null)
    {
      if (this.jdField_a_of_type_Int <= 0)
      {
        QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate funcallid Error.");
        super.finish();
        return true;
      }
      if (paramBundle != null) {
        this.jdField_d_of_type_Int = paramBundle.getInt("feeType");
      }
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = ((VipFullScreenVideoView)super.findViewById(2131303298));
      boolean bool = VipFunCallManager.a(this.app, 0, null).getBoolean("key_fun_call_soundon", true);
      String str;
      Object localObject1;
      int n;
      int m;
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.jdField_e_of_type_Int = VipFunCallManager.a();
        str = VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, null);
        localObject1 = str;
        if (str == null)
        {
          localObject1 = str;
          if (paramBundle != null)
          {
            VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, paramBundle, null, true);
            localObject1 = VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, null);
          }
        }
        if (localObject1 == null)
        {
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
          a(3, this.jdField_a_of_type_Int, null, "预览参数异常，请稍后尝试", null, null, null);
          return true;
        }
        if (this.jdField_e_of_type_Int == 6) {
          if (VipFunCallManager.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, (String)localObject1, this.jdField_e_of_type_Int, null, this.jdField_a_of_type_Int, true))
          {
            n = 0;
            m = n;
            if (bool)
            {
              a();
              m = n;
            }
            label348:
            this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setOnTouchListener(new wgg(this));
          }
        }
      }
      for (;;)
      {
        localObject1 = (RelativeLayout)super.findViewById(2131305274);
        paramBundle = BitmapManager.a(VipFunCallManager.a(this.app, this.jdField_a_of_type_Int, 9, null));
        if (paramBundle != null)
        {
          paramBundle = new BitmapDrawable(paramBundle);
          label404:
          if ((paramBundle != null) && (localObject1 != null))
          {
            ((RelativeLayout)localObject1).setBackgroundDrawable(paramBundle);
            if (m != 0) {
              this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setBackgroundDrawable(paramBundle);
            }
          }
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299478));
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.a(this.app, 3, this.jdField_b_of_type_JavaLangString));
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299479));
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.j(this.app, this.jdField_b_of_type_JavaLangString));
          }
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131305275));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131305276));
          this.jdField_a_of_type_AndroidViewView = super.findViewById(2131298267);
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidViewView = super.findViewById(2131305279);
          this.jdField_c_of_type_AndroidViewView = super.findViewById(2131305285);
          this.jdField_d_of_type_AndroidViewView = super.findViewById(2131305282);
          this.jdField_e_of_type_AndroidViewView = super.findViewById(2131305283);
          this.f = super.findViewById(2131305280);
          this.g = super.findViewById(2131305277);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          if (!bool) {
            onClick(this.jdField_d_of_type_AndroidViewView);
          }
          this.f.setOnClickListener(this);
          this.g.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131305281));
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.app.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver, true);
          if (VipFunCallManager.a(this.app, this.app.getAccount(), 6, true, null) != this.jdField_a_of_type_Int) {
            break label930;
          }
          this.g.setVisibility(0);
          if ((this.g instanceof Button)) {
            ((Button)this.g).setText("已设置");
          }
          this.g.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.f.setVisibility(8);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            break label1174;
          }
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilArrayList.toString();
          return true;
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate VipFunCallManager.play Error.");
          n = 1;
          break;
          if (this.jdField_e_of_type_Int != 7) {
            break label1176;
          }
          paramBundle = BitmapManager.a((String)localObject1);
          if (paramBundle != null)
          {
            paramBundle = new BitmapDrawable(paramBundle);
            label870:
            if (paramBundle == null) {
              break label910;
            }
            this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setBackgroundDrawable(paramBundle);
          }
          for (n = 0;; n = 1)
          {
            m = n;
            if (!bool) {
              break;
            }
            a();
            m = n;
            break;
            paramBundle = null;
            break label870;
            label910:
            QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate BitmapDrawable == null.");
          }
          paramBundle = null;
          break label404;
          label930:
          localObject1 = VipFunCallManager.a(this.app, 1, null);
          if (localObject1 != null)
          {
            Object localObject3 = ((SharedPreferences)localObject1).getString("group", null);
            str = String.valueOf(this.jdField_a_of_type_Int);
            paramBundle = (Bundle)localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              paramBundle = (Bundle)localObject2;
              if (!TextUtils.isEmpty(str))
              {
                localObject3 = ((String)localObject3).split(",");
                m = 0;
              }
            }
            for (;;)
            {
              paramBundle = (Bundle)localObject2;
              if (m < localObject3.length)
              {
                if (str.equals(localObject3[m])) {
                  paramBundle = ((SharedPreferences)localObject1).getString("group_" + str, null);
                }
              }
              else
              {
                if (TextUtils.isEmpty(paramBundle)) {
                  break;
                }
                paramBundle = paramBundle.split(",");
                if ((paramBundle.length < 3) || (paramBundle[2].length() <= 2)) {
                  break;
                }
                paramBundle = paramBundle[2].split("-");
                localObject1 = new ArrayList();
                m = i1;
                while (m < paramBundle.length)
                {
                  if ((paramBundle[m] != null) && (paramBundle[m].length() > 4)) {
                    ((ArrayList)localObject1).add(paramBundle[m]);
                  }
                  m += 1;
                }
              }
              m += 1;
            }
            Collections.sort((List)localObject1);
            this.jdField_d_of_type_JavaLangString = ((ArrayList)localObject1).toString();
            a((ArrayList)localObject1, true);
          }
        }
        label1174:
        break;
        label1176:
        m = 0;
        break label348;
        m = 0;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_e_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.pause();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.jdField_e_of_type_Int == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.resume();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  protected boolean onBackEvent()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
    if ((!this.jdField_a_of_type_JavaUtilArrayList.toString().equals(this.jdField_d_of_type_JavaLangString)) && (a(5, this.jdField_a_of_type_Int, null, "当前设置的来电分组尚未保存，确定要退出吗？", null, null, null))) {
      return true;
    }
    super.onBackEvent();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    int m;
    do
    {
      String str;
      do
      {
        do
        {
          for (;;)
          {
            return;
            m = this.jdField_a_of_type_AndroidOsBundle.getInt("funcType", 4);
            str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
            int n = this.jdField_a_of_type_AndroidOsBundle.getInt("fcID", this.jdField_a_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.d("VipFunCallPreviewActivity", 1, "DialogInterface funcType=" + m + ", url:" + str);
            }
            if ((1 != m) && (2 != m)) {
              break;
            }
            if (paramInt == 1)
            {
              str = "mvip.gxh.android.funcallnew_" + n;
              if (QLog.isColorLevel()) {
                QLog.d("VipOpenVipDialog", 2, "onClick:aid=" + str);
              }
              if (1 == m) {
                VipUtils.a(this, 3, str);
              }
              while (paramDialogInterface != null)
              {
                paramDialogInterface.dismiss();
                return;
                VipUtils.b(this, 3, str);
              }
            }
          }
          if (5 != m) {
            break;
          }
        } while (paramInt != 1);
        super.finish();
        return;
        if ((6 != m) && (4 != m)) {
          break;
        }
      } while ((paramInt != 1) || (TextUtils.isEmpty(str)));
      paramDialogInterface = new Intent(this, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", str);
      paramDialogInterface.putExtra("isShowAd", false);
      super.startActivity(paramDialogInterface);
      return;
    } while (3 != m);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (this.jdField_d_of_type_AndroidWidgetTextView != paramView) {
        break;
      }
    } while (onBackEvent());
    super.finish();
    return;
    if (paramView == this.jdField_d_of_type_AndroidViewView)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
      }
      VipFunCallManager.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", false).commit();
      return;
    }
    if (paramView == this.jdField_e_of_type_AndroidViewView)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_b_of_type_Boolean) {
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
        }
      }
      for (;;)
      {
        VipFunCallManager.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", true).commit();
        return;
        a();
      }
    }
    Object localObject;
    int m;
    if ((paramView == this.jdField_c_of_type_AndroidViewView) || (paramView == this.f)) {
      if (paramView == this.f)
      {
        localObject = VipFunCallManager.a(this.app, 1, null).getString("group", null);
        paramView = String.valueOf(this.jdField_a_of_type_Int);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramView)))
        {
          localObject = ((String)localObject).split(",");
          if (localObject.length >= 5)
          {
            m = 0;
            label281:
            if (m >= localObject.length) {
              break label657;
            }
            if (!paramView.equals(localObject[m])) {}
          }
        }
      }
    }
    for (;;)
    {
      if (m < 0)
      {
        a(6, this.jdField_a_of_type_Int, null, "指定来电群组已达上限（5个）请在“我的来电”里删除其他来电群组后再添加新的分组。", "确定", "我的来电", "http://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123");
        VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "1", new String[0]);
        return;
        m += 1;
        break label281;
      }
      VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.jdField_a_of_type_Int), "preview", "ClickGroupList", "0", new String[0]);
      paramView = new Intent(this, SelectMemberActivity.class);
      paramView.putExtra("param_type", 8998);
      paramView.putExtra("param_entrance", 22);
      paramView.putExtra("param_only_friends", true);
      paramView.putExtra("param_donot_need_contacts", true);
      paramView.putExtra("param_uins_selected_friends", this.jdField_a_of_type_JavaUtilArrayList);
      super.startActivityForResult(paramView, 201605);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        paramView = (VipSetFunCallHandler)this.app.a(46);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("callId", this.jdField_a_of_type_Int);
        ((Bundle)localObject).putInt("ringId", this.jdField_b_of_type_Int);
        ((Bundle)localObject).putInt("from", 1);
        a(true, 2131368382);
        paramView.a(3, localObject);
        return;
      }
      if (paramView != this.g) {
        break;
      }
      paramView = new VipFunCallAndRing.TSsoCmd0x4Req();
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      paramView.rpt_uins.set((List)localObject);
      paramView.i32_funcall_id.set(this.jdField_a_of_type_Int);
      paramView.i32_ring_id.set(this.jdField_b_of_type_Int);
      a(true, 2131368382);
      ((VipSetFunCallHandler)this.app.a(46)).a(4, paramView);
      return;
      label657:
      m = -1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      Object localObject = new Rect();
      super.getWindow().findViewById(16908290).getDrawingRect((Rect)localObject);
      ((Rect)localObject).width();
      ((Rect)localObject).height();
      ProfileCardUtil.c(this, 102);
      int m = ProfileCardUtil.a(getResources());
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((FrameLayout.LayoutParams)localObject).topMargin = m;
        }
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = (m + ProfileCardUtil.c(this, 25) + (int)getResources().getDimension(2131492908));
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 25);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 10);
        this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 30);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vipav\VipFunCallPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */