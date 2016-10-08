package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iyc;
import java.util.List;

public class LocationFaceAdapter
  extends BaseFaceListAdapter
{
  private static final String a = "LocationFaceAdapter";
  public static int b;
  public static int c;
  
  public LocationFaceAdapter(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = DisplayUtil.b(paramContext, 125.0F);
    c = DisplayUtil.b(paramContext, 110.0F);
  }
  
  protected int a()
  {
    return 2;
  }
  
  protected void a(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131296664)).intValue();
    LocationFacePackage.Item localItem = (LocationFacePackage.Item)((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a.get(i);
    paramView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)paramView.getTag(2131296666);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localItem.a = paramView.getDrawable();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener.a(localItem);
      return;
    }
    SLog.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
  
  protected void a(View paramView, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a(paramInt);
    ImageView localImageView = (ImageView)paramView.findViewById(2131302798);
    Object localObject = (TextView)paramView.findViewById(2131302800);
    paramView = (ProgressBar)paramView.findViewById(2131302799);
    ((TextView)localObject).setText(((LocationFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).b(paramInt));
    localObject = (Boolean)localImageView.getTag(2131296666);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()) && (str.equals(localImageView.getTag(2131296665))))
    {
      paramView.setVisibility(4);
      return;
    }
    localImageView.setTag(2131296665, str);
    localImageView.setTag(2131296666, Boolean.valueOf(false));
    paramView.setVisibility(0);
    ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, localImageView, str, b, c, new iyc(str, localImageView, paramView));
  }
  
  protected void b(View paramView, int paramInt)
  {
    paramView = (ImageView)paramView.findViewById(2131302798);
    paramView.setTag(2131296664, Integer.valueOf(paramInt));
    paramView.setOnClickListener(this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\adapter\LocationFaceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */