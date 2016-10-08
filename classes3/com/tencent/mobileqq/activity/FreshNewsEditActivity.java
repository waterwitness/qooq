package com.tencent.mobileqq.activity;

import EncounterSvc.RespEncounterInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.freshnews.FreshNewsDragGridView;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.freshnews.FreshNewsManager.PhotoInfo;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import ljr;
import ljs;
import ljt;
import lju;
import ljv;
import ljw;
import ljx;

public class FreshNewsEditActivity
  extends NearbyTitleBarActivity
  implements View.OnClickListener, ActionSheet.OnButtonClickListener
{
  public static final int a = 9;
  public static final String a = "param_photo_paths";
  public static final int b = 2;
  public static final String b = "param_topic_info";
  public static final int d = 0;
  private static final String d = FreshNewsEditActivity.class.getSimpleName();
  public static final int e = 1;
  private static final String e = "plus_sign";
  private static final int g = 1;
  private static final int h = 1;
  public Handler a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  BlockableEditTextView jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView;
  FreshNewsDragGridView jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView;
  private FreshNewsManager.CUnpublishedFeedsListener jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener = new ljv(this);
  FreshNewsManager jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
  TopicInfo jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo;
  protected QQProgressNotifier a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public ArrayList a;
  public ljw a;
  private boolean jdField_a_of_type_Boolean;
  public int c;
  String c;
  int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FreshNewsEditActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new lju(this);
  }
  
  private void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while ((i < paramArrayList.size()) && (i < 9))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new FreshNewsManager.PhotoInfo((String)paramArrayList.get(i), ""));
        i += 1;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new FreshNewsManager.PhotoInfo("plus_sign", ""));
      }
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new FreshNewsManager.PhotoInfo("plus_sign", ""));
    }
    e();
  }
  
  private void b()
  {
    Object localObject = getIntent().getExtras();
    this.f = ((Bundle)localObject).getInt("from", 0);
    this.jdField_a_of_type_Boolean = ((Bundle)localObject).getBoolean("abp_flag", false);
    if (this.f == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo = ((TopicInfo)getIntent().getParcelableExtra("param_topic_info"));
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.a)))
    {
      localObject = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject).append('#').append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.a).append('#');
      ((SpannableStringBuilder)localObject).setSpan(new DatingCommentTextView.TouchableSpan(null, Color.parseColor("#bbbbbb")), 0, ((SpannableStringBuilder)localObject).length(), 33);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setEditStatus(2);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setBlockFront(true);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getEditableText().append((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(((SpannableStringBuilder)localObject).length() + 140) });
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (((FreshNewsManager.PhotoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).a.equals("plus_sign"))
      {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView.a = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView.a = -1;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView.a = -1;
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null)
    {
      localIntent = new Intent(this, NearbyTopicFeedActivity.class);
      localIntent.putExtra("topic_info", this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo);
    }
    for (;;)
    {
      localIntent.putExtra("abp_flag", true);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("TAB", 1);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.rightViewText.setEnabled(true);
      return;
    }
    this.rightViewText.setEnabled(false);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    finish();
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        paramView.add(((FreshNewsManager.PhotoInfo)localIterator.next()).a);
      }
      FreshNewsUtil.a(this, 9, getClass().getName(), paramView);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    this.jdField_c_of_type_JavaLangString = FreshNewsUtil.a(this, 2, null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (this.jdField_c_of_type_JavaLangString == null);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.size() - 1, new FreshNewsManager.PhotoInfo(this.jdField_c_of_type_JavaLangString, ""));
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 9) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
    e();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904168);
    paramBundle = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Int = ((paramBundle.widthPixels - (int)(paramBundle.density * 30.0F) - (int)(paramBundle.density * 30.0F)) / 4);
    setLeftButton(2131367262, this);
    setTitle("编辑新鲜事");
    setRightButton(2131372396, this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)findViewById(2131301683));
    if (ThemeUtil.isInNightMode(this.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setTextColor(Color.parseColor("#6a82a5"));
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setHintTextColor(Color.parseColor("#44608a"));
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView = ((FreshNewsDragGridView)findViewById(2131300984));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299604));
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.b.getManager(211));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a());
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c("从相册选择");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c("拍照");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    a(getIntent().getStringArrayListExtra("param_photo_paths"), false);
    this.jdField_a_of_type_Ljw = new ljw(this, null);
    c();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView.setListener(this.jdField_a_of_type_Ljw);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView.setAdapter(this.jdField_a_of_type_Ljw);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.f == 1) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      str = d;
      localStringBuilder = new StringBuilder().append("doOnNewIntent, paths=");
      if (localArrayList != null) {
        break label67;
      }
    }
    label67:
    for (paramIntent = "null";; paramIntent = localArrayList.toString())
    {
      QLog.i(str, 4, paramIntent);
      a(localArrayList, true);
      return;
    }
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView.a();
    }
    super.doOnPause();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130968587, 2130968588);
    }
  }
  
  protected boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
    if ((!this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.a()) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1)) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        f();
      }
      return true;
      DialogUtil.a(this, "退出此次编辑？", 2131367264, 2131367262, new ljr(this), new ljs(this)).show();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.leftViewNotBack)
    {
      onBackEvent();
      NearbyTitleBarActivity.b(this.b, "0X8005787");
    }
    Object localObject1;
    do
    {
      return;
      if (paramView == this.rightViewText)
      {
        if ((this.f == 1) && (!NetworkUtil.e(BaseApplication.getContext())))
        {
          a(1, getString(2131367256), 200);
          return;
        }
        if ((this.f == 1) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c())) {
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b()) {
            QQToast.a(this, "1分钟之内只允许发布一条新鲜事", 0).b(getTitleBarHeight());
          }
        }
        for (;;)
        {
          NearbyTitleBarActivity.b(this.b, "0X8005786");
          return;
          paramView = new FreshNewsInfo();
          paramView.feedContent = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
          long l2 = System.currentTimeMillis();
          paramView.feedId = String.valueOf(l2);
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) {}
          for (long l1 = 7L;; l1 = 0L)
          {
            paramView.feedType = l1;
            paramView.ownerFlag = 1;
            localObject1 = new ArrayList();
            localObject2 = new Vector();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              FreshNewsManager.PhotoInfo localPhotoInfo = (FreshNewsManager.PhotoInfo)localIterator.next();
              if (!"plus_sign".equals(localPhotoInfo.a))
              {
                ((List)localObject1).add(localPhotoInfo.a);
                ((List)localObject2).add("_");
              }
            }
          }
          paramView.photoPaths = ((List)localObject1);
          paramView.photoUrls = ((List)localObject2);
          paramView.publishState = 2;
          paramView.publishTime = l2;
          localObject1 = this.b.a();
          if (localObject1 != null)
          {
            paramView.publisherID = ((RespEncounterInfo)localObject1).tiny_id;
            paramView.publisherNickname = ((RespEncounterInfo)localObject1).strNick;
            paramView.publisherAge = ((RespEncounterInfo)localObject1).cAge;
            paramView.publisherGender = ((RespEncounterInfo)localObject1).cSex;
          }
          paramView.topicInfo = this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo;
          if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.a)) && (paramView.feedContent.length() >= this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.a.length())) {
            paramView.feedContent = paramView.feedContent.substring(this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.a.length() + 2);
          }
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(paramView);
          if (this.f == 1)
          {
            a(0, "正在发布...", 200);
          }
          else
          {
            f();
            continue;
            QQToast.a(this, String.format("需要魅力值%d星，才能发布新鲜事哦。", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a()) }), 0).b(getTitleBarHeight());
          }
        }
      }
      localObject1 = (ljx)paramView.getTag();
    } while ((localObject1 == null) || (TextUtils.isEmpty(((ljx)localObject1).a.a)));
    if ("plus_sign".equals(((ljx)localObject1).a.a))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      NearbyTitleBarActivity.b(this.b, "0X8005788");
      return;
    }
    Object localObject2 = ActionSheet.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView.a();
    ((ActionSheet)localObject2).c("查看大图");
    ((ActionSheet)localObject2).c("删除照片");
    ((ActionSheet)localObject2).d(2131367262);
    ((ActionSheet)localObject2).a(new ljt(this, (ActionSheet)localObject2, paramView, (ljx)localObject1));
    ((ActionSheet)localObject2).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\FreshNewsEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */