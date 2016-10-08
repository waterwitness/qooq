package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LocationFaceAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;

public class FaceListPage
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "FaceListPage";
  public int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener;
  private FacePackage jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
  private FacePanel.OnFaceSelectedListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener;
  private BaseFaceListAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter;
  private LocationFaceAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
  private NormalFaceAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ViewGroup c;
  private ViewGroup d;
  
  public FaceListPage(Context paramContext, FacePanel.OnFaceSelectedListener paramOnFaceSelectedListener, FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = paramFacePackagePageEventListener;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener = paramOnFaceSelectedListener;
    d();
  }
  
  private void b()
  {
    SLog.b("FaceListPage", "FacePackage is LocationFacePackage");
    LocationFacePackage localLocationFacePackage = (LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    if (!localLocationFacePackage.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.notifyDataSetChanged();
      return;
    }
    if (localLocationFacePackage.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.c.setVisibility(4);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
  }
  
  private void b(FacePackage paramFacePackage)
  {
    if ((paramFacePackage instanceof NormalFacePackage))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter = new NormalFaceAdapter(getContext());
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(paramFacePackage);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter);
      }
      return;
      if ((paramFacePackage instanceof LocationFacePackage))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter = new LocationFaceAdapter(getContext());
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterLocationFaceAdapter;
      }
      else
      {
        SLog.e("FaceListPage", "FacePackage is illegal.");
      }
    }
  }
  
  private void c()
  {
    SLog.b("FaceListPage", "FacePackage is NormalFacePackage");
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    if (!localNormalFacePackage.jdField_a_of_type_JavaUtilList.isEmpty()) {
      SLog.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(localNormalFacePackage.g))
        {
          SLog.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
          bool2 = localNormalFacePackage.a();
        }
      }
      if (bool2)
      {
        SLog.b("FaceListPage", "FacePkg is already download.show face list.");
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(null);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.notifyDataSetChanged();
        return;
      }
      SLog.b("FaceListPage", "FacePkg has not downloaded.show download page.");
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      String str = (String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(2131296665);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.d)))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131296665, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.d);
        ImageLoader.a().a(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.d, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, null);
      }
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(localNormalFacePackage.jdField_b_of_type_JavaLangString)) {}
      for (str = "";; str = localNormalFacePackage.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText(str);
        if (!localNormalFacePackage.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(localNormalFacePackage.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(localNormalFacePackage.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(null);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = AIOUtils.a(130.0F, getContext().getResources());
    LayoutInflater.from(getContext()).inflate(2130904448, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302765));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302766));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297446));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131302763));
    this.jdField_a_of_type_AndroidViewViewGroup = ((RelativeLayout)findViewById(2131302764));
    this.jdField_b_of_type_AndroidViewViewGroup = ((RelativeLayout)findViewById(2131302770));
    this.c = ((LinearLayout)findViewById(2131302771));
    this.d = ((LinearLayout)findViewById(2131302773));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130841387);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130841386);
  }
  
  public void a()
  {
    if ("LocationFacePackage".equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a()))
    {
      LocationFacePackage localLocationFacePackage = (LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
      if ((localLocationFacePackage.jdField_a_of_type_JavaUtilList.isEmpty()) && (!localLocationFacePackage.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        if (!NetworkUtil.h(getContext())) {
          break label87;
        }
        StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      label87:
      StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
    }
  }
  
  public void a(FacePackage paramFacePackage)
  {
    if (paramFacePackage != null)
    {
      SLog.b("FaceListPage", "onChange,FacePkgInfo:" + paramFacePackage.toString());
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a().equals(paramFacePackage.a()))) {
        b(paramFacePackage);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = paramFacePackage;
      if ("NormalFacePackage".equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a())) {
        c();
      }
      while (!"LocationFacePackage".equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a())) {
        return;
      }
      b();
      return;
    }
    SLog.b("FaceListPage", "onChange, null.");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterBaseFaceListAdapter.a(null);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(1);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetProgressBar) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener != null)
      {
        if (((NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).jdField_a_of_type_Boolean) {
          break label95;
        }
        SLog.b("FaceListPage", "Download pkg:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    label95:
    while ((paramView != this.c) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener == null))
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(null);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener.a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\FaceListPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */