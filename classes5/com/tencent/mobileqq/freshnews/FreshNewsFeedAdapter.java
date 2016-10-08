package com.tencent.mobileqq.freshnews;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.data.FNADHotTopicItemData;
import com.tencent.mobileqq.freshnews.data.FNADNowItemData;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.data.FNHotChatItemData;
import com.tencent.mobileqq.freshnews.data.FNTopicItemData;
import com.tencent.mobileqq.freshnews.data.FreshNewsDataFactory;
import com.tencent.mobileqq.freshnews.feed.FNBaseItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.flat.canvas.AbstractUIElement;
import com.tencent.mobileqq.nearby.flat.canvas.UIElementView;
import com.tencent.mobileqq.nearby.picbrowser.NearbyPicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import spp;
import spq;
import spr;
import sps;
import spt;
import spu;
import spv;
import spw;
import spx;
import spy;
import sqb;
import sqc;

public class FreshNewsFeedAdapter
  extends BaseAdapter
{
  public static final int a = 1000;
  public static final String a = "Q.nearby.freshNews";
  public Dialog a;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public AppInterface a;
  public BaseActivity a;
  public FreshNewsFeedAdapter.OnPublishTopicListener a;
  public FreshNewsFeedFactory a;
  public FreshNewsInfo a;
  public FNBaseItemData a;
  public FNDefaultItemData a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressDialog a;
  public ActionSheet a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  protected Runnable a;
  public List a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  public FNBaseItemData b;
  private String jdField_b_of_type_JavaLangString;
  private View.OnClickListener c;
  
  public FreshNewsFeedAdapter(NearbyAppInterface paramNearbyAppInterface, BaseActivity paramBaseActivity, FaceDecoder paramFaceDecoder, int paramInt, ListView paramListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData = null;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new sqc(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new spt(this);
    this.c = new spu(this);
    this.jdField_a_of_type_JavaLangRunnable = new spv(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedFactory = new FreshNewsFeedFactory(paramInt);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(long paramLong, String paramString)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    do
    {
      return;
      if (paramLong > 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.nearby.freshNews", 2, "pullToBlackList tinnyId:" + paramLong);
    return;
    ThreadManager.a(new sqb(this, paramLong, paramString), 8, null, false);
  }
  
  private void a(AbstractUIElement paramAbstractUIElement, FNDefaultItemData paramFNDefaultItemData, int paramInt)
  {
    if (paramFNDefaultItemData.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject2;
    while (i < paramFNDefaultItemData.jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = new PicInfo();
      ((PicInfo)localObject2).a = ((String)paramFNDefaultItemData.jdField_a_of_type_JavaUtilList.get(i));
      ((PicInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)paramFNDefaultItemData.b.get(i));
      ((ArrayList)localObject1).add(localObject2);
      i += 1;
    }
    paramFNDefaultItemData = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NearbyPicBrowserActivity.class);
    paramFNDefaultItemData.putExtra("intent_param_index", paramInt);
    paramFNDefaultItemData.putExtra("intent_param_pic_infos", (Serializable)localObject1);
    localObject1 = paramAbstractUIElement.a();
    if ((localObject1 != null) && ((localObject1 instanceof UIElementView)))
    {
      localObject2 = AnimationUtils.a((UIElementView)localObject1);
      if (localObject2 != null)
      {
        paramInt = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
        i = paramAbstractUIElement.l() - paramAbstractUIElement.j();
        if ((paramInt >= ((UIElementView)localObject1).getHeight()) || (((Rect)localObject2).top >= ViewUtils.b() / 3)) {
          break label340;
        }
        if (paramInt < i) {
          break label299;
        }
        paramAbstractUIElement = new Rect(((Rect)localObject2).left + paramAbstractUIElement.i(), paramInt - i + ((Rect)localObject2).top, ((Rect)localObject2).left + paramAbstractUIElement.k(), ((Rect)localObject2).bottom);
      }
    }
    for (;;)
    {
      if (paramAbstractUIElement != null)
      {
        paramFNDefaultItemData.putExtra("KEY_THUMBNAL_BOUND", paramAbstractUIElement);
        paramFNDefaultItemData.putExtra("extra_is_image_center_crop", true);
      }
      paramFNDefaultItemData.addFlags(536870912);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramFNDefaultItemData);
      return;
      label299:
      paramAbstractUIElement = new Rect(((Rect)localObject2).left + paramAbstractUIElement.i(), ((Rect)localObject2).top, ((Rect)localObject2).left + paramAbstractUIElement.k(), ((Rect)localObject2).bottom);
      continue;
      label340:
      paramAbstractUIElement = new Rect(((Rect)localObject2).left + paramAbstractUIElement.i(), ((Rect)localObject2).top + paramAbstractUIElement.j(), ((Rect)localObject2).left + paramAbstractUIElement.k(), ((Rect)localObject2).top + paramAbstractUIElement.l());
    }
  }
  
  private void b(View paramView, FNBaseItemData paramFNBaseItemData)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setInterpolator(new OvershootInterpolator());
    localScaleAnimation.setAnimationListener(new spq(this, paramFNBaseItemData));
    paramView.startAnimation(localScaleAnimation);
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private void c(FNBaseItemData paramFNBaseItemData)
  {
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData = paramFNBaseItemData;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369311);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369313);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new spy(this));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public FNBaseItemData a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (FNBaseItemData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public FNBaseItemData a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      localObject1 = localObject2;
      if ((paramView.getTag(-1) instanceof Integer)) {
        localObject1 = a(((Integer)paramView.getTag(-1)).intValue());
      }
    }
    return (FNBaseItemData)localObject1;
  }
  
  public FNBaseItemData a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FNBaseItemData localFNBaseItemData = (FNBaseItemData)localIterator.next();
        if (paramString.equals(localFNBaseItemData.e)) {
          return localFNBaseItemData;
        }
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(int paramInt, FNDefaultItemData paramFNDefaultItemData)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNDefaultItemData = paramFNDefaultItemData;
    new QQInputPopupWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true, this.jdField_a_of_type_ComTencentWidgetListView, paramInt, null, null, new spr(this, paramFNDefaultItemData)).show();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "", "", "0X800577A", "0X800577A", 0, 0, "", "", "", "");
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "updateFaceBmp|publisherId:" + paramLong);
    }
    int i = 0;
    label50:
    View localView;
    FNBaseItemData localFNBaseItemData;
    if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      localFNBaseItemData = a(localView);
      if (localFNBaseItemData != null) {
        break label95;
      }
    }
    label95:
    while (localFNBaseItemData.jdField_a_of_type_Long != paramLong)
    {
      i += 1;
      break label50;
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedFactory.a(localFNBaseItemData).a(localView, paramBitmap);
  }
  
  public void a(View paramView, FNBaseItemData paramFNBaseItemData)
  {
    if ((paramView == null) || (paramFNBaseItemData == null)) {}
    FNBaseItemBuilder localFNBaseItemBuilder;
    do
    {
      return;
      localFNBaseItemBuilder = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedFactory.a(paramFNBaseItemData);
    } while (localFNBaseItemBuilder == null);
    localFNBaseItemBuilder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramFNBaseItemData, null);
  }
  
  public void a(FreshNewsFeedAdapter.OnPublishTopicListener paramOnPublishTopicListener)
  {
    if (paramOnPublishTopicListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter$OnPublishTopicListener = paramOnPublishTopicListener;
    }
  }
  
  public void a(FreshNewsInfo paramFreshNewsInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        FNBaseItemData localFNBaseItemData = (FNBaseItemData)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localFNBaseItemData.e.equals(paramFreshNewsInfo.feedId))
        {
          localFNBaseItemData.jdField_a_of_type_Int = paramFreshNewsInfo.publishState;
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(FNBaseItemData paramFNBaseItemData)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    int i = 0;
    label18:
    View localView;
    FNBaseItemData localFNBaseItemData;
    if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      localFNBaseItemData = a(localView);
      if (localFNBaseItemData != null) {
        break label59;
      }
    }
    label59:
    while (!localFNBaseItemData.equals(paramFNBaseItemData))
    {
      i += 1;
      break label18;
      break;
    }
    a(localView, paramFNBaseItemData);
  }
  
  public void a(String paramString)
  {
    if ((!b()) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      int i = 0;
      View localView;
      Object localObject;
      if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        localObject = a(localView);
        if (localObject == null) {}
        while (!paramString.equals(((FNBaseItemData)localObject).e))
        {
          i += 1;
          break;
        }
      }
      while (localView != null)
      {
        i = localView.getHeight();
        localObject = localView.getLayoutParams();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, 0 });
        localValueAnimator.addUpdateListener(new spp(this, (ViewGroup.LayoutParams)localObject, localView));
        localValueAnimator.addListener(new sps(this, paramString, (ViewGroup.LayoutParams)localObject, localView));
        localValueAnimator.setTarget(localView);
        localValueAnimator.setDuration(1000L);
        localValueAnimator.start();
        return;
        localView = null;
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
    d();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    int i = 0;
    label17:
    View localView;
    FNBaseItemData localFNBaseItemData;
    if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      localFNBaseItemData = a(localView);
      if (localFNBaseItemData != null) {
        break label54;
      }
    }
    for (;;)
    {
      i += 1;
      break label17;
      break;
      label54:
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedFactory.a(localFNBaseItemData).a(localView, localFNBaseItemData, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    }
  }
  
  public void b(FNBaseItemData paramFNBaseItemData)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData = paramFNBaseItemData;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558973);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903236);
      paramFNBaseItemData = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852);
      if (paramFNBaseItemData != null)
      {
        paramFNBaseItemData.requestFocus();
        paramFNBaseItemData.setText(2131372599);
      }
      paramFNBaseItemData = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297843);
      if (paramFNBaseItemData != null)
      {
        paramFNBaseItemData.setText(2131367262);
        paramFNBaseItemData.setOnClickListener(new spw(this));
      }
      paramFNBaseItemData = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297844);
      if (paramFNBaseItemData != null)
      {
        paramFNBaseItemData.setText(2131368306);
        paramFNBaseItemData.setOnClickListener(new spx(this));
      }
    }
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "FreshNewsFeedBaseItem showJuhua, tip = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
        }
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("FreshNews", 2, paramString.toString());
    return;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void c()
  {
    int i;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      i = ViewUtils.a();
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(Bitmap.createBitmap(i, i * 2 / 3, Bitmap.Config.RGB_565));
    }
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.s() - 10;
      i = j;
      if (j < 0) {
        i = 0;
      }
      int m = this.jdField_a_of_type_ComTencentWidgetListView.s() + 10;
      int k = i;
      j = m;
      if (m > ((List)localObject).size())
      {
        j = ((List)localObject).size();
        k = i;
      }
      while (k < j)
      {
        localObject = a(k);
        if (localObject != null) {
          ((FNBaseItemData)localObject).a(this.jdField_a_of_type_AndroidGraphicsCanvas);
        }
        k += 1;
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo = null;
      localObject = FreshNewsDataFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, (FreshNewsInfo)localObject);
    } while (localObject == null);
    ((FNBaseItemData)localObject).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList.add(0, localObject);
    notifyDataSetChanged();
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.nearby.freshNews", 2, localException.toString());
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    FNBaseItemData localFNBaseItemData = a(paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedFactory.a(localFNBaseItemData);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = a(paramInt);
    FNBaseItemBuilder localFNBaseItemBuilder = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedFactory.a(paramViewGroup);
    if ((paramViewGroup instanceof FNDefaultItemData)) {
      return localFNBaseItemBuilder.a(paramInt, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_Boolean, paramView, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if ((paramViewGroup instanceof FNHotChatItemData)) {
      return localFNBaseItemBuilder.a(paramInt, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_Boolean, paramView, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    if ((paramViewGroup instanceof FNTopicItemData)) {
      return localFNBaseItemBuilder.a(paramInt, paramViewGroup, null, this.jdField_a_of_type_Boolean, paramView, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.c);
    }
    if ((paramViewGroup instanceof FNADHotTopicItemData)) {
      return localFNBaseItemBuilder.a(paramInt, paramViewGroup, null, this.jdField_a_of_type_Boolean, paramView, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    }
    if ((paramViewGroup instanceof FNADNowItemData)) {
      return localFNBaseItemBuilder.a(paramInt, paramViewGroup, null, this.jdField_a_of_type_Boolean, paramView, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    }
    return localFNBaseItemBuilder.a(paramInt, Integer.valueOf(this.jdField_b_of_type_Int), null, this.jdField_a_of_type_Boolean, paramView, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
  }
  
  public int getViewTypeCount()
  {
    return 9;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsFeedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */