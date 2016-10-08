package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.activity.weather.WeatherManager.WeatherUpdaterListener;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.data.ApolloRedTouchInfo;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mex;
import mey;
import mez;
import mfb;
import mfc;
import mfd;
import mfe;
import mff;
import mfg;
import mfh;
import mfj;
import mfk;
import mfl;
import mfm;
import mfn;
import mfp;
import mft;
import mfu;
import mfv;
import mfw;
import mfx;
import mfz;
import mga;
import mgb;
import mgc;
import mgd;
import mgf;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingMe
  implements View.OnClickListener
{
  public static int a = 0;
  public static final String a = "QQSettingRedesign";
  private static List jdField_a_of_type_JavaUtilList;
  public static final String b = "http://mc.vip.qq.com";
  public static final int c = 0;
  public static final int d = 1;
  private static final String e = "apollo_settingme_first_enter";
  private static final int jdField_g_of_type_Int = 0;
  private static final int jdField_h_of_type_Int = 1;
  private static final int i = 2;
  private static final int jdField_j_of_type_Int = 3;
  private static final int k = 4;
  private static final int l = 5;
  private static final int m = 6;
  private static final int n = 7;
  private static final int o = 8;
  private static final int p = 9;
  private static final int q = 65535;
  private static final int r = 1099;
  public float a;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mfz(this);
  public Handler a;
  public View a;
  public ViewGroup a;
  protected ImageView a;
  public RelativeLayout a;
  public TextView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private WeatherManager.WeatherUpdaterListener jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener = new mfx(this);
  private WeatherManager jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager;
  public ApolloTextureView a;
  public ApolloRedTouchInfo a;
  public ApolloBoxEnterView a;
  public FrameGifView a;
  public BaseActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new mfn(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new mfm(this);
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mfp(this);
  public QQAppInterface a;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new mfu(this);
  private VipInfoObserver jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver = new mfl(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private DingdongPluginBizObserver jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver = new mfv(this);
  public DynamicAvatarView a;
  public Card a;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new mfj(this);
  protected RedTouch a;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = new mft(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground;
  protected RedDotTextView a;
  public BusinessInfoCheckUpdate.AppInfo a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  protected boolean a;
  public int[] a;
  protected View[] a;
  protected RedTouchTextView[] a;
  public float b;
  int b;
  protected View b;
  public ImageView b;
  public TextView b;
  protected RedTouch b;
  public BusinessInfoCheckUpdate.AppInfo b;
  public boolean b;
  protected View c;
  protected ImageView c;
  public TextView c;
  protected RedTouch c;
  public BusinessInfoCheckUpdate.AppInfo c;
  private String c;
  public boolean c;
  public View d;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  public TextView d;
  protected RedTouch d;
  BusinessInfoCheckUpdate.AppInfo jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private String jdField_d_of_type_JavaLangString = "http://mc.vip.qq.com";
  public boolean d;
  public int e;
  public TextView e;
  public BusinessInfoCheckUpdate.AppInfo e;
  public boolean e;
  public int f;
  public TextView f;
  public BusinessInfoCheckUpdate.AppInfo f;
  private boolean f;
  public BusinessInfoCheckUpdate.AppInfo g;
  private boolean jdField_g_of_type_Boolean;
  public BusinessInfoCheckUpdate.AppInfo h;
  private boolean jdField_h_of_type_Boolean;
  public BusinessInfoCheckUpdate.AppInfo i;
  BusinessInfoCheckUpdate.AppInfo jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public BusinessInfoCheckUpdate.AppInfo k = null;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("mc.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("mo.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("m.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("fun.svip.qq.com");
    jdField_a_of_type_JavaUtilList.add("iyouxi.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_a_of_type_JavaUtilList.add("i.gtimg.cn");
    jdField_a_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_a_of_type_JavaUtilList.add("vipfunc.qq.com");
    jdField_a_of_type_JavaUtilList.add("cgi.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("cmshow.qq.com");
  }
  
  public QQSettingMe(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, FrameHelperActivity paramFrameHelperActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.j = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo = new ApolloRedTouchInfo();
    this.jdField_a_of_type_AndroidOsHandler = new mga(this, Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130904343, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301399);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.j) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription("进入我的资料卡");
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297019));
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView).a(53).a();
    paramBaseActivity = paramQQAppInterface.a();
    int i1;
    if ((paramBaseActivity == null) || (paramBaseActivity.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130838582);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296932));
      this.jdField_c_of_type_JavaLangString = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramBaseActivity);
      if ((this.jdField_c_of_type_JavaLangString == null) || ("".equals(this.jdField_c_of_type_JavaLangString.trim()))) {
        this.jdField_c_of_type_JavaLangString = paramBaseActivity;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      C();
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297020));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302372));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302371));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302373);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewView).b(10).a(19).a();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131493303);
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[9];
      paramQQAppInterface = new int[9];
      QQAppInterface tmp600_599 = paramQQAppInterface;
      tmp600_599[0] = 2131302379;
      QQAppInterface tmp606_600 = tmp600_599;
      tmp606_600[1] = 2131302380;
      QQAppInterface tmp612_606 = tmp606_600;
      tmp612_606[2] = 2131302383;
      QQAppInterface tmp618_612 = tmp612_606;
      tmp618_612[3] = 2131302385;
      QQAppInterface tmp624_618 = tmp618_612;
      tmp624_618[4] = 2131302384;
      QQAppInterface tmp630_624 = tmp624_618;
      tmp630_624[5] = 2131302382;
      QQAppInterface tmp636_630 = tmp630_624;
      tmp636_630[6] = 2131302381;
      QQAppInterface tmp643_636 = tmp636_630;
      tmp643_636[7] = 2131302386;
      QQAppInterface tmp650_643 = tmp643_636;
      tmp650_643[8] = 2131302387;
      tmp650_643;
      paramFrameHelperActivity = new int[9];
      FrameHelperActivity tmp664_663 = paramFrameHelperActivity;
      tmp664_663[0] = 2131370937;
      FrameHelperActivity tmp670_664 = tmp664_663;
      tmp670_664[1] = 2131370934;
      FrameHelperActivity tmp676_670 = tmp670_664;
      tmp676_670[2] = 2131370935;
      FrameHelperActivity tmp682_676 = tmp676_670;
      tmp682_676[3] = 2131370941;
      FrameHelperActivity tmp688_682 = tmp682_676;
      tmp688_682[4] = 2131370932;
      FrameHelperActivity tmp694_688 = tmp688_682;
      tmp694_688[5] = 2131370933;
      FrameHelperActivity tmp700_694 = tmp694_688;
      tmp700_694[6] = 2131371273;
      FrameHelperActivity tmp707_700 = tmp700_694;
      tmp707_700[7] = 2131370945;
      FrameHelperActivity tmp714_707 = tmp707_700;
      tmp714_707[8] = 2131371223;
      tmp714_707;
      i1 = 0;
      label725:
      if (i1 >= 9) {
        break label1071;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1] = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(paramQQAppInterface[i1]);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setFocusable(true);
      if (paramQQAppInterface[i1] != 2131302381) {
        break label1057;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(8);
    }
    for (;;)
    {
      if ((i1 == 7) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] != null))
      {
        a(false);
        if (e()) {
          a(true);
        }
      }
      if (paramQQAppInterface[i1] == 2131302387) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setOnClickListener(this);
      ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i1].findViewById(2131302405)).setImageResource(new int[] { 2130841283, 2130841279, 2130841282, 2130841284, 2130841285, 2130841286, 2130841260, 2130841280, 2130841261 }[i1]);
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i1].findViewById(2131302406)).setText(paramFrameHelperActivity[i1]);
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i1].findViewById(2131300679)).setVisibility(8);
      AccessibilityUtil.a(this.jdField_a_of_type_ArrayOfAndroidViewView[i1], paramBaseActivity.getString(paramFrameHelperActivity[i1]), Button.class.getName());
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[i1] = ((RedTouchTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i1].findViewById(2131302406));
      i1 += 1;
      break label725;
      paramFrameHelperActivity = paramQQAppInterface.a(paramQQAppInterface.a(1, paramBaseActivity, (byte)3, 0));
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap(paramFrameHelperActivity);
      break;
      label1057:
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
    }
    label1071:
    paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302388);
    paramBaseActivity.setOnClickListener(this);
    AccessibilityUtil.a(paramBaseActivity, "设置", Button.class.getName());
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)paramBaseActivity.findViewById(2131302389));
    this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302390);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    AccessibilityUtil.a(this.jdField_c_of_type_AndroidViewView, "夜间模式", Button.class.getName());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302392));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302391));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[5].findViewById(2131302407));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302398));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302400));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302401));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302399));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = ((ApolloBoxEnterView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302397));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131372314));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302396));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302393);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void C()
  {
    boolean bool2 = OlympicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MCard");
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297742));
    }
    boolean bool1;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      bool1 = true;
      if (bool2 != bool1)
      {
        ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (!bool2) {
          break label160;
        }
        i1 = 0;
        label73:
        localImageView.setVisibility(i1);
        if (!bool2) {
          break label166;
        }
      }
    }
    label160:
    label166:
    for (int i1 = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidWidgetImageView.getResources());; i1 = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, i1, 0);
      if (bool2) {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, "updateOlympicTorchShow " + bool2);
      }
      return;
      bool1 = false;
      break;
      i1 = 8;
      break label73;
    }
  }
  
  private void D()
  {
    ThreadManager.a(new mgb(this), 5, null, false);
  }
  
  private void E()
  {
    a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.i);
  }
  
  private void F()
  {
    Object localObject = new StringBuilder();
    int i1 = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
    String str;
    if (!this.jdField_d_of_type_JavaLangString.contains("?"))
    {
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString + "?platform=1&type=20001&networkInfo=" + i1);
      str = ((StringBuilder)localObject).toString();
      localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100400));
      str = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(str, (BusinessInfoCheckUpdate.AppInfo)localObject);
      if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) || (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != 0)) {
        break label309;
      }
    }
    label309:
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      ((Intent)localObject).putExtra("portraitOnly", true);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("has_red_dot", bool);
      ((Intent)localObject).putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131367467));
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 256L, (Intent)localObject, false, -1);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100400));
      return;
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString + "&platform=1&type=20001&networkInfo=" + i1);
      break;
    }
  }
  
  private void G()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.k);
      boolean bool = this.jdField_h_of_type_Boolean;
      this.jdField_h_of_type_Boolean = this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      if (QLog.isColorLevel()) {
        QLog.i(LocalRedTouchManager.jdField_a_of_type_JavaLangString, 2, "updateHeadIcon, old:" + bool + " new:" + this.jdField_h_of_type_Boolean);
      }
      if (bool != this.jdField_h_of_type_Boolean) {
        w();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void H()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    String str1 = localSharedPreferences.getString("cur_temp", null);
    String str2 = localSharedPreferences.getString("cur_city", null);
    String str3 = localSharedPreferences.getString("cur_code", null);
    boolean bool = localSharedPreferences.getBoolean("show_flag", false);
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateWeatherView cur_temp:" + str1 + ",cur_city" + str2 + ",o_wea_code" + str3 + ",show_flag:" + bool);
    }
    if (!bool)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    }
    while ((str1 == null) || (str2 == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(str2);
    this.jdField_e_of_type_AndroidWidgetTextView.setText("o");
    c(str3);
  }
  
  private void I()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = false;
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[7] != null) {
        ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131302405)).setImageResource(2130841280);
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramAppInfo);
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = OfficeCenterSharedPref.a().a("officecenter_always_show_flag", false);
    if (bool != paramBoolean) {
      OfficeCenterSharedPref.a().b("officecenter_always_show_flag", paramBoolean);
    }
    return bool;
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      localStringBuilder.append("地点：").append(this.jdField_f_of_type_AndroidWidgetTextView.getText()).append("，天气：");
      if (!paramString.equals("201")) {
        break label100;
      }
      localStringBuilder.append("晴");
    }
    for (;;)
    {
      localStringBuilder.append("，温度：").append(this.jdField_d_of_type_AndroidWidgetTextView.getText()).append("摄氏度");
      if ((AppSetting.j) && (localStringBuilder != null)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localStringBuilder.toString());
      }
      return;
      label100:
      if (paramString.equals("202")) {
        localStringBuilder.append("多云");
      } else if (paramString.equals("203")) {
        localStringBuilder.append("阴");
      } else if (paramString.equals("204")) {
        localStringBuilder.append("雨");
      } else if (paramString.equals("205")) {
        localStringBuilder.append("雪");
      } else if (paramString.equals("206")) {
        localStringBuilder.append("雾");
      } else if (paramString.equals("207")) {
        localStringBuilder.append("沙尘");
      } else if (paramString.equals("208")) {
        localStringBuilder.append("霾");
      } else {
        localStringBuilder.append("未知");
      }
    }
  }
  
  private boolean c()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    long l1;
    int i1;
    do
    {
      return true;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      l1 = localSharedPreferences.getLong("sp_vip_info_request_time", 0L);
      i1 = localSharedPreferences.getInt("sp_vip_info_update_freq", 10);
    } while (NetConnInfoCenter.getServerTime() - l1 > i1 * 60);
    return false;
  }
  
  private boolean d()
  {
    return OfficeCenterSharedPref.a().a("officecenter_always_show_flag", false);
  }
  
  private boolean e()
  {
    return b();
  }
  
  private boolean f()
  {
    String str = a();
    if (str.equals("1")) {}
    do
    {
      return true;
      if ((str.equals("2")) || (!str.equals("3"))) {
        return false;
      }
    } while (d());
    if (a())
    {
      a(true);
      return true;
    }
    return false;
  }
  
  public void A()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, "Bubble");
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo != null)) {
        QLog.d("QQSettingRedesign", 2, "apollo redtouch clean bubtext=" + this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_a_of_type_JavaLangString + " and ts = " + this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_b_of_type_Int);
      }
    }
  }
  
  public void B()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      OlympicUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006EFD", 0);
    }
  }
  
  public String a()
  {
    return OfficeCenterSharedPref.a().a("officecenter_test_strategy", "");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    if (!this.jdField_c_of_type_Boolean) {
      h();
    }
    AbstractGifImage.resumeAll();
    x();
    l();
    v();
    if ((((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() > 480) && ((ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", null) <= 0) || (!ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Boolean.valueOf(false)))))
    {
      H();
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a();
    }
    Object localObject1;
    for (;;)
    {
      i();
      n();
      z();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localObject1 != null) && (((String)localObject1).equals(this.jdField_c_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.s();
      }
      b();
      this.jdField_b_of_type_Boolean = true;
      Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800433C", "0X800433C", 0, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        long l1 = WebProcessManager.b((String)localObject1);
        if (System.currentTimeMillis() - l1 < 604800000L) {
          WebProcessManager.a(jdField_a_of_type_JavaUtilList, "key_vip_dns_parse");
        }
      }
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
      if (localObject1 != null)
      {
        localObject2 = (BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
        if ((localObject2 == null) || (!((BusinessCardManager)localObject2).a(0))) {
          break;
        }
        ((View)localObject1).setVisibility(0);
      }
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    ((View)localObject1).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1099) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(true, false);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramConfiguration.orientation;
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "fillData, " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      f();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      g();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(paramQQAppInterface);
      l();
      x();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(Card paramCard)
  {
    int i2 = 1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1;
    label31:
    float f3;
    float f1;
    if (paramCard.bSuperVipOpen == 1)
    {
      i1 = 1;
      if (paramCard.bQQVipOpen != 1) {
        break label368;
      }
      paramCard = ((Resources)localObject).getDisplayMetrics();
      f3 = ((Resources)localObject).getDimension(2131492997);
      if (i2 == 0) {
        break label392;
      }
      if (i1 == 0) {
        break label374;
      }
      f1 = paramCard.density * 46.0F;
    }
    for (;;)
    {
      label66:
      float f2 = ((Resources)localObject).getDimension(2131493315);
      float f4 = ((Resources)localObject).getDimension(2131493306);
      float f5 = ((Resources)localObject).getDimension(2131493311);
      float f6 = ((Resources)localObject).getDimension(2131493316);
      float f7 = ((Resources)localObject).getDimension(2131493298);
      f4 = paramCard.widthPixels - (f2 + f4 + f5 + f6 + f7);
      f2 = f4;
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        f2 = f4;
        if (this.jdField_b_of_type_AndroidWidgetTextView.getWidth() > 0) {
          f2 = Math.min(f4, this.jdField_b_of_type_AndroidWidgetTextView.getWidth());
        }
      }
      f4 = f2 - f1;
      if (f3 <= 1.0F) {}
      for (f2 = 1.0F;; f2 = f3)
      {
        QQSettingUtil.jdField_a_of_type_Int = (int)Math.floor(f4 / f2);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resizeQQLevelIconSize width=" + paramCard.widthPixels);
          ((StringBuilder)localObject).append(",iconSize=" + f2);
          ((StringBuilder)localObject).append(",vipSize=" + f1);
          ((StringBuilder)localObject).append(",space=" + f4);
          ((StringBuilder)localObject).append(",maxIconSize=" + QQSettingUtil.jdField_a_of_type_Int);
          QLog.i("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
        }
        return;
        i1 = 0;
        break;
        label368:
        i2 = 0;
        break label31;
        label374:
        f1 = paramCard.density * 42.0F;
        break label66;
      }
      label392:
      f1 = 0.0F;
    }
  }
  
  public void a(RichStatus paramRichStatus)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302375);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302376);
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      localImageView.setBackgroundResource(2130841277);
      localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramRichStatus.actionId, 200));
      localStringBuilder.append(paramRichStatus.actionText);
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      localStringBuilder.append(' ');
      if ((paramRichStatus != null) && (paramRichStatus.plainText != null))
      {
        if (paramRichStatus.plainText.size() <= 0) {
          break label250;
        }
        paramRichStatus = (String)paramRichStatus.plainText.get(0);
        label148:
        if (!TextUtils.isEmpty(paramRichStatus)) {
          localStringBuilder.append(paramRichStatus);
        }
      }
      paramRichStatus = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramRichStatus)) {
        break label255;
      }
      localTextView.setText("编辑个性签名");
    }
    for (;;)
    {
      if (AppSetting.j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append(paramRichStatus);
        this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      return;
      localImageView.setBackgroundResource(0);
      localImageView.setPadding(0, 0, 0, 0);
      localImageView.setImageResource(2130841278);
      break;
      label250:
      paramRichStatus = null;
      break label148;
      label255:
      if (DeviceInfoUtil.b()) {
        localTextView.setText(paramRichStatus + " ");
      } else {
        localTextView.setText(paramRichStatus);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new mey(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSettingRedesign", 2, "updateMyVipInfo svip= " + paramBoolean1 + ",vip=" + paramBoolean2 + ",viplevel=" + paramInt);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131302406);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131302405);
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    Object localObject1 = localResources.getString(2131370937);
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        localImageView.setImageResource(2130841283);
        localObject2 = ((SharedPreferences)localObject2).getString("vip_qqsetting_title_svip", localResources.getString(2131370939));
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        int i1;
        localException.printStackTrace();
        continue;
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() > 8) {
        localObject2 = ((String)localObject1).substring(0, 8);
      }
      localTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setVisibility(0);
      if (AppSetting.j) {
        AccessibilityUtil.a(this.jdField_a_of_type_ArrayOfAndroidViewView[0], (CharSequence)localObject2, Button.class.getName());
      }
      return;
      if (paramBoolean2)
      {
        localImageView.setImageResource(2130841283);
        localObject2 = ((SharedPreferences)localObject2).getString("vip_qqsetting_title_vip", localResources.getString(2131370938));
        localObject1 = localObject2;
      }
      else
      {
        localImageView.setImageResource(2130841283);
        i1 = ((SharedPreferences)localObject2).getInt("key_selfvip_growthvalue", 0);
        if ((paramInt > 0) || (i1 > 0))
        {
          localObject2 = ((SharedPreferences)localObject2).getString("vip_qqsetting_title_expired_vip", localResources.getString(2131370940));
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = ((SharedPreferences)localObject2).getString("vip_qqsetting_title_notvip", localResources.getString(2131370937));
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a().iterator();
    while (localIterator.hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
      if ((localTroopInfo != null) && (localTroopInfo.dwGroupClassExt == 10012L) && (localTroopInfo.troopuin.endsWith("3"))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo == null) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          Object localObject = new JSONObject(paramString2);
          paramString2 = ((JSONObject)localObject).optString("_show_mission");
          localObject = ((JSONObject)localObject).optJSONObject("msg");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optJSONObject(paramString2);
            if (localObject != null)
            {
              int i1 = ((JSONObject)localObject).optInt("time");
              if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (i1 != this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0).getInt(paramString1, 0)))
              {
                localObject = ((JSONObject)localObject).optString("content");
                if (!TextUtils.isEmpty((CharSequence)localObject))
                {
                  localObject = new JSONObject((String)localObject);
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_c_of_type_JavaLangString = paramString1;
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("actionId");
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("bubbleText");
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("url");
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("type");
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_b_of_type_Int = i1;
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_a_of_type_Boolean = true;
                  this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.jdField_d_of_type_JavaLangString = paramString2;
                  return true;
                }
              }
            }
          }
        }
        catch (JSONException paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingRedesign", 2, "parseRedInfo error :" + paramString1.toString());
    return false;
  }
  
  protected void b()
  {
    ApolloEngine.a();
    boolean bool = ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Boolean.valueOf(false));
    this.jdField_f_of_type_Boolean = bool;
    if ((!bool) || (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", null) <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    int i2 = ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    long l1 = System.currentTimeMillis();
    Object localObject1 = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    int i1;
    if (localObject1 != null)
    {
      this.jdField_f_of_type_Int = ((ApolloBaseInfo)localObject1).apolloStatus;
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress();
      if (localObject1 == null) {
        break label1679;
      }
      i1 = ((ApolloDress)localObject1).jdField_a_of_type_Int;
      localObject1 = ((ApolloDress)localObject1).a();
    }
    for (;;)
    {
      if ((i1 <= 0) || (localObject1 == null) || (localObject1.length <= 0) || (this.jdField_f_of_type_Int != 1) || ((i1 > 0) && (localObject1 != null) && (!ApolloActionHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1, (int[])localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {}
      for (bool = true;; bool = false)
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_show", this.jdField_f_of_type_Int, 0, new String[] { "0" });
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "roleId->" + i1 + " apolloStatus->" + this.jdField_f_of_type_Int + " needStatic->" + bool);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject2 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
          if (localObject2 != null) {
            ((WebProcessManager)localObject2).e();
          }
        }
        if (bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0);
          localObject2 = Long.valueOf(((SharedPreferences)localObject1).getLong("apollo_drawer_gif_ts" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0L));
          i1 = ((SharedPreferences)localObject1).getInt("apollo_drawer_gif_times" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
          if (((((Long)localObject2).longValue() == 0L) || (System.currentTimeMillis() - ((Long)localObject2).longValue() > 1440000L)) && (i1 < 2) && (i2 > 480))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setAnimaListener(new mex(this, (SharedPreferences)localObject1, i1, (Long)localObject2));
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.a() == 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.a() == 2)) {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.postDelayed(new mfk(this), 1000L);
            }
            for (;;)
            {
              this.jdField_d_of_type_AndroidViewView.setVisibility(8);
              return;
              this.jdField_f_of_type_Int = 0;
              localObject1 = null;
              i1 = 0;
              break;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.a() == 3)
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
                this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.postDelayed(new mfw(this), 1000L);
              }
            }
          }
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          if ((FontSettingManager.a() >= 17.0F) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
            this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302395).setVisibility(8);
          }
          if ((i2 <= 480) && (!((SharedPreferences)localObject1).getBoolean("apollo_480_static", false)) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
          {
            this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302395).setVisibility(8);
            this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_d_of_type_AndroidViewView);
            this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a(53);
            this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a();
            localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
            this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQSettingRedesign", 2, "play apollo static pic");
          return;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837759);
        long l2;
        long l3;
        float f1;
        float f2;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null)
        {
          this.jdField_e_of_type_Int = i1;
          this.jdField_a_of_type_ArrayOfInt = ((int[])localObject1);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
          localObject1 = new mgf(this);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a((OnApolloViewListener)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a() != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a((IRenderCallback)localObject1);
          }
          l2 = DeviceInfoUtil.i();
          l3 = DeviceInfoUtil.h();
          f1 = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.a();
          f2 = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.b();
          i1 = (int)((float)l3 * 0.7F);
          localObject1 = new RelativeLayout.LayoutParams(i1, (int)(l2 >> 1));
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((float)l3 - f1 / 2.0F));
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(l3 - ((RelativeLayout.LayoutParams)localObject1).rightMargin - i1));
          this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject1);
          f1 = (((RelativeLayout.LayoutParams)localObject1).rightMargin - f2) / f1;
          if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof SettingMeRelativeLayout)) {
            ((SettingMeRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup).setSurfaceView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, f1, ((RelativeLayout.LayoutParams)localObject1).rightMargin - f2);
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          f1 = FontSettingManager.a() / 16.0F;
          if (f1 != 0.0F) {
            break label1670;
          }
          f1 = 1.0F;
        }
        label1258:
        label1670:
        for (;;)
        {
          float f3 = DeviceInfoUtil.a() / f1;
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(60.0F * f3), (int)(60.0F * f3));
          localLayoutParams.addRule(11, -1);
          localLayoutParams.addRule(12, -1);
          i1 = AIOUtils.a(5.0F, (Resources)localObject1);
          if (i2 <= 480)
          {
            i1 = -AIOUtils.a(56.0F, (Resources)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setGifData(100, (Drawable)localObject2, null, null, false);
            float f4 = ((float)l3 - f2 - 160.0F * f3) / 2.0F;
            localLayoutParams.rightMargin = ((int)((i1 + (f4 + f2)) / f1));
            localLayoutParams.bottomMargin = ((int)(5.0F * f3));
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b();
            if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() != 0) {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
            }
            if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof SettingMeRelativeLayout)) {
              ((SettingMeRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup).a();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("QQSettingRedesign", 2, "refresh ApolloSettingMe->" + (System.currentTimeMillis() - l1));
            return;
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setGifData(100, (Drawable)localObject2, "http://cmshow.gtimg.cn/client/zip/box_gif.zip", QQFrameZipDecoder.a("http://cmshow.gtimg.cn/client/zip/box_gif.zip"), false);
            break label1258;
            if (this.jdField_a_of_type_Float <= 0.0F) {
              break;
            }
            if ((i1 != this.jdField_e_of_type_Int) || (!ApolloUtil.a((int[])localObject1, this.jdField_a_of_type_ArrayOfInt)))
            {
              if (i1 != this.jdField_e_of_type_Int)
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().g();
                l2 = Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f());
                f1 = (float)(l2 >> 2) / 368.0F;
                if (l2 != DeviceInfoUtil.i()) {
                  QLog.e("QQSettingRedesign", 1, "DeviceInfoUtil.getPortraitHeight():" + DeviceInfoUtil.i() + " height:" + l2);
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, i1, f1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
              }
              this.jdField_e_of_type_Int = i1;
              this.jdField_a_of_type_ArrayOfInt = ((int[])localObject1);
              if (localObject1 != null) {
                this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1, (int[])localObject1, null);
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().a(1000L);
            }
            if (!this.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(65535, 100L);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
          }
        }
      }
      label1679:
      localObject1 = null;
      i1 = 0;
    }
  }
  
  public void b(String paramString)
  {
    ThreadManager.a(new mez(this, paramString), 5, null, false);
  }
  
  public boolean b()
  {
    boolean bool1 = false;
    Iterator localIterator = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
      if ((localTroopInfo == null) || (localTroopInfo.dwGroupClassExt != 10012L)) {
        break label116;
      }
      i1 = 1;
    }
    label116:
    for (;;)
    {
      break;
      boolean bool2 = OfficeCenterSharedPref.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "officecenter_receive_schedule_message", false);
      if ((i1 != 0) || (bool2)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public void c()
  {
    int i2 = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (Build.VERSION.SDK_INT < 14)) {}
    ArrayList localArrayList;
    do
    {
      return;
      RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < ApolloConstant.b.length)
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(ApolloConstant.b[i1]);
        if ((localAppInfo != null) && (!TextUtils.isEmpty(localAppInfo.buffer.get()))) {
          localArrayList.add(localAppInfo);
        }
        i1 += 1;
      }
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    int i1 = i2;
    for (;;)
    {
      if (i1 < localArrayList.size())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "buffer = " + ((BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i1)).buffer.get());
        }
        if (!a(((BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i1)).path.get(), ((BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i1)).buffer.get())) {}
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQSettingRedesign", 2, "apollo RedTouchInfo = " + this.jdField_a_of_type_ComTencentMobileqqApolloDataApolloRedTouchInfo.toString());
        return;
      }
      i1 += 1;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onPause!");
    }
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().b(1);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onDestroy!");
    }
    if (this.jdField_c_of_type_Boolean)
    {
      f();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.b();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
        if (localAvatarPendantManager != null) {
          localAvatarPendantManager.c();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.a().c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
      }
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof SettingMeRelativeLayout)) {
        ((SettingMeRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup).setSurfaceView(null, null, 1.0F, 0.0F);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.b(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback);
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback);
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager = ((WeatherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener);
      }
    }
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "init, " + this.jdField_c_of_type_Boolean);
    }
    if (true == this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    g();
    l();
    x();
    v();
    i();
    n();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
      QQSettingUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "initUpdateVipInfoReceiver:" + localException.toString());
        }
      }
    }
  }
  
  public void i()
  {
    ThreadManager.a(new mgc(this), 5, null, false);
  }
  
  public void j()
  {
    G();
    o();
    p();
    t();
    u();
    y();
    q();
    k();
    r();
    s();
    z();
    E();
  }
  
  protected void k()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[4].setAppInfo(this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((QzoneAlbumRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).a(this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void l()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(ImageUtil.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    do
    {
      return;
      a(str);
      ThreadManager.a(new mgd(this, str), null, true);
      C();
      b(str);
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    } while (!AppSetting.j);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
    }
    w();
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void n()
  {
    String str = null;
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a();
    Drawable localDrawable;
    if (i1 == 1)
    {
      localDrawable = localResources.getDrawable(2130841275);
      str = localResources.getString(2131370944);
    }
    for (;;)
    {
      if (localDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      if (str != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      }
      return;
      if (i1 == 2)
      {
        localDrawable = localResources.getDrawable(2130841274);
        str = localResources.getString(2131370944);
      }
      else
      {
        localDrawable = null;
      }
    }
  }
  
  public void o()
  {
    boolean bool = UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool);
    }
    if (!bool) {
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (!this.jdField_c_of_type_Boolean)) {}
    Object localObject2;
    label1228:
    do
    {
      long l1;
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
                switch (paramView.getId())
                {
                default: 
                  return;
                case 2131297742: 
                  OlympicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006EFE", 0);
                }
              } while (!((OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).c("HomePage"));
              localObject1 = String.format("http://sqimg.qq.com/qq_product_operations/olympic/detail.html?_wv=16777216&uin=%s&adtag=%s", new Object[] { NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), "profileCard" });
              localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", URLUtil.guessUrl((String)localObject1));
              paramView.getContext().startActivity((Intent)localObject2);
              return;
              paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
              paramView.jdField_f_of_type_Int = 1;
              paramView.g = 8;
              ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
              DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
            } while (!this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("CliOper", "0X8006726");
            return;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            paramView.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364458));
            paramView.putExtra("nick", ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1));
            paramView.putExtra("uin", (String)localObject1);
            paramView.putExtra("type", 1);
            paramView.putExtra("reportFlag", 1);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
            return;
            l1 = System.currentTimeMillis();
          } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
          this.jdField_a_of_type_Long = l1;
          QWalletHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_wallet", "Clk_wallet", 0, 0, "", "", "", "");
          QQSettingUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100007));
          if (jdField_a_of_type_Int > 0)
          {
            DrawerFrame.jdField_f_of_type_Int = 2;
            return;
          }
          DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
          return;
          QfavHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1, true);
          QfavReport.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0);
          QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(103000));
          return;
          paramView = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
          bool = false;
          localObject1 = new QZoneClickReport.ReportInfo();
          ((QZoneClickReport.ReportInfo)localObject1).c("443");
          ((QZoneClickReport.ReportInfo)localObject1).d("3");
          ((QZoneClickReport.ReportInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
          if ((this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
          {
            bool = true;
            ((QZoneClickReport.ReportInfo)localObject1).e("1");
          }
          for (;;)
          {
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (QZoneClickReport.ReportInfo)localObject1);
            paramView.b(String.valueOf(100180));
            try
            {
              l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
              localObject2 = QZoneHelper.UserInfo.a();
              ((QZoneHelper.UserInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l1);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
              paramView = (View)localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                paramView = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              }
              ((QZoneHelper.UserInfo)localObject2).jdField_b_of_type_JavaLangString = paramView;
              QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QZoneHelper.UserInfo)localObject2, Long.valueOf(l1), 0, bool, -1);
              paramView = new QZoneClickReport.ReportInfo();
              paramView.jdField_c_of_type_JavaLangString = "1";
              paramView.jdField_d_of_type_JavaLangString = "0";
              paramView.jdField_b_of_type_Int = 4;
              paramView.k = "3";
              paramView.l = "drawerAlbumList";
              paramView.m = "QZonePhotoListActivity";
              QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
              paramView = new HashMap();
              paramView.put("source_type", "3");
              paramView.put("source_from", "drawerAlbumList");
              paramView.put("source_to", "QZonePhotoListActivity");
              StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
              DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
              return;
              ((QZoneClickReport.ReportInfo)localObject1).e("2");
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                paramView.printStackTrace();
                l1 = 0L;
              }
            }
          }
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100005));
          paramView = (IndividuationABTestManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(176);
          bool = false;
          if (paramView.jdField_c_of_type_Int == 0)
          {
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("QQSettingRedesign", 2, "isOpenNative = " + bool);
            }
            if (!bool) {
              break label1228;
            }
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, IndividuationSetActivity.class);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting_native", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
            return;
            if (!TextUtils.isEmpty(paramView.jdField_c_of_type_JavaLangString)) {
              break;
            }
            bool = true;
            break;
            if (QLog.isColorLevel()) {
              QLog.d("QQSettingRedesign", 2, "individuation jumpurl = " + paramView.jdField_c_of_type_JavaLangString);
            }
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.jdField_c_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          }
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
          if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", UpgradeController.a(), "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
            ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100190));
          DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
          return;
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
          this.jdField_c_of_type_AndroidViewView.setClickable(false);
          this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          DrawerFrame.jdField_f_of_type_Int = 0;
        } while (!AppSetting.j);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
        for (paramView = "关闭夜间模式";; paramView = "夜间模式 ")
        {
          AccessibilityUtil.a(this.jdField_c_of_type_AndroidViewView, paramView, Button.class.getName());
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        localObject1 = "http://weather.mp.qq.com/?_wv=5127&asyncMode=1";
        paramView = (View)localObject1;
        if (this.jdField_f_of_type_AndroidWidgetTextView.getText() != null)
        {
          paramView = (View)localObject1;
          if (this.jdField_f_of_type_AndroidWidgetTextView.getText().length() <= 0) {}
        }
        try
        {
          paramView = "http://weather.mp.qq.com/?_wv=5127&asyncMode=1&city=" + URLEncoder.encode(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString(), "utf-8");
          ((Intent)localObject2).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          ((Intent)localObject2).putExtra("url", paramView);
          return;
        }
        catch (UnsupportedEncodingException paramView)
        {
          for (;;)
          {
            paramView = "http://weather.mp.qq.com/?_wv=5127&asyncMode=1&city=" + this.jdField_f_of_type_AndroidWidgetTextView.getText();
          }
        }
        localObject1 = "";
        paramView = (View)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
        {
          paramView = (View)localObject1;
          if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a())
          {
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, EditActivity.class);
            ((Intent)localObject2).putExtra("k_source", 0);
            ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
            RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
            BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(String.valueOf(100450));
            paramView = (View)localObject1;
            if (localAppInfo != null)
            {
              paramView = (View)localObject1;
              if (localAppInfo.iNewFlag != null)
              {
                paramView = (View)localObject1;
                if (localAppInfo.iNewFlag.get() != 0)
                {
                  paramView = (View)localObject1;
                  if (localAppInfo.missions.has())
                  {
                    paramView = (String)localAppInfo.missions.get().get(0);
                    ((Intent)localObject2).putExtra("k_taskId", paramView);
                  }
                }
              }
            }
            localRedTouchManager.b(String.valueOf(100450));
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
            DrawerFrame.jdField_f_of_type_Int = 0;
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", paramView, "");
        return;
        l1 = System.currentTimeMillis();
      } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
      this.jdField_a_of_type_Long = l1;
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, "enter vip");
      }
      ThreadManager.a(new mfb(this), 5, null, true);
      F();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
      if (jdField_a_of_type_Int > 0)
      {
        DrawerFrame.jdField_f_of_type_Int = 2;
        return;
      }
      DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QfileFileAssistantActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
      DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int;
      paramView = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      localObject1 = paramView.a(String.valueOf(100160));
    } while ((localObject1 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 0));
    paramView.b(String.valueOf(100160));
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("service_type", 2);
      ((JSONObject)localObject2).put("act_id", 1002);
      paramView.b((BusinessInfoCheckUpdate.AppInfo)localObject1, ((JSONObject)localObject2).toString());
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
      return;
    }
    if ((((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() <= 480) && (this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a()))
    {
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0).edit().putBoolean("apollo_480_static", true).commit();
    }
    Object localObject1 = new Intent();
    if (paramView.getId() == 2131302397)
    {
      ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject1).putExtra("extra_key_box_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0) {
        break label2508;
      }
    }
    label2508:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject1).putExtra("extra_key_open_box", bool);
      ((Intent)localObject1).putExtra("extra_key_box_from", "drawer");
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject1, "drawer");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.jdField_f_of_type_Int, 0, new String[] { "1", "0", "drawer" });
      return;
    }
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.jdField_f_of_type_Int, 0, new String[] { "0", "0", "drawer" });
    return;
    if (jdField_a_of_type_Int > 0) {}
    for (DrawerFrame.jdField_f_of_type_Int = 2;; DrawerFrame.jdField_f_of_type_Int = jdField_a_of_type_Int)
    {
      ThreadManager.a(new mfc(this), 5, null, true);
      paramView = new Intent();
      localObject1 = (DingdongPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114);
      paramView.putExtra("schedule_unread_count", ((DingdongPluginManager)localObject1).a());
      DingdongPluginHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "com.dingdong.business.Schedule.Activity.ScheduleListActivity", paramView, -1);
      ((DingdongPluginManager)localObject1).a(0);
      DingdongPluginHelper.a("0X80062F1");
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, BusinessCardListActivity.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064D7", "0X80064D7", 0, 0, "", "", "", "");
  }
  
  protected void p()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[1].setAppInfo(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void q()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void r()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[2].setAppInfo(this.i);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void s()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(1000017));
      if (!((BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111)).a())
      {
        localAppInfo.iNewFlag.set(1);
        localAppInfo.red_display_info.red_type_info.add(new BusinessInfoCheckUpdate.RedTypeInfo());
        localAppInfo.red_display_info.red_type_info.add(new BusinessInfoCheckUpdate.RedTypeInfo());
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[8].setAppInfo(localAppInfo);
        return;
        localAppInfo.iNewFlag.set(0);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void t()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[5].setAppInfo(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void u()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[0].setAppInfo(this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void v()
  {
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 4).getString("VIPCenter_url_key", "http://mc.vip.qq.com");
    ThreadManager.b().post(new mfd(this));
  }
  
  public void w()
  {
    int i1 = 0;
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
    Object localObject;
    if ((!this.jdField_h_of_type_Boolean) && (localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
    {
      localObject = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      ((AvatarPendantManager)localObject).b();
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localObject = ((AvatarPendantManager)localObject).a(localExtensionInfo.pendantId);
      if (AvatarPendantUtil.a(localExtensionInfo.pendantId))
      {
        ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.n);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
        i1 = 1;
      }
    }
    for (;;)
    {
      if ((i1 == 1) && (i1 == this.jdField_h_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("CliOper", "0X8006728");
      }
      return;
      ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.n);
      break;
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new mfe(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new mff(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new mfg(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.a().post(new mfh(this));
      return;
    }
    a(localRichStatus);
  }
  
  protected void y()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[3].setAppInfo(this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void z()
  {
    int i1 = 1;
    if (e())
    {
      I();
      a(true);
    }
    for (;;)
    {
      try
      {
        if (this.j == null)
        {
          this.j = new BusinessInfoCheckUpdate.AppInfo();
          this.j.path.set("");
          this.j.num.set(0);
          this.j.type.set(-1);
          this.j.iNewFlag.set(0);
          this.j.uiAppId.set(-1);
          this.j.type.set(0);
          this.j.iNewFlag.set(1);
          this.j.appset.set(1);
          this.j.mission_level.set(0);
          BusinessInfoCheckUpdate.RedDisplayInfo localRedDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(9);
          localRedTypeInfo.red_content.set("-1");
          localRedTypeInfo.red_desc.set("");
          localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
          localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(0);
          localRedDisplayInfo.tab_display_info.set(localRedTypeInfo);
          localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
          this.j.red_display_info.set(localRedDisplayInfo);
        }
        boolean bool = OfficeCenterSharedPref.a().a("officecenter_red_point_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
        if (!OfficeCenterSharedPref.a().a("officecenter_red_point_first_show", false))
        {
          OfficeCenterSharedPref.a().b("officecenter_red_point_first_show", true);
          OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
          if (!bool)
          {
            if (i1 != 0)
            {
              this.j.iNewFlag.set(1);
              this.j.red_display_info.red_type_info.add(new BusinessInfoCheckUpdate.RedTypeInfo());
              this.j.red_display_info.red_type_info.add(new BusinessInfoCheckUpdate.RedTypeInfo());
              this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[7].setAppInfo(this.j);
              return;
              a(false);
              return;
            }
            this.j.iNewFlag.set(0);
            continue;
          }
        }
        i1 = bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQSettingMe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */