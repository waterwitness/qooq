package com.tencent.mobileqq.nearby;

import EncounterSvc.RespEncounterInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.EncounterHolder;
import com.tencent.mobileqq.nearpeople.EncounterHolder.EncounterHolderOpt;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.List;
import tip;
import tiq;
import tir;
import tis;

public class SpecialNearbyListActivity
  extends NearbyTitleBarActivity
  implements Handler.Callback, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener, OverScrollViewListener
{
  public static final String a;
  static final long jdField_c_of_type_Long = 1000L;
  static final int jdField_d_of_type_Int = 1;
  static final int jdField_e_of_type_Int = 2;
  static final int jdField_f_of_type_Int = 3;
  static final int jdField_g_of_type_Int = 4;
  public int a;
  public long a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public PeopleAroundAdapter a;
  NearbyObserver jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new tis(this);
  public final SpecialNearbyListActivity.SpecialData a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  View b;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  View jdField_c_of_type_AndroidViewView;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean = false;
  View jdField_e_of_type_AndroidViewView;
  View jdField_f_of_type_AndroidViewView;
  View jdField_g_of_type_AndroidViewView;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SpecialNearbyListActivity.class.getSimpleName();
  }
  
  public SpecialNearbyListActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData = new SpecialNearbyListActivity.SpecialData();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.getCount() <= 1) || (this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_b_of_type_Boolean) || (this.e.getVisibility() != 0) || (this.jdField_c_of_type_Int != 2) || (!NetworkUtil.e(this))) {
      return;
    }
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "onScrollChanged req get more data", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Boolean.valueOf(this.jdField_c_of_type_Boolean) });
    }
    b(false, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      Object localObject;
      if (paramInt1 < i)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        if (localObject == null) {
          break label186;
        }
        localObject = ((View)localObject).getTag();
        if (!(localObject instanceof PeopleAroundAdapter.ViewHolder)) {
          break label186;
        }
        localObject = (PeopleAroundAdapter.ViewHolder)localObject;
        if (!((Boolean)((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getTag()).booleanValue()) {
          break label97;
        }
        if ((paramString == null) || (paramInt2 != ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break label186;
        }
      }
      label97:
      do
      {
        do
        {
          return;
          if ((paramString == null) || (paramInt2 != ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))) {
            break;
          }
        } while (paramBitmap == null);
        ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap(paramBitmap);
        ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setTag(Boolean.valueOf(true));
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "face updated, uin=" + ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString);
      return;
      label186:
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.jdField_b_of_type_Long);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt) {
      this.jdField_c_of_type_Int = paramInt;
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      if (paramInt == 0)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          paramAbsListView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt);
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
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  void a(boolean paramBoolean)
  {
    int j = 8;
    TextView localTextView = (TextView)this.e.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.e.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.e.findViewById(2131298469);
    if (paramBoolean)
    {
      i = 2131370686;
      localTextView.setText(i);
      if (!paramBoolean) {
        break label98;
      }
      i = 0;
      label68:
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break label105;
      }
    }
    label98:
    label105:
    for (int i = j;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
      i = 2131368205;
      break;
      i = 8;
      break label68;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Byte == 0)) {
      return;
    }
    ThreadManager.a(new tiq(this, paramBoolean1), 8, null, true);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.f == null) {
          this.f = getLayoutInflater().inflate(2130904227, null);
        }
        TextView localTextView = (TextView)this.f.findViewById(2131298153);
        localTextView.setText(getString(2131371562));
        localTextView.setTextColor(getResources().getColor(2131428302));
        this.f.findViewById(2131298160).setVisibility(4);
        this.f.setOnClickListener(null);
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.f);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!paramBoolean2) {
        a(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_JavaUtilList, paramBoolean1);
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(null);
      break;
      if (paramBoolean3)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_b_of_type_Boolean)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.e.setVisibility(0);
        }
        else
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.e.setVisibility(8);
        }
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.jdField_b_of_type_Long);
    if (NetworkUtil.e(this))
    {
      b(true, true);
      return true;
    }
    paramView = Message.obtain();
    paramView.what = 2;
    paramView.arg1 = 0;
    paramView.arg2 = 1;
    paramView.obj = getString(2131368597);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1000L);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.jdField_b_of_type_Long);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      return;
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      startTitleProgress();
    }
    if (!paramBoolean1) {
      a(true);
    }
    a(paramBoolean1, paramBoolean2);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label144;
        }
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_JavaUtilList.get(0);
        if (!(paramIntent instanceof RespEncounterInfo)) {
          break label144;
        }
        paramIntent = (RespEncounterInfo)paramIntent;
        if ((paramIntent.lEctID <= 0L) || (!String.valueOf(paramIntent.lEctID).equals(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount()))) {
          break label144;
        }
      }
    }
    label144:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (NetworkUtil.e(this))) {
        b(true, false);
      }
      ThreadManager.a(new tip(this), 5, null, false);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2130904237);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298060);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131301927);
    this.jdField_a_of_type_ComTencentWidgetListView = ((FPSXListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297950));
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    Object localObject = getResources();
    paramBundle = ((Resources)localObject).getDrawable(2130838317);
    localObject = ((Resources)localObject).getDrawable(2130837958);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverscrollHeader(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView.setContentBackground((Drawable)localObject, false, false);
    this.jdField_a_of_type_ComTencentWidgetListView.setNeedCheckSpringback(true);
    paramBundle = getLayoutInflater();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)paramBundle.inflate(2130903729, this.jdField_a_of_type_ComTencentWidgetListView, false));
    this.jdField_c_of_type_AndroidViewView = paramBundle.inflate(2130904246, null);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131301964);
    this.e = this.jdField_c_of_type_AndroidViewView.findViewById(2131301965);
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.b(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter = new PeopleAroundAdapter(this, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, null, false, this, this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollChangeListener(this);
    localObject = getIntent();
    paramBundle = ((Intent)localObject).getStringExtra("neighbor_interest_name");
    byte b1 = ((Intent)localObject).getByteExtra("neighbor_interest_id", (byte)0);
    long l = ((Intent)localObject).getLongExtra("neighbor_sub_interest_id", 0L);
    int i = ((Intent)localObject).getIntExtra("param_mode", 3);
    localObject = ((Intent)localObject).getStringExtra("neighbor_interest_info");
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Byte = b1;
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_b_of_type_JavaLangString = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_JavaLangString = ((String)localObject);
    setTitle(this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_b_of_type_JavaLangString);
    setLeftViewName(2131366637);
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(false, true, true);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver, true);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (!NetworkUtil.e(this)) {
        break;
      }
      b(true, false);
      return bool;
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    QQToast.a(BaseApplication.getContext(), 1, getString(2131369008), 0).b(getTitleBarHeight());
    a(false, true, false);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 2;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "MSG_RESP", new Object[] { Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
      }
      boolean bool1;
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Boolean)
      {
        if (this.g == null) {
          this.g = getLayoutInflater().inflate(2130904222, null);
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.a(this.g);
          this.jdField_d_of_type_Boolean = true;
        }
        ((TextView)this.g.findViewById(2131301449)).setText(String.format(getString(2131372593), new Object[] { this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_c_of_type_JavaLangString }));
        this.g.findViewById(2131298590).setOnClickListener(this);
        if (paramMessage.arg1 != 1) {
          break label329;
        }
        bool1 = true;
        if (paramMessage.arg2 != 1) {
          break label335;
        }
        bool2 = true;
        if (!bool2) {
          break label341;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        if (bool1) {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 2;
        ((Message)localObject).arg1 = 0;
        if (!bool2) {
          break label352;
        }
        i = 2;
        ((Message)localObject).arg2 = i;
        if (!bool2) {
          break label357;
        }
      }
      for (paramMessage = null;; paramMessage = getString(2131368597))
      {
        ((Message)localObject).obj = paramMessage;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 800L);
        a(true, bool1, bool2);
        return true;
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
        if (this.g != null) {
          this.jdField_a_of_type_ComTencentWidgetListView.a(this.g);
        }
        this.jdField_d_of_type_Boolean = false;
        break;
        bool1 = false;
        break label197;
        bool2 = false;
        break label208;
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
        break label234;
        i = 1;
        break label255;
      }
    case 2: 
      label197:
      label208:
      label234:
      label255:
      label329:
      label335:
      label341:
      label352:
      label357:
      stopTitleProgress();
      this.jdField_a_of_type_ComTencentWidgetListView.H();
      if (!(paramMessage.obj instanceof String)) {
        break;
      }
    }
    for (Object localObject = (String)paramMessage.obj;; localObject = null)
    {
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      QQToast.a(BaseApplicationImpl.getContext(), j, (CharSequence)localObject, i).b(getTitleBarHeight());
      return true;
      if (paramMessage.arg1 == 1)
      {
        j = 1;
        label447:
        if (j == 0) {
          break label536;
        }
        localObject = "已添加至我的兴趣";
        this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Boolean = false;
        paramMessage = (Message)localObject;
        if (this.g != null)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.a(this.g);
          this.g = null;
          paramMessage = (Message)localObject;
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a()))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
          if (j != 0) {
            i = 1;
          }
          ((QQProgressNotifier)localObject).a(i, paramMessage, 0);
          return true;
          j = 0;
          break label447;
          label536:
          if (!(paramMessage.obj instanceof String)) {
            break label631;
          }
          localObject = (String)paramMessage.obj;
          paramMessage = (Message)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramMessage = "添加失败，请稍后重试。";
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
        }
        localObject = BaseApplicationImpl.getContext();
        if (j != 0) {}
        for (;;)
        {
          QQToast.a((Context)localObject, i, paramMessage, 0).b(getTitleBarHeight());
          return true;
          i = 1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
        return true;
        label631:
        paramMessage = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      if (!NetworkUtil.e(this)) {
        QQToast.a(BaseApplication.getContext(), 1, getString(2131369008), 0).b(getTitleBarHeight());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (NearbyUtils.a()) {
            NearbyUtils.a(jdField_a_of_type_JavaLangString, "onClick req get more data", new Object[0]);
          }
          b(false, true);
          return;
          if (paramView.getId() != 2131298590) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag == null);
        if (!NetworkUtil.e(this))
        {
          QQToast.a(BaseApplication.getContext(), 1, getString(2131369008), 0).b(getTitleBarHeight());
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131369749, 1000);
        this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_c_of_type_Boolean = true;
        paramView = new ArrayList(1);
        paramView.add(this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag);
        ((NearbyHandler)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3)).a(paramView, 1, 0);
        ThreadManager.a(new tir(this), 5, null, false);
        return;
      } while (!(paramView.getTag() instanceof PeopleAroundAdapter.ViewHolder));
      paramView = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
    } while (!(paramView.jdField_a_of_type_JavaLangObject instanceof EncounterHolder.EncounterHolderOpt));
    paramView = ((EncounterHolder.EncounterHolderOpt)paramView.jdField_a_of_type_JavaLangObject).a.encounter;
    NearbyCmdHelper.a(99, this, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramView, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\SpecialNearbyListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */