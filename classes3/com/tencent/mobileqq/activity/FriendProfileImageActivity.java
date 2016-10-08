package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import lmm;
import lmn;
import lmo;
import lmp;
import lmq;
import lmr;
import lms;
import lmu;
import lmv;
import lmw;
import lmx;
import lmz;
import lna;
import lnb;
import lnc;
import mqq.os.MqqHandler;

public class FriendProfileImageActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, FriendProfileImageModel.InfoUpdateListener, Runnable
{
  public static final String a = "curType";
  private static final long jdField_b_of_type_Long = 300L;
  public static final String b = "url";
  public static final String c = "_id";
  static final int d = 0;
  public static final String d = "friendUin";
  static final int jdField_e_of_type_Int = 1;
  public static final String e = "requestTypeKey";
  public static final String f = "faceid";
  public static final String g = "index";
  public static final String h = "KEY_THUMBNAL_BOUND";
  public static final String i = "extra_pendant_id";
  public static final String j = "extra_action_source";
  public static final String k = "is_from_face2face_add_friend";
  public static final String l = "is_hide_actionsheet";
  public static final String m = "is_hide_footbar";
  public int a;
  long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public AsyncTask a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  public TextView a;
  public FriendProfileImageModel a;
  public FriendProfileImageAdapter a;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public Gallery a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  public AlphaAnimation b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  public boolean c;
  public boolean d;
  boolean jdField_e_of_type_Boolean;
  private int f;
  public boolean f;
  private boolean g;
  private boolean h;
  
  public FriendProfileImageActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("profile_image", "com.tencent.mobileqq:web");
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_JavaLangRunnable = new lmo(this);
    this.jdField_c_of_type_Long = 350L;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new lms(this);
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      int n = paramString1.lastIndexOf("/");
      str1 = str2;
      if (n >= 0)
      {
        str1 = str2;
        if (n < paramString1.length() - 1) {
          str1 = AppConstants.bo + paramString2 + paramString1.substring(n + 1);
        }
      }
    }
    return str1;
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    this.jdField_f_of_type_Boolean = true;
    View localView = getActivity().findViewById(16908290);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    int i6;
    int i7;
    int i4;
    int i2;
    int i3;
    int n;
    int i1;
    float f1;
    float f2;
    if ((paramRect2 != null) && (paramRect1 != null))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
      i6 = paramRect1.width();
      i7 = paramRect1.height();
      i4 = paramRect2.width();
      int i5 = paramRect2.height();
      i2 = localView.getWidth();
      i3 = localView.getHeight();
      if (i4 <= i2)
      {
        n = i5;
        i1 = i4;
        if (i5 <= i3) {}
      }
      else
      {
        f1 = i2 / i4;
        f2 = i3 / i5;
        if (f1 >= f2) {
          break label469;
        }
        n = Math.round(i5 * f1);
        i1 = i2;
      }
      f2 = AnimationUtils.a(i1, n, i2, i3);
      i2 = i1;
      if (i1 == 0) {
        i2 = 1;
      }
      if (n != 0) {
        break label490;
      }
      n = 1;
    }
    label469:
    label487:
    label490:
    for (;;)
    {
      if ((i2 != i6) || (i7 != n))
      {
        f1 = i6 / i2 / f2;
        f2 = i7 / n / f2;
        if (f1 <= f2) {
          break label487;
        }
        f1 = f2;
      }
      for (;;)
      {
        paramRect1 = new ScaleAnimation(f1, 1.0F, f1, 1.0F, 1, 0.5F, 1, 0.5F);
        paramRect1.setDuration(this.jdField_c_of_type_Long);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(paramRect1);
        paramRect1 = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
        AnimationUtils.a(localView, paramRect1);
        n = paramRect1.centerX();
        i1 = paramRect1.centerY();
        i2 = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
        i3 = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
        paramRect1 = new TranslateAnimation(-(n - i2), 0.0F, -(i1 - i3), 0.0F);
        paramRect1.setDuration(this.jdField_c_of_type_Long);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        paramRect1.setAnimationListener(new lmp(this));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramRect1);
        if (!this.e) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new lmq(this), this.jdField_c_of_type_Long);
        }
        paramRect1 = new AlphaAnimation(0.0F, 1.0F);
        paramRect1.setInterpolator(new DecelerateInterpolator());
        paramRect1.setDuration(350L);
        paramRect1.setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.startAnimation(paramRect1);
        return;
        i1 = Math.round(i4 * f2);
        n = i3;
        break;
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new lnc(this, paramTextView));
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new lmn(this, paramTextView));
  }
  
  private void h()
  {
    if (isFinishing()) {}
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo;
    do
    {
      return;
      localProfileImageInfo = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
    } while ((localProfileImageInfo == null) || (localProfileImageInfo.h != 6));
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131370093, 1);
    localActionSheet.a(2131370099, 1);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      localActionSheet.a(2131370107, 3);
    }
    localActionSheet.d(2131367262);
    localActionSheet.a(new lmz(this, localProfileImageInfo, localActionSheet));
    localActionSheet.show();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int += 1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    e(paramProfileImageInfo);
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      if (paramAdapterView.d_() <= 1) {
        break label159;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "/" + paramAdapterView.d_());
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 4) {
        break label124;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      if (this.g)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
        this.g = false;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label124:
    this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    return;
    label159:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void a(String paramString1, String paramString2)
  {
    new File(AppConstants.bo).mkdirs();
    paramString2 = a(paramString1, paramString2);
    if (!new File(paramString2).exists()) {
      b(paramString1, paramString2);
    }
    for (;;)
    {
      sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + paramString2)));
      return;
      DialogUtil.a(this, 230).setTitle(getString(2131368781)).setMessage(getString(2131368783)).setPositiveButton(getString(2131368782), new lnb(this, paramString1, paramString2)).setNegativeButton(getString(2131367259), new lna(this)).show();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "onDeleteSuccess()");
    }
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.notifyDataSetChanged();
      return;
    }
    finish();
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    e(paramProfileImageInfo);
    a(2131370111, 1);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (FileUtils.d(paramString1, paramString2))
    {
      QQToast.a(this, getString(2131368777) + " " + AppConstants.bo, 0).a();
      return;
    }
    QQToast.a(this, getString(2131368778), 0).a();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "onDeleteFailed()");
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(1, 50L);
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (paramProfileImageInfo != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putString("forward_filepath", paramProfileImageInfo.d);
      localBundle.putString("forward_thumb", paramProfileImageInfo.c);
      paramProfileImageInfo = new Intent();
      paramProfileImageInfo.putExtras(localBundle);
      ForwardBaseOption.a(this, paramProfileImageInfo, 21);
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368307);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void d(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131368787), 0).a();
    }
    Card localCard;
    do
    {
      return;
      localCard = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b);
    } while (localCard == null);
    ((CardHandler)this.app.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b, localCard.uFaceTimeStamp, HexUtil.a(paramProfileImageInfo.jdField_a_of_type_JavaLangString));
    d();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    f();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427379);
    super.setContentView(2130903378);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(getMainLooper(), this);
    paramBundle = getIntent().getExtras();
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_from_face2face_add_friend", false);
    this.d = paramBundle.getBoolean("is_hide_actionsheet", false);
    this.e = paramBundle.getBoolean("is_hide_footbar", false);
    this.jdField_f_of_type_Int = paramBundle.getInt("curType", 0);
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131298351));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296792));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296895));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296820);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298350));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298359));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298360));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131296815));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298353));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298363));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new lmm(this));
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter = new FriendProfileImageAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = new FriendProfileImageAvatar(this.app);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_f_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b = paramBundle.getString("friendUin");
    this.jdField_a_of_type_Long = paramBundle.getLong("extra_pendant_id", 0L);
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371062);
      this.jdField_a_of_type_Long = 5L;
    }
    this.jdField_c_of_type_Int = paramBundle.getInt("extra_action_source", 0);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b != null)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(2131493192);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298361));
      ThreadManager.b().post(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298362));
      if (((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b) != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 1, PendantInfo.j);
      }
    }
    if (this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("index", -1);
      localObject = new FriendProfileImageModel.ProfileImageInfo();
      ((FriendProfileImageModel.ProfileImageInfo)localObject).e = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b;
      ((FriendProfileImageModel.ProfileImageInfo)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("filekey");
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this, (FriendProfileImageModel.ProfileImageInfo)localObject);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131492970));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new lmu(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new lmv(this));
      a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new lmw(this));
      this.jdField_a_of_type_AndroidOsAsyncTask = new lmx(this, (FriendProfileImageModel.ProfileImageInfo)localObject);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    ThreadManager.b().removeCallbacks(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsAsyncTask.cancel(true);
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {}
    for (;;)
    {
      int n;
      try
      {
        int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        n = 0;
        if (n < i1)
        {
          View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(n);
          if (localView == null) {
            break label164;
          }
          localView = localView.findViewById(2131296303);
          if (!(localView instanceof URLImageView)) {
            break label164;
          }
          ((URLImageView)localView).setImageDrawable(null);
          ((URLImageView)localView).setBackgroundDrawable(null);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label164:
      n += 1;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      h();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AvatarPendantUtil.a(this.app, this, "sp_key_entrance_card_face_preview", this.app.a(), this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    float f1;
    int n;
    Object localObject;
    Rect localRect3;
    int i1;
    if ((paramBoolean) && (!this.h))
    {
      f1 = getResources().getDisplayMetrics().density;
      n = getResources().getDisplayMetrics().densityDpi;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      this.h = true;
      localRect3 = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      if (localObject == null) {
        break label171;
      }
      if (((FriendProfileImageModel.ProfileImageInfo)localObject).h != 6) {
        break label152;
      }
      n = ImageUtil.a(640, 160, n);
      i1 = n;
    }
    for (;;)
    {
      Rect localRect1 = new Rect(0, 0, i1, n);
      Rect localRect2 = ImageUtil.a(localRect1, (int)getResources().getDimension(2131492943), f1);
      localObject = localRect2;
      if (localRect2 == null) {
        localObject = localRect1;
      }
      a(localRect3, (Rect)localObject);
      return;
      label152:
      n = ImageUtil.a(100, 160, n);
      i1 = n;
      continue;
      label171:
      n = 0;
      i1 = 0;
    }
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((this.jdField_f_of_type_Int == 1) || (this.jdField_a_of_type_AndroidViewView == null) || (paramProfileImageInfo == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + paramProfileImageInfo.e + ", state=" + paramProfileImageInfo.h);
            }
            localObject = (String)this.jdField_a_of_type_AndroidViewView.getTag();
            if (paramProfileImageInfo.h != 6) {
              break;
            }
          } while ((localObject != null) && (((String)localObject).equals(paramProfileImageInfo.d)));
          this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.c(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
          return;
          if ((paramProfileImageInfo.h != 3) && (paramProfileImageInfo.h != 4)) {
            break;
          }
          if ((localObject == null) || (!((String)localObject).equals(paramProfileImageInfo.c))) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.b(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
          }
        } while ((!paramProfileImageInfo.jdField_a_of_type_Boolean) || (paramProfileImageInfo.h != 4));
        Object localObject = (ImageProgressCircle)this.jdField_a_of_type_AndroidViewView.findViewById(2131296302);
        if (localObject != null)
        {
          ((ImageProgressCircle)localObject).setProgress(paramProfileImageInfo.i);
          if (((ImageProgressCircle)localObject).getVisibility() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a((ImageProgressCircle)localObject);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + paramProfileImageInfo.i);
      return;
    } while ((paramProfileImageInfo.h != 5) && (paramProfileImageInfo.h != 2));
    this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(paramProfileImageInfo, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void f()
  {
    if ((!this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      g();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(350L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new lmr(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
      return true;
    } while ((this == null) || (isFinishing()));
    a(2131368787, 1);
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel == null);
    if (!Utils.b())
    {
      Toast.makeText(super.getApplicationContext(), getString(2131368967), 0).show();
      return;
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b != null)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b.equals(this.app.a())) {
        bool1 = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    AvatarPendantUtil.a(this.app, this, bool1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b.equals(this.app.a())) {
        break label193;
      }
      ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      AvatarPendantUtil.a(this, "sp_key_entrance_card_face_preview", this.app.a(), System.currentTimeMillis());
      finish();
      return;
      label193:
      ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b == null)) {
      return;
    }
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b);
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = localFaceDrawable;
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\FriendProfileImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */