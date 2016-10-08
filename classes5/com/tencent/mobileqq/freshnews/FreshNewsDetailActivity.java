package com.tencent.mobileqq.freshnews;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.nearby.picbrowser.NearbyPicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import soj;
import sok;
import sol;
import som;
import son;
import soo;
import sop;
import soq;
import sor;
import sos;
import sot;
import sou;
import sov;
import sow;
import sox;
import soy;
import soz;
import spa;
import spc;
import spd;
import spe;
import spg;
import sph;
import spi;
import spj;

public class FreshNewsDetailActivity
  extends NearbyTitleBarActivity
  implements View.OnClickListener, FreshNewsDetailCommentItem.IFreshNewsDetailCommentItemCallback, QQInputView.IQQInputCallback, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ActionSheet.OnButtonClickListener, ListView.OnScrollChangeListener
{
  public static final int a = 0;
  public static final String a = "FreshNewsDetailActivity";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 1;
  public static final int j = 2;
  static final int jdField_k_of_type_Int = 1;
  static final int jdField_l_of_type_Int = 2;
  static final int t = 0;
  static final int u = 1;
  public long a;
  public Dialog a;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DatingCommentTextView jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView;
  public InputBar a;
  public FreshNewsComment a;
  public FreshNewsDetailCommentAdapter a;
  public FreshNewsHandler a;
  public FreshNewsInfo a;
  public FreshNewsManager a;
  FreshNewsObserver jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver;
  public QQInputView a;
  public NearbyAppInterface a;
  NearbyProcObserver jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public PullRefreshHeader a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  public XListView a;
  Boolean jdField_a_of_type_JavaLangBoolean;
  public LinkedList a;
  boolean jdField_a_of_type_Boolean;
  public long b;
  public View b;
  public ImageView b;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  CustomImgView jdField_b_of_type_ComTencentWidgetCustomImgView;
  public String b;
  public boolean b;
  public View c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  public View e;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  View f;
  public TextView f;
  public boolean f;
  View jdField_g_of_type_AndroidViewView;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  View jdField_h_of_type_AndroidViewView;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  boolean jdField_h_of_type_Boolean;
  View jdField_i_of_type_AndroidViewView;
  TextView jdField_i_of_type_AndroidWidgetTextView;
  View j;
  View jdField_k_of_type_AndroidViewView;
  View jdField_l_of_type_AndroidViewView;
  public int m;
  View m;
  public int n;
  public int o;
  public int p;
  public int q;
  int r;
  public int s;
  
  public FreshNewsDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.n = 0;
    this.o = 0;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment = null;
    this.jdField_f_of_type_Boolean = false;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.jdField_a_of_type_JavaLangBoolean = null;
    this.s = -1;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new soj(this);
    this.jdField_a_of_type_AndroidOsHandler = new sou(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver = new spg(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver = new soz(this);
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface)
  {
    if ((paramContext != null) && (paramAppInterface != null)) {
      paramContext.getSharedPreferences("blacklist_" + paramAppInterface.a(), 0).edit().clear().commit();
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.hide();
    }
    if (this.s == 0) {
      switch (paramInt)
      {
      }
    }
    label449:
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
              do
              {
                return;
                this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8005784", "0X8005784", 0, 0, "", "", "", "");
                NewReportPlugin.a(this, true, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID), 202, "freshnews", this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo);
              } while ((paramInt != 1) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager == null));
              long l1 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID;
              this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.h(l1);
              this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId;
              ThreadManager.a(new sot(this, l1), 8, null, false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X80061A6", "0X80061A6", 0, 0, "", "", "", "");
              finish();
              return;
            } while ((this.s != 1) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment == null) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger == null));
            if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long)) {
              break label449;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_Int & 0x1) != 1) {
              break;
            }
            if (paramInt == 0)
            {
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new sov(this), 100L);
              return;
            }
            if (paramInt == 1)
            {
              NewReportPlugin.a(this, true, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long), 203, "freshnews", this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment);
              return;
            }
            if (paramInt == 3)
            {
              c("正在删除");
              this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_JavaLangString);
              return;
            }
          } while (paramInt != 2);
          a(this.s, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long);
          return;
          if (paramInt == 0)
          {
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new sow(this), 100L);
            return;
          }
          if (paramInt == 1)
          {
            NewReportPlugin.a(this, true, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long), 203, "freshnews", this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment);
            return;
          }
        } while (paramInt != 2);
        a(this.s, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_Int & 0x1) != 1) {
          break;
        }
        if (paramInt == 0)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new sox(this), 100L);
          return;
        }
      } while (paramInt != 1);
      c("正在删除");
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_JavaLangString);
      return;
    } while (paramInt != 0);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new soy(this), 100L);
  }
  
  public int a(AdapterView paramAdapterView, View paramView)
  {
    int i2 = paramAdapterView.a(paramView);
    int i1 = i2;
    if ((paramAdapterView instanceof ListView)) {
      i1 = i2 - ((ListView)paramAdapterView).m();
    }
    return i1;
  }
  
  public View a(AdapterView paramAdapterView, int paramInt)
  {
    int i1 = 0;
    while (i1 < paramAdapterView.getChildCount())
    {
      View localView = paramAdapterView.getChildAt(i1);
      if (paramInt == a(paramAdapterView, localView)) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, null);
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "getDefaultContent.content=" + str);
    }
    return str;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onInputViewHeightChanged.top=" + paramInt + ", mPosition=" + this.p);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new spj(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0) || (this.jdField_c_of_type_Boolean) || (this.l.getVisibility() != 0) || (this.r == 1) || (!NetworkUtil.e(this))) {
      return;
    }
    this.l.performClick();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onDecodeTaskCompleted uin=" + paramString + ", type=" + paramInt2);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if ((localObject != null) && ((localObject instanceof FreshNewsDetailCommentItem)))
        {
          localObject = (FreshNewsDetailCommentItem)localObject;
          if ((paramString != null) && (paramString.equals(((FreshNewsDetailCommentItem)localObject).a()))) {
            ((FreshNewsDetailCommentItem)localObject).a(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  void a(int paramInt, long paramLong)
  {
    int i2 = 1;
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      a(1, getString(2131367256), 100);
    }
    int i1;
    do
    {
      return;
      if (paramLong <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FreshNewsDetailActivity", 2, "pullToBlackList tinnyId:" + paramLong);
        }
        a(1, "无效的号码", 100);
        return;
      }
      Object localObject = getSharedPreferences("blacklist_" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0);
      i1 = i2;
      if (paramInt == 0)
      {
        i1 = i2;
        if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          localObject = ((SharedPreferences)localObject).getString(Long.toString(paramLong), "");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            b(1, 2131372192, 100);
            return;
          }
          c(getString(2131372190));
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b((String)localObject);
          i1 = 0;
        }
      }
    } while (i1 == 0);
    c(getString(2131372189));
    paramInt = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "blacklist_sequence", Integer.valueOf(0))).intValue();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(paramLong, paramInt);
  }
  
  public void a(int paramInt, FreshNewsComment paramFreshNewsComment)
  {
    if (paramFreshNewsComment == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onCommentMenuClick.comment.flag=" + paramFreshNewsComment.jdField_a_of_type_Int + ", commentid=" + paramFreshNewsComment.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131371351);
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long != paramFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369311);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131372187);
    }
    if ((paramFreshNewsComment.jdField_a_of_type_Int & 0x1) == 1) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131367499, 3);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment = paramFreshNewsComment;
    this.p = (paramInt + 1);
    paramFreshNewsComment = a(this.jdField_a_of_type_ComTencentWidgetXListView, paramInt);
    if (paramFreshNewsComment != null) {
      this.q = paramFreshNewsComment.getMeasuredHeight();
    }
    this.s = 1;
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    QQToast.a(this, paramInt1, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size())
      {
        FreshNewsComment localFreshNewsComment = (FreshNewsComment)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.get(i1);
        if (paramLong == localFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long)
        {
          FreshNewsInfo localFreshNewsInfo = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
          localFreshNewsInfo.commentCount -= 1;
          localArrayList.add(localFreshNewsComment);
        }
        i1 += 1;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.removeAll(localArrayList));
    d();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount);
  }
  
  void a(View paramView, int paramInt)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size();
    if (i1 == 1) {
      i1 = 300;
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList();
      int i2 = 0;
      while (i2 < this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size())
      {
        localObject = new PicInfo();
        ((PicInfo)localObject).jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(i2));
        ((PicInfo)localObject).jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(i2) + i1);
        localArrayList.add(localObject);
        i2 += 1;
      }
      if (i1 == 2) {
        i1 = 250;
      } else {
        i1 = 200;
      }
    }
    paramView = AnimationUtils.a(paramView);
    Object localObject = new Intent(this, NearbyPicBrowserActivity.class);
    ((Intent)localObject).putExtra("intent_param_index", paramInt);
    ((Intent)localObject).putExtra("intent_param_pic_infos", localArrayList);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramView);
    ((Intent)localObject).addFlags(536870912);
    startActivity((Intent)localObject);
    this.jdField_h_of_type_Boolean = true;
  }
  
  public void a(FreshNewsComment paramFreshNewsComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X800577F", "0X800577F", 0, 0, "", "", "", "");
    FreshNewsUtil.a(this, paramFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long, paramFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_JavaLangString, paramFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Int, paramFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.b, 34);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.r != paramInt) {
      this.r = paramInt;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(Long paramLong, String paramString, boolean paramBoolean)
  {
    if (paramLong.longValue() <= 0L) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = getSharedPreferences("blacklist_" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0);
      if (!paramBoolean)
      {
        localSharedPreferences.edit().remove(Long.toString(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID)).commit();
        return;
      }
    } while (TextUtils.isEmpty(paramString));
    localSharedPreferences.edit().putString(Long.toString(paramLong.longValue()), paramString).commit();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onSend.content=" + paramString);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.ownerFlag == 1) {
      bool = true;
    }
    while (!((FreshNewsManager)localObject).a(bool))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a();
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.cannotCommentTip)))
      {
        a(0, paramString.cannotCommentTip, 0);
        return;
        bool = false;
      }
      else
      {
        a(0, getString(2131372185), 0);
        return;
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b();
    if ((l1 > l2) && (l1 - l2 < 10000L))
    {
      a(0, getString(2131372186), 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.f();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size() > 0)) {}
    for (localObject = ((FreshNewsComment)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.get(0)).jdField_a_of_type_JavaLangString;; localObject = "")
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      if (this.o == 2)
      {
        paramString = FreshNewsUtil.a(true, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, (int)(System.currentTimeMillis() / 1000L), paramString, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, paramString, 20, (String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8005783", "0X8005783", 0, 0, "", "", "", "");
        return;
      }
      paramString = FreshNewsUtil.a(false, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, (int)(System.currentTimeMillis() / 1000L), paramString, "", 0L);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, paramString, 20, (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8005782", "0X8005782", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_m_of_type_AndroidViewView == null)
    {
      this.jdField_m_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904169, null);
      ((ImageView)this.jdField_m_of_type_AndroidViewView.findViewById(2131297535)).setImageResource(2130838205);
    }
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface)) {
      this.jdField_m_of_type_AndroidViewView.setBackgroundResource(2131427641);
    }
    for (;;)
    {
      TextView localTextView1 = (TextView)this.jdField_m_of_type_AndroidViewView.findViewById(2131298153);
      TextView localTextView2 = (TextView)this.jdField_m_of_type_AndroidViewView.findViewById(2131298160);
      localTextView1.setTextColor(getResources().getColor(2131427365));
      localTextView2.setTextColor(getResources().getColor(2131427365));
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter.a(this.jdField_m_of_type_AndroidViewView);
      localTextView1.setText(paramString1);
      localTextView2.setText(paramString2);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.j);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter.notifyDataSetChanged();
      return;
      this.jdField_m_of_type_AndroidViewView.setBackgroundResource(2131427640);
    }
  }
  
  void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_e_of_type_Boolean = true;
      this.n = 0;
      return;
    }
    int i1 = 1;
    while (i1 < paramList.size())
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, -AIOUtils.a(40.0F, getResources()), 0, 0.0F, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      ((CustomImgView)paramList.get(i1)).startAnimation(localTranslateAnimation);
      i1 += 1;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new spe(this, paramList), 100L);
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = new int[2];
    this.jdField_c_of_type_AndroidWidgetImageView.getLocationInWindow((int[])localObject1);
    TextView localTextView = new TextView(this);
    localTextView.setTextColor(getResources().getColor(2131427634));
    localTextView.setTextSize(1, 12.0F);
    Object localObject2 = new FrameLayout.LayoutParams(-2, -2);
    Object localObject3 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
    ((FrameLayout.LayoutParams)localObject2).leftMargin = (localObject1[0] + AIOUtils.a(3.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject2).topMargin = (localObject1[1] - ((Rect)localObject3).top);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    if (paramBoolean) {
      localTextView.setText("+1");
    }
    for (;;)
    {
      ((FrameLayout)getWindow().getDecorView()).addView(localTextView);
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - AIOUtils.a(40.0F, getResources()));
      localObject3 = new AnimationSet(true);
      ((AnimationSet)localObject3).addAnimation((Animation)localObject1);
      ((AnimationSet)localObject3).addAnimation((Animation)localObject2);
      ((AnimationSet)localObject3).setDuration(1000L);
      ((AnimationSet)localObject3).setAnimationListener(new spd(this, localTextView));
      localTextView.startAnimation((Animation)localObject3);
      return;
      localTextView.setText("-1");
    }
  }
  
  public String b()
  {
    if (this.o == 2) {}
    for (String str = String.format("回复%s：", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_JavaLangString });; str = "添加评论...")
    {
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsDetailActivity", 2, "getHint.hint=" + str);
      }
      return str;
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904167, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131296256);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297019));
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131296932));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301664));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298506));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301665);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298505));
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView = ((DatingCommentTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298722));
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301667);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301666));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301668));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301669));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301674));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301675));
    this.jdField_h_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301670);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301671));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301672));
    this.jdField_g_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301673);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301676));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131301679));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301680));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301681));
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301682);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_AndroidViewView);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301663));
    this.i = this.jdField_b_of_type_AndroidViewView.findViewById(2131301677);
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface))
    {
      this.i.setBackgroundResource(2131427636);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2131427636);
      return;
    }
    this.i.setBackgroundResource(2131427637);
    this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2131427637);
  }
  
  void b(int paramInt)
  {
    int i1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount();
    if ((i1 <= 0) || (i1 <= paramInt))
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.remove(paramInt);
      d();
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.size();
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    if (i2 > (((Rect)localObject1).right - AIOUtils.a(36.0F, getResources())) / AIOUtils.a(40.0F, getResources()))
    {
      localObject2 = (Long)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.get(i1);
      localObject1 = new CustomImgView(this);
      ((CustomImgView)localObject1).setBackgroundDrawable(getResources().getDrawable(2130840650));
      ((CustomImgView)localObject1).setTag(localObject2);
      ((CustomImgView)localObject1).setOnClickListener(this);
      ((CustomImgView)localObject1).setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 202, String.valueOf(localObject2), true));
      localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(30.0F, getResources()), AIOUtils.a(30.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(10.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(i1 * 40 + 10, getResources());
      ((CustomImgView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
    }
    localObject1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(paramInt);
    Object localObject2 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject2).setDuration(250L);
    ((ScaleAnimation)localObject2).setFillAfter(true);
    ((ScaleAnimation)localObject2).setInterpolator(new DecelerateInterpolator());
    ((View)localObject1).startAnimation((Animation)localObject2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new som(this, paramInt, i1), 100L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new son(this, paramInt), 350L);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    QQToast.a(this, paramInt1, paramInt2, 0).b(getTitleBarHeight());
  }
  
  public void b(int paramInt, FreshNewsComment paramFreshNewsComment)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onClickReplyCommentBtn.position=" + paramInt + ",nick=" + paramFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_JavaLangString + ",commentid=" + paramFreshNewsComment.jdField_a_of_type_JavaLangString);
    }
    this.o = 2;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment = paramFreshNewsComment;
    this.p = (paramInt + 1);
    paramFreshNewsComment = a(this.jdField_a_of_type_ComTencentWidgetXListView, paramInt);
    if (paramFreshNewsComment != null) {
      this.q = paramFreshNewsComment.getMeasuredHeight();
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.e();
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onInputViewHide.content=" + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, null, paramString);
    this.o = 1;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment = null;
    this.q = 0;
    this.p = 0;
    this.jdField_a_of_type_AndroidOsHandler.post(new sph(this));
  }
  
  void b(boolean paramBoolean)
  {
    int i2 = 8;
    TextView localTextView = (TextView)this.l.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.l.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.l.findViewById(2131298469);
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
  
  void c()
  {
    if ((this.jdField_m_of_type_Int == 0) || (this.jdField_m_of_type_Int == 2)) {
      d();
    }
    while (NetworkUtil.e(this))
    {
      if ((this.jdField_m_of_type_Int == 1) || (this.jdField_m_of_type_Int == 3))
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.b(this.j);
        c("正在加载...");
      }
      h();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.setVisibility(4);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void c(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FreshNewsDetailActivity", 2, paramString.toString());
    }
  }
  
  public void d()
  {
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_AndroidViewView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getTop());
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("input", 2, "updateUI inputBartop = " + this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getTop());
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.m() <= 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_AndroidViewView);
    }
    localObject1 = getResources().getDrawable(2130840650);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable((Drawable)localObject1);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 202, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID), true));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname))
    {
      localObject1 = new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname, 3, 16);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localObject1 = new StringBuilder(12);
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherGender != 1) {
        break label977;
      }
      ((StringBuilder)localObject1).append("女");
      label221:
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge > 0) {
        ((StringBuilder)localObject1).append(" ").append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge).append("岁");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherProfession > 0) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherProfession < 14)) {
        ((StringBuilder)localObject1).append(" ").append(com.tencent.mobileqq.util.NearbyProfileUtil.e[this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherProfession]);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherConstellation)) {
        ((StringBuilder)localObject1).append(" ").append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherConstellation);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherCharmLevel < 4) {
        break label1027;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherCharmLevel)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label409:
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.isPubNumber == 1)
        {
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          label428:
          if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commonId <= 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.common))) {
            break label1262;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.common);
          this.jdField_c_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commonId));
        }
        break;
      }
    }
    label686:
    label713:
    label749:
    label770:
    label816:
    label851:
    label890:
    label977:
    label1027:
    label1070:
    label1082:
    label1099:
    label1143:
    label1173:
    label1186:
    label1199:
    label1262:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(0));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      Object localObject2 = new SpannableStringBuilder();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((TopicInfo)localObject1).jdField_a_of_type_JavaLangString)))
      {
        ((SpannableStringBuilder)localObject2).append('#').append(((TopicInfo)localObject1).jdField_a_of_type_JavaLangString).append('#');
        if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
          this.jdField_a_of_type_AndroidContentResColorStateList = getResources().getColorStateList(2131428211);
        }
        ((SpannableStringBuilder)localObject2).setSpan(new DatingCommentTextView.TouchableSpan(this, this.jdField_a_of_type_AndroidContentResColorStateList), 0, ((SpannableStringBuilder)localObject2).length(), 33);
      }
      for (i1 = 1;; i1 = 0)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent.trim()))) {
          ((SpannableStringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent);
        }
        localObject2 = new QQText((CharSequence)localObject2, 3, 16);
        if (i1 != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setTag(localObject1);
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(LinkMovementMethod.getInstance());
          if ((i1 == 0) && (((QQText)localObject2).length() <= 0)) {
            break label1070;
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setVisibility(0);
          f();
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.isPubNumber != 1) {
            break label1082;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setText(FreshNewsUtil.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publishTime), true));
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.ownerFlag != 1) {
            break label1099;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText("删除");
          FreshNewsUtil.a(this, this.jdField_e_of_type_AndroidWidgetTextView);
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseFlag != 1) {
            break label1143;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840691);
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427634));
          FreshNewsUtil.a(this, this.jdField_e_of_type_AndroidWidgetTextView);
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount <= 0) {
            break label1173;
          }
          this.jdField_f_of_type_AndroidWidgetTextView.setText(FreshNewsUtil.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount));
          g();
          FreshNewsUtil.a(this, this.jdField_c_of_type_AndroidWidgetImageView);
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount <= 0) {
            break label1186;
          }
          this.jdField_g_of_type_AndroidWidgetTextView.setText(FreshNewsUtil.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount));
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount > 0) {
            break label1199;
          }
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList);
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter.a(null);
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter.notifyDataSetChanged();
          e();
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.setVisibility(0);
          return;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname);
          break;
          ((StringBuilder)localObject1).append("男");
          break label221;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840889);
          break label409;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840890);
          break label409;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840891);
          break label409;
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          break label409;
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
          break label428;
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setTag(null);
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(null);
          break label686;
          this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setVisibility(8);
          break label713;
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.strTimeDistance);
          break label749;
          this.jdField_e_of_type_AndroidWidgetTextView.setText("更多");
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.isPubNumber == 1)
          {
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
            break label770;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          break label770;
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840687);
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131428302));
          break label816;
          this.jdField_f_of_type_AndroidWidgetTextView.setText("赞");
          break label851;
          this.jdField_g_of_type_AndroidWidgetTextView.setText("评论");
          break label890;
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          this.jdField_h_of_type_AndroidWidgetTextView.setText("共" + this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount + "条评论");
        }
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 22) && (paramInt2 == 220)) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getAppRuntime();
    Bundle localBundle;
    if ((paramBundle instanceof NearbyAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramBundle);
      setContentView(2130904165);
      setTitle(2131371725);
      localBundle = getIntent().getExtras();
      this.jdField_m_of_type_Int = localBundle.getInt("from");
      if (this.jdField_m_of_type_Int != 3) {
        break label198;
      }
      paramBundle = localBundle.getString("feedId");
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo = new FreshNewsInfo();
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId = paramBundle;
      }
      if (QLog.isColorLevel()) {
        if ("doOnCreate.mFrom=" + this.jdField_m_of_type_Int + "FreshNewsInfo:" + this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo != null) {
          break label215;
        }
      }
    }
    label198:
    label215:
    for (paramBundle = "null";; paramBundle = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.toString())
    {
      QLog.d("FreshNewsDetailActivity", 2, paramBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo != null) {
        break label226;
      }
      finish();
      return false;
      throw new NullPointerException("NearbyAppInterface is null, appRuntime = " + paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo = ((FreshNewsInfo)localBundle.getParcelable("FreshNewsInfo"));
      break;
    }
    label226:
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("abp_flag", false);
    if (((this.jdField_m_of_type_Int == 3) && (!this.jdField_a_of_type_Boolean)) || (this.jdField_m_of_type_Int == 4)) {
      setLeftViewName(2131366637);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131301659);
      this.jdField_a_of_type_AndroidViewView.getRootView().setBackgroundResource(2130837958);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131301660));
      paramBundle = getResources().getDrawable(2130838317);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(paramBundle);
      paramBundle = getResources().getDrawable(2130837958);
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(paramBundle, false, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903729, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollChangeListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new spc(this));
      b();
      this.j = LayoutInflater.from(this).inflate(2130904246, null);
      this.j.setVisibility(0);
      this.k = this.j.findViewById(2131301964);
      ((TextView)this.k.findViewById(2131302100)).setText("暂无更多评论");
      this.l = this.j.findViewById(2131301965);
      this.l.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter = new FreshNewsDetailCommentAdapter(this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this, ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface));
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView = ((QQInputView)super.findViewById(2131301661));
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar = ((InputBar)this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.findViewById(2131297409));
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.setHintTextColor(Color.parseColor("#44608a"));
      }
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.setCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler = ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1));
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211));
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
      c();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
      return true;
      setLeftViewName(2131369273);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.f();
      String str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.a();
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, null, str);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      a(2, this.jdField_b_of_type_JavaLangString, 0);
      this.jdField_b_of_type_JavaLangString = null;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        break label49;
      }
    }
    label49:
    label276:
    do
    {
      return;
      int i3 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      Object localObject;
      if (i1 < i3)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
        if ((localObject instanceof CustomImgView)) {
          localArrayList.add((CustomImgView)localObject);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localObject instanceof LinearLayout))
          {
            localObject = (LinearLayout)localObject;
            int i4 = ((LinearLayout)localObject).getChildCount();
            int i2 = 0;
            while (i2 < i4)
            {
              View localView = ((LinearLayout)localObject).getChildAt(i2);
              if ((localView instanceof CustomImgView)) {
                localArrayList.add((CustomImgView)localView);
              }
              i2 += 1;
            }
          }
        }
      }
      i1 = 0;
      if (i1 < localArrayList.size())
      {
        localObject = (CustomImgView)localArrayList.get(i1);
        if ((localObject != null) && (((CustomImgView)localObject).a() != null) && ((((CustomImgView)localObject).a() instanceof URLDrawable)))
        {
          localObject = (URLDrawable)((CustomImgView)localObject).a();
          if (((URLDrawable)localObject).getStatus() == 2) {
            if (((URLDrawable)localObject).getTag() != null) {
              break label276;
            }
          }
        }
        for (localObject = "";; localObject = ((URLDrawable)localObject).getTag().toString())
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!this.jdField_a_of_type_JavaUtilLinkedList.contains(localObject))) {
            this.jdField_a_of_type_JavaUtilLinkedList.add(localObject);
          }
          i1 += 1;
          break;
        }
      }
    } while (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0);
    ThreadManager.a(new spa(this), 5, null, true);
  }
  
  public void e()
  {
    if (this.j == null) {}
    do
    {
      return;
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentWidgetXListView.n() <= 0) {
          this.jdField_a_of_type_ComTencentWidgetXListView.b(this.j);
        }
        this.j.setVisibility(0);
        if (this.jdField_c_of_type_Boolean)
        {
          b(true);
          return;
        }
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXListView.n() <= 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.j);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    boolean bool = this.jdField_g_of_type_Boolean;
    this.jdField_g_of_type_Boolean = false;
    int i4 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size();
    int i2;
    int i1;
    Object localObject1;
    if (i4 == 1)
    {
      i2 = FNDefaultItemBuilder.b;
      i1 = 300;
      if (i4 != 1) {
        break label303;
      }
      localObject1 = new CustomImgView(this);
      ((CustomImgView)localObject1).setTag(Integer.valueOf(0));
      ((CustomImgView)localObject1).setOnClickListener(this);
      ((CustomImgView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
      ((CustomImgView)localObject1).setBackgroundDrawable(getResources().getDrawable(2130840637));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    for (;;)
    {
      try
      {
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i2;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i2;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = getResources().getDrawable(2130840689);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getResources().getDrawable(2130840678);
        localObject2 = URLDrawable.getDrawable(NearbyImgDownloader.a((String)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(0) + i1), (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDownloadListener(new ImgDownloadListener(this));
        ((URLDrawable)localObject2).setTag(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(0));
        if ((bool) && (((URLDrawable)localObject2).getStatus() == 2)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        ((CustomImgView)localObject1).setImageDrawable((Drawable)localObject2);
        return;
      }
      catch (Exception localException1)
      {
        ((CustomImgView)localObject1).setImageDrawable(getResources().getDrawable(2130840689));
        localException1.printStackTrace();
        return;
      }
      if (i4 == 2)
      {
        i2 = FNDefaultItemBuilder.c;
        i1 = 250;
        break;
      }
      i2 = FNDefaultItemBuilder.d;
      i1 = 200;
      break;
      label303:
      localObject1 = null;
      int i3 = 0;
      while (i3 < i4)
      {
        if (i3 % 3 == 0)
        {
          localObject1 = new LinearLayout(this);
          localObject3 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(3.0F, getResources());
          ((LinearLayout)localObject1).setOrientation(0);
          ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        }
        localObject3 = new CustomImgView(this);
        ((CustomImgView)localObject3).setTag(Integer.valueOf(i3));
        ((CustomImgView)localObject3).setOnClickListener(this);
        Object localObject4 = new LinearLayout.LayoutParams(i2, i2);
        ((LinearLayout.LayoutParams)localObject4).leftMargin = AIOUtils.a(1.5F, getResources());
        ((LinearLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(1.5F, getResources());
        ((CustomImgView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((CustomImgView)localObject3).setBackgroundDrawable(getResources().getDrawable(2130840637));
        ((LinearLayout)localObject1).addView((View)localObject3);
        try
        {
          localObject4 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = i2;
          ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = i2;
          ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = getResources().getDrawable(2130840689);
          ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = getResources().getDrawable(2130840678);
          localObject4 = URLDrawable.getDrawable(NearbyImgDownloader.a((String)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(i3) + i1), (URLDrawable.URLDrawableOptions)localObject4);
          ((URLDrawable)localObject4).setDownloadListener(new ImgDownloadListener(this));
          ((URLDrawable)localObject4).setTag(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(i3));
          if ((bool) && (((URLDrawable)localObject4).getStatus() == 2)) {
            ((URLDrawable)localObject4).restartDownload();
          }
          ((CustomImgView)localObject3).setImageDrawable((Drawable)localObject4);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((CustomImgView)localObject3).setImageDrawable(getResources().getDrawable(2130840689));
            localException2.printStackTrace();
          }
        }
        i3 += 1;
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130968587, 2130968588);
    }
  }
  
  void g()
  {
    int i2;
    Object localObject1;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList == null) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.size() <= 0))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i2 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.size();
      localObject1 = new Rect();
      getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      int i3 = (((Rect)localObject1).right - AIOUtils.a(36.0F, getResources())) / AIOUtils.a(40.0F, getResources());
      i1 = i2;
      if (i2 > i3) {
        i1 = i3;
      }
      if (i1 > 0) {
        break label134;
      }
    }
    label134:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      break;
      localObject1 = new ArrayList(10);
      i2 = 0;
      while (i2 < i1)
      {
        Object localObject2 = (Long)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.get(i2);
        CustomImgView localCustomImgView = new CustomImgView(this);
        localCustomImgView.setBackgroundDrawable(getResources().getDrawable(2130840650));
        localCustomImgView.setTag(localObject2);
        localCustomImgView.setOnClickListener(this);
        localCustomImgView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, 202, String.valueOf(localObject2), true));
        localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(30.0F, getResources()), AIOUtils.a(30.0F, getResources()));
        ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(10.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(9);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(i2 * 40 + 10, getResources());
        localCustomImgView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(localCustomImgView);
        ((ArrayList)localObject1).add(localCustomImgView);
        if ((this.n == 1) && (i2 == 0)) {
          localCustomImgView.setVisibility(4);
        }
        i2 += 1;
      }
    } while (this.n != 1);
    a((List)localObject1);
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/tencent/mobileqq/freshnews/FreshNewsDetailActivity:jdField_b_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 91	com/tencent/mobileqq/freshnews/FreshNewsDetailActivity:jdField_b_of_type_Boolean	Z
    //   19: aload_0
    //   20: getfield 289	com/tencent/mobileqq/freshnews/FreshNewsDetailActivity:jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler	Lcom/tencent/mobileqq/freshnews/FreshNewsHandler;
    //   23: aload_0
    //   24: getfield 214	com/tencent/mobileqq/freshnews/FreshNewsDetailActivity:jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo	Lcom/tencent/mobileqq/freshnews/FreshNewsInfo;
    //   27: getfield 242	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   30: invokevirtual 1594	com/tencent/mobileqq/freshnews/FreshNewsHandler:b	(Ljava/lang/String;)Z
    //   33: ifne -22 -> 11
    //   36: aload_0
    //   37: getfield 136	com/tencent/mobileqq/freshnews/FreshNewsDetailActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   40: iconst_1
    //   41: iconst_0
    //   42: iconst_0
    //   43: invokevirtual 1087	android/os/Handler:obtainMessage	(III)Landroid/os/Message;
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 136	com/tencent/mobileqq/freshnews/FreshNewsDetailActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   51: aload_1
    //   52: ldc2_w 658
    //   55: invokevirtual 1091	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   58: pop
    //   59: goto -48 -> 11
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	FreshNewsDetailActivity
    //   46	6	1	localMessage	Message
    //   62	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	62	finally
    //   14	59	62	finally
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onInputViewShow.");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new spi(this));
  }
  
  public void j()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FreshNewsDetailActivity", 2, localException.toString());
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558973);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903236);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296852);
      if (localTextView != null)
      {
        localTextView.requestFocus();
        localTextView.setText("确认删除这条新鲜事吗？");
      }
      localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297843);
      if (localTextView != null)
      {
        localTextView.setText(2131367262);
        localTextView.setOnClickListener(new sok(this));
      }
      localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297844);
      if (localTextView != null)
      {
        localTextView.setText(2131368306);
        localTextView.setOnClickListener(new sol(this));
      }
    }
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseFlag = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
    ((FreshNewsInfo)localObject).praiseCount -= 1;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount < 0) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
    String str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId;
    boolean bool;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseFlag == 1)
    {
      bool = true;
      ((FreshNewsManager)localObject).a(str, bool);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840687);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427467));
      long l2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = this.jdField_a_of_type_Long;
      }
      if (l1 == 0L) {
        break label331;
      }
      i1 = 0;
      label158:
      if (i1 >= this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.size()) {
        break label331;
      }
      if (((Long)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.get(i1)).longValue() != l1) {
        break label264;
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(FreshNewsUtil.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount));
      if (i1 != -1) {
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.size() > 1) {
          b(i1);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, false);
        return;
        bool = false;
        break;
        label264:
        i1 += 1;
        break label158;
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.remove(i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setText("赞");
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
          n();
        }
        for (;;)
        {
          d();
          break;
          this.jdField_e_of_type_Boolean = true;
        }
        d();
      }
      label331:
      i1 = -1;
    }
  }
  
  void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseFlag = 1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
    ((FreshNewsInfo)localObject).praiseCount += 1;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount > 0)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(FreshNewsUtil.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount));
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
      str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId;
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseFlag != 1) {
        break label235;
      }
    }
    long l1;
    label235:
    for (boolean bool = true;; bool = false)
    {
      ((FreshNewsManager)localObject).a(str, bool);
      p();
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, true);
      int i1 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.size();
      int i2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
      long l2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
      l1 = l2;
      if (l2 == 0L) {
        l1 = this.jdField_a_of_type_Long;
      }
      if (l1 != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseIdList.add(0, Long.valueOf(l1));
      }
      if ((i1 > 0) || (i2 == 0)) {
        break label247;
      }
      d();
      if (l1 == 0L) {
        break label241;
      }
      o();
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setText("赞");
      break;
    }
    label241:
    this.jdField_e_of_type_Boolean = true;
    return;
    label247:
    if (l1 != 0L)
    {
      this.n = 1;
      d();
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    d();
  }
  
  void n()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      int i1 = this.jdField_c_of_type_AndroidViewView.getHeight();
      int i2 = AIOUtils.a(50.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, i1 - i2 });
      localValueAnimator.setDuration(250L);
      localValueAnimator.addUpdateListener(new soo(this));
      localValueAnimator.addListener(new sop(this));
      localValueAnimator.start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_Boolean = true;
  }
  
  void o()
  {
    int i1 = this.jdField_c_of_type_AndroidViewView.getHeight();
    int i2 = AIOUtils.a(50.0F, getResources()) + i1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 11)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, i2 });
      localValueAnimator.setDuration(250L);
      localValueAnimator.addUpdateListener(new soq(this));
      localValueAnimator.addListener(new sor(this, i2));
      localValueAnimator.start();
      return;
    }
    this.jdField_e_of_type_Boolean = true;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("TAB", 1);
      localIntent.putExtra("abp_flag", true);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131301680: 
    default: 
      if (paramView == this.l) {
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
      }
      break;
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X800577F", "0X800577F", 0, 0, "", "", "", "");
          FreshNewsUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherID, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherGender, 34, 22);
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.ownerFlag == 1)
          {
            k();
            break;
          }
          if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369311);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369313);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          this.s = 0;
          break;
        } while (!this.jdField_e_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8005781", "0X8005781", 0, 0, "", "", "", "");
        this.jdField_e_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseFlag == 1)
        {
          l();
          break;
        }
        m();
        break;
        this.o = 1;
        this.p = 0;
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.e();
        break;
        localObject = paramView.getTag();
        if ((localObject == null) || (!(localObject instanceof TopicInfo))) {
          break;
        }
        NearbyTopicFeedActivity.a(this, (TopicInfo)localObject);
        break;
        if (!NetworkUtil.e(this))
        {
          paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 0L);
          return;
        }
        this.jdField_c_of_type_Boolean = true;
        e();
        int i1 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size();
        localObject = "";
        if (i1 > 0) {
          localObject = ((FreshNewsComment)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.get(i1 - 1)).jdField_a_of_type_JavaLangString;
        }
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, (String)localObject, 20, 0);
        localObject = paramView.getTag();
      } while (localObject == null);
      if ((localObject instanceof Integer))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X8005780", "0X8005780", 0, 0, "", "", "", "");
        a(paramView, ((Integer)localObject).intValue());
        return;
      }
    } while (!(localObject instanceof Long));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X800577F", "0X800577F", 0, 0, "", "", "", "");
    FreshNewsUtil.a(this, ((Long)localObject).longValue(), null, 0, 0, 34);
  }
  
  void p()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setInterpolator(new OvershootInterpolator());
    localScaleAnimation.setAnimationListener(new sos(this));
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */