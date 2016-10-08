import android.text.TextUtils;
import com.tencent.mobileqq.freshnews.FreshNewsComment;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.freshnews.FreshNewsDetailCommentAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.freshnews.QQInputView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class spg
  extends FreshNewsObserver
{
  public spg(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString1, FreshNewsInfo paramFreshNewsInfo, String paramString2, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onGetFreshNewsDetail.isSuccess=" + paramBoolean + ", errTip=" + paramString2 + ",errCode=" + paramInt + ",selfTinyId=" + paramLong + "\nfreshNewsInfo=" + paramFreshNewsInfo.toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId)))
    {
      this.a.j();
      this.a.jdField_b_of_type_Boolean = false;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.H();
      if (!paramBoolean) {
        break label223;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo = paramFreshNewsInfo;
      this.a.jdField_a_of_type_Long = paramLong;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount <= this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size()) {
        break label212;
      }
    }
    label212:
    for (this.a.d = true;; this.a.d = false)
    {
      this.a.jdField_a_of_type_ComTencentWidgetXListView.a(this.a.jdField_b_of_type_AndroidViewView);
      this.a.b();
      this.a.d();
      return;
    }
    label223:
    if (paramInt == 1213)
    {
      this.a.a("该新鲜事已被删除", null);
      return;
    }
    if ((this.a.m == 1) || (this.a.m == 3)) {
      this.a.a("加载失败，请下拉刷新重试", null);
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "加载失败";
    }
    this.a.a(1, paramString1, 0);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onDeleteFeed.isSuccess=" + paramBoolean + ", feedid=" + paramString1 + ",errTip=" + paramString2);
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId)))
    {
      this.a.j();
      if (paramBoolean)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "删除成功";
        }
        this.a.a(1, paramString1, 0);
        this.a.finish();
      }
    }
    else
    {
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "删除失败";
    }
    this.a.a(1, paramString1, 0);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onDeleteComment.isSuccess=" + paramBoolean + ", feedid=" + paramString1 + ",commentid=" + paramString2 + ",commentCount=" + paramInt + ",commentCountInfo=" + paramString3 + ",errTip=" + paramString4);
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId)))
    {
      this.a.j();
      if (!paramBoolean) {
        break label280;
      }
      paramString1 = paramString4;
      if (TextUtils.isEmpty(paramString4)) {
        paramString1 = "删除成功";
      }
      this.a.a(1, paramString1, 0);
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
      paramString1.commentCount -= 1;
      paramInt = 0;
      if (paramInt >= this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size()) {
        break label305;
      }
      if (!paramString2.equals(((FreshNewsComment)this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.get(paramInt)).a)) {
        break label271;
      }
    }
    for (;;)
    {
      if (paramInt != -1) {
        this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.remove(paramInt);
      }
      this.a.d();
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId, this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount);
      return;
      label271:
      paramInt += 1;
      break;
      label280:
      paramString1 = paramString4;
      if (TextUtils.isEmpty(paramString4)) {
        paramString1 = "删除评论失败";
      }
      this.a.a(1, paramString1, 0);
      return;
      label305:
      paramInt = -1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, List paramList, int paramInt1, int paramInt2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onGetFreshNewsComments.isSuccess=" + paramBoolean + ", feedid=" + paramString1 + ",refCommentId=" + paramString2 + ",oldOver=" + paramInt1 + ",newOver=" + paramInt2 + ",errTip=" + paramString3);
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId)))
    {
      this.a.c = false;
      if (!paramBoolean) {
        break label283;
      }
      if (paramInt1 != 1) {
        break label234;
      }
      this.a.d = false;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramInt1 = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size();
        if (paramInt1 <= 0) {
          break label245;
        }
        if (paramString2.equals(((FreshNewsComment)this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.get(paramInt1 - 1)).a))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.addAll(paramList);
          this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      this.a.e();
      return;
      label234:
      this.a.d = true;
      break;
      label245:
      if (TextUtils.isEmpty(paramString2))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.addAll(paramList);
        this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentAdapter.notifyDataSetChanged();
        continue;
        label283:
        if (TextUtils.isEmpty(paramString3)) {
          this.a.a(1, "加载评论失败", 0);
        } else {
          this.a.a(1, paramString3, 0);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsDetailActivity", 2, "onPublishComment.isSuccess=" + paramBoolean + ", feedid=" + paramString1 + ",commentCounts=" + paramInt1 + ",clearFlag=" + paramInt2 + ",strErrorTip=" + paramString2);
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedId)))
    {
      this.a.f = false;
      this.a.j();
      if (!paramBoolean) {
        break label360;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView.a();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount = paramInt1;
      if (paramInt2 != 1) {
        break label240;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.addAll(paramList);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentCount <= this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size()) {
        break label349;
      }
    }
    label240:
    label349:
    for (this.a.d = true;; this.a.d = false)
    {
      this.a.d();
      return;
      paramString1 = new ArrayList(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size() + 20);
      if ((paramList != null) && (paramList.size() > 0)) {
        paramString1.addAll(paramList);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList.size() > 0)) {
        paramString1.addAll(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.commentList = paramString1;
      break;
    }
    label360:
    if (TextUtils.isEmpty(paramString2))
    {
      this.a.a(1, "评论失败", 0);
      return;
    }
    this.a.a(1, paramString2, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */