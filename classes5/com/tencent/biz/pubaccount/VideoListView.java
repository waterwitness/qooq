package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import hre;
import hrf;
import hrg;
import hrh;
import hri;
import hrj;
import hrk;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class VideoListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  public static final String a = "Q.pubaccount.video.VideoListView";
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  public Bundle a;
  public ViewGroup a;
  private VideoListAdapter.VideoListEventListener jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener;
  public VideoListView.OnRefreshListener a;
  public QQAppInterface a;
  public boolean a;
  public int b;
  public ViewGroup b;
  public boolean b;
  private boolean c;
  public int f;
  private int g;
  
  public VideoListView(Context paramContext, Activity paramActivity, Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    super.setDivider(null);
    super.setOnScrollListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903485, null));
    super.a(this.jdField_a_of_type_AndroidViewViewGroup, null, false);
    ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298755)).setOnClickListener(new hre(this));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903484, null));
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
    super.b(this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.b().postDelayed(new hrk(this, paramAccountDetail), 10L);
  }
  
  private void a(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoListView", 2, "followPubAccount() ERROR uin=null return");
      }
      return;
    }
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString, new hri(this));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "doVideoLikeClicked() articleID=" + paramString + ", isLikeVideo=" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener.a(paramString, paramBoolean);
    }
  }
  
  private void b(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "saveAccountDetailToDB()");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((AccountDetail)localEntityManager.a(AccountDetail.class, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN")) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoListView", 2, "saveAccountDetailToDB() accountDetail != null, update() detail.name=" + paramAccountDetail.name);
      }
      if (!localEntityManager.a(paramAccountDetail))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoListView", 2, "saveAccountDetailToDB() update ERROR em.update(detail)=false");
        }
        localEntityManager.a(AccountDetail.class);
      }
    }
    for (;;)
    {
      localEntityManager.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoListView", 2, "saveAccountDetailToDB() em.persist detail.name=" + paramAccountDetail.name);
      }
      localEntityManager.a(paramAccountDetail);
    }
  }
  
  private void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("source", 114);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    ReportController.b(null, "CliOper", "", "", "0X80069B3", "0X80069B3", 0, 0, "", "", "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "fetchPublicAccountInfo() uin=" + paramString);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidContentContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("6.5.5,3,2880");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new hrj(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoListView", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener = null;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "checkIsFollowPublicAccountAgain()");
    }
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", false)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoListView", 2, "checkIsFollowPublicAccountAgain() VIDEO_IS_FROM_PUBLIC_ACCOUNT = false, RETURN");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a().iterator();
          PublicAccountInfo localPublicAccountInfo;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
          } while (Long.valueOf(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN")).longValue() != localPublicAccountInfo.uin);
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoListView", 2, "checkIsFollowPublicAccountAgain() info.uin=" + localPublicAccountInfo.uin + ", isFollowed");
          }
          localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298766);
          ((TextView)localObject).setText("已关注");
          ((TextView)localObject).setTextColor(872415231);
          ((TextView)localObject).setBackgroundDrawable(null);
          ((TextView)localObject).setOnClickListener(null);
          return;
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.pubaccount.video.VideoListView", 2, "checkIsFollowPublicAccountAgain() ERROR Exception = " + localException.getMessage());
  }
  
  public void a()
  {
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131298749);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131298748);
    switch (this.f)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewGroup.requestLayout();
      return;
      localTextView.setText("上拉发现更多精彩视频");
      localProgressBar.setVisibility(8);
      continue;
      localTextView.setText("加载中");
      localProgressBar.setVisibility(0);
      continue;
      localTextView.setText("刷新失败");
      localProgressBar.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "updateVideoLikeCount() count=" + paramInt);
    }
    this.g = paramInt;
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298754);
    if (paramInt <= 0)
    {
      localTextView.setText("");
      return;
    }
    if (paramInt > 10000)
    {
      localTextView.setText("10000+");
      return;
    }
    localTextView.setText(String.valueOf(paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (((paramInt == 0) || (paramInt == 2)) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoListView$OnRefreshListener != null) && (this.f != 1))
    {
      this.f = 1;
      a();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListView$OnRefreshListener.a();
      ReportController.b(null, "CliOper", "", "", "0X8006764", "0X8006764", 0, 0, "", "", "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (t() == paramInt3 - 1)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "updateVideoLikeStatus() isLiked=" + paramBoolean);
    }
    this.c = paramBoolean;
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298753);
    if (paramBoolean)
    {
      localImageView.setBackgroundResource(2130838922);
      return;
    }
    localImageView.setBackgroundResource(2130838921);
  }
  
  public void b()
  {
    e();
  }
  
  public void c()
  {
    d();
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      continue;
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getY());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      continue;
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getY());
      continue;
      int i = (int)paramMotionEvent.getY();
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener != null) {
        if (i - this.jdField_a_of_type_Int > 100) {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener.a(1);
        } else if (100 < this.jdField_a_of_type_Int - i) {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener.a(0);
        }
      }
    }
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.f = paramInt;
    a();
  }
  
  public void setHeaderViewData(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    View localView3 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298760);
    View localView4 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298767);
    View localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298761);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298747);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298762);
    Object localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298752);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298751);
    View localView2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298758);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298750);
    localTextView2.setVisibility(8);
    localRelativeLayout.setVisibility(0);
    localTextView1.setVisibility(0);
    localView2.setVisibility(0);
    localTextView1.setText(paramBundle.getString("VIDEO_TITLE"));
    a(false);
    a(0);
    ((LinearLayout)localObject1).setOnClickListener(new hrf(this, paramBundle));
    int i = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
    localObject1 = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    Object localObject2;
    Object localObject3;
    if ((1 != i) && ((TextUtils.isEmpty((CharSequence)localObject1)) || ("16888".equalsIgnoreCase((String)localObject1))))
    {
      i = 1;
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298759);
      localObject3 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298769);
      if (i == 0) {
        break label549;
      }
      ((View)localObject2).setVisibility(8);
      ((View)localObject3).setVisibility(8);
      label273:
      if ((!paramBundle.getBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", true)) && (i != 0)) {
        break label613;
      }
      ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298764)).setText(paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME"));
      ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298765)).setText(paramBundle.getString("VIDEO_CREATE_TIME") + " 发布");
      paramBundle = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298766);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject3 = (AccountDetail)((EntityManager)localObject2).a(AccountDetail.class, (String)localObject1);
      ((EntityManager)localObject2).a();
      if ((localObject3 == null) || (((AccountDetail)localObject3).followType != 1)) {
        break label564;
      }
      paramBundle.setText("已关注");
      paramBundle.setTextColor(872415231);
      paramBundle.setBackgroundDrawable(null);
      paramBundle.setOnClickListener(null);
      label437:
      localView3.setVisibility(0);
      localView4.setVisibility(8);
      paramBundle = ImageUtil.b();
      localImageView.setBackgroundDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject1, 3, paramBundle, paramBundle));
      localView1.setOnClickListener(new hrh(this, (String)localObject1));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_LISTVIEW_CONFIG_HIDE_SHARE_BUTTON", false)) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE"))))
      {
        localTextView1.setVisibility(8);
        localView2.setVisibility(8);
        localTextView2.setVisibility(0);
        localRelativeLayout.setVisibility(8);
      }
      return;
      i = 0;
      break;
      label549:
      ((View)localObject2).setVisibility(0);
      ((View)localObject3).setVisibility(0);
      break label273;
      label564:
      paramBundle.setText("关注");
      paramBundle.setTextColor(1728053247);
      paramBundle.setBackgroundResource(2130838915);
      paramBundle.setOnClickListener(new hrg(this, (String)localObject1));
      if (localObject3 != null) {
        break label437;
      }
      c((String)localObject1);
      break label437;
      label613:
      ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298768)).setText(paramBundle.getString("VIDEO_CREATE_TIME") + " 发布");
      localView3.setVisibility(8);
      localView4.setVisibility(0);
      localView1.setOnClickListener(null);
    }
  }
  
  public void setOnRefreshListener(VideoListView.OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView$OnRefreshListener = paramOnRefreshListener;
  }
  
  public void setVideoListEventListener(VideoListAdapter.VideoListEventListener paramVideoListEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener = paramVideoListEventListener;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */