package com.tencent.mobileqq.fragment;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NeighborComm.RespHeader;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.config.NearbyDataManager.INearbyBannerListener;
import com.tencent.mobileqq.dating.AnchorageManager;
import com.tencent.mobileqq.dating.AnchorageManager.Anchorage;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearpeople.EncounterHolder;
import com.tencent.mobileqq.nearpeople.EncounterHolder.EncounterHolderOpt;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.lbs.NearbyProtocolCoder;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import snm;
import sno;
import snp;
import snq;
import snr;
import sns;
import snt;
import snu;
import snv;
import snw;
import snx;
import sny;
import snz;
import sod;
import soe;
import sof;
import tencent.im.oidb.cmd0x683.cmd0x683.GodInfo;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListInfo;

public class NearbyFragment
  extends NearbyBaseFragment
  implements View.OnClickListener, NearbyDataManager.INearbyBannerListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener
{
  public static final int a = 2;
  public static final long a = 1000L;
  public static final int c = 3;
  public static final int d = 4;
  public static final boolean d;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int m = 11;
  public static final int n = 12;
  public static final int o = 1;
  static final int p = 5000;
  private static final int z = 101;
  private int A;
  private int B;
  private double jdField_a_of_type_Double;
  public Dialog a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new snm(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public NearPeopleFilterActivity.NearPeopleFilters a;
  public PeopleAroundAdapter a;
  NearbyHandler jdField_a_of_type_ComTencentMobileqqAppNearbyHandler;
  NearbyObserver jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new snz(this);
  public NearbyDataManager a;
  public NearbyUserBehaviorReport a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public IIconDecoder.IIconListener a;
  IIconDecoder jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder;
  public PullRefreshHeader a;
  public ActionSheet a;
  public ListView a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new snr(this);
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  public ArrayList a;
  public List a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new sns(this);
  public cmd0x683.RankListInfo a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private double jdField_b_of_type_Double = 15.0D;
  public long b;
  public Dialog b;
  protected View b;
  SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public long c;
  View c;
  public long d;
  View d;
  long jdField_e_of_type_Long = 0L;
  View jdField_e_of_type_AndroidViewView;
  public boolean e;
  private long jdField_f_of_type_Long;
  View jdField_f_of_type_AndroidViewView;
  public boolean f;
  View g;
  public boolean g;
  View h;
  public boolean h;
  public boolean i = false;
  public boolean l = false;
  boolean m = false;
  private boolean n = true;
  public int q = 4;
  protected int r;
  public int s;
  public int t;
  int u = 0;
  int v = -1;
  public int w = 0;
  public int x = 0;
  private int y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (Build.VERSION.SDK_INT >= 16) {}
    for (bool = true;; bool = false)
    {
      jdField_d_of_type_Boolean = bool;
      return;
    }
  }
  
  public NearbyFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener = new sny(this);
    this.jdField_a_of_type_TencentImOidbCmd0x683Cmd0x683$RankListInfo = null;
    this.jdField_b_of_type_Int = 0;
  }
  
  private NearPeopleFilterActivity.NearPeopleFilters a(boolean paramBoolean)
  {
    int i1 = 0;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    int k;
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getStringExtra("filter"));
      if (this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a() == 0) {
        break label296;
      }
      int i2 = ((Intent)localObject1).getIntExtra("filterGender", 0);
      int i3 = ((Intent)localObject1).getIntExtra("filter_time", 0);
      int i4 = ((Intent)localObject1).getIntExtra("filter_age", 0);
      int i5 = ((Intent)localObject1).getIntExtra("filter_xingzuo", 0);
      k = ((Intent)localObject1).getIntExtra("filter_interest", 0);
      int i6 = ((Intent)localObject1).getIntExtra("filter_career", 0);
      localObject3 = ((Intent)localObject1).getStringExtra("filter_location");
      localObject2 = new NearPeopleFilterActivity.NearPeopleFilters();
      ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).i = i2;
      ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).j = i3;
      ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).k = i4;
      ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).m = i5;
      ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).n = i6;
      if ((k >= 0) && (k <= NearPeopleFilterActivity.NearPeopleFilters.b.length - 1)) {
        break label409;
      }
      k = 0;
    }
    label289:
    label296:
    label364:
    label397:
    label409:
    for (;;)
    {
      ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).l = k;
      localObject1 = new String[5];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
      localObject1[4] = "不限";
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      if (localObject1.length >= 4)
      {
        k = i1;
        while (k < 4)
        {
          ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).d[k] = localObject1[k];
          k += 1;
        }
        localObject1 = new Intent();
        break;
        if (localObject1.length < 5) {
          break label289;
        }
        localObject1 = localObject1[4];
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      }
      do
      {
        return (NearPeopleFilterActivity.NearPeopleFilters)localObject2;
        localObject1 = "不限";
        break;
        if (!paramBoolean) {
          break label364;
        }
        localObject1 = NearPeopleFilterActivity.NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject1 = new NearPeopleFilterActivity.NearPeopleFilters();
      if (this.v >= 0) {}
      for (k = this.v;; k = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_gender", Integer.valueOf(0))).intValue())
      {
        this.v = (k - 1);
        if (this.v != 0) {
          break label397;
        }
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).i = 2;
        return (NearPeopleFilterActivity.NearPeopleFilters)localObject1;
        localObject1 = null;
        break;
      }
      ((NearPeopleFilterActivity.NearPeopleFilters)localObject1).i = 0;
      return (NearPeopleFilterActivity.NearPeopleFilters)localObject1;
    }
  }
  
  private List a()
  {
    RespEncounterInfo localRespEncounterInfo = null;
    Object localObject = NearPeopleFilterActivity.NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), "nearpeople_filters_result");
    if ((localObject != null) && (((NearPeopleFilterActivity.NearPeopleFilters)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters))) {}
    for (boolean bool = true;; bool = false)
    {
      NearbyUtils.a("Q.nearby", "initNearbyDataWithCache", new Object[] { "cache", Boolean.valueOf(bool) });
      localObject = localRespEncounterInfo;
      Object[] arrayOfObject;
      ArrayList localArrayList;
      if (bool)
      {
        arrayOfObject = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() + "v5.3.nb", new Class[] { Object.class, Long.class, Boolean.class });
        localObject = localRespEncounterInfo;
        if (arrayOfObject != null)
        {
          localObject = (List)arrayOfObject[0];
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label433;
          }
          localArrayList = new ArrayList(((List)localObject).size());
          localArrayList.addAll(EncounterHolder.getEncHolderOpts((List)localObject));
          Iterator localIterator = ((List)localObject).iterator();
          localObject = localArrayList;
          if (localIterator.hasNext())
          {
            localObject = localIterator.next();
            if (!(localObject instanceof EncounterHolder)) {
              break label428;
            }
            localRespEncounterInfo = ((EncounterHolder)localObject).encounter;
            label220:
            if ((localRespEncounterInfo == null) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), String.valueOf(localRespEncounterInfo.lEctID)))) {
              break label431;
            }
            localObject = NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount());
            long l1 = ((Long)localObject[0]).longValue();
            int k = ((Integer)localObject[1]).intValue();
            NearbyUtils.a("Q.nearby", "initNearbyPeople", new Object[] { "update vote", Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(localRespEncounterInfo.iVoteNum), Integer.valueOf(localRespEncounterInfo.iVoteIncrement) });
            localObject = localArrayList;
            if (l1 >= localRespEncounterInfo.iVoteNum)
            {
              localRespEncounterInfo.iVoteNum = ((int)l1);
              localRespEncounterInfo.iVoteIncrement = k;
            }
          }
        }
      }
      label428:
      label431:
      label433:
      for (localObject = localArrayList;; localObject = null)
      {
        this.jdField_b_of_type_Long = ((Long)arrayOfObject[1]).longValue();
        this.i = ((Boolean)arrayOfObject[2]).booleanValue();
        NearbyUtils.a("Q.nearby", "initNearbyDataWithCache", new Object[] { "file cache size: " + arrayOfObject.length });
        return (List)localObject;
        localRespEncounterInfo = null;
        break label220;
        break;
      }
    }
  }
  
  private void a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.inflate(2130904320, this.jdField_a_of_type_ComTencentWidgetListView, false));
    this.jdField_h_of_type_AndroidViewView = paramLayoutInflater.inflate(2130903500, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)paramLayoutInflater.inflate(2130903729, this.jdField_a_of_type_ComTencentWidgetListView, false));
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.inflate(2130904246, null);
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface, View paramView, boolean paramBoolean)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof Integer))) {}
    for (int k = ((Integer)paramView).intValue();; k = 0)
    {
      if (k <= 0) {
        return;
      }
      if (paramBoolean) {}
      for (int i1 = 0;; i1 = 1)
      {
        paramNearbyAppInterface.c("CliOper", "", "", "0X8005DEC", "0X8005DEC", k, 0, Integer.toString(i1), "", "", "");
        return;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private boolean a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getByteArrayExtra("respHeader");
    Object localObject2 = paramIntent.getByteArrayExtra("respGetEncounter");
    FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramIntent.getParcelableExtra("FromServiceMsg");
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramIntent.getParcelableExtra("ToServiceMsg");
    if ((localObject1 == null) || (localObject2 == null) || (localFromServiceMsg == null) || (localToServiceMsg == null)) {
      return false;
    }
    paramIntent = new JceInputStream((byte[])localObject1);
    paramIntent.setServerEncoding("utf-8");
    localObject1 = new RespHeader();
    ((RespHeader)localObject1).readFrom(paramIntent);
    paramIntent = new JceInputStream((byte[])localObject2);
    paramIntent.setServerEncoding("utf-8");
    localObject2 = new RespGetEncounterV2();
    ((RespGetEncounterV2)localObject2).readFrom(paramIntent);
    if ((localObject1 == null) || (localObject2 == null)) {
      return false;
    }
    if (((RespGetEncounterV2)localObject2).stUserData != null)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a.a("EncounterSvc.ReqGetEncounter");
      if ((paramIntent instanceof NearbyProtocolCoder))
      {
        ((NearbyProtocolCoder)paramIntent).a[0] = ((RespGetEncounterV2)localObject2).stUserData;
        if (NearbyUtils.b())
        {
          paramIntent = ((NearbyProtocolCoder)paramIntent).a[0];
          if (paramIntent != null) {
            break label327;
          }
        }
      }
    }
    label327:
    for (paramIntent = "user data is null";; paramIntent = paramIntent.strProvince)
    {
      NearbyUtils.a("NearbyFragment", new Object[] { "initWithPreloadData", Integer.valueOf(0), paramIntent });
      localToServiceMsg.extraData.setClassLoader(DatingFilters.class.getClassLoader());
      this.jdField_c_of_type_Long = localToServiceMsg.extraData.getLong("requestId");
      localToServiceMsg.extraData.putBoolean("isPreloadData", true);
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(localFromServiceMsg, localToServiceMsg, new Object[] { localObject1, localObject2 });
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
      NearbyUtils.a("Q.nearby", "initWithPreloadData", new Object[0]);
      return true;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler = ((NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3));
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b(true);
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager = ((NearbyDataManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(209));
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(false);
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    SingleLineTextView localSingleLineTextView = (SingleLineTextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302312);
    localSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841169);
    localSingleLineTextView.setCompoundDrawablePadding(AIOUtils.a(1.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.jdField_h_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetListView.a(this.jdField_h_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131301964);
    this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131301965);
    this.jdField_f_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131301966);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_f_of_type_AndroidViewView.findViewById(2131302091));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131302092));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.b(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter = new PeopleAroundAdapter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder, false, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollChangeListener(this);
    g();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 4)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyFragment", 2, "show pushbanner,remove god layout");
      }
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131371842);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131371844);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new sof(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new sno(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void m()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(101, 1000L);
  }
  
  private void n()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
  }
  
  private void o()
  {
    Object localObject = BaseApplicationImpl.getContext();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyFragemnt", 2, "BaseApplicationImpl.getContext() is null!!!!");
      }
      return;
    }
    localObject = FileUtils.a(((BaseApplication)localObject).getFileStreamPath(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() + "v5.8.gods"));
    cmd0x683.RankListInfo localRankListInfo;
    if ((localObject != null) && (localObject.length > 0)) {
      localRankListInfo = new cmd0x683.RankListInfo();
    }
    try
    {
      localRankListInfo.mergeFrom((byte[])localObject);
      this.jdField_a_of_type_TencentImOidbCmd0x683Cmd0x683$RankListInfo = localRankListInfo;
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
      NearbyUtils.a("Q.nearby", "initOtherDataWithCache", new Object[0]);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  private void p()
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Object.class;
    Object[] arrayOfObject = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() + "entered_ids", arrayOfClass);
    if ((arrayOfObject != null) && (arrayOfObject.length == arrayOfClass.length))
    {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)arrayOfObject[0]);
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break label107;
        }
        QLog.i("Q.dynamicAvatar", 2, "initEnteredProfileIds: " + this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    return;
    label107:
    QLog.i("Q.dynamicAvatar", 2, "initEnteredProfileIds is empty.");
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int k = 0;
    Object localObject1;
    Object localObject2;
    if (k < i1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(k);
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getTag();
        if ((localObject1 instanceof PeopleAroundAdapter.ViewHolder))
        {
          localObject1 = (PeopleAroundAdapter.ViewHolder)localObject1;
          localObject2 = ((PeopleAroundAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangObject;
          if (!((Boolean)((PeopleAroundAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getTag()).booleanValue()) {
            break label90;
          }
        }
      }
    }
    label90:
    label292:
    for (;;)
    {
      k += 1;
      break;
      if ((localObject2 instanceof RespEncounterInfo))
      {
        localObject1 = (RespEncounterInfo)localObject2;
        if (((RespEncounterInfo)localObject1).tiny_id > 0L) {
          localObject1 = String.valueOf(((RespEncounterInfo)localObject1).tiny_id);
        }
        for (;;)
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label292;
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
          break;
          if (((RespEncounterInfo)localObject1).lEctID > 0L)
          {
            localObject1 = String.valueOf(((RespEncounterInfo)localObject1).lEctID);
            continue;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() == 0)
            {
              localObject1 = "actNearByFaceAllShowCost";
              k = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
              if (k == 1) {
                localObject1 = "actNearByFaceAllShowCostWIFI";
              }
              for (;;)
              {
                StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), (String)localObject1, true, 0L, 0L, null, "");
                if (QLog.isColorLevel()) {
                  QLog.i("NearByFragment", 2, "startFacesStat.face all show cost=0");
                }
                this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
                this.jdField_e_of_type_Long = 0L;
                return;
                if (k == 2) {
                  localObject1 = "actNearByFaceAllShowCost2G";
                } else if (k == 3) {
                  localObject1 = "actNearByFaceAllShowCost3G";
                } else if (k == 4) {
                  localObject1 = "actNearByFaceAllShowCost4G";
                }
              }
            }
            this.jdField_e_of_type_Long = System.currentTimeMillis();
          }
          else
          {
            localObject1 = null;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.getCount() <= 1) || (this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a()) || (this.jdField_e_of_type_AndroidViewView.getVisibility() != 0) || (!this.jdField_h_of_type_Boolean) || (this.w == 1) || (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity))) {}
    do
    {
      return;
      c(false, true);
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport == null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(3);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFragment", 2, "uin=" + paramString + ", type=" + paramInt2);
    }
    long l2 = System.currentTimeMillis();
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramString);
    Object localObject;
    label125:
    long l1;
    int k;
    if ((this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (this.jdField_b_of_type_JavaUtilArrayList.size() == 0))
    {
      localObject = "actNearByFaceAllShowCost";
      paramInt1 = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
      if (paramInt1 == 1)
      {
        localObject = "actNearByFaceAllShowCostWIFI";
        l1 = 0L;
        if (this.jdField_e_of_type_Long > 0L) {
          l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        }
        if (l1 > 0L)
        {
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), (String)localObject, true, l1, 0L, null, "");
          if (QLog.isColorLevel()) {
            QLog.i("NearByFragment", 2, "onDecodeTaskCompleted.face all show cost=" + l1);
          }
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        this.jdField_e_of_type_Long = 0L;
      }
    }
    else
    {
      k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < k)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        if (localObject == null) {
          break label514;
        }
        localObject = ((View)localObject).getTag();
        if (!(localObject instanceof PeopleAroundAdapter.ViewHolder)) {
          break label514;
        }
        localObject = (PeopleAroundAdapter.ViewHolder)localObject;
        if (!((Boolean)((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getTag()).booleanValue()) {
          break label415;
        }
        if ((paramString == null) || (paramInt2 != ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break label514;
        }
      }
      for (;;)
      {
        l1 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("NearbyFragment", 2, "onDecodeTaskCompleted face ui update cost=" + (l1 - l2) + ",uin=" + paramString);
        return;
        if (paramInt1 == 2)
        {
          localObject = "actNearByFaceAllShowCost2G";
          break label125;
        }
        if (paramInt1 == 3)
        {
          localObject = "actNearByFaceAllShowCost3G";
          break label125;
        }
        if (paramInt1 != 4) {
          break label125;
        }
        localObject = "actNearByFaceAllShowCost4G";
        break label125;
        label415:
        if ((paramString == null) || (paramInt2 != ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break label514;
        }
        if (paramBitmap != null)
        {
          ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.a(new BitmapDrawable(paramBitmap));
          ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setTag(Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d("NearbyFragment", 2, "face updated, uin=" + ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString);
          }
        }
      }
      label514:
      paramInt1 += 1;
    }
  }
  
  void a(ImageView paramImageView, cmd0x683.GodInfo paramGodInfo)
  {
    if ((paramImageView == null) || (paramGodInfo == null)) {}
    do
    {
      return;
      long l1 = paramGodInfo.uint64_tinyid.get();
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 202, Long.toString(l1), 1);
      Drawable localDrawable = paramImageView.getBackground();
      paramImageView.setBackgroundDrawable(localFaceDrawable);
      if ((localDrawable != localFaceDrawable) && ((localDrawable instanceof AsynLoadDrawable))) {
        ((AsynLoadDrawable)localDrawable).a();
      }
      paramImageView.setOnClickListener(this);
      paramImageView.setTag(paramGodInfo);
    } while (!AppSetting.j);
    paramImageView.setContentDescription(paramGodInfo.bytes_nickname.get().toStringUtf8());
  }
  
  void a(NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters)
  {
    if ((paramNearPeopleFilters != null) && (!paramNearPeopleFilters.a())) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(true);
    }
  }
  
  public void a(NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramNearbyMyTabCard.gender == 1) {}
    for (int k = 2131371608;; k = 2131371607)
    {
      this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 2131368213, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(k), 2131367262, 2131368223, new snp(this), new snq(this));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()) {
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.w != paramInt) {
      this.w = paramInt;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.k = paramInt;
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      if (this.y >= 2)
      {
        f();
        n();
      }
      DynamicFaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.a(paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      if (paramInt == 0)
      {
        if (this.y >= 2)
        {
          a();
          m();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null)
        {
          int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
          int k = 0;
          while (k < i1)
          {
            paramAbsListView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(k);
            if (paramAbsListView != null)
            {
              paramAbsListView = paramAbsListView.getTag();
              if ((paramAbsListView instanceof PeopleAroundAdapter.ViewHolder))
              {
                paramAbsListView = (PeopleAroundAdapter.ViewHolder)paramAbsListView;
                Object localObject = paramAbsListView.jdField_a_of_type_JavaLangObject;
                if ((localObject instanceof EncounterHolder.EncounterHolderOpt))
                {
                  localObject = (EncounterHolder.EncounterHolderOpt)localObject;
                  this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(((EncounterHolder.EncounterHolderOpt)localObject).a, paramAbsListView.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView);
                }
              }
            }
            k += 1;
          }
        }
        if ((this.jdField_a_of_type_ComTencentWidgetListView.s() == 0) && (this.jdField_a_of_type_AndroidOsHandler.hasMessages(8)))
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        }
        DynamicFaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(SingleLineTextView paramSingleLineTextView, int paramInt, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(1, String.valueOf(paramInt), 200, true, true);
    }
    paramBitmap = new StatableBitmapDrawable(getResources(), localBitmap, false, false);
    if (this.u == 0) {
      this.u = ((int)(paramSingleLineTextView.a() * 1.1F + 0.5F));
    }
    paramBitmap.setBounds(0, 0, this.u, this.u);
    paramSingleLineTextView.setCompoundDrawables(paramBitmap, null);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
  }
  
  public void a(cmd0x683.RankListInfo paramRankListInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFragment", 2, "updateHeader() start");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NearbyFragment", 2, "updateHeader() return, isShowPushBanner=true");
        return;
        if (this.jdField_a_of_type_TencentImOidbCmd0x683Cmd0x683$RankListInfo != null) {
          this.jdField_a_of_type_TencentImOidbCmd0x683Cmd0x683$RankListInfo = null;
        }
        if ((paramRankListInfo != null) && (paramRankListInfo.rpt_msg_godinfo != null))
        {
          k = paramRankListInfo.rpt_msg_godinfo.size();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager;
          if (k == NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity)) {
            break;
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 4)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        }
      } while (!QLog.isColorLevel());
      Object localObject1 = new StringBuilder().append("updateHeader() return, rankListInfo.size=");
      if (paramRankListInfo == null) {
        k = 0;
      }
      for (;;)
      {
        paramRankListInfo = ((StringBuilder)localObject1).append(k).append(" reqNum=");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager;
        QLog.d("NearbyFragment", 2, NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity));
        return;
        if (paramRankListInfo.rpt_msg_godinfo == null) {
          k = 0;
        } else {
          k = paramRankListInfo.rpt_msg_godinfo.size();
        }
      }
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131493541);
      int i2 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 2.0F);
      localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302309);
      int k = ((LinearLayout)localObject1).getChildCount();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager;
      int i3 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity) + 1 - k;
      if (i3 > 0)
      {
        k = 0;
        while (k < i3)
        {
          localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
          ((ImageView)localObject2).setImageResource(2130837949);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, i1);
          localLayoutParams.weight = 1.0F;
          localLayoutParams.leftMargin = i2;
          ((ImageView)localObject2).setLayoutParams(localLayoutParams);
          ((LinearLayout)localObject1).addView((View)localObject2);
          k += 1;
        }
      }
      i1 = ((LinearLayout)localObject1).getChildCount();
      k = 1;
      while (k < i1)
      {
        a((ImageView)((LinearLayout)localObject1).getChildAt(k), (cmd0x683.GodInfo)paramRankListInfo.rpt_msg_godinfo.get(k - 1));
        k += 1;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302310).setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", "0X80057BB", "0X80057BB", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("NearbyFragment", 2, "updateHeader() set godlayout visible");
        }
      }
      if (paramBoolean)
      {
        paramRankListInfo = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
        paramRankListInfo.setDuration(500L);
        paramRankListInfo.setAnimationListener(new soe(this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(paramRankListInfo);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyFragment", 2, "updateHeader() start anim");
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("NearbyFragment", 2, "updateHeader() end");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyFragment", 2, "doRefreshList() last request is in process... return");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters);
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
    this.jdField_c_of_type_Long = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler, paramBoolean, localNearPeopleFilters, this.s, this.t, this.x);
    DatingUtil.b("doRefreshList", new Object[] { Long.valueOf(this.jdField_c_of_type_Long) });
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.m = paramBoolean2;
    paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFragment", 2, "onUpdatePushBanner() Banner isSuccess : " + paramBoolean1 + " show=" + paramBoolean2);
    }
    int i1 = 0;
    int k = i1;
    if (paramBoolean1)
    {
      k = i1;
      if (paramBoolean2)
      {
        k = 1;
        this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.b();
        k();
      }
    }
    if ((k == 0) && (this.jdField_a_of_type_TencentImOidbCmd0x683Cmd0x683$RankListInfo != null))
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(8)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    label172:
    label181:
    label570:
    label576:
    for (;;)
    {
      return;
      if (this.n)
      {
        this.n = false;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      Object localObject;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        if (this.jdField_e_of_type_Boolean)
        {
          if (this.jdField_g_of_type_AndroidViewView == null) {
            this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getLayoutInflater().inflate(2130904227, null);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.a()))
          {
            localObject = (TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131298153);
            ((TextView)localObject).setText(getString(2131371562));
            ((TextView)localObject).setTextColor(getResources().getColor(2131428302));
            this.jdField_g_of_type_AndroidViewView.findViewById(2131298160).setVisibility(4);
            this.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
            this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.jdField_g_of_type_AndroidViewView);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            if (!paramBoolean1) {
              break label570;
            }
            a(paramNearPeopleFilters);
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) {
          break label576;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.jdField_a_of_type_JavaUtilList, true);
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
        return;
        localObject = (TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131298153);
        ((TextView)localObject).setText(2131372006);
        ((TextView)localObject).setTextColor(getResources().getColor(2131428262));
        this.jdField_g_of_type_AndroidViewView.findViewById(2131298160).setVisibility(0);
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(new sod(this));
        break;
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(null);
        break label172;
        if (!paramBoolean2) {
          break label181;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_h_of_type_Boolean)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          break label181;
        }
        if ((!this.i) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l >= 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l <= 7))
        {
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
            this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230783);
          }
          String str = this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l - 1)];
          localObject = String.format("附近还有更多%s爱好者哦", new Object[] { str });
          str = String.format("编辑%s兴趣,可以查看更多", new Object[] { str });
          if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals(str)) {
            this.jdField_a_of_type_AndroidWidgetButton.setText(str);
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().equals(localObject)) {
            break label181;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          break label181;
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        break label181;
        b(false);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l1 = Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long);
    if ((!this.jdField_g_of_type_Boolean) && (!paramBoolean3) && (paramBoolean1) && (!paramBoolean2) && (l1 >= 0L) && (l1 < 180000L) && (!this.l))
    {
      k = 1;
      if (k == 0) {
        break label101;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getBooleanExtra("IS_HAS_REDTOUCH", false)) {
        break label95;
      }
    }
    label95:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        break label101;
      }
      return;
      k = 0;
      break;
    }
    label101:
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if (paramBoolean2)
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false);
        this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
      }
    }
    for (;;)
    {
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity)) {
        break label172;
      }
      a(paramBoolean1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(true).a(true);
      break;
      b(true);
    }
    label172:
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, 1, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public boolean a()
  {
    boolean bool = false;
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("abp_flag", false);
    }
    if (bool)
    {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, SplashActivity.class);
      localIntent.putExtra("main_tab_id", 4);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
    }
  }
  
  void b(boolean paramBoolean)
  {
    int i1 = 8;
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_e_of_type_AndroidViewView.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131298469);
    if (paramBoolean)
    {
      k = 2131370686;
      localTextView.setText(k);
      if (!paramBoolean) {
        break label99;
      }
      k = 0;
      label69:
      localProgressBar.setVisibility(k);
      if (!paramBoolean) {
        break label106;
      }
    }
    label99:
    label106:
    for (int k = i1;; k = 0)
    {
      localImageView.setVisibility(k);
      return;
      k = 2131368205;
      break;
      k = 8;
      break label69;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean1) {}
    for (int k = 0;; k = 1)
    {
      localObject = ((Handler)localObject).obtainMessage(2, k, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
  }
  
  boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(getClass().getName());
    if (localObject != null)
    {
      NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = (NearPeopleFilterActivity.NearPeopleFilters)((AnchorageManager.Anchorage)localObject).jdField_a_of_type_JavaUtilMap.get("extra_last_filter");
      if ((localNearPeopleFilters == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.equals(localNearPeopleFilters))) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = localNearPeopleFilters;
      this.jdField_a_of_type_ComTencentWidgetListView.onRestoreInstanceState(((AnchorageManager.Anchorage)localObject).jdField_a_of_type_AndroidOsParcelable);
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(((AnchorageManager.Anchorage)localObject).jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.jdField_a_of_type_JavaUtilList, false);
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      localObject = ((AnchorageManager.Anchorage)localObject).jdField_a_of_type_JavaUtilMap;
      this.jdField_b_of_type_Long = ((Long)((Map)localObject).get("extra_last_time")).longValue();
      this.jdField_h_of_type_Boolean = ((Boolean)((Map)localObject).get("extra_has_more")).booleanValue();
      this.i = ((Boolean)((Map)localObject).get("extra_last_alreadyeditinterestflag")).booleanValue();
      return true;
    }
    return false;
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  void g()
  {
    this.k = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", "0X8004440", "0X8004440", 0, 0, "", "", "", "");
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent();
    this.x = localIntent.getIntExtra("neighbor_list_source", 0);
    if ((this.x == 0) && (localIntent.getIntExtra("FROM_WHERE", 0) == 1003)) {
      this.x = 1;
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a("Q.nearby", new Object[] { "initNearbyPeople", Integer.valueOf(this.x) });
    }
    if (localIntent.getBooleanExtra("nearbyDataIsSuc", false)) {
      NearbyUtils.a("Q.nearby", "initNearbyPeople", new Object[] { "hasPreloadData", Boolean.valueOf(true) });
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool3 = ((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "history_valid", Boolean.valueOf(false))).booleanValue();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = a(bool3);
      if ((bool3) && (!bool1)) {}
      for (boolean bool2 = b();; bool2 = false)
      {
        NearbyUtils.a("Q.nearby", "initNearbyPeople", new Object[] { "anchor", Boolean.valueOf(bool2) });
        ThreadManager.a(new snt(this, bool1, localIntent, bool3, bool2), null, true);
        return;
      }
    }
  }
  
  void h()
  {
    ViewExposeUtil.ViewExposeUnit localViewExposeUnit = ViewExposeUtil.a(NearbyFragment.class, hashCode());
    if (localViewExposeUnit != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - localViewExposeUnit.jdField_b_of_type_Long), Integer.toString(PeopleAroundAdapter.h), "", "");
      PeopleAroundAdapter.h = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a(LayoutInflater.from(getActivity()));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      continue;
      j();
      continue;
      int k = this.jdField_a_of_type_ComTencentWidgetListView.s();
      if ((this.w == 0) && (k == 0))
      {
        a(this.jdField_a_of_type_TencentImOidbCmd0x683Cmd0x683$RankListInfo, this.m);
        this.m = false;
      }
      else
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 5000L);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false).a();
        this.jdField_a_of_type_ComTencentWidgetListView.H();
        if (paramMessage.arg1 == 1)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, getString(2131368597), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false).a();
          this.jdField_a_of_type_ComTencentWidgetListView.H();
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131369008), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
            continue;
            paramMessage = (List)paramMessage.obj;
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramMessage);
            if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
              continue;
              this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false).a();
              this.jdField_a_of_type_ComTencentWidgetListView.H();
              IphoneTitleBarActivity localIphoneTitleBarActivity = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
              if (paramMessage.arg1 == 1) {}
              for (paramMessage = getString(2131368230);; paramMessage = getString(2131368220))
              {
                QQToast.a(localIphoneTitleBarActivity, 1, paramMessage, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
                break;
              }
              paramMessage = (List)paramMessage.obj;
              if (paramMessage != null) {
                this.jdField_a_of_type_JavaUtilList.addAll(paramMessage);
              }
              if (this.jdField_a_of_type_JavaUtilList.size() > 0)
              {
                this.jdField_e_of_type_Boolean = true;
                a(true, true, this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters);
              }
              if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
              for (boolean bool = true;; bool = false)
              {
                a(true, false, bool);
                break;
              }
              this.jdField_f_of_type_Boolean = true;
            }
          }
        }
      }
    }
  }
  
  void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("extra_has_more", Boolean.valueOf(this.jdField_h_of_type_Boolean));
      localHashMap.put("extra_last_alreadyeditinterestflag", Boolean.valueOf(this.i));
      localHashMap.put("extra_last_time", Long.valueOf(this.jdField_b_of_type_Long));
      localHashMap.put("extra_last_filter", this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(getClass().getName(), this.jdField_a_of_type_ComTencentWidgetListView.onSaveInstanceState(), this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList, localHashMap);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getBooleanExtra("SHOW_EDIT_TIP", false))
    {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 2131371880, getString(2131371881), 2131371883, 2131371882, new snv(this), new snw(this), false, true);
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing())) {
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    if (paramInt1 == 100) {
      if (paramInt2 == -1)
      {
        localObject = new NearPeopleFilterActivity.NearPeopleFilters();
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).i = paramIntent.getIntExtra("gender", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).j = paramIntent.getIntExtra("time", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).k = paramIntent.getIntExtra("age", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).l = paramIntent.getIntExtra("interest", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).m = paramIntent.getIntExtra("xingzuo", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).n = paramIntent.getIntExtra("key_career", 0);
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).d[0] = paramIntent.getStringExtra("key_hometown_country");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).d[1] = paramIntent.getStringExtra("key_hometown_province");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).d[2] = paramIntent.getStringExtra("key_hometown_city");
        ((NearPeopleFilterActivity.NearPeopleFilters)localObject).jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_hometown_string");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l != ((NearPeopleFilterActivity.NearPeopleFilters)localObject).l)) {
          this.l = false;
        }
        bool = ((NearPeopleFilterActivity.NearPeopleFilters)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters);
        if (!bool) {
          ((NearPeopleFilterActivity.NearPeopleFilters)localObject).jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = ((NearPeopleFilterActivity.NearPeopleFilters)localObject);
        if (this.jdField_f_of_type_Boolean) {
          break label240;
        }
        this.jdField_g_of_type_Boolean = true;
        NearbyUtils.a("NearbyFragment", "onActivityResult, interestTag, mAfterInflate=false.return", new Object[0]);
      }
    }
    label240:
    do
    {
      do
      {
        do
        {
          return;
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            a(true, false, bool);
            return;
          }
          if (paramInt1 != 11) {
            break;
          }
        } while ((paramInt2 != -1) || (paramIntent == null));
        if (!this.jdField_f_of_type_Boolean)
        {
          NearbyUtils.a("NearbyFragment", "onActivityResult, interestTag, mAfterInflate=false.return", new Object[0]);
          return;
        }
        paramIntent.setExtrasClassLoader(getClass().getClassLoader());
        localObject = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
        paramInt1 = paramIntent.getIntExtra("interest_tag_type", 0);
      } while ((localObject == null) || (((ArrayList)localObject).size() == 0) || (paramInt1 < 1) || (paramInt1 > 7));
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity))
      {
        b(2, 2131369008, 0);
        return;
      }
      paramIntent = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    } while (paramIntent == null);
    this.l = false;
    InterestTag localInterestTag = new InterestTag(paramInt1);
    localInterestTag.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
    Object localObject = new ArrayList();
    ((List)localObject).add(localInterestTag);
    a(0, "正在添加...", 0);
    paramIntent.a((List)localObject, 1, 0);
    return;
    int k;
    if (paramInt1 == 1000) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt2 = paramIntent.getByteExtra("param_gender", (byte)-1);
        k = this.v;
        this.v = paramInt2;
        if (!this.jdField_f_of_type_Boolean)
        {
          this.jdField_g_of_type_Boolean = true;
          NearbyUtils.a("NearbyFragment", "onActivityResult, mAfterInflate=false.return", new Object[0]);
          return;
        }
        NearbyUtils.a("NearbyFragment", "onActivityResult, mAfterInflate=true", new Object[0]);
        if ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label716;
        }
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.get(0);
        if (!(paramIntent instanceof RespEncounterInfo)) {
          break label716;
        }
        paramIntent = (RespEncounterInfo)paramIntent;
        if ((paramIntent.lEctID <= 0L) || (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().equals(String.valueOf(paramIntent.lEctID)))) {
          break label716;
        }
      }
    }
    label716:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramIntent = NearPeopleFilterActivity.NearPeopleFilters.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
      if ((paramIntent == null) || ((paramIntent.a()) && (paramInt2 != k)))
      {
        paramIntent = new NearPeopleFilterActivity.NearPeopleFilters();
        if (k == 0)
        {
          paramIntent.i = 2;
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters = paramIntent;
        if (paramInt1 != 0) {
          a(true, false, true);
        }
        ThreadManager.a(new snu(this), 5, null, false);
        return;
        paramIntent.i = 0;
        break;
        c(true, false);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if ((paramView.getTag() instanceof cmd0x683.GodInfo))
      {
        paramView = (cmd0x683.GodInfo)paramView.getTag();
        if (paramView.uint32_gender.get() != 0) {
          break label402;
        }
      }
      break;
    }
    label402:
    for (int k = 0;; k = 1)
    {
      DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, paramView.uint64_tinyid.get(), k, 0, false, false);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", "0X80057BD", "0X80057BD", 0, 0, Long.toString(paramView.uint64_tinyid.get()), "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i == 2) {}
      for (k = 1;; k = 0)
      {
        DatingTopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 0L, k, 0, false, false);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", "0X80057BC", "0X80057BC", 0, 0, "", "", "", "");
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", "0X8005552", "0X8005552", 0, 0, "", "", "", "");
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, ChooseInterestTagActivity.class);
      localIntent.putExtra("interest_tag_type", this.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l);
      localIntent.putExtra("is_from_judge", false);
      localIntent.putExtra("from_where", "NearbyActivity");
      startActivityForResult(localIntent, 11);
      a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
      break;
      l();
      break;
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity))
      {
        QQToast.a(BaseApplication.getContext(), 1, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131369008), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
        return;
      }
      c(false, true);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(3);
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130904237, null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131301927);
    this.jdField_a_of_type_ComTencentWidgetListView = ((FPSXListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297950));
    ((FPSXListView)this.jdField_a_of_type_ComTencentWidgetListView).setActTAG("actFPSNearbyList");
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentWidgetListView.getLayoutParams();
    if (paramLayoutInflater == null) {
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = getResources().getDrawable(2130838317);
      this.jdField_a_of_type_ComTencentWidgetListView.setOverscrollHeader(paramLayoutInflater);
      paramLayoutInflater = getResources().getDrawable(2130837958);
      this.jdField_a_of_type_ComTencentWidgetListView.setContentBackground(paramLayoutInflater, false, false);
      this.jdField_a_of_type_ComTencentWidgetListView.setNeedCheckSpringback(true);
      ThreadManager.a(new snx(this), null, false);
      if (AppSetting.j) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a("我的资料及清除位置等功能");
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.c(getString(2131369273)).a(getString(2131369273), getString(2131372005)).a(true).a(2130838587).a("更多").a(this).a();
      return this.jdField_a_of_type_AndroidViewView;
      paramLayoutInflater.width = -1;
      paramLayoutInflater.height = -1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c) {
      i();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.b(this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.b(this);
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a();
      this.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(null);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {}
    for (LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302309);; localLinearLayout = null)
    {
      if (localLinearLayout != null)
      {
        int i1 = localLinearLayout.getChildCount();
        int k = 1;
        while (k < i1)
        {
          ImageView localImageView = (ImageView)localLinearLayout.getChildAt(k);
          Drawable localDrawable = localImageView.getBackground();
          localImageView.setBackgroundDrawable(null);
          if ((localDrawable instanceof AsynLoadDrawable)) {
            ((AsynLoadDrawable)localDrawable).a();
          }
          k += 1;
        }
      }
      return;
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("FROM_WHERE", 0);
    if (!ViewExposeUtil.a(NearbyFragment.class, hashCode())) {
      ViewExposeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, NearbyFragment.class, hashCode(), "0X8004938", k);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\NearbyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */