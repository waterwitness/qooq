package com.tencent.biz.qqstory.pgc;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.SearchType;
import com.tencent.biz.qqstory.pgc.adapter.DiscoverAdapter;
import com.tencent.biz.qqstory.pgc.adapter.SearchResultAdapter;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.BaseDiscoverFrameLayout;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView.PullToRefreshListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import ikl;
import ikn;
import iko;
import ikp;
import ikq;
import ikr;
import iks;
import ikt;
import iku;
import ikv;
import ikw;
import iky;
import ikz;
import ila;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QQStoryDiscoverActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, QQStoryPullToRefreshListView.PullToRefreshListener
{
  public static final String b = "key_from";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 2;
  final int jdField_a_of_type_Int;
  public Dialog a;
  public Bitmap a;
  public View a;
  public EditText a;
  public FrameLayout a;
  public ImageButton a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public QQStoryHandler a;
  private QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver;
  public DiscoverAdapter a;
  public SearchResultAdapter a;
  public InfoCardDialog a;
  public QQStoryLoadingView a;
  public QQStoryPullToRefreshListView a;
  public XListView a;
  public String a;
  public LinkedHashMap a;
  public boolean a;
  public int[] a;
  public String[] a;
  final int b;
  public View b;
  public EditText b;
  public TextView b;
  public boolean b;
  final int c;
  public View c;
  public boolean c;
  final int d;
  protected View d;
  public boolean d;
  final int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  public boolean e;
  protected boolean f;
  
  public QQStoryDiscoverActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
    this.jdField_e_of_type_Int = (SearchResultAdapter.f + 1);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new ikn(this);
  }
  
  private void h()
  {
    this.jdField_e_of_type_AndroidViewView = getLayoutInflater().inflate(2130904934, this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView, false);
    this.jdField_e_of_type_AndroidViewView.setVisibility(4);
    ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131300896)).setText("搜索");
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(this.jdField_e_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_e_of_type_AndroidViewView.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new iku(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130904469);
    Object localObject1 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    ((WindowManager.LayoutParams)localObject1).dimAmount = 0.0F;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297082);
    Object localObject2 = (View)this.jdField_b_of_type_AndroidViewView.getParent();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297767));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298458));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298334);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int k = this.jdField_b_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -k);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -k, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localObject1 = (InputMethodManager)getSystemService("input_method");
    ikv localikv = new ikv(this, localTranslateAnimation1, (View)localObject2, localTranslateAnimation2, k);
    localTranslateAnimation1.setAnimationListener(localikv);
    localTranslateAnimation2.setAnimationListener(localikv);
    ((View)localObject2).startAnimation(localTranslateAnimation1);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ikw(this, (View)localObject2, k, localTranslateAnimation2, (InputMethodManager)localObject1));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300895));
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new iky(this));
    this.jdField_b_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
    localObject2 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300876);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297765));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298733));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130837958));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ikz(this, (InputMethodManager)localObject1));
    StoryReportor.a("search", "clk", 0, 0, new String[0]);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.c();
  }
  
  public void a()
  {
    if (NetworkUtil.h(this))
    {
      ArrayList localArrayList = new ArrayList();
      qqstory_pgc.SearchType localSearchType = new qqstory_pgc.SearchType();
      localSearchType.search_type.set(0);
      localSearchType.start_cookie.set(ByteStringMicro.copyFromUtf8(""));
      localSearchType.search_count.set(this.jdField_e_of_type_Int);
      localArrayList.add(localSearchType);
      localSearchType = new qqstory_pgc.SearchType();
      localSearchType.search_type.set(1);
      localSearchType.start_cookie.set(ByteStringMicro.copyFromUtf8(""));
      localSearchType.search_count.set(this.jdField_e_of_type_Int);
      localArrayList.add(localSearchType);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_JavaLangString, localArrayList);
      return;
    }
    ToastUtil.a().a("当前网络不可用，请检查你的网络设置");
  }
  
  public void a(UserInfo paramUserInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramUserInfo.type, paramUserInfo.unionId, paramInt, 1);
  }
  
  protected void a(Map paramMap)
  {
    super.a(paramMap);
    paramMap.put(new ila(this, this), "");
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    StoryReportor.a("hall", "refresh", 0, 0, new String[0]);
    j();
  }
  
  public void c()
  {
    QQStoryManager localQQStoryManager = (QQStoryManager)this.app.getManager(180);
    if (!localQQStoryManager.c())
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.6F, 1.0F, 1.6F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(1000L);
      localScaleAnimation.setRepeatCount(-1);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.8F, 0.0F);
      localAlphaAnimation.setDuration(1000L);
      localAlphaAnimation.setRepeatCount(-1);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.addAnimation(localScaleAnimation);
      this.jdField_d_of_type_AndroidViewView.startAnimation(localAnimationSet);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new iko(this));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new ikp(this));
      localQQStoryManager.c();
      this.jdField_e_of_type_Boolean = true;
      StoryReportor.a("new_guide", "press_exp", 0, 0, new String[0]);
    }
  }
  
  public void d()
  {
    if (this.f) {
      return;
    }
    this.f = true;
    this.jdField_d_of_type_AndroidViewView.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_c_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new ikq(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904435);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131302734));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)findViewById(2131302735));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298335);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131301792);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)super.findViewById(2131302729));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302730));
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter = new DiscoverAdapter();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setSmoothScrollbarEnabled(true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter.a(new ikl(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter.a(new ikr(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterDiscoverAdapter.a(new iks(this));
    super.setClickableTitle("发现", new ikt(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter = new SearchResultAdapter(this, this.app, SearchResultAdapter.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
    this.app.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    j();
    ((StoryManager)SuperManager.a(5)).a(1);
    ((PreloadDownloaderManager)SuperManager.a(6)).b(this, 2);
    paramBundle = getIntent();
    if (paramBundle != null) {
      StoryReportor.a("hall", "exp", paramBundle.getIntExtra("key_from", 0), 0, new String[0]);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.dismiss();
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPgcAdapterSearchResultAdapter.b();
    ((StoryManager)SuperManager.a(5)).a(0);
    ((PreloadDownloaderManager)SuperManager.a(6)).b(2);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    this.jdField_d_of_type_Boolean = false;
    super.doOnResume();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.E, 2, "QQStoryDiscoverActivity: onActivityResult start");
    }
    if (1 == paramInt1)
    {
      int m = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.getChildCount();
      int k = 0;
      while (k < m)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.getChildAt(k) instanceof BaseDiscoverFrameLayout)) {
          ((BaseDiscoverFrameLayout)this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.getChildAt(k)).setChildrenVisible();
        }
        k += 1;
      }
    }
    if ((paramInt1 == 2) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_c_of_type_Boolean = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.E, 2, "QQStoryDiscoverActivity: onActivityResult end");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300880: 
      this.jdField_b_of_type_AndroidWidgetEditText.setText("");
      return;
    case 2131300876: 
      this.jdField_a_of_type_AndroidAppDialog.cancel();
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_e_of_type_Boolean))
    {
      d();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\QQStoryDiscoverActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */