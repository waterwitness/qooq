package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import hrc;
import hrd;
import java.util.List;

public class VideoListAdapter
  extends BaseAdapter
{
  public static final String a = "Q.pubaccount.video.VideoListAdapter";
  private Context jdField_a_of_type_AndroidContentContext;
  public VideoListAdapter.VideoListEventListener a;
  private List jdField_a_of_type_JavaUtilList;
  
  public VideoListAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "";
    }
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 1000L / 60L), Long.valueOf(paramLong / 1000L % 60L) });
  }
  
  public void a(VideoListAdapter.VideoListEventListener paramVideoListEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter$VideoListEventListener = paramVideoListEventListener;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
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
    VideoInfo localVideoInfo;
    Object localObject;
    ColorDrawable localColorDrawable;
    if (paramView == null)
    {
      paramView = (ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903486, null);
      paramViewGroup = new hrd(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramView.findViewById(2131298770));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298772));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131298773));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131298771));
      paramView.setTag(paramViewGroup);
      localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localVideoInfo != null)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        localColorDrawable = new ColorDrawable(-12895429);
        if (!TextUtils.isEmpty(localVideoInfo.b)) {
          break label263;
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(localColorDrawable);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoListAdapter", 2, "getView() ERROR videoInfo.coverUrl=" + localVideoInfo.b);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localVideoInfo.jdField_c_of_type_JavaLangString);
      paramViewGroup.c.setText(ReadInJoyTimeUtils.a(localVideoInfo.a, true));
      paramViewGroup.b.setText(a(localVideoInfo.jdField_c_of_type_Int * 1000));
      paramView.setOnClickListener(new hrc(this, localVideoInfo));
      VideoReporter.a(localVideoInfo);
      return paramView;
      paramViewGroup = (hrd)paramView.getTag();
      break;
      label263:
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = AIOUtils.a(113.0F, (Resources)localObject);
      localURLDrawableOptions.mRequestHeight = AIOUtils.a(70.0F, (Resources)localObject);
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      try
      {
        localObject = URLDrawable.getDrawable(localVideoInfo.b, localURLDrawableOptions);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable((Drawable)localObject);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.pubaccount.video.VideoListAdapter", 2, "getView() URLDrawable.getDrawable() ERROR videoInfo.coverUrl=" + localVideoInfo.b);
        }
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(localColorDrawable);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */