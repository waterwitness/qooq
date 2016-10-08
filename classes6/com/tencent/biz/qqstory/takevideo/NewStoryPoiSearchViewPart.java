package com.tencent.biz.qqstory.takevideo;

import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import ivs;
import ivt;
import ivu;
import ivv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class NewStoryPoiSearchViewPart
  extends NewStoryPart
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected static final String a = "Q.qqstory.record.NewStoryPoiSearchViewPart";
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public LbsManager.POIListRequestSession a;
  public QQStoryPoiListAdapter a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList a;
  View b;
  View c;
  public View d;
  View e;
  View f;
  View g;
  
  public NewStoryPoiSearchViewPart()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = null;
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = LbsManager.POIListRequestSession.a();
    this.jdField_a_of_type_AndroidTextTextWatcher = new ivv(this);
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.record.NewStoryPoiSearchViewPart", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.a(str);
    if (TextUtils.isEmpty(str))
    {
      SLog.c("Q.qqstory.record.NewStoryPoiSearchViewPart", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
      f();
      return;
    }
    ((LbsManager)SuperManager.a(9)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, new ivu(this, str));
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b())
    {
      e();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  void a(NewStoryPoiList.SelectLocationCallback paramSelectLocationCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSelectLocationCallback);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(true);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.q();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.post(new ivt(this));
      this.d.setVisibility(4);
      return;
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a(18, this.jdField_a_of_type_AndroidViewView);
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131302854);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131302852));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131302853);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302855));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131302856);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131302857);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131302858);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302859));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = new QQStoryPoiListAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new ivs(this));
      d();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.c.setOnClickListener(this);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      b();
      paramView = (NewStoryPoiList.SelectLocationCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.f.setVisibility(4);
    this.g.setVisibility(0);
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getResources().getString(2131366433, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131298776);
    if (paramBoolean)
    {
      localTextView.setText(2131368598);
      return;
    }
    localTextView.setText(2131368594);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      b();
      return true;
    }
    return false;
  }
  
  public boolean a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    return a();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.o();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.r();
    }
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramNewStoryTakeVideoActivity.findViewById(2131302872));
    if (this.jdField_a_of_type_AndroidViewViewStub == null) {
      throw new IllegalStateException("can not find view by id 2131302872");
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.o();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.r();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a((NewStoryPoiList.SelectLocationCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
  }
  
  public void c(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.c(paramNewStoryTakeVideoActivity);
  }
  
  protected void d()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity).inflate(2130903499, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131297449);
      TextView localTextView1 = (TextView)this.d.findViewById(2131298776);
      TextView localTextView2 = (TextView)this.d.findViewById(2131298777);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131297005);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131368594);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.n() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.d);
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.g.setVisibility(4);
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void f(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.f(paramNewStoryTakeVideoActivity);
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.g(paramNewStoryTakeVideoActivity);
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131302855: 
    default: 
      return;
    case 2131302854: 
    case 2131302856: 
      InputMethodUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
      return;
    }
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryPoiSearchViewPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */