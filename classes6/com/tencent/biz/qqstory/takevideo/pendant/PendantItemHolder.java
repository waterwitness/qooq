package com.tencent.biz.qqstory.takevideo.pendant;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem.OnDownloadStateListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.RingView;
import com.tencent.biz.qqstory.view.RingView.DrawInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PendantItemHolder
  implements View.OnClickListener, NewStoryPendantItem.OnDownloadStateListener
{
  public static final int a = -90;
  private static final String jdField_a_of_type_JavaLangString = "PendantItemHolder";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 270;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private NewStoryPendantItem jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem;
  private OnPendantItemClickListener jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener;
  private final RingView.DrawInfo jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo;
  private final RingView jdField_a_of_type_ComTencentBizQqstoryViewRingView;
  private final Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private final RingView.DrawInfo jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private final ImageView jdField_c_of_type_AndroidWidgetImageView;
  private final RingView.DrawInfo jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo;
  
  public PendantItemHolder(ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296303));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302820));
    this.jdField_a_of_type_ComTencentBizQqstoryViewRingView = ((RingView)paramViewGroup.findViewById(2131302819));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302821));
    RingView localRingView = this.jdField_a_of_type_ComTencentBizQqstoryViewRingView;
    RingView.DrawInfo localDrawInfo = new RingView.DrawInfo(-90, 270, 0, 0.89F, 1, 0.0F, 0, 2130706432, Paint.Style.FILL);
    this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo = localDrawInfo;
    localRingView.a(localDrawInfo);
    localRingView = this.jdField_a_of_type_ComTencentBizQqstoryViewRingView;
    localDrawInfo = new RingView.DrawInfo(-90, 270, 0, 1.0F, 0, 0.12F, 0, -13450762, Paint.Style.STROKE);
    this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo = localDrawInfo;
    localRingView.a(localDrawInfo);
    localRingView = this.jdField_a_of_type_ComTencentBizQqstoryViewRingView;
    localDrawInfo = new RingView.DrawInfo(-90, 270, 0, 0.5F, 0, 0.12F, -13450762, 2130706432, Paint.Style.STROKE);
    this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo = localDrawInfo;
    localRingView.a(localDrawInfo);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramViewGroup.getContext());
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = b(paramViewGroup.getContext());
    a(false);
  }
  
  private int a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return -90;
    }
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    }
    return (int)(360.0F * f) - 90;
  }
  
  private Drawable a(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841501);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    paramContext = paramContext.getResources().getDrawable(2130841500);
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  private Drawable b(Context paramContext)
  {
    return new ColorDrawable(0);
  }
  
  private void b(NewStoryPendantItem paramNewStoryPendantItem)
  {
    if (TextUtils.equals(paramNewStoryPendantItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = paramNewStoryPendantItem;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem == NewStoryPendantItem.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem) || (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem == NewStoryPendantItem.b))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
        this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
        this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a())
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.a();
        this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.a();
        this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b(a(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a()));
        this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
        this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
        this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      if (paramNewStoryPendantItem.a() != 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
        this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.a();
        this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
      this.jdField_b_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
      this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    SLog.d("PendantItemHolder", "updateDownloadState item invalid, current=%s, new=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem, paramNewStoryPendantItem });
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(this);
    }
  }
  
  public void a(NewStoryPendantItem paramNewStoryPendantItem)
  {
    SLog.a("PendantItemHolder", "onDownloadStateChanged : " + paramNewStoryPendantItem);
    b(paramNewStoryPendantItem);
  }
  
  public void a(NewStoryPendantItem paramNewStoryPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != paramNewStoryPendantItem)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(null);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = paramNewStoryPendantItem;
      this.jdField_c_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != NewStoryPendantItem.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem) && (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != NewStoryPendantItem.b)) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(this);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != NewStoryPendantItem.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem) {
        break label99;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      b(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem);
      return;
      label99:
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem == NewStoryPendantItem.b)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      else if (!TextUtils.equals((String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(), this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.c))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.c);
        paramNewStoryPendantItem = Uri.parse(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.c);
        if ("android.resource".equalsIgnoreCase(paramNewStoryPendantItem.getScheme()))
        {
          try
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(Integer.parseInt(paramNewStoryPendantItem.getPath()));
          }
          catch (NumberFormatException paramNewStoryPendantItem)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841498);
          UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.c, UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), 48.0F), this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), new CircleTransformation());
        }
      }
    }
  }
  
  public void a(OnPendantItemClickListener paramOnPendantItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener = paramOnPendantItemClickListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewViewGroup.setSelected(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != NewStoryPendantItem.b) && (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != NewStoryPendantItem.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.a();
        this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
      this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewRingView$DrawInfo.b();
    this.jdField_a_of_type_ComTencentBizQqstoryViewRingView.invalidate();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a(null);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem;
    OnPendantItemClickListener localOnPendantItemClickListener = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener;
    if ((paramView != null) && (localOnPendantItemClickListener != null)) {
      localOnPendantItemClickListener.a(paramView, -1, this.jdField_c_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\pendant\PendantItemHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */