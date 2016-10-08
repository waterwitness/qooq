package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PromotionEmoticonPkg;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class RecommendEmotionAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  public static final String b = "RecommendEmotionAdapter";
  public static final int h = 85;
  public static final int i = 148;
  public static final int j = 100;
  public static final int k = 101;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  protected ProgressButton a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  protected List b;
  protected List c;
  private List d;
  private List e;
  protected int o;
  
  public RecommendEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.b = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.d = new ArrayList();
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.o = (this.f / paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)paramQQAppInterface.getManager(13));
  }
  
  private ImageView a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() < 1) || (paramPromotionEmoticonPkg == null) || (TextUtils.isEmpty(paramPromotionEmoticonPkg.a)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getRedPointViewByEp view or ep error");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "getRedPointViewByEp");
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(localImageView);
      if ((localPromotionEmoticonPkg != null) && (paramPromotionEmoticonPkg.a.equals(localPromotionEmoticonPkg.a))) {
        return localImageView;
      }
    }
    return null;
  }
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new LinearLayout.LayoutParams(this.o, (int)(148.0F * this.jdField_a_of_type_Float));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(85.0F * this.jdField_a_of_type_Float), (int)(85.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    ((RelativeLayout)localObject1).setId(2131296614);
    Object localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131303118);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131296615);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843321));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131303119);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(18.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    ((TextView)localObject1).setTextSize(15.0F);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new ProgressButton(this.jdField_a_of_type_AndroidContentContext);
    ((ProgressButton)localObject1).setId(2131303120);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.jdField_a_of_type_Float));
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    localLayoutParams.gravity = 1;
    ((ProgressButton)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838232));
    ((ProgressButton)localObject1).setTextColor(-14894864);
    ((ProgressButton)localObject1).setPadding((int)(this.jdField_a_of_type_Float * 15.0F), 0, (int)(this.jdField_a_of_type_Float * 15.0F), 0);
    ((ProgressButton)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((ProgressButton)localObject1).setTextSize(13.0F);
    ((ProgressButton)localObject1).setGravity(17);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    return localLinearLayout;
  }
  
  private ClubContentJsonTask.PromotionEmoticonPkg a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      paramView = paramView.getTag();
    } while (paramView == null);
    if ((paramView instanceof ClubContentJsonTask.PromotionEmoticonPkg)) {}
    for (paramView = (ClubContentJsonTask.PromotionEmoticonPkg)paramView;; paramView = null) {
      return paramView;
    }
  }
  
  private ProgressButton a(EmoticonPackage paramEmoticonPackage)
  {
    if ((this.b == null) || (this.b.size() < 1) || (paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getProgressButton view or ep error");
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ProgressButton localProgressButton = (ProgressButton)localIterator.next();
      ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(localProgressButton);
      if ((localPromotionEmoticonPkg != null) && (paramEmoticonPackage.epId.equals(localPromotionEmoticonPkg.a))) {
        return localProgressButton;
      }
    }
    return null;
  }
  
  private void a(View paramView, ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if ((paramView == null) || (paramPromotionEmoticonPkg == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null)
    {
      if (!a()) {
        break label391;
      }
      if (!this.jdField_e_of_type_JavaUtilList.contains(paramPromotionEmoticonPkg))
      {
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(paramPromotionEmoticonPkg);
        this.jdField_e_of_type_JavaUtilList.add(paramPromotionEmoticonPkg);
      }
    }
    Object localObject;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "updateUI epid = " + paramPromotionEmoticonPkg.a + "expose num = " + paramPromotionEmoticonPkg.s);
      }
      paramView.setVisibility(0);
      localObject = (URLImageView)paramView.findViewById(2131303118);
      Drawable localDrawable1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841690);
      Drawable localDrawable2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841691);
      ((URLImageView)localObject).setImageDrawable(URLDrawable.getDrawable(paramPromotionEmoticonPkg.b, localDrawable1, localDrawable2));
      ((URLImageView)localObject).setTag(paramPromotionEmoticonPkg);
      ((URLImageView)localObject).setOnClickListener(this);
      ((TextView)paramView.findViewById(2131303119)).setText(paramPromotionEmoticonPkg.c);
      ((URLImageView)localObject).setContentDescription(paramPromotionEmoticonPkg.c);
      localObject = (ProgressButton)paramView.findViewById(2131303120);
      ((ProgressButton)localObject).setText(paramPromotionEmoticonPkg.d);
      ((ProgressButton)localObject).setTag(paramPromotionEmoticonPkg);
      ((ProgressButton)localObject).setContentDescription(paramPromotionEmoticonPkg.d);
      ((ProgressButton)localObject).setOnClickListener(this);
      ((ProgressButton)localObject).setProgressColor(-16745986);
      if ((this.b != null) && (!this.b.contains(localObject))) {
        this.b.add(localObject);
      }
      paramView = (ImageView)paramView.findViewById(2131296615);
      paramView.setVisibility(8);
      paramView.setTag(paramPromotionEmoticonPkg);
      if (paramPromotionEmoticonPkg.r == 1) {
        paramView.setVisibility(0);
      }
      if ((this.jdField_c_of_type_JavaUtilList != null) && (!this.jdField_c_of_type_JavaUtilList.contains(paramView))) {
        this.jdField_c_of_type_JavaUtilList.add(paramView);
      }
      float f = ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramPromotionEmoticonPkg.a);
      if (f < 0.0F) {
        break;
      }
      ((ProgressButton)localObject).setProgress((int)f);
      ((ProgressButton)localObject).setText("取消");
      return;
      label391:
      if (!this.d.contains(paramPromotionEmoticonPkg)) {
        this.d.add(paramPromotionEmoticonPkg);
      }
    }
    ((ProgressButton)localObject).setText(paramPromotionEmoticonPkg.d);
    ((ProgressButton)localObject).setProgress(0);
  }
  
  private void a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    boolean bool = true;
    Intent localIntent = null;
    if (paramPromotionEmoticonPkg.n == 4)
    {
      localIntent = new Intent();
      localIntent.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if (paramPromotionEmoticonPkg.n == 4) {}
      for (;;)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, paramPromotionEmoticonPkg.a, false, localIntent, bool);
        return;
        bool = false;
      }
    }
    QLog.e("RecommendEmotionAdapter", 1, "openEmoticonDetailPage error : context not activity");
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo) == this.jdField_e_of_type_Int) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    return ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramPromotionEmoticonPkg.a) >= 0.0F;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    paramViewGroup = (RecommendEmotionAdapter.RecommendEmotionViewHolder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.a().a(this.jdField_e_of_type_Int);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        m = 0;
        for (;;)
        {
          paramViewHolder = paramView;
          if (m >= this.jdField_c_of_type_Int) {
            break label275;
          }
          try
          {
            paramViewHolder = a();
            paramViewHolder.setVisibility(8);
            localObject = new LinearLayout.LayoutParams(this.o, -1);
            if (paramInt == 0) {}
            for (((LinearLayout.LayoutParams)localObject).topMargin = ((int)(22.0F * this.jdField_a_of_type_Float));; ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * this.jdField_a_of_type_Float)))
            {
              paramView.addView(paramViewHolder, (ViewGroup.LayoutParams)localObject);
              m += 1;
              break;
            }
            return paramView;
          }
          catch (Exception paramViewHolder)
          {
            QLog.e("RecommendEmotionAdapter", 1, "getEmotionView ; position = " + paramInt + "; has exception ,e = " + paramViewHolder.getMessage());
            paramView = null;
          }
        }
      }
      paramViewHolder = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
        paramViewHolder = paramView;
      }
      label275:
      a(this.jdField_e_of_type_Int, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.a = new LinearLayout[this.jdField_c_of_type_Int];
      m = 0;
      while (m < this.jdField_c_of_type_Int)
      {
        paramViewGroup.a[m] = ((LinearLayout)paramView.getChildAt(m));
        m += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
    }
    int m = 0;
    int n;
    for (;;)
    {
      paramView = paramViewHolder;
      if (m >= this.jdField_c_of_type_Int) {
        break;
      }
      n = this.jdField_c_of_type_Int * paramInt + m;
      if (n <= this.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label420;
      }
      paramViewGroup.a[m].setTag(null);
      paramViewGroup.a[m].setVisibility(8);
      m += 1;
    }
    label420:
    Object localObject = paramViewGroup.a[m];
    paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(n);
    if ((paramView instanceof ClubContentJsonTask.PromotionEmoticonPkg)) {}
    for (paramView = (ClubContentJsonTask.PromotionEmoticonPkg)paramView;; paramView = null)
    {
      a((View)localObject, paramView);
      if (paramView == null) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, paramView.a, paramInt + "", "", paramView.r + "");
      break;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new RecommendEmotionAdapter.RecommendEmotionViewHolder();
  }
  
  public void a()
  {
    super.a();
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 17)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "paback");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton == null) {
        QLog.e("RecommendEmotionAdapter", 1, "payBack view is null");
      }
    }
    else
    {
      return;
    }
    ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton);
    if (localPromotionEmoticonPkg == null)
    {
      QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, localPromotionEmoticonPkg.a, "", "", "0");
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton, localPromotionEmoticonPkg, true);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt == 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(ProgressButton paramProgressButton, ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg, boolean paramBoolean)
  {
    if ((paramProgressButton == null) || (paramPromotionEmoticonPkg == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "downloadOrPay epid = " + paramPromotionEmoticonPkg.a);
    }
    if ((paramPromotionEmoticonPkg.o == 2) || (paramPromotionEmoticonPkg.o == 6))
    {
      a(paramPromotionEmoticonPkg);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, paramPromotionEmoticonPkg.a, "", "", paramPromotionEmoticonPkg.r + "");
      return;
    }
    boolean bool = false;
    int m = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).h();
    Object localObject = "vip";
    String str;
    if (paramPromotionEmoticonPkg.n == 4) {
      str = "mvip.gexinghua.android.sbq_" + paramPromotionEmoticonPkg.a;
    }
    for (;;)
    {
      label189:
      if (paramPromotionEmoticonPkg.o == 4)
      {
        localObject = "!vip";
        if ((m != 1) && (m != 3)) {
          break label826;
        }
        bool = true;
        localObject = "!vip";
      }
      label826:
      for (;;)
      {
        EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
        EmoticonPackage localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.jobType = paramPromotionEmoticonPkg.n;
        localEmoticonPackage.epId = paramPromotionEmoticonPkg.a;
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "canDownload:" + bool + ",vipType:" + m + ",isPayBack:" + paramBoolean);
        }
        if (a(paramPromotionEmoticonPkg))
        {
          localEmojiManager.a(localEmoticonPackage.epId);
          paramProgressButton.setText(paramPromotionEmoticonPkg.d);
          paramProgressButton.setProgress(0);
          if (paramBoolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800581D", 0, 0, paramPromotionEmoticonPkg.a, "", "", "");
            return;
            if ((paramPromotionEmoticonPkg.n != 3) && (paramPromotionEmoticonPkg.n != 0) && (paramPromotionEmoticonPkg.n != 5)) {
              break label829;
            }
            str = "mvip.gxh.android.bqmall_aio_" + paramPromotionEmoticonPkg.a;
            break label189;
            if (paramPromotionEmoticonPkg.o == 5)
            {
              localObject = "!svip";
              if (m != 3) {
                break label826;
              }
              bool = true;
              localObject = "!svip";
              continue;
            }
            bool = true;
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005817", 0, 0, paramPromotionEmoticonPkg.a, "", "", "");
          return;
        }
        if (bool)
        {
          localObject = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
          if (localEmoticonPackage.type != 4) {
            ((EmoticonHandler)localObject).a(localEmoticonPackage.epId);
          }
          localEmojiManager.a(localEmoticonPackage, true);
          paramProgressButton.setText("取消");
          paramProgressButton.setProgressColor(-16745986);
          if (!paramBoolean) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, paramPromotionEmoticonPkg.a, "", "", "");
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8006139", 0, 0, paramPromotionEmoticonPkg.a, "", "", "");
          return;
        }
        if (paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = paramProgressButton;
        paramProgressButton = "http://mc.vip.qq.com/qqwallet/index?aid=" + str + "&type=" + (String)localObject + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk&debug=1";
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramProgressButton);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 4779);
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "func downloadOrPay. mCurPageIndex: epid = " + paramPromotionEmoticonPkg.a);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005815", 0, 0, paramPromotionEmoticonPkg.a, "", "", "");
        return;
      }
      label829:
      str = "";
    }
  }
  
  public void c()
  {
    Object localObject;
    if (this.d.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected invisiableExposeList size > 0");
      }
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = (ClubContentJsonTask.PromotionEmoticonPkg)((Iterator)localObject).next();
        if (!this.jdField_e_of_type_JavaUtilList.contains(localPromotionEmoticonPkg))
        {
          this.jdField_e_of_type_JavaUtilList.add(localPromotionEmoticonPkg);
          if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localPromotionEmoticonPkg);
          }
        }
      }
      this.d.clear();
    }
    label259:
    label365:
    label369:
    for (;;)
    {
      return;
      localObject = a();
      if (localObject != null)
      {
        int m = ((ListView)localObject).s();
        int n = ((ListView)localObject).t();
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstShowPosition = " + m + ";lastShowPosition = " + n);
        }
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_e_of_type_JavaUtilList.clear();
          m = this.jdField_c_of_type_Int * m;
          int i2 = this.jdField_c_of_type_Int * (n + 1) - 1;
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstDataPosition = " + m + ";lastDataPosition = " + i2);
          }
          if (m <= i2)
          {
            n = 1;
            if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label365;
            }
          }
          for (int i1 = 1;; i1 = 0)
          {
            if ((n & i1) == 0) {
              break label369;
            }
            localObject = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(m);
            if ((localObject != null) && ((localObject instanceof ClubContentJsonTask.PromotionEmoticonPkg)))
            {
              localObject = (ClubContentJsonTask.PromotionEmoticonPkg)localObject;
              if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) {
                this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a((ClubContentJsonTask.PromotionEmoticonPkg)localObject);
              }
              if (!this.jdField_e_of_type_JavaUtilList.contains(localObject)) {
                this.jdField_e_of_type_JavaUtilList.add(localObject);
              }
            }
            m += 1;
            break;
            n = 0;
            break label259;
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      Object localObject = a(paramMessage);
      if (localObject == null) {
        return true;
      }
      DownloadTask localDownloadTask = a().a("vipEmoticonKey_" + paramMessage.epId);
      if (localDownloadTask == null) {
        return true;
      }
      int m = (int)localDownloadTask.jdField_a_of_type_Float;
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "handleMessage refreashProgress epid = " + paramMessage.epId + ";progress = " + m);
      }
      if (m == 100) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
      }
      ((ProgressButton)localObject).setProgress(m);
      ((ProgressButton)localObject).setProgressColor(-16745986);
      continue;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      paramMessage = a(paramMessage);
      if (paramMessage == null) {
        return true;
      }
      localObject = a(paramMessage);
      if (localObject == null) {
        return true;
      }
      paramMessage.setProgress(0);
      paramMessage.setText(((ClubContentJsonTask.PromotionEmoticonPkg)localObject).d);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, ((ClubContentJsonTask.PromotionEmoticonPkg)localObject).a, "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(paramView);
    if (localPromotionEmoticonPkg == null) {}
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localImageView = a(localPromotionEmoticonPkg);
          if (!(paramView instanceof URLImageView)) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, localPromotionEmoticonPkg.a, "", "", localPromotionEmoticonPkg.r + "");
          a(localPromotionEmoticonPkg);
        } while ((localImageView == null) || (localImageView.getVisibility() != 0));
        localImageView.setVisibility(8);
        localPromotionEmoticonPkg.r = 0;
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d(localPromotionEmoticonPkg.a);
        return;
      } while (!(paramView instanceof ProgressButton));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, localPromotionEmoticonPkg.a, "", "", localPromotionEmoticonPkg.r + "");
      a((ProgressButton)paramView, localPromotionEmoticonPkg, false);
    } while ((localImageView == null) || (localImageView.getVisibility() != 0));
    localImageView.setVisibility(8);
    localPromotionEmoticonPkg.r = 0;
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d(localPromotionEmoticonPkg.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\RecommendEmotionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */