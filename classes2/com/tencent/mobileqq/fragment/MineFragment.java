package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.dating.AnchorageManager;
import com.tencent.mobileqq.dating.AnchorageManager.Anchorage;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.dating.RankEventManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager.NotifyListener;
import com.tencent.mobileqq.freshnews.MyFreshNewsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfig;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfigExtraVal;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import smx;
import smy;
import smz;
import sna;
import snb;
import snc;
import snd;
import sne;
import snf;
import sng;
import snh;
import sni;
import snj;
import snk;
import snl;

public class MineFragment
  extends NearbyBaseFragment
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 2;
  static final long jdField_a_of_type_Long = 1000L;
  public static final String a = "MineFragment";
  static final String jdField_b_of_type_JavaLangString = "http://exp.qq.com/ur/?urid=22132";
  static final int jdField_c_of_type_Int = 3;
  private static final String jdField_c_of_type_JavaLangString = "100510.100523";
  static final int jdField_d_of_type_Int = 4;
  static final int jdField_e_of_type_Int = 5;
  static final int jdField_f_of_type_Int = 6;
  static final int g = 7;
  static final int h = 8;
  public Dialog a;
  Button jdField_a_of_type_AndroidWidgetButton;
  GridView jdField_a_of_type_AndroidWidgetGridView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  NearbyObserver jdField_a_of_type_ComTencentMobileqqAppNearbyObserver;
  DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver;
  NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  MineFragment.VisitorHeaderAdapter jdField_a_of_type_ComTencentMobileqqFragmentMineFragment$VisitorHeaderAdapter;
  FreshNewsManager.NotifyListener jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$NotifyListener;
  FreshNewsManager jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
  NearbyUserBehaviorReport jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport;
  public NearbyMyTabCard a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  public PullRefreshHeader a;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public ActionSheet a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  public View c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean;
  View jdField_f_of_type_AndroidViewView;
  int i;
  int j;
  
  public MineFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = new NearbyMyTabCard();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new sne(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new snf(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$NotifyListener = new snb(this);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new snc(this);
    this.jdField_b_of_type_Int = 3;
  }
  
  public static void a(NearbyAppInterface paramNearbyAppInterface)
  {
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(0L));
    NearbyHandler localNearbyHandler = (NearbyHandler)paramNearbyAppInterface.a(3);
    if (localNearbyHandler != null) {
      localNearbyHandler.a(false);
    }
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), false);
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(false));
    paramNearbyAppInterface.a().b();
    paramNearbyAppInterface.c = false;
    ThreadManager.a(new smy(paramNearbyAppInterface), 10, null, true);
  }
  
  private void a(List paramList)
  {
    int n = 1;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateVistorHeader visitor count:");
      if (paramList != null) {
        break label78;
      }
    }
    label78:
    for (int k = 0;; k = paramList.size())
    {
      QLog.d("Q.nearby.visitor", 2, k);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      return;
    }
    if (paramList.size() > 3) {}
    int m;
    for (k = 3;; k = paramList.size())
    {
      localObject1 = new ArrayList(3);
      m = 0;
      while (m < k)
      {
        localObject2 = (StrangerInfo)paramList.get(m);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        m += 1;
      }
    }
    k = ((List)localObject1).size();
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    if ((k != this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment$VisitorHeaderAdapter.getCount()) && (k > 0))
    {
      m = this.i;
      ((RelativeLayout.LayoutParams)localObject2).width = ((k - 1) * this.jdField_j_of_type_Int + m * k);
    }
    for (k = 1;; k = 0)
    {
      if ((!this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.a(35.0F, paramList)))
      {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(35.0F, paramList);
        k = n;
      }
      for (;;)
      {
        if (k != 0) {
          this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(((List)localObject1).size());
        MineFragment.VisitorHeaderAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment$VisitorHeaderAdapter, (List)localObject1);
        if (this.jdField_a_of_type_AndroidWidgetGridView.getVisibility() == 0) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
        return;
        if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.a(45.0F, paramList)))
        {
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(45.0F, paramList);
          k = n;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.a(new sna(this, paramBoolean), null, true);
  }
  
  public static void b(NearbyAppInterface paramNearbyAppInterface)
  {
    File localFile = BaseApplicationImpl.getContext().getFileStreamPath(paramNearbyAppInterface.a() + "v5.3.nb");
    if (localFile.exists())
    {
      localFile.delete();
      NearbyUtils.a("Q.nearby", "clearNearbyCache", new Object[0]);
    }
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), "history_valid", Boolean.valueOf(false));
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131371844);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new sni(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130840839);
    case 10001: 
      return this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130840893);
    case 10002: 
      return this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130840873);
    case 10003: 
      return this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130840941);
    case 10004: 
      return this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130840940);
    case 10005: 
      return this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130840942);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130840899);
  }
  
  public View a(NearbyMyTabCard.NearbyMyTabConfig paramNearbyMyTabConfig, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity).inflate(2130904240, null);
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 0)
    {
      localView.setBackgroundResource(2130838358);
      localView = localView.findViewById(2131301934);
      if ((paramNearbyMyTabConfig.extraVal != null) && (!TextUtils.isEmpty(paramNearbyMyTabConfig.extraVal.path))) {
        paramNearbyMyTabConfig.redTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, localView).a(21).c(30).a();
      }
      localView.setTag(paramNearbyMyTabConfig);
      localView.setOnClickListener(this);
      ((TextView)localView.findViewById(2131301938)).setText(paramNearbyMyTabConfig.strName);
      localObject1 = (TextView)localView.findViewById(2131300063);
      ((TextView)localObject1).setText(paramNearbyMyTabConfig.tips);
      ((TextView)localObject1).setVisibility(0);
      if ((paramNearbyMyTabConfig.configId != 10010) || (paramNearbyMyTabConfig.extraVal == null) || (TextUtils.isEmpty(paramNearbyMyTabConfig.extraVal.path))) {
        break label382;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramNearbyMyTabConfig.extraVal.path);
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0))
      {
        ((TextView)localObject1).setVisibility(8);
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "sp_nearby_mytab", 0, "key_nearby_push_signin_redtouch", Integer.valueOf(0));
        if (QLog.isColorLevel()) {
          QLog.i("MineFragment", 2, "bindConfigItemView.set singin push flag to 0..");
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8006731", "0X8006731", 0, 0, "", "", "", "");
      }
      label291:
      localObject1 = (ImageView)localView.findViewById(2131301936);
      localObject2 = a(paramNearbyMyTabConfig.configId);
      if (TextUtils.isEmpty(paramNearbyMyTabConfig.iconUrl)) {
        break label443;
      }
      ((ImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramNearbyMyTabConfig.iconUrl, 0, 0, (Drawable)localObject2, (Drawable)localObject2, false));
    }
    for (;;)
    {
      if (paramNearbyMyTabConfig.redTouch != null) {
        break label453;
      }
      return localView;
      if (paramInt1 + 1 == paramInt2)
      {
        localView.setBackgroundResource(2130838353);
        break;
      }
      localView.setBackgroundResource(2130838356);
      break;
      label382:
      if ((paramNearbyMyTabConfig.configId != 10011) || (this.jdField_e_of_type_Boolean)) {
        break label291;
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8005D3A", "0X8005D3A", 3, 0, "", "", "", "");
      break label291;
      label443:
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
    }
    label453:
    return paramNearbyMyTabConfig.redTouch;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(NearbyMyTabCard.NearbyMyTabConfig paramNearbyMyTabConfig)
  {
    int k = NearbyMineHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramNearbyMyTabConfig.extraVal.pathId);
    if ((k > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b(paramNearbyMyTabConfig.extraVal.pathId))) {
      return NearbyMineHelper.a(5, paramNearbyMyTabConfig.extraVal.pathId, paramNearbyMyTabConfig.extraVal.path, String.valueOf(k), 0);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramNearbyMyTabConfig.extraVal.path);
  }
  
  void a()
  {
    if ((this.k) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    this.k = true;
    f();
    NearbyMyTabCard localNearbyMyTabCard = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    if (localNearbyMyTabCard == null) {
      ThreadManager.a(new smx(this), 5, null, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$NotifyListener);
      return;
      a(localNearbyMyTabCard, true);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("MineFragment", new Object[] { "updateRedTouch:" + paramInt });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) {
      return;
    }
    ThreadManager.a(new snd(this, paramInt), null, true);
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) || (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList == null) || (paramViewGroup == null)) {}
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList;
      if (localList.size() > 0) {}
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      int m = localList.size();
      paramViewGroup.removeAllViews();
      int k = 0;
      while (k < m)
      {
        paramViewGroup.addView(a((NearbyMyTabCard.NearbyMyTabConfig)localList.get(k), k, m), localLayoutParams);
        k += 1;
      }
    }
  }
  
  void a(NearbyMyTabCard paramNearbyMyTabCard)
  {
    int k;
    if ((paramNearbyMyTabCard != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = paramNearbyMyTabCard;
      long l = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      if (l == 0L) {
        break label233;
      }
      paramNearbyMyTabCard = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 202, String.valueOf(l), true);
      if (paramNearbyMyTabCard != null)
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramNearbyMyTabCard);
        if ((localDrawable != paramNearbyMyTabCard) && ((localDrawable instanceof AsynLoadDrawable))) {
          ((AsynLoadDrawable)localDrawable).a();
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.nickName);
      switch (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.charmLevel)
      {
      default: 
        k = 2130840884;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(k);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.charmValue));
      if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.giftNum > 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.giftNum));
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      j();
      return;
      label233:
      paramNearbyMyTabCard = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 200, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), true);
      break;
      k = 2130840886;
      continue;
      k = 2130840887;
      continue;
      k = 2130840888;
      continue;
      k = 2130840889;
      continue;
      k = 2130840890;
      continue;
      k = 2130840891;
    }
  }
  
  void a(NearbyMyTabCard paramNearbyMyTabCard, boolean paramBoolean)
  {
    a(paramNearbyMyTabCard);
    a(0);
    if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramBoolean)
    {
      paramNearbyMyTabCard = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(getClass().getName());
      if ((paramNearbyMyTabCard != null) && (paramNearbyMyTabCard.a != null)) {
        this.jdField_a_of_type_ComTencentWidgetXListView.onRestoreInstanceState(paramNearbyMyTabCard.a);
      }
    }
    a(false);
  }
  
  void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    try
    {
      JumpAction localJumpAction = JumpParser.a(null, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, paramString1);
      if (localJumpAction != null)
      {
        paramString2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class);
        paramString2.setData(Uri.parse(paramString1));
        startActivity(paramString2);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("MineFragment", new Object[] { "clickAction", paramString2, paramString1, localException.toString() });
        }
        str = null;
      }
      String str = paramString1;
      if (paramString1.indexOf("plg_uin=1") > -1) {
        str = paramString1 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
      }
      paramString1 = new Intent(getActivity(), QQBrowserActivity.class);
      if (str.indexOf("plg_nld=1") > -1) {
        paramString1.putExtra("reportNld", true);
      }
      paramString1.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
      paramString1.putExtra("plugin_start_time", System.nanoTime());
      paramString1.putExtra("click_start_time", System.currentTimeMillis());
      paramString1.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramString1.putExtra("portraitOnly", true);
      paramString1.putExtra("fromNearby", true);
      startActivity(paramString1.putExtra("url", str).putExtra("title", paramString2));
    }
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 2);
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.c = false;
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.c = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.likeTotalNum, this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.newLikeNum, this.jdField_d_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentWidgetSingleLineTextView, null);
  }
  
  void f()
  {
    Object localObject1 = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSystemService("layout_inflater");
    this.jdField_c_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2130904241, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131296790));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297741));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131298505));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131301940));
    this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131301942);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131300563));
    Object localObject2 = getResources().getDrawable(2130840943);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject2, null);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 5.0F));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131298512));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131298511);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131296776).setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131301955));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131301957));
    this.jdField_c_of_type_AndroidViewView.findViewById(2131301939).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131301415));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localObject2 = this.jdField_c_of_type_AndroidViewView.findViewById(2131301949);
    FreshNewsManager localFreshNewsManager = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
    if (FreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface))
    {
      ((View)localObject2).setVisibility(0);
      ((View)localObject2).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (View)localObject2).a(21).c(30).a();
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.findViewById(2131301952).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297950));
      localObject2 = getResources().getDrawable(2130838317);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader((Drawable)localObject2);
      localObject2 = getResources().getDrawable(2130837958);
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground((Drawable)localObject2, false, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)((LayoutInflater)localObject1).inflate(2130903729, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(new snl(this));
      this.f = this.jdField_c_of_type_AndroidViewView.findViewById(2131301945);
      this.f.setOnClickListener(this);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources();
      this.i = ((Resources)localObject1).getDimensionPixelSize(2131493656);
      this.jdField_j_of_type_Int = ((Resources)localObject1).getDimensionPixelSize(2131493657);
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_c_of_type_AndroidViewView.findViewById(2131301948));
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.i);
      this.jdField_a_of_type_AndroidWidgetGridView.setHorizontalSpacing(this.jdField_j_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetGridView.setStretchMode(0);
      this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment$VisitorHeaderAdapter = new MineFragment.VisitorHeaderAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.i);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment$VisitorHeaderAdapter);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.f).a(21).c(30).a();
      return;
      ((View)localObject2).setVisibility(8);
    }
  }
  
  void g()
  {
    ViewExposeUtil.ViewExposeUnit localViewExposeUnit = ViewExposeUtil.a(getClass(), hashCode());
    if (localViewExposeUnit != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - localViewExposeUnit.b), "", "", "");
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
    if (!FreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface)) {
      return;
    }
    int k = NearbyMineHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 100519);
    if ((k > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b(100519))) {}
    for (localObject = NearbyMineHelper.a(5, 100519, "100510.100519", String.valueOf(k), 0);; localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a("100510.100519"))
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(7)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      }
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, localObject).sendToTarget();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    case 1: 
    case 3: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      do
      {
        Object localObject;
        do
        {
          int k;
          do
          {
            return true;
            a();
            return true;
            this.jdField_a_of_type_ComTencentWidgetXListView.H();
            return true;
            this.jdField_a_of_type_ComTencentWidgetXListView.H();
            QQToast.a(BaseApplication.getContext(), 1, 2131369008, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
            return true;
            localObject = (NearbyMyTabCard)paramMessage.obj;
            if (paramMessage.arg1 == 1) {
              bool = true;
            }
            a((NearbyMyTabCard)localObject, bool);
            return true;
            b(paramMessage.arg1);
            return true;
            k = paramMessage.arg1;
            paramMessage = (BusinessInfoCheckUpdate.AppInfo)paramMessage.obj;
          } while ((k >= this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList.size()) || (paramMessage == null));
          localObject = (NearbyMyTabCard.NearbyMyTabConfig)this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.configList.get(k);
        } while ((localObject == null) || (((NearbyMyTabCard.NearbyMyTabConfig)localObject).redTouch == null) || (((NearbyMyTabCard.NearbyMyTabConfig)localObject).extraVal == null));
        ((NearbyMyTabCard.NearbyMyTabConfig)localObject).redTouch.a(paramMessage);
        return true;
      } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
      paramMessage = (BusinessInfoCheckUpdate.AppInfo)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramMessage);
      return true;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.visitors);
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.gender == 1) {}
    for (int k = 2131371608;; k = 2131371607)
    {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 2131368213, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(k), 2131367262, 2131368223, new snj(this), new snk(this));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
    }
  }
  
  void j()
  {
    ThreadManager.a(new smz(this), 10, null, true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (!this.k) {}
    while (paramInt1 != 1000) {
      return;
    }
    b(1);
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MineFragment", 2, "AutoMonitor_fragment MineFragment onAttach");
    }
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211));
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301952: 
      if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) {}
      for (k = 0;; k = this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.giftNum)
      {
        paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/received_list.html?_wv=2147347&visit=owner&sourceType=%d&ADTAG=%s&totalFlower=%d&_bid=2050&isfresh=%d", new Object[] { Integer.valueOf(1), "near.more.r", Integer.valueOf(k), Integer.valueOf(0) });
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", "0X80057C1", "0X80057C1", 0, 0, "", "", "", "");
        if (paramView == null) {
          break;
        }
        a(paramView, "");
        return;
      }
    case 2131301949: 
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, MyFreshNewsActivity.class);
      paramView.setFlags(67108864);
      paramView.putExtra("parm_mode", 10);
      localObject1 = (FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211);
      if (localObject1 == null) {
        break;
      }
    }
    for (int k = ((FreshNewsManager)localObject1).a(true);; k = 0)
    {
      if (k == 0)
      {
        paramView.putExtra("param_which_fragment", 10);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X800578A", "0X800578A", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(paramView);
        return;
        paramView.putExtra("param_which_fragment", 11);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X800578B", "0X800578B", 0, 0, "", "", "", "");
      }
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0);
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, NearbyPeopleProfileActivity.class);
      ((Intent)localObject1).putExtra("param_mode", 2);
      ((Intent)localObject1).putExtra("AllInOne", paramView);
      startActivityForResult((Intent)localObject1, 1000);
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.b = true;
      }
      ThreadManager.a(new sng(this), 5, null, false);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", "0X80057BF", "0X80057BF", 0, 0, "", "", "", "");
      return;
      paramView = (NearbyMyTabCard.NearbyMyTabConfig)paramView.getTag();
      if (paramView == null) {
        break;
      }
      localObject1 = paramView.strUrl;
      Object localObject2 = paramView.strName;
      if (paramView.extraVal != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramView.extraVal.path);
        if (!TextUtils.isEmpty(paramView.extraVal.actionName)) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("CliOper", "", "", paramView.extraVal.actionName, paramView.extraVal.actionName, 0, 0, "", "", "", "");
        }
      }
      if (paramView.configId == 10010)
      {
        if ((paramView.extraVal != null) && (!TextUtils.isEmpty(paramView.extraVal.path)))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramView.extraVal.path);
          if ((localObject3 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() != 0)) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8006733", "0X8006733", 0, 0, "", "", "", "");
          }
        }
        Object localObject3 = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8006735", "0X8006735", 0, 0, "", "", "", "");
      }
      if (paramView.configId == 10006)
      {
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, NearbyTroopsActivity.class);
        ((Intent)localObject2).putExtra("from", 23);
        ((Intent)localObject2).putExtra("mode", 1);
        paramView = (NearbyFragment)((NearbyActivity)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity).a(0);
        if (paramView != null)
        {
          ((Intent)localObject2).putExtra("lat", paramView.s);
          ((Intent)localObject2).putExtra("lon", paramView.t);
        }
        ((Intent)localObject2).putExtra("location_name", "");
        localObject1 = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_troop_title", "");
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = getResources().getString(2131367336);
        }
        ((Intent)localObject2).putExtra("config_res_plugin_item_name", paramView);
        ((Intent)localObject2).putExtra("TAB_INDEX", "0");
        startActivity((Intent)localObject2);
        return;
      }
      if (localObject1 == null) {
        break;
      }
      a((String)localObject1, (String)localObject2);
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "http://exp.qq.com/ur/?urid=22132");
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("hide_more_button", true);
      startActivity(paramView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "0X8005811");
      return;
      k();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(5);
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, NearbyVisitorListActivity.class);
      paramView.putExtra("charmlevel", this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.charmLevel);
      startActivity(paramView);
      k = 3;
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a()) {
        k = 1;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
        a(null);
        ThreadManager.a(new snh(this), 5, null, false);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X80061A7", "0X80061A7", k, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFragmentMineFragment$VisitorHeaderAdapter.getCount() > 0) {
          k = 2;
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130904242, null);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131301959);
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.c(getString(2131369273)).a();
    if ((this.jdField_j_of_type_Boolean) && (!this.k)) {
      a();
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.k) {}
    Drawable localDrawable;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(getClass().getName(), this.jdField_a_of_type_ComTencentWidgetXListView.onSaveInstanceState(), null, null);
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        g();
        if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
        }
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$NotifyListener);
      } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
      localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    } while (!(localDrawable instanceof AsynLoadDrawable));
    ((AsynLoadDrawable)localDrawable).a();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean) {
      g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.k) {
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    if (!ViewExposeUtil.a(getClass(), hashCode())) {
      ViewExposeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80057BA", ((NearbyActivity)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity).c());
    }
    a(0);
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\MineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */