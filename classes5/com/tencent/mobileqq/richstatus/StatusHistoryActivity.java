package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.ImageItem;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import uiu;
import uiv;
import uiw;
import uix;
import uiy;
import uiz;
import uja;
import ujb;
import ujc;
import ujd;
import uje;
import ujf;
import ujh;

public class StatusHistoryActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, IIconListener, IStatusListener, ClickableColorSpanTextView.SpanClickListener, SlideDetectListView.OnScrollToTopListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  private static final int A = 1;
  private static final int B = 2;
  private static final int C = 3;
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 1000L;
  public static String a;
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "Q.richstatus.history";
  public static final int c = 2;
  public static final int d = 3;
  protected static final int e = 1;
  private static final String e = "key__entry_type";
  private static final String f = "key_uin";
  private static final int jdField_g_of_type_Int = 0;
  private static final String jdField_g_of_type_JavaLangString = "key_uin_name";
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 23;
  private static final int k = 24;
  private static final int l = 30;
  private static final int m = 7;
  private static final int r = 0;
  private static final int s = 1;
  private static final int t = 2;
  private static final int u = 3;
  private static final int v = 0;
  private static final int w = 1;
  private static final int x = 2;
  private static final int y = 3;
  private int D = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new uiz(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SignatureManager a;
  private SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new ujd(this);
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private StatusObserver jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private SlideDetectListView.OnSlideListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener = new ujb(this);
  public SlideDetectListView a;
  public AdapterView.OnItemClickListener a;
  Runnable jdField_a_of_type_JavaLangRunnable = new uja(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public ConcurrentHashMap a;
  public final MqqHandler a;
  private ujf jdField_a_of_type_Ujf;
  public boolean a;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public View.OnClickListener b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  protected boolean b;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ujc(this);
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  protected int f;
  private int n;
  private int o;
  private int p = 24;
  private int q;
  private int z = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "get_more";
  }
  
  public StatusHistoryActivity()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new uje(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new uiv(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载历史签名...");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843342);
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("暂无个性签名历史记录");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败，下拉重新加载。");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    paramString3 = new Intent(paramContext, StatusHistoryActivity.class);
    paramString3.putExtra("key_uin", paramString1);
    paramString3.putExtra("key__entry_type", paramInt);
    paramString3.putExtra("key_uin_name", paramString2);
    paramContext.startActivity(paramString3);
  }
  
  private void a(StatusHistoryActivity.ItemViewHolder paramItemViewHolder)
  {
    paramItemViewHolder.b = new ArrayList();
    if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.isFirstReadUins) {
      if (paramItemViewHolder.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        if (paramItemViewHolder.jdField_a_of_type_JavaUtilList.size() <= this.f) {
          break label102;
        }
        int i1 = 0;
        while (i1 < this.f - 1)
        {
          paramItemViewHolder.b.add(paramItemViewHolder.jdField_a_of_type_JavaUtilList.get(i1));
          i1 += 1;
        }
        paramItemViewHolder.b.add(jdField_a_of_type_JavaLangString);
      }
    }
    label102:
    do
    {
      do
      {
        do
        {
          return;
          paramItemViewHolder.b.addAll(paramItemViewHolder.jdField_a_of_type_JavaUtilList);
        } while ((this.jdField_b_of_type_JavaUtilHashMap.get(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId) == null) || (((Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId)).booleanValue()));
        paramItemViewHolder.b.add(jdField_a_of_type_JavaLangString);
        return;
      } while (paramItemViewHolder.jdField_a_of_type_JavaUtilList.size() <= 0);
      paramItemViewHolder.b.addAll(paramItemViewHolder.jdField_a_of_type_JavaUtilList);
    } while (((Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId)).booleanValue());
    paramItemViewHolder.b.add(jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    ThreadManager.a().post(new uiy(this));
  }
  
  private void b(StatusHistoryActivity.ItemViewHolder paramItemViewHolder)
  {
    Object localObject1 = paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    Object localObject2 = paramItemViewHolder.c.getLayoutParams();
    label217:
    Layout localLayout;
    if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null)
    {
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(this.q / paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.a * paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.b));
      ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramItemViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i1 = 17;
      if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId, i1, this.q, ((ViewGroup.LayoutParams)localObject1).height);
        if (localObject1 != null)
        {
          if (!(localObject1 instanceof URLDrawable)) {
            break label543;
          }
          localObject2 = (URLDrawable)localObject1;
          if (((URLDrawable)localObject2).getStatus() == 1)
          {
            SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, false);
            if (!TextUtils.isEmpty(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p)) {
              paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p));
            }
          }
          ((URLDrawable)localObject2).setURLDrawableListener(new uiw(this, paramItemViewHolder));
          paramItemViewHolder.c.setBackgroundDrawable((Drawable)localObject1);
          if ((SignatureManager.y != null) && (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId)))
          {
            i1 = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId;
            localObject1 = SignatureManager.y;
            localObject2 = SignatureManager.a;
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId, new Object[] { Integer.valueOf(i1), localObject1, localObject2 });
          }
        }
      }
    }
    else
    {
      SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, true);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffa8a8a8"));
      localLayout = SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, false, this.q);
      if (localLayout == null) {
        break label600;
      }
    }
    label405:
    label523:
    label543:
    label600:
    for (int i1 = localLayout.getLineCount();; i1 = 1)
    {
      float f1;
      if (i1 < 3)
      {
        i1 = 2;
        f1 = 0.35F;
        if ((localLayout != null) && (!TextUtils.isEmpty(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.s))) {
          break label523;
        }
      }
      for (((ViewGroup.LayoutParams)localObject1).height = ((int)(f1 * this.q));; ((ViewGroup.LayoutParams)localObject1).height = (localLayout.getHeight() + DisplayUtil.a(this, 77.0F)))
      {
        if (paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0")) {
          ((ViewGroup.LayoutParams)localObject1).height = (localLayout.getHeight() + DisplayUtil.a(this, 77.0F));
        }
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        paramItemViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
        if (i1 < 5)
        {
          i1 = 3;
          f1 = 0.46F;
          break label405;
        }
        i1 = 4;
        f1 = 0.577F;
        break label405;
      }
      SignatureManager.a(getResources(), paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.app, false);
      if (TextUtils.isEmpty(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p)) {
        break label217;
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p));
      break label217;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    stopTitleProgress();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(1, 2131368597);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
  }
  
  private void c()
  {
    if (this.jdField_d_of_type_JavaLangString == null) {
      return;
    }
    String str2 = this.jdField_d_of_type_JavaLangString;
    String str1 = str2;
    if (str2.length() == 0) {
      str1 = String.valueOf(this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
    str2 = getString(2131361994) + ":";
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(str2 + str1);
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramInt2 == 200) || (this.D != 0)) {}
    label148:
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount();
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= i1) {
          break label148;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(paramInt2).getTag();
        if ((localObject != null) && ((localObject instanceof StatusHistoryActivity.ItemViewHolder)))
        {
          localObject = (StatusHistoryActivity.ItemViewHolder)localObject;
          if (((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId == paramInt1)
          {
            if (((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView == null) {
              break;
            }
            ((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.history", 2, "onGetIcon.actionid=" + paramInt1);
            }
          }
        }
        paramInt2 += 1;
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(this.jdField_b_of_type_Long);
  }
  
  public void a(int paramInt, RichStatus paramRichStatus, String paramString)
  {
    this.rightViewText.setEnabled(true);
    if (paramInt == 100) {
      a(true, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (Arrays.equals(((RichStatus)this.jdField_a_of_type_JavaUtilArrayList.get(0)).encode(), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.encode())))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        a(3);
        this.jdField_a_of_type_Ujf.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = paramClickableColorSpanTextView.getTag();
    if ((paramClickableColorSpanTextView instanceof StatusHistoryActivity.ItemViewHolder))
    {
      paramClickableColorSpanTextView = (StatusHistoryActivity.ItemViewHolder)paramClickableColorSpanTextView;
      if (paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId != 0) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this, this.jdField_c_of_type_JavaLangString, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId, paramClickableColorSpanTextView.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.D = paramInt;
    if ((this.n == 0) && (paramInt == 0))
    {
      URLDrawable.resume();
      this.jdField_a_of_type_Ujf.notifyDataSetChanged();
      a(true, 0L);
      return;
    }
    URLDrawable.pause();
    if (this.n > 0)
    {
      this.n -= 1;
      return;
    }
    a(false, 0L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, int paramInt, String paramString2, SignatureTemplateInfo.DynamicItem paramDynamicItem, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramString2 == null) || (paramDynamicItem == null) || (paramAIOAnimationConatiner == null)) {
      return;
    }
    paramAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(4), paramString1, Integer.valueOf(paramInt), paramString2, Boolean.valueOf(false), null, paramDynamicItem });
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      Object[] arrayOfObject = (Object[])((Map.Entry)localObject).getValue();
      int i1 = SignatureManager.a((String)((Map.Entry)localObject).getKey(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a());
      localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, i1));
      if ((localObject != null) && ((localObject instanceof StatusHistoryActivity.ItemViewHolder))) {
        ((StatusHistoryActivity.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
      } else if (QLog.isColorLevel()) {
        QLog.e("Q.richstatus.history", 2, "stopBubbleAnimation list view item's tag can not cast to ItemViewHolder, object:" + localObject);
      }
    }
    if (paramLong == 0L) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1;
    if (NetworkUtil.e(this)) {
      if (paramBoolean1)
      {
        l1 = 2147483647L;
        int i1 = (int)l1;
        StatusServlet.a(this.app, this.jdField_c_of_type_JavaLangString, 0, i1);
        label35:
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          a(1);
        }
        if (!paramBoolean2) {
          break label124;
        }
        stopTitleProgress();
      }
    }
    label124:
    while (!paramBoolean1)
    {
      return;
      l1 = ((RichStatus)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).time - 1L;
      break;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      if (paramBoolean1) {
        break label35;
      }
      this.z = 3;
      break label35;
    }
    startTitleProgress();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(this.jdField_b_of_type_Long);
    a(true, true);
    if (this.app.getAccount().equals(this.jdField_c_of_type_JavaLangString))
    {
      paramView = (SignatureHandler)this.app.a(41);
      if (paramView != null) {
        paramView.a();
      }
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(this.jdField_b_of_type_Long);
    this.n = 2;
  }
  
  public void b(int paramInt, boolean paramBoolean) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130905005);
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)this.app.getManager(57));
    this.q = (paramBundle.widthPixels - DisplayUtil.a(this, 97.0F));
    this.f = ((this.q - DisplayUtil.a(this, 90.0F)) / DisplayUtil.a(this, 37.0F));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_uin_name");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("key_uin");
    this.o = getIntent().getIntExtra("key__entry_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver = new ujh(this, null);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    setTitle("历史签名");
    if (this.app.a().equals(this.jdField_c_of_type_JavaLangString))
    {
      if (this.o != 0)
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText("写签名");
        this.rightViewText.setContentDescription("写签名");
        this.rightViewText.setOnClickListener(this);
      }
      this.p = 23;
    }
    ReportController.b(this.app, "CliOper", "", "", "Modify_signature", "Clk_signature_list", this.p, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((MutilayoutSlideDetectListView)findViewById(2131305029));
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130905000, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299796));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298735));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838325);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131305024));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131298776)).setTextColor(getResources().getColor(2131427409));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131298777)).setTextColor(getResources().getColor(2131427409));
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130905001, null);
    ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131305006)).setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131305004));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131305005));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_b_of_type_AndroidViewView, null, false);
    this.jdField_a_of_type_Ujf = new ujf(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Ujf);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnSlideListener);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new uiu(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    this.jdField_b_of_type_AndroidOsHandler = new uix(this, Looper.myLooper());
    b();
    c();
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    if (this.app.getAccount().equals(this.jdField_c_of_type_JavaLangString))
    {
      paramBundle = (SignatureHandler)this.app.a(41);
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
    findViewById(2131305026).setOnClickListener(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusObserver);
    URLDrawable.resume();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null)
    {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = null;
    }
    SignatureManager localSignatureManager = (SignatureManager)this.app.getManager(57);
    if (localSignatureManager != null) {
      localSignatureManager.a(null);
    }
    a(false, 0L);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    a(false, 0L);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    TextView localTextView = this.rightViewText;
    if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      this.jdField_b_of_type_Boolean = true;
      a(true, false);
      super.doOnResume();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return true;
        stopTitleProgress();
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
      } while (paramMessage.arg1 != 1);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        a(2);
      }
      a(1, 2131368597);
      return true;
    case 1: 
      this.jdField_a_of_type_Ujf.notifyDataSetChanged();
      return true;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("k_source", 4);
      paramView.setFlags(335544320);
      startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "signiture", "his_clk_write", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.e();
      }
    }
    do
    {
      return;
      if (paramView == findViewById(2131305026))
      {
        startActivity(new Intent(this, SigCommentListActivity.class));
        paramView.setVisibility(8);
        return;
      }
      if (paramView == findViewById(2131305024))
      {
        startActivity(new Intent(this, EditActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "signiture", "his_clk_blueadd", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        paramView = new Intent(this, FriendProfileCardActivity.class);
        paramView.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 5));
        startActivity(paramView);
        ReportController.b(this.app, "CliOper", "", "", "signiture", "his_clk_pp", 0, 0, "", "", "", "");
        return;
      }
    } while ((!(paramView.getTag() instanceof StatusHistoryActivity.MoreViewHolder)) || (this.z != 3));
    this.z = 1;
    this.jdField_a_of_type_Ujf.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\StatusHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */