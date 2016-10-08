package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class NormalFaceAdapter
  extends BaseFaceListAdapter
{
  private static final String a = "NormalFaceAdapter";
  public static int b;
  public static int c;
  
  public NormalFaceAdapter(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = DisplayUtil.b(paramContext, 50.0F);
    b = DisplayUtil.b(paramContext, 110.0F);
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 5;
    }
    return 3;
  }
  
  protected void a(View paramView)
  {
    int i = 0;
    ImageView localImageView = (ImageView)paramView;
    int j = ((Integer)localImageView.getTag(2131296664)).intValue();
    Object localObject2 = (NormalFacePackage)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    Uri localUri = Uri.parse(((NormalFacePackage)localObject2).a(j));
    Object localObject1 = localUri.getPath();
    String str = new File((String)localObject1).getName();
    localObject1 = Drawable.createFromPath((String)localObject1);
    SelectedItem localSelectedItem = new SelectedItem();
    localSelectedItem.jdField_a_of_type_JavaLangString = ((NormalFacePackage)localObject2).b;
    localSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
    localSelectedItem.b = str;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      try
      {
        j = ((RelativeLayout.LayoutParams)((ListView)paramView.getParent().getParent()).getLayoutParams()).leftMargin;
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          float f2;
          float f3;
          float f4;
          float f5;
          int k;
          SLog.e("NormalFaceAdapter", "get marginLeft error.");
          localException.printStackTrace();
          continue;
          float f1 = (i - (k + (i - j) / 2) * 2) / i;
        }
      }
      localObject2 = (FaceListItem)paramView.getParent();
      j = (int)ViewCompat.b((View)localObject2);
      f2 = ViewCompat.a(paramView);
      f3 = paramView.getWidth() / 2;
      f4 = i;
      f5 = ((FaceListItem)localObject2).getHeight() / 2 + j;
      i = ((Drawable)localObject1).getIntrinsicWidth();
      j = localImageView.getWidth();
      k = localImageView.getPaddingLeft();
      if (j > i)
      {
        f1 = (((j - i) / 2 - k) * 2 + i) / i;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel$OnFaceSelectedListener.a(localSelectedItem, f4 + (f2 + f3), f5, f1 * 1.2F);
        return;
      }
    }
    SLog.e("NormalFaceAdapter", "can create drawable from uri:" + localUri);
  }
  
  protected void a(View paramView, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage.a(paramInt);
    paramView.setTag(2131296665, str);
    paramView.setTag(2131296664, Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_Int == 0)
    {
      ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, (ImageView)paramView, str, c, c, null);
      return;
    }
    ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, (ImageView)paramView, str, b, b, null);
  }
  
  protected void b(View paramView, int paramInt)
  {
    paramView.setOnClickListener(this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\adapter\NormalFaceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */