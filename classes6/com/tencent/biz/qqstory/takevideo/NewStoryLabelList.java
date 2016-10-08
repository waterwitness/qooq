package com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import ivi;
import ivj;
import ivk;

public class NewStoryLabelList
  extends NewStoryPart
  implements View.OnClickListener
{
  protected static final String a = "Q.qqstory.record.NewStoryLabelList";
  protected ViewStub a;
  public TextView a;
  protected ElasticImageView a;
  public QQStoryAddVideoLabelViewPart a;
  public String b;
  
  public NewStoryLabelList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart = new QQStoryAddVideoLabelViewPart(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a(12, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a(new ivj(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.b(new ivk(this));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.k();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a().requestFocus();
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a());
  }
  
  public String a()
  {
    return this.b;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.b = "";
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.o();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.l();
      return true;
    }
    return false;
  }
  
  public boolean a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    return a();
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131302945));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)a(2131302943));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131302873));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new ivi(this));
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.g(paramNewStoryTakeVideoActivity);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131302944: 
    default: 
      return;
    case 2131302945: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(true);
      b();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
      for (paramView = "2";; paramView = "1")
      {
        StoryReportor.a("video_edit", "edit_tag", 0, 0, new String[] { paramView });
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(true);
    b();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (paramView = "2";; paramView = "1")
    {
      StoryReportor.a("video_edit", "add_tag", 0, 0, new String[] { paramView });
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryLabelList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */