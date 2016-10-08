package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyArticleDetailActivity
  extends QQBrowserActivity
{
  public static final String a = "subscribename";
  public static final String b = "url";
  public static final String c = "from";
  public static final String d = "articleid";
  public static final String e = "channelid";
  public static final String f = "articleinfo";
  public static final String g = "recommendSeq";
  private static final String j = "ReadInJoyArticleDetail";
  protected int a;
  protected long a;
  private ArticleInfo a;
  private int b;
  protected long b;
  private long g;
  private long h;
  protected String h;
  protected String i;
  
  public ReadInJoyArticleDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while (paramInt2 != 1)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005438", "0X8005438", 0, 0, "", "", "", "");
      QfavBuilder.a(this, paramIntent);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a().a();
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a().b();
  }
  
  protected void doOnPause()
  {
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_h_of_type_Long - this.g;
    if ((l > 0L) && (this.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleFriendLikeText)) {
        break label172;
      }
    }
    label172:
    for (int k = 0;; k = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "start to report article read info:" + ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, k));
      }
      ReportController.b(null, "CliOper", "", "", "0X80066FB", "0X80066FB", 0, 0, Long.toString(l / 1000L), Long.toString(this.jdField_b_of_type_Long), Integer.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, k));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetail", 2, "previousPage is channelView but articleInfo is null");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
    localReportInfo.mChannelId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
    localReportInfo.mAlgorithmId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
    localReportInfo.mOperation = 9;
    localReportInfo.mReadTimeLength = ((int)(l / 1000L));
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  protected void doOnResume()
  {
    this.g = System.currentTimeMillis();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getIntent().getExtras();
    this.jdField_h_of_type_JavaLangString = localBundle.getString("url");
    if (this.jdField_h_of_type_JavaLangString == null)
    {
      QLog.d("ReadInJoyArticleDetail", 2, "initModel url empty");
      return;
    }
    this.i = localBundle.getString("subscribename");
    if (this.i == null) {
      this.i = "";
    }
    paramBundle = String.valueOf(53);
    String str = localBundle.getString("from");
    if (str == null) {}
    for (;;)
    {
      this.jdField_b_of_type_Int = Integer.valueOf(paramBundle).intValue();
      this.jdField_b_of_type_Long = localBundle.getLong("articleid", -1L);
      this.jdField_a_of_type_Int = localBundle.getInt("channelid", -1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.getParcelable("articleinfo"));
      this.jdField_a_of_type_Long = localBundle.getLong("recommendSeq", -1L);
      return;
      paramBundle = str;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\activity\ReadInJoyArticleDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */