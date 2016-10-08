package com.tencent.mobileqq.nearby.myvistor;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.List;
import tkl;
import tkm;
import tko;
import tkq;
import tkr;
import tks;

public class NearbyVisitorListActivity
  extends NearbyTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener
{
  public static final int a = 0;
  public static final String a = "glamourLevel";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "Q.nearby.visitor";
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public long a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  NearbyHandler jdField_a_of_type_ComTencentMobileqqAppNearbyHandler;
  private NearbyObserver jdField_a_of_type_ComTencentMobileqqAppNearbyObserver;
  NearbyVisitorAdapter jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private IIconDecoder.IIconListener jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener;
  public IIconDecoder a;
  public PullRefreshHeader a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  public PinnedHeaderExpandableListView a;
  public List a;
  public boolean a;
  public byte[] a;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  public boolean b;
  public long c;
  View c;
  public long d;
  View d;
  View e;
  public int f;
  int g;
  int h;
  public int i;
  
  public NearbyVisitorListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 0;
    this.g = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new tko(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new tkq(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new tkr(this);
    this.i = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener = new tks(this);
  }
  
  private void a(int paramInt)
  {
    if (this.f == paramInt) {}
    TextView localTextView1;
    View localView;
    TextView localTextView2;
    ViewGroup.LayoutParams localLayoutParams;
    label192:
    do
    {
      do
      {
        do
        {
          return;
          this.f = paramInt;
          localTextView1 = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131301961);
          localView = this.jdField_c_of_type_AndroidViewView.findViewById(2131301962);
          localTextView2 = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131301963);
          localView.setOnClickListener(this);
          localLayoutParams = this.jdField_c_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.height = DisplayUtil.a(this, 122.0F);
          if (paramInt != 1) {
            break label192;
          }
          if (this.h > 3) {
            break;
          }
          localTextView1.setVisibility(8);
          localView.setVisibility(0);
          localLayoutParams.height = DisplayUtil.a(this, 61.0F);
          localTextView2.setText(2131372405);
        } while (!AppSetting.j);
        localTextView1.setContentDescription(getString(2131372407));
        localView.setContentDescription(getString(2131372405) + "，连按两次来打开");
        return;
        localTextView1.setVisibility(8);
        localView.setVisibility(8);
      } while (!AppSetting.j);
      localTextView1.setContentDescription(getString(2131372406));
      return;
    } while (paramInt != 2);
    if (this.h <= 3)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() < 20)
      {
        localTextView1.setText(2131372406);
        localTextView2.setText(2131372405);
      }
      for (;;)
      {
        localView.setVisibility(0);
        localTextView1.setVisibility(0);
        if (!AppSetting.j) {
          break;
        }
        localTextView1.setContentDescription(localTextView1.getText());
        localView.setContentDescription(getString(2131372404) + "，连按两次来打开");
        return;
        localTextView1.setText(getString(2131372403, new Object[] { Integer.valueOf(20) }));
        localTextView2.setText(2131372404);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() < 200) {
      localTextView1.setText(2131372406);
    }
    for (;;)
    {
      localTextView1.setVisibility(0);
      localView.setVisibility(8);
      localLayoutParams.height = DisplayUtil.a(this, 61.0F);
      if (!AppSetting.j) {
        break;
      }
      localTextView1.setContentDescription(localTextView1.getText());
      return;
      localTextView1.setText(getString(2131372402, new Object[] { Integer.valueOf(200) }));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 8;
    TextView localTextView = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidViewView.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298469);
    if (paramBoolean)
    {
      j = 2131370686;
      localTextView.setText(j);
      if (!paramBoolean) {
        break label94;
      }
      j = 0;
      label65:
      localProgressBar.setVisibility(j);
      if (!paramBoolean) {
        break label101;
      }
    }
    label94:
    label101:
    for (int j = k;; j = 0)
    {
      localImageView.setVisibility(j);
      return;
      j = 2131368205;
      break;
      j = 8;
      break label65;
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      QQToast.a(this, getString(2131372521), 0).b(getTitleBarHeight());
      return;
    }
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
      QQToast.a(this, 1, getString(2131368597), 0).b(getTitleBarHeight());
    }
    startTitleProgress();
    if (!paramBoolean1) {
      a(true);
    }
    this.jdField_b_of_type_Boolean = true;
    if (paramBoolean1) {
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(NearbyDataManager.b, this.jdField_a_of_type_ArrayOfByte);
  }
  
  private void c()
  {
    ThreadManager.a(new tkm(this), null, true);
  }
  
  private void d()
  {
    String str;
    if (this.jdField_b_of_type_Long > 0L)
    {
      if (this.centerView.getVisibility() == 0) {
        this.centerView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_b_of_type_Long <= 99999L)
      {
        str = String.format(getString(2131372522), new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label180;
      }
      startTitleProgress();
      return;
      str = String.format(getString(2131372523), new Object[] { Float.valueOf((float)this.jdField_b_of_type_Long / 10000.0F) });
      break;
      if (this.centerView.getVisibility() == 8) {
        this.centerView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    label180:
    stopTitleProgress();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 == paramInt3) && (paramInt3 > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 1) && (!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_Boolean) && (this.g != 1)) {
      if (NetworkUtil.e(this)) {}
    }
    while ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0))
    {
      return;
      b(false, true);
    }
    if (paramInt1 != 0)
    {
      a(2);
      return;
    }
    a(1);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      Object localObject;
      if (paramInt1 < j)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.getChildAt(paramInt1);
        if (localObject == null) {
          break label177;
        }
        localObject = ((View)localObject).getTag();
        if (!(localObject instanceof NearbyVisitorAdapter.ChildItemHolder)) {
          break label177;
        }
        localObject = (NearbyVisitorAdapter.ChildItemHolder)localObject;
        if (!((Boolean)((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.getTag()).booleanValue()) {
          break label97;
        }
        if ((paramString == null) || (paramInt2 != ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break label177;
        }
      }
      label97:
      do
      {
        return;
        if ((paramString == null) || (paramInt2 != ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_Int) || (!paramString.equals(((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_JavaLangString))) {
          break;
        }
        ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        ((NearbyVisitorAdapter.ChildItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setTag(Boolean.valueOf(true));
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby.visitor", 2, "face updated, uin=" + paramString);
      return;
      label177:
      paramInt1 += 1;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.g != paramInt) {
      this.g = paramInt;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    TextView localTextView;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (this.e == null) {
        this.e = ((ViewStub)findViewById(2131302087)).inflate();
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      localTextView = (TextView)this.e.findViewById(2131299583);
      if (this.h <= 3)
      {
        localTextView.setText(2131372400);
        Button localButton = (Button)this.e.findViewById(2131301960);
        localButton.setOnClickListener(this);
        if (AppSetting.j)
        {
          localTextView.setContentDescription(getString(2131372400));
          localButton.setContentDescription("如何提升魅力值，按钮，连按两次来打开。");
        }
        this.e.setVisibility(0);
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        a(false);
      }
      d();
      if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter == null)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Long, this.jdField_d_of_type_Long);
      int j = 0;
      while (j < this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter.getGroupCount())
      {
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(j);
        j += 1;
      }
      localTextView.setText(2131372399);
      if (!AppSetting.j) {
        break;
      }
      localTextView.setContentDescription(getString(2131372399));
      break;
      if (paramBoolean2)
      {
        if (this.e != null) {
          this.e.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  protected void b()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    str = "http://ti.qq.com/meilizhigl/index.html?_wv=1027&isguest=[isguest]&uin=[uin]".replace("[isguest]", "0").replace("[uin]", str);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    startActivity(localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904260);
    this.h = getIntent().getIntExtra("glamourLevel", 0);
    setTitle(2131372398);
    setLeftViewName(2131366637);
    if (this.titleRoot != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.titleRoot.findViewById(2131297138));
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297829)).setText(2131372398);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297830));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder$IIconListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131302086));
    paramBundle = getResources().getDrawable(2130838317);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverscrollHeader(paramBundle);
    paramBundle = getResources().getDrawable(2130837958);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(paramBundle, false, true);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131302088);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903729, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904245, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301964);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301965);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter = new NearbyVisitorAdapter(this, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyMyvistorNearbyVisitorAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnScrollChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131302088);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnGroupClickListener(new tkl(this));
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler = ((NearbyHandler)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968587, 2130968588);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      b();
      this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X80061AA", "0X80061AA", 0, 0, "", "", "", "");
      return;
      b();
      if (this.f == 1)
      {
        this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X80061A9", "0X80061A9", 0, 0, "", "", "", "");
        return;
      }
    } while (this.f != 2);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X80061A8", "0X80061A8", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\myvistor\NearbyVisitorListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */