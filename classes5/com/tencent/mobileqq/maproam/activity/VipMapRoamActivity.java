package com.tencent.mobileqq.maproam.activity;

import EncounterSvc.RespEncounterInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.RptInterestTag;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnRoamResultObserver;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog.OnSearchResultItemClick;
import com.tencent.mobileqq.maproam.widget.RoamingMapView;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearpeople.EncounterHolder;
import com.tencent.mobileqq.nearpeople.EncounterHolder.EncounterHolderOpt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import com.tencent.widget.XListView.MotionEventInterceptor;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tcd;
import tce;
import tcf;
import tcg;
import tch;
import tci;
import tcj;
import tck;
import tcm;
import tcn;
import tco;
import tcp;

public class VipMapRoamActivity
  extends LbsBaseActivity
  implements View.OnClickListener, Animation.AnimationListener, FaceDecoder.DecodeTaskCompletionListener, QQMapView.QQMapViewObserver, AbsListView.OnScrollListener, XListView.MotionEventInterceptor
{
  public static final String a = "VipMapRoamActivity";
  public static final int b = 100;
  public static final String b = "Vip_MapRoam";
  public static final int c = 101;
  public static final String c = "lat";
  public static final int d = 200;
  public static final String d = "lon";
  public static final int e = 300;
  public static final int f = 400;
  public static final int g = 0;
  public static final String g = "abp_flag";
  public static final int h = 100500;
  public static final String h = "is_from_web";
  public static final int i = 100501;
  public static int j;
  public static int k;
  public static final int l = 0;
  public float a;
  public long a;
  public View a;
  public ViewGroup a;
  public Animation a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public NearPeopleFilterActivity.NearPeopleFilters a;
  public PeopleAroundAdapter a;
  public NearbyHandler a;
  NearbyObserver jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new tck(this);
  public VipMapRoamActivity.UiHandler a;
  public RoamLocalSearchBar a;
  RoamSearchDialog.OnRoamResultObserver jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = new tce(this);
  RoamSearchDialog.OnSearchResultItemClick jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = new tcp(this);
  public RoamingMapView a;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public FaceDecoder a;
  public IIconDecoder.IIconListener a;
  public IIconDecoder a;
  public PullRefreshHeader a;
  protected QQProgressNotifier a;
  public GeoPoint a;
  public MapController a;
  public OverScrollViewListener a;
  public XListView a;
  public Runnable a;
  public List a;
  public AtomicBoolean a;
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public float b;
  public long b;
  public View b;
  public Animation b;
  public ImageView b;
  public LinearLayout b;
  public RelativeLayout b;
  public TextView b;
  public RoamLocalSearchBar b;
  public GeoPoint b;
  public boolean b;
  public View c;
  public Animation c;
  public ImageView c;
  public TextView c;
  public GeoPoint c;
  public boolean c;
  public View d;
  public Animation d;
  public ImageView d;
  public TextView d;
  public boolean d;
  private View e;
  public ImageView e;
  public TextView e;
  public String e;
  public boolean e;
  public ImageView f;
  public TextView f;
  public String f;
  public boolean f;
  public TextView g;
  public boolean g;
  private TextView h;
  public boolean h;
  public boolean i;
  public boolean j;
  private boolean k;
  public int m;
  private int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_j_of_type_Int = 2000;
    jdField_k_of_type_Int = 3000;
  }
  
  public VipMapRoamActivity()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler = new VipMapRoamActivity.UiHandler(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new tcm(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener = new tcn(this);
    this.jdField_a_of_type_JavaLangRunnable = new tco(this);
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if (!TextUtils.isEmpty(paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString)) {
        break label214;
      }
    }
    label214:
    for (String str = "";; str = paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = new GeoPoint((int)(paramSosoLbsInfo.a.a * 1000000.0D), (int)(paramSosoLbsInfo.a.b * 1000000.0D));
      if ((!this.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.Copy();
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      }
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(str);
      }
      b(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      if (!this.jdField_g_of_type_Boolean)
      {
        a(true, false);
        this.jdField_g_of_type_Boolean = true;
        this.jdField_d_of_type_Boolean = false;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler != null) && (this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(false, true, this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6(), this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "onLocationFinish info city=" + str);
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i2 = 8;
    TextView localTextView = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidViewView.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298469);
    if (paramBoolean)
    {
      i1 = 2131370686;
      localTextView.setText(i1);
      if (!paramBoolean) {
        break label99;
      }
      i1 = 0;
      label69:
      localProgressBar.setVisibility(i1);
      if (!paramBoolean) {
        break label106;
      }
    }
    label99:
    label106:
    for (int i1 = i2;; i1 = 0)
    {
      localImageView.setVisibility(i1);
      return;
      i1 = 2131368205;
      break;
      i1 = 8;
      break label69;
    }
  }
  
  private void j()
  {
    SosoInterface.a(new tci(this, 3, true, true, 0L, true, false, "VipMapRoamActivity"));
  }
  
  /* Error */
  public NearPeopleFilterActivity.NearPeopleFilters a(Intent paramIntent)
  {
    // Byte code:
    //   0: new 339	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters
    //   3: dup
    //   4: invokespecial 340	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: ifnull +482 -> 491
    //   12: aload_1
    //   13: ldc_w 342
    //   16: invokevirtual 348	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +467 -> 491
    //   27: aload_1
    //   28: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   31: invokevirtual 357	java/lang/Integer:intValue	()I
    //   34: istore 8
    //   36: iload 8
    //   38: ifeq +420 -> 458
    //   41: aload_0
    //   42: invokevirtual 361	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   45: ldc_w 363
    //   48: invokevirtual 348	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 361	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   56: ldc_w 365
    //   59: invokevirtual 348	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 4
    //   64: aload_0
    //   65: invokevirtual 361	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   68: ldc_w 367
    //   71: invokevirtual 348	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 5
    //   76: aload_0
    //   77: invokevirtual 361	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   80: ldc_w 369
    //   83: invokevirtual 348	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 6
    //   88: aload_0
    //   89: invokevirtual 361	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   92: ldc_w 371
    //   95: invokevirtual 348	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 7
    //   100: aload_0
    //   101: invokevirtual 361	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getIntent	()Landroid/content/Intent;
    //   104: ldc_w 373
    //   107: invokevirtual 348	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_3
    //   111: aload_1
    //   112: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +382 -> 497
    //   118: aload_1
    //   119: invokestatic 376	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   122: ifne +231 -> 353
    //   125: goto +372 -> 497
    //   128: new 339	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters
    //   131: dup
    //   132: invokespecial 340	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:<init>	()V
    //   135: astore_1
    //   136: iload 8
    //   138: iflt +227 -> 365
    //   141: iload 8
    //   143: iconst_2
    //   144: if_icmpgt +221 -> 365
    //   147: aload_1
    //   148: iload 8
    //   150: putfield 378	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:i	I
    //   153: aload 4
    //   155: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +345 -> 503
    //   161: aload 4
    //   163: invokestatic 376	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   166: ifne +205 -> 371
    //   169: goto +334 -> 503
    //   172: iload 8
    //   174: getstatic 381	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:b	[I
    //   177: arraylength
    //   178: if_icmpge +349 -> 527
    //   181: getstatic 381	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:b	[I
    //   184: iload 8
    //   186: iaload
    //   187: istore 8
    //   189: aload_1
    //   190: iload 8
    //   192: putfield 382	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_j_of_type_Int	I
    //   195: aload 5
    //   197: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: ifne +309 -> 509
    //   203: aload 5
    //   205: invokestatic 376	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   208: ifne +176 -> 384
    //   211: goto +298 -> 509
    //   214: iload 8
    //   216: getstatic 383	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   219: arraylength
    //   220: if_icmpge +313 -> 533
    //   223: aload_1
    //   224: iload 8
    //   226: putfield 384	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_k_of_type_Int	I
    //   229: aload 6
    //   231: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne +281 -> 515
    //   237: aload 6
    //   239: invokestatic 376	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   242: ifne +155 -> 397
    //   245: goto +270 -> 515
    //   248: iload 8
    //   250: getstatic 386	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:c	[Ljava/lang/String;
    //   253: arraylength
    //   254: if_icmpge +285 -> 539
    //   257: aload_1
    //   258: iload 8
    //   260: putfield 388	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:m	I
    //   263: aload 7
    //   265: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: ifne +253 -> 521
    //   271: aload 7
    //   273: invokestatic 376	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   276: ifne +134 -> 410
    //   279: goto +242 -> 521
    //   282: aload_1
    //   283: iload 8
    //   285: putfield 390	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:n	I
    //   288: aload_3
    //   289: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: istore 9
    //   294: aload_1
    //   295: astore_2
    //   296: iload 9
    //   298: ifne +286 -> 584
    //   301: aload_3
    //   302: ldc_w 392
    //   305: invokevirtual 398	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   308: astore_3
    //   309: aload_1
    //   310: astore_2
    //   311: aload_3
    //   312: arraylength
    //   313: iconst_4
    //   314: if_icmplt +270 -> 584
    //   317: iconst_0
    //   318: istore 8
    //   320: iload 8
    //   322: iconst_4
    //   323: if_icmpge +100 -> 423
    //   326: aload_1
    //   327: getfield 400	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:d	[Ljava/lang/String;
    //   330: iload 8
    //   332: aload_3
    //   333: iload 8
    //   335: aaload
    //   336: aastore
    //   337: iload 8
    //   339: iconst_1
    //   340: iadd
    //   341: istore 8
    //   343: goto -23 -> 320
    //   346: astore_1
    //   347: iconst_0
    //   348: istore 8
    //   350: goto -314 -> 36
    //   353: aload_1
    //   354: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   357: invokevirtual 357	java/lang/Integer:intValue	()I
    //   360: istore 8
    //   362: goto -234 -> 128
    //   365: iconst_0
    //   366: istore 8
    //   368: goto -221 -> 147
    //   371: aload 4
    //   373: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   376: invokevirtual 357	java/lang/Integer:intValue	()I
    //   379: istore 8
    //   381: goto -209 -> 172
    //   384: aload 5
    //   386: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   389: invokevirtual 357	java/lang/Integer:intValue	()I
    //   392: istore 8
    //   394: goto -180 -> 214
    //   397: aload 6
    //   399: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   402: invokevirtual 357	java/lang/Integer:intValue	()I
    //   405: istore 8
    //   407: goto -159 -> 248
    //   410: aload 7
    //   412: invokestatic 354	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   415: invokevirtual 357	java/lang/Integer:intValue	()I
    //   418: istore 8
    //   420: goto -138 -> 282
    //   423: aload_3
    //   424: arraylength
    //   425: iconst_5
    //   426: if_icmplt +14 -> 440
    //   429: aload_3
    //   430: iconst_4
    //   431: aaload
    //   432: astore_2
    //   433: aload_1
    //   434: aload_2
    //   435: putfield 402	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   438: aload_1
    //   439: areturn
    //   440: ldc_w 404
    //   443: astore_2
    //   444: goto -11 -> 433
    //   447: astore_3
    //   448: aload_2
    //   449: astore_1
    //   450: aload_3
    //   451: astore_2
    //   452: aload_2
    //   453: invokevirtual 407	java/lang/Exception:printStackTrace	()V
    //   456: aload_1
    //   457: areturn
    //   458: aload_0
    //   459: invokevirtual 411	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getApplication	()Landroid/app/Application;
    //   462: aload_0
    //   463: invokevirtual 415	com/tencent/mobileqq/maproam/activity/VipMapRoamActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   466: invokevirtual 419	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   469: invokestatic 422	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters;
    //   472: astore_1
    //   473: aload_1
    //   474: astore_2
    //   475: aload_1
    //   476: ifnonnull +108 -> 584
    //   479: new 339	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters
    //   482: dup
    //   483: invokespecial 340	com/tencent/mobileqq/activity/NearPeopleFilterActivity$NearPeopleFilters:<init>	()V
    //   486: areturn
    //   487: astore_2
    //   488: goto -36 -> 452
    //   491: iconst_0
    //   492: istore 8
    //   494: goto -458 -> 36
    //   497: iconst_0
    //   498: istore 8
    //   500: goto -372 -> 128
    //   503: iconst_3
    //   504: istore 8
    //   506: goto -334 -> 172
    //   509: iconst_0
    //   510: istore 8
    //   512: goto -298 -> 214
    //   515: iconst_0
    //   516: istore 8
    //   518: goto -270 -> 248
    //   521: iconst_0
    //   522: istore 8
    //   524: goto -242 -> 282
    //   527: iconst_3
    //   528: istore 8
    //   530: goto -341 -> 189
    //   533: iconst_0
    //   534: istore 8
    //   536: goto -313 -> 223
    //   539: iconst_0
    //   540: istore 8
    //   542: goto -285 -> 257
    //   545: astore_2
    //   546: iconst_5
    //   547: anewarray 394	java/lang/String
    //   550: dup
    //   551: iconst_0
    //   552: ldc_w 424
    //   555: aastore
    //   556: dup
    //   557: iconst_1
    //   558: ldc_w 424
    //   561: aastore
    //   562: dup
    //   563: iconst_2
    //   564: ldc_w 424
    //   567: aastore
    //   568: dup
    //   569: iconst_3
    //   570: ldc_w 424
    //   573: aastore
    //   574: dup
    //   575: iconst_4
    //   576: ldc_w 404
    //   579: aastore
    //   580: astore_3
    //   581: goto -272 -> 309
    //   584: aload_2
    //   585: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	VipMapRoamActivity
    //   0	586	1	paramIntent	Intent
    //   7	468	2	localObject1	Object
    //   487	1	2	localException1	Exception
    //   545	40	2	localException2	Exception
    //   110	320	3	localObject2	Object
    //   447	4	3	localException3	Exception
    //   580	1	3	arrayOfString	String[]
    //   62	310	4	str1	String
    //   74	311	5	str2	String
    //   86	312	6	str3	String
    //   98	313	7	str4	String
    //   34	507	8	i1	int
    //   292	5	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   27	36	346	java/lang/Exception
    //   41	125	447	java/lang/Exception
    //   128	136	447	java/lang/Exception
    //   353	362	447	java/lang/Exception
    //   147	169	487	java/lang/Exception
    //   172	189	487	java/lang/Exception
    //   189	211	487	java/lang/Exception
    //   214	223	487	java/lang/Exception
    //   223	245	487	java/lang/Exception
    //   248	257	487	java/lang/Exception
    //   257	279	487	java/lang/Exception
    //   282	294	487	java/lang/Exception
    //   311	317	487	java/lang/Exception
    //   326	337	487	java/lang/Exception
    //   371	381	487	java/lang/Exception
    //   384	394	487	java/lang/Exception
    //   397	407	487	java/lang/Exception
    //   410	420	487	java/lang/Exception
    //   423	429	487	java/lang/Exception
    //   433	438	487	java/lang/Exception
    //   301	309	545	java/lang/Exception
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (PeopleAroundAdapter.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap(paramBitmap);
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public void a(PeopleAroundAdapter.ViewHolder paramViewHolder)
  {
    Object localObject1 = null;
    Object localObject3;
    if (paramViewHolder != null)
    {
      localObject3 = paramViewHolder.jdField_a_of_type_JavaLangObject;
      localObject2 = localObject3;
      if ((localObject3 instanceof EncounterHolder.EncounterHolderOpt)) {
        localObject1 = ((EncounterHolder.EncounterHolderOpt)localObject3).a.encounter;
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      if (localObject1 == null) {}
      while (localObject2 == null) {
        return;
      }
      localObject2 = String.valueOf(((RespEncounterInfo)localObject1).lEctID);
      if (((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()))
      {
        localObject2 = new ProfileActivity.AllInOne((String)localObject2, 0);
        ((ProfileActivity.AllInOne)localObject2).h = ((RespEncounterInfo)localObject1).strNick;
        ((ProfileActivity.AllInOne)localObject2).jdField_b_of_type_Int = ((RespEncounterInfo)localObject1).cAge;
        ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_Byte = ((RespEncounterInfo)localObject1).cSex;
        ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_Short = ((RespEncounterInfo)localObject1).wFace;
        ((ProfileActivity.AllInOne)localObject2).f = 103;
        ((ProfileActivity.AllInOne)localObject2).g = 5;
        localObject3 = new Intent(this, NearbyPeopleProfileActivity.class);
        ((Intent)localObject3).putExtra("AllInOne", (Parcelable)localObject2);
        ((Intent)localObject3).putExtra("param_mode", 2);
        ((Intent)localObject3).putExtra("param_tiny_id", ((RespEncounterInfo)localObject1).tiny_id);
        ((Intent)localObject3).putExtra("param_interest_filter_type", this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l);
        startActivityForResult((Intent)localObject3, jdField_k_of_type_Int);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {}
        for (localObject1 = "1";; localObject1 = "0")
        {
          VipUtils.a((AppInterface)localObject2, "Vip_MapRoam", "0X8004A34", "0X8004A34", 0, 0, new String[] { localObject1 });
          NearbyFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramViewHolder.jdField_b_of_type_AndroidWidgetTextView, false);
          return;
        }
      }
      localObject2 = new ProfileActivity.AllInOne((String)localObject2, 41);
      ((ProfileActivity.AllInOne)localObject2).h = ((RespEncounterInfo)localObject1).strNick;
      ((ProfileActivity.AllInOne)localObject2).jdField_b_of_type_Int = ((RespEncounterInfo)localObject1).cAge;
      ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_Byte = ((RespEncounterInfo)localObject1).cSex;
      ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_Short = ((RespEncounterInfo)localObject1).wFace;
      ((ProfileActivity.AllInOne)localObject2).jdField_b_of_type_ArrayOfByte = ((RespEncounterInfo)localObject1).sig;
      ((ProfileActivity.AllInOne)localObject2).o = ((RespEncounterInfo)localObject1).enc_id;
      ((ProfileActivity.AllInOne)localObject2).p = ((RespEncounterInfo)localObject1).uid;
      if (QLog.isDevelopLevel()) {
        QLog.d("fight_accost", 4, "附近人列表accost_uin = " + ((ProfileActivity.AllInOne)localObject2).jdField_a_of_type_JavaLangString + "accost_sig = " + ((ProfileActivity.AllInOne)localObject2).jdField_b_of_type_ArrayOfByte);
      }
      ((ProfileActivity.AllInOne)localObject2).f = 103;
      ((ProfileActivity.AllInOne)localObject2).g = 5;
      localObject3 = new Intent(this, NearbyPeopleProfileActivity.class);
      ((Intent)localObject3).putExtra("AllInOne", (Parcelable)localObject2);
      ((Intent)localObject3).addFlags(536870912);
      ((Intent)localObject3).putExtra("param_mode", 3);
      ((Intent)localObject3).putExtra("param_tiny_id", ((RespEncounterInfo)localObject1).tiny_id);
      startActivity((Intent)localObject3);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        VipUtils.a((AppInterface)localObject2, "Vip_MapRoam", "0X8004A34", "0X8004A34", 0, 0, new String[] { localObject1 });
        NearbyFragment.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramViewHolder.jdField_b_of_type_AndroidWidgetTextView, false);
        return;
      }
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "onMapScrollEnd to refresh bubble view");
    }
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
    } while (paramInt != 0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 1) {}
    do
    {
      do
      {
        return;
      } while (paramInt1 != 0);
      paramAbsListView = ((ListView)paramAbsListView).getChildAt(0);
    } while (paramAbsListView == null);
    paramInt1 = Math.abs(paramAbsListView.getTop());
    paramInt2 = getResources().getDimensionPixelOffset(2131493280) - getResources().getDimensionPixelOffset(2131493282);
    if (paramInt1 >= paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setBackgroundAlpha(1.0F);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    float f1 = paramInt1 * 1.0F / paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setBackgroundAlpha(f1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(SingleLineTextView paramSingleLineTextView, int paramInt, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(1, String.valueOf(paramInt), 200, true, true);
    }
    paramBitmap = new StatableBitmapDrawable(getResources(), localBitmap, false, false);
    if (this.n == 0) {
      this.n = ((int)(paramSingleLineTextView.a() * 1.1F + 0.5F));
    }
    paramBitmap.setBounds(0, 0, this.n, this.n);
    paramSingleLineTextView.setCompoundDrawables(paramBitmap, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "showSecurityTips strSecurityTips=" + paramString1 + " strSecurityDetailUrl=" + paramString2);
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getApplication(), 230);
      localQQCustomDialog.setTitle("温馨提示");
      localQQCustomDialog.getMessageTextView().setVisibility(8);
      TextView localTextView = localQQCustomDialog.getMessageTextView_Plain_Text();
      localTextView.setVisibility(0);
      SpannableString localSpannableString = new SpannableString(paramString1 + "了解更多");
      localSpannableString.setSpan(new URLSpan(paramString2), paramString1.length(), localSpannableString.length(), 18);
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), paramString1.length(), localSpannableString.length(), 33);
      localTextView.setText(localSpannableString);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localQQCustomDialog.setNegativeButton(2131367263, new tcf(this, localQQCustomDialog));
      localQQCustomDialog.show();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "getMapRoamList last request is in process... return");
      }
      return;
    }
    if (!paramBoolean1) {
      a(true);
    }
    int i3 = c();
    byte b5 = (byte)this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.m;
    byte b6 = (byte)this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l;
    int i2 = 480;
    int i1;
    label79:
    byte b3;
    byte b4;
    byte b1;
    byte b2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 3)
    {
      i1 = 480;
      b3 = 0;
      b4 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_k_of_type_Int != 0) {
        break label336;
      }
      b1 = 0;
      b2 = 0;
      label100:
      this.jdField_c_of_type_Boolean = true;
      if (!paramBoolean2) {
        break label475;
      }
    }
    label336:
    label475:
    for (i2 = 1;; i2 = 0)
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(i3, paramBoolean1, null, this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint, i2, b5, b6, i1, b1, b2, this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.n, ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.d[0]), ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.d[1]), ConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.d[2]), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint, null, null, 0L, (byte)0, false, null, 0, 0L);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VipMapRoamActivity", 2, "getMapRoamList mRequestId=" + this.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 0)
      {
        i1 = 30;
        break label79;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 1)
      {
        i1 = 60;
        break label79;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int == 2)
      {
        i1 = 240;
        break label79;
      }
      i1 = i2;
      if (!QLog.isColorLevel()) {
        break label79;
      }
      QLog.d("VipMapRoamActivity", 2, "getMapRoamList time is unknown mFilter.time=" + this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_j_of_type_Int);
      i1 = i2;
      break label79;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_k_of_type_Int == 1)
      {
        b1 = 18;
        b2 = 22;
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_k_of_type_Int == 2)
      {
        b1 = 23;
        b2 = 26;
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_k_of_type_Int == 3)
      {
        b1 = 27;
        b2 = 35;
        break label100;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_k_of_type_Int == 4)
      {
        b1 = 36;
        b2 = Byte.MAX_VALUE;
        break label100;
      }
      b1 = b3;
      b2 = b4;
      if (!QLog.isColorLevel()) {
        break label100;
      }
      QLog.d("VipMapRoamActivity", 2, "getMapRoamList agetype is unknown mFilter.age=" + this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.jdField_k_of_type_Int);
      b1 = b3;
      b2 = b4;
      break label100;
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.dispatchTouchEvent(paramMotionEvent);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getScrollY() >= 0) {
        break label83;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 0) {
        this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(8);
      }
    }
    for (;;)
    {
      return false;
      label83:
      if (this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 8) {
        this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(0);
      }
    }
  }
  
  protected void b(GeoPoint paramGeoPoint)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "markCurrentPosition Lat=" + paramGeoPoint.getLatitudeE6() + ",Lng=" + paramGeoPoint.getLongitudeE6());
    }
    paramGeoPoint = new MapView.LayoutParams(-2, -2, paramGeoPoint, 17);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837951);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView);
    localObject = new ImageView(this);
    ((ImageView)localObject).setImageResource(2130837950);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.addView(localRelativeLayout, paramGeoPoint);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 17432576);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(800L);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler;
    if (paramBoolean1) {}
    for (int i1 = 0;; i1 = 200)
    {
      localObject = ((VipMapRoamActivity.UiHandler)localObject).obtainMessage(100, i1, 0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null)
    {
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i)
      {
      case 0: 
      default: 
        return 0;
      case 1: 
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  public void c(GeoPoint paramGeoPoint) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == jdField_j_of_type_Int) {
      if (paramInt2 == -1)
      {
        localObject1 = new NearPeopleFilterActivity.NearPeopleFilters();
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).i = paramIntent.getIntExtra("gender", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).jdField_j_of_type_Int = paramIntent.getIntExtra("time", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).jdField_k_of_type_Int = paramIntent.getIntExtra("age", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).m = paramIntent.getIntExtra("xingzuo", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).l = paramIntent.getIntExtra("interest", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).n = paramIntent.getIntExtra("key_career", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).d[0] = paramIntent.getStringExtra("key_hometown_country");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).d[1] = paramIntent.getStringExtra("key_hometown_province");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).d[2] = paramIntent.getStringExtra("key_hometown_city");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_hometown_string");
        if (!fileList().equals(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters)) {
          ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = ((NearPeopleFilterActivity.NearPeopleFilters)localObject1);
        a(true, true);
      }
    }
    do
    {
      do
      {
        do
        {
          ArrayList localArrayList;
          do
          {
            int i1;
            do
            {
              byte b1;
              byte b2;
              byte b3;
              int i2;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (paramInt1 != jdField_k_of_type_Int) {
                        break;
                      }
                    } while (paramInt2 != -1);
                    localObject2 = paramIntent.getStringExtra("param_nickname");
                    b1 = paramIntent.getByteExtra("param_gender", (byte)-1);
                    paramInt1 = paramIntent.getIntExtra("param_age", 0);
                    paramInt2 = paramIntent.getIntExtra("param_career", 0);
                    i1 = paramIntent.getIntExtra("param_interest_filter_type", 0);
                    b2 = paramIntent.getByteExtra("param_constellation", (byte)0);
                    b3 = paramIntent.getByteExtra("param_marital_status", (byte)0);
                    i2 = paramIntent.getIntExtra("param_photo_count", 0);
                    localObject1 = paramIntent.getParcelableArrayListExtra("param_interest");
                  } while ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() <= 0));
                  paramIntent = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.get(0);
                } while ((paramIntent == null) || (!(paramIntent instanceof RespEncounterInfo)));
                paramIntent = (RespEncounterInfo)paramIntent;
              } while ((paramIntent.lEctID <= 0L) || (!getAppInterface().a().equals(String.valueOf(paramIntent.lEctID))));
              paramIntent.strNick = ((String)localObject2);
              paramIntent.cSex = b1;
              paramIntent.cAge = ((byte)paramInt1);
              paramIntent.profession_id = paramInt2;
              paramIntent.constellation = b2;
              paramIntent.marriage = b3;
              paramIntent.nFaceNum = i2;
            } while ((i1 == 0) || (i1 != this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l));
            Object localObject2 = new appoint_define.InterestTag();
            ((appoint_define.InterestTag)localObject2).uint32_tag_type.set(i1);
            localArrayList = new ArrayList();
            if (localObject1 != null)
            {
              paramInt1 = 0;
              while (paramInt1 < ((List)localObject1).size())
              {
                localObject3 = (InterestTagInfo)((List)localObject1).get(paramInt1);
                appoint_define.InterestItem localInterestItem = new appoint_define.InterestItem();
                localInterestItem.uint64_tag_id.set(paramInt1);
                localInterestItem.str_tag_name.set(((InterestTagInfo)localObject3).tagName);
                localArrayList.add(localInterestItem);
                paramInt1 += 1;
              }
            }
            ((appoint_define.InterestTag)localObject2).rpt_msg_tag_list.set(localArrayList);
            localObject1 = new appoint_define.RptInterestTag();
            Object localObject3 = new ArrayList();
            ((List)localObject3).add(localObject2);
            ((appoint_define.RptInterestTag)localObject1).rpt_interest_tags.set((List)localObject3);
            paramIntent.vInterestInfo = ((appoint_define.RptInterestTag)localObject1).toByteArray();
          } while ((this.jdField_k_of_type_Boolean) || (localArrayList.size() <= 0));
          a(true, true);
          return;
        } while ((paramInt1 != 11) || (paramInt2 != -1) || (paramIntent == null));
        localObject1 = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
        paramInt1 = paramIntent.getIntExtra("interest_tag_type", 0);
      } while ((localObject1 == null) || (((ArrayList)localObject1).size() == 0) || (paramInt1 < 1) || (paramInt1 > 7));
      if (!NetworkUtil.e(getActivity()))
      {
        a(2, 2131369008, 0);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler == null);
    paramIntent = new InterestTag(paramInt1);
    paramIntent.a.addAll((Collection)localObject1);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(paramIntent);
    a(0, "正在添加...", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a((List)localObject1, 1, 0);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "doOnCreate VipMapRoam");
    }
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2130904553);
    paramBundle = findViewById(2131303156);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramBundle.setFitsSystemWindows(true);
    }
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), true);
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler = ((NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener);
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = a(getIntent());
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler != null) && (NetworkUtil.e(getApplication())))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a();
      NearbyAppInterface localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {
        break label322;
      }
      paramBundle = "1";
      label194:
      VipUtils.a(localNearbyAppInterface, "Vip_MapRoam", "0X8004A2E", "0X8004A2E", 0, 0, new String[] { paramBundle });
      this.i = getIntent().getBooleanExtra("abp_flag", false);
      this.jdField_j_of_type_Boolean = getIntent().getBooleanExtra("is_from_web", false);
      if ((!this.jdField_j_of_type_Boolean) || (this.i)) {
        break label329;
      }
      setLeftViewName(2131366637);
    }
    for (;;)
    {
      ViewExposeUtil.a(getAppInterface(), getClass(), hashCode(), "0X80057C2", 0);
      return true;
      if (NetworkUtil.e(getApplication())) {
        break;
      }
      QQToast.a(getApplication(), getString(2131367256), 0).b(getTitleBarHeight());
      break;
      label322:
      paramBundle = "0";
      break label194;
      label329:
      if (this.i) {
        setLeftViewName(2131369273);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMaproamActivityVipMapRoamActivity$UiHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.b(this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.destroy();
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onDestroy();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    ViewExposeUtil.ViewExposeUnit localViewExposeUnit = ViewExposeUtil.a(getClass(), hashCode());
    if (localViewExposeUnit != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - localViewExposeUnit.jdField_b_of_type_Long), "", "", "");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onPause();
    }
    if ((this.jdField_d_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_d_of_type_AndroidWidgetImageView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "doOnPause clear mCurrentPositionAnim");
      }
      this.jdField_d_of_type_AndroidViewAnimationAnimation.cancel();
      this.jdField_d_of_type_AndroidWidgetImageView.clearAnimation();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onResume();
    if ((this.jdField_d_of_type_AndroidViewAnimationAnimation != null) && (this.jdField_d_of_type_AndroidWidgetImageView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipMapRoamActivity", 2, "doOnResume restart mCurrentPositionAnim");
      }
      this.jdField_d_of_type_AndroidViewAnimationAnimation.reset();
      this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.onStop();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 2130968647);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(0);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 2130968649);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(0);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getApplication(), 2130968648);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar = ((RoamLocalSearchBar)findViewById(2131303158));
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver, this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.findViewById(2131303174));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303159));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131303169));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131303170));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131303171));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131303172));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131303157));
    this.jdField_a_of_type_ComTencentWidgetXListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903729, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837958);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2130904554, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303160));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303168));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131303169));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131303170));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131303171));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131303172));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView = ((RoamingMapView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303161));
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(1);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setOnTouchListener(new tcd(this));
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getController();
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMaxZoomLevel() - 1);
    Object localObject = getIntent();
    if (localObject != null)
    {
      i1 = ((Intent)localObject).getIntExtra("lat", 0);
      i2 = ((Intent)localObject).getIntExtra("lon", 0);
      if ((Integer.MIN_VALUE != i1) && (Integer.MIN_VALUE != i2) && (i1 != 0) && (i2 != 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = new GeoPoint(i1, i2);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar = ((RoamLocalSearchBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303162));
    this.jdField_b_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303163));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303164));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303165));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303167);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303166));
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130904246, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301964);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301965);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301966);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_e_of_type_AndroidViewView.findViewById(2131302091));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302091));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter = new PeopleAroundAdapter(this, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder, false, this, this.jdField_a_of_type_ComTencentWidgetXListView);
    localObject = getLayoutInflater().inflate(2130904263, null);
    int i1 = getResources().getDimensionPixelOffset(2131493280);
    int i2 = getResources().getDimensionPixelOffset(2131493281);
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, getWindowManager().getDefaultDisplay().getHeight() - i2 - i1));
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.post(new tch(this));
  }
  
  public void finish()
  {
    super.finish();
    if (this.i) {
      overridePendingTransition(2130968587, 2130968588);
    }
  }
  
  public void g()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("switchMapMode current mode=");
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
      {
        localObject = "active mode";
        QLog.d("VipMapRoamActivity", 2, (String)localObject);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView == null) || (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() != 1)) {
        break label211;
      }
      localObject = new ValueAnimation(Integer.valueOf(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()), Integer.valueOf(getResources().getDimensionPixelSize(2131493280)), null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(0);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamLocalSearchBar.setBackgroundAlpha(0.0F);
      ((ValueAnimation)localObject).setDuration(300L);
      ((ValueAnimation)localObject).setAnimationListener(this);
      ((ValueAnimation)localObject).a(new tcg(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject);
      label211:
      do
      {
        return;
        localObject = "thumbnail mode";
        break;
        localObject = findViewById(16908290);
      } while (localObject == null);
      localObject = new ValueAnimation(Integer.valueOf(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()), Integer.valueOf(((View)localObject).getHeight()), null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.setMapMode(1);
    }
  }
  
  protected String getModuleId()
  {
    return "module_nearby";
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipMapRoamActivity", 2, "updateFilterBar");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.toString());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.toString());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("VipMapRoamActivity", 2, "updateFilterBar exception msg=" + localException.getMessage());
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onAnimationEnd mapview is ");
      if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
      {
        str = "active mode";
        QLog.d("VipMapRoamActivity", 2, str);
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation != paramAnimation) {
        break label83;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    label83:
    label152:
    do
    {
      do
      {
        do
        {
          return;
          str = "thumbnail mode";
          break;
          if (this.jdField_b_of_type_AndroidViewAnimationAnimation == paramAnimation)
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            return;
          }
        } while (!(paramAnimation instanceof ValueAnimation));
        if (QLog.isColorLevel()) {
          QLog.d("VipMapRoamActivity", 2, "onAnimationEnd switch map mode end");
        }
        if (1 != this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a()) {
          break label152;
        }
      } while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (((this.jdField_a_of_type_AndroidViewAnimationAnimation == paramAnimation) || (this.jdField_b_of_type_AndroidViewAnimationAnimation == paramAnimation)) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.i)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.i);
      localIntent.setFlags(603979776);
      localIntent.putExtra("TAB", 3);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof PeopleAroundAdapter.ViewHolder)))
    {
      a((PeopleAroundAdapter.ViewHolder)paramView.getTag());
      return;
    }
    NearbyAppInterface localNearbyAppInterface;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301965: 
      localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {
        break;
      }
    case 2131302091: 
    case 2131303167: 
    case 2131303172: 
    case 2131303174: 
    case 2131302093: 
    case 2131303171: 
      for (paramView = "1";; paramView = "0")
      {
        VipUtils.a(localNearbyAppInterface, "Vip_MapRoam", "0X8004A36", "0X8004A36", 0, 0, new String[] { paramView });
        if (NetworkUtil.e(getApplication())) {
          break;
        }
        a(1, getString(2131369008));
        return;
        paramView = new Intent(this, ChooseInterestTagActivity.class);
        paramView.putExtra("interest_tag_type", this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l);
        paramView.putExtra("is_from_judge", false);
        paramView.putExtra("from_where", "VipMapRoamActivity");
        startActivityForResult(paramView, 11);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 1)
        {
          onBackEvent();
          return;
        }
        g();
        return;
        NearPeopleFilterActivity.a(this, null, this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters, jdField_j_of_type_Int);
        localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {}
        for (paramView = "1";; paramView = "0")
        {
          VipUtils.a(localNearbyAppInterface, "Vip_MapRoam", "0X8004A33", "0X8004A33", 0, 0, new String[] { paramView });
          return;
        }
      }
      a(false, true);
      return;
    }
    if (this.m == 100500)
    {
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        paramView = getResources().getString(2131371215);
        Utils.a(this, 2131367535, paramView, new tcj(this), null);
        localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {
          break label425;
        }
      }
      label425:
      for (paramView = "1";; paramView = "0")
      {
        VipUtils.a(localNearbyAppInterface, "Vip_MapRoam", "0X8004A30", "0X8004A30", 0, 0, new String[] { paramView });
        return;
        paramView = this.jdField_e_of_type_JavaLangString;
        break;
      }
    }
    if (this.m == 100501)
    {
      QQToast.a(getApplication(), this.jdField_e_of_type_JavaLangString, 0).b(getTitleBarHeight());
      localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {}
      for (paramView = "1";; paramView = "0")
      {
        VipUtils.a(localNearbyAppInterface, "Vip_MapRoam", "0X8004A30", "0X8004A30", 0, 0, new String[] { paramView });
        return;
      }
    }
    if (!NetworkUtil.e(getApplication()))
    {
      QQToast.a(getApplication(), getString(2131367256), 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint = this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.getMapCenter();
    if ((this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() != 0) && (this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() != 0))
    {
      a(true, true);
      localNearbyAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()) {
        break label680;
      }
    }
    label680:
    for (paramView = "1";; paramView = "0")
    {
      VipUtils.a(localNearbyAppInterface, "Vip_MapRoam", "0X8004A32", "0X8004A32", 0, 0, new String[] { paramView });
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VipMapRoamActivity", 2, "get roamPoint error mRoamPoint,lat=" + this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() + ",lng=" + this.jdField_b_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6());
      break;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView != null) && (this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamingMapView.a() == 0))
    {
      g();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)getAppInterface());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\maproam\activity\VipMapRoamActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */