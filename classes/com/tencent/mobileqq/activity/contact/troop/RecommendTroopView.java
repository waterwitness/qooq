package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.troop.activity.RecommendTroopAdapter;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import ojt;
import oju;
import ojw;
import ojx;

public class RecommendTroopView
  extends BaseTroopView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnScrollToTopListener, Observer
{
  public static final String b = "nearby_troop_count";
  public static final String c = "troop_num";
  public static final String d = "troop_wording";
  public static final int e = 100;
  public static final int f = 105;
  public static final int g = 106;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  protected SosoInterface.OnLocationListener a;
  public RecommendTroopAdapter a;
  protected FaceDecoder a;
  public SwipListView a;
  protected final String a;
  protected int b;
  public RelativeLayout b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public View e;
  protected boolean e;
  public View f;
  protected boolean f;
  protected boolean g;
  
  public RecommendTroopView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "RecommendTroopView";
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ojt(this);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private boolean c()
  {
    a(2130903786);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300076));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300079));
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131300077));
    this.f = LayoutInflater.from(a()).inflate(2130903926, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.f.findViewById(2131300678));
    this.jdField_e_of_type_AndroidViewView = this.f.findViewById(2131300677);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.a(this.f);
    if (a().getSharedPreferences("nearby_troop_count", 0).getInt("troop_num", 0) != 0)
    {
      String str = a().getSharedPreferences("nearby_troop_count", 0).getString("troop_wording", "");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300078));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setTranscriptMode(0);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300081));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter = new RecommendTroopAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext, a());
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return true;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.f.setPadding(0, 0, 0, 0);
    }
  }
  
  private void m()
  {
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localRecommendTroopManagerImp != null) {}
    for (List localList = localRecommendTroopManagerImp.b(); ((localList == null) || (localList.size() == 0)) && (localRecommendTroopManagerImp != null) && (localRecommendTroopManagerImp.a() != 1); localList = null)
    {
      localRecommendTroopManagerImp.a(0L, 1);
      return;
    }
    n();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new oju(this, 3, true, false, 1800000L, false, false, "RecommendTroopView");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      l();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new ojw(this));
  }
  
  private void p()
  {
    if (((RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21) != null) && (!this.jdField_b_of_type_Boolean) && (RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
    {
      a(1, true);
      return;
    }
    a(1, false);
  }
  
  protected int a()
  {
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    int i = RecommendTroopManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.aC, 9000, 0 - i);
      localRecommendTroopManagerImp.a();
      p();
    }
    if ((localRecommendTroopManagerImp != null) && (!this.jdField_b_of_type_Boolean) && (i > 0)) {
      return 1;
    }
    return 0;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (TextUtils.isEmpty(paramString))) {}
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendTroopView.class, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      l();
      a();
      continue;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setEmptyView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      continue;
      int i = paramMessage.arg1;
      if (!a().isFinishing()) {
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter.getCount() != 0))
        {
          paramMessage = (String)paramMessage.obj;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
          this.f.setVisibility(0);
          this.f.setPadding(0, (int)DisplayUtils.a(getContext(), 10.0F), 0, 0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "recom", "exp_nearby", 0, 0, "", "", "", "");
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          SharedPreferences localSharedPreferences = a().getSharedPreferences("nearby_troop_count", 0);
          localSharedPreferences.edit().putString("troop_wording", paramMessage);
          localSharedPreferences.edit().putInt("troop_num", i);
          localSharedPreferences.edit().commit();
        }
        else
        {
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.f.setPadding(0, 0, 0, 0);
        }
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopView", 4, "onChecked........");
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      l();
      m();
    }
    int i = a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Clk_grp_recom", 0, 0, "", i + "", "", "");
    k();
  }
  
  protected void e()
  {
    super.e();
    l();
  }
  
  protected void g()
  {
    super.g();
    RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localRecommendTroopManagerImp != null) {
      localRecommendTroopManagerImp.a();
    }
  }
  
  protected void h()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    GroupCatalogTool.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
  }
  
  public void k()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityRecommendTroopAdapter.a()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("RecommendTroopView", 4, "reportPv");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
    }
  }
  
  public void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopView", 4, "refreshRecommendTroopList");
    }
    if (this.g) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopView", 4, "refreshRecommendTroopList start ");
    }
    this.g = true;
    Object localObject = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
    if (localObject != null) {}
    for (localObject = ((RecommendTroopManagerImp)localObject).b();; localObject = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(new ojx(this, (List)localObject));
      this.g = false;
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300081: 
      paramView = new Intent(a(), NearbyTroopsActivity.class);
      paramView.putExtra("lat", 0);
      paramView.putExtra("lon", 0);
      paramView.putExtra("mode", 0);
      paramView.putExtra("from", 25);
      paramView.putExtra("TAB_INDEX", 2);
      NearbyTroopsLocationActivity.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_nearby", 0, 0, "", "", "", "");
      return;
    }
    NearbyTroopsActivity.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", 25, 0, null, this.c, this.jdField_d_of_type_Int);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "recom", "Clk_nearby", 0, 0, "", "", "", "");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = String.valueOf(AppConstants.aC);
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if ((paramObservable.equals(((MessageRecord)paramObject).frienduin)) && ((((MessageRecord)paramObject).msgtype == 64497) || (((MessageRecord)paramObject).msgtype == 64496))) {
        o();
      }
    }
    while ((!(paramObject instanceof RecentUser)) || (!paramObservable.equals(((RecentUser)paramObject).uin))) {
      return;
    }
    o();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\RecommendTroopView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */