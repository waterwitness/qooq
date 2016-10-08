package com.tencent.mobileqq.freshnews.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.freshnews.hotchat.HotchatFeedInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class FNHotChatItemData
  extends FNBaseItemData
{
  public StaticLayout a;
  TextPaint a;
  public CharSequence a;
  public String a;
  public URL a;
  public StaticLayout b;
  public CharSequence b;
  public String b;
  public boolean b;
  public CharSequence c;
  public String c;
  public boolean c;
  public CharSequence d;
  
  public FNHotChatItemData(FreshNewsInfo paramFreshNewsInfo)
  {
    super(paramFreshNewsInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Context paramContext, AppInterface paramAppInterface)
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.ownerFlag == 1)
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = paramAppInterface.a();
      }
      if (this.jdField_a_of_type_AndroidTextTextPaint == null)
      {
        this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
        this.jdField_a_of_type_AndroidTextTextPaint.density = paramContext.getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramContext.getResources().getDimension(2131492899));
        this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramContext.getResources().getColor(2131428297));
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname)) {
        break label757;
      }
      this.jdField_a_of_type_JavaLangCharSequence = new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname, 3, 16);
      label137:
      int i = ViewUtils.a() - AIOUtils.a(66.0F, paramContext.getResources());
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      if ((this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname.length() >= 3))
      {
        int j = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(0);
        paramAppInterface = new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname);
        int k = paramAppInterface.length();
        if (j > 3)
        {
          paramAppInterface = paramAppInterface.delete(j - 3, k).append("...");
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.freshNews", 2, "cliped nick = " + paramAppInterface + ",feedid = " + this.e);
          }
          this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(paramAppInterface, this.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.isPubNumber != 1) {
        break label766;
      }
      bool = true;
      label348:
      this.jdField_b_of_type_Boolean = bool;
      paramAppInterface = new StringBuilder("");
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherGender != 1) {
        break label772;
      }
      paramAppInterface.append("女");
      label382:
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge > 0)
      {
        paramAppInterface.append(" ");
        paramAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge);
        paramAppInterface.append("岁");
      }
      this.jdField_b_of_type_JavaLangString = paramAppInterface.toString();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent.trim())) {
        break label783;
      }
      this.jdField_b_of_type_JavaLangCharSequence = new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent, 3, 16);
      label463:
      i = ViewUtils.a() - AIOUtils.a(20.0F, paramContext.getResources());
      float f = paramContext.getResources().getDimension(2131493435);
      this.jdField_b_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, f, false);
      if ((this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() > 3) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent.length() > 3))
      {
        paramContext = new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent);
        this.jdField_b_of_type_AndroidTextStaticLayout = new StaticLayout(paramContext.delete(this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(2) - 3, paramContext.length()).append("..."), this.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, f, false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotchatInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotchatInfo.e))) {
        break label792;
      }
      this.jdField_c_of_type_JavaLangCharSequence = new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotchatInfo.e, 3, 16);
      label651:
      if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotchatInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotchatInfo.f))) {
        break label801;
      }
      this.d = new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotchatInfo.f, 3, 16);
      label701:
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        break label810;
      }
    }
    label757:
    label766:
    label772:
    label783:
    label792:
    label801:
    label810:
    for (this.jdField_c_of_type_JavaLangString = FreshNewsUtil.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publishTime), true);; this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.strTimeDistance)
    {
      if (this.jdField_a_of_type_JavaNetURL == null) {}
      try
      {
        this.jdField_a_of_type_JavaNetURL = NearbyImgDownloader.a("http://sqimg.qq.com/qq_product_operations/playqq/anonymous/image/reliao0714.png");
        return;
      }
      catch (MalformedURLException paramContext)
      {
        this.jdField_a_of_type_JavaNetURL = null;
      }
      bool = false;
      break;
      this.jdField_a_of_type_JavaLangCharSequence = "";
      break label137;
      bool = false;
      break label348;
      paramAppInterface.append("男");
      break label382;
      this.jdField_b_of_type_JavaLangCharSequence = "";
      break label463;
      this.jdField_c_of_type_JavaLangCharSequence = "";
      break label651;
      this.d = "";
      break label701;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\data\FNHotChatItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */