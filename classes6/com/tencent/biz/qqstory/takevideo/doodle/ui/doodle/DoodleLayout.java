package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig;
import com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig.Builder;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.control.ColorPicker;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ixq;
import ixr;
import ixs;
import ixt;
import ixu;
import ixv;
import ixw;
import ixx;
import ixz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoodleLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = 1.0F;
  private static final int jdField_a_of_type_Int = 480;
  private static final String jdField_a_of_type_JavaLangString = "DoodleLayout";
  public static boolean a = false;
  private static final float jdField_b_of_type_Float = 0.5F;
  private static final int jdField_b_of_type_Int = 640;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private NewStoryTakeVideoActivity jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity;
  private EmptyLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  private FaceLayer.FaceAndTextItem jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceAndTextItem;
  private FaceLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer;
  private LineLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer;
  private TextLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer;
  private BaseLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
  private DoodleConfig jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig;
  private EditTextDialog jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog;
  private ColorPicker jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker;
  private DoodleLayout.DoodleEventListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener;
  private DoodleView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  private FacePanel jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel;
  private ElasticImageView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView;
  private ixu jdField_a_of_type_Ixu;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public boolean b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public boolean c;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private final int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private final int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private final int jdField_g_of_type_Int;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private final int h;
  private int i;
  private int j;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_Int = 2;
    this.h = 3;
    this.i = 0;
    this.j = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity = ((NewStoryTakeVideoActivity)paramContext);
    d();
  }
  
  private void a(int paramInt)
  {
    SLog.b("DoodleLayout", "onTextPressed, buttonState:" + this.i + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if (paramInt == 2) {}
    for (String str = "add_text";; str = "edit_text")
    {
      a(str);
      if (this.i != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.b();
    setViewActive(this.d, true);
    setViewActive(this.c, false);
    setViewActive(this.b, false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841365);
    if (this.i == 0) {}
    for (;;)
    {
      b(1);
      return;
      if (this.i == 2)
      {
        a(false);
        a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
        b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
      }
      else if (this.i != 3) {}
    }
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if (localDrawable == null)
    {
      SLog.e("DoodleLayout", "tintImageViewDrawable:Can not get drawable from imageView..");
      return;
    }
    localDrawable.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_IN));
    paramImageView.setImageDrawable(localDrawable);
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {}
    for (String str = "2";; str = "1")
    {
      a(paramString, 0, 0, new String[] { str });
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    StoryReportor.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 0;
    View localView;
    if (paramBoolean)
    {
      k = getResources().getColor(2131427981);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(k);
      setBackgroundColor(k);
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int k = m;; k = 4)
    {
      localView.setVisibility(k);
      return;
      k = 0;
      break;
    }
  }
  
  private void a(View... paramVarArgs)
  {
    int m = paramVarArgs.length;
    int k = 0;
    while (k < m)
    {
      paramVarArgs[k].setVisibility(4);
      k += 1;
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      SLog.e("DoodleLayout", "illegal state.");
      return;
    }
    this.i = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(this.j);
      return;
      this.j = 0;
      continue;
      this.j = 3;
      continue;
      this.j = 1;
      continue;
      this.j = 2;
    }
  }
  
  private void b(View... paramVarArgs)
  {
    int m = paramVarArgs.length;
    int k = 0;
    while (k < m)
    {
      paramVarArgs[k].setVisibility(0);
      k += 1;
    }
  }
  
  private int c()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int k = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    int m = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (k + m);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramInt);
    }
  }
  
  private void d()
  {
    LayoutInflater.from(getContext()).inflate(2130904443, this);
    e();
    f();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131302755));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302347));
    this.c = ((ImageView)findViewById(2131302759));
    this.d = ((ImageView)findViewById(2131297135));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302760));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302762));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302756));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)findViewById(2131302758));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299498);
    this.b = ((ImageView)findViewById(2131302757));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel = ((FacePanel)findViewById(2131302763));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel.setOnFaceSelectedListener(new ixw(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker = ((ColorPicker)findViewById(2131302761));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker.setListener(new ixq(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)findViewById(2131302754));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    a();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig = new DoodleConfig.Builder().a(480).b(640).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer = ((TextLayer)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(TextLayer.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer = ((LineLayer)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("LineLayer"));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer = ((FaceLayer)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(FaceLayer.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer = ((EmptyLayer)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(EmptyLayer.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(LineLayer.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(new ixx(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(new ixr(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.a(new ixv(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.a(new ixs(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.a(new ixz(this, null));
  }
  
  private void g()
  {
    SLog.b("DoodleLayout", "undo, activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() + ",pathCount:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.d());
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.c())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.d() == 0) {
        a(new View[] { this.jdField_e_of_type_AndroidWidgetImageView });
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Ixu = new ixu(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog = new EditTextDialog(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(c());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.setContentView(2130904446);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(this.jdField_a_of_type_Ixu);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.show();
  }
  
  private void i()
  {
    SLog.b("DoodleLayout", "onFacePressed, buttonState:" + this.i + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    a("add_face");
    if (this.i == 2)
    {
      a(false);
      a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
      b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841378);
      setViewActive(this.c, true);
      setViewActive(this.d, true);
      setViewActive(this.b, true);
      b(0);
      return;
    }
    a(true);
    setBackgroundColor(getResources().getColor(2131427981));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841365);
    a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    if (this.i == 0) {
      b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
    }
    for (;;)
    {
      setViewActive(this.c, true);
      setViewActive(this.d, false);
      setViewActive(this.b, false);
      b(2);
      return;
      if (this.i == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.dismiss();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841365);
        postDelayed(new ixt(this), 100L);
      }
      else if (this.i != 3) {}
    }
  }
  
  private void j()
  {
    SLog.b("DoodleLayout", "onLinePressed, buttonState:" + this.i + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    a("clk_graffiti");
    if (this.i == 3)
    {
      b(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841378);
      a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_f_of_type_AndroidWidgetImageView });
      b(new View[] { this.d, this.c });
      a(this.jdField_g_of_type_AndroidWidgetImageView, 0);
      return;
    }
    setViewActive(this.b, true);
    setViewActive(this.c, true);
    setViewActive(this.d, true);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841365);
    a(new View[] { this.d, this.c });
    b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker, this.jdField_f_of_type_AndroidWidgetImageView });
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b(true);
    a(this.jdField_g_of_type_AndroidWidgetImageView, LineLayer.jdField_f_of_type_Int);
    this.jdField_g_of_type_AndroidWidgetImageView.invalidate();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(LineLayer.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.d() > 0) {
      b(new View[] { this.jdField_e_of_type_AndroidWidgetImageView });
    }
    if (this.i == 0) {}
    for (;;)
    {
      b(3);
      return;
      if (this.i == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.dismiss();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841365);
      }
      else if (this.i == 2)
      {
        a(false);
        a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
        b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
      }
    }
  }
  
  public int a()
  {
    int k = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.a();
    int m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a();
    int n = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.a();
    SLog.b("DoodleLayout", "DoodleCount: text->" + k + ",line->" + m + ",face->" + n);
    return k + m + n;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public FacePanel a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel;
  }
  
  public String a()
  {
    TextInfo localTextInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.a();
    if (localTextInfo != null)
    {
      SLog.b("DoodleLayout", "doodle text :" + localTextInfo.jdField_a_of_type_JavaLangString);
      return localTextInfo.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.b);
    SLog.b("DoodleLayout", "Using poi list:" + localArrayList.toString());
    return localArrayList;
  }
  
  public Map a()
  {
    HashMap localHashMap = new HashMap(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_JavaUtilMap);
    SLog.b("DoodleLayout", "Using face map:" + localHashMap.toString());
    return localHashMap;
  }
  
  public void a()
  {
    b(new View[] { this.jdField_a_of_type_AndroidWidgetImageView, this.d, this.c, this.b, this.jdField_g_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel.setVisibility(8);
    a(new View[] { this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker, this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView });
    a(this.jdField_g_of_type_AndroidWidgetImageView, 0);
    this.c.setImageResource(2130841391);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841378);
    a(false);
    setViewActive(this.d, true);
    setViewActive(this.c, true);
    setViewActive(this.b, true);
    b(0);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.dismiss();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.d(paramMotionEvent);
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
    }
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    if (paramItem == null) {
      SLog.e("DoodleLayout", "the item is null.");
    }
    for (;;)
    {
      return;
      SLog.b("DoodleLayout", "addLocationFaceItem:" + paramItem.toString());
      FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight());
      if (localLayerParams == null) {
        break;
      }
      boolean bool = false;
      if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.a(null, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams);
      }
      while (bool)
      {
        a("add_place");
        return;
        if (paramItem.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.a(paramItem.jdField_a_of_type_AndroidGraphicsBitmap, localLayerParams);
        }
      }
    }
    SLog.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
  }
  
  public boolean a()
  {
    SLog.b("DoodleLayout", "onBackPressed, buttonState:" + this.i + ",activeLayer:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if (this.i == 0) {
      return false;
    }
    a();
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a())
    {
      SLog.b("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b(paramMotionEvent);
    if (paramMotionEvent != this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer)
    {
      SLog.b("DoodleLayout", "layer accept the outside MotionEvent. Layer->" + paramMotionEvent.toString());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = paramMotionEvent;
      return true;
    }
    SLog.b("DoodleLayout", "no layer accept the outside MotionEvent.");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramString);
  }
  
  public int[] a()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a();
    SLog.b("DoodleLayout", "normal path count:" + arrayOfInt[0] + ",mosaic path count:" + arrayOfInt[1]);
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b();
  }
  
  public int[] b()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.a();
    SLog.b("DoodleLayout", "normal face count:" + arrayOfInt[0] + ",location face count:" + arrayOfInt[1]);
    return arrayOfInt;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextLayer.a()) {
      a(1);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      if ((!a()) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.d();
      }
    }
    do
    {
      return;
      if (paramView == this.b)
      {
        j();
        return;
      }
      if (paramView == this.c)
      {
        i();
        return;
      }
      if (paramView == this.d)
      {
        a(2);
        return;
      }
      if (paramView == this.jdField_e_of_type_AndroidWidgetImageView)
      {
        g();
        return;
      }
    } while (paramView != this.jdField_f_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.c();
    a(this.jdField_g_of_type_AndroidWidgetImageView, 0);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130841458);
  }
  
  protected void onDetachedFromWindow()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c();
    super.onDetachedFromWindow();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity != null)
    {
      jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y;
      SLog.b("DoodleLayout", "is take photo:" + jdField_a_of_type_Boolean);
      return;
    }
    SLog.e("DoodleLayout", "NewStoryTakeVideoActivity is null.");
  }
  
  public void setAllViewsActive(boolean paramBoolean)
  {
    setViewActive(this.b, paramBoolean);
    setViewActive(this.c, paramBoolean);
    setViewActive(this.d, paramBoolean);
  }
  
  public void setDoodleBitmapMaxSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      SLog.e("DoodleLayout", "width or height is illegal, width=" + paramInt1 + ",height=" + paramInt2);
      return;
    }
    SLog.b("DoodleLayout", "setDoodleBitmapMaxSize, maxWidth" + paramInt1 + ",maxHeight:" + paramInt2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.a = paramInt1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.b = paramInt2;
  }
  
  public void setDoodleEventListener(DoodleLayout.DoodleEventListener paramDoodleEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener = paramDoodleEventListener;
  }
  
  public void setLeftBackIcon(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int k = 2130841365;; k = 2130841378)
    {
      localImageView.setImageResource(k);
      return;
    }
  }
  
  public void setLocation(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceAndTextItem == null)
    {
      SLog.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    SLog.b("DoodleLayout", "setLocation: clickItem-->" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceAndTextItem);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceAndTextItem.a(paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceAndTextItem = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 1)
    {
      SLog.e("DoodleLayout", "MosaicSize little than 1.");
      k = 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.b(k);
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      SLog.e("DoodleLayout", "StandardMosaicSize, width or height <= 0. width:" + paramInt1 + ",height:" + paramInt2);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerLineLayer.a(paramInt1, paramInt2);
  }
  
  public void setViewActive(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.5F)
    {
      ViewCompat.a(paramView, f1);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\doodle\DoodleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */