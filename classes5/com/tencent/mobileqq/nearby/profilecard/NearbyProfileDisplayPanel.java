package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.MyFreshNewsActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.SpecialNearbyListActivity;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.BorderTextView;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import tmk;
import tml;
import tmm;
import tmn;
import tmo;
import tmp;
import tmq;
import tmr;
import tms;
import tmt;
import tmu;
import tmv;
import tmw;
import tmx;
import tmy;
import tmz;
import tna;
import tnb;
import tnd;

public class NearbyProfileDisplayPanel
  implements View.OnClickListener, OnTagClickListener, BounceScrollView.OnScrollChangedListener
{
  private static final float jdField_a_of_type_Float = 15.0F;
  public static final int a = 1500;
  static long jdField_a_of_type_Long = 0L;
  public static final String a = "NearbyProfileDisplayPanel";
  public static final int b = 1000;
  public static final String b = "is_show_edit_profile_guide";
  public static String[] b;
  public static String[] c;
  private static final int jdField_f_of_type_Int = 1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new tmt(this);
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new tmk(this);
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new tmq(this);
  View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new tmw(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  public NearbyPeopleProfileActivity a;
  private NearbyProfileDisplayPanel.PicGallaryAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$PicGallaryAdapter;
  public ProfileQiqiLiveController a;
  protected ProfileBusiEntry a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private HorizontalScrollLayout jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout;
  public ProgressButton a;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new tmu(this);
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private BorderTextView jdField_a_of_type_ComTencentWidgetBorderTextView;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  InterestTag[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
  SavorTagIcon[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon;
  SavorTagImg[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  public boolean c;
  public int d;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  public boolean f;
  private View jdField_g_of_type_AndroidViewView;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private View jdField_h_of_type_AndroidViewView;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  private View jdField_i_of_type_AndroidViewView;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private View jdField_j_of_type_AndroidViewView;
  private LinearLayout jdField_j_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  public boolean j;
  private LinearLayout jdField_k_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  public boolean k;
  private LinearLayout jdField_l_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  boolean jdField_l_of_type_Boolean = true;
  private LinearLayout jdField_m_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  public boolean m;
  private LinearLayout jdField_n_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  private boolean jdField_n_of_type_Boolean;
  private LinearLayout jdField_o_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  private boolean jdField_o_of_type_Boolean;
  private TextView jdField_p_of_type_AndroidWidgetTextView;
  private boolean jdField_p_of_type_Boolean;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  private boolean jdField_q_of_type_Boolean;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  }
  
  public NearbyProfileDisplayPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new tms(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.b(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    n();
    InterestGuide.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getCurrentAccountUin(), paramView, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D);
  }
  
  private PicInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)) {
      return (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt + 1);
    }
    return (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  private void a(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    int i1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount() - 1;
    int i2;
    while (i1 > 0)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(i1);
      i2 = ((View)localObject).getId();
      if (((localObject instanceof ImageView)) && (i2 != 2131301993) && (i2 != 2131301991)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeViewAt(i1);
      }
      i1 -= 1;
    }
    Object localObject = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301993);
    label113:
    label123:
    label135:
    ImageView[] arrayOfImageView;
    int i3;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
    {
      i1 = 1;
      if (i1 == 0) {
        break label342;
      }
      i1 = paramInt + 1;
      i2 = ((ImageView)localObject).getWidth();
      if (i2 <= 0) {
        break label352;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Charm", 2, "setCharm() uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + " heart=" + i1 + " charm=" + paramLong1 + " level=" + paramInt + " cur=" + paramLong2 + " next=" + paramLong3);
      }
      if ((AppSetting.jdField_j_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131372132) + i1 + "心 双击查看魅力值攻略");
      }
      arrayOfImageView = new ImageView[i1];
      arrayOfImageView[0] = localObject;
      i3 = 0;
      label297:
      if (i3 < i1)
      {
        if (i3 != 0) {
          break label409;
        }
        if (paramInt <= 0) {
          break label367;
        }
        ((ImageView)localObject).setImageResource(2130840892);
        ((ImageView)localObject).setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      i3 += 1;
      break label297;
      break;
      i1 = 0;
      break label113;
      label342:
      i1 = Math.max(1, paramInt);
      break label123;
      label352:
      i2 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 21.0F);
      break label135;
      label367:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
      {
        a((ImageView)localObject, paramLong1, paramLong2, paramLong3);
      }
      else
      {
        ((ImageView)localObject).setImageResource(2130840877);
        ((ImageView)localObject).setBackgroundDrawable(null);
        continue;
        label409:
        ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        arrayOfImageView[i3] = localImageView;
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(15);
        localLayoutParams.setMargins(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F) * i3 + (i3 - 1) * i2, 0, 0, 0);
        localLayoutParams.addRule(1, ((ImageView)localObject).getId());
        localImageView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localImageView);
        if (i3 < paramInt)
        {
          localImageView.setImageResource(2130840892);
          ((ImageView)localObject).setBackgroundDrawable(null);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
        {
          a(localImageView, paramLong1, paramLong2, paramLong3);
        }
      }
    }
  }
  
  private void a(ImageView paramImageView, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramImageView == null) {}
    do
    {
      do
      {
        return;
        if ((paramLong3 > paramLong2) && (paramLong3 != 0L)) {
          break;
        }
        if (paramImageView.getId() == 2131301993)
        {
          paramImageView.setImageResource(2130840877);
          paramImageView.setBackgroundDrawable(null);
          return;
        }
      } while (paramImageView.getVisibility() == 4);
      paramImageView.setVisibility(4);
    } while (!QLog.isColorLevel());
    QLog.d("Charm", 2, "uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + " next=" + paramLong3 + " <= " + "cur=" + paramLong2 + " set invisiable");
    return;
    int i1 = (int)((paramLong1 - paramLong2) * 100.0D / (paramLong3 - paramLong2));
    if (i1 >= 100)
    {
      paramImageView.setImageResource(2130840892);
      return;
    }
    if (i1 >= 80)
    {
      paramImageView.setImageResource(2130840881);
      return;
    }
    if (i1 >= 60)
    {
      paramImageView.setImageResource(2130840880);
      return;
    }
    if (i1 >= 40)
    {
      paramImageView.setImageResource(2130840879);
      return;
    }
    if (i1 >= 20)
    {
      paramImageView.setImageResource(2130840878);
      return;
    }
    paramImageView.setImageResource(2130840877);
  }
  
  private void a(TextView paramTextView)
  {
    int i1 = paramTextView.getWidth();
    int i2 = paramTextView.getHeight();
    Object localObject2 = new StringBuilder();
    if (this.jdField_e_of_type_Int > 0) {}
    for (Object localObject1 = "+ ";; localObject1 = "- ")
    {
      paramTextView.setText((String)localObject1 + String.valueOf(Math.abs(this.jdField_e_of_type_Int)));
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
      localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, i1 / 2, i2 / 2);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation((Animation)localObject1);
      localAnimationSet.addAnimation((Animation)localObject2);
      localAnimationSet.setDuration(1500L);
      paramTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      this.jdField_e_of_type_Int = 0;
      return;
    }
  }
  
  private void a(FreshNewsInfo paramFreshNewsInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setFreshNewsInfo, freshNewsInfo=");
      if (paramFreshNewsInfo != null) {
        break label87;
      }
    }
    label87:
    for (String str = "null";; str = paramFreshNewsInfo.toString())
    {
      QLog.d("NearbyProfileDisplayPanel", 2, str);
      if ((paramFreshNewsInfo != null) && (paramFreshNewsInfo.photoUrls != null) && (!paramFreshNewsInfo.photoUrls.isEmpty())) {
        break;
      }
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      return;
    }
    if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (this.jdField_o_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
      this.jdField_o_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_o_of_type_AndroidWidgetLinearLayout.post(new tna(this, paramFreshNewsInfo));
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.G == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.y)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a();
      localObject = str;
      if (str == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131371855);
      }
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString, (String)localObject, 1010);
    }
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
    ((Intent)localObject).putExtra("PREVIOUS_WINDOW", NearbyPeopleProfileActivity.class.getName());
    ((Intent)localObject).putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    ((Intent)localObject).putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("cSpecialFlag"));
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i != 0) {
      ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i);
    }
    if (paramInt == 1001)
    {
      ((Intent)localObject).putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
      ((Intent)localObject).addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      return;
      if (paramInt == 1010)
      {
        ((Intent)localObject).putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      }
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i1 = 1;
    switch (paramArrayList.size())
    {
    }
    for (;;)
    {
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130838349);
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130838357);
      ((View)paramArrayList.get(1)).setBackgroundResource(2130838352);
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130838357);
      ((View)paramArrayList.get(paramArrayList.size() - 1)).setBackgroundResource(2130838352);
      while (i1 < paramArrayList.size() - 1)
      {
        ((View)paramArrayList.get(i1)).setBackgroundResource(2130838355);
        i1 += 1;
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    RichStatus localRichStatus;
    if (paramArrayOfByte != null)
    {
      localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      if (localRichStatus == null) {
        break label424;
      }
    }
    label424:
    for (paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131427409));; paramArrayOfByte = null)
    {
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {}
        for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.actionId, 200);; paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130842868))
        {
          paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
          int i1 = (int)(this.jdField_c_of_type_AndroidWidgetTextView.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, i1, i1);
          paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
          paramArrayOfByte.a(-0.1F);
          ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428262));
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
      }
      paramArrayOfByte = StringUtil.e(((SpannableString)localObject).toString());
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText("未填写");
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428306));
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramArrayOfByte);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428262));
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("未填写");
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428306));
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
  }
  
  private byte[] a()
  {
    byte[] arrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length != 0) {}
    }
    else
    {
      arrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().k(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    if ((arrayOfByte1 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return arrayOfByte1;
  }
  
  private int b()
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 6);
    int i1;
    if (i2 > 0)
    {
      i1 = i2;
      if (i2 < 6) {}
    }
    else
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g;
      if (i1 != 5) {
        break label48;
      }
      i1 = 1;
    }
    return i1;
    label48:
    if (ProfileActivity.b(i1)) {
      return 3;
    }
    if (((i1 >= 10) && (i1 <= 19)) || (i1 == 30)) {
      return 2;
    }
    return 6;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1;
    switch (paramInt2)
    {
    default: 
      i1 = 0;
    }
    while (i1 == 0)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      i1 = 2131372110;
      continue;
      i1 = 2131371861;
      continue;
      i1 = 2131369990;
      continue;
      i1 = 2131367902;
      continue;
      i1 = 2131370025;
      continue;
      i1 = 2131371592;
      continue;
      i1 = 2131372231;
    }
    View localView = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
    localView.setVisibility(0);
    if (paramInt2 != 40)
    {
      localObject = (Button)localView.findViewById(2131301921);
      ((Button)localObject).setText(i1);
      if (paramInt2 == 38)
      {
        ((Button)localObject).setBackgroundResource(2130843110);
        ((Button)localObject).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131427606));
      }
      ((Button)localObject).setOnClickListener(this);
      localDataTag = new DataTag(paramInt2, null);
      ((Button)localObject).setTag(localDataTag);
      localView.setTag(localDataTag);
      return;
    }
    ((Button)localView.findViewById(2131301921)).setVisibility(8);
    Object localObject = (ProgressButton)localView.findViewById(2131302178);
    ((ProgressButton)localObject).setVisibility(0);
    ((ProgressButton)localObject).setText(i1);
    if (paramInt2 == 38)
    {
      ((ProgressButton)localObject).setBackgroundResource(2130843110);
      ((ProgressButton)localObject).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131427606));
    }
    ((ProgressButton)localObject).setOnClickListener(this);
    DataTag localDataTag = new DataTag(paramInt2, null);
    ((ProgressButton)localObject).setTag(localDataTag);
    localView.setTag(localDataTag);
  }
  
  private void b(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
    }
    paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a());
    paramString.putExtra("url", (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  private int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == 1) {
        return 0;
      }
      return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  private void n()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301983));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301982));
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301942));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301977));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301976));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301967));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301979));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301985));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301986));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301989));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301987));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301988));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302007));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302008));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302009));
    this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302010));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302011));
    this.jdField_h_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302012));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302013));
    this.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302014));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302015));
    this.jdField_j_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302023));
    this.jdField_k_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301994));
    this.jdField_l_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_k_of_type_AndroidWidgetLinearLayout.findViewById(2131301995));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302024));
    this.jdField_c_of_type_AndroidViewView = this.jdField_k_of_type_AndroidWidgetLinearLayout.findViewById(2131301996);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302025));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302026));
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout = ((HorizontalScrollLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302241));
    this.jdField_i_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131302029);
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297139));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297083));
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297183));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301969));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301970));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301971));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301972));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301973));
    this.jdField_j_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131302028);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_b_of_type_AndroidViewView.findViewById(2131297137));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131297016));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302040));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302041));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131302042));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301984));
    this.jdField_m_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301892));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302031));
    this.jdField_n_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302032));
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302033));
    this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302035));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302034));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301981));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301978));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302002));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302005));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302006));
    Object localObject = (RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301968);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301998));
    this.jdField_o_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131302001));
    localObject = (LinearLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    if (localObject != null) {
      ((LinearLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (localObject != null) {
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840650));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301997);
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301944);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301956);
    this.jdField_g_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301958);
    this.jdField_h_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131302027);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.h = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getStringArray(2131230782);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon = new SavorTagIcon[4];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg = new SavorTagImg[3];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag = new InterestTag[7];
    int i1 = 0;
    while (i1 < 7)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1] = new InterestTag(i1 + 1);
      i1 += 1;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428302);
    i1 = 0;
    while (i1 < 4)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1] = ((SavorTagIcon)this.jdField_b_of_type_AndroidViewView.findViewById(NearbyProfileEditPanel.a[i1]));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i1], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList, this);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setRightArrowVisible(false);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setTitleTextColor(i2);
      if (AppSetting.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setClickable(true);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < 3)
    {
      int i3 = i1 + 4;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1] = ((SavorTagImg)this.jdField_b_of_type_AndroidViewView.findViewById(NearbyProfileEditPanel.a[i3]));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i3], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i3].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i3].jdField_a_of_type_JavaUtilArrayList, this);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setRightArrowVisible(false);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setTitleTextColor(i2);
      if (AppSetting.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setClickable(true);
      }
      i1 += 1;
    }
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_l_of_type_AndroidWidgetTextView.setText(2131366637);
    this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(new tmv(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
  }
  
  private void o()
  {
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(3);
    int i1 = 0;
    if (i1 < 4)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localArrayList1.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setVisibility(0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setVisibility(8);
      }
    }
    i1 = 0;
    if (i1 < 3)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[(i1 + 4)].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localArrayList2.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setVisibility(0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setVisibility(8);
      }
    }
    int i2 = localArrayList1.size();
    i1 = 0;
    if (i1 < i2)
    {
      if ((i1 == 0) && (i2 > 1)) {
        ((View)localArrayList1.get(i1)).setBackgroundResource(2130843292);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (i1 == i2 - 1) {
          ((View)localArrayList1.get(i1)).setBackgroundResource(2130843277);
        } else {
          ((View)localArrayList1.get(i1)).setBackgroundResource(2130843286);
        }
      }
    }
    int i3 = localArrayList2.size();
    i1 = 0;
    if (i1 < i3)
    {
      if ((i1 == 0) && (i3 > 1)) {
        ((View)localArrayList2.get(i1)).setBackgroundResource(2130843292);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (i1 == i3 - 1) {
          ((View)localArrayList2.get(i1)).setBackgroundResource(2130843277);
        } else {
          ((View)localArrayList2.get(i1)).setBackgroundResource(2130843286);
        }
      }
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131297537);
    }
    if (this.jdField_g_of_type_AndroidViewView == null) {
      this.jdField_g_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301958);
    }
    if ((i2 == 0) && (i3 == 0)) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    while ((i2 > 0) && (i3 > 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void p()
  {
    int i1 = 0;
    int i3 = NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo);
    boolean bool;
    int i2;
    Object localObject1;
    int i4;
    int i5;
    int i6;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible == 0L)
    {
      bool = true;
      i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "mode=" + i2 + ", numFlowers=" + i3 + ", isGiftVisible=" + bool);
      }
      if (i3 <= 0) {
        break label423;
      }
      this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localObject1 = NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo);
      i4 = AIOUtils.a(23.5F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      i5 = AIOUtils.a(30.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      i6 = AIOUtils.a(2.5F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break label254;
      }
      this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProfileDisplayPanel", 2, "bindData, Flower num > 0 but url and tips is null");
      }
      label204:
      if (i2 != 2) {
        break label400;
      }
      localObject1 = this.jdField_c_of_type_AndroidViewView;
      if (bool) {
        i1 = 8;
      }
      ((View)localObject1).setVisibility(i1);
    }
    for (;;)
    {
      this.jdField_l_of_type_AndroidWidgetLinearLayout.setOnClickListener(new tmz(this, i2));
      return;
      bool = false;
      break;
      label254:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841004);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i4;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i5;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131371863, new Object[] { Integer.valueOf(i3) });
      localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(1, 16.0F);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = i6;
      this.jdField_l_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      break label204;
      label400:
      if ((i2 == 3) && (!bool))
      {
        this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        continue;
        label423:
        if (i2 == 3)
        {
          this.jdField_l_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          localObject2 = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          ((TextView)localObject2).setTextColor(-16777216);
          ((TextView)localObject2).setTextSize(1, 16.0F);
          ((TextView)localObject2).setGravity(16);
          ((TextView)localObject2).setSingleLine(true);
          ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
          Resources localResources = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {}
          for (localObject1 = "他";; localObject1 = "她")
          {
            ((TextView)localObject2).setText(localResources.getString(2131371862, new Object[] { localObject1 }));
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            this.jdField_l_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
            break;
          }
        }
        this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  private void q()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localObject != null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_n_of_type_Boolean) {
            break label302;
          }
          if (TextUtils.isEmpty(((PicInfo)localObject).d)) {
            break label282;
          }
          this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
          if (!DynamicAvatarDownloadManager.b(((PicInfo)localObject).d)) {
            break label131;
          }
          a(((PicInfo)localObject).d);
        }
      }
    }
    for (;;)
    {
      return;
      localObject = null;
      break;
      label131:
      Drawable localDrawable;
      if (NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(((PicInfo)localObject).d);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130843567);
      }
      for (;;)
      {
        try
        {
          if ((((PicInfo)localObject).jdField_c_of_type_JavaLangString == null) || (((PicInfo)localObject).jdField_c_of_type_JavaLangString.length() <= 0)) {
            continue;
          }
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localObject = URLDrawable.getDrawable(new File(((PicInfo)localObject).jdField_c_of_type_JavaLangString).toURL(), localURLDrawableOptions);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          label282:
          label302:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + localMalformedURLException.getMessage(), localMalformedURLException);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
        return;
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (!StringUtil.b(((PicInfo)localObject).jdField_a_of_type_JavaLangString))
        {
          localObject = NearbyImgDownloader.a(((PicInfo)localObject).jdField_a_of_type_JavaLangString);
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
          ((URLDrawable)localObject).setDownloadListener(new ImgDownloadListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "actNearbyPeoplePicDownload"));
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl))
      {
        if (DynamicAvatarDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
        if (NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) && (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.S != 640) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.S != 0)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.C))))
      {
        w();
        return;
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        continue;
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void r()
  {
    this.jdField_i_of_type_AndroidViewView.setBackgroundResource(2130840953);
    this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
    {
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_m_of_type_AndroidWidgetTextView.setText(2131370906);
    this.jdField_m_of_type_AndroidWidgetTextView.setOnClickListener(new tnb(this));
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      d();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, 1);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "NumberFormatException");
  }
  
  private void t()
  {
    if ((this.jdField_d_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) && (this.jdField_e_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) && (this.jdField_k_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) || (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8)) {
        break label575;
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      label90:
      if ((this.jdField_f_of_type_AndroidWidgetLinearLayout.getVisibility() != 8) || (this.jdField_g_of_type_AndroidWidgetLinearLayout.getVisibility() != 8) || (this.jdField_h_of_type_AndroidWidgetLinearLayout.getVisibility() != 8) || (this.jdField_i_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
        break label586;
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      label147:
      if ((this.jdField_j_of_type_AndroidWidgetLinearLayout.getVisibility() != 8) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
        break label597;
      }
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_d_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_d_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_e_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_e_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      if (this.jdField_k_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_k_of_type_AndroidWidgetLinearLayout);
      }
      a(localArrayList);
      localArrayList.clear();
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_e_of_type_AndroidWidgetRelativeLayout);
      }
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_d_of_type_AndroidWidgetRelativeLayout);
      }
      a(localArrayList);
      localArrayList.clear();
      if (this.jdField_f_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_f_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_g_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_g_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_h_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_h_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_i_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_i_of_type_AndroidWidgetLinearLayout);
      }
      a(localArrayList);
      localArrayList.clear();
      if (this.jdField_j_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_j_of_type_AndroidWidgetLinearLayout);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        localArrayList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      a(localArrayList);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 15.0F), 0);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 15.0F), 0);
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 15.0F), 0);
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 15.0F), 0);
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      break;
      label575:
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      break label90;
      label586:
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      break label147;
      label597:
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371566), new tmo(this), new tmp(this));
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 76)) {}
    for (int i1 = 3019;; i1 = 3007)
    {
      int i2 = 0;
      if ((i1 == 3007) && (!LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
      {
        u();
        return;
      }
      if ((i1 == 3019) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
      {
        u();
        return;
      }
      if (i1 == 3007) {
        i2 = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_return_addr") != null)
      {
        localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, null, i1, i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, null, AddContactsActivity.class.getName(), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131367975), null);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
        return;
      }
      Intent localIntent = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, null, i1, i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, null, NearbyPeopleProfileActivity.class.getName(), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131367975), null);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1000);
      return;
    }
  }
  
  private void w()
  {
    bool = true;
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428332));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840949));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(null);
    Object localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 200, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 3);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
    int i1 = (int)(70.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
    int i2 = (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
    localObject = new Paint();
    ((Paint)localObject).setColor(-1);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setStrokeWidth(i2);
    ((Paint)localObject).setAntiAlias(true);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i2 * 2 + i1, i2 * 2 + i1, Bitmap.Config.ARGB_8888);
      if (localBitmap != null)
      {
        new Canvas(localBitmap).drawCircle(i1 / 2 + i2, i2 + i1 / 2, i1 / 2, (Paint)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall create bitmap oom.");
          continue;
          this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840951);
          bool = false;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 3)
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
          }
        }
      }
    }
    this.jdField_i_of_type_AndroidViewView.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131301974).setBackgroundDrawable(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840952);
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
        return;
      }
    }
  }
  
  private void x()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)), "", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
  
  int a()
  {
    int i11 = 1;
    int i1;
    int i2;
    label21:
    int i3;
    label30:
    int i4;
    label40:
    int i5;
    label50:
    int i6;
    label60:
    int i7;
    label70:
    int i8;
    label80:
    int i9;
    label90:
    int i10;
    if (this.jdField_k_of_type_Boolean)
    {
      i1 = 1;
      if (!this.jdField_j_of_type_Boolean) {
        break label169;
      }
      i2 = 1;
      if (!this.jdField_i_of_type_Boolean) {
        break label174;
      }
      i3 = 1;
      if (!this.jdField_h_of_type_Boolean) {
        break label179;
      }
      i4 = 1;
      if (!this.jdField_g_of_type_Boolean) {
        break label185;
      }
      i5 = 1;
      if (!this.jdField_f_of_type_Boolean) {
        break label191;
      }
      i6 = 1;
      if (!this.jdField_e_of_type_Boolean) {
        break label197;
      }
      i7 = 1;
      if (!this.jdField_d_of_type_Boolean) {
        break label203;
      }
      i8 = 1;
      if (!this.jdField_c_of_type_Boolean) {
        break label209;
      }
      i9 = 1;
      if (!this.jdField_b_of_type_Boolean) {
        break label215;
      }
      i10 = 1;
      label100:
      if (!this.jdField_a_of_type_Boolean) {
        break label221;
      }
    }
    for (;;)
    {
      return i10 << 1 | i1 << 10 | i2 << 9 | i3 << 8 | i4 << 7 | i5 << 6 | i6 << 5 | i7 << 4 | i8 << 3 | i9 << 2 | i11 << 0;
      i1 = 0;
      break;
      label169:
      i2 = 0;
      break label21;
      label174:
      i3 = 0;
      break label30;
      label179:
      i4 = 0;
      break label40;
      label185:
      i5 = 0;
      break label50;
      label191:
      i6 = 0;
      break label60;
      label197:
      i7 = 0;
      break label70;
      label203:
      i8 = 0;
      break label80;
      label209:
      i9 = 0;
      break label90;
      label215:
      i10 = 0;
      break label100;
      label221:
      i11 = 0;
    }
  }
  
  View a(int paramInt, View paramView)
  {
    CustomImgView localCustomImgView;
    View localView;
    PicInfo localPicInfo;
    Object localObject1;
    if (paramView == null)
    {
      paramView = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
      paramView.setOrientation(0);
      localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localCustomImgView.setLayoutParams(new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E));
      paramView.addView(localCustomImgView);
      localView = new View(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localView.setLayoutParams(new LinearLayout.LayoutParams((int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E));
      paramView.addView(localView);
      localCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840637));
      localPicInfo = a(paramInt);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841004);
    }
    for (;;)
    {
      try
      {
        if ((localPicInfo.jdField_c_of_type_JavaLangString == null) || (localPicInfo.jdField_c_of_type_JavaLangString.length() <= 0)) {
          continue;
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        localCustomImgView.setImageDrawable(URLDrawable.getDrawable(new File(localPicInfo.jdField_c_of_type_JavaLangString).toURL(), (URLDrawable.URLDrawableOptions)localObject2));
        if (paramInt >= c() - 1) {
          continue;
        }
        localView.setVisibility(0);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject2;
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.nearby_people_card.", 2, "PicGallery.getView() new URL(). " + localMalformedURLException.getMessage(), localMalformedURLException);
        continue;
        if (paramInt != c() - 1) {
          continue;
        }
        localMalformedURLException.setVisibility(8);
        continue;
      }
      paramView.setTag(localPicInfo);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (AppSetting.jdField_j_of_type_Boolean) {
        paramView.setContentDescription("图片" + paramInt);
      }
      return paramView;
      paramView = (LinearLayout)paramView;
      localCustomImgView = (CustomImgView)paramView.getChildAt(0);
      localView = paramView.getChildAt(1);
      break;
      if (!StringUtil.b(localPicInfo.b))
      {
        localObject2 = NearbyImgDownloader.a(localPicInfo.b);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E;
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
        localObject1 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        ((URLDrawable)localObject1).setDownloadListener(new ImgDownloadListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "actNearbyPeoplePicDownload"));
        localCustomImgView.setImageDrawable((Drawable)localObject1);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      return;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 1))
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$PicGallaryAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$PicGallaryAdapter = new NearbyProfileDisplayPanel.PicGallaryAdapter(this);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$PicGallaryAdapter);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$PicGallaryAdapter.notifyDataSetChanged();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.jdField_e_of_type_Int);
    if (!this.jdField_n_of_type_Boolean)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D;
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (i1 == 3)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon == null) {
          break label184;
        }
        i1 = 0;
        if (i1 >= 4) {
          break label184;
        }
        if (!this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a()) {
          break label166;
        }
      }
    }
    label166:
    label184:
    for (int i1 = 1;; i1 = 0)
    {
      int i3 = i1;
      int i2;
      if (i1 == 0)
      {
        i3 = i1;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg != null) {
          i2 = 0;
        }
      }
      for (;;)
      {
        i3 = i1;
        if (i2 < 3)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i2].a()) {
            i3 = 1;
          }
        }
        else
        {
          if (i3 != 0)
          {
            this.jdField_n_of_type_Boolean = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005549", "0X8005549", 0, 0, "", "", "", "");
          }
          return;
          i1 += 1;
          break;
        }
        i2 += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "prepare2ScoreAnim() diff=" + paramInt);
    }
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301992);
    Rect localRect;
    if (localTextView.getTag() == null)
    {
      localRect = new Rect();
      localTextView.setTag(localRect);
    }
    for (;;)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView();
      localTextView.getGlobalVisibleRect(localRect);
      if (localRect.bottom >= localView.getHeight()) {
        break;
      }
      a(localTextView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(202, 2500L);
      return;
      localRect = (Rect)localTextView.getTag();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130843567);
        String str = ProfileCardUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin));
        URL localURL = new URL("profile_img_big", null, str);
        if (paramInt2 == 1) {
          URLDrawable.removeMemoryCacheByUrl(localURL.toString());
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        localObject = new PicInfo();
        ((PicInfo)localObject).jdField_c_of_type_JavaLangString = str;
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(0, localObject);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean = true;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
          if (paramInt2 == 1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.set(0, localObject);
          }
        }
        QLog.i("Q.nearby_people_card.", 2, localMalformedURLException.getMessage());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      return;
    }
    if (paramInt2 != 1) {
      w();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt2 > paramInt4) && (paramInt2 >= this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)) {
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.jdField_c_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject1);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation((Animation)localObject1);
      }
      return;
      localObject1 = localObject2;
      if (paramInt2 < paramInt4)
      {
        localObject1 = localObject2;
        if (paramInt2 <= this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F)
        {
          localObject1 = localObject2;
          if (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
            localObject1 = this.jdField_b_of_type_AndroidViewAnimationAnimation;
          }
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
          return;
          localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        } while (paramInt2 == 0);
        Object localObject = paramIntent;
        if (paramIntent == null) {
          localObject = DatingUtil.jdField_a_of_type_AndroidContentIntent;
        }
        DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (Intent)localObject);
        return;
      } while (paramInt2 != 220);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(220);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
      return;
    } while (paramInt2 != -1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 25;
    f();
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo == null) || (paramInt == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 1))
    {
      if (NearbyUtils.b()) {
        NearbyUtils.a("NearbyProfileDisplayPanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D), Integer.valueOf(paramInt), paramInterestTagInfo });
      }
      return;
    }
    paramView = "";
    Object localObject = paramInterestTagInfo.convertTo();
    if (localObject != null) {
      paramView = ((JSONObject)localObject).toString();
    }
    localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, SpecialNearbyListActivity.class);
    ((Intent)localObject).putExtra("neighbor_interest_id", (byte)paramInt);
    ((Intent)localObject).putExtra("neighbor_sub_interest_id", paramInterestTagInfo.tagId);
    ((Intent)localObject).putExtra("neighbor_interest_name", paramInterestTagInfo.tagName);
    ((Intent)localObject).putExtra("param_mode", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D);
    ((Intent)localObject).putExtra("neighbor_interest_info", paramView);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
    ThreadManager.a(new tmr(this, paramInt), 5, null, false);
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayPanel", 2, "setHotChatInfo, info=" + paramHotChatInfo);
    }
    if ((paramHotChatInfo == null) || (TextUtils.isEmpty(paramHotChatInfo.name)))
    {
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      return;
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    if (paramHotChatInfo.subType == 1) {
      if (this.jdField_h_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_q_of_type_AndroidWidgetTextView.setText(paramHotChatInfo.name);
      return;
      if (this.jdField_h_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
    p();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130843567);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    localObject = new VideoDrawable.VideoDrawableParams();
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.U;
    localURLDrawableOptions.mExtraInfo = localObject;
    paramString = URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(paramString), localURLDrawableOptions);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.size() > 0)) {
      if (paramString.equals(((PicInfo)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.get(0)).d))
      {
        if (!paramBoolean) {
          break label61;
        }
        a(paramString);
      }
    }
    label61:
    while ((!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
    {
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (paramBoolean)
    {
      a(paramString);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      String str4 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(new String[] { str1, str2, str3, str4 });
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.nearby_people_card.", 4, "setHometownTextView hometownStr is: " + str1);
      }
      if ("不限".equals(str1)) {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428306));
          this.jdField_i_of_type_AndroidWidgetTextView.setText("未填写");
          this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        t();
      }
      return;
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      continue;
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428262));
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_i_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131428306));
        this.jdField_i_of_type_AndroidWidgetTextView.setText("未填写");
        this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      else
      {
        this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.removeBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
        d();
      }
    }
    do
    {
      return;
      paramList = (ShowExternalTroop)paramList.get(0);
      this.jdField_c_of_type_JavaLangString = paramList.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.b = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131364857);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString = paramList.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = paramList.strFaceUrl;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString == null));
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_c_of_type_JavaLangString, "1", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_c_of_type_JavaLangString, "0", "", "");
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "http://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      paramString.putExtra("url", HtmlOffline.a(str, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.jdField_a_of_type_Int + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + "&vname=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h + "&bn=" + paramBoolean));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
    }
  }
  
  boolean a()
  {
    return (Utils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.feedPreviewTime = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new tnd(this));
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
      String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.b();
      String str1 = str2;
      if (StringUtil.b(str2)) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.b();
      }
      localUserInfo.b = str1;
      QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, -1, LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    r();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo);
    }
    b(false);
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    int i1 = localResources.getColor(2131428262);
    int i2 = localResources.getColor(2131428306);
    label164:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin()))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
        break label1189;
      }
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label1176;
      }
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130841140);
      this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label1201;
      }
      localStringBuilder.append("男");
      localStringBuilder.append(" ");
      label209:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0)
      {
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
        localStringBuilder.append("岁");
        localStringBuilder.append(" ");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation != 0)
      {
        localStringBuilder.append(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation));
        localStringBuilder.append(" ");
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2))
      {
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance);
        localStringBuilder.append(" ");
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2)) {
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
      }
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label1233;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      label399:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      localStringBuilder.delete(0, localStringBuilder.length());
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) {
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
      }
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label1275;
      }
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      label517:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 3) {
        break label1321;
      }
      if (this.jdField_p_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label1287;
      }
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_o_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      label569:
      if (("Coolpad8750".equals(DeviceInfoUtil.d())) || ("Coolpad 8705".equals(DeviceInfoUtil.d()))) {
        this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.freshNewsInfo);
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hotInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charm != 0L) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 3)) {
        break label1362;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      label667:
      if (!StringUtil.b(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1))) {
        break label1427;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2) {
        break label1415;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i2);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("未填写");
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label723:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job >= NearbyProfileUtil.d.length)) {
        break label1521;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job != NearbyProfileUtil.d.length - 1) {
        break label1474;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      label772:
      this.jdField_f_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label815:
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = StringUtil.e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        break label1586;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2) {
        break label1574;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i2);
      this.jdField_g_of_type_AndroidWidgetTextView.setText("未填写");
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label883:
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = StringUtil.e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
      if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        break label1650;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2) {
        break label1638;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i2);
      this.jdField_h_of_type_AndroidWidgetTextView.setText("未填写");
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label951:
      a(true);
      p();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowQzoneFeed())) {
        break label1702;
      }
      this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      label989:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowQzoneFeed()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hasQzonePhotoUrl())) {
        break label1802;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      label1028:
      d();
      s();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 3) {
        break label2238;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      f();
    }
    for (;;)
    {
      t();
      q();
      a();
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
      i1 = 0;
      while (i1 < 4)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList);
        if (AppSetting.jdField_j_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a());
        }
        i1 += 1;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1176:
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130841139);
      break label164;
      label1189:
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
      break label164;
      label1201:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label209;
      }
      localStringBuilder.append("女");
      localStringBuilder.append(" ");
      break label209;
      label1233:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.findViewById(2131301980).getLayoutParams()).bottomMargin = ((int)(15.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
      break label399;
      label1275:
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
      break label517;
      label1287:
      this.jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      break label569;
      label1321:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2) {
        break label569;
      }
      this.jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetTextView.setText("我的交友资料");
      break label569;
      label1362:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charm, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.curThreshold, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nextThreshold);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      break label667;
      label1415:
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label723;
      label1427:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label723;
      label1474:
      this.jdField_e_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      break label772;
      label1521:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText("未填写");
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i2);
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        break label815;
      }
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label815;
      label1574:
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label883;
      label1586:
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label883;
      label1638:
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label951;
      label1650:
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_h_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label951;
      label1702:
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.qzoneFeed;
      Object localObject1 = localObject2;
      if (StringUtil.b((String)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.qzoneName;
      }
      localObject2 = localObject1;
      if (StringUtil.b((String)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname + localResources.getString(2131370017);
      }
      this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new tmx(this));
      this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label989;
      label1802:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getQZonePhotoList();
      i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131493548);
      ImageView[] arrayOfImageView = new ImageView[3];
      arrayOfImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302255));
      arrayOfImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302257));
      arrayOfImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302259));
      View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302256);
      View localView2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302258);
      View localView3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302260);
      i1 = 0;
      if (i1 < arrayOfImageView.length)
      {
        ImageView localImageView = arrayOfImageView[i1];
        label1963:
        label1982:
        Object localObject3;
        if ((localObject2 != null) && (((List)localObject2).size() > i1))
        {
          localObject1 = (String)((List)localObject2).get(i1);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (localImageView == null)) {
            break label2053;
          }
          localImageView.setVisibility(8);
          localObject3 = new View[] { localView1, localView2, localView3 }[i1];
          if ((localImageView == null) || (localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).contains("video=1"))) {
            break label2197;
          }
          ((View)localObject3).setVisibility(0);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject1 = null;
          break label1963;
          label2053:
          if (localImageView == null) {
            break label1982;
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(localResources.getColor(2131427454));
          }
          try
          {
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i2;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i2;
            localObject3 = URLDrawable.getDrawable(NearbyImgDownloader.a((String)localObject1), (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject3).setDownloadListener(new ImgDownloadListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "actProfileCardQzoneEntryPicDownload"));
            localImageView.setVisibility(0);
            localImageView.setImageDrawable((Drawable)localObject3);
          }
          catch (Exception localException)
          {
            localImageView.setVisibility(8);
          }
          if (!QLog.isColorLevel()) {
            break label1982;
          }
          QLog.e("Q.nearby_people_card.", 2, localException.toString());
          break label1982;
          label2197:
          if (localException != null) {
            localException.setVisibility(8);
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new tmy(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      break label1028;
      label2238:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      e();
    }
    i1 = 0;
    while (i1 < 3)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[(i1 + 4)].jdField_a_of_type_JavaUtilArrayList);
      if (AppSetting.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a());
      }
      i1 += 1;
    }
    o();
    if (AppSetting.jdField_j_of_type_Boolean)
    {
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append("图片1");
      localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(localStringBuilder.toString());
      this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_i_of_type_AndroidWidgetTextView.getText());
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_c_of_type_AndroidWidgetTextView.getText());
      this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_AndroidWidgetTextView.getText());
      this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_h_of_type_AndroidWidgetTextView.getText());
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_f_of_type_AndroidWidgetTextView.getText());
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_g_of_type_AndroidWidgetTextView.getText());
    }
    if (paramNearbyPeopleCard.uRoomid == 0L)
    {
      this.jdField_a_of_type_ComTencentWidgetBorderTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131372239));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(Math.round(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float * 1.0F));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(-635272);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(-635272);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 11.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController = new ProfileQiqiLiveController(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_AndroidOsHandler);
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() > 2))
    {
      paramNearbyPeopleCard = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2);
      paramNearbyPeopleCard.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramNearbyPeopleCard.findViewById(2131302178));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgressColor(-16745986);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_pv", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
      {
        bool1 = true;
        if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null)) {
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 1, 1);
        }
        VoteView localVoteView = this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label150;
        }
        label95:
        localVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper, paramBoolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setOnClickListener(this);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean = false;
      }
      return;
      bool1 = false;
      break;
      label150:
      bool2 = false;
      break label95;
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.setVisibility(4);
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean;
    }
    return bool;
  }
  
  public void c()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.b();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.b();
    }
    localUserInfo.b = str1;
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, localUserInfo, Long.valueOf(l1), 1, 0, -1);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "hideCharmChanged() showAnim=" + paramBoolean);
    }
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131301992);
    if (paramBoolean)
    {
      int i1 = localTextView.getWidth();
      int i2 = localTextView.getHeight();
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, i1 / 2, i2 / 2);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(1500L);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setFillBefore(false);
      localTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      return;
    }
    localTextView.setVisibility(4);
  }
  
  void d()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getBusiEntrys();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.removeAllViews();
    int i3 = localList.size();
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby) || (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowHobby()) || (i3 == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
    if (i3 <= 4) {
      i1 /= 4;
    }
    Object localObject1;
    Object localObject2;
    LayoutInflater localLayoutInflater;
    int i4;
    ProfileBusiEntry localProfileBusiEntry;
    Object localObject3;
    for (;;)
    {
      localObject1 = null;
      localObject2 = null;
      localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      i4 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131493549);
      int i2 = 0;
      while (i2 < i3)
      {
        localProfileBusiEntry = (ProfileBusiEntry)localList.get(i2);
        if (localProfileBusiEntry != null) {
          break label190;
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        i2 += 1;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      break;
      i1 = i1 * 146 / 640;
    }
    label190:
    View localView = localLayoutInflater.inflate(2130904291, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131300666);
    if (localObject2 == null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841057);
      label232:
      String str3 = localProfileBusiEntry.jdField_a_of_type_JavaLangString;
      String str2 = localProfileBusiEntry.b;
      String str1 = localProfileBusiEntry.jdField_c_of_type_JavaLangString;
      if ((!StringUtil.b(str1)) && (5 < str1.length()))
      {
        str1 = str1.substring(0, 5) + "...";
        label298:
        localObject3 = localObject1;
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = localObject1;
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
          localObject3 = localObject1;
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
          localObject3 = localObject1;
          localURLDrawableOptions.mRequestHeight = i4;
          localObject3 = localObject1;
          localURLDrawableOptions.mRequestWidth = i4;
          localObject3 = localObject1;
          localObject1 = URLDrawable.getDrawable(NearbyImgDownloader.a(str3), localURLDrawableOptions);
          localObject3 = localObject1;
          ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.a(i4, i4, (int)(10.0F * DeviceInfoUtil.a())));
          localObject3 = localObject1;
          ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.b);
          localObject3 = localObject1;
          ((URLDrawable)localObject1).setDownloadListener(new ImgDownloadListener(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "actProfileCardHobbyPicDownload"));
          localObject3 = localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            continue;
            localImageView.setImageDrawable((Drawable)localObject2);
          }
          localDataTag = new DataTag(19, new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isOpenRecentPlayingGamesByNative()), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strProfileUrl, localProfileBusiEntry });
          if (this.jdField_q_of_type_Boolean) {
            break label1162;
          }
        }
        if (localObject3 != null)
        {
          localImageView.setImageDrawable((Drawable)localObject3);
          ((TextView)localView.findViewById(2131300667)).setText(str2);
          ((TextView)localView.findViewById(2131299988)).setText(str1);
          localView.setContentDescription(str2 + str1);
          switch (localProfileBusiEntry.jdField_a_of_type_Int)
          {
          default: 
            localObject1 = new DataTag(27, localProfileBusiEntry);
          }
        }
      }
    }
    label1162:
    for (;;)
    {
      localView.setTag(localObject1);
      localView.setOnClickListener(this);
      localObject1 = new LinearLayout.LayoutParams(i1, -2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004315 ", "0X8004315 ", 0, 0, "", "", "", "");
      this.jdField_q_of_type_Boolean = true;
      continue;
      DataTag localDataTag = new DataTag(22, localProfileBusiEntry);
      if (!this.r)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004314", "0X8004314", 0, 0, "", "", "", "");
        this.r = true;
        continue;
        localDataTag = new DataTag(21, localProfileBusiEntry);
        if (!this.jdField_p_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004316", "0X8004316", 0, 0, "", "", "", "");
          this.jdField_p_of_type_Boolean = true;
          continue;
          localDataTag = new DataTag(28, localProfileBusiEntry);
          if (!this.jdField_o_of_type_Boolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004300", "0X8004300", 0, 0, "", "", "", "");
            this.jdField_o_of_type_Boolean = true;
            continue;
            localDataTag = new DataTag(30, localProfileBusiEntry);
            continue;
            localDataTag = new DataTag(33, localProfileBusiEntry);
            continue;
            localDataTag = new DataTag(39, localProfileBusiEntry);
            if (!this.s)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80055CB", "0X80055CB", 0, 0, "", "", "", "");
              this.s = true;
              continue;
              localDataTag = new DataTag(42, localProfileBusiEntry);
              if (!this.t)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005D15", "0X8005D15", 0, 0, "", "", "", "");
                this.t = true;
                continue;
                localDataTag = new DataTag(58, localProfileBusiEntry);
                if (!this.u)
                {
                  VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "0X8006E04", "0X8006E04", 1, 0, new String[0]);
                  this.u = true;
                  continue;
                  break label298;
                  break label232;
                }
                continue;
              }
              continue;
            }
            continue;
          }
          continue;
        }
        continue;
      }
    }
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void f()
  {
    DatingUtil.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getSimpleName(), new Object[] { "card godflag is `", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag), " sayhello flag is ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag) });
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      b(1, 20);
      b(2, 8);
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) || ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag == 3)))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 14) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 79) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75)) && (a() != null) && (a().length > 0)) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L)
        {
          b(0, 36);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) {
            break label365;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b != null) || (a())) {
            break label355;
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
      }
      for (;;)
      {
        b(1, 7);
        return;
        b(2, 40);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          break;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        break;
        label355:
        b(2, 8);
        continue;
        label365:
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b == null) && (!a())) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
        } else {
          b(0, 8);
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 17) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 18) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 19))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag == 1) {
        b(0, 38);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        return;
        b(0, 37);
      }
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) && (!ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g))) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 14)) && (a() != null) && (a().length > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) {
        break label659;
      }
      b(0, 36);
    }
    for (;;)
    {
      b(1, 7);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) {
        break label677;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag != 1) {
        break;
      }
      b(2, 38);
      return;
      label659:
      b(2, 40);
    }
    b(2, 37);
    return;
    label677:
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag == 1)
    {
      b(0, 38);
      return;
    }
    b(0, 37);
  }
  
  public void g()
  {
    ThreadPriorityManager.a(true);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Boolean)
    {
      i1 = 0;
      if (!a()) {
        break label71;
      }
      localIntent = new Intent();
      localIntent.putExtra("finchat", true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(0, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    label71:
    while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
    {
      Intent localIntent;
      return;
      i1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      break;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, i1);
  }
  
  public void h()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.S == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.S == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.C)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.S, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.C, false);
      return;
    }
    w();
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.a(true);
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView.a(false);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      x();
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      FaceDrawable localFaceDrawable = (FaceDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void l()
  {
    DownloadApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(10);
    }
    DownloadApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof DataTag)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      paramView = (DataTag)localObject;
      switch (paramView.ah)
      {
      }
    }
    for (;;)
    {
      return;
      if ((paramView.a instanceof ProfileBusiEntry))
      {
        paramView = (ProfileBusiEntry)paramView.a;
        if (!StringUtil.b(paramView.d))
        {
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("portraitOnly", true);
          if (!StringUtil.b(paramView.d)) {
            break label350;
          }
          paramView = "";
          label271:
          ((Intent)localObject).putExtra("url", paramView);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        label350:
        paramView = paramView.d;
        break label271;
        if ((paramView.a instanceof Object[]))
        {
          paramView = (Object[])paramView.a;
          a(((Boolean)paramView[0]).booleanValue(), (String)paramView[1]);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if ((paramView.a instanceof ProfileBusiEntry))
        {
          paramView = (ProfileBusiEntry)paramView.a;
          if (!StringUtil.b(paramView.d)) {
            b(paramView.d);
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if ((paramView.a instanceof ProfileBusiEntry))
        {
          localObject = (ProfileBusiEntry)paramView.a;
          if (!StringUtil.b(((ProfileBusiEntry)localObject).d))
          {
            Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            localIntent.putExtra("url", ((ProfileBusiEntry)localObject).d);
            localIntent.putExtra("hide_operation_bar", true);
            localIntent.putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
          }
        }
        if (28 != paramView.ah) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if (!(paramView.a instanceof ProfileBusiEntry)) {
          continue;
        }
        paramView = (ProfileBusiEntry)paramView.a;
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ShowExternalTroopListActivity.class);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.putExtra("isHost", bool);
          paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_c_of_type_JavaLangString, "1", "", "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 3) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_c_of_type_JavaLangString, "0", "", "");
        return;
        if (!(paramView.a instanceof ProfileBusiEntry)) {
          continue;
        }
        paramView = (ProfileBusiEntry)paramView.a;
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView.d + "&_webviewtype=1");
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
        return;
        this.jdField_d_of_type_Boolean = true;
        v();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004827", "0X8004827", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "", "");
        if (!ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523C", "0X800523C", 0, 0, "", "", "", "");
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, paramView, (String)localObject, null, true, null, true, true, null, "from_internal");
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby_people_card.", 2, "mCard == null , or mCard.uin is Empty, " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Boolean);
        return;
        this.jdField_c_of_type_Boolean = true;
        g();
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin != null))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, paramView, "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 76)) {
            break label1488;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
        }
        label1488:
        while ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 103))
        {
          NearbyPeopleProfileActivity.T = 0;
          if (!ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)) {
            break label1576;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
          return;
          paramView = "";
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {}
        for (paramView = "1";; paramView = "0")
        {
          VipUtils.a((AppInterface)localObject, "Vip_MapRoam", "0X8004A35", "0X8004A35", 0, 0, new String[] { paramView });
          break;
        }
        label1576:
        if (!ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005CAA", "0X8005CAA", 0, 0, "", "", "", "");
        return;
        this.jdField_b_of_type_Boolean = true;
        NearbyPeopleProfileActivity.T += 1;
        paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        localObject = Utils.a(a());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          if (Friends.isValidUin(paramView))
          {
            paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a(paramView), ((String)localObject).toLowerCase(), Integer.valueOf(1), "near.card.s", "" });
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("portraitOnly", true);
            ((Intent)localObject).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
            i1 = NearbyProfileUtil.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i1, 0, "", "", "", "");
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app != null)
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0)) {
            break label1928;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131369645));
          continue;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371565));
        }
        label1928:
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_m_of_type_Boolean)
        {
          DatingUtil.c("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
          return;
        }
        paramView = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(60);
        if (paramView == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_m_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 17) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 18) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 19))
        {
          i1 = 8;
          label2093:
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label2187;
            }
          }
        }
        label2187:
        for (int i2 = 1;; i2 = 2)
        {
          i2 = i1 | i2;
          paramView.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(204, 1000L);
          return;
          i1 = 4;
          break label2093;
        }
        if (!(paramView.a instanceof ProfileBusiEntry)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80055CA", "0X80055CA", 0, 0, "", "", "", "");
        paramView = (ProfileBusiEntry)paramView.a;
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView.d);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
        return;
        if (!(paramView.a instanceof ProfileBusiEntry)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
        paramView = (ProfileBusiEntry)paramView.a;
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView.d);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
        return;
        if (!(paramView.a instanceof ProfileBusiEntry)) {
          continue;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "0X8006E05", "0X8006E05", 1, 0, new String[0]);
        paramView = (ProfileBusiEntry)paramView.a;
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView.d);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
          continue;
        }
        if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131367256, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131492908));
          return;
        }
        if (PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "com.guagua.qiqi"))
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          return;
        }
        if (this.jdField_d_of_type_Int == 1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131372238);
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(3);
          this.jdField_d_of_type_Int = 2;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          return;
        }
        if (NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          if (this.jdField_l_of_type_Boolean)
          {
            DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131372232), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131372233), 0, 2131372237, new tml(this), null).show();
            this.jdField_l_of_type_Boolean = false;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
            if ((this.jdField_d_of_type_Int != 2) && (this.jdField_d_of_type_Int != 0)) {
              break;
            }
            this.jdField_d_of_type_Int = 1;
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
        }
        if ((this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 0))
        {
          DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131372232), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131372234), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
          this.jdField_d_of_type_Int = 1;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
        return;
        if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView)
        {
          if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D)
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, VisitorsActivity.class);
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
            {
              i1 = 0;
              localObject = new Bundle();
              ((Bundle)localObject).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).longValue());
              ((Bundle)localObject).putLong("totalVoters", i1);
              ((Bundle)localObject).putBoolean("isStartedByProfileCard", true);
              ((Bundle)localObject).putBoolean("votersOnly", true);
              if (i1 <= 0) {
                break label3291;
              }
            }
            label3291:
            for (bool = true;; bool = false)
            {
              ((Bundle)localObject).putBoolean("hasVoters", bool);
              ((Bundle)localObject).putInt("frome_where", 4);
              paramView.putExtras((Bundle)localObject);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
              NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc = 0;
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new tmm(this));
              }
              if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
                this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean = true;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
              return;
              i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount;
              break;
            }
          }
          if (3 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D) {
            continue;
          }
          this.jdField_a_of_type_Boolean = true;
          paramView = new HashMap();
          localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131370016));
            paramView.put("param_FailCode", "-210");
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).a((String)localObject, "profileCardSendFavorite", false, 0L, 0L, paramView, "", false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("NearbyProfileDisplayPanel", 2, "mCard is null,vote failed !");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyProfileDisplayPanel", 2, "Click Vote View, mCard.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ",mCard.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt + ",mCard.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0)
          {
            i1 = 1;
            label3494:
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt > 0)) {
              break label3805;
            }
            i2 = 1;
            label3517:
            if ((i1 != 0) || (i2 != 0)) {
              break label3939;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) || (!NetworkUtil.e(BaseApplication.getContext()))) {
              break label3811;
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
            paramView.likeCount += 1;
            paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
            paramView.bAvailVoteCnt = ((short)(paramView.bAvailVoteCnt - 1));
            this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted = 1;
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
            if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))
            {
              paramView = Message.obtain();
              paramView.what = 1;
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramView, 2000L);
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_o_of_type_Boolean = true;
            b(true);
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004825", "0X8004825", b(), 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "", "");
            if (ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label4238;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
            return;
            i1 = 0;
            break label3494;
            label3805:
            i2 = 0;
            break label3517;
            label3811:
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler != null)
            {
              paramView.put("param_FailCode", "-203");
              StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).a((String)localObject, "profileCardSendFavorite", true, 0L, 0L, paramView, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131369994));
            }
            else
            {
              paramView.put("param_FailCode", "-204");
              StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).a((String)localObject, "profileCardSendFavorite", false, 0L, 0L, paramView, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131370016));
            }
          }
          label3939:
          long l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileDisplayPanel", 2, "toastInterval:" + l1);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice != null)
          {
            if (l1 > FriendProfileCardActivity.h)
            {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
              jdField_a_of_type_Long = SystemClock.uptimeMillis();
            }
            if (i2 != 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)), "", "", "");
            }
          }
          for (;;)
          {
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a()).a((String)localObject, "profileCardSendFavorite", false, 0L, 0L, paramView, "", false);
            break;
            if (i1 != 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)), "", "", "");
              continue;
              if (l1 > FriendProfileCardActivity.h)
              {
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131370016));
                jdField_a_of_type_Long = SystemClock.uptimeMillis();
              }
              if (i1 != 0) {
                paramView.put("param_FailCode", "-230");
              } else if (i2 != 0) {
                paramView.put("param_FailCode", "-231");
              }
            }
          }
          label4238:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_a_of_type_ComTencentImageURLImageView)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
            continue;
          }
          localObject = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0);
          paramView = AnimationUtils.a(paramView);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject), paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
          if (ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
          }
          if (!NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D)) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().b(((PicInfo)localObject).jdField_a_of_type_JavaLangString);
          return;
        }
        if (paramView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2)
          {
            paramView = (Boolean)paramView.getTag();
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(100L);
            if ((paramView != null) && (!paramView.booleanValue())) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new tmn(this), 300L);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050C9", "0X80050C9", 0, 0, "", "", "", "");
          }
          while (ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 3)
            {
              localObject = new PicInfo();
              ((PicInfo)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(32, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 200);
              if (QLog.isColorLevel()) {
                QLog.e("Q.nearby_people_card.", 2, "on mode guest small head clicked: uin is: " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + " local path is: " + ((PicInfo)localObject).jdField_c_of_type_JavaLangString);
              }
              paramView = AnimationUtils.a(paramView);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a((PicInfo)localObject, paramView);
            }
          }
        }
        if (paramView == this.jdField_b_of_type_AndroidWidgetRelativeLayout)
        {
          this.jdField_h_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 3) {}
          for (i1 = 1;; i1 = 0)
          {
            paramView = NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            paramView = "http://ti.qq.com/meilizhigl/index.html?_wv=1027&isguest=[isguest]&uin=[uin]".replace("[isguest]", Integer.toString(i1)).replace("[uin]", paramView);
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 2) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AC", "0X80052AC", 0, 0, "", "", "", "");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D != 3) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AD", "0X80052AD", 0, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_g_of_type_AndroidWidgetImageView)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
          if ((!Friends.isValidUin(paramView)) || (!Friends.isValidUin(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin))) {
            continue;
          }
          bool = paramView.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          if (bool)
          {
            i1 = 0;
            if (!bool) {
              break label5103;
            }
          }
          for (;;)
          {
            paramView = String.format("http://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(i1), paramView });
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("portraitOnly", true);
            ((Intent)localObject).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
            return;
            i1 = 1;
            break;
            label5103:
            paramView = "";
          }
        }
        if (paramView == this.jdField_e_of_type_AndroidWidgetRelativeLayout)
        {
          this.jdField_f_of_type_Boolean = true;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, MyFreshNewsActivity.class);
          paramView.setFlags(67108864);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.D == 2) {
            paramView.putExtra("parm_mode", 10);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(paramView, 22);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005A1A", "0X8005A1A", 0, 0, "", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005CE9", "0X8005CE9", 0, 0, "", "", "", "");
            return;
            paramView.putExtra("param_guest_nick", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
            paramView.putExtra("param_guest_tinyid", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
            paramView.putExtra("param_guest_uin", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            paramView.putExtra("parm_mode", 11);
          }
        }
        if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.H == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b();
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(300L);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_d_of_type_AndroidWidgetRelativeLayout)
        {
          this.jdField_g_of_type_Boolean = true;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hotInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hotInfo.joinUrl)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NearbyProfileDisplayPanel", 2, "jump to Hotchat, url=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hotInfo.joinUrl);
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hotInfo.joinUrl;
            i1 = paramView.lastIndexOf("hotnamecode=");
            if (i1 < 0) {}
            do
            {
              if (QLog.isColorLevel()) {
                QLog.i("NearbyProfileDisplayPanel", 2, "jumpToHotChat, can not find hotnamecode, using old jump method");
              }
              localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
              ((Intent)localObject).putExtra("hide_more_button", true);
              ((Intent)localObject).putExtra("ishiderefresh", true);
              ((Intent)localObject).putExtra("ishidebackforward", true);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(((Intent)localObject).putExtra("url", paramView));
              return;
              localObject = paramView.substring(i1 + 12);
            } while (TextUtils.isEmpty((CharSequence)localObject));
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, NearbyTransitActivity.class);
            paramView.putExtra("action", 1);
            paramView.putExtra("hotnamecode", (String)localObject);
            paramView.putExtra("enter_time", System.currentTimeMillis());
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("NearbyProfileDisplayPanel", 2, "jump to Hotchat, url is empty");
          return;
        }
        if ((paramView != this.jdField_d_of_type_AndroidWidgetImageView) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() < 1)) {
          continue;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0);
        paramView = AnimationUtils.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject), paramView);
        return;
      }
      catch (SecurityException paramView)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\profilecard\NearbyProfileDisplayPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */