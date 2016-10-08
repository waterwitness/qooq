package com.tencent.biz.qqstory.takevideo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.rmw.Utils;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import iws;
import iwt;
import java.util.ArrayList;
import java.util.List;

public class NewStoryViewController
  extends NewStoryPart
{
  public static final int a = 0;
  protected static final String a = "Q.qqstory.record.NewStoryViewController";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = 15;
  public static final int q = 16;
  public static final int r = 17;
  public static final int s = 18;
  public static final int t = 19;
  public static final int u = 20;
  protected static final int v = 3000;
  protected SparseArray a;
  protected Runnable a;
  protected final List a;
  protected boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public NewStoryViewController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static String a(View paramView)
  {
    Resources localResources = paramView.getResources();
    int i1 = paramView.getId();
    if (i1 == -1) {
      return "View[" + paramView.getClass().getSimpleName() + "]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View[");
    localStringBuilder.append('#');
    localStringBuilder.append(Integer.toHexString(paramView.getId()));
    localStringBuilder.append(' ');
    localStringBuilder.append(localResources.getResourcePackageName(i1));
    localStringBuilder.append(':');
    localStringBuilder.append(localResources.getResourceTypeName(i1));
    localStringBuilder.append('/');
    localStringBuilder.append(localResources.getResourceEntryName(paramView.getId()));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getSharedPreferences("qqstory", 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getSharedPreferences("qqstory", 0).getBoolean(paramString, paramBoolean);
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 2: 
      return "CANCEL";
    case 1: 
      return "RECORD";
    case 5: 
      return "FLASH";
    case 3: 
      return "NIGHT";
    case 6: 
      return "SWITCH";
    case 4: 
      return "MUTE";
    case 0: 
      return "PUBLISH";
    case 7: 
      return "DOODLE";
    case 8: 
      return "VIEW_RECORD_TIPS";
    case 9: 
      return "VIEW_POI";
    case 10: 
      return "VIEW_POI_CONTENT";
    case 11: 
      return "VIEW_LABEL";
    case 12: 
      return "VIEW_LABEL_CONTENT";
    case 13: 
      return "VIEW_HSV";
    }
    return "VIEW_FACE_DETECT_TIPS";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "initState");
    b(new int[] { 7, 4, 0, 13, 12, 10, 11, 9, 16, 20, 19, 8 });
    a(new int[] { 2, 3, 5, 6, 2, 1, 15, 17 });
    if ((this.b) || (this.c)) {
      a(new int[] { 8 });
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("view should not be null");
    }
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
    if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) {
      paramView.setVisibility(4);
    }
    if (localView != null)
    {
      SLog.d("Q.qqstory.record.NewStoryViewController", "replace " + a(localView) + " by " + a(paramView) + " as " + b(paramInt));
      return;
    }
    SLog.b("Q.qqstory.record.NewStoryViewController", "add " + a(paramView) + " as " + b(paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(15));
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(15));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    if (paramBoolean2)
    {
      if (this.d) {
        b(new int[] { 5 });
      }
    }
    else {
      return;
    }
    a(new int[] { 5 });
  }
  
  public void a(int... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    if (i1 < i2)
    {
      int i3 = paramVarArgs[i1];
      if (i3 == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.c();
        label36:
        if ((i3 != 5) || (!this.d)) {
          break label79;
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (i3 != 7) {
          break label36;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.b();
        break label36;
        label79:
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(i3);
        if (localView != null) {
          if (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(i3))) {
            localView.setVisibility(0);
          } else {
            localView.setVisibility(4);
          }
        }
      }
    }
  }
  
  public View b(int paramInt)
  {
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void b()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "recordState");
    s();
    a(new int[] { 1, 6 });
    if (this.b)
    {
      this.b = false;
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      a("qqstory_record", true);
    }
    while (!this.c) {
      return;
    }
    a(new int[] { 8 });
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(3));
    if (!CameraAbility.c())
    {
      SLog.b("Q.qqstory.record.NewStoryViewController", "always hide switch button");
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(6));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    TextView localTextView;
    if (!a("qqstory_record", false))
    {
      a(new int[] { 8 });
      localTextView = (TextView)this.jdField_a_of_type_AndroidUtilSparseArray.get(8);
      if (paramBoolean)
      {
        this.c = true;
        localTextView.setText("视频将在24小时后自动销毁");
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams.setMargins(0, 0, 0, Utils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, 115.0F));
        localTextView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_JavaLangRunnable = new iws(this);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
    }
    else
    {
      return;
    }
    this.b = true;
    localTextView.setText("按住拍，24小时后自动销毁");
  }
  
  public void b(int... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramVarArgs[i1];
      if (i3 == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.b();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.a(0.0F);
      }
      View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(i3);
      if (localView != null) {
        localView.setVisibility(4);
      }
      i1 += 1;
    }
  }
  
  public void c()
  {
    if (this.c)
    {
      this.c = false;
      b(new int[] { 8 });
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      a("qqstory_record", true);
    }
  }
  
  public void d()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "doodleStateSelectFace");
    s();
    a(new int[] { 7, 4 });
  }
  
  public void e()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "doodleStateDrawLine");
    s();
    a(new int[] { 7, 0, 16, 20 });
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a()))
    {
      a(new int[] { 19 });
      b(new int[] { 11 });
      return;
    }
    a(new int[] { 11 });
    b(new int[] { 19 });
  }
  
  public void f()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "doodleStateEditText");
    s();
    a(new int[] { 7, 4 });
  }
  
  public void g()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "doodleStateEditText");
    s();
    a(new int[] { 7, 16, 20 });
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.g(paramNewStoryTakeVideoActivity);
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void h()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "repeatPlayState");
    b(new int[] { 3, 5, 6, 13, 8, 1, 10, 12, 2, 15, 17, 18 });
    a(new int[] { 4, 0, 9, 7, 16, 20 });
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a()))
    {
      a(new int[] { 19 });
      b(new int[] { 11 });
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        b(new int[] { 11, 19, 0 });
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a() == 2) {
        b(new int[] { 4 });
      }
      t();
      return;
      a(new int[] { 11 });
      b(new int[] { 19 });
    }
  }
  
  public void i()
  {
    if (!a("qqstory_filter_guide", false))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(false);
      StoryNewGuideDialog localStoryNewGuideDialog = new StoryNewGuideDialog(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
      localStoryNewGuideDialog.a("左右滑动可切换滤镜");
      localStoryNewGuideDialog.show();
      localStoryNewGuideDialog.setOnDismissListener(new iwt(this));
      a("qqstory_filter_guide", true);
    }
  }
  
  public void j()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "unfoldHSV");
    b(new int[] { 0, 4, 15, 1, 8, 17 });
    a(new int[] { 13 });
  }
  
  public void k()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "openEditLabel");
    s();
    a(new int[] { 12 });
  }
  
  public void l()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "closeEditLabel");
    h();
  }
  
  public void m()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "openEditMusic");
    this.jdField_a_of_type_Boolean = true;
    b(new int[] { 11, 19, 0 });
  }
  
  public void n()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "closeEditMusic");
    this.jdField_a_of_type_Boolean = false;
    a(new int[] { 0 });
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a()))
    {
      a(new int[] { 19 });
      b(new int[] { 11 });
      return;
    }
    a(new int[] { 11 });
    b(new int[] { 19 });
  }
  
  public void o()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "openEditPOI");
    s();
    a(new int[] { 10 });
  }
  
  public void p()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "closeEditPOI");
    h();
  }
  
  public void q()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "openSearchPOI");
    s();
    a(new int[] { 18 });
  }
  
  public void r()
  {
    SLog.b("Q.qqstory.record.NewStoryViewController", "closeSearchPOI");
    h();
  }
  
  public void s()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((View)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).setVisibility(4);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.b();
  }
  
  public void t()
  {
    SLog.a("Q.qqstory.record.NewStoryViewController", "--------------- dump -------------------------------");
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1);
      String str;
      switch (localView.getVisibility())
      {
      default: 
        str = "UNKNOWN";
      }
      for (;;)
      {
        SLog.a("Q.qqstory.record.NewStoryViewController", a(localView) + " - " + str);
        i1 += 1;
        break;
        str = "VISIBLE";
        continue;
        str = "INVISIBLE";
        continue;
        str = "GONE";
      }
    }
    SLog.a("Q.qqstory.record.NewStoryViewController", "--------------- dump -------------------------------");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */