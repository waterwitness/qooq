package com.tencent.mobileqq.search.ftsmsg;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FTSMessageSearchResultModel
  extends FTSEntitySearchResultModel
{
  private static final String d = "FTSMessageSearchResultModel";
  protected String c;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  
  public FTSMessageSearchResultModel(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList paramArrayList, List paramList, String paramString3, CharSequence paramCharSequence)
  {
    super(paramQQAppInterface, paramString1, paramString2, paramArrayList, paramList);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramString1 = (FTSMessage)paramList.get(0);
    this.jdField_e_of_type_JavaLangString = String.valueOf(paramString1.uin);
    this.f = paramString1.senderuin;
    this.jdField_e_of_type_Int = paramString1.istroop;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    int i;
    if (this.jdField_e_of_type_Int == 3000)
    {
      i = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(this.jdField_e_of_type_JavaLangString);
      if (i <= 0) {
        this.g = "";
      }
    }
    else
    {
      return;
    }
    this.g = String.valueOf(i);
  }
  
  public int a()
  {
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("FTSMessageSearchResultModel", 2, "Face type is illegal. type = " + this.jdField_e_of_type_Int);
      }
    case 0: 
      return 1;
    case 1: 
      return 4;
    }
    return 101;
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Int);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Int, this.f);
    }
    FTSMessage localFTSMessage;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 1;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.g = this.jdField_e_of_type_Int;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.h = this.jdField_b_of_type_Int;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.i = this.jdField_c_of_type_Int;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.j = this.jdField_d_of_type_Int;
      SQLiteFTSUtils.a(paramView);
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label253;
      }
      RecentUtil.jdField_a_of_type_Boolean = true;
      localFTSMessage = (FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      if (localFTSMessage.msgExts != null)
      {
        if ((localFTSMessage.istroop != 1) && (localFTSMessage.istroop != 3000)) {
          break label234;
        }
        RecentUtil.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).shmsgseq;
      }
      label165:
      SearchHistoryManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      RecentUtil.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Int, (String)this.jdField_a_of_type_JavaLangCharSequence, false);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, paramView, false);
    }
    for (;;)
    {
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
      return;
      com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.f = 2;
      break;
      label234:
      RecentUtil.jdField_a_of_type_Long = ((FTSMessageCodec.TextMsgExts)localFTSMessage.msgExts).time;
      break label165;
      label253:
      FTSEntitySearchDetailActivity.a(paramView.getContext(), b(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_JavaUtilList, 1, this.jdField_e_of_type_JavaLangString, this.jdField_e_of_type_Int);
    }
  }
  
  public CharSequence b()
  {
    if ((this.jdField_e_of_type_Int == 3000) && (!TextUtils.isEmpty(this.g))) {
      return SearchUtils.a(this.g);
    }
    return "";
  }
  
  public CharSequence c()
  {
    int i;
    if (this.jdField_d_of_type_JavaLangCharSequence == null)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      if (i == 1) {
        this.jdField_d_of_type_JavaLangCharSequence = SearchUtils.a(((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mContent, ((FTSEntity)this.jdField_a_of_type_JavaUtilList.get(0)).mProximityStart, this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else
    {
      return this.jdField_d_of_type_JavaLangCharSequence;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(i + "条与" + "\"");
    if ((this.jdField_c_of_type_JavaLangString != null) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))) {
      localSpannableStringBuilder.append(SearchUtils.a(this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString));
    }
    for (;;)
    {
      localSpannableStringBuilder.append("\"").append("相关记录");
      this.jdField_d_of_type_JavaLangCharSequence = localSpannableStringBuilder;
      break;
      localSpannableStringBuilder.append(SearchUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public CharSequence e()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_b_of_type_JavaLangCharSequence == null) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0)).matchTitle;
      if (localCharSequence != null) {
        this.jdField_b_of_type_JavaLangCharSequence = localCharSequence;
      }
    }
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public CharSequence f()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_c_of_type_JavaLangCharSequence == null) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof FTSMessage)))
    {
      CharSequence localCharSequence = ((FTSMessage)this.jdField_a_of_type_JavaUtilList.get(0)).matchSecondTitle;
      if (localCharSequence != null) {
        this.jdField_c_of_type_JavaLangCharSequence = localCharSequence;
      }
    }
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ftsmsg\FTSMessageSearchResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */