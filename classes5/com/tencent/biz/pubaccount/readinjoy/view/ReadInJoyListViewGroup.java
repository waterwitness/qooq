package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView.DrawFinishedListener;
import cooperation.readinjoy.ReadInJoyHelper;
import ibx;
import iby;
import ica;
import icc;
import icd;
import ice;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, ReadInJoyBaseAdapter.OnLastReadRefreshListener, ReadInJoyXListView.RefreshCallback, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static final String a = "ReadInJoyListViewGroup";
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private ReadInJoyArticleAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter;
  private ReadInJoyTipsView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ReadinjoyTagsContainer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTagsContainer;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener;
  public boolean a;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ReadInJoyObserver jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController, paramInt, paramReadInJoyPageItemCache);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new iby(this);
    this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ice(this);
    a().getLayoutInflater().inflate(2130903755, this);
    h();
  }
  
  private int a()
  {
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private List a()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int i = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_b_of_type_Int == i) {
      localList = (List)localIntent.getSerializableExtra("subscription_all_article_id");
    }
    if ((localLong.longValue() > 0L) && (localList != null) && (localList.size() > 0))
    {
      localList.remove(localLong);
      localList.add(0, localLong);
    }
    return localList;
  }
  
  private void a(String paramString)
  {
    findViewById(2131299958).setVisibility(8);
    View localView = findViewById(2131299934);
    ((TextView)localView.findViewById(2131299935)).setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a();
    if (paramBoolean)
    {
      if (paramInt > 0)
      {
        str = getResources().getString(2131362964);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramBoolean, String.format(str, new Object[] { Integer.valueOf(paramInt) }));
        return;
      }
      String str = getResources().getString(2131362966);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramBoolean, str);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramBoolean);
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    boolean bool3;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getCount() == 0)
    {
      bool3 = true;
      if (!c()) {
        break label117;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.d <= 300000L) {
        break label106;
      }
      i = 1;
      label45:
      if ((!bool3) && (i == 0)) {
        break label111;
      }
    }
    label106:
    label111:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
      if (!bool1) {
        break label277;
      }
      b(false);
      return true;
      bool3 = false;
      break;
      i = 0;
      break label45;
    }
    label117:
    Object localObject = ((BaseActivity)a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((QQAppInterface)localObject).getManager(161);
    label152:
    boolean bool4;
    if (ReadInJoyHelper.a((QQAppInterface)localObject))
    {
      bool1 = localKandianMergeManager.b();
      bool4 = a().getIntent().getBooleanExtra("from_search", false);
      if ((!bool3) && (!bool1) && (!bool4)) {
        break label271;
      }
    }
    label271:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool4) }));
      bool1 = bool2;
      break;
      localObject = a();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        bool1 = true;
        break label152;
      }
      bool1 = false;
      break label152;
    }
    label277:
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long == 0L) {}
    for (;;)
    {
      ((ReadInJoyPageItemCache)localObject).jdField_a_of_type_Long = l;
      return false;
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long;
    }
  }
  
  private void b(Map paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.values() == null) || (!paramBoolean)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        if (!localBaseReportData.jdField_a_of_type_Boolean)
        {
          localBaseReportData.jdField_a_of_type_Boolean = true;
          ReportController.b(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_a_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_b_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_c_of_type_Int, localBaseReportData.d));
          ReportInfo localReportInfo = new ReportInfo();
          localReportInfo.mUin = ReadInJoyUtils.a();
          localReportInfo.mSource = 0;
          localReportInfo.mSourceArticleId = localBaseReportData.jdField_a_of_type_JavaLangLong.longValue();
          localReportInfo.mChannelId = this.jdField_b_of_type_Int;
          localReportInfo.mAlgorithmId = ((int)localBaseReportData.jdField_a_of_type_Long);
          localReportInfo.mStrategyId = localBaseReportData.jdField_a_of_type_Int;
          localReportInfo.mOperation = 7;
          localReportInfo.mServerContext = localBaseReportData.jdField_a_of_type_ArrayOfByte;
          localReportInfo.mReadTimeLength = -1;
          if ((localBaseReportData.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(localBaseReportData.jdField_a_of_type_JavaLangString))) {
            ReportController.b(null, "CliOper", "", "", "0X80069AA", "0X80069AA", 0, 0, "0", VideoReporter.a(), "", ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_JavaLangString, Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue())));
          }
          localArrayList.add(localReportInfo);
        }
      }
    } while (localArrayList.isEmpty());
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    long l3 = 0L;
    long l4 = 0L;
    Object localObject3 = null;
    Object localObject1;
    boolean bool;
    Object localObject2;
    long l2;
    long l1;
    if (this.jdField_b_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Boolean)
      {
        localObject1 = a();
        bool = b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Boolean = false;
        if (localObject1 == null)
        {
          localObject2 = ((KandianMergeManager)((BaseActivity)a()).app.getManager(161)).a();
          l2 = l4;
          l1 = l3;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            l2 = l4;
            l1 = l3;
            localObject1 = localObject2;
            if (((List)localObject2).size() > 2)
            {
              l1 = ((Long)((List)localObject2).get(((List)localObject2).size() - 2)).longValue();
              l2 = ((Long)((List)localObject2).get(((List)localObject2).size() - 1)).longValue();
              localObject1 = ((List)localObject2).subList(0, ((List)localObject2).size() - 2);
            }
          }
          label196:
          localObject3 = ((KandianMergeManager)((BaseActivity)a()).app.getManager(161)).a();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramBoolean);
      }
      label250:
      ReadInJoyLogicEngine localReadInJoyLogicEngine;
      int i;
      int j;
      String str;
      if (localObject3 == null)
      {
        localObject2 = null;
        if (localObject3 != null) {
          break label343;
        }
        localObject3 = null;
        localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
        i = this.jdField_b_of_type_Int;
        j = this.jdField_c_of_type_Int;
        if (!(localObject2 instanceof String)) {
          break label356;
        }
        str = (String)localObject2;
        label280:
        if (!(localObject2 instanceof Long)) {
          break label362;
        }
      }
      label343:
      label356:
      label362:
      for (l3 = ((Long)localObject2).longValue();; l3 = -1L)
      {
        localReadInJoyLogicEngine.a(i, (List)localObject1, true, bool, j, str, l3, (String)localObject3, a(), l1, l2);
        this.jdField_c_of_type_Int += 1;
        return;
        localObject2 = ((Pair)localObject3).first;
        break;
        localObject3 = (String)((Pair)localObject3).second;
        break label250;
        str = null;
        break label280;
      }
      l2 = l4;
      l1 = l3;
      break label196;
      localObject1 = null;
      bool = false;
      break;
      l2 = 0L;
      l1 = 0L;
      bool = false;
      localObject1 = null;
    }
  }
  
  private boolean b()
  {
    List localList = (List)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = ((Long)localList.get(0)).longValue(); Long.valueOf(l).longValue() != 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  private boolean c()
  {
    return a().getIntent().getBooleanExtra("is_channel_activity", false);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131299957));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130837958);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverscrollHeader(getResources().getDrawable(2130838317));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a(a().getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter = new ReadInJoyArticleAdapter(a(), a().getLayoutInflater(), this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(a().getIntent().getIntExtra("channel_type", 0));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(new ibx(this));
    k();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTagsContainer = new ReadinjoyTagsContainer(getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTagsContainer);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTagsContainer.setChannelId(this.jdField_b_of_type_Int);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView = ((ReadInJoyTipsView)findViewById(2131299956));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299961);
    if (ThemeUtil.isInNightMode(((BaseActivity)a()).app)) {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void i()
  {
    if ((ReadInJoyHelper.b(((BaseActivity)a()).app)) && (!c()))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.b()))
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver == null)
        {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ica(this);
          ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
        }
        ReadInJoyLogicEngine.a().f();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.a();
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.e(0);
  }
  
  private void k()
  {
    findViewById(2131299934).setVisibility(8);
    View localView = findViewById(2131299958);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  public void L_()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b();
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public ReadInJoyArticleAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9991) {
      a(1, paramIntent);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 == 9091)
          {
            a(0, paramIntent);
            return;
          }
          if (paramInt1 != 9993) {
            break;
          }
        } while (paramInt2 != 1);
        L_();
        return;
        if (paramInt1 != 21) {
          break;
        }
      } while (paramInt2 != -1);
      ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), a(), a().getApplicationContext(), paramIntent, null);
      return;
      if (paramInt1 == 3)
      {
        a(3, paramIntent);
        return;
      }
    } while (paramInt1 != 4);
    a(4, paramIntent);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((paramInt != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramList);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
        Object localObject1 = (Long)paramList.get(0);
        Object localObject2 = ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, ((Long)localObject1).longValue());
        Object localObject3 = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 != null)
        {
          localObject1 = ((ArticleInfo)localObject2).mTitle;
          localObject1 = ReadInJoyUtils.c((String)localObject1);
          localObject3 = new StringBuilder().append((String)localObject1).append(" articleID : ");
          if (localObject2 == null) {
            break label252;
          }
        }
        label252:
        for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
        {
          QLog.d("ReadInJoyListViewGroup", 1, localObject1);
          if (!QLog.isColorLevel()) {
            break label269;
          }
          localObject1 = new StringBuilder("onChannelArticleLoaded ");
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            ((StringBuilder)localObject1).append("recommendSeq = " + localObject3 + ",\n ");
          }
          localObject1 = "";
          break;
        }
        QLog.d("ReadInJoyListViewGroup", 1, ((StringBuilder)localObject1).toString());
      }
      label269:
      if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_b_of_type_Int == 0))
      {
        this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, ((Long)paramList.get(0)).longValue());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          PublicAccountUtil.a(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a()).app, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle, String.valueOf(this.jdField_b_of_type_Long), false);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_b_of_type_Long = 0L;
      boolean bool = a();
      if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_c_of_type_Long > 600000L) {}
      for (paramInt = 1; (!bool) && (paramInt != 0) && (!ReadInJoyHelper.b(((BaseActivity)a()).app)) && (!c()); paramInt = 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.a(10);
        return;
      }
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getItem((int)paramLong);
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a();
    if ((localObject2 instanceof Long)) {}
    for (paramAdapterView = ReadInJoyLogicEngine.a().a(j, ((Long)localObject2).longValue());; paramAdapterView = null)
    {
      if (paramAdapterView != null)
      {
        if (!ReadInJoyUtils.a(paramAdapterView)) {
          break label532;
        }
        if ((1 == paramAdapterView.mVideoType) || (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.q)))
        {
          localObject2 = new VideoPlayManager.VideoPlayParam();
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_JavaLangString = paramAdapterView.mVideoVid;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_Long = paramAdapterView.mArticleID;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_Int = paramAdapterView.mVideoDuration;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_c_of_type_Long = paramAdapterView.mFileSize;
          ((VideoPlayManager.VideoPlayParam)localObject2).g = paramAdapterView.thirdUin;
          ((VideoPlayManager.VideoPlayParam)localObject2).h = paramAdapterView.thirdUinName;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_b_of_type_Int = paramAdapterView.mVideoJsonWidth;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_c_of_type_Int = paramAdapterView.mVideoJsonHeight;
          if (paramAdapterView.mVideoCoverUrl != null) {
            break label449;
          }
          localObject1 = null;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
          localObject1 = new ReadinjoyVideoReportData();
          ((ReadinjoyVideoReportData)localObject1).jdField_a_of_type_JavaLangLong = Long.valueOf(paramAdapterView.mArticleID);
          ((ReadinjoyVideoReportData)localObject1).jdField_a_of_type_JavaLangString = paramAdapterView.mVideoVid;
          ((ReadinjoyVideoReportData)localObject1).jdField_a_of_type_Int = paramAdapterView.busiType;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = ((ReadinjoyVideoReportData)localObject1);
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_c_of_type_JavaLangString = paramAdapterView.thirdIcon;
          ((VideoPlayManager.VideoPlayParam)localObject2).d = paramAdapterView.thirdName;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_e_of_type_JavaLangString = paramAdapterView.thirdAction;
          ((VideoPlayManager.VideoPlayParam)localObject2).jdField_e_of_type_Int = paramAdapterView.busiType;
          ((VideoPlayManager.VideoPlayParam)localObject2).i = paramAdapterView.innerUniqueID;
          if ((!NetworkUtil.h(paramView.getContext())) || (NetworkUtil.i(paramView.getContext())) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.d())) {
            break label461;
          }
          DialogUtil.a(paramView.getContext(), 232, paramView.getContext().getString(2131371551), paramView.getContext().getString(2131371552), paramView.getContext().getString(2131367262), "继续观看", new icc(this, (VideoPlayManager.VideoPlayParam)localObject2, paramAdapterView), new icd(this)).show();
        }
      }
      for (;;)
      {
        paramAdapterView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getItem(0);
        if ((this.jdField_b_of_type_Int == 0) && ((paramAdapterView instanceof Long)))
        {
          paramAdapterView = ReadInJoyLogicEngine.a().a(j, ((Long)paramAdapterView).longValue());
          if (paramAdapterView != null)
          {
            this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramAdapterView;
            PublicAccountUtil.a(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a()).app, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle, String.valueOf(this.jdField_b_of_type_Long), true);
          }
        }
        return;
        label449:
        localObject1 = paramAdapterView.mVideoCoverUrl.getFile();
        break;
        label461:
        ReportController.b(null, "CliOper", "", "", "0X80069AC", "0X80069AC", 0, 0, Long.toString(paramAdapterView.mChannelID), "", "", paramAdapterView.mVideoVid);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a((VideoPlayManager.VideoPlayParam)localObject2, paramAdapterView);
        ReadInJoyLogicEngine.a().a(paramAdapterView.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
      }
      label532:
      Bundle localBundle = new Bundle();
      localBundle.putString("leftViewText", null);
      Object localObject1 = paramAdapterView.mArticleContentUrl;
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        label590:
        localBundle.putString("url", (String)localObject1 + "from=0");
        localBundle.putBoolean("hide_operation_bar", true);
        localBundle.putString("from", String.valueOf(53));
        localBundle.putString("subscribename", paramAdapterView.mSubscribeName);
        localBundle.putLong("articleid", paramAdapterView.mArticleID);
        localBundle.putLong("recommendSeq", ((Long)localObject2).longValue());
        localBundle.putInt("channelid", j);
        localBundle.putParcelable("articleinfo", paramAdapterView);
        localBundle.putInt("articalChannelId", 9);
        paramView = new Intent(paramView.getContext(), ReadInJoyArticleDetailActivity.class);
        paramView.putExtras(localBundle);
        a().startActivityForResult(paramView, 9991);
        if (!paramAdapterView.hasChannelInfo()) {
          break label974;
        }
        paramInt = paramAdapterView.mChannelInfoId;
        label755:
        if (!TextUtils.isEmpty(paramAdapterView.mArticleFriendLikeText)) {
          break label979;
        }
      }
      label974:
      label979:
      for (int i = 0;; i = 1)
      {
        ReportController.b(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAdapterView.mArticleID), Integer.toString(paramAdapterView.mStrategyId), ReadInJoyUtils.b(paramAdapterView.mAlgorithmID, ReadInJoyUtils.a(paramAdapterView), j, paramInt, i));
        paramView = new ArrayList();
        localObject1 = new ReportInfo();
        ((ReportInfo)localObject1).mUin = ReadInJoyUtils.a();
        ((ReportInfo)localObject1).mSource = 0;
        ((ReportInfo)localObject1).mSourceArticleId = paramAdapterView.mArticleID;
        ((ReportInfo)localObject1).mChannelId = j;
        ((ReportInfo)localObject1).mAlgorithmId = ((int)paramAdapterView.mAlgorithmID);
        ((ReportInfo)localObject1).mStrategyId = paramAdapterView.mStrategyId;
        ((ReportInfo)localObject1).mOperation = 1;
        ((ReportInfo)localObject1).mServerContext = paramAdapterView.mServerContext;
        ((ReportInfo)localObject1).mReadTimeLength = -1;
        paramView.add(localObject1);
        ReadInJoyLogicEngine.a().a(paramView);
        ReadInJoyLogicEngine.a().a(paramAdapterView.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
        break;
        localObject1 = (String)localObject1 + "?";
        break label590;
        paramInt = 0;
        break label755;
      }
    }
  }
  
  public void a(ListView paramListView)
  {
    ReportController.b(null, "CliOper", "", "", "0X80066F8", "0X80066F8", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_b_of_type_Int));
    b(true);
  }
  
  public void a(Map paramMap) {}
  
  public void a(Map paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    ReadInJoyDisplayUtils.a();
    if (c()) {
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(false);
      }
      a().getIntent().putExtra("from_search", false);
      return;
      ReadInJoyHelper.a(System.currentTimeMillis(), (QQAppInterface)ReadInJoyUtils.a());
    }
  }
  
  public void a(Set paramSet, Map paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_b_of_type_Long = System.currentTimeMillis();
    if (c()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, 20, Long.MAX_VALUE, true);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_c_of_type_Long = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      L_();
      return;
    }
    j();
    a(3, null);
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if ((paramInt != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getCount() == 0) {}
      StringBuilder localStringBuilder;
      for (int i = 1;; i = 0)
      {
        paramInt = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt));
        if (!paramBoolean) {
          break label214;
        }
        if ((paramList == null) || (paramInt <= 0)) {
          break label187;
        }
        if (!QLog.isColorLevel()) {
          break label153;
        }
        localStringBuilder = new StringBuilder("onChannelRefreshed ");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Long localLong = (Long)localIterator.next();
          localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
        }
      }
      QLog.d("ReadInJoyListViewGroup", 1, localStringBuilder.toString());
      label153:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
      while ((c()) || (i == 0))
      {
        a(paramBoolean, paramInt);
        return;
        label187:
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty())
        {
          a(getResources().getString(2131362968));
          continue;
          label214:
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty()) {
            a(getResources().getString(2131362967));
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    paramBoolean2 = true;
    if ((paramInt != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null))
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    }
    ReadInJoyXListView localReadInJoyXListView;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      localReadInJoyXListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
      if (paramBoolean1) {
        break label209;
      }
    }
    for (;;)
    {
      localReadInJoyXListView.b(paramBoolean2);
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "autoLoad:" + this.jdField_c_of_type_Boolean + " noMoreData:" + paramBoolean1 + " fore:" + GesturePWDUtils.isAppOnForeground(getContext()));
      }
      if ((!this.jdField_c_of_type_Boolean) && (paramBoolean1) && (GesturePWDUtils.isAppOnForeground(getContext())))
      {
        paramList = getResources().getString(2131362966);
        QQToast.a(getContext().getApplicationContext(), paramList, 0).a();
      }
      this.jdField_c_of_type_Boolean = false;
      return;
      paramBoolean1 = false;
      break;
      label209:
      paramBoolean2 = false;
    }
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public void b()
  {
    i();
    if (ReadInJoyHelper.a(a())) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.f();
    }
  }
  
  public void b(int paramInt, List paramList)
  {
    if ((paramInt != this.jdField_b_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
  }
  
  public void b(ListView paramListView)
  {
    ReportController.b(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_b_of_type_Int));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(false);
    }
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, a());
  }
  
  public void b(Map paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
    i();
  }
  
  public void c()
  {
    if (ReadInJoyHelper.a(a())) {
      if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 0L) {
        break label74;
      }
    }
    label74:
    for (long l = 0L;; l = System.currentTimeMillis() - this.jdField_c_of_type_Long)
    {
      ReportController.b(null, "CliOper", "", "", "0X80069BB", "0X80069BB", 0, 0, Long.toString(l), "", "", "");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.g();
      }
      return;
    }
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter = null;
    if ((a() instanceof ReadInJoyFeedsActivity)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a(false);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver != null) {
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    }
    ReadInJoyHelper.b(((BaseActivity)a()).app);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.b()))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.a()) {
        break label47;
      }
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(3, null);
      ReadInJoyLogicEngine.a().h();
      return;
      label47:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      k();
      b(true);
      return;
      paramView = (Integer)paramView.getTag();
      if (paramView.intValue() == 10)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelection(0);
        b(true);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTipsView.setOnClickListener(null);
        }
        ReportController.b((QQAppInterface)ReadInJoyUtils.a(), "CliOper", "", "", "0X80067B7", "0X80067B7", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_b_of_type_Int));
        return;
      }
      if (paramView.intValue() == 100)
      {
        ReadInJoyHelper.b(((BaseActivity)a()).app);
        ReadInJoyActivityHelper.a(a());
        ReportController.b((QQAppInterface)ReadInJoyUtils.a(), "CliOper", "", "", "0X80067D9", "0X80067D9", 0, 0, "", "", "", "");
        return;
      }
    } while (paramView.intValue() != 20);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyListViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */