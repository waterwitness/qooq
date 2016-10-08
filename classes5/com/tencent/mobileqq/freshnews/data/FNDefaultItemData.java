package com.tencent.mobileqq.freshnews.data;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FNDefaultItemData
  extends FNBaseItemData
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public static final int b = 300;
  private static Drawable b;
  public static final int c = 250;
  public static final int d = 200;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  public StaticLayout a;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  public TopicInfo a;
  public CharSequence a;
  public String a;
  public List a;
  public StaticLayout b;
  public CharSequence b;
  public String b;
  public List b;
  public boolean b;
  public CharSequence c;
  public String c;
  public List c;
  public boolean c;
  public String d;
  public List d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public int h;
  public int i;
  public int j;
  
  public FNDefaultItemData(FreshNewsInfo paramFreshNewsInfo)
  {
    super(paramFreshNewsInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 300;
    }
    if (paramInt == 2) {
      return 250;
    }
    return 200;
  }
  
  public static URLDrawable.URLDrawableOptions a(Context paramContext, int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 300;
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt;
      localURLDrawableOptions.mRequestHeight = paramInt;
      if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840689);
      }
      if (jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
        jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e9e9e9"));
      }
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mLoadingDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      return localURLDrawableOptions;
      if (paramInt == 2) {
        paramInt = 250;
      } else {
        paramInt = 200;
      }
    }
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.ownerFlag == 1)
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (!this.jdField_b_of_type_Boolean) {
        break label1565;
      }
    }
    label103:
    label369:
    label389:
    label444:
    label492:
    label828:
    label957:
    label1107:
    label1113:
    label1119:
    label1130:
    label1163:
    label1204:
    label1264:
    label1269:
    label1301:
    label1316:
    label1414:
    label1540:
    label1546:
    label1565:
    Object localObject2;
    for (Object localObject1 = NearbyMineHelper.a(paramAppInterface);; localObject2 = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = paramAppInterface.a();
      }
      String str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname))
      {
        this.jdField_a_of_type_JavaLangCharSequence = new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname.replaceAll("\\r|\\n", ""), 3, 16);
        if (this.jdField_a_of_type_AndroidTextTextPaint == null)
        {
          this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
          this.jdField_a_of_type_AndroidTextTextPaint.density = paramContext.getResources().getDisplayMetrics().density;
          this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramContext.getResources().getDimension(2131492899));
          this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramContext.getResources().getColor(2131428297));
        }
        int k = ViewUtils.a() - AIOUtils.a(66.0F, paramContext.getResources());
        this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, k, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
        if ((this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname.length() >= 3))
        {
          int m = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(0);
          paramAppInterface = new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherNickname);
          int n = paramAppInterface.length();
          if (m > 3)
          {
            paramAppInterface = paramAppInterface.delete(m - 3, n).append("...");
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby.freshNews", 2, "cliped nick = " + paramAppInterface);
            }
            this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(paramAppInterface, this.jdField_a_of_type_AndroidTextTextPaint, k, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotFlag <= 0) {
          break label1107;
        }
        bool1 = true;
        this.jdField_c_of_type_Boolean = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.isPubNumber != 1) {
          break label1113;
        }
        bool1 = true;
        this.jdField_d_of_type_Boolean = bool1;
        paramAppInterface = new StringBuilder("");
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherGender >= 0) || (localObject1 == null)) {
          break label1130;
        }
        if (((NearbyMyTabCard)localObject1).gender != 2) {
          break label1119;
        }
        paramAppInterface.append("女");
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge >= 0) || (localObject1 == null)) {
          break label1163;
        }
        paramAppInterface.append(" ");
        paramAppInterface.append(((NearbyMyTabCard)localObject1).age);
        paramAppInterface.append("岁");
        this.jdField_b_of_type_JavaLangString = paramAppInterface.toString();
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.common;
        this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commonId;
        paramAppInterface = new SpannableStringBuilder("");
        if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.jdField_a_of_type_JavaLangString)))
        {
          paramAppInterface.append('#').append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.jdField_a_of_type_JavaLangString).append('#');
          if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
            this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131428211);
          }
          this.jdField_b_of_type_JavaLangCharSequence = paramAppInterface.toString();
          this.jdField_e_of_type_Boolean = true;
          paramAppInterface.setSpan(new DatingCommentTextView.TouchableSpan(null, this.jdField_a_of_type_AndroidContentResColorStateList), 0, paramAppInterface.length(), 33);
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent.trim()))) {
          paramAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent);
        }
        if (paramAppInterface.length() <= 0) {
          break label1204;
        }
        k = ViewUtils.a() - AIOUtils.a(20.0F, paramContext.getResources());
        float f1 = paramContext.getResources().getDimension(2131493435);
        this.jdField_c_of_type_JavaLangCharSequence = new QQText(paramAppInterface, 3, 16);
        this.jdField_b_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_c_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, k, Layout.Alignment.ALIGN_NORMAL, 1.0F, f1, false);
        if ((this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() > 3) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent.length() > 3)) {
          this.jdField_b_of_type_AndroidTextStaticLayout = new StaticLayout(paramAppInterface.delete(this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(2) - 3, paramAppInterface.length()).append("..."), this.jdField_a_of_type_AndroidTextTextPaint, k, Layout.Alignment.ALIGN_NORMAL, 1.0F, f1, false);
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label1414;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls == null) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size() <= 0)) {
          break label1264;
        }
        this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size();
        if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList != null)) {
          break label1269;
        }
        this.jdField_c_of_type_JavaUtilList = new ArrayList(this.jdField_f_of_type_Int);
        this.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_f_of_type_Int);
        this.jdField_b_of_type_JavaUtilList = new ArrayList(this.jdField_f_of_type_Int);
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.iterator();
        if (!localIterator.hasNext()) {
          break label1269;
        }
        str2 = (String)localIterator.next();
      }
      for (;;)
      {
        try
        {
          paramAppInterface = str2 + a(this.jdField_f_of_type_Int);
        }
        catch (MalformedURLException localMalformedURLException1)
        {
          paramAppInterface = null;
        }
        try
        {
          localObject1 = NearbyImgDownloader.a(paramAppInterface);
          if (localObject1 == null) {
            break label957;
          }
          this.jdField_c_of_type_JavaUtilList.add(localObject1);
          this.jdField_a_of_type_JavaUtilList.add(str2);
          this.jdField_b_of_type_JavaUtilList.add(paramAppInterface);
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          String str1;
          for (;;) {}
        }
        bool1 = false;
        break;
        if ((this.jdField_b_of_type_Boolean) && (localObject1 != null))
        {
          if (localObject1 == null)
          {
            paramAppInterface = "我";
            this.jdField_a_of_type_JavaLangCharSequence = paramAppInterface;
            break label103;
          }
          paramAppInterface = ((NearbyMyTabCard)localObject1).nickName;
          continue;
        }
        this.jdField_a_of_type_JavaLangCharSequence = "";
        break label103;
        bool1 = false;
        break label369;
        bool1 = false;
        break label389;
        paramAppInterface.append("男");
        break label444;
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherGender == 1)
        {
          paramAppInterface.append("女");
          break label444;
        }
        paramAppInterface.append("男");
        break label444;
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge <= 0) {
          break label492;
        }
        paramAppInterface.append(" ");
        paramAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publisherAge);
        paramAppInterface.append("岁");
        break label492;
        this.jdField_c_of_type_JavaLangCharSequence = "";
        this.jdField_b_of_type_AndroidTextStaticLayout = null;
        break label828;
        if (QLog.isColorLevel()) {
          QLog.d("FNDefaultItemData", 2, "update  convertURL  error,urlStr:" + str2, localMalformedURLException1);
        }
        str1 = null;
      }
      this.jdField_f_of_type_Int = 0;
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_f_of_type_JavaLangString = FreshNewsUtil.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publishTime), true);
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseFlag != 1) {
          break label1540;
        }
        bool1 = bool2;
        this.jdField_f_of_type_Boolean = bool1;
        this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.praiseCount;
        this.h = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publishErrorStr)) {
          break label1546;
        }
      }
      for (this.jdField_g_of_type_JavaLangString = paramContext.getResources().getString(2131372596);; this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.publishErrorStr)
      {
        if (this.j == 0) {
          this.j = paramContext.getResources().getColor(2131427634);
        }
        if (this.i == 0) {
          this.i = paramContext.getResources().getColor(2131428302);
        }
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoPaths != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoPaths.size() > 0))
        {
          this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoPaths.size();
          this.jdField_d_of_type_JavaUtilList = new ArrayList(this.jdField_f_of_type_Int);
          paramAppInterface = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoPaths.iterator();
          while (paramAppInterface.hasNext())
          {
            str1 = (String)paramAppInterface.next();
            this.jdField_d_of_type_JavaUtilList.add(str1);
          }
          break;
        }
        this.jdField_f_of_type_Int = 0;
        break;
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.strTimeDistance;
        break label1301;
        bool1 = false;
        break label1316;
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
        {
          this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.freshNews", 2, "warmUpLayout nickNameLayout feedid:" + this.jdField_e_of_type_JavaLangString);
          }
        }
      } while (this.jdField_b_of_type_AndroidTextStaticLayout == null);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby.freshNews", 2, "warmUpLayout contentLayout feedid:" + this.jdField_e_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\data\FNDefaultItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */