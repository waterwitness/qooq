package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import hpy;
import hpz;
import hqa;
import hqb;
import hqc;
import hqd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class PublicAccountManageAdapter
  extends BaseAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private static final String jdField_a_of_type_JavaLangString = "PublicAccountManageAdapter";
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private PublicAccountManageActivity jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private Comparator jdField_a_of_type_JavaUtilComparator;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  
  public PublicAccountManageAdapter(QQAppInterface paramQQAppInterface, PublicAccountManageActivity paramPublicAccountManageActivity, SwipListView paramSwipListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilComparator = new hpy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity = paramPublicAccountManageActivity;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = paramPublicAccountManageActivity.getResources().getDimension(2131494174);
  }
  
  private hqc a(PublicAccountInfo paramPublicAccountInfo)
  {
    hqc localhqc = new hqc(this, paramPublicAccountInfo);
    localhqc.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localhqc.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localhqc;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {}
    hqc localhqc;
    do
    {
      return;
      localhqc = (hqc)getItem(paramInt);
    } while ((localhqc == null) || (localhqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null));
    String str = localhqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity, AccountDetailActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.addFlags(67108864);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", str, "0X800679F", "0X800679F", 0, 0, String.valueOf(localhqc.jdField_a_of_type_Long), "", "", "");
  }
  
  private void a(View paramView)
  {
    paramView = (View)paramView.getParent().getParent();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.c(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.c(paramView);
  }
  
  private void a(hqc paramhqc)
  {
    if (paramhqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity, null);
      localActionSheet.a(String.format(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.getResources().getString(2131364548), new Object[] { paramhqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name }));
      localActionSheet.a(2131364502, 3);
      localActionSheet.d(2131367262);
      localActionSheet.a(new hpz(this, paramhqc, localActionSheet));
      localActionSheet.show();
    }
  }
  
  private void a(hqd paramhqd, int paramInt, View paramView)
  {
    Object localObject = (hqc)getItem(paramInt);
    if ((localObject != null) && (((hqc)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null))
    {
      PublicAccountInfo localPublicAccountInfo = ((hqc)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
      paramhqd.jdField_a_of_type_Hqc = ((hqc)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null)
      {
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, localPublicAccountInfo.getUin());
        paramhqd.b.setImageDrawable(localDrawable);
      }
      paramhqd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localPublicAccountInfo.name);
      if (localPublicAccountInfo.certifiedGrade <= 0L) {
        break label181;
      }
      paramhqd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838906);
      if (((hqc)localObject).jdField_a_of_type_Long > 0L) {
        break label193;
      }
      paramhqd.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.getString(2131372574));
    }
    for (;;)
    {
      if (AppSetting.j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramhqd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a()).append(',').append(paramhqd.jdField_a_of_type_AndroidWidgetTextView.getText());
        paramView.setContentDescription(((StringBuilder)localObject).toString());
      }
      return;
      label181:
      paramhqd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break;
      label193:
      if (((hqc)localObject).jdField_a_of_type_Long > 99L) {
        paramhqd.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.getString(2131372575));
      } else {
        paramhqd.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.getString(2131372576), new Object[] { Long.valueOf(((hqc)localObject).jdField_a_of_type_Long) }));
      }
    }
  }
  
  private void a(hqd paramhqd, Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramhqd.b.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramhqd.jdField_a_of_type_Hqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin()));
      return;
    }
    paramhqd.b.setImageBitmap(paramBitmap);
  }
  
  private void b(hqc paramhqc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.a(true);
    String str = paramhqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountManageAdapter", 2, "unfollow->puin:" + str);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "unfollow");
    mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
    localUnFollowRequest.uin.set((int)Long.parseLong(str));
    localNewIntent.putExtra("data", localUnFollowRequest.toByteArray());
    localNewIntent.setObserver(new hqa(this, str, paramhqc));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountManageAdapter", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131364487, 0).show();
  }
  
  private void c(hqc paramhqc)
  {
    String str = paramhqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountManageAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramhqc);
    notifyDataSetChanged();
    ThreadManager.b().postDelayed(new hqb(this, str), 10L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (TextUtils.isEmpty(???))) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(???, paramBitmap);
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L)) {}
        for (paramInt2 = 1; (paramInt1 <= 0) || (paramInt2 != 0); paramInt2 = 0) {
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
              break label110;
            }
            return;
          }
        }
      }
    }
    label110:
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap == null) || (!(paramBitmap instanceof hqd))) {
          break label225;
        }
        paramBitmap = (hqd)paramBitmap;
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramBitmap.jdField_a_of_type_Hqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
        if (localBitmap == null) {
          break label225;
        }
        a(paramBitmap, localBitmap);
        break label225;
        this.jdField_a_of_type_Long = l;
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
      label225:
      paramInt1 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a == null) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.c();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.b()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.b();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof hqd)))
        {
          localObject = (hqd)localObject;
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, ((hqd)localObject).jdField_a_of_type_Hqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
        }
        i += 1;
      }
    }
  }
  
  public void b()
  {
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).e();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaUtilList.add(a(localPublicAccountInfo));
        }
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof hqd))) {}
    for (paramViewGroup = (hqd)paramView.getTag();; paramViewGroup = null)
    {
      Object localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        localObject = new hqd(this);
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity).inflate(2130903482, null);
        ((hqd)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298738));
        ((hqd)localObject).b = ((ImageView)paramView.findViewById(2131296790));
        ((hqd)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131296829));
        ((hqd)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298739));
        ((hqd)localObject).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298740));
        ((hqd)localObject).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        ((hqd)localObject).b.setOnClickListener(this);
        ((hqd)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramView.setTag(localObject);
        paramView.setTag(-3, Integer.valueOf((int)this.jdField_a_of_type_Float));
      }
      ((hqd)localObject).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      ((hqd)localObject).b.setTag(Integer.valueOf(paramInt));
      ((hqd)localObject).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      a((hqd)localObject, paramInt, paramView);
      return paramView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.a();
    if (localView != null) {
      ((TextView)localView.findViewById(2131298736)).setText(String.format(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.getString(2131372573), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) }));
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(paramView);
      return;
      a(i);
      return;
      paramView = (hqc)getItem(i);
    } while (paramView == null);
    a(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountManageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */